package aeii;

import a.a.Class_b_EnumerationExt;
import a.a.a.Class_a_StaticFileConnection;
import a.a.a.Class_c_AbstractConnection;
import a.a.a.Class_g_2517;

import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connection;

public final class Class_b_0081
{
  private String var_60f = null;
  
  public final Enumeration sub_653(String paramString, boolean paramBoolean)
  {
    try
    {
      if (this.var_60f == null) {
        return Class_a_StaticFileConnection.getListRoots();
      }
      Class_c_AbstractConnection conn;
      Enumeration localEnumeration = (conn = (Class_c_AbstractConnection)Class_g_2517.sub_d70("file:///" + this.var_60f, 1)).sub_null_2();
      conn.close();
      Vector vec = new Vector();
      if (paramString == null) {
        paramString = "";
      }
      while (localEnumeration.hasMoreElements())
      {
        String str;
        if (((str = (String)localEnumeration.nextElement()).endsWith("/")) || (str.toLowerCase().endsWith(paramString))) {
        	vec.addElement(str);
        }
      }
      return vec.elements();
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final void sub_759(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("..")))
    {
      if (this.var_60f != null)
      {
        this.var_60f += paramString;
        return;
      }
      this.var_60f = paramString;
      return;
    }
    if (this.var_60f != null)
    {
      this.var_60f = this.var_60f.substring(0, this.var_60f.length() - 1);
      int index;
      if ((index = this.var_60f.lastIndexOf('/')) >= 0)
      {
        this.var_60f = this.var_60f.substring(0, index + 1);
        return;
      }
      this.var_60f = null;
    }
  }
  
  public final Class_c_AbstractConnection sub_81a(String paramString)
  {
    try
    {
      return (Class_c_AbstractConnection)Class_g_2517.sub_d2f("file:///" + this.var_60f + paramString);
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final String sub_877()
  {
    return this.var_60f;
  }
  
  public static Enumeration sub_896(Enumeration paramEnumeration)
  {
    if (paramEnumeration == null) {
      return null;
    }
    Vector localVector1 = new Vector();
    Vector localVector2 = new Vector();
    while (paramEnumeration.hasMoreElements())
    {
      String str;
      if ((str = (String)paramEnumeration.nextElement()).endsWith("/")) {
        localVector1.addElement(str);
      } else {
        localVector2.addElement(str);
      }
    }
    if (localVector1.size() > 0) {
      sub_98f(localVector1, 0, localVector1.size() - 1);
    }
    if (localVector2.size() > 0) {
      sub_98f(localVector2, 0, localVector2.size() - 1);
    }
    Class_b_EnumerationExt enumClass;
    (enumClass = new Class_b_EnumerationExt()).addEnumeration(localVector1.elements());
    enumClass.addEnumeration(localVector2.elements());
    return enumClass;
  }
  
  private static void sub_98f(Vector paramVector, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      String str1 = ((String)paramVector.elementAt((paramInt2 - paramInt1) / 2 + paramInt1)).toLowerCase();
      int i = paramInt1;
      int j = paramInt2;
      while (i <= j)
      {
        while ((((String)paramVector.elementAt(i)).toLowerCase().compareTo(str1) < 0) && (i <= paramInt2)) {
          i++;
        }
        while ((((String)paramVector.elementAt(j)).toLowerCase().compareTo(str1) > 0) && (j >= paramInt1)) {
          j--;
        }
        if (i <= j)
        {
          String str2 = (String)paramVector.elementAt(i);
          paramVector.setElementAt(paramVector.elementAt(j), i);
          paramVector.setElementAt(str2, j);
          i++;
          j--;
        }
      }
      if (j > paramInt1) {
        sub_98f(paramVector, paramInt1, j);
      }
      if (i >= paramInt2) {
        break;
      }
      paramInt1 = i;
      paramVector = paramVector;
    }
  }
  
  public static String[] sub_adb(Enumeration paramEnumeration, String[] paramArrayOfString)
  {
    Vector localVector = new Vector();
    if (paramArrayOfString != null) {
      for (int i = 0; i < paramArrayOfString.length; i++) {
        localVector.addElement(paramArrayOfString[i]);
      }
    }
    while (paramEnumeration.hasMoreElements()) {
      localVector.addElement(paramEnumeration.nextElement());
    }
    String[] arrayOfString = new String[localVector.size()];
    localVector.copyInto(arrayOfString);
    return arrayOfString;
  }
}


/* Location:           C:\Users\DevInCube\Desktop\deob\
 * Qualified Name:     aeii.Class_b_0081
 * JD-Core Version:    0.7.0.1
 */