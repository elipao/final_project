/**
 * The Student Class contains Student objects which can have a first name, middle name, last name,
 * academic id, phone number, an array of emails, acceptance date (day, month, year), major
 * and a list of courses. Contains mutator and accessor methods for each attribute,
 * can add and delete entries for the emails array and courses list, and has a display method.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private String firstName;
    private String middleName;
    private String lastName;
    private String academicId;
    private String[] emails;
    private String phoneNumber;
    private int acceptanceDay;
    private int acceptanceMonth;
    private int acceptanceYear;
    private String major;
    private List<Courses> courses;

    /**
     * Default overloaded Student constructor
     */
    public Student() {
        this.setFirstName("");
        this.setMiddleName("");
        this.setLastName("");
        this.setAcademicId("");
        this.setEmails(new String[]{});
        this.setPhoneNumber("");
        this.setAcceptanceDay(0);
        this.setAcceptanceMonth(0);
        this.setAcceptanceYear(0);
        this.setMajor("");
        this.setCourses(new ArrayList<>());

    }

    /**
     * Overloaded Student constructor containing all possible attributes:
     *
     * @param firstName the student's first name
     * @param middleName the student's middle name
     * @param lastName the student's last name
     * @param academicId the student's academic ID
     * @param phoneNumber the student's office phone number
     * @param emails the student's emails
     * @param acceptanceMonth the month the student was accepted
     * @param acceptanceDay the day the student was accepted
     * @param acceptanceYear the year the student was accepted
     * @param major the student's major
     * @param courses a list of the student's courses
     */
    public Student(String firstName, String middleName, String lastName, String academicId,
                   String[] emails, String phoneNumber, int acceptanceDay, int acceptanceMonth,
                   int acceptanceYear, String major, List<Courses> courses) {

        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.setAcademicId(academicId);
        this.setEmails(emails);
        this.setPhoneNumber(phoneNumber);
        this.setAcceptanceDay(acceptanceDay);
        this.setAcceptanceMonth(acceptanceMonth);
        this.setAcceptanceYear(acceptanceYear);
        this.setMajor(major);
        this.setCourses(courses);
    }


    /**
     * Sets the first name of the student.
     *
     * @param firstName the new first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the first name of the student.
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the middle name of the student.
     *
     * @param middleName the new middle name of the student
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets the middle name of the student.
     *
     * @return the middle name of the student
     */
    public String getMiddleName() {
        return this.middleName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the new last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the last name of the student.
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the academic ID of the student.
     *
     * @param academicId the new academic ID of the student
     */
    public void setAcademicId(String academicId) {
        this.academicId = academicId;
    }

    /**
     * Gets the academic ID of the student.
     *
     * @return the academic ID of the student
     */
    public String getAcademicId() {
        return this.academicId;
    }

    /**
     * Sets the email addresses of the student.
     *
     * @param emails the new email addresses of the student
     */
    public void setEmails(String[] emails) {
        this.emails = emails;
    }

    /**
     * Gets the email addresses of the student.
     *
     * @return the email addresses of the student
     */
    public String[] getEmails() {
        return this.emails;
    }

    /**
     * Sets the phone number of the student.
     *
     * @param phoneNumber the new phone number of the student
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the phone number of the student.
     *
     * @return the phone number of the student
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the acceptance day of the student.
     *
     * @param acceptanceDay the new acceptance day of the student
     */
    public void setAcceptanceDay(int acceptanceDay) {
        this.acceptanceDay = acceptanceDay;
    }

    /**
     * Gets the acceptance day of the student.
     *
     * @return the acceptance day of the student
     */
    public int getAcceptanceDay() {
        return this.acceptanceDay;
    }

    /**
     * Sets the acceptance month of the student.
     *
     * @param acceptanceMonth the new acceptance month of the student
     */
    public void setAcceptanceMonth(int acceptanceMonth) {
        this.acceptanceMonth = acceptanceMonth;
    }

    /**
     * Gets the acceptance month of the student.
     *
     * @return the acceptance month of the student
     */
    public int getAcceptanceMonth() {
        return this.acceptanceMonth;
    }

    /**
     * Sets the acceptance year of the student.
     *
     * @param acceptanceYear the new acceptance month of the student
     */
    public void setAcceptanceYear(int acceptanceYear) {
        this.acceptanceYear = acceptanceYear;
    }


    /**
     * Gets the acceptance year of the student.
     *
     * @return the acceptance year of the student
     */
    public int getAcceptanceYear() {
        return this.acceptanceYear;
    }

    /**
     * Sets the major of the student.
     *
     * @param major the new first name of the student
     */
    public void setMajor(String major) {
        this.major = major;
    }


    /**
     * Gets the major of the student.
     *
     * @return the major of the student
     */
    public String getMajor() {
        return this.major;
    }

    /**
     * Sets the courses taken by the student.
     *
     * @param courses the new courses taken by the student
     */
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }


    /**
     * Gets the courses taken by the student.
     *
     * @return the courses taken by the student
     */
    public List<Courses> getCourses() {
        return this.courses;
    }


    public void displayValues() {
        System.out.println("Name: " + this.getFirstName() + this.getMiddleName() + this.getLastName());
        System.out.println("Academic ID: " + this.getAcademicId());
        System.out.println("Emails: " + Arrays.toString(this.getEmails()));
        System.out.println("Phone Number: " + this.getPhoneNumber());
        System.out.println("Acceptance Date: " + this.getAcceptanceDay() + "/" + this.getAcceptanceMonth() + "/" + this.getAcceptanceYear());
        System.out.println("Major: " + this.getMajor());
        System.out.println("Courses:");
        for (Courses course : courses) {
            System.out.println("- " + course);
        }
    }


}

