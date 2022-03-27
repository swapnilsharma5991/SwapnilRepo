package com.qa.Rediff.base;

public class sample {
	int a=1;
	
public static void main(String[] args) {
	sample s = new sample();

	s.test1();
}
	public void test1() {
		int a=55;
		System.out.println("Test");
		System.out.println(a);
		System.out.println(this.a);
	}
}

