package com.example.xch.negativimage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image1);
        //nega();
        //blur();
        //scale();
        blurplusnaga();
    }

    private void nega()
    {
        //(nicht functiont)Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.img1);
        //1.
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
        //2.@SuppressLint("ResourceType") InputStream in = getResources().openRawResource(R.drawable.img1);
        //Bitmap bitmap = BitmapFactory.decodeStream(in);
        //3.Bitmap bitmap=BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/img1.JPG"));
        Bitmap negativeBitmap = NegativeHandle.negativehandle(bitmap, getApplicationContext());
        imageView.setImageBitmap(negativeBitmap);
    }

    private void blur()
    {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
        Bitmap blurBitmap = BlurHandle.blurhandle( getApplicationContext(),bitmap,25);
        imageView.setImageBitmap(blurBitmap);
    }

    private void scale(){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 8, bitmap.getHeight() / 8, false);
        Bitmap blurBitmap = BlurHandle.blurhandle(getApplicationContext(),newBitmap,15);
        imageView.setImageBitmap(blurBitmap);
    }

    private void blurplusnaga(){

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img1);
        Bitmap blurBitmap = BlurHandle.blurhandle( getApplicationContext(),bitmap,1);
        Bitmap negativeBitmap = NegativeHandle.negativehandle(blurBitmap, getApplicationContext());
        imageView.setImageBitmap(negativeBitmap);
    }

}
