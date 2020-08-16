package com.example.uprawnienia_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.Manifest;


public class MainActivity extends AppCompatActivity {

    static final Integer LOCATION = 0x1;
    static final Integer CALL = 0x2;
    static final Integer WRITE_EXST = 0x3;
    static final Integer READ_EXST = 0x4;
    static final Integer CAMERA = 0x5;
    static final Integer ACCOUNTS = 0x6;
    static final Integer GPS_SETTINGS = 0x7;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gps = (Button)findViewById(R.id.lokalizacja);
        Button zapisSD = (Button)findViewById(R.id.write);
        Button odczytSD = (Button)findViewById(R.id.read);
        Button call = (Button)findViewById(R.id.call);
        Button camera = (Button)findViewById(R.id.camera);
        Button accounts = (Button)findViewById(R.id.accounts);
        //Button gps_settings = (Button)findViewById(R.id.gps_settings);


        gps.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // Jeżeli uprawnienia dla naszej aplikacji nie są nadane to pokazywane jest stosowne zapytanie
                        // metoda shouldShowRequestPermissionRationale zwraca true jeżeli użytkownik nie podjął decyzji
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                            // Jeżeli uprawnienie nie zostały nadane
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION);
                        } else {
                            //Metoda requestPermissions jest wywoływana aby uzytkownik mógł podjąć decyzję o nadaniu uprawnien
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.ACCESS_FINE_LOCATION + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        zapisSD.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXST);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXST);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.WRITE_EXTERNAL_STORAGE + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        odczytSD.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXST);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXST);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.READ_EXTERNAL_STORAGE + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CALL_PHONE)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.CALL_PHONE + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.CAMERA + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        accounts.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.GET_ACCOUNTS)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.GET_ACCOUNTS}, ACCOUNTS);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.GET_ACCOUNTS}, ACCOUNTS);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.GET_ACCOUNTS + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        accounts.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.GET_ACCOUNTS)) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.GET_ACCOUNTS}, ACCOUNTS);
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.GET_ACCOUNTS}, ACCOUNTS);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, " " + Manifest.permission.GET_ACCOUNTS + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

//        gps_settings.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View v) {
//                if (Build.VERSION.SDK_INT >= 23) {
//                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.GET_ACCOUNTS)) {
//                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, GPS_SETTINGS);
//                        } else {
//                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, GPS_SETTINGS);
//                        }
//                    } else {
//                        Toast.makeText(MainActivity.this, " " + Manifest.permission.ACCESS_COARSE_LOCATION + " uprawnienia zostały przyznane.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
    }




    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(),"Odpowiedź uzytkownika pozytywna uprawnienia nadane",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),"Odpowiedź uzytkownika negatywna brak uprawnień",Toast.LENGTH_LONG).show();
        }
    }

    public void ask(View view) {

    }


}
