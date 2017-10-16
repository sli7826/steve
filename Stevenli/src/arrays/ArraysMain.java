package arrays;

import java.util.Arrays;

public class ArraysMain {
	private String[] testArray;
	private int[] intRay;
	public ArraysMain() {
		intRay=new int[50];
		populate(intRay);
		System.out.println(Arrays.toString(intRay));
	}

	private void populate(int[] intRay) {
		for(int i=0;i<intRay.length;i++) {
			intRay[i]=diceRoll(2);
		}
	}

	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	public void notes() {
		testArray=new String[50];
		for(String value:testArray) {
			System.out.println(value);
		}
	}
	public int diceRoll(int numberOfDice) {
		int a=0;
		while(numberOfDice!=0) {
			int b=(int)((Math.random()*6)+1);
			a+=b;
			numberOfDice--;
		}
		return a;
	}

}
