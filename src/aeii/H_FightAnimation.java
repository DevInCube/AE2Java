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
	private byte unitHealthBeforeAttack;
	public byte unitHealthAfterAttack;
	private byte someUnitsCount;
	public byte var_b87;
	private byte someUnitsSpitesCountMbAlive;
	private byte var_b97;
	private boolean var_b9f;
	private int var_ba7 = 0;
	private static byte[] var_baf = { 3, -3 };
	private G_Sprite var_bb7;
	private G_Sprite castSprite;
	private G_Sprite castEffectSprite;
	private G_Sprite slashSprite;
	private int var_bd7;
	private int var_bdf;
	private long someAnimationTime2;
	private long someFATime;
	private G_Sprite[] someUnitsSprites;
	private D_ImageWrap[] bgMultipleImages;
	private D_ImageWrap fightAnimBackgroundImage;
	public H_FightAnimation hclass;
	private int unitPosTileType;
	private int bgSingleImageHeight;
	private int bgMultXCount;
	private int bgMultYCount;
	private boolean var_c37 = false;
	private int unitHealth;
	private int var_c47;
	private int[][] unitCharactersPositions;
	private int[] circleAnimDegrees;
	private int var_c5f;
	private int var_c67 = 20;
	private int var_c6f;
	private int var_c77;
	private byte[][] bgMultipleRandomPositions;
	private G_Sprite kingHeadsSprite;
	private G_Sprite kingBacksSprite;
	private G_Sprite[] var_c97;
	private int var_c9f;
	private int var_ca7;

	public H_FightAnimation(G_Game game, A_Unit unit, H_FightAnimation hclass) {
		this.game = game;
		this.someUnit1 = unit;
		this.someUnit1Type = unit.unitType;
		this.hclass = hclass;
		this.unitHealthBeforeAttack = ((byte) unit.health);
		this.unitHealth = this.unitHealthBeforeAttack;
		this.someUnitsCount = ((byte) unit.getSomeHealthManipulationVal());
		this.someUnitsSpitesCountMbAlive = this.someUnitsCount;
		int semiViewportWidth = 0;
		if (hclass == null) {
			this.var_b97 = 0;
			this.var_bd7 = 0;
			this.var_b9f = true;
		} else {
			semiViewportWidth = game.someCanWidthDiv2;
			this.var_b97 = 1;
			this.var_ba7 = 0;
		}
		this.unitPosTileType = game.getMapTileType(unit.posX,
				unit.posY);
		int tileTypeValue1 = var_b2f[this.unitPosTileType];
		int tileTypeValue2 = var_b27[this.unitPosTileType];
		if ((hclass != null)
				&& (tileTypeValue2 == var_b27[hclass.unitPosTileType])) {
			this.bgMultipleImages = new D_ImageWrap[hclass.bgMultipleImages.length];
			System.arraycopy(hclass.bgMultipleImages, 0, this.bgMultipleImages, 0,
					this.bgMultipleImages.length);
		} else {
			this.bgMultipleImages = new G_Sprite(tileNamesStrings[tileTypeValue2]).frameImages;
		}
		if (this.var_b97 == 1) {
			for (int it = 0; it < this.bgMultipleImages.length; it++) {
				this.bgMultipleImages[it] = new D_ImageWrap(this.bgMultipleImages[it], 1);
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
			this.bgSingleImageHeight = this.fightAnimBackgroundImage.imageHeight;
		}
		this.bgMultXCount = (game.someCanWidthDiv2 / this.bgMultipleImages[0].imageWidth);
		if (game.someCanWidthDiv2 % this.bgMultipleImages[0].imageWidth != 0) {
			this.bgMultXCount += 1;
		}
		this.bgMultYCount = ((game.faViewPortHeight - this.bgSingleImageHeight) / this.bgMultipleImages[0].imageHeight);
		if ((game.faViewPortHeight - this.bgSingleImageHeight)
				% this.bgMultipleImages[0].imageHeight != 0) {
			this.bgMultYCount += 1;
		}
		this.bgMultipleRandomPositions = new byte[this.bgMultXCount][this.bgMultYCount];
		for (int it = 0; it < this.bgMultXCount; it++) {
			for (int it2 = 0; it2 < this.bgMultYCount; it2++) {
				this.bgMultipleRandomPositions[it][it2] = ((byte) Math.abs(C_MainCanvas.random
						.nextInt() % this.bgMultipleImages.length));
			}
		}
		this.var_bb7 = new G_Sprite(var_b37[this.someUnit1Type],
				game.var_4832[unit.teamId]);
		if ((hclass != null)
				&& (hclass.someUnit1Type == this.someUnit1Type)) {
			if (hclass.slashSprite != null) {
				this.slashSprite = new G_Sprite(hclass.slashSprite);
			}
			if (hclass.castSprite != null) {
				this.castSprite = new G_Sprite(hclass.castSprite);
			}
			if (hclass.castEffectSprite != null) {
				this.castEffectSprite = new G_Sprite(hclass.castEffectSprite);
			}
			if (hclass.kingHeadsSprite != null) {
				this.kingHeadsSprite = new G_Sprite(hclass.kingHeadsSprite);
				this.kingBacksSprite = new G_Sprite(hclass.kingBacksSprite);
			}
		} else if ((this.someUnit1Type != 0) && (this.someUnit1Type != 10)//soldier skeleton wolf
				&& (this.someUnit1Type != 5)) {
			if (this.someUnit1Type == 1) { //archer
				this.castEffectSprite = new G_Sprite("archer_arrow");
			} else if (this.someUnit1Type == 9) { // king
				this.castSprite = new G_Sprite("kingwave");
				this.slashSprite = new G_Sprite("kingslash");
				this.kingHeadsSprite = new G_Sprite("king_heads");
				this.kingBacksSprite = new G_Sprite("king_heads_back");
			} else if (this.someUnit1Type == 2) { // lizard
				this.castSprite = new G_Sprite("watermagic");
				this.castEffectSprite = new G_Sprite("fish");
			} else if ((this.someUnit1Type != 7) && (this.someUnit1Type != 6)) { //catapult golem
				if (this.someUnit1Type == 3) { // sorceress
					this.castSprite = new G_Sprite("spell");
					this.castEffectSprite = this.castSprite;
				}
			} else {
				this.castEffectSprite = new G_Sprite("crater");
			}
		} else {
			this.slashSprite = new G_Sprite("slash");
		}
		if (this.castSprite != null) {
			this.castSprite.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.castEffectSprite != null) {
			this.castEffectSprite.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.slashSprite != null) {
			this.slashSprite.setFrameSequenceByIndex(0, this.var_b9f);
		}
		if (this.kingHeadsSprite != null) {
			this.kingHeadsSprite.setFrameSequenceByIndex(unit.var_eeb, this.var_b9f);
			this.kingHeadsSprite.setCurrentFrameIndex(unit.var_eeb);
			this.kingBacksSprite.setFrameSequenceByIndex(0, this.var_b9f);
			this.kingBacksSprite.setCurrentFrameIndex(unit.var_eeb);
		}
		this.unitCharactersPositions = new int[unit.chars.length][2];
		for (int it = 0; it < this.unitCharactersPositions.length; it++) {
			this.unitCharactersPositions[it][0] = (unit.chars[it][0]
					* game.canvasWidth / 128); 
			if (this.var_b97 == 1) {
				this.unitCharactersPositions[it][0] = (game.someCanWidthDiv2
						- this.unitCharactersPositions[it][0] - this.var_bb7.spriteFrameWidth + semiViewportWidth);
			}
			this.unitCharactersPositions[it][1] = (unit.chars[it][1]
					* game.faViewPortHeight / 128 - this.var_bb7.spriteFrameHeight);
		}
		this.someUnitsSprites = new G_Sprite[this.someUnitsCount];
		if ((this.someUnit1Type == 4) || (this.someUnit1Type == 6)) { // wisp or golem
			this.circleAnimDegrees = new int[this.someUnitsCount];
		}
		for (int it = 0; it < this.someUnitsCount; it++) {
			this.someUnitsSprites[it] = new G_Sprite(this.var_bb7);
			game.addSomeSprite(this.someUnitsSprites[it]);
			this.someUnitsSprites[it].setPixelPosition(this.unitCharactersPositions[it][0], this.unitCharactersPositions[it][1]);
			this.someUnitsSprites[it].setFrameSequenceByIndex(0, this.var_b9f);
			this.someUnitsSprites[it].var_c80 = false;
			this.someUnitsSprites[it].someYVal = 0;
			if (this.someUnit1Type == 6) { //golem
				this.someUnitsSprites[it].var_ca0 = true;
				this.circleAnimDegrees[it] = C_MainCanvas.getRandomMax(360);
				this.someUnitsSprites[it].var_c38 = (-6 + 4
						* F_StringManager.sub_f0f(this.circleAnimDegrees[it]) >> 10);
			} else if (this.someUnit1Type == 4) { // wisp
				this.someUnitsSprites[it].var_ca0 = true;
				this.someUnitsSprites[it].var_c38 = (-5 - C_MainCanvas.getRandomMax(10));
				this.circleAnimDegrees[it] = C_MainCanvas.getRandomMax(360);
			} else if (this.someUnit1Type == 9) { //kings head?
				this.someUnitsSprites[it].var_cc0 = this.kingHeadsSprite;
				this.someUnitsSprites[it].var_cc8 = this.kingBacksSprite;
			}
		}
	}

	private int sub_1640(G_Sprite sprite, int inWid) {
		if (this.var_b97 == 1) {
			return this.var_bb7.spriteFrameWidth - inWid - sprite.spriteFrameWidth;
		}
		return inWid;
	}

	public final void sub_1688() {
		this.var_b57 = true;
		this.var_ba7 = 1;
		this.someFATime = this.game.someGameTime;
	}

	public final void runUnitFightAnimation() {
		if ((this.var_b67) && (this.unitHealth > this.unitHealthAfterAttack)) {
			this.unitHealth -= 2;
			if (this.unitHealth < this.unitHealthAfterAttack) {
				this.unitHealth = this.unitHealthAfterAttack;
			}
			this.game.var_4eb2 = true;
		}
		int k;
		int i3;
		boolean isStandingUnitType = (this.someUnit1Type != 8) && (this.someUnit1Type != 9) && (this.someUnit1Type != 7)
				&& (this.someUnit1Type != 1) && (this.someUnit1Type != 3)
				&& (this.someUnit1Type != 2) && (this.someUnit1Type != 6);
		if (isStandingUnitType) {
			if (this.someUnit1Type == 4) { // wisp
				H_FightAnimation hFightAnim = this;
				switch (this.var_ba7) {
				case 1:
					if (hFightAnim.var_c6f == 0) {
						if (hFightAnim.game.someGameTime
								- hFightAnim.someFATime >= 200L) {
							hFightAnim.var_c6f = 1;
							hFightAnim.someFATime = hFightAnim.game.someGameTime;
						}
					} else {
						if (hFightAnim.var_c6f == 1) {
							hFightAnim.var_c67 += 5;
							if (hFightAnim.var_c67 >= 90) {
								hFightAnim.var_c6f += 1;
								hFightAnim.someFATime = hFightAnim.game.someGameTime;
							}
							if ((hFightAnim.var_c67 - 20) % 15 == 0) {
								for (int kIt = 0; kIt < hFightAnim.someUnitsSprites.length; kIt++) {
									G_Sprite bSmokeS = G_Sprite
											.getSpriteWithParams(
													hFightAnim.game.bSmokeSprite,
													C_MainCanvas
															.getRandomWithin(-1, 2),
													0, 0, 1, 100, (byte) 0);
									bSmokeS.setPixelPosition(
													hFightAnim.someUnitsSprites[kIt].pixelX
															+ C_MainCanvas
																	.getRandomMax(hFightAnim.var_bb7.spriteFrameWidth
																			- bSmokeS.spriteFrameWidth),
													hFightAnim.someUnitsSprites[kIt].pixelY
															+ hFightAnim.var_bb7.spriteFrameHeight
															- bSmokeS.spriteFrameHeight
															+ 1);
									hFightAnim.game.addSomeSprite(bSmokeS);
								}
							}
						} else if ((hFightAnim.var_c6f == 2)
								&& (hFightAnim.game.someGameTime
										- hFightAnim.someFATime >= 400L)) {
							hFightAnim.var_c67 = 20;
							hFightAnim.hclass.drawAfterAttackEffects();
							hFightAnim.var_ba7 = 4;
							hFightAnim.hclass.var_c37 = false;
							hFightAnim.someFATime = hFightAnim.game.someGameTime;
						}
						if (++hFightAnim.var_c5f >= 2) {
							for (k = 0; k < hFightAnim.hclass.someUnitsSprites.length; k++) {
								G_Sprite sSparkS = G_Sprite.getSpriteWithParams(
										hFightAnim.game.redsparkSprite, 0,
										0, 0, 1, 50, (byte) 0);
								sSparkS.setPixelPosition(
												hFightAnim.hclass.someUnitsSprites[k].pixelX
														+ C_MainCanvas
																.getRandomMax(hFightAnim.hclass.someUnitsSprites[k].spriteFrameWidth
																		- sSparkS.spriteFrameWidth),
												hFightAnim.hclass.someUnitsSprites[k].pixelY
														+ C_MainCanvas
																.getRandomMax(hFightAnim.hclass.someUnitsSprites[k].spriteFrameHeight
																		- sSparkS.spriteFrameHeight));
								sSparkS.var_c88 = true;
								hFightAnim.game
										.addSomeSprite(sSparkS);
							}
							hFightAnim.var_c5f = 0;
							H_FightAnimation hFA = hFightAnim.hclass;
							for (int i2 = 0; i2 < hFA.someUnitsSpitesCountMbAlive; i2++) {
								hFA.someUnitsSprites[i2].var_c90 = 6;
							}
						}
					}
					break;
				case 4:
					if (hFightAnim.game.someGameTime
							- hFightAnim.someFATime >= 800L) {
						hFightAnim.var_b5f = true;
						hFightAnim.var_ba7 = 0;
					}
					break;
				}
				k = 0;
				if (hFightAnim.game.someGameTime
						- hFightAnim.someAnimationTime2 >= 300L) {
					k = 1;
					hFightAnim.someAnimationTime2 = hFightAnim.game.someGameTime;
				}
				for (int n = 0; n < hFightAnim.someUnitsSprites.length; n++) {
					if (k != 0) {
						G_Sprite randSprite = G_Sprite.getSpriteWithParams(null, 0, 0,
								0, 1, 500, (byte) 4);
						randSprite.setPixelPosition(
										hFightAnim.someUnitsSprites[n].pixelX
												+ (hFightAnim.someUnitsSprites[n].spriteFrameWidth >> 1),
										hFightAnim.someUnitsSprites[n].pixelY
												+ (hFightAnim.someUnitsSprites[n].spriteFrameHeight >> 1)
												+ hFightAnim.var_bdf);
						hFightAnim.game
								.addSomeSprite(randSprite);
					}
					i3 = hFightAnim.someUnitsSprites[n].spriteFrameWidth / 3;
					hFightAnim.someUnitsSprites[n]
							.setPixelPosition(
									hFightAnim.unitCharactersPositions[n][0]
											+ (i3
													* F_StringManager
															.sub_f35(hFightAnim.circleAnimDegrees[n]) >> 10),
									hFightAnim.unitCharactersPositions[n][1]
											+ (i3
													* F_StringManager
															.sub_f0f(hFightAnim.circleAnimDegrees[n])
													/ 3 >> 10));
					hFightAnim.circleAnimDegrees[n] = ((hFightAnim.circleAnimDegrees[n] + hFightAnim.var_c67) % 360);
				}
			} else {
				int i;
				switch (this.var_ba7) {
				case 1:
					if (this.game.someGameTime - this.someFATime >= 200L) {
						this.var_ba7 = 3;
					}
				case 2:
				case 5:
				default:
					break;
				case 3:
					i = 1;
					G_Sprite atheSprite;
					if (this.var_c6f < this.someUnitsSpitesCountMbAlive) {
						if ((this.someUnit1Type == 0) || (this.someUnit1Type == 5)) {
							this.someUnitsSprites[this.var_c6f].var_c70 = -6;
						}
						if (this.someUnit1Type == 5) {
							this.someUnitsSprites[this.var_c6f].someXVal = (2 * var_baf[this.var_b97]);
							for (k = 0; k < 3; k++) {
								atheSprite = G_Sprite.getSpriteWithParams(
										this.game.bSmokeSprite,
										C_MainCanvas.getRandomWithin(-1, 2), 0, -1, 1,
										100, (byte) 0);
								atheSprite.setPixelPosition(
												this.someUnitsSprites[this.var_c6f].pixelX
														+ C_MainCanvas
																.getRandomMax(this.var_bb7.spriteFrameWidth
																		- atheSprite.spriteFrameWidth),
												this.someUnitsSprites[this.var_c6f].pixelY
														+ this.var_bb7.spriteFrameHeight
														- atheSprite.spriteFrameHeight
														+ 1);
								this.game.addSomeSprite(atheSprite);
							}
						}
						this.someUnitsSprites[this.var_c6f].someXVal = var_baf[this.var_b97];
						this.someUnitsSprites[this.var_c6f].setFrameSequenceByIndex(1, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (int kIt = 0; kIt < this.var_c6f; kIt++) {
						if (this.someUnit1Type == 10) { //skeleton
							if (this.someUnitsSprites[kIt].var_ca8 != -1) {
								this.someUnitsSprites[kIt].var_ca8 += 1;
								if (this.someUnitsSprites[kIt].var_ca8 >= 16) {
									this.someUnitsSprites[kIt].setFrameSequenceByIndex(2, this.var_b9f);
									this.someUnitsSprites[kIt].someXVal = 0;
									this.someUnitsSprites[kIt].var_ca8 = -1;
									atheSprite = G_Sprite
											.getSpriteWithParams(null, 0, 0, 0, 1, 800,
													(byte) 2);
									atheSprite.setPixelPosition(
													this.someUnitsSprites[kIt].pixelX
															+ sub_1640(
																	atheSprite,
																	this.var_bb7.spriteFrameWidth),
													this.someUnitsSprites[kIt].pixelY
															+ this.var_bb7.spriteFrameHeight);
									this.game.addSomeSprite(atheSprite);
									atheSprite = G_Sprite
											.getSpriteWithParams(this.slashSprite, 0, 0, 0, 1,
													150, (byte) 0);
									atheSprite.setPixelPosition(
											this.someUnitsSprites[kIt].pixelX
													+ sub_1640(
															atheSprite,
															24),
											this.someUnitsSprites[kIt].pixelY + 3);
									this.game.addSomeSprite(atheSprite);
								} else {
									i = 0;
								}
							}
						} else if (this.someUnitsSprites[kIt].var_c38 < 0) {
							this.someUnitsSprites[kIt].var_c70 += 1;
							i = 0;
						} else if (this.someUnitsSprites[kIt].var_c70 >= 6) {
							this.someUnitsSprites[kIt].var_c38 = 0;
							this.someUnitsSprites[kIt].var_c70 = 0;
							this.someUnitsSprites[kIt].someXVal = 0;
							if ((this.someUnit1Type == 0) || (this.someUnit1Type == 5)) {
								this.someUnitsSprites[kIt].setFrameSequenceByIndex(2, this.var_b9f);
								if (this.someUnit1Type == 0) {
									(atheSprite = G_Sprite
											.getSpriteWithParams(this.slashSprite, 0, 0, 0, 1,
													150, (byte) 0)).setPixelPosition(
											this.someUnitsSprites[kIt].pixelX
													+ sub_1640(
															atheSprite,
															14),
											this.someUnitsSprites[kIt].pixelY
													+ this.someUnitsSprites[kIt].spriteFrameHeight);
									atheSprite.var_c38 = (4 - this.someUnitsSprites[kIt].spriteFrameHeight);
									this.game.addSomeSprite(atheSprite);
								} else if (this.someUnit1Type == 5) { // wolf
									atheSprite = G_Sprite
											.getSpriteWithParams(this.game.redsparkSprite, 0,
													0, 0, 1, 50, (byte) 0);
									atheSprite.setPixelPosition(
													this.someUnitsSprites[kIt].pixelX
															+ sub_1640(
																	atheSprite,
																	this.var_bb7.spriteFrameWidth * 3 / 4),
													this.someUnitsSprites[kIt].pixelY
															+ this.someUnitsSprites[kIt].spriteFrameHeight);
									atheSprite.var_c38 = (-atheSprite.spriteFrameHeight);
									this.game.addSomeSprite(atheSprite);
								}
							}
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_c6f = 0;
					this.var_ba7 = 6;
					this.hclass.drawAfterAttackEffects();
					this.game.sub_188ce(200);
					C_MainCanvas.sub_2af6(200);
					C_MainCanvas.playMusicLooped(14, 1);
					this.someFATime = this.game.someGameTime;
					break;
				case 4:
					i = 1;
					if (this.var_c6f < this.someUnitsSpitesCountMbAlive) {
						if ((this.someUnit1Type != 0) && (this.someUnit1Type != 2)
								&& (this.someUnit1Type != 5)) { //not soldier lizard wolf
							if (this.someUnit1Type == 10) { // skeleton
								this.someUnitsSprites[this.var_c6f].var_ca8 = 0;
							}
						} else {
							this.someUnitsSprites[this.var_c6f].var_c70 = -6;
						}
						if (this.someUnit1Type == 5) { // wolf
							this.someUnitsSprites[this.var_c6f].someXVal = (-2 * var_baf[this.var_b97]);
						} else {
							this.someUnitsSprites[this.var_c6f].someXVal = (-var_baf[this.var_b97]);
						}
						this.someUnitsSprites[this.var_c6f].setFrameSequenceByIndex(3, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (int kIt = 0; kIt < this.var_c6f; kIt++) {
						if (this.someUnit1Type == 10) {
							if (this.someUnitsSprites[kIt].var_ca8 != -1) {
								this.someUnitsSprites[kIt].var_ca8 += 1;
								if (this.someUnitsSprites[kIt].var_ca8 >= 16) {
									this.someUnitsSprites[kIt].setFrameSequenceByIndex(0, this.var_b9f);
									this.someUnitsSprites[kIt].someXVal = 0;
									this.someUnitsSprites[kIt].var_ca8 = -1;
								} else {
									i = 0;
								}
							}
						} else if (this.someUnitsSprites[kIt].var_c38 < 0) {
							this.someUnitsSprites[kIt].var_c70 += 1;
							i = 0;
						} else if (this.someUnitsSprites[kIt].var_c70 >= 6) {
							this.someUnitsSprites[kIt].var_c70 = 0;
							this.someUnitsSprites[kIt].someXVal = 0;
							this.someUnitsSprites[kIt].var_c38 = 0;
							this.someUnitsSprites[kIt].setFrameSequenceByIndex(0, this.var_b9f);
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_b5f = true;
					this.var_ba7 = 0;
					this.someFATime = this.game.someGameTime;
					break;
				}
				if (((this.someUnit1Type == 10) && (this.game.someGameTime
						- this.someFATime >= 400L))
						|| (((this.someUnit1Type == 0) || (this.someUnit1Type == 2) || (this.someUnit1Type == 5)) && (this.game.someGameTime
								- this.someFATime >= 50L))) {
					this.var_ba7 = 4;
				}
			}
		} else {
			//label2184:
			H_FightAnimation fightAnim = this;
			int i1;
			int m = 0; // @todo m = 0 ? i wrote this
			G_Sprite someSprite;
			switch (this.var_ba7) {
			case 1:
				G_Sprite aSprite;
				if (fightAnim.someUnit1Type == 6) { //golem
					if (fightAnim.var_c6f == 0) {
						if (fightAnim.game.someGameTime
								- fightAnim.someFATime >= 200L) {
							if (fightAnim.var_ca7 < fightAnim.someUnitsSpitesCountMbAlive) {
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_ca8 = -1;
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_ca0 = false;
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c70 = 0;
							}
							if (++fightAnim.var_ca7 >= fightAnim.someUnitsSpitesCountMbAlive) {
								fightAnim.var_ca7 = 0;
								fightAnim.var_c6f = 1;
								fightAnim.someFATime = fightAnim.game.someGameTime;
								break;
							}
						}
					} else if (fightAnim.var_c6f == 1) {
						if (fightAnim.game.someGameTime
								- fightAnim.someFATime >= 200L) {
							if (fightAnim.var_ca7 < fightAnim.someUnitsSpitesCountMbAlive) {
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c70 = -1;
							}
							if (++fightAnim.var_ca7 >= fightAnim.someUnitsSpitesCountMbAlive) {
								fightAnim.var_ca7 = 0;
								fightAnim.var_c6f = 2;
								fightAnim.someFATime = fightAnim.game.someGameTime;
								break;
							}
						}
					} else if (fightAnim.var_c6f == 2) {
						k = 1;
						if (fightAnim.game.someGameTime
								- fightAnim.someFATime >= 200L) {
							if (fightAnim.var_ca7 < fightAnim.someUnitsSpitesCountMbAlive) {
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_ca8 = 0;
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c70 = 0;
								fightAnim.someUnitsSprites[fightAnim.var_ca7]
										.setFrameSequenceByIndex(2, fightAnim.var_b9f);
								fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c48 = 1;
							}
							if (++fightAnim.var_ca7 >= fightAnim.someUnitsSpitesCountMbAlive) {
							}
						} else {
							k = 0;
						}
						for (int it = 0; it < fightAnim.someUnitsSpitesCountMbAlive; it++) {
							if (fightAnim.someUnitsSprites[it].var_ca8 == 0) {
								if (fightAnim.someUnitsSprites[it].currentFrameIndex == 1) {
									fightAnim.someUnitsSprites[it].var_c38 = 0;
									fightAnim.someUnitsSprites[it].var_ca8 = 1;
									C_MainCanvas.sub_2af6(200);
									fightAnim.game.sub_188ce(1200);
									C_MainCanvas.playMusicLooped(14, 1);
									for (int it2 = 0; it2 < 2; it2++) {
										G_Sprite smokeS = G_Sprite
												.getSpriteWithParams(
														fightAnim.game.smokeSprite,
														0,
														0,
														-1,
														1,
														C_MainCanvas
																.getRandomMax(4) * 50,
														(byte) 0);
										smokeS.setPixelPosition(
														fightAnim.someUnitsSprites[it].pixelX
																+ C_MainCanvas
																		.getRandomMax(fightAnim.var_bb7.spriteFrameWidth
																				- smokeS.spriteFrameWidth),
														fightAnim.someUnitsSprites[it].pixelY
																+ fightAnim.var_bb7.spriteFrameHeight
																- smokeS.spriteFrameHeight
																+ 2);
										smokeS.var_c88 = true;
										fightAnim.game
												.addSomeSprite(smokeS);
									}
									aSprite = G_Sprite
											.getSpriteWithParams(
													fightAnim.game.smokeSprite,
													-1,
													0,
													-1,
													1,
													C_MainCanvas.getRandomMax(4) * 50,
													(byte) 0);
									aSprite.setPixelPosition(
													fightAnim.someUnitsSprites[it].pixelX,
													fightAnim.someUnitsSprites[it].pixelY
															+ fightAnim.var_bb7.spriteFrameHeight
															- aSprite.spriteFrameHeight
															+ 2);
									aSprite.var_c88 = true;
									fightAnim.game
											.addSomeSprite(aSprite);
									aSprite = G_Sprite
											.getSpriteWithParams(
													fightAnim.game.smokeSprite,
													1,
													0,
													-1,
													1,
													C_MainCanvas.getRandomMax(4) * 50,
													(byte) 0);
									aSprite.setPixelPosition(
													fightAnim.someUnitsSprites[it].pixelX
															+ fightAnim.var_bb7.spriteFrameWidth
															- aSprite.spriteFrameWidth,
													fightAnim.someUnitsSprites[it].pixelY
															+ fightAnim.var_bb7.spriteFrameHeight
															- aSprite.spriteFrameHeight
															+ 2);
									aSprite.var_c88 = true;
									fightAnim.game
											.addSomeSprite(aSprite);
								}
								m = 0;
							} else if (fightAnim.someUnitsSprites[it].var_ca8 != -1) {
								if (fightAnim.someUnitsSprites[it].var_c48 > 0) {
									m = 0;
								} else if (fightAnim.someUnitsSprites[it].var_c48 != -1) {
									if (fightAnim.someUnitsSprites[it].var_ca8 == 1) {
										fightAnim.someUnitsSprites[it]
												.setFrameSequenceByIndex(
														3,
														fightAnim.var_b9f);
										fightAnim.someUnitsSprites[it].var_c48 = 1;
										fightAnim.someUnitsSprites[it].var_ca8 = 2;
										m = 0;
									} else if (fightAnim.someUnitsSprites[it].var_ca8 == 2) {
										fightAnim.someUnitsSprites[it].var_c38 = -6;
										fightAnim.someUnitsSprites[it].var_ca0 = true;
										fightAnim.someUnitsSprites[it].var_c70 = C_MainCanvas
												.getRandomWithin(-2, 3);
										fightAnim.someUnitsSprites[it]
												.setFrameSequenceByIndex(
														0,
														fightAnim.var_b9f);
										fightAnim.someUnitsSprites[it].var_c48 = -1;
										fightAnim.someUnitsSprites[it].var_ca8 = 3;
										m = 0;
									}
								}
							}
						}
						if (m != 0) {
							fightAnim.var_c6f = 0;
							fightAnim.someFATime = fightAnim.game.someGameTime;
							fightAnim.var_ba7 = 4;
							break;
						}
					}
				} else if (fightAnim.var_c6f == 0) {
					if (fightAnim.game.someGameTime
							- fightAnim.someFATime >= 200L) {
						if (fightAnim.someUnit1Type == 9) { //king
							fightAnim.var_c97 = new G_Sprite[fightAnim.someUnitsSpitesCountMbAlive << 1];
						} else if ((fightAnim.someUnit1Type != 7)
								&& (fightAnim.someUnit1Type != 1)) {
							fightAnim.var_c97 = new G_Sprite[fightAnim.someUnitsSpitesCountMbAlive];
						}
						fightAnim.var_c6f = 1;
						fightAnim.var_ca7 = 0;
						fightAnim.someFATime = fightAnim.game.someGameTime;
						break;
					}
				} else if (fightAnim.var_c6f == 1) {
					m = 1;
					if (fightAnim.var_ca7 < fightAnim.someUnitsSpitesCountMbAlive) {
						fightAnim.someUnitsSprites[fightAnim.var_ca7]
								.setFrameSequenceByIndex(2, fightAnim.var_b9f);
						fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c48 = 1;
						if ((fightAnim.someUnit1Type != 3)
								&& (fightAnim.someUnit1Type != 2)) {
							if (fightAnim.someUnit1Type == 1) {
								(someSprite = G_Sprite.getSpriteWithParams(
										fightAnim.castEffectSprite, 0, 0, 0, 1,
										0, (byte) 0)).setFrameSequenceByIndex(1,
										fightAnim.var_b9f);
								someSprite
										.setPixelPosition(
												fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelX
														+ fightAnim
																.sub_1640(
																		someSprite,
																		fightAnim.someUnitsSprites[fightAnim.var_ca7].spriteFrameWidth),
												fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelY);
								fightAnim.game
										.addSomeSprite(someSprite);
							} else {
								if (fightAnim.someUnit1Type == 7) {
									fightAnim.someUnitsSprites[fightAnim.var_ca7].var_c90 = 5;
									for (i1 = 0; i1 < 3; i1++) {
										(aSprite = G_Sprite
												.getSpriteWithParams(
														fightAnim.game.bSmokeSprite,
														C_MainCanvas.getRandomWithin(
																-1, 2),
														0,
														0,
														1,
														C_MainCanvas
																.getRandomMax(4) * 50,
														(byte) 0))
												.setPixelPosition(
														fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelX
																+ fightAnim.var_bb7.spriteFrameWidth
																/ 2,
														fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelY);
										aSprite.var_c88 = true;
										fightAnim.game
												.addSomeSprite(aSprite);
									}
								}
								if (fightAnim.someUnit1Type == 9) {
									(someSprite = G_Sprite
											.getSpriteWithParams(
													fightAnim.slashSprite,
													0, 0, 0, 1, 200, (byte) 0))
											.setPixelPosition(
													fightAnim.someUnitsSprites[0].pixelX,
													fightAnim.someUnitsSprites[0].pixelY
															+ fightAnim.var_bb7.spriteFrameHeight);
									someSprite.var_c38 = (-fightAnim.var_bb7.spriteFrameHeight);
									fightAnim.game
											.addSomeSprite(someSprite);
									fightAnim.var_c97[0] = G_Sprite
											.getSpriteWithParams(
													fightAnim.castSprite,
													var_baf[fightAnim.var_b97] * 3,
													-2, 0, -1, 100, (byte)0);
									int i4 = fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelX
											+ fightAnim
													.sub_1640(
															fightAnim.var_c97[fightAnim.var_ca7],
															fightAnim.someUnitsSprites[fightAnim.var_ca7].spriteFrameWidth / 2);
									i1 = fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelY
											+ fightAnim.var_bb7.spriteFrameHeight
											- fightAnim.var_c97[fightAnim.var_ca7].spriteFrameHeight
											+ 2;
									fightAnim.var_c97[0].setPixelPosition(i4,
											i1);
									fightAnim.var_c97[1] = G_Sprite
											.getSpriteWithParams(
													fightAnim.castSprite,
													var_baf[fightAnim.var_b97] * 3,
													1, 0, -1, 100, (byte)0);
									fightAnim.var_c97[1].setPixelPosition(i4,
											i1);
									fightAnim.game
											.addSomeSprite(fightAnim.var_c97[1]);
									fightAnim.var_c97[1].var_c98 = fightAnim.var_b97;
									fightAnim.game
											.addSomeSprite(fightAnim.var_c97[0]);
									fightAnim.var_c97[0].var_c98 = fightAnim.var_b97;
								} else if (fightAnim.someUnit1Type == 8) {
									fightAnim.var_c97[fightAnim.var_ca7] = G_Sprite
											.getSpriteWithParams(
													null,
													var_baf[fightAnim.var_b97],
													0, 0, -1, 2000, (byte)6);
									fightAnim.var_c97[fightAnim.var_ca7]
											.setPixelPosition(
													fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelX
															+ fightAnim
																	.sub_1640(
																			fightAnim.var_c97[fightAnim.var_ca7],
																			fightAnim.someUnitsSprites[fightAnim.var_ca7].spriteFrameWidth + 2),
													fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelY + 30);
									fightAnim.var_c97[fightAnim.var_ca7].var_c88 = true;
									C_MainCanvas.sub_2af6(200);
									fightAnim.game.sub_188ce(1200);
									C_MainCanvas.playMusicLooped(14, 1);
									fightAnim.game
											.addSomeSprite(fightAnim.var_c97[fightAnim.var_ca7]);
								}
							}
						} else {
							fightAnim.var_c97[fightAnim.var_ca7] = G_Sprite
									.getSpriteWithParams(fightAnim.castSprite, 0, 0,
											0, 1, 50, (byte)0);
							fightAnim.var_c97[fightAnim.var_ca7]
									.setPixelPosition(
											fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelX
													+ fightAnim
															.sub_1640(
																	fightAnim.var_c97[fightAnim.var_ca7],
																	fightAnim.someUnitsSprites[fightAnim.var_ca7].spriteFrameWidth),
											fightAnim.someUnitsSprites[fightAnim.var_ca7].pixelY);
							fightAnim.game
									.addSomeSprite(fightAnim.var_c97[fightAnim.var_ca7]);
						}
					}
					if (++fightAnim.var_ca7 < fightAnim.someUnitsSpitesCountMbAlive) {
						m = 0;
					}
					for (i1 = 0; i1 < fightAnim.someUnitsSpitesCountMbAlive; i1++) {
						if (fightAnim.someUnitsSprites[i1].var_c48 > 0) {
							m = 0;
						} else if ((fightAnim.someUnit1Type != 7)
								&& (fightAnim.someUnitsSprites[i1].var_c48 != -1)) {
							if (fightAnim.someUnitsSprites[i1].var_ca8 == 0) {
								fightAnim.someUnitsSprites[i1].setFrameSequenceByIndex(3,
										fightAnim.var_b9f);
								fightAnim.someUnitsSprites[i1].var_c48 = 1;
								fightAnim.someUnitsSprites[i1].var_ca8 = 1;
								if (fightAnim.someUnit1Type == 8) {
									fightAnim.var_c97[i1].var_c78 = false;
								}
								m = 0;
							} else if (fightAnim.someUnitsSprites[i1].var_ca8 == 1) {
								fightAnim.someUnitsSprites[i1].setFrameSequenceByIndex(0,
										fightAnim.var_b9f);
								fightAnim.someUnitsSprites[i1].var_c48 = -1;
								fightAnim.someUnitsSprites[i1].var_ca8 = 2;
								m = 0;
							}
						}
						if ((fightAnim.someUnit1Type == 8)
								&& (fightAnim.var_c97[i1] != null)
								&& (fightAnim.var_c97[i1].var_c78)) {
							G_Sprite localClass_g_25175;
							(localClass_g_25175 = G_Sprite.getSpriteWithParams(
									fightAnim.game.bSmokeSprite,
									var_baf[fightAnim.var_b97]
											* C_MainCanvas.getRandomWithin(1, 4),
									C_MainCanvas.getRandomWithin(-2, 3), 0, 1,
									50 * C_MainCanvas.getRandomMax(4), (byte) 0))
									.setPixelPosition(
											fightAnim.someUnitsSprites[i1].pixelX
													+ fightAnim
															.sub_1640(
																	localClass_g_25175,
																	fightAnim.var_bb7.spriteFrameWidth),
											fightAnim.var_c97[i1].pixelY
													+ C_MainCanvas
															.getRandomMax(30 - fightAnim.var_c97[i1].spriteFrameHeight)
													- 15);
							localClass_g_25175.var_c88 = true;
							fightAnim.game
									.addSomeSprite(localClass_g_25175);
						}
					}
					if (m != 0) {
						if (fightAnim.someUnit1.unitType == 9) {
							fightAnim.var_ba7 = 6;
						} else {
							fightAnim.var_ba7 = 4;
						}
						fightAnim.var_c77 = 400;
						if (fightAnim.someUnit1.unitType == 8) {
							fightAnim.var_c77 = 0;
						}
						fightAnim.someFATime = fightAnim.game.someGameTime;
						fightAnim.var_c6f = 0;
					}
				}
				break;
			case 2:
			case 3:
			case 5:
			default:
				break;
			case 4:
				if (fightAnim.var_c6f == 0) {
					if (fightAnim.game.someGameTime
							- fightAnim.someFATime < fightAnim.var_c77) {
						break;
					}
					fightAnim.hclass.drawAfterAttackEffects();
					if (fightAnim.someUnit1Type != 1) {
						fightAnim.game.sub_188ce(200);
					}
					C_MainCanvas.sub_2af6(200);
					C_MainCanvas.playMusicLooped(14, 1);
					if (fightAnim.castEffectSprite != null) {
						fightAnim.var_c9f = A_Unit.unitsFACharacterPositions[fightAnim.someUnit1Type].length;
					}
					fightAnim.var_c6f = 1;
					break;
				}
				if (fightAnim.var_c6f != 1) {
					break;
				}
				if (--fightAnim.var_c9f < 0) {
					fightAnim.var_ba7 = 7;
					fightAnim.someFATime = fightAnim.game.someGameTime;
					break;
				}
				if ((fightAnim.someUnit1Type != 3)
						&& (fightAnim.someUnit1Type != 2)
						&& (fightAnim.someUnit1Type != 1)) {
					someSprite = G_Sprite.getSpriteWithParams(
							fightAnim.castEffectSprite, 0, 0, 0, -1, 0,
							(byte) 0);
				} else {
					someSprite = G_Sprite
							.getSpriteWithParams(fightAnim.castEffectSprite, 0, 0, 0, 1,
									0, (byte) 0);
				}
				if ((fightAnim.someUnit1Type == 2)
						|| (fightAnim.someUnit1Type == 1)) {
					someSprite.var_c80 = false;
				}
				int i5 = C_MainCanvas
						.getRandomMax(fightAnim.game.someCanWidth / 2
								- someSprite.spriteFrameWidth);
				i1 = 0;
				if (fightAnim.hclass.fightAnimBackgroundImage != null) {
					i1 = 0 + (fightAnim.hclass.fightAnimBackgroundImage.imageHeight - someSprite.spriteFrameHeight);
				}
				m = (fightAnim.game.faViewPortHeight - i1)
						* ((fightAnim.var_c9f << 1) + 1)
						/ (A_Unit.unitsFACharacterPositions[fightAnim.someUnit1Type].length << 1)
						- someSprite.spriteFrameHeight / 2 + i1;
				if (fightAnim.var_b97 == 0) {
					i5 += fightAnim.game.someCanWidthDiv2;
				}
				if ((fightAnim.someUnit1Type == 7)
						|| (fightAnim.someUnit1Type == 6)) {
					someSprite.var_c38 = m;
					m = 0;
				}
				someSprite.setPixelPosition(i5, m);
				fightAnim.game.addSomeSprite(someSprite);
				for (int it = 0; it < 3; it++) {
					G_Sprite someSpriteX;
					if ((fightAnim.someUnit1Type != 7) // catapult
							&& (fightAnim.someUnit1Type != 6)) { //colossus
						someSpriteX = G_Sprite.getSpriteWithParams(
								fightAnim.game.bSmokeSprite,
								C_MainCanvas.getRandomWithin(-1, 2), 0, -1, 1, 100,
								(byte) 0);
						someSpriteX.setPixelPosition(
										i5
												+ C_MainCanvas
														.getRandomMax(someSprite.spriteFrameWidth
																- someSpriteX.spriteFrameWidth),
										m + someSprite.spriteFrameHeight
												- someSpriteX.spriteFrameHeight
												+ 1);
					} else {
						(someSpriteX = G_Sprite.getSpriteWithParams(
								fightAnim.game.smokeSprite,
								C_MainCanvas.getRandomWithin(-1, 2), 0,
								C_MainCanvas.getRandomWithin(-2, 0), 1,
								C_MainCanvas.getRandomMax(4) * 50, (byte) 0))
								.setPixelPosition(
										i5
												+ C_MainCanvas
														.getRandomMax(someSprite.spriteFrameWidth
																- someSpriteX.spriteFrameWidth),
										someSprite.var_c38
												+ someSprite.spriteFrameHeight
												- someSpriteX.spriteFrameHeight
												+ 1);
						someSpriteX.var_c38 = (-someSprite.spriteFrameHeight / 2);
					}
					fightAnim.game.addSomeSprite(someSpriteX);
				}
				break;
			case 6:
				m = 1;
				for (i1 = 0; i1 < fightAnim.var_c97.length; i1++) {
					if ((fightAnim.someUnit1Type == 9)
							&& (C_MainCanvas.getRandomMax(2) == 0)) {
						G_Sprite localClass_g_25176;
						(localClass_g_25176 = G_Sprite.getSpriteWithParams(
								fightAnim.game.bSmokeSprite,
								C_MainCanvas.getRandomWithin(-2, 1), 0, -1, 1, 100,
								(byte) 0))
								.setPixelPosition(
										fightAnim.var_c97[i1].pixelX
												+ fightAnim
														.sub_1640(
																fightAnim.var_c97[i1],
																0),
										fightAnim.var_c97[i1].pixelY
												+ fightAnim.var_c97[i1].spriteFrameHeight
												- localClass_g_25176.spriteFrameHeight);
						if (fightAnim.var_c97[i1].var_ca8 == 1) {
							localClass_g_25176.var_c98 = fightAnim.hclass.var_b97;
						} else {
							localClass_g_25176.var_c98 = fightAnim.var_b97;
						}
						fightAnim.game
								.addSomeSprite(localClass_g_25176);
					}
					if (fightAnim.someUnit1Type == 9) {
						if (fightAnim.var_b97 == 0) {
							if (fightAnim.var_c97[i1].pixelX >= fightAnim.game.someCanWidth) {
								if (fightAnim.var_c97[i1].var_ca8 == 0) {
									fightAnim.var_c97[i1]
											.setPixelPosition(
													fightAnim.game.someCanWidthDiv2
															- fightAnim.var_c97[i1].spriteFrameWidth,
													fightAnim.var_c97[i1].pixelY);
									fightAnim.var_c97[i1].var_c98 = fightAnim.hclass.var_b97;
									fightAnim.var_c97[i1].var_ca8 = 1;
								} else {
									if (fightAnim.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									fightAnim.game
											.removeSomeSprite(fightAnim.var_c97[i1]);
									fightAnim.var_c97[i1].var_ca8 = 2;
									continue;
								}
							} else {
								m = 0;
								continue;
							}
						} else {
							if (fightAnim.var_b97 != 1) {
								continue;
							}
							if (fightAnim.var_c97[i1].pixelX
									+ fightAnim.var_c97[i1].spriteFrameWidth < 0) {
								if (fightAnim.var_c97[i1].var_ca8 == 0) {
									fightAnim.var_c97[i1]
											.setPixelPosition(
													fightAnim.game.someCanWidthDiv2,
													fightAnim.var_c97[i1].pixelY);
									fightAnim.var_c97[i1].var_c98 = fightAnim.hclass.var_b97;
									fightAnim.var_c97[i1].var_ca8 = 1;
								} else {
									if (fightAnim.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									fightAnim.game
											.removeSomeSprite(fightAnim.var_c97[i1]);
									fightAnim.var_c97[i1].var_ca8 = 2;
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
				fightAnim.var_c6f = 0;
				fightAnim.var_ba7 = 4;
				fightAnim.someFATime = fightAnim.game.someGameTime;
				break;
			}
			if (fightAnim.game.someGameTime
					- fightAnim.someFATime >= 1000L) {
				fightAnim.var_ba7 = 0;
				fightAnim.var_b5f = true;
			}
		}
		if (this.someUnit1Type == 6) {
			for (int j = 0; j < this.someUnitsSprites.length; j++) {
				if (this.someUnitsSprites[j].var_ca0) {
					this.someUnitsSprites[j].var_c38 = (-6 + 4
							* F_StringManager.sub_f0f(this.circleAnimDegrees[j]) >> 10);
					this.circleAnimDegrees[j] = ((this.circleAnimDegrees[j] + 10) % 360);
				}
			}
		}
	}

	private void drawAfterAttackEffects() {
		this.var_b67 = true;
		this.var_c47 = (this.someUnitsCount - this.var_b87);
		this.someUnitsSpitesCountMbAlive = this.var_b87;
		
		for (int j = 0; j < this.var_c47; j++) {
			this.game.removeSomeSprite(this.someUnitsSprites[j]);
			G_Sprite rSparkSprite = G_Sprite.getSpriteWithParams(this.game.redsparkSprite, 0, 0, 0, 1, 0, (byte) 0);
			rSparkSprite.setPixelPosition(this.someUnitsSprites[j].pixelX
					+ (this.someUnitsSprites[j].spriteFrameWidth - rSparkSprite.spriteFrameWidth)
					/ 2, this.game.canvasHeight); 
			rSparkSprite.var_c38 = (this.someUnitsSprites[j].pixelY
					+ (this.someUnitsSprites[j].spriteFrameHeight - rSparkSprite.spriteFrameHeight)
					/ 2 - this.game.canvasHeight); 
			this.game.addSomeSprite(rSparkSprite);
			G_Sprite bSmokeSprite;
			for (int it = 0; it < 3; it++) {
				bSmokeSprite = G_Sprite.getSpriteWithParams(
						this.game.bSmokeSprite, it + -1, 0,
						C_MainCanvas.getRandomWithin(-4, -1), 1,
						C_MainCanvas.getRandomMax(4) * 50, (byte) 0);
				bSmokeSprite.setPixelPosition(
								this.someUnitsSprites[j].pixelX
										+ (this.someUnitsSprites[j].spriteFrameWidth - bSmokeSprite.spriteFrameWidth)
										/ 2, this.someUnitsSprites[j].pixelY
										+ this.someUnitsSprites[j].spriteFrameHeight
										- bSmokeSprite.spriteFrameHeight + 3);
				this.game.addSomeSprite(bSmokeSprite);
			}
			bSmokeSprite = G_Sprite.getSpriteWithParams(this.game.smokeSprite,
					0, 0, -1, 1, 200, (byte) 0);
			bSmokeSprite.setPixelPosition(
							this.someUnitsSprites[j].pixelX
									+ (this.someUnitsSprites[j].spriteFrameWidth - bSmokeSprite.spriteFrameWidth)
									/ 2, this.someUnitsSprites[j].pixelY
									+ this.someUnitsSprites[j].spriteFrameHeight
									- bSmokeSprite.spriteFrameHeight + 3);
			this.game.addSomeSprite(bSmokeSprite);
		}
		G_Sprite[] someSpritesL = new G_Sprite[this.someUnitsSpitesCountMbAlive];
		System.arraycopy(this.someUnitsSprites, this.var_c47, someSpritesL, 0,
				this.someUnitsSpitesCountMbAlive);
		this.someUnitsSprites = someSpritesL;
		String damageString = "" + (this.unitHealthAfterAttack - this.unitHealthBeforeAttack);
		G_Sprite dmgStrSprite = G_Sprite.createSomeSprite(damageString, 0, -4, (byte) 1);
		int aX = 0;
		int aY = 0;
		if (this.var_b87 == 1) {
			aX = this.someUnitsSprites[0].pixelX + this.someUnitsSprites[0].spriteFrameWidth / 2;
			aY = this.someUnitsSprites[0].pixelY + this.someUnitsSprites[0].spriteFrameHeight + 1;
		} else {
			aX = this.game.someCanWidthDiv2 / 2;
			if (this.var_b97 == 1) {
				aX += this.game.someCanWidthDiv2;
			}
			aY = (this.game.faViewPortHeight + this.bgSingleImageHeight) / 2;
		}
		dmgStrSprite.setPixelPosition(aX, aY);
		dmgStrSprite.var_c88 = true;
		this.game.addSomeSprite(dmgStrSprite);
	}

	public final void drawBackgroundShifted(Graphics gr, int shiftX,
			int shiftY) {
		gr.translate(shiftX, shiftY);
		int lefX = 0;
		int itX = 0;
		int countX = this.bgMultXCount;
		while (itX < countX) {
			int topY = this.bgSingleImageHeight + shiftY;
			int itY = 0;
			int countY = this.bgMultYCount;
			while (itY < countY) {
				this.bgMultipleImages[this.bgMultipleRandomPositions[itX][itY]].drawOnGraphics(gr, lefX, topY);
				topY += 24;
				itY++;
			}
			lefX += 24;
			itX++;
		}
		if (this.fightAnimBackgroundImage != null) {
			//draw fa bg Image
			int fabgImWidth = this.fightAnimBackgroundImage.imageWidth;
			int leftX = 0;
			int it = 0;
			int fabgImagesCount = (this.game.someCanWidthDiv2 + fabgImWidth - 1) / fabgImWidth;
			while (it < fabgImagesCount) {
				this.fightAnimBackgroundImage.drawOnGraphics(gr, leftX, 0);
				leftX += fabgImWidth;
				it++;
			}
		}
		gr.translate(-shiftX, -shiftY);
	}

	public final void drawUnitHealthStatus(Graphics gr) {
		int height = this.game.canvasHeight - G_Game.var_4592 / 2; 
		C_MainCanvas.sub_2007(gr, this.unitHealth + "/" + 100,
				this.game.someCanWidthDiv2 / 2, height, 1, 3);
	}

	public final void drawSomeArcOverUnits(Graphics gr) {
		gr.setColor(4210752); //#404040 darkgray
		for (int i = 0; i < this.someUnitsSpitesCountMbAlive; i++) {
			G_Sprite unitSprite = this.someUnitsSprites[i];
			if ((this.someUnit1Type == 0) || (this.someUnit1Type == 4) //soldier wisp wolf golem
					|| (this.someUnit1Type == 5) || (this.someUnit1Type == 6)) {
				gr.fillArc(unitSprite.pixelX,
						unitSprite.pixelY
								+ (unitSprite.spriteFrameHeight << 2) / 5,
						unitSprite.spriteFrameWidth,
						unitSprite.spriteFrameHeight / 4, 0, 360);
			}
		}
	}

	static {
		//new byte[] { 18 }[1] = -18;
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_h_0417
 * 
 * JD-Core Version: 0.7.0.1
 */