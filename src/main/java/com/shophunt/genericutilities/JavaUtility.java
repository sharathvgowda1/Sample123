package com.shophunt.genericutilities;

import java.util.Date;
import java.util.Random;

/**
 *   it's Contains java specific libraries like getRandomdata & getsystemDate   etc
 * @author Deepak
 *
 */

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int r =  random.nextInt(1000);
		return r;

	}
	/**
	 *  its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */
	public String  getSystemDate() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");

		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;

		String format = yyyy+"-"+mm+"-"+dd;
		return format;
	}
	/**
	 *  its used to get the current system date based on DD-MM-YYYY format 
	 * @return
	 */
	public String  getSystemDateInIST() {
		Date date = new Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");

		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;

		String format = dd+"-"+mm+"-"+yyyy;
		return format;
	}
	
	/**
	 * it is used to get the current system date with time on DD-MM-YYYY-time
	 * 
	 */
	public String getSystemDateInISTWithTime() {
		Date date = new Date();
		String[] arr = date.toString().split(" ");
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
		String time = arr[3];
		String uptime = time.replace(':', '-');
		arr[3] = uptime;
		String format = dd+"-"+mm+"-"+yyyy+"-"+arr[3];
		return format;
	}
}
