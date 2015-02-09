package aeii;

import a.a.a.Class_g_Sprite;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

public final class Class_a_Unit extends Class_g_Sprite {

	public static byte var_dd3 = 12;
	public static byte var_ddb;
	public static byte var_de3 = Class_a_Unit.var_ddb = 6;
	private static Class_g_1956 var_deb;
	public String unitName;
	public short level;
	public int maybeExperience;
	public byte[][] chars;
	private Vector var_e13;
	private short var_e1b;
	private long var_e23;
	public byte unitType;
	public byte teamId;
	public short posX;
	public short posY;
	public int var_e4b;
	public int var_e53;
	public int attackMin;
	public int attackMax;
	public int defence;
	public int moveRange;
	public int health;
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
	public Class_a_Unit var_ee3;
	public byte var_eeb = 0;
	public int unitId;
	public int cost;
	public int var_f03;

	private static String[] unitNames = { "soldier", "archer", "lizard", "wizard", "wisp", "spider", "golem", "catapult", "wyvern", "king", "skeleton", "crystall" }; // 12
	public static byte[] unitsMoveRange = new byte[12];
	private static byte[][] unitsAttackValues = new byte[12][2];
	private static byte[] unitsDefence = new byte[12];
	private static byte[] unitsAttackRangeMax = new byte[12];
	private static byte[] unitsAttackRangeMin = new byte[12];
	public static byte[][][] unitsChars = new byte[12][][];
	public static short[] unitsCost = new short[12];
	private static short[] unitsHasProperty = new short[12];

	private Class_a_Unit(
			byte inUnitType,
			byte inTeamId,
			int inX,
			int inY,
			boolean addToMap) {
		super(var_deb.getTeamUnitSprite(inTeamId, inUnitType));
		this.unitType = inUnitType;
		this.var_e83 = 0;
		this.posX = ((short) inX);
		this.posY = ((short) inY);
		setPixelPosition(inX * 24, inY * 24); //24 - tile size? 
		setUnitLevel((byte) 0);
		if (addToMap) {
			var_deb.mapUnitsMaybe.addElement(this);
		}
	}

	public final void setUnitLevel(byte level) {
		this.level = ((short) level);
		level <<= 1;
		this.attackMin = (unitsAttackValues[this.unitType][0] + level);
		this.attackMax = (unitsAttackValues[this.unitType][1] + level);
		this.defence = (unitsDefence[this.unitType] + level);
		this.moveRange = unitsMoveRange[this.unitType];
		/* if not king set new unit name */
		if (this.unitType != 9) { // 9 - KING
			int theInt = this.level / 2;
			if (theInt > 3) {
				theInt = 3;
			}
			this.unitName = Class_f_StringManager
					.getLangString(139 + (this.unitType << 2) + theInt);
		}
	}

	public final void sub_108f(int paramInt) {
		this.var_eab = true;
		this.var_ec3 = var_deb.var_479a;
		this.var_ebb = paramInt;
	}

	public static final Class_a_Unit createUnit(byte inType, byte inTeam, int inX, int inY) {
		return createUnitWithBool(inType, inTeam, inX, inY, true);
	}

	public static final Class_a_Unit createUnitWithBool(byte inUnitType, byte inTeamId, int inX, int inY, boolean addToMap) {
		/* if king & ?? */
		if ((inUnitType == 9) && (var_deb.teamsUnitsCount[inTeamId] >= var_deb.teamsUnits[inTeamId].length)) {
			return null;
		}
		Class_a_Unit unit = new Class_a_Unit(inUnitType, var_deb.var_4832[inTeamId], inX, inY, addToMap);
		unit.unitType = inUnitType;
		unit.teamId = inTeamId;
		unit.health = 100;
		unit.chars = unitsChars[inUnitType];
		unit.cost = unitsCost[inUnitType];
		if (inUnitType == 9) { // king
			unit.setKingName(var_deb.var_4832[inTeamId] - 1);
			unit.unitId = var_deb.teamsUnitsCount[inTeamId];
			var_deb.teamsUnits[inTeamId][unit.unitId] = unit;
			var_deb.teamsUnitsCount[inTeamId] += 1;
		}
		return unit;
	}

	public static final Class_a_Unit sub_11aa(byte inType, byte inTeam, int paramInt1, int paramInt2, boolean paramBoolean) {
		Class_a_Unit unit = new Class_a_Unit(inType, var_deb.var_4832[inTeam], paramInt1, paramInt2, paramBoolean);
		unit.unitType = inType;
		unit.teamId = inTeam;
		unit.health = 100;
		unit.chars = unitsChars[inType];
		unit.cost = unitsCost[inType];
		if (inType == 9) { // king
			unit.setKingName(var_deb.var_4832[inTeam] - 1);
		}
		return unit;
	}

	public final void killUnitMaybe() {
		var_deb.mapUnitsMaybe.removeElement(this);
	}

	public final void setKingName(int paramInt) {
		this.var_eeb = ((byte) paramInt);
		this.unitName = Class_f_StringManager.getLangString(paramInt + 93);
	}

	public final int getSomeAttackValueMaybe1(Class_a_Unit unit) {
		return getSomeAttackValueMaybe2(unit, this.posX, this.posY);
	}

	private int getSomeAttackValueMaybe2(Class_a_Unit unit, int paramInt1, int paramInt2) {
		int someAttackValue = this.var_e9b;
		if (unit != null) {
			if ((hasProperty((short) 64)) && (unit.hasProperty((short) 1))) {
				someAttackValue += 15;
			}
			if ((this.unitType == 4) && (unit.unitType == 10)) { // this Wisp
																	// unit =
																	// skeleton
				someAttackValue += 15;
			}
		}
		if ((hasProperty((short) 2)) && (var_deb
				.getMapTileType(paramInt1, paramInt2) == 5)) {
			someAttackValue += 10;
		}
		if (var_deb.var_4782[paramInt1][paramInt2] == 34) {
			someAttackValue += 25;
		}
		return someAttackValue;
	}

	public final int getSomeUnitResistance(Class_a_Unit unit) {
		return getSomeUnitResistance2(this.posX, this.posY);
	}

	private int getSomeUnitResistance2(int x, int y) {
		int tileType = var_deb.getMapTileType(x, y);
		int resist = this.var_ea3 + Class_g_1956.tilesExtraDefence[tileType];
		if ((hasProperty((short) 2)) && (tileType == 5)) {
			resist += 15;
		}
		if (var_deb.var_4782[x][y] == 34) {
			resist += 15;
		}
		return resist;
	}

	public final int getDamageWhenAttack(Class_a_Unit ins) {
		int randomAttack = Class_c_MainCanvas
				.getRandomWithin(this.attackMin, this.attackMax);
		int attackVal = randomAttack + getSomeAttackValueMaybe1(ins);
		int defence = ins.defence + ins.getSomeUnitResistance(this);
		int damageDone = (attackVal - defence) * this.health / 100;
		if (damageDone < 0) {
			damageDone = 0;
		} else if (damageDone > ins.health) {
			damageDone = ins.health;
		}
		ins.health -= damageDone;
		this.maybeExperience += ins.getSomeExperienceKoef() * damageDone;
		return damageDone;
	}

	private int getSomeExperienceKoef() {
		return this.attackMin + this.attackMax + this.defence;
	}

	public final int getLevelExperience() {
		return (getSomeExperienceKoef() * 100 << 1) / 3;
	}

	public final boolean unitGotNewLevel() {
		int levelExp = getLevelExperience();
		if (this.maybeExperience >= levelExp) {
			this.maybeExperience -= levelExp;
			setUnitLevel((byte) (this.level + 1));
			return true;
		}
		return false;
	}

	public final boolean canAttackPosition(int inX, int inY) {
		boolean isNear = (Math.abs(this.posX - inX) + Math.abs(this.posY - inY)) == 1;
		return (this.var_e83 != 4) && (this.health > 0) && isNear && (unitsAttackRangeMin[this.unitType] == 1);
	}

	public final void sub_1595(byte paramByte) {
		this.var_e8b = ((byte) (this.var_e8b | paramByte));
		sub_160c();
		if (paramByte == 1) {
			this.var_ed3 = var_deb.someUnitTeamId;
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
		this.posX = ((short) paramInt1);
		this.posY = ((short) paramInt2);
		this.pixelX = ((short) (paramInt1 * 24));
		this.pixelY = ((short) (paramInt2 * 24));
	}

	public final int sub_16bf() {
		int i = 100 / this.chars.length;
		int j = this.health / i;
		if ((this.health != 100) && (this.health % i > 0)) {
			j++;
		}
		return j;
	}

	public final int sub_1713(int paramInt1, int paramInt2, Class_a_Unit unit) {
		return (this.attackMin + this.attackMax + this.defence + getSomeAttackValueMaybe2(unit, paramInt1, paramInt2) + getSomeUnitResistance2(paramInt1, paramInt2)) * this.health / 100;
	}

	public final void setAttackMaskForPosition(byte[][] inAttackMask, int inX, int inY) {
		int attackRangeMin = unitsAttackRangeMin[this.unitType];
		int attackRangeMax = unitsAttackRangeMax[this.unitType];
		int minX = inX - attackRangeMax;
		if (minX < 0) {
			minX = 0;
		}
		int minY = inY - attackRangeMax;
		if (minY < 0) {
			minY = 0;
		}
		int maxX = inX + attackRangeMax;
		if (maxX >= var_deb.mapWidthMaybe) {
			maxX = var_deb.mapWidthMaybe - 1;
		}
		int maxY = inY + attackRangeMax;
		if (maxY >= var_deb.mapHeightMaybe) {
			maxY = var_deb.mapHeightMaybe - 1;
		}
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				int distanceToCell = Math.abs(x - inX) + Math.abs(y - inY);
				if ((distanceToCell >= attackRangeMin) && (distanceToCell <= attackRangeMax) && (inAttackMask[x][y] <= 0)) {
					inAttackMask[x][y] = 127;
				}
			}
		}
	}

	public final void sub_18dd(byte[][] attackMask) {
		if (hasProperty((short) 512)) {
			setAttackMaskForPosition(attackMask, this.posX, this.posY);
			return;
		}
		sub_20f8(attackMask);
		for (int i = 0; i < var_deb.mapWidthMaybe; i++) {
			for (int j = 0; j < var_deb.mapHeightMaybe; j++) {
				if ((attackMask[i][j] > 0) && (attackMask[i][j] != 127)) {
					setAttackMaskForPosition(attackMask, i, j);
				}
			}
		}
	}

	public final Class_a_Unit[] getUnitsInAttackRange1(int inX, int inY, byte paramByte) {
		byte attRangeMin = unitsAttackRangeMin[this.unitType];
		byte attRangeMax = unitsAttackRangeMax[this.unitType];
		return getUnitsInAttackRange(inX, inY, attRangeMin, attRangeMax, paramByte);
	}

	public final Class_a_Unit[] getUnitsInAttackRange(int inX, int inY, int inAttRangeMin, int inAttRangeMax, byte paramByte) {
		Vector units = new Vector();
		int minX = inX - inAttRangeMax;
		if ((minX) < 0) {
			minX = 0;
		}
		int minY = inY - inAttRangeMax;
		if ((minY) < 0) {
			minY = 0;
		}
		int maxX = inX + inAttRangeMax;
		if ((maxX) >= var_deb.mapWidthMaybe) {
			maxX = var_deb.mapWidthMaybe - 1;
		}
		int maxY = inY + inAttRangeMax;
		if ((maxY) >= var_deb.mapHeightMaybe) {
			maxY = var_deb.mapHeightMaybe - 1;
		}
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				int distance = Math.abs(x - inX) + Math.abs(y - inY);
				if ((distance >= inAttRangeMin) && (distance <= inAttRangeMax)) {
					Class_a_Unit unit;
					if (paramByte == 0) {
						unit = var_deb.getUnitAtPos(x, y, (byte) 0);
						if (unit != null) {
							if (var_deb.var_483a[unit.teamId] != var_deb.var_483a[this.teamId]) {
								units.addElement(unit);
							}
						} else if ((this.unitType == 7) && (var_deb
								.getMapTileType(x, y) == 8) && (Class_g_1956
								.sub_11b75(var_deb.var_4782[x][y])) && (!var_deb
								.sub_11c55(x, y, var_deb.var_483a[this.teamId]))) {
							Class_a_Unit fakeHouseUnit = createUnitWithBool((byte) 0, (byte) 0, x, y, false);
							fakeHouseUnit.unitType = -1;
							fakeHouseUnit.var_e83 = 4;
							units.addElement(fakeHouseUnit);
						}
					} else if (paramByte == 1) {
						unit = var_deb.getUnitAtPos(x, y, (byte) 1);
						if (unit != null) {
							units.addElement(unit);
						}
					} else if ((paramByte == 2) && ((unit = var_deb
							.getUnitAtPos(x, y, (byte) 0)) != null) && (var_deb.var_483a[unit.teamId] == var_deb.var_483a[this.teamId])) {
						units.addElement(unit);
					}
				}
			}
		}
		Class_a_Unit[] units2 = new Class_a_Unit[units.size()];
		units.copyInto(units2);
		return units2;
	}

	public final void sub_1c9f(int paramInt1, int paramInt2, boolean paramBoolean) {
		sub_1cc2(paramInt1, paramInt2, paramBoolean, false);
	}

	public final void sub_1cc2(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
		if (paramBoolean1) {
			this.var_e13 = sub_1ef5(this.posX, this.posY, paramInt1, paramInt2);
		} else {
			if ((paramBoolean2) && (var_deb
					.getUnitAtPos(paramInt1, paramInt2, (byte) 0) != null)) {
				paramBoolean2 = false;
				int it;
				for (it = paramInt1 - 1; it <= paramInt1 + 1; it++) {
					for (int jt = paramInt2 - 1; jt <= paramInt2 + 1; jt++) {
						if (((it == paramInt1) && (jt == paramInt2)) || (((it == paramInt1) || (jt == paramInt2)) && (var_deb
								.getUnitAtPos(it, jt, (byte) 0) == null))) {
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
			shorts = new short[] { this.posX, this.posY };
			this.var_e13.addElement(shorts);
			short i = this.posX;
			int iInt;
			if ((iInt = Math.abs(paramInt1 - this.posX)) > 0) {
				int j = (paramInt1 - this.posX) / iInt;
				for (int p2 = 0; p2 < iInt; p2++) {
					short i2 = (short) (i + j);
					short[] arrayOfShort1 = { i2, this.posY };
					this.var_e13.addElement(arrayOfShort1);
				}
			}
			int j = this.posY;
			if ((iInt = Math.abs(paramInt2 - this.posY)) > 0) {
				int int2 = (paramInt2 - this.posY) / iInt;
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

	public final Vector sub_1ef5(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
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
			if (paramInt4 < var_deb.mapHeightMaybe - 1) {
				j = var_deb.var_47da[paramInt3][(paramInt4 + 1)];
			}
			if (paramInt3 > 0) {
				k = var_deb.var_47da[(paramInt3 - 1)][paramInt4];
			}
			if (paramInt3 < var_deb.mapWidthMaybe - 1) {
				m = var_deb.var_47da[(paramInt3 + 1)][paramInt4];
			}
			int n;
			if ((n = Math.max(Math.max(i, j), Math.max(k, m))) == i) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3, paramInt4 - 1);
			} else if (n == j) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3, paramInt4 + 1);
			} else if (n == k) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3 - 1, paramInt4);
			} else if (n == m) {
				localVector = sub_1ef5(paramInt1, paramInt2, paramInt3 + 1, paramInt4);
			}
			localVector.addElement(arrayOfShort);
		}
		return localVector;
	}

	public final void sub_20f8(byte[][] paramArrayOfByte) {
		sub_212e(paramArrayOfByte, this.posX, this.posY, this.moveRange, -1, this.unitType, this.teamId, false);
	}

	public static final boolean sub_212e(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte1, byte paramByte2, boolean paramBoolean) {
		if (paramInt3 > paramArrayOfByte[paramInt1][paramInt2]) {
			paramArrayOfByte[paramInt1][paramInt2] = ((byte) paramInt3);
			if ((paramBoolean) && (var_deb
					.getUnitAtPos(paramInt1, paramInt2, (byte) 0) == null)) {
				return true;
			}
			int i;
			if ((paramInt4 != 1) && ((i = paramInt3 - sub_22a9(paramInt1, paramInt2 - 1, paramByte1, paramByte2)) >= 0) && (sub_212e(paramArrayOfByte, paramInt1, paramInt2 - 1, i, 2, paramByte1, paramByte2, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			if ((paramInt4 != 2) && ((i = paramInt3 - sub_22a9(paramInt1, paramInt2 + 1, paramByte1, paramByte2)) >= 0) && (sub_212e(paramArrayOfByte, paramInt1, paramInt2 + 1, i, 1, paramByte1, paramByte2, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			if ((paramInt4 != 4) && ((i = paramInt3 - sub_22a9(paramInt1 - 1, paramInt2, paramByte1, paramByte2)) >= 0) && (sub_212e(paramArrayOfByte, paramInt1 - 1, paramInt2, i, 8, paramByte1, paramByte2, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			return (paramInt4 != 8) && ((i = paramInt3 - sub_22a9(paramInt1 + 1, paramInt2, paramByte1, paramByte2)) >= 0) && (sub_212e(paramArrayOfByte, paramInt1 + 1, paramInt2, i, 4, paramByte1, paramByte2, paramBoolean)) && (paramBoolean);
		}
		return false;
	}

	private static int sub_22a9(int paramInt1, int paramInt2, byte paramByte1, byte paramByte2) {
		if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 < var_deb.mapWidthMaybe) && (paramInt2 < var_deb.mapHeightMaybe)) {
			Class_a_Unit localClass_a_0260;
			if (((localClass_a_0260 = var_deb
					.getUnitAtPos(paramInt1, paramInt2, (byte) 0)) != null) && (var_deb.var_483a[localClass_a_0260.teamId] != var_deb.var_483a[paramByte2])) {
				return 1000;
			}
			paramInt1 = var_deb.getMapTileType(paramInt1, paramInt2);
			if (paramByte1 == 11) {
				if (paramInt1 == 4) {
					return 1000;
				}
			} else {
				if (unitTypeHasProperty(paramByte1, (short) 1)) {
					return 1;
				}
				if ((unitTypeHasProperty(paramByte1, (short) 2)) && (paramInt1 == 5)) {
					return 1;
				}
			}
			return Class_g_1956.tilesTypes[paramInt1];
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
				this.posX = ((short) (this.pixelX / 24));
				this.posY = ((short) (this.pixelY / 24));
				this.var_e13 = null;
				this.var_e1b = 0;
			} else {
				if ((this.var_ee3 != null) && (this.pixelX % 24 == 0) && (this.pixelY % 24 == 0)) {
					this.var_ee3.sub_1c9f(this.posX, this.posY, false);
				}
				short[] arrayOfShort;
				int i = (arrayOfShort = (short[]) this.var_e13
						.elementAt(this.var_e1b))[0] * 24;
				int j = arrayOfShort[1] * 24;
				Class_g_Sprite localClass_g_2517 = null;
				if ((this.var_ee3 == null) && (++this.var_edb >= 24 / var_de3 / 2)) {
					localClass_g_2517 = var_deb
							.showSpriteOnMap(var_deb.bSmokeSprite, this.pixelX, this.pixelY, 0, 0, 1, Class_c_MainCanvas
									.getRandomWithin(1, 4) * 50);
					this.var_edb = 0;
				}
				if (i < this.pixelX) {
					this.pixelX -= var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517
								.setPixelPosition(this.pixelX + this.spriteFrameWidth, this.pixelY + this.spriteFrameHeight - localClass_g_2517.spriteFrameHeight);
					}
				} else if (i > this.pixelX) {
					this.pixelX += var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517
								.setPixelPosition(this.pixelX - localClass_g_2517.spriteFrameWidth, this.pixelY + this.spriteFrameHeight - localClass_g_2517.spriteFrameHeight);
					}
				} else if (j < this.pixelY) {
					this.pixelY -= var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517
								.setPixelPosition(this.pixelX + (this.spriteFrameWidth - localClass_g_2517.spriteFrameWidth) / 2, this.pixelY + this.spriteFrameHeight);
					}
				} else if (j > this.pixelY) {
					this.pixelY += var_de3;
					if (localClass_g_2517 != null) {
						localClass_g_2517
								.setPixelPosition(this.pixelX + (this.spriteFrameWidth - localClass_g_2517.spriteFrameWidth) / 2, this.pixelY - localClass_g_2517.spriteFrameHeight);
					}
				}
				if ((this.pixelX == i) && (this.pixelY == j)) {
					this.posX = arrayOfShort[0];
					this.posY = arrayOfShort[1];
					this.var_e1b = ((short) (this.var_e1b + 1));
				}
			}
			super.setPixelPosition(this.pixelX, this.pixelY);
			getSomeExperienceKoef();
			return;
		}
		if ((this.var_e83 == 0) && (var_deb.var_479a - this.var_e23 >= 200L)) {
			getSomeExperienceKoef();
			this.var_e23 = var_deb.var_479a;
		}
	}

	private static boolean unitTypeHasProperty(byte unitIndex, short propertyFlag) {
		return (unitsHasProperty[unitIndex] & propertyFlag) != 0;
	}

	public final boolean hasProperty(short propFlag) {
		return unitTypeHasProperty(this.unitType, propFlag);
	}

	public final void sub_26fe() {
		this.var_e83 = 2;
		Class_a_Unit unit = var_deb.getUnitAtPos(this.posX, this.posY, (byte) 1);
		if (unit != null) {
			unit.killUnitMaybe();
		}
		if (hasProperty((short) 256)) { // 1 << 8 - Wisp
			Class_a_Unit[] unitsInAttRange = getUnitsInAttackRange(this.posX, this.posY, 1, 2, (byte) 2);
			for (int i = 0; i < unitsInAttRange.length; i++) {
				unitsInAttRange[i].sub_1595((byte) 2);
				var_deb.showSpriteOnMap(var_deb.sparkSprite, unitsInAttRange[i].pixelX, unitsInAttRange[i].pixelY, 0, 0, 1, 50);
			}
		}
		var_deb.var_4e0a = this;
	}

	public static final Class_a_Unit[] sub_27b7(byte paramByte) {
		Class_a_Unit[] units = new Class_a_Unit[var_deb.teamsUnitsCount[paramByte]];
		int i = 0;
		for (int it = 0; it < units.length; it++) {
			if ((var_deb.teamsUnits[var_deb.someUnitTeamId][it] != null) && (var_deb.teamsUnits[var_deb.someUnitTeamId][it].var_e83 == 3)) {
				units[(i++)] = var_deb.teamsUnits[var_deb.someUnitTeamId][it];
			}
		}
		Class_a_Unit[] units2 = new Class_a_Unit[var_deb.var_49ca + 1 + i];
		for (byte k = 0; k < units2.length; k = (byte) (k + 1)) {
			if (k < i) {
				units2[k] = units[k];
			} else {
				units2[k] = createUnitWithBool((byte) (k - i), paramByte, 0, 0, false);
			}
		}
		return units2;
	}

	public final void sub_28d7(Graphics paramGraphics, int paramInt1, int paramInt2) {
		sub_28fa(paramGraphics, paramInt1, paramInt2, false);
	}

	public final void sub_28fa(Graphics gr, int inX, int inY, boolean paramBoolean) {
		if (this.var_e83 != 4) {
			int x;
			int y;
			if (this.var_eab) {
				if (this.var_eb3) {
					x = -2;
				} else {
					x = 2;
				}
				Class_c_MainCanvas.getRandomNumber(); //@todo
				y = 0;
				super.sub_1d20(gr, inX + x, inY + y);
			} else if ((!paramBoolean) && (this.var_e83 != 2)) {
				super.sub_1d20(gr, inX, inY);
			} else {
				var_deb.unitTeamSprites[0][this.unitType]
						.sub_1d20(gr, this.pixelX + inX, this.pixelY + inY);
			}
			if (this.unitType == 9) { // King
				x = this.pixelX + inX;
				y = this.pixelY + inY;
				if ((paramBoolean) || (this.var_e83 == 2)) {
					var_deb.kingHeadsIcons[1]
							.drawFrame(gr, (this.var_eeb << 1) + this.currentFrameIndex, x, y, 0);
					return;
				}
				var_deb.kingHeadsIcons[0]
						.drawFrame(gr, (this.var_eeb << 1) + this.currentFrameIndex, x, y, 0);
			}
		}
	}

	public final void drawHealthString(Graphics gr, int inX, int inY) {
		inX = this.pixelX + inX;
		inY = this.pixelY + inY;
		if ((this.var_e83 != 3) && (this.health < 100)) {
			String healthStr = "" + this.health;
			Class_c_MainCanvas.drawAString(gr, healthStr, inX, inY + this.spriteFrameHeight - 7, 0);
		}
	}

	public static final void initializeUnitsData(Class_g_1956 ins) {
		var_deb = ins;
		try {
			for (int unitInd = 0; unitInd < unitNames.length; unitInd++) {
				InputStream unitStream = Class_c_MainCanvas
						.getResourceStream(unitNames[unitInd] + ".unit");
				String unitString = Class_c_MainCanvas
						.streamToString((InputStream) unitStream);
				while (unitString != null) {
					int eolnIndex = unitString.indexOf(';');
					if (eolnIndex >= 0) {
						unitString = unitString.substring(0, eolnIndex);
					}
					if ((unitString = unitString.trim()).length() != 0) {
						String[] arrayOfString = Class_c_MainCanvas
								.splitStringByChar(unitString, ' ');
						if (arrayOfString[0].equalsIgnoreCase("MoveRange")) {
							unitsMoveRange[unitInd] = ((byte) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0].equalsIgnoreCase("Attack")) {
							unitsAttackValues[unitInd][0] = ((byte) Integer
									.parseInt(arrayOfString[1]));
							unitsAttackValues[unitInd][1] = ((byte) Integer
									.parseInt(arrayOfString[2]));
						} else if (arrayOfString[0].equalsIgnoreCase("Defence")) {
							unitsDefence[unitInd] = ((byte) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0]
								.equalsIgnoreCase("AttackRange")) {
							unitsAttackRangeMax[unitInd] = ((byte) Integer
									.parseInt(arrayOfString[1]));
							unitsAttackRangeMin[unitInd] = ((byte) Integer
									.parseInt(arrayOfString[2]));
						} else if (arrayOfString[0].equalsIgnoreCase("Cost")) {
							unitsCost[unitInd] = ((short) Integer
									.parseInt(arrayOfString[1]));
						} else if (arrayOfString[0]
								.equalsIgnoreCase("CharCount")) {
							int charCount = Integer.parseInt(arrayOfString[1]);
							unitsChars[unitInd] = new byte[charCount][2];
						} else if (arrayOfString[0].equalsIgnoreCase("CharPos")) {
							int charPosIndex = Integer
									.parseInt(arrayOfString[1]);
							byte charPosX = ((byte) Integer
									.parseInt(arrayOfString[2]));
							byte charPosY = ((byte) Integer
									.parseInt(arrayOfString[3]));
							unitsChars[unitInd][charPosIndex][0] = charPosX;
							unitsChars[unitInd][charPosIndex][1] = charPosY;
						} else if (arrayOfString[0]
								.equalsIgnoreCase("HasProperty")) {
							int val = Integer.parseInt(arrayOfString[1]);
							unitsHasProperty[unitInd] = ((short) (unitsHasProperty[unitInd] | 1 << val)); // flags
						}
					}
				}
			}
			return;
		} catch (Exception exx) {
			try {
				InputStream stream = Class_c_MainCanvas
						.getResourceStream("units.bin");
				DataInputStream unitBinStream = new DataInputStream(stream);
				int unitsCount = 12; // @todo move to class member
				for (int i = 0; i < unitsCount; i++) {
					unitsMoveRange[i] = unitBinStream.readByte();
					unitsAttackValues[i][0] = unitBinStream.readByte();
					unitsAttackValues[i][1] = unitBinStream.readByte();
					unitsDefence[i] = unitBinStream.readByte();
					unitsAttackRangeMax[i] = unitBinStream.readByte();
					unitsAttackRangeMin[i] = unitBinStream.readByte();
					unitsCost[i] = unitBinStream.readShort();
					int j = unitBinStream.readByte();
					unitsChars[i] = new byte[j][2];
					for (int it = 0; it < j; it++) {
						unitsChars[i][it][0] = unitBinStream.readByte();
						unitsChars[i][it][1] = unitBinStream.readByte();
					}
					int propLength = ((DataInputStream) unitBinStream)
							.readByte();
					for (int it = 0; it < propLength; it++) {
						unitsHasProperty[i] = ((short) (unitsHasProperty[i] | 1 << unitBinStream
								.readByte()));
					}
				}
				unitBinStream.close();
				return;
			} catch (Exception ex2) {
				exx.printStackTrace();
				ex2.printStackTrace();
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