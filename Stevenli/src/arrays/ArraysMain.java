package arrays;

import java.util.Arrays;

public class ArraysMain {
	private String[] testArray;
	private int[] intRay;
	public ArraysMain() {
		intRay=new int[52];
		//populate(intRay);
		//checkOccurences(intRay,3,18);
		populate1ToN(intRay);
		shuffle(intRay);
		System.out.println(Arrays.toString(intRay));
	}

	private void shuffle(int[] arr) {
		for(int i=0;i<500;i++) {
			swap(arr,(int)(Math.random()*arr.length),(int)(Math.random()*arr.length));
		}
		
	}

	private void swap(int[] arr, int i, int j) {
		int a=arr[i];
		arr[i]=arr[j];
		arr[j]=a;
		
	}

	private void populate1ToN(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i]=i+1;
		}
		
	}

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter=new int[end-start+1];
		for(int value:intRay) {
			counter[value-start]++;
		}
		for(int i=0;i<counter.length;i++) {
			System.out.println("A "+(start+i)+" was rolled "+counter[i]+" times.");
		}
	}

	private void populate(int[] intRay) {
		for(int i=0;i<intRay.length;i++) {
			intRay[i]=diceRoll(3);
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
