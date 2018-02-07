package main;
import static Ulincsys.Pythonics.*;

import Ulincsys.Plist;

public class Main {
	public static void main(String[] args) {
		
		Object plist = 'd';
		
		print(Int("14", "no"));
		
		
		int num = 2;
		String string = "th place";
		
		Plist tobj = new Plist();
		
		//Creating example object to error the Int() casting function
		Object obj = new Plist();
		print(obj);
		
		//Casting non-int compatible object to throw Invalid Input error, enabling continue after error
		int itest = Int(obj, true);
		print(itest);
		
		//Example call to print function, providing multiple parameters of different types
		print("Your are in", 1, num, string + ".");
		
		//Example call to input function, providing a statement and calling Int() to cast to int
		int test = Int(input("Enter a number: "));
		print(test);
		
		//Example call to input function without providing a statement or casting
		String stest = input();
		print(stest);
		
		//Example call to str() to cast to String
		String sNum = str(num);
		print(sNum);
		
		//Example call to Char() to cast to char
		char chrctr = Char(num);
		print(chrctr);
		
	}
}