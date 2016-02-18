package ar.edu.unlp.hermesmarfiltibaldo.dao;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDBHelper.*;


/**
 * Created by luciano on 14/12/15.
 */
public class HermesDaoDB implements HermesDao {

    private static final String SEXO_MASCULINO = Alumno.MASCULINO;
    private static final String SEXO_FEMENINO = Alumno.FEMENINO;
    private static HermesDBHelper hermesDBHelper;

    public HermesDaoDB(Context context)
    {
        hermesDBHelper = new HermesDBHelper(context);
    }

    private void beforeRead(){}

    public List<Alumno> getAlumnos(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

// Retorna todos los alumnos
        String[] projection = {
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

        List<Alumno> l = new ArrayList<Alumno>();
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    l.add(new Alumno(cursor.getLong(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
                }
                while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return l;
    }

    public long createNewAlumno(Alumno alumno){
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
        return newRowId;
    }

    public void createNewPictograma(Pictograma pictograma){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID, pictograma.getId());
        values.put(HermesContract.Pictograma.COLUMN_NAME_IMAGEN, pictograma.getImageFilename());
        values.put(HermesContract.Pictograma.COLUMN_NAME_AUDIO, pictograma.getAudioFilename());
        values.put(HermesContract.Pictograma.COLUMN_NAME_SEXO, pictograma.getSexo());
        values.put(HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID, pictograma.getCategoriaID());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.Pictograma.TABLE_NAME,
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

    public void createNewCategoriaAlumno(Categoria categoria, Alumno alumno){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HermesContract.CategoriaAlumno.COLUMN_NAME_CATEGORIA_ID, categoria.getId());
        values.put(HermesContract.CategoriaAlumno.COLUMN_NAME_ALUMNO_ID, alumno.getId());


// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.CategoriaAlumno.TABLE_NAME,
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

       List<Categoria> l = new ArrayList<Categoria>();
       if (cursor.getCount() > 0) {
           if (cursor.moveToFirst()) {
               do {
                   l.add( new Categoria(cursor.getLong(0),cursor.getString(1)));
               }
               while (cursor.moveToNext());
           }
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
                " C."   + HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID +
                " WHERE CA." + HermesContract.CategoriaAlumno.COLUMN_NAME_ALUMNO_ID + " = ? ";

        Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{String.valueOf(alumno.getId().toString())});
        List<Categoria> l = new ArrayList<Categoria>();
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    l.add(new Categoria(cursor.getLong(cursor.getColumnIndex(HermesContract.Categoria.COLUMN_NAME_CATEGORIA_ID))
                                     , cursor.getString(cursor.getColumnIndex(HermesContract.Categoria.COLUMN_NAME_NOMBRE))));
                }
                while (cursor.moveToNext());
            }
        }

        cursor.close();
        db.close();
        return l;
    }


    public List<Pictograma> getPictogramas(Categoria cat, String sexo){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String[] projection = {
               HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID,
                HermesContract.Pictograma.COLUMN_NAME_AUDIO,
               HermesContract.Pictograma.COLUMN_NAME_IMAGEN,
               HermesContract.Pictograma.COLUMN_NAME_SEXO,
               HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID
        };

        Cursor c = db.query(
                HermesContract.Pictograma.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                " ( " + HermesContract.Pictograma.COLUMN_NAME_SEXO + " =? OR "
                        + HermesContract.Pictograma.COLUMN_NAME_SEXO + "= '" + Alumno.UNISEX +"' ) AND "
                        + HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID + "=? ",                                // The columns for the WHERE clause
                new String[]{sexo, cat.getId().toString()},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        List<Pictograma> pictogramas = new ArrayList<>();
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    pictogramas.add(new Pictograma(c.getLong(0),c.getString(1), c.getString(2),c.getString(3),c.getLong(4)));
                }
                while (c.moveToNext());
            }
        }
        c.close();
        db.close();
        return pictogramas;
    }

    @Deprecated
    public List<Pictograma> getPictogramas(Alumno alumno){
        //crotada
        return this.getPictogramasAlumno(alumno);
    }

    public List<Pictograma> getPictogramasAlumno(Alumno alumno)  {
            SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

            String getPictogramasAlumno = "SELECT P.* FROM "+
                    "  " + HermesContract.PictogramaAlumno.TABLE_NAME + " as PA " +
                    " INNER JOIN " + HermesContract.Pictograma.TABLE_NAME + " as P on "+
                    " PA." + HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " = " +
                    " P." + HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID +
                    " WHERE PA." + HermesContract.Alumno.COLUMN_ALUMNO_ID + " = ? ";

            Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{String.valueOf(alumno.getId().toString())});
            List<Pictograma> l = new ArrayList<Pictograma>();
            if (cursor.moveToFirst()) {
                do {
                    l.add(new Pictograma(
                            cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID)),
                            cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_AUDIO)),
                            cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_IMAGEN)),
                            cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_SEXO)),
                            cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID))));
                }
                while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
            return l;
        }

    public String getPortComunicadorJSON(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String[] projection = {
                HermesContract.Configuracion.COLUMN_NAME_CONFIGURACION_ID,
                HermesContract.Configuracion.COLUMN_NAME_VALOR,
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE,
        };

        Cursor c = db.query(
                HermesContract.Configuracion.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + "=?",                                // The columns for the WHERE clause
                new String[]{"PORT"},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        String result = c.getString(1);
        c.close();
        db.close();
        return  result;
    }

    public String getIP(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String[] projection = {
                HermesContract.Configuracion.COLUMN_NAME_CONFIGURACION_ID,
                HermesContract.Configuracion.COLUMN_NAME_VALOR,
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE,
        };

        Cursor c = db.query(
                HermesContract.Configuracion.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + "=?",                                // The columns for the WHERE clause
                new String[]{"IP"},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        c.moveToFirst();
        String result = c.getString(1);
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
                HermesContract.Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + " =  ? ",
                new String[]{name});
        db.close();
    }

    public void updateAlumno(Alumno alumno){

        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

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
                HermesContract.Alumno.COLUMN_ALUMNO_ID + " =? ",
                new String[]{alumno.getId().toString()});
        db.close();
    }

    public void removeAlumno(Alumno alumno){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

        long newRowId;
        newRowId = db.delete(
                HermesContract.Alumno.TABLE_NAME,
                HermesContract.Alumno.COLUMN_ALUMNO_ID + " =? ",
                new String[]{alumno.getId().toString()});
        db.close();
    }

    public void removeAlumnoPictograma(Alumno alumno, Pictograma pictograma){
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase ();

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.delete(
                HermesContract.PictogramaAlumno.TABLE_NAME,
                HermesContract.PictogramaAlumno.COLUMN_NAME_ALUMNO_ID + " =? AND " + HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " =? ",
                new String[]{alumno.getId().toString(), pictograma.getId().toString()});
        db.close();
    }

    public void removeAlumnoTodosPictogramas(Alumno alumno){
        //  Lo usamos para cuando hay un cambio de sexo
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase ();

        long newRowId;
        newRowId = db.delete(
                HermesContract.PictogramaAlumno.TABLE_NAME,
                HermesContract.PictogramaAlumno.COLUMN_NAME_ALUMNO_ID + "=?",
                new String[]{alumno.getId().toString()});
        db.close();
    }

    public void removeAlumnoTodasCategoria(Alumno alumno){
        //  Lo usamos para cuando hay un cambio de sexo
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();


        long newRowId;
        newRowId = db.delete(
                HermesContract.CategoriaAlumno.TABLE_NAME,
                HermesContract.CategoriaAlumno.COLUMN_NAME_ALUMNO_ID + "=?" ,
                new String[]{alumno.getId().toString()});
        db.close();
    }

    public Pictograma getPictogramaPorNombre(String nombre){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String getPictogramasAlumno = "SELECT PA.* FROM "+
                "  " + HermesContract.Pictograma.TABLE_NAME + " as PA " +
                " WHERE PA." + HermesContract.Pictograma.COLUMN_NAME_IMAGEN + " = ? ";

        Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{String.valueOf(nombre)});
        //List<Pictograma> l = new ArrayList<Pictograma>();
        Pictograma p = null;
        if (cursor.moveToFirst()) {
                p = new Pictograma(
                        cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID)),
                        cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_AUDIO)),
                        cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_IMAGEN)),
                        cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_SEXO)),
                        cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID)));

        }

        cursor.close();
        db.close();
        return p;
    }

    public List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria) {
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String getPictogramasAlumno = "SELECT P.* FROM "+
                "  " + HermesContract.PictogramaAlumno.TABLE_NAME + " as PA " +
                " INNER JOIN " + HermesContract.Pictograma.TABLE_NAME + " as P on "+
                " PA." + HermesContract.PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " = " +
                " P." + HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID +
                " WHERE PA." + HermesContract.Alumno.COLUMN_ALUMNO_ID + " = ? " +
                " AND P." + HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID + " =?";

        Cursor cursor = db.rawQuery(getPictogramasAlumno, new String[]{alumnoActual.getId().toString(), categoria.getId().toString()});
        List<Pictograma> l = new ArrayList<Pictograma>();
        if(cursor.getCount() > 0){
                if (cursor.moveToFirst()) {
                    do {
                        l.add(new Pictograma(
                                cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_PICTOGRAMA_ID)),
                                cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_AUDIO)),
                                cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_IMAGEN)),
                                cursor.getString(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_SEXO)),
                                cursor.getLong(cursor.getColumnIndex(HermesContract.Pictograma.COLUMN_NAME_CATEOGRIA_ID))));
                    }
                    while (cursor.moveToNext());
                }
        }

        cursor.close();
        db.close();
        return l;
    }

    public void createNewNotificacion(Notificacion n, boolean b) {
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(HermesContract.Notificacion.COLUMN_NAME_CATEGORIA, n.getCategoria());
        values.put(HermesContract.Notificacion.COLUMN_NAME_CONTEXTO,n.getContexto()) ;
        values.put(HermesContract.Notificacion.COLUMN_NAME_ENVIADO, b );
        values.put(HermesContract.Notificacion.COLUMN_NAME_FECHA, n.getFecha().toString() );
        values.put(HermesContract.Notificacion.COLUMN_NAME_MENSAJE, n.getMensaje());
        values.put(HermesContract.Notificacion.COLUMN_NAME_NINIO, n.getNinio());

// Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                HermesContract.Notificacion.TABLE_NAME,
                null,
                values);
        db.close();
    }

    public List<Notificacion> getNotificacionesNoEnviadas(){
        SQLiteDatabase db = hermesDBHelper.getReadableDatabase();

        String[] projection = {
                HermesContract.Notificacion.COLUMN_NAME_CATEGORIA,
                HermesContract.Notificacion.COLUMN_NAME_CONTEXTO,
                HermesContract.Notificacion.COLUMN_NAME_ENVIADO,
                HermesContract.Notificacion.COLUMN_NAME_FECHA,
                HermesContract.Notificacion.COLUMN_NAME_MENSAJE,
                HermesContract.Notificacion.COLUMN_NAME_NINIO,
        };
        Cursor c = db.query(
                HermesContract.Notificacion.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                HermesContract.Notificacion.COLUMN_NAME_ENVIADO + " =? ",                                // The columns for the WHERE clause
                new String[]{"false"},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        List<Notificacion> notificacion = new ArrayList<Notificacion>();
        if (c.getCount() > 0) {
            if (c.moveToFirst()) {
                do {
                    notificacion.add(new Notificacion(new Date(c.getLong(c.getColumnIndex(HermesContract.Notificacion.COLUMN_NAME_FECHA))),
                            c.getString(c.getColumnIndex(HermesContract.Notificacion.COLUMN_NAME_CATEGORIA)),
                            c.getString(c.getColumnIndex(HermesContract.Notificacion.COLUMN_NAME_CONTEXTO)),
                            c.getString(c.getColumnIndex(HermesContract.Notificacion.COLUMN_NAME_MENSAJE)),
                            c.getString(c.getColumnIndex(HermesContract.Notificacion.COLUMN_NAME_NINIO))));
                }
                while (c.moveToNext());
            }
        }
        c.close();
        db.close();
        return notificacion;
    }

    public void setNotificacionToEnviada(Notificacion n) {
        // Gets the data repository in write mode
        SQLiteDatabase db = hermesDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(HermesContract.Notificacion.COLUMN_NAME_ENVIADO, "true");
        
        long newRowId;
        newRowId = db.update(
                HermesContract.Notificacion.TABLE_NAME,
                values,
                HermesContract.Notificacion.COLUMN_NAME_CATEGORIA + " =? " +
                    HermesContract.Notificacion.COLUMN_NAME_CONTEXTO + " =? " +
                    HermesContract.Notificacion.COLUMN_NAME_MENSAJE + " =? " +
                    HermesContract.Notificacion.COLUMN_NAME_NINIO + " =? " +
                    HermesContract.Notificacion.COLUMN_NAME_FECHA + " =? ",
                new String[]{n.getCategoria(), n.getContexto(), n.getMensaje(), n.getNinio(), n.getFecha().toString()});
        db.close();
    }

}
