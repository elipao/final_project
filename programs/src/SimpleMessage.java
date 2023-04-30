import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void setMessage(String entry){
        message.setText(entry);
    }

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



