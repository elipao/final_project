import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener{

    private JRadioButton[] radioButtons = new JRadioButton[8];
    private String userSelection = null;

    public MenuFrame(){

        this.setSize(500,500);
        this.setTitle("MenuFrame");
        this.setLayout(new GridLayout(9, 1));

        JLabel label = new JLabel("Main Menu");
        this.add(label);

        for (int i = 0; i < 8; i++){
            radioButtons[i] = new JRadioButton("");
            this.add(radioButtons[i]);
            radioButtons[i].addActionListener(this);
        }

        //set the text for each button
        radioButtons[0].setText("a. Add and populate an advisor to the advisor array");
        radioButtons[1].setText("b. Edit an advisor in via keyboard");
        radioButtons[2].setText("c. Delete an advisor in the array");
        radioButtons[3].setText("d. Display an advisor in the array");
        radioButtons[4].setText("e. Search and display the advisor based on a department.");
        radioButtons[5].setText("f. Search and display the advisor list based on a last name.");
        radioButtons[6].setText("g. Search and display the advisor list based on title.");
        radioButtons[7].setText("h. Exit the application");

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == radioButtons[7]) {
            this.dispose();
        } else {
            for (int i = 0; i < radioButtons.length - 1; i++) {
                if (e.getSource() == radioButtons[i]) {
                    userSelection = String.valueOf((char) (i + 97));
                    radioButtons[i].setSelected(false);
                    this.setVisible(false);
                }
            }
        }
    }

    public String returnSelection(){
        return userSelection;
    }

}