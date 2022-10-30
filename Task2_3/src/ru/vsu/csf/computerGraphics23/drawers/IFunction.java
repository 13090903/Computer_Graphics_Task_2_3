package ru.vsu.csf.computerGraphics23.drawers;

import java.awt.*;

public interface IFunction {
    Color getColor();
    double compute(double x, double t);
}
