package com.example.poziomica_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public static float sensorX;
    public static float x;
    public static float scale;
    final float alpha = (float) 0.8;
    public static double angle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CanvasView(this));
        SensorManager sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ORIENTATION),0,null);
    }

    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }
    public void onSensorChanged(SensorEvent event) {
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            sensorX = (alpha * sensorX + (1 - alpha) * event.values[1]);
            scale = (float) 8.0;
            angle = event.values[1] * 180/Math.PI;
        } else {
            sensorX = (alpha * sensorX + (1 - alpha) * event.values[2]);
            scale = (float) 6.0;
            angle = event.values[2] * 180/Math.PI;
        }
    }

    class CanvasView extends View {
        public CanvasView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            x = MainActivity.sensorX * scale + canvas.getWidth() / 2;
            if (x < (canvas.getWidth() / 10) + 50) {
                x = (canvas.getWidth() / 10) + 50;
            } else if (x > (9 * canvas.getWidth() / 10) - 50) {
                x = (9 * canvas.getWidth() / 10) - 50;
            }

            Paint paint = new Paint();
            paint.setARGB(100, 255, 0, 0);
            paint.setStrokeWidth(4);
            canvas.drawLine((canvas.getWidth() / 2) - 60, (canvas.getHeight() / 2) + 52, (canvas.getWidth() / 2) - 60, (canvas.getHeight() / 2) - 52, paint);
            canvas.drawLine((canvas.getWidth() / 2) + 60, (canvas.getHeight() / 2) + 52, (canvas.getWidth() / 2) + 60, (canvas.getHeight() / 2) - 52, paint);
            paint.setARGB(100, 0, 255, 0);
            canvas.drawLine(canvas.getWidth() / 10, (canvas.getHeight() / 2) - 52, 9 * canvas.getWidth() / 10, (canvas.getHeight() / 2) - 52, paint);
            canvas.drawLine(canvas.getWidth() / 10, (canvas.getHeight() / 2) + 52, 9 * canvas.getWidth() / 10, (canvas.getHeight() / 2) + 52, paint);
            canvas.drawLine(canvas.getWidth() / 10, (canvas.getHeight() / 2) - 52, canvas.getWidth() / 10, (canvas.getHeight() / 2) + 52, paint);
            canvas.drawLine(9 * canvas.getWidth() / 10, (canvas.getHeight() / 2) - 52, 9 * canvas.getWidth() / 10, (canvas.getHeight() / 2) + 52, paint);
            paint.setStrokeWidth(4);
            paint.setARGB(100, 0, 0, 255);
            canvas.drawCircle(x, canvas.getHeight() / 2, 50, paint);

            paint.setColor(Color.BLACK);
            paint.setTextSize(50);
            canvas.drawText("Aktualna wartość kąta odchylenia: " + String.format("%.1f", MainActivity.angle), 20, 50, paint);

            invalidate();
        }
    }
}