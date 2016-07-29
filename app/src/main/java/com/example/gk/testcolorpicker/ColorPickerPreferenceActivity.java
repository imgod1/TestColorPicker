package com.example.gk.testcolorpicker;

import android.app.Activity;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.margaritov.preference.colorpicker.ColorPickerPreference;

public class ColorPickerPreferenceActivity extends PreferenceActivity {

    public static void actionStart(Activity activity){
        Intent intent = new Intent(activity,ColorPickerPreferenceActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
        ((ColorPickerPreference) findPreference("color2")).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {

            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                Log.e("test","ColorPickerPreferenceActivity color:"+newValue.toString());
                preference.setSummary(ColorPickerPreference.convertToARGB(Integer.valueOf(String.valueOf(newValue))));
                return true;
            }

        });
        ((ColorPickerPreference) findPreference("color2")).setAlphaSliderEnabled(true);
    }
}
