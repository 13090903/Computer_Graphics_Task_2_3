package ru.vsu.csf.computerGraphics23;

import ru.vsu.csf.computerGraphics23.drawers.ITimeDependentParam;

public class SigmoidTimeDependentParams implements ITimeDependentParam {
    private double a, b, c;

    public SigmoidTimeDependentParams(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getParamValue(double t) {
        return a*1/(1 + Math.exp(-b*t)) + c;
    }
}
