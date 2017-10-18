package arrays;

import java.util.Arrays;

public class ArraysMain {
	private String[] testArray;
	private int[] intRay;
	public ArraysMain() {
		intRay=new int[25];
		populate(intRay);
		System.out.println("The longest consecutive rolls is "+longestConsecutiveSequence(intRay)[0]+" and it happened at "+longestConsecutiveSequence(intRay)[1]+". It started with a "+intRay[longestConsecutiveSequence(intRay)[1]-longestConsecutiveSequence(intRay)[0]]);
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
	public int[] reverseOrder(int[] arr) {
		int[] a=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			a[i]=arr[i];
		}
		for(int i=0;i<a.length/2;i++) {
			swap(a,i,a.length-i-1);
		}
		return a;
	}
	public int countLessThan(int[] arr, int n) {
		int a=0;
		for(int value:arr) {
			if(value<n) {
				a++;
			}
		}
		return a;
	}
	public void frontToBack(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			swap(arr,i,i+1);
		}
	}
	public void cycleThrough(int[] arr,int n) {
		while(n!=0) {
			frontToBack(arr);
			n--;
		}
	}
	public int[] longestConsecutiveSequence(int[] arr) {
		int current=1;
		int longest=0;
		int[] a=new int[2];
		int idx=0;
		for(int i=0;i<arr.length-1;i++) {
			if((arr[i]+1)==arr[i+1]) {
				current++;
			}
			else if(current>longest){
				longest=current;
				current=1;
				idx=i;
			}
			else {
				current=1;
			}
		}
		if(current>longest) {
			longest=current;
			a[1]=idx;
		}
		if(longest==0) {
			longest = arr.length;
			a[1]=0;
		}
		a[1]=idx+1;
		a[0]=longest;
		return a;
	}
	
}
