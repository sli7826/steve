package attendance;

public class Student implements Attendee {
	private String first;
	private String last;
	private boolean present;
	public Student(String first, String last) {
		this.first=first;
		this.last=last;
		present=false;
	}
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present=present;
	}
	public String getFirstName() {
		return first;
	}
	public String getLastName() {
		return last;
	}
	public boolean mathces(String first, String last) {
		return (first.toLowerCase().equals(this.first.toLowerCase())&& last.toLowerCase().equals(this.last.toLowerCase()));
	}
	public boolean matches(String last) {
		return(last.toLowerCase().equals(this.last.toLowerCase()));
	}
	public String getReportString() {
		String temp1=last;
		String temp2=first;
		if(last.length()>20) {
			temp1=last.substring(0, 17)+"...";
		}
		if(first.length()>20) {
			temp2=first.substring(0, 17)+"...";
		}
		while(temp1.length()<20) {
			temp1+=" ";
		}
		temp1+=temp2;
		while(temp1.length()<40) {
			temp1+=" ";
		}
		if(present)
			return temp1+"Present"+"\n";
		else
			return temp1+"Not Present"+"\n";
	}
	
}
