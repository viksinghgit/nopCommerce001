package com.extentreports.basics;

public class StringBufferBuilder {
	
	public static void concat1(String s1)  // String
	{
		s1=s1+"forGeeks";
	}
	
	public static void concat2(StringBuffer s2)  // StringBuffer
	{
		s2.append("forGeeks");
	}
	
	public static void concat3(StringBuilder s3)  // StringBuilder
	{
		s3.append("forGeeks");
	}
	
public static void main(String[] args) {
	
	String s1 = "Geeks";
	concat1(s1);
	System.out.println("String concatenation is : "+s1);
	
	StringBuffer s2 = new StringBuffer("Geeks");
	concat2(s2);
	System.out.println("StringBuffer concatenation is : "+s2);

	StringBuilder s3 = new StringBuilder("Geeks");
	concat3(s3);
	System.out.println("StringBuilder concatenation is : "+s3);
	
	
}
}
