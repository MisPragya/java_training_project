package com.capgemini.view;
import com.capgemini.service.*;
import com.capgemini.model.*;
import java.util.*;
public class Admin {

	private static Scanner scanner=new Scanner(System.in);
	static StudentSchedular studSc=new StudentSchedular();
	static int[] rollNums=new int[10];
	static Student[] students=new Student[10];
	static int counter=0;
	
	public static void main(String[] args) {
		int choice;
		while(true)
		{
			System.out.println("1. Add a student");
			System.out.println("2. View all students' details");
			System.out.println("3. Show student details by roll number");
			System.out.println("4. Show student details by course name");
			System.out.println("5. Show student count by course name");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice: ");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				addStudent();
				break;
			case 2:
				getStudentsDetails();
				break;
			case 3:
				getStudentByRoll();
				break;
			case 4:
				getStudentByCourse();
				break;
			case 5:
				getStudentByCountByCourse();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Oops! Wrong choice.");
			}	
		}		
	}

	private static void addStudent()
	{
		System.out.println("Enter roll number: ");
		int rollNum=scanner.nextInt();
		System.out.println("Enter name: ");
		String name=scanner.next();
		System.out.println("Enter no. of courses student is enrolled in: ");
		int courseCount=scanner.nextInt();
		String[] courses=new String[courseCount];
		System.out.println("Enter courses: ");
		for(int i=0;i<courseCount;i++)
			courses[i]=scanner.next();
		
	    students[counter]=studSc.addStudent(rollNum,name,courses,rollNums);
	    
	    counter = counter + 1;
	    if(students[counter - 1]==null) {
	    	System.out.println("Roll number already exists or is invalid!");
	    	rollNums[counter-1]=0;
	    	counter--;
	    }else {
	    	System.out.println(" student added successfully.......");
	    	rollNums[counter-1] = students[counter-1].getRollNum();
	    }
	}

	private static void getStudentsDetails() {
		
		System.out.println("*************** Students Details *****************: ");
		
		if(students == null)
			System.out.println("No Records Exists !!");
		else {
	
				for(Student student: students){
				if(student != null) {
					System.out.println("******************************************************************************************");
					System.out.println("Name: " + student.getName());
					System.out.println("Roll: " + student.getRollNum());
					System.out.println("Course: ");
					
					for(String course: student.getCourses())
						System.out.println(course);	
					
					System.out.println("******************************************************************************************");
				}
			}
		}
		
	}
	
	private static void getStudentByRoll() {
		
		System.out.println("Enter roll number to get details: ");
		int rollNum=scanner.nextInt();
		
		boolean rollExists = checkIfRollExists(rollNum,rollNums);
		if(rollExists) {
		
			System.out.println("*************** Student Details *****************: ");
			
			for(Student student: students){
				if(student != null && student.getRollNum() == rollNum) {
					System.out.println("Name: " + student.getName());
					System.out.println("Roll: " + student.getRollNum());
					System.out.println("Course: ");
					for(String course: student.getCourses())
						System.out.println(course);	
				}
			}
		}
		else
			System.out.println("Roll number doesn't exist!");
		
	}
	
	private static void getStudentByCourse() {
		
		System.out.println("Enter Course name to get details: ");
		String course=scanner.next();
		int count = 0;
		
		for(Student student: students){
			if(student != null) {
				for(String c: student.getCourses()) {
					if(c.equalsIgnoreCase(course)) {
						count++;
						System.out.println("Name: " + student.getName());
						System.out.println("Roll: " + student.getRollNum());
						System.out.println("Course: ");
						for(String tempCourse: student.getCourses())
							System.out.println(tempCourse);	
					}
				}
			}
		}
		if(count==0)
			System.out.println("No record found for course: " + course);
		
	}
	
	private static void getStudentByCountByCourse() {
		
		System.out.println("Enter Course name to get details: ");
		String course=scanner.next();
		int courseCount = 0;
		
		for(Student student: students){
			if(student != null) {
				for(String c: student.getCourses())
					if(c.equalsIgnoreCase(course))
						courseCount++;
			}
 		}
		
		if(courseCount == 0)
			System.out.println("Number of students enrolled for course " + course + " is: " + courseCount);
		else
			System.out.println(courseCount + " students enrolled for course: " + course);
	}
	
	private static boolean checkIfRollExists(int rollNum,int[] rollNums)
	{
		boolean rollExists=false;
		int i = 0;
		
		while(i <10 && rollNums[i] > 0 )
		{
			if(rollNums[i]==rollNum)
			{
				rollExists=true;
				return rollExists;
			}
			i++;
		}
		return rollExists;
	}
	
}
