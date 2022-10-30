package ru.vsu.csf.computerGraphics23;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalFrameParabola extends JDialog {
    public static List<Integer> Acoefs = new ArrayList<>();
    public static List<Integer> Bcoefs = new ArrayList<>();
    public static List<Integer> Ccoefs = new ArrayList<>();
    private JTextArea Aa1Text, AbText, Ac1Text, Aa2Text, AwText, AfiText, Ac2Text;
    private JTextArea Ba1Text, BbText, Bc1Text, Ba2Text, BwText, BfiText, Bc2Text;
    private JTextArea Ca1Text, CbText, Cc1Text, Ca2Text, CwText, CfiText, Cc2Text;

    public AdditionalFrameParabola(Monolog owner) {
        super(owner, "Parabola time dependent params", true);
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
            Aa1Text = new JTextArea("a");
            Aa1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            AwText = new JTextArea("w");
            AwText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            AfiText = new JTextArea("fi");
            AfiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Ac1Text = new JTextArea("c");
            Ac1Text.setFont(font);
            add(A1);
            add(a);
            add(Aa1Text);
            add(w);
            add(AwText);
            add(fi);
            add(AfiText);
            add(c);
            add(Ac1Text);
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
            Aa2Text = new JTextArea("a");
            Aa2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            AbText = new JTextArea("b");
            AbText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Ac2Text = new JTextArea("c");
            Ac2Text.setFont(font);
            add(A1);
            add(a);
            add(Aa2Text);
            add(b);
            add(AbText);
            add(c);
            add(Ac2Text);
            A.setVisible(false);
            sin.setVisible(false);
            sig.setVisible(false);
            revalidate();
            repaint();
        });
        JLabel B = new JLabel("B:");
        B.setFont(font);
        JButton sin1 = new JButton("Sinusoid params");
        sin1.setFont(font);
        JButton sig1 = new JButton("Sigmoid params");
        sig1.setFont(font);
        add(B);
        add(sin1);
        add(sig1);
        sin1.addActionListener(s -> {
            JLabel A1 = new JLabel("B:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            Ba1Text = new JTextArea("a");
            Ba1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            BwText = new JTextArea("w");
            BwText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            BfiText = new JTextArea("fi");
            BfiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Bc1Text = new JTextArea("c");
            Bc1Text.setFont(font);
            add(A1);
            add(a);
            add(Ba1Text);
            add(w);
            add(BwText);
            add(fi);
            add(BfiText);
            add(c);
            add(Bc1Text);
            B.setVisible(false);
            sin1.setVisible(false);
            sig1.setVisible(false);
            revalidate();
            repaint();
        });
        sig1.addActionListener(s -> {
            JLabel A1 = new JLabel("B:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            Ba2Text = new JTextArea("a");
            Ba2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            BbText = new JTextArea("b");
            BbText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Bc2Text = new JTextArea("c");
            Bc2Text.setFont(font);
            add(A1);
            add(a);
            add(Ba2Text);
            add(b);
            add(BbText);
            add(c);
            add(Bc2Text);
            B.setVisible(false);
            sin1.setVisible(false);
            sig1.setVisible(false);
            revalidate();
            repaint();
        });
        JLabel C = new JLabel("C:");
        C.setFont(font);
        JButton sin2 = new JButton("Sinusoid params");
        sin2.setFont(font);
        JButton sig2 = new JButton("Sigmoid params");
        sig2.setFont(font);
        add(C);
        add(sin2);
        add(sig2);
        sin2.addActionListener(s -> {
            JLabel A1 = new JLabel("C:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            Ca1Text = new JTextArea("a");
            Ca1Text.setFont(font);
            JLabel w = new JLabel("w:");
            w.setFont(font);
            CwText = new JTextArea("w");
            CwText.setFont(font);
            JLabel fi = new JLabel("fi:");
            fi.setFont(font);
            CfiText = new JTextArea("fi");
            CfiText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Cc1Text = new JTextArea("c");
            Cc1Text.setFont(font);
            add(A1);
            add(a);
            add(Ca1Text);
            add(w);
            add(CwText);
            add(fi);
            add(CfiText);
            add(c);
            add(Cc1Text);
            C.setVisible(false);
            sin2.setVisible(false);
            sig2.setVisible(false);
            revalidate();
            repaint();
        });
        sig2.addActionListener(s -> {
            JLabel A1 = new JLabel("C:");
            A1.setFont(font);
            JLabel a = new JLabel("a:");
            a.setFont(font);
            Ca2Text = new JTextArea("a");
            Ca2Text.setFont(font);
            JLabel b = new JLabel("b:");
            b.setFont(font);
            CbText = new JTextArea("b");
            CbText.setFont(font);
            JLabel c = new JLabel("c:");
            c.setFont(font);
            Cc2Text = new JTextArea("c");
            Cc2Text.setFont(font);
            add(A1);
            add(a);
            add(Ca2Text);
            add(b);
            add(CbText);
            add(c);
            add(Cc2Text);
            C.setVisible(false);
            sin2.setVisible(false);
            sig2.setVisible(false);
            revalidate();
            repaint();
        });
        JButton submit = new JButton("Submit");
        submit.setFont(font);
        add(submit);
        submit.addActionListener(s -> {
            if (Aa1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Aa1Text.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(Aa1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
                matcher = pattern.matcher(AwText.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(AwText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
                matcher = pattern.matcher(AfiText.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(AfiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
                matcher = pattern.matcher(Ac1Text.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(Ac1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Aa2Text.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(Aa2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
                matcher = pattern.matcher(AbText.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(AbText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
                matcher = pattern.matcher(Ac2Text.getText());
                if (matcher.find()) {
                    Acoefs.add(Integer.valueOf(Ac2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Acoefs.add(1);
                }
            }
            if (Ba1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Ba1Text.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(Ba1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
                matcher = pattern.matcher(BwText.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(BwText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
                matcher = pattern.matcher(BfiText.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(BfiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
                matcher = pattern.matcher(Bc1Text.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(Bc1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Ba2Text.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(Ba2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
                matcher = pattern.matcher(BbText.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(BbText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
                matcher = pattern.matcher(Bc2Text.getText());
                if (matcher.find()) {
                    Bcoefs.add(Integer.valueOf(Bc2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Bcoefs.add(1);
                }
            }
            if (Ca1Text != null) {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Ca1Text.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(Ca1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
                matcher = pattern.matcher(CwText.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(CwText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
                matcher = pattern.matcher(CfiText.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(CfiText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
                matcher = pattern.matcher(Cc1Text.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(Cc1Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
            } else {
                Pattern pattern = Pattern.compile("^\\d+");
                Matcher matcher = pattern.matcher(Ca2Text.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(Ca2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
                matcher = pattern.matcher(CbText.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(CbText.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
                }
                matcher = pattern.matcher(Cc2Text.getText());
                if (matcher.find()) {
                    Ccoefs.add(Integer.valueOf(Cc2Text.getText().substring(matcher.start(), matcher.end())));
                } else {
                    Ccoefs.add(1);
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
