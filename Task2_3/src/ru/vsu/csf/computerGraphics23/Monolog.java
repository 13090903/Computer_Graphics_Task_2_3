package ru.vsu.csf.computerGraphics23;

import javax.swing.*;

public class Monolog extends JDialog {
    private JPanel contentPane;
    private JButton buttonParabola;
    private JButton buttonSinusoid;
    public static String funcType;
    private JButton buttonOK;

    public Monolog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonParabola.addActionListener(s -> {
            new AdditionalFrameParabola(this);
            funcType = "Parabola";
        });
        buttonSinusoid.addActionListener(s -> {
            new AdditionalFrameSinusoid(this);
            funcType = "Sinusoid";
        });
        pack();
    }

    public static void main(String[] args) {
        Monolog dialog = new Monolog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);

    }
}
