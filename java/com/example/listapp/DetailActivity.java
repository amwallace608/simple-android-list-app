package com.example.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //get Intent and passed item index value
        Intent in = getIntent();
        int index = in.getIntExtra("com.example.ITEM_INDEX", -1);
        if (index > -1){
            int pic = getImage(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    //get image for item
    private int getImage(int index){
        switch (index){
            case 0: return R.drawable.intel_ssd;
            case 1: return R.drawable.rtx2070_gpu;
            case 2: return R.drawable.ryzen_cpu;
            case 3: return R.drawable.x570_mobo;
            case 4: return R.drawable.rgb_ram;
            case 5: return R.drawable.evga_psu;
            default: return -1;
        }
    }

    //scale image
    private void scaleImg(ImageView img, int pic){
        //get access to screen to determine screen size
        Display screen = getWindowManager().getDefaultDisplay();
        //get access to java library class that scales images
        BitmapFactory.Options options = new BitmapFactory.Options();

        //turn on boundaries
        options.inJustDecodeBounds = true;
        //look at dimensions without drawing image
        BitmapFactory.decodeResource(getResources(), pic, options);
        //get width/height of image, compare against screen
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();
        if(imgWidth > screenWidth){
            //get ratio of img width to screen width
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            //set scale factor for new bitmap
            options.inSampleSize = ratio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }
}
