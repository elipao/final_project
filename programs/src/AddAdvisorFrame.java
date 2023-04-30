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
 * AddAdvisorFrame class provides a JAVA AWT frame with interactive components to enter the
 * attributes of a new advisor. The attributes are then written to a new file.
 */
public class AddAdvisorFrame extends JFrame implements ActionListener {
    private JPanel emailPane1, emailPane2, adviseePane, addAdvisorPane;
    private JLabel pageL, firstL, midL, lastL, idL, titleL, departmentL, officeLocL, phoneL, emailL,
            addedEmailL, addedEmailsL, hiredDateL, adviseesL, errorsL;
    private JTextField firstT, midT, lastT, idT, officeLocT, phoneT, emailT, hiredDateT, adviseesT;
    private JComboBox<String> titleC = new JComboBox<>();
    private JComboBox<String> departmentC = new JComboBox<>();
    private JButton emailAddB, emailClearB, addB, returnMainB, addAnotherB;
    private String text = "";
    private final int PANEL_ROWS = 16;
    private final int PANEL_COLS = 2;
    private List<Student> adviseesList = new ArrayList<>();
    private List<String> emailsList = new ArrayList<>();
    private String addedEmailsLiteral = "";
    private String aFrameSelection = null;


    public AddAdvisorFrame(){
        this.setPreferredSize(new Dimension(600,500));
        this.setTitle("Add Advisor");

        JPanel advisorP = new JPanel();
        advisorP.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLS));

        EmptyBorder eBorder = new EmptyBorder(10, 10, 10, 10);
        advisorP.setBorder(eBorder);

        //panels, not sure why I called them pane
        emailPane1 = new JPanel(new GridLayout(1, 2));
        emailPane2 = new JPanel(new GridLayout(1, 2));
        adviseePane = new JPanel(new GridLayout(1, 2));
        addAdvisorPane = new JPanel(new GridLayout(1, 2));

        //labels
        pageL = new JLabel("Add Advisor");
        Font font = pageL.getFont();
        pageL.setFont(font.deriveFont(Font.BOLD));
        firstL = new JLabel("First: ");
        midL = new JLabel("Middle: ");
        lastL = new JLabel("Last: ");
        idL = new JLabel("Academic ID (AAAA): ");
        titleL = new JLabel("Choose title: ");
        departmentL = new JLabel("Choose department: ");
        officeLocL = new JLabel("Office Location: ");
        phoneL = new JLabel("Phone (000-000-0000): ");
        emailL = new JLabel("Email: ");
        addedEmailL = new JLabel("Added Emails: ");
        addedEmailsL = new JLabel("{ Added Emails } ");
        hiredDateL = new JLabel("Hired Date (DD/MM/YYYY): ");
        adviseesL = new JLabel("Enter all ID's of the students you would like to add (separate by space): ");
        errorsL = new JLabel("Errors: None");

        //text fields
        firstT = new JTextField("", 20);
        midT = new JTextField("", 10);
        lastT = new JTextField("", 20);
        idT = new JTextField();
        officeLocT = new JTextField();
        phoneT = new JTextField();
        emailT = new JTextField();
        hiredDateT = new JTextField();
        adviseesT = new JTextField();

        //combo boxes
        titleC = new JComboBox<String>();
        titleC.addItem("Professor");
        titleC.addItem("Associate Professor");
        titleC.addItem("Assistant Professor");
        departmentC = new JComboBox<String>();
        departmentC.addItem("Science");
        departmentC.addItem("Arts");
        departmentC.addItem("Engineering");

        //buttons
        emailAddB = new JButton("Add Email");
        emailClearB = new JButton("Clear All Emails");
        addB = new JButton("Add Advisor");
        returnMainB = new JButton("Return to Main Menu");
        addAnotherB = new JButton("Add Another Advisor");

        //action listeners added to buttons
        emailAddB.addActionListener(this);
        emailClearB.addActionListener(this);
        addB.addActionListener(this);
        returnMainB.addActionListener(this);
        addAnotherB.addActionListener(this);

        //building components onto main frame
        advisorP.add(pageL);
        //added empty label
        advisorP.add(new JLabel());
        advisorP.add(firstL);
        advisorP.add(firstT);
        advisorP.add(midL);
        advisorP.add(midT);
        advisorP.add(lastL);
        advisorP.add(lastT);
        advisorP.add(idL);
        advisorP.add(idT);
        advisorP.add(titleL);
        advisorP.add(titleC);
        advisorP.add(departmentL);
        advisorP.add(departmentC);
        advisorP.add(officeLocL);
        advisorP.add(officeLocT);
        advisorP.add(phoneL);
        advisorP.add(phoneT);
        emailPane1.add(emailL);
        emailPane1.add(emailT);
        advisorP.add(emailPane1);
        emailPane2.add(emailAddB);
        emailPane2.add(emailClearB);
        advisorP.add(emailPane2);
        advisorP.add(addedEmailL);
        advisorP.add(addedEmailsL);
        advisorP.add(hiredDateL);
        advisorP.add(hiredDateT);
        advisorP.add(adviseesL);
        advisorP.add(adviseesT);
        advisorP.add(addB);
        advisorP.add(errorsL);
        advisorP.add(returnMainB);
        advisorP.add(addAnotherB);

        this.add(advisorP);
        pack();
        this.setVisible(true);
    }

    /**
     * writes all the user entries to a .txt file
     */
    public void writeToFile(){

        //write to a file
        try{
            FileWriter dataWrite = new FileWriter("dataFile.txt");
            dataWrite.write(firstT.getText() + "\n");
            dataWrite.write(midT.getText()+ "\n");
            dataWrite.write(lastT.getText()+ "\n");
            dataWrite.write(idT.getText()+ "\n");
            dataWrite.write((String)titleC.getSelectedItem()+ "\n");
            dataWrite.write((String)departmentC.getSelectedItem()+ "\n");
            dataWrite.write(officeLocT.getText()+ "\n");
            dataWrite.write(phoneT.getText()+ "\n");
            dataWrite.write(addedEmailsLiteral + "\n");
            dataWrite.write(hiredDateT.getText()+ "\n");
            dataWrite.write(adviseesT.getText() + "\n");
            dataWrite.close();
        } catch (IOException e) {
            System.out.println("dataFile reader failed");
            e.printStackTrace();
        }

    }

    /**
     * validates the entries of the user by calling the Advisor set methods which contain validators.
     * The Advisor set methods will throw IllegalArgumentExceptions, and this method checks for them in a
     * try-catch.
     * @return boolean where false indicates invalid entries, and true indicates valid entries
     */
    public boolean validateEntries(){
        //[1] makes instance of Advisor, tests to see whether it gives any errors during setting the values
        //[2] if it makes any errors, then it will set the text of the errors message to show all input errors
        //[3] return true if no errors, false otherwise

        Advisor advisor = new Advisor();
        Advisor.numAdvisors-=1;

        //the set methods act as validators in this case to catch the IllegalArgumentException
        try{
            advisor.setFirstName(firstT.getText());
            advisor.setMiddleName(midT.getText());
            advisor.setLastName(lastT.getText());
            advisor.setAcademicId(idT.getText());
            advisor.setTitle((String)titleC.getSelectedItem());
            advisor.setDepartment((String)departmentC.getSelectedItem());
            advisor.setOfficeLoc(officeLocT.getText());
            advisor.setPhoneNumber(phoneT.getText());
            advisor.setEmails(addedEmailsLiteral.split("\\s+"));

            String temp_dates = hiredDateT.getText();
            String[] date = temp_dates.split("/");
            advisor.setHireDay(Integer.parseInt(date[0]));
            advisor.setHireMonth(Integer.parseInt(date[1]));
            advisor.setHireYear(Integer.parseInt(date[2]));

            String[] temp_id_arr = adviseesT.getText().split(" ");
            Student[] new_student_array = new Student[temp_id_arr.length];

            for(int i = 0; i < temp_id_arr.length; i++){
                for(int j = 0; j < _Tester2.students.length; j++){
                    if(temp_id_arr[i].equals(_Tester2.students[i].getAcademicId())){
                        new_student_array[i] = _Tester2.students[i];
                    }
                }
            }
            advisor.setAdvisees(new_student_array);
            return true;
        } catch (IllegalArgumentException e){
            errorsL.setText("Error! One or more of the entries is/are incorrect.");
            return false;
        }
    }


    /** Will return the frame selection, where null indicates that no button has been pressed.
     * Purpose of seemingly useless function is to interact with backend in a timely fashion so that the backend can
     * wait for the user to enter the selection rather than instantaneously calling a bunch of methods at once or in
     * other words allows the use of multithreading.
     * @return frame selection which is an attribute of the parent class object
     */
    public String frameSelection(){
        return this.aFrameSelection;
    }


    /**
     * clears all text fields.
     */
    public void clearTextFields(){
        firstT.setText("");
        midT.setText("");
        lastT.setText("");
        idT.setText("");
        titleC.setSelectedIndex(0);
        departmentC.setSelectedIndex(0);
        officeLocT.setText("");
        phoneT.setText("");
        emailsList.clear();
        emailT.setText("");
        addedEmailsLiteral="";
        addedEmailsL.setText("");
        hiredDateT.setText("");
        adviseesList.clear();
        adviseesT.setText("");
    }


    //  IN ORDER FOR THE COMPONENT TO BE RECOGNIZED AS A SOURCE, IT HAS TO HAVE A
    // THE .ADDACTIONLISTENER() FUNCTION TO IT
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == emailAddB){
            emailsList.add(emailT.getText());
            addedEmailsLiteral +=  emailT.getText() + ", ";
            addedEmailsL.setText(addedEmailsLiteral);
        }
        else if (e.getSource() == emailClearB){
            emailsList.clear();
            addedEmailsLiteral = "";
            addedEmailsL.setText(addedEmailsLiteral);
        }
        else if(e.getSource() == addB){
            if(validateEntries()){
                this.writeToFile();
                aFrameSelection = "added";
                addB.setText("ADDED");
                addB.setBackground(Color.GREEN);
                //this.setVisible(false);
            }
        }
        //will prevent the adding button to be pressed before the add advisor button
        else if(e.getSource() == addAnotherB && aFrameSelection == "added"){
            this.setVisible(false);
            this.clearTextFields();
            aFrameSelection = null;
            addB.setText("add Advisor");
            addB.setBackground(Color.WHITE);
        }
        else if(e.getSource() == returnMainB){
            this.setVisible(false);
            aFrameSelection = "returnMain";

        }
    }
}


