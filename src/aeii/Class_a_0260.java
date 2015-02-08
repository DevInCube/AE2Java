package aeii;

import a.a.a.Class_g_Sprite;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class Class_a_0260 extends Class_g_Sprite {
	
	public static byte var_dd3 = 12;
	public static byte var_ddb;
	public static byte var_de3 = Class_a_0260.var_ddb = 6;
	private static Class_g_1956 var_deb;
	public String var_df3;
	public short var_dfb;
	public int var_e03;
	public byte[][] var_e0b;
	private Vector var_e13;
	private short var_e1b;
	private long var_e23;
	public byte var_e2b;
	public byte var_e33;
	public short var_e3b;
	public short var_e43;
	public int var_e4b;
	public int var_e53;
	public int var_e5b;
	public int var_e63;
	public int var_e6b;
	public int var_e73;
	public int var_e7b;
	public byte var_e83;
	public byte var_e8b;
	private short var_e93;
	private short var_e9b;
	private short var_ea3;
	private boolean var_eab;
	private boolean var_eb3 = true;
	private int var_ebb;
	private long var_ec3;
	public byte var_ecb;
	public byte var_ed3;
	private int var_edb;
	public Class_a_0260 var_ee3;
	public byte var_eeb = 0;
	public int var_ef3;
	public int var_efb;
	public int var_f03;
	private static String[] var_f0b = { "soldier", "archer", "lizard",
			"wizard", "wisp", "spider", "golem", "catapult", "wyvern", "king",
			"skeleton", "crystall" };
	public static byte[] var_f13 = new byte[12];
	private static byte[][] var_f1b = new byte[12][2];
	private static byte[] var_f23 = new byte[12];
	private static byte[] var_f2b = new byte[12];
	private static byte[] var_f33 = new byte[12];
	public static byte[][][] var_f3b = new byte[12][][];
	public static short[] var_f43 = new short[12];
	private static short[] var_f4b = new short[12];

	private Class_a_0260(byte paramByte1, byte paramByte2, int paramInt1,
			int paramInt2, boolean paramBoolean) {
		super(var_deb.sub_ac4c(paramByte2, paramByte1));
		this.var_e2b = paramByte1;
		this.var_e83 = 0;
		this.var_e3b = ((short) paramInt1);
		this.var_e43 = ((short) paramInt2);
		sub_1b36(paramInt1 * 24, paramInt2 * 24);
		sub_fea((byte) 0);
		if (paramBoolean) {
			var_deb.var_47fa.addElement(this);
		}
	}

	public final void sub_fea(byte paramByte) {
		this.var_dfb = ((short) paramByte);
		paramByte <<= 1;
		this.var_e5b = (var_f1b[this.var_e2b][0] + paramByte);
		this.var_e63 = (var_f1b[this.var_e2b][1] + paramByte);
		this.var_e6b = (var_f23[this.var_e2b] + paramByte);
		this.var_e73 = var_f13[this.var_e2b];
		if (this.var_e2b != 9) {
			int theInt;
			if ((theInt = this.var_dfb / 2) > 3) {
				theInt = 3;
			}
			this.var_df3 = Class_f_0145.getLangString(139 + (this.var_e2b << 2)
					+ theInt);
		}
	}

	public final void sub_108f(int paramInt) {
		this.var_eab = true;
		this.var_ec3 = var_deb.var_479a;
		this.var_ebb = paramInt;
	}

	public static final Class_a_0260 sub_10be(byte paramByte1, byte paramByte2,
			int paramInt1, int paramInt2) {
		return sub_10e1(paramByte1, paramByte2, paramInt1, paramInt2, true);
	}

	public static final Class_a_0260 sub_10e1(byte paramByte1, byte paramByte2,
			int paramInt1, int paramInt2, boolean paramBoolean) {
		if ((paramByte1 == 9)
				&& (var_deb.var_4862[paramByte2] >= var_deb.var_485a[paramByte2].length)) {
			return null;
		}
		Class_a_0260 iclass;
		(iclass = new Class_a_0260(paramByte1, var_deb.var_4832[paramByte2],
				paramInt1, paramInt2, paramBoolean)).var_e2b = paramByte1;
		iclass.var_e33 = paramByte2;
		iclass.var_e7b = 100;
		iclass.var_e0b = var_f3b[paramByte1];
		iclass.var_efb = var_f43[paramByte1];
		if (paramByte1 == 9) {
			iclass.sub_124c(var_deb.var_4832[paramByte2] - 1);
			iclass.var_ef3 = var_deb.var_4862[paramByte2];
			var_deb.var_485a[paramByte2][iclass.var_ef3] = iclass;
			var_deb.var_4862[paramByte2] += 1;
		}
		return iclass;
	}

	public static final Class_a_0260 sub_11aa(byte paramByte1, byte paramByte2,
			int paramInt1, int paramInt2, boolean paramBoolean) {
		Class_a_0260 iclass;
		(iclass = new Class_a_0260(paramByte1, var_deb.var_4832[paramByte2],
				paramInt1, paramInt2, paramBoolean)).var_e2b = paramByte1;
		iclass.var_e33 = paramByte2;
		iclass.var_e7b = 100;
		iclass.var_e0b = var_f3b[paramByte1];
		iclass.var_efb = var_f43[paramByte1];
		if (paramByte1 == 9) {
			iclass.sub_124c(var_deb.var_4832[paramByte2] - 1);
		}
		return iclass;
	}

	public final void sub_1226() {
		var_deb.var_47fa.removeElement(this);
	}

	public final void sub_124c(int paramInt) {
		this.var_eeb = ((byte) paramInt);
		this.var_df3 = Class_f_0145.getLangString(paramInt + 93);
	}

	public final int sub_1278(Class_a_0260 paramClass_a_0260) {
		return sub_12a0(paramClass_a_0260, this.var_e3b, this.var_e43);
	}

	private int sub_12a0(Class_a_0260 paramClass_a_0260, int paramInt1,
			int paramInt2) {
		int i = this.var_e9b;
		if (paramClass_a_0260 != null) {
			if ((sub_26db((short) 64))
					&& (paramClass_a_0260.sub_26db((short) 1))) {
				i += 15;
			}
			if ((this.var_e2b == 4) && (paramClass_a_0260.var_e2b == 10)) {
				i += 15;
			}
		}
		if ((sub_26db((short) 2))
				&& (var_deb.sub_11671(paramInt1, paramInt2) == 5)) {
			i += 10;
		}
		if (var_deb.var_4782[paramInt1][paramInt2] == 34) {
			i += 25;
		}
		return i;
	}

	public final int sub_135c(Class_a_0260 paramClass_a_0260) {
		return sub_1383(this.var_e3b, this.var_e43);
	}

	private int sub_1383(int paramInt1, int paramInt2) {
		int i = var_deb.sub_11671(paramInt1, paramInt2);
		int j = this.var_ea3 + Class_g_1956.var_46b2[i];
		if ((sub_26db((short) 2)) && (i == 5)) {
			j += 15;
		}
		if (var_deb.var_4782[paramInt1][paramInt2] == 34) {
			j += 15;
		}
		return j;
	}

	public final int sub_13f9(Class_a_0260 paramClass_a_0260) {
		int i = Class_c_MainCanvas.getRandomWithin(this.var_e5b, this.var_e63)
				+ sub_1278(paramClass_a_0260);
		int j = paramClass_a_0260.var_e6b + paramClass_a_0260.sub_135c(this);
		if ((i = (i - j) * this.var_e7b / 100) < 0) {
			i = 0;
		} else if (i > paramClass_a_0260.var_e7b) {
			i = paramClass_a_0260.var_e7b;
		}
		paramClass_a_0260.var_e7b -= i;
		this.var_e03 += paramClass_a_0260.sub_1491() * i;
		return i;
	}

	private int sub_1491() {
		return this.var_e5b + this.var_e63 + this.var_e6b;
	}

	public final int sub_14ba() {
		return (sub_1491() * 100 << 1) / 3;
	}

	public final boolean sub_14e0() {
		int i = sub_14ba();
		if (this.var_e03 >= i) {
			this.var_e03 -= i;
			sub_fea((byte) (this.var_dfb + 1));
			return true;
		}
		return false;
	}

	public final boolean sub_1532(int paramInt1, int paramInt2) {
		return (this.var_e83 != 4)
				&& (this.var_e7b > 0)
				&& (Math.abs(this.var_e3b - paramInt1)
						+ Math.abs(this.var_e43 - paramInt2) == 1)
				&& (var_f33[this.var_e2b] == 1);
	}

	public final void sub_1595(byte paramByte) {
		this.var_e8b = ((byte) (this.var_e8b | paramByte));
		sub_160c();
		if (paramByte == 1) {
			this.var_ed3 = var_deb.var_4842;
		}
	}

	public final void sub_15e0(byte paramByte) {
		this.var_e8b = ((byte) (this.var_e8b & (paramByte ^ 0xFFFFFFFF)));
		sub_160c();
	}

	public final void sub_160c() {
		this.var_e93 = 0;
		this.var_e9b = 0;
		this.var_ea3 = 0;
		if ((this.var_e8b & 0x1) != 0) {
			this.var_e9b = ((short) (this.var_e9b - 10));
			this.var_ea3 = ((short) (this.var_ea3 - 10));
		}
		if ((this.var_e8b & 0x2) != 0) {
			this.var_e9b = ((short) (this.var_e9b + 10));
		}
	}

	public final void sub_1686(int paramInt1, int paramInt2) {
		this.var_e3b = ((short) paramInt1);
		this.var_e43 = ((short) paramInt2);
		this.var_c08 = ((short) (paramInt1 * 24));
		this.var_c10 = ((short) (paramInt2 * 24));
	}

	public final int sub_16bf() {
		int i = 100 / this.var_e0b.length;
		int j = this.var_e7b / i;
		if ((this.var_e7b != 100) && (this.var_e7b % i > 0)) {
			j++;
		}
		return j;
	}

	public final int sub_1713(int paramInt1, int paramInt2,
			Class_a_0260 paramClass_a_0260) {
		return (this.var_e5b + this.var_e63 + this.var_e6b
				+ sub_12a0(paramClass_a_0260, paramInt1, paramInt2) + sub_1383(
					paramInt1, paramInt2)) * this.var_e7b / 100;
	}

	public final void sub_1753(byte[][] paramArrayOfByte, int paramInt1,
			int paramInt2) {
		int i = var_f33[this.var_e2b];
		int j = var_f2b[this.var_e2b];
		int kInt;
		if ((kInt = paramInt1 - j) < 0) {
			kInt = 0;
		}
		int m;
		if ((m = paramInt2 - j) < 0) {
			m = 0;
		}
		int n;
		if ((n = paramInt1 + j) >= var_deb.var_46f2) {
			n = var_deb.var_46f2 - 1;
		}
		int i1;
		if ((i1 = paramInt2 + j) >= var_deb.var_46fa) {
			i1 = var_deb.var_46fa - 1;
		}
		for (int k = kInt; k <= n; k++) {
			for (int i2 = m; i2 <= i1; i2++) {
				int i3;
				if (((i3 = Math.abs(k - paramInt1) + Math.abs(i2 - paramInt2)) >= i)
						&& (i3 <= j) && (paramArrayOfByte[k][i2] <= 0)) {
					paramArrayOfByte[k][i2] = 127;
				}
			}
		}
	}

	public final void sub_18dd(byte[][] paramArrayOfByte) {
		if (sub_26db((short) 512)) {
			sub_1753(paramArrayOfByte, this.var_e3b, this.var_e43);
			return;
		}
		sub_20f8(paramArrayOfByte);
		for (int i = 0; i < var_deb.var_46f2; i++) {
			for (int j = 0; j < var_deb.var_46fa; j++) {
				if ((paramArrayOfByte[i][j] > 0)
						&& (paramArrayOfByte[i][j] != 127)) {
					sub_1753(paramArrayOfByte, i, j);
				}
			}
		}
	}

	public final Class_a_0260[] sub_19aa(int paramInt1, int paramInt2,
			byte paramByte) {
		return sub_19dc(paramInt1, paramInt2, var_f33[this.var_e2b],
				var_f2b[this.var_e2b], paramByte);
	}

	public final Class_a_0260[] sub_19dc(int paramInt1, int paramInt2,
			int paramInt3, int paramInt4, byte paramByte) {
		Vector localVector = new Vector();
		int iInt;
		if ((iInt = paramInt1 - paramInt4) < 0) {
			iInt = 0;
		}
		int j;
		if ((j = paramInt2 - paramInt4) < 0) {
			j = 0;
		}
		int k;
		if ((k = paramInt1 + paramInt4) >= var_deb.var_46f2) {
			k = var_deb.var_46f2 - 1;
		}
		int m;
		if ((m = paramInt2 + paramInt4) >= var_deb.var_46fa) {
			m = var_deb.var_46fa - 1;
		}
		for (int i = iInt; i <= k; i++) {
			for (int n = j; n <= m; n++) {
				int i1;
				if (((i1 = Math.abs(i - paramInt1) + Math.abs(n - paramInt2)) >= paramInt3)
						&& (i1 <= paramInt4)) {
					Class_a_0260 localClass_a_0260;
					if (paramByte == 0) {
						if ((localClass_a_0260 = var_deb.sub_1156a(i, n,
								(byte) 0)) != null) {
							if (var_deb.var_483a[localClass_a_0260.var_e33] != var_deb.var_483a[this.var_e33]) {
								localVector.addElement(localClass_a_0260);
							}
						} else if ((this.var_e2b == 7)
								&& (var_deb.sub_11671(i, n) == 8)
								&& (Class_g_1956
										.sub_11b75(var_deb.var_4782[i][n]))
								&& (!var_deb.sub_11c55(i, n,
										var_deb.var_483a[this.var_e33]))) {
							(localClass_a_0260 = sub_10e1((byte) 0, (byte) 0,
									i, n, false)).var_e2b = -1;
							localClass_a_0260.var_e83 = 4;
							localVector.addElement(localClass_a_0260);
						}
					} else if (paramByte == 1) {
						if ((localClass_a_0260 = var_deb.sub_1156a(i, n,
								(byte) 1)) != null) {
							localVector.addElement(localClass_a_0260);
						}
					} else if ((paramByte == 2)
							&& ((localClass_a_0260 = var_deb.sub_1156a(i, n,
									(byte) 0)) != null)
							&& (var_deb.var_483a[localClass_a_0260.var_e33] == var_deb.var_483a[this.var_e33])) {
						localVector.addElement(localClass_a_0260);
					}
				}
			}
		}
		Class_a_0260[] arrayOfClass_a_0260 = new Class_a_0260[localVector
				.size()];
		localVector.copyInto(arrayOfClass_a_0260);
		return arrayOfClass_a_0260;
	}

	public final void sub_1c9f(int paramInt1, int paramInt2,
			boolean paramBoolean) {
		sub_1cc2(paramInt1, paramInt2, paramBoolean, false);
	}

	public final void sub_1cc2(int paramInt1, int paramInt2,
			boolean paramBoolean1, boolean paramBoolean2) {
		if (paramBoolean1) {
			this.var_e13 = sub_1ef5(this.var_e3b, this.var_e43, paramInt1,
					paramInt2);
		} else {
			if ((paramBoolean2)
					&& (var_deb.sub_1156a(paramInt1, paramInt2, (byte) 0) != null)) {
				paramBoolean2 = false;
				int it;
				for (it = paramInt1 - 1; it <= paramInt1 + 1; it++) {
					for (int jt = paramInt2 - 1; jt <= paramInt2 + 1; jt++) {
						if (((it == paramInt1) && (jt == paramInt2))
								|| (((it == paramInt1) || (jt == paramInt2)) && (var_deb
										.sub_1156a(it, jt, (byte) 0) == null))) {
							paramInt1 = it;
							paramInt2 = jt;
							paramBoolean2 = true;
							break;
						}
					}
					if (paramBoolean2) {
						break;
					}
				}
			}
			this.var_e13 = new Vector();
			short[] shorts;
			shorts = new short[] { this.var_e3b, this.var_e43 };
			this.var_e13.addElement(shorts);
			short i = this.var_e3b;
			int iInt;
			if ((iInt = Math.abs(paramInt1 - this.var_e3b)) > 0) {
				int j = (paramInt1 - this.var_e3b) / iInt;
				for (int p2 = 0; p2 < iInt; p2++) {
					short i2 = (short) (i + j);
					short[] arrayOfShort1 = { i2, this.var_e43 };
					this.var_e13.addElement(arrayOfShort1);
				}
			}
			int j = this.var_e43;
			if ((iInt = Math.abs(paramInt2 - this.var_e43)) > 0) {
				int int2 = (paramInt2 - this.var_e43) / iInt;
				for (int bool1 = 0; bool1 < iInt; bool1++) {
					short j2 = (short) (j + int2);
					short[] arrayOfShort2 = { i, j2 };
					this.var_e13.addElement(arrayOfShort2);
				}
			}
		}
		this.var_e4b = paramInt1;
		this.var_e53 = paramInt2;
		this.var_e1b = 1;
		this.var_e83 = 1;
	}

	public final Vector sub_1ef5(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		Vector localVector = null;
		short[] arrayOfShort = { (short) paramInt3, (short) paramInt4 };
		if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4)) {
			(localVector = new Vector()).addElement(arrayOfShort);
		} else {
			int i = 0;
			int j = 0;
			int k = 0;
			int m = 0;
			if (paramInt4 > 0) {
				i = var_deb.var_47da[paramInt3][(paramInt4 - 1)];
			}
			if (paramInt4 < var_deb.var_46fa - 1) {
				j = var_deb.var_47da[paramInt3][(paramInt4 + 1)];
			}
			if (paramInt3 > 0) {
				k = var_deb.var_47da[(paramInt3 - 1)][paramInt4];
			}
			if (paramInt3 < var_deb.var_46f2 - 1) {
				m = var_deb.var_47da[(paramInt3 + 1)][paramInt4];
			}
			int n;
			if ((n = Math.max(Math.max(i, j), Math.max(k, m))) == i) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3,
						paramInt4 - 1);
			} else if (n == j) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3,
						paramInt4 + 1);
			} else if (n == k) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3 - 1,
						paramInt4);
			} else if (n == m) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3 + 1,
						paramInt4);
			}
			localVector.addElement(arrayOfShort);
		}
		return localVector;
	}

	public final void sub_20f8(byte[][] paramArrayOfByte) {
		sub_212e(paramArrayOfByte, this.var_e3b, this.var_e43, this.var_e73,
				-1, this.var_e2b, this.var_e33, false);
	}

	public static final boolean sub_212e(byte[][] paramArrayOfByte,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			byte paramByte1, byte paramByte2, boolean paramBoolean) {
		if (paramInt3 > paramArrayOfByte[paramInt1][paramInt2]) {
			paramArrayOfByte[paramInt1][paramInt2] = ((byte) paramInt3);
			if ((paramBoolean)
					&& (var_deb.sub_1156a(paramInt1, paramInt2, (byte) 0) == null)) {
				return true;
			}
			int i;
			if ((paramInt4 != 1)
					&& ((i = paramInt3
							- sub_22a9(paramInt1, paramInt2 - 1, paramByte1,
									paramByte2)) >= 0)
					&& (sub_212e(paramArrayOfByte, paramInt1, paramInt2 - 1, i,
							2, paramByte1, paramByte2, paramBoolean))
					&& (paramBoolean)) {
				return true;
			}
			if ((paramInt4 != 2)
					&& ((i = paramInt3
							- sub_22a9(paramInt1, paramInt2 + 1, paramByte1,
									paramByte2)) >= 0)
					&& (sub_212e(paramArrayOfByte, paramInt1, paramInt2 + 1, i,
							1, paramByte1, paramByte2, paramBoolean))
					&& (paramBoolean)) {
				return true;
			}
			if ((paramInt4 != 4)
					&& ((i = paramInt3
							- sub_22a9(paramInt1 - 1, paramInt2, paramByte1,
									paramByte2)) >= 0)
					&& (sub_212e(paramArrayOfByte, paramInt1 - 1, paramInt2, i,
							8, paramByte1, paramByte2, paramBoolean))
					&& (paramBoolean)) {
				return true;
			}
			return (paramInt4 != 8)
					&& ((i = paramInt3
							- sub_22a9(paramInt1 + 1, paramInt2, paramByte1,
									paramByte2)) >= 0)
					&& (sub_212e(paramArrayOfByte, paramInt1 + 1, paramInt2, i,
							4, paramByte1, paramByte2, paramBoolean))
					&& (paramBoolean);
		}
		return false;
	}

	private static int sub_22a9(int paramInt1, int paramInt2, byte paramByte1,
			byte paramByte2) {
		if ((paramInt1 >= 0) && (paramInt2 >= 0)
				&& (paramInt1 < var_deb.var_46f2)
				&& (paramInt2 < var_deb.var_46fa)) {
			Class_a_0260 localClass_a_0260;
			if (((localClass_a_0260 = var_deb.sub_1156a(paramInt1, paramInt2,
					(byte) 0)) != null)
					&& (var_deb.var_483a[localClass_a_0260.var_e33] != var_deb.var_483a[paramByte2])) {
				return 1000;
			}
			paramInt1 = var_deb.sub_11671(paramInt1, paramInt2);
			if (paramByte1 == 11) {
				if (paramInt1 == 4) {
					return 1000;
				}
			} else {
				if (sub_26a3(paramByte1, (short) 1)) {
					return 1;
				}
				if ((sub_26a3(paramByte1, (short) 2)) && (paramInt1 == 5)) {
					return 1;
				}
			}
			return Class_g_1956.var_46ba[paramInt1];
		}
		return 10000;
	}

	public final void sub_238a() {
		if (this.var_eab) {
			if (var_deb.var_479a - this.var_ec3 >= this.var_ebb) {
				this.var_eab = false;
			} else {
				this.var_eb3 = (!this.var_eb3);
			}
		}
		if (this.var_e83 == 1) {
			if (this.var_e1b >= this.var_e13.size()) {
				this.var_e83 = 0;
				this.var_e3b = ((short) (this.var_c08 / 24));
				this.var_e43 = ((short) (this.var_c10 / 24));
				this.var_e13 = null;
				this.var_e1b = 0;
			} else {
				if ((this.var_ee3 != null) && (this.var_c08 % 24 == 0)
						&& (this.var_c10 % 24 == 0)) {
					this.var_ee3.sub_1c9f(this.var_e3b, this.var_e43, false);
				}
				short[] arrayOfShort;
				int i = (arrayOfShort = (short[]) this.var_e13
						.elementAt(this.var_e1b))[0] * 24;
				int j = arrayOfShort[1] * 24;
				Class_g_Sprite localClass_g_2517 = null;
				if ((this.var_ee3 == null)
						&& (++this.var_edb >= 24 / var_de3 / 2)) {
					localClass_g_2517 = var_deb.sub_6c4a(var_deb.var_4a72,
							this.var_c08, this.var_c10, 0, 0, 1,
							Class_c_MainCanvas.getRandomWithin(1, 4) * 50);
					this.var_edb = 0;
				}
				if (i < this.var_c08) {
					this.var_c08 -= var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517.sub_1b36(this.var_c08 + this.spriteFrameWidth,
								this.var_c10 + this.spriteFrameHeight
										- localClass_g_2517.spriteFrameHeight);
					}
				} else if (i > this.var_c08) {
					this.var_c08 += var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517.sub_1b36(this.var_c08
								- localClass_g_2517.spriteFrameWidth, this.var_c10
								+ this.spriteFrameHeight - localClass_g_2517.spriteFrameHeight);
					}
				} else if (j < this.var_c10) {
					this.var_c10 -= var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517.sub_1b36(this.var_c08
								+ (this.spriteFrameWidth - localClass_g_2517.spriteFrameWidth)
								/ 2, this.var_c10 + this.spriteFrameHeight);
					}
				} else if (j > this.var_c10) {
					this.var_c10 += var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517.sub_1b36(this.var_c08
								+ (this.spriteFrameWidth - localClass_g_2517.spriteFrameWidth)
								/ 2, this.var_c10 - localClass_g_2517.spriteFrameHeight);
					}
				}
				if ((this.var_c08 == i) && (this.var_c10 == j)) {
					this.var_e3b = arrayOfShort[0];
					this.var_e43 = arrayOfShort[1];
					this.var_e1b = ((short) (this.var_e1b + 1));
				}
			}
			super.sub_1b36(this.var_c08, this.var_c10);
			sub_1491();
			return;
		}
		if ((this.var_e83 == 0) && (var_deb.var_479a - this.var_e23 >= 200L)) {
			sub_1491();
			this.var_e23 = var_deb.var_479a;
		}
	}

	private static boolean sub_26a3(byte paramByte, short paramShort) {
		return (var_f4b[paramByte] & paramShort) != 0;
	}

	public final boolean sub_26db(short paramShort) {
		return sub_26a3(this.var_e2b, paramShort);
	}

	public final void sub_26fe() {
		this.var_e83 = 2;
		Object localObject;
		if ((localObject = var_deb.sub_1156a(this.var_e3b, this.var_e43,
				(byte) 1)) != null) {
			((Class_a_0260) localObject).sub_1226();
		}
		if (sub_26db((short) 256)) {
			Class_a_0260[]  classes;
			classes = sub_19dc(this.var_e3b, this.var_e43, 1, 2, (byte) 2);
			for (int i = 0; i < classes.length; i++) {
				classes[i].sub_1595((byte) 2);
				var_deb.sub_6c4a(var_deb.var_474a, classes[i].var_c08,
						classes[i].var_c10, 0, 0, 1, 50);
			}
		}
		var_deb.var_4e0a = this;
	}

	public static final Class_a_0260[] sub_27b7(byte paramByte) {
		Class_a_0260[] arrayOfClass_a_02601 = new Class_a_0260[var_deb.var_4862[paramByte]];
		int i = 0;
		for (int j = 0; j < arrayOfClass_a_02601.length; j++) {
			if ((var_deb.var_485a[var_deb.var_4842][j] != null)
					&& (var_deb.var_485a[var_deb.var_4842][j].var_e83 == 3)) {
				arrayOfClass_a_02601[(i++)] = var_deb.var_485a[var_deb.var_4842][j];
			}
		}
		Class_a_0260[] arrayOfClass_a_02602 = new Class_a_0260[var_deb.var_49ca
				+ 1 + i];
		for (int k = 0; k < arrayOfClass_a_02602.length; k = (byte) (k + 1)) {
			if (k < i) {
				arrayOfClass_a_02602[k] = arrayOfClass_a_02601[k];
			} else {
				arrayOfClass_a_02602[k] = sub_10e1((byte) (k - i), paramByte,
						0, 0, false);
			}
		}
		return arrayOfClass_a_02602;
	}

	public final void sub_28d7(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		sub_28fa(paramGraphics, paramInt1, paramInt2, false);
	}

	public final void sub_28fa(Graphics paramGraphics, int paramInt1,
			int paramInt2, boolean paramBoolean) {
		if (this.var_e83 != 4) {
			int j;
			int i;
			if (this.var_eab) {
				if (this.var_eb3) {
					j = -2;
				} else {
					j = 2;
				}
				Class_c_MainCanvas.getRandomNumber();
				i = 0;
				super.sub_1d20(paramGraphics, paramInt1 + j, paramInt2 + i);
			} else if ((!paramBoolean) && (this.var_e83 != 2)) {
				super.sub_1d20(paramGraphics, paramInt1, paramInt2);
			} else {
				var_deb.var_46a2[0][this.var_e2b].sub_1d20(paramGraphics,
						this.var_c08 + paramInt1, this.var_c10 + paramInt2);
			}
			if (this.var_e2b == 9) {
				j = this.var_c08 + paramInt1;
				i = this.var_c10 + paramInt2;
				if ((paramBoolean) || (this.var_e83 == 2)) {
					var_deb.var_4afa[1].drawFrame(paramGraphics,
							(this.var_eeb << 1) + this.currentFrameIndex, j, i, 0);
					return;
				}
				var_deb.var_4afa[0].drawFrame(paramGraphics, (this.var_eeb << 1)
						+ this.currentFrameIndex, j, i, 0);
			}
		}
	}

	public final void sub_2a65(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		paramInt1 = this.var_c08 + paramInt1;
		paramInt2 = this.var_c10 + paramInt2;
		if ((this.var_e83 != 3) && (this.var_e7b < 100)) {
			Class_c_MainCanvas.sub_20c1(paramGraphics, "" + this.var_e7b, paramInt1,
					paramInt2 + this.spriteFrameHeight - 7, 0);
		}
	}

	public static final void sub_2ada(Class_g_1956 paramClass_g_1956) {
		var_deb = paramClass_g_1956;
		try {
			for (int it = 0; it < var_f0b.length; it++) {
				InputStream stream;
				stream = Class_c_MainCanvas.getResourceStream(var_f0b[it]
						+ ".unit");
				String str;
				while ((str = Class_c_MainCanvas.streamToString((InputStream) stream)) != null) {
					int kIndex;
					if ((kIndex = str.indexOf(';')) >= 0) {
						str = str.substring(0, kIndex);
					}
					if ((str = str.trim()).length() != 0) {
						String[] arrayOfString;
						if ((arrayOfString = Class_c_MainCanvas.splitStringByChar(str, ' '))[0]
								.equalsIgnoreCase("MoveRange")) {
							var_f13[it] = ((byte) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0].equalsIgnoreCase("Attack")) {
							var_f1b[it][0] = ((byte) Integer
									.parseInt(arrayOfString[1]));
							var_f1b[it][1] = ((byte) Integer
									.parseInt(arrayOfString[2]));
						} else if (arrayOfString[0].equalsIgnoreCase("Defence")) {
							var_f23[it] = ((byte) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0]
								.equalsIgnoreCase("AttackRange")) {
							var_f2b[it] = ((byte) Integer
									.parseInt(arrayOfString[1]));
							var_f33[it] = ((byte) Integer
									.parseInt(arrayOfString[2]));
						} else if (arrayOfString[0].equalsIgnoreCase("Cost")) {
							var_f43[it] = ((short) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0]
								.equalsIgnoreCase("CharCount")) {
							var_f3b[it] = new byte[Integer
									.parseInt(arrayOfString[1])][2];
						} else if (arrayOfString[0].equalsIgnoreCase("CharPos")) {
							kIndex = Integer.parseInt(arrayOfString[1]);
							var_f3b[it][kIndex][0] = ((byte) Integer
									.parseInt(arrayOfString[2]));
							var_f3b[it][kIndex][1] = ((byte) Integer
									.parseInt(arrayOfString[3]));
						} else if (arrayOfString[0]
								.equalsIgnoreCase("HasProperty")) {
							var_f4b[it] = ((short) (var_f4b[it] | 1 << Integer
									.parseInt(arrayOfString[1])));
						}
					}
				}
			}
			return;
		} catch (Exception exx) {
			try {
				int k;
				Object localObject = new DataInputStream(
						Class_c_MainCanvas.getResourceStream("units.bin"));
				for (int i = 0; i < 12; i++) {
					var_f13[i] = ((DataInputStream) localObject).readByte();
					var_f1b[i][0] = ((DataInputStream) localObject).readByte();
					var_f1b[i][1] = ((DataInputStream) localObject).readByte();
					var_f23[i] = ((DataInputStream) localObject).readByte();
					var_f2b[i] = ((DataInputStream) localObject).readByte();
					var_f33[i] = ((DataInputStream) localObject).readByte();
					var_f43[i] = ((DataInputStream) localObject).readShort();
					int j = ((DataInputStream) localObject).readByte();
					var_f3b[i] = new byte[j][2];
					for (k = 0; k < j; k++) {
						var_f3b[i][k][0] = ((DataInputStream) localObject)
								.readByte();
						var_f3b[i][k][1] = ((DataInputStream) localObject)
								.readByte();
					}
					k = ((DataInputStream) localObject).readByte();
					for (j = 0; j < k; j++) {
						var_f4b[i] = ((short) (var_f4b[i] | 1 << ((DataInputStream) localObject)
								.readByte()));
					}
				}
				((DataInputStream) localObject).close();
				return;
			} catch (Exception localException) {
				exx.printStackTrace();
				localException.printStackTrace();
			}
		}
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_a_0260
 * 
 * JD-Core Version: 0.7.0.1
 */