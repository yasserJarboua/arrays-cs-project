package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for(Student stu:students){
            if(stu.getAge()>oldest.getAge()){
                oldest=stu;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for(Student student:students){
            if(student.getAge()>=18){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double average=0;
        int counter=0;
        for(Student std:students){
            average+=std.getGrade();
            counter++;
        }
        return average/counter;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        Student s=null;
        for(Student std:students){
            if (std.getName().equals(name)){
                s=std;
            }
        }
        return s;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students,(s1,s2)->s2.getGrade()-s1.getGrade());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student std:students){
            if (std.getGrade()>=15){
                System.out.println(std.toString());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student std:students){
            if (std.getId()==id){
                std.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i=0;i<students.length;i++){
            for(int j=i+1;j<students.length;j++){
                if(students[j].getName().equals(students[i].getName()) ){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student newStudents[]=new Student[students.length+1];
        for(int i=0;i<students.length;i++){
            newStudents[i]=students[i];
        }
        newStudents[students.length]=newStudent;
        return  newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student arr[]=new Student[5];
        arr[0]=new Student(1,"Hamza",20);
        arr[1]=new Student(2,"Alar");
        arr[2]=new Student(3,"Dina",21);
        arr[3]=new Student(4,"Mohamed",20,19);
        arr[4]=new Student(5,"Adam",19,18);

        arr[1].setAge(22);
        arr[1].setGrade(14);
        arr[0].setGrade(13);
        arr[2].setGrade(12);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("The oldest student is : "+findOldest(arr));

        // 3) Count adults
        System.out.println("The adults  number is : "+ countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade is : " + averageGrade(arr));

        // 5) Find by name
        System.out.println("The student of  name Mohamed has : ");
        System.out.println(findStudentByName(arr,"Mohamed"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        System.out.println("\nUpdated id=4? " + updateGrade(arr,4,20));
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("Duplicate names : "+hasDuplicateNames(arr));

        // 10) Append new student
        Student s=new Student(6,"Nizare",19,17);
        arr=appendStudent(arr,s);
        // 11)
        Student school[][]=new Student[2][3];
        school[0][0]=arr[0];
        school[0][1]=arr[1];
        school[0][2]=arr[2];
        school[1][0]=arr[3];
        school[1][1]=arr[4];
        school[1][2]=arr[5];
        for(int i=0;i<school.length;i++){
            System.out.println("The students of the class number "+(i+1)+" are :\n");
            for(int j=0;j<school[0].length;j++){
                System.out.println(school[i][j]);
            }
            System.out.println("\n");
        }
        Student  top=null;
        for(int i=0;i<school.length;i++){
            System.out.println("The top students of the class number "+(i+1)+" is :\n");
            top = school[i][0];
            for(int j=0;j<school[0].length;j++){
                if (school[i][j].getGrade()>top.getGrade()){
                    top=school[i][j];
                }
            }
            System.out.println(top+"\n");
        }
    }
}

