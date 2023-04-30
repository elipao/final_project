import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Displays all attributes of an advisor using JAVA AWT
 */
public class DisplayFrame extends JFrame implements ActionListener {
    private JPanel emailPane, adviseePane, addAdvisorPane;
    private JLabel pageL, firstL, midL, lastL, idL, titleL, departmentL, officeLocL, phoneL, emailL,
            addedEmailL, addedEmailsL, hiredDateL, adviseesL, errorsL, advisorIdEntryL;
    private JLabel firstL1, midL1, lastL1, idL1, titleL1, departmentL1, officeLocL1, phoneL1,
            emailL1, hiredDateL1, adviseesL1;

    private JTextField advisorIdEntryT;

    private JComboBox<String> titleC = new JComboBox<>();
    private JComboBox<String> departmentC = new JComboBox<>();
    private JButton returnMainB;
    private String text = "";
    private final int PANEL_ROWS = 18;
    private final int PANEL_COLS = 2;
    private List<Student> adviseesList = new ArrayList<>();
    private List<String> emailsList = new ArrayList<>();
    private String addedEmailsLiteral = "";
    private String dFrameSelection = null;


    public DisplayFrame(){

        this.setTitle("Display Advisor Frame");

        this.setPreferredSize(new Dimension(400,500));


        JPanel advisorP = new JPanel();
        advisorP.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLS));
        EmptyBorder eBorder = new EmptyBorder(10, 10, 10, 10);
        advisorP.setBorder(eBorder);


        emailPane = new JPanel(new GridLayout(1, 2));
        adviseePane = new JPanel(new GridLayout(1, 2));
        addAdvisorPane = new JPanel(new GridLayout(1, 2));


        pageL = new JLabel("Advisor Display");
        Font font = pageL.getFont();
        pageL.setFont(font.deriveFont(Font.BOLD));
        firstL = new JLabel("First: ");
        midL = new JLabel("Middle: ");
        lastL = new JLabel("Last: ");
        idL = new JLabel("Academic ID (AAA): ");
        titleL = new JLabel("Title: ");
        departmentL = new JLabel("Department: ");
        officeLocL = new JLabel("Office Location: ");
        phoneL = new JLabel("Phone Number (000-000-0000): ");
        emailL = new JLabel("Email: ");
        hiredDateL = new JLabel("Hired Date (DD/MM/YYYY): ");
        adviseesL = new JLabel("Enter all ID's of the students you would like to add (separate by space): ");

        returnMainB = new JButton("Return to main menu");
        returnMainB.addActionListener(this);

        errorsL = new JLabel();
        firstL1 = new JLabel();
        midL1 = new JLabel();
        lastL1 = new JLabel();
        idL1 = new JLabel();
        titleL1 = new JLabel();
        departmentL1 = new JLabel();
        officeLocL1 = new JLabel();
        phoneL1 = new JLabel();
        emailL1 = new JLabel();
        hiredDateL1 = new JLabel();
        adviseesL1 = new JLabel();

        advisorP.add(pageL);
        //added empty label
        advisorP.add(new JLabel());
        advisorP.add(firstL);
        advisorP.add(firstL1);
        advisorP.add(midL);
        advisorP.add(midL1);
        advisorP.add(lastL);
        advisorP.add(lastL1);
        advisorP.add(idL);
        advisorP.add(idL1);
        advisorP.add(titleL);
        advisorP.add(titleL1);
        advisorP.add(departmentL);
        advisorP.add(departmentL1);
        advisorP.add(officeLocL);
        advisorP.add(officeLocL1);
        advisorP.add(phoneL);
        advisorP.add(phoneL1);
        advisorP.add(emailL);
        advisorP.add(emailL1);


        advisorP.add(hiredDateL);
        advisorP.add(hiredDateL1);
        advisorP.add(adviseesL);
        advisorP.add(adviseesL1);


        advisorP.add(returnMainB);
        advisorP.add(errorsL);



        this.add(advisorP);
        pack();
        this.setVisible(true);
    }

    /** Will return the frame selection, where null indicates that no button has been pressed.
     * Purpose of seemingly useless function is to interact with backend in a timely fashion so that the backend can
     * wait for the user to enter the selection rather than instantaneously calling a bunch of methods at once or in
     * other words allows the use of multithreading.
     * @return frame selection which is an attribute of the parent class object
     */
    public String returnSelection(){
        return dFrameSelection;
    }


    /**
     * Given an object of the Advisor class to be displayed, this function will set the labels for
     * each of the attributes of the advisor to the given object's attributes.
     * @param advisor the advisor to be displayed
     */
    public void setLabels(Advisor advisor){
        errorsL.setText("Errors: None");
        firstL1.setText(advisor.getFirstName());
        midL1.setText(advisor.getMiddleName());
        lastL1.setText(advisor.getLastName());
        idL1.setText(advisor.getAcademicId());
        titleL1.setText(advisor.getTitle());
        departmentL1.setText(advisor.getDepartment());
        officeLocL1.setText(advisor.getOfficeLoc());
        phoneL1.setText(advisor.getPhoneNumber());
        String[] temp_emails = advisor.getEmails();
        String emailString = "";
        for(String email: temp_emails){
            emailString += email + ", ";
        }
        emailL1.setText(emailString);
        hiredDateL1.setText(advisor.getHireDay()+"/"+advisor.getHireMonth()+"/"+advisor.getHireYear());


        String studentNames = "";
        for(Student student: advisor.getAdvisees()){
            studentNames += student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName() + ", ";
        }
        adviseesL1.setText(studentNames);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == returnMainB){
            dFrameSelection = "main";
            this.setVisible(false);
        }
    }
}
