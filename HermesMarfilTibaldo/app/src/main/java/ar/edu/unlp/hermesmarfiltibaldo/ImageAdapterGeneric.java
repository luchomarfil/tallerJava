package ar.edu.unlp.hermesmarfiltibaldo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 16/02/16.
 */
public abstract class ImageAdapterGeneric extends BaseAdapter {
    protected Context mContext;
    protected int number;
    protected List<Pictograma> mThumbIds;

    public ImageAdapterGeneric(Context c, int number) {
        this.mContext = c;
        this.number = number;
        this.mThumbIds = new LinkedList<Pictograma>();
        this.getImages();
    }

    protected abstract void getImages();

    public int getCount() {
        return mThumbIds.size();
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
            //   imageView.setLayoutParams(new GridView.LayoutParams(300, 250));
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
        this.asignarEventoTouch();
        return imageView;
    }

    protected abstract void asignarEventoTouch();


}


