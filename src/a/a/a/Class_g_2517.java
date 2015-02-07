package a.a.a;

import aeii.Class_c_0282;
import aeii.Class_d_0033;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Graphics;

public class Class_g_2517 {
	
	public Class_d_0033[] var_bf0;
	private byte[] var_bf8;
	public int var_c00;
	public int var_c08; // m
	public int var_c10; // n
	public boolean var_c18;
	public int var_c20;
	public int var_c28;
	public byte[][] var_c30;
	public int var_c38;
	public byte var_c40;
	public int var_c48;
	public int var_c50;
	public int var_c58;
	public int var_c60;
	public int var_c68;
	public int var_c70;
	public boolean var_c78;
	public boolean var_c80;
	public boolean var_c88;
	public int var_c90;
	public byte var_c98;
	public boolean var_ca0;
	public int var_ca8;
	public String var_cb0;
	public int var_cb8;
	public Class_g_2517 var_cc0;
	public Class_g_2517 var_cc8;
	public int[][] var_cd0;
	public short[][] var_cd8;
	public int var_ce0;
	public byte[] var_ce8;
	public boolean[] var_cf0;

	public Class_g_2517() {
	}

	public static Connection sub_d2f(String paramString) {
		if (paramString.startsWith("file://")) {
			try {
				return sub_db4(Connector.open(paramString));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return Connector.open(paramString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Connection sub_d70(String paramString, int paramInt) {
		if (paramString.startsWith("file://")) {
			try {
				return sub_db4(Connector.open(paramString, 1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return Connector.open(paramString, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Class_c_0013 sub_db4(Connection paramConnection) {
		/*
		 * switch () { case 1: return new Class_e_0115(paramConnection); case 2:
		 * return new Class_d_0114(paramConnection); case 3: return new
		 * Class_b_0012(paramConnection); case 4: return new
		 * Class_f_0116(paramConnection); }
		 */
		return null;
	}

	public Class_g_2517(String paramString) {
		this.var_c00 = 0;
		this.var_c08 = 0;
		this.var_c10 = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.var_ce0 = 16769024;
		sub_fab(paramString, 1);
	}

	public Class_g_2517(Class_d_0033[] paramArrayOfClass_d_0033) {
		this.var_c00 = 0;
		this.var_c08 = 0;
		this.var_c10 = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.var_ce0 = 16769024;
		this.var_bf0 = paramArrayOfClass_d_0033;
		this.var_bf8 = new byte[this.var_bf0.length];
		int iInt = 0;
		while (iInt < this.var_bf0.length) {
			byte iByte = (byte) (iInt + 1);
			this.var_bf8[iInt] = iByte;
		}
		this.var_c20 = this.var_bf0[0].var_6b1;
		this.var_c28 = this.var_bf0[0].var_6b9;
	}

	public Class_g_2517(String paramString, byte paramByte) {
		this.var_c00 = 0;
		this.var_c08 = 0;
		this.var_c10 = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.var_ce0 = 16769024;
		sub_fab(paramString, paramByte);
	}

	private void sub_fab(String paramString, int paramInt) {
		try {
			int i = 0;
			int[][] arrayOfInt1 = null;
			int[][] arrayOfInt2 = null;
			int j = 0;
			InputStream localInputStream;
			int i1;
			int i2;
			int i3;
			int i4;
			int i5;
			if ((localInputStream = Class_c_0282.sub_2fb7(paramString
					+ ".sprite")) != null) {
				String str;
				while ((str = Class_c_0282.sub_1b49(localInputStream)) != null) {
					if ((i1 = str.indexOf(';')) >= 0) {
						str = str.substring(0, i1);
					}
					if ((str = str.trim()).length() != 0) {
						String[] arrayOfString;
						if ((arrayOfString = Class_c_0282.sub_1bda(str, ' '))[0]
								.equalsIgnoreCase("FrameCount")) {
							arrayOfInt1 = new int[i = (byte) Integer
									.parseInt(arrayOfString[1])][2];
							arrayOfInt2 = new int[i][2];
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameWidth")) {
							this.var_c20 = Integer.parseInt(arrayOfString[1]);
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameHeight")) {
							this.var_c28 = Integer.parseInt(arrayOfString[1]);
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameDef")) {
							i1 = Integer.parseInt(arrayOfString[1]);
							arrayOfInt1[i1][0] = Integer
									.parseInt(arrayOfString[2]);
							arrayOfInt1[i1][1] = Integer
									.parseInt(arrayOfString[3]);
						} else if (arrayOfString[0].equalsIgnoreCase("Align")) {
							j = Integer.parseInt(arrayOfString[1]);
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameSeqCount")) {
							if ((i1 = Integer.parseInt(arrayOfString[1])) > 0) {
								this.var_c30 = new byte[i1][];
							}
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameDelay")) {
							this.var_c58 = (Integer.parseInt(arrayOfString[1]) * 50);
						} else if (arrayOfString[0]
								.equalsIgnoreCase("FrameSeq")) {
							i1 = Integer.parseInt(arrayOfString[1]);
							this.var_c30[i1] = new byte[Integer
									.parseInt(arrayOfString[2])];
							for (i2 = 0; i2 < this.var_c30[i1].length; i2++) {
								this.var_c30[i1][i2] = ((byte) Integer
										.parseInt(arrayOfString[(i2 + 3)]));
							}
						} else if (arrayOfString[0]
								.equalsIgnoreCase("Translate")) {
							i1 = Integer.parseInt(arrayOfString[1]);
							arrayOfInt2[i1][0] = Integer
									.parseInt(arrayOfString[2]);
							arrayOfInt2[i1][1] = Integer
									.parseInt(arrayOfString[3]);
						}
					}
				}
			} else {
				arrayOfInt1 = new int[i = (byte) (localInputStream = Class_c_0282
						.sub_2fb7(paramString + ".sprbin")).read()][2];
				arrayOfInt2 = new int[i][2];
				this.var_c20 = ((byte) localInputStream.read());
				this.var_c28 = ((byte) localInputStream.read());
				for (i3 = 0; i3 < i; i3++) {
					arrayOfInt1[i3][0] = localInputStream.read();
					arrayOfInt1[i3][1] = localInputStream.read();
				}
				j = localInputStream.read();
				int k;
				if ((k = localInputStream.read()) > 0) {
					this.var_c30 = new byte[k][];
					this.var_c58 = (localInputStream.read() * 50);
					for (i2 = 0; i2 < k; i2++) {
						int m = localInputStream.read();
						this.var_c30[i2] = new byte[m];
						for (i1 = 0; i1 < m; i1++) {
							this.var_c30[i2][i1] = ((byte) localInputStream
									.read());
						}
					}
				}
				for (i2 = 0; i2 < i; i2++) {
					i4 = (byte) localInputStream.read();
					i5 = (byte) localInputStream.read();
					if ((i4 == -1) || (i5 == -1)) {
						break;
					}
					arrayOfInt2[i2][0] = i4;
					arrayOfInt2[i2][1] = i5;
				}
			}
			localInputStream.close();
			this.var_bf0 = new Class_d_0033[i];
			Class_d_0033[] arrayOfClass_d_0033 = new Class_d_0033[i];
			try {
				Class_d_0033 localClass_d_0033;
				i1 = (localClass_d_0033 = new Class_d_0033(paramString,
						paramInt)).var_6b1 / this.var_c20;
				i2 = localClass_d_0033.var_6b9 / this.var_c28;
				i3 = 0;
				for (i4 = 0; i4 < i2; i4++) {
					for (i5 = 0; i5 < i1; i5++) {
						arrayOfClass_d_0033[i3] = new Class_d_0033(
								localClass_d_0033, i5, i4, this.var_c20,
								this.var_c28);
						i3++;
					}
				}
			} catch (Exception localException2) {
				try {
					for (i1 = 0; i1 < i; i1++) {
						StringBuffer localStringBuffer;
						(localStringBuffer = new StringBuffer(paramString))
								.append('_');
						if (i1 < 10) {
							localStringBuffer.append('0');
						}
						localStringBuffer.append(i1);
						if (paramInt == 1) {
							arrayOfClass_d_0033[i1] = new Class_d_0033(
									localStringBuffer.toString());
						} else {
							arrayOfClass_d_0033[i1] = new Class_d_0033(
									localStringBuffer.toString(), paramInt);
						}
					}
				} catch (Exception localException3) {
				}
			}
			for (int n = 0; n < i; n++) {
				this.var_bf0[n] = new Class_d_0033(
						arrayOfClass_d_0033[arrayOfInt1[n][0]],
						arrayOfInt1[n][1]);
			}
			if (j > 0) {
				for (int n1 = 0; n1 < i; n1++) {
					this.var_bf0[n1].sub_fb5(j, this.var_c20, this.var_c28);
					this.var_bf0[n1].sub_10e6(arrayOfInt2[n1][0],
							arrayOfInt2[n1][1]);
				}
			} else {
				for (int n2 = 0; n2 < i; n2++) {
					this.var_bf0[n2].sub_10e6(arrayOfInt2[n2][0],
							arrayOfInt2[n2][1]);
				}
			}
			if (this.var_c30 != null) {
				this.var_bf8 = this.var_c30[0];
			} else {
				this.var_bf8 = new byte[this.var_bf0.length];
				int n3 = 0;
				while (n3 < this.var_bf0.length) {
					byte bb = (byte) (n3 + 1);
					this.var_bf8[n3] = bb;
				}
				return;
			}
		} catch (Exception localException4) {
			localException4.printStackTrace();
		}
	}

	public Class_g_2517(Class_g_2517 paramClass_g_2517) {
		this.var_c00 = 0;
		this.var_c08 = 0;
		this.var_c10 = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.var_ce0 = 16769024;
		this.var_bf0 = paramClass_g_2517.var_bf0;
		this.var_bf8 = paramClass_g_2517.var_bf8;
		this.var_c00 = paramClass_g_2517.var_c00;
		this.var_c08 = paramClass_g_2517.var_c08;
		this.var_c10 = paramClass_g_2517.var_c10;
		this.var_c38 = paramClass_g_2517.var_c38;
		this.var_c18 = paramClass_g_2517.var_c18;
		this.var_c20 = paramClass_g_2517.var_c20;
		this.var_c28 = paramClass_g_2517.var_c28;
		this.var_c58 = paramClass_g_2517.var_c58;
		this.var_c30 = paramClass_g_2517.var_c30;
	}

	public Class_g_2517(int paramInt1, int paramInt2) {
		this.var_c00 = 0;
		this.var_c08 = 0;
		this.var_c10 = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.var_ce0 = 16769024;
		this.var_c20 = paramInt1;
		this.var_c28 = paramInt2;
	}

	public int sub_1aba() {
		return this.var_bf8.length;
	}

	public int sub_1ada() {
		return this.var_bf0.length;
	}

	public void sub_1afa(int paramInt) {
		if (paramInt < this.var_bf8.length) {
			this.var_c00 = ((byte) paramInt);
		}
	}

	public void sub_1b36(int paramInt1, int paramInt2) {
		this.var_c08 = ((short) paramInt1);
		this.var_c10 = ((short) paramInt2);
	}

	public void sub_1b5d() {
		this.var_c00 += 1;
		if (this.var_c00 >= this.var_bf8.length) {
			this.var_c00 = 0;
		}
	}

	public void sub_1ba4(byte[] paramArrayOfByte) {
		this.var_bf8 = paramArrayOfByte;
		this.var_c00 = 0;
		this.var_c50 = 0;
	}

	public void sub_1bce(int paramInt, boolean paramBoolean) {
		if ((this.var_c30 != null) && (paramInt <= this.var_c30.length)) {
			byte[] ibyte = this.var_c30[paramInt];
			if (paramBoolean) {
				byte[] parByte = new byte[ibyte.length];
				for (int i = 0; i < parByte.length; i++) {
					parByte[i] = ((byte) (ibyte[i] + sub_1ada() / 2));
				}
				ibyte = parByte;
			}
			sub_1ba4(ibyte);
		}
	}

	public void sub_1c69(Graphics paramGraphics, int paramInt1, int paramInt2,
			int paramInt3, int paramInt4) {
		if ((this.var_c40 != 2) && (this.var_c40 != 4) && (this.var_c40 != 3)) {
			if (this.var_c18) {
				paramInt2 = this.var_c08 + paramInt2;
				paramInt3 = this.var_c10 + paramInt3;
				this.var_bf0[paramInt1].sub_1139(paramGraphics, paramInt2,
						paramInt3, paramInt4);
			}
		} else {
			sub_1d20(paramGraphics, paramInt2, paramInt3);
		}
	}

	public void sub_1cf3(Graphics paramGraphics, int paramInt1, int paramInt2,
			int paramInt3) {
		sub_1c69(paramGraphics, this.var_bf8[this.var_c00], paramInt1,
				paramInt2, paramInt3);
	}

	public void sub_1d20(Graphics paramGraphics, int paramInt1, int paramInt2) {
		int j;
		int i;
		int k;
		if ((this.var_c40 != 2) && (this.var_c40 != 4)) {
			if (this.var_c40 == 6) {
				if (this.var_c00 == 0) {
					paramGraphics.setColor(15718144);
				} else {
					paramGraphics.setColor(16777215);
				}
				if (this.var_c60 > 0) {
					j = this.var_c08 + 15;
					paramGraphics.fillArc(this.var_c08, this.var_c10 - 15, 30,
							30, 0, 360);
					paramGraphics.fillRect(j, this.var_c10 - 15,
							Class_c_0282.var_17bf - j, 30);
					return;
				}
				paramGraphics.fillArc(this.var_c08 - 30, this.var_c10 - 15, 30,
						30, 0, 360);
				paramGraphics.fillRect(0, this.var_c10 - 15, this.var_c08 - 15,
						30);
				return;
			}
			if (this.var_c40 == 3) {
				paramGraphics.setColor(0);
				if (this.var_c60 > 0) {
					paramGraphics.drawLine(this.var_c08, this.var_c10,
							this.var_c08 + 4, this.var_c10 - 2);
					return;
				}
				paramGraphics.drawLine(this.var_c08 - 4, this.var_c10 - 2,
						this.var_c08, this.var_c10);
				return;
			}
			if (this.var_c18) {
				i = this.var_c08 + paramInt1;
				j = this.var_c10 + paramInt2;
				if (this.var_cb0 != null) {
					Class_c_0282.sub_2007(paramGraphics, this.var_cb0, i, j,
							this.var_cb8, 33);
					return;
				}
				if (this.var_c90 > 0) {
					i += Class_c_0282.sub_1a08(-4, 5);
					j += Class_c_0282.sub_1a08(-1, 2);
				}
				k = this.var_bf8[this.var_c00];
				this.var_bf0[k].sub_1115(paramGraphics, i, j);
				if (this.var_cc0 != null) {
					Class_g_2517 cl;
					if ((paramInt1 = k % (sub_1ada() / 2)) == 2) {
						cl = this.var_cc8;
					} else {
						cl = this.var_cc0;
						this.var_cc0.sub_1afa(paramInt1);
					}
					cl.sub_1d20(paramGraphics, i, j);
				}
			}
		} else {
			paramGraphics.setColor(this.var_ce0);
			for (k = 0; k < 5; k++) {
				if (this.var_cf0[k] != false) {
					i = (this.var_cd0[k][0] >> 10) + paramInt1 + this.var_c08;
					j = (this.var_cd0[k][1] >> 10) + paramInt2 + this.var_c10;
					paramGraphics.fillRect(i, j, this.var_ce8[k],
							this.var_ce8[k]);
				}
			}
		}
	}

	public static Class_g_2517 sub_2009(String paramString, int paramInt1, int paramInt2, byte paramByte)
  {
    paramInt1 = Class_c_0282.sub_1e71(paramByte, paramString); //@todo WTF! @upd I addded paramByte
    paramInt2 = Class_c_0282.sub_1e99((byte)1);
    Class_g_2517 clas;
    (clas = new Class_g_2517(paramInt1, paramInt2)).var_cb8 = 1;
    clas.var_cb0 = paramString;
    clas.var_c60 = 0;
    clas.var_c70 = -4;
    clas.var_c40 = 5;
    return clas;
  }

	public static Class_g_2517 sub_2054(Class_g_2517 paramClass_g_2517,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			int paramInt5, byte paramByte) {
		if (paramClass_g_2517 != null) {
			paramClass_g_2517 = new Class_g_2517(paramClass_g_2517);
		} else {
			paramClass_g_2517 = new Class_g_2517(0, 0);
			if ((paramByte == 2) || (paramByte == 4)) {
				if (paramByte == 4) {
					paramClass_g_2517.var_ce0 = 15658751;
				}
				paramClass_g_2517.var_cd0 = new int[5][2];
				paramClass_g_2517.var_cd8 = new short[5][2];
				paramClass_g_2517.var_ce8 = new byte[5];
				paramClass_g_2517.var_cf0 = new boolean[5];
				for (int i = 0; i < 5; i++) {
					paramClass_g_2517.var_cf0[i] = true;
					if (paramByte == 4) {
						paramClass_g_2517.var_cd8[i][0] = ((short) (Class_c_0282.var_17f7
								.nextInt() % 4 << 10));
						paramClass_g_2517.var_cd8[i][1] = ((short) (Class_c_0282.var_17f7
								.nextInt() % 4 << 10));
					} else {
						paramClass_g_2517.var_cd8[i][0] = ((short) (Math
								.abs(Class_c_0282.var_17f7.nextInt()) % 8192 + -4096));
						paramClass_g_2517.var_cd8[i][1] = ((short) (Math
								.abs(Class_c_0282.var_17f7.nextInt()) % 4096 + -2048));
					}
					paramClass_g_2517.var_ce8[i] = ((byte) (Math
							.abs(Class_c_0282.var_17f7.nextInt()) % 2 + 1));
				}
			}
		}
		paramClass_g_2517.var_c40 = paramByte;
		paramClass_g_2517.var_c48 = paramInt4;
		paramClass_g_2517.var_c58 = paramInt5;
		paramClass_g_2517.var_c60 = paramInt1;
		paramClass_g_2517.var_c68 = paramInt2;
		paramClass_g_2517.var_c70 = paramInt3;
		paramClass_g_2517.var_c80 = true;
		return paramClass_g_2517;
	}

	public void sub_21f3() {
		if (this.var_c78) {
			this.var_c50 += 50;
			if (this.var_c90 >= 0) {
				this.var_c90 -= 1;
			}
			switch (this.var_c40) {
			case 2:
			case 4:
				sub_23d5();
				return;
			case 3:
				sub_1b36(this.var_c08 + this.var_c60, this.var_c10
						+ this.var_c68);
				return;
			case 5:
				if (this.var_c48 == -1) {
					sub_1b36(this.var_c08 + this.var_c60, this.var_c10);
					this.var_c38 += this.var_c70;
					if (this.var_c38 < 0) {
						this.var_c70 += 1;
						return;
					}
					this.var_c38 = 0;
					this.var_c70 = (-this.var_c70 / 2);
					if (this.var_c70 == 0) {
						this.var_c48 = 1;
						this.var_c50 = 0;
					}
				} else if (this.var_c50 >= 400) {
					this.var_c78 = false;
					return;
				}
				break;
			case 6:
				this.var_c00 = ((this.var_c00 + 1) % 2);
				if (this.var_c50 >= this.var_c58) {
					this.var_c78 = false;
					return;
				}
				break;
			default:
				sub_1b36(this.var_c08 + this.var_c60, this.var_c10
						+ this.var_c68);
				this.var_c38 += this.var_c70;
				if ((this.var_c48 != 0) && (this.var_c50 >= this.var_c58)) {
					sub_1b5d();
					if ((this.var_c40 == 0) && (this.var_c00 == 0)
							&& (this.var_c48 > 0)) {
						this.var_c48 -= 1;
						if (this.var_c48 <= 0) {
							sub_1afa(sub_1aba() - 1);
							if (this.var_c80) {
								this.var_c78 = false;
							}
						}
					}
					this.var_c50 = 0;
				}
				break;
			}
		}
	}

	public void sub_23d5() {
		if (this.var_c40 != 4) {
			this.var_ce0 += -263168;
		}
		for (int i = 0; i < 5; i++) {
			if (this.var_cf0[i] != false) {
				if (this.var_c40 == 4) {
					this.var_cd0[i][0] += this.var_cd8[i][0];
					this.var_cd0[i][1] += this.var_cd8[i][1];
					if (this.var_cd8[i][0] < 0) {
						this.var_cd8[i][0] = ((short) (this.var_cd8[i][0] + 256));
					} else if (this.var_cd8[i][0] > 0) {
						this.var_cd8[i][0] = ((short) (this.var_cd8[i][0] - 256));
					}
					if (this.var_cd8[i][1] < 0) {
						this.var_cd8[i][1] = ((short) (this.var_cd8[i][1] + 256));
					} else if (this.var_cd8[i][1] > 0) {
						this.var_cd8[i][1] = ((short) (this.var_cd8[i][1] - 256));
					}
				} else {
					this.var_cd0[i][0] += this.var_cd8[i][0];
					this.var_cd0[i][1] += this.var_cd8[i][1];
					this.var_cd8[i][1] = ((short) (this.var_cd8[i][1] + 256));
				}
			}
		}
		if (this.var_c50 >= this.var_c58) {
			this.var_c78 = false;
		}
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.a.Class_g_2517
 * 
 * JD-Core Version: 0.7.0.1
 */