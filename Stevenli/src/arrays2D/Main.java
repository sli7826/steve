package arrays2D;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr= {0,1,0};
		changeNeighbor(arr,2);
		System.out.println(Arrays.toString(arr));

	}
	public static void changeNeighbor(int[] arr,int x) {
		if(x<arr.length) {
			arr[x]++;
			if(x!=0) {
				arr[x-1]--;
			}
			if(x!=arr.length-1) {
				arr[x+1]--;
			}
		}
	}

}
