package a.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * 
 * @author DevInCube
 *
 */
public final class B_EnumerationExt implements Enumeration {
	
	private Enumeration enumeration;
	private Vector vector = new Vector();
	private int iterator;
	private int count;

	public B_EnumerationExt() {
		A_Enumeration self = new A_Enumeration(this);
		this.vector.addElement(self);
		this.enumeration = self;
		this.count = 0;
		this.iterator = 0;
	}

	public final void addEnumeration(Enumeration inEnum) {
		if ((inEnum == null) || (!inEnum.hasMoreElements())) {
			return;
		}
		this.vector.addElement(inEnum);
		this.count = (this.vector.size() - 1);
	}

	public final boolean hasMoreElements() {
		if (this.iterator < this.count) {
			return true;
		}
		return this.enumeration.hasMoreElements();
	}

	public final Object nextElement() {
		for (;;) {
			if (this.enumeration.hasMoreElements()) {
				return this.enumeration.nextElement();
			}
			if (++this.iterator > this.count) {
				break;
			}
			this.enumeration = ((Enumeration) this.vector.elementAt(this.iterator));
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