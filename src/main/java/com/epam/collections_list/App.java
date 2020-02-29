package com.epam.collections_list;
import java.util.ArrayList;
import java.util.Scanner;
class Student
{
	private String studentName;
	private int studentRollNo;
	private double studentTotalMarks;
	private String studentStream;
	Student()
	{
		studentName="Rohan Sinha";
		studentRollNo=1;
		studentTotalMarks=480;
		studentStream="CSE";
	}
	Student(String studentName,int studentRollNo,double studentTotalMarks,String studentStream)
	{
		this.studentName=studentName;
		this.studentRollNo=studentRollNo;
		this.studentTotalMarks=studentTotalMarks;
		this.studentStream=studentStream;
	}
	int getstudentRollNo()
	{
		return studentRollNo;
	}
	static Student studentRecordFetch(int studentRollNo,ArrayList<Student> students)
	{
		Student T=null;
		if(students.isEmpty()==true)
		{
			System.out.println("Record Empty---");
		}
		boolean flag=false;
		for(Student S:students)
		{
			if(S.getstudentRollNo()==studentRollNo)
			{
				flag=true;
				T=S;
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("No Records available matching the condition");
		}
		return T;
	}
	static void studentRecordInsert(Student student,ArrayList<Student> students)
	{
		boolean flag=false;
		Student studentReference=null ;
		for(Student S:students)
		{
			if(S.getstudentRollNo()==student.getstudentRollNo()) 
			{
				flag=true;
				studentReference=S;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Record Existing");
			studentRecordDisplaySpecific(studentReference);
		}
		else
		{
			students.add(student);
			System.out.println("Record Added");
		}
	}
	static void studentRecordDisplay(ArrayList<Student> students)
	{
		if(students.isEmpty()==true)
		{
		System.out.println("No Records----");
		return;
		}
		for(Student S:students)
		{
			studentRecordDisplaySpecific(S);
			System.out.println("-------------------------------");
		}
	}
	public boolean equals(Object obj) {
	    if (obj instanceof Student) {
	        Student S = (Student) obj;
	        return S.studentRollNo == this.studentRollNo;
	    }
	    return false;
	}
	static void studentRecordDisplaySpecific(Student student)
	{
		if(student==null) 
		{
			System.out.println("No record available--");
			return;
		}
		System.out.println(" Roll no    :"+student.studentRollNo);
		System.out.println(" Name       :"+student.studentName);
		System.out.println(" Total Marks:"+student.studentTotalMarks);
		System.out.println(" Stream     :"+student.studentStream);
	}
	static void studentRecordDelete(int studentRollNo,ArrayList<Student> students)
	{
		Student S=studentRecordFetch(studentRollNo,students);
		if(S==null)
		return;
		System.out.println(" Record Deleted Successfully");
		students.remove(S);
	}
}
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Student> students = new ArrayList<Student>();
        Scanner scanner = new Scanner(System.in);
        students.add(new Student("Akash Chatterjee",2,490,"CSE"));
        students.add(new Student("Amit Kumar",3,400,"CSE"));
        students.add(new Student("Trideep Chakraborty",7,350,"ECE"));
        students.add(new Student("Amarjeet Gupta",4,400,"ME"));
        students.add(new Student("Tapan Kumar Das",6,495,"CSE"));
        students.add(new Student("Sayan Maity",8,450,"CSE"));
        students.add(new Student("Ansab Mumtaz",10,489,"EEE"));
        students.add(new Student("Chiraag Mishra",9,440,"CSE"));
        students.add(new Student("Suraj Kumar Singh",5,300,"ECE"));
        students.add(new Student("Anurag Pandey",11,500,"BT"));
        int choice,studentRollNo;
        double studentTotalMarks;
        char choiceAtEnd;
        String studentName,studentStream;
        do
        {
        	System.out.println("Menu");
        	System.out.println("1.Insert Data");
        	System.out.println("2.Display Data");
        	System.out.println("3.Delete Data");
        	System.out.println("4.Fetch Data");
        	//System.out.println("5.Exit");
        	System.out.println("Enter your choice");
        	choice=scanner.nextInt();
        	switch(choice)
        	{
        	case 1:System.out.println("Enter the Student Name");
        		   scanner.nextLine();
        		   studentName=scanner.nextLine();
        		   System.out.println("Enter the Student Roll Number");
        		   studentRollNo=scanner.nextInt();
        		   System.out.println("Enter the Student Total Marks");
        		   studentTotalMarks=scanner.nextDouble();
        		   scanner.nextLine();
        		   System.out.println("Enter the Student Stream");
        		   studentStream=scanner.nextLine();
        		   Student.studentRecordInsert(new Student(studentName,studentRollNo,studentTotalMarks,studentStream),students);
        		   break;
        	case 2:Student.studentRecordDisplay(students);
        	       break;
        	case 3:System.out.println("Enter the Roll Number of the student");
        		   studentRollNo=scanner.nextInt();
        		   Student.studentRecordDelete(studentRollNo, students);
        		   break;
        	case 4:System.out.println("Enter the Roll Number of the student");
 		           studentRollNo=scanner.nextInt();
 		           Student S=Student.studentRecordFetch(studentRollNo,students);
 		           Student.studentRecordDisplaySpecific(S);
 		           break;
 		    default:System.out.println("Wrong Choice");
        	}
        	System.out.println("Do you want to continue(y/n)");
        	 choiceAtEnd=scanner.next().charAt(0);
        	 scanner.nextLine();
        }while(choiceAtEnd=='y'||choiceAtEnd=='Y');
        scanner.close();
    }
}
// program developed by Rahul Sinha

