/*Приветствовать любого пользователя при вводе его имени через командную строку.*/

import java.util.*;
import java.io.*;

public class HelloUser {
	
	public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName;
        System.out.println ("Enter your name:");
        userName = scanner.nextLine();
        System.out.println ("Hello, " + userName);
	}
}

