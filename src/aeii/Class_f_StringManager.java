package aeii;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public class Class_f_StringManager {

	public static Class_c_MainCanvas mainCanvas;
	public int canvasWidth = mainCanvas.getWidth();
	public int canvasHeight = mainCanvas.getHeight();
	public int canvasWidthShift = this.canvasWidth >> 1;
	public int canvasHeightShift = this.canvasHeight >> 1;
	private static String[] langStrings;
	private static short[] var_773 = null;
	private static int var_77b = 360;
	private static int var_783 = 0;
	private static int var_78b = 0;

	public void sub_7f2() {
		//
	}

	public void sub_80d() {
		//
	}

	public void sub_828(Graphics paramGraphics) {
		//
	}

	public static final String[] wrapStringText(String inStr, int pixWidthMax,
			Font inFont) {
		Vector list = new Vector();
		int startIndex = 0;
		int strLen = inStr.length();
		String subStr1 = null;
		for (;;) {
			int charIndex = startIndex;
			int eolnIndex = inStr.indexOf('\n', startIndex);
			do {
				int sIndex = charIndex;
				String subStr2 = subStr1;
				charIndex = sub_a64(inStr, charIndex);
				if ((eolnIndex >= 0) && (eolnIndex < charIndex)) {
					charIndex = eolnIndex;
				}
				subStr1 = inStr.substring(startIndex, charIndex).trim();
				String subStr3;
				if (inFont.stringWidth(subStr1) > pixWidthMax) {
					if (sIndex == startIndex) {
						for (int it = subStr1.length() - 1; it > 0; it--) {
							subStr3 = subStr1.substring(0, it);
							if (inFont.stringWidth(subStr3) <= pixWidthMax) {
								charIndex = sIndex + it;
								subStr1 = subStr3;
								break;
							}
						}
						break;
					}
					charIndex = sIndex;
					subStr1 = subStr2;
					break;
				}
				/*
				 * @ wtf if (str2 == str4) { str2++; break; } //@todo
				 */
			} while (charIndex < strLen);
			list.addElement(subStr1);
			startIndex = charIndex;
			if (charIndex >= strLen) {
				String[] arrayOfString = new String[list.size()];
				list.copyInto(arrayOfString);
				return arrayOfString;
			}
		}
	}

	private static final int sub_a64(String paramString, int charIndex) {
		if (isSomeInSomeCharInterval(paramString.charAt(charIndex))) {
			return charIndex + 1;
		}
		int spaceIndex = paramString.indexOf(' ', charIndex);
		while (spaceIndex == 0) {
			charIndex++;
		}
		int j;
		if (spaceIndex == -1) {
			j = paramString.length();
		} else {
			j = spaceIndex + 1;
		}
		for (int it = charIndex + 1; it < j; it++) {
			if (isSomeInSomeCharInterval(paramString.charAt(it))) {
				return it;
			}
		}
		return j;
	}

	private static final boolean isSomeInSomeCharInterval(int charInd) {
		return ((charInd >= 11904) && (charInd < 44032))
				|| ((charInd >= 63744) && (charInd < 64256))
				|| ((charInd >= 65280) && (charInd < 65504));
	}

	public static final int loadLangDataFromFile(String langFileName) {
		DataInputStream dis;
		try {
			dis = new DataInputStream(Main.mainMIDlet.getClass()
					.getResourceAsStream(langFileName));
			langStrings = new String[dis.readInt()];

			int i = 0;
			int j = langStrings.length;
			while (i < j) {
				langStrings[i] = dis.readUTF();
				i++;
			}
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return langStrings.length;
	}

	public static final String getLangString(int index) {
		return getLangString(index, false);
	}

	public static final String getLangString(int index, boolean paramBoolean) {
		if (index < langStrings.length) {
			String langString = langStrings[index];
			if ((paramBoolean)
					&& ((langString = replaceStringInString(
							replaceStringInString(replaceStringInString(
									replaceStringInString(langString, "%K5",
											getStrByIdAndReplaceUWith(20, mainCanvas.getCodeKeyName(16)),
											true), "%K0", mainCanvas.getCodeKeyName(32),
									true), "%K7", mainCanvas.getCodeKeyName(256), true),
							"%K9", mainCanvas.getCodeKeyName(512), true)).indexOf("%KM") != -1)) {
				StringBuffer buf = new StringBuffer();
				String[] arrayOfString = { mainCanvas.getCodeKeyName(1),
						mainCanvas.getCodeKeyName(2), mainCanvas.getCodeKeyName(4),
						mainCanvas.getCodeKeyName(8) };
				buf.append(sub_d68(17, arrayOfString));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(getLangString(18));
				if (buf.length() > 0) {
					buf.append('/');
				}
				buf.append(getLangString(19));
				langString = replaceStringInString(langString, "%KM", buf.toString(), true);
			}
			return langString;
		}
		return "?: " + index;
	}

	private static String sub_d68(int unUsedInt, String[] inArr) {
		String str = new String(getLangString(17)); // maybehere unUsedInt
		for (int i = 0; i < inArr.length; i++) {
			str = replaceStringInString(str, "%U", inArr[i], false);
		}
		return str;
	}

	public static final String getStrByIdAndReplaceUWith(int strIndex, String inStr) {
		String langStr = getLangString(strIndex, false);
		return replaceStringInString(langStr, "%U", inStr, false);
	}

	private static String replaceStringInString(String originalStr, String toReplace,
			String replacement, boolean manyTimes) {
		do {
			int startIndex = originalStr.indexOf(toReplace);
			if (startIndex == -1) {
				break;
			}
			originalStr = originalStr.substring(0, startIndex) + replacement
					+ originalStr.substring(startIndex + toReplace.length());
		} while (manyTimes);
		return originalStr;
	}

	public static final void sub_e73() {
		Class_f_StringManager.var_783 = var_77b >> 1;
		var_78b = Class_f_StringManager.var_783 >> 1;
		var_773 = new short[var_77b];
		int i = var_77b * 10000 / 2 / 31415;
		int j = i * 1024;
		int k = 0;
		for (int m = 0; m < var_77b; m++) {
			int n = k / i;
			var_773[m] = ((short) n);
			j -= n;
			k += j / i;
		}
		var_773['Â'] = 0; // var_773['Â´'] = 0;
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