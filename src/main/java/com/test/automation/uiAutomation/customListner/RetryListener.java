package com.test.automation.uiAutomation.customListner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{

	//this will add/load IRetryAnalyzer during runtime otherwise 
	//use @Test(retry=”IRetryAnalyzer Implementing class”).
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2, Method arg3) {
		
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();

		if (retry == null)	{
			arg0.setRetryAnalyzer(Retry.class);
		}
		
	}


}
