package a.a.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.microedition.io.StreamConnection;

public abstract interface C_AConnection extends StreamConnection {
	
	public abstract InputStream openInputStream();

	public abstract OutputStream openOutputStream();

	public abstract Enumeration getList();

	public abstract void create();

	public abstract boolean exists();

	public abstract void truncate(long paramLong);
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.a.Class_c_0013
 * 
 * JD-Core Version: 0.7.0.1
 */