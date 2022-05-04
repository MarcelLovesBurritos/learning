/*Sorting
 * 1. Bubble
 * 2. Cocktail
 * 3. Insertion
 * 4. Selection
 * 5. 
 * 6. 
 * 7. 
 * 8. */

import java.util.*;

public class Sorting {
	
	public void bubbleSort (int[] array){ // 1. Bubble
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
	
	public void cocktailSort (int[] array){ // 2. Cocktail
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
	
	public void insertionSort (int[] array){ // 3. Insertion
		for (int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i - 1;
			while (j >= 0 && temp < array[j]){
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
		System.out.println ("Array sorted by Insertion: " + Arrays.toString(array));
	}
	
	public void selectionSort (int[] array){ // 4. Selection
		for (int i = 0; i < array.length; i++){
			int min = array[i];
			int minN = i;
			int temp;
			for (int j = i + 1; j < array.length; j++){
				if (array[j] < min){
					min = array[j];
					minN = j;
				}
			}
			temp = array[i];
			array[i] = min;
			array[minN] = temp;
		}
		System.out.println ("Array sorted by Selection: " + Arrays.toString(array));
	}
	
	
	public static void main (String[] args) {
		int[] array = {4, 8, 3, 7, 5, 9, 0, 1, 2, 6};
		Sorting sorting = new Sorting();
		//sorting.bubbleSort(array);
		//sorting.cocktailSort(array);
		//sorting.insertionSort(array);
		sorting.selectionSort(array);
	}
}

