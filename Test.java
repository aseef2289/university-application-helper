public class Test{
  public static void main(String[] args){
    //Testing methods from Main

    //Test 1 using normal values for meetsUoftComputerScienceCourses 
    //String [] courses = {"ENG4U", "MCV4U", "MHF4U", "ICS4U", "SBI4U", "SPH4U"};
    final String [] COURSES_1 = {"ENG4U", "MCV4U", "MHF4U", "ICS4U", "SBI4U", "SPH4U"};
    //Test 2 using regular arguments but an number in a required field for meetsUoftComputerScienceCourses
    final String [] COURSES_2 = {"1", "MCV4U", "MHF4U", "ICS4U", "SBI4U", "SPH4U"};
    //Test 3 with a number in a non-required field for meetsUoftComputerScienceCourses
    final String [] COURSES_3 = {"1", "MCV4U", "MHF4U", "ICS4U", "SBI4U", "1"};
    //Test 4 with normal values for meetsUoftComputerScienceMarks
    final double [] MARKS = {76, 98, 87, 100, 95, 100};
    final int SIZE = 6;
    //Test 5 with normal values for meetsUoftComputerScienceMarks
    final double [] MARKS_2 = {0, 0, 0, 0, 0, 0};

    boolean result1 = Main.meetsUoftComputerScienceCourses(COURSES_1);
    System.out.println(result1);

    boolean result2 = Main.meetsUoftComputerScienceCourses(COURSES_2);
    System.out.println(result2);

    boolean result3 = Main.meetsUoftComputerScienceCourses(COURSES_3);
    System.out.println(result3);

    boolean result4 = Main.meetsUoftComputerScienceMarks(MARKS, SIZE);
    System.out.println(result4);

    boolean result5 = Main.meetsUoftComputerScienceMarks(MARKS_2, SIZE);
    System.out.println(result5);

  }
}