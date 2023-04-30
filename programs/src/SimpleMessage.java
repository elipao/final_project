import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class simply contains a JAVA AWT based pop-up that simply displays a user entry and has an "OK"
 * button that when pressed hides the frame.
 * The entry can be customized through a method defined in the class.
 */
public class SimpleMessage extends JFrame implements ActionListener{
    private JLabel message;
    private JButton okB;
    private String messageSelection = null;

    public SimpleMessage(){
        JPanel panel = new JPanel();
        this.setTitle("Simple Message");
        panel.setPreferredSize(new Dimension(500,200));
        panel.setLayout(new BorderLayout());
        message = new JLabel();
        EmptyBorder eBorder = new EmptyBorder(10, 10, 10, 10);
        panel.setBorder(eBorder);
        panel.add(message, BorderLayout.NORTH);
        okB = new JButton("OK");
        okB.addActionListener(this);

        panel.add(okB, BorderLayout.SOUTH);

        this.add(panel);
        pack();
        this.setVisible(true);
    }

    /**
     * sets the message of the frame to the parameter entry of type String
     * @param entry the String to be set to the simple message
     */
    public void setMessage(String entry){
        message.setText(entry);
    }

    /** Will return the frame selection, where null indicates that no button has been pressed.
     * Purpose of seemingly useless function is to interact with backend in a timely fashion so that the backend can
     * wait for the user to enter the selection rather than instantaneously calling a bunch of methods at once or in
     * other words allows the use of multithreading.
     * @return frame selection which is an attribute of the parent class object
     */
    public String returnSelection(){
        return this.messageSelection;
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource()==okB){
            this.setVisible(false);
            this.messageSelection = "returnMain";
        }
    }

    public static void main(String[] args){
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setMessage("Hello");
    }
}



