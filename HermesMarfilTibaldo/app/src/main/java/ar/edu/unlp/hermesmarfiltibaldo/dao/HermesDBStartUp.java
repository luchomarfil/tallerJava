package ar.edu.unlp.hermesmarfiltibaldo.dao;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
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
        pictogramas.add(new Pictograma(1, "emociones/Asustada.m4a", "emociones/Asustada.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(2, "emociones/Asustado.m4a", "emociones/Asustado.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(3, "emociones/Cansada.m4a", "emociones/Cansada.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(4, "emociones/Cansado.m4a", "emociones/Cansado.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(5, "emociones/Contenta.m4a", "emociones/Contenta.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(6, "emociones/Contento.m4a", "emociones/Contento.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(7, "emociones/Dolorida.m4a", "emociones/Dolorida.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(8, "emociones/Dolorido.m4a", "emociones/Dolorido.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(9, "emociones/Enojada.m4a", "emociones/Enojada.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(10, "emociones/Enojado.m4a", "emociones/Enojado.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(11, "emociones/Sorprendida.m4a", "emociones/Sorprendida.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(12, "emociones/Sorprendido.m4a", "emociones/Sorprendido.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(13, "emociones/Triste.m4a", "emociones/Triste Hombre.png", "M", Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(14, "emociones/Triste.m4a", "emociones/Triste Mujer.png", "F", Categoria.ID_CATEGORIA_EMOCIONES));
        //   } else if (cat.getId() == Categoria.ID_CATEGORIA_ESTABLO) {
        pictogramas.add(new Pictograma(15, "establo/Casco.m4a", "establo/Casco.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(16, "establo/Cepillo.m4a", "establo/Cepillo.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(17, "establo/Escarba Vasos.m4a", "establo/Escarba Vasos.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(18, "establo/Limpieza.m4a", "establo/Limpieza.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(19, "establo/Matra.m4a", "establo/Matra.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(20, "establo/Montura.m4a", "establo/Montura.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(21, "establo/Pasto.m4a", "establo/Pasto.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(22, "establo/Rasqueta Blanda.m4a", "establo/Rasqueta Blanda.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(23, "establo/Rasqueta Dura.m4a", "establo/Rasqueta Dura.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(24, "establo/Riendas.m4a", "establo/Riendas.png", "U", Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(25, "establo/Zanahoria.m4a", "establo/Zanahoria.png", "U", Categoria.ID_CATEGORIA_ESTABLO));

        //  } else if (cat.getId() == Categoria.ID_CATEGORIA_NECESIDADES) {
        pictogramas.add(new Pictograma(40, "necesidades/Banio.m4a", "necesidades/Banio.png", "U", Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(41, "necesidades/Sed Hombre.m4a", "necesidades/Sed Hombre.png", "M", Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(42, "necesidades/Sed Mujer.m4a", "necesidades/Sed Mujer.png", "F", Categoria.ID_CATEGORIA_NECESIDADES));

        //    } else if (cat.getId() == Categoria.ID_CATEGORIA_PISTA) {
        pictogramas.add(new Pictograma(26, "pista/Aro.m4a", "pista/Aro.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(27, "pista/Broches.m4a", "pista/Broches.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(28, "pista/Burbujas.m4a", "pista/Burbujas.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(29, "pista/Caballo.m4a", "pista/Caballo.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(30, "pista/Caballo.m4a", "pista/Caballo 2.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(31, "pista/Caballo.m4a", "pista/Caballo 3.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(32, "pista/Chapas.m4a", "pista/Chapas.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(33, "pista/Cubos.m4a", "pista/Cubos.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(34, "pista/Letras.m4a", "pista/Letras.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(35, "pista/Maracas.m4a", "pista/Maracas.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(36, "pista/Palos.m4a", "pista/Palos.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(37, "pista/Pato.m4a", "pista/Pato.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(38, "pista/Pelota.m4a", "pista/Pelota.png", "U", Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(39, "pista/Tarima.m4a", "pista/Tarima.png", "U", Categoria.ID_CATEGORIA_PISTA));
        Pictograma pictograma;

        for (Iterator<Pictograma> i = pictogramas.iterator(); i.hasNext(); ) {
            values = new ContentValues();
            pictograma = i.next();
            values.put(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID, pictograma.getId());
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
