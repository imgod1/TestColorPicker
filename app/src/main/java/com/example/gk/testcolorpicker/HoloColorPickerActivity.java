package com.example.gk.testcolorpicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.larswerkman.holocolorpicker.ColorPicker;

import net.margaritov.preference.colorpicker.ColorPickerView;

public class HoloColorPickerActivity extends AppCompatActivity {
    private ColorPicker picker;

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, HoloColorPickerActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holo_color_picker);
        picker = (ColorPicker) findViewById(R.id.picker);
        picker.setColor(Color.BLACK);
        picker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                Log.e("test", "HoloColorPickerActivity color:" + color);
            }
        });
    }
}
