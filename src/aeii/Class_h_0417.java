package aeii;

import a.a.a.Class_g_2517;
import java.util.Random;
import javax.microedition.lcdui.Graphics;

public final class Class_h_0417 {

	private static String[] var_b1f = { "road", "grass", "woods", "hill",
			"mountain", "water", "bridge", "town" };
	private static byte[] var_b27 = { 0, 1, 1, 1, 4, 5, 6, 7, 7, 7 };
	private static byte[] var_b2f = { 0, 1, 2, 3, 4, 5, 6, 7, 7, 7 };
	private static String[] var_b37 = { "soldier", "archer", "lizard",
			"wizard", "wisp", "spider", "golem", "catapult", "wyvern", "king",
			"skeleton" };
	private Class_g_1956 var_b3f;
	public Class_a_0260 var_b47;
	private byte var_b4f;
	public boolean var_b57 = false;
	public boolean var_b5f = false;
	private boolean var_b67;
	private byte var_b6f;
	public byte var_b77;
	private byte var_b7f;
	public byte var_b87;
	private byte var_b8f;
	private byte var_b97;
	private boolean var_b9f;
	private int var_ba7 = 0;
	private static byte[] var_baf = { 3, -3 };
	private Class_g_2517 var_bb7;
	private Class_g_2517 var_bbf;
	private Class_g_2517 var_bc7;
	private Class_g_2517 var_bcf;
	private int var_bd7;
	private int var_bdf;
	private long var_be7;
	private long var_bef;
	private Class_g_2517[] var_bf7;
	private Class_d_0033[] var_bff;
	private Class_d_0033 var_c07;
	public Class_h_0417 var_c0f;
	private int var_c17;
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
	private Class_g_2517 var_c87;
	private Class_g_2517 var_c8f;
	private Class_g_2517[] var_c97;
	private int var_c9f;
	private int var_ca7;
	private Object localClass_h_04172;

	public Class_h_0417(Class_g_1956 paramClass_g_1956,
			Class_a_0260 paramClass_a_0260, Class_h_0417 paramClass_h_0417) {
		this.var_b3f = paramClass_g_1956;
		this.var_b47 = paramClass_a_0260;
		this.var_b4f = paramClass_a_0260.var_e2b;
		this.var_c0f = paramClass_h_0417;
		this.var_b6f = ((byte) paramClass_a_0260.var_e7b);
		this.var_c3f = this.var_b6f;
		this.var_b7f = ((byte) paramClass_a_0260.sub_16bf());
		this.var_b8f = this.var_b7f;
		int i = 0;
		if (paramClass_h_0417 == null) {
			this.var_b97 = 0;
			this.var_bd7 = 0;
			this.var_b9f = true;
		} else {
			i = paramClass_g_1956.var_45aa;
			this.var_b97 = 1;
			this.var_ba7 = 0;
		}
		this.var_c17 = paramClass_g_1956.sub_11671(paramClass_a_0260.var_e3b,
				paramClass_a_0260.var_e43);
		int j = var_b2f[this.var_c17];
		int k = var_b27[this.var_c17];
		if ((paramClass_h_0417 != null)
				&& (k == var_b27[paramClass_h_0417.var_c17])) {
			this.var_bff = new Class_d_0033[paramClass_h_0417.var_bff.length];
			System.arraycopy(paramClass_h_0417.var_bff, 0, this.var_bff, 0,
					this.var_bff.length);
		} else {
			this.var_bff = new Class_g_2517(var_b1f[k]).var_bf0;
		}
		if (this.var_b97 == 1) {
			for (k = 0; k < this.var_bff.length; k++) {
				this.var_bff[k] = new Class_d_0033(this.var_bff[k], 1);
			}
		}
		try {
			if ((paramClass_h_0417 != null)
					&& (j == var_b2f[paramClass_h_0417.var_c17])) {
				this.var_c07 = paramClass_h_0417.var_c07;
			} else {
				this.var_c07 = new Class_d_0033(var_b1f[j] + "_bg");
			}
			if (this.var_b97 == 1) {
				this.var_c07 = new Class_d_0033(this.var_c07, 1);
			}
		} catch (Exception localException) {
		}
		if (this.var_c07 != null) {
			this.var_c1f = this.var_c07.var_6b9;
		}
		this.var_c27 = (paramClass_g_1956.var_45aa / this.var_bff[0].var_6b1);
		if (paramClass_g_1956.var_45aa % this.var_bff[0].var_6b1 != 0) {
			this.var_c27 += 1;
		}
		this.var_c2f = ((paramClass_g_1956.var_4eba - this.var_c1f) / this.var_bff[0].var_6b9);
		if ((paramClass_g_1956.var_4eba - this.var_c1f)
				% this.var_bff[0].var_6b9 != 0) {
			this.var_c2f += 1;
		}
		this.var_c7f = new byte[this.var_c27][this.var_c2f];
		for (k = 0; k < this.var_c27; k++) {
			for (j = 0; j < this.var_c2f; j++) {
				this.var_c7f[k][j] = ((byte) Math.abs(Class_c_0282.var_17f7
						.nextInt() % this.var_bff.length));
			}
		}
		this.var_bb7 = new Class_g_2517(var_b37[this.var_b4f],
				paramClass_g_1956.var_4832[paramClass_a_0260.var_e33]);
		if ((paramClass_h_0417 != null)
				&& (paramClass_h_0417.var_b4f == this.var_b4f)) {
			if (paramClass_h_0417.var_bcf != null) {
				this.var_bcf = new Class_g_2517(paramClass_h_0417.var_bcf);
			}
			if (paramClass_h_0417.var_bbf != null) {
				this.var_bbf = new Class_g_2517(paramClass_h_0417.var_bbf);
			}
			if (paramClass_h_0417.var_bc7 != null) {
				this.var_bc7 = new Class_g_2517(paramClass_h_0417.var_bc7);
			}
			if (paramClass_h_0417.var_c87 != null) {
				this.var_c87 = new Class_g_2517(paramClass_h_0417.var_c87);
				this.var_c8f = new Class_g_2517(paramClass_h_0417.var_c8f);
			}
		} else if ((this.var_b4f != 0) && (this.var_b4f != 10)
				&& (this.var_b4f != 5)) {
			if (this.var_b4f == 1) {
				this.var_bc7 = new Class_g_2517("archer_arrow");
			} else if (this.var_b4f == 9) {
				this.var_bbf = new Class_g_2517("kingwave");
				this.var_bcf = new Class_g_2517("kingslash");
				this.var_c87 = new Class_g_2517("king_heads");
				this.var_c8f = new Class_g_2517("king_heads_back");
			} else if (this.var_b4f == 2) {
				this.var_bbf = new Class_g_2517("watermagic");
				this.var_bc7 = new Class_g_2517("fish");
			} else if ((this.var_b4f != 7) && (this.var_b4f != 6)) {
				if (this.var_b4f == 3) {
					this.var_bbf = new Class_g_2517("spell");
					this.var_bc7 = this.var_bbf;
				}
			} else {
				this.var_bc7 = new Class_g_2517("crater");
			}
		} else {
			this.var_bcf = new Class_g_2517("slash");
		}
		if (this.var_bbf != null) {
			this.var_bbf.sub_1bce(0, this.var_b9f);
		}
		if (this.var_bc7 != null) {
			this.var_bc7.sub_1bce(0, this.var_b9f);
		}
		if (this.var_bcf != null) {
			this.var_bcf.sub_1bce(0, this.var_b9f);
		}
		if (this.var_c87 != null) {
			this.var_c87.sub_1bce(paramClass_a_0260.var_eeb, this.var_b9f);
			this.var_c87.sub_1afa(paramClass_a_0260.var_eeb);
			this.var_c8f.sub_1bce(0, this.var_b9f);
			this.var_c8f.sub_1afa(paramClass_a_0260.var_eeb);
		}
		this.var_c4f = new int[paramClass_a_0260.var_e0b.length][2];
		for (k = 0; k < this.var_c4f.length; k++) {
			this.var_c4f[k][0] = (paramClass_a_0260.var_e0b[k][0]
					* paramClass_g_1956.j / 128); // @todo see "long j" or
													// "int j" or "byte j"
			if (this.var_b97 == 1) {
				this.var_c4f[k][0] = (paramClass_g_1956.var_45aa
						- this.var_c4f[k][0] - this.var_bb7.var_c20 + i);
			}
			this.var_c4f[k][1] = (paramClass_a_0260.var_e0b[k][1]
					* paramClass_g_1956.var_4eba / 128 - this.var_bb7.var_c28);
		}
		this.var_bf7 = new Class_g_2517[this.var_b7f];
		if ((this.var_b4f == 4) || (this.var_b4f == 6)) {
			this.var_c57 = new int[this.var_b7f];
		}
		for (k = 0; k < this.var_b7f; k++) {
			this.var_bf7[k] = new Class_g_2517(this.var_bb7);
			paramClass_g_1956.sub_18887(this.var_bf7[k]);
			this.var_bf7[k].sub_1b36(this.var_c4f[k][0], this.var_c4f[k][1]);
			this.var_bf7[k].sub_1bce(0, this.var_b9f);
			this.var_bf7[k].var_c80 = false;
			this.var_bf7[k].var_c68 = 0;
			if (this.var_b4f == 6) {
				this.var_bf7[k].var_ca0 = true;
				this.var_c57[k] = Class_c_0282.sub_19e8(360);
				this.var_bf7[k].var_c38 = (-6 + 4
						* Class_f_0145.sub_f0f(this.var_c57[k]) >> 10);
			} else if (this.var_b4f == 4) {
				this.var_bf7[k].var_ca0 = true;
				this.var_bf7[k].var_c38 = (-5 - Class_c_0282.sub_19e8(10));
				this.var_c57[k] = Class_c_0282.sub_19e8(360);
			} else if (this.var_b4f == 9) {
				this.var_bf7[k].var_cc0 = this.var_c87;
				this.var_bf7[k].var_cc8 = this.var_c8f;
			}
		}
	}

	private int sub_1640(Class_g_2517 paramClass_g_2517, int paramInt) {
		if (this.var_b97 == 1) {
			return this.var_bb7.var_c20 - paramInt - paramClass_g_2517.var_c20;
		}
		return paramInt;
	}

	public final void sub_1688() {
		this.var_b57 = true;
		this.var_ba7 = 1;
		this.var_bef = this.var_b3f.var_479a;
	}

	public final void sub_16b8() {
		if ((this.var_b67) && (this.var_c3f > this.var_b77)) {
			this.var_c3f -= 2;
			if (this.var_c3f < this.var_b77) {
				this.var_c3f = this.var_b77;
			}
			this.var_b3f.var_4eb2 = true;
		}
		int k;
		int i3;
		if ((this.var_b4f != 8) && (this.var_b4f != 9) && (this.var_b4f != 7)
				&& (this.var_b4f != 1) && (this.var_b4f != 3)
				&& (this.var_b4f != 2) && (this.var_b4f != 6)) {
			if (this.var_b4f == 4) {
				Class_h_0417 localClass_h_04171 = this;
				switch (this.var_ba7) {
				case 1:
					if (localClass_h_04171.var_c6f == 0) {
						if (localClass_h_04171.var_b3f.var_479a
								- localClass_h_04171.var_bef >= 200L) {
							localClass_h_04171.var_c6f = 1;
							localClass_h_04171.var_bef = localClass_h_04171.var_b3f.var_479a;
						}
					} else {
						Object localObject;
						if (localClass_h_04171.var_c6f == 1) {
							localClass_h_04171.var_c67 += 5;
							if (localClass_h_04171.var_c67 >= 90) {
								localClass_h_04171.var_c6f += 1;
								localClass_h_04171.var_bef = localClass_h_04171.var_b3f.var_479a;
							}
							if ((localClass_h_04171.var_c67 - 20) % 15 == 0) {
								for (k = 0; k < localClass_h_04171.var_bf7.length; k++) {
									Class_g_2517 clas;
									(clas = Class_g_2517
											.sub_2054(
													localClass_h_04171.var_b3f.var_4a72,
													Class_c_0282
															.sub_1a08(-1, 2),
													0, 0, 1, 100, (byte) 0))
											.sub_1b36(
													localClass_h_04171.var_bf7[k].var_c08
															+ Class_c_0282
																	.sub_19e8(localClass_h_04171.var_bb7.var_c20
																			- ((Class_g_2517) clas).var_c20),
													localClass_h_04171.var_bf7[k].var_c10
															+ localClass_h_04171.var_bb7.var_c28
															- ((Class_g_2517) clas).var_c28
															+ 1);
									localClass_h_04171.var_b3f
											.sub_18887((Class_g_2517) clas);
								}
							}
						} else if ((localClass_h_04171.var_c6f == 2)
								&& (localClass_h_04171.var_b3f.var_479a
										- localClass_h_04171.var_bef >= 400L)) {
							localClass_h_04171.var_c67 = 20;
							localClass_h_04171.var_c0f.sub_331c();
							localClass_h_04171.var_ba7 = 4;
							localClass_h_04171.var_c0f.var_c37 = false;
							localClass_h_04171.var_bef = localClass_h_04171.var_b3f.var_479a;
						}
						if (++localClass_h_04171.var_c5f >= 2) {
							for (k = 0; k < localClass_h_04171.var_c0f.var_bf7.length; k++) {
								Class_g_2517 clas;
								(clas = Class_g_2517.sub_2054(
										localClass_h_04171.var_b3f.var_4752, 0,
										0, 0, 1, 50, (byte) 0))
										.sub_1b36(
												localClass_h_04171.var_c0f.var_bf7[k].var_c08
														+ Class_c_0282
																.sub_19e8(localClass_h_04171.var_c0f.var_bf7[k].var_c20
																		- ((Class_g_2517) clas).var_c20),
												localClass_h_04171.var_c0f.var_bf7[k].var_c10
														+ Class_c_0282
																.sub_19e8(localClass_h_04171.var_c0f.var_bf7[k].var_c28
																		- ((Class_g_2517) clas).var_c28));
								((Class_g_2517) clas).var_c88 = true;
								localClass_h_04171.var_b3f
										.sub_18887((Class_g_2517) clas);
							}
							localClass_h_04171.var_c5f = 0;
							localObject = localClass_h_04171.var_c0f;
							for (int i2 = 0; i2 < ((Class_h_0417) localObject).var_b8f; i2++) {
								((Class_h_0417) localObject).var_bf7[i2].var_c90 = 6;
							}
						}
					}
					break;
				case 4:
					if (localClass_h_04171.var_b3f.var_479a
							- localClass_h_04171.var_bef >= 800L) {
						localClass_h_04171.var_b5f = true;
						localClass_h_04171.var_ba7 = 0;
					}
					break;
				}
				k = 0;
				if (localClass_h_04171.var_b3f.var_479a
						- localClass_h_04171.var_be7 >= 300L) {
					k = 1;
					localClass_h_04171.var_be7 = localClass_h_04171.var_b3f.var_479a;
				}
				for (int n = 0; n < localClass_h_04171.var_bf7.length; n++) {
					if (k != 0) {
						Class_g_2517 localClass_g_25173;
						(localClass_g_25173 = Class_g_2517.sub_2054(null, 0, 0,
								0, 1, 500, (byte) 4))
								.sub_1b36(
										localClass_h_04171.var_bf7[n].var_c08
												+ (localClass_h_04171.var_bf7[n].var_c20 >> 1),
										localClass_h_04171.var_bf7[n].var_c10
												+ (localClass_h_04171.var_bf7[n].var_c28 >> 1)
												+ localClass_h_04171.var_bdf);
						localClass_h_04171.var_b3f
								.sub_18887(localClass_g_25173);
					}
					i3 = localClass_h_04171.var_bf7[n].var_c20 / 3;
					localClass_h_04171.var_bf7[n]
							.sub_1b36(
									localClass_h_04171.var_c4f[n][0]
											+ (i3
													* Class_f_0145
															.sub_f35(localClass_h_04171.var_c57[n]) >> 10),
									localClass_h_04171.var_c4f[n][1]
											+ (i3
													* Class_f_0145
															.sub_f0f(localClass_h_04171.var_c57[n])
													/ 3 >> 10));
					localClass_h_04171.var_c57[n] = ((localClass_h_04171.var_c57[n] + localClass_h_04171.var_c67) % 360);
				}
			} else {
				int i;
				switch (this.var_ba7) {
				case 1:
					if (this.var_b3f.var_479a - this.var_bef >= 200L) {
						this.var_ba7 = 3;
					}
				case 2:
				case 5:
				default:
					break;
				case 3:
					i = 1;
					Class_g_2517 localClass_g_25172;
					if (this.var_c6f < this.var_b8f) {
						if ((this.var_b4f == 0) || (this.var_b4f == 5)) {
							this.var_bf7[this.var_c6f].var_c70 = -6;
						}
						if (this.var_b4f == 5) {
							this.var_bf7[this.var_c6f].var_c60 = (2 * var_baf[this.var_b97]);
							for (k = 0; k < 3; k++) {
								(localClass_g_25172 = Class_g_2517.sub_2054(
										this.var_b3f.var_4a72,
										Class_c_0282.sub_1a08(-1, 2), 0, -1, 1,
										100, (byte) 0))
										.sub_1b36(
												this.var_bf7[this.var_c6f].var_c08
														+ Class_c_0282
																.sub_19e8(this.var_bb7.var_c20
																		- localClass_g_25172.var_c20),
												this.var_bf7[this.var_c6f].var_c10
														+ this.var_bb7.var_c28
														- localClass_g_25172.var_c28
														+ 1);
								this.var_b3f.sub_18887(localClass_g_25172);
							}
						}
						this.var_bf7[this.var_c6f].var_c60 = var_baf[this.var_b97];
						this.var_bf7[this.var_c6f].sub_1bce(1, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (k = 0; k < this.var_c6f; k++) {
						if (this.var_b4f == 10) {
							if (this.var_bf7[k].var_ca8 != -1) {
								this.var_bf7[k].var_ca8 += 1;
								if (this.var_bf7[k].var_ca8 >= 16) {
									this.var_bf7[k].sub_1bce(2, this.var_b9f);
									this.var_bf7[k].var_c60 = 0;
									this.var_bf7[k].var_ca8 = -1;

									(localClass_g_25172 = Class_g_2517
											.sub_2054(null, 0, 0, 0, 1, 800,
													(byte) 2))
											.sub_1b36(
													this.var_bf7[k].var_c08
															+ sub_1640(
																	localClass_g_25172,
																	this.var_bb7.var_c20),
													this.var_bf7[k].var_c10
															+ this.var_bb7.var_c28);
									this.var_b3f.sub_18887(localClass_g_25172);
									(localClass_g_25172 = Class_g_2517
											.sub_2054(this.var_bcf, 0, 0, 0, 1,
													150, (byte) 0)).sub_1b36(
											this.var_bf7[k].var_c08
													+ sub_1640(
															localClass_g_25172,
															24),
											this.var_bf7[k].var_c10 + 3);
									this.var_b3f.sub_18887(localClass_g_25172);
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
							if ((this.var_b4f == 0) || (this.var_b4f == 5)) {
								this.var_bf7[k].sub_1bce(2, this.var_b9f);
								if (this.var_b4f == 0) {
									(localClass_g_25172 = Class_g_2517
											.sub_2054(this.var_bcf, 0, 0, 0, 1,
													150, (byte) 0)).sub_1b36(
											this.var_bf7[k].var_c08
													+ sub_1640(
															localClass_g_25172,
															14),
											this.var_bf7[k].var_c10
													+ this.var_bf7[k].var_c28);
									localClass_g_25172.var_c38 = (4 - this.var_bf7[k].var_c28);
									this.var_b3f.sub_18887(localClass_g_25172);
								} else if (this.var_b4f == 5) {
									(localClass_g_25172 = Class_g_2517
											.sub_2054(this.var_b3f.var_4752, 0,
													0, 0, 1, 50, (byte) 0))
											.sub_1b36(
													this.var_bf7[k].var_c08
															+ sub_1640(
																	localClass_g_25172,
																	this.var_bb7.var_c20 * 3 / 4),
													this.var_bf7[k].var_c10
															+ this.var_bf7[k].var_c28);
									localClass_g_25172.var_c38 = (-localClass_g_25172.var_c28);
									this.var_b3f.sub_18887(localClass_g_25172);
								}
							}
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_c6f = 0;
					this.var_ba7 = 6;
					this.var_c0f.sub_331c();
					this.var_b3f.sub_188ce(200);
					Class_c_0282.sub_2af6(200);
					Class_c_0282.sub_2c63(14, 1);
					this.var_bef = this.var_b3f.var_479a;
					break;
				case 4:
					i = 1;
					if (this.var_c6f < this.var_b8f) {
						if ((this.var_b4f != 0) && (this.var_b4f != 2)
								&& (this.var_b4f != 5)) {
							if (this.var_b4f == 10) {
								this.var_bf7[this.var_c6f].var_ca8 = 0;
							}
						} else {
							this.var_bf7[this.var_c6f].var_c70 = -6;
						}
						if (this.var_b4f == 5) {
							this.var_bf7[this.var_c6f].var_c60 = (-2 * var_baf[this.var_b97]);
						} else {
							this.var_bf7[this.var_c6f].var_c60 = (-var_baf[this.var_b97]);
						}
						this.var_bf7[this.var_c6f].sub_1bce(3, this.var_b9f);
						this.var_c6f += 1;
						i = 0;
					}
					for (k = 0; k < this.var_c6f; k++) {
						if (this.var_b4f == 10) {
							if (this.var_bf7[k].var_ca8 != -1) {
								this.var_bf7[k].var_ca8 += 1;
								if (this.var_bf7[k].var_ca8 >= 16) {
									this.var_bf7[k].sub_1bce(0, this.var_b9f);
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
							this.var_bf7[k].sub_1bce(0, this.var_b9f);
						}
					}
					if (i == 0) {
						//break label2184; //@todo
					}
					this.var_b5f = true;
					this.var_ba7 = 0;
					this.var_bef = this.var_b3f.var_479a;
					break;
				}
				if (((this.var_b4f == 10) && (this.var_b3f.var_479a
						- this.var_bef >= 400L))
						|| (((this.var_b4f == 0) || (this.var_b4f == 2) || (this.var_b4f == 5)) && (this.var_b3f.var_479a
								- this.var_bef >= 50L))) {
					this.var_ba7 = 4;
				}
			}
		} else {
			//label2184:
			Class_h_0417 localClass_h_04172 = this;
			int i1;
			int m;
			Class_g_2517 localClass_g_25177;
			switch (this.var_ba7) {
			case 1:
				Class_g_2517 localClass_g_25174;
				if (localClass_h_04172.var_b4f == 6) {
					if (localClass_h_04172.var_c6f == 0) {
						if (localClass_h_04172.var_b3f.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca8 = -1;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca0 = false;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = 0;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
								localClass_h_04172.var_ca7 = 0;
								localClass_h_04172.var_c6f = 1;
								localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
								break;
							}
						}
					} else if (localClass_h_04172.var_c6f == 1) {
						if (localClass_h_04172.var_b3f.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = -1;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
								localClass_h_04172.var_ca7 = 0;
								localClass_h_04172.var_c6f = 2;
								localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
								break;
							}
						}
					} else if (localClass_h_04172.var_c6f == 2) {
						k = 1;
						if (localClass_h_04172.var_b3f.var_479a
								- localClass_h_04172.var_bef >= 200L) {
							if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_ca8 = 0;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c70 = 0;
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7]
										.sub_1bce(2, localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c48 = 1;
							}
							if (++localClass_h_04172.var_ca7 >= localClass_h_04172.var_b8f) {
							}
						} else {
							k = 0;
						}
						for (i1 = 0; i1 < localClass_h_04172.var_b8f; i1++) {
							if (localClass_h_04172.var_bf7[i1].var_ca8 == 0) {
								if (localClass_h_04172.var_bf7[i1].var_c00 == 1) {
									localClass_h_04172.var_bf7[i1].var_c38 = 0;
									localClass_h_04172.var_bf7[i1].var_ca8 = 1;
									Class_c_0282.sub_2af6(200);
									localClass_h_04172.var_b3f.sub_188ce(1200);
									Class_c_0282.sub_2c63(14, 1);
									for (i3 = 0; i3 < 2; i3++) {
										Class_g_2517 localClass_g_25171;
										(localClass_g_25171 = Class_g_2517
												.sub_2054(
														localClass_h_04172.var_b3f.var_4742,
														0,
														0,
														-1,
														1,
														Class_c_0282
																.sub_19e8(4) * 50,
														(byte) 0))
												.sub_1b36(
														localClass_h_04172.var_bf7[i1].var_c08
																+ Class_c_0282
																		.sub_19e8(localClass_h_04172.var_bb7.var_c20
																				- localClass_g_25171.var_c20),
														localClass_h_04172.var_bf7[i1].var_c10
																+ localClass_h_04172.var_bb7.var_c28
																- localClass_g_25171.var_c28
																+ 2);
										localClass_g_25171.var_c88 = true;
										localClass_h_04172.var_b3f
												.sub_18887(localClass_g_25171);
									}
									(localClass_g_25174 = Class_g_2517
											.sub_2054(
													localClass_h_04172.var_b3f.var_4742,
													-1,
													0,
													-1,
													1,
													Class_c_0282.sub_19e8(4) * 50,
													(byte) 0))
											.sub_1b36(
													localClass_h_04172.var_bf7[i1].var_c08,
													localClass_h_04172.var_bf7[i1].var_c10
															+ localClass_h_04172.var_bb7.var_c28
															- localClass_g_25174.var_c28
															+ 2);
									localClass_g_25174.var_c88 = true;
									localClass_h_04172.var_b3f
											.sub_18887(localClass_g_25174);
									(localClass_g_25174 = Class_g_2517
											.sub_2054(
													localClass_h_04172.var_b3f.var_4742,
													1,
													0,
													-1,
													1,
													Class_c_0282.sub_19e8(4) * 50,
													(byte) 0))
											.sub_1b36(
													localClass_h_04172.var_bf7[i1].var_c08
															+ localClass_h_04172.var_bb7.var_c20
															- localClass_g_25174.var_c20,
													localClass_h_04172.var_bf7[i1].var_c10
															+ localClass_h_04172.var_bb7.var_c28
															- localClass_g_25174.var_c28
															+ 2);
									localClass_g_25174.var_c88 = true;
									localClass_h_04172.var_b3f
											.sub_18887(localClass_g_25174);
								}
								m = 0;
							} else if (localClass_h_04172.var_bf7[i1].var_ca8 != -1) {
								if (localClass_h_04172.var_bf7[i1].var_c48 > 0) {
									m = 0;
								} else if (localClass_h_04172.var_bf7[i1].var_c48 != -1) {
									if (localClass_h_04172.var_bf7[i1].var_ca8 == 1) {
										localClass_h_04172.var_bf7[i1]
												.sub_1bce(
														3,
														localClass_h_04172.var_b9f);
										localClass_h_04172.var_bf7[i1].var_c48 = 1;
										localClass_h_04172.var_bf7[i1].var_ca8 = 2;
										m = 0;
									} else if (localClass_h_04172.var_bf7[i1].var_ca8 == 2) {
										localClass_h_04172.var_bf7[i1].var_c38 = -6;
										localClass_h_04172.var_bf7[i1].var_ca0 = true;
										localClass_h_04172.var_bf7[i1].var_c70 = Class_c_0282
												.sub_1a08(-2, 3);
										localClass_h_04172.var_bf7[i1]
												.sub_1bce(
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
							localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
							localClass_h_04172.var_ba7 = 4;
							break;
						}
					}
				} else if (localClass_h_04172.var_c6f == 0) {
					if (localClass_h_04172.var_b3f.var_479a
							- localClass_h_04172.var_bef >= 200L) {
						if (localClass_h_04172.var_b4f == 9) {
							localClass_h_04172.var_c97 = new Class_g_2517[localClass_h_04172.var_b8f << 1];
						} else if ((localClass_h_04172.var_b4f != 7)
								&& (localClass_h_04172.var_b4f != 1)) {
							localClass_h_04172.var_c97 = new Class_g_2517[localClass_h_04172.var_b8f];
						}
						localClass_h_04172.var_c6f = 1;
						localClass_h_04172.var_ca7 = 0;
						localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
						break;
					}
				} else if (localClass_h_04172.var_c6f == 1) {
					m = 1;
					if (localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
						localClass_h_04172.var_bf7[localClass_h_04172.var_ca7]
								.sub_1bce(2, localClass_h_04172.var_b9f);
						localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c48 = 1;
						if ((localClass_h_04172.var_b4f != 3)
								&& (localClass_h_04172.var_b4f != 2)) {
							if (localClass_h_04172.var_b4f == 1) {
								(localClass_g_25177 = Class_g_2517.sub_2054(
										localClass_h_04172.var_bc7, 0, 0, 0, 1,
										0, (byte) 0)).sub_1bce(1,
										localClass_h_04172.var_b9f);
								localClass_g_25177
										.sub_1b36(
												localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c08
														+ localClass_h_04172
																.sub_1640(
																		localClass_g_25177,
																		localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c20),
												localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c10);
								localClass_h_04172.var_b3f
										.sub_18887(localClass_g_25177);
							} else {
								if (localClass_h_04172.var_b4f == 7) {
									localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c90 = 5;
									for (i1 = 0; i1 < 3; i1++) {
										(localClass_g_25174 = Class_g_2517
												.sub_2054(
														localClass_h_04172.var_b3f.var_4a72,
														Class_c_0282.sub_1a08(
																-1, 2),
														0,
														0,
														1,
														Class_c_0282
																.sub_19e8(4) * 50,
														(byte) 0))
												.sub_1b36(
														localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c08
																+ localClass_h_04172.var_bb7.var_c20
																/ 2,
														localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c10);
										localClass_g_25174.var_c88 = true;
										localClass_h_04172.var_b3f
												.sub_18887(localClass_g_25174);
									}
								}
								if (localClass_h_04172.var_b4f == 9) {
									(localClass_g_25177 = Class_g_2517
											.sub_2054(
													localClass_h_04172.var_bcf,
													0, 0, 0, 1, 200, (byte) 0))
											.sub_1b36(
													localClass_h_04172.var_bf7[0].var_c08,
													localClass_h_04172.var_bf7[0].var_c10
															+ localClass_h_04172.var_bb7.var_c28);
									localClass_g_25177.var_c38 = (-localClass_h_04172.var_bb7.var_c28);
									localClass_h_04172.var_b3f
											.sub_18887(localClass_g_25177);
									localClass_h_04172.var_c97[0] = Class_g_2517
											.sub_2054(
													localClass_h_04172.var_bbf,
													var_baf[localClass_h_04172.var_b97] * 3,
													-2, 0, -1, 100, (byte)0);
									int i4 = localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c08
											+ localClass_h_04172
													.sub_1640(
															localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
															localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c20 / 2);
									i1 = localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c10
											+ localClass_h_04172.var_bb7.var_c28
											- localClass_h_04172.var_c97[localClass_h_04172.var_ca7].var_c28
											+ 2;
									localClass_h_04172.var_c97[0].sub_1b36(i4,
											i1);
									localClass_h_04172.var_c97[1] = Class_g_2517
											.sub_2054(
													localClass_h_04172.var_bbf,
													var_baf[localClass_h_04172.var_b97] * 3,
													1, 0, -1, 100, (byte)0);
									localClass_h_04172.var_c97[1].sub_1b36(i4,
											i1);
									localClass_h_04172.var_b3f
											.sub_18887(localClass_h_04172.var_c97[1]);
									localClass_h_04172.var_c97[1].var_c98 = localClass_h_04172.var_b97;
									localClass_h_04172.var_b3f
											.sub_18887(localClass_h_04172.var_c97[0]);
									localClass_h_04172.var_c97[0].var_c98 = localClass_h_04172.var_b97;
								} else if (localClass_h_04172.var_b4f == 8) {
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7] = Class_g_2517
											.sub_2054(
													null,
													var_baf[localClass_h_04172.var_b97],
													0, 0, -1, 2000, (byte)6);
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7]
											.sub_1b36(
													localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c08
															+ localClass_h_04172
																	.sub_1640(
																			localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
																			localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c20 + 2),
													localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c10 + 30);
									localClass_h_04172.var_c97[localClass_h_04172.var_ca7].var_c88 = true;
									Class_c_0282.sub_2af6(200);
									localClass_h_04172.var_b3f.sub_188ce(1200);
									Class_c_0282.sub_2c63(14, 1);
									localClass_h_04172.var_b3f
											.sub_18887(localClass_h_04172.var_c97[localClass_h_04172.var_ca7]);
								}
							}
						} else {
							localClass_h_04172.var_c97[localClass_h_04172.var_ca7] = Class_g_2517
									.sub_2054(localClass_h_04172.var_bbf, 0, 0,
											0, 1, 50, (byte)0);
							localClass_h_04172.var_c97[localClass_h_04172.var_ca7]
									.sub_1b36(
											localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c08
													+ localClass_h_04172
															.sub_1640(
																	localClass_h_04172.var_c97[localClass_h_04172.var_ca7],
																	localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c20),
											localClass_h_04172.var_bf7[localClass_h_04172.var_ca7].var_c10);
							localClass_h_04172.var_b3f
									.sub_18887(localClass_h_04172.var_c97[localClass_h_04172.var_ca7]);
						}
					}
					if (++localClass_h_04172.var_ca7 < localClass_h_04172.var_b8f) {
						m = 0;
					}
					for (i1 = 0; i1 < localClass_h_04172.var_b8f; i1++) {
						if (localClass_h_04172.var_bf7[i1].var_c48 > 0) {
							m = 0;
						} else if ((localClass_h_04172.var_b4f != 7)
								&& (localClass_h_04172.var_bf7[i1].var_c48 != -1)) {
							if (localClass_h_04172.var_bf7[i1].var_ca8 == 0) {
								localClass_h_04172.var_bf7[i1].sub_1bce(3,
										localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[i1].var_c48 = 1;
								localClass_h_04172.var_bf7[i1].var_ca8 = 1;
								if (localClass_h_04172.var_b4f == 8) {
									localClass_h_04172.var_c97[i1].var_c78 = false;
								}
								m = 0;
							} else if (localClass_h_04172.var_bf7[i1].var_ca8 == 1) {
								localClass_h_04172.var_bf7[i1].sub_1bce(0,
										localClass_h_04172.var_b9f);
								localClass_h_04172.var_bf7[i1].var_c48 = -1;
								localClass_h_04172.var_bf7[i1].var_ca8 = 2;
								m = 0;
							}
						}
						if ((localClass_h_04172.var_b4f == 8)
								&& (localClass_h_04172.var_c97[i1] != null)
								&& (localClass_h_04172.var_c97[i1].var_c78)) {
							Class_g_2517 localClass_g_25175;
							(localClass_g_25175 = Class_g_2517.sub_2054(
									localClass_h_04172.var_b3f.var_4a72,
									var_baf[localClass_h_04172.var_b97]
											* Class_c_0282.sub_1a08(1, 4),
									Class_c_0282.sub_1a08(-2, 3), 0, 1,
									50 * Class_c_0282.sub_19e8(4), (byte) 0))
									.sub_1b36(
											localClass_h_04172.var_bf7[i1].var_c08
													+ localClass_h_04172
															.sub_1640(
																	localClass_g_25175,
																	localClass_h_04172.var_bb7.var_c20),
											localClass_h_04172.var_c97[i1].var_c10
													+ Class_c_0282
															.sub_19e8(30 - localClass_h_04172.var_c97[i1].var_c28)
													- 15);
							localClass_g_25175.var_c88 = true;
							localClass_h_04172.var_b3f
									.sub_18887(localClass_g_25175);
						}
					}
					if (m != 0) {
						if (localClass_h_04172.var_b47.var_e2b == 9) {
							localClass_h_04172.var_ba7 = 6;
						} else {
							localClass_h_04172.var_ba7 = 4;
						}
						localClass_h_04172.var_c77 = 400;
						if (localClass_h_04172.var_b47.var_e2b == 8) {
							localClass_h_04172.var_c77 = 0;
						}
						localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
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
					if (localClass_h_04172.var_b3f.var_479a
							- localClass_h_04172.var_bef < localClass_h_04172.var_c77) {
						break;
					}
					localClass_h_04172.var_c0f.sub_331c();
					if (localClass_h_04172.var_b4f != 1) {
						localClass_h_04172.var_b3f.sub_188ce(200);
					}
					Class_c_0282.sub_2af6(200);
					Class_c_0282.sub_2c63(14, 1);
					if (localClass_h_04172.var_bc7 != null) {
						localClass_h_04172.var_c9f = Class_a_0260.var_f3b[localClass_h_04172.var_b4f].length;
					}
					localClass_h_04172.var_c6f = 1;
					break;
				}
				if (localClass_h_04172.var_c6f != 1) {
					break;
				}
				if (--localClass_h_04172.var_c9f < 0) {
					localClass_h_04172.var_ba7 = 7;
					localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
					break;
				}
				if ((localClass_h_04172.var_b4f != 3)
						&& (localClass_h_04172.var_b4f != 2)
						&& (localClass_h_04172.var_b4f != 1)) {
					localClass_g_25177 = Class_g_2517.sub_2054(
							localClass_h_04172.var_bc7, 0, 0, 0, -1, 0,
							(byte) 0);
				} else {
					localClass_g_25177 = Class_g_2517
							.sub_2054(localClass_h_04172.var_bc7, 0, 0, 0, 1,
									0, (byte) 0);
				}
				if ((localClass_h_04172.var_b4f == 2)
						|| (localClass_h_04172.var_b4f == 1)) {
					localClass_g_25177.var_c80 = false;
				}
				int i5 = Class_c_0282
						.sub_19e8(localClass_h_04172.var_b3f.var_459a / 2
								- localClass_g_25177.var_c20);
				i1 = 0;
				if (localClass_h_04172.var_c0f.var_c07 != null) {
					i1 = 0 + (localClass_h_04172.var_c0f.var_c07.var_6b9 - localClass_g_25177.var_c28);
				}
				m = (localClass_h_04172.var_b3f.var_4eba - i1)
						* ((localClass_h_04172.var_c9f << 1) + 1)
						/ (Class_a_0260.var_f3b[localClass_h_04172.var_b4f].length << 1)
						- localClass_g_25177.var_c28 / 2 + i1;
				if (localClass_h_04172.var_b97 == 0) {
					i5 += localClass_h_04172.var_b3f.var_45aa;
				}
				if ((localClass_h_04172.var_b4f == 7)
						|| (localClass_h_04172.var_b4f == 6)) {
					localClass_g_25177.var_c38 = m;
					m = 0;
				}
				localClass_g_25177.sub_1b36(i5, m);
				localClass_h_04172.var_b3f.sub_18887(localClass_g_25177);
				for (i1 = 0; i1 < 3; i1++) {
					Class_g_2517 localClass_g_25178;
					if ((localClass_h_04172.var_b4f != 7)
							&& (localClass_h_04172.var_b4f != 6)) {
						(localClass_g_25178 = Class_g_2517.sub_2054(
								localClass_h_04172.var_b3f.var_4a72,
								Class_c_0282.sub_1a08(-1, 2), 0, -1, 1, 100,
								(byte) 0))
								.sub_1b36(
										i5
												+ Class_c_0282
														.sub_19e8(localClass_g_25177.var_c20
																- localClass_g_25178.var_c20),
										m + localClass_g_25177.var_c28
												- localClass_g_25178.var_c28
												+ 1);
					} else {
						(localClass_g_25178 = Class_g_2517.sub_2054(
								localClass_h_04172.var_b3f.var_4742,
								Class_c_0282.sub_1a08(-1, 2), 0,
								Class_c_0282.sub_1a08(-2, 0), 1,
								Class_c_0282.sub_19e8(4) * 50, (byte) 0))
								.sub_1b36(
										i5
												+ Class_c_0282
														.sub_19e8(localClass_g_25177.var_c20
																- localClass_g_25178.var_c20),
										localClass_g_25177.var_c38
												+ localClass_g_25177.var_c28
												- localClass_g_25178.var_c28
												+ 1);
						localClass_g_25178.var_c38 = (-localClass_g_25177.var_c28 / 2);
					}
					localClass_h_04172.var_b3f.sub_18887(localClass_g_25178);
				}
				break;
			case 6:
				m = 1;
				for (i1 = 0; i1 < localClass_h_04172.var_c97.length; i1++) {
					if ((localClass_h_04172.var_b4f == 9)
							&& (Class_c_0282.sub_19e8(2) == 0)) {
						Class_g_2517 localClass_g_25176;
						(localClass_g_25176 = Class_g_2517.sub_2054(
								localClass_h_04172.var_b3f.var_4a72,
								Class_c_0282.sub_1a08(-2, 1), 0, -1, 1, 100,
								(byte) 0))
								.sub_1b36(
										localClass_h_04172.var_c97[i1].var_c08
												+ localClass_h_04172
														.sub_1640(
																localClass_h_04172.var_c97[i1],
																0),
										localClass_h_04172.var_c97[i1].var_c10
												+ localClass_h_04172.var_c97[i1].var_c28
												- localClass_g_25176.var_c28);
						if (localClass_h_04172.var_c97[i1].var_ca8 == 1) {
							localClass_g_25176.var_c98 = localClass_h_04172.var_c0f.var_b97;
						} else {
							localClass_g_25176.var_c98 = localClass_h_04172.var_b97;
						}
						localClass_h_04172.var_b3f
								.sub_18887(localClass_g_25176);
					}
					if (localClass_h_04172.var_b4f == 9) {
						if (localClass_h_04172.var_b97 == 0) {
							if (localClass_h_04172.var_c97[i1].var_c08 >= localClass_h_04172.var_b3f.var_459a) {
								if (localClass_h_04172.var_c97[i1].var_ca8 == 0) {
									localClass_h_04172.var_c97[i1]
											.sub_1b36(
													localClass_h_04172.var_b3f.var_45aa
															- localClass_h_04172.var_c97[i1].var_c20,
													localClass_h_04172.var_c97[i1].var_c10);
									localClass_h_04172.var_c97[i1].var_c98 = localClass_h_04172.var_c0f.var_b97;
									localClass_h_04172.var_c97[i1].var_ca8 = 1;
								} else {
									if (localClass_h_04172.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									localClass_h_04172.var_b3f
											.sub_188aa(localClass_h_04172.var_c97[i1]);
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
							if (localClass_h_04172.var_c97[i1].var_c08
									+ localClass_h_04172.var_c97[i1].var_c20 < 0) {
								if (localClass_h_04172.var_c97[i1].var_ca8 == 0) {
									localClass_h_04172.var_c97[i1]
											.sub_1b36(
													localClass_h_04172.var_b3f.var_45aa,
													localClass_h_04172.var_c97[i1].var_c10);
									localClass_h_04172.var_c97[i1].var_c98 = localClass_h_04172.var_c0f.var_b97;
									localClass_h_04172.var_c97[i1].var_ca8 = 1;
								} else {
									if (localClass_h_04172.var_c97[i1].var_ca8 != 1) {
										continue;
									}
									localClass_h_04172.var_b3f
											.sub_188aa(localClass_h_04172.var_c97[i1]);
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
				localClass_h_04172.var_bef = localClass_h_04172.var_b3f.var_479a;
				break;
			}
			if (localClass_h_04172.var_b3f.var_479a
					- localClass_h_04172.var_bef >= 1000L) {
				localClass_h_04172.var_ba7 = 0;
				localClass_h_04172.var_b5f = true;
			}
		}
		if (this.var_b4f == 6) {
			for (int j = 0; j < this.var_bf7.length; j++) {
				if (this.var_bf7[j].var_ca0) {
					this.var_bf7[j].var_c38 = (-6 + 4
							* Class_f_0145.sub_f0f(this.var_c57[j]) >> 10);
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
			this.var_b3f.sub_188aa(this.var_bf7[j]);
			Class_g_2517 localClass_g_25171;
			(localClass_g_25171 = Class_g_2517.sub_2054(this.var_b3f.var_4752,
					0, 0, 0, 1, 0, (byte) 0)).sub_1b36(this.var_bf7[j].var_c08
					+ (this.var_bf7[j].var_c20 - localClass_g_25171.var_c20)
					/ 2, this.var_b3f.k); // @todo see "long k" or "long byte"
			localClass_g_25171.var_c38 = (this.var_bf7[j].var_c10
					+ (this.var_bf7[j].var_c28 - localClass_g_25171.var_c28)
					/ 2 - this.var_b3f.k); // @todo see "long k" or "long byte"
			this.var_b3f.sub_18887(localClass_g_25171);
			Class_g_2517 localClass_g_25172;
			for (i = 0; i < 3; i++) {
				(localClass_g_25172 = Class_g_2517.sub_2054(
						this.var_b3f.var_4a72, i + -1, 0,
						Class_c_0282.sub_1a08(-4, -1), 1,
						Class_c_0282.sub_19e8(4) * 50, (byte) 0))
						.sub_1b36(
								this.var_bf7[j].var_c08
										+ (this.var_bf7[j].var_c20 - localClass_g_25172.var_c20)
										/ 2, this.var_bf7[j].var_c10
										+ this.var_bf7[j].var_c28
										- localClass_g_25172.var_c28 + 3);
				this.var_b3f.sub_18887(localClass_g_25172);
			}
			(localClass_g_25172 = Class_g_2517.sub_2054(this.var_b3f.var_4742,
					0, 0, -1, 1, 200, (byte) 0))
					.sub_1b36(
							this.var_bf7[j].var_c08
									+ (this.var_bf7[j].var_c20 - localClass_g_25172.var_c20)
									/ 2, this.var_bf7[j].var_c10
									+ this.var_bf7[j].var_c28
									- localClass_g_25172.var_c28 + 3);
			this.var_b3f.sub_18887(localClass_g_25172);
		}
		Class_g_2517[] arrayOfClass_g_2517 = new Class_g_2517[this.var_b8f];
		System.arraycopy(this.var_bf7, this.var_c47, arrayOfClass_g_2517, 0,
				this.var_b8f);
		this.var_bf7 = arrayOfClass_g_2517;
		Class_g_2517 localClass_g_25171 = Class_g_2517.sub_2009(""
				+ (this.var_b77 - this.var_b6f), 0, -4, (byte) 1);
		int k;
		if (this.var_b87 == 1) {
			k = this.var_bf7[0].var_c08 + this.var_bf7[0].var_c20 / 2;
			i = this.var_bf7[0].var_c10 + this.var_bf7[0].var_c28 + 1;
		} else {
			k = this.var_b3f.var_45aa / 2;
			if (this.var_b97 == 1) {
				k += this.var_b3f.var_45aa;
			}
			i = (this.var_b3f.var_4eba + this.var_c1f) / 2;
		}
		localClass_g_25171.sub_1b36(k, i);
		localClass_g_25171.var_c88 = true;
		this.var_b3f.sub_18887(localClass_g_25171);
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
				this.var_bff[this.var_c7f[j][m]].sub_1115(paramGraphics, i, n);
				n += 24;
				m++;
			}
			i += 24;
			j++;
		}
		if (this.var_c07 != null) {
			j = this.var_c07.var_6b1;
			i = 0;
			k = 0;
			m = (this.var_b3f.var_45aa + j - 1) / j;
			while (k < m) {
				this.var_c07.sub_1115(paramGraphics, i, 0);
				i += j;
				k++;
			}
		}
		paramGraphics.translate(-paramInt1, -paramInt2);
	}

	public final void sub_36f9(Graphics paramGraphics) {
		int i = this.var_b3f.k - Class_g_1956.var_4592 / 2; // @todo see
															// "long k" and
															// "byte k"
		Class_c_0282.sub_2007(paramGraphics, this.var_c3f + "/" + 100,
				this.var_b3f.var_45aa / 2, i, 1, 3);
	}

	public final void sub_374d(Graphics paramGraphics) {
		paramGraphics.setColor(4210752);
		for (int i = 0; i < this.var_b8f; i++) {
			Class_g_2517 localClass_g_2517 = this.var_bf7[i];
			if ((this.var_b4f == 0) || (this.var_b4f == 4)
					|| (this.var_b4f == 5) || (this.var_b4f == 6)) {
				paramGraphics.fillArc(localClass_g_2517.var_c08,
						localClass_g_2517.var_c10
								+ (localClass_g_2517.var_c28 << 2) / 5,
						localClass_g_2517.var_c20,
						localClass_g_2517.var_c28 / 4, 0, 360);
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