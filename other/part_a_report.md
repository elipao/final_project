# Part A Report 

## How to Use:
+ Simply **Run _Tester2** located in: final_project > prorams > src > _Tester2 
  + _Tester2: the backBone of all the programs, contributing primary backend services which connect all frontend frames 
  + FRONTEND: each of the frames (menu frame, returnMenuFrame, addAdvisorFrame) are each classes for modularity
  + BACKEND: _Tester2, Advisor, Student, Courses classes 
 + Does contain bugs, but will overall run smoothly
  
  
## User Requirements:
+ **user interface** in the form of a menu that allows a **set of commands** (edit, delete, add, etc) to alter an Advisor object, which is provided in the _Tester class.
+ The _Tester2 class **must contain an array of 5 Advisor objects**, with **each advisor containing three Student objects** and **each student must have at least three courses** from different semesters.
+ The Advisor class, Student class, and Courses class have several attributes (such as first name, academic id) and **each have their own accessor and mutator methods** (setters and getters), and must have their own display method which displays all the values of the attributes.
+ **Javadocs** which contains documentation of the code.
+ JavaFX-based GUI Interface to allow user input for classes
+ Event handlers for user inputs
+ At least 3 advisor's information have to be entered into the GUI (dynamically) and should be retrievable 
+ OPTIONAL: tables in database to save data in project which can be accessed through GUI and backend 


## How the project requirements have been met:
+ The **user interface** contains a working menu for each set of commands
  + For the first menu: add and populate the new advisor
    + unsure of requirements on whether it has to be fully populated or just partially, so I ended up only using the default constructor to allow for future considerations/optimizations such as only adding select attributes opposed to all attributes at once
+ The _Tester class **contains an array of 5 Advisor objects** with **each advisor containing three Student objects** and **each student has at least three courses** from different semesters.
+ The Advisor class, Student class, and Courses class have several attributes (such as first name, academic id) and **each have their own accessor and mutator methods** (setters and getters), and must have their own display method which displays all the values of the attributes.
  + validation checks were added to the Advisor class set methods and will throw exception(s) if standards fail, however, not all exceptions/validations are fully implemented or created yet
+ contains **javadocs** folder which document all classes contained in the final project 
+ JavaFX-based GUI: Uses both the Java Swing and Java AWT Library to construct a working GUI which works together to provide user entry services and displayal purposes. 
  + Java AWT utilized for larger interactive components and for design reasons: main menu, add advisor frame, exit or return to main menu frame, and display advisor frame are all based on the Java AWT library. 
  + Java Swing utilized for smaller interactive components like for the submenu option to edit one of 
eleven attributes of an advisor based on advisor id, the frontend design was chosen to be JOptionPane input dialogs for a more cleaner design (rather than creating eleven plus frames with each of their own interactive JComponents). Similarily, for deletion, finding advisors by department, and finding advisor by last name they used the SimpleMessage class to just display the output of the calculation which could be summed up in one sentence, hence the simple message name. 
  + There are event handlers which partially cover most of the GUI complications like validitors for user entries. For example, if an advisor id does not exist, rather than the program terminating/freezing, it will display a message saying advisor id not found and then will prompt to return to main menu or exit. Since the user won't be losing as much progress(all they will have to do is type in a correct advisor id) as compared to adding an advisor (which requires typing in ten plus entries), restarting the prompt isn't too much of a hassle. When it does come to multiple user entries such as in adding advisors, a label will report to the user that one of the formats are incorrect preventing the program from crashing. Once the format of all entries are correct, only then can the user add the advisor.
  + upto 95 advisors can be added into the GUI dynamically, as I set the constant MAX_NUM_ADVISORS = 100 and in the constructor created 5. 
  + OPTIONAL: used reading and writing files for the Add Advisor Frame to allow large data to be more portable. In the Add Advisor Frame, the user enters several attributes to add a new advisor to the advisor array and all attributes are written to a file called "dataFile.txt". In the backend, this file is then unpacked or read and the individual attributes contained in the file are set to the actual attributes of the new advisor created in the _Tester2.java file. Each time a new advisor is created, the past file is discarded, then the new attributes are writted, then the attributes are read in the backend and then they are set to the actual attributes via set methods belonding to the Advisor class. This is the single instance of using databases - only in adding new advisors and reading them. 
  
  
## Bugs that need to be fixed
+ clicking on the add another advisor button and then clicking the return to main menu button without fully adding an advisor. Likely to only run into this bug if you decided mid-way into entering advisor data that you want to leave. 
