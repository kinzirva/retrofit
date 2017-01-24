package com.kinzirva.myretrofit.util;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESC}
 * Created by kinzirva on 2017/1/23.
 */

public class NetStatusReceiverUtils {
    private static Map<Context, NetStatusReceiver> map = new HashMap<Context, NetStatusReceiver>();

    public static void register(Context context, NetStatusReceiver.NetWorkListener listener) {
        if(map.get(context)==null){
            IntentFilter filter = new IntentFilter();
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            filter.setPriority(1000);
            NetStatusReceiver receiver = new NetStatusReceiver(listener);
            map.put(context, receiver);
            context.registerReceiver(receiver, filter);
        }
    }

    public static void unRegister(Context context) {
        try {
            context.unregisterReceiver(map.get(context));
            map.remove(context);
        } catch (Exception e) {
        }
    }
}
