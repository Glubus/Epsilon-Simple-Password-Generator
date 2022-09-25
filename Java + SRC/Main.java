import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.*;

public class Main implements ActionListener,MouseInputListener {
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JTextField textfield;
    private JTextField textfieldpasswordreceiver;
    private JCheckBox checkbox1;
    private JCheckBox checkbox2;
    private JCheckBox checkbox3;
    public static void main(String[] args){
        new Main();
        }

    public static ArrayList<String> dictionnary(Boolean A, Boolean B, Boolean C) {
        ArrayList<String> Dict = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
                        "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        if (C==true){
                Collections.addAll(Dict, "!","#","$","%","&","*","+","-",".","/",":",";","<","=",">","@","^","_","|","~");
        }
        if (A==true){
            Collections.addAll(Dict, "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
        }
        if (B==true){
            Collections.addAll(Dict, "1","2","3","4","5","6","7","8","9","0");
        }
        return Dict;
    }
    public static String generator(ArrayList<String> Tableau, int x){
        String otp = "";
        int o = 0;
        for (int i = 0; i < x; i++){
            o = (int)(Math.random()*Tableau.size())+0;
            otp = otp + Tableau.get(o);
        }
        return otp;
    }

    public Main() {
        Font font1 = new Font("poppins", Font.BOLD, 20); 
        Font LabelMain = new Font("poppins", Font.PLAIN, 29); 
        Font font2 = new Font("poppins", Font.PLAIN, 20);      
        frame = new JFrame();
        JButton button = new JButton("Submit");
        button.setLocation(442, 410);
        button.setSize(150, 50);
        button.setFont(font2);
        button.setForeground(Color.white);
        button.setBorderPainted(false);
        button.setBackground(Color.decode("#121212"));
        button.addActionListener(this);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.decode("#808080"), 3));
        label = new JLabel();
        panel = new JPanel();
        JLabel otherlabel= new JLabel("How many character ?");
        otherlabel.setLocation(450, 225);
        otherlabel.setSize(280, 75);
        otherlabel.setFont(font2);
        otherlabel.setForeground(Color.white);

        panel.setBackground(Color.black);

        checkbox1 = new JCheckBox("Want Uppercase ? (A,B,C,...)");
        checkbox1.setLocation(380, 295);
        checkbox1.setSize(300, 30);
        checkbox1.setFont(font2);
        checkbox1.setForeground(Color.white);
        checkbox1.setBorderPainted(false);
        checkbox1.setBackground(Color.black);
        checkbox1.setOpaque(false);

        checkbox2 = new JCheckBox("Want Numbers ? (1,2,3,...)");
        checkbox2.setLocation(380, 330);
        checkbox2.setSize(300, 30);
        checkbox2.setFont(font2);
        checkbox2.setForeground(Color.white);
        checkbox2.setBorderPainted(false);
        checkbox2.setBackground(Color.black);
        checkbox2.setOpaque(false);

        checkbox3 = new JCheckBox("Want Spe_Character ? (!,/,...)");
        checkbox3.setLocation(380, 365);
        checkbox3.setSize(300, 30);
        checkbox3.setFont(font2);
        checkbox3.setForeground(Color.white);
        checkbox3.setBorderPainted(false);
        checkbox3.setBackground(Color.black);
        checkbox3.setOpaque(false);

        JLabel MainLabel = new JLabel("Password Generator");
        MainLabel.setLocation(380, 80);
        MainLabel.setSize(300, 75);
        MainLabel.setFont(LabelMain);
        MainLabel.setForeground(Color.white);
        MainLabel.addMouseListener(this);
        
        textfieldpasswordreceiver = new JTextField("");
        textfieldpasswordreceiver.setLocation(380, 180);
        textfieldpasswordreceiver.setSize(300, 42);
        textfieldpasswordreceiver.setFont(font1);
        textfieldpasswordreceiver.setHorizontalAlignment(JTextField.CENTER);
        textfieldpasswordreceiver.setBorder(BorderFactory.createLineBorder(Color.decode("#808080"), 3));
        textfieldpasswordreceiver.setBackground(Color.decode("#121212"));
        textfieldpasswordreceiver.setForeground(Color.white);
        textfieldpasswordreceiver.setEditable(false);
        textfieldpasswordreceiver.addMouseListener(this);

        textfield = new JTextField("");
        textfield.setLocation(380, 240);
        textfield.setSize(50,42);
        textfield.setFont(font1);
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setBorder(BorderFactory.createLineBorder(Color.decode("#808080"),3));
        textfield.setBackground(Color.decode("#121212"));
        textfield.setForeground(Color.white);

        frame.add(MainLabel);
        frame.setResizable(false);
        panel.setBorder(BorderFactory.createEmptyBorder(284, 512, 284, 512));
        panel.setLayout(new GridLayout(0,1));
        frame.add(button);
        frame.add(label);
        frame.add(textfield);
        frame.add(otherlabel);
        frame.add(checkbox1);
        frame.add(checkbox2);
        frame.add(textfieldpasswordreceiver);
        frame.add(checkbox3);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Epsilon's Simple Password Generator (Java)");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String test = textfield.getText();
        try {
            int u = Integer.parseInt(test);
            ArrayList<String> dict = dictionnary(checkbox1.isSelected(), checkbox2.isSelected(), checkbox3.isSelected());
            textfieldpasswordreceiver.setText(generator(dict, u));}
        catch (NumberFormatException ex){
            label.setText("Not Integer ");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String test = textfieldpasswordreceiver.getText();
        StringSelection yo = new StringSelection(test);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(yo, null);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}