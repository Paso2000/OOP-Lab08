 package it.unibo.oop.lab.mvcio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
       final private Controller cont = new Controller();
   

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUI() {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        JTextField txtf = new JTextField(""+cont.GetFile());
        panel1.add(txtf);
        JButton butt = new JButton("save");
        JTextArea txt = new JTextArea();
        JButton bros= new JButton("Browse..");
        panel1.setLayout(new BorderLayout());
        panel1.add(txtf,BorderLayout.CENTER);
        panel1.add(bros, BorderLayout.AFTER_LINE_ENDS);
        panel.add(txt,BorderLayout.CENTER);
        panel.add(butt,BorderLayout.SOUTH);
        panel.add(panel1,BorderLayout.NORTH);
        frame.getContentPane().add(panel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        butt.addActionListener(new ActionListener(){
       
            
            public void actionPerformed(ActionEvent e) {
                try {
                    cont.WriteOnFile(txt.getText());
                } catch (IOException e1) {
                        System.out.println("error");
                }    
            }
            
        });
        bros.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                JFileChooser f= new JFileChooser();
           
        
        if(f.showSaveDialog(f)==f.APPROVE_OPTION) {
            cont.SetFile(""+f);
            txtf.setText(""+cont.GetFile());
        }
        }
        
    });
        
        frame.setVisible(true);
        

            
            

    }
    public static void main(final String... args) {
        new SimpleGUI();
     }

}
