package com.ulp.usb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import static android.Manifest.permission.READ_CALL_LOG;

public class MainActivity extends AppCompatActivity {

    private MensajeUsb msjUsb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //pedir permiso

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
        }
        //
        msjUsb = new MensajeUsb();

    }

    @Override
    protected void onResume() {

        //this.msjUsb = new MensajeUsb();
        registerReceiver(this.msjUsb, new IntentFilter("android.hardware.usb.action.USB_STATE"));
        Toast.makeText(this, "Main : "+msjUsb.estado, Toast.LENGTH_LONG).show();//uso este Toas para leer el valor del estado como chequeo

        // hacer llamada
        if(msjUsb.estado){
            Toast.makeText(this, "Llamando....", Toast.LENGTH_LONG).show();
            llamar();
        }
       //
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(msjUsb);

    }

    public void llamar(){
        String numero="0001";//uso este numero no valido para evitar la llamada real que ya probe hacerla
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+numero));
        startActivity(intent);

    }

}