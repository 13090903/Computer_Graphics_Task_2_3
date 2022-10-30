package ru.vsu.csf.computerGraphics23;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalFrameSinusoid extends JDialog {
    public static List<Integer> A1coefs = new ArrayList<>();
    public static List<Integer> W1coefs = new ArrayList<>();
    public static List<Integer> F1coefs = new ArrayList<>();
    public static List<Integer> C1coefs = new ArrayList<>();
    private JTextArea A1a1Text, A1bText, A1c1Text, A1a2Text, A1wText, A1fiText, A1c2Text;
    private JTextArea W1a1Text, W1bText, W1c1Text, W1a2Text, W1wText, W1fiText, W1c2Text;
    private JTextArea F1a1Text, F1bText, F1c1Text, F1a2Text, F1wText, F1fiText, F1c2Text;
    private JTextArea C1a1Text, C1bText, C1c1Text, C1a2Text, C1wText, C1fiText, C1c2Text;

    public AdditionalFrameSinusoid(Monolog owner) {
        super(owner, "Sinusoid time dependent params", true);
        setLayout(new FlowLayout());
        setSize(450, 300);
        Font font = new Font("TimesRoman", Font.BOLD, 20);
        JLabel A = new JLabel("A:");
        A.setFont(font);
        JButton sin = new JButton("Sinusoid params");
        sin.setFont(font);
        JButton sig = new JButton("Sigmoid params");
        sig.setFont(font);
        add(A);
        add(sin);
        add(sig);
        sin.addActionListener(s -> {
            JLabel A1 = new JLabel("A:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            A1a1Text = new JTextArea("a");
            A1a1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            A1wText = new JTextArea("w");
            A1wText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            A1fiText = new JTextArea("fi");
            A1fiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            A1c1Text = new JTextArea("c");
            A1c1Text.setFont(font);
            add(A1);
            add(a);
            add(A1a1Text);
            add(w);
            add(A1wText);
            add(fi);
            add(A1fiText);
            add(c);
            add(A1c1Text);
            A.setVisible(false);
            sin.setVisible(false);
            sig.setVisible(false);
            revalidate();
            repaint();
        });
        sig.addActionListener(s -> {
            JLabel A1 = new JLabel("A:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            A1a2Text = new JTextArea("a");
            A1a2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            A1bText = new JTextArea("b");
            A1bText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            A1c2Text = new JTextArea("c");
            A1c2Text.setFont(font);
            add(A1);
            add(a);
            add(A1a2Text);
            add(b);
            add(A1bText);
            add(c);
            add(A1c2Text);
            A.setVisible(false);
            sin.setVisible(false);
            sig.setVisible(false);
            revalidate();
            repaint();
        });
        JLabel W = new JLabel("W:");
        W.setFont(font);
        JButton sin1 = new JButton("Sinusoid params");
        sin1.setFont(font);
        JButton sig1 = new JButton("Sigmoid params");
        sig1.setFont(font);
        add(W);
        add(sin1);
        add(sig1);
        sin1.addActionListener(s -> {
            JLabel A1 = new JLabel("W:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            W1a1Text = new JTextArea("a");
            W1a1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            W1wText = new JTextArea("w");
            W1wText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            W1fiText = new JTextArea("fi");
            W1fiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            W1c1Text = new JTextArea("c");
            W1c1Text.setFont(font);
            add(A1);
            add(a);
            add(W1a1Text);
            add(w);
            add(W1wText);
            add(fi);
            add(W1fiText);
            add(c);
            add(W1c1Text);
            W.setVisible(false);
            sin1.setVisible(false);
            sig1.setVisible(false);
            revalidate();
            repaint();
        });
        sig1.addActionListener(s -> {
            JLabel A1 = new JLabel("W:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            W1a2Text = new JTextArea("a");
            W1a2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            W1bText = new JTextArea("b");
            W1bText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            W1c2Text = new JTextArea("c");
            W1c2Text.setFont(font);
            add(A1);
            add(a);
            add(W1a2Text);
            add(b);
            add(W1bText);
            add(c);
            add(W1c2Text);
            W.setVisible(false);
            sin1.setVisible(false);
            sig1.setVisible(false);
            revalidate();
            repaint();
        });
        JLabel F = new JLabel("F:");
        F.setFont(font);
        JButton sin2 = new JButton("Sinusoid params");
        sin2.setFont(font);
        JButton sig2 = new JButton("Sigmoid params");
        sig2.setFont(font);
        add(F);
        add(sin2);
        add(sig2);
        sin2.addActionListener(s -> {
            JLabel A1 = new JLabel("F:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            F1a1Text = new JTextArea("a");
            F1a1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            F1wText = new JTextArea("w");
            F1wText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            F1fiText = new JTextArea("fi");
            F1fiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            F1c1Text = new JTextArea("c");
            F1c1Text.setFont(font);
            add(A1);
            add(a);
            add(F1a1Text);
            add(w);
            add(F1wText);
            add(fi);
            add(F1fiText);
            add(c);
            add(F1c1Text);
            F.setVisible(false);
            sin2.setVisible(false);
            sig2.setVisible(false);
            revalidate();
            repaint();
        });
        sig2.addActionListener(s -> {
            JLabel A1 = new JLabel("F:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            F1a2Text = new JTextArea("a");
            F1a2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            F1bText = new JTextArea("b");
            F1bText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            F1c2Text = new JTextArea("c");
            F1c2Text.setFont(font);
            add(A1);
            add(a);
            add(F1a2Text);
            add(b);
            add(F1bText);
            add(c);
            add(F1c2Text);
            F.setVisible(false);
            sin2.setVisible(false);
            sig2.setVisible(false);
            revalidate();
            repaint();
        });
        JLabel C = new JLabel("C:");
        C.setFont(font);
        JButton sin3 = new JButton("Sinusoid params");
        sin3.setFont(font);
        JButton sig3 = new JButton("Sigmoid params");
        sig3.setFont(font);
        add(C);
        add(sin3);
        add(sig3);
        sin3.addActionListener(s -> {
            JLabel A1 = new JLabel("C:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            C1a1Text = new JTextArea("a");
            C1a1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            C1wText = new JTextArea("w");
            C1wText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            C1fiText = new JTextArea("fi");
            C1fiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            C1c1Text = new JTextArea("c");
            C1c1Text.setFont(font);
            add(A1);
            add(a);
            add(C1a1Text);
            add(w);
            add(C1wText);
            add(fi);
            add(C1fiText);
            add(c);
            add(C1c1Text);
            C.setVisible(false);
            sin3.setVisible(false);
            sig3.setVisible(false);
            revalidate();
            repaint();
        });
        sig3.addActionListener(s -> {
            JLabel A1 = new JLabel("C:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            C1a2Text = new JTextArea("a");
            C1a2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            C1bText = new JTextArea("b");
            C1bText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            C1c2Text = new JTextArea("c");
            C1c2Text.setFont(font);
            add(A1);
            add(a);
            add(C1a2Text);
            add(b);
            add(C1bText);
            add(c);
            add(C1c2Text);
            C.setVisible(false);
            sin3.setVisible(false);
            sig3.setVisible(false);
            revalidate();
            repaint();
        });
        JButton submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.addActionListener(s -> {
            if (A1a1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(A1a1Text.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1a1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
                matcher = pattern.matcher(A1wText.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1wText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
                matcher = pattern.matcher(A1fiText.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1fiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
                matcher = pattern.matcher(A1c1Text.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1c1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(A1a2Text.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1a2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
                matcher = pattern.matcher(A1bText.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1bText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
                matcher = pattern.matcher(A1c2Text.getText());
                if (matcher.find()) {
                    A1coefs.add(Integer.valueOf(A1c2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    A1coefs.add(1);
                }
            }
            if (W1a1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(W1a1Text.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1a1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
                matcher = pattern.matcher(W1wText.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1wText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
                matcher = pattern.matcher(W1fiText.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1fiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
                matcher = pattern.matcher(W1c1Text.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1c1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(W1a2Text.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1a2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
                matcher = pattern.matcher(W1bText.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1bText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
                matcher = pattern.matcher(W1c2Text.getText());
                if (matcher.find()) {
                    W1coefs.add(Integer.valueOf(W1c2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    W1coefs.add(1);
                }
            }
            if (F1a1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(F1a1Text.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1a1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
                matcher = pattern.matcher(F1wText.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1wText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
                matcher = pattern.matcher(F1fiText.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1fiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
                matcher = pattern.matcher(F1c1Text.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1c1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(F1a2Text.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1a2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
                matcher = pattern.matcher(F1bText.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1bText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
                matcher = pattern.matcher(F1c2Text.getText());
                if (matcher.find()) {
                    F1coefs.add(Integer.valueOf(F1c2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    F1coefs.add(1);
                }
            }
            if (C1a1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(C1a1Text.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1a1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
                matcher = pattern.matcher(C1wText.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1wText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
                matcher = pattern.matcher(C1fiText.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1fiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
                matcher = pattern.matcher(C1c1Text.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1c1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(C1a2Text.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1a2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
                matcher = pattern.matcher(C1bText.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1bText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
                matcher = pattern.matcher(C1c2Text.getText());
                if (matcher.find()) {
                    C1coefs.add(Integer.valueOf(C1c2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    C1coefs.add(1);
                }
            }
            setVisible(false);
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }
}
