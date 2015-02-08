package aeii;

import a.a.Class_b_EnumerationExt;
import a.a.a.Class_a_StaticFileConnection;
import a.a.a.Class_c_AConnection;
import a.a.a.Class_g_Sprite;

import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connection;

public final class Class_b_FilesManager {

	private String path = null;

	public final Enumeration getDirectoryPaths(String dirName, boolean unused) {
		try {
			if (this.path == null) {
				return Class_a_StaticFileConnection.getListRoots();
			}
			Class_c_AConnection conn = (Class_c_AConnection) Class_g_Sprite
					.createFileConnectionWithInt("file:///" + this.path, 1);
			Enumeration files = conn.getList();
			conn.close();
			Vector vec = new Vector();
			if (dirName == null) {
				dirName = "";
			}
			while (files.hasMoreElements()) {
				String filePath = (String) files.nextElement();
				boolean isDirectory = filePath.endsWith("/");
				if (isDirectory || filePath.toLowerCase().endsWith(dirName)) {
					vec.addElement(filePath);
				}
			}
			return vec.elements();
		} catch (Exception localException) {
			//
		}
		return null;
	}

	public final void changeDirectory(String folder) {
		if ((folder != null) && (!folder.equals(".."))) {
			if (this.path != null) {
				this.path += folder;
				return;
			}
			this.path = folder;
			return;
		}
		if (this.path != null) {
			this.path = this.path.substring(0, this.path.length() - 1);
			int index = this.path.lastIndexOf('/');
			if (index >= 0) {
				this.path = this.path.substring(0, index + 1);
				return;
			}
			this.path = null;
		}
	}

	public final Class_c_AConnection createSomeFileConnection(String folder) {
		try {
			return (Class_c_AConnection) Class_g_Sprite
					.createFileConnection("file:///" + this.path + folder);
		} catch (Exception localException) {
			//
		}
		return null;
	}

	public final String sub_877() {
		return this.path;
	}

	public static Enumeration sortFoldersAndFiles(Enumeration inEnum) {
		if (inEnum == null) {
			return null;
		}
		Vector directories = new Vector();
		Vector files = new Vector();
		while (inEnum.hasMoreElements()) {
			String str = (String) inEnum.nextElement();
			if (str.endsWith("/")) {
				directories.addElement(str);
			} else {
				files.addElement(str);
			}
		}
		if (directories.size() > 0) {
			sub_98f(directories, 0, directories.size() - 1);
		}
		if (files.size() > 0) {
			sub_98f(files, 0, files.size() - 1);
		}
		Class_b_EnumerationExt enumClass = new Class_b_EnumerationExt();
		enumClass.addEnumeration(directories.elements());
		enumClass.addEnumeration(files.elements());
		return enumClass;
	}

	private static void sub_98f(Vector inList, int paramInt1, int paramInt2) {
		for (;;) {
			String str1 = ((String) inList
					.elementAt((paramInt2 - paramInt1) / 2 + paramInt1))
					.toLowerCase();
			int i = paramInt1;
			int j = paramInt2;
			while (i <= j) {
				while ((((String) inList.elementAt(i)).toLowerCase()
						.compareTo(str1) < 0) && (i <= paramInt2)) {
					i++;
				}
				while ((((String) inList.elementAt(j)).toLowerCase()
						.compareTo(str1) > 0) && (j >= paramInt1)) {
					j--;
				}
				if (i <= j) {
					String strItem = (String) inList.elementAt(i);
					inList.setElementAt(inList.elementAt(j), i);
					inList.setElementAt(strItem, j);
					i++;
					j--;
				}
			}
			if (j > paramInt1) {
				sub_98f(inList, paramInt1, j);
			}
			if (i >= paramInt2) {
				break;
			}
			paramInt1 = i;
		}
	}

	public static String[] mergeThese(Enumeration inEnum, String[] strings) {
		Vector list = new Vector();
		if (strings != null) {
			for (int i = 0; i < strings.length; i++) {
				list.addElement(strings[i]);
			}
		}
		while (inEnum.hasMoreElements()) {
			list.addElement(inEnum.nextElement());
		}
		String[] resStrs = new String[list.size()];
		list.copyInto(resStrs);
		return resStrs;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_b_0081
 * 
 * JD-Core Version: 0.7.0.1
 */