package classwork;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		//ObjectArrays OA=new  ObjectArrays();
		Person s=new Person("ben","nockles",Borough.NY_BOROUGHS[0]);
		int x=10;
		int[] a= {5,6,7};
		test(s,x,a);
		System.out.println(s+","+x+","+Arrays.toString(a));
	}
	public static void test(Person s,int x,int[] arr) {
		s.setFirstName("Ilona");
		x=5;
		//arr=new int[3];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
	}
	public static void test2(Person s,int x,int[] arr) {
		String name=s.getFirstName();
		x=5;
		//arr=new int[3];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
	}
}
