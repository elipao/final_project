import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * For non JAVA AWT based components, this JAVA AWT based class displays a pop-up that will ask the user to
 * exit or return to the main menu.
 */

public class ReturnMainMenuFrame extends JFrame implements ActionListener{

    private JButton exitB, returnMainB;
    private JLabel orL, qL;
    private String userSelection = null;


    public ReturnMainMenuFrame(){
        this.setTitle("Exit or Return to Main Menu?");

        JPanel mPanel = new JPanel();
        mPanel.setPreferredSize(new Dimension(400, 200));

        mPanel.setLayout(new FlowLayout());
        EmptyBorder eBorder = new EmptyBorder(70, 10, 70, 10);
        mPanel.setBorder(eBorder);
        this.setLayout(new BorderLayout());

        exitB = new JButton("Exit");
        exitB.setBackground(Color.RED);
        exitB.setOpaque(true);
        exitB.addActionListener(this);

        returnMainB = new JButton("Return to Main Menu");
        returnMainB.setBackground(Color.CYAN);
        returnMainB.setOpaque(true);
        returnMainB.addActionListener(this);
        orL = new JLabel("OR");
        qL = new JLabel("?");
        mPanel.add(exitB);
        mPanel.add(orL);
        mPanel.add(returnMainB);
        mPanel.add(qL);

        this.add(mPanel, BorderLayout.CENTER);
        pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exitB){
            dispose();
        }
        else{
            userSelection = "main";
            this.setVisible(false);
        }
    }

    /** Will return the frame selection, where null indicates that no button has been pressed.
     * Purpose of seemingly useless function is to interact with backend in a timely fashion so that the backend can
     * wait for the user to enter the selection rather than instantaneously calling a bunch of methods at once or in
     * other words allows the use of multithreading.
     * @return frame selection which is an attribute of the parent class object
     */
    public String returnSelection(){
        return userSelection;
    }

}
