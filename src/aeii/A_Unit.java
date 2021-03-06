package aeii;

import a.a.a.G_Sprite;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;

public final class A_Unit extends G_Sprite {

	public static byte unitSpeedFastVal = 12;
	public static byte unitSpeedSlowVal;
	public static byte unitSpeed = A_Unit.unitSpeedSlowVal = 6;
	private static G_Game game;
	public String unitName;
	public short level;
	public int experience;
	public byte[][] chars;
	private Vector somePositionsList;
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
	public byte status;
	private short movementStatusValMb;
	private short attackStatusVal;
	private short defenceStatusVal;
	private boolean var_eab;
	private boolean var_eb3 = true;
	private int var_ebb;
	private long sTimeMb;
	public byte var_ecb;
	public byte var_ed3;
	private int var_edb;
	public A_Unit someUnit0;
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
	public static byte[][][] unitsFACharacterPositions = new byte[12][][];
	public static short[] unitsCost = new short[12];
	private static short[] unitsHasProperty = new short[12];

	private A_Unit(
			byte inUnitType,
			byte inTeamId,
			int inX,
			int inY,
			boolean addToMap) {
		super(game.getTeamUnitSprite(inTeamId, inUnitType));
		this.unitType = inUnitType;
		this.var_e83 = 0;
		this.posX = ((short) inX);
		this.posY = ((short) inY);
		setPixelPosition(inX * 24, inY * 24); //24 - tile size? 
		setUnitLevel((byte) 0);
		if (addToMap) {
			game.mapUnitsMaybe.addElement(this);
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
			this.unitName = F_StringManager
					.getLangString(139 + (this.unitType << 2) + theInt);
		}
	}

	public final void scheduleAnimationStop(int inVal) {
		this.var_eab = true;
		this.sTimeMb = game.someGameTime;
		this.var_ebb = inVal;
	}

	public static final A_Unit createUnit(byte inType, byte inTeam, int inX, int inY) {
		return createUnitWithBool(inType, inTeam, inX, inY, true);
	}

	public static final A_Unit createUnitWithBool(byte inUnitType, byte inTeamId, int inX, int inY, boolean addToMap) {
		/* if king & ?? */
		if ((inUnitType == 9) && (game.teamsUnitsCount[inTeamId] >= game.teamsUnits[inTeamId].length)) {
			return null;
		}
		A_Unit unit = new A_Unit(inUnitType, game.var_4832[inTeamId], inX, inY, addToMap);
		unit.unitType = inUnitType;
		unit.teamId = inTeamId;
		unit.health = 100;
		unit.chars = unitsFACharacterPositions[inUnitType];
		unit.cost = unitsCost[inUnitType];
		if (inUnitType == 9) { // king
			unit.setKingName(game.var_4832[inTeamId] - 1);
			unit.unitId = game.teamsUnitsCount[inTeamId];
			game.teamsUnits[inTeamId][unit.unitId] = unit;
			game.teamsUnitsCount[inTeamId] += 1;
		}
		return unit;
	}

	public static final A_Unit createNewUnit(byte inType, byte inTeam, int pX, int pY, boolean addToMap) {
		A_Unit unit = new A_Unit(inType, game.var_4832[inTeam], pX, pY, addToMap);
		unit.unitType = inType;
		unit.teamId = inTeam;
		unit.health = 100;
		unit.chars = unitsFACharacterPositions[inType];
		unit.cost = unitsCost[inType];
		if (inType == 9) { // king
			unit.setKingName(game.var_4832[inTeam] - 1);
		}
		return unit;
	}

	public final void removeUnit() {
		game.mapUnitsMaybe.removeElement(this);
	}

	public final void setKingName(int index) {
		this.var_eeb = ((byte) index);
		this.unitName = F_StringManager.getLangString(index + 93);
	}

	public final int getExtraUnitAttack(A_Unit unit) {
		return getExtraAttackOnPos(unit, this.posX, this.posY);
	}

	private int getExtraAttackOnPos(A_Unit unit, int pX, int pY) {
		int someAttackValue = this.attackStatusVal;
		if (unit != null) {
			if ((hasProperty((short) 64)) && (unit.hasProperty((short) 1))) { // archer and dragon
				someAttackValue += 15;
			}
			if ((this.unitType == 4) && (unit.unitType == 10)) { // Wisp and skeleton
				someAttackValue += 15;
			}
		}
		if ((hasProperty((short) 2)) && (game
				.getMapTileType(pX, pY) == 5)) { //lizard & 5 - water type
			someAttackValue += 10;
		}
		if (game.mapTilesIds[pX][pY] == 34) { //ancient ruins head
			someAttackValue += 25;
		}
		return someAttackValue;
	}

	public final int getExtraDefence(A_Unit unit) {
		return getExtraDefenceOnPos(this.posX, this.posY);
	}

	private int getExtraDefenceOnPos(int x, int y) {
		int tileType = game.getMapTileType(x, y);
		int resist = this.defenceStatusVal + G_Game.tilesExtraDefence[tileType];
		if ((hasProperty((short) 2)) && (tileType == 5)) {  //lizard & 5 - water type
			resist += 15;
		}
		if (game.mapTilesIds[x][y] == 34) {  //ancient ruins head
			resist += 15;
		}
		return resist;
	}

	public final int getDamageWhenAttack(A_Unit otherUnit) {
		int randomAttack = C_MainCanvas
				.getRandomWithin(this.attackMin, this.attackMax);
		int attackVal = randomAttack + getExtraUnitAttack(otherUnit);
		int defence = otherUnit.defence + otherUnit.getExtraDefence(this);
		int damageDone = (attackVal - defence) * this.health / 100;
		if (damageDone < 0) {
			damageDone = 0;
		} else if (damageDone > otherUnit.health) {
			damageDone = otherUnit.health;
		}
		otherUnit.health -= damageDone;
		this.experience += otherUnit.getSomeExperienceKoef() * damageDone;
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
		if (this.experience >= levelExp) {
			this.experience -= levelExp;
			setUnitLevel((byte) (this.level + 1));
			return true;
		}
		return false;
	}

	public final boolean canAttackPosition(int inX, int inY) {
		boolean isNear = (Math.abs(this.posX - inX) + Math.abs(this.posY - inY)) == 1;
		return (this.var_e83 != 4) && (this.health > 0) && isNear && (unitsAttackRangeMin[this.unitType] == 1);
	}

	public final void applyPoisonStatus(byte pStat) {
		this.status = ((byte) (this.status | pStat));
		calcStatusEffect();
		if (pStat == 1) {
			this.var_ed3 = game.currentPlayerId;
		}
	}

	public final void applyInvertedStatMbWTF(byte stat) {
		byte invertedStat = (byte)(stat ^ 0xFFFFFFFF);
		this.status = ((byte) (this.status & invertedStat));
		calcStatusEffect();
	}

	public final void calcStatusEffect() {
		this.movementStatusValMb = 0;
		this.attackStatusVal = 0;
		this.defenceStatusVal = 0;
		if ((this.status & 0x1) != 0) { // poison
			this.attackStatusVal = ((short) (this.attackStatusVal - 10));
			this.defenceStatusVal = ((short) (this.defenceStatusVal - 10));
		}
		if ((this.status & 0x2) != 0) { //wisp
			this.attackStatusVal = ((short) (this.attackStatusVal + 10));
		}
	}

	public final void setOnMapPosition(int mapX, int mapY) {
		this.posX = ((short) mapX);
		this.posY = ((short) mapY);
		this.pixelX = ((short) (mapX * 24));
		this.pixelY = ((short) (mapY * 24));
	}

	public final int getSomeHealthManipulationVal() {
		int i = 100 / this.chars.length;
		int j = this.health / i;
		if ((this.health != 100) && (this.health % i > 0)) {
			j++;
		}
		return j;
	}

	public final int getUnitTotalExpGainMb(int mX, int mY, A_Unit unit) {
		return (this.attackMin + this.attackMax + this.defence + getExtraAttackOnPos(unit, mX, mY) + getExtraDefenceOnPos(mX, mY)) * this.health / 100;
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
		if (maxX >= game.mapWidth) {
			maxX = game.mapWidth - 1;
		}
		int maxY = inY + attackRangeMax;
		if (maxY >= game.mapHeight) {
			maxY = game.mapHeight - 1;
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
		if (hasProperty((short) 512)) { //destroy village
			setAttackMaskForPosition(attackMask, this.posX, this.posY);
			return;
		}
		fillWhereUnitCanMove(attackMask);
		for (int i = 0; i < game.mapWidth; i++) {
			for (int j = 0; j < game.mapHeight; j++) {
				if ((attackMask[i][j] > 0) && (attackMask[i][j] != 127)) {
					setAttackMaskForPosition(attackMask, i, j);
				}
			}
		}
	}

	public final A_Unit[] getUnitsInAttackRange1(int inX, int inY, byte paramByte) {
		byte attRangeMin = unitsAttackRangeMin[this.unitType];
		byte attRangeMax = unitsAttackRangeMax[this.unitType];
		return getUnitsInAttackRange(inX, inY, attRangeMin, attRangeMax, paramByte);
	}

	public final A_Unit[] getUnitsInAttackRange(int inX, int inY, int inAttRangeMin, int inAttRangeMax, byte paramByte) {
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
		if ((maxX) >= game.mapWidth) {
			maxX = game.mapWidth - 1;
		}
		int maxY = inY + inAttRangeMax;
		if ((maxY) >= game.mapHeight) {
			maxY = game.mapHeight - 1;
		}
		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				int distance = Math.abs(x - inX) + Math.abs(y - inY);
				if ((distance >= inAttRangeMin) && (distance <= inAttRangeMax)) {
					A_Unit unit;
					if (paramByte == 0) {
						unit = game.getUnitAtPos(x, y, (byte) 0);
						if (unit != null) {
							if (game.var_483a[unit.teamId] != game.var_483a[this.teamId]) {
								units.addElement(unit);
							}
						} else if ((this.unitType == 7) && (game
								.getMapTileType(x, y) == 8) && (G_Game
								.tileCanBeOccupied(game.mapTilesIds[x][y])) && (!game
								.sub_11c55(x, y, game.var_483a[this.teamId]))) {
							A_Unit fakeHouseUnit = createUnitWithBool((byte) 0, (byte) 0, x, y, false);
							fakeHouseUnit.unitType = -1;
							fakeHouseUnit.var_e83 = 4;
							units.addElement(fakeHouseUnit);
						}
					} else if (paramByte == 1) {
						unit = game.getUnitAtPos(x, y, (byte) 1);
						if (unit != null) {
							units.addElement(unit);
						}
					} else if ((paramByte == 2) && ((unit = game
							.getUnitAtPos(x, y, (byte) 0)) != null) && (game.var_483a[unit.teamId] == game.var_483a[this.teamId])) {
						units.addElement(unit);
					}
				}
			}
		}
		A_Unit[] units2 = new A_Unit[units.size()];
		units.copyInto(units2);
		return units2;
	}

	public final void setHiddenPositions(int inX, int inY, boolean paramBoolean) {
		setHiddenPositions(inX, inY, paramBoolean, false);
	}

	public final void setHiddenPositions(int inX, int inY, boolean paramBoolean1, boolean paramBoolean2) {
		if (paramBoolean1) {
			this.somePositionsList = sub_1ef5(this.posX, this.posY, inX, inY);
		} else {
			if ((paramBoolean2) && (game
					.getUnitAtPos(inX, inY, (byte) 0) != null)) {
				paramBoolean2 = false;
				for (int it = inX - 1; it <= inX + 1; it++) {
					for (int jt = inY - 1; jt <= inY + 1; jt++) {
						if (((it == inX) && (jt == inY)) || (((it == inX) || (jt == inY)) && (game
								.getUnitAtPos(it, jt, (byte) 0) == null))) {
							inX = it;
							inY = jt;
							paramBoolean2 = true;
							break;
						}
					}
					if (paramBoolean2) {
						break;
					}
				}
			}
			this.somePositionsList = new Vector();
			short[] position = new short[] { this.posX, this.posY };
			this.somePositionsList.addElement(position);
			short x = this.posX;
			int dist = Math.abs(inX - this.posX);
			if (dist > 0) {
				int directionX = (inX - this.posX) / dist;
				for (int p2 = 0; p2 < dist; p2++) {
					short xx = (short) (x + directionX);
					short[] pos = { xx, this.posY };
					this.somePositionsList.addElement(pos);
				}
			}
			int y = this.posY;
			dist = Math.abs(inY - this.posY);
			if (dist > 0) {
				int directionY = (inY - this.posY) / dist;
				for (int bool1 = 0; bool1 < dist; bool1++) {
					short yy = (short) (y + directionY);
					short[] pos = { x, yy };
					this.somePositionsList.addElement(pos);
				}
			}
		}
		this.var_e4b = inX;
		this.var_e53 = inY;
		this.var_e1b = 1;
		this.var_e83 = 1;
	}

	public final Vector sub_1ef5(int inX, int inY, int paramInt3, int paramInt4) {
		Vector localVector = null;
		short[] position = { (short) paramInt3, (short) paramInt4 };
		if ((inX == paramInt3) && (inY == paramInt4)) {
			localVector = new Vector();
			localVector.addElement(position);
		} else {
			int i = 0;
			int j = 0;
			int k = 0;
			int m = 0;
			if (paramInt4 > 0) {
				i = game.var_47da[paramInt3][(paramInt4 - 1)];
			}
			if (paramInt4 < game.mapHeight - 1) {
				j = game.var_47da[paramInt3][(paramInt4 + 1)];
			}
			if (paramInt3 > 0) {
				k = game.var_47da[(paramInt3 - 1)][paramInt4];
			}
			if (paramInt3 < game.mapWidth - 1) {
				m = game.var_47da[(paramInt3 + 1)][paramInt4];
			}
			int n;
			if ((n = Math.max(Math.max(i, j), Math.max(k, m))) == i) {
				localVector = sub_1ef5(inX, inY, paramInt3, paramInt4 - 1);
			} else if (n == j) {
				localVector = sub_1ef5(inX, inY, paramInt3, paramInt4 + 1);
			} else if (n == k) {
				localVector = sub_1ef5(inX, inY, paramInt3 - 1, paramInt4);
			} else if (n == m) {
				localVector = sub_1ef5(inX, inY, paramInt3 + 1, paramInt4);
			}
			localVector.addElement(position);
		}
		return localVector;
	}

	public final void fillWhereUnitCanMove(byte[][] bytes) {
		canMoveSomeWhereMB(bytes, this.posX, this.posY, this.moveRange, -1, this.unitType, this.teamId, false);
	}

	public static final boolean canMoveSomeWhereMB(byte[][] bytes, int inX, int inY, int moveRange, int cameFromDir, byte unitType, byte unitTeamId, boolean paramBoolean) {
		if (moveRange > bytes[inX][inY]) {
			bytes[inX][inY] = ((byte) moveRange);
			if ((paramBoolean) && (game
					.getUnitAtPos(inX, inY, (byte) 0) == null)) {
				return true;
			}
			int newMoveRange;
			if ((cameFromDir != 1) && ((newMoveRange = moveRange - getPosMoveCost(inX, inY - 1, unitType, unitTeamId)) >= 0) && (canMoveSomeWhereMB(bytes, inX, inY - 1, newMoveRange, 2, unitType, unitTeamId, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			if ((cameFromDir != 2) && ((newMoveRange = moveRange - getPosMoveCost(inX, inY + 1, unitType, unitTeamId)) >= 0) && (canMoveSomeWhereMB(bytes, inX, inY + 1, newMoveRange, 1, unitType, unitTeamId, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			if ((cameFromDir != 4) && ((newMoveRange = moveRange - getPosMoveCost(inX - 1, inY, unitType, unitTeamId)) >= 0) && (canMoveSomeWhereMB(bytes, inX - 1, inY, newMoveRange, 8, unitType, unitTeamId, paramBoolean)) && (paramBoolean)) {
				return true;
			}
			return (cameFromDir != 8) && ((newMoveRange = moveRange - getPosMoveCost(inX + 1, inY, unitType, unitTeamId)) >= 0) && (canMoveSomeWhereMB(bytes, inX + 1, inY, newMoveRange, 4, unitType, unitTeamId, paramBoolean)) && (paramBoolean);
		}
		return false;
	}

	private static int getPosMoveCost(int inX, int inY, byte unitType, byte unitTeamId) {
		if ((inX >= 0) && (inY >= 0) && (inX < game.mapWidth) && (inY < game.mapHeight)) {
			A_Unit unitAtPos = game.getUnitAtPos(inX, inY, (byte) 0);
			boolean areEnemies = (game.var_483a[unitAtPos.teamId] != game.var_483a[unitTeamId]);
			if ((unitAtPos != null) && areEnemies) {
				return 1000; //cant move through enemies
			}
			int mapTileType = game.getMapTileType(inX, inY);
			if (unitType == 11) { // crystal
				if (mapTileType == 4) { // mountain
					return 1000; //crystal cant cross mountain
				}
			} else {
				if (unitTypeHasProperty(unitType, (short) 1)) { // flying
					return 1; 
				}
				if ((unitTypeHasProperty(unitType, (short) 2)) && (mapTileType == 5)) { // lizard and water
					return 1;
				}
			}
			return G_Game.tilesTypes[mapTileType];
		}
		return 10000; // cant move outside map
	}

	public final void sub_238a() {
		if (this.var_eab) {
			if (game.someGameTime - this.sTimeMb >= this.var_ebb) {
				this.var_eab = false;
			} else {
				this.var_eb3 = (!this.var_eb3);
			}
		}
		if (this.var_e83 == 1) {
			if (this.var_e1b >= this.somePositionsList.size()) {
				this.var_e83 = 0;
				this.posX = ((short) (this.pixelX / 24));
				this.posY = ((short) (this.pixelY / 24));
				this.somePositionsList = null;
				this.var_e1b = 0;
			} else {
				if ((this.someUnit0 != null) && (this.pixelX % 24 == 0) && (this.pixelY % 24 == 0)) {
					this.someUnit0.setHiddenPositions(this.posX, this.posY, false);
				}
				short[] arrayOfShort = (short[])this.somePositionsList
						.elementAt(this.var_e1b);
				int i = arrayOfShort[0] * 24;
				int j = arrayOfShort[1] * 24;
				G_Sprite bSmokeSprite = null;
				if ((this.someUnit0 == null) && (++this.var_edb >= 24 / unitSpeed / 2)) {
					bSmokeSprite = game
							.showSpriteOnMap(game.bSmokeSprite, this.pixelX, this.pixelY, 0, 0, 1, C_MainCanvas
									.getRandomWithin(1, 4) * 50);
					this.var_edb = 0;
				}
				if (i < this.pixelX) {
					this.pixelX -= unitSpeed;
					if (bSmokeSprite != null) {
						bSmokeSprite
								.setPixelPosition(this.pixelX + this.spriteFrameWidth, this.pixelY + this.spriteFrameHeight - bSmokeSprite.spriteFrameHeight);
					}
				} else if (i > this.pixelX) {
					this.pixelX += unitSpeed;
					if (bSmokeSprite != null) {
						bSmokeSprite
								.setPixelPosition(this.pixelX - bSmokeSprite.spriteFrameWidth, this.pixelY + this.spriteFrameHeight - bSmokeSprite.spriteFrameHeight);
					}
				} else if (j < this.pixelY) {
					this.pixelY -= unitSpeed;
					if (bSmokeSprite != null) {
						bSmokeSprite
								.setPixelPosition(this.pixelX + (this.spriteFrameWidth - bSmokeSprite.spriteFrameWidth) / 2, this.pixelY + this.spriteFrameHeight);
					}
				} else if (j > this.pixelY) {
					this.pixelY += unitSpeed;
					if (bSmokeSprite != null) {
						bSmokeSprite
								.setPixelPosition(this.pixelX + (this.spriteFrameWidth - bSmokeSprite.spriteFrameWidth) / 2, this.pixelY - bSmokeSprite.spriteFrameHeight);
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
		if ((this.var_e83 == 0) && (game.someGameTime - this.var_e23 >= 200L)) {
			getSomeExperienceKoef();
			this.var_e23 = game.someGameTime;
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
		A_Unit unit = game.getUnitAtPos(this.posX, this.posY, (byte) 1);
		if (unit != null) {
			unit.removeUnit();
		}
		if (hasProperty((short) 256)) { // 1 << 8 - Wisp
			A_Unit[] unitsInAttRange = getUnitsInAttackRange(this.posX, this.posY, 1, 2, (byte) 2);
			for (int i = 0; i < unitsInAttRange.length; i++) {
				unitsInAttRange[i].applyPoisonStatus((byte) 2);
				game.showSpriteOnMap(game.sparkSprite, unitsInAttRange[i].pixelX, unitsInAttRange[i].pixelY, 0, 0, 1, 50);
			}
		}
		game.unitFinishedMove = this;
	}

	public static final A_Unit[] sub_27b7(byte teamID) {
		int unitsCount = game.teamsUnitsCount[teamID];
		A_Unit[] units = new A_Unit[unitsCount];
		int countSomeUnits = 0;
		for (int it = 0; it < units.length; it++) {
			if ((game.teamsUnits[game.currentPlayerId][it] != null) && (game.teamsUnits[game.currentPlayerId][it].var_e83 == 3)) {
				units[(countSomeUnits++)] = game.teamsUnits[game.currentPlayerId][it];
			}
		}
		A_Unit[] units2 = new A_Unit[countSomeUnits + game.var_49ca + 1];
		for (int k = 0; k < units2.length; k++) {
			if (k < countSomeUnits) {
				units2[k] = units[k];
			} else {
				byte unitType = (byte) (k - countSomeUnits);
				units2[k] = createUnitWithBool(unitType, teamID, 0, 0, false);
			}
		}
		return units2;
	}

	public final void sub_28d7(Graphics graphics, int inX, int inY) {
		sub_28fa(graphics, inX, inY, false);
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
				C_MainCanvas.getRandomNumber(); //@todo
				y = 0;
				super.sub_1d20(gr, inX + x, inY + y);
			} else if ((!paramBoolean) && (this.var_e83 != 2)) {
				super.sub_1d20(gr, inX, inY);
			} else {
				game.unitTeamSprites[0][this.unitType]
						.sub_1d20(gr, this.pixelX + inX, this.pixelY + inY);
			}
			if (this.unitType == 9) { // King
				x = this.pixelX + inX;
				y = this.pixelY + inY;
				if ((paramBoolean) || (this.var_e83 == 2)) {
					game.kingHeadsIcons[1]
							.drawFrame(gr, (this.var_eeb << 1) + this.currentFrameIndex, x, y, 0);
					return;
				}
				game.kingHeadsIcons[0]
						.drawFrame(gr, (this.var_eeb << 1) + this.currentFrameIndex, x, y, 0);
			}
		}
	}

	public final void drawHealthString(Graphics gr, int inX, int inY) {
		inX = this.pixelX + inX;
		inY = this.pixelY + inY;
		if ((this.var_e83 != 3) && (this.health < 100)) {
			String healthStr = "" + this.health;
			C_MainCanvas.drawAString(gr, healthStr, inX, inY + this.spriteFrameHeight - 7, 0);
		}
	}

	public static final void initializeUnitsData(G_Game inGame) {
		game = inGame;
		try {
			for (int unitInd = 0; unitInd < unitNames.length; unitInd++) {
				InputStream unitStream = C_MainCanvas
						.getResourceStream(unitNames[unitInd] + ".unit");
				String unitString = C_MainCanvas
						.streamToString((InputStream) unitStream);
				while (unitString != null) {
					int eolnIndex = unitString.indexOf(';');
					if (eolnIndex >= 0) {
						unitString = unitString.substring(0, eolnIndex);
					}
					if ((unitString = unitString.trim()).length() != 0) {
						String[] arrayOfString = C_MainCanvas
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
							unitsFACharacterPositions[unitInd] = new byte[charCount][2];
						} else if (arrayOfString[0].equalsIgnoreCase("CharPos")) {
							int charPosIndex = Integer
									.parseInt(arrayOfString[1]);
							byte charPosX = ((byte) Integer
									.parseInt(arrayOfString[2]));
							byte charPosY = ((byte) Integer
									.parseInt(arrayOfString[3]));
							unitsFACharacterPositions[unitInd][charPosIndex][0] = charPosX;
							unitsFACharacterPositions[unitInd][charPosIndex][1] = charPosY;
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
				InputStream stream = C_MainCanvas
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
					unitsFACharacterPositions[i] = new byte[j][2];
					for (int it = 0; it < j; it++) {
						unitsFACharacterPositions[i][it][0] = unitBinStream.readByte();
						unitsFACharacterPositions[i][it][1] = unitBinStream.readByte();
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