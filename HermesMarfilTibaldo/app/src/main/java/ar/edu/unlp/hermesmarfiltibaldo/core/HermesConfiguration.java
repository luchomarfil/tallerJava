package ar.edu.unlp.hermesmarfiltibaldo.core;

import android.content.Context;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoDB;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoImpl;

/**
 * Created by luciano on 16/02/16.
 */
public class HermesConfiguration {


    public static void inicializar(Context c) {

        HermesCore.instancia().setHermesDao(new HermesDaoDB(c));
        //HermesCore.instancia().setHermesDao(new HermesDaoDB(c));

    }
}
