package a.a.a;

import java.util.Enumeration;

/**
 * FileConnectionProvider
 * @author DevInCube
 *
 */
public final class A_StaticFileConnection {

	private static int fileConCode = -1;

	/**
	 * Resolve Connection
	 * 
	 * @return
	 */
	static int getAvailableFileConnectionCode() {
		if (fileConCode < 0) {
			if (classExists("javax.microedition.io.file.FileConnection")) {
				fileConCode = 1;
			} else if (classExists("com.siemens.mp.io.file.FileConnection")) {
				fileConCode = 2;
			} else if (classExists("com.motorola.io.FileConnection")) {
				fileConCode = 3;
			} else if (classExists("com.motorola.io.file.FileConnection")) {
				fileConCode = 4;
			} else {
				fileConCode = 0;
			}
		}
		return fileConCode;
	}

	/**
	 * Check if class exists
	 * 
	 * @param paramString
	 * @return
	 */
	private static boolean classExists(String paramString) {
		try {
			return Class.forName(paramString) != null;
		} catch (Throwable localThrowable) {
		}
		return false;
	}

	/**
	 * Get mobile file system Roots
	 * 
	 * @return
	 */
	public static Enumeration getListRoots() {

		switch (getAvailableFileConnectionCode()) {
			case 1:
				return null;//javax.microedition.io.file.FileSystemRegistry.listRoots();
			case 2:
				return null;//com.siemens.mp.io.file.FileSystemRegistry.listRoots();
			case 3:
				return null;//com.motorola.io.FileSystemRegistry.listRoots();
			case 4:
				return null;//com.motorola.io.file.FileSystemRegistry.listRoots();
		}

		return null;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.a.Class_a_0411
 * 
 * JD-Core Version: 0.7.0.1
 */