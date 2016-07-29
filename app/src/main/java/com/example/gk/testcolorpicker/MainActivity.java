package com.example.gk.testcolorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.gk.testcolorpicker.views.ColorPickerDialog;
import com.larswerkman.holocolorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_main;
    private ColorPicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        txt_main = (TextView) findViewById(R.id.txt_main);
        txt_main.setOnClickListener(this);
        picker = (ColorPicker) findViewById(R.id.picker);
        picker.setColor(Color.BLACK);
        picker.setOnColorSelectedListener(new ColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int color) {
                Log.e("test", "color:" + color);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_main:
                showColorDialog();
                break;
        }
    }

    private void showColorDialog() {
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(MainActivity.this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(int color) {
                Log.e("test", "color:" + color);
                txt_main.setBackgroundColor(color);
            }
        }, Color.BLUE);
        colorPickerDialog.show();
    }
}
