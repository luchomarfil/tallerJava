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

    public void getImages()
    {
        // references to our images
        Logger l = Logger.getLogger(ImageAdapterModoAlumno.class.getName());
        l.info("Numero " + getOwner().number);
        switch (getOwner().number) {
            case 0:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());
                //mThumbIds = new ArrayList<Pictograma>();
                break;
        }

    }

    @Override
    protected void asignarEventoTouch(ImageView imageView, final Pictograma pictograma, int number) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HermesCore.instancia().playAudio(pictograma,getOwner().mContext);
                HermesCore.instancia().comunicarNotificacion(pictograma);
            }
        });

    }


}