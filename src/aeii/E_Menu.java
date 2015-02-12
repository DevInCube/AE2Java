package aeii;

import a.a.a.G_Sprite;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

public final class E_Menu extends F_StringManager {

	private boolean[] var_fe2 = { false, false };
	public int someGrayColor = 13553358; //#CECECE lightGray
	private static int var_ff2 = C_MainCanvas.canvasHeight;
	private static int var_ffa = ((E_Menu.var_ff2 <= 143 ? 1 : 2) << 1) + 1;
	private byte var_1002 = 2;
	private short var_100a = 3;
	public static G_Game theGame;
	public String[] menuActionsListString;
	private D_ImageWrap[] someImages;
	private int menuLeftX;
	private int menuTopY;
	public int mapPrevPixelWidth;
	public int mapPrevPixelHeight;
	private int listItemHeightMb;
	private Font mainFont = C_MainCanvas.theFont;
	public int var_105a;
	private int var_1062;
	private int var_106a;
	private int var_1072;
	private int menuLeftX1mb;
	private int menuLeftY1Mb;
	public byte typeMB;
	private int var_1092;
	private boolean var_109a = false;
	private boolean var_10a2 = false;
	public A_Unit[] someUnits;
	private int var_10b2;
	private int var_10ba;
	private byte var_10c2 = -1;
	private int var_10ca;
	private int var_10d2;
	private int var_10da;
	private int var_10e2;
	private String[] var_10ea;
	public int showTime = -1;
	private boolean var_10fa = true;
	private int var_1102;
	public A_Unit someUnit0;
	private boolean var_1112 = true;
	public F_StringManager stringManager;
	private int var_1122;
	private G_Sprite[] threeSmallSparksSprites;
	private int var_1132;
	private boolean var_113a = false;
	private Vector childrenMenu;
	public int var_114a = -1;
	public boolean var_1152;
	public boolean var_115a;
	private int var_1162;
	private int var_116a;
	private int maxSmallTilesInViewPortWidth;
	private int maxSmallTilesInViewPortHeight;
	private byte[][] theMapData;
	private Vector var_118a;
	private int mapWidth;
	private int mapHeight;
	public int var_11a2 = 2370117;
	public int var_11aa = 2370117;
	public D_ImageWrap menuImage;
	private E_Menu eMenu;
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
	private int someHeightMb;
	private int var_1242;
	private byte var_124a;
	private G_Sprite bigCircleSprite;
	
	public E_Menu(byte typeMB, int paramInt) {
		this.typeMB = typeMB;
		this.var_1092 = paramInt;
		if (typeMB == 15) {
			this.var_11e2 = (theGame.someCanHeight - theGame.buttonsSprite.spriteFrameHeight);
			this.var_10fa = true;
		} else if ((typeMB != 0) && (typeMB != 11)) {
			if (typeMB == 3) {
				this.bigCircleSprite = theGame.bigCircleSprite;
				initSmallSparks();
				this.var_10fa = false;
				this.var_1152 = true;
				this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
				this.mapPrevPixelWidth = theGame.someCanWidth;
				this.mapPrevPixelHeight = (theGame.bigCircleSprite.spriteFrameHeight + var_ffa);
				if ((paramInt & 0x2) == 0) {
					this.mapPrevPixelHeight += 5;
				}
				this.someUnits = A_Unit.sub_27b7(theGame.currentPlayerId);
				this.var_1062 = this.someUnits.length;
				int pInt = (int) (this.mapPrevPixelWidth - (theGame.sideArrowSprite.spriteFrameWidth << 1));
				if ((paramInt & 0x4) == 0) {
					pInt -= 8;
				}
				if ((paramInt & 0x8) == 0) {
					pInt -= 8;
				}
				this.var_10d2 = (pInt / (theGame.bigCircleSprite.spriteFrameWidth + 3));
				if (this.var_10d2 > this.var_1062) {
					this.var_10d2 = this.var_1062;
				}
				this.listItemHeightMb = (pInt / this.var_10d2);
				this.var_1122 = ((pInt - this.listItemHeightMb * this.var_10d2) / 2);
				this.var_1002 = 2;
			} else if ((typeMB != 2) && (typeMB != 5)) {
				if ((typeMB != 7) && (typeMB == 8)) {
					this.var_100a = 8;
					this.var_fe2[0] = true;
				}
			} else {
				this.var_10fa = false;
				this.mapPrevPixelHeight = (5 + var_ff2 + 24 + var_ffa
						+ (theGame.smallCircleSprite.spriteFrameHeight << 1) + var_ff2 + var_ff2 + 1);
				if (typeMB == 5) {
					this.mapPrevPixelHeight += var_ffa + C_MainCanvas.fontBaselinePos;
					this.someUnit0 = theGame.getUnitAtPos(theGame.cursorPosX,
							theGame.cursorPosY, (byte) 0);
					this.var_105a = this.someUnit0.unitType;
					this.mapPrevPixelWidth = theGame.someCanWidth;
				} else {
					this.mapPrevPixelWidth = theGame.someCanWidth;
				}
			}
		} else {
			this.var_fe2[0] = true;
			this.var_fe2[1] = true;
		}
		this.var_109a = true;
	}

	public final void sub_1272() {
		this.var_1232 = 0;
		if (this.threeSmallSparksSprites != null) {
			setSmallSparksRandomPosition();
		}
		this.var_1132 = 4;
		this.var_109a = true;
		this.var_10a2 = true;
		if (theGame != null) {
			theGame.someUnknownMethod();
		}
		if (this.eMenu != null) {
			this.eMenu.var_109a = true;
		}
		if (this.typeMB == 15) {
			for (int i = 0; i < this.childrenMenu.size(); i++) {
				E_Menu mMenu = (E_Menu) this.childrenMenu.elementAt(i);
				mMenu.sub_1272();
				mMenu.var_10a2 = false;
			}
		}
	}

	public final void sub_132e(byte paramByte, boolean paramBoolean) {
		this.var_fe2[paramByte] = paramBoolean;
	}

	public final void sub_1350(F_StringManager sm) {
		this.stringManager = sm;
		this.var_fe2[1] = (boolean) (sm != null ? true : false);
	}

	public final E_Menu sub_165b(String paramString) {
		this.eMenu = new E_Menu((byte) 10, 0);
		this.eMenu.initMessageBox(null, paramString, theGame.someCanWidth, -1);
		return this.eMenu;
	}

	public final void addChildMenu(E_Menu childMenu, int inX,
			int inY, int paramInt3) {
		if (this.childrenMenu == null) {
			this.childrenMenu = new Vector();
		}
		if (this.var_11da == null) {
			this.var_11da = new int[5];
			for (int i = 0; i < 5; i++) {
				this.var_11da[i] = this.var_11e2;
				if (i > 0) {
					this.var_11da[i] -= theGame.buttonsSprite.spriteFrameHeight;
				}
			}
		}
		childMenu.setLocation(inX, inY, paramInt3);
		int menuTopY = childMenu.menuTopY;
		for (int it = 0; it < 5; it++) {
			if (menuTopY < this.var_11da[it]) {
				if (menuTopY + childMenu.mapPrevPixelHeight <= this.var_11da[it]) {
					break;
				}
				this.var_11da[it] = menuTopY;
				if (it + 1 <= this.var_11d2) {
					break;
				}
				this.var_11d2 = (it + 1);
				break;
			}
			menuTopY -= this.var_11da[inX];
		}
		childMenu.var_fe2[0] = false;
		childMenu.var_fe2[1] = false;
		this.childrenMenu.addElement(childMenu);
	}

	public final void setMapPreviewMaybe(int viewportWidthMb, int viewportHeight,
			byte[][] mapData, Vector paramVector) {
		this.var_1092 = 15;
		this.theMapData = mapData;
		this.var_118a = paramVector;
		this.var_100a = 8;
		this.var_fe2[0] = true;
		this.var_10fa = true;
		this.mapWidth = mapData.length;
		this.mapHeight = mapData[0].length;
		this.mapPrevPixelWidth = (this.mapWidth * theGame.smallTilesFrames[0].imageWidth + 8); // 2 * border width
		this.mapPrevPixelHeight = (this.mapHeight * theGame.smallTilesFrames[0].imageHeight + 8);// 2 * border height
		if (this.mapPrevPixelWidth > viewportWidthMb) {
			int smallTileWidth = theGame.smallTilesFrames[0].imageWidth;
			this.maxSmallTilesInViewPortWidth = ((viewportWidthMb - 8) / smallTileWidth);
			this.mapPrevPixelWidth = (smallTileWidth * this.maxSmallTilesInViewPortWidth + 8);
		} else {
			this.maxSmallTilesInViewPortWidth = this.mapWidth;
		}
		if (this.mapPrevPixelHeight > viewportHeight) {
			int smallTileHeight = theGame.smallTilesFrames[0].imageHeight;
			this.maxSmallTilesInViewPortHeight = ((viewportHeight - 8) / smallTileHeight);
			this.mapPrevPixelHeight = (smallTileHeight * this.maxSmallTilesInViewPortHeight + 8);
		} else {
			this.maxSmallTilesInViewPortHeight = this.mapHeight;
		}
		this.typeMB = 8;
	}

	public final void setLocation(int locX, int locY, int paramInt3) {
		this.menuLeftX = locX;
		this.menuTopY = locY;
		if ((paramInt3 & 0x1) != 0) {
			this.menuLeftX -= (this.mapPrevPixelWidth >> 1);
		} else if ((paramInt3 & 0x8) != 0) {
			this.menuLeftX -= this.mapPrevPixelWidth;
		}
		if ((paramInt3 & 0x2) != 0) {
			this.menuTopY -= (this.mapPrevPixelHeight >> 1);
		} else if ((paramInt3 & 0x20) != 0) {
			this.menuTopY -= this.mapPrevPixelHeight;
		}
		this.menuLeftX1mb = this.menuLeftX;
		this.menuLeftY1Mb = this.menuTopY;
	}

	public final void sub_19f5(String paramString, int paramInt1,
			int paramInt2, byte paramByte) {
		this.var_10c2 = paramByte;
		if (paramByte == -1) {
			this.var_1092 = 14;
		} else {
			this.var_10da = (theGame.portraitsSprite.spriteFrameWidth - 8);
		}
		int intVal;
		intVal = paramInt1 - this.var_10da - 16;
		this.menuActionsListString = F_StringManager.wrapStringText(paramString, intVal,
				C_MainCanvas.theFont);
		sub_1a89(null, this.menuActionsListString, paramInt1, paramInt2);
		this.var_113a = false;
		this.typeMB = 7;
	}

	private void sub_1a89(String paramString, String[] paramArrayOfString,
			int paramInt1, int paramInt2) {
		this.var_10fa = false;
		this.mapPrevPixelWidth = paramInt1;
		this.mapPrevPixelHeight = paramInt2;
		this.var_1062 = paramArrayOfString.length;
		this.var_105a = 0;
		this.var_10ca = 0;
		this.var_10e2 = 0;
		this.var_113a = false;
		paramInt1 = paramInt1 - this.var_10da - 16;
		if (paramString != null) {
			this.var_10ea = F_StringManager.wrapStringText(paramString, paramInt1,
					C_MainCanvas.theFont);
		}
		this.menuActionsListString = paramArrayOfString;
		this.listItemHeightMb = C_MainCanvas.var_1767;
		this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
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
			someInteger -= this.var_10ea.length * this.listItemHeightMb;
		}
		this.var_10d2 = ((someInteger - 2) / this.listItemHeightMb);
		if (this.var_10d2 > this.menuActionsListString.length) {
			this.var_10d2 = this.menuActionsListString.length;
		} else if (this.var_10d2 < this.menuActionsListString.length) {
			this.var_113a = true;
		}
		if (paramInt2 < 0) {
			if (this.var_10ea != null) {
				this.mapPrevPixelHeight = (this.var_10ea.length * this.listItemHeightMb);
			}
			this.mapPrevPixelHeight += this.var_10d2 * this.listItemHeightMb;
			if ((this.var_1092 & 0x1) == 0) {
				this.mapPrevPixelHeight += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				this.mapPrevPixelHeight += 5;
			}
		} else {
			this.var_1122 = ((someInteger - this.var_10d2 * this.listItemHeightMb) / 2);
		}
		this.typeMB = 10;
		this.var_1002 = 2;
	}

	public final void initMessageBox(String header, String message,
			int sWidth, int paramInt2) {
		int sWid = sWidth - this.var_10da;
		if ((this.var_1092 & 0x4) == 0) {
			sWid -= 8;
		}
		if ((this.var_1092 & 0x8) == 0) {
			sWid -= 8;
		}
		this.menuActionsListString = F_StringManager.wrapStringText(message, sWid,
				C_MainCanvas.theFont);
		sub_1a89(header, this.menuActionsListString, sWidth, paramInt2);
		if (this.var_113a) {
			sWid -= theGame.arrowSprite.spriteFrameWidth;
			this.menuActionsListString = F_StringManager.wrapStringText(message, sWid,
					C_MainCanvas.theFont);
			sub_1a89(header, this.menuActionsListString, sWidth, paramInt2);
		}
	}

	private final void initSmallSparks() {
		this.threeSmallSparksSprites = new G_Sprite[3];
		for (int i = 0; i < this.threeSmallSparksSprites.length; i++) {
			this.threeSmallSparksSprites[i] = new G_Sprite(theGame.smallSparkSprite);
		}
		setSmallSparksRandomPosition();
	}

	private void setSmallSparksRandomPosition() {
		for (int i = 0; i < this.threeSmallSparksSprites.length; i++) {
			this.threeSmallSparksSprites[i].var_c18 = true;
			this.threeSmallSparksSprites[i].setPixelPosition(
					C_MainCanvas.getRandomMax(this.bigCircleSprite.spriteFrameWidth),
					C_MainCanvas.getRandomMax(this.bigCircleSprite.spriteFrameHeight));
			this.threeSmallSparksSprites[i].setCurrentFrameIndex(C_MainCanvas.getRandomMax(this.threeSmallSparksSprites[i]
					.getImagesCount()));
		}
	}

	public final void sub_1e54(String[] inStr,
			D_ImageWrap[] inImage, int paramInt1,
			int paramInt2, int paramInt3) {
		this.var_1092 = 15;
		this.menuActionsListString = inStr;
		this.someImages = inImage;
		this.var_1062 = this.menuActionsListString.length;
		this.mapPrevPixelWidth = 0;
		for (int it = 0; it < this.var_1062; it++) {
			int width = C_MainCanvas.theFont.stringWidth(this.menuActionsListString[it]);
			if (width > this.mapPrevPixelWidth) {
				this.mapPrevPixelWidth = width;
			}
		}
		this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
		this.var_10ba = (this.var_10b2 / 2);
		this.someHeightMb = theGame.smallCircleSprite.spriteFrameWidth;
		this.listItemHeightMb = (this.someHeightMb + this.var_10b2);
		this.mapPrevPixelWidth += this.var_1062 * this.listItemHeightMb;
		this.mapPrevPixelWidth += 32;
		if (this.mapPrevPixelWidth > this.canvasWidth) {
			this.mapPrevPixelWidth = this.canvasWidth;
		}
		this.mapPrevPixelHeight = this.someHeightMb;
		setLocation(paramInt1, paramInt2, paramInt3);
		this.typeMB = 13;
		this.var_1002 = 2;
	}

	public final void initSlotsMenues(String[] headers, int inWidth,
			int paramInt2) {
		this.menuActionsListString = headers;
		this.var_1062 = this.menuActionsListString.length;
		this.var_1152 = true;
		this.var_10fa = false;
		this.mapPrevPixelHeight = paramInt2;
		int maxStringWidth = 0;
		for (int it = 0; it < this.menuActionsListString.length; it++) {
			int strWidth = C_MainCanvas.theFont.stringWidth(this.menuActionsListString[it]);
			if (strWidth > maxStringWidth) {
				maxStringWidth = strWidth;
			}
		}
		this.mapPrevPixelWidth = (maxStringWidth + 16 + (theGame.sideArrowSprite.spriteFrameWidth << 1));
		if (this.mapPrevPixelWidth < inWidth) {
			this.mapPrevPixelWidth = inWidth;
		}
		if (this.mapPrevPixelHeight < 0) {
			this.mapPrevPixelHeight = C_MainCanvas.var_1767;
			if (theGame.sideArrowSprite.spriteFrameHeight > this.mapPrevPixelHeight) {
				this.mapPrevPixelHeight = theGame.sideArrowSprite.spriteFrameHeight;
			}
			if ((this.var_1092 & 0x1) == 0) {
				this.mapPrevPixelHeight += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				this.mapPrevPixelHeight += 5;
			}
		}
		this.typeMB = 14; //slot menu
		this.var_1002 = 2;
	}

	public final void setMenuListStringActionsMb(String[] actStrings, int centerX,
			int centerY, int minWidth, int maxHeight, int paramInt5,
			int someModeOrType) {
		this.menuActionsListString = actStrings;
		this.var_1062 = this.menuActionsListString.length;
		this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
		this.listItemHeightMb = C_MainCanvas.var_1767;
		int width;
		int maxStringWidth = 0;
		for (int i = 0; i < this.menuActionsListString.length; i++) {
			width = C_MainCanvas.theFont.stringWidth(this.menuActionsListString[i]);
			if (width > maxStringWidth) {
				maxStringWidth = width;
			}
		}
		this.mapPrevPixelWidth = (maxStringWidth + 4 + 16);
		if (this.mapPrevPixelWidth > this.canvasWidth) {
			this.mapPrevPixelWidth = this.canvasWidth;
		} else if (this.mapPrevPixelWidth < minWidth) {
			if (someModeOrType == 4) {
				this.var_11ea = ((minWidth - this.mapPrevPixelWidth) / 2);
			}
			this.mapPrevPixelWidth = minWidth;
		}
		this.mapPrevPixelHeight = (this.listItemHeightMb * this.menuActionsListString.length + this.var_10b2 + 16);
		if (this.mapPrevPixelHeight > maxHeight) {
			this.mapPrevPixelHeight = maxHeight;
		}
		sub_1a89(null, this.menuActionsListString, this.mapPrevPixelWidth, this.mapPrevPixelHeight);
		if ((this.mapPrevPixelWidth < this.canvasWidth) && (this.var_113a)) {
			this.mapPrevPixelWidth += theGame.arrowSprite.spriteFrameWidth;
		}
		this.typeMB = 11;
		setLocation(centerX, centerY, paramInt5);
	}

	public final void sub_224f(String[] inStrings,
			D_ImageWrap[] inIMage, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, byte paramByte) {
		this.var_124a = 1;
		this.menuActionsListString = inStrings;
		this.someImages = inIMage;
		this.var_1062 = this.menuActionsListString.length;
		this.bigCircleSprite = theGame.bigCircleSprite;
		this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
		this.var_1092 = 15;
		this.someHeightMb = this.bigCircleSprite.spriteFrameWidth;
		this.var_1242 = (this.someHeightMb >> 1);
		initSmallSparks();
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
			this.var_1202 = ((this.bigCircleSprite.spriteFrameWidth << 10) / (2 * F_StringManager
					.sub_f0f(45)));
			this.var_120a = (this.var_1202 + this.bigCircleSprite.spriteFrameWidth / 2);
			paramInt3 = (this.var_120a << 1) + C_MainCanvas.var_1767 + 2;
		} else {
			int someInt = (this.bigCircleSprite.spriteFrameWidth << 10)
					/ F_StringManager.sub_f0f(this.var_1222 / 2)
					+ this.bigCircleSprite.spriteFrameHeight / 2;
			this.var_120a = ((paramInt3 - C_MainCanvas.var_1767) / 2 - 2);
			if (this.var_120a > someInt) {
				this.var_120a = someInt;
			}
			this.var_1202 = (this.var_120a - this.bigCircleSprite.spriteFrameHeight / 2);
		}
		this.var_11fa = 0;
		this.mapPrevPixelWidth = (this.var_120a << 1);
		this.mapPrevPixelHeight = paramInt3;
		this.var_1002 = 0;
		setLocation(paramInt1, paramInt2, 3);
	}

	private int sub_242b(int paramInt) {
		int i = this.var_114a;
		int j = this.var_114a;
		int k = this.childrenMenu.size();
		do {
			if ((i += paramInt) < 0) {
				i = k - 1;
			} else if (i >= this.childrenMenu.size()) {
				if (j < 0) {
					return -1;
				}
				i = 0;
			}
		} while (!((E_Menu) this.childrenMenu.elementAt(i)).var_1152);
		return i;
	}

	public final void sub_24ca() {
		sub_24ea(true);
	}

	private void sub_24ea(boolean paramBoolean) {
		if (this.var_1002 != 3) {
			if ((this.typeMB == 10) && (this.showTime > 0)
					&& (this.showTime <= 250)) {
				this.var_1132 += 1;
				this.var_109a = true;
			} else if (this.var_1132 > 0) {
				this.var_1132 -= 1;
				this.var_109a = true;
			}
			if ((paramBoolean) && (this.var_1002 == 2)) {
				paramBoolean = false;
				if ((this.var_fe2[0] != false)
						&& ((F_StringManager.mainCanvas
								.sub_26d7(G_Game.var_4602)) || (F_StringManager.mainCanvas
								.sub_26d7(16)))) {
					paramBoolean = true;
					F_StringManager.mainCanvas.releaseGameAction(G_Game.var_4602);
					F_StringManager.mainCanvas.releaseGameAction(16);
				}
				if ((this.typeMB == 0) || (this.typeMB == 3)) {
					for (int i = 0; i < this.threeSmallSparksSprites.length; i++) {
						if (this.threeSmallSparksSprites[i].currentFrameIndex == this.threeSmallSparksSprites[i]
								.getImagesCount() - 1) {
							if (this.var_1232 == 0) {
								this.threeSmallSparksSprites[i]
										.setPixelPosition(
												C_MainCanvas
														.getRandomMax(this.bigCircleSprite.spriteFrameWidth
																- this.threeSmallSparksSprites[i].spriteFrameWidth),
												C_MainCanvas
														.getRandomMax(this.bigCircleSprite.spriteFrameHeight
																- this.threeSmallSparksSprites[i].spriteFrameHeight));
							} else {
								this.threeSmallSparksSprites[i].var_c18 = false;
							}
						}
						this.threeSmallSparksSprites[i].nextFrame();
					}
					this.var_109a = true;
				}
				if ((!this.var_115a) && (this.var_114a >= 0)) {
					int m;
					if (F_StringManager.mainCanvas.sub_26d7(1)) {
						((E_Menu) this.childrenMenu.elementAt(this.var_114a)).var_109a = true;
						this.var_114a = sub_242b(-1);
						E_Menu eClass = (E_Menu) this.childrenMenu
								.elementAt(this.var_114a);
						eClass.var_109a = true;
						m = eClass.menuTopY;
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
					if (F_StringManager.mainCanvas.sub_26d7(2)) {
						((E_Menu) this.childrenMenu.elementAt(this.var_114a)).var_109a = true;
						this.var_114a = sub_242b(1);
						E_Menu eClass = (E_Menu) this.childrenMenu
								.elementAt(this.var_114a);
						eClass .var_109a = true;
						m = eClass.menuTopY;
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
					theGame.sub_770a(this, this.var_114a, "", (byte) 0);
					return;
				}
				int k = 0;
				E_Menu localClass_e_01343 = (E_Menu) this.childrenMenu
						.elementAt(k);
				localClass_e_01343.sub_24ea(k == this.var_114a ? true
						: this.var_115a ? true : false);
				this.var_109a = true;
				if (this.typeMB == 0) {
					if (this.var_1002 == 2) {
						this.var_109a = true;
						if (F_StringManager.mainCanvas.sub_26d7(4)) {
							this.var_1232 -= this.var_1222;
							this.var_122a += this.var_1222;
							this.var_105a -= 1;
							if (this.var_105a < 0) {
								this.var_105a = (this.var_1062 - 1);
							}
						} else if (F_StringManager.mainCanvas.sub_26d7(8)) {
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
								setSmallSparksRandomPosition();
							}
						} else if (F_StringManager.mainCanvas.isGameActionRunning(4)) {
							this.var_1232 -= this.var_1222;
							this.var_122a += this.var_1222;
							this.var_105a -= 1;
							if (this.var_105a < 0) {
								this.var_105a = (this.var_1062 - 1);
							}
						} else if (F_StringManager.mainCanvas.isGameActionRunning(8)) {
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
							theGame.sub_770a(this, this.var_105a,
									this.menuActionsListString[this.var_105a], (byte) 0);
						}
					}
				} else if ((this.typeMB != 13) && (this.typeMB != 14)) {
					if (this.typeMB == 3) {
						if (this.var_10e2 != 0) {
							if (Math.abs(this.var_10e2) < 2) {
								this.var_10e2 = 0;
							} else {
								this.var_10e2 -= this.var_10e2 / 2;
							}
							this.var_109a = true;
						}
						if (paramBoolean) {
							theGame.sub_770a(this, this.var_105a,
									this.menuActionsListString[this.var_105a], (byte) 0);
							return;
						}
						if (F_StringManager.mainCanvas.sub_26d7(4)) {
							if (this.var_105a < this.var_10ca) {
								this.var_105a += this.var_1062;
							}
							this.var_105a -= 1;
							if (this.var_105a < this.var_10ca) {
								if (this.var_105a < 0) {
									this.var_105a += this.var_1062;
								}
								this.var_10ca = this.var_105a;
								this.var_10e2 = (-this.listItemHeightMb);
							}
							this.var_105a %= this.var_1062;
							theGame.sub_770a(this, this.var_105a, null,
									(byte) 2);
							setSmallSparksRandomPosition();
							this.var_109a = true;
						} else if (F_StringManager.mainCanvas.sub_26d7(8)) {
							if (this.var_105a < this.var_10ca) {
								this.var_105a += this.var_1062;
							}
							this.var_105a += 1;
							if (this.var_105a >= this.var_10ca + this.var_10d2) {
								this.var_10e2 = this.listItemHeightMb;
								this.var_10ca = ((this.var_10ca + 1) % this.var_1062);
							}
							this.var_105a %= this.var_1062;
							theGame.sub_770a(this, this.var_105a, null,
									(byte) 3);
							setSmallSparksRandomPosition();
							this.var_109a = true;
						}
					} else if ((this.typeMB != 10) && (this.typeMB != 7)
							&& (this.typeMB != 11)) {
						if (this.typeMB == 8) {
							if (F_StringManager.mainCanvas.sub_26d7(1)) {
								if (this.var_116a > 0) {
									this.var_116a -= 1;
									this.var_109a = true;
								}
							} else if ((F_StringManager.mainCanvas.sub_26d7(2))
									&& (this.var_116a + this.maxSmallTilesInViewPortHeight < this.mapHeight)) {
								this.var_116a += 1;
								this.var_109a = true;
							}
							if (F_StringManager.mainCanvas.sub_26d7(4)) {
								if (this.var_1162 > 0) {
									this.var_1162 -= 1;
									this.var_109a = true;
								}
							} else if ((F_StringManager.mainCanvas.sub_26d7(8))
									&& (this.var_1162 + this.maxSmallTilesInViewPortWidth < this.mapWidth)) {
								this.var_1162 += 1;
								this.var_109a = true;
							}
						}
					} else {
						if (this.showTime != -1) {
							if (this.showTime > 0) {
								this.showTime -= 50;
							} else {
								F_StringManager.mainCanvas.showMessageBox(this.stringManager);
							}
						}
						if (this.var_10e2 > 0) {
							this.var_10e2 -= this.listItemHeightMb / 3 + 1;
							if (this.var_10e2 < 0) {
								this.var_10e2 = 0;
							}
							this.var_109a = true;
						} else if (this.var_10e2 < 0) {
							this.var_10e2 += this.listItemHeightMb / 3 + 1;
							if (this.var_10e2 > 0) {
								this.var_10e2 = 0;
							}
							this.var_109a = true;
						}
						if (this.var_10e2 == 0) {
							if (((this.typeMB == 11) || (this.typeMB == 10))
									&& (paramBoolean)) {
								theGame.sub_770a(this, this.var_105a,
										this.menuActionsListString[this.var_105a], (byte) 0);
								return;
							}
							if ((this.typeMB != 7)
									&& (F_StringManager.mainCanvas.sub_26d7(1))) {
								if (this.typeMB == 11) {
									this.var_105a -= 1;
									if (this.var_105a < 0) {
										this.var_105a = (this.var_1062 - 1);
										this.var_10ca = (this.var_1062 - this.var_10d2);
										if (this.typeMB == 3) {
											this.var_10ca = this.var_105a;
										}
									} else if (this.var_105a < this.var_10ca) {
										this.var_10e2 = (-this.listItemHeightMb);
										this.var_10ca -= 1;
									}
									theGame.sub_770a(this, this.var_105a,
											null, (byte) 2);
									this.var_109a = true;
								} else if (this.var_10ca > 0) {
									this.var_10e2 = (-this.listItemHeightMb);
									this.var_10ca -= 1;
									this.var_109a = true;
								}
								F_StringManager.mainCanvas.clearActionCodesMb();
							}
							if ((F_StringManager.mainCanvas.sub_26d7(2))
									|| ((this.typeMB == 7) && (F_StringManager.mainCanvas
											.sub_26d7(2048)))) {
								if (this.typeMB == 11) {
									this.var_105a += 1;
									if (this.var_105a >= this.var_1062) {
										this.var_105a = 0;
										this.var_10ca = 0;
									} else if (this.var_105a >= this.var_10ca
											+ this.var_10d2) {
										this.var_10e2 = this.listItemHeightMb;
										this.var_10ca += 1;
									}
									theGame.sub_770a(this, this.var_105a,
											null, (byte) 3);
									this.var_109a = true;
								} else if (this.var_10ca + this.var_10d2 < this.menuActionsListString.length) {
									this.var_10e2 = this.listItemHeightMb;
									this.var_10ca += 1;
									this.var_109a = true;
								} else if (this.typeMB == 7) {
									theGame.sub_770a(this, 0, null, (byte) 0);
									return;
								}
								F_StringManager.mainCanvas.clearActionCodesMb();
							}
						}
					}
				} else if (F_StringManager.mainCanvas.sub_26d7(4)) {
					this.var_105a -= 1;
					if (this.var_105a < 0) {
						this.var_105a = (this.var_1062 - 1);
					}
					if (this.typeMB == 14) {
						theGame.sub_770a(this, this.var_105a, null, (byte) 2);
					}
					this.var_109a = true;
				} else if (F_StringManager.mainCanvas.sub_26d7(8)) {
					this.var_105a += 1;
					if (this.var_105a >= this.var_1062) {
						this.var_105a = 0;
					}
					if (this.typeMB == 14) {
						theGame.sub_770a(this, this.var_105a, null, (byte) 2);
					}
					this.var_109a = true;
				} else if (paramBoolean) {
					theGame.sub_770a(this, this.var_105a,
							this.menuActionsListString[this.var_105a], (byte) 0);
					return;
				}
				if ((this.var_1002 == 2)
						&& (this.var_fe2[1] != false)
						&& (F_StringManager.mainCanvas
								.sub_26d7(G_Game.var_460a))) {
					F_StringManager.mainCanvas.releaseGameAction(G_Game.var_460a);
					F_StringManager.mainCanvas.clearActionCodesMb();
					if (this.stringManager != null) {
						F_StringManager.mainCanvas.showMessageBox(this.stringManager);
					}
					if (this.menuActionsListString != null) {
						theGame.sub_770a(this, this.var_105a,
								this.menuActionsListString[this.var_105a], (byte) 1);
						return;
					}
					theGame.sub_770a(this, -1, null, (byte) 1);
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
				if (this.typeMB == 0) {
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
					if ((F_StringManager.mainCanvas.sub_2677())
							|| ((this.var_11fa >= this.var_1202) && (this.var_11f2[0] == 0))) {
						this.var_11fa = this.var_1202;
						for (int it = 0; it < this.var_11f2.length; it++) {
							this.var_11f2[it] = ((short) (this.var_1222 * it));
						}
						this.var_1002 = 2;
						if (this.var_1112) {
							F_StringManager.mainCanvas.clearActionCodesMb();
						}
					}
				} else if (this.typeMB == 13) {
					this.menuLeftX1mb += (this.menuLeftX - this.menuLeftX1mb) / 2;
					this.var_1102 += 1;
					if (this.var_1102 == 2) {
						this.var_1002 = 2;
						this.menuLeftX1mb = this.menuLeftX;
					}
				} else {
					int theInt;
					if ((theInt = (this.menuLeftX - this.menuLeftX1mb) / 4) <= 0) {
						paramBoolean = true;
					}
					this.menuLeftX1mb += theInt;
					if (this.menuLeftX1mb == this.menuLeftX) {
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

	public static final void drawRoundedRect(Graphics paramGraphics, int paramInt1,
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
			if (((F_StringManager.mainCanvas.var_17b7 == this) && (this.var_10a2))
					|| (this.typeMB == 0)) {
				theGame.startLoading(paramGraphics);
			}
			this.var_10a2 = false;
			paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			if (this.eMenu != null) {
				this.eMenu.sub_347b(paramGraphics);
			}
			paramInt1 = this.menuLeftX1mb;
			paramInt2 = this.menuLeftY1Mb + paramInt2;
			if ((this.typeMB != 0) && (this.typeMB != 13)) {
				sub_5092(paramGraphics, paramInt1, paramInt2, this.mapPrevPixelWidth,
						this.mapPrevPixelHeight, this.var_1092, this.var_11aa,
						this.var_11a2, this.var_1132, 5);
				paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			}
			int someXVal = this.mapPrevPixelWidth;
			int someYVal = this.mapPrevPixelHeight;
			if ((this.var_1092 & 0x1) == 0) {
				someYVal -= 5;
				paramInt2 += 5;
			}
			if ((this.var_1092 & 0x2) == 0) {
				someYVal -= 5;
			}
			if ((this.var_1092 & 0x4) == 0) {
				paramInt1 += 8;
				someXVal -= 8;
			}
			if ((this.var_1092 & 0x8) == 0) {
				someXVal -= 8;
			}
			paramGraphics.translate(paramInt1, paramInt2);
			paramGraphics.setFont(this.mainFont);
			if ((this.menuImage != null)
					&& ((this.menuActionsListString == null) || (this.mainFont
							.stringWidth(this.menuActionsListString[0]) < someXVal
							- (this.menuImage.imageWidth << 1)))) {
				this.menuImage.drawOnGraphics(paramGraphics, 0, someYVal / 1, 6);
			}
			if (paramBoolean) {
				paramGraphics.setColor(5594742);
				drawRoundedRect(paramGraphics, 0, 0, someXVal, someYVal);
			}
			int k;
			int bool4;
			int bool3;
			int bool5 = 0; //@todo bool5 = 0 ? i wrote this
			if (this.typeMB == 0) {
				paramGraphics.setColor(16777215);
				k = this.var_122a + this.var_1232;
				for (bool4 = this.var_11f2.length - 1; bool4>0; bool4--) {
					if ((bool3 = (this.var_11f2[bool4] + k) % 360) < 0) {
						bool3 += 360;
					}
					int iInt = this.var_120a
							+ (F_StringManager.sub_f0f(bool3) * this.var_11fa >> 10);
					bool3 = C_MainCanvas.var_1767
							+ this.var_120a
							+ 2
							- (F_StringManager.sub_f35(bool3) * this.var_11fa >> 10);
					if ((this.var_1002 == 2) && (bool4 == this.var_105a)) {
						this.bigCircleSprite.drawFrame(paramGraphics, 1, iInt,
								bool3, 3);
						if (this.var_1232 == 0) {
							bool5 = 0;
						}
					} else {
						while (bool5 < this.threeSmallSparksSprites.length) {
							this.threeSmallSparksSprites[bool5].drawCurrentFrame(paramGraphics,
									iInt - this.var_1242, bool3
											- this.var_1242, 20);
							bool5++;
							//continue; @todo i commented
							this.bigCircleSprite.drawFrame(paramGraphics, 0,
									iInt, bool3, 3);
						}
					}
					if ((this.menuActionsListString[bool4] != null)
							&& (this.someImages != null)
							&& (this.someImages[bool4] != null)) {
						this.someImages[bool4].drawOnGraphics(paramGraphics,
								iInt, bool3, 3);
					}
				}
				if (this.var_1002 == 2) {
					for (bool4 = 0; bool4 < this.threeSmallSparksSprites.length; bool4++) {
						this.threeSmallSparksSprites[bool4].drawCurrentFrame(paramGraphics,
								(this.mapPrevPixelWidth - this.someHeightMb) / 2,
								C_MainCanvas.var_1767, 3);
					}
				}
			}
			int bool12 = 0;
			int m = 0;
			int bool9 = 0;
			int i4 = 0;
			int i3 = 0;
			int j = 0;
			int bool7  = 0;
			int bool10  = 0;
			int bool11 = 0;
			int i  = 0;
			int n  = 0;
			switch (this.typeMB) {
				case 0:
					if (this.var_1002 == 2) {
						paramGraphics.setColor(1645370);
						if (this.var_124a == 2) {
							someYVal = this.mapPrevPixelWidth;
							if (this.menuActionsListString[this.var_105a] != null) {
								bool12 = C_MainCanvas.theFont
										.stringWidth(this.menuActionsListString[this.var_105a]) + 2;
								if (someYVal < bool12) {
									someYVal = bool12;
								}
							}
							drawRoundedRect(paramGraphics, (this.mapPrevPixelWidth - someYVal) / 2, 1,
									someYVal, C_MainCanvas.var_1767);
						} else {
							drawRoundedRect(paramGraphics, 2 - this.menuLeftX, 1,
									this.canvasWidth - 4, C_MainCanvas.var_1767);
						}
						if (this.menuActionsListString[this.var_105a] != null) {
							paramGraphics.setColor(16777215);
							C_MainCanvas.showString(paramGraphics,
									this.menuActionsListString[this.var_105a], this.var_120a,
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
					paramGraphics.setClip(0, 0, someXVal, someYVal);
					someYVal = var_ff2;
					this.someUnit0.sub_28d7(paramGraphics, -this.someUnit0.pixelX + someYVal,
							-this.someUnit0.pixelY + someYVal);  // m n p o
					k = someYVal + this.someUnit0.spriteFrameHeight / 2;
					paramGraphics.setFont(C_MainCanvas.theFont);
					paramGraphics.setColor(this.someGrayColor);
					C_MainCanvas.showString(paramGraphics, this.someUnit0.unitName,
							someYVal + this.someUnit0.spriteFrameWidth + someYVal, k
									- C_MainCanvas.fontBaselinePos / 2, 20);
					String str2;
					if (this.typeMB == 2) {
						str2 = "" + this.someUnit0.cost;
						theGame.hudIcons2Sprite.drawFrame(paramGraphics, 1, someXVal - someYVal
								- C_MainCanvas.spriteTextWidth((byte) 1, str2), k, 10);
					} else {
						str2 = "" + this.someUnit0.health;
					}
					C_MainCanvas.sub_2007(paramGraphics, str2, someXVal - someYVal, k, 1,
							10);
					this.var_10b2 = (C_MainCanvas.var_1767 - C_MainCanvas.fontBaselinePos);
					bool3 = someYVal + this.someUnit0.spriteFrameHeight + var_ff2;
					paramGraphics.setColor(this.someGrayColor);
					paramGraphics.drawLine(someYVal, bool3, someXVal - someYVal - someYVal,
							bool3);
					bool3 += 1 + var_ff2;
					int i2;
					if (this.typeMB == 5) {
						bool5 = C_MainCanvas.fontBaselinePos;
						k = bool3 + bool5 / 1;
						C_MainCanvas.showString(paramGraphics,
								F_StringManager.getLangString(97), someYVal, bool3, 20);
						bool4 = C_MainCanvas.theFont.stringWidth(F_StringManager
								.getLangString(97));
						int sumBool;
						sumBool = someYVal + bool4 + someYVal;
						String str1 = "" + this.someUnit0.level;
						i2 = C_MainCanvas.spriteTextWidth((byte) 0, str1);
						int bool13 = someXVal - sumBool - someYVal
								- theGame.hudIconsSprite.spriteFrameWidth - i2 - someYVal;
						paramGraphics.setColor(this.someGrayColor);
						drawRoundedRect(paramGraphics, sumBool, bool3, bool13, bool5);
						paramGraphics.setColor(2370117);
						int bool6;
						if ((bool6 = bool13 * this.someUnit0.experience
								/ this.someUnit0.getLevelExperience()) <= 0) {
							bool6 = 1;
						}
						paramGraphics.fillRect(sumBool + 1, bool3 + 1,
								bool6, bool5 - 1);
						sumBool = someXVal - someYVal - i2;
						theGame.hudIconsSprite.drawFrame(paramGraphics, 2, sumBool,
								k, 10);
						C_MainCanvas.sub_2007(paramGraphics, str1, sumBool, k,
								0, 6);
						bool3 += bool5 + var_ff2;
						paramGraphics.setColor(this.someGrayColor);
						paramGraphics.drawLine(someYVal, bool3, someXVal - someYVal - someYVal,
								bool3);
						bool3 += 1 + var_ff2;
					}
					bool5 = (someXVal - someYVal * 1) / 2;
					m = theGame.hudIconsSprite.spriteFrameHeight;
					int bool13 = theGame.smallCircleSprite.spriteFrameHeight;
					int bool6 = theGame.smallCircleSprite.spriteFrameHeight / 2;
					for (k = 0; k < 2; k++) {
						int bool9Int = bool3 + bool6 - m / 2;
						int sumBool;
						sumBool = someYVal;
						for (int bool11Int = 0; bool11Int < 1; bool11Int++) {
							if ((k == 0) || (bool11==0)) {
								i2 = sumBool + bool6;
								drawRoundedRect(paramGraphics, i2, bool9Int, bool5 - bool6, m);
								theGame.smallCircleSprite.sub_1d20(paramGraphics,
										sumBool, bool3);
								if (((i4 = (k << 1) + bool11Int) == 0) || (i4 == 1)) {
									theGame.hudIconsSprite.drawFrame(paramGraphics, i4,
											i2, bool3 + bool6, 3);
								}
								bool12 = 0;
								if (i4 == 0) {
									if (this.typeMB == 5) {
										i3 = this.someUnit0.getExtraUnitAttack(null);
									}
									str2 = this.someUnit0.attackMin + i3 + "-"
											+ (this.someUnit0.attackMax + i3);
								} else if (i4 == 1) {
									if (this.typeMB == 5) {
										i3 = this.someUnit0.getExtraDefence(null);
									}
									str2 = "" + (this.someUnit0.defence + i3);
								} else if (i4 == 2) {
									theGame.actionIconsFrames[5].drawOnGraphics(paramGraphics,
											i2, bool3 + bool6, 3);
									str2 = "" + this.someUnit0.moveRange;
								}
								C_MainCanvas.sub_2007(paramGraphics, str2,
										sumBool + bool13 + 1, bool3 + bool6,
										0, 6);
								if (i3 > 0) {
									theGame.arrowIconsSprite.drawFrame(paramGraphics, 1, i2
											+ bool5 - bool6 - 1, bool3 + bool6, 10);
								} else if (i3 < 0) {
									theGame.arrowIconsSprite.drawFrame(paramGraphics, 2, i2
											+ bool5 - bool6 - 1, bool3 + bool6, 10);
								}
								sumBool += bool5 + var_ff2;
							}
						}
						bool3 += bool13;
					}
					bool3 += var_ff2;
					paramGraphics.setColor(this.someGrayColor);
					paramGraphics.drawLine(someYVal, bool3, someXVal - someYVal - someYVal,
							bool3);
					break;
				case 3:
					paramGraphics.setClip(0, 0, someXVal, someYVal);
					bool3 = var_ff2;
					paramGraphics.setColor(11515819);
					paramGraphics.drawLine(var_ff2, bool3, someXVal - (var_ff2 << 1),
							bool3);
					bool3 = bool3 + (1 + var_ff2) + theGame.bigCircleSprite.spriteFrameHeight / 2;
					int sumB;
					sumB = theGame.sideArrowSprite.spriteFrameWidth + this.var_10e2
							+ this.var_1122;
					j = this.var_10ca;
					i3 = this.var_10ca + this.var_10d2;
					if (this.var_10e2 > 0) {
						j--;
						sumB -= this.listItemHeightMb;
					} else if (this.var_10e2 < 0) {
						i3++;
					}
					for (i4 = j; i4 < i3; i4++) {
						if ((bool5 = i4 % this.var_1062) < 0) {
							bool5 += this.var_1062;
						}
						m = sumB + this.listItemHeightMb / 2;
						if (bool5 == this.var_105a) {
							theGame.bigCircleSprite.drawFrame(paramGraphics, 1, m, bool3,
									3);
						} else {
							theGame.bigCircleSprite.drawFrame(paramGraphics, 0, m, bool3,
									3);
						}
						A_Unit localClass_a_0260 = this.someUnits[bool5];
						int theXpos = m - localClass_a_0260.pixelX - localClass_a_0260.spriteFrameWidth / 2; //m
						int theYPos = bool3 - localClass_a_0260.pixelY - localClass_a_0260.spriteFrameHeight //n p
								/ 2;
						localClass_a_0260
								.sub_28fa(
										paramGraphics,
										theXpos,
										theYPos,
										localClass_a_0260.cost > theGame.var_486a[theGame.currentPlayerId]);
						if (bool5 == this.var_105a) {
							k = m - this.bigCircleSprite.spriteFrameWidth / 2;
							int bool11int = bool3 - this.bigCircleSprite.spriteFrameWidth / 2;
							for (int bool10int = 0; bool10int < this.threeSmallSparksSprites.length; bool10int++) {
								this.threeSmallSparksSprites[bool10int].drawCurrentFrame(paramGraphics, k,
										bool11int, 20);
							}
						}
						sumB += this.listItemHeightMb;
					}
					theGame.sideArrowSprite.drawFrame(paramGraphics, 0, 0, bool3, 6);
					theGame.sideArrowSprite.drawFrame(paramGraphics, 1, someXVal, bool3, 10);
					break;
				case 7:
				case 10:
				case 11:
					paramGraphics.setFont(C_MainCanvas.theFont);
					if (this.var_10c2 != -1) {
						theGame.portraitsSprite.drawFrame(paramGraphics, this.var_10c2,
								-8, j, 36);
					}
					someXVal -= this.var_10da;
					paramGraphics.setClip(0, 0, i, this.mapPrevPixelHeight - 10);
					bool5 = 0;
					bool3 = 0;
					if (this.var_10ea != null) {
						paramGraphics.setColor(G_Game.getLinearGradientStepMb(16777215,
								this.var_11aa, this.var_1132, 5));
						for (i4 = 0; i4 < this.var_10ea.length; i4++) {
							C_MainCanvas.showString(paramGraphics, this.var_10ea[i4],
									this.var_10da + i / 2, bool3 + this.var_10ba,
									17);
							bool3 += this.listItemHeightMb;
						}
						paramGraphics.setColor(10463131);
						paramGraphics.drawLine(0, bool3, i - 1, bool3);
						bool5 = bool3;
					}
					i4 = bool3 + this.var_1122;
					paramGraphics.setColor(this.someGrayColor);
					int intbool10 = this.var_10ca;
					int intparamBoolean = this.var_10ca + this.var_10d2;
					if (this.var_10e2 > 0) {
						intbool10--;
						bool3 -= this.listItemHeightMb;
					} else if (this.var_10e2 < 0) {
						intparamBoolean++;
					}
					bool3 += this.var_10e2 + this.var_1122;
					paramGraphics.setClip(this.var_10da, bool5, i, j - bool5);
					k = i;
					if (this.var_113a) {
						k = i - theGame.arrowSprite.spriteFrameWidth;
					}
					m = this.var_10da + k / 2;
					for (bool9 = intbool10; bool9 < intparamBoolean; bool9++) {
						bool5 = 0;
						if (bool3 < i4) {
							bool5 = i4 - bool3;
						} else if (bool3 + this.listItemHeightMb > j - this.var_1122) {
							bool5 = bool3 + this.listItemHeightMb - j + this.var_1122;
						}
						if ((this.typeMB == 11) && (bool9 == this.var_105a)) {
							paramGraphics.setColor(5594742);
							drawRoundedRect(paramGraphics, 0, bool3, k, this.listItemHeightMb);
							bool7 = G_Game.getLinearGradientStepMb(this.var_11aa, 16777215,
									this.listItemHeightMb - bool5, this.listItemHeightMb);
						} else {
							bool7 = G_Game.getLinearGradientStepMb(this.var_11aa,
									this.someGrayColor, this.listItemHeightMb - bool5,
									this.listItemHeightMb);
						}
						bool7 = G_Game.getLinearGradientStepMb(bool7, this.var_11aa,
								this.var_1132, 5);
						paramGraphics.setColor(bool7);
						if (this.var_11ea >= 0) {
							C_MainCanvas.showString(paramGraphics,
									this.menuActionsListString[bool9], this.var_11ea, bool3
											+ this.var_10ba, 20);
						} else {
							C_MainCanvas.showString(paramGraphics,
									this.menuActionsListString[bool9], m, bool3 + this.var_10ba,
									17);
						}
						bool3 += this.listItemHeightMb;
					}
					if (this.var_113a) {
						int i1 = theGame.arrowSprite.spriteFrameHeight;
						bool5 = theGame.arrowSprite.spriteFrameWidth;
						bool7 = theGame.arrowSprite.spriteFrameWidth / 2;
						intparamBoolean = j - (i1 << 1) - 2;
						bool3 = i - (bool5 + bool7) / 2;
						if (intparamBoolean > 1) {
							paramGraphics.setColor(this.someGrayColor);
							drawRoundedRect(paramGraphics, bool3, i1 + 1, bool7,
									intparamBoolean);
							if ((k = (intparamBoolean - 1) * this.var_10d2
									/ this.var_1062) <= 0) {
								k = 1;
							}
							paramGraphics.setColor(2370117);
							drawRoundedRect(paramGraphics, bool3 + 1, i1
									+ (intparamBoolean - 1) * this.var_10ca
									/ this.var_1062 + 2, bool7 - 1, k);
							theGame.arrowSprite.drawFrame(paramGraphics, 0, i - bool5,
									0, 20);
							theGame.arrowSprite.drawFrame(paramGraphics, 1, i - bool5,
									j, 36);
						} else {
							if (this.var_10ca > 0) {
								theGame.arrowSprite.drawFrame(paramGraphics, 0, i
										- bool5, 0, 20);
							}
							if (this.var_10ca + this.var_10d2 < this.var_1062) {
								theGame.arrowSprite.drawFrame(paramGraphics, 1, i
										- bool5, j, 36);
							}
						}
					}
					if (this.typeMB != 7) {
						break;
					}
					paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
					int i1 = j;
					if ((this.var_1092 & 0x2) == 0) {
						i1 = j + 5;
					}
					theGame.arrowSprite.drawFrame(paramGraphics, 1, i + this.var_10da,
							i1, 40);
					break;
				case 8:
					G_Game.drawRectBar(paramGraphics, 0, 0, this.mapPrevPixelWidth,
							this.mapPrevPixelHeight);
					bool11 = theGame.smallTilesFrames[0].imageWidth;
					bool10 = theGame.smallTilesFrames[0].imageHeight;
					i4 = this.maxSmallTilesInViewPortHeight + this.var_116a;
					i3 = this.maxSmallTilesInViewPortWidth + this.var_1162;
					bool3 = 1;
					int  bool8;
					for (m = this.var_116a; m < i4; m++) {
						intparamBoolean = 1;
						for (k = this.var_1162; k < i3; k++) {
							bool8 = theGame.tilesDefs[this.theMapData[k][m]];
							if (G_Game.tileCanBeOccupied(this.theMapData[k][m])) {
								bool5 = (this.theMapData[k][m] - 37) / 2;
								bool8 = bool5 * 1 + 8 + bool8 - 8;
							}
							theGame.smallTilesFrames[bool8].drawOnGraphics(paramGraphics,
									intparamBoolean, bool3);
							intparamBoolean += bool11;
						}
						bool3 += bool10;
					}
					if ((this.var_118a != null) && (this.var_106a == 0)) {
						m = -this.var_1162 * bool11 + 4;
						k = -this.var_116a * bool10 + 4;
						bool8 = 0;
						bool5 = theGame.mapUnitsMaybe.size();
						while (bool8 < bool5) {
							A_Unit paramBooleanCl;
							if (((paramBooleanCl = (A_Unit) theGame.mapUnitsMaybe
									.elementAt(bool8)).posX >= this.var_1162)
									&& (paramBooleanCl.posX < i3)
									&& (paramBooleanCl.posY >= this.var_116a)
									&& (paramBooleanCl.posY < i4)) {
								theGame.miniIconsSprite
										.drawFrame(
												paramGraphics,
												theGame.var_4832[paramBooleanCl.teamId] - 1,
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
						theGame.arrowSprite.drawFrame(paramGraphics, 0, i / 2, 0, 17);
					}
					if (this.var_116a + this.maxSmallTilesInViewPortHeight < this.mapHeight) {
						theGame.arrowSprite.drawFrame(paramGraphics, 1, i / 2, j, 33);
					}
					if (this.var_1162 > 0) {
						theGame.sideArrowSprite.drawFrame(paramGraphics, 0, 0, j / 2, 6);
					}
					if (this.var_1162 + this.maxSmallTilesInViewPortWidth >= this.mapWidth) {
						break;
					}
					theGame.sideArrowSprite.drawFrame(paramGraphics, 1, i, j / 2, 10);
					break;
				case 13:
					m = C_MainCanvas.var_1767;
					k = (this.mapPrevPixelHeight - m) / 2;
					paramGraphics.setColor(G_Game.getLinearGradientStepMb(1645370, 16777215,
							this.var_1132, 5));
					drawRoundedRect(paramGraphics, 0, k, this.mapPrevPixelWidth, m);
					paramGraphics.setFont(C_MainCanvas.theFont);
					paramGraphics.setColor(16777215);
					C_MainCanvas
							.showString(paramGraphics, this.menuActionsListString[this.var_105a],
									16, k + this.var_10ba, 20);
					n = this.mapPrevPixelWidth - this.listItemHeightMb;
					bool5 = this.var_1062 - 1;
			}
			while (bool5 > 0) {
				if (bool5 == this.var_105a) {
					theGame.smallCircleSprite.drawFrame(paramGraphics, 1, n, 0, 20);
				} else {
					theGame.smallCircleSprite.drawFrame(paramGraphics, 0, n, 0, 20);
				}
				this.someImages[bool5].drawOnGraphics(paramGraphics, n
						+ theGame.smallCircleSprite.spriteFrameWidth / 2, this.mapPrevPixelHeight / 2, 3);
				n -= this.listItemHeightMb;
				bool5--;
				//continue;@todo
				paramGraphics.setFont(C_MainCanvas.theFont);
				paramGraphics.setColor(G_Game.getLinearGradientStepMb(16777215, 1645370,
						this.var_1132, 5));
				k = j / 2;
				C_MainCanvas.showString(paramGraphics,
						this.menuActionsListString[this.var_105a], i / 2,
						(j - C_MainCanvas.fontBaselinePos) / 2, 17);
				theGame.sideArrowSprite.drawFrame(paramGraphics, 0, 0, k, 6);
				theGame.sideArrowSprite.drawFrame(paramGraphics, 1, i, k, 10);
				//break;@todo
				m = 0;
				bool3 = 0;
				bool5 = this.var_11da[0];
				for (j = 1; j <= this.var_11ca; j++) {
					m = bool5;
					bool5 += this.var_11da[j];
				}
				if (this.var_11ca > 0) {
					bool3 = -m + theGame.buttonsSprite.spriteFrameHeight;
				}
				for (j = 0; j < this.childrenMenu.size(); j++) {
					E_Menu intparamBoolean;
					if (((intparamBoolean = (E_Menu) this.childrenMenu
							.elementAt(j)).menuTopY >= m)
							&& (intparamBoolean.menuTopY < bool5)) {
						intparamBoolean.sub_349e(paramGraphics, 0, bool3,
								j == this.var_114a);
					}
				}
				paramGraphics.setClip(0, 0, theGame.someCanWidth,
						theGame.someCanHeight);
				if (this.var_11ca > 0) {
					paramGraphics.setColor(2370117);
					paramGraphics.fillRect(0, 0, this.canvasWidth,
							theGame.buttonsSprite.spriteFrameHeight);
					theGame.arrowSprite.drawFrame(paramGraphics, 0,
							theGame.someCanWidth / 2, -this.var_106a, 17);
				}
				if (this.var_11ca < this.var_11d2) {
					paramGraphics.setColor(2370117);
					j = this.var_11da[this.var_11ca];
					if (this.var_11ca > 0) {
						j += theGame.buttonsSprite.spriteFrameHeight;
					}
					paramGraphics.fillRect(0, j, this.canvasWidth,
							theGame.someCanHeight - j);
					theGame.arrowSprite.drawFrame(paramGraphics, 1,
							theGame.someCanWidth / 2, theGame.someCanHeight
									+ this.var_106a, 33);
				}
			}
			paramGraphics.translate(-paramInt1, -paramInt2);
			paramGraphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			if ((F_StringManager.mainCanvas.var_17b7 == this) && (this.var_1002 == 2)) {
				if (this.var_fe2[0] != false) {
					theGame.drawButtonIcon(paramGraphics, G_Game.var_4602, 0,
							theGame.someCanHeight);
				}
				if (this.var_fe2[1] != false) {
					theGame.drawButtonIcon(paramGraphics, G_Game.var_460a, 1,
							theGame.someCanHeight);
				}
			}
		}
	}

	public static final void sub_5066(Graphics graphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
		sub_5092(graphics, 0, paramInt2, paramInt3, paramInt4, paramInt5,
				2370117, 2370117, 0, 0); //#242A45 dark blue
	}

	public static final void sub_5092(Graphics graphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int inColor1, int inColor2, int paramInt8, int paramInt9) {
		G_Sprite menuSprite = theGame.menuSprite;
		graphics.setClip(paramInt1, paramInt2, paramInt3, paramInt4);
		graphics.setColor(inColor1);
		graphics.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
		int i;
		int j;
		int k;
		int m;
		if (inColor2 != inColor1) {
			i = paramInt4 / 4;
			j = paramInt2 + 5;
			for (int it = 0; it < i; it++) {
				m = G_Game.getLinearGradientStepMb(inColor2, inColor1, it, i);
				graphics.setColor(G_Game.getLinearGradientStepMb(m, inColor1,
						paramInt8, paramInt9));
				graphics.fillRect(paramInt1, j, paramInt3, 1);
				j++;
			}
		}
		if (paramInt5 != 15) {
			i = (paramInt5 & 0x4) == 0 ? 1 : 0;
			j = (paramInt5 & 0x8) == 0 ? 1 : 0;
			k = (paramInt5 & 0x1) == 0 ? 1 : 0;
			m = (paramInt5 & 0x2) == 0 ? 1 : 0;
			paramInt5 = paramInt3 / menuSprite.spriteFrameWidth - 2;
			if (paramInt3 % menuSprite.spriteFrameWidth != 0) {
				paramInt5++;
			}
			if (i == 0) {
				paramInt5++;
			}
			if (j == 0) {
				paramInt5++;
			}
			inColor1 = paramInt4 / menuSprite.spriteFrameHeight - 2;
			if (paramInt4 % menuSprite.spriteFrameHeight != 0) {
				inColor1++;
			}
			if (k == 0) {
				inColor1++;
			}
			if (m == 0) {
				inColor1++;
			}
			inColor2 = paramInt1;
			if (i != 0) {
				inColor2 = paramInt1 + menuSprite.spriteFrameWidth;
			}
			paramInt4 = paramInt2 + paramInt4 - menuSprite.spriteFrameHeight;
			for (paramInt8 = 0; paramInt8 < paramInt5; paramInt8++) {
				if (k != 0) {
					menuSprite.drawFrame(graphics, 1, inColor2,
							paramInt2, 0);
				}
				if (m != 0) {
					menuSprite.drawFrame(graphics, 6, inColor2,
							paramInt4, 0);
				}
				inColor2 += menuSprite.spriteFrameWidth;
			}
			paramInt8 = paramInt2;
			if (k != 0) {
				paramInt8 = paramInt2 + menuSprite.spriteFrameHeight;
			}
			paramInt3 = paramInt1 + paramInt3 - menuSprite.spriteFrameWidth;
			for (int it = 0; it < inColor1; it++) {
				if (i != 0) {
					menuSprite.drawFrame(graphics, 3, paramInt1,
							paramInt8, 0);
				}
				if (j != 0) {
					menuSprite.drawFrame(graphics, 4, paramInt3,
							paramInt8, 0);
				}
				paramInt8 += menuSprite.spriteFrameHeight;
			}
			if ((i != 0) && (k != 0)) {
				menuSprite.drawFrame(graphics, 0, paramInt1,
						paramInt2, 0);
			}
			if ((j != 0) && (k != 0)) {
				menuSprite.drawFrame(graphics, 2, paramInt3,
						paramInt2, 0);
			}
			if ((i != 0) && (m != 0)) {
				menuSprite.drawFrame(graphics, 5, paramInt1,
						paramInt4, 0);
			}
			if ((j != 0) && (m != 0)) {
				menuSprite.drawFrame(graphics, 7, paramInt3,
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