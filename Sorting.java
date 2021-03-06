/*Sorting
 * 1. Bubble
 * 1.1 RecBubble
 * 2. Cocktail
 * 2.1 RecCocktail
 * 3. Insertion
 * 3.1 ReInsertion
 * 4. Selection
 * 5. Shell
 * 6. Quick Sort
 * 7. Merge
 * 8. Heap*/

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
	
	public void recBubbleSort (int[] array){ // 1.1 RecBubble
		int temp;
		for (int i = 0; i < array.length - 1; i++){
			if (array[i] > array[i+1]){
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				recBubbleSort(array);
			}
		}
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
	
	public void recCocktailSort (int[] array, int left, int right){ // 2.1 RecCocktail
		int temp;
		if (left >= right) return;
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
		recCocktailSort (array, left, right);
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
	
	public void recInsertionSort (int[] array, int i){ // 3. RecInsertion
		if (i >= array.length) return;
		int temp = array[i];
		int j = i - 1;
		while (j >= 0 && temp < array[j]){
			array[j+1] = array[j];
			j--;
		}
		array[j+1] = temp;
		i++;
		recInsertionSort(array, i);
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
	
	public void shellSort (int[] array){ // 5. Shell
		int step = array.length/2;
		int temp;
		while (step > 0){
			for (int i = step; i < array.length; i++){
				for (int j = i - step; j >= 0; j -= step){
					if (array[j] > array[j+step]){
						temp = array[j];
						array[j] = array[j+step];
						array[j+step] = temp;
					}
				}

			}
			step = step/2;
		}
		System.out.println ("Array sorted by Shell: " + Arrays.toString(array));
	}
	
	public void quickSort (int[] array, int low, int high){ // 6. Quick Sort
		if (low >= high){
			return;
		}
		int pillar = low;
		int temp;
		int counter = high;
		for (int i = high; i >= low; i--){
			if (array[i] > array[pillar]){
				temp = array[i];
				array[i] = array[counter];
				array[counter] = temp;
				counter--;
			}
		}
		temp = array[pillar];
		array[pillar] = array[counter];
		array[counter] = temp;
		quickSort(array, low, counter-1);
		quickSort(array, counter+1, high);
	}
	
	public void mergeSort (int[] array, int low, int high){ // 7. Merge Sort (split)
		if (low >= high){
			return;
		}
		int mid = (low+high) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid+1, high);
		merge(array, low, mid, high);
	}
	
	public void merge (int[] array, int low, int mid, int high){ // 7. Merge Sort (merge)
		int leftArrayLength = mid - low + 1;
		int rightArrayLength = high - mid;
		
		int[] leftArray = new int [leftArrayLength];
		int[] rightArray = new int [rightArrayLength];
		
		for (int i = 0; i < leftArrayLength; i++){
			leftArray[i] = array[low+i];
		}
		for (int i = 0; i < rightArrayLength; i++){
			rightArray[i] = array[mid+i+1];
		}
		
		int leftID = 0;
		int rightID = 0;
		for (int i = low; i < high+1; i++){
			if (leftID < leftArrayLength && rightID < rightArrayLength){
				if (leftArray[leftID] < rightArray[rightID]){
					array[i] = leftArray[leftID];
					leftID++;
				}
				else {
					array[i] = rightArray[rightID];
					rightID++;
				}
			}
			else if (leftID < leftArrayLength){
				array[i] = leftArray[leftID];
				leftID++;
			}
			else if (rightID < rightArrayLength){
				array[i] = rightArray[rightID];
				rightID++;
			}
		}
	}
	
	public void heapSort (int[] array, int length, int i){ // 8. Heap Sort
		int firstChild = 2*i + 1;
		int secondChild = 2*i + 2;
		int temp;
		int root = i;
		if (firstChild < length && array[firstChild] > array[root]){
			root = firstChild;
		}
		if (secondChild < length - 1 && array[secondChild] > array[root]){
			root = secondChild;
		}
		if (root != i){
			temp = array[root];
			array[root] = array[i];
			array[i] = temp;
			heapSort(array, length, root);
		}
	}
	
	
	public static void main (String[] args) {
		int[] array = {4, 8, 3, 7, 5, 9, 0, 1, 2, 6};
		Sorting sorting = new Sorting();
		//sorting.bubbleSort(array);
		/*sorting.recBubbleSort(array);
		System.out.println ("Array sorted by Recursive Bubble: " + Arrays.toString(array));*/
		
		//sorting.cocktailSort(array);
		/*int left = 0;
		int right = array.length - 1;
		sorting.recCocktailSort(array, left, right);
		System.out.println ("Array sorted by Recursive Cocktail: " + Arrays.toString(array));*/

		//sorting.insertionSort(array);
		/*int i = 1;
		sorting.recInsertionSort(array, i);
		System.out.println ("Array sorted by Recursive Insertion: " + Arrays.toString(array));*/
		
		//sorting.selectionSort(array);
		
		//sorting.shellSort(array);
		
		/*int low = 0;
		int high = array.length - 1;
		sorting.quickSort(array, low, high);
		System.out.println ("Array sorted by QuickSort: " + Arrays.toString(array));*/
		
		/*int low = 0;
		int high = array.length-1;
		sorting.mergeSort(array, low, high);
		System.out.println ("Array sorted by MergeSort: " + Arrays.toString(array));*/
		
		int length = array.length;
		for (int i = length/2 - 1; i >= 0; i--){
			sorting.heapSort(array, length, i);
		}
		for (int i = length - 1; i >= 0; i--){
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			sorting.heapSort(array, i, 0);
		}
		System.out.println ("Array sorted by HeapSort: " + Arrays.toString(array));
	}
}

