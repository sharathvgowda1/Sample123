package org.xpath.assignment;

import java.util.Date;

public class SystemDate {
	
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		String[] arr = d.toString().split(" ");
		String time = arr[3];
		String updatedtime = time.replace(':', '-');
		arr[3] = updatedtime;
		System.out.println(arr[3]);
	}

}
