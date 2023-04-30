# Part A Report 

## How to Use:
+ Simply **Run _Tester2** located in: final_project > prorams > src > _Tester2 
  + _Tester2: the backBone of all the programs, contributing primary backend services which connect all frontend frames 
  + FRONTEND: each of the frames (menu frame, returnMenuFrame, addAdvisorFrame) are each classes for modularity
  + BACKEND: _Tester2, Advisor, Student, Courses classes 
  
  
## User Requirements:
+ **user interface** in the form of a menu that allows a **set of commands** (edit, delete, add, etc) to alter an Advisor object, which is provided in the _Tester class.
+ The _Tester class **must contain an array of 5 Advisor objects**, with **each advisor containing three Student objects** and **each student must have at least three courses** from different semesters.
+ The Advisor class, Student class, and Courses class have several attributes (such as first name, academic id) and **each have their own accessor and mutator methods** (setters and getters), and must have their own display method which displays all the values of the attributes.
+ **Javadocs** which contains documentation of the code.


## How the project requirements have been met:
+ The **user interface** contains a working menu for each set of commands
  + For the first menu: add and populate the new advisor
    + unsure of requirements on whether it has to be fully populated or just partially, so I ended up only using the default constructor to allow for future considerations/optimizations such as only adding select attributes opposed to all attributes at once
+ The _Tester class **contains an array of 5 Advisor objects** with **each advisor containing three Student objects** and **each student has at least three courses** from different semesters.
+ The Advisor class, Student class, and Courses class have several attributes (such as first name, academic id) and **each have their own accessor and mutator methods** (setters and getters), and must have their own display method which displays all the values of the attributes.
  + validation checks were added to the Advisor class set methods and will throw exception(s) if standards fail, however, not all exceptions/validations are fully implemented or created yet
+ contains **javadocs** folder
