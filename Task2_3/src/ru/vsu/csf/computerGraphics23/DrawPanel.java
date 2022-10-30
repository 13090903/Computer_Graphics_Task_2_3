package ru.vsu.csf.computerGraphics23;

import ru.vsu.csf.computerGraphics23.drawers.*;
import ru.vsu.csf.computerGraphics23.functions.Parabola;
import ru.vsu.csf.computerGraphics23.functions.Sinusoid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static ru.vsu.csf.computerGraphics23.AdditionalFrameParabola.*;
import static ru.vsu.csf.computerGraphics23.AdditionalFrameSinusoid.*;

public class DrawPanel extends JPanel implements MouseWheelListener {
    private int currentX, currentY;
    Random rnd = new Random();
    private final ScreenConverter converter;
    private final Line ox;
    private final Line oy;
    private final Line current;
    private Point lastP;
    private final Color[] colors = new Color[]{Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.RED, Color.YELLOW};

    private final java.util.List<IFunction> currentFunctions = new ArrayList<>();

    private Timer timer;
    double time = 0;
    double dt = 0.05;

    public DrawPanel() {

        converter = new ScreenConverter(800,600, -2,2, 4, 4);
        ox = new Line(new RealPoint(-converter.getsWidth(),0), new RealPoint(converter.getsWidth(),0));
        oy = new Line(new RealPoint(0,-converter.getsHeight()), new RealPoint(0,converter.getsHeight()));
        current = new Line(new RealPoint(0,0), new RealPoint(0,0));

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(lastP != null){
                    Point curP = e.getPoint();
                    ScreenPoint delta = new ScreenPoint(curP.x - lastP.x,curP.y - lastP.y);
                    RealPoint deltaR = converter.s2r(delta);
                    converter.setX(deltaR.getX());
                    converter.setY(deltaR.getY());
                    lastP = curP;
                    repaint();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                ScreenPoint sp = new ScreenPoint(e.getX(), e.getY());
//                current.setP2(converter.s2r(sp));
//                repaint();
            }
        });

        this.addMouseWheelListener(e -> {
            int count = e.getWheelRotation();
            double base = count < 0 ? 0.99 : 1.01;
            double coef = 1;
            for (int i = Math.abs(count); i > 0 ; i--) {
                coef *= base;
            }
            converter.setWidth(converter.getWidth() * coef);
            converter.setHeight(converter.getHeight() * coef);
            repaint();
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    lastP = e.getPoint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    lastP = null;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        timer = new Timer(20, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time += dt;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        converter.setsHeight(getHeight());
        converter.setsWidth(getWidth());

        BufferedImage bi = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D biG = bi.createGraphics();
        biG.setColor(Color.WHITE);
        biG.fillRect(0,0,getWidth(),getHeight());

        LineDrawer ld = new GraphicsLineDrawer(biG);
//        LineDrawer ld = new WuLineDrawer(new GraphicsPixelDrawer(biG));
//        LineDrawer ld = new BresenhamLineDrawer(new GraphicsPixelDrawer(biG));
//        LineDrawer ld = new DDALineDrawer(new GraphicsPixelDrawer(biG));

        biG.setColor(Color.BLACK);
        /*ld.drawLine(getWidth() / 2, getHeight() / 2, currentX, currentY);*/
        drawLine(ld,converter,ox);
        drawLine(ld,converter,oy);
        drawLine(ld,converter,current);
        drawMarking(ld, converter, biG);
        if ((Acoefs.size() != 0 && Bcoefs.size() != 0 && Ccoefs.size() != 0) || (A1coefs.size() != 0 && W1coefs.size() != 0 && F1coefs.size() != 0 && C1coefs.size() != 0)) {
//            currentFunctions.clear();
            if (Objects.equals(Monolog.funcType, "Parabola")) {
                ITimeDependentParam p1P = null;
                ITimeDependentParam p2P = null;
                ITimeDependentParam p3P = null;
                if (Acoefs.size() == 4) {
                    p1P = new SinusoidTimeDependentParams(Acoefs.get(0), Acoefs.get(1), Acoefs.get(2), Acoefs.get(3));
                } else if (Acoefs.size() == 3) {
                    p1P = new SigmoidTimeDependentParams(Acoefs.get(0), Acoefs.get(1), Acoefs.get(2));
                }
                if (Bcoefs.size() == 4) {
                    p2P = new SinusoidTimeDependentParams(Bcoefs.get(0), Bcoefs.get(1), Bcoefs.get(2), Bcoefs.get(3));
                } else if (Bcoefs.size() == 3) {
                    p2P = new SigmoidTimeDependentParams(Bcoefs.get(0), Bcoefs.get(1), Bcoefs.get(2));
                }
                if (Ccoefs.size() == 4) {
                    p3P = new SinusoidTimeDependentParams(Ccoefs.get(0), Ccoefs.get(1), Ccoefs.get(2), Ccoefs.get(3));
                } else if (Ccoefs.size() == 3) {
                    p3P = new SigmoidTimeDependentParams(Ccoefs.get(0), Ccoefs.get(1), Ccoefs.get(2));
                }
                currentFunctions.add(new Parabola(p1P, p2P, p3P, colors[rnd.nextInt(7)]));
                Acoefs.clear();
                Bcoefs.clear();
                Ccoefs.clear();
            }
            if (Objects.equals(Monolog.funcType, "Sinusoid")) {
                ITimeDependentParam p1S = null;
                ITimeDependentParam p2S = null;
                ITimeDependentParam p3S = null;
                ITimeDependentParam p4S = null;
                if (A1coefs.size() == 4) {
                    p1S = new SinusoidTimeDependentParams(A1coefs.get(0), A1coefs.get(1), A1coefs.get(2), A1coefs.get(3));
                } else if (A1coefs.size() == 3) {
                    p1S = new SigmoidTimeDependentParams(A1coefs.get(0), A1coefs.get(1), A1coefs.get(2));
                }
                if (W1coefs.size() == 4) {
                    p2S = new SinusoidTimeDependentParams(W1coefs.get(0), W1coefs.get(1), W1coefs.get(2), W1coefs.get(3));
                } else if (W1coefs.size() == 3) {
                    p2S = new SigmoidTimeDependentParams(W1coefs.get(0), W1coefs.get(1), W1coefs.get(2));
                }
                if (F1coefs.size() == 4) {
                    p3S = new SinusoidTimeDependentParams(F1coefs.get(0), F1coefs.get(1), F1coefs.get(2), F1coefs.get(3));
                } else if (F1coefs.size() == 3) {
                    p3S = new SigmoidTimeDependentParams(F1coefs.get(0), F1coefs.get(1), F1coefs.get(2));
                }
                if (C1coefs.size() == 4) {
                    p4S = new SinusoidTimeDependentParams(C1coefs.get(0), C1coefs.get(1), C1coefs.get(2), C1coefs.get(3));
                } else if (C1coefs.size() == 3) {
                    p4S = new SigmoidTimeDependentParams(C1coefs.get(0), C1coefs.get(1), C1coefs.get(2));
                }
                currentFunctions.add(new Sinusoid(p1S, p2S, p3S, p4S, colors[rnd.nextInt(7)]));
                A1coefs.clear();
                W1coefs.clear();
                F1coefs.clear();
                C1coefs.clear();
            }
        }
        for (IFunction f : currentFunctions) {
            drawFunction(ld, converter, f, time);
        }

        g2d.drawImage(bi,0,0,null);
        biG.dispose();
    }

    private static void drawLine(LineDrawer ld,ScreenConverter sc, Line l){
        ScreenPoint p1 = sc.r2s(l.getP1());
        ScreenPoint p2 = sc.r2s(l.getP2());
        ld.drawLine(p1.getX(),p1.getY(), p2.getX(), p2.getY());
    }

    private static void drawMarking(LineDrawer ld,ScreenConverter sc, Graphics2D biG){
        int step = 1;
        if (sc.getWidth() > 20) {
            step = 5;
        }
        if (sc.getWidth() > 50) {
            step = 10;
        }
        if (sc.getWidth() > 200) {
            step = 20;
        }
        if (sc.getWidth() > 500) {
            step = 50;
        }
        if (sc.getWidth() > 1000) {
            step = 100;
        }
        for (int i = -sc.getsWidth(); i < sc.getsWidth(); i+=step) {
            if (i == 0) {
                RealPoint rp = new RealPoint(0.1*step, 0.1*step);
                biG.drawString(String.valueOf(i), (float) sc.r2s(rp).getX(), (float) sc.r2s(rp).getY());
            } else {
                RealPoint rp = new RealPoint(i, 0.1 * step);
                biG.drawString(String.valueOf(i), (float) sc.r2s(rp).getX(), (float) sc.r2s(rp).getY());
                drawLine(ld, sc, new Line(new RealPoint(i, -0.05 * step), new RealPoint(i, 0.05 * step)));
            }
        }
        for (int i = -sc.getsHeight(); i < sc.getsHeight(); i+=step) {
            if (i != 0) {
                RealPoint rp = new RealPoint(0.1 * step, i);
                biG.drawString(String.valueOf(i), (float) sc.r2s(rp).getX(), (float) sc.r2s(rp).getY());
                drawLine(ld, sc, new Line(new RealPoint(-0.05 * step, i), new RealPoint(0.05 * step, i)));
            }
        }
    }

    private static void drawFunction(LineDrawer ld, ScreenConverter sc, IFunction f, double t) {
        double step = sc.getWidth()/ sc.getsWidth();
        double x = sc.getX() + 0 * step;
        double y = f.compute(x, t);
        for (int i = 1; i < sc.getsWidth(); i++) {
            double x1 = sc.getX() + i * step;
            double y1 = f.compute(x, t);

            if (y1 < sc.getY() && y1 > sc.getY() - sc.getHeight()) {
                drawLine(ld, sc, new Line(new RealPoint(x, y), new RealPoint(x1, y1)));
            }
            x = x1;
            y = y1;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}

