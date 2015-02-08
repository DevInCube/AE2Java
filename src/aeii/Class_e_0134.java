package aeii;

import a.a.a.Class_g_Sprite;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class Class_e_0134 extends Class_f_StringManager {

	private boolean[] var_fe2 = { false, false };
	public int var_fea = 13553358;
	private static int var_ff2;
	private static int var_ffa = ((Class_e_0134.var_ff2 = Class_c_MainCanvas.canvasHeight <= 143 ? 1
			: 2) << 1) + 1;
	private byte var_1002 = 2;
	private short var_100a = 3;
	public static Class_g_1956 var_1012;
	public String[] var_101a;
	private Class_d_ImageWrap[] var_1022;
	private int var_102a;
	private int var_1032;
	public int var_103a;
	public int var_1042;
	private int var_104a;
	private Font var_1052 = Class_c_MainCanvas.theFont;
	public int var_105a;
	private int var_1062;
	private int var_106a;
	private int var_1072;
	private int var_107a;
	private int var_1082;
	public byte var_108a;
	private int var_1092;
	private boolean var_109a = false;
	private boolean var_10a2 = false;
	public Class_a_Unit[] var_10aa;
	private int var_10b2;
	private int var_10ba;
	private byte var_10c2 = -1;
	private int var_10ca;
	private int var_10d2;
	private int var_10da;
	private int var_10e2;
	private String[] var_10ea;
	public int var_10f2 = -1;
	private boolean var_10fa = true;
	private int var_1102;
	public Class_a_Unit var_110a;
	private boolean var_1112 = true;
	public Class_f_StringManager stringManager;
	private int var_1122;
	private Class_g_Sprite[] someSprites;
	private int var_1132;
	private boolean var_113a = false;
	private Vector var_1142;
	public int var_114a = -1;
	public boolean var_1152;
	public boolean var_115a;
	private int var_1162;
	private int var_116a;
	private int var_1172;
	private int var_117a;
	private byte[][] var_1182;
	private Vector var_118a;
	private int var_1192;
	private int var_119a;
	public int var_11a2 = 2370117;
	public int var_11aa = 2370117;
	public Class_d_ImageWrap var_11b2;
	private Class_e_0134 var_11ba;
	public int[] var_11c2;
	private int var_11ca;
	private int var_11d2;
	private int[] var_11da;
	public int var_11e2;
	private int var_11ea = -1;
	private short[] var_11f2;
	private int var_11fa;
	private int var_1202;
	private int var_120a;
	private int var_1212;
	private int var_121a;
	private int var_1222;
	private int var_122a;
	private int var_1232;
	private int var_123a;
	private int var_1242;
	private byte var_124a;
	private Class_g_Sprite var_1252;

	public final void sub_1272() {
		this.var_1232 = 0;
		if (this.someSprites != null) {
			sub_1dd0();
		}
		this.var_1132 = 4;
		this.var_109a = true;
		this.var_10a2 = true;
		if (var_1012 != null) {
			var_1012.sub_60da();
		}
		if (this.var_11ba != null) {
			this.var_11ba.var_109a = true;
		}
		if (this.var_108a == 15) {
			for (int i = 0; i < this.var_1142.size(); i++) {
				Class_e_0134 localClass_e_0134;
				(localClass_e_0134 = (Class_e_0134) this.var_1142.elementAt(i))
						.sub_1272();
				localClass_e_0134.var_10a2 = false;
			}
		}
	}

	public final void sub_132e(byte paramByte, boolean paramBoolean) {
		this.var_fe2[paramByte] = paramBoolean;
	}

	public final void sub_1350(Class_f_StringManager paramClass_f_0145) {
		this.stringManager = paramClass_f_0145;
		this.var_fe2[1] = (boolean) (paramClass_f_0145 != null ? true : false);
	}

	public Class_e_0134(byte paramByte, int paramInt) {
		this.var_108a = paramByte;
		this.var_1092 = paramInt;
		if (paramByte == 15) {
			this.var_11e2 = (var_1012.var_45a2 - var_1012.var_4732.spriteFrameHeight);
			this.var_10fa = true;
		} else if ((paramByte != 0) && (paramByte != 11)) {
			if (paramByte == 3) {
				this.var_1252 = var_1012.var_4a0a;
				sub_1d69();
				this.var_10fa = false;
				this.var_1152 = true;
				this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
				this.var_103a = var_1012.var_459a;
				this.var_1042 = (var_1012.var_4a0a.spriteFrameHeight + var_ffa);
				if ((paramInt & 0x2) == 0) {
					this.var_1042 += 5;
				}
				this.var_10aa = Class_a_Unit.sub_27b7(var_1012.var_4842);
				this.var_1062 = this.var_10aa.length;
				int pInt = (int) (this.var_103a - (var_1012.var_4722.spriteFrameWidth << 1));
				if ((paramInt & 0x4) == 0) {
					pInt -= 8;
				}
				if ((paramInt & 0x8) == 0) {
					pInt -= 8;
				}
				this.var_10d2 = (pInt / (var_1012.var_4a0a.spriteFrameWidth + 3));
				if (this.var_10d2 > this.var_1062) {
					this.var_10d2 = this.var_1062;
				}
				this.var_104a = (pInt / this.var_10d2);
				this.var_1122 = ((pInt - this.var_104a * this.var_10d2) / 2);
				this.var_1002 = 2;
			} else if ((paramByte != 2) && (paramByte != 5)) {
				if ((paramByte != 7) && (paramByte == 8)) {
					this.var_100a = 8;
					this.var_fe2[0] = true;
				}
			} else {
				this.var_10fa = false;
				this.var_1042 = (5 + var_ff2 + 24 + var_ffa
						+ (var_1012.var_4a12.spriteFrameHeight << 1) + var_ff2 + var_ff2 + 1);
				if (paramByte == 5) {
					this.var_1042 += var_ffa + Class_c_MainCanvas.fontBaselinePos;
					this.var_110a = var_1012.getUnitAtPos(var_1012.var_4772,
							var_1012.var_477a, (byte) 0);
					this.var_105a = this.var_110a.unitType;
					this.var_103a = var_1012.var_459a;
				} else {
					this.var_103a = var_1012.var_459a;
				}
			}
		} else {
			this.var_fe2[0] = true;
			this.var_fe2[1] = true;
		}
		this.var_109a = true;
	}

	public final Class_e_0134 sub_165b(String paramString) {
		this.var_11ba = new Class_e_0134((byte) 10, 0);
		this.var_11ba.sub_1ca8(null, paramString, var_1012.var_459a, -1);
		return this.var_11ba;
	}

	public final void sub_1698(Class_e_0134 paramClass_e_0134, int paramInt1,
			int paramInt2, int paramInt3) {
		if (this.var_1142 == null) {
			this.var_1142 = new Vector();
		}
		if (this.var_11da == null) {
			this.var_11da = new int[5];
			for (int i = 0; i < 5; i++) {
				this.var_11da[i] = this.var_11e2;
				if (i > 0) {
					this.var_11da[i] -= var_1012.var_4732.spriteFrameHeight;
				}
			}
		}
		paramClass_e_0134.sub_1930(paramInt1, paramInt2, paramInt3);
		int i = paramClass_e_0134.var_1032;
		for (int it = 0; it < 5; it++) {
			if (i < this.var_11da[it]) {
				if (i + paramClass_e_0134.var_1042 <= this.var_11da[it]) {
					break;
				}
				this.var_11da[it] = i;
				if (it + 1 <= this.var_11d2) {
					break;
				}
				this.var_11d2 = (it + 1);
				break;
			}
			i -= this.var_11da[paramInt1];
		}
		boolean paramInt3bool = false;
		paramInt2 = 0;
		Class_e_0134 cl;
		(cl = paramClass_e_0134).var_fe2[paramInt2] = paramInt3bool;
		paramInt3bool = false;
		paramInt2 = 1;
		Class_e_0134 cl2;
		(cl2 = paramClass_e_0134).var_fe2[paramInt2] = paramInt3bool;
		this.var_1142.addElement(paramClass_e_0134);
	}

	public final void sub_17fe(int paramInt1, int paramInt2,
			byte[][] paramArrayOfByte, Vector paramVector) {
		this.var_1092 = 15;
		this.var_1182 = paramArrayOfByte;
		this.var_118a = paramVector;
		this.var_100a = 8;
		this.var_fe2[0] = true;
		this.var_10fa = true;
		this.var_1192 = paramArrayOfByte.length;
		this.var_119a = paramArrayOfByte[0].length;
		this.var_103a = (this.var_1192 * var_1012.var_46c2[0].imageWidth + 8);
		this.var_1042 = (this.var_119a * var_1012.var_46c2[0].imageHeight + 8);
		if (this.var_103a > paramInt1) {
			int someInt;
			someInt = var_1012.var_46c2[0].imageWidth;
			this.var_1172 = ((paramInt1 - 8) / someInt);
			this.var_103a = (someInt * this.var_1172 + 8);
		} else {
			this.var_1172 = this.var_1192;
		}
		if (this.var_1042 > paramInt2) {
			int someInt;
			someInt = var_1012.var_46c2[0].imageHeight;
			this.var_117a = ((paramInt2 - 8) / someInt);
			this.var_1042 = (someInt * this.var_117a + 8);
		} else {
			this.var_117a = this.var_119a;
		}
		this.var_108a = 8;
	}

	public final void sub_1930(int paramInt1, int paramInt2, int paramInt3) {
		this.var_102a = paramInt1;
		this.var_1032 = paramInt2;
		if ((paramInt3 & 0x1) != 0) {
			this.var_102a -= (this.var_103a >> 1);
		} else if ((paramInt3 & 0x8) != 0) {
			this.var_102a -= this.var_103a;
		}
		if ((paramInt3 & 0x2) != 0) {
			this.var_1032 -= (this.var_1042 >> 1);
		} else if ((paramInt3 & 0x20) != 0) {
			this.var_1032 -= this.var_1042;
		}
		this.var_107a = this.var_102a;
		this.var_1082 = this.var_1032;
	}

	public final void sub_19f5(String paramString, int paramInt1,
			int paramInt2, byte paramByte) {
		this.var_10c2 = paramByte;
		if (paramByte == -1) {
			this.var_1092 = 14;
		} else {
			this.var_10da = (var_1012.var_476a.spriteFrameWidth - 8);
		}
		int intVal;
		intVal = paramInt1 - this.var_10da - 16;
		this.var_101a = Class_f_StringManager.wrapStringText(paramString, intVal,
				Class_c_MainCanvas.theFont);
		sub_1a89(null, this.var_101a, paramInt1, paramInt2);
		this.var_113a = false;
		this.var_108a = 7;
	}

	private void sub_1a89(String paramString, String[] paramArrayOfString,
			int paramInt1, int paramInt2) {
		this.var_10fa = false;
		this.var_103a = paramInt1;
		this.var_1042 = paramInt2;
		this.var_1062 = paramArrayOfString.length;
		this.var_105a = 0;
		this.var_10ca = 0;
		this.var_10e2 = 0;
		this.var_113a = false;
		paramInt1 = paramInt1 - this.var_10da - 16;
		if (paramString != null) {
			this.var_10ea = Class_f_StringManager.wrapStringText(paramString, paramInt1,
					Class_c_MainCanvas.theFont);
		}
		this.var_101a = paramArrayOfString;
		this.var_104a = Class_c_MainCanvas.var_1767;
		this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
		this.var_10ba = (this.var_10b2 / 2);
		int someInteger;
		if (paramInt2 <= 0) {
			someInteger = this.canvasHeight;
		} else {
			someInteger = paramInt2;
		}
		if ((this.var_1092 & 0x1) == 0) {
			someInteger -= 5;
		}
		if ((this.var_1092 & 0x2) == 0) {
			someInteger -= 5;
		}
		if (paramString != null) {
			someInteger -= this.var_10ea.length * this.var_104a;
		}
		this.var_10d2 = ((someInteger - 2) / this.var_104a);
		if (this.var_10d2 > this.var_101a.length) {
			this.var_10d2 = this.var_101a.length;
		} else if (this.var_10d2 < this.var_101a.length) {
			this.var_113a = true;
		}
		if (paramInt2 < 0) {
			if (this.var_10ea != null) {
				this.var_1042 = (this.var_10ea.length * this.var_104a);
			}
			this.var_1042 += this.var_10d2 * this.var_104a;
			if ((this.var_1092 & 0x1) == 0) {
				this.var_1042 += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				this.var_1042 += 5;
			}
		} else {
			this.var_1122 = ((someInteger - this.var_10d2 * this.var_104a) / 2);
		}
		this.var_108a = 10;
		this.var_1002 = 2;
	}

	public final void sub_1ca8(String paramString1, String paramString2,
			int paramInt1, int paramInt2) {
		int i = paramInt1 - this.var_10da;
		if ((this.var_1092 & 0x4) == 0) {
			i -= 8;
		}
		if ((this.var_1092 & 0x8) == 0) {
			i -= 8;
		}
		this.var_101a = Class_f_StringManager.wrapStringText(paramString2, i,
				Class_c_MainCanvas.theFont);
		sub_1a89(paramString1, this.var_101a, paramInt1, paramInt2);
		if (this.var_113a) {
			i -= var_1012.var_472a.spriteFrameWidth;
			this.var_101a = Class_f_StringManager.wrapStringText(paramString2, i,
					Class_c_MainCanvas.theFont);
			sub_1a89(paramString1, this.var_101a, paramInt1, paramInt2);
		}
	}

	private final void sub_1d69() {
		this.someSprites = new Class_g_Sprite[3];
		for (int i = 0; i < this.someSprites.length; i++) {
			this.someSprites[i] = new Class_g_Sprite(var_1012.var_4762);
		}
		sub_1dd0();
	}

	private void sub_1dd0() {
		for (int i = 0; i < this.someSprites.length; i++) {
			this.someSprites[i].var_c18 = true;
			this.someSprites[i].setPixelPosition(
					Class_c_MainCanvas.getRandomMax(this.var_1252.spriteFrameWidth),
					Class_c_MainCanvas.getRandomMax(this.var_1252.spriteFrameHeight));
			this.someSprites[i].setCurrentFrameIndex(Class_c_MainCanvas.getRandomMax(this.someSprites[i]
					.getImagesCount()));
		}
	}

	public final void sub_1e54(String[] paramArrayOfString,
			Class_d_ImageWrap[] paramArrayOfClass_d_0033, int paramInt1,
			int paramInt2, int paramInt3) {
		this.var_1092 = 15;
		this.var_101a = paramArrayOfString;
		this.var_1022 = paramArrayOfClass_d_0033;
		this.var_1062 = this.var_101a.length;
		this.var_103a = 0;
		for (int it = 0; it < this.var_1062; it++) {
			int width;
			if ((width = Class_c_MainCanvas.theFont.stringWidth(this.var_101a[it])) > this.var_103a) {
				this.var_103a = width;
			}
		}
		this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
		this.var_10ba = (this.var_10b2 / 2);
		this.var_123a = var_1012.var_4a12.spriteFrameWidth;
		this.var_104a = (this.var_123a + this.var_10b2);
		this.var_103a += this.var_1062 * this.var_104a;
		this.var_103a += 32;
		if (this.var_103a > this.canvasWidth) {
			this.var_103a = this.canvasWidth;
		}
		this.var_1042 = this.var_123a;
		sub_1930(paramInt1, paramInt2, paramInt3);
		this.var_108a = 13;
		this.var_1002 = 2;
	}

	public final void sub_1f72(String[] paramArrayOfString, int paramInt1,
			int paramInt2) {
		this.var_101a = paramArrayOfString;
		this.var_1062 = this.var_101a.length;
		this.var_1152 = true;
		this.var_10fa = false;
		this.var_1042 = paramInt2;
		int someInt = 0;
		for (paramInt2 = 0; paramInt2 < this.var_101a.length; paramInt2++) {
			int strWidth;
			if ((strWidth = Class_c_MainCanvas.theFont
					.stringWidth(this.var_101a[paramInt2])) > someInt) {
				someInt = strWidth;
			}
		}
		this.var_103a = (someInt + 16 + (var_1012.var_4722.spriteFrameWidth << 1));
		if (this.var_103a < paramInt1) {
			this.var_103a = paramInt1;
		}
		if (this.var_1042 < 0) {
			this.var_1042 = Class_c_MainCanvas.var_1767;
			if (var_1012.var_4722.spriteFrameHeight > this.var_1042) {
				this.var_1042 = var_1012.var_4722.spriteFrameHeight;
			}
			if ((this.var_1092 & 0x1) == 0) {
				this.var_1042 += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				this.var_1042 += 5;
			}
		}
		this.var_108a = 14;
		this.var_1002 = 2;
	}

	public final void sub_20ad(String[] paramArrayOfString, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int paramInt6) {
		this.var_101a = paramArrayOfString;
		this.var_1062 = this.var_101a.length;
		this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
		this.var_104a = Class_c_MainCanvas.var_1767;
		int someInt = 0;
		for (int i = 0; i < this.var_101a.length; i++) {
			int width;
			if ((width = Class_c_MainCanvas.theFont.stringWidth(this.var_101a[i])) > someInt) {
				someInt = width;
			}
		}
		this.var_103a = (someInt + 4 + 16);
		if (this.var_103a > this.canvasWidth) {
			this.var_103a = this.canvasWidth;
		} else if (this.var_103a < paramInt3) {
			if (paramInt6 == 4) {
				this.var_11ea = ((paramInt3 - this.var_103a) / 2);
			}
			this.var_103a = paramInt3;
		}
		this.var_1042 = (this.var_104a * this.var_101a.length + this.var_10b2 + 16);
		if (this.var_1042 > paramInt4) {
			this.var_1042 = paramInt4;
		}
		sub_1a89(null, this.var_101a, this.var_103a, this.var_1042);
		if ((this.var_103a < this.canvasWidth) && (this.var_113a)) {
			this.var_103a += var_1012.var_472a.spriteFrameWidth;
		}
		this.var_108a = 11;
		sub_1930(paramInt1, paramInt2, paramInt5);
	}

	public final void sub_224f(String[] paramArrayOfString,
			Class_d_ImageWrap[] paramArrayOfClass_d_0033, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
		this.var_124a = 1;
		this.var_101a = paramArrayOfString;
		this.var_1022 = paramArrayOfClass_d_0033;
		this.var_1062 = this.var_101a.length;
		this.var_1252 = var_1012.var_4a0a;
		this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
		this.var_1092 = 15;
		this.var_123a = this.var_1252.spriteFrameWidth;
		this.var_1242 = (this.var_123a >> 1);
		sub_1d69();
		this.var_11f2 = new short[this.var_1062];
		this.var_1222 = (360 / this.var_1062);
		this.var_121a = (this.var_1222 / 2);
		this.var_1212 = this.var_121a;
		for (int it = 0; it < this.var_1062; it++) {
			this.var_11f2[it] = ((short) (this.var_1222 * it));
		}
		if (this.var_1062 == 1) {
			this.var_1202 = 0;
		} else if (paramInt3 <= 0) {
			this.var_1202 = ((this.var_1252.spriteFrameWidth << 10) / (2 * Class_f_StringManager
					.sub_f0f(45)));
			this.var_120a = (this.var_1202 + this.var_1252.spriteFrameWidth / 2);
			paramInt3 = (this.var_120a << 1) + Class_c_MainCanvas.var_1767 + 2;
		} else {
			int someInt;
			someInt = (this.var_1252.spriteFrameWidth << 10)
					/ Class_f_StringManager.sub_f0f(this.var_1222 / 2)
					+ this.var_1252.spriteFrameHeight / 2;
			this.var_120a = ((paramInt3 - Class_c_MainCanvas.var_1767) / 2 - 2);
			if (this.var_120a > someInt) {
				this.var_120a = someInt;
			}
			this.var_1202 = (this.var_120a - this.var_1252.spriteFrameHeight / 2);
		}
		this.var_11fa = 0;
		this.var_103a = (this.var_120a << 1);
		this.var_1042 = paramInt3;
		this.var_1002 = 0;
		sub_1930(paramInt1, paramInt2, 3);
	}

	private int sub_242b(int paramInt) {
		int i = this.var_114a;
		int j = this.var_114a;
		int k = this.var_1142.size();
		do {
			if ((i += paramInt) < 0) {
				i = k - 1;
			} else if (i >= this.var_1142.size()) {
				if (j < 0) {
					return -1;
				}
				i = 0;
			}
		} while (!((Class_e_0134) this.var_1142.elementAt(i)).var_1152);
		return i;
	}

	public final void sub_24ca() {
		sub_24ea(true);
	}

	private void sub_24ea(boolean paramBoolean) {
		if (this.var_1002 != 3) {
			if ((this.var_108a == 10) && (this.var_10f2 > 0)
					&& (this.var_10f2 <= 250)) {
				this.var_1132 += 1;
				this.var_109a = true;
			} else if (this.var_1132 > 0) {
				this.var_1132 -= 1;
				this.var_109a = true;
			}
			if ((paramBoolean) && (this.var_1002 == 2)) {
				paramBoolean = false;
				if ((this.var_fe2[0] != false)
						&& ((Class_f_StringManager.mainCanvas
								.sub_26d7(Class_g_1956.var_4602)) || (Class_f_StringManager.mainCanvas
								.sub_26d7(16)))) {
					paramBoolean = true;
					Class_f_StringManager.mainCanvas.releaseGameAction(Class_g_1956.var_4602);
					Class_f_StringManager.mainCanvas.releaseGameAction(16);
				}
				if ((this.var_108a == 0) || (this.var_108a == 3)) {
					for (int i = 0; i < this.someSprites.length; i++) {
						if (this.someSprites[i].currentFrameIndex == this.someSprites[i]
								.getImagesCount() - 1) {
							if (this.var_1232 == 0) {
								this.someSprites[i]
										.setPixelPosition(
												Class_c_MainCanvas
														.getRandomMax(this.var_1252.spriteFrameWidth
																- this.someSprites[i].spriteFrameWidth),
												Class_c_MainCanvas
														.getRandomMax(this.var_1252.spriteFrameHeight
																- this.someSprites[i].spriteFrameHeight));
							} else {
								this.someSprites[i].var_c18 = false;
							}
						}
						this.someSprites[i].nextFrame();
					}
					this.var_109a = true;
				}
				if ((!this.var_115a) && (this.var_114a >= 0)) {
					int m;
					if (Class_f_StringManager.mainCanvas.sub_26d7(1)) {
						((Class_e_0134) this.var_1142.elementAt(this.var_114a)).var_109a = true;
						this.var_114a = sub_242b(-1);
						Class_e_0134 localClass_e_01341;
						(localClass_e_01341 = (Class_e_0134) this.var_1142
								.elementAt(this.var_114a)).var_109a = true;
						m = localClass_e_01341.var_1032;
						for (int j = 0; j < 5; j++) {
							if (m < this.var_11da[j]) {
								if (this.var_11ca == j) {
									break;
								}
								sub_1272();
								this.var_11ca = j;
								break;
							}
							m -= this.var_11da[j];
						}
					}
					if (Class_f_StringManager.mainCanvas.sub_26d7(2)) {
						((Class_e_0134) this.var_1142.elementAt(this.var_114a)).var_109a = true;
						this.var_114a = sub_242b(1);
						Class_e_0134 localClass_e_01342;
						(localClass_e_01342 = (Class_e_0134) this.var_1142
								.elementAt(this.var_114a)).var_109a = true;
						m = localClass_e_01342.var_1032;
						for (int k = 0; k < 5; k++) {
							if (m < this.var_11da[k]) {
								if (this.var_11ca == k) {
									break;
								}
								sub_1272();
								this.var_11ca = k;
								break;
							}
							m -= this.var_11da[k];
						}
					}
				}
				if (paramBoolean) {
					var_1012.sub_770a(this, this.var_114a, "", (byte) 0);
					return;
				}
				int k = 0;
				Class_e_0134 localClass_e_01343 = (Class_e_0134) this.var_1142
						.elementAt(k);
				localClass_e_01343.sub_24ea(k == this.var_114a ? true
						: this.var_115a ? true : false);
				this.var_109a = true;
				if (this.var_108a == 0) {
					if (this.var_1002 == 2) {
						this.var_109a = true;
						if (Class_f_StringManager.mainCanvas.sub_26d7(4)) {
							this.var_1232 -= this.var_1222;
							this.var_122a += this.var_1222;
							this.var_105a -= 1;
							if (this.var_105a < 0) {
								this.var_105a = (this.var_1062 - 1);
							}
						} else if (Class_f_StringManager.mainCanvas.sub_26d7(8)) {
							this.var_1232 += this.var_1222;
							this.var_122a -= this.var_1222;
							if (this.var_122a < 0) {
								this.var_122a += 360;
							}
							this.var_105a += 1;
							if (this.var_105a >= this.var_1062) {
								this.var_105a = 0;
							}
						}
						if (this.var_1232 != 0) {
							if ((k = -this.var_1232 / 2) == 0) {
								this.var_1232 = 0;
							} else {
								this.var_1232 += k;
							}
							if (this.var_1232 == 0) {
								sub_1dd0();
							}
						} else if (Class_f_StringManager.mainCanvas.isGameActionRunning(4)) {
							this.var_1232 -= this.var_1222;
							this.var_122a += this.var_1222;
							this.var_105a -= 1;
							if (this.var_105a < 0) {
								this.var_105a = (this.var_1062 - 1);
							}
						} else if (Class_f_StringManager.mainCanvas.isGameActionRunning(8)) {
							this.var_1232 += this.var_1222;
							this.var_122a -= this.var_1222;
							if (this.var_122a < 0) {
								this.var_122a += 360;
							}
							this.var_105a += 1;
							if (this.var_105a >= this.var_1062) {
								this.var_105a = 0;
							}
						}
						if (paramBoolean) {
							var_1012.sub_770a(this, this.var_105a,
									this.var_101a[this.var_105a], (byte) 0);
						}
					}
				} else if ((this.var_108a != 13) && (this.var_108a != 14)) {
					if (this.var_108a == 3) {
						if (this.var_10e2 != 0) {
							if (Math.abs(this.var_10e2) < 2) {
								this.var_10e2 = 0;
							} else {
								this.var_10e2 -= this.var_10e2 / 2;
							}
							this.var_109a = true;
						}
						if (paramBoolean) {
							var_1012.sub_770a(this, this.var_105a,
									this.var_101a[this.var_105a], (byte) 0);
							return;
						}
						if (Class_f_StringManager.mainCanvas.sub_26d7(4)) {
							if (this.var_105a < this.var_10ca) {
								this.var_105a += this.var_1062;
							}
							this.var_105a -= 1;
							if (this.var_105a < this.var_10ca) {
								if (this.var_105a < 0) {
									this.var_105a += this.var_1062;
								}
								this.var_10ca = this.var_105a;
								this.var_10e2 = (-this.var_104a);
							}
							this.var_105a %= this.var_1062;
							var_1012.sub_770a(this, this.var_105a, null,
									(byte) 2);
							sub_1dd0();
							this.var_109a = true;
						} else if (Class_f_StringManager.mainCanvas.sub_26d7(8)) {
							if (this.var_105a < this.var_10ca) {
								this.var_105a += this.var_1062;
							}
							this.var_105a += 1;
							if (this.var_105a >= this.var_10ca + this.var_10d2) {
								this.var_10e2 = this.var_104a;
								this.var_10ca = ((this.var_10ca + 1) % this.var_1062);
							}
							this.var_105a %= this.var_1062;
							var_1012.sub_770a(this, this.var_105a, null,
									(byte) 3);
							sub_1dd0();
							this.var_109a = true;
						}
					} else if ((this.var_108a != 10) && (this.var_108a != 7)
							&& (this.var_108a != 11)) {
						if (this.var_108a == 8) {
							if (Class_f_StringManager.mainCanvas.sub_26d7(1)) {
								if (this.var_116a > 0) {
									this.var_116a -= 1;
									this.var_109a = true;
								}
							} else if ((Class_f_StringManager.mainCanvas.sub_26d7(2))
									&& (this.var_116a + this.var_117a < this.var_119a)) {
								this.var_116a += 1;
								this.var_109a = true;
							}
							if (Class_f_StringManager.mainCanvas.sub_26d7(4)) {
								if (this.var_1162 > 0) {
									this.var_1162 -= 1;
									this.var_109a = true;
								}
							} else if ((Class_f_StringManager.mainCanvas.sub_26d7(8))
									&& (this.var_1162 + this.var_1172 < this.var_1192)) {
								this.var_1162 += 1;
								this.var_109a = true;
							}
						}
					} else {
						if (this.var_10f2 != -1) {
							if (this.var_10f2 > 0) {
								this.var_10f2 -= 50;
							} else {
								Class_f_StringManager.mainCanvas.sub_220e(this.stringManager);
							}
						}
						if (this.var_10e2 > 0) {
							this.var_10e2 -= this.var_104a / 3 + 1;
							if (this.var_10e2 < 0) {
								this.var_10e2 = 0;
							}
							this.var_109a = true;
						} else if (this.var_10e2 < 0) {
							this.var_10e2 += this.var_104a / 3 + 1;
							if (this.var_10e2 > 0) {
								this.var_10e2 = 0;
							}
							this.var_109a = true;
						}
						if (this.var_10e2 == 0) {
							if (((this.var_108a == 11) || (this.var_108a == 10))
									&& (paramBoolean)) {
								var_1012.sub_770a(this, this.var_105a,
										this.var_101a[this.var_105a], (byte) 0);
								return;
							}
							if ((this.var_108a != 7)
									&& (Class_f_StringManager.mainCanvas.sub_26d7(1))) {
								if (this.var_108a == 11) {
									this.var_105a -= 1;
									if (this.var_105a < 0) {
										this.var_105a = (this.var_1062 - 1);
										this.var_10ca = (this.var_1062 - this.var_10d2);
										if (this.var_108a == 3) {
											this.var_10ca = this.var_105a;
										}
									} else if (this.var_105a < this.var_10ca) {
										this.var_10e2 = (-this.var_104a);
										this.var_10ca -= 1;
									}
									var_1012.sub_770a(this, this.var_105a,
											null, (byte) 2);
									this.var_109a = true;
								} else if (this.var_10ca > 0) {
									this.var_10e2 = (-this.var_104a);
									this.var_10ca -= 1;
									this.var_109a = true;
								}
								Class_f_StringManager.mainCanvas.sub_26ad();
							}
							if ((Class_f_StringManager.mainCanvas.sub_26d7(2))
									|| ((this.var_108a == 7) && (Class_f_StringManager.mainCanvas
											.sub_26d7(2048)))) {
								if (this.var_108a == 11) {
									this.var_105a += 1;
									if (this.var_105a >= this.var_1062) {
										this.var_105a = 0;
										this.var_10ca = 0;
									} else if (this.var_105a >= this.var_10ca
											+ this.var_10d2) {
										this.var_10e2 = this.var_104a;
										this.var_10ca += 1;
									}
									var_1012.sub_770a(this, this.var_105a,
											null, (byte) 3);
									this.var_109a = true;
								} else if (this.var_10ca + this.var_10d2 < this.var_101a.length) {
									this.var_10e2 = this.var_104a;
									this.var_10ca += 1;
									this.var_109a = true;
								} else if (this.var_108a == 7) {
									var_1012.sub_770a(this, 0, null, (byte) 0);
									return;
								}
								Class_f_StringManager.mainCanvas.sub_26ad();
							}
						}
					}
				} else if (Class_f_StringManager.mainCanvas.sub_26d7(4)) {
					this.var_105a -= 1;
					if (this.var_105a < 0) {
						this.var_105a = (this.var_1062 - 1);
					}
					if (this.var_108a == 14) {
						var_1012.sub_770a(this, this.var_105a, null, (byte) 2);
					}
					this.var_109a = true;
				} else if (Class_f_StringManager.mainCanvas.sub_26d7(8)) {
					this.var_105a += 1;
					if (this.var_105a >= this.var_1062) {
						this.var_105a = 0;
					}
					if (this.var_108a == 14) {
						var_1012.sub_770a(this, this.var_105a, null, (byte) 2);
					}
					this.var_109a = true;
				} else if (paramBoolean) {
					var_1012.sub_770a(this, this.var_105a,
							this.var_101a[this.var_105a], (byte) 0);
					return;
				}
				if ((this.var_1002 == 2)
						&& (this.var_fe2[1] != false)
						&& (Class_f_StringManager.mainCanvas
								.sub_26d7(Class_g_1956.var_460a))) {
					Class_f_StringManager.mainCanvas.releaseGameAction(Class_g_1956.var_460a);
					Class_f_StringManager.mainCanvas.sub_26ad();
					if (this.stringManager != null) {
						Class_f_StringManager.mainCanvas.sub_220e(this.stringManager);
					}
					if (this.var_101a != null) {
						var_1012.sub_770a(this, this.var_105a,
								this.var_101a[this.var_105a], (byte) 1);
						return;
					}
					var_1012.sub_770a(this, -1, null, (byte) 1);
					return;
				}
			}
			if ((this.var_10fa) && (++this.var_1072 >= this.var_100a)) {
				if (this.var_106a == 0) {
					this.var_106a = 2;
				} else {
					this.var_106a = 0;
				}
				this.var_1072 = 0;
				this.var_109a = true;
			}
			switch (this.var_1002) {
			case 0:
				if (this.var_108a == 0) {
					if (this.var_11fa < this.var_1202) {
						int someInt;
						if (this.var_124a == 2) {
							someInt = this.var_1202 / 2;
						} else {
							someInt = this.var_1202 / 5;
						}
						if (!paramBoolean) {
							paramBoolean = true;
						}
						this.var_11fa += someInt;
						if (this.var_11fa > this.var_1202) {
							this.var_11fa = this.var_1202;
						}
					} else {
						this.var_1212 = (Math.abs(360 - this.var_11f2[0]) / 2);
						if (this.var_1212 <= 0) {
							this.var_1212 = 1;
						} else if (this.var_1212 > this.var_121a) {
							this.var_1212 = this.var_121a;
						}
					}
					if (this.var_124a == 1) {
						for (int it = 0; it < this.var_11f2.length; it++) {
							this.var_11f2[it] = ((short) ((this.var_11f2[it] + this.var_1212) % 360));
						}
					}
					if ((Class_f_StringManager.mainCanvas.sub_2677())
							|| ((this.var_11fa >= this.var_1202) && (this.var_11f2[0] == 0))) {
						this.var_11fa = this.var_1202;
						for (int it = 0; it < this.var_11f2.length; it++) {
							this.var_11f2[it] = ((short) (this.var_1222 * it));
						}
						this.var_1002 = 2;
						if (this.var_1112) {
							Class_f_StringManager.mainCanvas.sub_26ad();
						}
					}
				} else if (this.var_108a == 13) {
					this.var_107a += (this.var_102a - this.var_107a) / 2;
					this.var_1102 += 1;
					if (this.var_1102 == 2) {
						this.var_1002 = 2;
						this.var_107a = this.var_102a;
					}
				} else {
					int theInt;
					if ((theInt = (this.var_102a - this.var_107a) / 4) <= 0) {
						paramBoolean = true;
					}
					this.var_107a += theInt;
					if (this.var_107a == this.var_102a) {
						this.var_1002 = 2;
					}
				}
				this.var_109a = true;
				return;
			case 1:
				this.var_1002 = 3;
			}
		}
	}

	public static final void sub_3421(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		if (paramInt4 <= 2) {
			paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
			return;
		}
		paramGraphics.fillRect(paramInt1, paramInt2 + 1, paramInt3,
				paramInt4 - 2);
		paramGraphics.fillRect(paramInt1 + 1, paramInt2, paramInt3 - 2,
				paramInt4);
	}

	public final void sub_347b(Graphics paramGraphics) {
		sub_349e(paramGraphics, 0, 0, false);
	}

	private void sub_349e(Graphics paramGraphics, int paramInt1, int paramInt2,
			boolean paramBoolean) {
		if ((this.var_1002 != 3) && (this.var_109a)) {
			this.var_109a = false;
			if (((Class_f_StringManager.mainCanvas.var_17b7 == this) && (this.var_10a2))
					|| (this.var_108a == 0)) {
				var_1012.sub_fe5d(paramGraphics);
			}
			this.var_10a2 = false;
			paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			if (this.var_11ba != null) {
				this.var_11ba.sub_347b(paramGraphics);
			}
			paramInt1 = this.var_107a;
			paramInt2 = this.var_1082 + paramInt2;
			if ((this.var_108a != 0) && (this.var_108a != 13)) {
				sub_5092(paramGraphics, paramInt1, paramInt2, this.var_103a,
						this.var_1042, this.var_1092, this.var_11aa,
						this.var_11a2, this.var_1132, 5);
				paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			}
			int bool1 = this.var_103a;
			int bool2 = this.var_1042;
			if ((this.var_1092 & 0x1) == 0) {
				bool2 -= 5;
				paramInt2 += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				bool2 -= 5;
			}
			if ((this.var_1092 & 0x4) == 0) {
				paramInt1 += 8;
				bool1 -= 8;
			}
			if ((this.var_1092 & 0x8) == 0) {
				bool1 -= 8;
			}
			paramGraphics.translate(paramInt1, paramInt2);
			paramGraphics.setFont(this.var_1052);
			if ((this.var_11b2 != null)
					&& ((this.var_101a == null) || (this.var_1052
							.stringWidth(this.var_101a[0]) < bool1
							- (this.var_11b2.imageWidth << 1)))) {
				this.var_11b2.drawOnGraphics(paramGraphics, 0, bool2 / 1, 6);
			}
			if (paramBoolean) {
				paramGraphics.setColor(5594742);
				sub_3421(paramGraphics, 0, 0, bool1, bool2);
			}
			int k;
			int bool4;
			int bool3;
			int bool5;
			if (this.var_108a == 0) {
				paramGraphics.setColor(16777215);
				k = this.var_122a + this.var_1232;
				for (bool4 = this.var_11f2.length - 1; bool4>0; bool4--) {
					if ((bool3 = (this.var_11f2[bool4] + k) % 360) < 0) {
						bool3 += 360;
					}
					int iInt = this.var_120a
							+ (Class_f_StringManager.sub_f0f(bool3) * this.var_11fa >> 10);
					bool3 = Class_c_MainCanvas.var_1767
							+ this.var_120a
							+ 2
							- (Class_f_StringManager.sub_f35(bool3) * this.var_11fa >> 10);
					if ((this.var_1002 == 2) && (bool4 == this.var_105a)) {
						this.var_1252.drawFrame(paramGraphics, 1, iInt,
								bool3, 3);
						if (this.var_1232 == 0) {
							bool5 = 0;
						}
					} else {
						while (bool5 < this.someSprites.length) {
							this.someSprites[bool5].drawCurrentFrame(paramGraphics,
									iInt - this.var_1242, bool3
											- this.var_1242, 20);
							bool5++;
							continue;
							this.var_1252.drawFrame(paramGraphics, 0,
									iInt, bool3, 3);
						}
					}
					if ((this.var_101a[bool4] != null)
							&& (this.var_1022 != null)
							&& (this.var_1022[bool4] != null)) {
						this.var_1022[bool4].drawOnGraphics(paramGraphics,
								iInt, bool3, 3);
					}
				}
				if (this.var_1002 == 2) {
					for (bool4 = 0; bool4 < this.someSprites.length; bool4++) {
						this.someSprites[bool4].drawCurrentFrame(paramGraphics,
								(this.var_103a - this.var_123a) / 2,
								Class_c_MainCanvas.var_1767, 3);
					}
				}
			}
			int bool12;
			int m;
			int bool9;
			int i4;
			int i3;
			int j;
			int bool7;
			int bool10;
			int bool11;
			int i;
			int n;
			switch (this.var_108a) {
				case 0:
					if (this.var_1002 == 2) {
						paramGraphics.setColor(1645370);
						if (this.var_124a == 2) {
							bool2 = this.var_103a;
							if (this.var_101a[this.var_105a] != null) {
								bool12 = Class_c_MainCanvas.theFont
										.stringWidth(this.var_101a[this.var_105a]) + 2;
								if (bool2 < bool12) {
									bool2 = bool12;
								}
							}
							sub_3421(paramGraphics, (this.var_103a - bool2) / 2, 1,
									bool2, Class_c_MainCanvas.var_1767);
						} else {
							sub_3421(paramGraphics, 2 - this.var_102a, 1,
									this.canvasWidth - 4, Class_c_MainCanvas.var_1767);
						}
						if (this.var_101a[this.var_105a] != null) {
							paramGraphics.setColor(16777215);
							Class_c_MainCanvas.showString(paramGraphics,
									this.var_101a[this.var_105a], this.var_120a,
									(this.var_10b2 >> 1) + 1, 17);
						}
					}
				case 1:
				case 4:
				case 6:
				case 9:
				case 12:
				default:
					break;
				case 2:
				case 5:
					paramGraphics.setClip(0, 0, bool1, bool2);
					bool2 = var_ff2;
					this.var_110a.sub_28d7(paramGraphics, -this.var_110a.m + bool2,
							-this.var_110a.n + bool2);  // m n p o
					k = bool2 + this.var_110a.p / 2;
					paramGraphics.setFont(Class_c_MainCanvas.theFont);
					paramGraphics.setColor(this.var_fea);
					Class_c_MainCanvas.showString(paramGraphics, this.var_110a.unitName,
							bool2 + this.var_110a.o + bool2, k
									- Class_c_MainCanvas.fontBaselinePos / 2, 20);
					String str2;
					if (this.var_108a == 2) {
						str2 = "" + this.var_110a.cost;
						var_1012.var_4a2a.drawFrame(paramGraphics, 1, bool1 - bool2
								- Class_c_MainCanvas.sub_1e71((byte) 1, str2), k, 10);
					} else {
						str2 = "" + this.var_110a.health;
					}
					Class_c_MainCanvas.sub_2007(paramGraphics, str2, bool1 - bool2, k, 1,
							10);
					this.var_10b2 = (Class_c_MainCanvas.var_1767 - Class_c_MainCanvas.fontBaselinePos);
					bool3 = bool2 + this.var_110a.p + var_ff2;
					paramGraphics.setColor(this.var_fea);
					paramGraphics.drawLine(bool2, bool3, bool1 - bool2 - bool2,
							bool3);
					bool3 += 1 + var_ff2;
					int i2;
					if (this.var_108a == 5) {
						bool5 = Class_c_MainCanvas.fontBaselinePos;
						k = bool3 + bool5 / 1;
						Class_c_MainCanvas.showString(paramGraphics,
								Class_f_StringManager.getLangString(97), bool2, bool3, 20);
						bool4 = Class_c_MainCanvas.theFont.stringWidth(Class_f_StringManager
								.getLangString(97));
						int sumBool;
						sumBool = bool2 + bool4 + bool2;
						String str1 = "" + this.var_110a.level;
						i2 = Class_c_MainCanvas.sub_1e71((byte) 0, str1);
						int bool13 = bool1 - sumBool - bool2
								- var_1012.var_4a22.spriteFrameWidth - i2 - bool2;
						paramGraphics.setColor(this.var_fea);
						sub_3421(paramGraphics, sumBool, bool3, bool13, bool5);
						paramGraphics.setColor(2370117);
						int bool6;
						if ((bool6 = bool13 * this.var_110a.maybeExperience
								/ this.var_110a.getLevelExperience()) <= 0) {
							bool6 = 1;
						}
						paramGraphics.fillRect(sumBool + 1, bool3 + 1,
								bool6, bool5 - 1);
						sumBool = bool1 - bool2 - i2;
						var_1012.var_4a22.drawFrame(paramGraphics, 2, sumBool,
								k, 10);
						Class_c_MainCanvas.sub_2007(paramGraphics, str1, sumBool, k,
								0, 6);
						bool3 += bool5 + var_ff2;
						paramGraphics.setColor(this.var_fea);
						paramGraphics.drawLine(bool2, bool3, bool1 - bool2 - bool2,
								bool3);
						bool3 += 1 + var_ff2;
					}
					bool5 = (bool1 - bool2 * 1) / 2;
					m = var_1012.var_4a22.spriteFrameHeight;
					int bool13 = var_1012.var_4a12.spriteFrameHeight;
					int bool6 = var_1012.var_4a12.spriteFrameHeight / 2;
					for (k = 0; k < 2; k++) {
						int bool9Int = bool3 + bool6 - m / 2;
						int sumBool;
						sumBool = bool2;
						for (int bool11Int = 0; bool11Int < 1; bool11Int++) {
							if ((k == 0) || (!bool11)) {
								i2 = sumBool + bool6;
								sub_3421(paramGraphics, i2, bool9Int, bool5 - bool6, m);
								var_1012.var_4a12.sub_1d20(paramGraphics,
										sumBool, bool3);
								if (((i4 = (k << 1) + bool11Int) == 0) || (i4 == 1)) {
									var_1012.var_4a22.drawFrame(paramGraphics, i4,
											i2, bool3 + bool6, 3);
								}
								bool12 = 0;
								if (i4 == 0) {
									if (this.var_108a == 5) {
										i3 = this.var_110a.getSomeAttackValueMaybe1(null);
									}
									str2 = this.var_110a.attackMin + i3 + "-"
											+ (this.var_110a.attackMax + i3);
								} else if (i4 == 1) {
									if (this.var_108a == 5) {
										i3 = this.var_110a.getSomeUnitResistance(null);
									}
									str2 = "" + (this.var_110a.defence + i3);
								} else if (i4 == 2) {
									var_1012.var_4622[5].drawOnGraphics(paramGraphics,
											i2, bool3 + bool6, 3);
									str2 = "" + this.var_110a.moveRange;
								}
								Class_c_MainCanvas.sub_2007(paramGraphics, str2,
										sumBool + bool13 + 1, bool3 + bool6,
										0, 6);
								if (i3 > 0) {
									var_1012.var_4b22.drawFrame(paramGraphics, 1, i2
											+ bool5 - bool6 - 1, bool3 + bool6, 10);
								} else if (i3 < 0) {
									var_1012.var_4b22.drawFrame(paramGraphics, 2, i2
											+ bool5 - bool6 - 1, bool3 + bool6, 10);
								}
								sumBool += bool5 + var_ff2;
							}
						}
						bool3 += bool13;
					}
					bool3 += var_ff2;
					paramGraphics.setColor(this.var_fea);
					paramGraphics.drawLine(bool2, bool3, bool1 - bool2 - bool2,
							bool3);
					break;
				case 3:
					paramGraphics.setClip(0, 0, bool1, bool2);
					bool3 = var_ff2;
					paramGraphics.setColor(11515819);
					paramGraphics.drawLine(var_ff2, bool3, bool1 - (var_ff2 << 1),
							bool3);
					bool3 = bool3 + (1 + var_ff2) + var_1012.var_4a0a.spriteFrameHeight / 2;
					int sumB;
					sumB = var_1012.var_4722.spriteFrameWidth + this.var_10e2
							+ this.var_1122;
					j = this.var_10ca;
					i3 = this.var_10ca + this.var_10d2;
					if (this.var_10e2 > 0) {
						j--;
						sumB -= this.var_104a;
					} else if (this.var_10e2 < 0) {
						i3++;
					}
					for (i4 = j; i4 < i3; i4++) {
						if ((bool5 = i4 % this.var_1062) < 0) {
							bool5 += this.var_1062;
						}
						m = sumB + this.var_104a / 2;
						if (bool5 == this.var_105a) {
							var_1012.var_4a0a.drawFrame(paramGraphics, 1, m, bool3,
									3);
						} else {
							var_1012.var_4a0a.drawFrame(paramGraphics, 0, m, bool3,
									3);
						}
						Class_a_Unit localClass_a_0260 = this.var_10aa[bool5];
						int bool7int = m - localClass_a_0260.m - localClass_a_0260.o / 2; //m
						int bool9int = bool3 - localClass_a_0260.n - localClass_a_0260.p //n p
								/ 2;
						localClass_a_0260
								.sub_28fa(
										paramGraphics,
										bool7int,
										bool9int,
										localClass_a_0260.cost > var_1012.var_486a[var_1012.var_4842]);
						if (bool5 == this.var_105a) {
							k = m - this.var_1252.spriteFrameWidth / 2;
							int bool11int = bool3 - this.var_1252.spriteFrameWidth / 2;
							for (int bool10int = 0; bool10int < this.someSprites.length; bool10int++) {
								this.someSprites[bool10int].drawCurrentFrame(paramGraphics, k,
										bool11int, 20);
							}
						}
						sumB += this.var_104a;
					}
					var_1012.var_4722.drawFrame(paramGraphics, 0, 0, bool3, 6);
					var_1012.var_4722.drawFrame(paramGraphics, 1, bool1, bool3, 10);
					break;
				case 7:
				case 10:
				case 11:
					paramGraphics.setFont(Class_c_MainCanvas.theFont);
					if (this.var_10c2 != -1) {
						var_1012.var_476a.drawFrame(paramGraphics, this.var_10c2,
								-8, j, 36);
					}
					bool1 -= this.var_10da;
					paramGraphics.setClip(0, 0, i, this.var_1042 - 10);
					bool5 = 0;
					bool3 = 0;
					if (this.var_10ea != null) {
						paramGraphics.setColor(Class_g_1956.sub_f52a(16777215,
								this.var_11aa, this.var_1132, 5));
						for (i4 = 0; i4 < this.var_10ea.length; i4++) {
							Class_c_MainCanvas.showString(paramGraphics, this.var_10ea[i4],
									this.var_10da + i / 2, bool3 + this.var_10ba,
									17);
							bool3 += this.var_104a;
						}
						paramGraphics.setColor(10463131);
						paramGraphics.drawLine(0, bool3, i - 1, bool3);
						bool5 = bool3;
					}
					i4 = bool3 + this.var_1122;
					paramGraphics.setColor(this.var_fea);
					int intbool10 = this.var_10ca;
					int intparamBoolean = this.var_10ca + this.var_10d2;
					if (this.var_10e2 > 0) {
						intbool10--;
						bool3 -= this.var_104a;
					} else if (this.var_10e2 < 0) {
						intparamBoolean++;
					}
					bool3 += this.var_10e2 + this.var_1122;
					paramGraphics.setClip(this.var_10da, bool5, i, j - bool5);
					k = i;
					if (this.var_113a) {
						k = i - var_1012.var_472a.spriteFrameWidth;
					}
					m = this.var_10da + k / 2;
					for (bool9 = intbool10; bool9 < intparamBoolean; bool9++) {
						bool5 = 0;
						if (bool3 < i4) {
							bool5 = i4 - bool3;
						} else if (bool3 + this.var_104a > j - this.var_1122) {
							bool5 = bool3 + this.var_104a - j + this.var_1122;
						}
						if ((this.var_108a == 11) && (bool9 == this.var_105a)) {
							paramGraphics.setColor(5594742);
							sub_3421(paramGraphics, 0, bool3, k, this.var_104a);
							bool7 = Class_g_1956.sub_f52a(this.var_11aa, 16777215,
									this.var_104a - bool5, this.var_104a);
						} else {
							bool7 = Class_g_1956.sub_f52a(this.var_11aa,
									this.var_fea, this.var_104a - bool5,
									this.var_104a);
						}
						bool7 = Class_g_1956.sub_f52a(bool7, this.var_11aa,
								this.var_1132, 5);
						paramGraphics.setColor(bool7);
						if (this.var_11ea >= 0) {
							Class_c_MainCanvas.showString(paramGraphics,
									this.var_101a[bool9], this.var_11ea, bool3
											+ this.var_10ba, 20);
						} else {
							Class_c_MainCanvas.showString(paramGraphics,
									this.var_101a[bool9], m, bool3 + this.var_10ba,
									17);
						}
						bool3 += this.var_104a;
					}
					if (this.var_113a) {
						int i1 = var_1012.var_472a.spriteFrameHeight;
						bool5 = var_1012.var_472a.spriteFrameWidth;
						bool7 = var_1012.var_472a.spriteFrameWidth / 2;
						intparamBoolean = j - (i1 << 1) - 2;
						bool3 = i - (bool5 + bool7) / 2;
						if (intparamBoolean > 1) {
							paramGraphics.setColor(this.var_fea);
							sub_3421(paramGraphics, bool3, i1 + 1, bool7,
									intparamBoolean);
							if ((k = (intparamBoolean - 1) * this.var_10d2
									/ this.var_1062) <= 0) {
								k = 1;
							}
							paramGraphics.setColor(2370117);
							sub_3421(paramGraphics, bool3 + 1, i1
									+ (intparamBoolean - 1) * this.var_10ca
									/ this.var_1062 + 2, bool7 - 1, k);
							var_1012.var_472a.drawFrame(paramGraphics, 0, i - bool5,
									0, 20);
							var_1012.var_472a.drawFrame(paramGraphics, 1, i - bool5,
									j, 36);
						} else {
							if (this.var_10ca > 0) {
								var_1012.var_472a.drawFrame(paramGraphics, 0, i
										- bool5, 0, 20);
							}
							if (this.var_10ca + this.var_10d2 < this.var_1062) {
								var_1012.var_472a.drawFrame(paramGraphics, 1, i
										- bool5, j, 36);
							}
						}
					}
					if (this.var_108a != 7) {
						break;
					}
					paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
					int i1 = j;
					if ((this.var_1092 & 0x2) == 0) {
						i1 = j + 5;
					}
					var_1012.var_472a.drawFrame(paramGraphics, 1, i + this.var_10da,
							i1, 40);
					break;
				case 8:
					Class_g_1956.sub_10f49(paramGraphics, 0, 0, this.var_103a,
							this.var_1042);
					bool11 = var_1012.var_46c2[0].imageWidth;
					bool10 = var_1012.var_46c2[0].imageHeight;
					i4 = this.var_117a + this.var_116a;
					i3 = this.var_1172 + this.var_1162;
					bool3 = 1;
					int  bool8;
					for (m = this.var_116a; m < i4; m++) {
						intparamBoolean = 1;
						for (k = this.var_1162; k < i3; k++) {
							bool8 = var_1012.var_46ca[this.var_1182[k][m]];
							if (Class_g_1956.sub_11b75(this.var_1182[k][m])) {
								bool5 = (this.var_1182[k][m] - 37) / 2;
								bool8 = bool5 * 1 + 8 + bool8 - 8;
							}
							var_1012.var_46c2[bool8].sub_1115(paramGraphics,
									intparamBoolean, bool3);
							intparamBoolean += bool11;
						}
						bool3 += bool10;
					}
					if ((this.var_118a != null) && (this.var_106a == 0)) {
						m = -this.var_1162 * bool11 + 4;
						k = -this.var_116a * bool10 + 4;
						bool8 = 0;
						bool5 = var_1012.mapUnitsMaybe.size();
						while (bool8 < bool5) {
							Class_a_Unit paramBooleanCl;
							if (((paramBooleanCl = (Class_a_Unit) var_1012.mapUnitsMaybe
									.elementAt(bool8)).posX >= this.var_1162)
									&& (paramBooleanCl.posX < i3)
									&& (paramBooleanCl.posY >= this.var_116a)
									&& (paramBooleanCl.posY < i4)) {
								var_1012.var_4a62
										.drawFrame(
												paramGraphics,
												var_1012.var_4832[paramBooleanCl.teamId] - 1,
												paramBooleanCl.posX * bool11 + m,
												paramBooleanCl.posY * bool10 + k,
												0);
							}
							bool8++;
						}
					}
					if (this.var_106a != 0) {
						break;
					}
					if (this.var_116a > 0) {
						var_1012.var_472a.drawFrame(paramGraphics, 0, i / 2, 0, 17);
					}
					if (this.var_116a + this.var_117a < this.var_119a) {
						var_1012.var_472a.drawFrame(paramGraphics, 1, i / 2, j, 33);
					}
					if (this.var_1162 > 0) {
						var_1012.var_4722.drawFrame(paramGraphics, 0, 0, j / 2, 6);
					}
					if (this.var_1162 + this.var_1172 >= this.var_1192) {
						break;
					}
					var_1012.var_4722.drawFrame(paramGraphics, 1, i, j / 2, 10);
					break;
				case 13:
					m = Class_c_MainCanvas.var_1767;
					k = (this.var_1042 - m) / 2;
					paramGraphics.setColor(Class_g_1956.sub_f52a(1645370, 16777215,
							this.var_1132, 5));
					sub_3421(paramGraphics, 0, k, this.var_103a, m);
					paramGraphics.setFont(Class_c_MainCanvas.theFont);
					paramGraphics.setColor(16777215);
					Class_c_MainCanvas
							.showString(paramGraphics, this.var_101a[this.var_105a],
									16, k + this.var_10ba, 20);
					n = this.var_103a - this.var_104a;
					bool5 = this.var_1062 - 1;
			}
			while (bool5>0) {
				if (bool5 == this.var_105a) {
					var_1012.var_4a12.drawFrame(paramGraphics, 1, n, 0, 20);
				} else {
					var_1012.var_4a12.drawFrame(paramGraphics, 0, n, 0, 20);
				}
				this.var_1022[bool5].drawOnGraphics(paramGraphics, n
						+ var_1012.var_4a12.spriteFrameWidth / 2, this.var_1042 / 2, 3);
				n -= this.var_104a;
				bool5--;
				continue;
				paramGraphics.setFont(Class_c_MainCanvas.theFont);
				paramGraphics.setColor(Class_g_1956.sub_f52a(16777215, 1645370,
						this.var_1132, 5));
				k = j / 2;
				Class_c_MainCanvas.showString(paramGraphics,
						this.var_101a[this.var_105a], i / 2,
						(j - Class_c_MainCanvas.fontBaselinePos) / 2, 17);
				var_1012.var_4722.drawFrame(paramGraphics, 0, 0, k, 6);
				var_1012.var_4722.drawFrame(paramGraphics, 1, i, k, 10);
				break;
				m = 0;
				bool3 = 0;
				bool5 = this.var_11da[0];
				for (j = 1; j <= this.var_11ca; j++) {
					m = bool5;
					bool5 += this.var_11da[j];
				}
				if (this.var_11ca > 0) {
					bool3 = -m + var_1012.var_4732.spriteFrameHeight;
				}
				for (j = 0; j < this.var_1142.size(); j++) {
					Class_e_0134 intparamBoolean;
					if (((intparamBoolean = (Class_e_0134) this.var_1142
							.elementAt(j)).var_1032 >= m)
							&& (intparamBoolean.var_1032 < bool5)) {
						intparamBoolean.sub_349e(paramGraphics, 0, bool3,
								j == this.var_114a);
					}
				}
				paramGraphics.setClip(0, 0, var_1012.var_459a,
						var_1012.var_45a2);
				if (this.var_11ca > 0) {
					paramGraphics.setColor(2370117);
					paramGraphics.fillRect(0, 0, this.canvasWidth,
							var_1012.var_4732.spriteFrameHeight);
					var_1012.var_472a.drawFrame(paramGraphics, 0,
							var_1012.var_459a / 2, -this.var_106a, 17);
				}
				if (this.var_11ca < this.var_11d2) {
					paramGraphics.setColor(2370117);
					j = this.var_11da[this.var_11ca];
					if (this.var_11ca > 0) {
						j += var_1012.var_4732.spriteFrameHeight;
					}
					paramGraphics.fillRect(0, j, this.canvasWidth,
							var_1012.var_45a2 - j);
					var_1012.var_472a.drawFrame(paramGraphics, 1,
							var_1012.var_459a / 2, var_1012.var_45a2
									+ this.var_106a, 33);
				}
			}
			paramGraphics.translate(-paramInt1, -paramInt2);
			paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			if ((Class_f_StringManager.mainCanvas.var_17b7 == this) && (this.var_1002 == 2)) {
				if (this.var_fe2[0] != false) {
					var_1012.sub_114f1(paramGraphics, Class_g_1956.var_4602, 0,
							var_1012.var_45a2);
				}
				if (this.var_fe2[1] != false) {
					var_1012.sub_114f1(paramGraphics, Class_g_1956.var_460a, 1,
							var_1012.var_45a2);
				}
			}
		}
	}

	public static final void sub_5066(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
		sub_5092(paramGraphics, 0, paramInt2, paramInt3, paramInt4, paramInt5,
				2370117, 2370117, 0, 0);
	}

	public static final void sub_5092(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int paramInt6, int paramInt7, int paramInt8, int paramInt9) {
		Class_g_Sprite localClass_g_2517 = var_1012.var_473a;
		paramGraphics.setClip(paramInt1, paramInt2, paramInt3, paramInt4);
		paramGraphics.setColor(paramInt6);
		paramGraphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
		int i;
		int j;
		int k;
		int m;
		if (paramInt7 != paramInt6) {
			i = paramInt4 / 4;
			j = paramInt2 + 5;
			for (k = 0; k < i; k++) {
				m = Class_g_1956.sub_f52a(paramInt7, paramInt6, k, i);
				paramGraphics.setColor(Class_g_1956.sub_f52a(m, paramInt6,
						paramInt8, paramInt9));
				paramGraphics.fillRect(paramInt1, j, paramInt3, 1);
				j++;
			}
		}
		if (paramInt5 != 15) {
			i = (paramInt5 & 0x4) == 0 ? 1 : 0;
			j = (paramInt5 & 0x8) == 0 ? 1 : 0;
			k = (paramInt5 & 0x1) == 0 ? 1 : 0;
			m = (paramInt5 & 0x2) == 0 ? 1 : 0;
			paramInt5 = paramInt3 / localClass_g_2517.spriteFrameWidth - 2;
			if (paramInt3 % localClass_g_2517.spriteFrameWidth != 0) {
				paramInt5++;
			}
			if (i == 0) {
				paramInt5++;
			}
			if (j == 0) {
				paramInt5++;
			}
			paramInt6 = paramInt4 / localClass_g_2517.spriteFrameHeight - 2;
			if (paramInt4 % localClass_g_2517.spriteFrameHeight != 0) {
				paramInt6++;
			}
			if (k == 0) {
				paramInt6++;
			}
			if (m == 0) {
				paramInt6++;
			}
			paramInt7 = paramInt1;
			if (i != 0) {
				paramInt7 = paramInt1 + localClass_g_2517.spriteFrameWidth;
			}
			paramInt4 = paramInt2 + paramInt4 - localClass_g_2517.spriteFrameHeight;
			for (paramInt8 = 0; paramInt8 < paramInt5; paramInt8++) {
				if (k != 0) {
					localClass_g_2517.drawFrame(paramGraphics, 1, paramInt7,
							paramInt2, 0);
				}
				if (m != 0) {
					localClass_g_2517.drawFrame(paramGraphics, 6, paramInt7,
							paramInt4, 0);
				}
				paramInt7 += localClass_g_2517.spriteFrameWidth;
			}
			paramInt8 = paramInt2;
			if (k != 0) {
				paramInt8 = paramInt2 + localClass_g_2517.spriteFrameHeight;
			}
			paramInt3 = paramInt1 + paramInt3 - localClass_g_2517.spriteFrameWidth;
			for (paramInt5 = 0; paramInt5 < paramInt6; paramInt5++) {
				if (i != 0) {
					localClass_g_2517.drawFrame(paramGraphics, 3, paramInt1,
							paramInt8, 0);
				}
				if (j != 0) {
					localClass_g_2517.drawFrame(paramGraphics, 4, paramInt3,
							paramInt8, 0);
				}
				paramInt8 += localClass_g_2517.spriteFrameHeight;
			}
			if ((i != 0) && (k != 0)) {
				localClass_g_2517.drawFrame(paramGraphics, 0, paramInt1,
						paramInt2, 0);
			}
			if ((j != 0) && (k != 0)) {
				localClass_g_2517.drawFrame(paramGraphics, 2, paramInt3,
						paramInt2, 0);
			}
			if ((i != 0) && (m != 0)) {
				localClass_g_2517.drawFrame(paramGraphics, 5, paramInt1,
						paramInt4, 0);
			}
			if ((j != 0) && (m != 0)) {
				localClass_g_2517.drawFrame(paramGraphics, 7, paramInt3,
						paramInt4, 0);
			}
		}
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_e_0134
 * 
 * JD-Core Version: 0.7.0.1
 */