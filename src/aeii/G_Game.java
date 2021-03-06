package aeii;

import a.a.a.C_AConnection;
import a.a.a.G_Sprite;
import aeii.enums.ConditionOperator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import java.util.Vector;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

/**
 * UI?
 * 
 * @author DevInCube
 *
 */
public final class G_Game extends F_StringManager implements Runnable,
		CommandListener, ItemStateListener {
	private static String[] var_4572;
	private static String[] var_457a;
	private static String[] var_4582;
	private String midletVersionAppProp = "?";
	public static byte var_4592 = 32;
	public int someCanWidth;
	public int someCanHeight;
	public int someCanWidthDiv2;
	private int someCanHeightDiv2;
	private int someSetting = 0;
	private static String[] originalSkirmishMapNames12 = new String[12];
	private static int[] var_45ca = { -1, -1, -1, -1, -1, -1, -1, -1 };
	private boolean[] var_45d2;
	private static int[] var_45da = { 500, 1000, 2000, 5000, 10000, 25000,
			50000, 75000, 100000, 150000, 200000 };// money skirmish
	private static int[] var_45e2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
			110, 120, 130, 140, 150, 160, 170, 180, 190, 200 }; // units
																// skirmish
	private int var_45ea;
	private int var_45f2;
	private byte scenarioModeIf0;
	public static int var_4602 = 1024;
	public static int var_460a = 2048;
	private String[] var_4612;
	private String[] var_461a;
	public D_ImageWrap[] actionIconsFrames;
	private String[] var_462a;
	private D_ImageWrap[] menuIconsFrames;
	private String[] var_463a;
	private String[] var_4642;
	private byte[] var_464a;
	private byte[] var_4652;
	private byte[] var_465a;
	private static byte[][] frameSequencesCursorMb = { { 0, 1 }, { 2, 3, 4 }, { 0, 1 }, { 5 } };
	private static byte[] someFrameSeq = { 0 };
	private long var_4672;
	private long var_467a;
	public static final String[] spriteColorsMaybe = { "grey", "blue", "red", "green",
			"black" }; // player group
	private static int[] var_468a = { 10526880, 26054, 15204434, 39473, 16754 };
	private static int[] var_4692 = { -1, 2, 3, 2, 3 };
	private static int[] var_469a = { -1, 4, 5, 4, 5 };
	public G_Sprite[][] unitTeamSprites;
	private static byte[] var_46aa = { 1, 2 };
	public static byte[] tilesExtraDefence = { 0, 5, 10, 10, 15, 0, 5, 15, 15, 15 };
	public static byte[] tilesTypes = { 1, 1, 2, 2, 3, 3, 1, 1, 1, 1 };
	public D_ImageWrap[] smallTilesFrames;
	public byte[] tilesDefs;
	private int var_46d2;
	private int var_46da;
	private int mapLeftX;
	private int mapTopY;
	public int mapWidth;
	public int mapHeight;
	private D_ImageWrap tombStoneImage;
	private D_ImageWrap[] tiles0Frames;
	private G_Sprite cursorSprite;
	private G_Sprite currentCursorSpriteMaybe;
	public G_Sprite sideArrowSprite;
	public G_Sprite arrowSprite;
	public G_Sprite buttonsSprite;
	public G_Sprite menuSprite;
	public G_Sprite smokeSprite;
	public G_Sprite sparkSprite;
	public G_Sprite redsparkSprite;
	private G_Sprite statusSprite;
	public G_Sprite smallSparkSprite;
	public G_Sprite portraitsSprite;
	public int cursorPosX;
	public int cursorPosY;
	public byte[][] mapTilesIds;
	private byte gameState;
	private byte var_4792;
	public long someGameTime;
	private int scenarioMapIndex;
	private int var_47aa;
	private int var_47b2;
	private A_Unit[] var_47ba;
	private A_Unit someActiveUnit;
	private int var_47ca;
	private int var_47d2;
	public byte[][] var_47da;
	private boolean var_47e2;
	private boolean var_47ea;
	private boolean isCursorVisible;
	public Vector mapUnitsMaybe;
	private Vector somePositions;
	private int var_480a;
	private int var_4812;
	private long var_481a;
	private byte teamsCountMaybe;
	private byte[] var_482a;
	public byte[] var_4832;
	public byte[] var_483a;
	public byte currentPlayerId;
	private short currentTurn;
	private A_Unit[] maybeTeamKings;
	public A_Unit[][] teamsUnits;
	public int[] teamsUnitsCount;
	public int[] var_486a;
	private byte[][] kingsPositions;
	private byte[] someTeamValuesArr;
	private E_Menu var_4882;
	private Vector spritesOtherVector;
	private Vector spritesVector;
	private A_Unit dyingUnit;
	private A_Unit var_48a2;
	private long var_48aa;
	private A_Unit selectedTombUnit;
	private byte activeTeamId;
	private long var_48c2;
	private int var_48ca;
	private boolean canCancelMb;
	private boolean canApplyMb;
	private byte gameStateMb;
	private D_ImageWrap msLogoImage;
	private D_ImageWrap splashImage;
	private D_ImageWrap aeLogoImage;
	private D_ImageWrap glowLightOnLogoImage;
	private int startupBgState;
	private boolean var_4912;
	private int var_491a;
	private int var_4922;
	private int var_492a;
	private long var_4932;
	private A_Unit attackingUnit;
	private A_Unit attackedUnit;
	private boolean var_494a;
	private long var_4952;
	private boolean var_495a;
	private long var_4962;
	private int var_496a; // int j
	private int var_4972;
	private D_ImageWrap[] var_497a;
	private boolean isLoadingBlackMb;
	private boolean var_498a;
	private static int[] var_4992 = { 85, 83, 83, 83, 83, 83, 83, 83, 83, 175,
			84, 84, 84, 175, 147, 159, 151, 155, 167, 171 };
	private static int[] var_499a = { 15, 196, 197, 198, 199, 200, 201, 202,
			203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214 };
	private int showHelp;
	private E_Menu var_49aa;
	private E_Menu var_49b2;
	private E_Menu var_49ba;
	private E_Menu gameMessageBox;
	public int var_49ca;
	private E_Menu var_49d2;
	private E_Menu var_49da;
	private E_Menu var_49e2;
	private boolean var_49ea;
	private int var_49f2;
	private byte[][] somePositionsOrTilesData;
	private byte[][] var_4a02;
	public G_Sprite bigCircleSprite;
	public G_Sprite smallCircleSprite;
	private A_Unit unitAtCursorPos;
	public G_Sprite hudIconsSprite;
	public G_Sprite hudIcons2Sprite;
	private int var_4a32;
	private int var_4a3a;
	private int glowLightXmb;
	private boolean isGameActive;
	private int statusBarOffset;
	private boolean var_4a5a;
	public G_Sprite miniIconsSprite;
	private G_Sprite[] aSomeSpritesArr;
	public G_Sprite bSmokeSprite;
	private E_Menu var_4a7a;
	private E_Menu var_4a82;
	private E_Menu var_4a8a;
	private E_Menu var_4a92;
	private E_Menu[] var_4a9a;
	private E_Menu[] var_4aa2;
	private E_Menu var_4aaa;
	private E_Menu[] var_4ab2;
	private G_Sprite alphaMaskSprite;
	private int fadeValue;
	private boolean var_4aca;
	private boolean var_4ad2;
	private boolean fadeEnabled;
	private Vector vectorOfSomeUnits;
	private G_Sprite levelUpSprite;
	private int someUnknownVal;
	public G_Sprite[] kingHeadsIcons;
	private E_Menu var_4b02;
	private E_Menu var_4b0a;
	private E_Menu var_4b12;
	private E_Menu var_4b1a;
	public G_Sprite arrowIconsSprite;
	private G_Sprite var_4b2a;
	private A_Unit var_4b32;
	private int var_4b3a;
	private boolean var_4b42;
	private boolean var_4b4a;
	private String mapStartUpMessage;
	private String[] saveSlotsDescriptions;
	private byte[] saveSlotBytes;
	private int[] saveSlotsMapIds;
	private E_Menu var_4b72;
	private E_Menu var_4b7a;
	private E_Menu sMenu;
	private E_Menu slotDescriptionDialog;
	private E_Menu var_4b92;
	private E_Menu var_4b9a;
	private E_Menu var_4ba2;
	private byte var_4baa;
	private byte[] var_4bb2;
	private int settingsCountMaybe;
	private String[] downloadedMapsNames;
	private int[] settingsIntListMaybe;
	private String[] var_4bd2;
	private String[] var_4bda;
	private E_Menu var_4be2;
	private E_Menu var_4bea;
	private E_Menu var_4bf2;
	private E_Menu someHoverMenu;
	private E_Menu var_4c02;
	private E_Menu var_4c0a;
	private E_Menu someMenu;
	private E_Menu var_4c1a;
	private int var_4c22;
	private String var_4c2a;
	private int downloadAvailableSize;
	private boolean msHighScoreUploadAppProp;
	private boolean var_4c42;
	private boolean var_4c4a;
	private D_ImageWrap gameOverImage;
	private Image[][] var_4c5a;
	private int loadingProgress;
	private A_Unit var_4c6a;
	private int mapStepMax;
	private int var_4c7a;
	private boolean var_4c82;
	private int alphaWindow;
	private int var_4c92;
	private int var_4c9a;
	private int var_4ca2;
	private int var_4caa;
	private D_ImageWrap introImage;
	private String[] introTextWrapped;
	private boolean var_4cc2;
	private byte var_4cca; // " byte j"
	private int var_4cd2;
	private int var_4cda;
	private int introImageHeight;
	private int var_4cea;
	private int var_4cf2;
	private int var_4cfa;
	private int var_4d02;
	private int var_4d0a;
	private int var_4d12;
	private static byte[] var_4d1a = { 0, 2, 3, 3, 1, 3, 3, 3, 3, 3, 3, 3 };
	private byte var_4d22; // byte k
	private int var_4d2a;
	private int var_4d32;
	private A_Unit var_4d3a;
	private A_Unit var_4d42;
	private A_Unit var_4d4a;
	private int var_4d52;
	private long var_4d5a; // long j
	private A_Unit[] var_4d62;
	private A_Unit[] aSomeUnitsArr;
	private byte[] var_4d72;
	private int[][] var_4d7a;
	private int[] var_4d82;
	private int var_4d8a;
	private byte[][] var_4d92;
	private int var_4d9a;
	private int var_4da2;
	private int var_4daa;
	private int var_4db2;
	private int var_4dba;
	private Vector var_4dc2;
	private boolean var_4dca;
	private int waitTime;
	private E_Menu mapStartUpMessageBox;
	private A_Unit var_4de2;
	private A_Unit var_4dea;
	private A_Unit var_4df2;
	private A_Unit var_4dfa;
	private A_Unit var_4e02;
	public A_Unit unitFinishedMove;
	private int aState;
	private String[][][] someScriptStrings;
	private long var_4e22; // long k
	private int var_4e2a;
	private boolean isWaiting;
	private boolean var_4e3a;
	private int var_4e42;
	private int var_4e4a;
	private int var_4e52;
	private H_FightAnimation fAnim1;
	private H_FightAnimation fAnim2;
	private long someGameTime2;
	private boolean var_4e72;
	private Vector spritesList;
	private boolean isShakingMB;
	private long shakingTimeMaxMb;
	private long shakingTimeMb;
	private boolean var_4e9a;
	private boolean var_4ea2;
	private boolean var_4eaa;
	public boolean var_4eb2;
	public int faViewPortHeight;
	private int var_4ec2;
	private int var_4eca;
	private String[] var_4ed2;
	private String[] var_4eda;
	private String[] var_4ee2;
	private String[] someMapsNamesMb;
	private String[] var_4ef2;
	private int[] mapBytesSizeMb;
	private String provisionHighscorePortalCodeAppProp;
	private String provisionHighscoreGameCodeAppProp;
	private String provisionHighscoreUrlAppProp;
	private ByteArrayOutputStream var_4f1a;
	private DataOutputStream var_4f22;
	private int var_4f2a;
	private boolean var_4f32;
	private F_StringManager var_4f3a;
	private int var_4f42;
	private E_Menu var_4f4a;
	private E_Menu var_4f52;
	private E_Menu var_4f5a;
	private E_Menu var_4f62;
	private B_FilesManager var_4f6a;
	private String[] var_4f72;
	private byte cursorTileId;
	private byte someUnitTypeId;
	private A_Unit var_4f8a;
	private byte var_4f92;
	private E_Menu var_4f9a;
	private E_Menu var_4fa2;
	private E_Menu var_4faa;
	private E_Menu var_4fb2;
	private int[] var_4fba;
	private int[] var_4fc2;
	private boolean[] var_4fca;
	private Form var_4fd2;
	private Form var_4fda;
	private Form var_4fe2;
	private Form var_4fea;
	private Form var_4ff2;
	private Form var_4ffa;
	private TextField var_5002;
	private TextField var_500a;
	private TextField var_5012;
	private ChoiceGroup var_501a;
	private TextField var_5022;
	private Gauge var_502a;
	private ImageItem var_5032;
	private TextField var_503a;
	private TextField var_5042;
	private TextField var_504a;
	private TextField var_5052;
	private TextBox var_505a;
	private Gauge var_5062;
	private Command var_506a;
	private Command var_5072;
	private Command var_507a;
	private Command var_5082;
	private Command var_508a;
	private Command var_5092;

	public G_Game() {
		var_4572 = new String[] { ".." };
		var_457a = new String[] { F_StringManager.getLangString(300), ".." };
		var_4582 = new String[] { F_StringManager.getLangString(305),
				F_StringManager.getLangString(306), F_StringManager.getLangString(307),
				F_StringManager.getLangString(303), F_StringManager.getLangString(70),
				F_StringManager.getLangString(293), F_StringManager.getLangString(60) };
		this.var_4f92 = 0;
		this.var_506a = new Command(F_StringManager.getLangString(12), 4, 1);
		this.var_5072 = new Command(F_StringManager.getLangString(13), 3, 5);
		this.var_507a = new Command(F_StringManager.getLangString(301), 4, 3);
		this.var_5082 = new Command(F_StringManager.getLangString(302), 4, 4);
		this.var_508a = new Command(F_StringManager.getLangString(304), 4, 2);
		this.var_5092 = new Command(F_StringManager.getLangString(316), 4, 2);
		if (C_MainCanvas.propDeveloperModeOn) {
			this.var_4612 = new String[] { F_StringManager.getLangString(66),
					F_StringManager.getLangString(70), F_StringManager.getLangString(71),
					F_StringManager.getLangString(4), F_StringManager.getLangString(314),
					F_StringManager.getLangString(60) };
		} else {
			this.var_4612 = new String[] { F_StringManager.getLangString(66),
					F_StringManager.getLangString(70), F_StringManager.getLangString(71),
					F_StringManager.getLangString(4), F_StringManager.getLangString(60) };
		}
		this.var_461a = new String[] { F_StringManager.getLangString(63),
				F_StringManager.getLangString(67), F_StringManager.getLangString(68),
				F_StringManager.getLangString(62), F_StringManager.getLangString(69),
				F_StringManager.getLangString(61), F_StringManager.getLangString(64) };
		this.actionIconsFrames = new D_ImageWrap[this.var_461a.length];
		this.var_462a = new String[] { F_StringManager.getLangString(1),
				F_StringManager.getLangString(2), F_StringManager.getLangString(5),
				F_StringManager.getLangString(3), F_StringManager.getLangString(6),
				F_StringManager.getLangString(8), F_StringManager.getLangString(7),
				F_StringManager.getLangString(9), F_StringManager.getLangString(10),
				F_StringManager.getLangString(11), F_StringManager.getLangString(4) };
		this.menuIconsFrames = new D_ImageWrap[this.var_462a.length];
		this.var_463a = new String[] { F_StringManager.getLangString(35),
				F_StringManager.getLangString(36), F_StringManager.getLangString(37) };
		this.var_4642 = new String[] { F_StringManager.getLangString(29),
				F_StringManager.getLangString(30) };
		this.var_464a = new byte[] { 0, 6, 5, 7, 8, 9 };
		this.var_4652 = new byte[] { 0, 6, 5, 7, 8, 9 };
		this.var_465a = new byte[] { 1, 2, 3, 4 };
		this.var_4672 = 0L;
		this.var_47e2 = false;
		this.var_47ea = false;
		this.isCursorVisible = true;
		this.mapUnitsMaybe = new Vector();
		this.teamsCountMaybe = 2;
		this.var_482a = new byte[5];
		this.var_4832 = new byte[4];
		this.var_483a = new byte[4];
		this.currentPlayerId = 0;
		this.var_486a = new int[4];
		this.kingsPositions = new byte[4][2];
		this.someTeamValuesArr = new byte[4];
		this.spritesOtherVector = new Vector();
		this.spritesVector = new Vector();
		this.canCancelMb = false;
		this.canApplyMb = false;
		this.var_4912 = false;
		this.var_494a = true;
		this.var_495a = false;
		this.isLoadingBlackMb = false;
		this.showHelp = -1;
		this.var_49ca = 8;
		this.var_49ea = false;
		this.isGameActive = true;
		this.aSomeSpritesArr = new G_Sprite[0];
		this.vectorOfSomeUnits = new Vector(2);
		this.var_4b3a = 0;
		this.var_4b42 = true;
		this.var_4bd2 = new String[] { F_StringManager.getLangString(46),
				F_StringManager.getLangString(47), F_StringManager.getLangString(291) };
		this.var_4bda = new String[] { F_StringManager.getLangString(289),
				F_StringManager.getLangString(298), F_StringManager.getLangString(48),
				F_StringManager.getLangString(49) };
		this.msHighScoreUploadAppProp = true;
		this.var_4c42 = true;
		this.var_4c4a = true;
		new StringBuffer();
		this.var_4c6a = null;
		this.mapStepMax = 12;
		this.var_4c7a = 1;
		this.var_4cea = 0;
		this.var_4cfa = 24;
		this.var_4d02 = 8;
		this.var_4d0a = (this.var_4d02 >> 1);
		this.var_4d22 = 0;
		this.var_4dca = false;
		this.var_4e02 = null;
		this.unitFinishedMove = null;
		this.isWaiting = false;
		this.var_4e3a = false;
		this.var_4e42 = -1;
		this.var_4e4a = -1;
		this.var_4e52 = 0;
		this.spritesList = new Vector();
		this.isShakingMB = false;
		this.provisionHighscorePortalCodeAppProp = "Macrospace";
		this.provisionHighscoreGameCodeAppProp = "msaeii";
		this.provisionHighscoreUrlAppProp = "http://msaeii.scores.macrospace.com/connectx/in";
		this.gameStateMb = 4;
	}

	public final void loadingProcess() {
		setLoadProgress(0);
		C_MainCanvas.initResPak();
		setLoadProgress(18);
		C_MainCanvas.createMusicPlayers();
		for (int i = 0; i < C_MainCanvas.musicThemesStrings.length; i++) {
			C_MainCanvas.initMusicPlayer(i);
			setLoadProgress(i + 19);
		}
		setLoadProgress(28);
		E_Menu.theGame = this;
		setLoadProgress(29);
		F_StringManager.sub_e73();
		setLoadProgress(30);
		C_MainCanvas.sub_28be();
		setLoadProgress(32);

		this.actionIconsFrames = new G_Sprite("action_icons").frameImages;
		setLoadProgress(34);
		this.menuIconsFrames = new G_Sprite("menu_icons").frameImages;
		setLoadProgress(36);
		this.hudIconsSprite = new G_Sprite("hud_icons");
		setLoadProgress(38);
		this.hudIcons2Sprite = new G_Sprite("hud_icons_2");
		setLoadProgress(40);
		this.arrowSprite = new G_Sprite("arrow");
		setLoadProgress(42);
		this.sideArrowSprite = new G_Sprite("side_arrow");
		setLoadProgress(44);
		this.buttonsSprite = new G_Sprite("buttons");
		setLoadProgress(46);
		this.menuSprite = new G_Sprite("menu");
		setLoadProgress(48);
		this.bigCircleSprite = new G_Sprite("big_circle");
		setLoadProgress(50);
		this.smallCircleSprite = new G_Sprite("small_circle");
		setLoadProgress(52);
		this.smallSparkSprite = new G_Sprite("small_spark");
		setLoadProgress(54);
		this.alphaMaskSprite = new G_Sprite("alpha");
		setLoadProgress(56);
		try {
			this.gameOverImage = new D_ImageWrap("gameover");
		} catch (Exception localException1) {
			//
		}
		setLoadProgress(58);
		this.msLogoImage = new D_ImageWrap("ms_logo");
		setLoadProgress(62);
		
		InputStream tilesStream = C_MainCanvas.getResourceStream("tiles0.prop");
		if (tilesStream != null) {
			String tilesPropString = C_MainCanvas.streamToString((InputStream) tilesStream);
			while (tilesPropString != null) {
				int eolnIndex = tilesPropString.indexOf(';');
				if (eolnIndex >= 0) {
					tilesPropString = tilesPropString.substring(0, eolnIndex);
				}
				if ((tilesPropString = tilesPropString.trim()).length() != 0) {
					String[] lineStrs = C_MainCanvas.splitStringByChar(tilesPropString, ' ');
					if (lineStrs[0]
							.equalsIgnoreCase("TypeCount")) {
						int typesCount = Integer
								.parseInt(lineStrs[1]);
						tilesTypes = new byte[typesCount];
						tilesExtraDefence = new byte[typesCount];
					} else if (lineStrs[0].equalsIgnoreCase("TypeDef")) {
						int val = Integer.parseInt(lineStrs[1]);
						tilesTypes[val] = ((byte) Integer
								.parseInt(lineStrs[2]));
						tilesExtraDefence[val] = ((byte) Integer
								.parseInt(lineStrs[3]));
					} else if (lineStrs[0].equalsIgnoreCase("TileCount")) {
						int tilesCount = Integer.parseInt(lineStrs[1]);
						this.tilesDefs = new byte[tilesCount];
					} else if (lineStrs[0].equalsIgnoreCase("TileDef")) {
						this.tilesDefs[Integer.parseInt(lineStrs[1])] = ((byte) Integer
								.parseInt(lineStrs[2]));
					}
				}
			}
			try {
				tilesStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				DataInputStream dis = new DataInputStream(
						C_MainCanvas.getResourceStream("tiles0.bin"));
				short j = dis.readShort();
				dis.readShort();
				this.tilesDefs = new byte[j];
				for (int it = 0; it < j; it++) {
					this.tilesDefs[it] = dis.readByte();
				}
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		setLoadProgress(64);
		G_Sprite stiles0Sprite = new G_Sprite("stiles0");
		this.smallTilesFrames = stiles0Sprite.frameImages;
		setLoadProgress(70);
		this.miniIconsSprite = new G_Sprite("mini_icons");
		setLoadProgress(72);
		this.tiles0Frames = new G_Sprite("tiles0").frameImages;
		this.someCanWidth = this.canvasWidth;
		this.someCanHeight = this.canvasHeight;
		this.someCanWidthDiv2 = (this.someCanWidth >> 1);
		this.someCanHeightDiv2 = (this.someCanHeight >> 1);
		this.startupBgState = 0;
		for (int m = 0; m < 12; m++) {
			originalSkirmishMapNames12[m] = F_StringManager.getLangString(m + 101);
		}
		loadSettings();
		setLoadProgress(74);
		try {
			this.someSetting = C_MainCanvas.getRecordData("settings", 1)[0];
		} catch (Exception ex2) {
			//
		}
		setLoadProgress(76);
		this.downloadedMapsNames = new String[0];
		this.settingsIntListMaybe = new int[0];
		byte[] saveSlotBytes;
		try {
			saveSlotBytes = C_MainCanvas.getRecordData("settings", 2);
			DataInputStream settingsDIS = new DataInputStream(new ByteArrayInputStream(
					saveSlotBytes));
			this.settingsCountMaybe = settingsDIS.readInt();
			this.settingsIntListMaybe = new int[this.settingsCountMaybe];
			this.downloadedMapsNames = new String[this.settingsCountMaybe];
			for (int k = 0; k < this.settingsCountMaybe; k++) {
				this.settingsIntListMaybe[k] =  settingsDIS.readInt();
				this.downloadedMapsNames[k] =  settingsDIS.readUTF();
			}
			settingsDIS.close();
		} catch (Exception localException3) {
			//
		}
		setLoadProgress(80);
		this.downloadAvailableSize = C_MainCanvas.getAvailableRecordSize("download");
		setLoadProgress(84);
		this.saveSlotsDescriptions = new String[10];
		this.saveSlotBytes = new byte[10];
		this.saveSlotsMapIds = new int[10];
		for (int it = 0; it < 10; it++) {
			this.saveSlotBytes[it] = -1;
			this.saveSlotsMapIds[it] = -1;
			saveSlotBytes = null;
			try {
				saveSlotBytes = C_MainCanvas.getRecordData("save", it);
			} catch (Exception ex4) {
				//
			}
			if ((saveSlotBytes != null) && (saveSlotBytes.length != 0)) {
				try {
					DataInputStream dis= new DataInputStream(
							new ByteArrayInputStream(saveSlotBytes));
					byte modeId = dis.readByte();
					int mapId = dis.readByte();
					dis.readByte();
					dis.readByte();
					byte i2 = dis.readByte();
					short turnsCount = dis.readShort();
					dis.close();
					this.saveSlotBytes[it] = i2;
					this.saveSlotsDescriptions[it] = getSaveSlotDescription(modeId, mapId, turnsCount);
					this.saveSlotsMapIds[it] = mapId;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				String noSavedGamesStr = F_StringManager.getLangString(79);
				this.saveSlotsDescriptions[it] = ("\n" + noSavedGamesStr + "\n ");
			}
		}
		setLoadProgress(90);
		int msSkPosAppProp = 0;
		String value;
		if ((value = Main.mainMIDlet
				.getAppProperty("ProvisionX-Highscore-gameCode")) != null) {
			this.provisionHighscoreGameCodeAppProp = value.trim();
		}
		if ((value = Main.mainMIDlet
				.getAppProperty("ProvisionX-Highscore-portalCode")) != null) {
			this.provisionHighscorePortalCodeAppProp = value.trim();
		}
		if ((value = Main.mainMIDlet.getAppProperty("ProvisionX-Highscore-Url")) != null) {
			this.provisionHighscoreUrlAppProp = value.trim();
		}
		if ((value = Main.mainMIDlet.getAppProperty("ms-highscoreUpload")) != null) {
			this.msHighScoreUploadAppProp = (Integer.parseInt(value.trim()) == 1);
		}
		if ((value = Main.mainMIDlet.getAppProperty("ms-skPos")) != null) {
			msSkPosAppProp = Integer.parseInt(value.trim());
		}
		if ((value = Main.mainMIDlet.getAppProperty("MIDlet-Version")) != null) {
			this.midletVersionAppProp = value.trim();
		}
		setLoadProgress(96);
		if (msSkPosAppProp == 1) {
			var_4602 = 2048;
			var_460a = 1024;
		}
		setLoadProgress(100);
		C_MainCanvas.playMusicLooped(0, 0);
		this.gameStateMb = 0;
	}

	private void setLoadProgress(int progress) {
		this.loadingProgress = progress;
		F_StringManager.mainCanvas.repaintAll();
	}

	private String getSaveSlotDescription(int modeId, int mapId, int turnsCount) {
		String mapName;
		if (modeId == 0) {
			mapName = F_StringManager.getLangString(mapId + 121);
		} else {
			mapName = sub_75cb(mapId);
		}
		String modeStr = F_StringManager.getLangString(modeId + 32);
		return modeStr + "\n" + mapName + "\n"
				+ "Current turn: " + (turnsCount + 1);
	}

	private boolean sub_5d81() {
		return (this.isGameActive) && (F_StringManager.mainCanvas.var_17b7 == this);
	}

	private void sub_5dc1() {
		this.msLogoImage = null;
		this.splashImage = null;
		this.aeLogoImage = null;
		this.glowLightOnLogoImage = null;
		System.gc();
		this.someCanHeight = (this.canvasHeight - var_4592);
		this.someCanHeightDiv2 = (this.someCanHeight >> 1);
		C_MainCanvas.stopCurrentMusicPlayer();
		if (this.gameStateMb != 1) {
			this.gameStateMb = 1;
			A_Unit.initializeUnitsData(this);
			C_MainCanvas.initResPak();
			this.unitTeamSprites = new G_Sprite[5][12];
			for (byte b = 0; b < 5; b = (byte) (b + 1)) {
				G_Sprite unitIconsSprite = new G_Sprite("unit_icons", b);
				int unitsCount = 12; //@todo move
				int unitFramesCount = unitIconsSprite.getImagesCount() / unitsCount;
				for (int unitInd = 0; unitInd < unitsCount; unitInd = (byte) (unitInd + 1)) {
					D_ImageWrap[] images;
					if (b == 0) {
						images = new D_ImageWrap[] { unitIconsSprite.frameImages[unitInd] };
						this.unitTeamSprites[b][unitInd] = new G_Sprite(
								images);
					} else {
						images = new D_ImageWrap[unitFramesCount];
						for (int frameInd = 0; frameInd < unitFramesCount; frameInd++) {
							images[frameInd] = unitIconsSprite.frameImages[(frameInd * unitsCount + unitInd)];
						}
						this.unitTeamSprites[b][unitInd] = new G_Sprite(
								images);
					}
				}
			}
			this.var_4c5a = new Image[2][this.tiles0Frames.length];
			for (byte b = 0; b < 2; b = (byte) (b + 1)) {
				for (int i = 0; i < this.tiles0Frames.length; i = (byte) (i + 1)) {
					this.var_4c5a[b][i] = Image.createImage(24, 24);
					Graphics graph = this.var_4c5a[b][i].getGraphics();
					this.tiles0Frames[i].drawOnGraphics((Graphics) graph, 0, 0);
					this.alphaMaskSprite.drawFrame((Graphics) graph, b, 0, 0, 0);
				}
			}
			this.portraitsSprite = new G_Sprite("portraits");
			this.cursorSprite = new G_Sprite("cursor");
			this.redsparkSprite = new G_Sprite("redspark");
			this.smokeSprite = new G_Sprite("smoke");
			this.sparkSprite = new G_Sprite("spark");
			this.statusSprite = new G_Sprite("status");
			this.arrowIconsSprite = new G_Sprite("arrow_icons");
			this.tombStoneImage = new D_ImageWrap("tombstone");
			this.levelUpSprite = new G_Sprite("levelup");
			this.kingHeadsIcons = new G_Sprite[2];
			this.kingHeadsIcons[0] = new G_Sprite("king_head_icons");
			this.kingHeadsIcons[1] = new G_Sprite("king_head_icons");//@todo load gray_ ("king_head_icons",
																	// 0);
			this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
			this.currentCursorSpriteMaybe = new G_Sprite(this.cursorSprite);
			this.currentCursorSpriteMaybe.setFrameSequence(frameSequencesCursorMb[3]);
			this.var_497a = new D_ImageWrap[2];
			this.var_4972 = var_46aa[0];
			this.var_497a[0] = this.tiles0Frames[var_46aa[0]];
			this.var_497a[1] = this.tiles0Frames[var_46aa[1]];
			this.bSmokeSprite = new G_Sprite("b_smoke");
		}
	}

	//@Override
	public final void someUnknownMethod() {
		this.var_4c42 = true;
		this.var_4c4a = true;
		this.var_4eb2 = true;
		this.var_4eaa = true;
	}

	private void loadSlot(byte[] data) {

		try {
			DataInputStream dis = new DataInputStream(
					new ByteArrayInputStream(data));

			this.scenarioModeIf0 = dis.readByte();
			this.scenarioMapIndex = dis.readByte();
			this.teamsCountMaybe = dis.readByte();
			loadMapById(this.scenarioMapIndex);
			this.currentPlayerId = dis.readByte();
			dis.readByte();
			this.currentTurn = dis.readShort();
			this.var_49ca = dis.readByte();
			this.teamsCountMaybe = dis.readByte();
			for (int i = 0; i < this.teamsCountMaybe; i++) {
				this.var_483a[i] = dis.readByte();
				this.someTeamValuesArr[i] = dis.readByte();
				this.var_486a[i] = dis.readInt();
				this.kingsPositions[i][0] = dis.readByte();
				this.kingsPositions[i][1] = dis.readByte();
			}
			this.var_45f2 = dis.readShort();
			for (int i = 0; i < this.somePositionsOrTilesData.length; i++) {
				this.mapTilesIds[this.somePositionsOrTilesData[i][0]][this.somePositionsOrTilesData[i][1]] = dis
						.readByte();
			}
			this.teamsUnits = new A_Unit[this.teamsCountMaybe][4];
			this.teamsUnitsCount = new int[this.teamsCountMaybe];
			sub_ac6f();
			byte dataLength = dis.readByte();
			int j = 0;
			while (j < dataLength) {
				byte unitType = dis.readByte();
				byte teamId = dis.readByte();
				byte k = dis.readByte();
				byte b3 = dis.readByte();
				byte unitHealth = dis.readByte();
				byte unitLvl = dis.readByte();
				short unitExp = dis.readShort();
				short posX = dis.readShort();
				short posY = dis.readShort();
				byte b5 = dis.readByte();
				byte b6 = dis.readByte();
				A_Unit unit = A_Unit.createUnit(unitType, teamId, posX, posY);
				unit.var_e83 = k;
				unit.experience = unitExp;
				unit.setUnitLevel(unitLvl);
				unit.status = b3;
				unit.calcStatusEffect();
				unit.health = unitHealth;
				unit.var_ecb = b5;
				unit.var_ed3 = b6;
				if (unitType == 9) {
					byte kingNameId = dis.readByte();
					short kingCost = dis.readShort();
					unit.setKingName(kingNameId);
					unit.cost = kingCost;
					if (dis.readByte() == 1) {// isALive?
						this.maybeTeamKings[unit.teamId] = unit;
					}
				}
				j++;
			}
			this.aState = dis.readShort();
			this.var_4e22 = dis.readInt();
			this.var_4e2a = dis.readInt();
			this.isWaiting = (dis.readByte() != 0);
			dis.close();
			if ((this.scenarioMapIndex == 6) && (this.aState > 32)) {
				this.gameMessageBox = newMessageBox(
						F_StringManager.getLangString(121 + this.scenarioMapIndex),
						F_StringManager.getLangString(138), this.someCanHeight, -1);
				this.gameMessageBox.sub_132e((byte) 0, true);
				this.gameMessageBox.sub_1350(null);
			}
			moveCursorToPos(this.kingsPositions[this.currentPlayerId][0],
					this.kingsPositions[this.currentPlayerId][1]);
			sub_efe5(this.kingsPositions[this.currentPlayerId][0],
					this.kingsPositions[this.currentPlayerId][1]);
			C_MainCanvas.playMusic2(var_4692[this.var_4832[this.currentPlayerId]], 0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Error */
	private void sub_6431(int paramInt, F_StringManager paramClass_f_0145) {
		// ByteCodeError 1 @error
	}

	private static void loadSettings() {
		try {
			byte[] setBytes = C_MainCanvas.getRecordData("settings", 0);
			for (int i = 0; i < 4; i++) {
				C_MainCanvas.settings[i] = ((setBytes[0] & 1 << i) != 0 ? true
						: false);
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	private static void saveSettings() {
		try {
			byte[] setBytes = new byte[1];
			for (int i = 0; i < 4; i++) {
				if (C_MainCanvas.settings[i] != false) {
					setBytes[0] = ((byte) (setBytes[0] | 1 << i));
				}
			}
			C_MainCanvas.addSomeRecords("settings", 0, setBytes);
			return;
		} catch (Exception ex) {
			//
		}
	}

	private void sub_6963(A_Unit unit) {
		this.var_4b3a = 0;
		moveCursorToPos(unit.posX, unit.posY);
		this.var_4b32 = unit;
	}

	private void sub_6994(A_Unit paramClass_a_02601,
			A_Unit paramClass_a_02602) {
		if (paramClass_a_02602.var_e83 == 4) {
			this.var_48a2 = paramClass_a_02602;
			showSpriteOnMap(this.redsparkSprite, this.var_48a2.pixelX, this.var_48a2.pixelY, 0, 0, 1,
					50); // m n
			this.var_48ca = 6;
			this.someActiveUnit.sub_26fe();
			this.gameState = 0;
			sub_bc72();
			this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
			if (this.someTeamValuesArr[this.currentPlayerId] == 0) {
				this.var_4d5a = this.someGameTime;
				this.var_4d22 = 6;
			}
		} else {
			if ((C_MainCanvas.settings[3] != false)
					&& (paramClass_a_02602.chars.length > 0)) // n
			{
				this.var_4912 = true;
				this.var_491a = 0;
				C_MainCanvas.stopCurrentMusicPlayer();
			} else {
				this.gameState = 13;
				this.var_492a = 0;
				this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
			}
			this.attackingUnit = paramClass_a_02601;
			this.attackedUnit = paramClass_a_02602;
		}
	}

	private void sub_6a9a() {
		sub_bc72();
		if (this.attackingUnit.health <= 0) {
			this.dyingUnit = this.attackingUnit;
		} else if (this.attackingUnit.unitGotNewLevel()) {
			this.vectorOfSomeUnits.addElement(this.attackingUnit);
		}
		if (this.attackedUnit.health <= 0) {
			this.dyingUnit = this.attackedUnit;
		} else {
			if (this.attackingUnit.hasProperty((short) 128)) { // wolf
				// poison
				showSpriteOnMap(this.sparkSprite, this.attackedUnit.pixelX, this.attackedUnit.pixelY, 0, 0,
						1, 50); // m n
				G_Sprite sSprite = G_Sprite.getSpriteWithParams(this.statusSprite, 0, 0,
						-4, -1, 800, (byte) 5);
				sSprite.setPixelPosition(this.attackedUnit.pixelX
						+ (this.attackedUnit.spriteFrameWidth - sSprite.spriteFrameWidth) / 2,
						this.attackedUnit.pixelY - sSprite.spriteFrameHeight);
				sSprite.setFrameSequence(someFrameSeq);
				this.spritesOtherVector.addElement(sSprite);
				this.attackedUnit.applyPoisonStatus((byte) 1);
			}
			if (this.attackedUnit.unitGotNewLevel()) {
				this.vectorOfSomeUnits.addElement(this.attackedUnit);
			}
		}
		if (this.dyingUnit != null) {
			//show unit dying on map
			moveCursorToPos(this.dyingUnit.posX, this.dyingUnit.posY);
			showSpriteOnMap(this.sparkSprite, this.dyingUnit.pixelX, this.dyingUnit.pixelY, 0, 0, 1,
					50);
			C_MainCanvas.playMusicLooped(12, 1);
		}
		this.var_48aa = this.someGameTime;
		if (this.someTeamValuesArr[this.currentPlayerId] == 0) {
			this.var_4d5a = this.someGameTime;
			this.var_4d22 = 6;
		}
		this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
		this.gameState = 0;
		this.attackingUnit.sub_26fe();
		this.attackedUnit = null;
		this.attackingUnit = null;
	}

	public final G_Sprite showSpriteOnMap(G_Sprite inSpite,
			int pixX, int pixY, int mapPOsX, int mapPosY,
			int paramInt5, int frameDelay) {
		G_Sprite sprite = G_Sprite.getSpriteWithParams(inSpite,
				mapPOsX, mapPosY, 0, paramInt5, frameDelay, (byte) 0);
		sprite.setPixelPosition(pixX, pixY);
		this.spritesVector.addElement(sprite);
		return sprite;
	}

	private void showWhereUnitCanMoveMb(A_Unit unit) {
		this.canApplyMb = true;
		this.canCancelMb = (!this.var_49ea);
		this.alphaWindow = 12;
		this.gameState = 1;
		this.var_495a = true;
		sub_bcb2(this.var_47da, 0);
		unit.fillWhereUnitCanMove(this.var_47da);
		this.var_47e2 = true;
		this.var_47ea = false;
		this.cursorSprite.setFrameSequence(frameSequencesCursorMb[2]);
	}

	private void sub_6d11(byte[] paramArrayOfByte, int paramInt1,
			int paramInt2, F_StringManager sman) {
		E_Menu mMenu = new E_Menu((byte) 0, 0);
		this.var_4a32 = paramInt1;
		this.var_4a3a = paramInt2;
		int arrLength = paramArrayOfByte.length;
		Vector vec2 = new Vector(arrLength);
		Vector localVector = new Vector(arrLength);
		for (int i = 0; i < arrLength; i++) {
			int j = paramArrayOfByte[i];
			if ((this.msHighScoreUploadAppProp) || (j != 6)) {
				vec2.addElement(this.var_462a[j]);
				localVector.addElement(this.menuIconsFrames[j]);
			}
		}
		String[] stringsArr = new String[vec2.size()];
		D_ImageWrap[] imagesArr = new D_ImageWrap[localVector.size()];
		vec2.copyInto(stringsArr);
		localVector.copyInto(imagesArr);
		mMenu.sub_224f(stringsArr, imagesArr,
				this.canvasWidthShift, this.var_4a32, this.var_4a3a, 3, (byte) 1);
		mMenu.sub_1350(sman);
		F_StringManager.mainCanvas.showMessageBox(mMenu);
	}

	private void sub_6e49(byte[] paramArrayOfByte) {
		this.var_4882 = new E_Menu((byte) 0, 0);
		int arrLen = paramArrayOfByte.length;
		String[] stringsArr = new String[arrLen];
		D_ImageWrap[] imagesArr = new D_ImageWrap[arrLen];
		for (int j = 0; j < paramArrayOfByte.length; j++) {
			stringsArr[j] = this.var_461a[paramArrayOfByte[j]];
			imagesArr[j] = this.actionIconsFrames[paramArrayOfByte[j]];
		}
		if (this.cursorPosY * 24 <= this.someCanHeight / 2 - 24) {
			this.var_4882.sub_1e54(stringsArr, imagesArr, 0,
					this.someCanHeight - this.buttonsSprite.spriteFrameHeight, 36);
		} else {
			this.var_4882.sub_1e54(stringsArr, imagesArr,
					this.someCanWidth, 0, 8);
		}
		this.var_4882.sub_1350(this);
		F_StringManager.mainCanvas.showMessageBox(this.var_4882);
	}

	private E_Menu createSlotsMenu(String slotsMenuHeader, D_ImageWrap inImage) {
		String[] slotHeaders = new String[10];
		for (int sIndex = 0; sIndex < 10; sIndex++) {
			slotHeaders[sIndex] = ("SLOT " + (sIndex + 1) + "/" + 10);
		}
		this.sMenu = new E_Menu((byte) 14, 0);
		this.sMenu.initSlotsMenues(slotHeaders, this.someCanWidth, -1);
		this.slotDescriptionDialog = new E_Menu((byte) 10, 0);
		this.slotDescriptionDialog.initMessageBox(null, this.saveSlotsDescriptions[0], this.someCanWidth, -1);
		if (this.saveSlotBytes[0] != -1) {
			this.slotDescriptionDialog.var_11a2 = var_468a[this.saveSlotBytes[0]]; // color?
		}
		E_Menu lMenu = new E_Menu((byte) 15, 15);
		int lHeight = (this.someCanHeight - this.sMenu.mapPrevPixelHeight - this.slotDescriptionDialog.mapPrevPixelHeight) / 2;
		E_Menu captionMenu = new E_Menu((byte) 10, 0);
		captionMenu.initMessageBox(null, slotsMenuHeader, this.someCanWidth, -1);
		captionMenu.menuImage = inImage;
		lMenu.addChildMenu(captionMenu, 0, 0, 0);
		lHeight += captionMenu.mapPrevPixelHeight / 2;
		lMenu.addChildMenu(this.sMenu, 0, lHeight, 0);
		lHeight += this.sMenu.mapPrevPixelHeight;
		lMenu.addChildMenu(this.slotDescriptionDialog, 0, lHeight, 20);
		lMenu.var_115a = true;
		lMenu.sub_132e((byte) 0, true);
		return lMenu;
	}

	private void sub_70c0(F_StringManager sManager) {
		int sLength = this.someMapsNamesMb.length;
		String[] localObject1 = new String[sLength];
		int[] arrayOfInt2 = new int[sLength];
		int strCount = 0;
		for (int m = 0; m < sLength; m++) {
			int n = 0;
			int i1 = 0;
			while (i1 < this.settingsCountMaybe) {
				if (!this.someMapsNamesMb[m].equals(this.downloadedMapsNames[i1])) {
					i1++;
				} else {
					n = 1;
				}
			}
			if (n == 0) {
				localObject1[strCount] = this.someMapsNamesMb[m];
				arrayOfInt2[strCount] = m;
				strCount++;
			}
		}
		this.var_4c0a = new E_Menu((byte) 15, 15);
		E_Menu sMenu = new E_Menu((byte) 10, 0);
		sMenu.initMessageBox(null,
				F_StringManager.getLangString(48), this.someCanWidth, -1); //DOWNLOAD
		
		if (strCount == 0) {
			//EMPTY
			E_Menu menu2 = new E_Menu((byte) 10, 0);
			menu2.initMessageBox(null,
					F_StringManager.getLangString(52), this.someCanWidth, this.someCanHeightDiv2); 
			this.var_4c0a.addChildMenu((E_Menu) menu2, 0,
					(this.someCanHeight + sMenu.mapPrevPixelHeight) / 2, 6);
		} else {
			Object localObject2 = new String[strCount];
			int[] arrayOfInt1 = new int[strCount];
			System.arraycopy(localObject1, 0, localObject2, 0, strCount);
			System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, strCount);
			this.var_4c1a = new E_Menu((byte) 10, 0);
			String availableBSize = bytesSizeToString(this.downloadAvailableSize);
			String freeStr = F_StringManager.getStrByIdAndReplaceUWith(53, (String) availableBSize); //Free: %U KBytes
			this.var_4c1a.initMessageBox(
					null,
					F_StringManager.getStrByIdAndReplaceUWith(54,
							bytesSizeToString(this.mapBytesSizeMb[arrayOfInt1[0]]))
							+ "\n"
							+ freeStr, this.someCanWidth, -1); // Needed: %U KBytes
			this.someMenu = new E_Menu((byte) 11, 0);
			this.someMenu.setMenuListStringActionsMb((String[]) localObject2, this.someCanWidthDiv2,
					this.someCanHeightDiv2, this.someCanWidth, this.someCanHeight
							- sMenu.mapPrevPixelHeight
							- this.var_4c1a.mapPrevPixelHeight, 3, 4);
			this.someMenu.var_11c2 = arrayOfInt1;
			int j = (this.someCanHeight - this.var_4c1a.mapPrevPixelHeight
					- this.someMenu.mapPrevPixelHeight + sMenu.mapPrevPixelHeight) / 2;
			this.var_4c0a.addChildMenu(this.someMenu, 0, j, 20);
			j += this.someMenu.mapPrevPixelHeight;
			this.var_4c0a.addChildMenu(this.var_4c1a, 0, j, 20);
			this.var_4c0a.var_115a = true;
			this.var_4c0a.sub_132e((byte) 0, true);
		}
		this.var_4c0a.addChildMenu(sMenu, 0, 0, 20);
		this.var_4c0a.sub_1350(sManager);
	}

	private E_Menu createMenuForDeleteDownloadedMaps(F_StringManager inSM) {
		E_Menu menu1;
		if (this.downloadedMapsNames.length == 0) {
			menu1 = new E_Menu((byte) 10, 0);
			menu1.sub_165b(F_StringManager.getLangString(49)); //DELETE
			menu1.menuImage = this.menuIconsFrames[6]; // about Icon or Earth icon
			menu1.initMessageBox(null, F_StringManager.getLangString(52),
					this.canvasWidth, -1); // EMPTY
			menu1.setLocation(0,
					(this.someCanHeight + menu1.mapPrevPixelHeight) / 2, 6);
			menu1.sub_1350(inSM);
			this.someHoverMenu = null;
			return menu1;
		}
		// menu with list of downloaded maps
		this.someHoverMenu = new E_Menu((byte) 11, 0);
		menu1 = this.someHoverMenu.sub_165b(F_StringManager.getLangString(49));//DELETE
		menu1.menuImage = this.menuIconsFrames[6]; // about Icon or Earth icon
		this.someHoverMenu.setMenuListStringActionsMb(this.downloadedMapsNames, this.canvasWidth / 2,
				(this.someCanHeight + menu1.mapPrevPixelHeight) / 2,
				this.someCanWidth, this.someCanHeight - menu1.mapPrevPixelHeight, 3,
				4);
		this.someHoverMenu.sub_1350(inSM);
		return this.someHoverMenu;
	}

	private int getDownloadedMapNewIndex(int paramInt) {
		if (paramInt >= originalSkirmishMapNames12.length) {
			int index = (paramInt - originalSkirmishMapNames12.length);
			return this.settingsIntListMaybe[index] + originalSkirmishMapNames12.length;
		}
		return paramInt;
	}

	private static DataInputStream getMapDataInputStream(int mapIndex) {
		if (mapIndex >= originalSkirmishMapNames12.length) {
			mapIndex -= originalSkirmishMapNames12.length;
			return new DataInputStream(new ByteArrayInputStream(
					C_MainCanvas.getRecordData("download", mapIndex)));
		}
		return new DataInputStream(C_MainCanvas.getResourceStream("s" + mapIndex
				+ ".aem"));
	}

	private static byte[] loadMapBinary(int mapId) {
		if (mapId >= originalSkirmishMapNames12.length) {
			mapId -= originalSkirmishMapNames12.length;
			return C_MainCanvas.getRecordData("download", mapId);
		}
		try {
			InputStream stream;
			stream = C_MainCanvas.getResourceStream("s" + mapId); // SKIRMISH MApS
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int i;
			while ((i = stream.read()) >= 0) {
				baos.write(i);
			}
			stream.close();
			byte[] bArr = baos.toByteArray();
			baos.close();
			return bArr;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private String sub_75cb(int paramInt) {
		if (paramInt >= originalSkirmishMapNames12.length) {
			paramInt -= originalSkirmishMapNames12.length;
			for (int i = 0; i < this.settingsIntListMaybe.length; i++) {
				if (this.settingsIntListMaybe[i] == paramInt) {
					return this.downloadedMapsNames[i];
				}
			}
			return null;
		}
		return originalSkirmishMapNames12[paramInt];
	}

	private static String bytesSizeToString(int bytesCount) {
		int i = (bytesCount = bytesCount * 100 / 1024) / 100;
		bytesCount %= 100;
		return i + "." + bytesCount;
	}

	private static String sub_7696(String paramString1, String paramString2) {
		if (paramString1 != null) {
			if (paramString1.endsWith("/")) {
				paramString1 = paramString1.substring(0,
						paramString1.length() - 1);
			}
			int pos;
			if ((pos = paramString1.lastIndexOf('/')) >= 0) {
				return paramString1.substring(pos + 1);
			}
			return paramString1;
		}
		return paramString2;
	}

	public final void sub_770a(E_Menu paramClass_e_0134, int paramInt,
			String paramString, byte paramByte) {
		try {
			this.var_4f32 = true;
			if ((paramClass_e_0134 == this.var_4882) && (paramByte == 1)) {
				if (this.gameState == 3) {
					this.someActiveUnit.setOnMapPosition(this.var_47ca, this.var_47d2);
					this.someActiveUnit.fillWhereUnitCanMove(this.var_47da);
					showWhereUnitCanMoveMb(this.someActiveUnit);
					this.var_495a = true;
					return;
				}
			} else {
				if (paramClass_e_0134 == this.var_4b92) {
					if (paramByte == 0) {
						F_StringManager.mainCanvas.stopThread();
						return;
					}
					this.var_4b92 = null;
					return;
				}
				if (paramClass_e_0134 == this.var_4b9a) {
					if (paramByte == 0) {
						sub_6d11(this.var_465a, this.var_4a32, this.var_4a3a,
								paramClass_e_0134.stringManager);
					}
					this.var_4b9a = null;
					return;
				}
				Object localObject1 = null;
				C_AConnection localObject3;
				Object localObject4;
				Object localObject5;
				if (paramClass_e_0134 == this.var_4f4a) {
					if (paramByte == 0) {
						String someStr;
						if ((someStr = this.var_4f72[this.var_4f52.var_105a])
								.endsWith(".aem")) {
							localObject4 = (localObject3 = this.var_4f6a
									.createSomeFileConnection((String) someStr))
									.openInputStream();
							localObject5 = new ByteArrayOutputStream();
							int i4;
							while ((i4 = ((InputStream) localObject4).read()) >= 0) {
								((ByteArrayOutputStream) localObject5)
										.write(i4);
							}
							((InputStream) localObject4).close();
							((C_AConnection) localObject3).close();
							localObject1 = ((String) someStr).substring(
									0,
									((String) someStr).length()
											- ".aem".length());
							sub_19157((String) localObject1,
									((ByteArrayOutputStream) localObject5)
											.toByteArray());
							((ByteArrayOutputStream) localObject5).close();
							E_Menu clas;
							(clas = newMessageBox(null, F_StringManager.getStrByIdAndReplaceUWith(45,
									(String) localObject1), this.someCanHeight, 2000))
									.sub_1350(this.var_4f4a);
							F_StringManager.mainCanvas.showMessageBox((F_StringManager) clas);
						} else {
							this.var_4f6a.changeDirectory((String) localObject1);
							this.var_4f72 = B_FilesManager.mergeThese(B_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_4572
											: null);
							this.var_4f4a = new E_Menu((byte) 15, 15);
							E_Menu lo3;
							(lo3 = this.var_4f4a.sub_165b(sub_7696(
									this.var_4f6a.sub_877(),
									F_StringManager.getLangString(290)))).menuImage = this.menuIconsFrames[6];
							this.var_4f52 = new E_Menu((byte) 0, 0);
							this.var_4f52.setMenuListStringActionsMb(this.var_4f72, 0, 0,
									this.someCanWidth, this.someCanHeight
											- ((E_Menu) lo3).mapPrevPixelHeight
											- (this.buttonsSprite.spriteFrameHeight << 1), 3,
									4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 1)) {
								this.var_4f52.var_105a = 1;
							}
							this.var_4f4a
									.addChildMenu(
											this.var_4f52,
											this.someCanWidthDiv2,
											(this.someCanHeight + ((E_Menu) lo3).mapPrevPixelHeight) / 2,
											3);
							this.var_4f4a.sub_132e((byte) 0, true);
							this.var_4f4a.var_115a = true;
							this.var_4f4a.sub_1350(this.var_4bea);
							F_StringManager.mainCanvas.showMessageBox(this.var_4f4a);
							return;
						}
					} else {
						this.var_4f4a = null;
						this.var_4f52 = null;
						this.var_4f72 = null;
						return;
					}
				} else if (paramClass_e_0134 == this.var_4f5a) {
					if (paramByte == 0) {
						if (this.var_4f62.var_105a == 0) {
							localObject1 = this.mapStartUpMessage + ".aem";
						} else {
							localObject1 = this.var_4f72[this.var_4f62.var_105a];
						}
						if (((String) localObject1).endsWith(".aem")) {
							C_AConnection lo3 = this.var_4f6a
									.createSomeFileConnection((String) localObject1);
							if (lo3.exists()) {
								((C_AConnection) lo3).truncate(0L);
							} else {
								((C_AConnection) lo3).create();
							}
							OutputStream ostream;
							(ostream = ((C_AConnection) lo3).openOutputStream())
									.write(loadMapBinary(this.var_47aa));
							((OutputStream) ostream).close();
							((C_AConnection) lo3).close();
							this.var_4f72 = B_FilesManager.mergeThese(B_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_457a
											: null);
							this.var_4f5a = new E_Menu((byte) 15, 15);
							E_Menu loc5;
							(loc5 = this.var_4f5a.sub_165b(sub_7696(
									this.var_4f6a.sub_877(),
									F_StringManager.getLangString(299)))).menuImage = this.menuIconsFrames[6];
							this.var_4f62 = new E_Menu((byte) 0, 0);
							this.var_4f62.setMenuListStringActionsMb(this.var_4f72, 0, 0,
									this.someCanWidth, this.someCanHeight
											- ((E_Menu) loc5).mapPrevPixelHeight
											- (this.buttonsSprite.spriteFrameHeight << 1), 3,
									4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 2)) {
								this.var_4f62.var_105a = 2;
							}
							this.var_4f5a
									.addChildMenu(
											this.var_4f62,
											this.someCanWidthDiv2,
											(this.someCanHeight + ((E_Menu) loc5).mapPrevPixelHeight) / 2,
											3);
							this.var_4f5a.sub_132e((byte) 0, true);
							this.var_4f5a.var_115a = true;
							this.var_4f5a.sub_1350(this.var_4faa);
							E_Menu localClass_e_01344;
							(localClass_e_01344 = newMessageBox(null,
									F_StringManager.getStrByIdAndReplaceUWith(45, this.mapStartUpMessage),
									this.someCanHeight, 2000))
									.sub_1350(this.var_4f5a);
							F_StringManager.mainCanvas.showMessageBox(localClass_e_01344);
						} else {
							this.var_4f6a.changeDirectory((String) localObject1);
							this.var_4f72 = B_FilesManager.mergeThese(B_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_457a
											: null);
							this.var_4f5a = new E_Menu((byte) 15, 15);
							E_Menu theflocalObject3;
							(theflocalObject3 = this.var_4f5a
									.sub_165b(sub_7696(this.var_4f6a.sub_877(),
											F_StringManager.getLangString(290)))).menuImage = this.menuIconsFrames[6];
							this.var_4f62 = new E_Menu((byte) 0, 0);
							this.var_4f62
									.setMenuListStringActionsMb(
											this.var_4f72,
											0,
											0,
											this.someCanWidth,
											this.someCanHeight
													- ((E_Menu) theflocalObject3).mapPrevPixelHeight
													- (this.buttonsSprite.spriteFrameHeight << 1),
											3, 4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 2)) {
								this.var_4f62.var_105a = 2;
							}
							this.var_4f5a
									.addChildMenu(
											this.var_4f62,
											this.someCanWidthDiv2,
											(this.someCanHeight + ((E_Menu) theflocalObject3).mapPrevPixelHeight) / 2,
											3);
							this.var_4f5a.sub_132e((byte) 0, true);
							this.var_4f5a.var_115a = true;
							this.var_4f5a.sub_1350(this.var_4faa);
							F_StringManager.mainCanvas.showMessageBox(this.var_4f5a);
							return;
						}
					} else {
						this.var_4f5a = null;
						this.var_4f62 = null;
						this.var_4f72 = null;
						return;
					}
				} else {
					if (paramClass_e_0134 == this.var_4ba2) {
						if (paramByte == 0) {
							int i = this.sMenu.var_105a;
							sub_6431(i, this.var_4b7a);
						}
						this.var_4ba2 = null;
						return;
					}
					if (paramClass_e_0134 == this.var_4b12) {
						if ((paramByte == 2) || (paramByte == 3)) {
							this.var_4b1a
									.initMessageBox(
											null,
											F_StringManager
													.getLangString(184 + this.var_4b12.someUnits[paramInt].unitType),
											this.someCanWidth, this.someCanHeight
													- this.var_4b0a.mapPrevPixelHeight
													- this.var_4b12.mapPrevPixelHeight);
							this.var_4b0a.someUnit0 = this.var_4b12.someUnits[paramInt];
							this.var_4b1a.sub_1272();
							this.var_4b0a.sub_1272();
							return;
						}
					} else {
						if (paramClass_e_0134 == this.var_4b02) {
							if (paramByte == 0) {
								A_Unit olocalObject3 = this.var_4b12.someUnits[this.var_4b12.var_105a];
								if (!sub_12226((A_Unit) olocalObject3,
										this.cursorPosX, this.cursorPosY)) {
									return;
								}
								this.someActiveUnit = sub_abab(
										(A_Unit) olocalObject3,
										this.cursorPosX, this.cursorPosY);
								this.var_49ea = true;
								showWhereUnitCanMoveMb(this.someActiveUnit);
								F_StringManager.mainCanvas.showMessageBox(this);
							}
							this.var_4b02 = null;
							this.var_4b12 = null;
							this.var_4b1a = null;
							this.var_4b0a = null;
							return;
						}
						if (paramClass_e_0134 == this.var_49b2) {
							if ((paramByte == 2) || (paramByte == 3)) {
								String yylocalObject3 = F_StringManager.getLangString(
										var_499a[paramInt], true);
								this.var_49ba.initMessageBox(null,
										(String) yylocalObject3, this.someCanWidth,
										this.var_49ba.mapPrevPixelHeight);
								this.var_49ba.sub_1272();
								return;
							}
						} else {
							if (paramClass_e_0134 == this.var_49aa) {
								this.var_49aa = null;
								this.var_49b2 = null;
								this.var_49ba = null;
								return;
							}
							if (paramClass_e_0134 == this.gameMessageBox) {
								if (paramByte == 0) {
									F_StringManager.mainCanvas.showMessageBox(this);
									return;
								}
							} else {
								int i2 = 0;
								int i3;
								Object localObject6;
								int i6;
								if (paramClass_e_0134 == this.var_4a7a) {
									if (paramByte != 0) {
										this.var_4a7a = null;
										return;
									}
									this.var_4a82 = new E_Menu((byte) 15,
											15);
									E_Menu localClass_e_01341;
									(localClass_e_01341 = new E_Menu(
											(byte) 10, 0)).menuImage = this.menuIconsFrames[4];
									localClass_e_01341.initMessageBox(null,
											F_StringManager.getLangString(34),
											this.someCanWidth, -1);
									this.var_4a82.addChildMenu(localClass_e_01341,
											0, 0, 20);
									String[] str22;
									str22 = new String[this.var_4baa];
									for (i2 = 0; i2 < this.var_4baa; i2++) {
										str22[i2] = F_StringManager.getStrByIdAndReplaceUWith(38, ""
												+ (i2 + 1));
									}
									i2 = localClass_e_01341.mapPrevPixelHeight;
									E_Menu[] olocObj3;
									olocObj3 = new E_Menu[this.var_4baa];
									this.var_4a9a = new E_Menu[this.var_4baa];
									this.var_4aa2 = new E_Menu[this.var_4baa];
									for (paramInt = 0; paramInt < this.var_4baa; paramInt++) {
										this.var_4a9a[paramInt] = new E_Menu(
												(byte)14, 6);
										this.var_4a9a[paramInt]
												.initSlotsMenues(this.var_463a,
														this.canvasWidthShift, -1);
										this.var_4aa2[paramInt] = new E_Menu(
												(byte)14, 5);
										this.var_4aa2[paramInt].initSlotsMenues(str22,
												this.canvasWidthShift, -1);
										this.var_4aa2[paramInt].var_105a = paramInt;
										int i5 = Math
												.max(this.var_4a9a[paramInt].mapPrevPixelWidth,
														this.var_4aa2[paramInt].mapPrevPixelWidth);
										i3 = this.canvasWidth - i5;
										this.var_4a9a[paramInt].mapPrevPixelWidth = i5;
										this.var_4aa2[paramInt].mapPrevPixelWidth = i5;
										this.var_4a82.addChildMenu(
												this.var_4a9a[paramInt], i3,
												i2, 20);
										i2 += this.var_4a9a[paramInt].mapPrevPixelHeight;
										this.var_4a82.addChildMenu(
												this.var_4aa2[paramInt], i3,
												i2, 20);
										i2 += this.var_4aa2[paramInt].mapPrevPixelHeight;
										olocObj3[paramInt] = new E_Menu(
												(byte)10, 8);
										olocObj3[paramInt]
												.initMessageBox(
														null,
														F_StringManager
																.getLangString(this.var_4bb2[paramInt] - 1 + 89),
														i3,
														this.var_4a9a[paramInt].mapPrevPixelHeight
																+ this.var_4aa2[paramInt].mapPrevPixelHeight);
										olocObj3[paramInt].var_11a2 = var_468a[this.var_4bb2[paramInt]];
										this.var_4a82.addChildMenu(
												olocObj3[paramInt], 0, i2, 36);
									}
									this.var_4a82.var_114a = 1;
									E_Menu localClass_e_01345;
									(localClass_e_01345 = new E_Menu(
											(byte) 10, 8)).initMessageBox(null,
											F_StringManager.getLangString(40),
											this.someCanWidthDiv2, -1);
									this.var_4a82.addChildMenu(localClass_e_01345,
											0, i2, 20);
									this.var_4a8a = new E_Menu((byte) 14,
											4);
									String[] ssparamInt;
									ssparamInt = new String[var_45da.length];
									for (i3 = 0; i3 < ssparamInt.length; i3++) {
										ssparamInt[i3] = ("" + var_45da[i3]);
									}
									this.var_4a8a.initSlotsMenues(ssparamInt,
											this.someCanWidthDiv2,
											localClass_e_01345.mapPrevPixelHeight);
									this.var_4a82.addChildMenu(this.var_4a8a,
											this.canvasWidthShift, i2, 20);
									i2 += localClass_e_01345.mapPrevPixelHeight;
									(localClass_e_01341 = new E_Menu(
											(byte) 10, 8)).initMessageBox(null,
											F_StringManager.getLangString(41),
											this.someCanWidthDiv2, -1);
									this.var_4a82.addChildMenu(localClass_e_01341,
											0, i2, 20);
									this.var_4a92 = new E_Menu((byte) 14,
											4);
									String[] slocalObject6 = new String[var_45e2.length];
									for (i6 = 0; i6 < slocalObject6.length; i6++) {
										slocalObject6[i6] = ("" + var_45e2[i6]);
									}
									this.var_4a92.initSlotsMenues(
											(String[]) slocalObject6,
											this.someCanWidthDiv2,
											localClass_e_01341.mapPrevPixelHeight);
									this.var_4a82.addChildMenu(this.var_4a92,
											this.canvasWidthShift, i2, 20);
									this.var_4a82.sub_1350(paramClass_e_0134);
									this.var_4a82.sub_132e((byte) 0, true);
									F_StringManager.mainCanvas
											.showMessageBox(this.var_4a82);
									return;
								}
								int j;
								int n;
								if (paramClass_e_0134 == this.var_4a82) {
									if (paramByte == 0) {
										j = 0;
										i6 = 0;
										
										boolean[] booparamInt = new boolean[this.var_4baa];
										for (n = 0; n < this.var_4baa; n++) {
											if (this.var_4a9a[n].var_105a == 2) {
												this.someTeamValuesArr[n] = 2;
											} else {
												j++;
												if (this.var_4a9a[n].var_105a == 0) {
													this.someTeamValuesArr[n] = 1;
												} else if (this.var_4a9a[n].var_105a == 1) {
													this.someTeamValuesArr[n] = 0;
												}
												this.var_483a[n] = ((byte) this.var_4aa2[n].var_105a);
												if (booparamInt[this.var_483a[n]] == false) {
													i6++;
													booparamInt[this.var_483a[n]] = true;
												}
											}
										}
										if ((j < 2) || (i6 < 2)) {
											((E_Menu) (localObject6 = newMessageBox(null,
													F_StringManager.getLangString(39),
													this.someCanHeight, 2000)))
													.sub_1350(this.var_4a82);
											F_StringManager.mainCanvas
													.showMessageBox((F_StringManager) localObject6);
											return;
										}
										this.var_4a82 = null;
										this.var_4a7a = null;
										F_StringManager.mainCanvas.showMessageBox(this);
										this.var_45ea = var_45da[this.var_4a8a.var_105a];
										this.var_45f2 = var_45e2[this.var_4a92.var_105a];
										this.var_4a9a = null;
										this.var_4a8a = null;
										this.var_4a92 = null;
										sub_1af6c();
										this.scenarioModeIf0 = 1;
										this.var_49ca = 8;
										this.isLoadingBlackMb = true;
										F_StringManager.mainCanvas.repaintAll();
										sub_5dc1();
										loadMapById(this.var_47aa);
										this.scenarioMapIndex = this.var_47aa;
										this.isLoadingBlackMb = false;
										this.gameState = 0;
										return;
									}
								} else {
									byte[] localObject9 = null;
									Object localObject10;
									int k;
									if (paramClass_e_0134 == this.var_49da) {
										j = this.var_49d2.var_105a;
										if ((paramByte == 0)
												&& ((j >= originalSkirmishMapNames12.length) || (this.var_45d2[j] == false))) {
											this.var_47aa = getDownloadedMapNewIndex(j);
											int inti2 = ((DataInputStream) (localObject6 = getMapDataInputStream(this.var_47aa)))
													.readInt();
											n = ((DataInputStream) localObject6)
													.readInt();
											byte[][] arrayOfByte = new byte[inti2][n];
											this.var_4bb2 = new byte[4];
											localObject9 = new byte[5];
											for (i3 = 0; i3 < 5; i3++) {
												localObject9[i3] = -1;
											}
											this.var_4baa = 0;
											for (int i31 = 0; i31 < i2; i31++) {
												for (int i9 = 0; i9 < n; i9++) {
													arrayOfByte[i31][i9] = ((DataInputStream) localObject6)
															.readByte();
													if ((this.tilesDefs[arrayOfByte[i31][i9]] == 9)
															&& ((i6 = sub_11bd2(
																	i31, i9,
																	arrayOfByte)) != 0)
															&& (localObject9[i6] == -1)) {
														this.var_4bb2[this.var_4baa] = ((byte) i6);
														localObject9[i6] = (this.var_4baa++);
													}
												}
											}
											((DataInputStream) localObject6)
													.close();
											this.mapStartUpMessage = this.var_49d2.menuActionsListString[j];
											this.var_4a7a = new E_Menu(
													(byte) 15, 15);
											E_Menu localClass_e_01342;
											(localClass_e_01342 = new E_Menu(
													(byte) 10, 0)).menuImage = this.menuIconsFrames[4];
											localClass_e_01342.initMessageBox(null,
													this.mapStartUpMessage,
													this.someCanWidth, -1);
											localObject10 = new E_Menu(
													(byte) 8, 0);
											((E_Menu)localObject10)
													.setMapPreviewMaybe(
															this.canvasWidth,
															this.someCanHeight
																	- localClass_e_01342.mapPrevPixelHeight
																	- this.buttonsSprite.spriteFrameHeight,
															arrayOfByte, null);
											this.var_4a7a
													.addChildMenu(
															(E_Menu) localObject10,
															this.someCanWidthDiv2,
															this.someCanHeightDiv2
																	+ (localClass_e_01342.mapPrevPixelHeight - this.buttonsSprite.spriteFrameHeight)
																	/ 2, 3);
											this.var_4a7a
													.addChildMenu(
															localClass_e_01342,
															0, 0, 0);
											this.var_4a7a
													.sub_1350(paramClass_e_0134);
											this.var_4a7a.sub_132e((byte) 0,
													true);
											this.var_4a7a.var_115a = true;
											F_StringManager.mainCanvas
													.showMessageBox(this.var_4a7a);
										}
									} else if (paramClass_e_0134 == this.var_4f9a) {
										k = this.var_4fa2.var_105a - 1;
										if (paramByte != 0) {
											this.var_4f9a = null;
											this.var_4fa2 = null;
											return;
										}
										if (k < 0) {
											sub_1ac39();
											C_MainCanvas
													.setDisplayableAsCurrent(this.var_4fd2);
											return;
										}
										if ((k >= originalSkirmishMapNames12.length)
												|| (this.var_45d2[k] == false)) {
											this.var_47aa = getDownloadedMapNewIndex(k);
											this.mapStartUpMessage = this.var_4fa2.menuActionsListString[k];
											this.var_4f9a = null;
											this.var_4fa2 = null;
											F_StringManager.mainCanvas.showMessageBox(this);
											this.scenarioModeIf0 = 1;
											this.var_49ca = 8;
											this.var_4f92 = 1;
											this.isLoadingBlackMb = true;
											F_StringManager.mainCanvas.repaintAll();
											sub_5dc1();
											loadMapById(this.var_47aa);
											this.scenarioMapIndex = this.var_47aa;
											this.isLoadingBlackMb = false;
											this.gameState = 0;
										}
									} else if (paramClass_e_0134 == this.var_4faa) {
										k = this.var_4fb2.var_105a;
										if (paramByte != 0) {
											this.var_4faa = null;
											this.var_4fb2 = null;
											return;
										}
										if ((k >= originalSkirmishMapNames12.length)
												|| (this.var_45d2[k] == false)) {
											this.var_47aa = getDownloadedMapNewIndex(k);
											this.mapStartUpMessage = this.var_4fb2.menuActionsListString[k];
											if (this.var_4f6a == null) {
												this.var_4f6a = new B_FilesManager();
											}
											this.var_4f72 = B_FilesManager
													.mergeThese(
															B_FilesManager
																	.sortFoldersAndFiles(this.var_4f6a
																			.getDirectoryPaths(
																					".aem",
																					true)),
															this.var_4f6a
																	.sub_877() != null ? var_457a
																	: null);
											this.var_4f5a = new E_Menu(
													(byte) 15, 15);
											E_Menu localObject61 = this.var_4f5a
													.sub_165b(sub_7696(
															this.var_4f6a
																	.sub_877(),
															F_StringManager
																	.getLangString(299)));
											localObject61.menuImage = this.menuIconsFrames[6];
											this.var_4f62 = new E_Menu(
													(byte) 0, 0);
											this.var_4f62
													.setMenuListStringActionsMb(
															this.var_4f72,
															0,
															0,
															this.someCanWidth,
															this.someCanHeight
																	- ((E_Menu) localObject61).mapPrevPixelHeight
																	- (this.buttonsSprite.spriteFrameHeight << 1),
															3, 4);
											if ((this.var_4f6a.sub_877() != null)
													&& (this.var_4f72.length > 2)) {
												this.var_4f62.var_105a = 2;
											}
											this.var_4f5a
													.addChildMenu(
															this.var_4f62,
															this.someCanWidthDiv2,
															(this.someCanHeight + ((E_Menu) localObject61).mapPrevPixelHeight) / 2,
															3);
											this.var_4f5a.sub_132e((byte) 0,
													true);
											this.var_4f5a.var_115a = true;
											this.var_4f5a
													.sub_1350(this.var_4faa);
											F_StringManager.mainCanvas
													.showMessageBox(this.var_4f5a);
										}
									} else if (paramClass_e_0134 == this.var_4aaa) {
										if (paramByte == 1) {
											boolean booparamInt = C_MainCanvas.settings[0];
											int i7 = 0;
											for (int iti2 = 0; iti2 < 4; iti2++) {
												boolean i8;
												if ((i8 = (this.var_4ab2[iti2].var_105a == 0 ? true
														: false)) != C_MainCanvas.settings[iti2]) {
													C_MainCanvas.settings[iti2] = i8;
													i7 = 1;
												}
											}
											if (i7 != 0) {
												saveSettings();
												if (booparamInt != C_MainCanvas.settings[0]) {
													if (C_MainCanvas.settings[0] == false) {
														C_MainCanvas.stopCurrentMusicPlayer();
														return;
													}
													if (this.gameStateMb == 1) {
														if ((this.gameState != 11)
																&& (this.gameState != 14)) {
															C_MainCanvas
																	.playMusicLooped(
																			var_4692[this.var_4832[this.currentPlayerId]],
																			0);
														}
													} else if (this.gameStateMb == 0) {
														C_MainCanvas.playMusicLooped(
																0, 0);
													}
												}
											} else {
												this.var_4aaa = null;
												this.var_4ab2 = null;
											}
										}
										return;
									}
									Object localObject7 = null;
									if (paramClass_e_0134 == this.var_4b7a) {
										if (paramByte == 0) {
											k = this.sMenu.var_105a;
											if (this.saveSlotBytes[k] == -1) {
												sub_6431(k, paramClass_e_0134);
											} else {
												this.var_4ba2 = newMessageBox(null,
														F_StringManager
																.getLangString(88),
														this.someCanHeight, -1);
												this.var_4ba2.sub_132e(
														(byte) 0, true);
												this.var_4ba2
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4ba2);
											}
										} else {
											this.var_4b7a = null;
											this.sMenu = null;
											this.slotDescriptionDialog = null;
										}
									} else if (paramClass_e_0134 == this.var_4b72) {
										if (paramByte == 0) {
											localObject7 = null;
											try {
												localObject7 = C_MainCanvas
														.getRecordData(
																"save",
																this.sMenu.var_105a);
											} catch (Exception localException) {
											}
											if (localObject7 != null) {
												this.var_4b72 = null;
												sub_1af6c();
												this.sMenu = null;
												this.slotDescriptionDialog = null;
												F_StringManager.mainCanvas
														.showMessageBox(this);
												this.isLoadingBlackMb = true;
												F_StringManager.mainCanvas.repaintAll();
												sub_5dc1();
												loadSlot((byte[]) localObject7);
												if (this.scenarioModeIf0 == 0) {
													this.isGameActive = true;
												}
												this.isLoadingBlackMb = false;
												this.gameState = 0;
											}
										} else {
											this.var_4b72 = null;
											this.sMenu = null;
											this.slotDescriptionDialog = null;
										}
									} else if (paramClass_e_0134 == this.sMenu) {
										if ((paramByte == 2)
												|| (paramByte == 3)) {
											this.slotDescriptionDialog.initMessageBox(null,
													this.saveSlotsDescriptions[paramInt],
													this.someCanWidth, -1);
											if (this.saveSlotBytes[paramInt] == -1) {
												this.slotDescriptionDialog.var_11a2 = 2370117;
											} else {
												this.slotDescriptionDialog.var_11a2 = var_468a[this.saveSlotBytes[paramInt]];
											}
											this.slotDescriptionDialog.sub_1272();
										}
										return;
									}
									E_Menu localClass_e_01343;
									Object localObject8;
									if (paramClass_e_0134 == this.var_4be2) {
										if (paramByte == 0) {
											if (paramString
													.equals(this.var_4bd2[0])) {
												if (this.var_4ed2 == null) {
													sub_18c91(
															0,
															"news",
															F_StringManager
																	.getLangString(0),
															paramClass_e_0134);
													return;
												}
												this.var_4bf2 = sub_188fc(paramClass_e_0134);
												return;
											}
											if (paramString
													.equals(this.var_4bd2[1])) {
												this.var_4bea = new E_Menu(
														(byte) 11, 0);
												(localClass_e_01343 = this.var_4bea
														.sub_165b(paramString)).menuImage = this.menuIconsFrames[6];
												this.var_4bea
														.setMenuListStringActionsMb(
																this.var_4bda,
																this.canvasWidth / 2,
																(this.someCanHeight + localClass_e_01343.mapPrevPixelHeight) / 2,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.mapPrevPixelHeight,
																3, 0);
												this.var_4bea
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4bea);
											}
											if (paramString
													.equals(this.var_4bd2[2])) {
												this.var_4f9a = new E_Menu(
														(byte) 15, 15);
												(localClass_e_01343 = new E_Menu(
														(byte) 10, 0))
														.initMessageBox(null,
																paramString,
																this.someCanWidth,
																-1);
												localClass_e_01343.menuImage = this.menuIconsFrames[6];
												this.var_45d2 = new boolean[12];
												for (i6 = this.someSetting; i6 <= 7; i6++) {
													if (var_45ca[i6] >= 0) {
														this.var_45d2[var_45ca[i6]] = true;
													}
												}
												String[] strs;
												strs = new String[12];
												for (n = 0; n < 12; n++) {
													if (this.var_45d2[n] != false) {
														strs[n] = F_StringManager
																.getLangString(42);
													} else {
														strs[n] = originalSkirmishMapNames12[n];
													}
												}
												String[] strArr;
												(strArr = new String[12 + this.settingsCountMaybe + 1])[0] = F_StringManager
														.getLangString(292);
												System.arraycopy(strs, 0,
														strArr, 1, 12);
												System.arraycopy(this.downloadedMapsNames,
														0, strArr, 13,
														this.settingsCountMaybe);
												this.var_4fa2 = new E_Menu(
														(byte) 0, 0);
												this.var_4fa2
														.setMenuListStringActionsMb(
																(String[]) strArr,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.mapPrevPixelHeight
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_4f9a
														.addChildMenu(
																this.var_4fa2,
																this.someCanWidthDiv2,
																(this.someCanHeight + localClass_e_01343.mapPrevPixelHeight) / 2,
																3);
												this.var_4f9a.addChildMenu(
														localClass_e_01343, 0,
														0, 0);
												this.var_4f9a.var_115a = true;
												this.var_4f9a.sub_132e(
														(byte) 0, true);
												this.var_4f9a
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4f9a);
											}
										} else if (paramByte == 1) {
											this.var_4be2 = null;
										}
									} else if (paramClass_e_0134 == this.var_4bea) {
										if (paramByte == 0) {
											if (paramString
													.equals(this.var_4bda[0])) {
												if (this.var_4f6a == null) {
													this.var_4f6a = new B_FilesManager();
												}
												this.var_4f72 = B_FilesManager
														.mergeThese(
																B_FilesManager
																		.sortFoldersAndFiles(this.var_4f6a
																				.getDirectoryPaths(
																						".aem",
																						true)),
																this.var_4f6a
																		.sub_877() != null ? var_4572
																		: null);
												this.var_4f4a = new E_Menu(
														(byte) 15, 15);
												E_Menu clas;
												(clas = this.var_4f4a
														.sub_165b(sub_7696(
																this.var_4f6a
																		.sub_877(),
																F_StringManager
																		.getLangString(290)))).menuImage = this.menuIconsFrames[6];
												this.var_4f52 = new E_Menu(
														(byte) 0, 0);
												this.var_4f52
														.setMenuListStringActionsMb(
																this.var_4f72,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- ((E_Menu) clas).mapPrevPixelHeight
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												if ((this.var_4f6a.sub_877() != null)
														&& (this.var_4f72.length > 1)) {
													this.var_4f52.var_105a = 1;
												}
												this.var_4f4a
														.addChildMenu(
																this.var_4f52,
																this.someCanWidthDiv2,
																(this.someCanHeight + ((E_Menu) clas).mapPrevPixelHeight) / 2,
																3);
												this.var_4f4a.sub_132e(
														(byte) 0, true);
												this.var_4f4a.var_115a = true;
												this.var_4f4a
														.sub_1350(this.var_4bea);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4f4a);
											} else if (paramString
													.equals(this.var_4bda[1])) {
												this.var_4faa = new E_Menu(
														(byte) 15, 15);
												(localClass_e_01343 = new E_Menu(
														(byte) 10, 0))
														.initMessageBox(
																null,
																F_StringManager
																		.getLangString(299),
																this.someCanWidth,
																-1);
												localClass_e_01343.menuImage = this.menuIconsFrames[6];
												this.var_45d2 = new boolean[12];
												for (i6 = this.someSetting; i6 <= 7; i6++) {
													if (var_45ca[i6] >= 0) {
														this.var_45d2[var_45ca[i6]] = true;
													}
												}
												String[] strs2 = new String[12];
												for (n = 0; n < 12; n++) {
													if (this.var_45d2[n] != false) {
														strs2[n] = F_StringManager
																.getLangString(42);
													} else {
														strs2[n] = originalSkirmishMapNames12[n];
													}
												}
												String[] lo9;
												lo9 = new String[12 + this.settingsCountMaybe];
												System.arraycopy(strs2, 0,
														localObject9, 0, 12);
												System.arraycopy(this.downloadedMapsNames,
														0, localObject9, 12,
														this.settingsCountMaybe);
												this.var_4fb2 = new E_Menu(
														(byte) 0, 0);
												this.var_4fb2
														.setMenuListStringActionsMb(
																(String[]) lo9,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.mapPrevPixelHeight
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_4faa
														.addChildMenu(
																this.var_4fb2,
																this.someCanWidthDiv2,
																(this.someCanHeight + localClass_e_01343.mapPrevPixelHeight) / 2,
																3);
												this.var_4faa.addChildMenu(
														localClass_e_01343, 0,
														0, 0);
												this.var_4faa.var_115a = true;
												this.var_4faa.sub_132e(
														(byte) 0, true);
												this.var_4faa
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4faa);
											} else if (paramString
													.equals(this.var_4bda[2])) {
												if (this.someMapsNamesMb == null) {
													sub_18c91(
															2,
															"levels",
															F_StringManager
																	.getLangString(0),
															paramClass_e_0134);
												} else {
													sub_70c0(paramClass_e_0134);
													F_StringManager.mainCanvas
															.showMessageBox(this.var_4c0a);
												}
											} else if (paramString
													.equals(this.var_4bda[3])) {
												F_StringManager.mainCanvas
														.showMessageBox(createMenuForDeleteDownloadedMaps(paramClass_e_0134));
											}
										} else if (paramByte == 1) {
											this.var_4bea = null;
										}
									} else if (paramClass_e_0134 == this.var_4bf2) {
										if (paramByte == 0) {
											if (this.var_4ee2[paramInt] == null) {
												this.var_4ec2 = paramInt;
												sub_18c91(
														1,
														this.var_4eda[paramInt],
														F_StringManager.getLangString(0),
														paramClass_e_0134);
											} else {
												(localClass_e_01343 = sub_1437e(
														this.var_4ed2[paramInt],
														this.var_4ee2[paramInt],
														this.someCanHeight,
														this.someCanHeight / 2, -1))
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(localClass_e_01343);
											}
										} else if (paramByte == 1) {
											this.var_4bf2 = null;
										}
									} else if (paramClass_e_0134 == this.var_4c0a) {
										if (paramByte == 0) {
											this.var_4eca = this.someMenu.var_11c2[this.someMenu.var_105a];
											if (this.downloadAvailableSize >= this.mapBytesSizeMb[this.var_4eca]) {
												sub_18c91(
														3,
														this.var_4ef2[this.var_4eca],
														F_StringManager.getLangString(0),
														paramClass_e_0134);
											} else {
												(localClass_e_01343 = newMessageBox(
														null,
														F_StringManager
																.getLangString(55),
														this.someCanHeight, -1))
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(localClass_e_01343);
											}
										} else if (paramByte == 1) {
											this.var_4c1a = null;
											this.someMenu = null;
											this.var_4c0a = null;
										}
									} else if (paramClass_e_0134 == this.someMenu) {
										if ((paramByte == 2)
												|| (paramByte == 3)) {
											String str = bytesSizeToString(this.downloadAvailableSize);
											this.var_4c1a
													.initMessageBox(
															null,
															F_StringManager
																	.getStrByIdAndReplaceUWith(
																			54,
																			bytesSizeToString(this.mapBytesSizeMb[this.someMenu.var_11c2[paramInt]]))
																	+ "\n"
																	+ F_StringManager
																			.getStrByIdAndReplaceUWith(
																					53,
																					str),
															this.someCanWidth, -1);
											this.var_4c1a.sub_1272();
										}
									} else if (paramClass_e_0134 == this.someHoverMenu) {
										if (paramByte == 0) {
											if (this.settingsIntListMaybe[paramInt]
													+ originalSkirmishMapNames12.length == this.scenarioMapIndex) {
												(localClass_e_01343 = newMessageBox(
														null,
														F_StringManager
																.getLangString(56),
														this.someCanHeight, -1))
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(localClass_e_01343);
											} else {
												this.var_4c22 = paramInt;
												this.var_4c2a = paramString;
												this.var_4c02 = sub_1437e(
														null,
														F_StringManager
																.getStrByIdAndReplaceUWith(50,
																		paramString),
														this.someCanHeight,
														this.someCanHeightDiv2, -1);
												this.var_4c02
														.sub_1350(paramClass_e_0134);
												this.var_4c02.sub_132e(
														(byte) 0, true);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4c02);
											}
										} else if (paramByte == 1) {
											this.someHoverMenu = null;
										}
									} else if (paramClass_e_0134 == this.var_4c02) {
										if (paramByte == 0) {
											sub_19031(this.var_4c22);
											E_Menu cl0134 = createMenuForDeleteDownloadedMaps(this.someHoverMenu.stringManager);
											E_Menu cll = newMessageBox(null,
													F_StringManager.getStrByIdAndReplaceUWith(51,
															this.var_4c2a),
													this.someCanHeight, -1);
											cll.sub_1350(cl0134); 
											F_StringManager.mainCanvas
													.showMessageBox((F_StringManager) cll);
										}
										this.var_4c02 = null;
										this.var_4c2a = null;
									}
									if (paramClass_e_0134.typeMB == 7) {
										F_StringManager.mainCanvas.showMessageBox(this);
										return;
									}
									if ((paramString != null)
											&& (paramByte == 0)) {
										if (paramString
												.equals(this.var_462a[0])) {
											if ((this.gameStateMb != 0)
													&& (this.gameState == 0)) {
												this.var_4b9a = newMessageBox(null,
														F_StringManager
																.getLangString(87),
														this.someCanHeight, -1);
												this.var_4b9a.sub_132e(
														(byte) 0, true);
												this.var_4b9a
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4b9a);
												return;
											}
											sub_6d11(this.var_465a,
													this.var_4a32,
													this.var_4a3a,
													paramClass_e_0134);
											return;
										}
										if ((!paramString
												.equals(this.var_462a[1]))
												&& (paramClass_e_0134 != this.var_49e2)) {
											if (paramString.equals(F_StringManager
													.getLangString(3))) {
												this.var_49e2 = new E_Menu(
														(byte) 11, 0);
												int m = this.someSetting;
												if (this.someSetting > 7) {
													m = 7;
												}
												m++;
												String[] strs;
												strs = new String[m];
												for (i2 = 0; i2 < m; i2++) {
													strs[i2] = (i2 + 1 + ". " + F_StringManager
															.getLangString(i2 + 121));
												}
												E_Menu locOb;
												(locOb = this.var_49e2
														.sub_165b(paramString)).menuImage = this.menuIconsFrames[3];
												this.var_49e2
														.setMenuListStringActionsMb(
																strs,
																this.canvasWidth / 2,
																(this.someCanHeight + ((E_Menu) locOb).mapPrevPixelHeight) / 2,
																this.someCanWidth,
																this.someCanHeight
																		- ((E_Menu) locOb).mapPrevPixelHeight,
																3, 4);
												this.var_49e2
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_49e2);
												return;
											}
											if (paramString.equals(F_StringManager
													.getLangString(4))) {
												this.var_4b7a = createSlotsMenu(
														paramString,
														this.menuIconsFrames[10]);
												this.var_4b7a
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4b7a);
												return;
											}
											if (paramString.equals(F_StringManager
													.getLangString(5))) {
												this.var_4b72 = createSlotsMenu(
														paramString,
														this.menuIconsFrames[2]);
												this.var_4b72
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_4b72);
												return;
											}
											int i1;
											if (!paramString
													.equals(F_StringManager
															.getLangString(6))) {
												if (paramString
														.equals(F_StringManager
																.getLangString(7))) {
													this.var_4be2 = new E_Menu(
															(byte) 11, 0);
													E_Menu locOb2;
													(locOb2 = this.var_4be2
															.sub_165b(paramString)).menuImage = this.menuIconsFrames[6];
													this.var_4be2
															.setMenuListStringActionsMb(
																	this.var_4bd2,
																	this.canvasWidth / 2,
																	(this.someCanHeight + ((E_Menu) locOb2).mapPrevPixelHeight) / 2,
																	this.someCanWidth,
																	this.someCanHeight
																			- ((E_Menu) locOb2).mapPrevPixelHeight,
																	3, 0);
													this.var_4be2
															.sub_1350(paramClass_e_0134);
													F_StringManager.mainCanvas
															.showMessageBox(this.var_4be2);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(8))) {
													this.var_4aaa = new E_Menu(
															(byte) 15, 15);
													E_Menu locOb2;
													(locOb2 = new E_Menu(
															(byte) 10, 0)).menuImage = this.menuIconsFrames[5];
													((E_Menu) locOb2)
															.initMessageBox(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													this.var_4aaa
															.addChildMenu(
																	(E_Menu) locOb2,
																	0, 0, 20);
													i6 = ((E_Menu) locOb2).mapPrevPixelHeight;
													E_Menu[] localObjs;
													localObjs = new E_Menu[4];
													this.var_4ab2 = new E_Menu[4];
													for (i1 = 0; i1 < 4; i1++) {
														int iparamInt = 8;
														if (i1 != 0) {
															iparamInt = 9;
														}
														if (i1 != 3) {
															iparamInt |= 0x2;
														}
														localObjs[i1] = new E_Menu(
																(byte) 10,
																iparamInt);
														localObjs[i1]
																.initMessageBox(
																		null,
																		C_MainCanvas.var_1807[i1],
																		this.someCanWidthDiv2,
																		-1);
														this.var_4aaa.addChildMenu(
																localObjs[i1],
																0, i6, 20);
														int int4 = 4;
														if (i1 != 0) {
															int4 = 5;
														}
														if (i1 != 3) {
															int4 |= 0x2;
														}
														this.var_4ab2[i1] = new E_Menu(
																(byte) 14, int4);
														this.var_4ab2[i1]
																.initSlotsMenues(
																		this.var_4642,
																		this.someCanWidthDiv2,
																		localObjs[i1].mapPrevPixelHeight);
														this.var_4ab2[i1].var_105a = (C_MainCanvas.settings[i1] != false ? 0
																: 1);
														this.var_4aaa
																.addChildMenu(
																		this.var_4ab2[i1],
																		this.canvasWidthShift,
																		i6, 20);
														i6 += localObjs[i1].mapPrevPixelHeight;
													}
													this.var_4aaa.var_114a = 2;
													this.var_4aaa
															.sub_1350(paramClass_e_0134);
													F_StringManager.mainCanvas
															.showMessageBox(this.var_4aaa);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(9))) {
													this.var_49aa = new E_Menu(
															(byte) 15, 15);
													E_Menu lo2;
													(lo2 = new E_Menu(
															(byte) 10, 0))
															.initMessageBox(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													((E_Menu) lo2).menuImage = this.menuIconsFrames[7];
													String[] strParam2 = new String[20];
													for (i2 = 0; i2 < var_4992.length; i2++) {
														strParam2[i2] = (F_StringManager
																.getLangString(var_4992[i2])
																+ " "
																+ i2
																+ "/" + 19);
													}
													this.var_49b2 = new E_Menu(
															(byte) 14, 2);
													this.var_49b2.initSlotsMenues(
															strParam2,
															this.someCanWidth, -1);
													this.var_49ba = new E_Menu(
															(byte) 10, 1);
													this.var_49ba
															.initMessageBox(
																	null,
																	F_StringManager
																			.getLangString(var_499a[0]),
																	this.someCanWidth,
																	this.someCanHeight
																			- ((E_Menu) lo2).mapPrevPixelHeight
																			- this.var_49b2.mapPrevPixelHeight
																			- (this.buttonsSprite.spriteFrameHeight << 1));
													i2 = ((E_Menu) lo2).mapPrevPixelHeight
															+ this.buttonsSprite.spriteFrameHeight;
													this.var_49aa.addChildMenu(
															this.var_49b2,
															this.someCanWidthDiv2, i2,
															17);
													i2 += this.var_49b2.mapPrevPixelHeight;
													this.var_49aa.addChildMenu(
															this.var_49ba,
															this.someCanWidthDiv2, i2,
															17);
													this.var_49aa.addChildMenu(
															(E_Menu) lo2,
															0, 0, 0);
													this.var_49aa
															.sub_1350(paramClass_e_0134);
													this.var_49aa.var_115a = true;
													F_StringManager.mainCanvas
															.showMessageBox(this.var_49aa);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(10))) {
													E_Menu lo2;
													lo2 = new E_Menu(
															(byte) 15, 15);
													E_Menu lo7;
													(lo7 = new E_Menu(
															(byte) 10, 0))
															.initMessageBox(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													((E_Menu) lo7).menuImage = this.menuIconsFrames[8];
													localObject8 = new E_Menu(
															(byte) 10, 0);
													String lo9;
													lo9 = F_StringManager
															.getStrByIdAndReplaceUWith(
																	16,
																	this.midletVersionAppProp);
													((E_Menu) localObject8)
															.initMessageBox(
																	null,
																	(String) lo9,
																	this.someCanWidth,
																	this.someCanHeight
																			- ((E_Menu) lo7).mapPrevPixelHeight
																			- (this.buttonsSprite.spriteFrameHeight << 1));
													((E_Menu) lo2)
															.addChildMenu(
																	(E_Menu) localObject8,
																	0,
																	(this.someCanHeight + ((E_Menu) lo7).mapPrevPixelHeight) / 2,
																	6);
													((E_Menu) lo2)
															.addChildMenu(
																	(E_Menu) lo7,
																	0, 0, 0);
													((E_Menu) lo2)
															.sub_1350(paramClass_e_0134);
													((E_Menu) lo2).var_115a = true;
													F_StringManager.mainCanvas
															.showMessageBox((F_StringManager) lo2);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(11))) {
													this.var_4b92 = newMessageBox(
															null,
															F_StringManager
																	.getLangString(86),
															this.someCanHeight, -1);
													this.var_4b92.sub_132e(
															(byte) 0, true);
													this.var_4b92
															.sub_1350(paramClass_e_0134);
													F_StringManager.mainCanvas
															.showMessageBox(this.var_4b92);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(60))) {
													sub_6d11(this.var_4652,
															this.someCanHeightDiv2,
															this.someCanHeight,
															paramClass_e_0134);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(61))) {
													this.var_49ea = false;
													showWhereUnitCanMoveMb(this.someActiveUnit);
													F_StringManager.mainCanvas
															.showMessageBox(this);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(62))) {
													sub_bcb2(this.var_47da, 0);
													this.var_4792 = this.gameState;
													this.gameState = 6;
													this.var_495a = true;
													this.var_47ba = this.someActiveUnit
															.getUnitsInAttackRange1(
																	this.someActiveUnit.posX,
																	this.someActiveUnit.posY,
																	(byte) 0);
													this.var_47b2 = 0;
													this.var_47e2 = true;
													this.var_47ea = true;
													this.someActiveUnit
															.setAttackMaskForPosition(
																	this.var_47da,
																	this.someActiveUnit.posX,
																	this.someActiveUnit.posY);
													this.cursorSprite
															.setFrameSequence(frameSequencesCursorMb[1]);
													moveCursorToPos(
															this.var_47ba[this.var_47b2].posX,
															this.var_47ba[this.var_47b2].posY);
													this.canCancelMb = true;
													this.canApplyMb = true;
													F_StringManager.mainCanvas
															.showMessageBox(this);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(63))) {
													this.var_4b02 = new E_Menu(
															(byte) 15, 15);
													this.var_4b02.var_11e2 = this.someCanHeight;
													this.var_4b0a = new E_Menu(
															(byte) 2, 2);
													this.var_4b12 = new E_Menu(
															(byte) 3, 1);
													this.var_4b1a = new E_Menu(
															(byte) 10, 3);
													this.var_4b1a.var_1152 = true;
													this.var_4b0a.someUnit0 = this.var_4b12.someUnits[0];
													this.var_4b1a
															.initMessageBox(
																	null,
																	F_StringManager
																			.getLangString(184 + this.var_4b12.someUnits[0].unitType),
																	this.someCanWidth,
																	this.someCanHeight
																			- this.var_4b0a.mapPrevPixelHeight
																			- this.var_4b12.mapPrevPixelHeight);
													this.var_4b02.addChildMenu(
															this.var_4b0a, 0,
															0, 0);
													this.var_4b02
															.addChildMenu(
																	this.var_4b1a,
																	0,
																	this.var_4b0a.mapPrevPixelHeight,
																	0);
													this.var_4b02.addChildMenu(
															this.var_4b12, 0,
															this.someCanHeight, 32);
													this.var_4b02.var_115a = true;
													this.var_4b02
															.sub_1350(this);
													this.var_4b02.sub_132e(
															(byte) 0, true);
													F_StringManager.mainCanvas
															.showMessageBox(this.var_4b02);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(64))) {
													this.someActiveUnit.sub_26fe();
													sub_bc72();
													this.unitAtCursorPos = getUnitAtPos(
															this.cursorPosX,
															this.cursorPosY,
															(byte) 0);
													this.gameState = 0;
													F_StringManager.mainCanvas
															.showMessageBox(this);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(66))) {
													sub_11699();
													F_StringManager.mainCanvas
															.showMessageBox(this);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(68))) {
													setMapTileId(
															(byte) 37,
															this.someActiveUnit.posX,
															this.someActiveUnit.posY);
													F_StringManager.mainCanvas
															.showMessageBox(newMessageBox(
																	null,
																	F_StringManager
																			.getLangString(74),
																	this.someCanHeight,
																	1000));
													C_MainCanvas.playMusicLooped(9, 1);
													this.someActiveUnit.sub_26fe();
													this.gameState = 0;
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(67))) {
													if (canOccupyVillageOrTownMaybe(this.someActiveUnit)) {
														changeTileToOccupiedByTeam(
																this.someActiveUnit.posX,
																this.someActiveUnit.posY,
																this.var_4832[this.someActiveUnit.teamId]);
														F_StringManager.mainCanvas
																.showMessageBox(newMessageBox(
																		null,
																		F_StringManager
																				.getLangString(73),
																		this.someCanHeight,
																		1000));
														this.gameState = 9;
														C_MainCanvas.playMusicLooped(
																9, 1);
														this.var_481a = this.someGameTime;
													}
													this.someActiveUnit.sub_26fe();
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(69))) {
													this.gameState = 7;
													this.var_47ba = this.someActiveUnit
															.getUnitsInAttackRange1(
																	this.someActiveUnit.posX,
																	this.someActiveUnit.posY,
																	(byte) 1);
													this.var_47e2 = true;
													this.var_47ea = true;
													this.someActiveUnit
															.setAttackMaskForPosition(
																	this.var_47da,
																	this.someActiveUnit.posX,
																	this.someActiveUnit.posY);
													this.canCancelMb = true;
													F_StringManager.mainCanvas
															.showMessageBox(this);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(70))) {
													E_Menu localObject2 = new E_Menu(
															(byte) 15, 15);
													E_Menu localObject71 = new E_Menu(
															(byte) 10, 0);
													localObject71.initMessageBox(
																	null,
																	this.mapStartUpMessage,
																	this.someCanWidth,
																	-1);
													E_Menu localObject81 = new E_Menu(
															(byte) 8, 0);
													localObject81.setMapPreviewMaybe(
																	this.someCanWidth,
																	this.someCanHeight
																			- ((E_Menu) localObject71).mapPrevPixelHeight
																			- this.buttonsSprite.spriteFrameHeight,
																	this.mapTilesIds,
																	this.mapUnitsMaybe);
													((E_Menu) localObject2)
															.addChildMenu(
																	(E_Menu) localObject81,
																	this.someCanWidthDiv2,
																	this.someCanHeightDiv2
																			+ (((E_Menu) localObject71).mapPrevPixelHeight - this.buttonsSprite.spriteFrameHeight)
																			/ 2,
																	3);
													((E_Menu) localObject2)
															.addChildMenu(
																	(E_Menu) localObject71,
																	0, 0, 0);
													((E_Menu) localObject2)
															.sub_1350(paramClass_e_0134);
													((E_Menu) localObject2).var_115a = true;
													F_StringManager.mainCanvas
															.showMessageBox((F_StringManager) localObject2);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(71))) {
													this.gameMessageBox.sub_132e(
															(byte) 0, false);
													this.gameMessageBox
															.sub_1350(paramClass_e_0134);
													F_StringManager.mainCanvas
															.showMessageBox(this.gameMessageBox);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(293))) {
													sub_19157(this.mapStartUpMessage,
															sub_bb13());
													E_Menu fAnima = newMessageBox(
															null,
															F_StringManager
																	.getStrByIdAndReplaceUWith(
																			45,
																			this.mapStartUpMessage),
																			this.someCanHeight, 2000);
													fAnima.sub_1350(this);
													F_StringManager.mainCanvas
															.showMessageBox((F_StringManager) fAnima);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(305))) {
													sub_1a88b();
													C_MainCanvas
															.setDisplayableAsCurrent(this.var_4fe2);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(306))) {
													sub_1aaa3();
													sub_1a91d();
													C_MainCanvas
															.setDisplayableAsCurrent(this.var_4fea);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(307))) {
													sub_1aa08();
													C_MainCanvas
															.setDisplayableAsCurrent(this.var_4ffa);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(303))) {
													sub_1aaa3();
													C_MainCanvas
															.setDisplayableAsCurrent(this.var_4fda);
													return;
												}
												if (paramString
														.equals(F_StringManager
																.getLangString(314))) {
													sub_1afeb();
													C_MainCanvas
															.setDisplayableAsCurrent(this.var_505a);
													return;
												}
											} else {
												this.var_49da = new E_Menu(
														(byte) 15, 15);
												E_Menu lo2;
												(lo2 = new E_Menu(
														(byte) 10, 0))
														.initMessageBox(null,
																paramString,
																this.someCanWidth,
																-1);
												((E_Menu) lo2).menuImage = this.menuIconsFrames[4];
												this.var_45d2 = new boolean[12];
												for (i6 = this.someSetting; i6 <= 7; i6++) {
													if (var_45ca[i6] >= 0) {
														this.var_45d2[var_45ca[i6]] = true;
													}
												}
												String[] lo9;
												lo9 = new String[12];
												for (i1 = 0; i1 < 12; i1++) {
													if (this.var_45d2[i1] != false) {
														lo9[i1] = F_StringManager
																.getLangString(42);
													} else {
														lo9[i1] = originalSkirmishMapNames12[i1];
													}
												}
												localObject10 = new String[12 + this.settingsCountMaybe];
												System.arraycopy(lo9,
														0, localObject10, 0, 12);
												System.arraycopy(this.downloadedMapsNames,
														0, localObject10, 12,
														this.settingsCountMaybe);
												this.var_49d2 = new E_Menu(
														(byte) 0, 0);
												this.var_49d2
														.setMenuListStringActionsMb(
																(String[]) localObject10,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- ((E_Menu) lo2).mapPrevPixelHeight
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_49da
														.addChildMenu(
																this.var_49d2,
																this.someCanWidthDiv2,
																(this.someCanHeight + ((E_Menu) lo2).mapPrevPixelHeight) / 2,
																3);
												this.var_49da
														.addChildMenu(
																(E_Menu) lo2,
																0, 0, 0);
												this.var_49da.var_115a = true;
												this.var_49da.sub_132e(
														(byte) 0, true);
												this.var_49da
														.sub_1350(paramClass_e_0134);
												F_StringManager.mainCanvas
														.showMessageBox(this.var_49da);
												return;
											}
										} else {
											F_StringManager.mainCanvas.showMessageBox(this);
											if (paramClass_e_0134 == this.var_49e2) {
												this.scenarioMapIndex = paramInt;
												this.var_49e2 = null;
											} else {
												this.scenarioMapIndex = 0;
											}
											sub_1af6c();
											this.scenarioModeIf0 = 0;
											this.someTeamValuesArr[1] = 0;
											this.isLoadingBlackMb = true;
											F_StringManager.mainCanvas.repaintAll();
											System.gc();
											sub_5dc1();
											loadMapById(this.scenarioMapIndex);
											this.isLoadingBlackMb = false;
											initMap();
											this.gameState = 0;
										}
									}
								}
							}
						}
					}
				}
			}
			return;
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
	}

	private A_Unit sub_abab(A_Unit paramClass_a_0260,
			int paramInt1, int paramInt2) {
		this.var_486a[this.currentPlayerId] -= paramClass_a_0260.cost;
		paramClass_a_0260.health = 100;
		paramClass_a_0260.setOnMapPosition(paramInt1, paramInt2);
		if (!this.mapUnitsMaybe.contains(paramClass_a_0260)) {
			this.mapUnitsMaybe.addElement(paramClass_a_0260);
		}
		this.var_4c42 = true;
		return paramClass_a_0260;
	}

	private A_Unit sub_ac11(byte paramByte, int paramInt1, int paramInt2) {
		this.var_486a[this.currentPlayerId] -= A_Unit.unitsCost[paramByte];
		this.var_4c42 = true;
		return A_Unit.createUnit(paramByte, this.currentPlayerId, paramInt1,
				paramInt2);
	}

	public final G_Sprite getTeamUnitSprite(byte teamId, byte unitType) {
		return this.unitTeamSprites[teamId][unitType];
	}

	private void sub_ac6f() {
		this.mapUnitsMaybe = new Vector();
		this.someActiveUnit = null;
		this.var_47ba = null;
		this.var_4c6a = null;
	}

	private void loadMapById(int mapIndex) {
		try {
			C_MainCanvas.stopCurrentMusicPlayer();
			this.spritesOtherVector = new Vector();
			this.var_4aca = false;
			this.isCursorVisible = true;
			this.var_4912 = false;
			this.var_4b4a = false;
			this.somePositions = null;
			this.dyingUnit = null;
			this.var_4b32 = null;
			this.var_48a2 = null;
			this.selectedTombUnit = null;
			this.vectorOfSomeUnits.removeAllElements();
			this.currentTurn = 0;
			this.currentPlayerId = 0;
			this.currentPlayerId = 0;
			this.aState = 0;
			sub_ac6f();
			this.maybeTeamKings = null;
			this.mapTilesIds = null;
			this.var_47da = null;
			this.teamsCountMaybe = 0;
			for (int i = 0; i < 5; i++) {
				this.var_482a[i] = -1;
			}
			this.var_495a = true;
			C_MainCanvas.initResPak();
			DataInputStream localObject;
			if (this.scenarioModeIf0 == 0) {
				this.mapStartUpMessage = F_StringManager.getLangString(mapIndex + 113); //0+113 //SKIRMISH The Temple of Courage 
				localObject = new DataInputStream(C_MainCanvas.getResourceStream("m"
						+ mapIndex + ".aem"));
			} else {
				this.mapStartUpMessage = sub_75cb(mapIndex);
				localObject = getMapDataInputStream(mapIndex);
			}
			this.mapWidth = ((DataInputStream) localObject).readInt();
			this.mapHeight = ((DataInputStream) localObject).readInt();
			this.mapTilesIds = new byte[this.mapWidth][this.mapHeight];
			this.var_47da = new byte[this.mapWidth][this.mapHeight];
			this.var_4d92 = new byte[this.mapWidth][this.mapHeight];
			this.var_4d9a = 0;
			int j = 0;
			Vector localVector1 = new Vector();
			Vector localVector2 = new Vector();
			for (int n = 0; n < this.mapWidth; n = (short) (n + 1)) {
				for (int i1 = 0; i1 < this.mapHeight; i1 = (short) (i1 + 1)) {
					this.mapTilesIds[n][i1] = ((DataInputStream) localObject)
							.readByte();
					this.var_47da[n][i1] = 0;
					if (isVillageOrTownEvenDestroyed(this.mapTilesIds[n][i1])) {
						int k = sub_11bae(n, i1);
						byte[] arrayOfByte2;
						(arrayOfByte2 = new byte[3])[0] = ((byte) n);
						arrayOfByte2[1] = ((byte) i1);
						arrayOfByte2[2] = ((byte) k);
						localVector1.addElement(arrayOfByte2);
						j++;
						if (getMapTileType(n, i1) == 9) {
							if ((this.scenarioModeIf0 == 1) && (k != 0)
									&& (this.var_482a[k] == -1)) {
								this.var_4832[this.teamsCountMaybe] = ((byte) k);
								this.var_482a[k] = (this.teamsCountMaybe++);
							}
							byte[] arrayOfByte1;
							(arrayOfByte1 = new byte[2])[0] = ((byte) n);
							arrayOfByte1[1] = ((byte) i1);
							localVector2.addElement(arrayOfByte1);
							this.var_4d9a += 1;
						}
					}
				}
			}
			this.var_4d82 = new int[j];
			this.somePositionsOrTilesData = new byte[j][];
			localVector1.copyInto(this.somePositionsOrTilesData);
			this.var_4a02 = new byte[this.var_4d9a][];
			localVector2.copyInto(this.var_4a02);
			this.var_46d2 = (this.mapWidth * 24);
			this.var_46da = (this.mapHeight * 24);
			if (this.scenarioModeIf0 == 1) { //skirmish
				for (int n = 0; n < this.teamsCountMaybe; n = (short) (n + 1)) {
					this.var_486a[n] = this.var_45ea;
				}
			}
			this.teamsCountMaybe = 2;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			this.var_482a[1] = 0;
			this.var_482a[2] = 1;
			this.var_4832[0] = 1;
			this.var_4832[1] = 2;
			this.var_483a[0] = 0;
			this.var_483a[1] = 1;
			this.someTeamValuesArr[0] = 1;
			this.someTeamValuesArr[1] = 0;
			this.var_45f2 = 100;
			int i2;
			for (int n = 0; n < this.somePositionsOrTilesData.length; n = (short) (n + 1)) {
				byte i1 = this.somePositionsOrTilesData[n][2];
				i2 = sub_11c17(i1);
				if ((i1 > 0) && ((i2 < 0) || (this.someTeamValuesArr[i2] == 2))) {
					int pX = this.somePositionsOrTilesData[n][0];
					int pY = this.somePositionsOrTilesData[n][1];
					changeTileToOccupiedByTeam(pX, pY, 0);
				}
			}
			int m = ((DataInputStream) localObject).readInt();
			((DataInputStream) localObject).skip(m << 2);
			int unitsCount = ((DataInputStream) localObject).readInt();
			this.maybeTeamKings = new A_Unit[this.teamsCountMaybe];
			this.teamsUnits = new A_Unit[this.teamsCountMaybe][4];
			this.teamsUnitsCount = new int[this.teamsCountMaybe];
			for (int n = 0; n < unitsCount; n = (short) (n + 1)) {
				int someVal1 = ((DataInputStream) localObject).readByte();
				int uPosX = ((DataInputStream) localObject).readShort() / 24;
				int uPosY = ((DataInputStream) localObject).readShort() / 24;
				byte uType = (byte) (someVal1 % 12);
				byte uTeam = (byte) sub_11c17(1 + someVal1 / 12);
				if (this.someTeamValuesArr[uTeam] != 2) {
					A_Unit unit1 = A_Unit.createUnit(uType,
							uTeam, uPosX, uPosY);
					if (uType == 9) {
						this.maybeTeamKings[uTeam] = unit1;
					}
				}
			}
			((DataInputStream) localObject).close();
			if (this.scenarioModeIf0 == 0) {
				// scenario
				this.gameMessageBox = newMessageBox(
						F_StringManager.getLangString(121 + this.scenarioMapIndex),
						F_StringManager.getLangString(129 + this.scenarioMapIndex),
						this.someCanHeight, -1);
			} else {
				// OBJECTIVE for skirmish
				this.gameMessageBox = newMessageBox(
						F_StringManager.getLangString(71), F_StringManager.getLangString(137),
						this.someCanHeight, -1);
			}
			this.var_4e3a = false;
			this.var_4e02 = null;
			this.var_4de2 = null;
			this.var_4dea = null;
			this.var_4df2 = null;
			this.var_4dfa = null;
			this.unitFinishedMove = null;
			for (short n = 0; n < this.maybeTeamKings.length; n = (short) (n + 1)) {
				if (this.maybeTeamKings[n] == null) {
					this.kingsPositions[n][0] = 0;
					this.kingsPositions[n][1] = 0;
				} else {
					this.kingsPositions[n][0] = ((byte) this.maybeTeamKings[n].posX);
					this.kingsPositions[n][1] = ((byte) this.maybeTeamKings[n].posY);
				}
			}
			if (this.scenarioModeIf0 == 1) {
				this.aState = 100;
				this.isGameActive = true;
				for (short n = 0; n < this.teamsCountMaybe; n = (short) (n + 1)) {
					if (this.someTeamValuesArr[n] != 2) {
						this.currentPlayerId = ((byte) n);
						break;
					}
					this.currentTurn = ((short) (this.currentTurn + 1));
				}
			}
			if ((this.maybeTeamKings.length > 0)
					&& (this.maybeTeamKings[this.currentPlayerId] != null)) {
				sub_efe5(this.maybeTeamKings[this.currentPlayerId].posX,
						this.maybeTeamKings[this.currentPlayerId].posY);
				moveCursorToPos(this.maybeTeamKings[this.currentPlayerId].posX,
						this.maybeTeamKings[this.currentPlayerId].posY);
			}
			this.aSomeUnitsArr = new A_Unit[this.somePositionsOrTilesData.length];
			this.var_4d72 = new byte[this.somePositionsOrTilesData.length];
			this.aSomeSpritesArr = new G_Sprite[this.somePositionsOrTilesData.length];
			//create smoke for all houses
			for (short n = 0; n < this.somePositionsOrTilesData.length; n = (short) (n + 1)) {
				// if unoccupied house tile 8
				if (getMapTileType(this.somePositionsOrTilesData[n][0], this.somePositionsOrTilesData[n][1]) == 8) {
					this.aSomeSpritesArr[n] = G_Sprite.getSpriteWithParams(this.bSmokeSprite, 0,
							-1, 0, 1, 250, (byte) 0);
					this.aSomeSpritesArr[n].isVisibleMb = false;
				}
			}
			if (this.someTeamValuesArr[this.currentPlayerId] == 0) {
				sub_122cc();
			}
			if ((this.var_4f92 != 0) || (this.teamsCountMaybe == 0)) {
				C_MainCanvas.playMusic2(var_4692[1], 0);
			}
			if (this.var_4f92 != 0) {
				this.mapLeftX = 0;
				this.mapTopY = 0;
				this.cursorPosX = 0;
				this.cursorPosY = 0;
				this.cursorSprite.setPixelPosition(this.cursorPosX * 24, this.cursorPosY * 24);
			} else {
				someReadScriptMethod(mapIndex);
				return;
			}
		} catch (Exception lex) {
			lex.printStackTrace();
		}
	}

	private void sub_b5bf(int[] paramArrayOfInt) {
		C_MainCanvas.sub_1abc(paramArrayOfInt, true);
		for (int i = 0; i < this.mapWidth; i++) {
			for (int j = 0; j < this.mapHeight; j++) {
				if (this.var_47da[i][j] > 0) {
					this.mapTilesIds[i][j] = ((byte) C_MainCanvas
							.getRandomArrayItemOrWhat(paramArrayOfInt));
				}
			}
		}
		C_MainCanvas.sub_1abc(paramArrayOfInt, false);
		sub_b87b();
	}

	private void sub_b66c(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4, int[] paramArrayOfInt) {
		paramInt2 = this.mapWidth + paramInt1 + paramInt2;
		paramInt4 = this.mapHeight + paramInt3 + paramInt4;
		byte[][] arrayOfByte = new byte[paramInt2][paramInt4];
		C_MainCanvas.sub_1abc(paramArrayOfInt, true);
		for (int k = 0; k < paramInt2; k++) {
			for (int m = 0; m < paramInt4; m++) {
				int i = k - paramInt1;
				int j = m - paramInt3;
				if ((i >= 0) && (j >= 0) && (i < this.mapWidth)
						&& (j < this.mapHeight)) {
					arrayOfByte[k][m] = this.mapTilesIds[i][j];
				} else {
					arrayOfByte[k][m] = ((byte) C_MainCanvas
							.getRandomArrayItemOrWhat(paramArrayOfInt));
				}
			}
		}
		C_MainCanvas.sub_1abc(paramArrayOfInt, false);
		for (int itt = 0; itt < this.mapUnitsMaybe.size(); itt++) {
			A_Unit localClass_a_0260;
			(localClass_a_0260 = (A_Unit) this.mapUnitsMaybe.elementAt(itt))
					.setOnMapPosition(localClass_a_0260.posX + paramInt1,
							localClass_a_0260.posY + paramInt3);
		}
		this.mapTilesIds = arrayOfByte;
		this.mapWidth = paramInt2;
		this.mapHeight = paramInt4;
		this.var_47da = new byte[this.mapWidth][this.mapHeight];
		this.var_4d92 = new byte[this.mapWidth][this.mapHeight];
		sub_b87b();
		this.var_46d2 = (this.mapWidth * 24);
		this.var_46da = (this.mapHeight * 24);
		this.mapLeftX = 0;
		this.mapTopY = 0;
		this.cursorPosX = 0;
		this.cursorPosY = 0;
		this.cursorSprite.setPixelPosition(this.cursorPosX * 24, this.cursorPosY * 24);
	}

	private void sub_b87b() {
		try {
			this.teamsCountMaybe = 0;
			for (int i = 0; i < 5; i++) {
				this.var_482a[i] = -1;
			}
			this.var_4d9a = 0;
			int i = 0;
			Vector localVector1 = new Vector();
			Vector localVector2 = new Vector();
			for (int k = 0; k < this.mapWidth; k = (short) (k + 1)) {
				for (int m = 0; m < this.mapHeight; m = (short) (m + 1)) {
					if (isVillageOrTownEvenDestroyed(this.mapTilesIds[k][m])) {
						int j = sub_11bae(k, m);
						byte[] arrayOfByte2;
						(arrayOfByte2 = new byte[3])[0] = ((byte) k);
						arrayOfByte2[1] = ((byte) m);
						arrayOfByte2[2] = ((byte) j);
						localVector1.addElement(arrayOfByte2);
						i++;
						if (getMapTileType(k, m) == 9) {
							if ((this.scenarioModeIf0 == 1) && (j != 0)
									&& (this.var_482a[j] == -1)) {
								this.var_4832[this.teamsCountMaybe] = ((byte) j);
								this.var_482a[j] = (this.teamsCountMaybe++);
							}
							byte[] arrayOfByte1;
							(arrayOfByte1 = new byte[2])[0] = ((byte) k);
							arrayOfByte1[1] = ((byte) m);
							localVector2.addElement(arrayOfByte1);
							this.var_4d9a += 1;
						}
					}
				}
			}
			this.var_4d82 = new int[i];
			this.somePositionsOrTilesData = new byte[i][];
			localVector1.copyInto(this.somePositionsOrTilesData);
			this.var_4a02 = new byte[this.var_4d9a][];
			localVector2.copyInto(this.var_4a02);
			this.aSomeUnitsArr = new A_Unit[this.somePositionsOrTilesData.length];
			this.var_4d72 = new byte[this.somePositionsOrTilesData.length];
			this.aSomeSpritesArr = new G_Sprite[this.somePositionsOrTilesData.length];
			for (int k = 0; k < this.somePositionsOrTilesData.length; k = (short) (k + 1)) {
				if (getMapTileType(this.somePositionsOrTilesData[k][0], this.somePositionsOrTilesData[k][1]) == 8) {
					this.aSomeSpritesArr[k] = G_Sprite.getSpriteWithParams(this.bSmokeSprite, 0,
							-1, 0, 1, 250, (byte) 0);
					this.aSomeSpritesArr[k].isVisibleMb = false;
				}
			}
			return;
		} catch (Exception localException2) {
			Exception localException1;
			(localException1 = localException2).printStackTrace();
		}
	}

	private byte[] sub_bb13() {
		try {
			ByteArrayOutputStream localObject = new ByteArrayOutputStream();
			DataOutputStream localDataOutputStream;
			(localDataOutputStream = new DataOutputStream(
					(OutputStream) localObject)).writeInt(this.mapWidth);
			localDataOutputStream.writeInt(this.mapHeight);
			for (int i = 0; i < this.mapWidth; i++) {
				for (int j = 0; j < this.mapHeight; j++) {
					localDataOutputStream.writeByte(this.mapTilesIds[i][j]);
				}
			}
			localDataOutputStream.writeInt(0);
			localDataOutputStream.writeInt(this.mapUnitsMaybe.size());
			for (int i = 0; i < this.mapUnitsMaybe.size(); i++) {
				A_Unit localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
						.elementAt(i);
				localDataOutputStream
						.writeByte((this.var_4832[localClass_a_0260.teamId] - 1)
								* 12 + localClass_a_0260.unitType);
				localDataOutputStream
						.writeShort(localClass_a_0260.posX * 24);
				localDataOutputStream
						.writeShort(localClass_a_0260.posY * 24);
			}
			localDataOutputStream.flush();
			byte[] arrayOfByte = ((ByteArrayOutputStream) localObject)
					.toByteArray();
			localDataOutputStream.close();
			return arrayOfByte;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	private void sub_bc72() {
		this.var_47b2 = 0;
		this.someActiveUnit = null;
		this.var_47ba = new A_Unit[0];
		sub_bcb2(this.var_47da, 0);
		this.var_47e2 = false;
		this.var_47ea = false;
	}

	private void sub_bcb2(byte[][] paramArrayOfByte, int paramInt) {
		for (int i = 0; i < this.mapWidth; i++) {
			for (int j = 0; j < this.mapHeight; j++) {
				paramArrayOfByte[i][j] = ((byte) paramInt);
			}
		}
	}

	private void sub_bd39(A_Unit paramClass_a_0260) {
		C_MainCanvas.sub_2d32(10);
		this.var_4c6a = null;
		sub_bcb2(this.var_47da, 0);
		this.var_47e2 = false;
		if (this.someTeamValuesArr[this.currentPlayerId] == 1) {
			this.var_4c7a = 1;
			this.isCursorVisible = true;
			this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
			this.gameState = 3;
			sub_6e49(sub_bddb(paramClass_a_0260, (byte) 0));
			C_MainCanvas.playMusicLooped(11, 1);
			return;
		}
		if (this.someTeamValuesArr[this.currentPlayerId] == 0) {
			this.var_4d22 = 4;
			this.gameState = 0;
		}
	}

	private byte[] sub_bddb(A_Unit paramClass_a_0260, byte paramByte) {
		int i = 0;
		byte[] arrayOfByte = new byte[this.var_461a.length];
		if ((paramByte == 1)
				&& (getMapTileType(this.someActiveUnit.posX, this.someActiveUnit.posY) == 9)
				&& (sub_11cae(this.someActiveUnit.posX, this.someActiveUnit.posY,
						paramClass_a_0260.teamId))) {
			i++;
			arrayOfByte[0] = 0;
		}
		if (canOccupyVillageMaybe(paramClass_a_0260)) {
			arrayOfByte[(i++)] = 2;
		} else if (canOccupyVillageOrTownMaybe(paramClass_a_0260)) {
			arrayOfByte[(i++)] = 1;
		}
		if (((paramByte == 1) || (paramClass_a_0260.unitType != 7))
				&& (paramClass_a_0260.chars.length > 0)
				&& (paramClass_a_0260.getUnitsInAttackRange1(paramClass_a_0260.posX,
						paramClass_a_0260.posY, (byte) 0).length > 0)) {
			arrayOfByte[(i++)] = 3;
		}
		if ((paramClass_a_0260.hasProperty((short) 32))
				&& (paramClass_a_0260.getUnitsInAttackRange1(paramClass_a_0260.posX,
						paramClass_a_0260.posY, (byte) 1).length > 0)) {
			arrayOfByte[(i++)] = 4;
		}
		if (paramByte == 1) {
			arrayOfByte[(i++)] = 5;
		} else {
			arrayOfByte[(i++)] = 6;
		}
		byte[] bytes = new byte[i];
		System.arraycopy(arrayOfByte, 0, bytes, 0, i);
		return bytes;
	}

	private void showStartupBackgrounds() {
		if ((C_MainCanvas.propDisableIntroOn) && (this.startupBgState < 4)) {
			this.aeLogoImage = new D_ImageWrap("logo", this.canvasWidth, -1); // @todo j?
			this.startupBgState = 3;
			this.var_491a = 40;
		}
		switch (this.startupBgState) {
		case 0:
			if (this.someGameTime >= 1200L) {
				this.startupBgState = 1;
			}
			this.var_491a = 40;
			return;
		case 1: // intro 0
			if (this.var_491a <= 0) {
				this.msLogoImage = null;
				this.var_491a = 0;
				this.startupBgState += 1;
				initIntro(0, 0, 3);
				return;
			}
			this.var_491a -= 1;
			return;
		case 2: // intro 1
			initIntro(1, 2, 3);
			this.aeLogoImage = new D_ImageWrap("logo", this.canvasWidth, -1); // j
			this.startupBgState += 1;
			return;
		case 3: //logo
			if (++this.var_491a > 40) {
				try {
					this.splashImage = new D_ImageWrap("splash", this.someCanWidth,
							-1);
					this.glowLightOnLogoImage = new D_ImageWrap("glow"); // glow light on logo
				} catch (Exception ex) {
					//
				}
				if (this.splashImage != null) {
					this.var_491a = 0;
				} else {
					this.var_491a = 11;
				}
				this.startupBgState += 1;
				F_StringManager.mainCanvas.clearActionCodesMb();
				return;
			}
			break;
		case 4: // start menu
			if (this.var_491a < 16) {
				this.var_491a += 1;
				this.var_4922 += 1;
				if (this.glowLightOnLogoImage != null) {
					this.glowLightXmb = (-this.glowLightOnLogoImage.imageWidth);
				}
			} else {
				if (this.glowLightXmb >= this.canvasWidth << 2) {
					if (this.glowLightOnLogoImage != null) {
						this.glowLightXmb = (-this.glowLightOnLogoImage.imageWidth);
					}
				} else {
					this.glowLightXmb += this.aeLogoImage.imageWidth / 6;
				}
				if (this.someGameTime % 100L == 0L) {
					this.var_498a = (!this.var_498a);//Press any key image vis?
				}
				if (((this.splashImage == null) || (F_StringManager.mainCanvas
						.sub_2677())) && (sub_5d81())) {
					if (this.glowLightOnLogoImage != null) {
						this.glowLightXmb = (-this.glowLightOnLogoImage.imageWidth);
					}
					this.var_498a = false;
					int i = this.aeLogoImage.imageHeight + 1;
					sub_6d11(this.var_464a, (this.canvasHeight + i) / 2,
							this.canvasHeight - i, this.splashImage == null ? null
									: this);
					F_StringManager.mainCanvas.clearActionCodesMb();
				}
			}
			break;
		}
	}

	//@Override
	public final void paintScene() {
		this.someGameTime += 50L;
		G_Game rGame;
		int m;
		if (this.gameStateMb == 2) { // GAME STATE Fight animation 
			rGame = this;
			if ((this.isShakingMB)
					&& (rGame.someGameTime
							- rGame.shakingTimeMb >= rGame.shakingTimeMaxMb)) {
				rGame.isShakingMB = false;
			}
			for (int m1 = 0; m1 < rGame.spritesList.size(); m1++) {
				((G_Sprite) rGame.spritesList
						.elementAt(m1)).sub_21f3();
			}
			for (int m1 = 0; m1 <  rGame.spritesList.size(); m1++) {
				G_Sprite sprite1 = (G_Sprite) rGame.spritesList.elementAt(m1);
				if (!sprite1.isVisibleMb) {
					rGame.removeSomeSprite(sprite1);
				}
			}
			rGame.fAnim1.runUnitFightAnimation();
			rGame.fAnim2.runUnitFightAnimation();
			if (rGame.var_4ea2) {
				rGame.var_491a += 1;
				if (rGame.var_491a >= 16) {
					rGame.var_4ea2 = false;
					rGame.fAnim1.sub_1688();
				}
				rGame.var_4eaa = true;
				rGame.var_4eb2 = true;
			} else if (rGame.var_4e72) {
				if (rGame.someGameTime
						- rGame.someGameTime2 >= 300L) {
					rGame.spritesList.removeAllElements();
					rGame.fAnim2 = null;
					rGame.fAnim1 = null;
					rGame.spritesOtherVector = new Vector();
					rGame.sub_6a9a();
					rGame.gameStateMb = 1;
					C_MainCanvas.stopCurrentMusicPlayer();
					C_MainCanvas
							.playMusicLooped(
									var_4692[rGame.var_4832[rGame.currentPlayerId]],
									0);
					F_StringManager.mainCanvas.clearActionCodesMb();
					rGame.var_4c42 = true;
					rGame.var_4c4a = true;
					return;
				}
			} else if (rGame.fAnim1.var_b5f) {
				if ((rGame.var_4e9a)
						&& (rGame.fAnim2.unitHealthAfterAttack > 0)) {
					if (!rGame.fAnim2.var_b57) {
						rGame.fAnim2.sub_1688();
					}
					if (!rGame.fAnim2.var_b5f) {
					}
				} else {
					rGame.var_4e72 = true;
					rGame.someGameTime2 = rGame.someGameTime;
				}
			}
		} else if (this.gameStateMb == 3) { // GAME STATE ?
			rGame = this;
			if (this.var_4cc2) {
				rGame.var_491a -= 1;
				if (rGame.var_491a < 0) {
					rGame.var_491a = 0;
					rGame.gameStateMb = rGame.var_4cca;
					rGame.introImage = null;
					rGame.introTextWrapped = null;
					return;
				}
			} else {
				if (((rGame.var_4cd2 != 2) || (rGame.var_491a >= 40))
						&& ((rGame.var_4cd2 == 2) || (rGame.var_491a >= 16))) {
					rGame.var_4c9a -= 1;
					if (rGame.var_4c9a < rGame.introImageHeight) {
						rGame.var_4c9a = (rGame.introImageHeight
								+ rGame.var_4c92 - (rGame.introImageHeight - rGame.var_4c9a));
						rGame.var_4caa += 1;
					}
				} else {
					rGame.var_491a += 1;
				}
				if ((rGame.var_4caa >= rGame.introTextWrapped.length)
						|| (F_StringManager.mainCanvas.sub_272b(var_4602))) {
					rGame.var_4cc2 = true;
					if ((rGame.introImage != null)
							|| (rGame.var_4caa < rGame.introTextWrapped.length)) {
						if (rGame.var_4cda == 2) {
							rGame.var_491a = 40;
							return;
						}
						rGame.var_491a = 16;
						return;
					}
					rGame.var_491a = 0;
				}
			}
		} else {
			if (this.gameStateMb == 0) { // showStartupBackgrounds
				showStartupBackgrounds();
				return;
			}
			sub_155a2();
			if (this.showHelp != -1) {
				if (C_MainCanvas.settings[2] != false) {
					E_Menu lo1;
					(lo1 = showUnitDialog(
							F_StringManager.getLangString(196 + this.showHelp, true),
							(byte) -1, (byte) 2)).var_11aa = 7831691;
					((E_Menu) lo1).var_11a2 = 7831691;
					((E_Menu) lo1).someGrayColor = 16250855;
				}
				this.showHelp = -1;
			}
			if (F_StringManager.mainCanvas.var_17b7 == this) {
				int i;
				if (this.gameState == 0) {
					for (i = 0; i < this.aSomeSpritesArr.length; i++) {
						m = sub_11bae(this.somePositionsOrTilesData[i][0], this.somePositionsOrTilesData[i][1]);
						if ((this.aSomeSpritesArr[i] != null) && (m != -1) && (m != 0)
								&& (!this.aSomeSpritesArr[i].isVisibleMb)
								&& (C_MainCanvas.random.nextInt() % 8 == 0)) {
							this.aSomeSpritesArr[i].isVisibleMb = true;
							this.aSomeSpritesArr[i].setCurrentFrameIndex(0);
							this.aSomeSpritesArr[i].var_c48 = 1;
							this.aSomeSpritesArr[i].setPixelPosition((this.somePositionsOrTilesData[i][0] + 1)
									* 24 - this.bSmokeSprite.spriteFrameWidth,
									this.somePositionsOrTilesData[i][1] * 24 - 2);
							this.spritesVector.addElement(this.aSomeSpritesArr[i]);
						}
					}
				}
				if (this.someGameTime - this.var_4952 >= 300L) {
					this.var_494a = (!this.var_494a);
					this.var_4952 = this.someGameTime;
				}
				if ((this.isShakingMB)
						&& (this.someGameTime - this.shakingTimeMb >= this.shakingTimeMaxMb)) {
					this.isShakingMB = false;
				}
				if (this.var_4912) {
					this.var_491a += 1;
					if (this.var_491a > 16) {
						if (this.gameState == 10) {
							this.var_4e52 = 1;
						} else if (this.gameState == 11) {
							if (this.scenarioModeIf0 == 0) {
								this.fadeEnabled = true;
								this.var_4ad2 = true;
								this.fadeValue = 0;
							}
							this.var_49f2 = 0;
							this.var_481a = this.someGameTime;
						} else {
							sub_18762(this.attackingUnit, this.attackedUnit);
							this.var_4d3a = null;
							sub_bc72();
						}
						this.var_4912 = false;
					}
				} else {
					if (this.fadeEnabled) {
						if (this.var_4aca) {
							if (this.fadeValue < 16) {
								this.fadeValue += 1;
							}
						} else if (this.var_4ad2) {
							this.fadeValue += 1;
							if (this.fadeValue > 16) {
								this.var_4ad2 = false;
							}
						}
					}
					if (this.somePositions != null) {
						this.var_480a = ((this.var_480a + 1) % 12);
					}
					if (this.var_47e2) {
						if (this.var_4cf2 == 0) {
							this.var_4cea += 1;
							if (this.var_4cea >= 15) {
								this.var_4cf2 = 1;
							}
						} else {
							this.var_4cea -= 1;
							if (this.var_4cea <= 0) {
								this.var_4cf2 = 0;
							}
						}
						if (this.alphaWindow > 0) {
							this.alphaWindow -= 4;
							if (this.alphaWindow < 0) {
								this.alphaWindow = 0;
							}
						}
					}
					if ((this.isCursorVisible)
							&& (this.someGameTime - this.var_4672 >= 200L)) {
						this.cursorSprite.nextFrame();
						this.var_4672 = this.someGameTime;
					}
					m = this.cursorPosX * 24;
					i = this.cursorPosY * 24;
					int i7 = this.cursorSprite.pixelX;
					int i9 = this.cursorSprite.pixelY;
					if (m > i7) {
						i7 += 8;
					} else if (m < i7) {
						i7 -= 8;
					}
					if (i > i9) {
						i9 += 8;
					} else if (i < i9) {
						i9 -= 8;
					}
					this.cursorSprite.setPixelPosition(i7, i9);
					if ((!this.var_4a5a) && (this.statusBarOffset > 0)) {
						if (this.statusBarOffset < 2) {
							this.statusBarOffset = 0;
						} else {
							this.statusBarOffset /= 2;
						}
						this.var_4c42 = true;
						this.var_4c4a = true;
					} else {
						A_Unit someUnit;
						if (this.gameState == 8) {
							if (this.var_4812 == 0) {
								if (this.statusBarOffset >= var_4592) {
									this.var_4812 = 1;
									sub_116cf();
									Object localObject2;
									if (this.someTeamValuesArr[this.currentPlayerId] == 1) {
										localObject2 = "" + this.var_4d12;
									} else {
										localObject2 = "?";
									}
									localObject2 = newMessageBox(
											F_StringManager.getLangString(75),
											F_StringManager.getStrByIdAndReplaceUWith(76,
													(String) localObject2),
											this.someCanHeight, 1500);
									F_StringManager.mainCanvas
											.showMessageBox((F_StringManager) localObject2);
									((E_Menu) localObject2).var_11a2 = var_468a[this.var_4832[this.currentPlayerId]];
									C_MainCanvas
											.playMusic2(
													var_4692[this.var_4832[this.currentPlayerId]],
													0);
									return;
								}
								if (this.statusBarOffset == 0) {
									this.var_4a5a = true;
									this.statusBarOffset = 1;
								} else {
									this.statusBarOffset <<= 1;
								}
								this.var_4c42 = true;
								this.var_4c4a = true;
							} else {
								for (i = this.mapUnitsMaybe.size() - 1; i >= 0; i--) {
									if (((someUnit = (A_Unit) this.mapUnitsMaybe
											.elementAt(i)).var_e83 != 3)
											&& (this.currentPlayerId == someUnit.teamId)
											&& ((getMapTileType(
													someUnit.posX,
													someUnit.posY) == 7) || (sub_11c55(
													someUnit.posX,
													someUnit.posY,
													this.var_483a[someUnit.teamId])))
											&& (someUnit.health < 100)) {
										int n;
										if ((n = 100 - someUnit.health) > 20) {
											n = 20;
										}
										someUnit.health += n;
										G_Sprite localClass_g_25171;
										(localClass_g_25171 = G_Sprite
												.createSomeSprite("+" + n, 0, -4,
														(byte) 1)).setPixelPosition(
												someUnit.pixelX
														+ someUnit.spriteFrameWidth
														/ 2,
												someUnit.pixelY
														+ someUnit.spriteFrameHeight); // m
																				// n
										this.spritesOtherVector
												.addElement(localClass_g_25171);
									}
								}
								this.var_4812 = 0;
								this.var_4a5a = false;
								this.gameState = 0;
							}
						} else if (this.gameState == 9) {
							this.gameState = 0;
						} else if (this.gameState == 11) {
							if ((!this.var_4912)
									&& (this.var_49f2 == 0)
									&& ((this.scenarioModeIf0 == 1)
											|| (this.someGameTime - this.var_481a >= 3000L) || (F_StringManager.mainCanvas
												.sub_2677()))) {
								this.someCanHeight = this.canvasHeight;
								this.someCanHeightDiv2 = this.canvasHeightShift;
								sub_6d11(this.var_464a, this.canvasHeightShift,
										this.canvasHeight, null);
								this.var_49f2 = 1;
								this.var_4ad2 = false;
							}
						} else if ((this.gameState != 10)
								&& (this.gameState != 14)) {
							if (this.gameState == 13) {
								if (this.var_492a == 0) {
									C_MainCanvas.vibrate(200);
									int i1 = this.attackingUnit
											.getDamageWhenAttack(this.attackedUnit);
									this.attackedUnit.scheduleAnimationStop(400);
									C_MainCanvas.playMusicLooped(14, 1);
									showSpriteOnMap(this.redsparkSprite, this.attackedUnit.pixelX,
											this.attackedUnit.pixelY, 0, 0, 2, 50);
									G_Sprite localClass_g_25172 = G_Sprite
											.createSomeSprite("-" + i1, 0, -4, (byte) 1);
									if ((i = this.attackedUnit.pixelX + this.attackedUnit.spriteFrameWidth
											/ 2)
											+ localClass_g_25172.spriteFrameWidth / 2 > this.var_46d2) {
										i = this.var_46d2
												- localClass_g_25172.spriteFrameWidth
												/ 2;
									} else if (i - localClass_g_25172.spriteFrameWidth
											/ 2 < 0) {
										i = localClass_g_25172.spriteFrameWidth / 2;
									}
									localClass_g_25172.setPixelPosition(i,
											this.attackedUnit.pixelY + this.attackedUnit.spriteFrameHeight);
									this.spritesOtherVector
											.addElement(localClass_g_25172);
									this.var_4932 = this.someGameTime;
									this.var_492a += 1;
								} else if (this.var_492a == 1) {
									if (this.someGameTime - this.var_4932 >= 800L) {
										moveCursorToPos(this.attackingUnit.posX,
												this.attackingUnit.posY);
										if (this.attackedUnit.canAttackPosition(
												this.attackingUnit.posX,
												this.attackingUnit.posY)) {
											C_MainCanvas.vibrate(200);
											int i2 = this.attackedUnit
													.getDamageWhenAttack(this.attackingUnit);
											this.attackingUnit.scheduleAnimationStop(400);
											C_MainCanvas.playMusicLooped(14, 1);
											showSpriteOnMap(this.redsparkSprite,
													this.attackingUnit.pixelX,
													this.attackingUnit.pixelY, 0, 0, 2,
													50);
											G_Sprite localClass_g_25173 = G_Sprite
													.createSomeSprite("-" + i2, 0, -4,
															(byte) 1);
											if ((i = this.attackingUnit.pixelX
													+ this.attackingUnit.spriteFrameWidth / 2)
													+ localClass_g_25173.spriteFrameWidth
													/ 2 > this.var_46d2) {
												i = this.var_46d2
														- localClass_g_25173.spriteFrameWidth
														/ 2;
											} else if (i
													- localClass_g_25173.spriteFrameWidth
													/ 2 < 0) {
												i = localClass_g_25173.spriteFrameWidth / 2;
											}
											localClass_g_25173.setPixelPosition(i,
													this.attackingUnit.pixelY
															+ this.attackingUnit.spriteFrameHeight);
											this.spritesOtherVector
													.addElement(localClass_g_25173);
											this.var_4932 = this.someGameTime;
											this.var_492a += 1;
										} else {
											sub_6a9a();
										}
									}
								} else if (this.someGameTime - this.var_4932 >= 800L) {
									sub_6a9a();
								}
							} else {
								Object localObject3;
								if (this.var_4b32 != null) {
									if (this.var_4b3a == 0) {
										if (this.var_4c82) {
											this.var_4b2a = showSpriteOnMap(
													this.sparkSprite,
													this.var_4b32.pixelX,
													-this.mapTopY, 0, 12, -1,
													0);
											E_Menu localClass_e_01342;
											(localClass_e_01342 = newMessageBox(
															null,
															F_StringManager
																	.getLangString(280),
															this.someCanHeight, 2000))
													.setLocation(this.someCanWidthDiv2, 2,
															17);
											F_StringManager.mainCanvas
													.showMessageBox(localClass_e_01342);
											this.var_4b3a = 1;
										}
									} else if (this.var_4b3a == 1) {
										for (i = 0; i < 3; i++) {
											showSpriteOnMap(
													this.bSmokeSprite,
													this.var_4b2a.pixelX
															+ C_MainCanvas
																	.getRandomMax(this.var_4b2a.spriteFrameWidth
																			- this.bSmokeSprite.spriteFrameWidth),
													this.var_4b2a.pixelY, 0,
													C_MainCanvas
															.getRandomWithin(-3, 0),
													1, 50 * C_MainCanvas
															.getRandomMax(4));
										}
										if (this.var_4b2a.pixelY >= this.var_4b32.pixelY) {
											this.var_4b2a.isVisibleMb = false;
											C_MainCanvas.vibrate(200);
											sub_188ce(500);
											if (this.var_4b42) {
												int i3;
												if ((i3 = 25 + C_MainCanvas
														.getRandomMax(25)) > this.var_4b32.health) {
													i3 = this.var_4b32.health;
												}
												this.var_4b32.health -= i3;
												G_Sprite localObject31 = G_Sprite
														.createSomeSprite("-" + i3, 0,
																-4, (byte) 1);
												localObject31 
														.setPixelPosition(
																this.var_4b32.pixelX
																		+ this.var_4b32.spriteFrameWidth
																		/ 2,
																this.var_4b32.pixelY
																		+ this.var_4b32.spriteFrameHeight);
												this.spritesOtherVector
														.addElement(localObject31 );
											}
											sub_ecee(this.var_4b32);
											this.var_4b3a = 2;
										}
									} else if (++this.var_4b3a >= 20) {
										if (this.var_4b32.health <= 0) {
											this.dyingUnit = this.var_4b32;
											showSpriteOnMap(this.sparkSprite,
													this.dyingUnit.pixelX,
													this.dyingUnit.pixelY, 0, 0, 1,
													50);
											C_MainCanvas.playMusicLooped(12, 1);
											this.var_48aa = this.someGameTime;
										}
										this.var_4b32 = null;
									}
								} else if (this.var_48a2 != null) {
									if (--this.var_48ca <= 0) {
										C_MainCanvas.vibrate(100);
										sub_ecee(this.var_48a2);
										setMapTileId((byte) 27,
												this.var_48a2.posX,
												this.var_48a2.posY);
										this.var_48a2 = null;
									}
								} else if (this.dyingUnit != null) {
									if ((this.someGameTime - this.var_48aa >= 300L)
											&& (sub_ee85(this.dyingUnit.posX,
													this.dyingUnit.posY))) {
										if ((this.scenarioModeIf0 == 0)
												&& (this.scenarioMapIndex == 7)
												&& (this.dyingUnit == this.maybeTeamKings[1])) {
											this.var_4b4a = true;
										} else {
											showSpriteOnMap(this.smokeSprite,
													this.dyingUnit.pixelX,
													this.dyingUnit.pixelY, 0, -3, 1,
													100);
											this.dyingUnit.var_e83 = 3;
											this.dyingUnit.var_ecb = 3;
											if ((this.dyingUnit.unitType != 10)
													&& (this.dyingUnit.unitType != 11)) {
												if (this.dyingUnit.unitType == 9) {
													this.dyingUnit.setOnMapPosition(-10,
															-10);
													this.dyingUnit.status = 0;
													this.dyingUnit.calcStatusEffect();
												}
											} else {
												this.dyingUnit.removeUnit();
											}
											if ((this.dyingUnit.unitType == 9)
													&& (this.dyingUnit.cost < 1000)) {
												this.dyingUnit.cost += 200;
											}
										}
										this.dyingUnit = null;
									}
								} else {
									int i10;
									if (this.vectorOfSomeUnits.size() > 0) {
										someUnit = (A_Unit) this.vectorOfSomeUnits
												.elementAt(0);
										if (this.someUnknownVal == 0) {
											moveCursorToPos(someUnit.posX,
													someUnit.posY);
											this.someUnknownVal = 1;
										} else if (sub_ee85(
												someUnit.posX,
												someUnit.posY)) {
											showSpriteOnMap(
													this.smallSparkSprite,
													someUnit.pixelX
															+ C_MainCanvas
																	.getRandomMax(someUnit.spriteFrameWidth),
													someUnit.pixelY
															+ C_MainCanvas
																	.getRandomMax(someUnit.spriteFrameHeight),
													0, 0, 1, 50);
											if (this.someUnknownVal == 1) {
												C_MainCanvas.playMusicLooped(13, 1);
											}
											if (this.someUnknownVal <= 5) {
												i10 = 200;
												if (this.someUnknownVal == 5) {
													i10 = 1000;
												}
												i = someUnit.pixelX
														+ (someUnit.spriteFrameWidth - this.levelUpSprite.spriteFrameWidth)
														/ 2;
												int i11 = someUnit.pixelY
														- (this.someUnknownVal << 2);
												if (i < 0) {
													i = 0;
												} else if (i
														+ this.levelUpSprite.spriteFrameWidth > this.var_46d2) {
													i = this.var_46d2
															- this.levelUpSprite.spriteFrameWidth;
												}
												if (i11 < 0) {
													i11 = 0;
												}
												showSpriteOnMap(this.levelUpSprite, i, i11,
														0, 0, 1, i10);
											}
											this.someUnknownVal += 1;
											if (this.someUnknownVal >= 20) {
												this.vectorOfSomeUnits
														.removeElement(someUnit);
												this.someUnknownVal = 0;
												if ((someUnit.unitType != 9)
														&& (someUnit.level <= 6)
														&& (someUnit.level % 2 == 0)) {
													//show level up message
													F_StringManager.mainCanvas
															.showMessageBox(newMessageBox(
																			null,
																			F_StringManager
																					.getLangString(80)
																					+ "\n"
																					+ someUnit.unitName,
																			this.someCanWidth,
																			2000));
												}
											}
										}
									} else if (this.selectedTombUnit != null) {
										if (this.someGameTime - this.var_48c2 >= 400L) {
											this.selectedTombUnit.removeUnit();//remove tomb
											A_Unit skeleton = A_Unit.createUnit((byte) 10,
													this.activeTeamId,
													this.selectedTombUnit.posX,
													this.selectedTombUnit.posY);
											skeleton.sub_26fe();
											this.selectedTombUnit = null;
										}
									} else if (!this.var_4e3a) {
										if (this.gameState == 2) {
											if ((this.someActiveUnit.var_e83 != 1)
													&& (this.var_4c82)) {
												sub_bd39(this.someActiveUnit);
											}
										} else if ((this.var_4f92 == 0)
												&& (this.someTeamValuesArr[this.currentPlayerId] == 0)) {
											sub_1240c();
										} else if (sub_5d81()) {
											if ((this.canApplyMb)
													&& (F_StringManager.mainCanvas
															.sub_272b(var_4602))) {
												F_StringManager.mainCanvas
														.runGameAction(16);
												F_StringManager.mainCanvas
														.releaseGameAction(var_4602);
											}
											if ((this.gameState != 6)
													&& (this.gameState != 7)) {
												if ((this.someGameTime
														- this.var_467a >= 150L)
														&& (this.cursorSprite.pixelX % 24 == 0)
														&& (this.cursorSprite.pixelY % 24 == 0)) {
													if ((!F_StringManager.mainCanvas
															.sub_26d7(4))
															&& (!F_StringManager.mainCanvas
																	.isGameActionRunning(4))) {
														if ((F_StringManager.mainCanvas
																.sub_26d7(8))
																|| (F_StringManager.mainCanvas
																		.isGameActionRunning(8))) {
															if (this.cursorPosX < this.mapWidth - 1) {
																this.cursorPosX += 1;
															}
															this.var_495a = true;
															this.var_467a = this.someGameTime;
														}
													} else {
														if (this.cursorPosX > 0) {
															this.cursorPosX -= 1;
														}
														this.var_495a = true;
														this.var_467a = this.someGameTime;
													}
													if ((!F_StringManager.mainCanvas
															.sub_26d7(1))
															&& (!F_StringManager.mainCanvas
																	.isGameActionRunning(1))) {
														if ((F_StringManager.mainCanvas
																.sub_26d7(2))
																|| (F_StringManager.mainCanvas
																		.isGameActionRunning(2))) {
															if (this.cursorPosY < this.mapHeight - 1) {
																this.cursorPosY += 1;
															}
															this.var_495a = true;
															this.var_467a = this.someGameTime;
														}
													} else {
														if (this.cursorPosY > 0) {
															this.cursorPosY -= 1;
														}
														this.var_495a = true;
														this.var_467a = this.someGameTime;
													}
													if (this.var_495a) {
														if (this.gameState == 1) {
															if (this.var_47da[this.cursorPosX][this.cursorPosY] > 0) {
																this.somePositions = this.someActiveUnit
																		.sub_1ef5(
																				this.someActiveUnit.posX,
																				this.someActiveUnit.posY,
																				this.cursorPosX,
																				this.cursorPosY);
															}
														} else {
															this.unitAtCursorPos = getUnitAtPos(
																	this.cursorPosX,
																	this.cursorPosY,
																	(byte) 0);
														}
														this.var_4c4a = true;
													}
													this.var_495a = false;
												}
												if (((this.gameState == 1) || (this.gameState == 0))
														&& (this.var_4f92 == 0)
														&& (F_StringManager.mainCanvas
																.sub_26d7(256))) {
													if ((someUnit = getUnitAtPos(
															this.cursorPosX,
															this.cursorPosY,
															(byte) 0)) != null) {
														E_Menu localObject31  = new E_Menu(
																(byte) 15, 15);
														localObject31.var_11e2 = this.someCanHeight;
														E_Menu localClass_e_01343 = new E_Menu(
																(byte) 5, 2);
														E_Menu localClass_e_01341;
														(localClass_e_01341 = new E_Menu(
																(byte) 10, 1)).var_1152 = true;
														String str = F_StringManager
																.getLangString(184 + someUnit.unitType);
														if (someUnit.status != 0) {
															StringBuffer localStringBuffer = new StringBuffer(
																	F_StringManager
																			.getLangString(98));
															if ((someUnit.status & 0x2) != 0) {
																localStringBuffer
																		.append('\n');
																localStringBuffer
																		.append(F_StringManager
																				.getLangString(100));
															}
															if ((someUnit.status & 0x1) != 0) {
																localStringBuffer
																		.append('\n');
																localStringBuffer
																		.append(F_StringManager
																				.getLangString(99));
															}
															localStringBuffer
																	.append("\n-----------\n");
															str = localStringBuffer
																	.toString()
																	+ str;
														}
														localClass_e_01341
																.initMessageBox(
																		null,
																		str,
																		this.someCanWidth,
																		this.someCanHeight
																				- localClass_e_01343.mapPrevPixelHeight);
														((E_Menu) localObject31)
																.addChildMenu(
																		localClass_e_01343,
																		0, 0, 0);
														((E_Menu) localObject31)
																.addChildMenu(
																		localClass_e_01341,
																		0,
																		localClass_e_01343.mapPrevPixelHeight,
																		0);
														((E_Menu) localObject31).var_115a = true;
														((E_Menu) localObject31)
																.sub_1350(this);
														F_StringManager.mainCanvas
																.showMessageBox((F_StringManager) localObject31);
													}
													F_StringManager.mainCanvas
															.releaseGameAction(256);
												}
												if (this.gameState == 1) {
													if ((F_StringManager.mainCanvas
															.sub_26d7(16))
															&& (this.someActiveUnit != null)) {
														someUnit = getUnitAtPos(
																this.cursorPosX,
																this.cursorPosY,
																(byte) 0);
														if ((this.var_47da[this.cursorPosX][this.cursorPosY] > 0)
																&& ((someUnit == null) || (someUnit == this.someActiveUnit))) {
															this.var_47ca = this.someActiveUnit.posX;
															this.var_47d2 = this.someActiveUnit.posY;
															this.someActiveUnit
																	.setHiddenPositions(
																			this.cursorPosX,
																			this.cursorPosY,
																			true);
															this.var_4c6a = this.someActiveUnit;
															this.isCursorVisible = false;
															this.var_47e2 = false;
															this.somePositions = null;
															this.var_4882 = null;
															this.canCancelMb = false;
															this.canApplyMb = false;
															this.gameState = 2;
															C_MainCanvas
																	.playMusicLooped(
																			10,
																			1);
														}
														F_StringManager.mainCanvas
																.releaseGameAction(16);
													}
												} else if (this.gameState == 0) {
													int i4;
													if (this.var_4f92 == 1) {
														if (F_StringManager.mainCanvas
																.sub_26d7(128)) {
															if ((this.cursorTileId = (byte) (this.cursorTileId + 1)) >= this.tiles0Frames.length) {
																this.cursorTileId = 0;
															}
															this.var_4c42 = true;
															this.var_4c4a = true;
														} else if (F_StringManager.mainCanvas
																.sub_26d7(64)) {
															if ((this.cursorTileId = (byte) (this.cursorTileId - 1)) < 0) {
																this.cursorTileId = ((byte) (this.tiles0Frames.length - 1));
															}
															this.var_4c42 = true;
															this.var_4c4a = true;
														} else {
															int i12;
															if (F_StringManager.mainCanvas
																	.sub_26d7(16)) {
																if (this.var_47e2) {
																	if (this.var_47da[this.cursorPosX][this.cursorPosY] == 0) {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 1;
																	} else {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 0;
																	}
																	this.var_47e2 = false;
																	for (i10 = 0; i10 < this.mapWidth; i10++) {
																		for (i12 = 0; i12 < this.mapHeight; i12++) {
																			if (this.var_47da[i10][i12] > 0) {
																				this.var_47e2 = true;
																				break;
																			}
																		}
																		if (this.var_47e2) {
																			break;
																		}
																	}
																} else {
																	this.mapTilesIds[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																}
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(512)) {
																if (this.cursorTileId == this.mapTilesIds[this.cursorPosX][this.cursorPosY]) {
																	if ((this.cursorTileId = (byte) (this.cursorTileId + 1)) >= this.tiles0Frames.length) {
																		this.cursorTileId = 0;
																	}
																	this.mapTilesIds[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																} else {
																	this.cursorTileId = this.mapTilesIds[this.cursorPosX][this.cursorPosY];
																}
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(256)) {
																if (this.cursorTileId == this.mapTilesIds[this.cursorPosX][this.cursorPosY]) {
																	if ((this.cursorTileId = (byte) (this.cursorTileId - 1)) < 0) {
																		this.cursorTileId = ((byte) (this.tiles0Frames.length - 1));
																	}
																	this.mapTilesIds[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																} else {
																	this.cursorTileId = this.mapTilesIds[this.cursorPosX][this.cursorPosY];
																}
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(32)) {
																if (this.var_47e2) {
																	sub_b5bf(this.var_4fba);
																} else {
																	this.cursorTileId = this.mapTilesIds[this.cursorPosX][this.cursorPosY];
																	sub_1aaa3();
																	for (i10 = 0; i10 < this.var_4fba.length; i10++) {
																		this.var_4fba[i10] = 0;
																		this.var_4fca[i10] = false;
																	}
																	this.var_4fba[this.cursorTileId] = 100;
																	this.var_4fca[this.cursorTileId] = true;
																	this.var_501a
																			.setSelectedFlags(this.var_4fca);
																	this.var_4c42 = true;
																	this.var_4c4a = true;
																}
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(16384)) {
																if (this.var_47e2) {
																	if (this.var_47da[this.cursorPosX][this.cursorPosY] == 0) {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 1;
																	} else {
																		i10 = this.mapWidth;
																		i12 = this.mapHeight;
																		int j = -1;
																		int i13 = -1;
																		for (int i14 = 0; i14 < this.mapWidth; i14++) {
																			for (i4 = 0; i4 < this.mapHeight; i4++) {
																				if (this.var_47da[i14][i4] > 0) {
																					if (i14 < i10) {
																						i10 = i14;
																					}
																					if (i14 > j) {
																						j = i14;
																					}
																					if (i4 < i12) {
																						i12 = i4;
																					}
																					if (i4 > i13) {
																						i13 = i4;
																					}
																				}
																			}
																		}
																		int i8 = 1;
																		for (int i14 = i10; i14 <= j; i14++) {
																			for (i4 = i12; i4 <= i13; i4++) {
																				if (this.var_47da[i14][i4] == 0) {
																					i8 = 0;
																				}
																				this.var_47da[i14][i4] = 1;
																			}
																		}
																		if (i8 != 0) {
																			if ((i10 == 0)
																					&& (i12 == 0)
																					&& (j == this.mapWidth - 1)
																					&& (i13 == this.mapHeight - 1)) {
																				sub_bcb2(
																						this.var_47da,
																						0);
																				this.var_47e2 = false;
																			} else {
																				sub_bcb2(
																						this.var_47da,
																						1);
																			}
																		}
																	}
																} else {
																	this.var_47da[this.cursorPosX][this.cursorPosY] = 1;
																	this.var_47e2 = true;
																}
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(8192)) {
																if (this.teamsCountMaybe > 0) {
																	sub_bcb2(
																			this.var_47da,
																			0);
																	this.var_47e2 = false;
																	this.var_4f92 = 2;
																	this.currentPlayerId = 0;
																	this.var_4f8a = null;
																	this.var_4c42 = true;
																	this.var_4c4a = true;
																}
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(var_4602)) {
																this.var_4882 = new E_Menu(
																		(byte) 11,
																		0);
																this.var_4882
																		.setMenuListStringActionsMb(
																				var_4582,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																F_StringManager.mainCanvas
																		.showMessageBox(this.var_4882);
															}
														}
													} else {
														Object localObject5;
														if (this.var_4f92 == 2) {
															if (F_StringManager.mainCanvas
																	.sub_26d7(128)) {
																if ((this.someUnitTypeId = (byte) (this.someUnitTypeId + 1)) >= 12) {
																	this.someUnitTypeId = 0;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(64)) {
																if ((this.someUnitTypeId = (byte) (this.someUnitTypeId - 1)) < 0) {
																	this.someUnitTypeId = 11;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(16)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) == null) {
																	A_Unit
																			.createNewUnit(
																					this.someUnitTypeId,
																					this.currentPlayerId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																} else {
																	((A_Unit) localObject5)
																			.removeUnit();
																}
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(512)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) != null) {
																	if (this.someUnitTypeId != ((A_Unit) localObject5).unitType) {
																		this.someUnitTypeId = ((A_Unit) localObject5).unitType;
																	} else {
																		if ((this.someUnitTypeId = (byte) (this.someUnitTypeId + 1)) >= 12) {
																			this.someUnitTypeId = 0;
																		}
																		((A_Unit) localObject5)
																				.removeUnit();
																		A_Unit
																				.createNewUnit(
																						this.someUnitTypeId,
																						this.currentPlayerId,
																						this.cursorPosX,
																						this.cursorPosY,
																						true);
																	}
																} else {
																	A_Unit
																			.createNewUnit(
																					this.someUnitTypeId,
																					this.currentPlayerId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(256)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) != null) {
																	if (this.someUnitTypeId != ((A_Unit) localObject5).unitType) {
																		this.someUnitTypeId = ((A_Unit) localObject5).unitType;
																	} else {
																		if ((this.someUnitTypeId = (byte) (this.someUnitTypeId - 1)) < 0) {
																			this.someUnitTypeId = 11;
																		}
																		((A_Unit) localObject5)
																				.removeUnit();
																		A_Unit
																				.createNewUnit(
																						this.someUnitTypeId,
																						this.currentPlayerId,
																						this.cursorPosX,
																						this.cursorPosY,
																						true);
																	}
																} else {
																	A_Unit
																			.createNewUnit(
																					this.someUnitTypeId,
																					this.currentPlayerId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(8192)) {
																if ((this.currentPlayerId = (byte) (this.currentPlayerId + 1)) >= this.teamsCountMaybe) {
																	this.currentPlayerId = 0;
																	this.var_4f92 = 1;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (F_StringManager.mainCanvas
																	.sub_26d7(var_4602)) {
																this.var_4882 = new E_Menu(
																		(byte) 11,
																		0);
																this.var_4882
																		.setMenuListStringActionsMb(
																				var_4582,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																F_StringManager.mainCanvas
																		.showMessageBox(this.var_4882);
															}
														} else if (F_StringManager.mainCanvas
																.sub_26d7(512)) {
															i4 = 0;
															localObject5 = this.maybeTeamKings[this.currentPlayerId];
															if ((this.unitAtCursorPos != null)
																	&& (this.unitAtCursorPos.unitType == 9)) {
															}
															A_Unit localObject51 = this.teamsUnits[this.currentPlayerId][((this.unitAtCursorPos.unitId + 1) % this.teamsUnitsCount[this.currentPlayerId])];
															for (;;) {
																i4++;
																if ((i4 >= this.teamsUnitsCount[this.currentPlayerId])
																		|| (((A_Unit) localObject51).var_e83 != 3)) {
																	if ((localObject51 == null)
																			|| (((A_Unit) localObject51).var_e83 == 3)) {
																		break;
																	}
																	moveCursorToPos(
																			((A_Unit) localObject51).posX,
																			((A_Unit) localObject51).posY);
																	sub_efb8(
																			((A_Unit) localObject51).pixelX + 12,
																			((A_Unit) localObject51).pixelY + 12);
																	break;
																}
																localObject51 = this.teamsUnits[this.currentPlayerId][((localObject51.unitId + 1) % this.teamsUnitsCount[this.currentPlayerId])];
															}
														} else if (F_StringManager.mainCanvas
																.sub_26d7(32)) {
															if (this.var_47ea) {
																sub_bcb2(
																		this.var_47da,
																		0);
																this.var_47e2 = false;
																this.var_47ea = false;
															} else {
																this.someActiveUnit = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0);
																if (this.someActiveUnit != null) {
																	sub_bcb2(
																			this.var_47da,
																			0);
																	this.someActiveUnit
																			.sub_18dd(this.var_47da);
																	this.var_47ea = true;
																	this.var_47e2 = true;
																	this.alphaWindow = 12;
																}
															}
															F_StringManager.mainCanvas
																	.releaseGameAction(32);
														} else if ((F_StringManager.mainCanvas
																.sub_26d7(16))
																|| (F_StringManager.mainCanvas
																		.sub_26d7(var_4602))) {
															this.someActiveUnit = getUnitAtPos(
																	this.cursorPosX,
																	this.cursorPosY,
																	(byte) 0);
															if ((this.someActiveUnit != null)
																	&& (this.someActiveUnit.var_e83 == 0)
																	&& (this.someActiveUnit.teamId == this.currentPlayerId)) {
																byte[] lo5;
																if ((lo5 = sub_bddb(
																				this.someActiveUnit,
																				(byte) 1)).length > 1) {
																	sub_6e49((byte[]) lo5);
																	C_MainCanvas
																			.playMusicLooped(
																					11,
																					1);
																} else {
																	this.var_49ea = false;
																	showWhereUnitCanMoveMb(this.someActiveUnit);
																}
															} else if ((getMapTileType(
																	this.cursorPosX,
																	this.cursorPosY) == 9)
																	&& (sub_11cae(
																			this.cursorPosX,
																			this.cursorPosY,
																			this.currentPlayerId))) {
																byte[] lo5;
																lo5 = new byte[] { 0 };
																sub_6e49((byte[]) lo5);
																C_MainCanvas
																		.playMusicLooped(
																				11,
																				1);
															} else {
																this.someActiveUnit = null;
																this.var_4882 = new E_Menu(
																		(byte) 11,
																		0);
																this.var_4882
																		.setMenuListStringActionsMb(
																				this.var_4612,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																F_StringManager.mainCanvas
																		.showMessageBox(this.var_4882);
																C_MainCanvas
																		.playMusicLooped(
																				11,
																				1);
															}
															F_StringManager.mainCanvas
																	.clearActionCodesMb();
														}
													}
												}
											} else {
												if ((!F_StringManager.mainCanvas
														.sub_26d7(4))
														&& (!F_StringManager.mainCanvas
																.sub_26d7(1))) {
													if ((F_StringManager.mainCanvas
															.sub_26d7(8))
															|| (F_StringManager.mainCanvas
																	.sub_26d7(2))) {
														this.var_47b2 += 1;
														if (this.var_47b2 >= this.var_47ba.length) {
															this.var_47b2 = 0;
														}
														F_StringManager.mainCanvas
																.releaseGameAction(8);
														F_StringManager.mainCanvas
																.releaseGameAction(2);
														this.var_495a = true;
													}
												} else {
													this.var_47b2 -= 1;
													if (this.var_47b2 < 0) {
														this.var_47b2 = (this.var_47ba.length - 1);
													}
													F_StringManager.mainCanvas
															.releaseGameAction(4);
													F_StringManager.mainCanvas
															.releaseGameAction(1);
													this.var_495a = true;
												}
												moveCursorToPos(
														this.var_47ba[this.var_47b2].posX,
														this.var_47ba[this.var_47b2].posY);
												if (this.var_495a) {
													this.unitAtCursorPos = getUnitAtPos(
															this.cursorPosX,
															this.cursorPosY,
															(byte) 0);
													this.var_4c4a = true;
												}
												if (F_StringManager.mainCanvas
														.sub_26d7(16)) {
													if (this.gameState == 6) {
														sub_6994(
																this.someActiveUnit,
																this.var_47ba[this.var_47b2]);
													} else if (this.gameState == 7) {
														sub_ed9f(
																this.var_47ba[this.var_47b2],
																this.currentPlayerId);
														this.someActiveUnit
																.sub_26fe();
														this.gameState = 0;
													}
													this.var_4882 = null;
													this.var_47e2 = false;
													this.var_47ea = false;
													this.canCancelMb = false;
													this.canApplyMb = false;
												}
												this.var_495a = false;
											}
										}
									}
								}
							}
						} else if ((this.var_4e52 != 1)
								&& ((this.gameState != 14) || (this.var_4e52 == 2))) {
							if (this.var_4e52 == 0) {
								this.var_4912 = true;
								this.var_491a = 0;
							} else if (this.var_4e52 == 2) {
								if (this.gameState == 14) {
									this.someCanHeight = this.canvasHeight;
									this.someCanHeightDiv2 = this.canvasHeightShift;
									sub_6d11(this.var_464a, this.canvasHeightShift,
											this.canvasHeight, null);
									return;
								}
								if (this.scenarioMapIndex <= 7) {
									loadMapById(this.scenarioMapIndex);
									initMap();
									this.gameState = 0;
								}
							}
						} else {
							this.scenarioMapIndex += 1;
							if (this.scenarioMapIndex > this.someSetting) {
								Object localObject4;
								if (var_45ca[this.someSetting] >= 0) {
									localObject4 = originalSkirmishMapNames12[var_45ca[this.someSetting]];
									localObject4 = newMessageBox(null,
											F_StringManager.getStrByIdAndReplaceUWith(82,
													(String) localObject4),
											this.canvasHeight, 3000);
									F_StringManager.mainCanvas
											.showMessageBox((F_StringManager) localObject4);
								}
								this.someSetting = this.scenarioMapIndex;
								try {
									localObject4 = new byte[] { (byte) this.someSetting };
									C_MainCanvas.addSomeRecords("settings", 1,
											(byte[]) localObject4);
								} catch (Exception localException) {
								}
							}
							this.var_4e52 = 2;
						}
					}
					int j = 0;
					int i5 = this.mapUnitsMaybe.size();
					while (j < i5) {
						((A_Unit) this.mapUnitsMaybe.elementAt(j)).sub_238a();
						j++;
					}
					if (this.someGameTime - this.var_4962 >= 300L) {
						this.var_496a = ((this.var_496a + 1) % this.var_497a.length);
						this.tiles0Frames[this.var_4972] = this.var_497a[this.var_496a];
						this.var_4962 = this.someGameTime;
					}
					G_Game llGame = this;
					if (this.var_4c6a == null) {
						llGame.sub_f012(
								llGame.cursorSprite.pixelX + 12,
								llGame.cursorSprite.pixelY + 12);
					} else {
						llGame.sub_f012(
								llGame.var_4c6a.pixelX + 12,
								llGame.var_4c6a.pixelY + 12);
					}
					if ((this.canCancelMb)
							&& (F_StringManager.mainCanvas.sub_272b(var_460a))) {
						if (this.gameState == 1) {
							this.gameState = 0;
							sub_bcb2(this.var_47da, 0);
							this.somePositions = null;
							this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
							moveCursorToPos(this.someActiveUnit.posX,
									this.someActiveUnit.posY);
							this.someActiveUnit = null;
						} else if ((this.gameState == 6) || (this.gameState == 7)) {
							this.gameState = this.var_4792;
							sub_bcb2(this.var_47da, 0);
							this.cursorSprite.setFrameSequence(frameSequencesCursorMb[0]);
							moveCursorToPos(this.someActiveUnit.posX,
									this.someActiveUnit.posY);
							F_StringManager.mainCanvas.showMessageBox(this.var_4882);
						}
						this.var_47e2 = false;
						this.var_47ea = false;
						F_StringManager.mainCanvas.releaseGameAction(var_460a);
						this.canCancelMb = false;
						this.canApplyMb = false;
					}
					for (int k = this.spritesOtherVector.size() - 1; k >= 0; k--) {
						G_Sprite localClass_g_25174;
						(localClass_g_25174 = (G_Sprite) this.spritesOtherVector
								.elementAt(k)).sub_21f3();
						if (!localClass_g_25174.isVisibleMb) {
							this.spritesOtherVector.removeElement(localClass_g_25174);
						}
					}
					int k = 0;
					int i6 = this.spritesVector.size();
					while (k < i6) {
						this.spritesOtherVector.addElement(this.spritesVector.elementAt(k));
						k++;
					}
					this.spritesVector.removeAllElements();
				}
			}
		}
	}

	private void sub_ecee(A_Unit paramClass_a_0260) {
		int i = paramClass_a_0260.pixelY + 24; // n
		showSpriteOnMap(this.smokeSprite, paramClass_a_0260.pixelX, i - this.smokeSprite.spriteFrameHeight,
				0, -2, 1, 100);
		for (int j = 0; j < 5; j++) {
			showSpriteOnMap(this.bSmokeSprite, paramClass_a_0260.pixelX, i
					- this.bSmokeSprite.spriteFrameHeight, j + -2,
					C_MainCanvas.getRandomWithin(-4, -1), 1,
					50 + 50 * C_MainCanvas.getRandomMax(4));
		}
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX, paramClass_a_0260.pixelX, 0, 0,
				1, 100);
	}

	private void sub_ed9f(A_Unit paramClass_a_0260, byte paramByte) {
		this.selectedTombUnit = paramClass_a_0260;
		this.activeTeamId = paramByte;
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX - 8,
				paramClass_a_0260.pixelY - 8, 1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX + 8,
				paramClass_a_0260.pixelY - 8, -1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX - 8,
				paramClass_a_0260.pixelY + 8, 1, -1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX + 8,
				paramClass_a_0260.pixelY + 8, -1, -1, 3, 50);
		this.var_48c2 = this.someGameTime;
	}

	private boolean sub_ee3c(int paramInt1, int paramInt2) {
		return (this.mapLeftX == sub_eeb2(paramInt1))
				&& (this.mapTopY == sub_ef35(paramInt2));
	}

	private boolean sub_ee85(int paramInt1, int paramInt2) {
		return sub_ee3c(paramInt1 * 24 + 12, paramInt2 * 24 + 12);
	}

	private int sub_eeb2(int paramInt) {
		if (this.var_46d2 > this.someCanWidth) {
			if ((paramInt = this.someCanWidthDiv2 - paramInt) > 0) {
				paramInt = 0;
			} else if (paramInt < this.someCanWidth - this.var_46d2) {
				paramInt = this.someCanWidth - this.var_46d2;
			}
		} else {
			paramInt = (this.someCanWidth - this.var_46d2) / 2;
		}
		return paramInt;
	}

	private int sub_ef35(int paramInt) {
		if (this.var_46da > this.someCanHeight) {
			if ((paramInt = this.someCanHeightDiv2 - paramInt) > 0) {
				paramInt = 0;
			} else if (paramInt < this.someCanHeight - this.var_46da) {
				paramInt = this.someCanHeight - this.var_46da;
			}
		} else {
			paramInt = (this.someCanHeight - this.var_46da) / 2;
		}
		return paramInt;
	}

	private void sub_efb8(int paramInt1, int paramInt2) {
		this.mapLeftX = sub_eeb2(paramInt1);
		this.mapTopY = sub_ef35(paramInt2);
	}

	private void sub_efe5(int paramInt1, int paramInt2) {
		sub_efb8(paramInt1 * 24 + 12, paramInt2 * 24 + 12);
	}

	private void sub_f012(int paramInt1, int paramInt2) {
		this.var_4c82 = true;
		paramInt1 = sub_eeb2(paramInt1);
		paramInt2 = sub_ef35(paramInt2);
		paramInt1 -= this.mapLeftX;
		paramInt2 -= this.mapTopY;
		int i;
		if (paramInt1 != 0) {
			i = paramInt1 / 2;
			if (paramInt1 < 0) {
				if (i > -this.var_4c7a) {
					i = -this.var_4c7a;
				} else if (i < -this.mapStepMax) {
					i = -this.mapStepMax;
				}
			} else if (i < this.var_4c7a) {
				i = this.var_4c7a;
			} else if (i > this.mapStepMax) {
				i = this.mapStepMax;
			}
			this.mapLeftX += i;
			this.var_4c82 = false;
		}
		if (paramInt2 != 0) {
			i = paramInt2 / 2;
			if (paramInt2 < 0) {
				if (i > -this.var_4c7a) {
					i = -this.var_4c7a;
				} else if (i < -this.mapStepMax) {
					i = -this.mapStepMax;
				}
			} else if (i < this.var_4c7a) {
				i = this.var_4c7a;
			} else if (i > this.mapStepMax) {
				i = this.mapStepMax;
			}
			this.mapTopY += i;
			this.var_4c82 = false;
		}
	}

	private void moveCursorToPos(int pX, int pY) {
		this.cursorPosX = pX;
		this.cursorPosY = pY;
		this.cursorSprite.setPixelPosition(pX * 24, pY * 24);
		this.unitAtCursorPos = getUnitAtPos(this.cursorPosX, this.cursorPosY, (byte) 0);
		this.var_4c4a = true;
	}

	private void drawMapMb(Graphics graphics) {
		int i = -this.mapLeftX / 24;
		int j = -this.mapTopY / 24;
		if (i < 0) {
			i = 0;
		}
		if (j < 0) {
			j = 0;
		}
		int k = (this.someCanWidth - this.mapLeftX - 1) / 24;
		int m = (this.someCanHeight - this.mapTopY - 1) / 24;
		if (k >= this.mapWidth) {
			k = this.mapWidth - 1;
		}
		if (m >= this.mapHeight) {
			m = this.mapHeight - 1;
		}
		int n;
		if (this.mapLeftX < 0) {
			n = this.mapLeftX % 24;
		} else {
			n = this.mapLeftX;
		}
		int i1;
		if (this.mapTopY < 0) {
			i1 = this.mapTopY % 24;
		} else {
			i1 = this.mapTopY;
		}
		int i2 = 0;
		if (this.var_47ea) {
			i2 = 1;
		}
		for (int it1 = j; it1 <= m; it1++) {
			int i3 = n;
			for (int it2 = i; it2 <= k; it2++) {
				int i5 = this.mapTilesIds[it2][it1];
				if ((!this.var_47e2) || (this.var_47da[it2][it1] == 0)
						|| (this.alphaWindow > 0)) {
					this.tiles0Frames[i5].drawOnGraphics(graphics, i3, i1);
				}
				if ((this.var_47e2) && (this.var_47da[it2][it1] > 0)) {
					if (this.alphaWindow != 0) {
						graphics.clipRect(i3 + this.alphaWindow, i1
								+ this.alphaWindow, 24 - (this.alphaWindow << 1),
								24 - (this.alphaWindow << 1));
					}
					graphics.drawImage(this.var_4c5a[i2][i5], i3, i1, 0);
					if (this.alphaWindow != 0) {
						graphics.setClip(0, 0, this.someCanWidth,
								this.someCanHeight);
					}
				}
				if (((i5 = it1 + 1) < this.mapHeight)
						&& (this.tilesDefs[this.mapTilesIds[it2][i5]] == 9)) {
					this.tiles0Frames[28].drawOnGraphics(graphics, i3, i1);
				}
				i3 += 24;
			}
			i1 += 24;
		}
	}

	private void runBlackLoadingState(Graphics graphics) {
		graphics.setFont(C_MainCanvas.theFont);
		graphics.setColor(0);
		graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
		graphics.setColor(16777215); // white
		String message = F_StringManager.getLangString(58); // Loading
		C_MainCanvas.showString(graphics, message,
				this.canvasWidth / 2,
				(this.canvasHeight - C_MainCanvas.theFont.getHeight()) / 2, 17);
	}

	public static final int getLinearGradientStepMb(int color1, int color2,
			int value, int maxValue) {
		if (value == 0) {
			return color1;
		}
		if (value == maxValue) {
			return color2;
		}
		int i = color1 & 0xFF0000;
		int j = color1 & 0xFF00;
		color1 &= 0xFF;
		i = (((color2 & 0xFF0000) - i) * value / maxValue & 0xFF0000)
				+ i;
		j = (((color2 & 0xFF00) - j) * value / maxValue & 0xFF00) + j;
		color1 = ((color2 & 0xFF) - color1) * value / maxValue
				+ color1;
		return i | j | color1;
	}

	private void initIntro(int introImageId, int paramInt2, int paramInt3) {
		this.var_4cd2 = paramInt2;
		this.var_4cda = paramInt3;
		this.var_4cca = this.gameStateMb;
		try {
			this.introImage = new D_ImageWrap("intro" + introImageId,
					this.someCanWidth, -1);
		} catch (Exception localException) {
			//
		}
		this.var_4c92 = C_MainCanvas.someFontHeight;
		if (this.introImage != null) {
			this.introImageHeight = this.introImage.imageHeight;
			this.var_491a = 0;
			this.var_4ca2 = ((this.canvasHeight - this.introImage.imageHeight) / this.var_4c92);
		} else {
			this.introImageHeight = 0;
			this.var_491a = 16;
			this.var_4ca2 = (this.canvasHeight / this.var_4c92);
		}
		this.introTextWrapped = F_StringManager.wrapStringText(
				F_StringManager.getLangString(introImageId + 215), this.canvasWidth,
				C_MainCanvas.someFont);
		this.var_4c9a = (this.canvasHeight - this.var_4c92);
		this.var_4caa = 0;
		this.var_4cc2 = false;
		F_StringManager.mainCanvas.clearActionCodesMb();
		this.gameStateMb = 3;
	}

	private void sub_f6d8(String text) {
		this.var_4cca = this.gameStateMb;
		this.introTextWrapped = F_StringManager.wrapStringText(text, this.canvasWidth,
				C_MainCanvas.someFont);
		this.var_491a = 16;
		this.var_4cc2 = false;
		this.var_4cd2 = 3;
		this.var_4cda = 3;
		this.introImageHeight = 0;
		this.var_4c92 = C_MainCanvas.someFontHeight;
		this.var_4ca2 = (this.canvasHeight / this.var_4c92);
		this.var_4c9a = (this.canvasHeight - this.var_4c92);
		this.var_4caa = 0;
		F_StringManager.mainCanvas.clearActionCodesMb();
		this.gameStateMb = 3;
	}

	private void runCurrentIntroStateMb(Graphics graphics) {
		graphics.setFont(C_MainCanvas.someFont);
		graphics.setColor(0);
		graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
		if (this.introImage != null) {
			if ((!this.var_4cc2)
					&& (((this.var_4cd2 == 2) && (this.var_491a >= 40)) || ((this.var_4cd2 != 2) && (this.var_491a >= 16)))) {
				this.introImage.drawOnGraphics(graphics, 0, 0);
			} else if (((this.var_4cda != 2) || (!this.var_4cc2))
					&& ((this.var_4cd2 != 2) || (this.var_4cc2))) {
				if (((this.var_4cda != 3) || (!this.var_4cc2))
						&& ((this.var_4cd2 != 3) || (this.var_4cc2))) {
					this.introImage.drawOnGraphics(graphics, 0, 0);
					if (this.var_4cc2) {
						if ((this.var_4cda == 1) && (this.var_491a <= 16)) {
							sub_12052(graphics, 0, 16 - this.var_491a, 16,
									0, 0, 0, this.canvasWidth, this.canvasHeight);
						}
					} else if (this.var_4cd2 == 0) {
						if (this.var_491a <= 16) {
							sub_12052(graphics, 16777215, this.var_491a,
									16, 1, 0, 0, this.canvasWidth, this.canvasHeight);
						}
					} else if ((this.var_4cd2 == 1) && (this.var_491a <= 16)) {
						sub_12052(graphics, 0, this.var_491a, 16, 1, 0, 0,
								this.canvasWidth, this.introImage.imageHeight);
					}
				} else {
					this.introImage.drawOnGraphics(graphics, 0, 0);
					int i = 255 * (16 - this.var_491a) / 16;
					C_MainCanvas.sub_1edc(graphics, i << 24, 0, 0,
							this.introImage.imageWidth, this.introImage.imageHeight);
				}
			} else {
				sub_11f87(graphics, this.var_491a, 40, 0, this.introImage,
						0, 0, 2);
			}
		}
		graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
		int i = this.var_491a;
		if ((this.var_4cc2) && (this.var_4cda == 2)) {
			i -= 24;
			if (i < 0) {
				i = 0;
			}
		}
		int j = this.var_4c9a;
		for (int k = this.var_4caa; (k < this.var_4caa + this.var_4ca2)
				&& (k < this.introTextWrapped.length)
				&& (j < this.canvasHeight - this.var_4c92); k++) {
			int m = this.var_4c92;
			if (j < this.introImageHeight + this.var_4c92) {
				m = j - this.introImageHeight;
			} else if (j + this.var_4c92 > this.canvasHeight - this.var_4c92) {
				m = this.canvasHeight - this.var_4c92 - j;
			}
			if (m < this.var_4c92) {
				int i1 = this.var_4c92;
				int n = m;
				m = 14672074;
				m = n * 14614528 / i1 & 0xFF0000;
				int i2 = n * 57344 / i1 & 0xFF00;
				n = n * 202 / i1;
				m = m | i2 | n;
			} else {
				m = 14672074;
			}
			if (this.var_4cc2) {
				m = getLinearGradientStepMb(0, m, i, 16);
			}
			graphics.setColor(m);
			C_MainCanvas.showString(graphics, this.introTextWrapped[k],
					this.canvasWidthShift, j + 3, 17);
			j += this.var_4c92;
		}
		if (!this.var_4cc2) {
			drawButtonIcon(graphics, var_4602, 2, this.canvasHeight);
		}
	}

	private void runWavingImageState(Graphics graphics) {
		/* intro images waving? */
		
		if (this.startupBgState == 0) {
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.msLogoImage,
					(this.canvasWidth - this.msLogoImage.imageWidth) / 2,
					(this.canvasHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.startupBgState == 1) {
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.msLogoImage,
					(this.canvasWidth - this.msLogoImage.imageWidth) / 2,
					(this.canvasHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.startupBgState == 3) {
			graphics.setColor(0);
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.aeLogoImage, 0, 0,
					1);
			graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			return;
		}
		if (this.startupBgState == 4) {
			if (this.var_491a >= 16) {
				if (this.splashImage != null) {
					this.aeLogoImage.drawOnGraphics(graphics, 0, 0);
					if (this.glowLightXmb != -1) {
						int i = (this.aeLogoImage.imageHeight + this.glowLightOnLogoImage.imageHeight - 1)
								/ this.glowLightOnLogoImage.imageHeight;
						for (int j = 0; j < i; j++) {
							this.glowLightOnLogoImage.drawOnGraphics(graphics, 4
									+ this.glowLightXmb - j * 38, 6
									+ this.glowLightOnLogoImage.imageHeight * j);
						}
					}
					this.splashImage.drawOnGraphics(graphics, 0, 0);
				} else {
					graphics.setColor(0);
					graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
					this.aeLogoImage.drawOnGraphics(graphics, 0, 0);
				}
				if ((this.var_498a) && (this.splashImage != null)) {
					graphics.setColor(16777215);
					graphics.setFont(C_MainCanvas.theFont);
					sub_fdce(graphics, F_StringManager.getLangString(59),
							this.canvasWidthShift, this.canvasHeight - this.buttonsSprite.spriteFrameHeight
									- 1, 33, 16777215, 0);
				}
			} else {
				if (this.splashImage != null) {
					this.splashImage.drawOnGraphics(graphics, 0, 0);
				} else {
					graphics.setColor(0);
					graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
				}
				C_MainCanvas.sub_1edc(graphics,
						255 * (16 - this.var_491a) / 16 << 24, 0, 0,
						this.canvasWidth, this.canvasHeight);
				this.aeLogoImage.drawOnGraphics(graphics, 0, 0);
			}
		}
	}

	public static final void sub_fdce(Graphics gr,
			String inStr, int inX, int inY, int paramInt3,
			int inColor, int paramInt5) {
		gr.setColor(0);
		gr.drawString(inStr, inX - 1, inY - 1,
				paramInt3);
		gr.drawString(inStr, inX - 1, inY,
				paramInt3);
		gr.drawString(inStr, inX - 1, inY + 1,
				paramInt3);
		gr.drawString(inStr, inX, inY - 1,
				paramInt3);
		gr.drawString(inStr, inX, inY + 1,
				paramInt3);
		gr.drawString(inStr, inX + 1, inY + 1,
				paramInt3);
		gr.drawString(inStr, inX + 1, inY,
				paramInt3);
		gr.drawString(inStr, inX + 1, inY - 1,
				paramInt3);
		gr.setColor(inColor);
		gr.drawString(inStr, inX, inY, paramInt3);
	}

	//@Override
	public final void startLoading(Graphics graphics) {
		if (this.gameStateMb == 4) { //loading screen
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			graphics.setFont(C_MainCanvas.theFont);
			graphics.setColor(0);
			// "LOADING..."
			graphics.drawString(F_StringManager.getLangString(58),
					this.canvasWidth / 2, this.canvasHeight / 2 - 1, 33);
			int loadBarHeight = this.canvasHeight / 18;
			if (loadBarHeight < 12) {
				loadBarHeight = 12;
			}
			int canvasCenterY = this.canvasHeight / 2 + 1;
			graphics.setColor(13553358); //#CECECE gray
			E_Menu.drawRoundedRect(graphics, 1, canvasCenterY, this.canvasWidth - 2, loadBarHeight);
			graphics.setColor(2370117); //#242A45 darkblue
			E_Menu.drawRoundedRect(graphics, 2, canvasCenterY + 2, this.loadingProgress
					* (this.canvasWidth - 6) / 100, loadBarHeight - 4);
			return;
		}
		int k;
		int i3count;
		if (this.gameStateMb == 2) {
			Graphics locGraph = graphics;
			G_Game self = this;
			k = 0;
			int n = 0;
			if (self.isShakingMB) {
				k = C_MainCanvas.getRandomNumber() % 10;
				n = C_MainCanvas.getRandomNumber() % 3;
			}
			locGraph.translate(0, self.var_4cfa);
			locGraph.setClip(0, 0, self.someCanWidth,
					self.faViewPortHeight);
			self.fAnim1.drawBackgroundShifted(locGraph, k, n);
			self.fAnim2.drawBackgroundShifted(locGraph, k
					+ self.someCanWidthDiv2, n);
			locGraph.setColor(0); //black
			locGraph.fillRect(self.someCanWidthDiv2 - 1 + k, 0, 2,
					self.faViewPortHeight);
			self.fAnim1.drawSomeArcOverUnits(locGraph);
			self.fAnim2.drawSomeArcOverUnits(locGraph);
			Vector spritesList = new Vector(self.spritesList.size());
			G_Sprite lcSprite;
			for (int n1 = 0; n1 < self.spritesList.size(); n1++) {
				lcSprite = (G_Sprite)self.spritesList.elementAt(n1);
				i3count = 0;
				if (lcSprite.var_c88) {
					spritesList.addElement(lcSprite);
				} else {
					for (int index = 0; index < spritesList.size(); index++) {
						G_Sprite lcSpr2 = (G_Sprite) spritesList
								.elementAt(index);
						if ((lcSpr2.var_c88)
								|| (lcSprite.pixelY
										+ lcSprite.spriteFrameHeight < lcSpr2.pixelY
										+ lcSpr2.spriteFrameHeight)) {
							spritesList.insertElementAt(lcSprite, index);
							break;
						}
						i3count++;
					}
				}
				if (i3count == spritesList.size()) {
					spritesList.addElement(lcSprite);
				}
			}
			self.spritesList = spritesList;
			for (int n1 = 0; n1 < self.spritesList.size(); n1++) {
				if ((lcSprite = (G_Sprite) self.spritesList
						.elementAt(n1)).var_c98 == 0) {
					locGraph.setClip(0, 0, self.someCanWidthDiv2,
							self.faViewPortHeight);
				} else if (lcSprite.var_c98 == 1) {
					locGraph.setClip(self.someCanWidthDiv2, 0,
							self.someCanWidthDiv2, self.faViewPortHeight);
				} else {
					locGraph.setClip(0, 0, self.someCanWidth,
							self.faViewPortHeight);
				}
				lcSprite.sub_1d20(locGraph, 0,
						lcSprite.var_c38);
				n++;
			}
			locGraph.translate(0, -self.var_4cfa);
			locGraph.setClip(0, 0, self.canvasWidth,
					self.canvasHeight);
			if (self.var_4eb2) {
				self.var_4eb2 = false;
				n = self.canvasHeight - var_4592;
				locGraph.setColor(14672074); //#DFE0CA light green
				locGraph.fillRect(0, n, self.canvasWidth, var_4592);
				E_Menu.sub_5066(locGraph, 0, n,
						self.canvasWidth, var_4592, 0);
				locGraph.setClip(0, 0, self.canvasWidth,
						self.canvasHeight);
				self.fAnim1.drawUnitHealthStatus(locGraph);
				locGraph.translate(self.someCanWidthDiv2, 0);
				self.fAnim2.drawUnitHealthStatus(locGraph);
				locGraph.translate(-self.someCanWidthDiv2, 0);
			}
			if (self.var_4eaa) {
				self.var_4eaa = false;
				self.drawUnitAttackBar(locGraph,
						self.fAnim1.someUnit1,
						self.fAnim2.someUnit1, 0);
			}
			if (self.var_4ea2) {
				sub_12052(locGraph, 0, self.var_491a, 16, 1, 0,
						0, self.canvasWidth, self.canvasHeight);
			}
			return;
		}
		if (this.gameStateMb == 3) { // intro state
			runCurrentIntroStateMb(graphics);
			return;
		}
		if (this.isLoadingBlackMb) { 
			runBlackLoadingState(graphics);
			return;
		}
		if (this.var_4912) {
			if (this.var_491a >= 16) {
				if ((this.gameState != 11) && (this.gameState != 10)) {
					runBlackLoadingState(graphics);
					return;
				}
				graphics.setColor(0);
				graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
				return;
			}
			sub_12052(graphics, 0, this.var_491a, 16, 0, 0, 0,
					this.canvasWidth, this.canvasHeight);
			return;
		}
		int m;
		int y;
		if (this.gameStateMb == 0) { // waving image state
			runWavingImageState(graphics);
		} else if (this.gameState == 14) {
			graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			graphics.setColor(0); // black
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
		} else if ((this.gameState == 10) && (this.var_4e52 > 0)) {
			runBlackLoadingState(graphics);
		} else {
			Object localObject1;
			//GAME OVER
			if ((this.gameState == 11) && (!this.var_4912)) {
				String aString = F_StringManager.getLangString(57); // GAME OVER
				graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				graphics.setFont(C_MainCanvas.theFont);
				graphics.setColor(0);
				graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
				if (this.scenarioModeIf0 == 0) {
					graphics.setColor(16777215); // white
					if (this.gameOverImage != null) {
						this.gameOverImage.drawOnGraphics(graphics, this.canvasWidthShift,
								this.canvasHeightShift, 3);
						C_MainCanvas.showString(graphics,
								 aString, this.canvasWidthShift,
								this.canvasHeight - 2, 33);
					} else {
						int strCenterY = this.canvasHeightShift - C_MainCanvas.theFont.getHeight()
								/ 2;
						C_MainCanvas.showString(graphics,
								 aString, this.canvasWidthShift, strCenterY, 17);
					}
				}
			} else {
				graphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
				if ((this.var_46d2 < this.someCanWidth)
						|| (this.var_46da < this.someCanHeight)) {
					graphics.setColor(0); //black
					graphics.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
				}
				if (this.isShakingMB) { // shift
					int tX = C_MainCanvas.getRandomNumber() % 10;
					int tY = C_MainCanvas.getRandomNumber() % 4;
					graphics.translate(tX, tY);
					drawMapMb(graphics);
					graphics.translate(-tX, -tY);
				} else {
					drawMapMb(graphics);
				}
				int muIndex = 0;
				int mapUnitCount = this.mapUnitsMaybe.size();
				while ( muIndex < mapUnitCount) {
					A_Unit unit = (A_Unit) this.mapUnitsMaybe.elementAt( muIndex);
					if (unit.var_e83 == 3) {
						this.tombStoneImage.drawOnGraphics(
										graphics,
										this.mapLeftX + unit.pixelX, 
										this.mapTopY + unit.pixelY  
										);
					} else if (unit != this.someActiveUnit) {
						unit.sub_28d7(graphics, this.mapLeftX, this.mapTopY);
					}
					 muIndex++;
				}
				muIndex = 0;
				mapUnitCount = this.mapUnitsMaybe.size();
				while ( muIndex < mapUnitCount) {
					((A_Unit) this.mapUnitsMaybe.elementAt( muIndex)).drawHealthString(
							graphics, this.mapLeftX, this.mapTopY);
					 muIndex++;
				}
				int i2;
				Object localObject2;
				if (this.somePositions != null) {
					graphics.setColor(14745682); //#E10052 red
					int m1 = 12 + this.var_4d02 / 4;
					int i4 = 24 - m1;
					int index = 0;
					int count = this.somePositions.size();
					while (index < count) {
						short[] lObj2 = (short[]) this.somePositions
								.elementAt(index);
						int left = lObj2[0] * 24 + this.mapLeftX;
						int top = lObj2[1] * 24 + this.mapTopY;
						int leftShift = left + 12;
						int topShift = top + 12;
						short[] arrayOfShort;
						if (index != 0) {
							if ((arrayOfShort = (short[]) this.somePositions
									.elementAt(index - 1))[0] == lObj2[0] + 1) {
								graphics.fillRect(left + i4, topShift
										- this.var_4d0a, m1, this.var_4d02);
							} else if (arrayOfShort[0] == lObj2[0] - 1) {
								graphics.fillRect(left, topShift - this.var_4d0a,
										m1, this.var_4d02);
							} else if (arrayOfShort[1] == lObj2[1] + 1) {
								graphics.fillRect(leftShift - this.var_4d0a, top
										+ i4, this.var_4d02, m1);
							} else if (arrayOfShort[1] == lObj2[1] - 1) {
								graphics.fillRect(leftShift - this.var_4d0a, top,
										this.var_4d02, m1);
							}
						}
						if (index == count - 1) {
							graphics.setClip(0, 0, this.someCanWidth,
									this.someCanHeight);
							this.currentCursorSpriteMaybe.drawCurrentFrame(graphics, leftShift, topShift, 3);
						} else if ((arrayOfShort = (short[]) this.somePositions
								.elementAt(index + 1))[0] == lObj2[0] + 1) {
							graphics.fillRect(left + i4, topShift - this.var_4d0a,
									m1, this.var_4d02);
						} else if (arrayOfShort[0] == lObj2[0] - 1) {
							graphics.fillRect(left, topShift - this.var_4d0a, m1,
									this.var_4d02);
						} else if (arrayOfShort[1] == lObj2[1] + 1) {
							graphics.fillRect(leftShift - this.var_4d0a, top + i4,
									this.var_4d02, m1);
						} else if (arrayOfShort[1] == lObj2[1] - 1) {
							graphics.fillRect(leftShift - this.var_4d0a, top,
									this.var_4d02, m1);
						}
						index++;
					}
				}
				if (this.someActiveUnit != null) {
					this.someActiveUnit.sub_28d7(graphics, this.mapLeftX,
							this.mapTopY);
					this.someActiveUnit.drawHealthString(graphics, this.mapLeftX,
							this.mapTopY);
				}
				if (this.isCursorVisible) {
					this.cursorSprite.drawCurrentFrame(graphics, this.mapLeftX + 12,
							this.mapTopY + 12, 3);
				}
				 muIndex = 0;
				mapUnitCount = this.spritesOtherVector.size();
				while ( muIndex < mapUnitCount) {
					G_Sprite lob = (G_Sprite) this.spritesOtherVector.elementAt( muIndex);
					lob.sub_1d20(
									graphics,
									this.mapLeftX,
									this.mapTopY
											+ ((G_Sprite) lob).var_c38);
					 muIndex++;
				}
				graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				 muIndex = this.canvasHeight - var_4592;
				if (this.statusBarOffset > 0) {
					E_Menu.sub_5066(graphics, 0,  muIndex, this.someCanWidth,
							var_4592, 14);
					graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				}
				mapUnitCount = var_4592 - 24 >> 1;
				int i4 = 24 + (mapUnitCount << 1);
				int x = this.canvasWidth - i4;
				 muIndex += this.statusBarOffset;
				if (this.var_4c42) {
					this.var_4c42 = false;
					i2 = this.canvasHeight - var_4592 / 2 + this.statusBarOffset;
					int i5 = 10;
					if (this.someCanWidth <= 120) {
						i5 = 4;
					}
					if (this.var_4f92 == 1) {
						E_Menu.sub_5092(graphics, 0,  muIndex, x + 1,
								var_4592, 0, 2370117, var_468a[0],
								this.statusBarOffset, var_4592);
						C_MainCanvas.sub_2007(graphics, this.cursorTileId + 1
								+ "/" + this.tiles0Frames.length, i5 + 1, i2, 1, 6);
					} else if (this.var_4f92 == 2) {
						E_Menu.sub_5092(graphics, 0,  muIndex, x + 1,
								var_4592, 0, 2370117,
								var_468a[this.var_4832[this.currentPlayerId]],
								this.statusBarOffset, var_4592);
						C_MainCanvas.sub_2007(graphics, this.someUnitTypeId + 1
								+ "/" + 12, i5 + 1, i2, 1, 6);
					} else {
						E_Menu.sub_5092(graphics, 0,  muIndex, x + 1,
								var_4592, 0, 2370117,
								var_468a[this.var_4832[this.currentPlayerId]],
								this.statusBarOffset, var_4592);
						if (this.scenarioModeIf0 == 1) {
							i3count = x / 2;
							this.hudIcons2Sprite.drawFrame(graphics, 0, i3count, i2, 6);
							C_MainCanvas.sub_2007(graphics,
									countSomeTeamUnitsOfType(-1, -1, this.currentPlayerId)
											- countSomeTeamUnitsOfType(10, -1, this.currentPlayerId)
											+ "/" + this.var_45f2, i3count
											+ this.hudIcons2Sprite.spriteFrameWidth + 1, i2, 1,
									6);
						}
						this.hudIcons2Sprite.drawFrame(graphics, 1, i5, i2, 6);
						i3count = i5 + this.hudIcons2Sprite.spriteFrameWidth + 1;
						if ((!C_MainCanvas.propDeveloperModeOn)
								&& (this.someTeamValuesArr[this.currentPlayerId] != 1)) {
							C_MainCanvas.sub_2007(graphics, "- - -", i3count,
									i2, 1, 6);
						} else {
							C_MainCanvas.sub_2007(graphics, ""
									+ this.var_486a[this.currentPlayerId], i3count, i2, 1,
									6);
						}
					}
					graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				}
				if (this.var_4c4a) {
					this.var_4c4a = false;
					if (mapUnitCount > 0) {
						drawRectBar(graphics, x,  muIndex, i4, var_4592);
					}
					int px = x + mapUnitCount;
					int py =  muIndex + mapUnitCount;
					if ((this.var_4f92 == 0) || (this.var_4f92 == 2)) {
						this.cursorTileId = this.mapTilesIds[this.cursorPosX][this.cursorPosY];
					}
					this.tiles0Frames[this.cursorTileId]
							.drawOnGraphics(graphics, px, py);
					if (this.var_4f92 == 2) {
						if (this.var_4f8a == null) {
							this.var_4f8a = A_Unit.createNewUnit(
									this.someUnitTypeId, this.currentPlayerId, 0, 0, false);
						}
						this.var_4f8a.sub_28d7(graphics, px, py);
					}
					if (this.var_4f92 == 0) {
						String str = "."
								+ tilesExtraDefence[this.tilesDefs[this.cursorTileId]];
						C_MainCanvas.sub_2007(graphics, str, px + 24,
								py + 24, 0, 40);
					}
					if (mapUnitCount == 0) {
						graphics.setColor(0);
						graphics.drawRect(px, py, 24, 24);
					}
				}
				if ((this.gameState == 6)
						&& (this.var_47ba[this.var_47b2].var_e83 != 4)) {
					int pY = 0;
					if (this.cursorPosY * 24 <= this.someCanHeight / 2 - 24) {
						pY = this.someCanHeight - this.buttonsSprite.spriteFrameHeight
								- this.var_4cfa + 2;
					}
					drawUnitAttackBar(graphics, this.someActiveUnit,
							this.var_47ba[this.var_47b2], pY);
				}
			}
		}
		if (sub_5d81()) {
			if (this.canCancelMb) {
				drawButtonIcon(graphics, var_460a, 1, this.someCanHeight); // return/cancel
			}
			if (this.canApplyMb) {
				drawButtonIcon(graphics, var_4602, 0, this.someCanHeight); // ok/apply
			}
			if ((this.gameStateMb == 1)
					&& ((this.someTeamValuesArr[this.currentPlayerId] == 0) || (this.gameState == 0))
					&& (this.gameState != 11)) {
				drawButtonIcon(graphics, var_4602, 3, this.someCanHeight); //openmenu
			}
		}
		if ((this.var_4aca) || (this.var_4ad2)) {
			int y1 = this.fadeValue;
			if (this.var_4ad2) {
				 y1 = 16 - this.fadeValue;
			}
			int m1 =  y1 * 255 / 16;
			C_MainCanvas.sub_1edc(graphics, m1 << 24, 0, 0, this.canvasWidth,
					this.canvasHeight);
		}
	}

	public static void drawRectBar(Graphics gr, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4) {
		gr.setColor(4344163); //#424963 darkblue
		gr.fillRect(paramInt1, paramInt2, paramInt3, paramInt4);
		gr.setColor(11384493); // #ADB6AD mudgreen
		gr.fillRect(paramInt1 + 1, paramInt2 + 1, paramInt3 - 2,
				paramInt4 - 2);
		gr.setColor(4344163); //#424963 darkblue
		gr.fillRect(paramInt1 + 3, paramInt2 + 3, paramInt3 - 6,
				paramInt4 - 6);
	}

	private void drawUnitAttackBar(Graphics gr,
			A_Unit unit1, A_Unit unit2,
			int paramInt) {
		int i = this.var_4cfa - 2;
		gr.setColor(11384493); // #ADB6AD mudgreen
		gr.fillRect(0, paramInt, this.someCanWidth, i);
		gr.setColor(0);
		gr.fillRect(0, i + paramInt, this.someCanWidth, 2);
		int j = 0;
		int k = i /= 2 + paramInt;
		for (int m = 0; m < 3; m++) {
			this.hudIconsSprite.drawFrame(gr, m, j + 1, k, 6);
			j += this.hudIconsSprite.spriteFrameWidth + 2;
			int n = paramInt + 1;
			int i1;
			if (m == 0) {
				if (this.canvasWidth <= 132) {
					i1 = 56;
				} else {
					i1 = 61 * this.someCanWidth / 176;
				}
			} else if (m == 1) {
				if (this.canvasWidth <= 132) {
					i1 = 28;
				} else {
					i1 = 47 * this.someCanWidth / 176;
				}
			} else {
				i1 = this.someCanWidth - j;
			}
			for (int i2 = 0; i2 < 2; i2++) {
				A_Unit localClass_a_0260;
				Object localObject;
				if (i2 == 0) {
					localClass_a_0260 = unit1;
					localObject = unit2;
				} else {
					localClass_a_0260 = unit2;
					localObject = unit1;
				}
				int i4 = i - 2;
				gr.setColor(2172994);
				gr.fillRect(j, n, i1, i4);
				int i5 = j + 1;
				if ((m == 0) || (this.canvasWidth > 132)) {
					gr
							.setColor(var_468a[this.var_4832[localClass_a_0260.teamId]]);
					gr.fillRect(i5, n + 1, 3, i4 - 2);
					i5 += 4;
				}
				int i6 = 0;
				if (m == 0) {
					if ((i2 != 0)
							&& (!unit2.canAttackPosition(
									unit1.posX,
									unit1.posY))) {
						localObject = "0-0";
					} else {
						int bonusAttack = localClass_a_0260
								.getExtraUnitAttack((A_Unit) localObject);
						localObject = localClass_a_0260.attackMin + bonusAttack + "-"
								+ (localClass_a_0260.attackMax + bonusAttack);
					}
				} else if (m == 1) {
					int unitResist = localClass_a_0260.getExtraDefence((A_Unit) localObject);
					localObject = "" + (localClass_a_0260.defence + unitResist);
				} else {
					localObject = "" + localClass_a_0260.level;
				}
				C_MainCanvas.drawAString(gr, (String) localObject, i5,
						n + 1, 0);
				if (i6 > 0) {
					this.arrowIconsSprite.drawFrame(
							gr,
							1,
							i5
									+ 1
									+ C_MainCanvas.spriteTextWidth((byte) 0,
											(String) localObject), n + i4 / 2,
							6);
				} else if (i6 < 0) {
					this.arrowIconsSprite.drawFrame(
							gr,
							2,
							i5
									+ 1
									+ C_MainCanvas.spriteTextWidth((byte) 0,
											(String) localObject), n + i4 / 2,
							6);
				}
				int i3 = j + i1 - 2;
				if ((m == 0) && ((localClass_a_0260.status & 0x2) != 0)) {
					this.statusSprite
							.drawFrame(gr, 1, i3, n + i4 / 2, 10);
					i3 -= this.statusSprite.spriteFrameWidth;
				}
				if (((m == 0) || (m == 1))
						&& ((localClass_a_0260.status & 0x1) != 0)) {
					this.statusSprite
							.drawFrame(gr, 0, i3, n + i4 / 2, 10);
				}
				n += i;
			}
			j += i1;
		}
	}

	public final void drawButtonIcon(Graphics paramGraphics, int paramInt1,
			int imageIndex, int pY) {
		int pX = 0;
		int j = 0;
		if (paramInt1 == 1024) {
			j = 36;
		} else if (paramInt1 == 2048) {
			pX = this.canvasWidth;
			j = 40;
		}
		this.buttonsSprite.drawFrame(paramGraphics, imageIndex, pX, pY, j);
	}

	public final A_Unit getUnitAtPos(int inX, int inY,
			byte paramByte) {
		int i = 0;
		int mapUnitsCount = this.mapUnitsMaybe.size();
		while (i < mapUnitsCount) {
			A_Unit unit = (A_Unit) this.mapUnitsMaybe.elementAt(i);
			int pX;
			int pY;
			if (unit.var_e83 == 1) {
				pX = unit.var_e4b;
				pY = unit.var_e53;
			} else {
				pX = unit.posX;
				pY = unit.posY;
			}
			if ((inX == pX) && (inY == pY)) {
				if (paramByte == 0) {
					if (unit.var_e83 != 3) {
						return unit;
					}
				} else if ((paramByte == 1) && (unit.var_e83 == 3)) {
					return unit;
				}
			}
			i++;
		}
		return null;
	}

	public final byte getMapTileType(int paramInt1, int paramInt2) {
		return this.tilesDefs[this.mapTilesIds[paramInt1][paramInt2]];
	}

	private void sub_11699() {
		C_MainCanvas.stopCurrentMusicPlayer();
		this.var_4812 = 0;
		this.statusBarOffset = 0;
		this.gameState = 8;
		this.var_481a = this.someGameTime;
	}

	private void sub_116cf() {
		for (;;) {
			if (this.var_4f92 != 0) {
				return;
			}
			this.kingsPositions[this.currentPlayerId][0] = ((byte) this.cursorPosX);
			this.kingsPositions[this.currentPlayerId][1] = ((byte) this.cursorPosY);
			this.currentTurn = ((short) (this.currentTurn + 1));
			this.currentPlayerId = ((byte) ((this.currentPlayerId + 1) % this.teamsCountMaybe));
			if (this.someTeamValuesArr[this.currentPlayerId] == 2) {
				sub_116cf();
				return;
			}
			for (int i = this.mapUnitsMaybe.size() - 1; i >= 0; i--) {
				A_Unit localClass_a_0260;
				if ((localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
						.elementAt(i)).var_e83 == 3) {
					if ((localClass_a_0260.unitType != 9)
							&& ((localClass_a_0260.var_ecb = (byte) (localClass_a_0260.var_ecb - 1)) <= 0)) {
						localClass_a_0260.removeUnit();
					}
				} else {
					localClass_a_0260.var_e83 = 0;
					if (((localClass_a_0260.status & 0x1) != 0)
							&& (localClass_a_0260.var_ed3 == this.currentPlayerId)) {
						localClass_a_0260.applyInvertedStatMbWTF((byte) 1);
					}
					if (localClass_a_0260.teamId == this.currentPlayerId) {
						localClass_a_0260.applyInvertedStatMbWTF((byte) 2);
					}
					localClass_a_0260.var_f03 = 0;
				}
			}
			this.var_4d12 = 0;
			for (int i = 0; i < this.mapTilesIds.length; i++) {
				for (int j = 0; j < this.mapTilesIds[i].length; j++) {
					if (sub_11cae(i, j, this.currentPlayerId)) {
						if (getMapTileType(i, j) == 8) {
							this.var_4d12 += 30;
						} else if (getMapTileType(i, j) == 9) {
							this.var_4d12 += 50;
						}
					}
				}
			}
			this.var_486a[this.currentPlayerId] += this.var_4d12;
			for (int i = 0; i < this.somePositionsOrTilesData.length; i++) {
				this.var_4d82[i] = 0;
			}
			if (this.someTeamValuesArr[this.currentPlayerId] == 1) {
				moveCursorToPos(this.kingsPositions[this.currentPlayerId][0],
						this.kingsPositions[this.currentPlayerId][1]);
			}
			this.var_495a = true;
			this.var_4c42 = true;
			if (this.someTeamValuesArr[this.currentPlayerId] == 0) {
				sub_122cc();
			} else {
				A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
			}
			if ((countSomeTeamUnitsOfType(-1, 0, this.currentPlayerId) > 0)
					|| (sub_11cef(this.currentPlayerId) != 0)) {
				break;
			}
		}
	}

	private boolean canOccupyVillageMaybe(A_Unit unit) {
		return (unit.hasProperty((short) 8)) //occupy village
				&& (getMapTileType(unit.posX,
						unit.posY) == 8) // village
				&& (!tileCanBeOccupied(this.mapTilesIds[unit.posX][unit.posY]));
	}

	private boolean canOccupyVillageOrTownMaybe(A_Unit unit) {
		if ((unit.hasProperty((short) 8)) //occupy village
				&& (getMapTileType(unit.posX,
						unit.posY) == 8) // village
				&& (tileCanBeOccupied(this.mapTilesIds[unit.posX][unit.posY]))
				&& (!sub_11c55(unit.posX,
						unit.posY,
						this.var_483a[unit.teamId]))) {
			return true;
		}
		return (unit.hasProperty((short) 16))  //occupy town!
				&& (getMapTileType(unit.posX,
						unit.posY) == 9) //town!
				&& (!sub_11c55(unit.posX,
						unit.posY,
						this.var_483a[unit.teamId]));
	}

	private void setMapTileId(byte id, int inX, int inY) {
		this.mapTilesIds[inX][inY] = id;
	}

	private void changeTileToOccupiedByTeam(int inX, int inY, int teamIndex) {
		byte tileId = this.mapTilesIds[inX][inY];
		if (tileCanBeOccupied(tileId)) {
			setMapTileId(
					(byte) (37 + (teamIndex << 1) + (tileId - 37) % 2),
					inX, inY);
		}
	}

	private static boolean isVillageOrTownEvenDestroyed(byte paramByte) {
		return ((paramByte >= 37) && (paramByte < 47)) || (paramByte == 27);
	}

	public static boolean tileCanBeOccupied(byte inByte) {
		return (inByte >= 37) && (inByte < 47);
	}

	private int sub_11bae(int paramInt1, int paramInt2) {
		return sub_11bd2(paramInt1, paramInt2, this.mapTilesIds);
	}

	private static int sub_11bd2(int inX, int inY,
			byte[][] paramArrayOfByte) {
		int val = paramArrayOfByte[inX][inY] - 37 >> 1;
		if ((val >= 0) && (val <= 4)) {
			return val;
		}
		return -1;
	}

	private int sub_11c17(int paramInt) {
		if ((paramInt != -1) && (paramInt != 0)) {
			return this.var_482a[paramInt];
		}
		return -1;
	}

	public final boolean sub_11c55(int paramInt1, int paramInt2, int paramInt3) {
		int val = sub_11c17(sub_11bae(paramInt1, paramInt2));
		if (val >= 0) {
			return paramInt3 == this.var_483a[paramInt1];
		}
		return false;
	}

	private boolean sub_11cae(int paramInt1, int paramInt2, int paramInt3) {
		return sub_11bae(paramInt1, paramInt2) == this.var_4832[paramInt3];
	}

	private int sub_11cef(int paramInt) {
		int i = 0;
		for (int j = 0; j < this.var_4d9a; j++) {
			if (sub_11cae(this.var_4a02[j][0], this.var_4a02[j][1], paramInt)) {
				i++;
			}
		}
		return i;
	}

	private int countSomeTeamUnitsOfType(int inUnitType, int paramInt2, byte inTeamId) {
		int count = 0;
		int index = 0;
		int unitsCount = this.mapUnitsMaybe.size();
		while (index < unitsCount) {
			A_Unit unit = (A_Unit) this.mapUnitsMaybe
					.elementAt(index);
			if (((inUnitType == -1) || (unit.unitType == inUnitType))
					&& (((paramInt2 == -1) && (unit.var_e83 != 3)) || ((paramInt2 == unit.var_e83) && ((inTeamId == -1) || (unit.teamId == inTeamId))))) {
				count++;
			}
			index++;
		}
		return count;
	}

	private A_Unit[] getSomeUnitsOfTypeOfTeam(int inUnitType, int paramInt2,
			byte inTeamId) {
		Vector list = new Vector();
		int i = 0;
		int unitsCount = this.mapUnitsMaybe.size();
		while (i < unitsCount) {
			A_Unit unit = (A_Unit) this.mapUnitsMaybe
					.elementAt(i);
			if (((inUnitType == -1) || (unit.unitType == inUnitType))
					&& (((paramInt2 == -1) && (unit.var_e83 != 3)) || ((paramInt2 == unit.var_e83) && ((inTeamId == -1) || (unit.teamId == inTeamId))))) {
				list.addElement(unit);
			}
			i++;
		}
		A_Unit[] units = new A_Unit[list
				.size()];
		list.copyInto(units);
		return units;
	}

	private static void sub_11f87(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, D_ImageWrap image,
			int paramInt4, int paramInt5, int paramInt6) {
		paramInt2 = image.imageWidth;
		paramInt3 = image.imageHeight;
		int i = paramInt2 / 2;
		paramInt3 = paramInt3;
		int j = paramInt2 * paramInt1 / 40;
		paramInt2 = paramInt2 * (40 - paramInt1) / 160;
		paramInt1 = paramInt1 * 360 / 40;
		paramInt6 = paramInt6 * 360 / paramInt3;
		for (int k = 0; k < paramInt3; k++) {
			int m = paramInt2 * F_StringManager.sub_f0f(paramInt1) >> 10;
			paramGraphics.setClip(paramInt4 + i - j / 2 + m, paramInt5 + k, j,
					1);
			image.drawOnGraphics(paramGraphics, paramInt4 + m, paramInt5);
			paramInt1 += paramInt6;
		}
	}

	private static void sub_12052(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5,
			int paramInt6, int paramInt7, int paramInt8) {
		paramInt3 = paramInt7 / 8 + 1;
		for (paramInt5 = 0; paramInt5 < 8; paramInt5++) {
			if ((paramInt6 = paramInt2 - paramInt5) < 0) {
				paramInt6 = 0;
			}
			if (paramInt6 >= 9) {
				paramInt6 = paramInt3;
			} else {
				paramInt6 = paramInt3 * paramInt6 / 9;
			}
			if (paramInt4 == 1) {
				paramInt7 = paramInt5 * paramInt3 + paramInt6;
				paramInt6 = paramInt3 - paramInt6;
			} else {
				paramInt7 = paramInt5 * paramInt3;
			}
			int i = paramInt6 * 255 / paramInt3;
			C_MainCanvas.setGraphicsColor(paramGraphics, i << 24 | paramInt1);
			for (i = 0; i <= 0; i++) {
				paramGraphics.fillRect(paramInt7 + 0, 0, paramInt6, paramInt8);
			}
		}
	}

	private boolean sub_12199(byte paramByte, int paramInt1, int paramInt2) {
		if ((this.var_45f2 > countSomeTeamUnitsOfType(-1, -1, this.currentPlayerId)
				- countSomeTeamUnitsOfType(10, -1, this.currentPlayerId))
				&& (paramByte <= this.var_49ca)
				&& (A_Unit.unitsCost[paramByte] <= this.var_486a[this.currentPlayerId])
				&& (A_Unit.unitsCost[paramByte] > 0)) {
			sub_bcb2(this.var_47da, 0);
			return A_Unit.canMoveSomeWhereMB(this.var_47da, paramInt1, paramInt2,
					A_Unit.unitsMoveRange[paramByte], -1, paramByte,
					this.currentPlayerId, true);
		}
		return false;
	}

	private boolean sub_12226(A_Unit paramClass_a_0260, int paramInt1,
			int paramInt2) {
		if ((this.var_45f2 > countSomeTeamUnitsOfType(-1, -1, this.currentPlayerId)
				- countSomeTeamUnitsOfType(10, -1, this.currentPlayerId))
				&& ((paramClass_a_0260.unitType <= this.var_49ca) || (paramClass_a_0260.unitType == 9))
				&& (paramClass_a_0260.cost <= this.var_486a[this.currentPlayerId])) {
			sub_bcb2(this.var_47da, 0);
			return A_Unit.canMoveSomeWhereMB(this.var_47da, paramInt1, paramInt2,
					A_Unit.unitsMoveRange[paramClass_a_0260.unitType], -1,
					paramClass_a_0260.unitType, this.currentPlayerId, true);
		}
		return false;
	}

	private void sub_122cc() {
		A_Unit[] units = getSomeUnitsOfTypeOfTeam(-1, 0, this.currentPlayerId);
		this.var_4dc2 = new Vector(units.length);
		for (int i = 0; i < units.length; i++) {
			int j = 0;
			while (j < i) {
				A_Unit unit = (A_Unit) this.var_4dc2
						.elementAt(j);
				int k = var_4d1a[unit.unitType];
				int m;
				if (((m = var_4d1a[units[i].unitType]) >= k)
						&& ((m != k) || (units[i].health >= unit.health))) {
					j++;
				} else {
					this.var_4dc2.insertElementAt(units[i], j);
				}
			}
			if (j == i) {
				this.var_4dc2.addElement(units[i]);
			}
		}
		this.aSomeUnitsArr = new A_Unit[this.somePositionsOrTilesData.length];
		this.var_4d72 = new byte[this.somePositionsOrTilesData.length];
		A_Unit.unitSpeed = A_Unit.unitSpeedFastVal;
		this.var_4d52 = 0;
		this.var_4d22 = 0;
	}

	private void sub_1240c() {
		if (F_StringManager.mainCanvas.sub_26d7(var_4602)) {
			sub_6d11(this.var_4652, this.someCanHeightDiv2, this.someCanHeight, this);
			F_StringManager.mainCanvas.clearActionCodesMb();
			return;
		}
		if (this.var_4d22 == 4) {
			if ((this.var_4d3a == null) && (this.var_4d42 == null)) {
				int i;
				if (canOccupyVillageOrTownMaybe(this.someActiveUnit)) {
					i = sub_14272(this.someActiveUnit.posX, this.someActiveUnit.posY);
					if ((this.var_4dba != -1) && (this.var_4dba != i)) {
						this.aSomeUnitsArr[this.var_4dba] = this.aSomeUnitsArr[i];
						this.aSomeUnitsArr[i] = this.someActiveUnit;
					}
					changeTileToOccupiedByTeam(this.someActiveUnit.posX, this.someActiveUnit.posY,
							this.var_4832[this.someActiveUnit.teamId]);
					String occupyMsg = F_StringManager.getLangString(73);
					int showTime = 1000;
					F_StringManager.mainCanvas.showMessageBox(newMessageBox(null, occupyMsg,
							this.someCanHeight, showTime)); //OCCUPIED!
					C_MainCanvas.playMusicLooped(9, 1); // game complete?
					this.gameState = 9;
					this.var_481a = this.someGameTime;
				} else if (canOccupyVillageMaybe(this.someActiveUnit)) {
					i = sub_14272(this.someActiveUnit.posX, this.someActiveUnit.posY);
					if ((this.var_4dba != -1) && (this.var_4dba != i)) {
						this.aSomeUnitsArr[this.var_4dba] = this.aSomeUnitsArr[i];
						this.aSomeUnitsArr[i] = this.someActiveUnit;
					}
					setMapTileId((byte) 37, this.someActiveUnit.posX,
							this.someActiveUnit.posY);
					F_StringManager.mainCanvas.showMessageBox(newMessageBox(null,
							F_StringManager.getLangString(74), this.someCanHeight, 1000));
					C_MainCanvas.playMusicLooped(9, 1);
					this.gameState = 0;
					this.var_481a = this.someGameTime;
				} else {
					this.gameState = 0;
				}
				this.someActiveUnit.sub_26fe();
				this.someActiveUnit = null;
				this.var_4d22 = 0;
			} else {
				this.var_4d22 = 5;
				this.someActiveUnit.setAttackMaskForPosition(this.var_47da, this.someActiveUnit.posX,
						this.someActiveUnit.posY);
				this.var_47ea = true;
				this.var_47e2 = true;
				this.var_4d5a = this.someGameTime;
				if (this.var_4d3a != null) {
					this.cursorSprite.setFrameSequence(frameSequencesCursorMb[1]);
					moveCursorToPos(this.var_4d3a.posX, this.var_4d3a.posY);
				} else if (this.var_4d42 != null) {
					moveCursorToPos(this.var_4d42.posX, this.var_4d42.posY);
				}
			}
			this.isCursorVisible = true;
			return;
		}
		if (this.var_4d22 == 5) {
			if (this.someGameTime - this.var_4d5a >= 500L) {
				if (this.var_4d3a != null) {
					sub_6994(this.someActiveUnit, this.var_4d3a);
				} else if (this.var_4d42 != null) {
					sub_ed9f(this.var_4d42, this.currentPlayerId);
					this.var_4d42 = null;
					this.var_4d22 = 7;
					this.someActiveUnit.sub_26fe();
				}
				this.var_47e2 = false;
				this.var_47ea = false;
			}
		} else if (this.var_4d22 == 7) {
			if (this.selectedTombUnit == null) {
				this.var_4d22 = 0;
				this.gameState = 0;
			}
		} else if (this.var_4d22 == 6) {
			if (this.someGameTime - this.var_4d5a >= 1000L) {
				this.var_4d3a = null;
				this.var_4d22 = 0;
				this.gameState = 0;
			}
		} else {
			if (this.var_4d22 == 2) {
				return;
			}
			if (this.var_4d22 == 3) {
				if (this.var_4d52 == 0) {
					if (sub_ee3c(this.someActiveUnit.pixelX + 12, this.someActiveUnit.pixelY + 12)) // m
					{
						if ((this.scenarioModeIf0 == 0) && (this.scenarioMapIndex == 7)
								&& (this.someActiveUnit == this.maybeTeamKings[1])) {
							this.var_4c6a = null;
							A_Unit[] loo = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);
							if (loo.length > 0) {
								sub_6963(loo[C_MainCanvas
										.getRandomMax(loo.length)]);
							}
							this.var_4d22 = 4;
							return;
						}
						this.var_4d52 = 1;
						this.var_4d5a = this.someGameTime;
					}
				} else if (this.var_4d52 == 1) {
					if (this.someGameTime - this.var_4d5a >= 100L) {
						this.var_47e2 = true;
						this.var_47ea = false;
						this.var_4d52 = 2;
						this.gameState = 1;
						this.var_4d5a = this.someGameTime;
					}
				} else if (this.var_4d52 == 2) {
					if (this.someGameTime - this.var_4d5a >= 200L) {
						this.cursorPosX = this.var_4d2a;
						this.cursorPosY = this.var_4d32;
						this.cursorSprite.setPixelPosition(this.var_4d2a * 24,
								this.var_4d32 * 24);
						this.somePositions = this.someActiveUnit.sub_1ef5(
								this.someActiveUnit.posX, this.someActiveUnit.posY,
								this.cursorPosX, this.cursorPosY);
						this.var_4d52 = 3;
						this.var_4d5a = this.someGameTime;
					}
				} else if ((this.var_4d52 == 3)
						&& (this.someGameTime - this.var_4d5a >= 200L)) {
					this.somePositions = null;
					this.someActiveUnit.setHiddenPositions(this.var_4d2a, this.var_4d32, true);
					this.var_4d22 = 2;
					this.var_4d52 = 0;
					this.gameState = 2;
				}
				return;
			}
			if (this.var_4dc2.size() == 0) {
				Object localObject = null;
				int j = 0;
				int k = 6666;
				int m = 0;
				int n = 0;
				int i4;
				int i2;
				int i5;
				int i7;
				for (int i1 = 0; i1 < this.somePositionsOrTilesData.length; i1++) {
					i4 = this.somePositionsOrTilesData[i1][0];
					i2 = this.somePositionsOrTilesData[i1][1];
					if ((getMapTileType(i4, i2) == 9)
							&& (sub_11cae(i4, i2, this.currentPlayerId))) {
						if (j == 0) {
							m = i4;
							n = i2;
						}
						j++;
						i5 = 0;
						int i8;
						for (int i6 = this.mapUnitsMaybe.size() - 1; i6 >= 0; i6--) {
							A_Unit localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
									.elementAt(i6);
							if ((this.var_483a[localClass_a_0260.teamId] != this.var_483a[this.currentPlayerId])
									&& (localClass_a_0260.hasProperty((short) 16))) {
								if ((i8 = Math.abs(localClass_a_0260.posX
										- i4)
										+ Math.abs(localClass_a_0260.posY
												- i2)) < k) {
									k = i8;
									m = i4;
									n = i2;
								}
								i5++;
							}
						}
						if (i5 == 0) {
							for (int i6 = 0; i6 < this.somePositionsOrTilesData.length; i6++) {
								i7 = this.somePositionsOrTilesData[i6][0];
								i8 = this.somePositionsOrTilesData[i6][1];
								if ((getMapTileType(i7, i8) == 9)
										&& (!sub_11cae(i7, i8, this.currentPlayerId))
										&& ((i5 = Math.abs(i7 - i4)
												+ Math.abs(i8 - i2)) < k)) {
									k = i5;
									m = i4;
									n = i2;
								}
							}
						}
					}
				}
				if (j > 0) {
					int i1;
					for (i1 = 0; i1 < this.teamsUnitsCount[this.currentPlayerId]; i1++) {
						if ((this.teamsUnits[this.currentPlayerId][i1] != null)
								&& (this.teamsUnits[this.currentPlayerId][i1].var_e83 == 3)
								&& (sub_12226(
										this.teamsUnits[this.currentPlayerId][i1], m, n))) {
							localObject = sub_abab(
									this.teamsUnits[this.currentPlayerId][i1], m, n);
						}
					}
					if (localObject == null) {
						if ((countSomeTeamUnitsOfType(0, -1, this.currentPlayerId) < 2)
								&& (sub_12199((byte) 0, m, n))) {
							localObject = sub_ac11((byte) 0, m, n);
						} else if ((countSomeTeamUnitsOfType(1, -1, this.currentPlayerId) < 2)
								&& (sub_12199((byte) 1, m, n))) {
							localObject = sub_ac11((byte) 1, m, n);
						} else {
							i1 = 0;
							i4 = 0;
							int i3;
							for ( byte i21 = 0; i21 < this.teamsCountMaybe; i3 = (byte) (i21 + 1)) {
								if (this.var_483a[i21] == this.var_483a[this.currentPlayerId]) {
									i1 += countSomeTeamUnitsOfType(-1, -1, i21);
								} else {
									i4 += countSomeTeamUnitsOfType(-1, -1, i21);
								}
							}
							if ((this.var_486a[this.currentPlayerId] >= 1000)
									|| (countSomeTeamUnitsOfType(-1, -1, this.currentPlayerId) < 8)
									|| (i1 < i4)) {
								i5 = 0;
								byte[] arrayOfByte = new byte[12];
								byte b;
								for (byte i71 = 1; i71 < 12; b = (byte) (i71 + 1)) {
									if (((countSomeTeamUnitsOfType(i71, -1, this.currentPlayerId) <= 0) || (A_Unit.unitsCost[i71] >= 600))
											&& (sub_12199(i71, m, n))) {
										arrayOfByte[i5] = i71;
										i5++;
									}
								}
								if (i5 > 0) {
									b = arrayOfByte[(Math.abs(C_MainCanvas
											.getRandomNumber()) % i5)];
									localObject = sub_ac11(b, m, n);
								}
							}
						}
					}
				}
				if (localObject != null) {
					sub_12e7e((A_Unit) localObject);
					return;
				}
				this.var_4d62 = null;
				this.var_4dc2 = null;
				sub_11699();
				return;
			}
			if ((this.scenarioModeIf0 == 0) && (this.scenarioMapIndex == 7)
					&& (this.maybeTeamKings[1].var_e83 != 2)) {
				this.someActiveUnit = this.maybeTeamKings[1];
				moveCursorToPos(this.someActiveUnit.posX, this.someActiveUnit.posY);
				this.var_4c6a = this.someActiveUnit;
				this.var_4d22 = 3;
				this.var_4dc2.removeElement(this.someActiveUnit);
				return;
			}
			Object localObject = this.var_4d4a;
			if (this.var_4d4a == null) {
				localObject = (A_Unit) this.var_4dc2.elementAt(0);
			}
			sub_12e7e((A_Unit) localObject);
			if (this.var_4d4a == null) {
				this.var_4dc2.removeElement(localObject);
			}
		}
	}

	private void sub_12e7e(A_Unit paramClass_a_0260) {
		this.someActiveUnit = paramClass_a_0260;
		this.isCursorVisible = true;
		sub_bcb2(this.var_47da, 0);
		this.someActiveUnit.fillWhereUnitCanMove(this.var_47da);
		this.var_47e2 = false;
		this.var_4d62 = getSomeUnitsOfTypeOfTeam(0, -1, this.currentPlayerId);
		int i = 0;
		int j = this.maybeTeamKings.length + this.var_4d62.length
				+ this.somePositionsOrTilesData.length;
		this.var_4d7a = new int[j][5];
		this.var_4d8a = 0;
		j = 10000;
		this.var_4da2 = -1;
		this.var_4daa = -1;
		this.var_4db2 = -1;
		this.var_4dba = -1;
		for (int k = 0; k < this.var_4d62.length + this.maybeTeamKings.length; k++) {
			A_Unit localClass_a_02601 = null;
			if (k >= this.var_4d62.length) {
				if ((localClass_a_02601 = this.maybeTeamKings[(k - this.var_4d62.length)]) != null) {
					if (localClass_a_02601.var_e83 == 3) {
						localClass_a_02601 = null;
					} else if ((this.var_483a[localClass_a_02601.teamId] != this.var_483a[this.currentPlayerId])
							&& (this.maybeTeamKings[this.currentPlayerId] == null)) {
						this.var_4d7a[i][2] += (localClass_a_02601.getUnitTotalExpGainMb(
								localClass_a_02601.posX,
								localClass_a_02601.posY, null) << 1);
					} else if ((this.currentTurn >= 15)
							&& (this.var_483a[localClass_a_02601.teamId] != this.var_483a[this.currentPlayerId])
							&& (countSomeTeamUnitsOfType(-1, -1, localClass_a_02601.teamId) < 4)
							&& (countSomeTeamUnitsOfType(-1, -1, this.currentPlayerId) >= 8)) {
						this.var_4d7a[i][2] += (localClass_a_02601.getUnitTotalExpGainMb(
								localClass_a_02601.posX,
								localClass_a_02601.posY, null) << 1);
					} else if (localClass_a_02601.teamId != this.currentPlayerId) {
						localClass_a_02601 = null;
					}
				}
			} else if (this.maybeTeamKings[this.currentPlayerId] != null) {
				localClass_a_02601 = this.var_4d62[k];
			}
			if (localClass_a_02601 != null) {
				this.var_4d7a[i][0] = localClass_a_02601.posX;
				this.var_4d7a[i][1] = localClass_a_02601.posY;
				if (localClass_a_02601.teamId == this.currentPlayerId) {
					A_Unit[] arrayOfClass_a_02601 = localClass_a_02601
							.getUnitsInAttackRange(localClass_a_02601.posX,
									localClass_a_02601.posY, 1, 5, (byte) 0);
					for (int m = 0; m < arrayOfClass_a_02601.length; m++) {
						if (arrayOfClass_a_02601[m].var_e83 != 4) {
							this.var_4d7a[i][2] += arrayOfClass_a_02601[m]
									.getUnitTotalExpGainMb(arrayOfClass_a_02601[m].posX,
											arrayOfClass_a_02601[m].posY,
											localClass_a_02601);
						}
					}
				}
				if (this.var_4d7a[i][2] > 0) {
					this.var_4d7a[i][4] += localClass_a_02601.getUnitTotalExpGainMb(
							localClass_a_02601.posX,
							localClass_a_02601.posY, null);
					this.var_4d7a[i][4] += localClass_a_02601.var_f03;
					if (this.var_4d7a[i][2] > this.var_4d8a) {
						this.var_4d8a = this.var_4d7a[i][2];
					}
					this.var_4d7a[i][3] = (Math.abs(localClass_a_02601.posX
							- paramClass_a_0260.posX) + Math
							.abs(localClass_a_02601.posY
									- paramClass_a_0260.posY));
					if (this.var_4d7a[i][3] <= 0) {
						this.var_4d7a[i][3] = 1;
					}
					if (this.var_4d7a[i][3] < j) {
						j = this.var_4d7a[i][3];
					}
				} else {
					this.var_4d7a[i][2] = -6666;
				}
			} else {
				this.var_4d7a[i][2] = -6666;
			}
			i++;
		}
		int k = 666;
		int n = 666;
		int i1 = -1;
		int m = -1;
		int i8;
		for (int i2 = 0; i2 < this.somePositionsOrTilesData.length; i2++) {
			int i6 = this.somePositionsOrTilesData[i2][0];
			int i7 = this.somePositionsOrTilesData[i2][1];
			i8 = getMapTileType(i6, i7);
			boolean bool = sub_11cae(i6, i7, paramClass_a_0260.teamId);
			this.var_4d7a[i][2] = -6666;
			if ((bool) || (this.aSomeUnitsArr[i2] != null)) {
				A_Unit[] arrayOfClass_a_02602 = paramClass_a_0260
						.getUnitsInAttackRange(i6, i7, 1, 5, (byte) 0);
				this.var_4d7a[i][0] = i6;
				this.var_4d7a[i][1] = i7;
				this.var_4d7a[i][2] = 0;
				for (int i3 = 0; i3 < arrayOfClass_a_02602.length; i3++) {
					if ((arrayOfClass_a_02602[i3].var_e83 != 4)
							&& (((this.aSomeUnitsArr[i2] != null) && (!bool))
									|| ((i8 == 8) && (arrayOfClass_a_02602[i3]
											.hasProperty((short) 8))) || ((i8 == 9) && (arrayOfClass_a_02602[i3]
									.hasProperty((short) 16))))) {
						this.var_4d7a[i][2] += arrayOfClass_a_02602[i3]
								.getUnitTotalExpGainMb(arrayOfClass_a_02602[i3].posX,
										arrayOfClass_a_02602[i3].posY, null);
					}
				}
				if (this.var_4d7a[i][2] == 0) {
					if ((this.aSomeUnitsArr[i2] != null) && (!bool)) {
						this.var_4d7a[i][2] = 100;
						this.var_4d7a[i][4] += 2000;
					} else {
						this.var_4d7a[i][2] = -6666;
					}
				}
				if (this.var_4d7a[i][2] != -6666) {
					this.var_4d7a[i][4] += this.var_4d82[i2];
					if (this.var_4d7a[i][2] > this.var_4d8a) {
						this.var_4d8a = this.var_4d7a[i][2];
					}
					this.var_4d7a[i][3] = (Math.abs(i6
							- paramClass_a_0260.posX) + Math.abs(i7
							- paramClass_a_0260.posY));
					if (this.var_4d7a[i][3] <= 0) {
						this.var_4d7a[i][3] = 1;
					}
					if (this.var_4d7a[i][3] < j) {
						j = this.var_4d7a[i][3];
					}
				}
			}
			if (sub_11c55(i6, i7, this.var_483a[paramClass_a_0260.teamId])) {
				A_Unit localClass_a_02602;
				int i4;
				if ((((localClass_a_02602 = getUnitAtPos(i6, i7, (byte) 0)) == null) || (localClass_a_02602.teamId == paramClass_a_0260.teamId))
						&& ((i4 = Math.abs(i6 - paramClass_a_0260.posX)
								+ Math.abs(i7 - paramClass_a_0260.posY)) < n)) {
					m = i2;
					n = i4;
				}
			} else if (((this.aSomeUnitsArr[i2] == null) || (this.aSomeUnitsArr[i2] == paramClass_a_0260))
					&& (((i8 == 8) && (paramClass_a_0260.hasProperty((short) 8))) || ((i8 == 9) && (paramClass_a_0260
							.hasProperty((short) 16))))) {
				int i10;
				if ((i10 = Math.abs(i6 - paramClass_a_0260.posX)
						+ Math.abs(i7 - paramClass_a_0260.posY)) < k) {
					i1 = i2;
					k = i10;
				}
				A_Unit localClass_a_02605 = getUnitAtPos(i6, i7, (byte) 0);
				if ((i10 < n)
						&& (this.var_47da[i6][i7] > 0)
						&& ((localClass_a_02605 == null) || (localClass_a_02605.teamId == paramClass_a_0260.teamId))) {
					m = i2;
					n = i10;
				}
			}
			i++;
		}
		if ((paramClass_a_0260.health < 50) && (m != -1)) {
			if (m == i1) {
				this.var_4dba = i1;
			}
			this.aSomeUnitsArr[m] = paramClass_a_0260;
			this.var_4da2 = this.somePositionsOrTilesData[m][0];
			this.var_4daa = this.somePositionsOrTilesData[m][1];
			sub_bcb2(this.var_4d92, 0);
			A_Unit.canMoveSomeWhereMB(this.var_4d92, this.var_4da2, this.var_4daa,
					10, -1, paramClass_a_0260.unitType, this.currentPlayerId, false);
		} else if ((this.maybeTeamKings[this.currentPlayerId] != null)
				&& (i1 != -1)
				&& ((paramClass_a_0260.hasProperty((short) 8)) || (paramClass_a_0260
						.hasProperty((short) 16)))) {
			this.var_4dba = i1;
			this.aSomeUnitsArr[i1] = paramClass_a_0260;
			this.var_4da2 = this.somePositionsOrTilesData[i1][0];
			this.var_4daa = this.somePositionsOrTilesData[i1][1];
			sub_bcb2(this.var_4d92, 0);
			A_Unit.canMoveSomeWhereMB(this.var_4d92, this.var_4da2, this.var_4daa,
					10, -1, paramClass_a_0260.unitType, this.currentPlayerId, false);
		} else {
			int i2 = -1;
			int i6 = -6666;
			for (int i7 = 0; i7 < i; i7++) {
				if (this.var_4d7a[i7][2] > -6666) {
					if (this.var_4d7a[i7][2] > 0) {
						this.var_4d7a[i7][2] = (this.var_4d7a[i7][2] * j / this.var_4d7a[i7][3]);
					}
					this.var_4d7a[i7][2] -= this.var_4d7a[i7][4];
					if (this.var_4d7a[i7][2] > i6) {
						i6 = this.var_4d7a[i7][2];
						i2 = i7;
					}
				}
			}
			if (i2 != -1) {
				int i7 = paramClass_a_0260.getUnitTotalExpGainMb(paramClass_a_0260.posX,
						paramClass_a_0260.posY, null);
				if (i2 < this.var_4d62.length) {
					this.var_4d62[i2].var_f03 += i7;
				} else if (i2 < this.maybeTeamKings.length + this.var_4d62.length) {
					this.maybeTeamKings[(i2 - this.var_4d62.length)].var_f03 += i7;
				} else {
					this.var_4db2 = (i2 - this.maybeTeamKings.length - this.var_4d62.length);
					this.var_4d82[this.var_4db2] += i7;
				}
				this.var_4da2 = this.var_4d7a[i2][0];
				this.var_4daa = this.var_4d7a[i2][1];
				sub_bcb2(this.var_4d92, 0);
				A_Unit.canMoveSomeWhereMB(this.var_4d92, this.var_4da2,
						this.var_4daa, 10, -1, paramClass_a_0260.unitType,
						this.currentPlayerId, false);
			}
		}
		int i2 = -10000;
		int i6 = 0;
		int i7 = this.var_47da.length;
		while (i6 < i7) {
			i8 = 0;
			int i9 = this.var_47da[i6].length;
			while (i8 < i9) {
				A_Unit localClass_a_02603;
				if ((this.var_47da[i6][i8] > 0)
						&& (((localClass_a_02603 = getUnitAtPos(i6, i8, (byte) 0)) == null)
								|| (localClass_a_02603 == paramClass_a_0260) || ((this.var_4d4a == null)
								&& (localClass_a_02603.teamId == paramClass_a_0260.teamId) && (localClass_a_02603.var_e83 == 0)))) {
					int i5;
					if ((!paramClass_a_0260.hasProperty((short) 512))
							|| (localClass_a_02603 == paramClass_a_0260)) {
						A_Unit[] arrayOfClass_a_02603 = paramClass_a_0260
								.getUnitsInAttackRange1(i6, i8, (byte) 0);
						for (int i12 = 0; i12 < arrayOfClass_a_02603.length; i12++) {
							if ((i5 = sub_13d9e(paramClass_a_0260, i6, i8,
									arrayOfClass_a_02603[i12], null)) > i2) {
								this.var_4d42 = null;
								this.var_4d3a = arrayOfClass_a_02603[i12];
								i2 = i5;
								this.var_4d2a = i6;
								this.var_4d32 = i8;
							}
						}
					}
					if (paramClass_a_0260.hasProperty((short) 32)) {
						this.var_47ba = paramClass_a_0260.getUnitsInAttackRange1(i6, i8,
								(byte) 1);
						for (int i11 = 0; i11 < this.var_47ba.length; i11++) {
							if ((i5 = sub_13d9e(paramClass_a_0260, i6, i8,
									null, this.var_47ba[i11])) > i2) {
								this.var_4d3a = null;
								this.var_4d42 = this.var_47ba[i11];
								i2 = i5;
								this.var_4d2a = i6;
								this.var_4d32 = i8;
							}
						}
					}
					if ((i5 = sub_13d9e(paramClass_a_0260, i6, i8, null, null)) > i2) {
						this.var_4d3a = null;
						this.var_4d42 = null;
						i2 = i5;
						this.var_4d2a = i6;
						this.var_4d32 = i8;
					}
				}
				i8++;
			}
			i6++;
		}
		if (this.var_4dba != -1) {
			this.var_4d72[this.var_4dba] = ((byte) (10 - this.var_4d92[this.var_4d2a][this.var_4d32]));
		}
		this.var_4d4a = null;
		A_Unit localClass_a_02604;
		if (((localClass_a_02604 = getUnitAtPos(this.var_4d2a, this.var_4d32,
				(byte) 0)) != null)
				&& (localClass_a_02604 != paramClass_a_0260)) {
			this.var_4d4a = localClass_a_02604;
			this.var_4d22 = 0;
			return;
		}
		moveCursorToPos(paramClass_a_0260.posX, paramClass_a_0260.posY);
		this.var_4c6a = paramClass_a_0260;
		this.var_4d22 = 3;
	}

	private int sub_13d9e(A_Unit paramClass_a_02601, int paramInt1,
			int paramInt2, A_Unit paramClass_a_02602,
			A_Unit paramClass_a_02603) {
		int i = 0;
		int k;
		if ((this.var_4dba != -1)
				&& (this.maybeTeamKings[paramClass_a_02601.teamId] != null)) {
			if (this.var_4da2 != -1) {
				if (this.var_4d92[paramInt1][paramInt2] > 0) {
					i = 100 + 100 * this.var_4d92[paramInt1][paramInt2] / 10;
				} else {
					int j = Math
							.abs(this.var_4da2 - paramClass_a_02601.posX)
							+ Math.abs(this.var_4daa
									- paramClass_a_02601.posY);
					k = Math.abs(this.var_4da2 - paramInt1)
							+ Math.abs(this.var_4daa - paramInt2);
					i = 0 + 100 * (j - k) / (paramClass_a_02601.moveRange - 1);
					if (tilesTypes[getMapTileType(paramInt1, paramInt2)] <= 1) {
						i += 20;
					}
				}
			}
			if ((paramClass_a_02602 == null)
					&& (!sub_11c55(paramInt1, paramInt2,
							this.var_483a[paramClass_a_02601.teamId]))) {
				if ((paramClass_a_02601.hasProperty((short) 16))
						&& (getMapTileType(paramInt1, paramInt2) == 9)) {
					i += 300;
				} else if ((paramClass_a_02601.hasProperty((short) 8))
						&& ((getMapTileType(paramInt1, paramInt2) == 8) || (this.mapTilesIds[paramInt1][paramInt2] == 27))) {
					i += 200;
				}
			}
		}
		switch (paramClass_a_02601.unitType) {
		case 2:
			if (getMapTileType(paramInt1, paramInt2) == 5) {
				i += 25;
			}
			break;
		case 3:
			if (paramClass_a_02603 != null) {
				i += 100;
			}
			break;
		case 4:
			A_Unit[] arrayOfClass_a_0260 = paramClass_a_02601.getUnitsInAttackRange(
					paramInt1, paramInt2, 1, 2, (byte) 2);
			if (paramClass_a_02603 != null) {
				i += 25 * arrayOfClass_a_0260.length;
			}
			break;
		}
		if (paramClass_a_02602 != null) {
			if (paramClass_a_02602.var_e83 == 4) {
				int j = sub_11bae(paramClass_a_02602.posX,
						paramClass_a_02602.posY);
				k = sub_14272(paramClass_a_02602.posX,
						paramClass_a_02602.posY);
				if ((j != 0) && (k != -1) && (this.aSomeUnitsArr[k] == null)) {
					i += paramClass_a_02601.getUnitTotalExpGainMb(paramInt1, paramInt2,
							paramClass_a_02602) / 2;
				}
			} else {
				if (!paramClass_a_02602.canAttackPosition(paramInt1, paramInt2)) {
					i += (paramClass_a_02601.getUnitTotalExpGainMb(paramInt1, paramInt2,
							paramClass_a_02602) << 1);
				} else {
					i += paramClass_a_02601.getUnitTotalExpGainMb(paramInt1, paramInt2,
							paramClass_a_02602)
							* 3
							/ 2
							- paramClass_a_02602.getUnitTotalExpGainMb(paramInt1, paramInt2,
									paramClass_a_02601);
				}
				if (paramClass_a_02602.unitType == 9) {
					i += 25;
				} else if (paramClass_a_02602.unitType == 11) {
					i += 100;
				}
			}
		}
		i += tilesExtraDefence[getMapTileType(paramInt1, paramInt2)];
		if ((paramClass_a_02601.health < 100)
				&& (sub_11c55(paramInt1, paramInt2,
						this.var_483a[paramClass_a_02601.teamId]))) {
			i += 100 - paramClass_a_02601.health;
		}
		int j = sub_14272(paramInt1, paramInt2);
		int m;
		if (this.var_4d92[paramInt1][paramInt2] > 0) {
			k = this.var_4d92[paramInt1][paramInt2];
			m = 10 - paramClass_a_02601.moveRange / 2;
			if (k > m) {
				k = m;
			}
			i += 50 + k * 100 / m;
		} else if (this.var_4da2 != -1) {
			k = Math.abs(this.var_4da2 - paramClass_a_02601.posX)
					+ Math.abs(this.var_4daa - paramClass_a_02601.posY);
			m = Math.abs(this.var_4da2 - paramInt1)
					+ Math.abs(this.var_4daa - paramInt2);
			i += 50 * (k - m) / (paramClass_a_02601.moveRange - 1);
		}
		if ((j != -1) && ((paramClass_a_02602 = this.aSomeUnitsArr[j]) != null)
				&& (paramClass_a_02602 != paramClass_a_02601)
				&& (paramClass_a_02602.var_e83 == 0)
				&& (this.var_4d72[j] < paramClass_a_02602.moveRange)) {
			i -= 200;
		}
		return i
				+ 20
				* (Math.abs(paramInt1 - paramClass_a_02601.posX) + Math
						.abs(paramInt2 - paramClass_a_02601.posY))
				/ (paramClass_a_02601.moveRange - 1);
	}

	private int sub_14272(int paramInt1, int paramInt2) {
		for (int i = 0; i < this.somePositionsOrTilesData.length; i++) {
			if ((this.somePositionsOrTilesData[i][0] == paramInt1)
					&& (this.somePositionsOrTilesData[i][1] == paramInt2)) {
				return i;
			}
		}
		return -1;
	}

	private void waitScript(int waitTimein) {
		this.waitTime = waitTimein;
		this.isWaiting = true;
	}

	private E_Menu showUnitDialog(String message, byte paramByte1,
			byte paramByte2) {
		E_Menu cll = new E_Menu((byte) 7, 12);
		int i = C_MainCanvas.var_1767 * 3;
		cll.sub_19f5(message, this.canvasWidth, i, paramByte1);
		cll.setLocation(0, this.canvasHeight - i, 0);
		F_StringManager.mainCanvas.showMessageBox(cll);
		return cll;
	}

	private E_Menu newMessageBox(String header, String message,
			int canvHeight, int showTime) {
		return sub_1437e(header, message, canvHeight, -1, showTime);
	}

	private E_Menu sub_1437e(String header, String message,
			int canvHeight, int paramInt2, int showTime) {
		E_Menu msgBox = new E_Menu((byte) 10, 12);
		msgBox.initMessageBox(header, message, this.canvasWidth, paramInt2);
		msgBox.setLocation(this.canvasWidthShift, canvHeight / 2, 3);
		msgBox.stringManager = this;
		msgBox.showTime = showTime;
		return msgBox;
	}

	private void initMap() {
		this.var_4e02 = null;
		if (this.scenarioModeIf0 == 0) {
			this.statusBarOffset = var_4592;
			this.var_4a5a = true;
			this.isGameActive = false;
			this.mapStartUpMessageBox = newMessageBox(null, this.mapStartUpMessage, this.canvasHeight, 2000);
			this.mapStartUpMessageBox.setLocation(this.canvasWidthShift, this.canvasHeightShift, 3);
			this.fadeEnabled = true;
			this.var_4ad2 = true;
			this.fadeValue = 0;
		}
		if (this.scenarioMapIndex == 0) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			A_Unit.unitSpeed = 4;
			this.mapStepMax = 2;
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			initIntro(2, 3, 3);
			C_MainCanvas.playMusic2(1, 1);
			this.fadeEnabled = false;
			this.isCursorVisible = false;
			this.aState = 0;
			return;
		}
		if (this.scenarioMapIndex == 1) {
			this.var_49ca = 1;
			this.var_486a[0] = 300;
			this.var_486a[1] = 50;
			A_Unit.unitSpeed = 4;
			this.mapStepMax = 2;
			this.maybeTeamKings[0].setKingName(2);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			getUnitAtPos(7, 12, (byte) 0).setHiddenPositions(7, 10, false);
			getUnitAtPos(8, 11, (byte) 0).setHiddenPositions(8, 9, false);
			getUnitAtPos(9, 12, (byte) 0).setHiddenPositions(9, 10, false);
			sub_186a6(7, 3);
			F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			return;
		}
		if (this.scenarioMapIndex == 2) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			A_Unit.unitSpeed = 4;
			this.var_486a[0] = 0;
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			this.var_4de2 = getUnitAtPos(8, 17, (byte) 0);
			this.var_4dea = getUnitAtPos(8, 18, (byte) 0);
			this.var_4df2 = getUnitAtPos(8, 19, (byte) 0);
			this.var_4de2.setHiddenPositions(8, 15, false);
			this.var_4dea.setHiddenPositions(8, 15, false);
			this.var_4df2.setHiddenPositions(8, 15, false);
			this.maybeTeamKings[0].setHiddenPositions(8, 14, false);
			this.isCursorVisible = false;
			F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			this.aState = 0;
			return;
		}
		if (this.scenarioMapIndex == 3) {
			this.var_49ca = 7;
			A_Unit.unitSpeed = 4;
			this.var_486a[0] = 400;
			this.var_486a[1] = 400;
			this.var_4de2 = A_Unit.createUnit((byte) 0, (byte) 0, -1, 5);
			this.var_4dea = A_Unit.createUnit((byte) 2, (byte) 0, -2, 5);
			this.var_4df2 = A_Unit.createUnit((byte) 3, (byte) 0, -3, 5);
			this.var_4de2.setHiddenPositions(3, 4, false);
			this.var_4dea.setHiddenPositions(4, 4, false);
			this.var_4df2.setHiddenPositions(2, 4, false);
			this.maybeTeamKings[0].setHiddenPositions(3, 3, false);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(3, 3);
			this.var_4c6a = this.maybeTeamKings[0];
			initIntro(3, 3, 3);
			C_MainCanvas.playMusic2(1, 1);
			this.fadeEnabled = false;
			this.isCursorVisible = false;
			this.aState = 0;
			return;
		}
		A_Unit localClass_a_02601;
		if (this.scenarioMapIndex == 4) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			sub_efb8(this.maybeTeamKings[0].pixelX + 12, this.maybeTeamKings[0].pixelY + 12); // m n pos
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			A_Unit.unitSpeed = 4;
			(localClass_a_02601 = getUnitAtPos(11, 2, (byte) 0)).setOnMapPosition(11, -3);
			localClass_a_02601.setHiddenPositions(11, 2, false);
			(localClass_a_02601 = getUnitAtPos(10, 1, (byte) 0)).setOnMapPosition(10, -5);
			localClass_a_02601.setHiddenPositions(10, 1, false);
			(localClass_a_02601 = getUnitAtPos(11, 1, (byte) 0)).setOnMapPosition(11, -5);
			localClass_a_02601.setHiddenPositions(11, 1, false);
			(localClass_a_02601 = getUnitAtPos(12, 1, (byte) 0)).setOnMapPosition(12, -5);
			localClass_a_02601.setHiddenPositions(12, 1, false);
			(localClass_a_02601 = getUnitAtPos(11, 0, (byte) 0)).setOnMapPosition(11, -7);
			localClass_a_02601.setHiddenPositions(11, 0, false);
			(localClass_a_02601 = getUnitAtPos(12, 0, (byte) 0)).setOnMapPosition(12, -7);
			localClass_a_02601.setHiddenPositions(12, 0, false);
			F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			this.isCursorVisible = false;
			this.aState = 0;
			return;
		}
		if (this.scenarioMapIndex == 5) {
			this.var_49ca = 7;
			this.var_486a[0] = 600;
			this.var_486a[1] = 600;
			this.maybeTeamKings[0].setKingName(2);
			sub_efe5(5, 0);
			moveCursorToPos(5, 0);
			this.mapStepMax = 4;
			sub_186a6(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			this.isCursorVisible = false;
			this.aState = 0;
			return;
		}
		A_Unit localClass_a_02602;
		if (this.scenarioMapIndex == 6) {
			this.var_49ca = 8;
			A_Unit.unitSpeed = 4;
			this.var_486a[0] = 400;
			this.var_486a[1] = 600;
			localClass_a_02601 = A_Unit.createUnit((byte) 0, (byte) 0, 13,
					-1);
			localClass_a_02602 = A_Unit.createUnit((byte) 1, (byte) 0, 13,
					-1);
			A_Unit localClass_a_02603 = A_Unit.createUnit((byte) 3,
					(byte) 0, 13, -1);
			A_Unit localClass_a_02604 = A_Unit.createUnit((byte) 11,
					(byte) 0, 13, -1);
			this.maybeTeamKings[0].someUnit0 = localClass_a_02601;
			localClass_a_02601.someUnit0 = localClass_a_02602;
			localClass_a_02602.someUnit0 = localClass_a_02603;
			localClass_a_02603.someUnit0 = localClass_a_02604;
			this.maybeTeamKings[0].fillWhereUnitCanMove(this.var_47da);
			this.maybeTeamKings[0].setHiddenPositions(14, 3, true);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			this.var_4c6a = this.maybeTeamKings[0];
			F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			this.isCursorVisible = false;
			this.aState = 0;
			return;
		}
		if (this.scenarioMapIndex == 7) {
			this.var_49ca = 8;
			A_Unit.unitSpeed = 4;
			this.var_486a[0] = 800;
			this.var_486a[1] = 200;
			(localClass_a_02601 = getUnitAtPos(7, 4, (byte) 0)).setKingName(3);
			this.maybeTeamKings[1] = localClass_a_02601;
			localClass_a_02602 = getUnitAtPos(8, 15, (byte) 0);
			this.maybeTeamKings[0] = localClass_a_02602;
			localClass_a_02602.setKingName(0);
			getUnitAtPos(6, 15, (byte) 0).setKingName(2);
			sub_efb8(this.maybeTeamKings[0].pixelX + 12, this.maybeTeamKings[0].pixelY + 12); // m n pos
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			initIntro(4, 3, 3);
			C_MainCanvas.playMusic2(1, 1);
			this.fadeEnabled = false;
			this.isCursorVisible = false;
			this.aState = 0;
		}
	}

	private void someReadScriptMethod(int scriptId) {
		//@todo WTF
		InputStream scriptStream = C_MainCanvas.getResourceStream("m" + scriptId + ".script");
		if (scriptStream  == null) {
			this.someScriptStrings = null;
			return;
		}
		Vector vecOfVecs = new Vector();
		Vector localVector2 = null;
		String scriptStr = C_MainCanvas.streamToString(scriptStream);
		while (scriptStr != null) {
			int eolnIndex =  scriptStr.indexOf(';');
			if (eolnIndex >= 0) {
				scriptStr = scriptStr.substring(0, eolnIndex);
			}
			String str = scriptStr.trim();
			if (str.length() != 0) {
				String[] lineParams = C_MainCanvas.splitStringByChar((String) str, ' ');
				int i = 0;
				if (lineParams[0].charAt(0) == '@') {
					String key = lineParams[0].substring(1);
					if (key.equalsIgnoreCase("case")) {
						int value = Integer.parseInt(lineParams[1]);
						while (vecOfVecs.size() <= value) {
							vecOfVecs.addElement(new Vector());
						}
						localVector2 = (Vector) vecOfVecs.elementAt(value);
					}
				} else {
					//localVector2.addElement(i);  //@todo unused localVector2
				}
			}
		}
		this.someScriptStrings = new String[vecOfVecs.size()][][];
		for (int i = 0; i < vecOfVecs.size(); i++) {
			Vector vec = (Vector) vecOfVecs.elementAt(i);
			this.someScriptStrings[i] = new String[vec.size()][];
			vec.copyInto(this.someScriptStrings[i]);
		}
	}

	/**
	 * Scripting here?
	 */
	private void someParseScriptMethod() {
		String[][] scriptArr2 = this.someScriptStrings[this.aState];
		int i = 0;
		int j = -1;
		A_Unit unit = null;
		while ((i >= 0) && (i < scriptArr2.length)) {
			String[] scriptLine = scriptArr2[(i++)];
			String key =  scriptLine[0];
			if (key.equalsIgnoreCase("Jump")) {
				int jumpInstrCount = Integer.parseInt(scriptLine[1]);
				i += jumpInstrCount;
			} else if (key.equalsIgnoreCase("Alt")) { //??
				j = Integer.parseInt(scriptLine[1]);
				if (j == 0) {
					j = -1;
				} else {
					j += i;
				}
			} else if (key.equalsIgnoreCase("Test")) {// Condition
				int firstArg = 0;
				int secondArg = 0;
				String operator = null;
				if (scriptLine[1].equalsIgnoreCase("CurrentPlayer")) {
					firstArg = this.currentPlayerId;
				} else if (scriptLine[1].equalsIgnoreCase("CurrentTurn")) {
					firstArg = this.currentTurn;
				} else if (scriptLine[1].equalsIgnoreCase("GameState")) {
					firstArg = this.gameState;
				} else if (scriptLine[1].equalsIgnoreCase("AlphaWindow")) {
					firstArg = this.alphaWindow;
				} else if (scriptLine[1].equalsIgnoreCase("StatusBarOffset")) {
					firstArg = this.statusBarOffset;
				} else if (scriptLine[1].equalsIgnoreCase("UnitFinishedMove")) {
					firstArg = this.unitFinishedMove != null ? 1 : 0;
				} else if (scriptLine[1].equalsIgnoreCase("CountUnits")) {
					int unitType = Integer.parseInt(scriptLine[2]);
					int someVal = Integer.parseInt(scriptLine[3]);
					byte teamId = (byte) Integer.parseInt(scriptLine[4]);
					firstArg = countSomeTeamUnitsOfType(unitType, someVal, teamId);
					operator = scriptLine[5];
					secondArg = Integer.parseInt(scriptLine[6]);
				}
				if (operator == null) {
					operator = scriptLine[2];
					secondArg = Integer.parseInt(scriptLine[3]);	
				}
				/* WTF */
				boolean boolExpr = false;
				switch(ConditionOperator.getOperatorId(operator)){ 
					case(ConditionOperator.LESS_THAN_EQUALS): boolExpr = firstArg <= secondArg; break;
					case(ConditionOperator.LESS_THAN): boolExpr = firstArg < secondArg; break;
					case(ConditionOperator.BIGGER_THAN_EQUALS): boolExpr = firstArg >= secondArg; break;
					case(ConditionOperator.BIGGER_THAN): boolExpr = firstArg > secondArg; break;
					case(ConditionOperator.NOT_EQUALS): boolExpr = firstArg != secondArg; break;
					case(ConditionOperator.EQUALS): boolExpr = firstArg == secondArg; break;
				}
				if(boolExpr == false)
				{
					i = j;
				}
				j = -1;
			} else if (scriptLine[0].equalsIgnoreCase("Wait")) {
				waitScript(Integer.parseInt(scriptLine[1]));
			} else if (scriptLine[0].equalsIgnoreCase("NextState")) {
				this.aState += 1;
			} else if (scriptLine[0].equalsIgnoreCase("ShowMapName")) {
				F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
			} else if (scriptLine[0].equalsIgnoreCase("StartPlay")) {
				startPlay();
			} else if (scriptLine[0].equalsIgnoreCase("CompleteMission")) {
				completeMission();
			} else if (scriptLine[0].equalsIgnoreCase("SetFadeEnabled")) {
				this.fadeEnabled = "true".equalsIgnoreCase(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("SetCursorVisible")) {
				this.isCursorVisible = "true".equalsIgnoreCase(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("SetGameActive")) {
				this.isGameActive = "true".equalsIgnoreCase(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("SetFadeValue")) {
				this.fadeValue = Integer.parseInt(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("SetMapStepMax")) {
				this.mapStepMax = Integer.parseInt(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("SetUnitSpeed")) {
				if (scriptLine[1].equalsIgnoreCase("slow")) {
					A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
				} else if (scriptLine[1].equalsIgnoreCase("fast")) {
					A_Unit.unitSpeed = A_Unit.unitSpeedFastVal;
				} else {
					A_Unit.unitSpeed = (byte) Integer.parseInt(scriptLine[1]);
				}
			} else if (scriptLine[0].equalsIgnoreCase("ShowDialog")) {
				int stringId = Integer.parseInt(scriptLine[1]);
				showUnitDialog(
						F_StringManager.getLangString(stringId),
						(byte) Integer.parseInt(scriptLine[2]),
						(byte) Integer.parseInt(scriptLine[3]));
			} else if (scriptLine[0].equalsIgnoreCase("ShowHelp")) {
				this.showHelp = Integer.parseInt(scriptLine[1]);
			} else if (scriptLine[0].equalsIgnoreCase("Vibrate")) {
				C_MainCanvas.vibrate(Integer.parseInt(scriptLine[1]));
			} else {
				A_Unit moveUnit;
				if (scriptLine[0].equalsIgnoreCase("MoveMapAndCursor")) {
					if (scriptLine[1].equalsIgnoreCase("king")) {
						moveUnit = this.maybeTeamKings[Integer.parseInt(scriptLine[2])];
						sub_186a6(moveUnit.posX, moveUnit.posY);
					} else {
						sub_186a6(Integer.parseInt(scriptLine[1]),
								Integer.parseInt(scriptLine[2]));
					}
				} else if (scriptLine[0].equalsIgnoreCase("GetUnitPlotRoute")) {
					int px = Integer.parseInt(scriptLine[1]);
					int py = Integer.parseInt(scriptLine[2]);
					unit = getUnitAtPos(px, py,
							(byte) Integer.parseInt(scriptLine[3]));
					unit.setHiddenPositions(
							Integer.parseInt(scriptLine[4]),
							Integer.parseInt(scriptLine[5]),
							"true".equalsIgnoreCase(scriptLine[6]));
				} else if (scriptLine[0]
						.equalsIgnoreCase("CreateUnitPlotRoute")) {
					unit = A_Unit.createUnit(
							(byte) Integer.parseInt(scriptLine[1]),
							(byte) Integer.parseInt(scriptLine[2]),
							Integer.parseInt(scriptLine[3]),
							Integer.parseInt(scriptLine[4]));
					unit.setHiddenPositions(
							Integer.parseInt(scriptLine[5]),
							Integer.parseInt(scriptLine[6]),
							"true".equalsIgnoreCase(scriptLine[7]),
							"true".equalsIgnoreCase(scriptLine[8]));
				} else if (scriptLine[0].equalsIgnoreCase("GetUnit")) {
					unit = getUnitAtPos(
							Integer.parseInt(scriptLine[1]),
							Integer.parseInt(scriptLine[2]),
							(byte) Integer.parseInt(scriptLine[3]));
				} else if (scriptLine[0].equalsIgnoreCase("RemoveUnit")) {
					unit.removeUnit();
				} else if (scriptLine[0]
						.equalsIgnoreCase("ScheduleUnitAnimationStop")) {
					unit.scheduleAnimationStop(Integer.parseInt(scriptLine[1]));
				} else if (scriptLine[0]
						.equalsIgnoreCase("CreateSpriteAtUnit")) {
					G_Sprite ssSprite = null;
					if (scriptLine[1].equalsIgnoreCase("Smoke")) {
						ssSprite = this.smokeSprite;
					} else if (scriptLine[1].equalsIgnoreCase("Spark")) {
						ssSprite = this.sparkSprite;
					} else if (scriptLine[1].equalsIgnoreCase("RedSpark")) {
						ssSprite = this.redsparkSprite;
					}
					int mapPosX = Integer.parseInt(scriptLine[2]);
					int mapPosY = Integer.parseInt(scriptLine[3]);
					int unk = Integer.parseInt(scriptLine[4]);
					int framedelay = Integer.parseInt(scriptLine[5]);
					showSpriteOnMap(ssSprite, unit.pixelX, unit.pixelY, 
							mapPosX, mapPosY, unk, framedelay);
				}
			}
		}
	}

	/** AI maybe **/
	private void sub_155a2() {
		if (this.var_4f92 != 0) {
			return;
		}
		if ((this.waitTime <= 0) || (--this.waitTime <= 0)) {
			if (this.var_4e3a) {
				if (this.aState == 0) {
					this.var_4912 = true;
					this.var_491a = 0;
					this.gameState = 11;
					this.aState = 1;
				}
			} else {
				int i;
				Object localObject3;
				Object localObject2;
				if (this.scenarioModeIf0 == 1) {
					if (this.aState == 100) {
						C_MainCanvas.playMusic2(
								var_4692[this.var_4832[this.currentPlayerId]], 0);
						this.gameMessageBox.sub_132e((byte) 0, true);
						this.gameMessageBox.sub_1350(null);
						F_StringManager.mainCanvas.showMessageBox(this.gameMessageBox);
						this.aState += 1;
						return;
					}
					if (this.aState == 101) {
						int j = -1;
						i = -1;
						int n = 1;
						for (int i2 = 0; i2 < this.teamsCountMaybe; i2++) {
							if ((this.someTeamValuesArr[i2] != 2)
									&& (((this.maybeTeamKings[i2] != null) && (this.maybeTeamKings[i2].var_e83 != 3)) || (sub_11cef(i2) != 0))) {
								i = i2;
								if ((j != -1) && (j != this.var_483a[i2])) {
									n = 0;
									break;
								}
								j = this.var_483a[i2];
							}
						}
						if (n != 0) {
							this.isGameActive = false;
							this.isCursorVisible = false;
							localObject3 = F_StringManager.getStrByIdAndReplaceUWith(38, ""
									+ (this.var_483a[i] + 1));
							String str = F_StringManager.getStrByIdAndReplaceUWith(81,
									(String) localObject3) + "\n(";
							for (n = 0; n < this.teamsCountMaybe; n++) {
								if ((this.someTeamValuesArr[n] != 2)
										&& (this.var_483a[n] == this.var_483a[i])) {
									str = str
											+ " "
											+ F_StringManager
													.getLangString(88 + this.var_4832[n])
											+ " ";
								}
							}
							str = str + ")";
							E_Menu lo2 = sub_1437e(null, str, this.someCanHeight,
									this.someCanHeightDiv2, -1);
							lo2.sub_1350(this);
							F_StringManager.mainCanvas.showMessageBox((F_StringManager) lo2);
							if (this.someTeamValuesArr[i] == 1) {
								C_MainCanvas.playMusic2(6, 1);
							} else {
								C_MainCanvas.playMusic2(7, 1);
							}
							waitScript(15);
							this.aState += 1;
							return;
						}
						return;
					}
					if (this.aState == 102) {
						this.var_4912 = true;
						this.var_491a = 0;
						this.gameState = 11;
						this.aState += 1;
					}
				} else if ((this.gameStateMb == 1) && (this.scenarioModeIf0 == 0)
						&& (this.aState != -1)) {
					if (this.var_4e42 != -1) {
						if (!sub_ee85(this.var_4e42, this.var_4e4a)) {
							return;
						}
						this.var_4e42 = -1;
						this.var_4e4a = -1;
					}
					if (this.gameState != 11) {
						int k = 1;
						for (i = 0; i < this.teamsUnitsCount[0]; i++) {
							if (this.teamsUnits[0][i].var_e83 != 3) {
								k = 0;
								break;
							}
						}
						if ((k != 0) && (sub_11cef(0) == 0)) {
							sub_1872e();
							return;
						}
					}
					if (this.someScriptStrings != null) {
						someParseScriptMethod();
					} else {
						Object localObject1;
						if (this.scenarioMapIndex == 0) {
							switch (this.aState) {
							case 0:
								this.aState += 1;
								break;
							case 1:
								F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
								waitScript(10);
								this.aState += 1;
								break;
							case 2:
								this.fadeEnabled = true;
								getUnitAtPos(0, 8, (byte) 0).setHiddenPositions(3, 8, false);
								getUnitAtPos(1, 9, (byte) 0).setHiddenPositions(4, 9, false);
								getUnitAtPos(0, 10, (byte) 0).setHiddenPositions(3, 10,
										false);
								sub_186a6(5, 9);
								break;
							case 3:
								sub_186a6(9, 3);
								this.isCursorVisible = true;
								break;
							case 4:
								waitScript(10);
								this.mapStepMax = 12;
								A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
								this.aState += 1;
								break;
							case 5:
								showUnitDialog(F_StringManager.getLangString(221),
										(byte) 2, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 6:
								localObject2 = getUnitAtPos(9, 3, (byte) 0);
								C_MainCanvas.vibrate(100);
								((A_Unit) localObject2).scheduleAnimationStop(400);
								showSpriteOnMap(this.redsparkSprite,
										((A_Unit) localObject2).pixelX,
										((A_Unit) localObject2).pixelY, 0, 0,
										2, 50);
								waitScript(10);
								this.aState += 1;
								break;
							case 7:
								showUnitDialog(F_StringManager.getLangString(222),
										(byte) 2, (byte) 4);
								this.aState += 1;
								break;
							case 8:
								localObject1 = getUnitAtPos(9, 3, (byte) 0);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject1).pixelX,
										((A_Unit) localObject1).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.smokeSprite,
										((A_Unit) localObject1).pixelX,
										((A_Unit) localObject1).pixelY, 0, -3,
										1, 100);
								((A_Unit) localObject1).removeUnit();
								waitScript(20);
								this.aState += 1;
								break;
							case 9:
								this.isCursorVisible = false;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								waitScript(10);
								this.aState += 1;
								break;
							case 11:
								showUnitDialog(F_StringManager.getLangString(223),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 12:
								showUnitDialog(F_StringManager.getLangString(224),
										(byte) 5, (byte) 4);
								this.aState += 1;
								break;
							case 13:
								startPlay();
								this.aState += 1;
								break;
							case 14:
								if (this.statusBarOffset == 0) {
									this.showHelp = 0;
									this.aState += 1;
								}
								break;
							case 15:
								if ((this.currentPlayerId == 0)
										&& (this.gameState == 1)
										&& (this.alphaWindow == 0)) {
									this.showHelp = 1;
									this.aState += 1;
								}
								break;
							case 16:
								if ((this.currentPlayerId == 0)
										&& (this.unitFinishedMove != null)) {
									this.showHelp = 2;
									this.aState += 1;
								}
								break;
							case 17:
								if ((this.currentPlayerId == 0)
										&& (this.unitFinishedMove != null)) {
									this.showHelp = 3;
									this.aState += 1;
								}
								break;
							case 18:
								if (countSomeTeamUnitsOfType(-1, 2, (byte) 0) >= 3) {
									this.showHelp = 4;
									this.aState += 1;
								} else if (this.currentTurn > 0) {
									this.aState += 1;
								}
								break;
							case 19:
								if (this.currentTurn >= 2) {
									this.showHelp = 5;
									this.aState += 1;
								}
								break;
							case 20:
								this.showHelp = 6;
								this.aState += 1;
								break;
							case 21:
								if ((this.gameState == 1)
										&& (this.currentPlayerId == 0)) {
									this.showHelp = 7;
									this.aState += 1;
								}
								break;
							case 22:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.isGameActive = false;
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 23:
								sub_186a6(1, 1);
								break;
							case 24:
								A_Unit.createUnit((byte) 1, (byte) 1, 1, 1)
										.setHiddenPositions(1, 2, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 25:
								sub_186a6(10, 10);
								break;
							case 26:
								A_Unit.createUnit((byte) 0, (byte) 1, 10,
										10).setHiddenPositions(10, 9, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 27:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 28:
								showUnitDialog(F_StringManager.getLangString(225),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 29:
								showUnitDialog(F_StringManager.getLangString(226),
										(byte) 0, (byte) 4);
								this.isGameActive = true;
								this.aState += 1;
								break;
							case 30:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (this.gameState == 0)) {
									this.isGameActive = false;
									this.isCursorVisible = false;
									waitScript(30);
									this.aState += 1;
								}
								break;
							case 31:
								this.var_4aca = true;
								this.fadeValue = 0;
								waitScript(20);
								this.aState += 1;
								break;
							case 32:
								showUnitDialog(F_StringManager.getLangString(227),
										(byte) 2, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 33:
								showUnitDialog(F_StringManager.getLangString(228),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 34:
								showUnitDialog(F_StringManager.getLangString(229),
										(byte) 2, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 35:
								showUnitDialog(F_StringManager.getLangString(230),
										(byte) 0, (byte) 4);
								waitScript(15);
								this.aState += 1;
								break;
							case 36:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 1) {
							switch (this.aState) {
							case 1:
								waitScript(10);
								this.aState += 1;
								break;
							case 2:
								this.mapStepMax = 4;
								sub_186a6(12, 3);
								break;
							case 3:
								showUnitDialog(F_StringManager.getLangString(231),
										(byte) 1, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 4:
								showUnitDialog(F_StringManager.getLangString(232),
										(byte) 3, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 5:
								showUnitDialog(F_StringManager.getLangString(233),
										(byte) 5, (byte) 4);
								sub_186a6(7, 3);
								break;
							case 6:
								A_Unit.unitSpeed = 2;
								this.var_4de2 = A_Unit.createUnit((byte) 0,
										(byte) 1, 7, 3);
								this.var_4dea = A_Unit.createUnit(
										(byte) 11, (byte) 1, 7, 3);
								this.var_4df2 = A_Unit.createUnit((byte) 0,
										(byte) 1, 7, 3);
								this.var_4de2.someUnit0 = this.var_4dea;
								this.var_4dea.someUnit0 = this.var_4df2;
								this.var_4de2.setHiddenPositions(6, -2, false);
								waitScript(30);
								this.aState += 1;
								break;
							case 7:
								if ((this.var_4df2.posX == 6)
										&& (this.var_4df2.posY == 1)) {
									A_Unit.unitSpeed = 4;
									this.var_4dfa = A_Unit.createUnit(
											(byte) 0, (byte) 0, 7, 3);
									this.var_4dfa.setHiddenPositions(6, 2, false);
									this.var_4dea.someUnit0 = null;
									showUnitDialog(F_StringManager.getLangString(234),
											(byte) 2, (byte) 4);
									this.aState += 1;
								}
								break;
							case 8:
								if (this.var_4dfa.var_e83 != 1) {
									C_MainCanvas.vibrate(100);
									this.var_4dfa.scheduleAnimationStop(400);
									showSpriteOnMap(this.redsparkSprite, this.var_4dfa.pixelX,
											this.var_4dfa.pixelY, 0, 0, 2, 50);
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 9:
								showUnitDialog(F_StringManager.getLangString(235),
										(byte) 2, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 10:
								showSpriteOnMap(this.smokeSprite, this.var_4dfa.pixelX,
										this.var_4dfa.pixelY, 0, -3, 1, 100);
								showSpriteOnMap(this.sparkSprite, this.var_4dfa.pixelX,
										this.var_4dfa.pixelY, 0, 0, 1, 50);
								this.var_4dfa.removeUnit();
								this.var_4dfa = null;
								waitScript(15);
								this.aState += 1;
								break;
							case 11:
								A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
								this.var_4de2.removeUnit();
								this.var_4dea.removeUnit();
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								this.mapStepMax = 12;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 12:
								showUnitDialog(F_StringManager.getLangString(236),
										(byte) 5, (byte) 4);
								this.aState += 1;
								break;
							case 13:
								showUnitDialog(F_StringManager.getLangString(237),
										(byte) 1, (byte) 4);
								this.aState += 1;
								break;
							case 14:
								sub_186a6(3, 5);
								break;
							case 15:
								showUnitDialog(F_StringManager.getLangString(238),
										(byte) 5, (byte) 4);
								this.aState += 1;
								break;
							case 16:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 17:
								this.showHelp = 8;
								this.aState += 1;
								break;
							case 18:
								this.showHelp = 9;
								this.aState += 1;
								break;
							case 19:
								startPlay();
								this.aState += 1;
								break;
							case 20:
								if ((this.gameState == 9)
										&& (this.currentPlayerId == 0)) {
									this.showHelp = 10;
									this.aState += 1;
								}
								break;
							case 21:
								this.showHelp = 11;
								this.aState += 1;
								break;
							case 22:
								if ((this.maybeTeamKings[0].var_e83 == 3)
										|| (this.maybeTeamKings[1].var_e83 == 3)) {
									this.showHelp = 12;
									this.aState += 1;
								}
								break;
							case 23:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.isGameActive = false;
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 24:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 25:
								showUnitDialog(F_StringManager.getLangString(239),
										(byte) 1, (byte) 4);
								this.aState += 1;
								break;
							case 26:
								showUnitDialog(F_StringManager.getLangString(240),
										(byte) 5, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 27:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 2) {
							switch (this.aState) {
							case 0:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2.setHiddenPositions(7, 14, false);
									this.aState += 1;
								}
								break;
							case 1:
								if (this.var_4dea.var_e83 != 1) {
									this.var_4dea.setHiddenPositions(7, 15, false);
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 2:
								A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								showUnitDialog(F_StringManager.getLangString(241),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 3:
								showUnitDialog(F_StringManager.getLangString(242),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 4:
								showUnitDialog(F_StringManager.getLangString(243),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 5:
								this.showHelp = 14;
								this.aState += 1;
								break;
							case 6:
								startPlay();
								this.aState += 1;
								break;
							case 7:
							case 8:
								if ((this.aState == 7)
										&& (this.currentPlayerId == 0)
										&& (this.statusBarOffset == 0)
										&& (countSomeTeamUnitsOfType(-1, 3, (byte) -1) > 0)) {
									this.showHelp = 15;
									this.aState += 1;
								}
								A_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, 2, (byte) 0);//super. it returns array
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].posX <= 4)
											|| (localObject11[i].posY <= 10)) {
										waitScript(10);
										this.isGameActive = false;
										this.isCursorVisible = false;
										this.aState = 9;
										break;
									}
								}
							case 9:
								sub_186a6(0, 8);
								A_Unit
										.createUnit((byte) 5, (byte) 1, -1, 8)
										.setHiddenPositions(0, 8, false);
								A_Unit
										.createUnit((byte) 5, (byte) 1, -2, 7)
										.setHiddenPositions(1, 7, false);
								waitScript(20);
								break;
							case 10:
								sub_186a6(8, 6);
								A_Unit
										.createUnit((byte) 5, (byte) 1, 12, 6)
										.setHiddenPositions(8, 6, false);
								waitScript(20);
								break;
							case 11:
								sub_186a6(2, 1);
								A_Unit
										.createUnit((byte) 5, (byte) 1, 1, -2)
										.setHiddenPositions(1, 2, false);
								A_Unit
										.createUnit((byte) 5, (byte) 1, 3, -2)
										.setHiddenPositions(3, 2, false);
								A_Unit
										.createUnit((byte) 4, (byte) 1, 2, -1)
										.setHiddenPositions(2, 1, false);
								waitScript(20);
								break;
							case 12:
								showUnitDialog(F_StringManager.getLangString(244),
										(byte) 5, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 13:
								sub_186a6(4, 8);
								waitScript(15);
								break;
							case 14:
								A_Unit localObject111 = A_Unit.createUnit((byte) 2,
										(byte) 1, 3, 8);
								localObject2 = A_Unit.createUnit((byte) 2,
										(byte) 1, 4, 7);
								localObject3 = A_Unit.createUnit((byte) 2,
										(byte) 1, 5, 8);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject111).pixelX,
										((A_Unit) localObject111).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject2).pixelX,
										((A_Unit) localObject2).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject3).pixelX,
										((A_Unit) localObject3).pixelY, 0, 0,
										1, 50);
								waitScript(10);
								this.aState += 1;
								break;
							case 15:
								showUnitDialog(F_StringManager.getLangString(245),
										(byte) 5, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 16:
								showUnitDialog(F_StringManager.getLangString(246),
										(byte) -1, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 17:
								showUnitDialog(F_StringManager.getLangString(247),
										(byte) 0, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 18:
								F_StringManager.mainCanvas.showMessageBox(newMessageBox(
										null, F_StringManager.getLangString(248),
										this.someCanHeight, 1500));
								this.aState += 1;
								break;
							case 19:
								getUnitAtPos(3, 8, (byte) 0).removeUnit();
								getUnitAtPos(4, 7, (byte) 0).removeUnit();
								getUnitAtPos(5, 8, (byte) 0).removeUnit();
								A_Unit localObject1111 = A_Unit.createUnit((byte) 2,
										(byte) 0, 3, 8);
								localObject2 = A_Unit.createUnit((byte) 2,
										(byte) 0, 4, 7);
								localObject3 = A_Unit.createUnit((byte) 2,
										(byte) 0, 5, 8);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject1111).pixelX,
										((A_Unit) localObject1111).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject2).pixelX,
										((A_Unit) localObject2).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((A_Unit) localObject3).pixelX,
										((A_Unit) localObject3).pixelY, 0, 0,
										1, 50);
								waitScript(10);
								this.aState += 1;
								break;
							case 20:
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.showHelp = 13;
								this.aState += 1;
								break;
							case 21:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.isGameActive = false;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 22:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 3) {
							switch (this.aState) {
							case 0:
								F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
								this.fadeEnabled = true;
								this.aState += 1;
								break;
							case 1:
								if (this.maybeTeamKings[0].var_e83 != 1) {
									this.var_4c6a = null;
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 2:
								this.var_4aca = true;
								this.fadeEnabled = true;
								this.fadeValue = 0;
								waitScript(20);
								this.aState += 1;
								break;
							case 3:
								showUnitDialog(F_StringManager.getLangString(249),
										(byte) 2, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 4:
								showUnitDialog(F_StringManager.getLangString(250),
										(byte) 0, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 5:
								showUnitDialog(F_StringManager.getLangString(251),
										(byte) 5, (byte) 4);
								moveCursorToPos(13, 3);
								sub_efb8(312, 72);
								this.maybeTeamKings[0].setOnMapPosition(7, 1);
								this.var_4de2.setOnMapPosition(5, 4);
								this.var_4dea.setOnMapPosition(7, 5);
								this.var_4df2.setOnMapPosition(3, 3);
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								this.mapStepMax = 2;
								waitScript(5);
								this.aState += 1;
								break;
							case 6:
								this.var_4aca = false;
								this.var_4ad2 = true;
								this.fadeValue = 0;
								waitScript(5);
								this.aState += 1;
								break;
							case 7:
								sub_186a6(13, 10);
								break;
							case 8:
								A_Unit.unitSpeed = 2;
								this.mapStepMax = 4;
								this.var_4de2 = getUnitAtPos(10, 10, (byte) 0);
								this.var_4de2.setHiddenPositions(6, 10, false);
								moveCursorToPos(6, 10);
								sub_186a6(6, 10);
								break;
							case 9:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2 = null;
									this.isCursorVisible = true;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 10:
								moveCursorToPos(4, 9);
								sub_186a6(4, 9);
								showSpriteOnMap(this.redsparkSprite, 96, 216, 0, 0, 1, 50);
								waitScript(15);
								break;
							case 11:
								this.var_48a2 = A_Unit.createUnitWithBool((byte) 0,
										(byte) 0, 4, 9, false);
								this.var_48a2.unitType = -1;
								this.var_48a2.var_e83 = 4;
								this.var_48ca = 6;
								waitScript(20);
								this.aState += 1;
								break;
							case 12:
								showUnitDialog(F_StringManager.getLangString(252),
										(byte) 5, (byte) 4);
								sub_186a6(7, 1);
								break;
							case 13:
								showUnitDialog(F_StringManager.getLangString(253),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 14:
								this.showHelp = 17;
								this.aState += 1;
								break;
							case 15:
								startPlay();
								this.aState += 1;
								break;
							case 16:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									waitScript(15);
									this.isGameActive = false;
									this.aState += 1;
								}
								break;
							case 17:
								showUnitDialog(F_StringManager.getLangString(254),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 18:
								showUnitDialog(F_StringManager.getLangString(255),
										(byte) 0, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 19:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 4) {
							if (this.var_4e02 == null) {
								this.var_4e02 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super. array
							}
							if ((this.aState == 25)
									&& (this.var_4e02.posX >= 15)
									&& (this.var_4e02.posY >= 11)
									&& (this.var_4e02.var_e83 == 2)) {
								waitScript(10);
								this.isGameActive = false;
								this.isCursorVisible = false;
								this.aState = 26;
								return;
							}
							if (this.var_4e02.var_e83 == 3) {
								this.var_4e02 = null;
								sub_1872e();
								return;
							}
							switch (this.aState) {
							case 0:
								waitScript(50);
								this.aState += 1;
								break;
							case 1:
								showUnitDialog(F_StringManager.getLangString(256),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 2:
								showUnitDialog(F_StringManager.getLangString(257),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 3:
								startPlay();
								this.aState += 1;
								break;
							case 4:
								A_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);//super. array
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX <= 8)) {
										this.isGameActive = false;
										waitScript(5);
										this.aState += 1;
										break;
									}
								}
							case 5:
								this.isCursorVisible = false;
								sub_186a6(4, 4);
								break;
							case 6:
								A_Unit
										.createUnit((byte) 10, (byte) 1, 4, 4)
										.setHiddenPositions(4, 1, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 7:
								A_Unit.createUnit((byte) 1, (byte) 1, 4, 4)
										.setHiddenPositions(5, 2, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 8:
								A_Unit
										.createUnit((byte) 10, (byte) 1, 4, 4)
										.setHiddenPositions(4, 3, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 9:
								showUnitDialog(F_StringManager.getLangString(258),
										(byte) 5, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.aState += 1;
								break;
							case 11:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);//super.
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posY >= 7)) {
										this.isGameActive = false;
										this.isCursorVisible = false;
										sub_186a6(6, 10);
										break;
									}
								}
							case 12:
								A_Unit
										.createUnit((byte) 1, (byte) 1, 6, 10)
										.setHiddenPositions(5, 10, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 13:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 6, 10)
										.setHiddenPositions(7, 8, false, true);
								waitScript(15);
								this.aState += 1;
								break;
							case 14:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 6, 10)
										.setHiddenPositions(7, 9, false, true);
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.aState += 1;
								break;
							case 15:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super. return unit[]
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX >= 8)
											&& (localObject11[i].posY >= 6)) {
										this.isGameActive = false;
										this.isCursorVisible = false;
										sub_186a6(12, 5);
										break;
									}
								}
							case 16:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 12, 5)
										.setHiddenPositions(12, 7, false, true);
								waitScript(15);
								this.aState += 1;
								break;
							case 17:
								A_Unit
										.createUnit((byte) 6, (byte) 1, 12, 5)
										.setHiddenPositions(12, 6, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 18:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 12, 5)
										.setHiddenPositions(12, 5, false, true);
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.aState += 1;
								break;
							case 19:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super.
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX >= 15)
											&& (localObject11[i].posY >= 8)) {
										this.isGameActive = false;
										this.isCursorVisible = false;
										sub_186a6(18, 8);
										break;
									}
								}
							case 20:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 18, 8)
										.setHiddenPositions(16, 10, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 21:
								A_Unit
										.createUnit((byte) 6, (byte) 1, 18, 8)
										.setHiddenPositions(17, 10, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 22:
								A_Unit
										.createUnit((byte) 5, (byte) 1, 18, 8)
										.setHiddenPositions(18, 10, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 23:
								A_Unit
										.createUnit((byte) 1, (byte) 1, 18, 8)
										.setHiddenPositions(18, 9, false, true);
								waitScript(10);
								this.aState += 1;
								break;
							case 24:
								showUnitDialog(F_StringManager.getLangString(259),
										(byte) 0, (byte) 4);
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.aState += 1;
								break;
							case 25:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.isGameActive = false;
									this.isCursorVisible = false;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 26:
								completeMission();
								this.aState += 1;
							}
						} else if (this.scenarioMapIndex == 5) {
							switch (this.aState) {
							case 0:
								waitScript(10);
								this.aState += 1;
								break;
							case 1:
								showUnitDialog(F_StringManager.getLangString(260),
										(byte) 1, (byte) 4);
								this.aState += 1;
								break;
							case 2:
								startPlay();
								this.aState += 1;
								break;
							case 3:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.isGameActive = false;
									this.isCursorVisible = false;
									waitScript(15);
									this.aState += 1;
								}
								break;
							case 4:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 5:
								showUnitDialog(F_StringManager.getLangString(261),
										(byte) 0, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 6:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 6) {
							if (this.aState <= 10) {
								if (this.var_4e02 == null) {
									this.var_4e02 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super.
								}
								if (this.var_4e02.var_e83 == 3) {
									this.var_4e02 = null;
									sub_1872e();
									return;
								}
							}
							switch (this.aState) {
							case 0:
								if (this.maybeTeamKings[0].var_e83 != 1) {
									this.var_4c6a = null;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 1:
								showUnitDialog(F_StringManager.getLangString(262),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 2:
								showUnitDialog(F_StringManager.getLangString(263),
										(byte) 0, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 3:
								A_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super.
								for (i = 0; i < localObject11.length; i++) {
									localObject11[i].someUnit0 = null;
								}
								startPlay();
								this.aState += 1;
								break;
							case 4:
								if (this.currentTurn >= 2) {
									waitScript(15);
									this.isGameActive = false;
									this.isCursorVisible = false;
									sub_186a6(11, 7);
								}
								break;
							case 5:
								A_Unit localObject111 = A_Unit.createUnit((byte) 5,
										(byte) 1, 11, 8);
								localObject111.fillWhereUnitCanMove(this.var_47da);
								localObject111.setHiddenPositions(14, 7,
										true);
								waitScript(10);
								this.aState += 1;
								break;
							case 6:
								A_Unit localObject21= A_Unit.createUnit((byte) 0,
										(byte) 1, 11, 8);
								localObject21.fillWhereUnitCanMove(this.var_47da);
								localObject21.setHiddenPositions(13, 7,
										true);
								waitScript(10);
								this.aState += 1;
								break;
							case 7:
								A_Unit localObject31 = A_Unit.createUnit((byte) 3,
										(byte) 1, 11, 8);
								localObject31.fillWhereUnitCanMove(this.var_47da);
								((A_Unit) localObject31).setHiddenPositions(12, 7,
										true);
								waitScript(10);
								this.aState += 1;
								break;
							case 8:
								A_Unit
										.createUnit((byte) 1, (byte) 1, 11, 8)
										.setHiddenPositions(13, 8, false);
								waitScript(20);
								this.aState += 1;
								break;
							case 9:
								showUnitDialog(F_StringManager.getLangString(264),
										(byte) 5, (byte) 4);
								this.isGameActive = true;
								this.isCursorVisible = true;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								int i1 = 0;
								A_Unit[] arrayOfClass_a_0260 = getSomeUnitsOfTypeOfTeam(-1, 2, (byte) 0); //super.
								for (int m = 0; m < arrayOfClass_a_0260.length; m++) {
									if ((arrayOfClass_a_0260[m].posX <= 9)
											|| (arrayOfClass_a_0260[m].posY >= 10)) {
										i1 = 1;
										break;
									}
								}
								if ((i1 != 0)
										|| (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)) {
									this.isCursorVisible = false;
									this.isGameActive = false;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 11:
								this.var_4de2 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super.
								this.var_4dea = A_Unit.createUnit((byte) 8,
										(byte) 1, this.mapWidth,
										this.var_4de2.posY);
								sub_186a6(this.mapWidth - 1,
										this.var_4de2.posY);
								this.isCursorVisible = false;
								break;
							case 12:
								this.var_4dea.setHiddenPositions(this.var_4de2.posX,
										this.var_4de2.posY, false);
								waitScript(5);
								this.aState += 1;
								break;
							case 13:
								showUnitDialog(F_StringManager.getLangString(265),
										(byte) 5, (byte) 4);
								this.var_4c6a = this.var_4dea;
								this.aState += 1;
								break;
							case 14:
								if (this.var_4dea.var_e83 != 1) {
									showUnitDialog(F_StringManager.getLangString(266),
											(byte) 0, (byte) 4);
									this.var_4dea.setHiddenPositions(-1,
											this.var_4dea.posY, false);
									waitScript(3);
									this.aState += 1;
								}
								break;
							case 15:
								this.var_4de2.setHiddenPositions(-1,
										this.var_4dea.posY, false);
								this.aState += 1;
								break;
							case 16:
								if (this.var_4dea.var_e83 != 1) {
									waitScript(10);
									this.var_4de2.removeUnit();
									this.var_4dea.removeUnit();
									moveCursorToPos(0, this.var_4dea.posY);
									this.var_4de2 = null;
									this.var_4dea = null;
									this.var_4c6a = null;
									this.aState += 1;
								}
								break;
							case 17:
								sub_186a6(1, 9);
								break;
							case 18:
								this.maybeTeamKings[1] = A_Unit.createUnit((byte)9, (byte)1,
										-2, 8);
								this.maybeTeamKings[1].setHiddenPositions(0, 8, false);
								A_Unit
										.createUnit((byte) 0, (byte) 1, -1, 8)
										.setHiddenPositions(3, 8, false);
								A_Unit.createUnit((byte) 0, (byte) 1, -1,
										10).setHiddenPositions(1, 10, false);
								A_Unit
										.createUnit((byte) 8, (byte) 1, -3, 7)
										.setHiddenPositions(4, 8, false);
								A_Unit.createUnit((byte) 8, (byte) 1, -3,
										11).setHiddenPositions(2, 10, false);
								A_Unit
										.createUnit((byte) 4, (byte) 1, -2, 9)
										.setHiddenPositions(2, 9, false);
								A_Unit
										.createUnit((byte) 6, (byte) 1, -4, 9)
										.setHiddenPositions(4, 9, false);
								A_Unit
										.createUnit((byte) 6, (byte) 1, -6, 9)
										.setHiddenPositions(5, 10, false);
								waitScript(50);
								this.aState += 1;
								break;
							case 19:
								showUnitDialog(F_StringManager.getLangString(267),
										(byte) 3, (byte) 4);
								this.aState += 1;
								break;
							case 20:
								sub_186a6(13, 14);
								break;
							case 21:
								A_Unit.createUnit((byte) 0, (byte) 1, 13,
										14).setHiddenPositions(12, 14, false);
								waitScript(5);
								this.aState += 1;
								break;
							case 22:
								A_Unit.createUnit((byte) 6, (byte) 1, 13,
										14).setHiddenPositions(14, 14, false);
								waitScript(5);
								this.aState += 1;
								break;
							case 23:
								A_Unit.createUnit((byte) 2, (byte) 1, 13,
										14).setHiddenPositions(13, 12, false);
								waitScript(5);
								this.aState += 1;
								break;
							case 24:
								A_Unit.createUnit((byte) 3, (byte) 1, 13,
										14).setHiddenPositions(13, 15, false);
								waitScript(15);
								this.aState += 1;
								break;
							case 25:
								showUnitDialog(F_StringManager.getLangString(268),
										(byte) 5, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 26:
								showUnitDialog(F_StringManager.getLangString(269),
										(byte) 0, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 27:
								sub_186a6(13, 17);
								break;
							case 28:
								A_Unit localClass_a_0260;
								(localClass_a_0260 = A_Unit.createUnit(
										(byte) 9, (byte) 0, 13, 18))
										.setKingName(2);
								localClass_a_0260.setHiddenPositions(13, 16, false);
								A_Unit.createUnit((byte) 6, (byte) 0, 12,
										18).setHiddenPositions(12, 16, false);
								A_Unit.createUnit((byte) 8, (byte) 0, 14,
										19).setHiddenPositions(14, 16, false);
								A_Unit.createUnit((byte) 4, (byte) 0, 13,
										19).setHiddenPositions(13, 17, false);
								A_Unit.createUnit((byte) 1, (byte) 0, 12,
										19).setHiddenPositions(12, 17, false);
								waitScript(20);
								this.aState += 1;
								break;
							case 29:
								showUnitDialog(F_StringManager.getLangString(270),
										(byte) 1, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 30:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 31:
								this.showHelp = 18;
								this.aState += 1;
								break;
							case 32:
								this.isGameActive = true;
								this.isCursorVisible = true;
								this.gameMessageBox = newMessageBox(F_StringManager
										.getLangString(121 + this.scenarioMapIndex),
										F_StringManager.getLangString(138),
										this.someCanHeight, -1);
								this.gameMessageBox.sub_132e((byte) 0, true);
								this.gameMessageBox.sub_1350(null);
								F_StringManager.mainCanvas.showMessageBox(this.gameMessageBox);
								this.aState += 1;
								break;
							case 33:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.isGameActive = false;
									this.isCursorVisible = false;
									waitScript(10);
									this.aState += 1;
								}
								break;
							case 34:
								completeMission();
							}
						} else if (this.scenarioMapIndex == 7) {
							switch (this.aState) {
							case 0:
								F_StringManager.mainCanvas.showMessageBox(this.mapStartUpMessageBox);
								this.fadeEnabled = true;
								this.aState += 1;
								break;
							case 1:
								if (!this.var_4ad2) {
									showUnitDialog(F_StringManager.getLangString(271),
											(byte) 0, (byte) 4);
									this.aState += 1;
								}
								break;
							case 2:
								sub_186a6(this.maybeTeamKings[1].posX,
										this.maybeTeamKings[1].posY);
								break;
							case 3:
								showUnitDialog(F_StringManager.getLangString(272),
										(byte) 4, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 4:
								showUnitDialog(F_StringManager.getLangString(273),
										(byte) 1, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 5:
								showUnitDialog(F_StringManager.getLangString(274),
										(byte) 4, (byte) 4);
								this.aState += 1;
								break;
							case 6:
								this.var_4de2 = getUnitAtPos(5, 2, (byte) 0);
								this.var_4de2.setHiddenPositions(7, 2, false);
								this.aState += 1;
								break;
							case 7:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2.removeUnit();
									this.var_4de2 = null;
									this.var_4dea = getUnitAtPos(7, 3, (byte) 0);
									this.var_4dea.setHiddenPositions(7, 2, false);
									this.aState += 1;
								}
								break;
							case 8:
								if (this.var_4dea.var_e83 != 1) {
									this.var_4dea.removeUnit();
									this.var_4dea = null;
									this.var_4df2 = getUnitAtPos(9, 2, (byte) 0);
									this.var_4df2.setHiddenPositions(7, 2, false);
									this.aState += 1;
								}
								break;
							case 9:
								if (this.var_4df2.var_e83 != 1) {
									this.var_4df2.removeUnit();
									this.var_4df2 = null;
									this.maybeTeamKings[1].setHiddenPositions(7, 2, false);
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 10:
								sub_186a6(9, 15);
								this.isCursorVisible = true;
								break;
							case 11:
								E_Menu localClass_e_0134;
								(localClass_e_0134 = newMessageBox(null,
										F_StringManager.getLangString(279),
										this.someCanHeight, 2000)).setLocation(
										this.someCanWidthDiv2, 2, 17);
								F_StringManager.mainCanvas
										.showMessageBox(localClass_e_0134);
								this.aState += 1;
								break;
							case 12:
								this.var_4b42 = false;
								sub_6963(getUnitAtPos(9, 15, (byte) 0));
								this.aState += 1;
								break;
							case 13:
								if (this.var_4b3a >= 2) {
									showUnitDialog(F_StringManager.getLangString(275),
											(byte) 0, (byte) 4);
									getUnitAtPos(9, 15, (byte) 0).removeUnit();
									this.var_4b42 = true;
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 14:
								this.isCursorVisible = false;
								showUnitDialog(F_StringManager.getLangString(276),
										(byte) 4, (byte) 4);
								this.aState += 1;
								break;
							case 15:
								showUnitDialog(F_StringManager.getLangString(277),
										(byte) 1, (byte) 4);
								waitScript(10);
								this.aState += 1;
								break;
							case 16:
								this.isCursorVisible = true;
								this.mapStepMax = 4;
								sub_186a6(3, 9);
								break;
							case 17:
								sub_186a6(13, 4);
								break;
							case 18:
								this.mapStepMax = 12;
								showUnitDialog(F_StringManager.getLangString(278),
										(byte) 5, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 19:
								startPlay();
								this.aState += 1;
								break;
							case 20:
								if (this.var_4b4a) {
									this.isCursorVisible = false;
									this.isGameActive = false;
									waitScript(20);
									this.aState += 1;
								}
								break;
							case 21:
								this.var_4aca = true;
								this.fadeValue = 0;
								this.fadeEnabled = true;
								this.aState += 1;
								break;
							case 22:
								if (this.fadeValue >= 16) {
									sub_efe5(7, 2);
									moveCursorToPos(7, 2);
									sub_ac6f();
									this.maybeTeamKings[1] = A_Unit.createUnit((byte)9,
											(byte)1, 7, 2);
									this.maybeTeamKings[1].setKingName(3);
									A_Unit.createUnit((byte) 9, (byte) 0,
											6, 3);
									A_Unit.createUnit((byte) 9, (byte) 0,
											8, 3).setKingName(2);
									A_Unit.createUnit((byte) 0, (byte) 0,
											6, 1);
									A_Unit.createUnit((byte) 0, (byte) 0,
											8, 1);
									waitScript(10);
									this.aState += 1;
									C_MainCanvas.playMusic2(8, 0);
								}
								break;
							case 23:
								this.var_4aca = false;
								this.var_4ad2 = true;
								this.fadeValue = 0;
								this.aState += 1;
								break;
							case 24:
								if (this.fadeValue >= 16) {
									showUnitDialog(F_StringManager.getLangString(281),
											(byte) 4, (byte) 4);
									waitScript(15);
									this.aState += 1;
								}
								break;
							case 25:
								showUnitDialog(F_StringManager.getLangString(282),
										(byte) 0, (byte) 4);
								waitScript(8);
								this.aState += 1;
								break;
							case 26:
								showUnitDialog(F_StringManager.getLangString(283),
										(byte) 4, (byte) 4);
								waitScript(15);
								this.aState += 1;
								break;
							case 27:
								showSpriteOnMap(this.sparkSprite, 168, 48, 0, 0, 1, 50);
								this.mapUnitsMaybe.removeElement(this.maybeTeamKings[1]);
								waitScript(15);
								this.aState += 1;
								break;
							case 28:
								C_MainCanvas.vibrate(400);
								sub_188ce(5000);
								waitScript(10);
								this.aState += 1;
								break;
							case 29:
								showUnitDialog(F_StringManager.getLangString(284),
										(byte) 5, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 30:
								showUnitDialog(F_StringManager.getLangString(285),
										(byte) 2, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 31:
								showUnitDialog(F_StringManager.getLangString(286),
										(byte) 1, (byte) 4);
								waitScript(5);
								this.aState += 1;
								break;
							case 32:
								showUnitDialog(F_StringManager.getLangString(287),
										(byte) 0, (byte) 4);
								this.var_4aca = true;
								this.fadeValue = 0;
								this.aState += 1;
								break;
							case 33:
								if (this.fadeValue >= 16) {
									waitScript(10);
									this.isShakingMB = false;
									this.aState += 1;
								}
								break;
							case 34:
								initIntro(5, 2, 2);
								this.aState += 1;
								break;
							case 35:
								C_MainCanvas.playMusic2(0, 0);
								sub_f6d8(F_StringManager.getLangString(288));
								this.aState += 1;
								break;
							case 36:
								this.var_4e52 = 0;
								this.gameState = 14;
								this.aState += 1;
							}
						}
					}
					this.unitFinishedMove = null;
				}
			}
		}
	}

	private void startPlay() {
		this.mapStartUpMessageBox = null;
		this.mapStepMax = 12;
		A_Unit.unitSpeed = A_Unit.unitSpeedSlowVal;
		this.gameMessageBox.sub_132e((byte) 0, true);
		this.gameMessageBox.sub_132e((byte) 1, false);
		F_StringManager.mainCanvas.showMessageBox(this.gameMessageBox);
		this.isCursorVisible = true;
		this.isGameActive = true;
		this.var_4a5a = false;
		C_MainCanvas.playMusic2(2, 0);
	}

	private void sub_186a6(int paramInt1, int paramInt2) {
		this.var_4e42 = paramInt1;
		this.var_4e4a = paramInt2;
		moveCursorToPos(paramInt1, paramInt2);
		this.aState += 1;
	}

	private void completeMission() {
		C_MainCanvas.stopCurrentMusicPlayer();
		C_MainCanvas.playMusicLooped(6, 1);
		F_StringManager.mainCanvas.showMessageBox(newMessageBox(null, F_StringManager.getLangString(72),
				this.someCanHeight, 3000));
		this.var_481a = this.someGameTime;
		this.aState = -1;
		this.var_4e52 = 0;
		this.gameState = 10;
	}

	private void sub_1872e() {
		this.var_4e3a = true;
		this.aState = 0;
		waitScript(20);
		C_MainCanvas.stopCurrentMusicPlayer();
		C_MainCanvas.playMusicLooped(7, 1);
	}

	private void sub_18762(A_Unit unit1,
			A_Unit unit2) {
		System.gc();
		this.faViewPortHeight = (this.someCanHeight - this.var_4cfa);
		this.var_4ea2 = true;
		this.var_491a = 0;
		this.var_4e72 = false;
		this.attackingUnit = unit1;
		this.attackedUnit = unit2;
		C_MainCanvas.initResPak();
		this.fAnim1 = new H_FightAnimation(this, unit1, null);
		this.fAnim2 = new H_FightAnimation(this, unit2,
				this.fAnim1);
		this.fAnim1.hclass = this.fAnim2;
		unit1.getDamageWhenAttack(unit2);
		if (unit2.canAttackPosition(unit1.posX,
				unit1.posY)) {
			unit2.getDamageWhenAttack(unit1);
			this.var_4e9a = true;
		} else {
			this.var_4e9a = false;
		}
		this.fAnim1.unitHealthAfterAttack = ((byte) unit1.health);
		this.fAnim1.var_b87 = ((byte) unit1.getSomeHealthManipulationVal());
		this.fAnim2.unitHealthAfterAttack = ((byte) unit2.health);
		this.fAnim2.var_b87 = ((byte) unit2.getSomeHealthManipulationVal());
		C_MainCanvas.playMusicLooped(var_469a[this.var_4832[this.currentPlayerId]], 0);
		this.gameStateMb = 2;
		return;
	}

	public final void addSomeSprite(G_Sprite sprite) {
		this.spritesList.addElement(sprite);
	}

	public final void removeSomeSprite(G_Sprite sprite) {
		this.spritesList.removeElement(sprite);
	}

	public final void sub_188ce(int paramInt) {
		this.isShakingMB = true;
		this.shakingTimeMaxMb = paramInt;
		this.shakingTimeMb = this.someGameTime;
	}

	private E_Menu sub_188fc(F_StringManager strMan) {
		E_Menu localClass_e_01341;
		if (this.var_4ed2.length > 0) {
			E_Menu localClass_e_01342;
			(localClass_e_01342 = (localClass_e_01341 = new E_Menu(
					(byte) 11, 0)).sub_165b(F_StringManager.getLangString(46))).menuImage = this.menuIconsFrames[6];
			localClass_e_01341.setMenuListStringActionsMb(this.var_4ed2, this.someCanWidth / 2,
					(this.someCanHeight + localClass_e_01342.mapPrevPixelHeight) / 2,
					this.someCanWidth, this.someCanHeight - localClass_e_01342.mapPrevPixelHeight,
					3, 4);
		} else {
			(localClass_e_01341 = new E_Menu((byte) 10, 0))
					.sub_165b(F_StringManager.getLangString(46)).menuImage = this.menuIconsFrames[6];
			localClass_e_01341.initMessageBox(null, F_StringManager.getLangString(52),
					this.someCanWidth, -1);
		}
		localClass_e_01341.sub_1350(strMan);
		F_StringManager.mainCanvas.showMessageBox(localClass_e_01341);
		return localClass_e_01341;
	}

	private void sub_189c7(byte[] inparamArrayOfByte) {
		try {
			DataInputStream paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(
					inparamArrayOfByte));
			paramArrayOfByte.readLong();
			switch (paramArrayOfByte.readInt()) {
			case 10001:
				paramArrayOfByte.readUTF();
				paramArrayOfByte.readInt();
				paramArrayOfByte.readUTF();
				paramArrayOfByte.readInt();
				paramArrayOfByte.readUTF();
				paramArrayOfByte.readInt();
				paramArrayOfByte.readUTF();
				int i = paramArrayOfByte.readInt();
				paramArrayOfByte.readUTF();
				paramArrayOfByte.readUTF();
				if (this.var_4f42 == 0) {
					i = paramArrayOfByte.readInt() / 2;
					this.var_4ed2 = new String[i];
					this.var_4eda = new String[i];
					this.var_4ee2 = new String[i];
					for (int k = 0; k < i; k++) {
						this.var_4ed2[k] = paramArrayOfByte.readUTF();
						this.var_4eda[k] = paramArrayOfByte.readUTF();
					}
					this.var_4bf2 = sub_188fc(this.var_4f3a);
				} else if (this.var_4f42 == 1) {
					paramArrayOfByte.readInt();
					this.var_4ee2[this.var_4ec2] = paramArrayOfByte.readUTF();
					E_Menu localClass_e_0134;
					(localClass_e_0134 = sub_1437e(
							this.var_4ed2[this.var_4ec2],
							this.var_4ee2[this.var_4ec2], this.someCanHeight,
							this.someCanHeight / 2, -1)).sub_1350(this.var_4f3a);
					F_StringManager.mainCanvas.showMessageBox(localClass_e_0134);
				} else if (this.var_4f42 == 2) {
					i = paramArrayOfByte.readInt() / 3;
					this.someMapsNamesMb = new String[i];
					this.var_4ef2 = new String[i];
					this.mapBytesSizeMb = new int[i];
					for (int j = 0; j < i; j++) {
						this.someMapsNamesMb[j] = paramArrayOfByte.readUTF();
						this.var_4ef2[j] = paramArrayOfByte.readUTF();
						this.mapBytesSizeMb[j] = Integer.parseInt(paramArrayOfByte
								.readUTF());
					}
					sub_70c0(this.var_4f3a);
					F_StringManager.mainCanvas.showMessageBox(this.var_4c0a);
				} else if (this.var_4f42 == 3) {
					String str = this.someMapsNamesMb[this.var_4eca];
					byte[] arrayOfByte = new byte[i];
					paramArrayOfByte.readFully(arrayOfByte);
					sub_19157(str, arrayOfByte);
					sub_70c0(this.var_4c0a.stringManager);
					E_Menu cll;
					(cll = newMessageBox(null, F_StringManager.getStrByIdAndReplaceUWith(45, str),
							this.someCanHeight, 2000)).sub_1350(this.var_4c0a);
					F_StringManager.mainCanvas.showMessageBox(cll);
				}
				this.var_4f3a = null;
				return;
			}
			paramArrayOfByte.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		E_Menu bbc;
		(bbc = newMessageBox(null, F_StringManager.getLangString(44), this.someCanHeight, -1))
				.sub_1350(this.var_4f3a);
		this.var_4f3a = null;
		F_StringManager.mainCanvas.showMessageBox(bbc);
	}

	private void sub_18c91(int paramInt, String paramString1,
			String paramString2, F_StringManager paramClass_f_0145) {
		try {
			this.var_4f42 = paramInt;
			this.var_4f3a = paramClass_f_0145;
			this.var_4f32 = false;
			this.var_4f1a = new ByteArrayOutputStream();
			this.var_4f22 = new DataOutputStream(this.var_4f1a);
			this.var_4f22.writeInt(10001);
			this.var_4f22.writeUTF(this.provisionHighscorePortalCodeAppProp);
			this.var_4f22.writeUTF(this.provisionHighscoreGameCodeAppProp);
			this.var_4f2a = this.var_4f1a.size();
			this.var_4f22.writeUTF("resourceName");
			this.var_4f22.writeUTF(paramString1);
			this.var_4f22.writeUTF("languageCode");
			this.var_4f22.writeUTF(paramString2);
			this.var_4f22.writeUTF("maxChunkSize");
			this.var_4f22.writeUTF("1024");
			this.var_4f22.writeUTF("chunk");
			this.var_4f22.writeUTF("0");
			this.var_4f22.writeUTF("requestId");
			this.var_4f22.writeUTF("0");
			E_Menu cl = newMessageBox(null, F_StringManager.getLangString(43), this.someCanHeight, -1);
			cl.sub_1350(paramClass_f_0145);
			F_StringManager.mainCanvas.showMessageBox(cl);

			new Thread(this).start(); // THREAD here (broken)

			return;
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}

	/* Error */
	public final void run() {
		// /ByteCodeError 2 @error
	}

	private void sub_19031(int paramInt) {
		int i = this.settingsIntListMaybe[paramInt];
		this.settingsCountMaybe -= 1;
		String[] arrayOfString = new String[this.settingsCountMaybe];
		int[] arrayOfInt = new int[this.settingsCountMaybe];
		System.arraycopy(this.downloadedMapsNames, 0, arrayOfString, 0, paramInt);
		System.arraycopy(this.downloadedMapsNames, paramInt + 1, arrayOfString, paramInt,
				this.settingsCountMaybe - paramInt);
		System.arraycopy(this.settingsIntListMaybe, 0, arrayOfInt, 0, paramInt);
		System.arraycopy(this.settingsIntListMaybe, paramInt + 1, arrayOfInt, paramInt,
				this.settingsCountMaybe - paramInt);
		this.downloadedMapsNames = arrayOfString;
		this.settingsIntListMaybe = arrayOfInt;
		C_MainCanvas.deleteRecord("download", i);
		this.downloadAvailableSize = C_MainCanvas.getAvailableRecordSize("download");
		sub_191de();
		for (paramInt = 0; paramInt < 3; paramInt++) {
			if (this.saveSlotsMapIds[paramInt] == i + originalSkirmishMapNames12.length) {
				this.saveSlotBytes[paramInt] = -1;
				this.saveSlotsMapIds[paramInt] = -1;
				this.saveSlotsDescriptions[paramInt] = ("\n" + F_StringManager.getLangString(79) + "\n ");
				C_MainCanvas.addSomeRecords("save", paramInt, new byte[0]);
			}
		}
	}

	private void sub_19157(String paramString, byte[] paramArrayOfByte) {
		String[] arrayOfString = new String[this.settingsCountMaybe + 1];
		int[] arrayOfInt = new int[this.settingsCountMaybe + 1];
		System.arraycopy(this.downloadedMapsNames, 0, arrayOfString, 0, this.settingsCountMaybe);
		System.arraycopy(this.settingsIntListMaybe, 0, arrayOfInt, 0, this.settingsCountMaybe);
		this.downloadedMapsNames = arrayOfString;
		this.settingsIntListMaybe = arrayOfInt;
		this.settingsIntListMaybe[this.settingsCountMaybe] = C_MainCanvas.saveRecord("download",
				paramArrayOfByte);
		this.downloadedMapsNames[this.settingsCountMaybe] = paramString;
		this.settingsCountMaybe += 1;
		this.downloadAvailableSize = C_MainCanvas.getAvailableRecordSize("download");
		sub_191de();
	}

	private void sub_191de() {
		try {
			ByteArrayOutputStream localObject = new ByteArrayOutputStream();
			DataOutputStream localDataOutputStream;
			(localDataOutputStream = new DataOutputStream(
					(OutputStream) localObject)).writeInt(this.settingsCountMaybe);
			for (int i = 0; i < this.settingsCountMaybe; i++) {
				localDataOutputStream.writeInt(this.settingsIntListMaybe[i]);
				localDataOutputStream.writeUTF(this.downloadedMapsNames[i]);
			}
			C_MainCanvas.addSomeRecords("settings", 2,
					((ByteArrayOutputStream) localObject).toByteArray());
			localDataOutputStream.close();
			return;
		} catch (IOException localIOException) {
			localIOException.printStackTrace();
		}
	}

	public final void commandAction(Command inparamCommand,
			Displayable inparamDisplayable) {
		Object localObject;
		if (inparamDisplayable == this.var_4fd2) {
			if (inparamCommand == this.var_506a) {
				if ((this.var_5002.size() == 0) || (this.var_500a.size() == 0)
						|| (this.var_5012.size() == 0)) {
					return;
				}
				int intSomoe;
				intSomoe = Integer.parseInt(this.var_500a.getString());
				int intSomoeDiss;
				intSomoeDiss = Integer.parseInt(this.var_5012.getString());
				if ((intSomoe <= 0) || (intSomoeDiss <= 0)) {
					return;
				}
				this.var_501a.getSelectedFlags(this.var_4fca);
				int i = 0;
				for (int n = 0; n < this.var_4fca.length; n++) {
					if (this.var_4fca[n] != false) {
						i++;
					}
				}
				if (i == 0) {
					return;
				}
				try {
					C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
					F_StringManager.mainCanvas.showMessageBox(this);
					this.scenarioModeIf0 = 1;
					this.var_4f92 = 1;
					this.isLoadingBlackMb = true;
					F_StringManager.mainCanvas.repaintAll();
					sub_5dc1();
					int[] arrayOfInt = this.var_4fba;
					int i1 = intSomoeDiss;
					int j = intSomoe;
					String paramDisplayable = this.var_5002.getString();
					G_Game paramCommand = this;
					try {
						C_MainCanvas.stopCurrentMusicPlayer();
						paramCommand.spritesOtherVector = new Vector();
						paramCommand.var_4aca = false;
						paramCommand.isCursorVisible = true;
						paramCommand.var_4912 = false;
						paramCommand.var_4b4a = false;
						paramCommand.somePositions = null;
						paramCommand.dyingUnit = null;
						paramCommand.var_4b32 = null;
						paramCommand.var_48a2 = null;
						paramCommand.selectedTombUnit = null;
						paramCommand.vectorOfSomeUnits.removeAllElements();
						paramCommand.currentTurn = 0;
						paramCommand.currentPlayerId = 0;
						paramCommand.currentPlayerId = 0;
						paramCommand.aState = 0;
						paramCommand.sub_ac6f();
						paramCommand.maybeTeamKings = null;
						paramCommand.mapTilesIds = null;
						paramCommand.var_47da = null;
						paramCommand.teamsCountMaybe = 0;
						for (int i3 = 0; i3 < 5; i3++) {
							paramCommand.var_482a[i3] = -1;
						}
						paramCommand.var_495a = true;
						C_MainCanvas.initResPak();
						paramCommand.mapStartUpMessage = paramDisplayable;
						paramCommand.mapWidth = j;
						paramCommand.mapHeight = i1;
						paramCommand.mapTilesIds = new byte[paramCommand.mapWidth][paramCommand.mapHeight];
						paramCommand.var_47da = new byte[paramCommand.mapWidth][paramCommand.mapHeight];
						paramCommand.var_4d92 = new byte[paramCommand.mapWidth][paramCommand.mapHeight];
						paramCommand.var_4d9a = 0;
						int i3 = 0;

						Vector vecParamDisplayable = new Vector();
						Vector localVector = new Vector();
						C_MainCanvas.sub_1abc(arrayOfInt, true);
						for (int i4 = 0; i4 < paramCommand.mapWidth; i4 = (short) (i4 + 1)) {
							for (int i5 = 0; i5 < paramCommand.mapHeight; i5 = (short) (i5 + 1)) {
								paramCommand.mapTilesIds[i4][i5] = ((byte) C_MainCanvas
										.getRandomArrayItemOrWhat(arrayOfInt));
								paramCommand.var_47da[i4][i5] = 0;
								if (isVillageOrTownEvenDestroyed(paramCommand.mapTilesIds[i4][i5])) {
									int i2 = paramCommand.sub_11bae(i4, i5);
									byte[] arrayOfByte;
									(arrayOfByte = new byte[3])[0] = ((byte) i4);
									arrayOfByte[1] = ((byte) i5);
									arrayOfByte[2] = ((byte) i2);
									vecParamDisplayable.addElement(arrayOfByte);
									i3++;
									if (paramCommand.getMapTileType(i4, i5) == 9) {
										if ((paramCommand.scenarioModeIf0 == 1)
												&& (i2 != 0)
												&& (paramCommand.var_482a[i2] == -1)) {
											paramCommand.var_4832[paramCommand.teamsCountMaybe] = ((byte) i2);
											paramCommand.var_482a[i2] = (paramCommand.teamsCountMaybe++);
										}
										byte[] localObjectByte;
										(localObjectByte = new byte[2])[0] = ((byte) i4);
										localObjectByte[1] = ((byte) i5);
										localVector.addElement(localObjectByte);
										paramCommand.var_4d9a += 1;
									}
								}
							}
						}
						C_MainCanvas.sub_1abc(arrayOfInt, false);
						paramCommand.var_4d82 = new int[i3];
						paramCommand.somePositionsOrTilesData = new byte[i3][];
						vecParamDisplayable.copyInto(paramCommand.somePositionsOrTilesData);
						paramCommand.var_4a02 = new byte[paramCommand.var_4d9a][];
						localVector.copyInto(paramCommand.var_4a02);
						paramCommand.var_46d2 = (paramCommand.mapWidth * 24);
						paramCommand.var_46da = (paramCommand.mapHeight * 24);
						paramCommand.var_4e3a = false;
						paramCommand.var_4e02 = null;
						paramCommand.var_4de2 = null;
						paramCommand.var_4dea = null;
						paramCommand.var_4df2 = null;
						paramCommand.var_4dfa = null;
						paramCommand.unitFinishedMove = null;
						if (paramCommand.scenarioModeIf0 == 1) {
							paramCommand.aState = 100;
							paramCommand.isGameActive = true;
						}
						paramCommand.aSomeUnitsArr = new A_Unit[paramCommand.somePositionsOrTilesData.length];
						paramCommand.var_4d72 = new byte[paramCommand.somePositionsOrTilesData.length];
						paramCommand.aSomeSpritesArr = new G_Sprite[paramCommand.somePositionsOrTilesData.length];
						for (short i4 = 0; i4 < paramCommand.somePositionsOrTilesData.length; i4 = (short) (i4 + 1)) {
							if (paramCommand.getMapTileType(
									paramCommand.somePositionsOrTilesData[i4][0],
									paramCommand.somePositionsOrTilesData[i4][1]) == 8) {
								paramCommand.aSomeSpritesArr[i4] = G_Sprite
										.getSpriteWithParams(paramCommand.bSmokeSprite, 0, -1,
												0, 1, 250, (byte) 0);
								paramCommand.aSomeSpritesArr[i4].isVisibleMb = false;
							}
						}
						C_MainCanvas.playMusic2(var_4692[1], 0);
						paramCommand.mapLeftX = 0;
						paramCommand.mapTopY = 0;
						paramCommand.cursorPosX = 0;
						paramCommand.cursorPosY = 0;
						paramCommand.cursorSprite.setPixelPosition(
								paramCommand.cursorPosX * 24,
								paramCommand.cursorPosY * 24);
					} catch (Exception localException2) {
						localException2.printStackTrace();
					}
					this.isLoadingBlackMb = false;
					this.gameState = 0;
					sub_1ae50();
				} catch (Exception localException3) {
					localException3.printStackTrace();
					return;
				}
			} else {
				if (inparamCommand == this.var_508a) {
					System.arraycopy(this.var_4fba, 0, this.var_4fc2, 0,
							this.var_4fba.length);
					itemStateChanged(this.var_502a);
					C_MainCanvas.setDisplayableAsCurrent(this.var_4ff2);
					return;
				}
				if (inparamCommand == this.var_507a) {
					for (int iparamCommand = 0; iparamCommand < this.var_4fca.length; iparamCommand++) {
						this.var_4fca[iparamCommand] = true;
					}
					this.var_501a.setSelectedFlags(this.var_4fca);
					itemStateChanged(this.var_501a);
					return;
				}
				if (inparamCommand == this.var_5082) {
					for (int iparamCommand = 0; iparamCommand < this.var_4fca.length; iparamCommand++) {
						this.var_4fca[iparamCommand] = false;
					}
					this.var_501a.setSelectedFlags(this.var_4fca);
					itemStateChanged(this.var_501a);
					return;
				}
				C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
				F_StringManager.mainCanvas.showMessageBox(this);
				sub_1ae50();
			}
		} else {
			if (inparamDisplayable == this.var_4fda) {
				if (inparamCommand == this.var_506a) {
					this.var_501a.getSelectedFlags(this.var_4fca);
					int intparamCommand = 0;
					for (int intparamDisplayable = 0; intparamDisplayable < this.var_4fca.length; intparamDisplayable++) {
						if (this.var_4fca[intparamDisplayable] != false) {
							intparamCommand++;
						}
					}
					if (intparamCommand == 0) {
						return;
					}
					itemStateChanged(this.var_501a);
					C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
					F_StringManager.mainCanvas.showMessageBox(this);
					return;
				}
				if (inparamCommand == this.var_508a) {
					System.arraycopy(this.var_4fba, 0, this.var_4fc2, 0,
							this.var_4fba.length);
					itemStateChanged(this.var_502a);
					C_MainCanvas.setDisplayableAsCurrent(this.var_4ff2);
					return;
				}
				if (inparamCommand == this.var_507a) {
					for (int intparamCommand = 0; intparamCommand < this.var_4fca.length; intparamCommand++) {
						this.var_4fca[intparamCommand] = true;
					}
					this.var_501a.setSelectedFlags(this.var_4fca);
					itemStateChanged(this.var_501a);
					return;
				}
				if (inparamCommand == this.var_5082) {
					for (int intparamCommand = 0; intparamCommand < this.var_4fca.length; intparamCommand++) {
						this.var_4fca[intparamCommand] = false;
					}
					this.var_501a.setSelectedFlags(this.var_4fca);
					itemStateChanged(this.var_501a);
					return;
				}
				C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
				F_StringManager.mainCanvas.showMessageBox(this);
				return;
			}
			if (inparamDisplayable == this.var_4fe2) {
				if (inparamCommand == this.var_506a) {
					if (this.var_5002.size() == 0) {
						return;
					}
					C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
					F_StringManager.mainCanvas.showMessageBox(this);
					this.mapStartUpMessage = this.var_5002.getString();
					return;
				}
				if (inparamCommand == this.var_5092) {
					this.var_5002.setString(Long.toString(
							System.currentTimeMillis(), 36).toUpperCase());
					return;
				}
				C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
				F_StringManager.mainCanvas.showMessageBox(this);
				return;
			}
			if (inparamDisplayable == this.var_4fea) {
				if (inparamCommand == this.var_506a) {
					if ((this.var_503a.size() == 0)
							|| (this.var_5042.size() == 0)
							|| (this.var_504a.size() == 0)
							|| (this.var_5052.size() == 0)) {
						return;
					}
					sub_b66c(Integer.parseInt(this.var_503a.getString()),
							Integer.parseInt(this.var_5042.getString()),
							Integer.parseInt(this.var_504a.getString()),
							Integer.parseInt(this.var_5052.getString()),
							this.var_4fba);
				}
				C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
				F_StringManager.mainCanvas.showMessageBox(this);
				return;
			}
			if (inparamDisplayable == this.var_4ff2) {
				if (inparamCommand == this.var_506a) {
					this.var_501a.getSelectedFlags(this.var_4fca);
					for (int intparamCommand = 0; intparamCommand < this.var_4fba.length; intparamCommand++) {
						this.var_4fca[intparamCommand] = (this.var_4fba[intparamCommand] > 0 ? true
								: false);
					}
					this.var_501a.setSelectedFlags(this.var_4fca);
					itemStateChanged(this.var_501a);
				} else {
					System.arraycopy(this.var_4fc2, 0, this.var_4fba, 0,
							this.var_4fba.length);
				}
				if (this.var_4fda != null) {
					C_MainCanvas.setDisplayableAsCurrent(this.var_4fda);
					return;
				}
				if (this.var_4fd2 != null) {
					C_MainCanvas.setDisplayableAsCurrent(this.var_4fd2);
				}
			} else {
				int k;
				if (inparamDisplayable == this.var_4ffa) {
					if (inparamCommand == this.var_506a) {
						int[] intArrparamCommand = new int[] {
								100 - this.var_5062.getValue(), 100 };
						for (int itparamDisplayable = 0; itparamDisplayable < this.mapWidth; itparamDisplayable++) {
							for (k = 0; k < this.mapHeight; k++) {
								if (this.var_47da[itparamDisplayable][k] > 0) {
									this.var_47da[itparamDisplayable][k] = ((byte) C_MainCanvas
											.getRandomArrayItemOrWhat(intArrparamCommand));
								}
							}
						}
					}
					C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
					F_StringManager.mainCanvas.showMessageBox(this);
					return;
				}
				if (inparamDisplayable == this.var_505a) {
					if (inparamCommand == this.var_506a) {
						String[] thepcc = null;
						try {

							String[] theppc = C_MainCanvas.splitStringByChar(this.var_505a
									.getString().toLowerCase(), ' ');
							if (thepcc[0].equals("win")) {
								if (this.scenarioMapIndex == 7) {
									this.var_4b4a = true;
								} else {
									completeMission();
								}
							} else if (theppc[0].equals("fps")) {
								F_StringManager.mainCanvas.setFPSOverride(Integer
										.parseInt(theppc[1]));
							} else if (theppc[0].equals("money")) {
								if (theppc[1].equals("add")) {
									if (theppc[2].equals("player")) {
										this.var_486a[this.currentPlayerId] += Integer
												.parseInt(theppc[3]);
										//break label3051; @label
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											if (this.someTeamValuesArr[paramDisplayable] == 0) {
												this.var_486a[paramDisplayable] += Integer
														.parseInt(theppc[3]);
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											this.var_486a[paramDisplayable] += Integer
													.parseInt(theppc[3]);
										}
										//break label3051;
									}
								} else if (theppc[1].equals("remove")) {
									if (theppc[2].equals("player")) {
										this.var_486a[this.currentPlayerId] -= Integer
												.parseInt(theppc[3]);
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											if (this.someTeamValuesArr[paramDisplayable] == 0) {
												this.var_486a[paramDisplayable] -= Integer
														.parseInt(theppc[3]);
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											this.var_486a[paramDisplayable] -= Integer
													.parseInt(theppc[3]);
										}
										//break label3051;
									}
								}
							} else if (theppc[0].equals("occupy")) {
								if (theppc[1].equals("house")) {
									if (theppc[2].equals("civilian")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidth; paramDisplayable++) {
											for (k = 0; k < this.mapHeight; k++) {
												if ((getMapTileType(
														paramDisplayable, k) == 8)
														&& (sub_11bae(
																paramDisplayable,
																k) == 0)) {
													changeTileToOccupiedByTeam(
															paramDisplayable,
															k,
															this.var_4832[this.currentPlayerId]);
												}
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidth; paramDisplayable++) {
											for (k = 0; k < this.mapHeight; k++) {
												if (getMapTileType(paramDisplayable,
														k) == 8) {
													changeTileToOccupiedByTeam(
															paramDisplayable,
															k,
															this.var_4832[this.currentPlayerId]);
												}
											}
										}
										//break label3051;
									}
								} else if (theppc[1].equals("castle")) {
									if (theppc[2].equals("civilian")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidth; paramDisplayable++) {
											for (k = 0; k < this.mapHeight; k++) {
												if ((getMapTileType(
														paramDisplayable, k) == 9)
														&& (sub_11bae(
																paramDisplayable,
																k) == 0)) {
													changeTileToOccupiedByTeam(
															paramDisplayable,
															k,
															this.var_4832[this.currentPlayerId]);
												}
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidth; paramDisplayable++) {
											for (k = 0; k < this.mapHeight; k++) {
												if (getMapTileType(paramDisplayable,
														k) == 9) {
													changeTileToOccupiedByTeam(
															paramDisplayable,
															k,
															this.var_4832[this.currentPlayerId]);
												}
											}
										}
										//break label3051;
									}
								}
							} else if (theppc[0].equals("unit")) {
								if (theppc[1].equals("reset")) {
									if (theppc[2].equals("current")) {
										A_Unit paramDisplayable;
										if ((paramDisplayable = getUnitAtPos(
												this.cursorPosX, this.cursorPosY,
												(byte) 0)) != null) {
											paramDisplayable.var_e83 = 0;
										}
										//break label3051;
									}
									A_Unit localClass_a_0260;
									if (theppc[2].equals("player")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											if ((localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).teamId == this.currentPlayerId) {
												localClass_a_0260.var_e83 = 0;
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											if ((localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).teamId != this.currentPlayerId) {
												localClass_a_0260.var_e83 = 0;
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											(localClass_a_0260 = (A_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).var_e83 = 0;
										}
										//break label3051;
									}
								} else if (theppc[1].equals("promote")) {
									if (theppc[2].equals("current")) {
										A_Unit paramDisplayable;
										if ((paramDisplayable = getUnitAtPos(
												this.cursorPosX, this.cursorPosY,
												(byte) 0)) != null) {
											paramDisplayable
													.setUnitLevel((byte) Integer
															.parseInt(theppc[3]));
										}
										//break label3051;
									}
									int m;
									if (theppc[2].equals("player")) {
										byte paramDisplayable = (byte) Integer
												.parseInt(theppc[3]);
										for (m = 0; m < this.mapUnitsMaybe.size(); m++) {
											A_Unit loo;
											if ((loo = (A_Unit) this.mapUnitsMaybe
													.elementAt(m)).teamId == this.currentPlayerId) {
												((A_Unit) loo)
														.setUnitLevel(paramDisplayable);
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										byte paramDisplayable = (byte) Integer
												.parseInt(theppc[3]);
										for (m = 0; m < this.mapUnitsMaybe.size(); m++) {
											A_Unit loo;
											if ((loo = (A_Unit) this.mapUnitsMaybe
													.elementAt(m)).teamId != this.currentPlayerId) {
												((A_Unit) loo)
														.setUnitLevel(paramDisplayable);
											}
										}
									//	break label3051;
									}
									if (theppc[2].equals("all")) {
										byte paramDisplayable = (byte) Integer
												.parseInt(theppc[3]);
										for (m = 0; m < this.mapUnitsMaybe.size(); m++) {
											A_Unit loo;
											(loo = (A_Unit) this.mapUnitsMaybe
													.elementAt(m))
													.setUnitLevel(paramDisplayable);
										}
									}
								}
							}
						} catch (Exception localException4) {
							return;
						}
					}
					label3051: C_MainCanvas.setDisplayableAsCurrent(F_StringManager.mainCanvas);
					F_StringManager.mainCanvas.showMessageBox(this);
				}
			}
		}
	}

	public final void itemStateChanged(Item inparamItem) {
		if (inparamItem == this.var_501a) {
			this.var_501a.getSelectedFlags(this.var_4fca);
			int paramItem = 0;
			for (int i = 0; i < this.var_4fba.length; i++) {
				if (this.var_4fba[i] > paramItem) {
					paramItem = this.var_4fba[i];
				}
			}
			if (paramItem == 0) {
				paramItem = 100;
			}
			for (int i = 0; i < this.var_4fca.length; i++) {
				if (this.var_4fca[i] != false) {
					if (this.var_4fba[i] <= 0) {
						this.var_4fba[i] = paramItem;
					}
				} else {
					this.var_4fba[i] = 0;
				}
			}
			return;
		}
		if (inparamItem == this.var_502a) {
			this.var_502a.setLabel(F_StringManager.getStrByIdAndReplaceUWith(308,
					Integer.toString(this.var_502a.getValue() + 1)));
			this.var_5032.setImage(this.var_501a.getImage(this.var_502a
					.getValue()));
			this.var_5022.setString(Integer
					.toString(this.var_4fba[this.var_502a.getValue()]));
			return;
		}
		if (inparamItem == this.var_5022) {
			if (this.var_5022.size() > 0) {
				this.var_4fba[this.var_502a.getValue()] = Integer
						.parseInt(this.var_5022.getString());
			}
		} else if (inparamItem == this.var_5062) {
			this.var_5062.setLabel(F_StringManager.getStrByIdAndReplaceUWith(315,
					Integer.toString(this.var_5062.getValue()) + "%"));
		}
	}

	private void sub_1a88b() {
		if (this.var_4fe2 != null) {
			return;
		}
		this.var_4fe2 = new Form(F_StringManager.getLangString(304));
		this.var_5002 = new TextField(F_StringManager.getLangString(294), this.mapStartUpMessage,
				100, 0);
		this.var_4fe2.append(this.var_5002);
		this.var_4fe2.addCommand(this.var_506a);
		this.var_4fe2.addCommand(this.var_5092);
		this.var_4fe2.addCommand(this.var_5072);
		this.var_4fe2.setCommandListener(this);
	}

	private void sub_1a91d() {
		if (this.var_4fea != null) {
			return;
		}
		this.var_4fea = new Form(F_StringManager.getLangString(306));
		this.var_503a = new TextField(F_StringManager.getLangString(310), "0", 20, 2);
		this.var_5042 = new TextField(F_StringManager.getLangString(311), "0", 20, 2);
		this.var_504a = new TextField(F_StringManager.getLangString(312), "0", 20, 2);
		this.var_5052 = new TextField(F_StringManager.getLangString(313), "0", 20, 2);
		this.var_4fea.append(this.var_503a);
		this.var_4fea.append(this.var_5042);
		this.var_4fea.append(this.var_504a);
		this.var_4fea.append(this.var_5052);
		this.var_4fea.addCommand(this.var_506a);
		this.var_4fea.addCommand(this.var_5072);
		this.var_4fea.setCommandListener(this);
	}

	private void sub_1aa08() {
		if (this.var_4ffa != null) {
			return;
		}
		this.var_4ffa = new Form(F_StringManager.getLangString(307));
		this.var_5062 = new Gauge("", true, 100, 100);
		this.var_5062.setLayout(2049);
		itemStateChanged(this.var_5062);
		this.var_4ffa.append(this.var_5062);
		this.var_4ffa.addCommand(this.var_506a);
		this.var_4ffa.addCommand(this.var_5072);
		this.var_4ffa.setCommandListener(this);
		this.var_4ffa.setItemStateListener(this);
	}

	private void sub_1aaa3() {
		if (this.var_4fda != null) {
			return;
		}
		this.var_4fda = new Form(F_StringManager.getLangString(303));
		this.var_501a = new ChoiceGroup(F_StringManager.getLangString(297), 2);
		if (this.var_4fba == null) {
			this.var_4fba = new int[this.tiles0Frames.length];
			for (int i = 0; i < this.var_4fba.length; i++) {
				this.var_4fba[i] = 100;
			}
		}
		this.var_4fc2 = new int[this.tiles0Frames.length];
		this.var_4fca = new boolean[this.tiles0Frames.length];
		for (int i = 0; i < this.tiles0Frames.length; i++) {
			this.var_501a.append(
					" " + F_StringManager.getStrByIdAndReplaceUWith(308, Integer.toString(i + 1))
							+ " ", this.tiles0Frames[i].createAnImage());
			this.var_501a.setSelectedIndex(i, this.var_4fba[i] > 0);
		}
		itemStateChanged(this.var_501a);
		this.var_4fda.append(this.var_501a);
		this.var_4fda.addCommand(this.var_506a);
		this.var_4fda.addCommand(this.var_508a);
		this.var_4fda.addCommand(this.var_507a);
		this.var_4fda.addCommand(this.var_5082);
		this.var_4fda.addCommand(this.var_5072);
		this.var_4fda.setCommandListener(this);
		this.var_4fda.setItemStateListener(this);
		sub_1ae84();
	}

	private void sub_1ac39() {
		this.var_4fd2 = new Form(F_StringManager.getLangString(292));
		this.var_5002 = new TextField(F_StringManager.getLangString(294), Long.toString(
				System.currentTimeMillis(), 36).toUpperCase(), 100, 0);
		int i = (this.canvasWidth + 23) / 24;
		int j = (this.canvasHeight - var_4592 + 23) / 24;
		this.var_500a = new TextField(F_StringManager.getLangString(295),
				Integer.toString(i), 3, 2);
		this.var_5012 = new TextField(F_StringManager.getLangString(296),
				Integer.toString(j), 3, 2);
		this.var_501a = new ChoiceGroup(F_StringManager.getLangString(297), 2);
		if (this.var_4fba == null) {
			this.var_4fba = new int[this.tiles0Frames.length];
			for (i = 0; i < this.var_4fba.length; i++) {
				this.var_4fba[i] = 100;
			}
		}
		this.var_4fc2 = new int[this.tiles0Frames.length];
		this.var_4fca = new boolean[this.tiles0Frames.length];
		for (i = 0; i < this.tiles0Frames.length; i++) {
			this.var_501a.append(
					" " + F_StringManager.getStrByIdAndReplaceUWith(308, Integer.toString(i + 1))
							+ " ", this.tiles0Frames[i].createAnImage());
			this.var_501a.setSelectedIndex(i, this.var_4fba[i] > 0);
		}
		itemStateChanged(this.var_501a);
		this.var_4fd2.append(this.var_5002);
		this.var_4fd2.append(this.var_500a);
		this.var_4fd2.append(this.var_5012);
		this.var_4fd2.append(this.var_501a);
		this.var_4fd2.addCommand(this.var_506a);
		this.var_4fd2.addCommand(this.var_508a);
		this.var_4fd2.addCommand(this.var_507a);
		this.var_4fd2.addCommand(this.var_5082);
		this.var_4fd2.addCommand(this.var_5072);
		this.var_4fd2.setCommandListener(this);
		this.var_4fd2.setItemStateListener(this);
		sub_1ae84();
	}

	private void sub_1ae50() {
		this.var_4fd2 = null;
		this.var_5002 = null;
		this.var_500a = null;
		this.var_5012 = null;
		this.var_501a = null;
	}

	private void sub_1ae84() {
		if (this.var_4ff2 != null) {
			return;
		}
		this.var_4ff2 = new Form(F_StringManager.getLangString(304));
		this.var_5032 = new ImageItem(null, null, 1, null);
		this.var_5032.setLayout(2049);
		this.var_502a = new Gauge("", true, this.tiles0Frames.length - 1, 0);
		this.var_502a.setLayout(2049);
		this.var_5022 = new TextField(F_StringManager.getLangString(309), "", 20, 2);
		this.var_5022.setLayout(2049);
		this.var_4ff2.append(this.var_5032);
		this.var_4ff2.append(this.var_502a);
		this.var_4ff2.append(this.var_5022);
		this.var_4ff2.addCommand(this.var_506a);
		this.var_4ff2.addCommand(this.var_5072);
		this.var_4ff2.setCommandListener(this);
		this.var_4ff2.setItemStateListener(this);
	}

	private void sub_1af6c() {
		G_Game localClass_g_1956 = this;
		this.var_4fda = null;
		localClass_g_1956.var_501a = null;
		(localClass_g_1956 = localClass_g_1956).var_4fba = null;
		localClass_g_1956.var_4fc2 = null;
		localClass_g_1956.var_4ff2 = null;
		localClass_g_1956.var_5022 = null;
		localClass_g_1956.var_502a = null;
		localClass_g_1956.var_5032 = null;
		localClass_g_1956 = this;
		this.var_4fe2 = null;
		localClass_g_1956.var_5002 = null;
		localClass_g_1956 = this;
		this.var_4fea = null;
		localClass_g_1956.var_503a = null;
		localClass_g_1956.var_5042 = null;
		localClass_g_1956.var_504a = null;
		localClass_g_1956.var_5052 = null;
		localClass_g_1956 = this;
		this.var_4ffa = null;
		localClass_g_1956.var_5062 = null;
		this.var_4f92 = 0;
	}

	private void sub_1afeb() {
		if (this.var_505a != null) {
			return;
		}
		String consoleStr = F_StringManager.getLangString(314);
		this.var_505a = new TextBox(consoleStr, "", 100, 0);
		this.var_505a.addCommand(this.var_506a);
		this.var_505a.addCommand(this.var_5072);
		this.var_505a.setCommandListener(this);
	}

	static {
		// @todo :(( many data lost upd: or moved to deslarations
		// { new int[0][], { { 150, 217, 244 }, { 65, 149, 233 }, { 0, 100, 198
		// }, { 12, 53, 112 } }, { { 244, 158, 156 }, { 219, 36, 113 }, { 161,
		// 0, 112 }, { 95, 5, 120 } }, { { 171, 237, 90 }, { 99, 190, 37 }, { 0,
		// 153, 55 }, { 0, 85, 82 } } }[4] = { { 0, 118, 150 }, { 0, 65, 114 },
		// { 0, 43, 75 }, { 0, 22, 48 } };
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_g_1956
 * 
 * JD-Core Version: 0.7.0.1
 */