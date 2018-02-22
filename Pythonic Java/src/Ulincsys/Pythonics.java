package Ulincsys;

import java.io.IOException;
import java.util.Scanner;
import javax.script.*;

@SuppressWarnings("unused")
public class Pythonics { //contains pythonic methods
	
	//######################################################################		INTERACTION

	//pythonic print method, can accept indefinite number of parameters of multiple types
	public static void print(Object... items) {
		for(Object item : items) {
			System.out.print(item);
		}
		System.out.println("");
	}
	
	//internal print function, saves space
	private static void rprint(Object[] items, Object... other) {
		for(Object item : items) {
			System.out.print(item);
		}
		System.out.println("");
		if(other.length != 0) {rprint(other);} 
		//because this function expects an initialized object list, a recursive call is used to print any remaining objects
	}
	
	//pythonic input, always returns String with no leading or trailing whitespace, can accept indefinite number of parameters of multiple types
	public static String input(Object... items) { 
		Scanner scnr = new Scanner(System.in);
		rprint(items);
		String temp = scnr.nextLine().trim();
		
		return temp;
	}
	
	//######################################################################		CASTING AND IDENTIFICATION
	
	//pythonic cast to int, will return -1 if error
	public static int Int(Object initial, Object... other) {
		boolean eoff = bool(other);
		String parse = str(initial).trim();
		
		try {
			return Integer.parseInt(parse);
		} catch(NumberFormatException e) {
			error(1, "Int(String)", eoff, parse + " || is not compatible with type - int");
		} catch(Exception e) {
			error(0, "Int(String)", eoff);
		}
		return 0;
	}
	
	//pythonic cast to String, will return -1 if error
	public static String str(Object parse, Object... other) {
		boolean eoff = bool(other);
		try {
			return parse.toString();
		} catch(Exception e) {
			error(0, "str(Object)", eoff);
		}
		return "0";
	}
	
	//pythonic cast to char, will always return the first character of a string, will return -1 if error
	public static char Char(Object parse, Object... other) {
		boolean eoff = bool(other);
		try {
			return str(parse).charAt(0);
		} catch(Exception e) {
			error(0, "Char(Object)", eoff);
		}
		return '0';
	}
	
	//pythonic cast to boolean, can convert Object and String data types to boolean, is the only class which relies explicitly upon (String) casting, as the str() method relies upon it
	public static boolean bool(Object[] other, boolean... EOFF) {
		boolean eoff = false; if(EOFF.length != 0 && EOFF[0]) {eoff = true;}
		boolean parse = false;
		if(other.length != 0) {
			Object Other = other[0];
			try {
				if((boolean)Other) {parse = true;}
			} catch (ClassCastException e){
				String sTest = (Other.toString()).toLowerCase();
				if(sTest.equals("true") || sTest.equals("t") || sTest.equals("yes") || sTest.equals("y")) {
					parse = true;
				} else if(sTest.equals("false") || sTest.equals("f") || sTest.equals("no") || sTest.equals("n")) {
					parse = false;
				} else {
					error(1, "bool(Object)", eoff, other + " || is not compatible with type - boolean");
				}
			} catch (Exception e) {
				error(0, "bool(Object)", eoff);
			}
		}
		return parse;
	}
	
	public static Object type(Object parse) {
		return parse.getClass().getName();
	}
	
	//######################################################################		OPERATIONS
	
	//pythonic evaluator, will evaluate given string
	public static Object eval(String parse, Object... other) {
		boolean eoff = bool(other);
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		try {
			return engine.eval(parse);
		} catch (ScriptException e) {
			error(1, "eval(String)", eoff, parse + " || is not evaluable");
		} catch(Exception e) {
			error(0, "eval(String)", eoff);
		}
		return -1;
	}
	
	public static void exec(String parse, Object... other) {
		
		/*
		boolean eoff = bool(other);
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(parse);
		} catch (IOException e) {
			error(1, "exec(String)", eoff, parse + " || is not executable");
		} catch(Exception e) {
			error(0, "exec(String)", eoff);
		}
		*/
	}
	
	//custom error detection and reporting, for use with Pythonics
	private static void error(int type, String trace, boolean eoff, Object... other) {
		Object[] errList = new Object[3];
		errList[0] = ("[ERROR] || ");
		switch (type) {
			case 0:
				errList[1] = "Generic Error";
				break;
			case 1:
				errList[1] = "Invalid Input";
				break;
			default:
				errList[1] = "Other Error";
				break;
		}
		errList[2] = (" occurred in " + trace + ":");
		rprint(errList);
		
		if(eoff) {
			rprint(other, "\nExit status: ", "Continue after error (may return erroneous value)");
		} else {
			rprint(other, "\nExit status: ", "-", type);
			System.exit(-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	// if (items == null || items.length == 0) {return;}
}