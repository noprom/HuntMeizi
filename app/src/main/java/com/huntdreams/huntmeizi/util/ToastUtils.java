package com.huntdreams.huntmeizi.util;

import android.content.Context;
import android.widget.Toast;

import com.huntdreams.huntmeizi.App;

/**
 * Created by drakeet on 9/27/14.
 */
public class ToastUtils {

    Context mContext;

    private ToastUtils() {
    }

    private static void show(Context context, int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    private static void show(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    public static void showShort(int resId) {
        Toast.makeText(App.getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(String message) {
        Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(int resId) {
        Toast.makeText(App.getContext(), resId, Toast.LENGTH_LONG).show();
    }

    public static void showLong(String message) {
        Toast.makeText(App.getContext(), message, Toast.LENGTH_LONG).show();
    }

}
