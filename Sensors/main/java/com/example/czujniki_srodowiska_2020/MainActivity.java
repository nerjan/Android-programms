package com.example.czujniki_srodowiska_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mCisnienie;
    private Sensor mSwiatlo;
    private Sensor mTemperatura_Otoczenia;
    private Sensor mWilgotnosc_Otoczenia;



    public  float cisnienie_w_milibarach;
    public  float swiatlo_w_luksach;
    public  float temperatura_w_stopniach;
    public  float wilgotnosc_w_procentach;
    public  float punkt_rosy;
    public  float wilgotnosc_bezwzgledna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mCisnienie = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSwiatlo = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mTemperatura_Otoczenia = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mWilgotnosc_Otoczenia = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //   this.millibars_of_pressure = event.values[0];
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {
            EditText w_cisnienia=(EditText)findViewById(R.id.wartosc_cisnienia);
            cisnienie_w_milibarach=event.values[0];
            w_cisnienia.setText( String.format("Wartość cisnienie w milibarach = %.2f", cisnienie_w_milibarach));
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            EditText w_swiatlo = (EditText) findViewById(R.id.wartosc_swiatlo);
            swiatlo_w_luksach = event.values[0];
            w_swiatlo.setText(String.format("Wartość nateżenia światła w luksach = %.2f", swiatlo_w_luksach));
        }
        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            EditText w_temperatura = (EditText) findViewById(R.id.wartosc_temperatura);
            temperatura_w_stopniach = event.values[0];
            w_temperatura.setText(String.format("Wartość temperatury w stopniach C = %.2f", temperatura_w_stopniach));
        }
        if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY) {
            EditText w_wilgotnosc = (EditText) findViewById(R.id.wartosc_wilgotnosc);
            wilgotnosc_w_procentach = event.values[0];
            w_wilgotnosc.setText(String.format("Wartość wilgotności wzglednej = %.2f", wilgotnosc_w_procentach));
        }
        if (event.sensor.getType() == Sensor.TYPE_RELATIVE_HUMIDITY || event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            EditText w_punkt_rosy = (EditText) findViewById(R.id.wartosc_punkt_rosy);
            punkt_rosy = obliczaniePunktuRosy();
            w_punkt_rosy.setText(String.format("Wartość punktu rosy = %.2f", punkt_rosy));

            EditText w_wilgotnosc_bezwzgledna = (EditText) findViewById(R.id.wartosc_wilgotnosc_bezwzgledna);
            wilgotnosc_bezwzgledna = obliczanieWilgotnosciBezwzglednej();
            w_wilgotnosc_bezwzgledna.setText(String.format("Wartość wilgotności bezwzglednej = %.2f", wilgotnosc_bezwzgledna));
        }

        //System.err.print("Swiatła: "+event.values[0]);
        // TextView textViewToChange = (TextView) findViewById(R.id.mainValue);
        // textViewToChange.setText(event.values[0] + "");
    }

    public float obliczaniePunktuRosy()
    {
        return (float) (Math.pow(wilgotnosc_w_procentach / 100, 1 / 8) * (112 + (0.9 * temperatura_w_stopniach)) + (0.1 * temperatura_w_stopniach) - 112);
    }

    public float obliczanieWilgotnosciBezwzglednej()
    {
        return (float) (216.7 * (wilgotnosc_w_procentach/100 * 6.112 * Math.exp(17.62 * temperatura_w_stopniach/(243.12 + temperatura_w_stopniach)))/(273.15 + temperatura_w_stopniach));
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mCisnienie, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mSwiatlo, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mTemperatura_Otoczenia, SensorManager.SENSOR_DELAY_NORMAL);
        //  mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY) != null){
            // Istnieje sensor wilgotności
            mSensorManager.registerListener(this, mWilgotnosc_Otoczenia, SensorManager.SENSOR_DELAY_UI);
        }
        else {
            // Brak sensora wilgotności.
            EditText w_wilgotnosc = (EditText) findViewById(R.id.wartosc_wilgotnosc);

            w_wilgotnosc.setText("Brak sensora wilgotności");
        }

    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
