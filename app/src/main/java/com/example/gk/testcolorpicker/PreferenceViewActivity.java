package com.example.gk.testcolorpicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import net.margaritov.preference.colorpicker.ColorPickerView;

public class PreferenceViewActivity extends AppCompatActivity {
    private ColorPickerView colorpickview;
    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, PreferenceViewActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference_view);
        colorpickview = (ColorPickerView) findViewById(R.id.colorpickview);
        colorpickview.setColor(Color.BLACK);
        colorpickview.setTag("landscape");
        colorpickview.setOnColorChangedListener(new ColorPickerView.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {
                Log.e("test","color view:"+color);
            }
        });
    }
}
