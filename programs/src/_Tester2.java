import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The _Tester2 class is designed to test the Advisor, Student, and Courses class but most importantly asks as the backbone
 * connecting the frontend and backend together. If I had more time, it would be called the "backbone" or something more related to the
 * backend.
 * Creates an array of 5 advisors which has their basic information, and each advisor contains 3
 * students where each student has at least one course each semester.
 * Words with a frontend GUI consisting of Java swing and Java AWT components.
 */

public class _Tester2 {
    private static final int MAX_NUM_ADVISORS = 100;

    private Courses[] courses = new Courses[5];
    private List<Courses> emptyCoursesList = new ArrayList<>();
    private String[] emptyStrArray = new String[0];
    private List<Student> emptyStudentList = new ArrayList<>();
    private Student[] emptyStudentArray = new Student[]{};
    public static Student[] students = new Student[5];
    private Advisor[] advisors = new Advisor[MAX_NUM_ADVISORS];

    // create new variable referencing the contentPane

    /**
     * Overloaded constructor which sets all testing components (array of courses, array of students, and array of advisors)
     * to random values.
     */
    public _Tester2(){
        courses[0] = new Courses("221", "CMPSC", "Fall", "in-person", 3.0);
        courses[1] = new Courses("260", "CMPSC", "Fall", "hybrid", 3.0);
        courses[2] = new Courses("220", "MATH", "Spring", "remote", 3.0);
        courses[3] = new Courses("220", "IST", "Summer", "in-person", 3.0);
        courses[4] = new Courses("7", "PHIL", "Spring", "hybrid", 4.0);

        emptyCoursesList.addAll(Arrays.asList(courses[0], courses[2], courses[3]));
        students[0] = new Student("Bob", "Harry", "Clark", "A940", emptyStrArray, "221-999-2340",
                1, 1, 2021, "Biology", emptyCoursesList);
        emptyCoursesList.clear();
        emptyCoursesList.addAll(Arrays.asList(courses[1], courses[4], courses[3]));
        students[1] = new Student("Sam", "Charles", "Jenkins", "B440", emptyStrArray, "221-333-3340",
                1, 1, 2021, "Computer Science", emptyCoursesList);
        emptyCoursesList.clear();
        emptyCoursesList.addAll(Arrays.asList(courses[1], courses[2], courses[3]));
        students[2] = new Student("James", "Opus", "Rivers", "C8K0", emptyStrArray, "221-944-6330",
                6, 6, 2022, "Computer Engineering", emptyCoursesList);
        emptyCoursesList.clear();
        emptyCoursesList.addAll(Arrays.asList(courses[0], courses[4], courses[3]));
        students[3] = new Student("Cynthia", "Reed", "Monoco", "A342", emptyStrArray, "221-669-3300",
                6, 6, 2021, "Chemistry", emptyCoursesList);
        emptyCoursesList.clear();
        emptyCoursesList.addAll(Arrays.asList(courses[1], courses[4], courses[3]));
        students[4] = new Student("Rob", "Thorn", "Horan", "A200", emptyStrArray, "221-772-7990",
                6, 6, 2022, "Arts", emptyCoursesList);


        emptyStudentList.addAll(Arrays.asList(students[0], students[1], students[2]));
        emptyStudentArray = emptyStudentList.toArray(new Student[0]);
        advisors[0] = new Advisor("Emily", "Rose", "Davis", "A001", "professor", "Science", "Main 102A",
                "215-705-8890", emptyStrArray, 1, 3, 2002, emptyStudentArray);
        emptyStudentList.clear();
        emptyStudentList.addAll(Arrays.asList(students[0], students[1], students[2]));
        advisors[1] = new Advisor("Luke", "Alexander", "Rodriquez", "JH02", "assistant professor", "Engineering", "Tomezko 206G",
                "215-910-7792", emptyStrArray, 2, 12, 2016, emptyStudentArray);
        emptyStudentList.clear();
        emptyStudentList.addAll(Arrays.asList(students[1], students[2], students[3]));
        advisors[2] = new Advisor("Jacob", "Chris", "Williams", "F702", "professor", "Arts", "Tomezko 103C",
                "201-333-8829", emptyStrArray, 4, 12, 2021, emptyStudentArray);
        emptyStudentList.clear();
        emptyStudentList.addAll(Arrays.asList(students[2], students[3], students[4]));
        advisors[3] = new Advisor("Olivia", "Grace", "Lu", "N56P", "associate professor", "Science", "Main 105A",
                "215-910-8833", emptyStrArray, 1, 9, 2023, emptyStudentArray);
        emptyStudentList.clear();
        emptyStudentList.addAll(Arrays.asList(students[0], students[1], students[4]));
        advisors[4] = new Advisor("Ava", "Marie", "Patel", "LL21", "assistant processor", "Arts", "Main 203A",
                "215-610-3322", emptyStrArray, 3, 8, 2010, emptyStudentArray);
    }


    /**
     * Constructs a default advisor to the advisor array
     */
    public void addAdvisor(){
        this.advisors[Advisor.numAdvisors] = new Advisor();
    }

    /**
     * Gets an advisor by their ID
     *
     * @param id the id of the advisor the user searches for
     * @return the Advisor that contains the matching search id
     */
    public Advisor getAdvisorById(String id){
        Boolean found = false;

        int advisor_id = 0;
        for(int i = 0; i < Advisor.numAdvisors; i++){
            if(id.equals(this.advisors[i].getAcademicId())){
                advisor_id = i;
                found = true;
            }
        }
        if(found == false){
            throw new IllegalArgumentException("Could not find advisor matching given id");
        }
        else{
            return this.advisors[advisor_id];
        }
    }

    /**
     * Reads .txt file sent from AddAdvisorFrame class containing all attributes of new advisor and sets
     * the new advisor attributes to a new advisor contained in an advisor array.
     */
    public void burnFileToAdvisor(){
        File file = new File("dataFile.txt"); // Replace file.txt with your file name
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                line.trim();
                lines.add(line);
            }

            this.advisors[Advisor.numAdvisors-1].setFirstName(lines.get(0));
            this.advisors[Advisor.numAdvisors-1].setMiddleName(lines.get(1));
            this.advisors[Advisor.numAdvisors-1].setLastName(lines.get(2));
            this.advisors[Advisor.numAdvisors-1].setAcademicId(lines.get(3));
            this.advisors[Advisor.numAdvisors-1].setTitle(lines.get(4));
            this.advisors[Advisor.numAdvisors-1].setDepartment(lines.get(5));
            this.advisors[Advisor.numAdvisors-1].setOfficeLoc(lines.get(6));
            this.advisors[Advisor.numAdvisors-1].setPhoneNumber(lines.get(7));
            this.advisors[Advisor.numAdvisors-1].setEmails(lines.get(8).split("\\s*,\\s*"));


            String temp_dates = lines.get(9);
            String[] date = temp_dates.split("/");
            this.advisors[Advisor.numAdvisors-1].setHireDay(Integer.parseInt(date[0]));
            this.advisors[Advisor.numAdvisors-1].setHireMonth(Integer.parseInt(date[1]));
            this.advisors[Advisor.numAdvisors-1].setHireYear(Integer.parseInt(date[2]));


            String[] temp_id_arr = lines.get(10).split(" ");
            Student[] new_student_array = new Student[temp_id_arr.length];

            for(int i = 0; i < temp_id_arr.length; i++){
                for(int j = 0; j < this.students.length; j++){
                    if(temp_id_arr[i].equals(this.students[i].getAcademicId())){
                        new_student_array[i] = this.students[i];
                    }
                }
            }
            if(new_student_array!=null){
                this.advisors[Advisor.numAdvisors-1].setAdvisees(new_student_array);
            } else{
                System.out.print("Invalid student ID: no students with that id could be find.");
            }


            this.advisors[Advisor.numAdvisors-1].displayValues();

            reader.close();
        } catch (IOException e) {
            System.out.print("Error!");
            e.printStackTrace();

        } catch (IllegalArgumentException e){
            System.out.print("Illegal Argument Exception");
        }
    }


    /**
     * Creates a pop-up frame prompting user to exit or return to main menu.
     * Waits for the user to make a selection first before returning to main menu.
     *
     * @param tester a reference of _Tester2, accidental flaw that start way back
     * at beginning of project unfortunately could not get rid of it.
     */
    public void runReturnMenuFrame(_Tester2 tester){
        ReturnMainMenuFrame mmFrameA = new ReturnMainMenuFrame();
        while(mmFrameA.returnSelection()==null){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        menuDisplay(tester);
    }

    /**
     * Presents a pop-up of a frame showing a simple short message and an Ok button
     * Waits for the user to press the ok button to hide the frame.
     *
     * @param entry the message that will be displayed in the frame
     */
    public void runSimpleMessage(String entry){
        SimpleMessage sFrame = new SimpleMessage();
        sFrame.setMessage(entry);
        while(sFrame.returnSelection()==null){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Brings all classes together to display the GUI and call methods to manipulate the frontend and backend data.
     * @param tester a reference of _Tester2, accidental flaw that start way back
     *      * at beginning of project unfortunately could not get rid of it.
     */
    public static void menuDisplay(_Tester2 tester){

        MenuFrame menuFrame = new MenuFrame();

        while(menuFrame.returnSelection()==null){
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        String key = menuFrame.returnSelection();

        switch(key) {
            case "a":
                //can i make this a recursive function? exits once the aframeselection is return to main menu,
                //keeps running the method as long as it's set on adding
                AddAdvisorFrame aFrame = new AddAdvisorFrame();
                //wait for them to addAdvisor or return to menu

                while(aFrame.frameSelection()!="returnMain"){
                    while(aFrame.frameSelection()==null){
                        try{
                            Thread.sleep(100);
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                    tester.addAdvisor();
                    tester.burnFileToAdvisor();

                    while(aFrame.frameSelection()=="added"){
                        try{
                            Thread.sleep(100);
                        } catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }

                    aFrame.setVisible(true);
                }
                menuDisplay(tester);



                break;
            case "b":
                String advisor_id_edit = JOptionPane.showInputDialog(null, "Enter the id of the advisor you'd like to edit: ");

                String keyEdit = JOptionPane.showInputDialog(null, "Enter the letter according to the option you'd like to edit: \n\n" +
                        "a. First name\n" +
                        "b. Middle name\n" +
                        "c. Last name\n" +
                        "d. Academic ID (a unique id for each faculty, staff, or students on campus)\n" +
                        "e. Title of the advisor (professor, associate professor, assistant professor)\n" +
                        "f. Department (Science, Arts, Engineering)\n" +
                        "g. Office Location (Building# such as: Tomezsko 207G, main 101A)\n" +
                        "h. Phone Number (office)\n" +
                        "i. Emails (an array of email: such as academic email advisor@psu.edu, advisor@gmail)\n" +
                        "j. Hired data (month, day, year)\n" +
                        "k. Advisees (an array of user-defined class: Student)");
                switch(keyEdit){
                    case "a":
                        tester.getAdvisorById(advisor_id_edit).setFirstName(JOptionPane.showInputDialog(null, "New first name: "));
                        break;
                    case "b":
                        tester.getAdvisorById(advisor_id_edit).setMiddleName(JOptionPane.showInputDialog(null, "New middle name: "));
                        break;
                    case "c":
                        tester.getAdvisorById(advisor_id_edit).setLastName(JOptionPane.showInputDialog(null, "New last name: "));
                        break;
                    case "d":
                        tester.getAdvisorById(advisor_id_edit).setAcademicId(JOptionPane.showInputDialog(null, "New academic ID (AAAA): "));
                        break;
                    case "e":
                        tester.getAdvisorById(advisor_id_edit).setTitle(JOptionPane.showInputDialog(null, "New title: "));
                        break;
                    case "f":
                        tester.getAdvisorById(advisor_id_edit).setDepartment(JOptionPane.showInputDialog(null, "New department: "));
                        break;
                    case "g":
                        tester.getAdvisorById(advisor_id_edit).setOfficeLoc(JOptionPane.showInputDialog(null, "New office location: "));
                        break;
                    case "h":
                        tester.getAdvisorById(advisor_id_edit).setPhoneNumber(JOptionPane.showInputDialog(null, "New phone number (000-000-0000): "));
                        break;
                    case "i":
                        //GIVE OPTION TO ADD MORE EMAILS
                        String temp_emails2 = JOptionPane.showInputDialog(null, "New Emails: ");
                        tester.getAdvisorById(advisor_id_edit).setEmails(temp_emails2.split("\\s+"));
                        break;
                    case "j":
                        String temp_dates2 = JOptionPane.showInputDialog(null, "New hire date (DD/MM/YYYY): ");
                        String[] date2 = temp_dates2.split("/");
                        for(String single_date: date2){
                            System.out.println(Integer.parseInt(single_date));
                        }
                        tester.getAdvisorById(advisor_id_edit).setHireDay(Integer.parseInt(date2[0]));
                        tester.getAdvisorById(advisor_id_edit).setHireMonth(Integer.parseInt(date2[1]));
                        tester.getAdvisorById(advisor_id_edit).setHireYear(Integer.parseInt(date2[2]));
                        break;
                    case "k":
                        String temp_ids2 = JOptionPane.showInputDialog(null, "Enter all new ID's of the students you would like to add (separate by space): ");
                        String[] temp_id_arr2 = temp_ids2.split(" ");

                        Student[] new_student_array2 = new Student[temp_id_arr2.length];


                        for(int i = 0; i < temp_id_arr2.length; i++){
                            for(int j = 0; j < tester.students.length; j++){
                                if(temp_id_arr2[i].equals(tester.students[i].getAcademicId())){
                                    new_student_array2[i] = tester.students[i];
                                }
                            }
                        }
                        tester.getAdvisorById(advisor_id_edit).setAdvisees(new_student_array2);
                        break;
                }
                tester.runReturnMenuFrame(tester);

                break;
            case "c":
                String advisor_id_delete = JOptionPane.showInputDialog(null, "Enter the id of the advisor you'd like to delete: ");
                Advisor.numAdvisors -= 1;
                Advisor[] new_advisors = new Advisor[Advisor.numAdvisors];
                int l = 0;
                //could simplify the for loop to the Advisor advisor: tester.Advisors format
                for(int k = 0; k < Advisor.numAdvisors; k++){
                    if(!(tester.advisors[k].getAcademicId().equals(advisor_id_delete))){
                        new_advisors[l] = tester.advisors[k];
                        l++;
                    }
                }
                tester.advisors = new_advisors;
                tester.runReturnMenuFrame(tester);
                break;
            case "d":
                String advisor_id_display = JOptionPane.showInputDialog(null, "Enter the id of the advisor you'd like to display: ");
                //tester.getAdvisorById(advisor_id_display).displayValues();
                //[1] pass the advisor to the display panel via display function called setLabels
                //[2] simply display the advisor
                DisplayFrame dFrame = new DisplayFrame();
                dFrame.setLabels(tester.getAdvisorById(advisor_id_display));

                while(dFrame.returnSelection()==null){
                    try{
                        Thread.sleep(100);
                    } catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                menuDisplay(tester);
                break;
            case "e":
                String search_department = JOptionPane.showInputDialog(null, "Enter the department to find the advisors for that department: ");

                String e_entry = "";
                boolean found_advisor_in_department = false;
                for(int i = 0; i < Advisor.numAdvisors; i++){
                    if(search_department.equals(tester.advisors[i].getDepartment())){
                        found_advisor_in_department = true;
                        e_entry += tester.advisors[i].getFirstName()+ " " + tester.advisors[i].getMiddleName() + " " + tester.advisors[i].getLastName() + ", \n";
                    }
                }
                if(found_advisor_in_department == true){
                    tester.runSimpleMessage(e_entry + "Belong(s) to the department of " + search_department + "\n");
                }
                else{
                    tester.runSimpleMessage("No advisors from the department of " + search_department + " could be found\n");
                }
                tester.runReturnMenuFrame(tester);
                break;
            case "f":
                String search_lastN = JOptionPane.showInputDialog(null, "Enter the advisor's last name to find the advisor: ");

                String f_entry = "";
                boolean found_advisor_lastname = false;
                for(int i = 0; i < Advisor.numAdvisors; i++){
                    if(search_lastN.equals(tester.advisors[i].getLastName())){
                        found_advisor_lastname = true;
                        f_entry += "The advisor with last name " + search_lastN + " is: " + tester.advisors[i].getFirstName()+ " " + tester.advisors[i].getMiddleName() + " " + tester.advisors[i].getLastName();
                    }
                }
                if(!found_advisor_lastname){
                    f_entry += "No advisors with the last name " + search_lastN + " could be found";
                }
                tester.runSimpleMessage(f_entry);
                tester.runReturnMenuFrame(tester);
                break;
            case "g":
                String search_title = JOptionPane.showInputDialog(null, "Enter the title to find the advisors with that title: ");

                String g_entry = "";
                boolean found_advisor_title = false;
                for(int i = 0; i < Advisor.numAdvisors; i++){
                    if(search_title.equals(tester.advisors[i].getTitle())){
                        found_advisor_title = true;
                        g_entry += tester.advisors[i].getFirstName()+ " " + tester.advisors[i].getMiddleName() + " " + tester.advisors[i].getLastName() + ", ";
                    }
                }
                if(found_advisor_title == true){
                    g_entry += "Has(or have) the title of " + search_title;
                }
                else{
                    g_entry = "No advisors with the title " + search_title + " could be found";

                }
                tester.runSimpleMessage(g_entry);
                tester.runReturnMenuFrame(tester);
                break;
            default:
                throw new IllegalArgumentException("not sure what you did, but it's wrong.");
        }

    }

    public static void main(String[] args){
        _Tester2 tester = new _Tester2();
        menuDisplay(tester);
    }
}
