package com.example.android.smartwifi.sync;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.android.smartwifi.MainActivity;
import com.example.android.smartwifi.R;
import com.example.android.smartwifi.data.SMARTWifiPreferences;
import com.example.android.smartwifi.utilities.NotificationUtils;
import com.example.android.smartwifi.utilities.WifiGeoUtils;

/**
 * Created by jtwyp6 on 10/21/17.
 */

public class SMARTWifiSyncTask{
    public static final String ACTION_WIFI_THRESHOLD = "wifi-threshold";
    public static final String ACTION_DISMISS_PRIORITY_WIFI_THRESHOLD = "priority-wifi-dismiss-threshold";
    public static final String ACTION_SWITCH_PRIORITY_WIFI_THRESHOLD = "priority-wifi-switch-threshold";
    public static final String ACTION_WIFI_ON = "wifi-on";
    public static WifiGeoUtils wifiGeoUtils;
    public static boolean pref_threshold;


    public static void executeTask(Context context, String action) {
        if (ACTION_SWITCH_PRIORITY_WIFI_THRESHOLD.equals(action)) {
            handleWifiThreshold(context);
        }else if (ACTION_DISMISS_PRIORITY_WIFI_THRESHOLD.equals(action)){
            NotificationUtils.clearAllNotifications(context);
        }else if (ACTION_WIFI_ON.equals(action)){
            try {
                    startMonitoringBecauseWifiOn(context);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startMonitoringBecauseWifiOn(Context context) throws InterruptedException {

        //Monitoring

        //SETUP PREFERENCES
        pref_threshold = SMARTWifiPreferences.isThresholdEnabled(context);

        //CREATE GEOUTILS
        wifiGeoUtils = new WifiGeoUtils(context);
        Log.d("Threshold Enabled", String.valueOf(pref_threshold));

        //if wifi is on, start location tracking
        //if data logging is on
        if(wifiGeoUtils.wifiManager.isWifiEnabled())
            wifiGeoUtils.startLocationTracking();

        while(wifiGeoUtils.wifiManager.isWifiEnabled()){
            Log.d("MAIN TASK", "While Enabled");
            WifiInfo wifiInfo = wifiGeoUtils.getConnectionInfo();
            Log.d("MAIN TASK", wifiInfo.toString());
            wifiGeoUtils.getLocation();
            if(pref_threshold){
                wifiGeoUtils.thresholdMonitor();
                Log.d("Threshold Enabled", "While Enabled");


            }
            Thread.sleep(1000);
        }
        //after wifi is disabled stop tracking
        wifiGeoUtils.stopLocationTracking();
        //while wifi is enable run code here.
    }




    private static void handleWifiThreshold(Context context) {
        //PreferenceUtilities.incrementWaterCount(context);
        Log.d("LETS GET TO WORK DAWG", "we doing background shit meow");
        NotificationUtils.clearAllNotifications(context);
    }

}
