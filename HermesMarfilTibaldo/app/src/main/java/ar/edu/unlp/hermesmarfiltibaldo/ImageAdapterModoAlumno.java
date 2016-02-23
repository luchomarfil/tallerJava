package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */


import android.view.View;
import android.widget.ImageView;

import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class ImageAdapterModoAlumno extends ImageAdapterStrategy {



    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public void asignarBordeImagen(ImageView imageView, Pictograma p, int number) {
    }

    public void getImages()
    {
        // references to our images
        Logger l = Logger.getLogger(ImageAdapterModoAlumno.class.getName());
        l.info("Numero " + getOwner().number);
        //HermesCore.instancia().getAlumnoActual().getCategorias().size();
        switch (getOwner().number) {
            case 0:
                if (HermesCore.instancia().getAlumnoActual().getCategorias().size()>0)
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramasPorCat(HermesCore.instancia().getAlumnoActual(),HermesCore.instancia().getAlumnoActual().getCategorias().get(0));}
                else
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());}
                break;
            case 1:
                if (HermesCore.instancia().getAlumnoActual().getCategorias().size()>1)
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramasPorCat(HermesCore.instancia().getAlumnoActual(), HermesCore.instancia().getAlumnoActual().getCategorias().get(1));}
                else
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());}
                break;
            case 2:
                if (HermesCore.instancia().getAlumnoActual().getCategorias().size()>2)
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramasPorCat(HermesCore.instancia().getAlumnoActual(), HermesCore.instancia().getAlumnoActual().getCategorias().get(2));}
                else
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());}
                break;
            case 3:
                if (HermesCore.instancia().getAlumnoActual().getCategorias().size()>3)
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramasPorCat(HermesCore.instancia().getAlumnoActual(),HermesCore.instancia().getAlumnoActual().getCategorias().get(3));}
                else
                {getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());}
                break;
            case 4:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());
                break;

        }
        l.info("Cantidad de imagenes cargadas para el alumno "+getOwner().mThumbIds.size());

    }

    @Override
    protected void asignarEventoTouch(ImageView imageView, final Pictograma pictograma, int number) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HermesCore.instancia().playAudio(pictograma, getOwner().mContext);
                if (!(pictograma.getNombre().equals("no") || pictograma.getNombre().equals("si") )){
                    HermesCore.instancia().comunicarNotificacion(pictograma);
                }
            }
        });

    }


}