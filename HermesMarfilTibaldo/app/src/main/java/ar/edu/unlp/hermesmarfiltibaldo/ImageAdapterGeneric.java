package ar.edu.unlp.hermesmarfiltibaldo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 16/02/16.
 */
public class ImageAdapterGeneric extends BaseAdapter {
    protected Context mContext;
    protected int number;
    protected List<Pictograma> mThumbIds;
    private ImageAdapterStrategy strategy;

    public ImageAdapterGeneric(Context c, int number, ImageAdapterStrategy strategy) {
        this.mContext = c;
        this.number = number;
        this.mThumbIds = new LinkedList<Pictograma>();
        this.setStrategy(strategy);
        this.getStrategy().setOwner(this);
        this.getImages();
    }

    protected void getImages(){
        this.getStrategy().getImages();
    }

    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return this.getStrategy().getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getStrategy().getItemId(position);
    }

    protected Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = mContext.getResources().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            if(HermesCore.instancia().getAlumnoActual().getTamanioPictograma() != Alumno.GRANDE ){
                imageView.setLayoutParams(new GridView.LayoutParams(150, 200));
            }else
            {imageView.setLayoutParams(new GridView.LayoutParams(300, 400));}

            //   imageView.setLayoutParams(new GridView.LayoutParams(800,600));
            imageView.setAdjustViewBounds(true);

            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        File imgFile = new  File(mThumbIds.get(position).getImageFilename());
        Bitmap bitmapFromAsset = getBitmapFromAsset(imgFile.getPath());
        BitmapDrawable bmd = new BitmapDrawable(bitmapFromAsset);

        // Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        //imageView.setImageBitmap(bitmapFromAsset);
        imageView.setImageDrawable(bmd);
        this.asignarEventoTouch(imageView, mThumbIds.get(position), number);
        this.estaResaltada(imageView, mThumbIds.get(position), number);
        return imageView;
    }

    protected void asignarEventoTouch(ImageView imageView, Pictograma pictograma, int number){
        this.getStrategy().asignarEventoTouch(imageView,pictograma,number);
    }

    protected void estaResaltada(ImageView imageView, Pictograma pictograma, int number)
    { this.getStrategy().estaResaltada( imageView,  pictograma,  number);}

    public ImageAdapterStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ImageAdapterStrategy strategy) {
        this.strategy = strategy;
    }
}


