package GUI;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

class Close extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

class Cal implements ActionListener {

    TextField tf, sf;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24;
    String fv, sv, op; // fv - first Value / sv - sort value / op - oparation value 
    Double fdv, sdv, total;
    MenuItem mi2;

    public Cal() {

        Frame f = new Frame();
        f.addWindowListener(new Close());
        f.setBackground(Color.BLACK);
        f.setTitle("My Calculator");
        f.setResizable(false);
        f.setSize(410, 700);
        f.setLocationRelativeTo(null); // To Make Frame Center

        // Get Fonts
        Font f1 = new Font("Arial Rounded MT", Font.CENTER_BASELINE, 30);
        Font f2 = new Font("Calibri", Font.BOLD, 25);
        Font f3 = new Font("Calibri", Font.BOLD, 50);

        // Create a Menu Bar
        MenuBar mb = new MenuBar();

        Menu m1 = new Menu("View"); // A Create a Menu
        MenuItem mi = new MenuItem("Standard"); // Create a Items
        m1.add(mi); // Add item into menu

        Menu m2 = new Menu("Edit"); // A Create a Menu
        MenuItem mi4 = new MenuItem("Save");
        mi2 = new MenuItem("Copy"); // Create a Items
        MenuItem mi3 = new MenuItem("Cut");

        m2.add(mi2); // Add item into menu
        m2.add(mi3); // Add item into menu
        m2.add(mi4); // Add item into menu

        mb.add(m1); // Add menu into Menu bar
        mb.add(m2); // Add menu into Menu bar
        f.setMenuBar(mb); // Add MenuBar into Frame

        //Create a Panel
        Panel p1 = new Panel();
        Panel p2 = new Panel();

        // Create a GridLayout
        /*(Rows/ columns/ hgap/ vgap)*/
        GridLayout gl = new GridLayout(6, 4, 10, 10);
        GridLayout g2 = new GridLayout(3, 1, 3, 3);

        // Set Grid System to Panel
        p2.setLayout(gl);
        p2.setBackground(Color.BLACK);

        p1.setLayout(g2);
        p1.setBackground(Color.BLACK);

        // create Main TextField
        tf = new TextField(16);
        tf.setFont(f3);
        tf.setEditable(false);
        tf.setForeground(Color.WHITE);
        tf.setBackground(Color.BLACK);
        tf.setText("0");
        tf.setCursor(Cursor.getDefaultCursor());

        // Create Sub Field
        sf = new TextField(10);
        sf.setFont(f2);
        sf.setEditable(false);
        sf.setForeground(Color.WHITE);
        sf.setBackground(Color.BLACK);
        sf.setCursor(Cursor.getDefaultCursor());

        // Add TextFields to Panel
        p1.add(sf);
        p1.add(tf);

        // Add panel into frame
        f.add(p1, BorderLayout.PAGE_START);
        f.add(p2, BorderLayout.CENTER);

        // Create Buttons
        Button[] btn = new Button[24];
        btn[0] = b1 = new Button("%");
        btn[1] = b2 = new Button("CE");
        btn[2] = b3 = new Button("C");
        btn[3] = b4 = new Button("<--");
        btn[4] = b5 = new Button("x²");
        btn[5] = b6 = new Button("√x");
        btn[6] = b7 = new Button("1/x");
        btn[7] = b8 = new Button("÷");
        btn[8] = b9 = new Button("7");
        btn[9] = b10 = new Button("8");
        btn[10] = b11 = new Button("9");
        btn[11] = b12 = new Button("*");
        btn[12] = b13 = new Button("4");
        btn[13] = b14 = new Button("5");
        btn[14] = b15 = new Button("6");
        btn[15] = b16 = new Button("-");
        btn[16] = b17 = new Button("1");
        btn[17] = b18 = new Button("2");
        btn[18] = b19 = new Button("3");
        btn[19] = b20 = new Button("+");
        btn[20] = b21 = new Button("+/-");
        btn[21] = b22 = new Button("0");
        btn[22] = b23 = new Button(".");
        btn[23] = b24 = new Button("=");

        // Set Button Designs
        for (int i = 0; i < 24; i++) {
            btn[i].setBackground(Color.DARK_GRAY);
            btn[i].setForeground(Color.WHITE);
            btn[i].setCursor(Cursor.getPredefinedCursor(12));
            btn[i].setFont(f1);

            p2.add(btn[i]); // Add Button into panel

            // Create Button Action
            btn[i].addActionListener(this);
        }

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent d) {
        // remove default 0
        if (tf.getText().equals("0")) {
            tf.setText("");
        }

        //Set Actions
        Object o = d.getSource();

        // Validate Buttons Values
        if (o.equals(b22 /*0*/)) {
            tf.setText(tf.getText() + b22.getLabel());
        } else if (o.equals(b17/*1*/)) {
            tf.setText(tf.getText() + b17.getLabel());
        } else if (o.equals(b18/*2*/)) {
            tf.setText(tf.getText() + b18.getLabel());
        } else if (o.equals(b19/*3*/)) {
            tf.setText(tf.getText() + b19.getLabel());
        } else if (o.equals(b13/*4*/)) {
            tf.setText(tf.getText() + b13.getLabel());
        } else if (o.equals(b14/*5*/)) {
            tf.setText(tf.getText() + b14.getLabel());
        } else if (o.equals(b15/*6*/)) {
            tf.setText(tf.getText() + b15.getLabel());
        } else if (o.equals(b9/*7*/)) {
            tf.setText(tf.getText() + b9.getLabel());
        } else if (o.equals(b10/*8*/)) {
            tf.setText(tf.getText() + b10.getLabel());
        } else if (o.equals(b11/*9*/)) {
            tf.setText(tf.getText() + b11.getLabel());

        } else if (o.equals(b20/* + */)) {
            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = b20.getLabel();
                tf.setText("");
                sf.setText(fv + op);
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b16/* - */)) {
            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = b16.getLabel();
                tf.setText("");
                sf.setText(fv + op);
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b8/* / */)) {

            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = "/";
                tf.setText("");
                sf.setText(fv + b8.getLabel());
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b12/* * */)) {

            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = b12.getLabel();
                tf.setText("");
                sf.setText(fv + op);
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b1 /* % */)) {
            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = b1.getLabel();
                tf.setText("");
                sf.setText(fv + op);
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b5 /* x² */)) {

            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = "M";
                mathOps();
                sf.setText(fv + "^" + "2" + "=");
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b6 /* √x */)) {

            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = "V";
                mathOps();
                sf.setText("√" + fv + "=");
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b7 /* 1÷x */)) {

            if (!"".equals(tf.getText())) {
                fv = tf.getText();
                op = "X";
                mathOps();
                sf.setText("1" + "/(" + fv + ")=");
            } else {
                tf.setText("0");
            }

        } else if (o.equals(b21 /* +/- */)) {
            if (!"".equals(tf.getText())) {
                //fv = tf.getText();
                // fv = tf.getText();
                tf.setText("-" + tf.getText());
                //sf.setText("-" + fv);
            } else {
                tf.setText("0");
            }
        } else if (o.equals(b3/* C */)) {
            fv = null;
            op = null;
            fdv = null;
            sdv = null;
            tf.setText("0");
            sf.setText("");

        } else if (o.equals(b2 /*CE*/)) {
            tf.setText("0");
        } else if (o.equals(b23/* . */)) {

            if (!tf.getText().contains(".")) {
                if ("".equals(tf.getText())) {
                    tf.setText("0.");
                } else {
                    tf.setText(tf.getText() + ".");
                }
            }

        } else if (o.equals(b4/* BackSpace */)) {
            int size = tf.getText().length();
            if (size <= 1) {
                tf.setText("0");
            } else {
                tf.setText(tf.getText().substring(0, size - 1));
            }
        } else if (o.equals(b24/*=*/)) {
            if (fv != null && op != null) {
                mathOps();
            } else {
                tf.setText("0");
            }
        }

        if (o.equals(mi2)) {
            String copyText = tf.getText();
            StringSelection StSel = new StringSelection(copyText);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(StSel, StSel);
        }
    }

    void mathOps() {

        sv = tf.getText();
        try {
            fdv = Double.parseDouble(fv);
            sdv = Double.parseDouble(sv);
        } catch (NumberFormatException e) {
            System.out.println(e + "(MathOps()-get fdv/sdv");
        }
        try {

            switch (op) {
                case "+":
                    total = (fdv) + (sdv);
                    break;
                case "-":
                    total = (fdv) - (sdv);
                    break;
                case "*":
                    total = (fdv) * (sdv);
                    break;
                case "/":
                    total = (fdv) / (sdv);
                    break;
                case "%":
                    total = sdv * fdv / 100;
                    break;
                case "M":
                    total = (fdv) * (fdv);
                    break;
                case "V":
                    total = Math.sqrt(fdv);
                    break;
                case "X":
                    total = 1 / (fdv);
                    break;
            }

            String totalString = Double.toString(total);

            if (totalString.endsWith(".0")) {
                tf.setText(totalString.substring(0, totalString.indexOf('.')));
            } else {
                tf.setText(totalString);
            }

            if (sv.startsWith("-")) {
                sf.setText(fv + op + "(" + sv + ")=");
            } else {
                sf.setText(fv + op + sv + "=");
            }
            op = null;

        } catch (Exception e) {
            System.out.println(e + "Math Switch");
            tf.setText("Error");
        }

    }

}

public class Calculator {

    public static void main(String[] args) {
        new Cal();
    }
}
