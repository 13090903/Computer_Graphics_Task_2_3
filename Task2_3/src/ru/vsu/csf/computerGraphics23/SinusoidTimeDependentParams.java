package ru.vsu.csf.computerGraphics23;

import ru.vsu.csf.computerGraphics23.drawers.ITimeDependentParam;

public class SinusoidTimeDependentParams implements ITimeDependentParam {
    private double a, w, fi, c;

    public SinusoidTimeDependentParams(double a, double w, double fi, double c) {
        this.a = a;
        this.w = w;
        this.fi = fi;
        this.c = c;
    }

    @Override
    public double getParamValue(double t) {
        return a*Math.sin(w*t + fi) + c;
    }
}
