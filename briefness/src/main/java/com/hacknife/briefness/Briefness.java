package com.hacknife.briefness;

import android.app.Activity;
import android.util.Log;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : Briefness
 */

public class Briefness {
    private static final String SUFFIX = "Briefnessor";

    public static Briefnessor bind(Activity target) {
        return bind(target, target);
    }

    public static Briefnessor bind(Object target, Object view) {
        Briefnessor proxyActivity = findProxyActivity(target);
        if (proxyActivity != null)
            proxyActivity.bind(target, view);
        Class<?> clazz = target.getClass();
        while (true) {
            clazz = clazz.getSuperclass();
            if (clazz.getName().startsWith("android.app.") | clazz.getName().startsWith("android.support.") | clazz.getName().startsWith("java.lang."))
                break;
            Briefnessor proxy = findProxySuperActivity(clazz);
            if (proxyActivity == null) proxyActivity = proxy;
            if (proxy != null) proxy.bind(target, view);
        }
        return proxyActivity;
    }

    private static void bind(Briefnessor briefnessor, Object source) {
        briefnessor.bind(source, null);
    }


    private static Briefnessor findProxyActivity(Object activity) {
        try {
            Class clazz = activity.getClass();
            Class briefnessClass = Class.forName(clazz.getName() + SUFFIX);
            return (Briefnessor) briefnessClass.newInstance();
        } catch (Exception e) {
        }
        Log.w("Briefness", String.format("can not find %s , something when compiler.", activity.getClass().getSimpleName() + SUFFIX));
        return null;
    }

    private static Briefnessor findProxySuperActivity(Class<?> clazz) {
        try {
            Class briefnessClass = Class.forName(clazz.getName() + SUFFIX);
            return (Briefnessor) briefnessClass.newInstance();

        } catch (Exception e) {

        }
        Log.w("Briefness", String.format("can not find %s , something when compiler.", clazz.getSimpleName() + SUFFIX));
        return null;
    }
}
