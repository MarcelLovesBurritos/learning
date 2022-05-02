/*Вывести заданное количество случайных чисел
 *с переходом и без перехода на новую строку*/

import java.util.*;

class ArraySetUp {
	Scanner scanner = new Scanner(System.in);
	int arrayLenght;
	int[] array;
	Random randomNumber = new Random();
	
	public int setArrayLenght(){
		System.out.println ("Enter the lenght of the array:");
		arrayLenght = scanner.nextInt();
		array = new int[arrayLenght];
		return arrayLenght;
	}
		
	public void fillArray (int arrayLenght){
		for (int i = 0; i < arrayLenght; i++){
			array[i] =  randomNumber.nextInt(42);
		}
	}
	
	public void showArray (){
		System.out.print ("Array w/o ln:");
		for (int i = 0; i < array.length; i++){
			System.out.print (array[i] + " ");
		}
		System.out.println();
	}
	
	public void showArrayLn (){
		System.out.println ("Array with ln:");
		for (int i = 0; i < array.length; i++){
			System.out.println (array[i]);
		}
	}	
} 

public class RandomArray {	
	public static void main (String[] args) {
		ArraySetUp arraySetup = new ArraySetUp();
		arraySetup.setArrayLenght();
		arraySetup.fillArray(arraySetup.arrayLenght);
		arraySetup.showArray();
		arraySetup.showArrayLn();
	}
}

