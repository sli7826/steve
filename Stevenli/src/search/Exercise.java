package search;

public class Exercise {
	
	public static void main(String[] args){
		towerSolution(3,"a","b","c");
	}

	public static int countPrimeFactors(int value, int testPrime) {
		if(value==1) {
			return 0;
		}
		else if(value%testPrime==0){
			return 1+countPrimeFactors(value/testPrime,testPrime);
		}else {
			return countPrimeFactors(value,testPrime+1);
		}
		
	}

	public static long factorial(int value) {
		if(value==0) return 1;
		else return factorial(value-1)*value;
	}
	
	public static void towerSolution(int n,String s,String h,String e) {
		s="A";
		h="B";
		e="C";
		if(n==2) {
			System.out.println(s+" to "+h);
			System.out.println(s+" to "+e);
			System.out.println(h+" to "+e);
		}
		else {
			System.out.println(s+" to "+h);
			towerSolution(n-1,e,s,h);
		}
	}
	
}
