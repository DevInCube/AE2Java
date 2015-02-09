package a.a.a;

import aeii.Class_c_MainCanvas;
import aeii.Class_d_ImageWrap;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.io.Connection;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Graphics;

public class Class_g_Sprite {

	public Class_d_ImageWrap[] frameImages;
	private byte[] currentFrameSequence;
	public int currentFrameIndex;
	public int pixelX; // m
	public int pixelY; // n
	public boolean var_c18;
	public int spriteFrameWidth; //o
	public int spriteFrameHeight; //p
	public byte[][] frameSequenceArr2;
	public int var_c38;
	public byte var_c40;
	public int var_c48;
	public int var_c50;
	public int frameDelay;
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
	public Class_g_Sprite var_cc0;
	public Class_g_Sprite var_cc8;
	public int[][] var_cd0;
	public short[][] var_cd8;
	public int someColorInt;
	public byte[] var_ce8;
	public boolean[] var_cf0;

	public Class_g_Sprite() {
		this.currentFrameIndex = 0;
		this.pixelX = 0;
		this.pixelY = 0;
		this.var_c18 = true;
		this.var_c40 = 0;
		this.var_c48 = -1;
		this.var_c78 = true;
		this.var_c90 = -1;
		this.var_c98 = -1;
		this.someColorInt = 16769024;  // #FFE000 - yellow
	}

	public Class_g_Sprite(String spriteId) {
		this();
		initializeFromFile(spriteId, 1);
	}
	
	public Class_g_Sprite(int frameWidth, int frameHeight) {
		this();
		this.spriteFrameWidth = frameWidth;
		this.spriteFrameHeight = frameHeight;
	}
	
	public Class_g_Sprite(Class_g_Sprite sprite) {
		this();
		this.frameImages = sprite.frameImages;
		this.currentFrameSequence = sprite.currentFrameSequence;
		this.currentFrameIndex = sprite.currentFrameIndex;
		this.pixelX = sprite.pixelX;
		this.pixelY = sprite.pixelY;
		this.var_c38 = sprite.var_c38;
		this.var_c18 = sprite.var_c18;
		this.spriteFrameWidth = sprite.spriteFrameWidth;
		this.spriteFrameHeight = sprite.spriteFrameHeight;
		this.frameDelay = sprite.frameDelay;
		this.frameSequenceArr2 = sprite.frameSequenceArr2;
	}

	public Class_g_Sprite(Class_d_ImageWrap[] inImages) {
		this();
		this.frameImages = inImages;
		this.currentFrameSequence = new byte[this.frameImages.length];
		int frameInd = 0;
		while (frameInd < this.frameImages.length) {
			byte iByte = (byte) (frameInd + 1);
			this.currentFrameSequence[frameInd] = iByte;
		}
		this.spriteFrameWidth = this.frameImages[0].imageWidth;
		this.spriteFrameHeight = this.frameImages[0].imageHeight;
	}

	public Class_g_Sprite(String paramString, byte paramByte) {
		this();
		initializeFromFile(paramString, paramByte);
	}

	private void initializeFromFile(String spriteID, int inArgInt) {
		try {
			int[][] frameDefArr = null;
			int[][] translateArr = null;
			int framesCount = 0;
			int alignVal = 0;
			InputStream spriteStream = Class_c_MainCanvas
					.getResourceStream(spriteID + ".sprite");
			if (spriteStream != null) {
				String spriteString = Class_c_MainCanvas
						.streamToString(spriteStream);
				while (spriteString != null) {
					int endLineIndex = spriteString.indexOf(';');
					if (endLineIndex >= 0) {
						spriteString = spriteString.substring(0, endLineIndex);
					}
					if ((spriteString = spriteString.trim()).length() != 0) {
						String[] tokens = Class_c_MainCanvas
								.splitStringByChar(spriteString, ' ');
						if (tokens[0].equalsIgnoreCase("FrameCount")) {
							framesCount = (byte) Integer.parseInt(tokens[1]);
							frameDefArr = new int[framesCount][2];
							translateArr = new int[framesCount][2];
						} else if (tokens[0]
								.equalsIgnoreCase("FrameWidth")) {
							this.spriteFrameWidth = Integer.parseInt(tokens[1]);
						} else if (tokens[0]
								.equalsIgnoreCase("FrameHeight")) {
							this.spriteFrameHeight = Integer.parseInt(tokens[1]);
						} else if (tokens[0]
								.equalsIgnoreCase("FrameDef")) {
							int value1 = Integer.parseInt(tokens[1]);
							int value2 = Integer.parseInt(tokens[2]);
							int value3 = Integer.parseInt(tokens[3]);
							frameDefArr[value1][0] = value2;
							frameDefArr[value1][1] = value3;
						} else if (tokens[0].equalsIgnoreCase("Align")) {
							alignVal = Integer.parseInt(tokens[1]);
						} else if (tokens[0]
								.equalsIgnoreCase("FrameSeqCount")) {
							int frameSeqCount = Integer.parseInt(tokens[1]);
							if (frameSeqCount > 0) {
								this.frameSequenceArr2 = new byte[frameSeqCount][];
							}
						} else if (tokens[0]
								.equalsIgnoreCase("FrameDelay")) {
							this.frameDelay = (Integer.parseInt(tokens[1]) * 50);
						} else if (tokens[0]
								.equalsIgnoreCase("FrameSeq")) {
							int seqIndex = Integer.parseInt(tokens[1]);
							int seqLength = Integer.parseInt(tokens[2]);
							this.frameSequenceArr2[seqIndex] = new byte[seqLength];
							for (int it = 0; it < this.frameSequenceArr2[seqIndex].length; it++) {
								byte seqVal = (byte) Integer.parseInt(tokens[(it + 3)]);
								this.frameSequenceArr2[seqIndex][it] = seqVal;
							}
						} else if (tokens[0]
								.equalsIgnoreCase("Translate")) {
							int val = Integer.parseInt(tokens[1]);
							int val2 = Integer.parseInt(tokens[2]);
							int val3 = Integer.parseInt(tokens[3]);
							translateArr[val][0] = val2;
							translateArr[val][1] = val3;
						}
					}
				}
			} else {
				framesCount = (byte) (spriteStream = Class_c_MainCanvas
						.getResourceStream(spriteID + ".sprbin")).read();
				frameDefArr = new int[framesCount][2];
				translateArr = new int[framesCount][2];
				this.spriteFrameWidth = ((byte) spriteStream.read());
				this.spriteFrameHeight = ((byte) spriteStream.read());
				for (int it = 0; it < framesCount; it++) {
					frameDefArr[it][0] = spriteStream.read();
					frameDefArr[it][1] = spriteStream.read();
				}
				alignVal = spriteStream.read();
				int k = spriteStream.read();
				if (k > 0) {
					this.frameSequenceArr2 = new byte[k][];
					this.frameDelay = (spriteStream.read() * 50);
					for (int it = 0; it < k; it++) {
						int m = spriteStream.read();
						this.frameSequenceArr2[it] = new byte[m];
						for (int it2 = 0; it2 < m; it2++) {
							this.frameSequenceArr2[it][it2] = ((byte) spriteStream.read());
						}
					}
				}
				for (int it = 0; it < framesCount; it++) {
					byte i41 = (byte) spriteStream.read();
					byte i51 = (byte) spriteStream.read();
					if ((i41 == -1) || (i51 == -1)) {
						break;
					}
					translateArr[it][0] = i41;
					translateArr[it][1] = i51;
				}
			}
			spriteStream.close();
			this.frameImages = new Class_d_ImageWrap[framesCount]; 
			Class_d_ImageWrap[] images = new Class_d_ImageWrap[framesCount];
			try {
				Class_d_ImageWrap image = new Class_d_ImageWrap(spriteID, inArgInt);
				int widthKoef = image.imageWidth / this.spriteFrameWidth;
				int heightKoef = image.imageHeight / this.spriteFrameHeight;
				int i3 = 0;
				for (int it = 0; it < heightKoef; it++) {
					for (int it2 = 0; it2 < widthKoef; it2++) {
						images[i3] = new Class_d_ImageWrap(image, it2, it, this.spriteFrameWidth, this.spriteFrameHeight);
						i3++;
					}
				}
			} catch (Exception ex) {
				try {
					for (int frameIndex = 0; frameIndex < framesCount; frameIndex++) {
						StringBuffer buf = new StringBuffer(spriteID);
						buf.append('_');
						if (frameIndex < 10) {
							buf.append('0');
						}
						buf.append(frameIndex);
						if (inArgInt == 1) {
							images[frameIndex] = new Class_d_ImageWrap(buf
									.toString());
						} else {
							images[frameIndex] = new Class_d_ImageWrap(buf
									.toString(), inArgInt);
						}
					}
				} catch (Exception ex3) {
					//
				}
			}
			for (int n = 0; n < framesCount; n++) {
				this.frameImages[n] = new Class_d_ImageWrap(images[frameDefArr[n][0]], frameDefArr[n][1]);
			}
			if (alignVal > 0) {
				for (int it = 0; it < framesCount; it++) {
					this.frameImages[it].align(alignVal, this.spriteFrameWidth, this.spriteFrameHeight);
					this.frameImages[it].translate(translateArr[it][0], translateArr[it][1]);
				}
			} else {
				for (int it = 0; it < framesCount; it++) {
					this.frameImages[it].translate(translateArr[it][0], translateArr[it][1]);
				}
			}
			if (this.frameSequenceArr2 != null) {
				this.currentFrameSequence = this.frameSequenceArr2[0];
			} else {
				this.currentFrameSequence = new byte[this.frameImages.length];
				int it = 0;
				while (it < this.frameImages.length) {
					byte frameSeqIndex = (byte) (it + 1);
					this.currentFrameSequence[it] = frameSeqIndex;
				}
				return;
			}
		} catch (Exception ex4) {
			ex4.printStackTrace();
		}
	}

	public int getFramesCount() {
		return this.currentFrameSequence.length;
	}

	public int getImagesCount() {
		return this.frameImages.length;
	}

	public void setCurrentFrameIndex(int val) {
		if (val < this.currentFrameSequence.length) {
			this.currentFrameIndex = ((byte) val);
		}
	}

	public void setPixelPosition(int pixX, int pixY) {
		this.pixelX = ((short) pixX);
		this.pixelY = ((short) pixY);
	}

	public void nextFrame() {
		this.currentFrameIndex += 1;
		if (this.currentFrameIndex >= this.currentFrameSequence.length) {
			this.currentFrameIndex = 0;
		}
	}

	public void setFrameSequence(byte[] frameIndexes) {
		this.currentFrameSequence = frameIndexes;
		this.currentFrameIndex = 0;
		this.var_c50 = 0;
	}

	public void setFrameSequenceByIndex(int seqIndex, boolean inBoolArg) {
		if ((this.frameSequenceArr2 != null) && (seqIndex <= this.frameSequenceArr2.length)) {
			byte[] seq = this.frameSequenceArr2[seqIndex];
			if (inBoolArg) {
				byte[] parByte = new byte[seq.length];
				for (int i = 0; i < parByte.length; i++) {
					parByte[i] = ((byte) (seq[i] + getImagesCount() / 2));
				}
				seq = parByte;
			}
			setFrameSequence(seq);
		}
	}

	public void drawFrame(Graphics paramGraphics, int imageIndex, int inX, int inY, int paramInt4) {
		if ((this.var_c40 != 2) && (this.var_c40 != 4) && (this.var_c40 != 3)) {
			if (this.var_c18) {
				inX = this.pixelX + inX;
				inY = this.pixelY + inY;
				this.frameImages[imageIndex]
						.drawOnGraphics(paramGraphics, inX, inY, paramInt4);
			}
		} else {
			sub_1d20(paramGraphics, inX, inY);
		}
	}

	public void drawCurrentFrame(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3) {
		int imageIndex = this.currentFrameSequence[this.currentFrameIndex];
		drawFrame(paramGraphics, imageIndex, paramInt1, paramInt2, paramInt3);
	}

	public void sub_1d20(Graphics graphics, int inX, int inY) {
		int x;
		int y;
		if ((this.var_c40 != 2) && (this.var_c40 != 4)) {
			if (this.var_c40 == 6) {
				if (this.currentFrameIndex == 0) {
					graphics.setColor(15718144); // #EFD700 - darken yellow
				} else {
					graphics.setColor(16777215); // #FFFFFF
				}
				if (this.var_c60 > 0) {
					x = this.pixelX + 15;
					graphics.fillArc(this.pixelX, this.pixelY - 15, 30, 30, 0, 360);
					graphics.fillRect(x, this.pixelY - 15, Class_c_MainCanvas.canvasWidth - x, 30);
					return;
				}
				graphics.fillArc(this.pixelX - 30, this.pixelY - 15, 30, 30, 0, 360);
				graphics.fillRect(0, this.pixelY - 15, this.pixelX - 15, 30);
				return;
			}
			if (this.var_c40 == 3) {
				graphics.setColor(0);
				if (this.var_c60 > 0) {
					graphics.drawLine(this.pixelX, this.pixelY, this.pixelX + 4, this.pixelY - 2);
					return;
				}
				graphics.drawLine(this.pixelX - 4, this.pixelY - 2, this.pixelX, this.pixelY);
				return;
			}
			if (this.var_c18) {
				y = this.pixelX + inX;
				x = this.pixelY + inY;
				if (this.var_cb0 != null) {
					Class_c_MainCanvas
							.sub_2007(graphics, this.var_cb0, y, x, this.var_cb8, 33);
					return;
				}
				if (this.var_c90 > 0) {
					y += Class_c_MainCanvas.getRandomWithin(-4, 5);
					x += Class_c_MainCanvas.getRandomWithin(-1, 2);
				}
				int k = this.currentFrameSequence[this.currentFrameIndex];
				this.frameImages[k].drawOnGraphics(graphics, y, x);
				if (this.var_cc0 != null) {
					Class_g_Sprite cl;
					int val = k % (getImagesCount() / 2);
					if (val == 2) {
						cl = this.var_cc8;
					} else {
						cl = this.var_cc0;
						this.var_cc0.setCurrentFrameIndex(inX);
					}
					cl.sub_1d20(graphics, y, x);
				}
			}
		} else {
			graphics.setColor(this.someColorInt);
			for (int k1 = 0; k1 < 5; k1++) {
				if (this.var_cf0[k1] != false) {
					y = (this.var_cd0[k1][0] >> 10) + inX + this.pixelX;
					x = (this.var_cd0[k1][1] >> 10) + inY + this.pixelY;
					graphics.fillRect(y, x, this.var_ce8[k1], this.var_ce8[k1]);
				}
			}
		}
	}

	public static Class_g_Sprite createSomeSprite(String paramString, int paramInt1, int paramInt2, byte paramByte) {
		//@todo first arg was missing, params are unused =(
		int someWidth = Class_c_MainCanvas.sub_1e71(paramByte, paramString); 
		int someHeight = Class_c_MainCanvas.sub_1e99((byte) 1); // why 1?
		Class_g_Sprite sprite = new Class_g_Sprite(someWidth, someHeight);
		sprite.var_cb8 = 1;
		sprite.var_cb0 = paramString;
		sprite.var_c60 = 0;
		sprite.var_c70 = -4;
		sprite.var_c40 = 5;
		return sprite;
	}

	public static Class_g_Sprite sub_2054(Class_g_Sprite inSprite, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int inFrameDelay, byte paramByte) {
		if (inSprite != null) {
			inSprite = new Class_g_Sprite(inSprite);
		} else {
			inSprite = new Class_g_Sprite(0, 0);
			if ((paramByte == 2) || (paramByte == 4)) {
				if (paramByte == 4) {
					inSprite.someColorInt = 15658751; // #EEEEFF - lightgrayblue
				}
				inSprite.var_cd0 = new int[5][2];
				inSprite.var_cd8 = new short[5][2];
				inSprite.var_ce8 = new byte[5];
				inSprite.var_cf0 = new boolean[5];
				for (int i = 0; i < 5; i++) {
					inSprite.var_cf0[i] = true;
					if (paramByte == 4) {
						inSprite.var_cd8[i][0] = ((short) (Class_c_MainCanvas.random
								.nextInt() % 4 << 10));
						inSprite.var_cd8[i][1] = ((short) (Class_c_MainCanvas.random
								.nextInt() % 4 << 10));
					} else {
						inSprite.var_cd8[i][0] = ((short) (Math
								.abs(Class_c_MainCanvas.random.nextInt()) % 8192 + -4096));
						inSprite.var_cd8[i][1] = ((short) (Math
								.abs(Class_c_MainCanvas.random.nextInt()) % 4096 + -2048));
					}
					inSprite.var_ce8[i] = ((byte) (Math
							.abs(Class_c_MainCanvas.random.nextInt()) % 2 + 1));
				}
			}
		}
		inSprite.var_c40 = paramByte;
		inSprite.var_c48 = paramInt4;
		inSprite.frameDelay = inFrameDelay;
		inSprite.var_c60 = paramInt1;
		inSprite.var_c68 = paramInt2;
		inSprite.var_c70 = paramInt3;
		inSprite.var_c80 = true;
		return inSprite;
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
				setPixelPosition(this.pixelX + this.var_c60, this.pixelY + this.var_c68);
				return;
			case 5:
				if (this.var_c48 == -1) {
					setPixelPosition(this.pixelX + this.var_c60, this.pixelY);
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
				this.currentFrameIndex = ((this.currentFrameIndex + 1) % 2);
				if (this.var_c50 >= this.frameDelay) {
					this.var_c78 = false;
					return;
				}
				break;
			default:
				setPixelPosition(this.pixelX + this.var_c60, this.pixelY + this.var_c68);
				this.var_c38 += this.var_c70;
				if ((this.var_c48 != 0) && (this.var_c50 >= this.frameDelay)) {
					nextFrame();
					if ((this.var_c40 == 0) && (this.currentFrameIndex == 0) && (this.var_c48 > 0)) {
						this.var_c48 -= 1;
						if (this.var_c48 <= 0) {
							setCurrentFrameIndex(getFramesCount() - 1);
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
			this.someColorInt += -263168;
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
		if (this.var_c50 >= this.frameDelay) {
			this.var_c78 = false;
		}
	}

	public static Connection createFileConnection(String path) {
		try {
			if (path.startsWith("file://")) {
				return getFileConnectionImpl(Connector.open(path));
			}
			return Connector.open(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Connection createFileConnectionWithInt(String paramString, int unusedInt) {
		try {
			if (paramString.startsWith("file://")) {
				return getFileConnectionImpl(Connector.open(paramString, 1));
			}
			return Connector.open(paramString, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static Class_c_AConnection getFileConnectionImpl(Connection conn) {
		// i added switch expr	
		/*
		switch (Class_a_StaticFileConnection.getAvailableFileConnectionCode()) { 
		  case 1: return new Class_e_StandardFileCon(conn);
		  case 2: return new Class_d_SiemenFileCon(conn); 
		  case 3: return new Class_b_MotorolaFileCon(conn); 
		  case 4: return new Class_f_MotorolaFileCon2(conn);
		}
		*/
		return null;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: a.a.a.Class_g_2517
 * 
 * JD-Core Version: 0.7.0.1
 */