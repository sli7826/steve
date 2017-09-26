package attendance;

import java.util.Scanner;

public class AttendanceApp {


	private Attendee[] students;



	public AttendanceApp(){

		createStudentRecords();
	}

	public void run(){
		AttendanceMain.print("Welcome to BTHS Attendance 1.0! To sign in, just type your last name. To view all attendance records, type \"Attendance\".");


		String last = AttendanceMain.getInput();

		while(!last.toLowerCase().equals("attendance")){
			last = searchForStudent(last);
		}
		attendanceReport();
		
	}
	
	public void attendanceReport(){
		AttendanceMain.print("Here are the present students today:");
		String s = "";
		for(int i = 0; i < students.length; i++){

			s+=students[i].getReportString();
		}
		System.out.println(s);
		AttendanceMain.print("(Press enter)");
		AttendanceMain.getInput();
		run();
		
	}
	


	public String searchForStudent(String last){
		while(notFound(last)){
			AttendanceMain.print("Sorry. That name was not found. Please try again. Enter the LAST name only.");
			last = AttendanceMain.getInput();
		}
		Attendee selected = getStudentWithName(null, last);
		if(multipleMatches(last)){
			
			AttendanceMain.print("There are multiple records with last name '"+last+"'. Please enter a first name.");
			String first = AttendanceMain.getInput();
			while(notFound(first, last)){
				AttendanceMain.print("Sorry. That name, "+first+" "+last+", was not found. Please try again. Enter the FIRST name only.");
				first = AttendanceMain.getInput();
			}
			selected = getStudentWithName(first, last);
		}
		if(selected == null){
			AttendanceMain.print("Error. Please start over. (Press enter)");
			AttendanceMain.getInput();
		}else{
			if(selected.isPresent()){
				AttendanceMain.print(selected.getFirstName()+" "+selected.getLastName()+" has ALREADY been marked present. No change has been made to the record.");
			}else{
				selected.setPresent(true);
				AttendanceMain.print("Excellent. "+selected.getFirstName()+" "+selected.getLastName()+" has been marked present.");				
			}
		}
		
		AttendanceMain.print("Welcome to BTHS Attendance 1.0! To sign in, just type your last name. To view all attendance records, type \"Attendance\".");
		return AttendanceMain.getInput();
		
	}
	
	public Attendee getStudentWithName(String first, String last) {
		for(int i = 0; i < students.length; i++){
			if(last.toLowerCase().equals(students[i].getLastName().toLowerCase())){
				if(first == null){
					return students[i];
				}else{

					if(first.toLowerCase().equals(students[i].getFirstName().toLowerCase())){
						return students[i];
					}

				}
			}
		}
		//student is not found, return null
		return null;
	}

	public String getAllFirstNamesMAtchingLastName(String entry) {
		String firstNams= "";
		for(int i = 0; i < students.length; i++){
			if(entry.toLowerCase().equals(students[i].getLastName().toLowerCase())){
				firstNams+=students[i].getFirstName()+" ";
			}
		}
		return firstNams;
	}

	public boolean multipleMatches(String entry) {
		int countMatches = 0;
		for(int i = 0; i < students.length; i++){
			if(entry.toLowerCase().equals(students[i].getLastName().toLowerCase())){
				countMatches ++;
			}
		}
		return countMatches > 1;
	}

	public boolean notFound(String last) {
		for(int i = 0; i < students.length; i++){
			if(students[i].matches(last)){
				return false;
			}
		}
		return true;
	}

	public boolean notFound(String first, String last) {
		for(int i = 0; i < students.length; i++){
			if(students[i].mathces(first,last)){
				return false;
			}
		}
		return true;
	}




	public void createStudentRecords(){
		//create an Attendee for every name in the record
		students = new Attendee[AttendanceMain.names.length];
		for(int i = 0; i < AttendanceMain.names.length; i++){
			//break the name into first and last names:
			String wholeName = AttendanceMain.names[i];
			String first = wholeName.substring(0, wholeName.indexOf(" "));
			String last = wholeName.substring(wholeName.indexOf(" ")+1,wholeName.length());
			students[i] = new Student(first, last);
		}
	}


}
