package org.testngPracticePrgs;

public class D {

	public static void main(String[] args) {
//		int no = 17;
//		int i = 2;
//		while (true) {
//			if (no % i == 0) {
//				break;
//			}
//			i++;
//		}
//		if(no==i) {
//			System.out.println("prime");
//		}
//		else
//		{
//			System.out.println("not a prime");
//		}

//		boolean flag = true;
//		for(int i = 2; i<no/2; i++) {
//			if(no % i==0)
//			{
//				flag = false;
//				break;
//			}
//		}
//		if(flag==true)
//		{
//			System.out.println("prime");
//		}
//		else {
//			System.out.println("not a prime");
//		}
		
		
		for(int i=2; i<=100; i++)
		{
			boolean flag=true;
			for(int j = 2; j<i/2; j++)
			{
				
				if(i%j==0)
					
				{
					flag=false;
					break;
				}
				
			}
			if(flag)
			{
				System.out.print(i+" ");
			}
		}
		
	}

}
