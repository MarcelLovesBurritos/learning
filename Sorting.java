/*Sorting
 * 1. Bubble
 * 2. Cocktail
 * 3. 
 * 4. 
 * 5. */

import java.util.*;

public class Sorting {
	
	public void bubbleSort (int[] array){
		int temp;
		boolean sorted = false;
		while (sorted == false){
			sorted = true;
			for (int i = 0; i < array.length - 1; i++){
				if (array[i] > array[i+1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					sorted = false;
				}
			}
		}
		System.out.println ("Array sorted by Bubble: " + Arrays.toString(array));
	}
	
	public void cocktailSort (int[] array){
		int temp;
		int left = 0;
		int right = array.length - 1;
		while (left < right){
			for (int i = 0; i < right; i++){
				if (array[i] > array[i+1]){
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			right--;
			for (int j = right; j > left; j--){
				if (array[j-1] > array[j]){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}
			left++;
		}
		System.out.println ("Array sorted by Cocktail: " + Arrays.toString(array));
	}	
	
	
	public static void main (String[] args) {
		int[] array = {4, 8, 3, 7, 5, 9, 0, 1, 2, 6};
		Sorting sorting = new Sorting();
		//sorting.bubbleSort(array);
		sorting.cocktailSort(array);
	}
}

