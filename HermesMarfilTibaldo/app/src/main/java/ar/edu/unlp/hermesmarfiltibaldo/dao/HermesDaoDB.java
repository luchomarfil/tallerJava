package ar.edu.unlp.hermesmarfiltibaldo.dao;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDBHelper.*;


/**
 * Created by luciano on 14/12/15.
 */
public class HermesDaoDB {

    private static final String SEXO_MASCULINO = "M";
    private static final String SEXO_FEMENINO = "F";
    private static HermesDBHelper hermesDBHelper;


    private static HermesDaoDB instance;

    public static synchronized HermesDaoDB instancia(Context context){
        if(instance==null){
            instance = new HermesDaoDB(context);
        }
        return instance;
    }

    private HermesDaoDB(Context context){
        hermesDBHelper = new HermesDBHelper(context);
    }
    private void beforeRead(){

    }

    public List<Alumno> getAlumnos(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                HermesContract.Alumno._ID,
                HermesContract.Alumno.COLUMN_ALUMNO_ID,
                HermesContract.Alumno.COLUMN_NAME_NOMBRE,
                HermesContract.Alumno.COLUMN_NAME_APELLIDO,
                HermesContract.Alumno.COLUMN_NAME_SEXO,
                HermesContract.Alumno.COLUMN_NAME_TAMANIO
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                HermesContract.Alumno.COLUMN_ALUMNO_ID + " DESC";
        String selection = "";
        String selectionArgs[] = {};

        Cursor cursor = db.query(
                HermesContract.Alumno.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(HermesContract.Alumno._ID)
        );
        List<Alumno> l = new ArrayList<Alumno>();
        if (cursor.moveToFirst()) {
            do {
                l.add(new Alumno(cursor.getLong(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5)));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return l;
    }

    public void createNewAlumno(Alumno alumno){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.Alumno.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(HermesContract.Alumno.COLUMN_NAME_APELLIDO, alumno.getApellido());
        values.put(HermesContract.Alumno.COLUMN_NAME_SEXO, alumno.getSexo());
        values.put(HermesContract.Alumno.COLUMN_NAME_TAMANIO, alumno.getTamanioPictograma());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.Alumno.TABLE_NAME,
                null,
                values);
        db.close();
    }

    public void createNewPictograma(Pictograma pictograma){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID, pictograma.getId());
        values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, pictograma.getImageFilename());
        values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, pictograma.getAudioFilename());
        values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, pictograma.getSexo());
        values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, pictograma.getCategoriaID());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.Categoria.TABLE_NAME,
                null,
                values);
        db.close();
    }

    public void createNewCategoria(Categoria categoria){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID, categoria.getId());
        values.put(HermesContract.Categoria.COLUMN_NAME_NOMBRE, categoria.getNombre());


// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.Categoria.TABLE_NAME,
                null,
                values);
        db.close();
    }

    public void createNewAlumnoPictograma(Alumno alumno, Pictograma pictograma){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.PictogramaAlumno.COLUMN_NAME_ALUMNO_ID, alumno.getId());
        values.put(HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID, pictograma.getId());


// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.PictogramaAlumno.TABLE_NAME,
                null,
                values);
        db.close();
    }

   public List<Categoria> getCategorias() {
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                HermesContract.Categoria._ID,
                HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID,
                HermesContract.Categoria.COLUMN_NAME_NOMBRE,
        };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID + " DESC";
        String selection = "";
        String selectionArgs[] = {};

        Cursor cursor = db.query(
                HermesContract.Categoria.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(HermesContract.Categoria._ID)
        );
        List<Categoria> l = new ArrayList<Categoria>();
        l.add(new Categoria(cursor.getLong(1), cursor.getString(2)));
        while (cursor.moveToNext())
        {
            l.add( new Categoria(cursor.getLong(1),cursor.getString(2)));
        }
        cursor.close();
        db.close();
        return l;
    }

    public List<Categoria> getCategorias(Alumno alumno)  {
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID,
                HermesContract.Categoria.COLUMN_NAME_NOMBRE,
        };

        String getPictogramasAlumno = "SELECT C.* FROM "+
                HermesContract.CategoriaAlumno.TABLE_NAME + " as CA " +
                " INNER JOIN " + HermesContract.Categoria.TABLE_NAME + " as C on "+
                " CA." + HermesContract.CategoriaAlumno.COLUMN_NAME_CATEGORIA_ID + " = " +
                HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID +
                " WHERE CA" + HermesContract.CategoriaAlumno.COLUMN_NAME_ALUMNO_ID + " = ? ";

        Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{String.valueOf(alumno.getId().toString())});
        List<Categoria> l = new ArrayList<Categoria>();
        if (cursor.moveToFirst()) {
            do {
                l.add(new Categoria(cursor.getLong(1),cursor.getString(2)));
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return l;
    }

    public List<Pictograma> getPictogramas(Categoria cat){
        List<Pictograma> pictogramas = new ArrayList<>();


        return pictogramas;
    }

  /*  public List<Pictograma> getPictogramasAjustes(Alumno alumno){
        List<Pictograma> pictogramas = new ArrayList<>();

        if(alumno.getSexo()==SEXO_FEMENINO){
            pictogramas.add(new Pictograma("emociones/Asustada.m4a","emociones/Asustada.png"));
            pictogramas.add(new Pictograma("emociones/Cansada.m4a","emociones/Cansada.png"));
            pictogramas.add(new Pictograma("emociones/Contenta.m4a","emociones/Contenta.png"));
            pictogramas.add(new Pictograma("emociones/Dolorida.m4a","emociones/Dolorida.png"));
            pictogramas.add(new Pictograma("emociones/Enojada.m4a","emociones/Enojada.png"));
            pictogramas.add(new Pictograma("emociones/Sorprendida.m4a","emociones/Sorprendida.png"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Mujer.png"));
            pictogramas.add(new Pictograma("necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png"));

        }
        else if(alumno.getSexo()==SEXO_MASCULINO){

            pictogramas.add(new Pictograma("emociones/Asustado.m4a","emociones/Asustado.png"));
            pictogramas.add(new Pictograma("emociones/Cansado.m4a","emociones/Cansdao.png"));
            pictogramas.add(new Pictograma("emociones/Contento.m4a","emociones/Contento.png"));
            pictogramas.add(new Pictograma("emociones/Dolorido.m4a","emociones/Dolorido.png"));
            pictogramas.add(new Pictograma("emociones/Enojado.m4a","emociones/Enojado.png"));
            pictogramas.add(new Pictograma("emociones/Sorprendido.m4a","emociones/Sorprendido.png"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Hombre.png"));
            pictogramas.add(new Pictograma("necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png"));

        }
        pictogramas.add(new Pictograma("establo/Casco.m4a","establo/Casco.png"));
        pictogramas.add(new Pictograma("establo/Cepillo.m4a","establo/Cepillo.png"));
        pictogramas.add(new Pictograma("establo/Escarba Vasos.m4a","establo/Escarba Vasos.png"));
        pictogramas.add(new Pictograma("establo/Limpieza.m4a","establo/Limpieza.png"));
        pictogramas.add(new Pictograma("establo/Matra.m4a","establo/Matra.png"));
        pictogramas.add(new Pictograma("establo/Montura.m4a","establo/Montura.png"));
        pictogramas.add(new Pictograma("establo/Pasto.m4a","establo/Pasto.png"));
        pictogramas.add(new Pictograma("establo/Dolorido.m4a","establo/Dolorido.png"));
        pictogramas.add(new Pictograma("establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png"));
        pictogramas.add(new Pictograma("establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png"));
        pictogramas.add(new Pictograma("establo/Riendas.m4a","establo/Riendas.png"));
        pictogramas.add(new Pictograma("establo/Zanahoria.m4a","establo/Zanahoria.png"));
        pictogramas.add(new Pictograma("necesidades/Banio.m4a","necesidades/Banio.png"));
        pictogramas.add(new Pictograma("pista/Aro.m4a","pista/Aro.png"));
        pictogramas.add(new Pictograma("pista/Broches.m4a","pista/Broches.png"));
        pictogramas.add(new Pictograma("pista/Burbujas.m4a","pista/Burbujas.png"));
        pictogramas.add(new Pictograma("pista/Caballo.m4a","pista/Caballo.png"));
        pictogramas.add(new Pictograma("pista/Caballo 2.m4a","pista/Caballo 2.png"));
        pictogramas.add(new Pictograma("pista/Caballo 3.m4a", "pista/Caballo 3.png"));
        pictogramas.add(new Pictograma("pista/Chapas.m4a","pista/Chapas.png"));
        pictogramas.add(new Pictograma("pista/Cubos.m4a","pista/Cubos.png"));
        pictogramas.add(new Pictograma("pista/Letras.m4a","pista/Letras.png"));
        pictogramas.add(new Pictograma("pista/Maracas.m4a","pista/Maracas.png"));
        pictogramas.add(new Pictograma("pista/Palos.m4a","pista/Palos.png"));
        pictogramas.add(new Pictograma("pista/Pato.m4a","pista/Pato.png"));
        pictogramas.add(new Pictograma("pista/Pelota.m4a","pista/Pelota.png"));
        pictogramas.add(new Pictograma("pista/Tarima.m4a","pista/Tarima.png"));

        return pictogramas;

    }*/

    public List<Pictograma> getPictogramasAlumno(Alumno alumno)  {
            SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
            String[] projection = {
                    HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ALUMNO_ID,
                    HermesContract.PictogramaAlumno.COLUMN_NAME_ALUMNO_ID,
                    HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID,
            };

            String getPictogramasAlumno = "SELECT P.* FROM "+
                    HermesContract.PictogramaAlumno.TABLE_NAME + " as PA " +
                    " INNER JOIN " + HermesContract.Pictograma.TABLE_NAME + " as P on "+
                    " PA." + HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " = " +
                    HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID +
                    " WHERE PA" + HermesContract.Alumno.COLUMN_ALUMNO_ID + " = ? ";

            Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{String.valueOf(alumno.getId().toString())});
            List<Pictograma> l = new ArrayList<Pictograma>();
            if (cursor.moveToFirst()) {
                do {
                    l.add(new Pictograma(cursor.getLong(1),cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getLong(5)));
                }
                while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return l;
        }


    public Integer getPortComunicadorJSON(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                HermesContract.Configuracion.COLUMN_NAME_VALOR,
        };

// How you want the results sorted in the resulting Cursor

        Cursor c = db.query(
                HermesContract.Configuracion.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + "=?",                                // The columns for the WHERE clause
                new String[] { "PORT" } ,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        int result =  c.getInt(1);
        c.close();
        db.close();
        return  result;
    }

    public String getIP(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();


// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                HermesContract.Configuracion.COLUMN_NAME_CONFIGURACION_ID,
                HermesContract.Configuracion.COLUMN_NAME_VALOR,
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE,
        };

// How you want the results sorted in the resulting Cursor

        Cursor c = db.query(
                HermesContract.Configuracion.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + "=?",                                // The columns for the WHERE clause
                new String[] { "IP" } ,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        String result = c.getString(2);
        c.close();
        db.close();
        return  result;
    }

    public void updateConfig(String name, String value){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.Configuracion.COLUMN_NAME_VALOR, value);

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.update(
                HermesContract.Configuracion.TABLE_NAME,
                values,
                " WHERE " + HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + " =  ? ",
                new String[]{name});
        db.close();
    }

    public void updateAlumno(Alumno alumno){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.Alumno.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(HermesContract.Alumno.COLUMN_NAME_APELLIDO, alumno.getApellido());
        values.put(HermesContract.Alumno.COLUMN_NAME_SEXO, alumno.getSexo());
        values.put(HermesContract.Alumno.COLUMN_NAME_TAMANIO, alumno.getTamanioPictograma());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.update(
                HermesContract.Alumno.TABLE_NAME,
                values,
                " WHERE " + HermesContract.Alumno.COLUMN_ALUMNO_ID + " =  ? ",
                new String[]{alumno.getId().toString()});
        db.close();
    }


    public void removeAlumno(Alumno alumno){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.delete(
                HermesContract.Alumno.TABLE_NAME,
                " WHERE " + HermesContract.Alumno.COLUMN_ALUMNO_ID + " =  ? ",
                new String[]{alumno.getId().toString()});
        db.close();
    }


    public void removeAlumnoPictograma(Alumno alumno, Pictograma pictograma){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase ();

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.delete(
                HermesContract.Alumno.TABLE_NAME,
                " WHERE " + HermesContract.PictogramaAlumno.COLUMN_NAME_ALUMNO_ID + " =  ? AND " +  HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " = ? " ,
                new String[]{alumno.getId().toString(), pictograma.getId().toString()});
        db.close();
    }
}
