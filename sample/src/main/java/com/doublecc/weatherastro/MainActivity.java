package com.doublecc.weatherastro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.doublecc.weatherastroview.WeatherAstroView;

public class MainActivity extends AppCompatActivity {

    private WeatherAstroView astroView;
    private Spinner spinner;
    private SeekBar seekBar;
    private CheckBox checkBox;
    private TextView textView;
    private String windspeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        astroView = (WeatherAstroView) findViewById(R.id.weatherAstroView);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        textView = (TextView) findViewById(R.id.text);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                windspeed = ""+seekBar.getProgress();
                textView.setText("风速："+windspeed);
                astroView.initData(windspeed,"东南","6:50","17:50","1024",checkBox.isChecked());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                astroView.initData(windspeed,"东南","6:50","17:50","1024",checkBox.isChecked());
            }
        });
    }
}
