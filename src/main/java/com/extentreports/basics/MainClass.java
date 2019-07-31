package com.extentreports.basics;

import com.extentreports.basics.StaticKeywordConcept.NonstaticInnerClass;

public class MainClass {

	public static void main(String[] args) {
		
		StaticKeywordConcept. 
		StaticNestedClass staticNestedClass = new StaticKeywordConcept.StaticNestedClass();
		staticNestedClass.printMessageStaticClass();
		
		
		StaticKeywordConcept keywordConcept = new StaticKeywordConcept();
		NonstaticInnerClass nonstaticInnerClass = keywordConcept.new NonstaticInnerClass();
		nonstaticInnerClass.printMessageInnerClass();
		
	}
}
