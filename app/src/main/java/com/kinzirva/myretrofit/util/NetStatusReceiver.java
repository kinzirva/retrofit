package com.kinzirva.myretrofit.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * ${DESC}
 * Created by kinzirva on 2017/1/23.
 */
public class NetStatusReceiver extends BroadcastReceiver{
    private NetWorkListener listener;
    public NetStatusReceiver(NetWorkListener listener) {
        this.listener=listener;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info=connectivityManager.getActiveNetworkInfo();
            NetManager.NetStatue status= NetManager.NetStatue.NO_WORK;
            if(info != null && info.isAvailable()) {
                if(NetManager.Net_MOBILE.equals(info.getTypeName())){
                    status= NetManager.NetStatue.MOBILE;
                } else if(NetManager.Net_WIFI.equals(info.getTypeName())){
                    status= NetManager.NetStatue.WIFI;
                }
            }
            if(listener!=null){
                listener.netWorkChange(status);
            }
        }
    }
    public void setNetListener(NetWorkListener listener){
        this.listener=listener;
    }
    public interface NetWorkListener{
        public abstract void netWorkChange(NetManager.NetStatue status);
    }
}
