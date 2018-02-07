package Ulincsys;

import java.util.LinkedList;

import static Ulincsys.Pythonics.*;

public class Plist { //Provides a pythonic list object
	
	public Plist(Object... items) {
		LinkedList<Object> internal = new LinkedList<Object>();
		
		for(Object item : items) {
			internal.add(item);
		}
	}
}