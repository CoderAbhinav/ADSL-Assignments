package Solutions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class StudentDatabase{
    static class Student{
        private String rollNo;
        private String firstName;
        private String lastName;
        private String department;
        private int year;
        private char division;

        public Student(String rollNo, String firstName, String lastName, String department, int year, char division) {
            this.rollNo = rollNo;
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = department;
            this.year = year;
            this.division = division;
        }

        public Student(String data){
            List<String> spliitedData = List.of(data.split(","));
            this.rollNo = spliitedData.get(0);
            this.firstName = spliitedData.get(1);
            this.lastName = spliitedData.get(2);
            this.department = spliitedData.get(3);
            this.year = Integer.parseInt(spliitedData.get(4));
            this.division = spliitedData.get(5).charAt(0);
        }


        @Override
        public String toString() {
            return rollNo + "," +
                    firstName + "," +
                    lastName + "," +
                    department + "," +
                    String.valueOf(year) + ","+
                    division + ";";

        }
    }

    private ArrayList<Student> studentList;
    private File databaseFile;

    Logger dbLogger = Logger.getLogger(StudentDatabase.class.getName());

    public StudentDatabase(String databaseFileName) throws IOException{
        databaseFile = new File(databaseFileName); // file object
        try {
            if (databaseFile.createNewFile()){ // creating file
                dbLogger.log(Level.INFO, "Created File");
            }else{
                dbLogger.log(Level.INFO, "Already Exists");
            }
            studentList = new ArrayList<>();
            Scanner sc = new Scanner(databaseFile);
            while (sc.hasNextLine()){
                studentList.add(new Student(sc.nextLine()));
            }
        } catch (IOException e) { // exception
            dbLogger.log(Level.SEVERE, "IO Exception");
            e.printStackTrace();
        }
    }

    public void display(){
        for (Student student : studentList){
            System.out.println(student.toString());
        }
    }
}

public class StudentDatabaseAssignment {
    public static void main(String[] args) {
        try {
            StudentDatabase db = new StudentDatabase("a.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
