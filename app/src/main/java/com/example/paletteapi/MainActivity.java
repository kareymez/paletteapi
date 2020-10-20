package com.example.paletteapi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt1, txt2, txt3, txt4, txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Bitmap bitmap = BitmapFactory.
                decodeResource(getResources(), R.drawable.mar);
        crearPalette(bitmap);
    }
    
    private void crearPalette(Bitmap bitmap){
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {

                Palette.Swatch vibrant = palette.getVibrantSwatch();
                if(vibrant!=null){
                    txt1.setBackgroundColor(vibrant.getRgb());
                    txt1.setTextColor(vibrant.getTitleTextColor());
                    txt1.setText("Rosa");
                }
                Palette.Swatch muted = palette.getMutedSwatch();

                if(muted!=null){
                    txt2.setBackgroundColor(muted.getRgb());
                    txt2.setTextColor(vibrant.getTitleTextColor());
                    txt2.setText("Lila");
                }

                Palette.Swatch dominant = palette.getDominantSwatch();

                if(dominant!=null){
                    txt3.setBackgroundColor(dominant.getRgb());
                    txt3.setTextColor(dominant.getTitleTextColor());
                    txt3.setText("Coral");
                }

                Palette.Swatch strong = palette.getDarkMutedSwatch();

                if(strong!=null){
                    txt4.setBackgroundColor(strong.getRgb());
                    txt4.setTextColor(strong.getTitleTextColor());
                    txt4.setText("Morado");
                }

                Palette.Swatch darkMuted = palette.getDarkVibrantSwatch();

                if(vibrant!=null){
                    txt5.setBackgroundColor(darkMuted.getRgb());
                    txt5.setTextColor(darkMuted.getTitleTextColor());
                    txt5.setText("Azul");
                }

                
            }
        });
    }

    private void init() {
        this.txt1 = findViewById(R.id.txt1);
        this.txt2 = findViewById(R.id.txt2);
        this.txt3 = findViewById(R.id.txt3);
        this.txt4 = findViewById(R.id.txt4);
        this.txt5 = findViewById(R.id.txt5);
    }
}