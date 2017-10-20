package classwork;

public class Person {
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private String nickname;
	private Person[] friends;
	public static final String[] FIRST_START= {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE= {"isti","icha","er","et","ere","era","ina"};
	public static final String[] FIRST_END= {"","na","n","r","tian","s","rs"};
	public static final String[] LAST_START= {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] LAST_MIDDLE= {"om","o","a","e","i","u","is"};
	public static final String[] LAST_END= {"","son","ne","er","a","ing","ton"};
	public Person(String first,String last,Borough home) {
		firstName=first;
		lastName=last;
		this.home=home;
		nickname=createNickname(firstName);
		this.hobby=Hobby.randomHobby();
		friends=new Person[3];
	}
	public void mingle(Person[] people) {
		for(Person p:people) {
			if(p!=this) {
				p=betterFriend(p,friends[0]);
				addfriendToFirstPlace(p);
			}
		}
	}
	private Person betterFriend(Person p, Person q) {
		if(p==null)
			return q;
		if(q==null)
			return p;
		if(p.getClass()==this.getClass()&&q.getClass()==this.getClass()) {
			if(p.getHobby()==this.getHobby())
				return p;
			if(q.getHobby()==this.getHobby())
				return q;
		}
		if(p.getClass()==this.getClass()) {
			return p;
		}
		if(q.getClass()==this.getClass()) {
			return q;
		}
		return p;
	}
	public void printFriends() {
		System.out.println("My name is "+firstName+" "+lastName+". Call me "+nickname+". and these are my friends:");
		for(Person f:friends) {
			if(f!=null) System.out.println(f);
		}
	}
	public void addfriendToFirstPlace(Person p) {
		for(int i=friends.length-1;i>0;i--) {
			friends[i]=friends[i-1];
		}
		friends[0]=p;
	}
	public String toString() {
		return "My name is "+firstName+" "+lastName+". Call me "+nickname+" and I live in "+home.toString()+". I like "+hobby.toString()+".";
	}
	public Hobby getHobby() {
		return hobby;
	}
	public static String createNickname(String name) {
		String[] a= {"a","e","i","o","u"};
		int b=0;
		for (int i=0;i<name.length();i++) {
			for(String c:a) {
				if(name.substring(i, i+1).equalsIgnoreCase(c)) {
					b++;
				}
			}
			if(b==2) {
				return name.substring(0, i);
			}	
		}
		return name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname=createNickname(firstName);
	}
	
}
