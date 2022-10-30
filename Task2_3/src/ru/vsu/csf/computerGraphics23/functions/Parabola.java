package ru.vsu.csf.computerGraphics23.functions;

import ru.vsu.csf.computerGraphics23.drawers.IFunction;
import ru.vsu.csf.computerGraphics23.drawers.ITimeDependentParam;

import java.awt.*;

public class Parabola implements IFunction {

    private ITimeDependentParam A, B, C;
    private final Color col;

    public Parabola(ITimeDependentParam a, ITimeDependentParam b, ITimeDependentParam c, Color col) {
        A = a;
        B = b;
        C = c;
        this.col = col;
    }

    @Override
    public double compute(double x, double t) {
        return A.getParamValue(t)*x*x + B.getParamValue(t)*x + C.getParamValue(t);
    }

    @Override
    public Color getColor() {
        return col;
    }
}

