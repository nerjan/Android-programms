package com.example.ks_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private TextView textViewResult;
    private EditText editTextKm;
    private EditText editTextPrice;
    private EditText editTextZl;
    private Button btnResult;
    private Button btnHelp;
    private Button btnView;
    private Button btnEnd;
    private Button btnWzory;
    private Button btnReturn;
    private Float num1;
    private Float num2;
    private Float num3;
    private Float num4;
    private Float eq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        editTextKm = (EditText) findViewById(R.id.editTextKm);
        editTextZl = (EditText) findViewById(R.id.editTextZl);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnView = (Button) findViewById((R.id.btnView));
        btnWzory = (Button) findViewById((R.id.btnWzory));
        if (view == btnResult) Result();
        if (view == btnView) sposobObliczania(view);
        if (view == btnHelp) helpClick(view);
        if (view == btnEnd) EndClick(view);
        if (view == btnWzory) wzoryClick(view);
    }

    public void wzoryClick(View view) {
        setContentView(R.layout.wzory);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        TextView wzory = (TextView) findViewById(R.id.text);
        wzory.setText("\n\nWartość tankowania\n------------------------------------\n Cena za litr                            * 100 = Spalanie(l/100km)\n------------------------------------\nIlość przejechanych km\n" +
                "\n\nOtrzymany wynik wyświetlamy z doładnością co do 2 miejsc po przecinku.");
    }

    public void Result() {
        if (editTextZl.length() == 0) {
            num1 = 0F;
        } else {
            num1 = Float.parseFloat(editTextZl.getText().toString());
        }
        if (editTextPrice.length() == 0) {
            num2 = 0F;
        } else {
            num2 = Float.parseFloat(editTextPrice.getText().toString());
        }
        if (editTextKm.length() == 0) {
            num3 = 0F;
        } else {
            num3 = Float.parseFloat(editTextKm.getText().toString());
        }
        num4 = num1 / num2 / num3;
        eq = num4 * 100;

        textViewResult.setText(String.format("= %.2f", eq));
    }

    public void helpClick(View view) {
        setContentView(R.layout.help);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        //btnReturn.setOnClickListener(this);
        TextView helper = (TextView) findViewById(R.id.text);
        helper.setText("Sposób obliczania spalania paliwa\n\n" +
                "Wartość tankowania w złotówkach jest dzielona przez cenę litra co daje liczbę zatankowanych litrów\n" +
                "Liczba zatankowanych litrów jest dzielona przez liczbę kilometrów\n" +
                "Wynik tego dzielenia mnoży się przez 100 aby uzyskać wynik z dwoma miejscami po przecinku\n");
    }

    public void sposobObliczania(View view) {
        setContentView(R.layout.sposob_obliczania);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        TextView sposobObliczania = (TextView) findViewById(R.id.text);
        sposobObliczania.setText("\n\n (Wartość tankowania / Cena za litr / Ilość przejechanych km) * 100\n" +
                "Otrzymany wynik wyświetlamy z doładnością co do 2 miejsc po przecinku.");
    }


    public void returnClick(View view) {
        setContentView(R.layout.activity_main);
    }
    public void EndClick(View view) {
        //  finish();
        System.exit(0);
    }
}
