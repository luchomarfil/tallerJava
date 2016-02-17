package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class ImageAdapterModoEdicion extends ImageAdapterGeneric {

    public ImageAdapterModoEdicion(Context c, int number) {
        super(c, number);
    }




    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public void getImages()
    {
        // references to our images
        Logger l = Logger.getLogger(ImageAdapterModoEdicion.class.getName());
        l.info("Numero "+this.number);
        switch (this.number) {
            case 0:
                mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaPista());
                break;
            case 1:
                mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaEstablo());
                break;
            case 2:
                mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaNecesidades());
                break;
            case 3:
                mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaEmociones());
                break;
            case 4:
                mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());
                //mThumbIds = new ArrayList<Pictograma>();
                break;
        }

        if(mThumbIds==null){
            mThumbIds = new LinkedList<>();
        }

    }

    @Override
    protected void asignarEventoTouch() {
    }
}