/*Отобразить в окне консоли аргументы командной строки в обратном порядке.*/

import java.util.*;

public class CommandLine {
	
	public static void main (String[] args) {
		for (int i = args.length - 1; i >= 0 ; i--){
			System.out.println("args[" + i + "] : " + args[i]);
		}
	}
}

