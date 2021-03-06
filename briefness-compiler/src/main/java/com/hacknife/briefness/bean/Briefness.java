package com.hacknife.briefness.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hacknife on 2018/10/31.
 */

public class Briefness {
    String layout;
    List<Method> methods;
    List<Field> fileds;
    Label label;

    public List<Field> getFileds() {
        return fileds;
    }

    public Briefness() {
        methods = new ArrayList<>();
        fileds = new ArrayList<>();
    }

    public void addField(Field field) {
        fileds.add(field);
    }

    public void addMethod(Method method) {
        methods.add(method);
    }

    public Label getLabel() {
        if (label == null)
            label = new Label();
        return label;
    }

    @Override
    public String toString() {
        return "Briefness{" +
                "layout='" + layout + '\'' +
                ", methods=" + methods +
                ", fileds=" + fileds +
                ", label=" + label +
                '}';
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }


    public String getLayout() {
        return layout;
    }

    public List<Method> getMethods() {
        return methods;
    }
}
