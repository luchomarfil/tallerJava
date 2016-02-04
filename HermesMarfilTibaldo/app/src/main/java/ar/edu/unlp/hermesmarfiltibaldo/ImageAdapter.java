package ar.edu.unlp.hermesmarfiltibaldo;

/**
 * Created by Agustín on 12/30/2015.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.view.ViewGroup;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int number;
    private List<String> mThumbIds;
    public ImageAdapter(Context c,int number) {
        mContext = c;
        this.number = number;
        mThumbIds = new LinkedList<String>();
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
            imageView.setLayoutParams(new GridView.LayoutParams(300, 250));
            imageView.setAdjustViewBounds(true);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }




        File imgFile = new  File(mThumbIds.get(position));
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }

        return imageView;
    }



    public void getImages()
    {
// references to our images


        File path = new File(Environment.getExternalStorageDirectory(),"establo/Casco.png").getParentFile();
        String[] fileNames;

            fileNames = path.list();

        for(int i = 0; i < fileNames.length; i++)
        {
            if (fileNames[i].toString().endsWith(".png"))
                {mThumbIds.add(fileNames[i].toString());}
        ///Now set this bitmap on imageview

        }
    }
}