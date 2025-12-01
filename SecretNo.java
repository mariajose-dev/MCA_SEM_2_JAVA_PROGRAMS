//Keep a secret number between 20 and 30 in your program. Ask the user to
//predict a number between 20 and 30. Use a do-while loop until the user predicts
//your secret number and displays the count of attempts.

import java.util.Scanner;
import java.io.*;

class SecretNo{
	public static void main(String args[]){
		int secret=25,your_no,co=0;
		Scanner s=new Scanner(System.in);
		do
		{
		System.out.print("Enter any number between 20 and 30: ");
		your_no=s.nextInt();
		co++;
		if(secret==your_no)
			{
				System.out.println("Success! Number of try's is "+co);
				break;	
			}
		else if(your_no<20 || your_no>30)
			System.out.println("Please enter a number between 20 and 30\n");
		else
			System.out.println("Try again! you are very close\n");
		}while(secret!=your_no);			
	}
}
