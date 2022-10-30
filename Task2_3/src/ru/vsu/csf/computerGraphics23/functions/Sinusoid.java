package ru.vsu.csf.computerGraphics23.functions;

import ru.vsu.csf.computerGraphics23.drawers.IFunction;
import ru.vsu.csf.computerGraphics23.drawers.ITimeDependentParam;

import java.awt.*;

public class Sinusoid implements IFunction {
    private ITimeDependentParam A, W, F, C;
    private final Color col;

    public Sinusoid(ITimeDependentParam a, ITimeDependentParam w, ITimeDependentParam f, ITimeDependentParam c, Color col) {
        A = a;
        W = w;
        F = f;
        C = c;
        this.col = col;
    }

    @Override
    public Color getColor() {
        return col;
    }

    @Override
    public double compute(double x, double t) {
        return A.getParamValue(t)*Math.sin(W.getParamValue(t)*x + F.getParamValue(t)) + C.getParamValue(t);
    }
}
