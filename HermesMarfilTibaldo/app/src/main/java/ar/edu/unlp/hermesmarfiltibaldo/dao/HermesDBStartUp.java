package ar.edu.unlp.hermesmarfiltibaldo.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by Agustín on 2/15/2016.
 */
public class HermesDBStartUp {
    public static void startUp(SQLiteDatabase db) {
        ContentValues values;
        List<Categoria> cat = new ArrayList<Categoria>();

        cat.add(Categoria.getCategoriaEstablo());
        cat.add(Categoria.getCategoriaNecesidades());
        cat.add(Categoria.getCategoriaPista());
        cat.add(Categoria.getCategoriaEmociones());
        Categoria categoria;
        for (Iterator<Categoria> i = cat.iterator(); i.hasNext(); ) {
            values = new ContentValues();
            categoria = i.next();
            values.put(HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID, categoria.getId());
            values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, categoria.getNombre());
            db.insert(
                    HermesContract.Categoria.TABLE_NAME,
                    null,
                    values);
        }

        List<Pictograma> pictogramas = new ArrayList<Pictograma>();
        //     if (cat.getId() == Categoria.ID_CATEGORIA_EMOCIONES) {
        pictogramas.add(new Pictograma(1,"asustad@", "emociones/Asustada.m4a", "emociones/Asustada.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(2,"asustad@", "emociones/Asustado.m4a", "emociones/Asustado.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(3,"cansad@", "emociones/Cansada.m4a", "emociones/Cansada.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(4,"cansad@", "emociones/Cansado.m4a", "emociones/Cansado.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(5,"content@", "emociones/Contenta.m4a", "emociones/Contenta.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(6,"content@", "emociones/Contento.m4a", "emociones/Contento.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(7,"dolorid@", "emociones/Dolorida.m4a", "emociones/Dolorida.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(8,"dolorid@", "emociones/Dolorido.m4a", "emociones/Dolorido.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(9,"enojad@", "emociones/Enojada.m4a", "emociones/Enojada.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(10,"enojad@", "emociones/Enojado.m4a", "emociones/Enojado.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(11,"sorprendid@" ,"emociones/Sorprendida.m4a", "emociones/Sorprendida.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(12,"sorprendid@", "emociones/Sorprendido.m4a", "emociones/Sorprendido.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(13,"triste", "emociones/Triste.m4a", "emociones/Triste Hombre.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(14,"triste", "emociones/Triste.m4a", "emociones/Triste Mujer.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));

        //   } else if (cat.getId() == Categoria.ID_CATEGORIA_ESTABLO) {
        pictogramas.add(new Pictograma(15,"casco", "establo/Casco.m4a", "establo/Casco.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(16,"cepillo", "establo/Cepillo.m4a", "establo/Cepillo.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(17,"escarba vasos", "establo/Escarba Vasos.m4a", "establo/Escarba Vasos.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(18,"limpieza", "establo/Limpieza.m4a", "establo/Limpieza.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(19,"matra", "establo/Matra.m4a", "establo/Matra.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(20,"montura", "establo/Montura.m4a", "establo/Montura.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(21,"pasto", "establo/Pasto.m4a", "establo/Pasto.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(22,"rasqueta blanda", "establo/Rasqueta Blanda.m4a", "establo/Rasqueta Blanda.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(23,"rasqueta dura", "establo/Rasqueta Dura.m4a", "establo/Rasqueta Dura.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(24,"riendas", "establo/Riendas.m4a", "establo/Riendas.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(25,"zanahoria", "establo/Zanahoria.m4a", "establo/Zanahoria.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_ESTABLO));

        //  } else if (cat.getId() == Categoria.ID_CATEGORIA_NECESIDADES) {
        pictogramas.add(new Pictograma(40,"banio", "necesidades/Banio.m4a", "necesidades/Banio.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(41,"sed", "necesidades/Sed Hombre.m4a", "necesidades/Sed Hombre.png", Alumno.MASCULINO, Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(42,"sed", "necesidades/Sed Mujer.m4a", "necesidades/Sed Mujer.png", Alumno.FEMENINO, Categoria.ID_CATEGORIA_NECESIDADES));

        //    } else if (cat.getId() == Categoria.ID_CATEGORIA_PISTA) {
        pictogramas.add(new Pictograma(26,"aro", "pista/Aro.m4a", "pista/Aro.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(27,"broches", "pista/Broches.m4a", "pista/Broches.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(28,"burbujas", "pista/Burbujas.m4a", "pista/Burbujas.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(29,"caballo", "pista/Caballo.m4a", "pista/Caballo.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(30,"caballo", "pista/Caballo.m4a", "pista/Caballo 2.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(31,"caballo", "pista/Caballo.m4a", "pista/Caballo 3.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(32,"chapas", "pista/Chapas.m4a", "pista/Chapas.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(33,"cubos", "pista/Cubos.m4a", "pista/Cubos.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(34,"letras", "pista/Letras.m4a", "pista/Letras.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(35,"maracas", "pista/Maracas.m4a", "pista/Maracas.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(36,"palos", "pista/Palos.m4a", "pista/Palos.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(37,"pato", "pista/Pato.m4a", "pista/Pato.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(38,"pelota", "pista/Pelota.m4a", "pista/Pelota.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(39,"tarima", "pista/Tarima.m4a", "pista/Tarima.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_PISTA));

        pictogramas.add(new Pictograma(50,"si", "emociones/Si.m4a", "emociones/Si.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_COMANDOS));
        pictogramas.add(new Pictograma(51,"no", "emociones/No.m4a", "emociones/No.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_COMANDOS));

        Pictograma pictograma;

        for (Iterator<Pictograma> i = pictogramas.iterator(); i.hasNext(); ) {
            values = new ContentValues();
            pictograma = i.next();
            values.put(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID, pictograma.getId());
            values.put(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_NAME, pictograma.getNombre());
            values.put(HermesContract.Pictograma.COLUMN_NAME_AUDIO, pictograma.getAudioFilename());
            values.put(HermesContract.Pictograma.COLUMN_NAME_IMAGEN, pictograma.getImageFilename());
            values.put(HermesContract.Pictograma.COLUMN_NAME_SEXO, pictograma.getSexo());
            values.put(HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID, pictograma.getCategoriaID());
            db.insert(
                    HermesContract.Pictograma.TABLE_NAME,
                    null,
                    values);
        }


        values = new ContentValues();
        values.put(HermesContract.Configuracion.COLUMN_NAME_VALOR, "192.168.1.1");
        values.put(HermesContract.Configuracion.COLUMN_NAME_CONFIGURACION_ID, 1);
        values.put(HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE, "IP");
        db.insert(
                HermesContract.Configuracion.TABLE_NAME,
                null,
                values);
        values = new ContentValues();
        values.put(HermesContract.Configuracion.COLUMN_NAME_VALOR, "8080");
        values.put(HermesContract.Configuracion.COLUMN_NAME_CONFIGURACION_ID, 2);
        values.put(HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE, "PORT");
        db.insert(
                HermesContract.Configuracion.TABLE_NAME,
                null,
                values);



    }
}
