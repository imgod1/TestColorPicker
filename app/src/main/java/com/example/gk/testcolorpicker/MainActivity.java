package com.example.gk.testcolorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gk.testcolorpicker.views.ColorPickerDialog;
import com.larswerkman.holocolorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_holo_color_picker;
    private Button btn_color_picker_dialog;
    private Button btn_color_picker_preference;
    private Button btn_color_picker_preference_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_holo_color_picker = (Button) findViewById(R.id.btn_holo_color_picker);
        btn_color_picker_dialog = (Button) findViewById(R.id.btn_color_picker_dialog);
        btn_color_picker_preference = (Button) findViewById(R.id.btn_color_picker_preference);
        btn_color_picker_preference_view = (Button) findViewById(R.id.btn_color_picker_preference_view);
        btn_holo_color_picker.setOnClickListener(this);
        btn_color_picker_dialog.setOnClickListener(this);
        btn_color_picker_preference.setOnClickListener(this);
        btn_color_picker_preference_view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_holo_color_picker:
                HoloColorPickerActivity.actionStart(MainActivity.this);
                break;
            case R.id.btn_color_picker_dialog:
                showColorDialog();
                break;
            case R.id.btn_color_picker_preference:
                ColorPickerPreferenceActivity.actionStart(MainActivity.this);
                break;
            case R.id.btn_color_picker_preference_view:
                PreferenceViewActivity.actionStart(MainActivity.this);
                break;
        }
    }

    private void showColorDialog() {
        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(MainActivity.this, new ColorPickerDialog.OnColorChangedListener() {
            @Override
            public void colorChanged(int color) {
                Log.e("test", "color:" + color);
                btn_color_picker_dialog.setBackgroundColor(color);
            }
        }, Color.BLUE);
        colorPickerDialog.show();
    }
}
