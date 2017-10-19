package classwork;

public class ObjectArrays {

	public ObjectArrays() {
		Person[] people=new Person[20];
		populate(people);
		Person[] people2=selectGroup(people,20);
		Person[] people3=selectGroup(people,20);
		double a=0;
		for(int i=0;i<100;i++) {
			people2=selectGroup(people,20);
			people3=selectGroup(people,20);
			a+=countDifferences(people3,people2);
		}
		System.out.println(a/100);
	}

	public void populate(Person[] people) {
		for(int i=0;i<people.length;i++) {
			String firstName=randomNameFrom(Person.FIRST_START,Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName=randomNameFrom(Person.LAST_START,Person.LAST_MIDDLE,Person.LAST_END);
			Borough b=randomBorough();
			if(Math.random()<.6) {
				int grade=(int)(Math.random()*5)+9;
				people[i]=new Student(firstName,lastName,b,grade);
			}else {
				people[i]=new Person(firstName,lastName,b);
			}
		}
		
	}

	public Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	public String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	public String get(String[] a) {
		return a[(int)(Math.random()*a.length)];
	}
	public Person[] selectGroup(Person[] arr,int n) {
		Person[] a=new Person[n];
		Person b;
		for(int i=0;i<n;i++) {
			b=arr[(int)(Math.random()*arr.length)];
			for(int j=0;j<a.length;j++) {
				if(a[j]==b) {
					while(a[j]==b) {
						b=arr[(int)(Math.random()*arr.length)];
					}
					j=0;
				}
			}
			a[i]=b;
		}
		return a;
	}
	public static boolean personInGroup(Person[] a,Person b){
		for(Person p:a) {
			if(p==b)
				return true;
		}
		return false;
	}
	public int countDifferences(Person[] arr1,Person[] arr2) {
		int a=0;
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i])
				a++;
		}
		return a;
	}

}
