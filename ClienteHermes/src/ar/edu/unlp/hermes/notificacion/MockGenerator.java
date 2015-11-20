package ar.edu.unlp.hermes.notificacion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import ar.edu.unlp.hermes.annotations.Mock;
import ar.edu.unlp.hermes.annotations.MockStringAttribute;
import ar.edu.unlp.hermes.annotations.MockTodayAttribute;



public class MockGenerator {
	private static Random r = new Random();
	
	public static <T> List<T> createMockInstances(Class<T> elClass, int cant) {
		Logger logger = Logger.getLogger(elClass.getClass().getSimpleName());
		List<T> elementosCreados = new ArrayList<T>();
		// analizamos para la clase pasada como parametro si contiene la
		// anotacion Mock
		boolean annotationPresent = elClass.isAnnotationPresent(Mock.class);
		if (annotationPresent) {
			// creo cada una de las anotaciones
			for (int i = 0; i < cant; i++) {
				// debo crear una nueva instancia del objeto de tipo T
				try {
					T instancia = elClass.newInstance();
					//analizo todos los campos declarados, para ver si tienen presente anotaciones					
					Field[] declaredFields = elClass.getDeclaredFields();
					for (Field field : declaredFields) {
						MockTodayAttribute anotacionToday = field.getAnnotation(MockTodayAttribute.class);
						if(anotacionToday!=null){//el field tiene anotacion today
							logger.info("el field " + field.getName() + " esta anotado con MockTodayAttribute");
							Method m = getSetMethodParaField(field,elClass);
							m.invoke(instancia, new Object[]{new Date()});
						}
						else{
							MockStringAttribute anotacionString = field.getAnnotation(MockStringAttribute.class);
							if(anotacionString!=null){
								logger.info("el field " + field.getName() + " esta anotado con MockStringAttribute con los valores "+anotacionString.value());
								Method m = getSetMethodParaField(field,elClass);
								m.invoke(instancia, new Object[]{valorAleatorio(anotacionString.value())});
							}
						}
					}
					
					elementosCreados.add(instancia);
					
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
				
				
			}
		}

		return elementosCreados;

	}

	private static Object valorAleatorio(String[] value) {
		int idx = r.nextInt(value.length);
		return value[idx];
	}

	private static Method getSetMethodParaField(Field field, Class cl) {
	    String s1 = field.getName().substring(0, 1).toUpperCase();
	    String nameCapitalized = s1 + field.getName().substring(1);
		
		try {
			return cl.getMethod("set"+nameCapitalized,field.getType());
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}
		
	}
}