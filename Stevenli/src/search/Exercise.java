package search;

public class Exercise {
	
	public static void main(String[] args){
		System.out.println(fib(8));
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
		if(n==1) {
			System.out.println(s+" to "+e);
		}
		else {
			towerSolution(n-1,s,e,h);
			System.out.println(s+" to "+e);
			towerSolution(n-1,h,s,e);
		}
	}
	public static int fib(int n) {
		if(n==0)return 0;
		if(n==1) {
			return 1;
		}else {
			return fib(n-1)+fib(n-2);
		}
	}
}
