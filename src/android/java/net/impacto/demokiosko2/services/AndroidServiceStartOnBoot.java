package net.impacto.demokiosko2.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AndroidServiceStartOnBoot extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("***********************************");
        System.out.println("Servicio iniciado automaticamente");
    }

}