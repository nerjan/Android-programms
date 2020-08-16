package com.example.sensory_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv1 = null;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img= (ImageView) findViewById(R.id.imageView);
        img.setImageResource(R.drawable.ise);
        img.setAdjustViewBounds(true);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setVisibility(View.GONE);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        tv1.setText("");
        for (int i = 1; i < mList.size(); i++) {
            tv1.setVisibility(View.VISIBLE);
            tv1.append("\n" + i + ". " + mList.get(i).getName() + "  " + mList.get(i).getVendor() + " " + mList.get(i).getVersion());
        }


    }
}

