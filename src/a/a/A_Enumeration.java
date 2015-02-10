package a.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * 
 * @author DevInCube
 *
 */
final class A_Enumeration implements Enumeration {
	
	A_Enumeration(B_EnumerationExt clas) {
		//
	}

	public final boolean hasMoreElements() {
		return false;
	}

	public final Object nextElement() {
		throw new NoSuchElementException();
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.Class_a_0009
 * 
 * JD-Core Version: 0.7.0.1
 */