package aeii;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public class Class_f_0145 {

	public static Class_c_0282 var_743;
	public int var_74b = var_743.getWidth();
	public int var_753 = var_743.getHeight();
	public int var_75b = this.var_74b >> 1;
	public int var_763 = this.var_753 >> 1;
	private static String[] var_76b;
	private static short[] var_773 = null;
	private static int var_77b = 360;
	private static int var_783 = 0;
	private static int var_78b = 0;

	public void sub_7f2() {
	}

	public void sub_80d() {
	}

	public void sub_828(Graphics paramGraphics) {
	}

	public static final String[] sub_843(String paramString, int paramInt,
			Font paramFont) {
		Vector localVector = new Vector();
	    int str1 = 0;
	    int i = paramString.length();
	    Object localObject1 = null;
	    for (;;)
	    {
	      int str2 = str1;
	      int str3 = paramString.indexOf('\n', str1);
	      do
	      {
	        int str5 = str2;
	        Object localObject2 = localObject1;
	        str2 = sub_a64(paramString, str2);
	        if ((str3 >= 0) && (str3 < str2)) {
	          str2 = str3;
	        }
	        localObject1 = paramString.substring(str1, str2).trim();
	        String str4;
	        if (paramFont.stringWidth((String)localObject1) > paramInt)
	        {
	          if (str5 == str1)
	          {
	            for (str1 = ((String)localObject1).length() - 1; str1 > 0; str1--)
	            {
	              str4 = ((String)localObject1).substring(0, str1);
	              if (paramFont.stringWidth(str4) <= paramInt)
	              {
	                str2 = str5 + str1;
	                localObject1 = str4;
	                break;
	              }
	            }
	            break;
	          }
	          str2 = str5;
	          localObject1 = localObject2;
	          break;
	        }
	        /* @ wtf
	        if (str2 == str4)
	        {
	          str2++;
	          break;
	        }*/
	      } while (str2 < i);
	      localVector.addElement(localObject1);
	      str1 = str2;
	      if (str2 >= i)
	      {
	        String[] arrayOfString = new String[localVector.size()];
	        localVector.copyInto(arrayOfString);
	        return arrayOfString;
	      }
	    }
	}

	private static final int sub_a64(String paramString, int paramInt) {
		if (sub_b26(paramString.charAt(paramInt))) {
			return paramInt + 1;
		}
		int i;
		while ((i = paramString.indexOf(' ', paramInt)) == 0) {
			paramInt++;
		}
		int j;
		if (i == -1) {
			j = paramString.length();
		} else {
			j = i + 1;
		}
		for (int i2 = paramInt + 1; i2 < j; i2++) {
			if (sub_b26(paramString.charAt(i2))) {
				return i2;
			}
		}
		return j;
	}

	private static final boolean sub_b26(int paramInt) {
		return ((paramInt >= 11904) && (paramInt < 44032))
				|| ((paramInt >= 63744) && (paramInt < 64256))
				|| ((paramInt >= 65280) && (paramInt < 65504));
	}

	public static final int sub_b8d(String paramString) {
		DataInputStream dis;
		try {
			var_76b = new String[(dis = new DataInputStream(Main.var_11b
					.getClass().getResourceAsStream(paramString))).readInt()];

			int i = 0;
			int j = var_76b.length;
			while (i < j) {
				String str = dis.readUTF();
				var_76b[i] = str;
				i++;
			}
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return var_76b.length;
	}

	public static final String sub_c07(int paramInt) {
		return sub_c27(paramInt, false);
	}

	public static final String sub_c27(int paramInt, boolean paramBoolean) {
		if (paramInt < var_76b.length) {
			String strparamInt = var_76b[paramInt];
			if ((paramBoolean)
					&& ((strparamInt = sub_df5(
							sub_df5(sub_df5(
									sub_df5(strparamInt, "%K5",
											sub_dcc(20, var_743.sub_251b(16)),
											true), "%K0", var_743.sub_251b(32),
									true), "%K7", var_743.sub_251b(256), true),
							"%K9", var_743.sub_251b(512), true)).indexOf("%KM") != -1)) {
				StringBuffer buf = new StringBuffer();
				String[] arrayOfString = { var_743.sub_251b(1),
						var_743.sub_251b(2), var_743.sub_251b(4),
						var_743.sub_251b(8) };
				buf.append(sub_d68(17, arrayOfString));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(sub_c07(18));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(sub_c07(19));
				strparamInt = sub_df5(strparamInt, "%KM", buf.toString(),
						true);
			}
			return strparamInt;
		}
		return "?: " + paramInt;
	}

	private static String sub_d68(int paramInt, String[] paramArrayOfString) {
		String str = new String(sub_c07(17));
		for (int i = 0; i < paramArrayOfString.length; i++) {
			str = sub_df5(str, "%U", paramArrayOfString[i], false);
		}
		return str;
	}

	public static final String sub_dcc(int paramInt, String paramString) {
		return sub_df5(sub_c27(paramInt = paramInt, false), "%U", paramString,
				false);
	}

	private static String sub_df5(String paramString1, String paramString2,
			String paramString3, boolean paramBoolean) {
		paramString1 = paramString1;
		do {
			int i;
			if ((i = paramString1.indexOf(paramString2)) == -1) {
				break;
			}
			paramString1 = paramString1.substring(0, i) + paramString3
					+ paramString1.substring(i + paramString2.length());
		} while (paramBoolean);
		return paramString1;
	}

	public static final void sub_e73()
  {
    var_78b = (Class_f_0145.var_783 = var_77b >> 1) >> 1;
    var_773 = new short[var_77b];
    int i = var_77b * 10000 / 2 / 31415;
    int j = i * 1024;
    int k = 0;
    for (int m = 0; m < var_77b; m++)
    {
      int n = k / i;
      var_773[m] = ((short)n);
      j -= n;
      k += j / i;
    }
    var_773['Â'] = 0; //var_773['Â´'] = 0;
    var_773[270] = -1024;
  }

	public static final short sub_f0f(int paramInt) {
		paramInt %= 360;
		return var_773[paramInt];
	}

	public static final short sub_f35(int paramInt) {
		paramInt = (paramInt + var_78b) % 360;
		return var_773[paramInt];
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_f_0145
 * 
 * JD-Core Version: 0.7.0.1
 */