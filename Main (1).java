/*
* File Name: Main.java
* Author: Aseef Ali Hasan
* Date: August 19, 2021
* Description:
* This is a program that helps users apply to university
* The user has to input their marks and courses
* The program determines if they are eligible to apply
* to the university and program that they chose
* All the methods set parameters that are fulfilled
* in the main methods.
* The answers to each function are returned to the main method
* All information is displayed through JOptionPane
*/

//Used to diplay information through GUI
import javax.swing.JOptionPane;
//Used for addtional functions when interpreting arrays
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //variable declaration and initializing
        //Stores the user's name
        String introText = JOptionPane.showInputDialog(null, 
                            "What is your name?");
        //Constant for all university choices that will be passed to the methods
        final String[] UNIVERSITY_CHOICES = {"University of Toronto", 
                                            "University of Waterloo", 
                                            "McMaster University", 
                                            "Quit"};
        //Constant with all majors that will be passed to the methods
        final String[] MAJOR_CHOICES = {"Computer Science", 
                                        "Life Science", 
                                        "Business Administration"};   
        //Constant that holds the number 6
        //This is because students use their top 6 courses when applying
        final int NUM_COURSES = 6;
        //Stores the courses the user inputs in an array
        String [] studentCourses = new String [NUM_COURSES];
        //Stores the marks the user inputs in an array
        double [] studentMarks = new double [NUM_COURSES]; 
        //Stores if user's courses meet program requirements
        boolean coursesAccepted;
        //Stores if user's marks meet program requirements
        boolean marksAccepted;
        
        //quit is true if user leaves the first field blank
        boolean quit = introText == null || introText.isEmpty();
        
        //While the user enters their name
        while (!quit)
        {   
            //Use showMenuAndGetChoice method to store what university
            //the user wants to apply to 
            String choice = showMenuAndGetChoice(UNIVERSITY_CHOICES);
            //Actions if the user picks UofT
            if (choice.equals("University of Toronto"))
            {   
                //Stores what major the user picked
                //Fulfills getMajor method parameter with array argument 
                String majorChoice = getMajor(MAJOR_CHOICES);
                //Actions if user picks CS
                if (majorChoice.equals("Computer Science"))
                { 
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument 
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = 
                            meetsUoftComputerScienceCourses(studentCourses);
                    //Actions if they meet the requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsUoftComputerScienceMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if marks meet the requirements 
                        if(marksAccepted == true)
                        {
                            //Shows message that they are eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application!");
                            //Program ends
                            quit = true;
                        }
                        //Actions if marks don't meet the requirements 
                        else
                        {
                            //Shows message that they are not eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if courses do not meet the requirements 
                    else
                    {
                        //Shows message that they are not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends
                        quit = true;
                    }
                }
                //Actions if user picks life science 
                else if (majorChoice.equals("Life Science"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = meetsUoftLifeScienceCourses(studentCourses);
                    //Actions if courses meet the requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsUoftLifeScienceMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if marks meet the requirements 
                        if(marksAccepted == true)
                        {
                            //Show message saying they're eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if marks do not meet requirements 
                        else
                        { 
                            //Show message saying they're not eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if they don't meet course requirements
                    else
                        //Show message saying they are not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends
                        quit = true;
                }
                //Actions if user picks Business Administration
                else if (majorChoice.equals("Business Administration"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = meetsUoftBusinessAdministrationCourses
                                      (studentCourses);
                    //Actions if they meet course requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsUoftBusinessAdministrationMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if they meet mark requirements
                        if(marksAccepted == true)
                        {
                            //Show message saying they are eligible 
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends 
                            quit = true;
                        }
                        //Actions if they don't meet mark requirements 
                        else
                        {
                            //Show message saying they are not eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if they do not meet course requirements 
                    else
                    { 
                        //Show message saying they are not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends
                        quit = true;  
                    }
                }
                //Actions if they pick something else
                else
                {
                    //Goodbye message appears
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    //Program ends 
                    quit = true;
                }
            }
            //Actions if they pick Waterloo 
            else if (choice.equals("University of Waterloo"))
            {
                //Use showMenuAndGetChoice method to store what university
                //the user wants to apply to 
                String majorChoice = getMajor(MAJOR_CHOICES);
                //Actions if user picks CS
                if (majorChoice.equals("Computer Science"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = meetsWaterlooComputerScienceCourses
                                      (studentCourses);
                    //Actions if they meet course requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsWaterlooComputerScienceMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if they meet mark requirements
                        if(marksAccepted == true)
                        {
                            //Show message saying they are eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if they don't meet mark requirements 
                        else
                        {
                            //Show message saying they are not eligible 
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends 
                            quit = true;
                        }
                    }
                    //Actions if they don't meet course requirements
                    else
                    {
                        //Show message saying they are not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends 
                        quit = true; 
                    }
                }
                //Actions if they pick Life Science
                else if (majorChoice.equals("Life Science"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = meetsWaterlooLifeScienceCourses
                                      (studentCourses);
                    //Actions if user meets course requirements                   
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsWaterlooLifeScienceMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if user meets mark requirements            
                        if(marksAccepted == true)
                        {
                            //Show message saying they're eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if user doesn't meet mark requirements 
                        else
                        {
                            //Show message saying they are not eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if user does not meet course requirements 
                    else
                    { 
                        //Show message saying they are not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends 
                        quit = true; 
                    }
                }
                //Actions if user picks business administration 
                else if (majorChoice.equals("Business Administration"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stored above
                    coursesAccepted = meetsWaterlooBusinessAdministrationCourses
                                        (studentCourses);
                    //Actions if user courses meet program requirements                     
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsWaterlooBusinessAdministrationMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if marks meet requirements 
                        if (marksAccepted == true)
                        {
                            //Show message saying they are eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if marks don't meet program requirements
                        else
                        {
                          //Show message saying they are eligible
                           JOptionPane.showMessageDialog(null, introText + 
                                   ", you are not eligble for application");
                          //Program ends
                           quit = true;  
                        }
                    }
                    //Actions if courses don't meet program requirements
                    else
                    {
                        //Show message saying they're not eligible
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Program ends
                        quit = true; 
                    }
                }
                //Actions if user inputs anything else
                else 
                {
                    //Shows goodbye message 
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    //Program ends
                    quit = true;
                }
            }
            //Actions if user picks McMaster
            else if (choice.equals("McMaster University"))
            {
                //Use showMenuAndGetChoice method to store what university
                //the user wants to apply to 
                String majorChoice = getMajor(MAJOR_CHOICES);
                if (majorChoice.equals("Computer Science"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stores above and int argument
                    coursesAccepted = meetsMcMasterComputerScienceCourses
                                        (studentCourses);
                    //Actions if user meets course requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsMcMasterComputerScienceMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if user meets mark requirements 
                        if (marksAccepted == true)
                        {
                            //Shows message saying they are eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Ends program
                            quit = true;
                        }
                        //Actions if user does not meet mark requirements
                        else
                        {
                            //Shows message saying they are not eligible 
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Ends program
                            quit = true;
                        }
                    }
                    //Actions if user doesn't meet course requirements 
                    else 
                    {
                        //Shows message saying they are not eligible 
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are not eligble for application");
                        //Ends program
                        quit = true; 
                    }
                }
                //Actions if user picks life science
                else if (majorChoice.equals("Life Science"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stores above and int argument
                    coursesAccepted = meetsMcMasterLifeScienceCourses
                                        (studentCourses);
                    //Actions if courses meet requirements 
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsMcMasterLifeScienceMarks(studentMarks, NUM_COURSES);
                        //Actions if marks meet requirements 
                        if (marksAccepted == true)
                        {
                            //Shows message saying they're eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                        ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if marks don't meet requirements 
                        else
                        {
                            //Shows message saying they're not eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you not are eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if courses don't meet requirements
                    else
                    { 
                        //Shows message saying they are not eligible 
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are eligble for application");
                        //Program ends
                        quit = true;
                    }
                }
                //Actions if user picks business administration
                else if (majorChoice.equals("Business Administration"))
                {
                    //Stores the courses in array
                    //Fullfils method's parameters with int argument
                    studentCourses = getCourses(NUM_COURSES);
                    //Stores boolean of if courses meets the requirments
                    //Fullfils method's parameters with array stores above and int argument
                    coursesAccepted = meetsMcMasterBusinessAdministrationCourses
                                        (studentCourses);
                    //Actions if courses meet requirements
                    if (coursesAccepted == true)
                    {
                        //Stores marks in array
                        //Fullfils method's parameters with int argument
                        studentMarks = getMarks(NUM_COURSES);
                        //Stores boolean of if marks meets the requirments
                        //Fullfils method's parameters with array stores above and int argument
                        marksAccepted = meetsMcMasterBusinessAdministrationMarks
                                        (studentMarks, NUM_COURSES);
                        //Actions if marks meet requirements 
                        if (marksAccepted ==  true)
                        {
                            //Shows message saying they are eligible
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are eligble for application");
                            //Program ends
                            quit = true;
                        }
                        //Actions if marks do not meet requirements 
                        else 
                        { 
                            //Shows message saying they are not eligible 
                            JOptionPane.showMessageDialog(null, introText + 
                                    ", you are not eligble for application");
                            //Program ends
                            quit = true;
                        }
                    }
                    //Actions if courses don't meet requirements 
                    else
                    { 
                        //Shows message saying they are not eligible 
                        JOptionPane.showMessageDialog(null, introText + 
                                ", you are eligble for application");
                        //Program ends 
                        quit = true;
                    }
                }
                //Actions if user picks anything else
                else
                {
                    //Shows goodbye message 
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    //Program ends
                    quit = true;
                }
            }
            //Actions if user chooses quit 
            else if (choice.equals("Quit"))
            {
                //Program ends 
                quit = true;
            }
        }
        //When quit is true program ends and shows goodbye message 
        JOptionPane.showMessageDialog(null, "Goodbye");
        quit = true;
    }//End of main method 

    /**
   * method name: showMenuAndGetChoice 
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 19 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method features the JOptionPane that will make the user menu
   * It creates a drop-dowm menu 
   * The user will pick their university from this menu
   *
   * Parameters: final String[] UNIVERSITY_CHOICES: constant array
   * of the 3 universities the user can choose from 
   *
   * Return: String of user's choice
   */
    public static String showMenuAndGetChoice(final String[] UNIVERSITY_CHOICES)
    {
        String choice = (String) javax.swing.JOptionPane.showInputDialog(
                null, //Component parentComponent
                "Applying to University", //String title
                "Chose an option",//information
                javax.swing.JOptionPane.PLAIN_MESSAGE, //int optionType
                null, //Icon icon,
                UNIVERSITY_CHOICES, //Object[] options,
                UNIVERSITY_CHOICES[0]//Object initialValue 
        );
        //Returns user's choice back to main method 
        return (choice);
    }
    
   /**
   * method name: getMajor 
   *
   * Author: Aseef Ali Hasan
   *
   * Date: August 19 2021
   *
   * Version: 1.0
   *
   * Change log: none
   *
   * Description:
   * This method features the JOptionPane that will make the user menu
   * It creates a drop-down menu 
   * The user will pick their university from this menu
   *
   * Parameters: final String[] MAJOR_CHOICES: constant array
   * of the 3 majors the user can choose from 
   *
   * Return: String of user's major choice
   */
    public static String getMajor(final String[] MAJOR_CHOICES)
    {
        String majorChoice = (String) javax.swing.JOptionPane.showInputDialog(
                null, //Component parentComponent
                "Choosing your major", //String title
                "Choose an option", //Information 
                javax.swing.JOptionPane.PLAIN_MESSAGE, //int optionType
                null, //Icon icon
                MAJOR_CHOICES, //Object[] options,
                MAJOR_CHOICES[0] //Object initialValue 
        );
        //Returns user's major choice to main method 
        return (majorChoice);
    }
    
    /**
    * method name: getCourses
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 17 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * This method creaates a array to hold the user's courses
    * The array is iterated with a for loop until it reaches
    * 6 courses for the top 6
    * Every iteration will prompt the user with a JOptionPane
    *
    * Parameters: final int SIZE: a constant storing the max
    * courses a user can apply with
    *
    * Return: Array of user's courses
    */
    public static String [] getCourses(final int SIZE)
    { 
        //Creates string to hold user's courses
        //Its the size of the constant that was a parameter
        String [] userCourses = new String [SIZE];
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than SIZE
        * Records a course in the array each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            userCourses[i] = JOptionPane.showInputDialog(null, "Enter your top "
                    + "6 courses like this (\"ENG4U\")");
        }
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than SIZE
        * Prints the user's course in a JOptionPane each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            JOptionPane.showMessageDialog(null, "Your courses are... "+ 
                                            userCourses[i]);
        }
        
        //Returns array of user's courses to main method
        return (userCourses);
    }

    /**
    * method name: meetsUoftComputerScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftComputerScienceCourses(String [] courses)
    {
        //Stores boolean of user's acceptance status
        boolean accepted;
        //Stores the required math course
        String requiredMath = "MCV4U";
        //Stores the required english course
        String requiredEnglish = "ENG4U";
        
        //Using array class to find if both courses are present in the array of courses
        accepted = Arrays.stream(courses).anyMatch(requiredMath::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of accpetance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsUoftLifeScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftLifeScienceCourses(String [] courses)
    {
        //Stores boolean of accpetance status
        boolean accepted;
        //Stores required math course
        String requiredMath = "MCV4U";
        //Stores required english course
        String requiredEnglish = "ENG4U";
        
        //Uses arrays class to see if both reqired courses are present in courses array
        accepted = Arrays.stream(courses).anyMatch(requiredMath::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsUoftBusinessAdministrationCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftBusinessAdministrationCourses(String [] courses)
    { 
        //Stores acceptance status
        boolean accepted;
        //Stores required math course
        String requiredMath = "MCV4U";
        //Stores required english course
        String requiredEnglish = "ENG4U";
        
        //Uses array class to determine if both required courses are in courses array
        accepted = Arrays.stream(courses).anyMatch(requiredMath::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooComputerScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooComputerScienceCourses(String [] courses)
    {
        //Creates boolean of accpetance status
        boolean accepted;
        //Stores required courses
        String requiredMath1 = "MCV4U";
        String requiredMath2 = "MHF4U";
        String requiredEnglish = "ENG4U";
        
        //Uses arrays class to determine if required courses are present in courses array
        accepted = Arrays.stream(courses).anyMatch(requiredMath1::equals) && 
                   Arrays.stream(courses).anyMatch(requiredMath2::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooLifeScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    * Goes through all combinations from the group of courses where only 2 courses are needed
    * to check if the user meets at least one of them to determine acceptance
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooLifeScienceCourses(String [] courses)
    {
       //Stores boolean for if user meets pre requisite courses and checks
       //for all other posible combinations
        boolean preReqCheck, check1, check2, check3, check4, check5, check6, 
                accepted;
        //Stores required courses
        String requiredMath1 = "MCV4U";
        String requiredMath2 = "MHF4U";
        String requiredEnglish = "ENG4U";
        //Stores courses from list from where 2 are needed
        String biology = "SBI4U";
        String chemistry = "SCH4U";
        String physics = "SPH4U";
        String spaceScience = "SES4U";
        
        //Uses array class to check if pre requisiste courses are present 
        preReqCheck = Arrays.stream(courses).anyMatch(requiredMath1::equals) && 
                      Arrays.stream(courses).anyMatch(requiredMath2::equals) && 
                      Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Check all possible combinations from list and stores result in boolean
        check1 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(chemistry::equals);
        
        check2 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(physics::equals);
        
        check3 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        check4 = Arrays.stream(courses).anyMatch(chemistry::equals) && 
                 Arrays.stream(courses).anyMatch(physics::equals);
        
        check5 = Arrays.stream(courses).anyMatch(chemistry::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        check6 = Arrays.stream(courses).anyMatch(physics::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        //If, else statements to check if both pre requisistes and combination
        //courses are met
        if (preReqCheck && check1 == true)
        {
            accepted = true;
        }
        else if (preReqCheck && check2 == true)
        {
            accepted = true;
        }
        else if (preReqCheck && check3 == true)
        {
            accepted = true;
        }
        else if (preReqCheck && check4 == true)
        {
            accepted = true;
        }
        else if (preReqCheck && check5 == true)
        {
            accepted = true;
        }
        else if (preReqCheck && check6 == true)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooBusinessAdministrationCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooBusinessAdministrationCourses(String [] courses)
    {
        //Stores boolean of acceptance status 
        boolean accepted;
        //Stores required courses
        String requiredMath1 = "MCV4U";
        String requiredMath2 = "MHF4U";
        String requiredEnglish = "ENG4U";
        
        //Uses array class to determine if required courses are present in courses array
        accepted = Arrays.stream(courses).anyMatch(requiredMath1::equals) && 
                   Arrays.stream(courses).anyMatch(requiredMath2::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterComputerScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    * Goes through all combinations from the group of courses where only 2 courses are needed
    * to check if the user meets at least one of them to determine acceptance
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterComputerScienceCourses(String [] courses)
    {
        //Stores boolean for if user meets pre requisite courses and checks
        //for all other posible combinations
        boolean preReqCheck, check1, check2, check3, check4, check5, check6, 
                check7, check8, check9, check10, check11, check12, check13, 
                check14, check15, accepted;
        //Stores required courses
        String requiredMath1 = "MCV4U";
        String requiredEnglish = "ENG4U";
        //Stores courses from list from where 2 are needed
        String biology = "SBI4U";
        String chemistry = "SCH4U";
        String physics = "SPH4U";
        String spaceScience = "SES4U";
        String computerScience = "ICS4U";
        String computerEngineering = "TEJ4M";
        
        //Uses array class to check if pre requisite courses are present in array
        preReqCheck = Arrays.stream(courses).anyMatch(requiredMath1::equals) && 
                      Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Check all possible combinations from list and stores result in boolean
        check1 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(chemistry::equals);
        
        check2 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(physics::equals);
        
        check3 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        check4 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(computerScience::equals);
        
        check5 = Arrays.stream(courses).anyMatch(biology::equals) && 
                 Arrays.stream(courses).anyMatch(computerEngineering::equals);
        
        check6 = Arrays.stream(courses).anyMatch(physics::equals) && 
                 Arrays.stream(courses).anyMatch(chemistry::equals);
        
        check7 = Arrays.stream(courses).anyMatch(physics::equals) && 
                 Arrays.stream(courses).anyMatch(computerScience::equals);
        
        check8 = Arrays.stream(courses).anyMatch(physics::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        check9 = Arrays.stream(courses).anyMatch(physics::equals) && 
                 Arrays.stream(courses).anyMatch(computerEngineering::equals);
        
        check10 = Arrays.stream(courses).anyMatch(chemistry::equals) && 
                 Arrays.stream(courses).anyMatch(spaceScience::equals);
        
        check11 = Arrays.stream(courses).anyMatch(chemistry::equals) && 
                 Arrays.stream(courses).anyMatch(computerScience::equals);
        
        check12 = Arrays.stream(courses).anyMatch(chemistry::equals) && 
                 Arrays.stream(courses).anyMatch(computerEngineering::equals);
        
        check13 = Arrays.stream(courses).anyMatch(spaceScience::equals) && 
                 Arrays.stream(courses).anyMatch(computerScience::equals);
        
        check14 = Arrays.stream(courses).anyMatch(spaceScience::equals) && 
                 Arrays.stream(courses).anyMatch(computerEngineering::equals);
        
        check15 = Arrays.stream(courses).anyMatch(computerScience::equals) && 
                 Arrays.stream(courses).anyMatch(computerEngineering::equals);
        
        //If, else statements to check if both pre requisistes and combination
        //courses are met
        if (preReqCheck && check1 == true)
        {
           accepted = true; 
        }  
        else if (preReqCheck && check2 == true)
        {
            accepted = true;
        } 
        else if (preReqCheck && check3 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check4 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check5 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check6 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check7 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check8 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check9 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check10 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check11 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check12 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check13 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check14 == true)
        {
           accepted = true; 
        }
        else if (preReqCheck && check15 == true)
        {
            accepted = true;
        }
        else 
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterLifeScienceCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    * Goes through all combinations from the group of courses where only 2 courses are needed
    * to check if the user meets at least one of them to determine acceptance
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterLifeScienceCourses(String [] courses)
    {
        //Stores boolean for if user meets pre requisite courses and checks
        //for all other posible combinations
        boolean preReqCheck, check1, check2, accepted;
        //Stores required courses
        String requiredEnglish = "ENG4U";
        String requiredBiology = "SBI4U";
        //Stores courses from 2 list where user
        //Needs one course from each list 
        String advancedFunctions = "MHF4U";
        String calculus = "MCV4U";
        String chemistry = "SCH4U";
        String physics = "SPH4U";
        
        //Uses arrays class to check if pre requisistes are present is courses array
        preReqCheck = Arrays.stream(courses).anyMatch(requiredBiology::equals) && 
                      Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //uses array class to check if either of 2 courses are present in both lists
        check1 = Arrays.stream(courses).anyMatch(advancedFunctions::equals) || 
                 Arrays.stream(courses).anyMatch(calculus::equals);
        
        check2 = Arrays.stream(courses).anyMatch(chemistry::equals) || 
                 Arrays.stream(courses).anyMatch(physics::equals);
        
        //Checks if all three booleans are true to grant eligiblity 
        if (preReqCheck && check1 && check2 == true)
        {
            accepted = true;
        }
        else 
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterBusinessAdministrationCourses 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates a boolean for if the user inputted the required course
    * It uses the arrays class to find the strings of required courses
    *
    * Parameters: final String[] courses: a string created the getCourses method
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterBusinessAdministrationCourses(String [] courses)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores required courses
        String requiredMath1 = "MCV4U";
        String requiredMath2 = "MHF4U";
        String requiredEnglish = "ENG4U";
        
        //Uses arrays class to check if all required courses are present in courses array
        accepted = Arrays.stream(courses).anyMatch(requiredMath1::equals) && 
                   Arrays.stream(courses).anyMatch(requiredMath2::equals) && 
                   Arrays.stream(courses).anyMatch(requiredEnglish::equals);
        
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: getMarks
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: none
    *
    * Description:
    * Creates an array to hold the user's marks
    * It uses a for loop to iterate through the array, asking the user
    * for each of their 6 marks each time.
    * It uses try and catch function to eliminate errors from letters
    *
    * Parameters: final int SIZE: constant storing 6, the max marks
    *
    * Return: userMarks: array with all of the user's marks
    */
    public static double [] getMarks(final int SIZE)
    {
        //Creates array to store the user's marks
        //Its the size of the max marks a student can have
        double [] userMarks = new double [SIZE];
        
        //While loop for try and catch function
        while (true)
        { 
            //Trys to get user's marks as numbers
            try
            { 
                /*
                * i starts at 0
                * will continue to add one each time
                * until i is less than SIZE
                * Records a mark in the array each time
                */
                for (int i = 0; i < SIZE; i++)
                {
                    userMarks[i] = Double.parseDouble(JOptionPane.showInputDialog
                    (null, "Enter your marks"));
                }
                /*
                * i starts at 0
                * will continue to add one each time
                * until i is less than SIZE
                * Prints the user's marks in the JOptionPane
                */
                for (int i = 0; i < SIZE; i++)
                {
                    JOptionPane.showMessageDialog(null, "Your marks are... "+ 
                                                    userMarks[i]);
                }
                //Returns array of user's marks to main method
                return (userMarks);
            }
            //Catches any errors from letters and strings
            catch (NumberFormatException e)
            {
                //Shows message that user can only enter numbers
                JOptionPane.showMessageDialog(null, 
                        "Please enter a NUMBER from 0-100");
            }
        }   
        
    }
    
    /**
    * method name: meetsUoftComputerScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftComputerScienceMarks(double [] marks, final int SIZE)
    {
        //Stores boolean of user's acceptance status 
        boolean accepted;
        //Stores target mark
        double target = 90;
        //Sets avg and total at 0
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }

        //Calculates average and rounds to 2 decimal places
       avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Checks if average is greater than or equal to the target
        //To determine acceptance status 
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsUoftLifeScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftLifeScienceMarks(double [] marks, final int SIZE)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores target marks
        double target = 85;
        //Sets avg and total to 0
        double avg = 0;
        double total = 0;

        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Calculates average and rounds to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Checks if average is greater than or equal to target
        //to determine acceptance status 
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }

    /**
    * method name: meetsUoftBusinessAdministrationMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsUoftBusinessAdministrationMarks(double [] marks, 
                                                                final int SIZE)
    {
        //Stores boolean for acceptance status
        boolean accepted;
        //Stores target mark
        double target = 87;
        //Sets variables
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Calculates average and rounds to 2 decimal places
       avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows average to user
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Checks if average is greater than or equal to the target
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooComputerScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooComputerScienceMarks(double [] marks, 
                                                            final int SIZE)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores target mark
        double target = 90;
        //Lets variables
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Caluclates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user the average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if average is greater than or equal to target mark
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooLifeScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooLifeScienceMarks(double [] marks, 
                                                        final int SIZE)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores target mark
        double target = 80;
        //Sets variables 
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Caluclates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if average is greater than or equal to target mark
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsWaterlooBusinessAdministrationMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsWaterlooBusinessAdministrationMarks
                            (double [] marks, final int SIZE)
    {
        //Stores boolea of acceptance status
        boolean accepted;
        //Stores target mark
        double target = 85;
        //Sets variables 
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Caluclates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if average is greater than or equal to target
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns booolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterComputerScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterComputerScienceMarks(double [] marks, 
                                                            final int SIZE)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores target mark
        double target = 92;
        //Sets variables 
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Calculates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average 
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if average is greater than or equal to the target
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterLifeScienceMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterLifeScienceMarks(double [] marks, 
                                                        final int SIZE)
    { 
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores boolean of target mark
        double target = 87;
        //Sets variables 
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Calculates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows user their average
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if user's marks is greater than or equal to the target mark 
        //And stores result in accepted boolean
        if (avg >= target)
        {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns boolean of acceptance status to main method 
        return (accepted);
    }
    
    /**
    * method name: meetsMcMasterBusinessAdministrationMarks 
    *
    * Author: Aseef Ali Hasan
    *
    * Date: August 19 2021
    *
    * Version: 1.0
    *
    * Change log: 8/19/21 Added feature of printing average
    *
    * Description:
    * Creates a boolean for if the user's average meets the target for 
    * their intended program.
    * It uses a for loop to find the total
    * It calculates the user's average
    *
    * Parameters: final String[] courses: a string created the getMars method
    * final int SIZE: a constant holding the max marks a student can have
    *
    * Return: boolean of their acceptance status 
    */
    public static boolean meetsMcMasterBusinessAdministrationMarks
                            (double [] marks, final int SIZE)
    {
        //Stores boolean of acceptance status
        boolean accepted;
        //Stores target mark
        double target = 87;
        //Sets variables 
        double avg = 0;
        double total = 0;
        
        /*
        * i starts at 0
        * will continue to add one each time
        * until i is less than or equal to 10
        * adds mark to total each time
        */
        for (int i = 0; i < SIZE; i++)
        {
            total = total + marks[i];
        }
        
        //Calculates average to 2 decimal places
        avg = total/SIZE;  
       avg = avg * 100;
       avg = Math.round(avg);
       avg = avg / 100;
       //Shows average to user
       JOptionPane.showMessageDialog(null, "Your average is " + avg);
        
        //Determines if average is greater than or equal to target mark 
        //And stores result in accepted boolean
        if (avg >= target) 
       {
            accepted = true;
        }
        else
        {
            accepted = false;
        }
        //Returns acceptance status to main method 
        return (accepted);
    }
}
