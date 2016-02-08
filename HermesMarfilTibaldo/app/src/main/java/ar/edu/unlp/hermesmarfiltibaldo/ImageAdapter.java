package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.ViewGroup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.core.HermesCore;
import ar.edu.unlp.hermesmarfiltibaldo.dao.HermesDao;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int number;
    private List<Pictograma> mThumbIds;
    public ImageAdapter(Context c,int number) {
        mContext = c;
        this.number = number;
        mThumbIds = new LinkedList<Pictograma>();
        getImages();
    }


    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
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

            imageView.setScaleType(ImageView.ScaleType.CENTER);
            //imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        File imgFile = new  File(mThumbIds.get(position).getImageFilename());
        Bitmap bitmapFromAsset = getBitmapFromAsset(imgFile.getPath());
        // Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        imageView.setImageBitmap(bitmapFromAsset);

        return imageView;
    }

    private Bitmap getBitmapFromAsset(String strName)
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



    public void getImages()
    {
// references to our images

        switch (this.number) {
            case 0:
                mThumbIds = HermesDao.instancia().getPictogramas(Categoria.getCategoriaEmociones());
                break;
            case 1:
                mThumbIds = HermesDao.instancia().getPictogramas(Categoria.getCategoriaEstablo());
                break;
            case 2:
                mThumbIds = HermesDao.instancia().getPictogramas(Categoria.getCategoriaNecesidades());
                break;
            case 3:
                mThumbIds = HermesDao.instancia().getPictogramas(Categoria.getCategoriaPista());
                break;
            case 4:
                mThumbIds = HermesDao.instancia().getPictogramas(HermesCore.instancia().getAlumnoActual());
                break;
        }

    }
}