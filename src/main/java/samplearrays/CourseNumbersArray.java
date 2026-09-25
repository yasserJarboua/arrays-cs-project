package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses =new int[registeredCourses.length+1];
        int newCourse=2170;
        int specificCourse=2080;
        for (int i=0;i<registeredCourses.length;i++){
            updatedCourses[i]=registeredCourses[i];
        }
        updatedCourses[registeredCourses.length]=newCourse;
        System.out.println("The student courses id's are :\n");
        for (int course:updatedCourses) System.out.println(course+"\n");
        for (int course:updatedCourses){
            if (course==specificCourse){
                System.out.println(true);
            }
        }
    }
}
