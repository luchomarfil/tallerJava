package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */

import android.app.AlertDialog;

import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import java.util.LinkedList;
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class ImageAdapterModoEdicion extends ImageAdapterStrategy {

    Color backgroundOriginal = null;

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
        l.info("Numero " + getOwner().number);
        switch (getOwner().number) {
            case 0:
                getOwner().mThumbIds = HermesCore.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual(), Categoria.getCategoriaPista());
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
            getOwner().mThumbIds = new LinkedList<Pictograma>();
        }

        l.info("Cantidad de imagenes cargadas para el alumno en modo edicion para la pagina" + getOwner().number+"  "+getOwner().mThumbIds.size());



    }

    @Override
    protected void asignarEventoTouch(final ImageView imageView, final Pictograma pictograma, final int number) {
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                if (number == 4) { //si es la solapa del alumno
                    new AlertDialog.Builder(getOwner().mContext)
                            .setTitle("Eliminar")
                            .setMessage("Desea eliminar el pictograma?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    confirmarBorrado(HermesCore.instancia().getAlumnoActual(), pictograma,v);
                                }
                            })
                            .setNegativeButton("No", null).create().show();



                }

                return true;

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number != 4) { //si no es la solapa del alumno

                    if (isEstaSeleccionado(pictograma)) {
                        HermesCore.instancia().getHermesDao().removeAlumnoPictograma(HermesCore.instancia().getAlumnoActual(), pictograma);

                    } else {
                        HermesCore.instancia().getHermesDao().createNewAlumnoPictograma(HermesCore.instancia().getAlumnoActual(), pictograma);
                   //     getOwner().mThumbIds.add(pictograma);
                        //se deberia agregar en el mthumbs correspondiente al number del usuario el pictograma para que se refresque la vista
                    }
                    getOwner().redibujar();

                }
            }
        });


    }

    private void confirmarBorrado(Alumno alumnoActual, Pictograma pictograma, View v) {
        HermesCore.instancia().getHermesDao().removeAlumnoPictograma(HermesCore.instancia().getAlumnoActual(), pictograma);
        getOwner().mThumbIds.remove(pictograma);
        getOwner().redibujar();
        v.invalidate();


    }

    private boolean isEstaSeleccionado(Pictograma pictograma) {
        boolean esta = false;
        for (Pictograma s : HermesCore.instancia().getHermesDao().getPictogramasAlumno(HermesCore.instancia().getAlumnoActual())) {
            if (s.getImageFilename().equals(pictograma.getImageFilename())) {
                esta = true;
            }
        }
        return esta;
    }

    @Override
    public void asignarBordeImagen(ImageView imageView, Pictograma p, int number) {

        if(number!=4) { // si no es la solapa del alumno
            if (isEstaSeleccionado(p)){
                imageView.setBackgroundResource(R.color.colorAccent);
                imageView.setPadding(6,6,6,6);
            } else {
               // imageView.setBackgroundColor(Color.TRANSPARENT);
                imageView.setPadding(3,3,0,0);
            }
        }
    }


}