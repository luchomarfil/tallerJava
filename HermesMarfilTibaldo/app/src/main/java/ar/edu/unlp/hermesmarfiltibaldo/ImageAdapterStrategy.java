package ar.edu.unlp.hermesmarfiltibaldo;

import android.widget.ImageView;

import ar.edu.unlp.hermesmarfiltibaldo.ImageAdapterGeneric;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 17/02/16.
 */
public abstract class ImageAdapterStrategy {

    ImageAdapterGeneric owner;
    protected abstract void getImages();
    protected abstract void asignarEventoTouch(ImageView imageView, Pictograma pictograma, int number);

    public ImageAdapterGeneric getOwner() {
        return owner;
    }

    public void setOwner(ImageAdapterGeneric owner) {
        this.owner = owner;
    }

    public abstract Object getItem(int position);

    public abstract long getItemId(int position);
}
