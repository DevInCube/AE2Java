package aeii;

import a.a.a.G_Sprite;
import java.util.Random;
import javax.microedition.lcdui.Graphics;

public final class H_FightAnimation {

	private static String[] tileNamesStrings = { "road", "grass", "woods", "hill",
			"mountain", "water", "bridge", "town" };
	private static byte[] var_b27 = { 0, 1, 1, 1, 4, 5, 6, 7, 7, 7 };
	private static byte[] var_b2f = { 0, 1, 2, 3, 4, 5, 6, 7, 7, 7 };
	private static String[] var_b37 = { "soldier", "archer", "lizard",
			"wizard", "wisp", "spider", "golem", "catapult", "wyvern", "king",
			"skeleton" };
	private G_Game game;
	public A_Unit someUnit1;
	private byte someUnit1Type;
	public boolean var_b57 = false;
	public boolean var_b5f = false;
	private boolean var_b67;
	private byte someUnit1Health;
	public byte var_b77;
	private byte var_b7f;
	public byte var_b87;
	private byte var_b8f;
	private byte var_b97;
	private boolean var_b9f;
	private int var_ba7 = 0;
	private static byte[] var_baf = { 3, -3 };
	private G_Sprite var_bb7;
	private G_Sprite var_bbf;
	private G_Sprite var_bc7;
	private G_Sprite var_bcf;
	private int var_bd7;
	private int var_bdf;
	private long var_be7;
	private long var_bef;
	private G_Sprite[] var_bf7;
	private D_ImageWrap[] someImagesArr;
	private D_ImageWrap fightAnimBackgroundImage;
	public H_FightAnimation hclass;
	private int unitPosTileType;
	private int var_c1f;
	private int var_c27;
	private int var_c2f;
	private boolean var_c37 = false;
	private int var_c3f;
	private int var_c47;
	private int[][] var_c4f;
	private int[] var_c57;
	private int var_c5f;
	private int var_c67 = 20;
	private int var_c6f;
	private int var_c77;
	private byte[][] var_c7f;
	private G_Sprite var_c87;
	private G_Sprite var_c8f;
	private G_Sprite[] var_c97;
	private int var_c9f;
	private int var_ca7;

	public H_FightAnimation(G_Game game, A_Unit unit, H_FightAnimation hclass) {
		this.game = game;
		this.someUnit1 = unit;
		this.someUnit1Type = unit.unitType;
		this.hclass = hclass;
		this.someUnit1Health = ((byte) unit.health);
		this.var_c3f = this.someUnit1Health;
		this.var_b7f = ((byte) unit.getSomeHealthManipulationVal());
		this.var_b8f = this.var_b7f;
		int someCanWidthShoftLocal = 0;
		if (hclass == null) {
			this.var_b97 = 0;
			this.var_bd7 = 0;
			this.var_b9f = true;
		} else {
			someCanWidthShoftLocal = game.someCanWidthShift;
			this.var_b97 = 1;
			this.var_ba7 = 0;
		}
		this.unitPosTileType = game.getMapTileType(unit.posX,
				unit.posY);
		int tileTypeValue1 = var_b2f[this.unitPosTileType];
		int tileTypeValue2 = var_b27[this.unitPosTileType];
		if ((hclass != null)
				&& (tileTypeValue2 == var_b27[hclass.unitPosTileType])) {
			this.someImagesArr = new D_ImageWrap[hclass.someImagesArr.length];
			System.arraycopy(hclass.someImagesArr, 0, this.someImagesArr, 0,
					this.someImagesArr.length);
		} else {
			this.someImagesArr = new G_Sprite(tileNamesStrings[tileTypeValue2]).frameImages;
		}
		if (this.var_b97 == 1) {
			for (int it = 0; it < this.someImagesArr.length; it++) {
				this.someImagesArr[it] = new D_ImageWrap(this.someImagesArr[it], 1);
			}
		}
		try {
			if ((hclass != null)
					&& (tileTypeValue1 == var_b2f[hclass.unitPosTileType])) {
				this.fightAnimBackgroundImage = hclass.fightAnimBackgroundImage;
			} else {
				this.fightAnimBackgroundImage = new D_ImageWrap(tileNamesStrings[tileTypeValue1] + "_bg");
			}
			if (this.var_b97 == 1) {
				this.fightAnimBackgroundImage = new D_ImageWrap(this.fightAnimBackgroundImage, 1);
			}
		} catch (Exception ex) {
			//
		}
		if (this.fightAnimBackgroundImage != null) {
			this.var_c1f = this.fightAnimBackgroundImage.imageHeight;
		}
		this.var_c27 = (game.someCanWidthShift / this.someImagesArr[0].imageWidth);
		if (game.someCanWidthShift % this.someImagesArr[0].imageWidth != 0) {
			this.var_c27 += 1;
		}
		this.var_c2f = ((game.var_4eba - this.var_c1f) / this.someImagesArr[0].imageHeight);
		if ((game.var_4eba - this.var_c1f)
				% this.someImagesArr[0].imageHeight != 0) {
			this.var_c2f += 1;
		}
		this.var_c7f = new byte[this.var_c27][this.var_c2f];
		for (tileTypeValue2 = 0; tileTypeValue2 < this.var_c27; tileTypeValue2++) {
			for (tileTypeValue1 = 0; tileTypeValue1 < this.var_c2f; tileTypeValue1++) {
				this.var_c7f[tileTypeValue2][tileTypeValue1] = ((byte) Math.abs(C_MainCanvas.random
						.nextInt() % this.someImagesArr.length));
			}
		}
		this.var_bb7 = new G_Sprite(var_b37[this.someUnit1Type],
				game.var_4832[unit.teamId]);
		if ((hclass != null)
				&& (hclass.someUnit1Type == this.someUnit1Type)) {
			if (hclass.var_bcf != null) {
				this.var_bcf = new G_Sprite(hclass.var_bcf);
			}
			if (hclass.var_bbf != null) {
				this.var_bbf = new G_Sprite(hclass.var_bbf);
			}
			if (hclass.var_bc7 != null) {
				this.var_bc7 = new G_Sprite(hclass.var_bc7);
			}
			if (hclass.var_c87 != null) {
				this.var_c87 = new G_Sprite(hclass.var_c87);
				this.var_c8f = new G_Sprite(hclass.var_c8f);
			}
		} else if ((this.someUnit1Type != 0) && (this.someUnit1Type != 10)
				&& (this.someUnit1Type != 5)) {
			if (this.someUnit1Type == 1) {
				this.var_bc7 = new G_Sprite("archer_arrow");
			} else if (this.someUnit1Type == 9) {
				this.var_bbf = new G_Sprite("kingwave");
				this.var_bcf = new G_Sprite("kingslash");
				this.var_c87 = new G_Sprite("king_heads");
				this.var_c8f = new G_Sprite("king_heads_back");
			} else if (this.someUnit1Type == 2) {
				this.var_bbf = new G_Sprite("watermagic");
				this.var_bc7 = new G_Sprite("fish");
			} else if ((this.someUnit1Type != 7) && (this.someUnit1Type != 6)) {
				if (this.someUnit1Type == 3) {
					this.var_bbf = new G_Sprite("spell");
					this.var_bc7 = this.var_bbf;
				}
			} else {
				this.var_bc7 = new G_Sprite("crater");
			}
		} else {
			this.var_bcf = new G_Sprite("slash");
		}
		if (this.var_bbf != null) {
			this.var_bbf.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.var_bc7 != null) {
			this.var_bc7.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.var_bcf != null) {
			this.var_bcf.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.var_c87 != null) {
			this.var_c87.setFrameSequenceByIndex(unit.var_eeb, this.var_b9f);
			this.var_c87.setCurrentFrameIndex(unit.var_eeb);
			this.var_c8f.setFrameSequenceByIndex(0, this.var_b9f);
			this.var_c8f.setCurrentFrameIndex(unit.var_eeb);
		}
		this.var_c4f = new int[unit.chars.length][2];
		for (tileTypeValue2 = 0; tileTypeValue2 < this.var_c4f.length; tileTypeValue2++) {
			this.var_c4f[tileTypeValue2][0] = (unit.chars[tileTypeValue2][0]
					* game.canvasWidth / 128); 
			if (this.var_b97 == 1) {
				this.var_c4f[tileTypeValue2][0] = (game.someCanWidthShift
						- this.var_c4f[tileTypeValue2][0] - this.var_bb7.spriteFrameWidth + someCanWidthShoftLocal);
			}
			this.var_c4f[tileTypeValue2][1] = (unit.chars[tileTypeValue2][1]
					* game.var_4eba / 128 - this.var_bb7.spriteFrameHeight);
		}
		this.var_bf7 = new G_Sprite[this.var_b7f];
		if ((this.someUnit1Type == 4) || (this.someUnit1Type == 6)) {
			this.var_c57 = new int[this.var_b7f];
		}
		for (tileTypeValue2 = 0; tileTypeValue2 < this.var_b7f; tileTypeValue2++) {
			this.var_bf7[tileTypeValue2] = new G_Sprite(this.var_bb7);
			game.addSomeSprite(this.var_bf7[tileTypeValue2]);
			this.var_bf7[tileTypeValue2].setPixelPosition(this.var_c4f[tileTypeValue2][0], this.var_c4f[tileTypeValue2][1]);
			this.var_bf7[tileTypeValue2].setFrameSequenceByIndex(0, this.var_b9f);
			this.var_bf7[tileTypeValue2].var_c80 = false;
			this.var_bf7[tileTypeValue2].var_c68 = 0;
			if (this.someUnit1Type == 6) {
				this.var_bf7[tileTypeValue2].var_ca0 = true;
				this.var_c57[tileTypeValue2] = C_MainCanvas.getRandomMax(360);
				this.var_bf7[tileTypeValue2].var_c38 = (-6 + 4
						* F_StringManager.sub_f0f(this.var_c57[tileTypeValue2]) >> 10);
			} else if (this.someUnit1Type == 4) {
				this.var_bf7[tileTypeValue2].var_ca0 = true;
				this.var_bf7[tileTypeValue2].var_c38 = (-5 - C_MainCanvas.getRandomMax(10));
				this.var_c57[tileTypeValue2] = C_MainCanvas.getRandomMax(360);
			} else if (this.someUnit1Type == 9) {
				this.var_bf7[tileTypeValue2].var_cc0 = this.var_c87;
				this.var_bf7[tileTypeValue2].var_cc8 = this.var_c8f;
			}
		}
	}

	private int sub_1640(G_Sprite paramClass_g_2517, int paramInt) {
		if (this.var_b97 == 1) {
			return this.var_bb7.spriteFrameWidth - paramInt - paramClass_g_2517.spriteFrameWidth;
		}
		return paramInt;
	}

	public final void sub_1688() {
		this.var_b57 = true;
		this.var_ba7 = 1;
		this.var_bef = this.game.var_479a;
	}

	public final void sub_16b8() {
		if ((this.var_b67) && (this.var_c3f > this.var_b77)) {
			this.var_c3f -= 2;
			if (this.var_c3f < this.var_b77) {
				this.var_c3f = this.var_b77;
			}
			this.game.var_4eb2 = true;
		}
		int k;
		int i3;
		if ((this.someUnit1Type != 8) && (this.someUnit1Type != 9) && (this.someUnit1Type != 7)
				&& (this.someUnit1Type != 1) && (this.someUnit1Type != 3)
				&& (this.someUnit1Type != 2) && (this.someUnit1Type != 6)) {
			if (this.someUnit1Type == 4) {
				H_FightAnimation localClass_h_04171 = this;
				switch (this.var_ba7) {
				case 1:
					if (localClass_h_04171.var_c6f == 0) {
						if (localClass_h_04171.game.var_479a
								- localClass_h_04171.var_bef >= 200L) {
							localClass_h_04171.var_c6f = 1;
							localClass_h_04171.var_bef = localClass_h_04171.game.var_479a;
						}
					} else {
						Object localObject;
						if (localClass_h_04171.var_c6f == 1) {
							localClass_h_04171.var_c67 += 5;
							if (localClass_h_04171.var_c67 >= 90) {
								localClass_h_04171.var_c6f += 1;
								localClass_h_04171.var_bef = localClass_h_04171.game.var_479a;
							}
							if ((localClass_h_04171.var_c67 - 20) % 15 == 0) {
								for (k = 0; k < localClass_h_04171.var_bf7.length; k++) {
									G_Sprite clas;
									(clas = G_Sprite
											.sub_2054(
													localClass_h_04171.game.bSmokeSprite,
													C_MainCanvas
															.getRandomWithin(-1, 2),
													0, 0, 1, 100, (byte) 0))
											.setPixelPosition(
													localClass_h_04171.var_bf7[k].pixelX
															+ C_MainCanvas
																	.getRandomMax(localClass_h_04171.var_bb7.spriteFrameWidth
																			- ((G_Sprite) clas).spriteFrameWidth),
													localClass_h_04171.var_bf7[k].pixelY
															+ localClass_h_04171.var_bb7.spriteFrameHeight
															- ((G_Sprite) clas).spriteFrameHeight
															+ 1);
									localClass_h_04171.game
											.addSomeSprite((G_Sprite) clas);
								}
							}
						} else if ((localClass_h_04171.var_c6f == 2)
								&& (localClass_h_04171.game.var_479a
										- localClass_h_04171.var_bef >= 400L)) {
							localClass_h_04171.var_c67 = 20;
							localClass_h_04171.hclass.sub_331c();
							localClass_h_04171.var_ba7 = 4;
							localClass_h_04171.hclass.var_c37 = false;
							localClass_h_04171.var_bef = localClass_h_04171.game.var_479a;
						}
						if (++localClass_h_04171.var_c5f >= 2) {
							for (k = 0; k < localClass_h_04171.hclass.var_bf7.length; k++) {
								G_Sprite clas;
								(clas = G_Sprite.sub_2054(
										localClass_h_04171.game.redsparkSprite, 0,
										0, 0, 1, 50, (byte) 0))
										.setPixelPosition(
												localClass_h_04171.hclass.var_bf7[k].pixelX
														+ C_MainCanvas
																.getRandomMax(localClass_h_04171.hclass.var_bf7[k].spriteFrameWidth
																		- ((G_Sprite) clas).spriteFrameWidth),
												localClass_h_04171.hclass.var_bf7[k].pixelY
														+ C_MainCanvas
																.getRandomMax(localClass_h_04171.hclass.var_bf7[k].spriteFrameHeight
																		- ((G_Sprite) clas).spriteFrameHeight));
								((G_Sprite) clas).var_c88 = true;
								localClass_h_04171.game
										.addSomeSprite((G_Sprite) clas);
							}
							localClass_h_04171.var_c5f = 0;
							localObject = localClass_h_04171.hclass;
							for (int i2 = 0; i2 < ((H_FightAnimation) localObject).var_b8f; i2++) {
								((H_FightAnimation) localObject).var_bf7[i2].var_c90 = 6;
							}
						}
					}
					break;
				case 4:
					if (localClass_h_04171.game.var_479a
							- localClass_h_04171.var_bef >= 800L) {
						localClass_h_04171.var_b5f = true;
						localClass_h_04171.var_ba7 = 0;
					}
					break;
				}
				k = 0;
				if (localClass_h_04171.game.var_479a
						- localClass_h_04171.var_be7 >= 300L) {
					k = 1;
					localClass_h_04171.var_be7 = localClass_h_04171.game.var_479a;
				}
				for (int n = 0; n < localClass_h_04171.var_bf7.length; n++) {
					if (k != 0) {
						G_Sprite localClass_g_25173;
						(localClass_g_25173 = G_Sprite.sub_2054(null, 0, 0,
								0, 1, 500, (byte) 4))
								.setPixelPosition(
										localClass_h_04171.var_bf7[n].pixelX
												+ (localClass_h_04171.var_bf7[n].spriteFrameWidth >> 1),
										localClass_h_04171.var_bf7[n].pixelY
												+ (localClass_h_04171.var_bf7[n].spriteFrameHeight >> 1)
												+ localClass_h_04171.var_bdf);
						localClass_h_04171.game
								.addSomeSprite(localClass_g_25173);
					}
					i3 = localClass_h_04171.var_bf7[n].spriteFrameWidth / 3;
					localClass_h_04171.var_bf7[n]
							.setPixelPosition(
									localClass_h_04171.var_c4f[n][0]
											+ (i3
													* F_StringManager
															.sub_f35(localClass_h_04171.var_c57[n]) >> 10),
									localClass_h_04171.var_c4f[n][1]
											+ (i3
													* F_StringManager
															.sub_f0f(localClass_h_04171.var_c57[n])
													/ 3 >> 10));
					localClass_h_04171.var_c57[n] = ((localClass_h_04171.var_c57[n] + localClass_h_04171.var_c67) % 360);
				}
			} else {
				int i;
				switch (this.var_ba7) {
				case 1:
					if (this.game.var_479a - this.var_bef >= 200L) {
						this.var_ba7 = 3;
					}
				case 2:
				case 5:
				default:
					break;
				case 3:
					i = 1;
					G_Sprite localClass_g_25172;
					if (this.var_c6f < this.var_b8f) {
						if ((this.someUnit1Type == 0) || (this.someUnit1Type == 5)) {
							this.var_bf7[this.var_c6f].var_c70 = -6;
						}
						if (this.someUnit1Type == 5) {
							this.var_bf7[this.var_c6f].var_c60 = (2 * var_baf[this.var_b97]);
							for (k = 0; k < 3; k++) {
								(localClass_g_25172 = G_Sprite.sub_2054(
										this.game.bSmokeSprite,
										C_MainCanvas.getRandomWithin(-1, 2), 0, -1, 1,
										100, (byte) 0))
										.setPixelPosition(
												this.var_bf7[this.var_c6f].pixelX
														+ C_MainCanvas
																.getRandomMax(this.var_bb7.spriteFrameWidth
																		- localClass_g_25172.spriteFrameWidth),
												this.var_bf7[this.var_c6f].pixelY
														+ this.var_bb7.spriteFrameHeight
														- localClass_g_25172.spriteFrameHeight
														+ 1);
								this.game.addSomeSprite(localClass_g_25172);
							}
						}
						this.var_bf7[this.var_c6f].var_c60 = var_baf[this.var_b97];
						this.var_bf7[this.var_c6f].setFrameSequenceByIndex(1, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (k = 0; k < this.var_c6f; k++) {
						if (this.someUnit1Type == 10) {
							if (this.var_bf7[k].var_ca8 != -1) {
								this.var_bf7[k].var_ca8 += 1;
								if (this.var_bf7[k].var_ca8 >= 16) {
									this.var_bf7[k].setFrameSequenceByIndex(2, this.var_b9f);
									this.var_bf7[k].var_c60 = 0;
									this.var_bf7[k].var_ca8 = -1;

									(localClass_g_25172 = G_Sprite
											.sub_2054(null, 0, 0, 0, 1, 800,
													(byte) 2))
											.setPixelPosition(
													this.var_bf7[k].pixelX
															+ sub_1640(
																	localClass_g_25172,
																	this.var_bb7.spriteFrameWidth),
													this.var_bf7[k].pixelY
															+ this.var_bb7.spriteFrameHeight);
									this.game.addSomeSprite(localClass_g_25172);
									(localClass_g_25172 = G_Sprite
											.sub_2054(this.var_bcf, 0, 0, 0, 1,
													150, (byte) 0)).setPixelPosition(
											this.var_bf7[k].pixelX
													+ sub_1640(
															localClass_g_25172,
															24),
											this.var_bf7[k].pixelY + 3);
									this.game.addSomeSprite(localClass_g_25172);
								} else {
									i = 0;
								}
							}
						} else if (this.var_bf7[k].var_c38 < 0) {
							this.var_bf7[k].var_c70 += 1;
							i = 0;
						} else if (this.var_bf7[k].var_c70 >= 6) {
							this.var_bf7[k].var_c38 = 0;
							this.var_bf7[k].var_c70 = 0;
							this.var_bf7[k].var_c60 = 0;
							if ((this.someUnit1Type == 0) || (this.someUnit1Type == 5)) {
								this.var_bf7[k].setFrameSequenceByIndex(2, this.var_b9f);
								if (this.someUnit1Type == 0) {
									(localClass_g_25172 = G_Sprite
											.sub_2054(this.var_bcf, 0, 0, 0, 1,
													150, (byte) 0)).setPixelPosition(
											this.var_bf7[k].pixelX
													+ sub_1640(
															localClass_g_25172,
															14),
											this.var_bf7[k].pixelY
													+ this.var_bf7[k].spriteFrameHeight);
									localClass_g_25172.var_c38 = (4 - this.var_bf7[k].spriteFrameHeight);
									this.game.addSomeSprite(localClass_g_25172);
								} else if (this.someUnit1Type == 5) {
									(localClass_g_25172 = G_Sprite
											.sub_2054(this.game.redsparkSprite, 0,
													0, 0, 1, 50, (byte) 0))
											.setPixelPosition(
													this.var_bf7[k].pixelX
															+ sub_1640(
																	localClass_g_25172,
																	this.var_bb7.spriteFrameWidth * 3 / 4),
													this.var_bf7[k].pixelY
															+ this.var_bf7[k].spriteFrameHeight);
									localClass_g_25172.var_c38 = (-localClass_g_25172.spriteFrameHeight);
									this.game.addSomeSprite(localClass_g_25172);
								}
							}
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_c6f = 0;
					this.var_ba7 = 6;
					this.hclass.sub_331c();
					this.game.sub_188ce(200);
					C_MainCanvas.sub_2af6(200);
					C_MainCanvas.playMusicLooped(14, 1);
					this.var_bef = this.game.var_479a;
					break;
				case 4:
					i = 1;
					if (this.var_c6f < this.var_b8f) {
						if ((this.someUnit1Type != 0) && (this.someUnit1Type != 2)
								&& (this.someUnit1Type != 5)) {
							if (this.someUnit1Type == 10) {
								this.var_bf7[this.var_c6f].var_ca8 = 0;
							}
						} else {
							this.var_bf7[this.var_c6f].var_c70 = -6;
						}
						if (this.someUnit1Type == 5) {
							this.var_bf7[this.var_c6f].var_c60 = (-2 * var_baf[this.var_b97]);
						} else {
							this.var_bf7[this.var_c6f].var_c60 = (-var_baf[this.var_b97]);
						}
						this.var_bf7[this.var_c6f].setFrameSequenceByIndex(3, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (k = 0; k < this.var_c6f; k++) {
						if (this.someUnit1Type == 10) {
							if (this.var_bf7[k].var_ca8 != -1) {
								this.var_bf7[k].var_ca8 += 1;
								if (this.var_bf7[k].var_ca8 >= 16) {
									this.var_bf7[k].setFrameSequenceByIndex(0, this.var_b9f);
									this.var_bf7[k].var_c60 = 0;
									this.var_bf7[k].var_ca8 = -1;
								} else {
									i = 0;
								}
							}
						} else if (this.var_bf7[k].var_c38 < 0) {
							this.var_bf7[k].var_c70 += 1;
							i = 0;
						} else if (this.var_bf7[k].var_c70 >= 6) {
							this.var_bf7[k].var_c70 = 0;
							this.var_bf7[k].var_c60 = 0;
							this.var_bf7[k].var_c38 = 0;
							this.var_bf7[k].setFrameSequenceByIndex(0, this.var_b9f);
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_b5f = true;
					this.var_ba7 = 0;
					this.var_bef = this.game.var_479a;
					break;
				}
				if (((this.someUnit1Type == 10) && (this.game.var_479a
						- this.var_bef >= 400L))
						|| (((this.someUnit1Type == 0) || (this.someUnit1Type == 2) || (this.someUnit1Type == 5)) && (this.game.var_479a
								- this.var_bef >= 50L))) {
					this.var_ba7 = 4;
				}
			}
		} else {
			//label2184:
			H_FightAnimation localClass_h_04172 = this;
			int i1;
			int m = 0; // @todo m = 0 ? i wrote this
			G_Sprite someSprite;
			switch (this.var_ba7) {
			case 1:
				G_Sprite localClass_g_25174;
				if (localClass_h_04172.someUnit1Type == 6) {
					if (localClass_h_04172.var_c6f == 0) {
						if (localClass_h_04172.game.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca8 = -1;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca0 = false;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = 0;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
								localClass_h_04172.var_ca7 = 0;
								localClass_h_04172.var_c6f = 1;
								localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
								break;
							}
						}
					} else if (localClass_h_04172.var_c6f == 1) {
						if (localClass_h_04172.game.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = -1;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
								localClass_h_04172.var_ca7 = 0;
								localClass_h_04172.var_c6f = 2;
								localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
								break;
							}
						}
					} else if (localClass_h_04172.var_c6f == 2) {
						k = 1;
						if (localClass_h_04172.game.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca8 = 0;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = 0;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7]
										.setFrameSequenceByIndex(2, localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c48 = 1;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
							}
						} else {
							k = 0;
						}
						for (i1 = 0; i1 < localClass_h_04172.var_b8f; i1++) {
							if (localClass_h_04172.var_bf7[i1].var_ca8 == 0) {
								if (localClass_h_04172.var_bf7[i1].currentFrameIndex == 1) {
									localClass_h_04172.var_bf7[i1].var_c38 = 0;
									localClass_h_04172.var_bf7[i1].var_ca8 = 1;
									C_MainCanvas.sub_2af6(200);
									localClass_h_04172.game.sub_188ce(1200);
									C_MainCanvas.playMusicLooped(14, 1);
									for (i3 = 0; i3 < 2; i3++) {
										G_Sprite localClass_g_25171;
										(localClass_g_25171 = G_Sprite
												.sub_2054(
														localClass_h_04172.game.smokeSprite,
														0,
														0,
														-1,
														1,
														C_MainCanvas
																.getRandomMax(4) * 50,
														(byte) 0))
												.setPixelPosition(
														localClass_h_04172.var_bf7[i1].pixelX
																+ C_MainCanvas
																		.getRandomMax(localClass_h_04172.var_bb7.spriteFrameWidth
																				- localClass_g_25171.spriteFrameWidth),
														localClass_h_04172.var_bf7[i1].pixelY
																+ localClass_h_04172.var_bb7.spriteFrameHeight
																- localClass_g_25171.spriteFrameHeight
																+ 2);
										localClass_g_25171.var_c88 = true;
										localClass_h_04172.game
												.addSomeSprite(localClass_g_25171);
									}
									(localClass_g_25174 = G_Sprite
											.sub_2054(
													localClass_h_04172.game.smokeSprite,
													-1,
													0,
													-1,
													1,
													C_MainCanvas.getRandomMax(4) * 50,
													(byte) 0))
											.setPixelPosition(
													localClass_h_04172.var_bf7[i1].pixelX,
													localClass_h_04172.var_bf7[i1].pixelY
															+ localClass_h_04172.var_bb7.spriteFrameHeight
															- localClass_g_25174.spriteFrameHeight
															+ 2);
									localClass_g_25174.var_c88 = true;
									localClass_h_04172.game
											.addSomeSprite(localClass_g_25174);
									(localClass_g_25174 = G_Sprite
											.sub_2054(
													localClass_h_04172.game.smokeSprite,
													1,
													0,
													-1,
													1,
													C_MainCanvas.getRandomMax(4) * 50,
													(byte) 0))
											.setPixelPosition(
													localClass_h_04172.var_bf7[i1].pixelX
															+ localClass_h_04172.var_bb7.spriteFrameWidth
															- localClass_g_25174.spriteFrameWidth,
													localClass_h_04172.var_bf7[i1].pixelY
															+ localClass_h_04172.var_bb7.spriteFrameHeight
															- localClass_g_25174.spriteFrameHeight
															+ 2);
									localClass_g_25174.var_c88 = true;
									localClass_h_04172.game
											.addSomeSprite(localClass_g_25174);
								}
								m = 0;
							} else if (localClass_h_04172.var_bf7[i1].var_ca8 != -1) {
								if (localClass_h_04172.var_bf7[i1].var_c48 > 0) {
									m = 0;
								} else if (localClass_h_04172.var_bf7[i1].var_c48 != -1) {
									if (localClass_h_04172.var_bf7[i1].var_ca8 == 1) {
										localClass_h_04172.var_bf7[i1]
												.setFrameSequenceByIndex(
														3,
														localClass_h_04172.var_b9f);
										localClass_h_04172.var_bf7[i1].var_c48 = 1;
										localClass_h_04172.var_bf7[i1].var_ca8 = 2;
										m = 0;
									} else if (localClass_h_04172.var_bf7[i1].var_ca8 == 2) {
										localClass_h_04172.var_bf7[i1].var_c38 = -6;
										localClass_h_04172.var_bf7[i1].var_ca0 = true;
										localClass_h_04172.var_bf7[i1].var_c70 = C_MainCanvas
												.getRandomWithin(-2, 3);
										localClass_h_04172.var_bf7[i1]
												.setFrameSequenceByIndex(
														0,
														localClass_h_04172.var_b9f);
										localClass_h_04172.var_bf7[i1].var_c48 = -1;
										localClass_h_04172.var_bf7[i1].var_ca8 = 3;
										m = 0;
									}
								}
							}
						}
						if (m != 0) {
							localClass_h_04172.var_c6f = 0;
							localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
							localClass_h_04172.var_ba7 = 4;
							break;
						}
					}
				} else if (localClass_h_04172.var_c6f == 0) {
					if (localClass_h_04172.game.var_479a
							- localClass_h_04172.var_bef >= 200L) {
						if (localClass_h_04172.someUnit1Type == 9) {
							localClass_h_04172.var_c97 = new G_Sprite[localClass_h_04172.var_b8f << 1];
						} else if ((localClass_h_04172.someUnit1Type != 7)
								&& (localClass_h_04172.someUnit1Type != 1)) {
							localClass_h_04172.var_c97 = new G_Sprite[localClass_h_04172.var_b8f];
						}
						localClass_h_04172.var_c6f = 1;
						localClass_h_04172.var_ca7 = 0;
						localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
						break;
					}
				} else if (localClass_h_04172.var_c6f == 1) {
					m = 1;
					if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
						localClass_h_04172.var_bf7[localClass_h_04172.var_ca7]
								.setFrameSequenceByIndex(2, localClass_h_04172.var_b9f);
						localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c48 = 1;
						if ((localClass_h_04172.someUnit1Type != 3)
								&& (localClass_h_04172.someUnit1Type != 2)) {
							if (localClass_h_04172.someUnit1Type == 1) {
								(someSprite = G_Sprite.sub_2054(
										localClass_h_04172.var_bc7, 0, 0, 0, 1,
										0, (byte) 0)).setFrameSequenceByIndex(1,
										localClass_h_04172.var_b9f);
								someSprite
										.setPixelPosition(
												localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelX
														+ localClass_h_04172
																.sub_1640(
																		someSprite,
																		localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].spriteFrameWidth),
												localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelY);
								localClass_h_04172.game
										.addSomeSprite(someSprite);
							} else {
								if (localClass_h_04172.someUnit1Type == 7) {
									localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c90 = 5;
									for (i1 = 0; i1 < 3; i1++) {
										(localClass_g_25174 = G_Sprite
												.sub_2054(
														localClass_h_04172.game.bSmokeSprite,
														C_MainCanvas.getRandomWithin(
																-1, 2),
														0,
														0,
														1,
														C_MainCanvas
																.getRandomMax(4) * 50,
														(byte) 0))
												.setPixelPosition(
														localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelX
																+ localClass_h_04172.var_bb7.spriteFrameWidth
																/ 2,
														localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelY);
										localClass_g_25174.var_c88 = true;
										localClass_h_04172.game
												.addSomeSprite(localClass_g_25174);
									}
								}
								if (localClass_h_04172.someUnit1Type == 9) {
									(someSprite = G_Sprite
											.sub_2054(
													localClass_h_04172.var_bcf,
													0, 0, 0, 1, 200, (byte) 0))
											.setPixelPosition(
													localClass_h_04172.var_bf7[0].pixelX,
													localClass_h_04172.var_bf7[0].pixelY
															+ localClass_h_04172.var_bb7.spriteFrameHeight);
									someSprite.var_c38 = (-localClass_h_04172.var_bb7.spriteFrameHeight);
									localClass_h_04172.game
											.addSomeSprite(someSprite);
									localClass_h_04172.var_c97[0] = G_Sprite
											.sub_2054(
													localClass_h_04172.var_bbf,
													var_baf[localClass_h_04172.var_b97] * 3,
													-2, 0, -1, 100, (byte)0);
									int i4 = localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelX
											+ localClass_h_04172
													.sub_1640(
															localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
															localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].spriteFrameWidth / 2);
									i1 = localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelY
											+ localClass_h_04172.var_bb7.spriteFrameHeight
											- localClass_h_04172.var_c97[localClass_h_04172.var_ca7].spriteFrameHeight
											+ 2;
									localClass_h_04172.var_c97[0].setPixelPosition(i4,
											i1);
									localClass_h_04172.var_c97[1] = G_Sprite
											.sub_2054(
													localClass_h_04172.var_bbf,
													var_baf[localClass_h_04172.var_b97] * 3,
													1, 0, -1, 100, (byte)0);
									localClass_h_04172.var_c97[1].setPixelPosition(i4,
											i1);
									localClass_h_04172.game
											.addSomeSprite(localClass_h_04172.var_c97[1]);
									localClass_h_04172.var_c97[1].var_c98 = localClass_h_04172.var_b97;
									localClass_h_04172.game
											.addSomeSprite(localClass_h_04172.var_c97[0]);
									localClass_h_04172.var_c97[0].var_c98 = localClass_h_04172.var_b97;
								} else if (localClass_h_04172.someUnit1Type == 8) {
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7] = G_Sprite
											.sub_2054(
													null,
													var_baf[localClass_h_04172.var_b97],
													0, 0, -1, 2000, (byte)6);
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7]
											.setPixelPosition(
													localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelX
															+ localClass_h_04172
																	.sub_1640(
																			localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
																			localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].spriteFrameWidth + 2),
													localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelY + 30);
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7].var_c88 = true;
									C_MainCanvas.sub_2af6(200);
									localClass_h_04172.game.sub_188ce(1200);
									C_MainCanvas.playMusicLooped(14, 1);
									localClass_h_04172.game
											.addSomeSprite(localClass_h_04172.var_c97[localClass_h_04172.var_ca7]);
								}
							}
						} else {
							localClass_h_04172.var_c97[localClass_h_04172.var_ca7] = G_Sprite
									.sub_2054(localClass_h_04172.var_bbf, 0, 0,
											0, 1, 50, (byte)0);
							localClass_h_04172.var_c97[localClass_h_04172.var_ca7]
									.setPixelPosition(
											localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelX
													+ localClass_h_04172
															.sub_1640(
																	localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
																	localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].spriteFrameWidth),
											localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].pixelY);
							localClass_h_04172.game
									.addSomeSprite(localClass_h_04172.var_c97[localClass_h_04172.var_ca7]);
						}
					}
					if (++localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
						m = 0;
					}
					for (i1 = 0; i1 < localClass_h_04172.var_b8f; i1++) {
						if (localClass_h_04172.var_bf7[i1].var_c48 > 0) {
							m = 0;
						} else if ((localClass_h_04172.someUnit1Type != 7)
								&& (localClass_h_04172.var_bf7[i1].var_c48 != -1)) {
							if (localClass_h_04172.var_bf7[i1].var_ca8 == 0) {
								localClass_h_04172.var_bf7[i1].setFrameSequenceByIndex(3,
										localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[i1].var_c48 = 1;
								localClass_h_04172.var_bf7[i1].var_ca8 = 1;
								if (localClass_h_04172.someUnit1Type == 8) {
									localClass_h_04172.var_c97[i1].var_c78 = false;
								}
								m = 0;
							} else if (localClass_h_04172.var_bf7[i1].var_ca8 == 1) {
								localClass_h_04172.var_bf7[i1].setFrameSequenceByIndex(0,
										localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[i1].var_c48 = -1;
								localClass_h_04172.var_bf7[i1].var_ca8 = 2;
								m = 0;
							}
						}
						if ((localClass_h_04172.someUnit1Type == 8)
								&& (localClass_h_04172.var_c97[i1] != null)
								&& (localClass_h_04172.var_c97[i1].var_c78)) {
							G_Sprite localClass_g_25175;
							(localClass_g_25175 = G_Sprite.sub_2054(
									localClass_h_04172.game.bSmokeSprite,
									var_baf[localClass_h_04172.var_b97]
											* C_MainCanvas.getRandomWithin(1, 4),
									C_MainCanvas.getRandomWithin(-2, 3), 0, 1,
									50 * C_MainCanvas.getRandomMax(4), (byte) 0))
									.setPixelPosition(
											localClass_h_04172.var_bf7[i1].pixelX
													+ localClass_h_04172
															.sub_1640(
																	localClass_g_25175,
																	localClass_h_04172.var_bb7.spriteFrameWidth),
											localClass_h_04172.var_c97[i1].pixelY
													+ C_MainCanvas
															.getRandomMax(30 - localClass_h_04172.var_c97[i1].spriteFrameHeight)
													- 15);
							localClass_g_25175.var_c88 = true;
							localClass_h_04172.game
									.addSomeSprite(localClass_g_25175);
						}
					}
					if (m != 0) {
						if (localClass_h_04172.someUnit1.unitType == 9) {
							localClass_h_04172.var_ba7 = 6;
						} else {
							localClass_h_04172.var_ba7 = 4;
						}
						localClass_h_04172.var_c77 = 400;
						if (localClass_h_04172.someUnit1.unitType == 8) {
							localClass_h_04172.var_c77 = 0;
						}
						localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
						localClass_h_04172.var_c6f = 0;
					}
				}
				break;
			case 2:
			case 3:
			case 5:
			default:
				break;
			case 4:
				if (localClass_h_04172.var_c6f == 0) {
					if (localClass_h_04172.game.var_479a
							- localClass_h_04172.var_bef < localClass_h_04172.var_c77) {
						break;
					}
					localClass_h_04172.hclass.sub_331c();
					if (localClass_h_04172.someUnit1Type != 1) {
						localClass_h_04172.game.sub_188ce(200);
					}
					C_MainCanvas.sub_2af6(200);
					C_MainCanvas.playMusicLooped(14, 1);
					if (localClass_h_04172.var_bc7 != null) {
						localClass_h_04172.var_c9f = A_Unit.unitsChars[localClass_h_04172.someUnit1Type].length;
					}
					localClass_h_04172.var_c6f = 1;
					break;
				}
				if (localClass_h_04172.var_c6f != 1) {
					break;
				}
				if (--localClass_h_04172.var_c9f < 0) {
					localClass_h_04172.var_ba7 = 7;
					localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
					break;
				}
				if ((localClass_h_04172.someUnit1Type != 3)
						&& (localClass_h_04172.someUnit1Type != 2)
						&& (localClass_h_04172.someUnit1Type != 1)) {
					someSprite = G_Sprite.sub_2054(
							localClass_h_04172.var_bc7, 0, 0, 0, -1, 0,
							(byte) 0);
				} else {
					someSprite = G_Sprite
							.sub_2054(localClass_h_04172.var_bc7, 0, 0, 0, 1,
									0, (byte) 0);
				}
				if ((localClass_h_04172.someUnit1Type == 2)
						|| (localClass_h_04172.someUnit1Type == 1)) {
					someSprite.var_c80 = false;
				}
				int i5 = C_MainCanvas
						.getRandomMax(localClass_h_04172.game.someCanWidth / 2
								- someSprite.spriteFrameWidth);
				i1 = 0;
				if (localClass_h_04172.hclass.fightAnimBackgroundImage != null) {
					i1 = 0 + (localClass_h_04172.hclass.fightAnimBackgroundImage.imageHeight - someSprite.spriteFrameHeight);
				}
				m = (localClass_h_04172.game.var_4eba - i1)
						* ((localClass_h_04172.var_c9f << 1) + 1)
						/ (A_Unit.unitsChars[localClass_h_04172.someUnit1Type].length << 1)
						- someSprite.spriteFrameHeight / 2 + i1;
				if (localClass_h_04172.var_b97 == 0) {
					i5 += localClass_h_04172.game.someCanWidthShift;
				}
				if ((localClass_h_04172.someUnit1Type == 7)
						|| (localClass_h_04172.someUnit1Type == 6)) {
					someSprite.var_c38 = m;
					m = 0;
				}
				someSprite.setPixelPosition(i5, m);
				localClass_h_04172.game.addSomeSprite(someSprite);
				for (i1 = 0; i1 < 3; i1++) {
					G_Sprite localClass_g_25178;
					if ((localClass_h_04172.someUnit1Type != 7)
							&& (localClass_h_04172.someUnit1Type != 6)) {
						(localClass_g_25178 = G_Sprite.sub_2054(
								localClass_h_04172.game.bSmokeSprite,
								C_MainCanvas.getRandomWithin(-1, 2), 0, -1, 1, 100,
								(byte) 0))
								.setPixelPosition(
										i5
												+ C_MainCanvas
														.getRandomMax(someSprite.spriteFrameWidth
																- localClass_g_25178.spriteFrameWidth),
										m + someSprite.spriteFrameHeight
												- localClass_g_25178.spriteFrameHeight
												+ 1);
					} else {
						(localClass_g_25178 = G_Sprite.sub_2054(
								localClass_h_04172.game.smokeSprite,
								C_MainCanvas.getRandomWithin(-1, 2), 0,
								C_MainCanvas.getRandomWithin(-2, 0), 1,
								C_MainCanvas.getRandomMax(4) * 50, (byte) 0))
								.setPixelPosition(
										i5
												+ C_MainCanvas
														.getRandomMax(someSprite.spriteFrameWidth
																- localClass_g_25178.spriteFrameWidth),
										someSprite.var_c38
												+ someSprite.spriteFrameHeight
												- localClass_g_25178.spriteFrameHeight
												+ 1);
						localClass_g_25178.var_c38 = (-someSprite.spriteFrameHeight / 2);
					}
					localClass_h_04172.game.addSomeSprite(localClass_g_25178);
				}
				break;
			case 6:
				m = 1;
				for (i1 = 0; i1 < localClass_h_04172.var_c97.length; i1++) {
					if ((localClass_h_04172.someUnit1Type == 9)
							&& (C_MainCanvas.getRandomMax(2) == 0)) {
						G_Sprite localClass_g_25176;
						(localClass_g_25176 = G_Sprite.sub_2054(
								localClass_h_04172.game.bSmokeSprite,
								C_MainCanvas.getRandomWithin(-2, 1), 0, -1, 1, 100,
								(byte) 0))
								.setPixelPosition(
										localClass_h_04172.var_c97[i1].pixelX
												+ localClass_h_04172
														.sub_1640(
																localClass_h_04172.var_c97[i1],
																0),
										localClass_h_04172.var_c97[i1].pixelY
												+ localClass_h_04172.var_c97[i1].spriteFrameHeight
												- localClass_g_25176.spriteFrameHeight);
						if (localClass_h_04172.var_c97[i1].var_ca8 == 1) {
							localClass_g_25176.var_c98 = localClass_h_04172.hclass.var_b97;
						} else {
							localClass_g_25176.var_c98 = localClass_h_04172.var_b97;
						}
						localClass_h_04172.game
								.addSomeSprite(localClass_g_25176);
					}
					if (localClass_h_04172.someUnit1Type == 9) {
						if (localClass_h_04172.var_b97 == 0) {
							if (localClass_h_04172.var_c97[i1].pixelX >= localClass_h_04172.game.someCanWidth) {
								if (localClass_h_04172.var_c97[i1].var_ca8 == 0) {
									localClass_h_04172.var_c97[i1]
											.setPixelPosition(
													localClass_h_04172.game.someCanWidthShift
															- localClass_h_04172.var_c97[i1].spriteFrameWidth,
													localClass_h_04172.var_c97[i1].pixelY);
									localClass_h_04172.var_c97[i1].var_c98 = localClass_h_04172.hclass.var_b97;
									localClass_h_04172.var_c97[i1].var_ca8 = 1;
								} else {
									if (localClass_h_04172.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									localClass_h_04172.game
											.removeSomeSprite(localClass_h_04172.var_c97[i1]);
									localClass_h_04172.var_c97[i1].var_ca8 = 2;
									continue;
								}
							} else {
								m = 0;
								continue;
							}
						} else {
							if (localClass_h_04172.var_b97 != 1) {
								continue;
							}
							if (localClass_h_04172.var_c97[i1].pixelX
									+ localClass_h_04172.var_c97[i1].spriteFrameWidth < 0) {
								if (localClass_h_04172.var_c97[i1].var_ca8 == 0) {
									localClass_h_04172.var_c97[i1]
											.setPixelPosition(
													localClass_h_04172.game.someCanWidthShift,
													localClass_h_04172.var_c97[i1].pixelY);
									localClass_h_04172.var_c97[i1].var_c98 = localClass_h_04172.hclass.var_b97;
									localClass_h_04172.var_c97[i1].var_ca8 = 1;
								} else {
									if (localClass_h_04172.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									localClass_h_04172.game
											.removeSomeSprite(localClass_h_04172.var_c97[i1]);
									localClass_h_04172.var_c97[i1].var_ca8 = 2;
									continue;
								}
							}
						}
						m = 0;
					}
				}
				if (m == 0) {
					break;
				}
				localClass_h_04172.var_c6f = 0;
				localClass_h_04172.var_ba7 = 4;
				localClass_h_04172.var_bef = localClass_h_04172.game.var_479a;
				break;
			}
			if (localClass_h_04172.game.var_479a
					- localClass_h_04172.var_bef >= 1000L) {
				localClass_h_04172.var_ba7 = 0;
				localClass_h_04172.var_b5f = true;
			}
		}
		if (this.someUnit1Type == 6) {
			for (int j = 0; j < this.var_bf7.length; j++) {
				if (this.var_bf7[j].var_ca0) {
					this.var_bf7[j].var_c38 = (-6 + 4
							* F_StringManager.sub_f0f(this.var_c57[j]) >> 10);
					this.var_c57[j] = ((this.var_c57[j] + 10) % 360);
				}
			}
		}
	}

	private void sub_331c() {
		this.var_b67 = true;
		this.var_c47 = (this.var_b7f - this.var_b87);
		this.var_b8f = this.var_b87;
		int i;
		for (int j = 0; j < this.var_c47; j++) {
			this.game.removeSomeSprite(this.var_bf7[j]);
			G_Sprite localClass_g_25171;
			(localClass_g_25171 = G_Sprite.sub_2054(this.game.redsparkSprite,
					0, 0, 0, 1, 0, (byte) 0)).setPixelPosition(this.var_bf7[j].pixelX
					+ (this.var_bf7[j].spriteFrameWidth - localClass_g_25171.spriteFrameWidth)
					/ 2, this.game.canvasHeight); // @todo see "long k" or "long byte"
			localClass_g_25171.var_c38 = (this.var_bf7[j].pixelY
					+ (this.var_bf7[j].spriteFrameHeight - localClass_g_25171.spriteFrameHeight)
					/ 2 - this.game.canvasHeight); // @todo see "long k" or "long byte"
			this.game.addSomeSprite(localClass_g_25171);
			G_Sprite localClass_g_25172;
			for (i = 0; i < 3; i++) {
				(localClass_g_25172 = G_Sprite.sub_2054(
						this.game.bSmokeSprite, i + -1, 0,
						C_MainCanvas.getRandomWithin(-4, -1), 1,
						C_MainCanvas.getRandomMax(4) * 50, (byte) 0))
						.setPixelPosition(
								this.var_bf7[j].pixelX
										+ (this.var_bf7[j].spriteFrameWidth - localClass_g_25172.spriteFrameWidth)
										/ 2, this.var_bf7[j].pixelY
										+ this.var_bf7[j].spriteFrameHeight
										- localClass_g_25172.spriteFrameHeight + 3);
				this.game.addSomeSprite(localClass_g_25172);
			}
			(localClass_g_25172 = G_Sprite.sub_2054(this.game.smokeSprite,
					0, 0, -1, 1, 200, (byte) 0))
					.setPixelPosition(
							this.var_bf7[j].pixelX
									+ (this.var_bf7[j].spriteFrameWidth - localClass_g_25172.spriteFrameWidth)
									/ 2, this.var_bf7[j].pixelY
									+ this.var_bf7[j].spriteFrameHeight
									- localClass_g_25172.spriteFrameHeight + 3);
			this.game.addSomeSprite(localClass_g_25172);
		}
		G_Sprite[] arrayOfClass_g_2517 = new G_Sprite[this.var_b8f];
		System.arraycopy(this.var_bf7, this.var_c47, arrayOfClass_g_2517, 0,
				this.var_b8f);
		this.var_bf7 = arrayOfClass_g_2517;
		G_Sprite localClass_g_25171 = G_Sprite.createSomeSprite(""
				+ (this.var_b77 - this.someUnit1Health), 0, -4, (byte) 1);
		int k;
		if (this.var_b87 == 1) {
			k = this.var_bf7[0].pixelX + this.var_bf7[0].spriteFrameWidth / 2;
			i = this.var_bf7[0].pixelY + this.var_bf7[0].spriteFrameHeight + 1;
		} else {
			k = this.game.someCanWidthShift / 2;
			if (this.var_b97 == 1) {
				k += this.game.someCanWidthShift;
			}
			i = (this.game.var_4eba + this.var_c1f) / 2;
		}
		localClass_g_25171.setPixelPosition(k, i);
		localClass_g_25171.var_c88 = true;
		this.game.addSomeSprite(localClass_g_25171);
	}

	public final void sub_35c1(Graphics paramGraphics, int paramInt1,
			int paramInt2) {
		paramGraphics.translate(paramInt1, paramInt2);
		int i = 0;
		int j = 0;
		int k = this.var_c27;
		int m;
		while (j < k) {
			int n = this.var_c1f + paramInt2;
			m = 0;
			int i1 = this.var_c2f;
			while (m < i1) {
				this.someImagesArr[this.var_c7f[j][m]].drawOnGraphics(paramGraphics, i, n);
				n += 24;
				m++;
			}
			i += 24;
			j++;
		}
		if (this.fightAnimBackgroundImage != null) {
			j = this.fightAnimBackgroundImage.imageWidth;
			i = 0;
			k = 0;
			m = (this.game.someCanWidthShift + j - 1) / j;
			while (k < m) {
				this.fightAnimBackgroundImage.drawOnGraphics(paramGraphics, i, 0);
				i += j;
				k++;
			}
		}
		paramGraphics.translate(-paramInt1, -paramInt2);
	}

	public final void sub_36f9(Graphics paramGraphics) {
		int i = this.game.canvasHeight - G_Game.var_4592 / 2; 
		C_MainCanvas.sub_2007(paramGraphics, this.var_c3f + "/" + 100,
				this.game.someCanWidthShift / 2, i, 1, 3);
	}

	public final void sub_374d(Graphics paramGraphics) {
		paramGraphics.setColor(4210752);
		for (int i = 0; i < this.var_b8f; i++) {
			G_Sprite localClass_g_2517 = this.var_bf7[i];
			if ((this.someUnit1Type == 0) || (this.someUnit1Type == 4)
					|| (this.someUnit1Type == 5) || (this.someUnit1Type == 6)) {
				paramGraphics.fillArc(localClass_g_2517.pixelX,
						localClass_g_2517.pixelY
								+ (localClass_g_2517.spriteFrameHeight << 2) / 5,
						localClass_g_2517.spriteFrameWidth,
						localClass_g_2517.spriteFrameHeight / 4, 0, 360);
			}
		}
	}

	static {
		new byte[] { 18 }[1] = -18;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_h_0417
 * 
 * JD-Core Version: 0.7.0.1
 */