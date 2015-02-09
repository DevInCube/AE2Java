package aeii;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class Class_d_ImageWrap {

	public Image anImage;
	private boolean var_699;
	private int var_6a1;
	private int var_6a9;
	public int imageWidth;
	public int imageHeight;
	private int var_6c1;
	private int var_6c9;
	public int var_6d1;

	public Class_d_ImageWrap() {
		//
	}

	public Class_d_ImageWrap(
			Class_d_ImageWrap other,
			int paramInt1,
			int paramInt2,
			int inWidth,
			int inHeight) {
		this.var_699 = false;
		this.var_6d1 = 0;
		this.anImage = other.anImage;
		this.imageWidth = inWidth;
		this.imageHeight = inHeight;
		this.var_6a1 = (paramInt1 * inWidth + other.var_6a1);
		this.var_6a9 = (paramInt2 * inHeight + other.var_6a9);
		this.var_699 = true;
	}

	public Class_d_ImageWrap(Class_d_ImageWrap other, int paramInt) {
		this.var_699 = false;
		this.var_6d1 = 0;
		this.anImage = other.anImage;
		this.imageWidth = other.imageWidth;
		this.imageHeight = other.imageHeight;
		this.var_6a1 = other.var_6a1;
		this.var_6a9 = other.var_6a9;
		this.var_6c1 = other.var_6c1;
		this.var_6c9 = other.var_6c9;
		this.var_699 = other.var_699;
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

	public Class_d_ImageWrap(String imageId, int width, int paramInt2) {
		this.var_699 = false;
		this.var_6d1 = 0;
		byte[] bytes = Class_c_MainCanvas.getResourceString(imageId + ".png");
		this.anImage = resizeImageMaybe(Image.createImage(bytes, 0, bytes.length), width, -1, true);
		this.imageWidth = ((short) this.anImage.getWidth());
		this.imageHeight = ((short) this.anImage.getHeight());
		this.var_699 = false;
	}

	public Class_d_ImageWrap(String id) {
		this(id, -1, -1);
	}

	public Class_d_ImageWrap(String imageID, int argInt) {
		this.var_699 = false;
		this.var_6d1 = 0;
		byte[] bytes = null;
		if (argInt != 1) {
			bytes = Class_c_MainCanvas
					.getResourceString(Class_g_1956.spriteColorsMaybe[argInt] + "_" + imageID + ".png");
		}
		if (bytes == null) {
			bytes = Class_c_MainCanvas.getResourceString(imageID + ".png");
		}
		this.anImage = Image.createImage(bytes, 0, bytes.length);
		this.imageWidth = ((short) this.anImage.getWidth());
		this.imageHeight = ((short) this.anImage.getHeight());
	}

	public void align(int alignVal, int argWidth, int argHeight) {
		if (!this.var_699) {
			int i = alignVal & 0xD;
			alignVal &= 0x32;
			if (this.var_6d1 == 2) {
				if ((i & 0x4) != 0) {
					i = 8;
				} else if ((i & 0x8) != 0) {
					i = 4;
				}
			} else if (this.var_6d1 == 1) {
				if ((alignVal & 0x10) != 0) {
					i = 32;
				} else if ((i & 0x20) != 0) {
					i = 16;
				}
			}
			if (((alignVal = i | alignVal) & 0x8) != 0) {
				this.var_6c1 = (argWidth - this.imageWidth);
			} else if ((alignVal & 0x1) != 0) {
				this.var_6c1 = (argWidth - this.imageWidth >> 1);
			}
			if ((alignVal & 0x20) != 0) {
				this.var_6c9 = (argHeight - this.imageHeight);
				return;
			}
			if ((alignVal & 0x2) != 0) {
				this.var_6c9 = (argHeight - this.imageHeight >> 1);
			}
		}
	}

	public void translate(int paramInt1, int paramInt2) {
		this.var_6c1 += paramInt1;
		this.var_6c9 += paramInt2;
	}

	public void drawOnGraphics(Graphics paramGraphics, int pX, int pY) {
		drawOnGraphics(paramGraphics, pX, pY, 20);
	}

	public void drawOnGraphics(Graphics paramGraphics, int pX, int pY, int paramInt3) {
		if ((!this.var_699) && (this.var_6d1 == 0)) {
			paramGraphics
					.drawImage(this.anImage, pX + this.var_6c1, pY + this.var_6c9, paramInt3);
			return;
		}
		paramGraphics
				.drawRegion(this.anImage, this.var_6a1, this.var_6a9, this.imageWidth, this.imageHeight, this.var_6d1, pX + this.var_6c1, pY + this.var_6c9, paramInt3);
	}

	public Image createAnImage() {
		return Image
				.createImage(this.anImage, this.var_6a1, this.var_6a9, this.imageWidth, this.imageHeight, this.var_6d1);
	}
	
	
	/*Static*/
	
	public static Image resizeImageMaybe(Image inImage, int newWidth, int newHeight, boolean paramBoolean) {
		if (inImage == null) {
			return null;
		}
		try {
			int imageWidth = inImage.getWidth();
			int imageHeight = inImage.getHeight();
			if ((imageWidth == newWidth) && (imageHeight == newHeight)) {
				return inImage;
			}
			if (newWidth < 0) {
				if (newHeight < 0) {
					return inImage;
				}
				newWidth = imageWidth * newHeight / imageHeight;
			} else if (newHeight < 0) {
				newHeight = imageHeight * newWidth / imageWidth;
			}
			int divKoef = 1;
			int imDivWidth;
			int imDivHeight;
			int newDivWidth;
			int newDivHeight;
			int[] imgByteArray;
			int[] newByteArray;
			do {
				imDivWidth = imageWidth / divKoef;
				imDivHeight = imageHeight / divKoef;
				newDivWidth = newWidth / divKoef;
				newDivHeight = newHeight / divKoef;
				try {
					imgByteArray = new int[imDivWidth * imDivHeight];
					newByteArray = new int[newDivWidth * newDivHeight];
				} catch (OutOfMemoryError memEx) {
					imgByteArray = null;
					newByteArray = null;
					divKoef++;
				}
			} while ((imgByteArray == null) || (newByteArray == null));
			if (divKoef == 1) {
				inImage.getRGB(imgByteArray, 0, imageWidth, 0, 0, imageWidth, imageHeight);
				sub_97e(imgByteArray, newByteArray, imageWidth, imageHeight, newWidth, newHeight, true);
				return Image
						.createRGBImage(newByteArray, newWidth, newHeight, true);
			}
			Image image;
			Graphics gr = (image = Image.createImage(newWidth, newHeight))
					.getGraphics();
			for (int j = 0; j < divKoef; j++) {
				for (int i = 0; i < divKoef; i++) {
					inImage.getRGB(imgByteArray, 0, imDivWidth, j * imDivWidth, i * imDivHeight, imDivWidth, imDivHeight);
					sub_97e(imgByteArray, newByteArray, imDivWidth, imDivHeight, newDivWidth, newDivHeight, false);
					gr.drawRGB(newByteArray, 0, newDivWidth, j * newDivWidth, i * newDivHeight, newDivWidth, newDivHeight, false);
				}
			}
			return image;
		} catch (Throwable ex) {
			//
		}
		return inImage;
	}

	private static void sub_97e(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
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
						paramArrayOfInt2[(it + k * paramInt3)] = (i3 << 24 | i4 << 16 | i5 << 8 | i6);
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
					paramArrayOfInt2[(it + k * paramInt3)] = (i4 << 16 | i5 << 8 | i6);
				}
			}
			return;
		} catch (ArrayIndexOutOfBoundsException ex) {
			//
		}
	}

}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_d_0033
 * 
 * JD-Core Version: 0.7.0.1
 */