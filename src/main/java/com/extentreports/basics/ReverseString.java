package com.extentreports.basics;

public class ReverseString {

	public static void main(String[] args) {
		String string ="Vikrant";
		char [] charArray = string.toCharArray();
		char [] charArrayReverse = new char[charArray.length];
		int j=0;
		for(int i=charArray.length-1;i>=0;i--)
		{
			charArrayReverse[j]=charArray[i];
			j++;
		}
		for(int k=0;k<charArrayReverse.length;k++)
		{
			System.out.print(charArrayReverse[k]);
		}
	}
}
