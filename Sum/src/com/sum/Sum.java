package com.sum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sum {

	public int SumArray(int[] numbers) {
		/*
		 * int sum=0; for(int temp:numbers) { sum+=temp; } System.out.println(sum);
		 * return sum;
		 */

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		System.out.println(strDate);

		return 0;
	}
	
	
	public static void main(String args[])
	{
		
	}

}
