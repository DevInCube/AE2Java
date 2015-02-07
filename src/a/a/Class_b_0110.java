package a.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * 
 * @author DevInCube
 *
 */
public final class Class_b_0110 implements Enumeration {
	
	private Enumeration var_22a;
	private Vector var_232 = new Vector();
	private int var_23a;
	private int var_242;

	public Class_b_0110() {
		Class_a_0009 localClass_a_0009 = new Class_a_0009(this);
		this.var_232.addElement(localClass_a_0009);
		this.var_22a = localClass_a_0009;
		this.var_242 = 0;
		this.var_23a = 0;
	}

	public final void sub_2ac(Enumeration paramEnumeration) {
		if ((paramEnumeration == null) || (!paramEnumeration.hasMoreElements())) {
			return;
		}
		this.var_232.addElement(paramEnumeration);
		this.var_242 = (this.var_232.size() - 1);
	}

	public final boolean hasMoreElements() {
		if (this.var_23a < this.var_242) {
			return true;
		}
		return this.var_22a.hasMoreElements();
	}

	public final Object nextElement() {
		for (;;) {
			if (this.var_22a.hasMoreElements()) {
				return this.var_22a.nextElement();
			}
			if (++this.var_23a > this.var_242) {
				break;
			}
			this.var_22a = ((Enumeration) this.var_232.elementAt(this.var_23a));
			// this = this;
		}
		throw new NoSuchElementException();
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.Class_b_0110
 * 
 * JD-Core Version: 0.7.0.1
 */