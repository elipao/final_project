/**
 * The Courses Class contains Courses objects which can have a course number, semester offered,
 * delivery method, and credits. Contains mutator and accessor methods for each attribute and has a display method.
 */

public class Courses {
    private String courseNumber;
    private String courseDepartment;
    private String semesterOffered;
    private String deliveryMethod;
    private double credits;

    /**
     * Default overloaded constructor
     */
    public Courses(){
        this.setCourseNumber("");
        this.setCourseDepartment("");
        this.setSemesterOffered("");
        this.setDeliveryMethod("");
        this.setCredits(0);
    }

    /**
     * Overloaded constructor containing all possible attributes:
     *
     * @param courseNumber the course's course number
     * @paran courseDepartment the course's department
     * @param semesterOffered the course's semester offered
     * @param deliveryMethod the course's delivery method
     * @param credits the course's credit amount
     */
    public Courses(String courseNumber, String courseDepartment, String semesterOffered, String deliveryMethod, double credits){
        this.setCourseNumber(courseNumber);
        this.setCourseDepartment(courseDepartment);
        this.setSemesterOffered(semesterOffered);
        this.setDeliveryMethod(deliveryMethod);
        this.setCredits(credits);
    }


    /**
     * Gets the course number.
     *
     * @return the course number
     */
    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the course number.
     *
     * @param courseDepartment the course number to set
     */
    public void setCourseDepartment(String courseDepartment) {
        this.courseDepartment = courseDepartment;
    }

    /**
     * Gets the course department.
     *
     * @return the course department
     */
    public String getCourseDepartment() {
        return courseDepartment;
    }

    /**
     * Sets the course department.
     *
     * @param courseNumber the course number to set
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * Gets the semester offered.
     *
     * @return the semester offered
     */
    public String getSemesterOffered() {
        return semesterOffered;
    }

    /**
     * Sets the semester offered.
     *
     * @param semesterOffered the semester offered to set
     */
    public void setSemesterOffered(String semesterOffered) {
        this.semesterOffered = semesterOffered;
    }

    /**
     * Gets the delivery method.
     *
     * @return the delivery method
     */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Sets the delivery method.
     *
     * @param deliveryMethod the delivery method to set
     */
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Gets the credits.
     *
     * @return the credits
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Sets the credits.
     *
     * @param credits the credits to set
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void displayValues() {

        System.out.println("Course Number: " + this.getCourseNumber());
        System.out.println("Course Department: " + this.getCourseDepartment());
        System.out.println("Semester Offered: " + this.getSemesterOffered());
        System.out.println("Delivery Method: " + this.getDeliveryMethod());
        System.out.println("Credits: " + this.getCredits());
    }
}
