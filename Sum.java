/*Ввести целые числа как аргументы командной строки,
 *подсчитать их сумму (произведение)
 *и вывести результат на консоль.*/

import java.util.*;

class MultiSum{
	int summary = 0;
	int multiplication = 1;
	
	public int sumArgs(String[] args){
		for (int i = 0; i < args.length ; i++){
			summary += Integer.parseInt(args[i]);
		}
		System.out.println("Summary of arguments =: " + summary);
		return summary;
	}
	
	public int multiArgs (String[] args){
		for (int i = 0; i < args.length ; i++){
			multiplication *= Integer.parseInt(args[i]);
		}
		System.out.println("Multiplication of arguments =: " + multiplication);
		return multiplication;
	}
}

public class Sum {
	public static void main (String[] args) {
		MultiSum multiSum = new MultiSum();
		multiSum.sumArgs(args);
		multiSum.multiArgs(args);
		}
	}

