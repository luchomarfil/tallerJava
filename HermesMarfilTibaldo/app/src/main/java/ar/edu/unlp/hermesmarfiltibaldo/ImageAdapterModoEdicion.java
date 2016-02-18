package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */

import android.content.Context;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class ImageAdapterModoEdicion extends ImageAdapterStrategy {

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
        l.info("Numero "+getOwner().number);
        switch (getOwner().number) {
            case 0:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaPista());
                break;
            case 1:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaEstablo());
                break;
            case 2:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaNecesidades());
                break;
            case 3:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(),Categoria.getCategoriaEmociones());
                break;
            case 4:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());
                //mThumbIds = new ArrayList<Pictograma>();
                break;
        }

        if(getOwner().mThumbIds==null){
            getOwner().mThumbIds = new LinkedList<>();
        }

    }

    @Override
    protected void asignarEventoTouch(ImageView imageView, Pictograma pictograma) {
    }
}