package ar.edu.unlp.hermesmarfiltibaldo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract.*;


/**
 * Created by Agustín on 2/7/2016.
 */


public class HermesDBHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ALUMNO =
            "CREATE TABLE " + Alumno.TABLE_NAME + " (" +
                    Alumno.COLUMN_ALUMNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    Alumno.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                    Alumno.COLUMN_NAME_APELLIDO + TEXT_TYPE + COMMA_SEP +
                    Alumno.COLUMN_NAME_SEXO + TEXT_TYPE + COMMA_SEP +
                    Alumno.COLUMN_NAME_TAMANIO + TEXT_TYPE +
            " )";
    private static final String SQL_DELETE_ALUMNO =
            "DROP TABLE IF EXISTS " + Alumno.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_PICTOGRAMA =
            "CREATE TABLE " + Pictograma.TABLE_NAME + " (" +
                    Pictograma.COLUMN_NAME_PICTOGRAMA_ID + " INTEGER PRIMARY KEY ," +
                    Pictograma.COLUMN_NAME_PICTOGRAMA_NAME + TEXT_TYPE + COMMA_SEP +
                    Pictograma.COLUMN_NAME_SEXO + TEXT_TYPE + COMMA_SEP +
                    Pictograma.COLUMN_NAME_AUDIO + TEXT_TYPE + COMMA_SEP +
                    Pictograma.COLUMN_NAME_IMAGEN + TEXT_TYPE + COMMA_SEP +
                    Pictograma.COLUMN_NAME_CATEOGRIA_ID + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_PICTOGRAMA =
            "DROP TABLE IF EXISTS " + Pictograma.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_PICTOGRAMA_ALUMNO =
            "CREATE TABLE " + PictogramaAlumno.TABLE_NAME + " (" +
                    PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ALUMNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    PictogramaAlumno.COLUMN_NAME_PICTOGRAMA_ID + " INTEGER " + COMMA_SEP +
                    PictogramaAlumno.COLUMN_NAME_ALUMNO_ID + " INTEGER " +
                    " )";
    private static final String SQL_DELETE_PICTOGRAMA_ALUMNO =
            "DROP TABLE IF EXISTS " + PictogramaAlumno.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_CONFIGURACION =
            "CREATE TABLE " + Configuracion.TABLE_NAME + " (" +
                    Configuracion.COLUMN_NAME_CONFIGURACION_ID + " INTEGER PRIMARY KEY," +
                    Configuracion.COLUMN_NAME_VALOR + TEXT_TYPE + COMMA_SEP +
                    Configuracion.CONLUMN_NAME_CONFIGURACION_NOMBRE + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_CONFIGURACION =
            "DROP TABLE IF EXISTS " + Configuracion.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_CATEGORIA =
            "CREATE TABLE " + Categoria.TABLE_NAME + " (" +
                    Categoria.COLUMN_NAME_CATEGORIA_ID + " INTEGER PRIMARY KEY," +
                    Categoria.COLUMN_NAME_NOMBRE + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_CATEGORIA =
            "DROP TABLE IF EXISTS " + Categoria.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_CATEGORIA_ALUMNO =
            "CREATE TABLE " + CategoriaAlumno.TABLE_NAME + " (" +
                    CategoriaAlumno.COLUMN_NAME_CATEGORIA_ALUMNO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    CategoriaAlumno.COLUMN_NAME_CATEGORIA_ID + " INTEGER " + COMMA_SEP +
                    CategoriaAlumno.COLUMN_NAME_ALUMNO_ID + " INTEGER " +
                    " )";


    private static final String SQL_DELETE_CATEGORIA_ALUMNO =
            "DROP TABLE IF EXISTS " + CategoriaAlumno.TABLE_NAME;
    // If you change the database schema, you must increment the database version.

    private static final String SQL_CREATE_CATEGORIA_NOTIFICACION =
            "CREATE TABLE " + Notificacion.TABLE_NAME + " (" +
                    Notificacion.COLUMN_NOTIFICACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    Notificacion.COLUMN_NAME_CONTEXTO + TEXT_TYPE + COMMA_SEP +
                    Notificacion.COLUMN_NAME_ENVIADO + TEXT_TYPE + COMMA_SEP +
                    Notificacion.COLUMN_NAME_FECHA + TEXT_TYPE + COMMA_SEP +
                    Notificacion.COLUMN_NAME_MENSAJE + TEXT_TYPE + COMMA_SEP +
                    Notificacion.COLUMN_NAME_NINIO + TEXT_TYPE + COMMA_SEP +
                    Notificacion.COLUMN_NAME_CATEGORIA + TEXT_TYPE +
                    " )";


    private static final String SQL_DELETE_CATEGORIA_NOTIFICACION =
            "DROP TABLE IF EXISTS " + Notificacion.TABLE_NAME;
    // If you change the database schema, you must increment the database version.


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "HERMES.db";

    public HermesDBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //DESCOMENTAR LA SIGUIENTE LINEA PARA REINICIAR LA BASE DE DATOS
        //this.onUpgrade(this.getWritableDatabase(), DATABASE_VERSION, DATABASE_VERSION + 1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PICTOGRAMA);
        db.execSQL(SQL_CREATE_ALUMNO);
        db.execSQL(SQL_CREATE_PICTOGRAMA_ALUMNO);
        db.execSQL(SQL_CREATE_CONFIGURACION);
        db.execSQL(SQL_CREATE_CATEGORIA);
        db.execSQL(SQL_CREATE_CATEGORIA_ALUMNO);
        db.execSQL(SQL_CREATE_CATEGORIA_NOTIFICACION);
        HermesDBStartUp.startUp(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_PICTOGRAMA);
        db.execSQL(SQL_DELETE_ALUMNO);
        db.execSQL(SQL_DELETE_PICTOGRAMA_ALUMNO);
        db.execSQL(SQL_DELETE_CONFIGURACION);
        db.execSQL(SQL_DELETE_CATEGORIA);
        db.execSQL(SQL_DELETE_CATEGORIA_ALUMNO);
        db.execSQL(SQL_DELETE_CATEGORIA_NOTIFICACION);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}