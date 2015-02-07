package aeii;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_d_0033 {
	public Image var_691;
	private boolean var_699;
	private int var_6a1;
	private int var_6a9;
	public int var_6b1;
	public int var_6b9;
	private int var_6c1;
	private int var_6c9;
	public int var_6d1;

	public Class_d_0033() {
	}

	public static Image sub_710(Image paramImage, int paramInt1, int paramInt2,
			boolean paramBoolean) {
		if (paramImage == null) {
			return null;
		}
		try {
			int width = paramImage.getWidth();
			int i = paramImage.getHeight();
			if ((width == paramInt1) && (i == paramInt2)) {
				return paramImage;
			}
			if (paramInt1 < 0) {
				if (paramInt2 < 0) {
					return paramImage;
				}
				paramInt1 = width * paramInt2 / i;
			} else if (paramInt2 < 0) {
				paramInt2 = i * paramInt1 / width;
			}
			int bool1 = 1;
			int bool2;
			int bool3;
			int bool4;
			int bool5;
			int[] arrayOfInt1;
			int[] arrayOfInt2;
			do {
				bool2 = width / bool1;
				bool3 = i / bool1;
				bool4 = paramInt1 / bool1;
				bool5 = paramInt2 / bool1;
				try {
					arrayOfInt1 = new int[bool2 * bool3];
					arrayOfInt2 = new int[bool4 * bool5];
				} catch (OutOfMemoryError localOutOfMemoryError) {
					arrayOfInt1 = null;
					arrayOfInt2 = null;
					bool1++;
				}
			} while ((arrayOfInt1 == null) || (arrayOfInt2 == null));
			if (bool1 == 1) {
				paramImage.getRGB(arrayOfInt1, 0, width, 0, 0, width, i);
				sub_97e(arrayOfInt1, arrayOfInt2, width, i, paramInt1,
						paramInt2, true);
				return Image.createRGBImage(arrayOfInt2, paramInt1, paramInt2,
						true);
			}
			Image image;
			Graphics gr = (image = Image.createImage(paramInt1, paramInt2))
					.getGraphics();
			for (int j = 0; j < bool1; j++) {
				for (i = 0; i < bool1; i++) {
					paramImage.getRGB(arrayOfInt1, 0, bool2, j * bool2, i
							* bool3, bool2, bool3);
					sub_97e(arrayOfInt1, arrayOfInt2, bool2, bool3, bool4,
							bool5, false);
					gr.drawRGB(arrayOfInt2, 0, bool4, j * bool4, i * bool5,
							bool4, bool5, false);
				}
			}
			return image;
		} catch (Throwable localThrowable) {
		}
		return paramImage;
	}

	private static void sub_97e(int[] paramArrayOfInt1, int[] paramArrayOfInt2,
			int paramInt1, int paramInt2, int paramInt3, int paramInt4,
			boolean paramBoolean) {
		int bool = (paramInt1 << 16) / paramInt3;
		int i8 = (paramInt2 << 16) / paramInt4;
		paramInt2 = bool >>> 1;
		int i = i8 >>> 16;
		if (paramInt2 == 0) {
			paramInt2 = 1;
		}
		if (i == 0) {
			i = 1;
		}
		int j = paramInt2 * i;
		try {
			int k;
			int m;
			int n;
			int i6;
			int i5;
			int i4;
			int i1;
			int i2;
			int i7;
			if (paramBoolean) {
				for (int it = 0; it < paramInt3; it++) {
					for (k = 0; k < paramInt4; k++) {
						m = it * bool >>> 16;
						n = k * i8 >>> 16;
						int i3 = i4 = i5 = i6 = 0;
						for (i1 = 0; i1 < paramInt2; i1++) {
							for (i2 = 0; i2 < i; i2++) {
								i7 = m + i1 + (n + i2) * paramInt1;
								i3 += (paramArrayOfInt1[i7] >>> 24);
								i4 += (paramArrayOfInt1[i7] >> 16 & 0xFF);
								i5 += (paramArrayOfInt1[i7] >> 8 & 0xFF);
								i6 += (paramArrayOfInt1[i7] & 0xFF);
							}
						}
						i3 /= j;
						i4 /= j;
						i5 /= j;
						i6 /= j;
						paramArrayOfInt2[(it + k * paramInt3)] = (i3 << 24
								| i4 << 16 | i5 << 8 | i6);
					}
				}
			}
			for (int it = 0; it < paramInt3; it++) {
				for (k = 0; k < paramInt4; k++) {
					m = it * bool >>> 16;
					n = k * i8 >>> 16;
					i4 = i5 = i6 = 0;
					for (i1 = 0; i1 < paramInt2; i1++) {
						for (i2 = 0; i2 < i; i2++) {
							i7 = m + i1 + (n + i2) * paramInt1;
							i4 += (paramArrayOfInt1[i7] >> 16 & 0xFF);
							i5 += (paramArrayOfInt1[i7] >> 8 & 0xFF);
							i6 += (paramArrayOfInt1[i7] & 0xFF);
						}
					}
					i4 /= j;
					i5 /= j;
					i6 /= j;
					paramArrayOfInt2[(it + k * paramInt3)] = (i4 << 16
							| i5 << 8 | i6);
				}
			}
			return;
		} catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
		}
	}

	public Class_d_0033(Class_d_0033 paramClass_d_0033, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		this.var_699 = false;
		this.var_6d1 = 0;
		this.var_691 = paramClass_d_0033.var_691;
		this.var_6b1 = paramInt3;
		this.var_6b9 = paramInt4;
		this.var_6a1 = (paramInt1 * paramInt3 + paramClass_d_0033.var_6a1);
		this.var_6a9 = (paramInt2 * paramInt4 + paramClass_d_0033.var_6a9);
		this.var_699 = true;
	}

	public Class_d_0033(Class_d_0033 paramClass_d_0033, int paramInt) {
		this.var_699 = false;
		this.var_6d1 = 0;
		this.var_691 = paramClass_d_0033.var_691;
		this.var_6b1 = paramClass_d_0033.var_6b1;
		this.var_6b9 = paramClass_d_0033.var_6b9;
		this.var_6a1 = paramClass_d_0033.var_6a1;
		this.var_6a9 = paramClass_d_0033.var_6a9;
		this.var_6c1 = paramClass_d_0033.var_6c1;
		this.var_6c9 = paramClass_d_0033.var_6c9;
		this.var_699 = paramClass_d_0033.var_699;
		if ((paramInt & 0x1) != 0) {
			this.var_6d1 = 2;
			return;
		}
		if ((paramInt & 0x2) != 0) {
			this.var_6d1 = 1;
			return;
		}
		if ((paramInt & 0x4) != 0) {
			this.var_6d1 = 6;
			return;
		}
		if ((paramInt & 0x8) != 0) {
			this.var_6d1 = 3;
			return;
		}
		if ((paramInt & 0x10) != 0) {
			this.var_6d1 = 5;
		}
	}

	public Class_d_0033(String id, int paramInt1, int paramInt2) {
		this.var_699 = false;
		this.var_6d1 = 0;
		byte[] bytes = Class_c_0282.sub_2ebf(id + ".png");
		this.var_691 = sub_710(Image.createImage(bytes, 0, bytes.length),
				paramInt1, -1, true);
		this.var_6b1 = ((short) this.var_691.getWidth());
		this.var_6b9 = ((short) this.var_691.getHeight());
		this.var_699 = false;
	}

	public Class_d_0033(String paramString) {
		this(paramString, -1, -1);
	}

	public void sub_fb5(int paramInt1, int paramInt2, int paramInt3) {
		if (!this.var_699) {
			int i = paramInt1 & 0xD;
			paramInt1 &= 0x32;
			if (this.var_6d1 == 2) {
				if ((i & 0x4) != 0) {
					i = 8;
				} else if ((i & 0x8) != 0) {
					i = 4;
				}
			} else if (this.var_6d1 == 1) {
				if ((paramInt1 & 0x10) != 0) {
					i = 32;
				} else if ((i & 0x20) != 0) {
					i = 16;
				}
			}
			if (((paramInt1 = i | paramInt1) & 0x8) != 0) {
				this.var_6c1 = (paramInt2 - this.var_6b1);
			} else if ((paramInt1 & 0x1) != 0) {
				this.var_6c1 = (paramInt2 - this.var_6b1 >> 1);
			}
			if ((paramInt1 & 0x20) != 0) {
				this.var_6c9 = (paramInt3 - this.var_6b9);
				return;
			}
			if ((paramInt1 & 0x2) != 0) {
				this.var_6c9 = (paramInt3 - this.var_6b9 >> 1);
			}
		}
	}

	public void sub_10e6(int paramInt1, int paramInt2) {
		this.var_6c1 += paramInt1;
		this.var_6c9 += paramInt2;
	}

	public void sub_1115(Graphics paramGraphics, int paramInt1, int paramInt2) {
		sub_1139(paramGraphics, paramInt1, paramInt2, 20);
	}

	public void sub_1139(Graphics paramGraphics, int paramInt1, int paramInt2,
			int paramInt3) {
		if ((!this.var_699) && (this.var_6d1 == 0)) {
			paramGraphics.drawImage(this.var_691, paramInt1 + this.var_6c1,
					paramInt2 + this.var_6c9, paramInt3);
			return;
		}
		paramGraphics.drawRegion(this.var_691, this.var_6a1, this.var_6a9,
				this.var_6b1, this.var_6b9, this.var_6d1, paramInt1
						+ this.var_6c1, paramInt2 + this.var_6c9, paramInt3);
	}

	public Image sub_11ba() {
		return Image.createImage(this.var_691, this.var_6a1, this.var_6a9,
				this.var_6b1, this.var_6b9, this.var_6d1);
	}

	public Class_d_0033(String paramString, int paramInt) {
		this.var_699 = false;
		this.var_6d1 = 0;
		byte[] arrayOfByte = null;
		if (paramInt != 1) {
			arrayOfByte = Class_c_0282.sub_2ebf(Class_g_1956.var_4682[paramInt]
					+ "_" + paramString + ".png");
		}
		if (arrayOfByte == null) {
			arrayOfByte = Class_c_0282.sub_2ebf(paramString + ".png");
		}
		this.var_691 = Image.createImage(arrayOfByte, 0, arrayOfByte.length);
		this.var_6b1 = ((short) this.var_691.getWidth());
		this.var_6b9 = ((short) this.var_691.getHeight());
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_d_0033
 * 
 * JD-Core Version: 0.7.0.1
 */