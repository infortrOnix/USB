package com.ulp.usb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MensajeUsb extends BroadcastReceiver {

    boolean estado;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");


        //metodo de control de estado nuevo

        if (intent.getExtras().getBoolean("connected")) {
            estado=true;
            Toast.makeText(context, "USB Conectado", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "estado: "+estado, Toast.LENGTH_LONG).show();
        }else{
            estado=false;
            Toast.makeText(context, "USB Desconectado", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "estado: "+estado, Toast.LENGTH_LONG).show();
        }

/*
        //

       //  Metodo de verificacion de estado anterior
        boolean isUsbStateOn = intent.getBooleanExtra("state", false);
        if (isUsbStateOn){

            // handle Airplane Mode on

            Toast.makeText(context, "USB Conectado", Toast.LENGTH_LONG).show();

        } else {
            // handle Airplane Mode off

            Toast.makeText(context, "USB Desconectado", Toast.LENGTH_LONG).show();
        }

*/


    }


}
