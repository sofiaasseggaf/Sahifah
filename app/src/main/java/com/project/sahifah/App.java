package com.project.sahifah;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;

import com.project.sahifah.broadcastReceiver.ConnectivityReceiver;
import com.project.sahifah.broadcastReceiver.NetworkStateChangeReceiver;

import static android.net.ConnectivityManager.CONNECTIVITY_ACTION;

public class App extends Application {

    private static App mInstance;

    private static final String WIFI_STATE_CHANGE_ACTION = "android.net.wifi.WIFI_STATE_CHANGED";

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        registerForNetworkChangeEvents(this);
    }

    public static void registerForNetworkChangeEvents(final Context context) {
        NetworkStateChangeReceiver networkStateChangeReceiver = new NetworkStateChangeReceiver();
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(CONNECTIVITY_ACTION));
        context.registerReceiver(networkStateChangeReceiver, new IntentFilter(WIFI_STATE_CHANGE_ACTION));
    }

    public static synchronized App getInstance(){
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener){
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
