Entrega 

version 0.1
-

Funcionalidad a entregar:
-
* Monitor que lee de archivo
* GUI para administrar etiquetas y ver notificaciones
* Conexion a la base de datos SQlite y persistencia de notificaciones

Archivos
-
monitor.jar       : Es el archivo de la aplicacion monitor consumiendo desde un archivo txt
monitorConJson.jar: Es el archivo de la aplicacion monitor consumiendo desde un cliente JSON
hermes            : Es la base de datos
hermes.base       : Es la base de datos, por si se quiere comenzar nuevamente con una BD limpia
hermes.log.x      : Son los archivos de logs que van generandose por la aplicacion
clienteJson.jar   : Es el archivo cliente ejecutable cuando se quiere alimentar mediante json a monitor.jar

Formas de ejecutar
-
1-Para probar de alimentar a monitor.jar desde notificaciones provistas en un archivo txt, se debe correr el archivo monitor.jar sin modificar nada

2-Para probar la aplicacion alimentando mediante un cliente json y con sockets se debe:

	a-dejar el codigo de MonitorGui a esto:
		public class MonitorGui extends JFrame implements WindowListener  {
			...
			...
			monitorGui.setThreadListener(new ArchivoNotificacionListener());
			//monitorGui.setThreadListener(new JSONNotificacionListener());
			monitorGui.getThreadListener().run();
			...
			...
		}
		
	b-ejecutar monitorConJson.jar y luego clienteJson.jar
	