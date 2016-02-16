package ar.edu.unlp.hermesmarfiltibaldo.core;

import android.content.Context;

import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDaoDB;

/**
 * Created by luciano on 16/02/16.
 */
public class HermesConfiguration {


    public static void inicializar(Context c) {

        HermesCore.instancia().setHermesDaoDB(new HermesDaoDB(c));

    }
}
