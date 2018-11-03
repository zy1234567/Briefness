// Generated by BriefnessProcessor (https://github.com/hacknife/Briefness).
// This class and method can not be confused and modified !!
package com.hacknife.demo.briefness;

import android.view.View;
import android.widget.TextView;

import com.hacknife.demo.bean.TextColor;
import com.hacknife.demo.bean.ViewState;

/**
 * author  : Hacknife
 * e-mail  : 4884280@qq.com
 * github  : http://github.com/hacknife
 * project : Briefness
 */
public class ViewInjector {
    public static boolean injector(View view, Object value) {
        if (view instanceof View && value instanceof ViewState) {
            view.setVisibility(value == ViewState.SHOW ? View.VISIBLE : View.GONE);
            return true;
        } else if (view instanceof TextView && value instanceof TextColor) {
            ((TextView) view).setTextColor(view.getResources().getColor(((TextColor) value).getColor()));
            return true;
        } else {
            return false;
        }
    }
}
