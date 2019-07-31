package com.extentreports.basics;

import java.io.File;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws Exception {
		String[] stringFromFile = null;
		String [] reverseString =null;
		File file = new File("C:\\Setups\\ReadFile.txt");
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			stringFromFile = scanner.nextLine().split(" ");
			
		}

	}

}
