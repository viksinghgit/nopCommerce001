package com.extentreports.basics;

public class StaticKeywordConcept {
	private static String message = "Hi All welcome to nested class concept";

	// Nested static class
	public static class StaticNestedClass {
		public void printMessageStaticClass() {
			System.out.println("Message from static class : " + message);
		}
	}

	// Nested Non Static class
	public class NonstaticInnerClass {
		public void printMessageInnerClass() {
			System.out.println("Message from inner class : " + message);
		}
	}

}
