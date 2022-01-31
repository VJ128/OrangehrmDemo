package com.orangeHRM.TestData;

import org.testng.annotations.*;

public class Class2 {
	

	@BeforeClass
	public void m2()
	{System.out.println("before class 2");}
	@BeforeMethod
	public void m3()
	{System.out.println("before method 2");}
	@Test
	public void m4()
	{System.out.println("before Test class 2");}
	@Test
	public void m5()
	{System.out.println("before Test class 2");}
}
