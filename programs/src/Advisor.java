import java.util.Arrays;

/**
 * The Advisor Class contains Advisor objects which can have a first name, middle name, last name,
 * academic id, title, department, office location, phone number, an array of emails, hire date (day, month, year),
 * and an array of advisees of class Student. Contains mutator and accessor methods for each attribute,
 * can add and delete entries for the emails and advisees array, and has a display method.
 */

public class Advisor {
    private String firstName;
    private String middleName;
    private String lastName;
    private String academicId;
    private String title;
    private String department;
    private String officeLoc;
    private String phoneNumber;
    private String[] emails;
    private int hireDay;
    private int hireMonth;
    private int hireYear;
    private Student[] advisees;
    private int numStudents;
    public static int numAdvisors = 0;

    /**
     *  Overloaded Advisor default constructor
     */
    public Advisor() {
        this.firstName = "";
        this.middleName = "";
        this.academicId = "0000";
        this.title = "";
        this.department = "";
        this.officeLoc = "";
        this.phoneNumber = "000-000-0000";
        this.emails = new String[]{};
        this.hireDay = -1;
        this.hireMonth = -1;
        this.hireYear = -1;
        this.advisees = new Student[]{};
        numAdvisors++;
    }

    /**
     * Overloaded Advisor constructor containing all attributes
     *
     * @param firstName the advisor's first name
     * @param middleName the advisor's middle name
     * @param lastName the advisor's last name
     * @param academicId the advisor's academic ID
     * @param title the advisor's title
     * @param department the advisor's department
     * @param officeLoc the advisor's office location
     * @param phoneNumber the advisor's office phone number
     * @param emails the advisor's emails
     * @param hireMonth the month the advisor was hired
     * @param hireDay the day the advisor was hired
     * @param hireYear the year the advisor was hired
     * @param advisees an array of the advisor's advisees
     */
    public Advisor(String firstName, String middleName, String lastName, String academicId,
                   String title, String department, String officeLoc, String phoneNumber,
                   String[] emails, int hireMonth, int hireDay, int hireYear, Student[] advisees) {

        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setAcademicId(academicId);
        this.setTitle(title);
        this.setDepartment(department);
        this.setOfficeLoc(officeLoc);
        this.setPhoneNumber(phoneNumber);
        this.setEmails(emails);
        this.setHireDay(hireDay);
        this.setHireMonth(hireMonth);
        this.setHireYear(hireYear);
        this.setAdvisees(advisees);
        ++numAdvisors;
    }

    /**
     * Set the advisor's first name.
     *
     * @param firstName the advisor's new first name
     */
    public void setFirstName(String firstName) {
        //could check for special characters
        if(firstName == null){
            throw new IllegalArgumentException("First name can't be null");
        }
        this.firstName = firstName;
    }

    /**
     * Return the advisor's first name.
     *
     * @return the advisor's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the new advisor's middle name.
     *
     * @param middleName the advisor's new middle name
     */
    public void setMiddleName(String middleName) {
        if(middleName == null){
            throw new IllegalArgumentException("Middle name can't be null");
        }
        this.middleName = middleName;
    }

    /**
     * Return the advisor's middle name.
     *
     * @return the advisor's middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the new advisor's last name.
     *
     * @param lastName the advisor's new last name
     */
    public void setLastName(String lastName) {
        if(lastName == null){
            throw new IllegalArgumentException("Last name can't be null");
        }
        this.lastName = lastName;
    }

    /**
     * Get the advisor's last name
     *
     * @return the last name of the advisor
     */
    public String getLastName() {
        return this.lastName;
    }


    /**
     * Set the new academic ID of the advisor
     *
     * @param academicId the academic ID to set
     */
    public void setAcademicId(String academicId) {
        if(academicId == null){
            throw new IllegalArgumentException("Academic ID can't be null");
        }
        if(academicId.length() != 4){
            throw new IllegalArgumentException("String length must be 4 characters (AAAA)");
        }
        if(academicId == "0000"){
            throw new IllegalArgumentException("Cannot be set to 0000");
        }
        this.academicId = academicId;
    }

    /**
     * Get the academic ID of the advisor
     *
     * @return the academic ID of the advisor
     */
    public String getAcademicId() {
        return academicId;
    }

    /**
     * Set the new title of the advisor
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        if(title == null){
            throw new IllegalArgumentException("Title can't be null");
        }
        this.title = title;
    }

    /**
     * Get the title of the advisor
     *
     * @return the title of the advisor
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the new department of the advisor
     *
     * @param department the department to set
     */
    public void setDepartment(String department) {
        if(department == null){
            throw new IllegalArgumentException("Department can't be null");
        }
        this.department = department;
    }

    /**
     * Get the department of the advisor
     *
     * @return the department of the advisor
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Set the new office location of the advisor.
     *
     * @param officeLoc the office location to set
     */
    public void setOfficeLoc(String officeLoc) {
        if(officeLoc == null){
            throw new IllegalArgumentException("Office Location can't be null");
        }
        this.officeLoc = officeLoc;
    }

    /**
     * Return the office location of the advisor.
     *
     * @return the office location of the advisor
     */
    public String getOfficeLoc() {
        return officeLoc;
    }

    /**
     * Set the new advisor phone number.
     *
     * @param phoneNumber the phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber == null){
            throw new IllegalArgumentException("Phone number can't be null");
        }
        if(phoneNumber.length() != 12){
            throw new IllegalArgumentException("Phone number length must be 12 characters");
        }
        if(academicId == "000-000-0000"){
            throw new IllegalArgumentException("Cannot be set to 000-000-0000");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the phone number of the advisor's office.
     *
     * @return the phone number of the advisor's office
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the new array of email addresses of the advisor.
     *
     * @param emails the array of email addresses to set
     */
    public void setEmails(String[] emails) {
        if(emails == null){
            throw new IllegalArgumentException("emails can't be null");
        }
        for(String email: emails){
            if(!email.contains("@")){
                throw new IllegalArgumentException("email must contain domain name");
            }
        }
        this.emails = emails;
    }

    /**
     * Returns the new array of email addresses of the advisor.
     *
     * @return the array of email addresses of the advisor
     */
    public String[] getEmails() {
        return emails;
    }
    /**
     * Set the day the advisor was hired.
     *
     * @param hireDay the day the advisor was hired to set
     */
    public void setHireDay(int hireDay) {
        if(!(hireDay >= 0 && hireDay <= 31)){
            throw new IllegalArgumentException("Hire day must be between 00-31");
        }
        this.hireDay = hireDay;
    }

    /**
     * Returns the day the advisor was hired.
     *
     * @return the day the advisor was hired
     */
    public int getHireDay() {
        return hireDay;
    }

    /**
     * Set the month the advisor was hired.
     *
     * @param hireMonth the month the advisor was hired to set
     */
    public void setHireMonth(int hireMonth) {
        if(!(0 <= hireMonth && hireMonth <= 12)){
            throw new IllegalArgumentException("Hire month must be between 00-12");
        }
        this.hireMonth = hireMonth;
    }

    /**
     * Return the month the advisor was hired.
     *
     * @return the month the advisor was hired
     */
    public int getHireMonth() {
        return hireMonth;
    }



    /**
     * Set the year the advisor was hired.
     *
     * @param hireYear the year the advisor was hired to set
     */
    public void setHireYear(int hireYear) {
        if(!(1990 <= hireYear && hireYear <= 2023)){
            throw new IllegalArgumentException("Hire year must be between 1990 and 2023");
        }
        this.hireYear = hireYear;
    }

    /**
     * Return the year the advisor was hired.
     *
     * @return the year the advisor was hired
     */
    public int getHireYear() {
        return hireYear;
    }

    /**
     * Set the array of advisees for the advisor.
     *
     * @param advisees the array of advisees to set
     */
    public void setAdvisees(Student[] advisees) {
        this.advisees = advisees;
    }

    /**
     * Return the array of advisees for the advisor.
     *
     * @return the array of advisees for the advisor
     */
    public Student[] getAdvisees() {
        return advisees;
    }

    /**
     * Add email to the array of email addresses of the advisor.
     *
     * @param email the email to be added to the email array
     */
    public void addEmail(String email) {
        String[] newEmails = Arrays.copyOf(this.emails, this.emails.length+1);
        newEmails[newEmails.length-1] = email;
        this.emails = newEmails;
    }

    /**
     * Delete email from the array of email addresses of the advisor.
     *
     * @param email the email to be deleted from the email array
     */
    public void deleteEmail(String email) {
        String[] newEmails = Arrays.copyOf(this.emails, this.emails.length+1);
        newEmails[newEmails.length-1] = email;
        this.emails = newEmails;
    }

    /**
     * Display all the values in the Advisor class.
     */
    public void displayValues() {
        System.out.println("Name: " + this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName());
        System.out.println("Academic ID: " + this.getAcademicId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Department: " + this.getDepartment());
        System.out.println("Office Location: " + this.getOfficeLoc());
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.print("Emails(" + this.getEmails().length + "): ");
        for(String email: emails){
            System.out.print(email + ", ");
        }
        System.out.println("\nHire Date: " + this.getHireMonth() + "/" + this.getHireDay() + "/" + this.getHireYear());
        System.out.print("Advisees(" + advisees.length + "): " );
        for(Student advisee: advisees){
            System.out.print(advisee.getFirstName() + " " + advisee.getMiddleName() + " " + advisee.getLastName() + ", ");
        }
    }

}
