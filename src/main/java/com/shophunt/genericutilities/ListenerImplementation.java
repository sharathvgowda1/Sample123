package com.shophunt.genericutilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		JavaUtility jlib = new JavaUtility();
		String date = jlib.getSystemDateInISTWithTime();
//		int r = jlib.getRandomNumber();
		EventFiringWebDriver e = new EventFiringWebDriver(BaseClass.sdriver);
		
		File src = e.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\photos\\"+testName+""+date+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	}
	
}


