package ar.edu.unlp.hermesmarfiltibaldo.dao.columns;

import android.provider.BaseColumns;

/**
 * Created by Agustín on 2/8/2016.
 */
public final class HermesContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public HermesContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Pictograma implements BaseColumns {
        public static final String TABLE_NAME = "pictograma";
        public static final String COLUMN_NAME_PICTOGRAMA_ID = "pictogramaid";
        public static final String COLUMN_NAME_IMAGEN = "imagen";
        public static final String COLUMN_NAME_CATEOGRIA_ID = "categoriaid";
        public static final String COLUMN_NAME_AUDIO = "audio";
        public static final String COLUMN_NAME_SEXO = "sexo";
    }

    /* Inner class that defines the table contents */
    public static abstract class PictogramaAlumno implements BaseColumns {
        public static final String TABLE_NAME = "pictogramaalumno";
        public static final String COLUMN_NAME_PICTOGRAMA_ALUMNO_ID = "pictogramaalumnoid";
        public static final String COLUMN_NAME_PICTOGRAMA_ID = "pictogramaid";
        public static final String COLUMN_NAME_ALUMNO_ID = "alumnoid";
    }
    /* Inner class that defines the table contents */
    public static abstract class Configuracion implements BaseColumns {
        public static final String TABLE_NAME = "configuracion";
        public static final String COLUMN_NAME_CONFIGURACION_ID = "configuracionid";
        public static final String COLUMN_NAME_VALOR = "valor";
        public static final String CONLUMN_NAME_CONFIGURACION_NOMBRE = "configuracionnombre";
    }

    /* Inner class that defines the table contents */
    public static abstract class Categoria implements BaseColumns {
        public static final String TABLE_NAME = "categoria";
        public static final String COLUMN_NAME_CATEGORIA_ID = "categoriaid";
        public static final String COLUMN_NAME_NOMBRE = "nombre";//EL NOMBRE DE LA CARPETA ES IGUAL AL DE LA CATEGORIA
    }

    /* Inner class that defines the table contents */
    public static abstract class CategoriaAlumno implements BaseColumns {
        public static final String TABLE_NAME = "solapaalumno";
        public static final String COLUMN_NAME_ENTRY_ID = "categoriaalumnoid";
        public static final String COLUMN_NAME_CATEGORIA_ID = "categoriaid";
        public static final String COLUMN_NAME_ALUMNO_ID = "alumnoid";
    }

    public static abstract class Alumno implements BaseColumns {
        public static final String TABLE_NAME = "alumno";
        public static final String COLUMN_ALUMNO_ID = "alumnoid";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_APELLIDO = "apellido";
        public static final String COLUMN_NAME_SEXO = "sexo";
        public static final String COLUMN_NAME_TAMANIO = "tamanio";
    }

}
