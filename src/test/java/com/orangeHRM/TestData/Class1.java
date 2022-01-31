package com.orangeHRM.TestData;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1 {
	
	@BeforeTest
	public void m1()
	{System.out.println("before Test");}
	@BeforeClass
	public void m2()
	{System.out.println("before class1");}
	@BeforeMethod
	public void m3()
	{System.out.println("before method1");}
	@Test
	public void m4()
	{System.out.println("before Test for class 1");}
	@Test
	public void m5()
	{System.out.println("before Test for class 1");}
	@AfterTest
	public void m6()
	{System.out.println("After Test");}
}

