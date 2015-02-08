package a.a.a;

//import com.siemens.mp.io.file.FileConnection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.microedition.io.Connection;

/***
 * 
 * @author DevInCube
 *
 *         SIEMENS File Connection
 */

final class Class_d_SiemenFileCon implements Class_c_AConnection {
	
	private FileConnection var_27d;

	public Class_d_SiemenFileCon(Connection paramConnection) {
		this.var_27d = ((FileConnection) paramConnection);
	}

	public final void close() {
		this.var_27d.close();
	}

	public final InputStream openInputStream() {
		return this.var_27d.openInputStream();
	}

	public final DataInputStream openDataInputStream() {
		return this.var_27d.openDataInputStream();
	}

	public final OutputStream openOutputStream() {
		return this.var_27d.openOutputStream();
	}

	public final DataOutputStream openDataOutputStream() {
		return this.var_27d.openDataOutputStream();
	}

	public final Enumeration getList() {
		return this.var_27d.list();
	}

	public final void create() {
		this.var_27d.create();
	}

	public final boolean exists() {
		return this.var_27d.exists();
	}

	public final void truncate(long paramLong) {
		this.var_27d.truncate(0L);
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.a.Class_d_0114
 * 
 * JD-Core Version: 0.7.0.1
 */