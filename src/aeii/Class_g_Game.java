package aeii;

import a.a.a.Class_c_AConnection;
import a.a.a.Class_g_Sprite;

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
public final class Class_g_Game extends Class_f_StringManager implements Runnable,
		CommandListener, ItemStateListener {
	private static String[] var_4572;
	private static String[] var_457a;
	private static String[] var_4582;
	private String midletVersionAppProp = "?";
	public static byte var_4592 = 32;
	public int someCanWidth;
	public int someCanHeight;
	public int someCanWidthShift;
	private int someCanHeightShift;
	private int someSetting = 0;
	private static String[] someOneOf12LangStrings = new String[12];
	private static int[] var_45ca = { -1, -1, -1, -1, -1, -1, -1, -1 };
	private boolean[] var_45d2;
	private static int[] var_45da = { 500, 1000, 2000, 5000, 10000, 25000,
			50000, 75000, 100000, 150000, 200000 };// money skirmish
	private static int[] var_45e2 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
			110, 120, 130, 140, 150, 160, 170, 180, 190, 200 }; // units
																// skirmish
	private int var_45ea;
	private int var_45f2;
	private byte var_45fa;
	public static int var_4602 = 1024;
	public static int var_460a = 2048;
	private String[] var_4612;
	private String[] var_461a;
	public Class_d_ImageWrap[] actionIconsFrames;
	private String[] var_462a;
	private Class_d_ImageWrap[] menuIconsFrames;
	private String[] var_463a;
	private String[] var_4642;
	private byte[] var_464a;
	private byte[] var_4652;
	private byte[] var_465a;
	private static byte[][] var_4662 = { { 0, 1 }, { 2, 3, 4 }, { 0, 1 }, { 5 } };
	private static byte[] var_466a = { 0 };
	private long var_4672;
	private long var_467a;
	public static final String[] spriteColorsMaybe = { "grey", "blue", "red", "green",
			"black" }; // player group
	private static int[] var_468a = { 10526880, 26054, 15204434, 39473, 16754 };
	private static int[] var_4692 = { -1, 2, 3, 2, 3 };
	private static int[] var_469a = { -1, 4, 5, 4, 5 };
	public Class_g_Sprite[][] unitTeamSprites;
	private static byte[] var_46aa = { 1, 2 };
	public static byte[] tilesExtraDefence = { 0, 5, 10, 10, 15, 0, 5, 15, 15, 15 };
	public static byte[] tilesTypes = { 1, 1, 2, 2, 3, 3, 1, 1, 1, 1 };
	public Class_d_ImageWrap[] smallTilesFrames;
	public byte[] tilesDefs;
	private int var_46d2;
	private int var_46da;
	private int mapLeftX;
	private int mapTopY;
	public int mapWidthMaybe;
	public int mapHeightMaybe;
	private Class_d_ImageWrap tombStoneImage;
	private Class_d_ImageWrap[] tiles0Frames;
	private Class_g_Sprite cursorSprite;
	private Class_g_Sprite currentCursorSpriteMaybe;
	public Class_g_Sprite sideArrowSprite;
	public Class_g_Sprite arrowSprite;
	public Class_g_Sprite buttonsSprite;
	public Class_g_Sprite menuSprite;
	public Class_g_Sprite smokeSprite;
	public Class_g_Sprite sparkSprite;
	public Class_g_Sprite redsparkSprite;
	private Class_g_Sprite statusSprite;
	public Class_g_Sprite smallSparkSprite;
	public Class_g_Sprite portraitsSprite;
	public int cursorPosX;
	public int cursorPosY;
	public byte[][] var_4782;
	private byte var_478a;
	private byte var_4792;
	public long var_479a;
	private int var_47a2;
	private int var_47aa;
	private int var_47b2;
	private Class_a_Unit[] var_47ba;
	private Class_a_Unit someActiveUnit;
	private int var_47ca;
	private int var_47d2;
	public byte[][] var_47da;
	private boolean var_47e2;
	private boolean var_47ea;
	private boolean var_47f2;
	public Vector mapUnitsMaybe;
	private Vector var_4802;
	private int var_480a;
	private int var_4812;
	private long var_481a;
	private byte teamsCountMaybe;
	private byte[] var_482a;
	public byte[] var_4832;
	public byte[] var_483a;
	public byte someUnitTeamId;
	private short var_484a;
	private Class_a_Unit[] maybeTeamKings;
	public Class_a_Unit[][] teamsUnits;
	public int[] teamsUnitsCount;
	public int[] var_486a;
	private byte[][] var_4872;
	private byte[] var_487a;
	private Class_e_FightAnimation var_4882;
	private Vector var_488a;
	private Vector spritesVector;
	private Class_a_Unit var_489a;
	private Class_a_Unit var_48a2;
	private long var_48aa;
	private Class_a_Unit var_48b2;
	private byte var_48ba;
	private long var_48c2;
	private int var_48ca;
	private boolean var_48d2;
	private boolean var_48da;
	private byte var_48e2;
	private Class_d_ImageWrap msLogoImage;
	private Class_d_ImageWrap var_48f2;
	private Class_d_ImageWrap var_48fa;
	private Class_d_ImageWrap var_4902;
	private int var_490a;
	private boolean var_4912;
	private int var_491a;
	private int var_4922;
	private int var_492a;
	private long var_4932;
	private Class_a_Unit var_493a;
	private Class_a_Unit var_4942;
	private boolean var_494a;
	private long var_4952;
	private boolean var_495a;
	private long var_4962;
	private int var_496a; // int j
	private int var_4972;
	private Class_d_ImageWrap[] var_497a;
	private boolean var_4982;
	private boolean var_498a;
	private static int[] var_4992 = { 85, 83, 83, 83, 83, 83, 83, 83, 83, 175,
			84, 84, 84, 175, 147, 159, 151, 155, 167, 171 };
	private static int[] var_499a = { 15, 196, 197, 198, 199, 200, 201, 202,
			203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214 };
	private int var_49a2;
	private Class_e_FightAnimation var_49aa;
	private Class_e_FightAnimation var_49b2;
	private Class_e_FightAnimation var_49ba;
	private Class_e_FightAnimation var_49c2;
	public int var_49ca;
	private Class_e_FightAnimation var_49d2;
	private Class_e_FightAnimation var_49da;
	private Class_e_FightAnimation var_49e2;
	private boolean var_49ea;
	private int var_49f2;
	private byte[][] var_49fa;
	private byte[][] var_4a02;
	public Class_g_Sprite bigCircleSprite;
	public Class_g_Sprite smallCircleSprite;
	private Class_a_Unit unitAtCursorPos;
	public Class_g_Sprite hudIconsSprite;
	public Class_g_Sprite hudIcons2Sprite;
	private int var_4a32;
	private int var_4a3a;
	private int var_4a42;
	private boolean var_4a4a;
	private int var_4a52;
	private boolean var_4a5a;
	public Class_g_Sprite miniIconsSprite;
	private Class_g_Sprite[] var_4a6a;
	public Class_g_Sprite bSmokeSprite;
	private Class_e_FightAnimation var_4a7a;
	private Class_e_FightAnimation var_4a82;
	private Class_e_FightAnimation var_4a8a;
	private Class_e_FightAnimation var_4a92;
	private Class_e_FightAnimation[] var_4a9a;
	private Class_e_FightAnimation[] var_4aa2;
	private Class_e_FightAnimation var_4aaa;
	private Class_e_FightAnimation[] var_4ab2;
	private Class_g_Sprite alphaMaskSprite;
	private int var_4ac2;
	private boolean var_4aca;
	private boolean var_4ad2;
	private boolean var_4ada;
	private Vector var_4ae2;
	private Class_g_Sprite levelUpSprite;
	private int var_4af2;
	public Class_g_Sprite[] kingHeadsIcons;
	private Class_e_FightAnimation var_4b02;
	private Class_e_FightAnimation var_4b0a;
	private Class_e_FightAnimation var_4b12;
	private Class_e_FightAnimation var_4b1a;
	public Class_g_Sprite arrowIconsSprite;
	private Class_g_Sprite var_4b2a;
	private Class_a_Unit var_4b32;
	private int var_4b3a;
	private boolean var_4b42;
	private boolean var_4b4a;
	private String var_4b52;
	private String[] saveSlotsDescriptions;
	private byte[] saveSlotBytes;
	private int[] saveSlotsMapIds;
	private Class_e_FightAnimation var_4b72;
	private Class_e_FightAnimation var_4b7a;
	private Class_e_FightAnimation var_4b82;
	private Class_e_FightAnimation var_4b8a;
	private Class_e_FightAnimation var_4b92;
	private Class_e_FightAnimation var_4b9a;
	private Class_e_FightAnimation var_4ba2;
	private byte var_4baa;
	private byte[] var_4bb2;
	private int settingsCountMaybe;
	private String[] settingsStrListMaybe;
	private int[] settingsIntListMaybe;
	private String[] var_4bd2;
	private String[] var_4bda;
	private Class_e_FightAnimation var_4be2;
	private Class_e_FightAnimation var_4bea;
	private Class_e_FightAnimation var_4bf2;
	private Class_e_FightAnimation var_4bfa;
	private Class_e_FightAnimation var_4c02;
	private Class_e_FightAnimation var_4c0a;
	private Class_e_FightAnimation var_4c12;
	private Class_e_FightAnimation var_4c1a;
	private int var_4c22;
	private String var_4c2a;
	private int downloadAvailableSize;
	private boolean msHighScoreUploadAppProp;
	private boolean var_4c42;
	private boolean var_4c4a;
	private Class_d_ImageWrap gameOverImage;
	private Image[][] var_4c5a;
	private int loadingProgress;
	private Class_a_Unit var_4c6a;
	private int var_4c72;
	private int var_4c7a;
	private boolean var_4c82;
	private int var_4c8a;
	private int var_4c92;
	private int var_4c9a;
	private int var_4ca2;
	private int var_4caa;
	private Class_d_ImageWrap introImage;
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
	private Class_a_Unit var_4d3a;
	private Class_a_Unit var_4d42;
	private Class_a_Unit var_4d4a;
	private int var_4d52;
	private long var_4d5a; // long j
	private Class_a_Unit[] var_4d62;
	private Class_a_Unit[] var_4d6a;
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
	private int var_4dd2;
	private Class_e_FightAnimation var_4dda;
	private Class_a_Unit var_4de2;
	private Class_a_Unit var_4dea;
	private Class_a_Unit var_4df2;
	private Class_a_Unit var_4dfa;
	private Class_a_Unit var_4e02;
	public Class_a_Unit var_4e0a;
	private int var_4e12;
	private String[][][] someScriptStrings;
	private long var_4e22; // long k
	private int var_4e2a;
	private boolean var_4e32;
	private boolean var_4e3a;
	private int var_4e42;
	private int var_4e4a;
	private int var_4e52;
	private Class_h_0417 var_4e5a;
	private Class_h_0417 var_4e62;
	private long var_4e6a;
	private boolean var_4e72;
	private Vector spritesList;
	private boolean var_4e82;
	private long var_4e8a;
	private long var_4e92;
	private boolean var_4e9a;
	private boolean var_4ea2;
	private boolean var_4eaa;
	public boolean var_4eb2;
	public int var_4eba;
	private int var_4ec2;
	private int var_4eca;
	private String[] var_4ed2;
	private String[] var_4eda;
	private String[] var_4ee2;
	private String[] var_4eea;
	private String[] var_4ef2;
	private int[] var_4efa;
	private String provisionHighscorePortalCodeAppProp;
	private String provisionHighscoreGameCodeAppProp;
	private String provisionHighscoreUrlAppProp;
	private ByteArrayOutputStream var_4f1a;
	private DataOutputStream var_4f22;
	private int var_4f2a;
	private boolean var_4f32;
	private Class_f_StringManager var_4f3a;
	private int var_4f42;
	private Class_e_FightAnimation var_4f4a;
	private Class_e_FightAnimation var_4f52;
	private Class_e_FightAnimation var_4f5a;
	private Class_e_FightAnimation var_4f62;
	private Class_b_FilesManager var_4f6a;
	private String[] var_4f72;
	private byte cursorTileId;
	private byte someUnitTypeId;
	private Class_a_Unit var_4f8a;
	private byte var_4f92;
	private Class_e_FightAnimation var_4f9a;
	private Class_e_FightAnimation var_4fa2;
	private Class_e_FightAnimation var_4faa;
	private Class_e_FightAnimation var_4fb2;
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

	public Class_g_Game() {
		var_4572 = new String[] { ".." };
		var_457a = new String[] { Class_f_StringManager.getLangString(300), ".." };
		var_4582 = new String[] { Class_f_StringManager.getLangString(305),
				Class_f_StringManager.getLangString(306), Class_f_StringManager.getLangString(307),
				Class_f_StringManager.getLangString(303), Class_f_StringManager.getLangString(70),
				Class_f_StringManager.getLangString(293), Class_f_StringManager.getLangString(60) };
		this.var_4f92 = 0;
		this.var_506a = new Command(Class_f_StringManager.getLangString(12), 4, 1);
		this.var_5072 = new Command(Class_f_StringManager.getLangString(13), 3, 5);
		this.var_507a = new Command(Class_f_StringManager.getLangString(301), 4, 3);
		this.var_5082 = new Command(Class_f_StringManager.getLangString(302), 4, 4);
		this.var_508a = new Command(Class_f_StringManager.getLangString(304), 4, 2);
		this.var_5092 = new Command(Class_f_StringManager.getLangString(316), 4, 2);
		if (Class_c_MainCanvas.propDeveloperModeOn) {
			this.var_4612 = new String[] { Class_f_StringManager.getLangString(66),
					Class_f_StringManager.getLangString(70), Class_f_StringManager.getLangString(71),
					Class_f_StringManager.getLangString(4), Class_f_StringManager.getLangString(314),
					Class_f_StringManager.getLangString(60) };
		} else {
			this.var_4612 = new String[] { Class_f_StringManager.getLangString(66),
					Class_f_StringManager.getLangString(70), Class_f_StringManager.getLangString(71),
					Class_f_StringManager.getLangString(4), Class_f_StringManager.getLangString(60) };
		}
		this.var_461a = new String[] { Class_f_StringManager.getLangString(63),
				Class_f_StringManager.getLangString(67), Class_f_StringManager.getLangString(68),
				Class_f_StringManager.getLangString(62), Class_f_StringManager.getLangString(69),
				Class_f_StringManager.getLangString(61), Class_f_StringManager.getLangString(64) };
		this.actionIconsFrames = new Class_d_ImageWrap[this.var_461a.length];
		this.var_462a = new String[] { Class_f_StringManager.getLangString(1),
				Class_f_StringManager.getLangString(2), Class_f_StringManager.getLangString(5),
				Class_f_StringManager.getLangString(3), Class_f_StringManager.getLangString(6),
				Class_f_StringManager.getLangString(8), Class_f_StringManager.getLangString(7),
				Class_f_StringManager.getLangString(9), Class_f_StringManager.getLangString(10),
				Class_f_StringManager.getLangString(11), Class_f_StringManager.getLangString(4) };
		this.menuIconsFrames = new Class_d_ImageWrap[this.var_462a.length];
		this.var_463a = new String[] { Class_f_StringManager.getLangString(35),
				Class_f_StringManager.getLangString(36), Class_f_StringManager.getLangString(37) };
		this.var_4642 = new String[] { Class_f_StringManager.getLangString(29),
				Class_f_StringManager.getLangString(30) };
		this.var_464a = new byte[] { 0, 6, 5, 7, 8, 9 };
		this.var_4652 = new byte[] { 0, 6, 5, 7, 8, 9 };
		this.var_465a = new byte[] { 1, 2, 3, 4 };
		this.var_4672 = 0L;
		this.var_47e2 = false;
		this.var_47ea = false;
		this.var_47f2 = true;
		this.mapUnitsMaybe = new Vector();
		this.teamsCountMaybe = 2;
		this.var_482a = new byte[5];
		this.var_4832 = new byte[4];
		this.var_483a = new byte[4];
		this.someUnitTeamId = 0;
		this.var_486a = new int[4];
		this.var_4872 = new byte[4][2];
		this.var_487a = new byte[4];
		this.var_488a = new Vector();
		this.spritesVector = new Vector();
		this.var_48d2 = false;
		this.var_48da = false;
		this.var_4912 = false;
		this.var_494a = true;
		this.var_495a = false;
		this.var_4982 = false;
		this.var_49a2 = -1;
		this.var_49ca = 8;
		this.var_49ea = false;
		this.var_4a4a = true;
		this.var_4a6a = new Class_g_Sprite[0];
		this.var_4ae2 = new Vector(2);
		this.var_4b3a = 0;
		this.var_4b42 = true;
		this.var_4bd2 = new String[] { Class_f_StringManager.getLangString(46),
				Class_f_StringManager.getLangString(47), Class_f_StringManager.getLangString(291) };
		this.var_4bda = new String[] { Class_f_StringManager.getLangString(289),
				Class_f_StringManager.getLangString(298), Class_f_StringManager.getLangString(48),
				Class_f_StringManager.getLangString(49) };
		this.msHighScoreUploadAppProp = true;
		this.var_4c42 = true;
		this.var_4c4a = true;
		new StringBuffer();
		this.var_4c6a = null;
		this.var_4c72 = 12;
		this.var_4c7a = 1;
		this.var_4cea = 0;
		this.var_4cfa = 24;
		this.var_4d02 = 8;
		this.var_4d0a = (this.var_4d02 >> 1);
		this.var_4d22 = 0;
		this.var_4dca = false;
		this.var_4e02 = null;
		this.var_4e0a = null;
		this.var_4e32 = false;
		this.var_4e3a = false;
		this.var_4e42 = -1;
		this.var_4e4a = -1;
		this.var_4e52 = 0;
		this.spritesList = new Vector();
		this.var_4e82 = false;
		this.provisionHighscorePortalCodeAppProp = "Macrospace";
		this.provisionHighscoreGameCodeAppProp = "msaeii";
		this.provisionHighscoreUrlAppProp = "http://msaeii.scores.macrospace.com/connectx/in";
		this.var_48e2 = 4;
	}

	public final void loadingProcess() {
		setLoadProgress(0);
		Class_c_MainCanvas.initResPak();
		setLoadProgress(18);
		Class_c_MainCanvas.createMusicPlayers();
		for (int i = 0; i < Class_c_MainCanvas.musicThemesStrings.length; i++) {
			Class_c_MainCanvas.initMusicPlayer(i);
			setLoadProgress(i + 19);
		}
		setLoadProgress(28);
		Class_e_FightAnimation.var_1012 = this;
		setLoadProgress(29);
		Class_f_StringManager.sub_e73();
		setLoadProgress(30);
		Class_c_MainCanvas.sub_28be();
		setLoadProgress(32);

		this.actionIconsFrames = new Class_g_Sprite("action_icons").frameImages;
		setLoadProgress(34);
		this.menuIconsFrames = new Class_g_Sprite("menu_icons").frameImages;
		setLoadProgress(36);
		this.hudIconsSprite = new Class_g_Sprite("hud_icons");
		setLoadProgress(38);
		this.hudIcons2Sprite = new Class_g_Sprite("hud_icons_2");
		setLoadProgress(40);
		this.arrowSprite = new Class_g_Sprite("arrow");
		setLoadProgress(42);
		this.sideArrowSprite = new Class_g_Sprite("side_arrow");
		setLoadProgress(44);
		this.buttonsSprite = new Class_g_Sprite("buttons");
		setLoadProgress(46);
		this.menuSprite = new Class_g_Sprite("menu");
		setLoadProgress(48);
		this.bigCircleSprite = new Class_g_Sprite("big_circle");
		setLoadProgress(50);
		this.smallCircleSprite = new Class_g_Sprite("small_circle");
		setLoadProgress(52);
		this.smallSparkSprite = new Class_g_Sprite("small_spark");
		setLoadProgress(54);
		this.alphaMaskSprite = new Class_g_Sprite("alpha");
		setLoadProgress(56);
		try {
			this.gameOverImage = new Class_d_ImageWrap("gameover");
		} catch (Exception localException1) {
			//
		}
		setLoadProgress(58);
		this.msLogoImage = new Class_d_ImageWrap("ms_logo");
		setLoadProgress(62);
		
		InputStream tilesStream = Class_c_MainCanvas.getResourceStream("tiles0.prop");
		if (tilesStream != null) {
			String tilesPropString = Class_c_MainCanvas.streamToString((InputStream) tilesStream);
			while (tilesPropString != null) {
				int eolnIndex = tilesPropString.indexOf(';');
				if (eolnIndex >= 0) {
					tilesPropString = tilesPropString.substring(0, eolnIndex);
				}
				if ((tilesPropString = tilesPropString.trim()).length() != 0) {
					String[] lineStrs = Class_c_MainCanvas.splitStringByChar(tilesPropString, ' ');
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
						Class_c_MainCanvas.getResourceStream("tiles0.bin"));
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
		Class_g_Sprite stiles0Sprite = new Class_g_Sprite("stiles0");
		this.smallTilesFrames = stiles0Sprite.frameImages;
		setLoadProgress(70);
		this.miniIconsSprite = new Class_g_Sprite("mini_icons");
		setLoadProgress(72);
		this.tiles0Frames = new Class_g_Sprite("tiles0").frameImages;
		this.someCanWidth = this.canvasWidth;
		this.someCanHeight = this.canvasHeight;
		this.someCanWidthShift = (this.someCanWidth >> 1);
		this.someCanHeightShift = (this.someCanHeight >> 1);
		this.var_490a = 0;
		for (int m = 0; m < 12; m++) {
			someOneOf12LangStrings[m] = Class_f_StringManager.getLangString(m + 101);
		}
		loadSettings();
		setLoadProgress(74);
		try {
			this.someSetting = Class_c_MainCanvas.getRecordData("settings", 1)[0];
		} catch (Exception ex2) {
			//
		}
		setLoadProgress(76);
		this.settingsStrListMaybe = new String[0];
		this.settingsIntListMaybe = new int[0];
		byte[] saveSlotBytes;
		try {
			saveSlotBytes = Class_c_MainCanvas.getRecordData("settings", 2);
			DataInputStream settingsDIS = new DataInputStream(new ByteArrayInputStream(
					saveSlotBytes));
			this.settingsCountMaybe = settingsDIS.readInt();
			this.settingsIntListMaybe = new int[this.settingsCountMaybe];
			this.settingsStrListMaybe = new String[this.settingsCountMaybe];
			for (int k = 0; k < this.settingsCountMaybe; k++) {
				this.settingsIntListMaybe[k] =  settingsDIS.readInt();
				this.settingsStrListMaybe[k] =  settingsDIS.readUTF();
			}
			settingsDIS.close();
		} catch (Exception localException3) {
			//
		}
		setLoadProgress(80);
		this.downloadAvailableSize = Class_c_MainCanvas.getAvailableRecordSize("download");
		setLoadProgress(84);
		this.saveSlotsDescriptions = new String[10];
		this.saveSlotBytes = new byte[10];
		this.saveSlotsMapIds = new int[10];
		for (int it = 0; it < 10; it++) {
			this.saveSlotBytes[it] = -1;
			this.saveSlotsMapIds[it] = -1;
			saveSlotBytes = null;
			try {
				saveSlotBytes = Class_c_MainCanvas.getRecordData("save", it);
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
				String noSavedGamesStr = Class_f_StringManager.getLangString(79);
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
		Class_c_MainCanvas.playMusicLooped(0, 0);
		this.var_48e2 = 0;
	}

	private void setLoadProgress(int progress) {
		this.loadingProgress = progress;
		Class_f_StringManager.mainCanvas.repaintAll();
	}

	private String getSaveSlotDescription(int modeId, int mapId, int turnsCount) {
		String mapName;
		if (modeId == 0) {
			mapName = Class_f_StringManager.getLangString(mapId + 121);
		} else {
			mapName = sub_75cb(mapId);
		}
		String modeStr = Class_f_StringManager.getLangString(modeId + 32);
		return modeStr + "\n" + mapName + "\n"
				+ "Current turn: " + (turnsCount + 1);
	}

	private boolean sub_5d81() {
		return (this.var_4a4a) && (Class_f_StringManager.mainCanvas.var_17b7 == this);
	}

	private void sub_5dc1() {
		this.msLogoImage = null;
		this.var_48f2 = null;
		this.var_48fa = null;
		this.var_4902 = null;
		System.gc();
		this.someCanHeight = (this.canvasHeight - var_4592);
		this.someCanHeightShift = (this.someCanHeight >> 1);
		Class_c_MainCanvas.stopCurrentMusicPlayer();
		if (this.var_48e2 != 1) {
			this.var_48e2 = 1;
			Class_a_Unit.initializeUnitsData(this);
			Class_c_MainCanvas.initResPak();
			this.unitTeamSprites = new Class_g_Sprite[5][12];
			for (byte b = 0; b < 5; b = (byte) (b + 1)) {
				Class_g_Sprite unitIconsSprite = new Class_g_Sprite("unit_icons", b);
				int unitsCount = 12; //@todo move
				int unitFramesCount = unitIconsSprite.getImagesCount() / unitsCount;
				for (int unitInd = 0; unitInd < unitsCount; unitInd = (byte) (unitInd + 1)) {
					Class_d_ImageWrap[] images;
					if (b == 0) {
						images = new Class_d_ImageWrap[] { unitIconsSprite.frameImages[unitInd] };
						this.unitTeamSprites[b][unitInd] = new Class_g_Sprite(
								images);
					} else {
						images = new Class_d_ImageWrap[unitFramesCount];
						for (int frameInd = 0; frameInd < unitFramesCount; frameInd++) {
							images[frameInd] = unitIconsSprite.frameImages[(frameInd * unitsCount + unitInd)];
						}
						this.unitTeamSprites[b][unitInd] = new Class_g_Sprite(
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
			this.portraitsSprite = new Class_g_Sprite("portraits");
			this.cursorSprite = new Class_g_Sprite("cursor");
			this.redsparkSprite = new Class_g_Sprite("redspark");
			this.smokeSprite = new Class_g_Sprite("smoke");
			this.sparkSprite = new Class_g_Sprite("spark");
			this.statusSprite = new Class_g_Sprite("status");
			this.arrowIconsSprite = new Class_g_Sprite("arrow_icons");
			this.tombStoneImage = new Class_d_ImageWrap("tombstone");
			this.levelUpSprite = new Class_g_Sprite("levelup");
			this.kingHeadsIcons = new Class_g_Sprite[2];
			this.kingHeadsIcons[0] = new Class_g_Sprite("king_head_icons");
			this.kingHeadsIcons[1] = new Class_g_Sprite("king_head_icons");//@todo load gray_ ("king_head_icons",
																	// 0);
			this.cursorSprite.setFrameSequence(var_4662[0]);
			this.currentCursorSpriteMaybe = new Class_g_Sprite(this.cursorSprite);
			this.currentCursorSpriteMaybe.setFrameSequence(var_4662[3]);
			this.var_497a = new Class_d_ImageWrap[2];
			this.var_4972 = var_46aa[0];
			this.var_497a[0] = this.tiles0Frames[var_46aa[0]];
			this.var_497a[1] = this.tiles0Frames[var_46aa[1]];
			this.bSmokeSprite = new Class_g_Sprite("b_smoke");
		}
	}

	@Override
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

			this.var_45fa = dis.readByte();
			this.var_47a2 = dis.readByte();
			this.teamsCountMaybe = dis.readByte();
			sub_aca4(this.var_47a2);
			this.someUnitTeamId = dis.readByte();
			dis.readByte();
			this.var_484a = dis.readShort();
			this.var_49ca = dis.readByte();
			this.teamsCountMaybe = dis.readByte();
			for (int i = 0; i < this.teamsCountMaybe; i++) {
				this.var_483a[i] = dis.readByte();
				this.var_487a[i] = dis.readByte();
				this.var_486a[i] = dis.readInt();
				this.var_4872[i][0] = dis.readByte();
				this.var_4872[i][1] = dis.readByte();
			}
			this.var_45f2 = dis.readShort();
			for (int i = 0; i < this.var_49fa.length; i++) {
				this.var_4782[this.var_49fa[i][0]][this.var_49fa[i][1]] = dis
						.readByte();
			}
			this.teamsUnits = new Class_a_Unit[this.teamsCountMaybe][4];
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
				Class_a_Unit unit = Class_a_Unit.createUnit(unitType, teamId, posX, posY);
				unit.var_e83 = k;
				unit.maybeExperience = unitExp;
				unit.setUnitLevel(unitLvl);
				unit.var_e8b = b3;
				unit.sub_160c();
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
			this.var_4e12 = dis.readShort();
			this.var_4e22 = dis.readInt();
			this.var_4e2a = dis.readInt();
			this.var_4e32 = (dis.readByte() != 0);
			dis.close();
			if ((this.var_47a2 == 6) && (this.var_4e12 > 32)) {
				this.var_49c2 = sub_14359(
						Class_f_StringManager.getLangString(121 + this.var_47a2),
						Class_f_StringManager.getLangString(138), this.someCanHeight, -1);
				this.var_49c2.sub_132e((byte) 0, true);
				this.var_49c2.sub_1350(null);
			}
			moveCursorToPos(this.var_4872[this.someUnitTeamId][0],
					this.var_4872[this.someUnitTeamId][1]);
			sub_efe5(this.var_4872[this.someUnitTeamId][0],
					this.var_4872[this.someUnitTeamId][1]);
			Class_c_MainCanvas.sub_2bf1(var_4692[this.var_4832[this.someUnitTeamId]], 0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* Error */
	private void sub_6431(int paramInt, Class_f_StringManager paramClass_f_0145) {
		// ByteCodeError 1 @error
	}

	private static void loadSettings() {
		try {
			byte[] setBytes = Class_c_MainCanvas.getRecordData("settings", 0);
			for (int i = 0; i < 4; i++) {
				Class_c_MainCanvas.settings[i] = ((setBytes[0] & 1 << i) != 0 ? true
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
				if (Class_c_MainCanvas.settings[i] != false) {
					setBytes[0] = ((byte) (setBytes[0] | 1 << i));
				}
			}
			Class_c_MainCanvas.addSomeRecords("settings", 0, setBytes);
			return;
		} catch (Exception ex) {
			//
		}
	}

	private void sub_6963(Class_a_Unit unit) {
		this.var_4b3a = 0;
		moveCursorToPos(unit.posX, unit.posY);
		this.var_4b32 = unit;
	}

	private void sub_6994(Class_a_Unit paramClass_a_02601,
			Class_a_Unit paramClass_a_02602) {
		if (paramClass_a_02602.var_e83 == 4) {
			this.var_48a2 = paramClass_a_02602;
			showSpriteOnMap(this.redsparkSprite, this.var_48a2.pixelX, this.var_48a2.pixelY, 0, 0, 1,
					50); // m n
			this.var_48ca = 6;
			this.someActiveUnit.sub_26fe();
			this.var_478a = 0;
			sub_bc72();
			this.cursorSprite.setFrameSequence(var_4662[0]);
			if (this.var_487a[this.someUnitTeamId] == 0) {
				this.var_4d5a = this.var_479a;
				this.var_4d22 = 6;
			}
		} else {
			if ((Class_c_MainCanvas.settings[3] != false)
					&& (paramClass_a_02602.chars.length > 0)) // n
			{
				this.var_4912 = true;
				this.var_491a = 0;
				Class_c_MainCanvas.stopCurrentMusicPlayer();
			} else {
				this.var_478a = 13;
				this.var_492a = 0;
				this.cursorSprite.setFrameSequence(var_4662[0]);
			}
			this.var_493a = paramClass_a_02601;
			this.var_4942 = paramClass_a_02602;
		}
	}

	private void sub_6a9a() {
		sub_bc72();
		if (this.var_493a.health <= 0) {
			this.var_489a = this.var_493a;
		} else if (this.var_493a.unitGotNewLevel()) {
			this.var_4ae2.addElement(this.var_493a);
		}
		if (this.var_4942.health <= 0) {
			this.var_489a = this.var_4942;
		} else {
			if (this.var_493a.hasProperty((short) 128)) {
				showSpriteOnMap(this.sparkSprite, this.var_4942.pixelX, this.var_4942.pixelY, 0, 0,
						1, 50); // m n
				Class_g_Sprite localClass_g_2517;
				(localClass_g_2517 = Class_g_Sprite.sub_2054(this.statusSprite, 0, 0,
						-4, -1, 800, (byte) 5)).setPixelPosition(this.var_4942.pixelX
						+ (this.var_4942.spriteFrameWidth - localClass_g_2517.spriteFrameWidth) / 2,
						this.var_4942.pixelY - localClass_g_2517.spriteFrameHeight);
				localClass_g_2517.setFrameSequence(var_466a);
				this.var_488a.addElement(localClass_g_2517);
				this.var_4942.sub_1595((byte) 1);
			}
			if (this.var_4942.unitGotNewLevel()) {
				this.var_4ae2.addElement(this.var_4942);
			}
		}
		if (this.var_489a != null) {
			moveCursorToPos(this.var_489a.posX, this.var_489a.posY);
			showSpriteOnMap(this.sparkSprite, this.var_489a.pixelX, this.var_489a.pixelY, 0, 0, 1,
					50);
			Class_c_MainCanvas.playMusicLooped(12, 1);
		}
		this.var_48aa = this.var_479a;
		if (this.var_487a[this.someUnitTeamId] == 0) {
			this.var_4d5a = this.var_479a;
			this.var_4d22 = 6;
		}
		this.cursorSprite.setFrameSequence(var_4662[0]);
		this.var_478a = 0;
		this.var_493a.sub_26fe();
		this.var_4942 = null;
		this.var_493a = null;
	}

	public final Class_g_Sprite showSpriteOnMap(Class_g_Sprite inSpite,
			int pixX, int pixY, int paramInt3, int paramInt4,
			int paramInt5, int paramInt6) {
		Class_g_Sprite sprite = Class_g_Sprite.sub_2054(inSpite,
				paramInt3, paramInt4, 0, paramInt5, paramInt6, (byte) 0);
		sprite.setPixelPosition(pixX, pixY);
		this.spritesVector.addElement(sprite);
		return sprite;
	}

	private void sub_6c83(Class_a_Unit paramClass_a_0260) {
		this.var_48da = true;
		this.var_48d2 = (!this.var_49ea);
		this.var_4c8a = 12;
		this.var_478a = 1;
		this.var_495a = true;
		sub_bcb2(this.var_47da, 0);
		paramClass_a_0260.sub_20f8(this.var_47da);
		this.var_47e2 = true;
		this.var_47ea = false;
		this.cursorSprite.setFrameSequence(var_4662[2]);
	}

	private void sub_6d11(byte[] paramArrayOfByte, int paramInt1,
			int paramInt2, Class_f_StringManager paramClass_f_0145) {
		Class_e_FightAnimation localClass_e_0134 = new Class_e_FightAnimation((byte) 0, 0);
		this.var_4a32 = paramInt1;
		this.var_4a3a = paramInt2;
		paramInt1 = paramArrayOfByte.length;
		Vector vec2;
		vec2 = new Vector(paramInt1);
		Vector localVector = new Vector(paramInt1);
		for (int i = 0; i < paramInt1; i++) {
			int j = paramArrayOfByte[i];
			if ((this.msHighScoreUploadAppProp) || (j != 6)) {
				vec2.addElement(this.var_462a[j]);
				localVector.addElement(this.menuIconsFrames[j]);
			}
		}
		String[] arrayOfString = new String[vec2.size()];
		Class_d_ImageWrap[] arrayOfClass_d_0033 = new Class_d_ImageWrap[localVector
				.size()];
		vec2.copyInto(arrayOfString);
		localVector.copyInto(arrayOfClass_d_0033);
		localClass_e_0134.sub_224f(arrayOfString, arrayOfClass_d_0033,
				this.canvasWidthShift, this.var_4a32, this.var_4a3a, 3, (byte) 1);
		localClass_e_0134.sub_1350(paramClass_f_0145);
		Class_f_StringManager.mainCanvas.sub_220e(localClass_e_0134);
	}

	private void sub_6e49(byte[] paramArrayOfByte) {
		this.var_4882 = new Class_e_FightAnimation((byte) 0, 0);
		int i;
		String[] arrayOfString = new String[i = paramArrayOfByte.length];
		Class_d_ImageWrap[] arrayOfClass_d_0033 = new Class_d_ImageWrap[i];
		for (int j = 0; j < paramArrayOfByte.length; j++) {
			arrayOfString[j] = this.var_461a[paramArrayOfByte[j]];
			arrayOfClass_d_0033[j] = this.actionIconsFrames[paramArrayOfByte[j]];
		}
		if (this.cursorPosY * 24 <= this.someCanHeight / 2 - 24) {
			this.var_4882.sub_1e54(arrayOfString, arrayOfClass_d_0033, 0,
					this.someCanHeight - this.buttonsSprite.spriteFrameHeight, 36);
		} else {
			this.var_4882.sub_1e54(arrayOfString, arrayOfClass_d_0033,
					this.someCanWidth, 0, 8);
		}
		this.var_4882.sub_1350(this);
		Class_f_StringManager.mainCanvas.sub_220e(this.var_4882);
	}

	private Class_e_FightAnimation sub_6f4c(String paramString,
			Class_d_ImageWrap paramClass_d_0033) {
		String[] arrayOfString = new String[10];
		for (int j = 0; j < 10; j++) {
			arrayOfString[j] = ("SLOT " + (j + 1) + "/" + 10);
		}
		this.var_4b82 = new Class_e_FightAnimation((byte) 14, 0);
		this.var_4b82.sub_1f72(arrayOfString, this.someCanWidth, -1);
		this.var_4b8a = new Class_e_FightAnimation((byte) 10, 0);
		this.var_4b8a.sub_1ca8(null, this.saveSlotsDescriptions[0], this.someCanWidth, -1);
		if (this.saveSlotBytes[0] != -1) {
			this.var_4b8a.var_11a2 = var_468a[this.saveSlotBytes[0]];
		}
		Class_e_FightAnimation localClass_e_01341 = new Class_e_FightAnimation((byte) 15, 15);
		int i = (this.someCanHeight - this.var_4b82.var_1042 - this.var_4b8a.var_1042) / 2;
		Class_e_FightAnimation localClass_e_01342;
		(localClass_e_01342 = new Class_e_FightAnimation((byte) 10, 0)).sub_1ca8(null,
				paramString, this.someCanWidth, -1);
		localClass_e_01342.var_11b2 = paramClass_d_0033;
		localClass_e_01341.sub_1698(localClass_e_01342, 0, 0, 0);
		i += localClass_e_01342.var_1042 / 2;
		localClass_e_01341.sub_1698(this.var_4b82, 0, i, 0);
		i += this.var_4b82.var_1042;
		localClass_e_01341.sub_1698(this.var_4b8a, 0, i, 20);
		localClass_e_01341.var_115a = true;
		localClass_e_01341.sub_132e((byte) 0, true);
		return localClass_e_01341;
	}

	private void sub_70c0(Class_f_StringManager paramClass_f_0145) {
		int i;
		String[] localObject1 = new String[i = this.var_4eea.length];
		int[] arrayOfInt2 = new int[i];
		int k = 0;
		for (int m = 0; m < i; m++) {
			int n = 0;
			int i1 = 0;
			while (i1 < this.settingsCountMaybe) {
				if (!this.var_4eea[m].equals(this.settingsStrListMaybe[i1])) {
					i1++;
				} else {
					n = 1;
				}
			}
			if (n == 0) {
				localObject1[k] = this.var_4eea[m];
				arrayOfInt2[k] = m;
				k++;
			}
		}
		this.var_4c0a = new Class_e_FightAnimation((byte) 15, 15);
		Class_e_FightAnimation localClass_e_0134;
		(localClass_e_0134 = new Class_e_FightAnimation((byte) 10, 0)).sub_1ca8(null,
				Class_f_StringManager.getLangString(48), this.someCanWidth, -1);
		Object localObject2;
		if (k == 0) {
			Class_e_FightAnimation clas;
			(clas = new Class_e_FightAnimation((byte) 10, 0)).sub_1ca8(null,
					Class_f_StringManager.getLangString(52), this.someCanWidth, this.someCanHeightShift);
			this.var_4c0a.sub_1698((Class_e_FightAnimation) clas, 0,
					(this.someCanHeight + localClass_e_0134.var_1042) / 2, 6);
		} else {
			localObject2 = new String[k];
			int[] arrayOfInt1 = new int[k];
			System.arraycopy(localObject1, 0, localObject2, 0, k);
			System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, k);
			this.var_4c1a = new Class_e_FightAnimation((byte) 10, 0);
			String stringIt;
			stringIt = sub_7651(this.downloadAvailableSize);
			this.var_4c1a.sub_1ca8(
					null,
					Class_f_StringManager.getStrByIdAndReplaceUWith(54,
							sub_7651(this.var_4efa[arrayOfInt1[0]]))
							+ "\n"
							+ Class_f_StringManager.getStrByIdAndReplaceUWith(53, (String) stringIt),
					this.someCanWidth, -1);
			this.var_4c12 = new Class_e_FightAnimation((byte) 11, 0);
			this.var_4c12.sub_20ad((String[]) localObject2, this.someCanWidthShift,
					this.someCanHeightShift, this.someCanWidth, this.someCanHeight
							- localClass_e_0134.var_1042
							- this.var_4c1a.var_1042, 3, 4);
			this.var_4c12.var_11c2 = arrayOfInt1;
			int j = (this.someCanHeight - this.var_4c1a.var_1042
					- this.var_4c12.var_1042 + localClass_e_0134.var_1042) / 2;
			this.var_4c0a.sub_1698(this.var_4c12, 0, j, 20);
			j += this.var_4c12.var_1042;
			this.var_4c0a.sub_1698(this.var_4c1a, 0, j, 20);
			this.var_4c0a.var_115a = true;
			this.var_4c0a.sub_132e((byte) 0, true);
		}
		this.var_4c0a.sub_1698(localClass_e_0134, 0, 0, 20);
		this.var_4c0a.sub_1350(paramClass_f_0145);
	}

	private Class_e_FightAnimation sub_7384(Class_f_StringManager paramClass_f_0145) {
		Class_e_FightAnimation localClass_e_01341;
		if (this.settingsStrListMaybe.length == 0) {
			Class_e_FightAnimation localClass_e_01342;
			(localClass_e_01342 = (localClass_e_01341 = new Class_e_FightAnimation(
					(byte) 10, 0)).sub_165b(Class_f_StringManager.getLangString(49))).var_11b2 = this.menuIconsFrames[6];
			localClass_e_01341.sub_1ca8(null, Class_f_StringManager.getLangString(52),
					this.canvasWidth, -1);
			localClass_e_01341.sub_1930(0,
					(this.someCanHeight + localClass_e_01342.var_1042) / 2, 6);
			localClass_e_01341.sub_1350(paramClass_f_0145);
			this.var_4bfa = null;
			return localClass_e_01341;
		}
		this.var_4bfa = new Class_e_FightAnimation((byte) 11, 0);
		(localClass_e_01341 = this.var_4bfa.sub_165b(Class_f_StringManager.getLangString(49))).var_11b2 = this.menuIconsFrames[6];
		this.var_4bfa.sub_20ad(this.settingsStrListMaybe, this.canvasWidth / 2,
				(this.someCanHeight + localClass_e_01341.var_1042) / 2,
				this.someCanWidth, this.someCanHeight - localClass_e_01341.var_1042, 3,
				4);
		this.var_4bfa.sub_1350(paramClass_f_0145);
		return this.var_4bfa;
	}

	private int sub_7465(int paramInt) {
		if (paramInt >= someOneOf12LangStrings.length) {
			return this.settingsIntListMaybe[(paramInt - someOneOf12LangStrings.length)]
					+ someOneOf12LangStrings.length;
		}
		return paramInt;
	}

	private static DataInputStream sub_74ac(int paramInt) {
		if (paramInt >= someOneOf12LangStrings.length) {
			paramInt -= someOneOf12LangStrings.length;
			return new DataInputStream(new ByteArrayInputStream(
					Class_c_MainCanvas.getRecordData("download", paramInt)));
		}
		return new DataInputStream(Class_c_MainCanvas.getResourceStream("s" + paramInt
				+ ".aem"));
	}

	private static byte[] sub_751c(int paramInt) {
		if (paramInt >= someOneOf12LangStrings.length) {
			paramInt -= someOneOf12LangStrings.length;
			return Class_c_MainCanvas.getRecordData("download", paramInt);
		}
		try {
			InputStream stream;
			stream = Class_c_MainCanvas.getResourceStream("s" + paramInt); // SKIRMISH MApS
															// @todo
			ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
			int i;
			while ((i = stream.read()) >= 0) {
				localByteArrayOutputStream.write(i);
			}
			stream.close();
			byte[] bArr;
			bArr = localByteArrayOutputStream.toByteArray();
			localByteArrayOutputStream.close();
			return bArr;
		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return null;
	}

	private String sub_75cb(int paramInt) {
		if (paramInt >= someOneOf12LangStrings.length) {
			paramInt -= someOneOf12LangStrings.length;
			for (int i = 0; i < this.settingsIntListMaybe.length; i++) {
				if (this.settingsIntListMaybe[i] == paramInt) {
					return this.settingsStrListMaybe[i];
				}
			}
			return null;
		}
		return someOneOf12LangStrings[paramInt];
	}

	private static String sub_7651(int paramInt) {
		int i = (paramInt = paramInt * 100 / 1024) / 100;
		paramInt %= 100;
		return i + "." + paramInt;
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

	public final void sub_770a(Class_e_FightAnimation paramClass_e_0134, int paramInt,
			String paramString, byte paramByte) {
		try {
			this.var_4f32 = true;
			if ((paramClass_e_0134 == this.var_4882) && (paramByte == 1)) {
				if (this.var_478a == 3) {
					this.someActiveUnit.sub_1686(this.var_47ca, this.var_47d2);
					this.someActiveUnit.sub_20f8(this.var_47da);
					sub_6c83(this.someActiveUnit);
					this.var_495a = true;
					return;
				}
			} else {
				if (paramClass_e_0134 == this.var_4b92) {
					if (paramByte == 0) {
						Class_f_StringManager.mainCanvas.stopThread();
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
				Class_c_AConnection localObject3;
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
							((Class_c_AConnection) localObject3).close();
							localObject1 = ((String) someStr).substring(
									0,
									((String) someStr).length()
											- ".aem".length());
							sub_19157((String) localObject1,
									((ByteArrayOutputStream) localObject5)
											.toByteArray());
							((ByteArrayOutputStream) localObject5).close();
							Class_e_FightAnimation clas;
							(clas = sub_14359(null, Class_f_StringManager.getStrByIdAndReplaceUWith(45,
									(String) localObject1), this.someCanHeight, 2000))
									.sub_1350(this.var_4f4a);
							Class_f_StringManager.mainCanvas.sub_220e((Class_f_StringManager) clas);
						} else {
							this.var_4f6a.changeDirectory((String) localObject1);
							this.var_4f72 = Class_b_FilesManager.mergeThese(Class_b_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_4572
											: null);
							this.var_4f4a = new Class_e_FightAnimation((byte) 15, 15);
							Class_e_FightAnimation lo3;
							(lo3 = this.var_4f4a.sub_165b(sub_7696(
									this.var_4f6a.sub_877(),
									Class_f_StringManager.getLangString(290)))).var_11b2 = this.menuIconsFrames[6];
							this.var_4f52 = new Class_e_FightAnimation((byte) 0, 0);
							this.var_4f52.sub_20ad(this.var_4f72, 0, 0,
									this.someCanWidth, this.someCanHeight
											- ((Class_e_FightAnimation) lo3).var_1042
											- (this.buttonsSprite.spriteFrameHeight << 1), 3,
									4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 1)) {
								this.var_4f52.var_105a = 1;
							}
							this.var_4f4a
									.sub_1698(
											this.var_4f52,
											this.someCanWidthShift,
											(this.someCanHeight + ((Class_e_FightAnimation) lo3).var_1042) / 2,
											3);
							this.var_4f4a.sub_132e((byte) 0, true);
							this.var_4f4a.var_115a = true;
							this.var_4f4a.sub_1350(this.var_4bea);
							Class_f_StringManager.mainCanvas.sub_220e(this.var_4f4a);
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
							localObject1 = this.var_4b52 + ".aem";
						} else {
							localObject1 = this.var_4f72[this.var_4f62.var_105a];
						}
						if (((String) localObject1).endsWith(".aem")) {
							Class_c_AConnection lo3 = this.var_4f6a
									.createSomeFileConnection((String) localObject1);
							if (lo3.exists()) {
								((Class_c_AConnection) lo3).truncate(0L);
							} else {
								((Class_c_AConnection) lo3).create();
							}
							OutputStream ostream;
							(ostream = ((Class_c_AConnection) lo3).openOutputStream())
									.write(sub_751c(this.var_47aa));
							((OutputStream) ostream).close();
							((Class_c_AConnection) lo3).close();
							this.var_4f72 = Class_b_FilesManager.mergeThese(Class_b_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_457a
											: null);
							this.var_4f5a = new Class_e_FightAnimation((byte) 15, 15);
							Class_e_FightAnimation loc5;
							(loc5 = this.var_4f5a.sub_165b(sub_7696(
									this.var_4f6a.sub_877(),
									Class_f_StringManager.getLangString(299)))).var_11b2 = this.menuIconsFrames[6];
							this.var_4f62 = new Class_e_FightAnimation((byte) 0, 0);
							this.var_4f62.sub_20ad(this.var_4f72, 0, 0,
									this.someCanWidth, this.someCanHeight
											- ((Class_e_FightAnimation) loc5).var_1042
											- (this.buttonsSprite.spriteFrameHeight << 1), 3,
									4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 2)) {
								this.var_4f62.var_105a = 2;
							}
							this.var_4f5a
									.sub_1698(
											this.var_4f62,
											this.someCanWidthShift,
											(this.someCanHeight + ((Class_e_FightAnimation) loc5).var_1042) / 2,
											3);
							this.var_4f5a.sub_132e((byte) 0, true);
							this.var_4f5a.var_115a = true;
							this.var_4f5a.sub_1350(this.var_4faa);
							Class_e_FightAnimation localClass_e_01344;
							(localClass_e_01344 = sub_14359(null,
									Class_f_StringManager.getStrByIdAndReplaceUWith(45, this.var_4b52),
									this.someCanHeight, 2000))
									.sub_1350(this.var_4f5a);
							Class_f_StringManager.mainCanvas.sub_220e(localClass_e_01344);
						} else {
							this.var_4f6a.changeDirectory((String) localObject1);
							this.var_4f72 = Class_b_FilesManager.mergeThese(Class_b_FilesManager
									.sortFoldersAndFiles(this.var_4f6a
											.getDirectoryPaths(".aem", true)),
									this.var_4f6a.sub_877() != null ? var_457a
											: null);
							this.var_4f5a = new Class_e_FightAnimation((byte) 15, 15);
							Class_e_FightAnimation theflocalObject3;
							(theflocalObject3 = this.var_4f5a
									.sub_165b(sub_7696(this.var_4f6a.sub_877(),
											Class_f_StringManager.getLangString(290)))).var_11b2 = this.menuIconsFrames[6];
							this.var_4f62 = new Class_e_FightAnimation((byte) 0, 0);
							this.var_4f62
									.sub_20ad(
											this.var_4f72,
											0,
											0,
											this.someCanWidth,
											this.someCanHeight
													- ((Class_e_FightAnimation) theflocalObject3).var_1042
													- (this.buttonsSprite.spriteFrameHeight << 1),
											3, 4);
							if ((this.var_4f6a.sub_877() != null)
									&& (this.var_4f72.length > 2)) {
								this.var_4f62.var_105a = 2;
							}
							this.var_4f5a
									.sub_1698(
											this.var_4f62,
											this.someCanWidthShift,
											(this.someCanHeight + ((Class_e_FightAnimation) theflocalObject3).var_1042) / 2,
											3);
							this.var_4f5a.sub_132e((byte) 0, true);
							this.var_4f5a.var_115a = true;
							this.var_4f5a.sub_1350(this.var_4faa);
							Class_f_StringManager.mainCanvas.sub_220e(this.var_4f5a);
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
							int i = this.var_4b82.var_105a;
							sub_6431(i, this.var_4b7a);
						}
						this.var_4ba2 = null;
						return;
					}
					if (paramClass_e_0134 == this.var_4b12) {
						if ((paramByte == 2) || (paramByte == 3)) {
							this.var_4b1a
									.sub_1ca8(
											null,
											Class_f_StringManager
													.getLangString(184 + this.var_4b12.var_10aa[paramInt].unitType),
											this.someCanWidth, this.someCanHeight
													- this.var_4b0a.var_1042
													- this.var_4b12.var_1042);
							this.var_4b0a.someUnit0 = this.var_4b12.var_10aa[paramInt];
							this.var_4b1a.sub_1272();
							this.var_4b0a.sub_1272();
							return;
						}
					} else {
						if (paramClass_e_0134 == this.var_4b02) {
							if (paramByte == 0) {
								Class_a_Unit olocalObject3 = this.var_4b12.var_10aa[this.var_4b12.var_105a];
								if (!sub_12226((Class_a_Unit) olocalObject3,
										this.cursorPosX, this.cursorPosY)) {
									return;
								}
								this.someActiveUnit = sub_abab(
										(Class_a_Unit) olocalObject3,
										this.cursorPosX, this.cursorPosY);
								this.var_49ea = true;
								sub_6c83(this.someActiveUnit);
								Class_f_StringManager.mainCanvas.sub_220e(this);
							}
							this.var_4b02 = null;
							this.var_4b12 = null;
							this.var_4b1a = null;
							this.var_4b0a = null;
							return;
						}
						if (paramClass_e_0134 == this.var_49b2) {
							if ((paramByte == 2) || (paramByte == 3)) {
								String yylocalObject3 = Class_f_StringManager.getLangString(
										var_499a[paramInt], true);
								this.var_49ba.sub_1ca8(null,
										(String) yylocalObject3, this.someCanWidth,
										this.var_49ba.var_1042);
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
							if (paramClass_e_0134 == this.var_49c2) {
								if (paramByte == 0) {
									Class_f_StringManager.mainCanvas.sub_220e(this);
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
									this.var_4a82 = new Class_e_FightAnimation((byte) 15,
											15);
									Class_e_FightAnimation localClass_e_01341;
									(localClass_e_01341 = new Class_e_FightAnimation(
											(byte) 10, 0)).var_11b2 = this.menuIconsFrames[4];
									localClass_e_01341.sub_1ca8(null,
											Class_f_StringManager.getLangString(34),
											this.someCanWidth, -1);
									this.var_4a82.sub_1698(localClass_e_01341,
											0, 0, 20);
									String[] str22;
									str22 = new String[this.var_4baa];
									for (i2 = 0; i2 < this.var_4baa; i2++) {
										str22[i2] = Class_f_StringManager.getStrByIdAndReplaceUWith(38, ""
												+ (i2 + 1));
									}
									i2 = localClass_e_01341.var_1042;
									Class_e_FightAnimation[] olocObj3;
									olocObj3 = new Class_e_FightAnimation[this.var_4baa];
									this.var_4a9a = new Class_e_FightAnimation[this.var_4baa];
									this.var_4aa2 = new Class_e_FightAnimation[this.var_4baa];
									for (paramInt = 0; paramInt < this.var_4baa; paramInt++) {
										this.var_4a9a[paramInt] = new Class_e_FightAnimation(
												(byte)14, 6);
										this.var_4a9a[paramInt]
												.sub_1f72(this.var_463a,
														this.canvasWidthShift, -1);
										this.var_4aa2[paramInt] = new Class_e_FightAnimation(
												(byte)14, 5);
										this.var_4aa2[paramInt].sub_1f72(str22,
												this.canvasWidthShift, -1);
										this.var_4aa2[paramInt].var_105a = paramInt;
										int i5 = Math
												.max(this.var_4a9a[paramInt].var_103a,
														this.var_4aa2[paramInt].var_103a);
										i3 = this.canvasWidth - i5;
										this.var_4a9a[paramInt].var_103a = i5;
										this.var_4aa2[paramInt].var_103a = i5;
										this.var_4a82.sub_1698(
												this.var_4a9a[paramInt], i3,
												i2, 20);
										i2 += this.var_4a9a[paramInt].var_1042;
										this.var_4a82.sub_1698(
												this.var_4aa2[paramInt], i3,
												i2, 20);
										i2 += this.var_4aa2[paramInt].var_1042;
										olocObj3[paramInt] = new Class_e_FightAnimation(
												(byte)10, 8);
										olocObj3[paramInt]
												.sub_1ca8(
														null,
														Class_f_StringManager
																.getLangString(this.var_4bb2[paramInt] - 1 + 89),
														i3,
														this.var_4a9a[paramInt].var_1042
																+ this.var_4aa2[paramInt].var_1042);
										olocObj3[paramInt].var_11a2 = var_468a[this.var_4bb2[paramInt]];
										this.var_4a82.sub_1698(
												olocObj3[paramInt], 0, i2, 36);
									}
									this.var_4a82.var_114a = 1;
									Class_e_FightAnimation localClass_e_01345;
									(localClass_e_01345 = new Class_e_FightAnimation(
											(byte) 10, 8)).sub_1ca8(null,
											Class_f_StringManager.getLangString(40),
											this.someCanWidthShift, -1);
									this.var_4a82.sub_1698(localClass_e_01345,
											0, i2, 20);
									this.var_4a8a = new Class_e_FightAnimation((byte) 14,
											4);
									String[] ssparamInt;
									ssparamInt = new String[var_45da.length];
									for (i3 = 0; i3 < ssparamInt.length; i3++) {
										ssparamInt[i3] = ("" + var_45da[i3]);
									}
									this.var_4a8a.sub_1f72(ssparamInt,
											this.someCanWidthShift,
											localClass_e_01345.var_1042);
									this.var_4a82.sub_1698(this.var_4a8a,
											this.canvasWidthShift, i2, 20);
									i2 += localClass_e_01345.var_1042;
									(localClass_e_01341 = new Class_e_FightAnimation(
											(byte) 10, 8)).sub_1ca8(null,
											Class_f_StringManager.getLangString(41),
											this.someCanWidthShift, -1);
									this.var_4a82.sub_1698(localClass_e_01341,
											0, i2, 20);
									this.var_4a92 = new Class_e_FightAnimation((byte) 14,
											4);
									String[] slocalObject6 = new String[var_45e2.length];
									for (i6 = 0; i6 < slocalObject6.length; i6++) {
										slocalObject6[i6] = ("" + var_45e2[i6]);
									}
									this.var_4a92.sub_1f72(
											(String[]) slocalObject6,
											this.someCanWidthShift,
											localClass_e_01341.var_1042);
									this.var_4a82.sub_1698(this.var_4a92,
											this.canvasWidthShift, i2, 20);
									this.var_4a82.sub_1350(paramClass_e_0134);
									this.var_4a82.sub_132e((byte) 0, true);
									Class_f_StringManager.mainCanvas
											.sub_220e(this.var_4a82);
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
												this.var_487a[n] = 2;
											} else {
												j++;
												if (this.var_4a9a[n].var_105a == 0) {
													this.var_487a[n] = 1;
												} else if (this.var_4a9a[n].var_105a == 1) {
													this.var_487a[n] = 0;
												}
												this.var_483a[n] = ((byte) this.var_4aa2[n].var_105a);
												if (booparamInt[this.var_483a[n]] == false) {
													i6++;
													booparamInt[this.var_483a[n]] = true;
												}
											}
										}
										if ((j < 2) || (i6 < 2)) {
											((Class_e_FightAnimation) (localObject6 = sub_14359(null,
													Class_f_StringManager.getLangString(39),
													this.someCanHeight, 2000)))
													.sub_1350(this.var_4a82);
											Class_f_StringManager.mainCanvas
													.sub_220e((Class_f_StringManager) localObject6);
											return;
										}
										this.var_4a82 = null;
										this.var_4a7a = null;
										Class_f_StringManager.mainCanvas.sub_220e(this);
										this.var_45ea = var_45da[this.var_4a8a.var_105a];
										this.var_45f2 = var_45e2[this.var_4a92.var_105a];
										this.var_4a9a = null;
										this.var_4a8a = null;
										this.var_4a92 = null;
										sub_1af6c();
										this.var_45fa = 1;
										this.var_49ca = 8;
										this.var_4982 = true;
										Class_f_StringManager.mainCanvas.repaintAll();
										sub_5dc1();
										sub_aca4(this.var_47aa);
										this.var_47a2 = this.var_47aa;
										this.var_4982 = false;
										this.var_478a = 0;
										return;
									}
								} else {
									byte[] localObject9 = null;
									Object localObject10;
									int k;
									if (paramClass_e_0134 == this.var_49da) {
										j = this.var_49d2.var_105a;
										if ((paramByte == 0)
												&& ((j >= someOneOf12LangStrings.length) || (this.var_45d2[j] == false))) {
											this.var_47aa = sub_7465(j);
											int inti2 = ((DataInputStream) (localObject6 = sub_74ac(this.var_47aa)))
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
											for (i3 = 0; i3 < i2; i3++) {
												for (int i9 = 0; i9 < n; i9++) {
													arrayOfByte[i3][i9] = ((DataInputStream) localObject6)
															.readByte();
													if ((this.tilesDefs[arrayOfByte[i3][i9]] == 9)
															&& ((i6 = sub_11bd2(
																	i3, i9,
																	arrayOfByte)) != 0)
															&& (localObject9[i6] == -1)) {
														this.var_4bb2[this.var_4baa] = ((byte) i6);
														localObject9[i6] = (this.var_4baa++);
													}
												}
											}
											((DataInputStream) localObject6)
													.close();
											this.var_4b52 = this.var_49d2.var_101a[j];
											this.var_4a7a = new Class_e_FightAnimation(
													(byte) 15, 15);
											Class_e_FightAnimation localClass_e_01342;
											(localClass_e_01342 = new Class_e_FightAnimation(
													(byte) 10, 0)).var_11b2 = this.menuIconsFrames[4];
											localClass_e_01342.sub_1ca8(null,
													this.var_4b52,
													this.someCanWidth, -1);
											((Class_e_FightAnimation) (localObject10 = new Class_e_FightAnimation(
													(byte) 8, 0)))
													.sub_17fe(
															this.canvasWidth,
															this.someCanHeight
																	- localClass_e_01342.var_1042
																	- this.buttonsSprite.spriteFrameHeight,
															arrayOfByte, null);
											this.var_4a7a
													.sub_1698(
															(Class_e_FightAnimation) localObject10,
															this.someCanWidthShift,
															this.someCanHeightShift
																	+ (localClass_e_01342.var_1042 - this.buttonsSprite.spriteFrameHeight)
																	/ 2, 3);
											this.var_4a7a
													.sub_1698(
															localClass_e_01342,
															0, 0, 0);
											this.var_4a7a
													.sub_1350(paramClass_e_0134);
											this.var_4a7a.sub_132e((byte) 0,
													true);
											this.var_4a7a.var_115a = true;
											Class_f_StringManager.mainCanvas
													.sub_220e(this.var_4a7a);
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
											Class_c_MainCanvas
													.setDisplayableAsCurrent(this.var_4fd2);
											return;
										}
										if ((k >= someOneOf12LangStrings.length)
												|| (this.var_45d2[k] == false)) {
											this.var_47aa = sub_7465(k);
											this.var_4b52 = this.var_4fa2.var_101a[k];
											this.var_4f9a = null;
											this.var_4fa2 = null;
											Class_f_StringManager.mainCanvas.sub_220e(this);
											this.var_45fa = 1;
											this.var_49ca = 8;
											this.var_4f92 = 1;
											this.var_4982 = true;
											Class_f_StringManager.mainCanvas.repaintAll();
											sub_5dc1();
											sub_aca4(this.var_47aa);
											this.var_47a2 = this.var_47aa;
											this.var_4982 = false;
											this.var_478a = 0;
										}
									} else if (paramClass_e_0134 == this.var_4faa) {
										k = this.var_4fb2.var_105a;
										if (paramByte != 0) {
											this.var_4faa = null;
											this.var_4fb2 = null;
											return;
										}
										if ((k >= someOneOf12LangStrings.length)
												|| (this.var_45d2[k] == false)) {
											this.var_47aa = sub_7465(k);
											this.var_4b52 = this.var_4fb2.var_101a[k];
											if (this.var_4f6a == null) {
												this.var_4f6a = new Class_b_FilesManager();
											}
											this.var_4f72 = Class_b_FilesManager
													.mergeThese(
															Class_b_FilesManager
																	.sortFoldersAndFiles(this.var_4f6a
																			.getDirectoryPaths(
																					".aem",
																					true)),
															this.var_4f6a
																	.sub_877() != null ? var_457a
																	: null);
											this.var_4f5a = new Class_e_FightAnimation(
													(byte) 15, 15);
											Class_e_FightAnimation localObject61 = this.var_4f5a
													.sub_165b(sub_7696(
															this.var_4f6a
																	.sub_877(),
															Class_f_StringManager
																	.getLangString(299)));
											localObject61.var_11b2 = this.menuIconsFrames[6];
											this.var_4f62 = new Class_e_FightAnimation(
													(byte) 0, 0);
											this.var_4f62
													.sub_20ad(
															this.var_4f72,
															0,
															0,
															this.someCanWidth,
															this.someCanHeight
																	- ((Class_e_FightAnimation) localObject61).var_1042
																	- (this.buttonsSprite.spriteFrameHeight << 1),
															3, 4);
											if ((this.var_4f6a.sub_877() != null)
													&& (this.var_4f72.length > 2)) {
												this.var_4f62.var_105a = 2;
											}
											this.var_4f5a
													.sub_1698(
															this.var_4f62,
															this.someCanWidthShift,
															(this.someCanHeight + ((Class_e_FightAnimation) localObject61).var_1042) / 2,
															3);
											this.var_4f5a.sub_132e((byte) 0,
													true);
											this.var_4f5a.var_115a = true;
											this.var_4f5a
													.sub_1350(this.var_4faa);
											Class_f_StringManager.mainCanvas
													.sub_220e(this.var_4f5a);
										}
									} else if (paramClass_e_0134 == this.var_4aaa) {
										if (paramByte == 1) {
											boolean booparamInt = Class_c_MainCanvas.settings[0];
											int i7 = 0;
											for (int iti2 = 0; iti2 < 4; iti2++) {
												boolean i8;
												if ((i8 = (this.var_4ab2[iti2].var_105a == 0 ? true
														: false)) != Class_c_MainCanvas.settings[iti2]) {
													Class_c_MainCanvas.settings[iti2] = i8;
													i7 = 1;
												}
											}
											if (i7 != 0) {
												saveSettings();
												if (booparamInt != Class_c_MainCanvas.settings[0]) {
													if (Class_c_MainCanvas.settings[0] == false) {
														Class_c_MainCanvas.stopCurrentMusicPlayer();
														return;
													}
													if (this.var_48e2 == 1) {
														if ((this.var_478a != 11)
																&& (this.var_478a != 14)) {
															Class_c_MainCanvas
																	.playMusicLooped(
																			var_4692[this.var_4832[this.someUnitTeamId]],
																			0);
														}
													} else if (this.var_48e2 == 0) {
														Class_c_MainCanvas.playMusicLooped(
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
											k = this.var_4b82.var_105a;
											if (this.saveSlotBytes[k] == -1) {
												sub_6431(k, paramClass_e_0134);
											} else {
												this.var_4ba2 = sub_14359(null,
														Class_f_StringManager
																.getLangString(88),
														this.someCanHeight, -1);
												this.var_4ba2.sub_132e(
														(byte) 0, true);
												this.var_4ba2
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4ba2);
											}
										} else {
											this.var_4b7a = null;
											this.var_4b82 = null;
											this.var_4b8a = null;
										}
									} else if (paramClass_e_0134 == this.var_4b72) {
										if (paramByte == 0) {
											localObject7 = null;
											try {
												localObject7 = Class_c_MainCanvas
														.getRecordData(
																"save",
																this.var_4b82.var_105a);
											} catch (Exception localException) {
											}
											if (localObject7 != null) {
												this.var_4b72 = null;
												sub_1af6c();
												this.var_4b82 = null;
												this.var_4b8a = null;
												Class_f_StringManager.mainCanvas
														.sub_220e(this);
												this.var_4982 = true;
												Class_f_StringManager.mainCanvas.repaintAll();
												sub_5dc1();
												loadSlot((byte[]) localObject7);
												if (this.var_45fa == 0) {
													this.var_4a4a = true;
												}
												this.var_4982 = false;
												this.var_478a = 0;
											}
										} else {
											this.var_4b72 = null;
											this.var_4b82 = null;
											this.var_4b8a = null;
										}
									} else if (paramClass_e_0134 == this.var_4b82) {
										if ((paramByte == 2)
												|| (paramByte == 3)) {
											this.var_4b8a.sub_1ca8(null,
													this.saveSlotsDescriptions[paramInt],
													this.someCanWidth, -1);
											if (this.saveSlotBytes[paramInt] == -1) {
												this.var_4b8a.var_11a2 = 2370117;
											} else {
												this.var_4b8a.var_11a2 = var_468a[this.saveSlotBytes[paramInt]];
											}
											this.var_4b8a.sub_1272();
										}
										return;
									}
									Class_e_FightAnimation localClass_e_01343;
									Object localObject8;
									if (paramClass_e_0134 == this.var_4be2) {
										if (paramByte == 0) {
											if (paramString
													.equals(this.var_4bd2[0])) {
												if (this.var_4ed2 == null) {
													sub_18c91(
															0,
															"news",
															Class_f_StringManager
																	.getLangString(0),
															paramClass_e_0134);
													return;
												}
												this.var_4bf2 = sub_188fc(paramClass_e_0134);
												return;
											}
											if (paramString
													.equals(this.var_4bd2[1])) {
												this.var_4bea = new Class_e_FightAnimation(
														(byte) 11, 0);
												(localClass_e_01343 = this.var_4bea
														.sub_165b(paramString)).var_11b2 = this.menuIconsFrames[6];
												this.var_4bea
														.sub_20ad(
																this.var_4bda,
																this.canvasWidth / 2,
																(this.someCanHeight + localClass_e_01343.var_1042) / 2,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.var_1042,
																3, 0);
												this.var_4bea
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4bea);
											}
											if (paramString
													.equals(this.var_4bd2[2])) {
												this.var_4f9a = new Class_e_FightAnimation(
														(byte) 15, 15);
												(localClass_e_01343 = new Class_e_FightAnimation(
														(byte) 10, 0))
														.sub_1ca8(null,
																paramString,
																this.someCanWidth,
																-1);
												localClass_e_01343.var_11b2 = this.menuIconsFrames[6];
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
														strs[n] = Class_f_StringManager
																.getLangString(42);
													} else {
														strs[n] = someOneOf12LangStrings[n];
													}
												}
												String[] strArr;
												(strArr = new String[12 + this.settingsCountMaybe + 1])[0] = Class_f_StringManager
														.getLangString(292);
												System.arraycopy(strs, 0,
														strArr, 1, 12);
												System.arraycopy(this.settingsStrListMaybe,
														0, strArr, 13,
														this.settingsCountMaybe);
												this.var_4fa2 = new Class_e_FightAnimation(
														(byte) 0, 0);
												this.var_4fa2
														.sub_20ad(
																(String[]) strArr,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.var_1042
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_4f9a
														.sub_1698(
																this.var_4fa2,
																this.someCanWidthShift,
																(this.someCanHeight + localClass_e_01343.var_1042) / 2,
																3);
												this.var_4f9a.sub_1698(
														localClass_e_01343, 0,
														0, 0);
												this.var_4f9a.var_115a = true;
												this.var_4f9a.sub_132e(
														(byte) 0, true);
												this.var_4f9a
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4f9a);
											}
										} else if (paramByte == 1) {
											this.var_4be2 = null;
										}
									} else if (paramClass_e_0134 == this.var_4bea) {
										if (paramByte == 0) {
											if (paramString
													.equals(this.var_4bda[0])) {
												if (this.var_4f6a == null) {
													this.var_4f6a = new Class_b_FilesManager();
												}
												this.var_4f72 = Class_b_FilesManager
														.mergeThese(
																Class_b_FilesManager
																		.sortFoldersAndFiles(this.var_4f6a
																				.getDirectoryPaths(
																						".aem",
																						true)),
																this.var_4f6a
																		.sub_877() != null ? var_4572
																		: null);
												this.var_4f4a = new Class_e_FightAnimation(
														(byte) 15, 15);
												Class_e_FightAnimation clas;
												(clas = this.var_4f4a
														.sub_165b(sub_7696(
																this.var_4f6a
																		.sub_877(),
																Class_f_StringManager
																		.getLangString(290)))).var_11b2 = this.menuIconsFrames[6];
												this.var_4f52 = new Class_e_FightAnimation(
														(byte) 0, 0);
												this.var_4f52
														.sub_20ad(
																this.var_4f72,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- ((Class_e_FightAnimation) clas).var_1042
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												if ((this.var_4f6a.sub_877() != null)
														&& (this.var_4f72.length > 1)) {
													this.var_4f52.var_105a = 1;
												}
												this.var_4f4a
														.sub_1698(
																this.var_4f52,
																this.someCanWidthShift,
																(this.someCanHeight + ((Class_e_FightAnimation) clas).var_1042) / 2,
																3);
												this.var_4f4a.sub_132e(
														(byte) 0, true);
												this.var_4f4a.var_115a = true;
												this.var_4f4a
														.sub_1350(this.var_4bea);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4f4a);
											} else if (paramString
													.equals(this.var_4bda[1])) {
												this.var_4faa = new Class_e_FightAnimation(
														(byte) 15, 15);
												(localClass_e_01343 = new Class_e_FightAnimation(
														(byte) 10, 0))
														.sub_1ca8(
																null,
																Class_f_StringManager
																		.getLangString(299),
																this.someCanWidth,
																-1);
												localClass_e_01343.var_11b2 = this.menuIconsFrames[6];
												this.var_45d2 = new boolean[12];
												for (i6 = this.someSetting; i6 <= 7; i6++) {
													if (var_45ca[i6] >= 0) {
														this.var_45d2[var_45ca[i6]] = true;
													}
												}
												String[] strs2 = new String[12];
												for (n = 0; n < 12; n++) {
													if (this.var_45d2[n] != false) {
														strs2[n] = Class_f_StringManager
																.getLangString(42);
													} else {
														strs2[n] = someOneOf12LangStrings[n];
													}
												}
												String[] lo9;
												lo9 = new String[12 + this.settingsCountMaybe];
												System.arraycopy(strs2, 0,
														localObject9, 0, 12);
												System.arraycopy(this.settingsStrListMaybe,
														0, localObject9, 12,
														this.settingsCountMaybe);
												this.var_4fb2 = new Class_e_FightAnimation(
														(byte) 0, 0);
												this.var_4fb2
														.sub_20ad(
																(String[]) lo9,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- localClass_e_01343.var_1042
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_4faa
														.sub_1698(
																this.var_4fb2,
																this.someCanWidthShift,
																(this.someCanHeight + localClass_e_01343.var_1042) / 2,
																3);
												this.var_4faa.sub_1698(
														localClass_e_01343, 0,
														0, 0);
												this.var_4faa.var_115a = true;
												this.var_4faa.sub_132e(
														(byte) 0, true);
												this.var_4faa
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4faa);
											} else if (paramString
													.equals(this.var_4bda[2])) {
												if (this.var_4eea == null) {
													sub_18c91(
															2,
															"levels",
															Class_f_StringManager
																	.getLangString(0),
															paramClass_e_0134);
												} else {
													sub_70c0(paramClass_e_0134);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_4c0a);
												}
											} else if (paramString
													.equals(this.var_4bda[3])) {
												Class_f_StringManager.mainCanvas
														.sub_220e(sub_7384(paramClass_e_0134));
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
														Class_f_StringManager.getLangString(0),
														paramClass_e_0134);
											} else {
												(localClass_e_01343 = sub_1437e(
														this.var_4ed2[paramInt],
														this.var_4ee2[paramInt],
														this.someCanHeight,
														this.someCanHeight / 2, -1))
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(localClass_e_01343);
											}
										} else if (paramByte == 1) {
											this.var_4bf2 = null;
										}
									} else if (paramClass_e_0134 == this.var_4c0a) {
										if (paramByte == 0) {
											this.var_4eca = this.var_4c12.var_11c2[this.var_4c12.var_105a];
											if (this.downloadAvailableSize >= this.var_4efa[this.var_4eca]) {
												sub_18c91(
														3,
														this.var_4ef2[this.var_4eca],
														Class_f_StringManager.getLangString(0),
														paramClass_e_0134);
											} else {
												(localClass_e_01343 = sub_14359(
														null,
														Class_f_StringManager
																.getLangString(55),
														this.someCanHeight, -1))
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(localClass_e_01343);
											}
										} else if (paramByte == 1) {
											this.var_4c1a = null;
											this.var_4c12 = null;
											this.var_4c0a = null;
										}
									} else if (paramClass_e_0134 == this.var_4c12) {
										if ((paramByte == 2)
												|| (paramByte == 3)) {
											String str = sub_7651(this.downloadAvailableSize);
											this.var_4c1a
													.sub_1ca8(
															null,
															Class_f_StringManager
																	.getStrByIdAndReplaceUWith(
																			54,
																			sub_7651(this.var_4efa[this.var_4c12.var_11c2[paramInt]]))
																	+ "\n"
																	+ Class_f_StringManager
																			.getStrByIdAndReplaceUWith(
																					53,
																					str),
															this.someCanWidth, -1);
											this.var_4c1a.sub_1272();
										}
									} else if (paramClass_e_0134 == this.var_4bfa) {
										if (paramByte == 0) {
											if (this.settingsIntListMaybe[paramInt]
													+ someOneOf12LangStrings.length == this.var_47a2) {
												(localClass_e_01343 = sub_14359(
														null,
														Class_f_StringManager
																.getLangString(56),
														this.someCanHeight, -1))
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(localClass_e_01343);
											} else {
												this.var_4c22 = paramInt;
												this.var_4c2a = paramString;
												this.var_4c02 = sub_1437e(
														null,
														Class_f_StringManager
																.getStrByIdAndReplaceUWith(50,
																		paramString),
														this.someCanHeight,
														this.someCanHeightShift, -1);
												this.var_4c02
														.sub_1350(paramClass_e_0134);
												this.var_4c02.sub_132e(
														(byte) 0, true);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4c02);
											}
										} else if (paramByte == 1) {
											this.var_4bfa = null;
										}
									} else if (paramClass_e_0134 == this.var_4c02) {
										if (paramByte == 0) {
											sub_19031(this.var_4c22);
											Class_e_FightAnimation cl0134 = sub_7384(this.var_4bfa.stringManager);
											Class_e_FightAnimation cll = sub_14359(null,
													Class_f_StringManager.getStrByIdAndReplaceUWith(51,
															this.var_4c2a),
													this.someCanHeight, -1);
											cll.sub_1350(cl0134); 
											Class_f_StringManager.mainCanvas
													.sub_220e((Class_f_StringManager) cll);
										}
										this.var_4c02 = null;
										this.var_4c2a = null;
									}
									if (paramClass_e_0134.var_108a == 7) {
										Class_f_StringManager.mainCanvas.sub_220e(this);
										return;
									}
									if ((paramString != null)
											&& (paramByte == 0)) {
										if (paramString
												.equals(this.var_462a[0])) {
											if ((this.var_48e2 != 0)
													&& (this.var_478a == 0)) {
												this.var_4b9a = sub_14359(null,
														Class_f_StringManager
																.getLangString(87),
														this.someCanHeight, -1);
												this.var_4b9a.sub_132e(
														(byte) 0, true);
												this.var_4b9a
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4b9a);
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
											if (paramString.equals(Class_f_StringManager
													.getLangString(3))) {
												this.var_49e2 = new Class_e_FightAnimation(
														(byte) 11, 0);
												int m = this.someSetting;
												if (this.someSetting > 7) {
													m = 7;
												}
												m++;
												String[] strs;
												strs = new String[m];
												for (i2 = 0; i2 < m; i2++) {
													strs[i2] = (i2 + 1 + ". " + Class_f_StringManager
															.getLangString(i2 + 121));
												}
												Class_e_FightAnimation locOb;
												(locOb = this.var_49e2
														.sub_165b(paramString)).var_11b2 = this.menuIconsFrames[3];
												this.var_49e2
														.sub_20ad(
																strs,
																this.canvasWidth / 2,
																(this.someCanHeight + ((Class_e_FightAnimation) locOb).var_1042) / 2,
																this.someCanWidth,
																this.someCanHeight
																		- ((Class_e_FightAnimation) locOb).var_1042,
																3, 4);
												this.var_49e2
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_49e2);
												return;
											}
											if (paramString.equals(Class_f_StringManager
													.getLangString(4))) {
												this.var_4b7a = sub_6f4c(
														paramString,
														this.menuIconsFrames[10]);
												this.var_4b7a
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4b7a);
												return;
											}
											if (paramString.equals(Class_f_StringManager
													.getLangString(5))) {
												this.var_4b72 = sub_6f4c(
														paramString,
														this.menuIconsFrames[2]);
												this.var_4b72
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_4b72);
												return;
											}
											int i1;
											if (!paramString
													.equals(Class_f_StringManager
															.getLangString(6))) {
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(7))) {
													this.var_4be2 = new Class_e_FightAnimation(
															(byte) 11, 0);
													Class_e_FightAnimation locOb2;
													(locOb2 = this.var_4be2
															.sub_165b(paramString)).var_11b2 = this.menuIconsFrames[6];
													this.var_4be2
															.sub_20ad(
																	this.var_4bd2,
																	this.canvasWidth / 2,
																	(this.someCanHeight + ((Class_e_FightAnimation) locOb2).var_1042) / 2,
																	this.someCanWidth,
																	this.someCanHeight
																			- ((Class_e_FightAnimation) locOb2).var_1042,
																	3, 0);
													this.var_4be2
															.sub_1350(paramClass_e_0134);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_4be2);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(8))) {
													this.var_4aaa = new Class_e_FightAnimation(
															(byte) 15, 15);
													Class_e_FightAnimation locOb2;
													(locOb2 = new Class_e_FightAnimation(
															(byte) 10, 0)).var_11b2 = this.menuIconsFrames[5];
													((Class_e_FightAnimation) locOb2)
															.sub_1ca8(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													this.var_4aaa
															.sub_1698(
																	(Class_e_FightAnimation) locOb2,
																	0, 0, 20);
													i6 = ((Class_e_FightAnimation) locOb2).var_1042;
													Class_e_FightAnimation[] localObjs;
													localObjs = new Class_e_FightAnimation[4];
													this.var_4ab2 = new Class_e_FightAnimation[4];
													for (i1 = 0; i1 < 4; i1++) {
														int iparamInt = 8;
														if (i1 != 0) {
															iparamInt = 9;
														}
														if (i1 != 3) {
															iparamInt |= 0x2;
														}
														localObjs[i1] = new Class_e_FightAnimation(
																(byte) 10,
																iparamInt);
														localObjs[i1]
																.sub_1ca8(
																		null,
																		Class_c_MainCanvas.var_1807[i1],
																		this.someCanWidthShift,
																		-1);
														this.var_4aaa.sub_1698(
																localObjs[i1],
																0, i6, 20);
														int int4 = 4;
														if (i1 != 0) {
															int4 = 5;
														}
														if (i1 != 3) {
															int4 |= 0x2;
														}
														this.var_4ab2[i1] = new Class_e_FightAnimation(
																(byte) 14, int4);
														this.var_4ab2[i1]
																.sub_1f72(
																		this.var_4642,
																		this.someCanWidthShift,
																		localObjs[i1].var_1042);
														this.var_4ab2[i1].var_105a = (Class_c_MainCanvas.settings[i1] != false ? 0
																: 1);
														this.var_4aaa
																.sub_1698(
																		this.var_4ab2[i1],
																		this.canvasWidthShift,
																		i6, 20);
														i6 += localObjs[i1].var_1042;
													}
													this.var_4aaa.var_114a = 2;
													this.var_4aaa
															.sub_1350(paramClass_e_0134);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_4aaa);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(9))) {
													this.var_49aa = new Class_e_FightAnimation(
															(byte) 15, 15);
													Class_e_FightAnimation lo2;
													(lo2 = new Class_e_FightAnimation(
															(byte) 10, 0))
															.sub_1ca8(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													((Class_e_FightAnimation) lo2).var_11b2 = this.menuIconsFrames[7];
													String[] strParam2 = new String[20];
													for (i2 = 0; i2 < var_4992.length; i2++) {
														strParam2[i2] = (Class_f_StringManager
																.getLangString(var_4992[i2])
																+ " "
																+ i2
																+ "/" + 19);
													}
													this.var_49b2 = new Class_e_FightAnimation(
															(byte) 14, 2);
													this.var_49b2.sub_1f72(
															strParam2,
															this.someCanWidth, -1);
													this.var_49ba = new Class_e_FightAnimation(
															(byte) 10, 1);
													this.var_49ba
															.sub_1ca8(
																	null,
																	Class_f_StringManager
																			.getLangString(var_499a[0]),
																	this.someCanWidth,
																	this.someCanHeight
																			- ((Class_e_FightAnimation) lo2).var_1042
																			- this.var_49b2.var_1042
																			- (this.buttonsSprite.spriteFrameHeight << 1));
													i2 = ((Class_e_FightAnimation) lo2).var_1042
															+ this.buttonsSprite.spriteFrameHeight;
													this.var_49aa.sub_1698(
															this.var_49b2,
															this.someCanWidthShift, i2,
															17);
													i2 += this.var_49b2.var_1042;
													this.var_49aa.sub_1698(
															this.var_49ba,
															this.someCanWidthShift, i2,
															17);
													this.var_49aa.sub_1698(
															(Class_e_FightAnimation) lo2,
															0, 0, 0);
													this.var_49aa
															.sub_1350(paramClass_e_0134);
													this.var_49aa.var_115a = true;
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_49aa);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(10))) {
													Class_e_FightAnimation lo2;
													lo2 = new Class_e_FightAnimation(
															(byte) 15, 15);
													Class_e_FightAnimation lo7;
													(lo7 = new Class_e_FightAnimation(
															(byte) 10, 0))
															.sub_1ca8(
																	null,
																	paramString,
																	this.someCanWidth,
																	-1);
													((Class_e_FightAnimation) lo7).var_11b2 = this.menuIconsFrames[8];
													localObject8 = new Class_e_FightAnimation(
															(byte) 10, 0);
													String lo9;
													lo9 = Class_f_StringManager
															.getStrByIdAndReplaceUWith(
																	16,
																	this.midletVersionAppProp);
													((Class_e_FightAnimation) localObject8)
															.sub_1ca8(
																	null,
																	(String) lo9,
																	this.someCanWidth,
																	this.someCanHeight
																			- ((Class_e_FightAnimation) lo7).var_1042
																			- (this.buttonsSprite.spriteFrameHeight << 1));
													((Class_e_FightAnimation) lo2)
															.sub_1698(
																	(Class_e_FightAnimation) localObject8,
																	0,
																	(this.someCanHeight + ((Class_e_FightAnimation) lo7).var_1042) / 2,
																	6);
													((Class_e_FightAnimation) lo2)
															.sub_1698(
																	(Class_e_FightAnimation) lo7,
																	0, 0, 0);
													((Class_e_FightAnimation) lo2)
															.sub_1350(paramClass_e_0134);
													((Class_e_FightAnimation) lo2).var_115a = true;
													Class_f_StringManager.mainCanvas
															.sub_220e((Class_f_StringManager) lo2);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(11))) {
													this.var_4b92 = sub_14359(
															null,
															Class_f_StringManager
																	.getLangString(86),
															this.someCanHeight, -1);
													this.var_4b92.sub_132e(
															(byte) 0, true);
													this.var_4b92
															.sub_1350(paramClass_e_0134);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_4b92);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(60))) {
													sub_6d11(this.var_4652,
															this.someCanHeightShift,
															this.someCanHeight,
															paramClass_e_0134);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(61))) {
													this.var_49ea = false;
													sub_6c83(this.someActiveUnit);
													Class_f_StringManager.mainCanvas
															.sub_220e(this);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(62))) {
													sub_bcb2(this.var_47da, 0);
													this.var_4792 = this.var_478a;
													this.var_478a = 6;
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
															.setFrameSequence(var_4662[1]);
													moveCursorToPos(
															this.var_47ba[this.var_47b2].posX,
															this.var_47ba[this.var_47b2].posY);
													this.var_48d2 = true;
													this.var_48da = true;
													Class_f_StringManager.mainCanvas
															.sub_220e(this);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(63))) {
													this.var_4b02 = new Class_e_FightAnimation(
															(byte) 15, 15);
													this.var_4b02.var_11e2 = this.someCanHeight;
													this.var_4b0a = new Class_e_FightAnimation(
															(byte) 2, 2);
													this.var_4b12 = new Class_e_FightAnimation(
															(byte) 3, 1);
													this.var_4b1a = new Class_e_FightAnimation(
															(byte) 10, 3);
													this.var_4b1a.var_1152 = true;
													this.var_4b0a.someUnit0 = this.var_4b12.var_10aa[0];
													this.var_4b1a
															.sub_1ca8(
																	null,
																	Class_f_StringManager
																			.getLangString(184 + this.var_4b12.var_10aa[0].unitType),
																	this.someCanWidth,
																	this.someCanHeight
																			- this.var_4b0a.var_1042
																			- this.var_4b12.var_1042);
													this.var_4b02.sub_1698(
															this.var_4b0a, 0,
															0, 0);
													this.var_4b02
															.sub_1698(
																	this.var_4b1a,
																	0,
																	this.var_4b0a.var_1042,
																	0);
													this.var_4b02.sub_1698(
															this.var_4b12, 0,
															this.someCanHeight, 32);
													this.var_4b02.var_115a = true;
													this.var_4b02
															.sub_1350(this);
													this.var_4b02.sub_132e(
															(byte) 0, true);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_4b02);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(64))) {
													this.someActiveUnit.sub_26fe();
													sub_bc72();
													this.unitAtCursorPos = getUnitAtPos(
															this.cursorPosX,
															this.cursorPosY,
															(byte) 0);
													this.var_478a = 0;
													Class_f_StringManager.mainCanvas
															.sub_220e(this);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(66))) {
													sub_11699();
													Class_f_StringManager.mainCanvas
															.sub_220e(this);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(68))) {
													sub_11aac(
															(byte) 37,
															this.someActiveUnit.posX,
															this.someActiveUnit.posY);
													Class_f_StringManager.mainCanvas
															.sub_220e(sub_14359(
																	null,
																	Class_f_StringManager
																			.getLangString(74),
																	this.someCanHeight,
																	1000));
													Class_c_MainCanvas.playMusicLooped(9, 1);
													this.someActiveUnit.sub_26fe();
													this.var_478a = 0;
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(67))) {
													if (canOccupyVillageOrTownMaybe(this.someActiveUnit)) {
														sub_11ad0(
																this.someActiveUnit.posX,
																this.someActiveUnit.posY,
																this.var_4832[this.someActiveUnit.teamId]);
														Class_f_StringManager.mainCanvas
																.sub_220e(sub_14359(
																		null,
																		Class_f_StringManager
																				.getLangString(73),
																		this.someCanHeight,
																		1000));
														this.var_478a = 9;
														Class_c_MainCanvas.playMusicLooped(
																9, 1);
														this.var_481a = this.var_479a;
													}
													this.someActiveUnit.sub_26fe();
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(69))) {
													this.var_478a = 7;
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
													this.var_48d2 = true;
													Class_f_StringManager.mainCanvas
															.sub_220e(this);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(70))) {
													Class_e_FightAnimation localObject2 = new Class_e_FightAnimation(
															(byte) 15, 15);
													Class_e_FightAnimation localObject71 = new Class_e_FightAnimation(
															(byte) 10, 0);
													localObject71.sub_1ca8(
																	null,
																	this.var_4b52,
																	this.someCanWidth,
																	-1);
													Class_e_FightAnimation localObject81 = new Class_e_FightAnimation(
															(byte) 8, 0);
													localObject81.sub_17fe(
																	this.someCanWidth,
																	this.someCanHeight
																			- ((Class_e_FightAnimation) localObject71).var_1042
																			- this.buttonsSprite.spriteFrameHeight,
																	this.var_4782,
																	this.mapUnitsMaybe);
													((Class_e_FightAnimation) localObject2)
															.sub_1698(
																	(Class_e_FightAnimation) localObject81,
																	this.someCanWidthShift,
																	this.someCanHeightShift
																			+ (((Class_e_FightAnimation) localObject71).var_1042 - this.buttonsSprite.spriteFrameHeight)
																			/ 2,
																	3);
													((Class_e_FightAnimation) localObject2)
															.sub_1698(
																	(Class_e_FightAnimation) localObject71,
																	0, 0, 0);
													((Class_e_FightAnimation) localObject2)
															.sub_1350(paramClass_e_0134);
													((Class_e_FightAnimation) localObject2).var_115a = true;
													Class_f_StringManager.mainCanvas
															.sub_220e((Class_f_StringManager) localObject2);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(71))) {
													this.var_49c2.sub_132e(
															(byte) 0, false);
													this.var_49c2
															.sub_1350(paramClass_e_0134);
													Class_f_StringManager.mainCanvas
															.sub_220e(this.var_49c2);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(293))) {
													sub_19157(this.var_4b52,
															sub_bb13());
													Class_e_FightAnimation fAnima = sub_14359(
															null,
															Class_f_StringManager
																	.getStrByIdAndReplaceUWith(
																			45,
																			this.var_4b52),
																			this.someCanHeight, 2000);
													fAnima.sub_1350(this);
													Class_f_StringManager.mainCanvas
															.sub_220e((Class_f_StringManager) fAnima);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(305))) {
													sub_1a88b();
													Class_c_MainCanvas
															.setDisplayableAsCurrent(this.var_4fe2);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(306))) {
													sub_1aaa3();
													sub_1a91d();
													Class_c_MainCanvas
															.setDisplayableAsCurrent(this.var_4fea);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(307))) {
													sub_1aa08();
													Class_c_MainCanvas
															.setDisplayableAsCurrent(this.var_4ffa);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(303))) {
													sub_1aaa3();
													Class_c_MainCanvas
															.setDisplayableAsCurrent(this.var_4fda);
													return;
												}
												if (paramString
														.equals(Class_f_StringManager
																.getLangString(314))) {
													sub_1afeb();
													Class_c_MainCanvas
															.setDisplayableAsCurrent(this.var_505a);
													return;
												}
											} else {
												this.var_49da = new Class_e_FightAnimation(
														(byte) 15, 15);
												Class_e_FightAnimation lo2;
												(lo2 = new Class_e_FightAnimation(
														(byte) 10, 0))
														.sub_1ca8(null,
																paramString,
																this.someCanWidth,
																-1);
												((Class_e_FightAnimation) lo2).var_11b2 = this.menuIconsFrames[4];
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
														lo9[i1] = Class_f_StringManager
																.getLangString(42);
													} else {
														lo9[i1] = someOneOf12LangStrings[i1];
													}
												}
												localObject10 = new String[12 + this.settingsCountMaybe];
												System.arraycopy(lo9,
														0, localObject10, 0, 12);
												System.arraycopy(this.settingsStrListMaybe,
														0, localObject10, 12,
														this.settingsCountMaybe);
												this.var_49d2 = new Class_e_FightAnimation(
														(byte) 0, 0);
												this.var_49d2
														.sub_20ad(
																(String[]) localObject10,
																0,
																0,
																this.someCanWidth,
																this.someCanHeight
																		- ((Class_e_FightAnimation) lo2).var_1042
																		- (this.buttonsSprite.spriteFrameHeight << 1),
																3, 4);
												this.var_49da
														.sub_1698(
																this.var_49d2,
																this.someCanWidthShift,
																(this.someCanHeight + ((Class_e_FightAnimation) lo2).var_1042) / 2,
																3);
												this.var_49da
														.sub_1698(
																(Class_e_FightAnimation) lo2,
																0, 0, 0);
												this.var_49da.var_115a = true;
												this.var_49da.sub_132e(
														(byte) 0, true);
												this.var_49da
														.sub_1350(paramClass_e_0134);
												Class_f_StringManager.mainCanvas
														.sub_220e(this.var_49da);
												return;
											}
										} else {
											Class_f_StringManager.mainCanvas.sub_220e(this);
											if (paramClass_e_0134 == this.var_49e2) {
												this.var_47a2 = paramInt;
												this.var_49e2 = null;
											} else {
												this.var_47a2 = 0;
											}
											sub_1af6c();
											this.var_45fa = 0;
											this.var_487a[1] = 0;
											this.var_4982 = true;
											Class_f_StringManager.mainCanvas.repaintAll();
											System.gc();
											sub_5dc1();
											sub_aca4(this.var_47a2);
											this.var_4982 = false;
											sub_143ce();
											this.var_478a = 0;
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

	private Class_a_Unit sub_abab(Class_a_Unit paramClass_a_0260,
			int paramInt1, int paramInt2) {
		this.var_486a[this.someUnitTeamId] -= paramClass_a_0260.cost;
		paramClass_a_0260.health = 100;
		paramClass_a_0260.sub_1686(paramInt1, paramInt2);
		if (!this.mapUnitsMaybe.contains(paramClass_a_0260)) {
			this.mapUnitsMaybe.addElement(paramClass_a_0260);
		}
		this.var_4c42 = true;
		return paramClass_a_0260;
	}

	private Class_a_Unit sub_ac11(byte paramByte, int paramInt1, int paramInt2) {
		this.var_486a[this.someUnitTeamId] -= Class_a_Unit.unitsCost[paramByte];
		this.var_4c42 = true;
		return Class_a_Unit.createUnit(paramByte, this.someUnitTeamId, paramInt1,
				paramInt2);
	}

	public final Class_g_Sprite getTeamUnitSprite(byte teamId, byte unitType) {
		return this.unitTeamSprites[teamId][unitType];
	}

	private void sub_ac6f() {
		this.mapUnitsMaybe = new Vector();
		this.someActiveUnit = null;
		this.var_47ba = null;
		this.var_4c6a = null;
	}

	private void sub_aca4(int paramInt) {
		try {
			Class_c_MainCanvas.stopCurrentMusicPlayer();
			this.var_488a = new Vector();
			this.var_4aca = false;
			this.var_47f2 = true;
			this.var_4912 = false;
			this.var_4b4a = false;
			this.var_4802 = null;
			this.var_489a = null;
			this.var_4b32 = null;
			this.var_48a2 = null;
			this.var_48b2 = null;
			this.var_4ae2.removeAllElements();
			this.var_484a = 0;
			this.someUnitTeamId = 0;
			this.someUnitTeamId = 0;
			this.var_4e12 = 0;
			sub_ac6f();
			this.maybeTeamKings = null;
			this.var_4782 = null;
			this.var_47da = null;
			this.teamsCountMaybe = 0;
			for (int i = 0; i < 5; i++) {
				this.var_482a[i] = -1;
			}
			this.var_495a = true;
			Class_c_MainCanvas.initResPak();
			DataInputStream localObject;
			if (this.var_45fa == 0) {
				this.var_4b52 = Class_f_StringManager.getLangString(paramInt + 113);
				localObject = new DataInputStream(Class_c_MainCanvas.getResourceStream("m"
						+ paramInt + ".aem"));
			} else {
				this.var_4b52 = sub_75cb(paramInt);
				localObject = sub_74ac(paramInt);
			}
			this.mapWidthMaybe = ((DataInputStream) localObject).readInt();
			this.mapHeightMaybe = ((DataInputStream) localObject).readInt();
			this.var_4782 = new byte[this.mapWidthMaybe][this.mapHeightMaybe];
			this.var_47da = new byte[this.mapWidthMaybe][this.mapHeightMaybe];
			this.var_4d92 = new byte[this.mapWidthMaybe][this.mapHeightMaybe];
			this.var_4d9a = 0;
			int j = 0;
			Vector localVector1 = new Vector();
			Vector localVector2 = new Vector();
			for (int n = 0; n < this.mapWidthMaybe; n = (short) (n + 1)) {
				for (int i1 = 0; i1 < this.mapHeightMaybe; i1 = (short) (i1 + 1)) {
					this.var_4782[n][i1] = ((DataInputStream) localObject)
							.readByte();
					this.var_47da[n][i1] = 0;
					if (sub_11b28(this.var_4782[n][i1])) {
						int k = sub_11bae(n, i1);
						byte[] arrayOfByte2;
						(arrayOfByte2 = new byte[3])[0] = ((byte) n);
						arrayOfByte2[1] = ((byte) i1);
						arrayOfByte2[2] = ((byte) k);
						localVector1.addElement(arrayOfByte2);
						j++;
						if (getMapTileType(n, i1) == 9) {
							if ((this.var_45fa == 1) && (k != 0)
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
			this.var_49fa = new byte[j][];
			localVector1.copyInto(this.var_49fa);
			this.var_4a02 = new byte[this.var_4d9a][];
			localVector2.copyInto(this.var_4a02);
			this.var_46d2 = (this.mapWidthMaybe * 24);
			this.var_46da = (this.mapHeightMaybe * 24);
			if (this.var_45fa == 1) {
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
			this.var_487a[0] = 1;
			this.var_487a[1] = 0;
			this.var_45f2 = 100;
			int i2;
			for (int n = 0; n < this.var_49fa.length; n = (short) (n + 1)) {
				byte i1 = this.var_49fa[n][2];
				i2 = sub_11c17(i1);
				if ((i1 > 0) && ((i2 < 0) || (this.var_487a[i2] == 2))) {
					sub_11ad0(this.var_49fa[n][0], this.var_49fa[n][1], 0);
				}
			}
			int m = ((DataInputStream) localObject).readInt();
			((DataInputStream) localObject).skip(m << 2);
			int i1 = ((DataInputStream) localObject).readInt();
			this.maybeTeamKings = new Class_a_Unit[this.teamsCountMaybe];
			this.teamsUnits = new Class_a_Unit[this.teamsCountMaybe][4];
			this.teamsUnitsCount = new int[this.teamsCountMaybe];
			for (int n = 0; n < i1; n = (short) (n + 1)) {
				i2 = ((DataInputStream) localObject).readByte();
				m = ((DataInputStream) localObject).readShort() / 24;
				j = ((DataInputStream) localObject).readShort() / 24;
				byte b1 = (byte) (i2 % 12);
				byte b2 = (byte) sub_11c17(1 + i2 / 12);
				if (this.var_487a[b2] != 2) {
					Class_a_Unit localClass_a_0260 = Class_a_Unit.createUnit(b1,
							b2, m, j);
					if (b1 == 9) {
						this.maybeTeamKings[b2] = localClass_a_0260;
					}
				}
			}
			((DataInputStream) localObject).close();
			if (this.var_45fa == 0) {
				this.var_49c2 = sub_14359(
						Class_f_StringManager.getLangString(121 + this.var_47a2),
						Class_f_StringManager.getLangString(129 + this.var_47a2),
						this.someCanHeight, -1);
			} else {
				this.var_49c2 = (this.var_49c2 = sub_14359(
						Class_f_StringManager.getLangString(71), Class_f_StringManager.getLangString(137),
						this.someCanHeight, -1));
			}
			this.var_4e3a = false;
			this.var_4e02 = null;
			this.var_4de2 = null;
			this.var_4dea = null;
			this.var_4df2 = null;
			this.var_4dfa = null;
			this.var_4e0a = null;
			for (short n = 0; n < this.maybeTeamKings.length; n = (short) (n + 1)) {
				if (this.maybeTeamKings[n] == null) {
					this.var_4872[n][0] = 0;
					this.var_4872[n][1] = 0;
				} else {
					this.var_4872[n][0] = ((byte) this.maybeTeamKings[n].posX);
					this.var_4872[n][1] = ((byte) this.maybeTeamKings[n].posY);
				}
			}
			if (this.var_45fa == 1) {
				this.var_4e12 = 100;
				this.var_4a4a = true;
				for (short n = 0; n < this.teamsCountMaybe; n = (short) (n + 1)) {
					if (this.var_487a[n] != 2) {
						this.someUnitTeamId = ((byte) n);
						break;
					}
					this.var_484a = ((short) (this.var_484a + 1));
				}
			}
			if ((this.maybeTeamKings.length > 0)
					&& (this.maybeTeamKings[this.someUnitTeamId] != null)) {
				sub_efe5(this.maybeTeamKings[this.someUnitTeamId].posX,
						this.maybeTeamKings[this.someUnitTeamId].posY);
				moveCursorToPos(this.maybeTeamKings[this.someUnitTeamId].posX,
						this.maybeTeamKings[this.someUnitTeamId].posY);
			}
			this.var_4d6a = new Class_a_Unit[this.var_49fa.length];
			this.var_4d72 = new byte[this.var_49fa.length];
			this.var_4a6a = new Class_g_Sprite[this.var_49fa.length];
			for (short n = 0; n < this.var_49fa.length; n = (short) (n + 1)) {
				if (getMapTileType(this.var_49fa[n][0], this.var_49fa[n][1]) == 8) {
					this.var_4a6a[n] = Class_g_Sprite.sub_2054(this.bSmokeSprite, 0,
							-1, 0, 1, 250, (byte) 0);
					this.var_4a6a[n].var_c78 = false;
				}
			}
			if (this.var_487a[this.someUnitTeamId] == 0) {
				sub_122cc();
			}
			if ((this.var_4f92 != 0) || (this.teamsCountMaybe == 0)) {
				Class_c_MainCanvas.sub_2bf1(var_4692[1], 0);
			}
			if (this.var_4f92 != 0) {
				this.mapLeftX = 0;
				this.mapTopY = 0;
				this.cursorPosX = 0;
				this.cursorPosY = 0;
				this.cursorSprite.setPixelPosition(this.cursorPosX * 24, this.cursorPosY * 24);
			} else {
				someReadScriptMethod(paramInt);
				return;
			}
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	private void sub_b5bf(int[] paramArrayOfInt) {
		Class_c_MainCanvas.sub_1abc(paramArrayOfInt, true);
		for (int i = 0; i < this.mapWidthMaybe; i++) {
			for (int j = 0; j < this.mapHeightMaybe; j++) {
				if (this.var_47da[i][j] > 0) {
					this.var_4782[i][j] = ((byte) Class_c_MainCanvas
							.getRandomArrayItemOrWhat(paramArrayOfInt));
				}
			}
		}
		Class_c_MainCanvas.sub_1abc(paramArrayOfInt, false);
		sub_b87b();
	}

	private void sub_b66c(int paramInt1, int paramInt2, int paramInt3,
			int paramInt4, int[] paramArrayOfInt) {
		paramInt2 = this.mapWidthMaybe + paramInt1 + paramInt2;
		paramInt4 = this.mapHeightMaybe + paramInt3 + paramInt4;
		byte[][] arrayOfByte = new byte[paramInt2][paramInt4];
		Class_c_MainCanvas.sub_1abc(paramArrayOfInt, true);
		for (int k = 0; k < paramInt2; k++) {
			for (int m = 0; m < paramInt4; m++) {
				int i = k - paramInt1;
				int j = m - paramInt3;
				if ((i >= 0) && (j >= 0) && (i < this.mapWidthMaybe)
						&& (j < this.mapHeightMaybe)) {
					arrayOfByte[k][m] = this.var_4782[i][j];
				} else {
					arrayOfByte[k][m] = ((byte) Class_c_MainCanvas
							.getRandomArrayItemOrWhat(paramArrayOfInt));
				}
			}
		}
		Class_c_MainCanvas.sub_1abc(paramArrayOfInt, false);
		for (int itt = 0; itt < this.mapUnitsMaybe.size(); itt++) {
			Class_a_Unit localClass_a_0260;
			(localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe.elementAt(itt))
					.sub_1686(localClass_a_0260.posX + paramInt1,
							localClass_a_0260.posY + paramInt3);
		}
		this.var_4782 = arrayOfByte;
		this.mapWidthMaybe = paramInt2;
		this.mapHeightMaybe = paramInt4;
		this.var_47da = new byte[this.mapWidthMaybe][this.mapHeightMaybe];
		this.var_4d92 = new byte[this.mapWidthMaybe][this.mapHeightMaybe];
		sub_b87b();
		this.var_46d2 = (this.mapWidthMaybe * 24);
		this.var_46da = (this.mapHeightMaybe * 24);
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
			for (int k = 0; k < this.mapWidthMaybe; k = (short) (k + 1)) {
				for (int m = 0; m < this.mapHeightMaybe; m = (short) (m + 1)) {
					if (sub_11b28(this.var_4782[k][m])) {
						int j = sub_11bae(k, m);
						byte[] arrayOfByte2;
						(arrayOfByte2 = new byte[3])[0] = ((byte) k);
						arrayOfByte2[1] = ((byte) m);
						arrayOfByte2[2] = ((byte) j);
						localVector1.addElement(arrayOfByte2);
						i++;
						if (getMapTileType(k, m) == 9) {
							if ((this.var_45fa == 1) && (j != 0)
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
			this.var_49fa = new byte[i][];
			localVector1.copyInto(this.var_49fa);
			this.var_4a02 = new byte[this.var_4d9a][];
			localVector2.copyInto(this.var_4a02);
			this.var_4d6a = new Class_a_Unit[this.var_49fa.length];
			this.var_4d72 = new byte[this.var_49fa.length];
			this.var_4a6a = new Class_g_Sprite[this.var_49fa.length];
			for (int k = 0; k < this.var_49fa.length; k = (short) (k + 1)) {
				if (getMapTileType(this.var_49fa[k][0], this.var_49fa[k][1]) == 8) {
					this.var_4a6a[k] = Class_g_Sprite.sub_2054(this.bSmokeSprite, 0,
							-1, 0, 1, 250, (byte) 0);
					this.var_4a6a[k].var_c78 = false;
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
					(OutputStream) localObject)).writeInt(this.mapWidthMaybe);
			localDataOutputStream.writeInt(this.mapHeightMaybe);
			for (int i = 0; i < this.mapWidthMaybe; i++) {
				for (int j = 0; j < this.mapHeightMaybe; j++) {
					localDataOutputStream.writeByte(this.var_4782[i][j]);
				}
			}
			localDataOutputStream.writeInt(0);
			localDataOutputStream.writeInt(this.mapUnitsMaybe.size());
			for (int i = 0; i < this.mapUnitsMaybe.size(); i++) {
				Class_a_Unit localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
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
		this.var_47ba = new Class_a_Unit[0];
		sub_bcb2(this.var_47da, 0);
		this.var_47e2 = false;
		this.var_47ea = false;
	}

	private void sub_bcb2(byte[][] paramArrayOfByte, int paramInt) {
		for (int i = 0; i < this.mapWidthMaybe; i++) {
			for (int j = 0; j < this.mapHeightMaybe; j++) {
				paramArrayOfByte[i][j] = ((byte) paramInt);
			}
		}
	}

	private void sub_bd39(Class_a_Unit paramClass_a_0260) {
		Class_c_MainCanvas.sub_2d32(10);
		this.var_4c6a = null;
		sub_bcb2(this.var_47da, 0);
		this.var_47e2 = false;
		if (this.var_487a[this.someUnitTeamId] == 1) {
			this.var_4c7a = 1;
			this.var_47f2 = true;
			this.cursorSprite.setFrameSequence(var_4662[0]);
			this.var_478a = 3;
			sub_6e49(sub_bddb(paramClass_a_0260, (byte) 0));
			Class_c_MainCanvas.playMusicLooped(11, 1);
			return;
		}
		if (this.var_487a[this.someUnitTeamId] == 0) {
			this.var_4d22 = 4;
			this.var_478a = 0;
		}
	}

	private byte[] sub_bddb(Class_a_Unit paramClass_a_0260, byte paramByte) {
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

	private void sub_bf69() {
		if ((Class_c_MainCanvas.propDisableIntroOn) && (this.var_490a < 4)) {
			this.var_48fa = new Class_d_ImageWrap("logo", this.canvasWidth, -1); // @todo j?
			this.var_490a = 3;
			this.var_491a = 40;
		}
		switch (this.var_490a) {
		case 0:
			if (this.var_479a >= 1200L) {
				this.var_490a = 1;
			}
			this.var_491a = 40;
			return;
		case 1:
			if (this.var_491a <= 0) {
				this.msLogoImage = null;
				this.var_491a = 0;
				this.var_490a += 1;
				initIntro(0, 0, 3);
				return;
			}
			this.var_491a -= 1;
			return;
		case 2:
			initIntro(1, 2, 3);
			this.var_48fa = new Class_d_ImageWrap("logo", this.canvasWidth, -1); // j
			this.var_490a += 1;
			return;
		case 3:
			if (++this.var_491a > 40) {
				try {
					this.var_48f2 = new Class_d_ImageWrap("splash", this.someCanWidth,
							-1);
					this.var_4902 = new Class_d_ImageWrap("glow");
				} catch (Exception localException) {
				}
				if (this.var_48f2 != null) {
					this.var_491a = 0;
				} else {
					this.var_491a = 11;
				}
				this.var_490a += 1;
				Class_f_StringManager.mainCanvas.sub_26ad();
				return;
			}
			break;
		case 4:
			if (this.var_491a < 16) {
				this.var_491a += 1;
				this.var_4922 += 1;
				if (this.var_4902 != null) {
					this.var_4a42 = (-this.var_4902.imageWidth);
				}
			} else {
				if (this.var_4a42 >= this.canvasWidth << 2) {
					if (this.var_4902 != null) {
						this.var_4a42 = (-this.var_4902.imageWidth);
					}
				} else {
					this.var_4a42 += this.var_48fa.imageWidth / 6;
				}
				if (this.var_479a % 100L == 0L) {
					this.var_498a = (!this.var_498a);
				}
				if (((this.var_48f2 == null) || (Class_f_StringManager.mainCanvas
						.sub_2677())) && (sub_5d81())) {
					if (this.var_4902 != null) {
						this.var_4a42 = (-this.var_4902.imageWidth);
					}
					this.var_498a = false;
					int i = this.var_48fa.imageHeight + 1;
					sub_6d11(this.var_464a, (this.canvasHeight + i) / 2,
							this.canvasHeight - i, this.var_48f2 == null ? null
									: this);
					Class_f_StringManager.mainCanvas.sub_26ad();
				}
			}
			break;
		}
	}

	@Override
	public final void paintScene() {
		this.var_479a += 50L;
		Class_g_Game localObject1;
		int m;
		if (this.var_48e2 == 2) {
			localObject1 = this;
			if ((this.var_4e82)
					&& (((Class_g_Game) localObject1).var_479a
							- ((Class_g_Game) localObject1).var_4e92 >= ((Class_g_Game) localObject1).var_4e8a)) {
				((Class_g_Game) localObject1).var_4e82 = false;
			}
			for (m = 0; m < ((Class_g_Game) localObject1).spritesList.size(); m++) {
				((Class_g_Sprite) ((Class_g_Game) localObject1).spritesList
						.elementAt(m)).sub_21f3();
			}
			for (m = 0; m < ((Class_g_Game) localObject1).spritesList.size(); m++) {
				Class_g_Sprite localClass_g_25175;
				if (!(localClass_g_25175 = (Class_g_Sprite) ((Class_g_Game) localObject1).spritesList
						.elementAt(m)).var_c78) {
					((Class_g_Game) localObject1).removeSomeSprite(localClass_g_25175);
				}
			}
			((Class_g_Game) localObject1).var_4e5a.sub_16b8();
			((Class_g_Game) localObject1).var_4e62.sub_16b8();
			if (((Class_g_Game) localObject1).var_4ea2) {
				((Class_g_Game) localObject1).var_491a += 1;
				if (((Class_g_Game) localObject1).var_491a >= 16) {
					((Class_g_Game) localObject1).var_4ea2 = false;
					((Class_g_Game) localObject1).var_4e5a.sub_1688();
				}
				((Class_g_Game) localObject1).var_4eaa = true;
				((Class_g_Game) localObject1).var_4eb2 = true;
			} else if (((Class_g_Game) localObject1).var_4e72) {
				if (((Class_g_Game) localObject1).var_479a
						- ((Class_g_Game) localObject1).var_4e6a >= 300L) {
					((Class_g_Game) localObject1).spritesList.removeAllElements();
					((Class_g_Game) localObject1).var_4e62 = null;
					((Class_g_Game) localObject1).var_4e5a = null;
					((Class_g_Game) localObject1).var_488a = new Vector();
					((Class_g_Game) localObject1).sub_6a9a();
					((Class_g_Game) localObject1).var_48e2 = 1;
					Class_c_MainCanvas.stopCurrentMusicPlayer();
					Class_c_MainCanvas
							.playMusicLooped(
									var_4692[localObject1.var_4832[localObject1.someUnitTeamId]],
									0);
					Class_f_StringManager.mainCanvas.sub_26ad();
					((Class_g_Game) localObject1).var_4c42 = true;
					((Class_g_Game) localObject1).var_4c4a = true;
					return;
				}
			} else if (((Class_g_Game) localObject1).var_4e5a.var_b5f) {
				if ((((Class_g_Game) localObject1).var_4e9a)
						&& (((Class_g_Game) localObject1).var_4e62.var_b77 > 0)) {
					if (!((Class_g_Game) localObject1).var_4e62.var_b57) {
						((Class_g_Game) localObject1).var_4e62.sub_1688();
					}
					if (!((Class_g_Game) localObject1).var_4e62.var_b5f) {
					}
				} else {
					((Class_g_Game) localObject1).var_4e72 = true;
					((Class_g_Game) localObject1).var_4e6a = ((Class_g_Game) localObject1).var_479a;
				}
			}
		} else if (this.var_48e2 == 3) {
			localObject1 = this;
			if (this.var_4cc2) {
				localObject1.var_491a -= 1;
				if (((Class_g_Game) localObject1).var_491a < 0) {
					((Class_g_Game) localObject1).var_491a = 0;
					((Class_g_Game) localObject1).var_48e2 = ((Class_g_Game) localObject1).var_4cca;
					((Class_g_Game) localObject1).introImage = null;
					((Class_g_Game) localObject1).introTextWrapped = null;
					return;
				}
			} else {
				if (((((Class_g_Game) localObject1).var_4cd2 != 2) || (((Class_g_Game) localObject1).var_491a >= 40))
						&& ((((Class_g_Game) localObject1).var_4cd2 == 2) || (((Class_g_Game) localObject1).var_491a >= 16))) {
					localObject1.var_4c9a -= 1;
					if (((Class_g_Game) localObject1).var_4c9a < ((Class_g_Game) localObject1).introImageHeight) {
						((Class_g_Game) localObject1).var_4c9a = (((Class_g_Game) localObject1).introImageHeight
								+ ((Class_g_Game) localObject1).var_4c92 - (((Class_g_Game) localObject1).introImageHeight - ((Class_g_Game) localObject1).var_4c9a));
						localObject1.var_4caa += 1;
					}
				} else {
					localObject1.var_491a += 1;
				}
				if ((((Class_g_Game) localObject1).var_4caa >= ((Class_g_Game) localObject1).introTextWrapped.length)
						|| (Class_f_StringManager.mainCanvas.sub_272b(var_4602))) {
					((Class_g_Game) localObject1).var_4cc2 = true;
					if ((((Class_g_Game) localObject1).introImage != null)
							|| (((Class_g_Game) localObject1).var_4caa < ((Class_g_Game) localObject1).introTextWrapped.length)) {
						if (((Class_g_Game) localObject1).var_4cda == 2) {
							((Class_g_Game) localObject1).var_491a = 40;
							return;
						}
						((Class_g_Game) localObject1).var_491a = 16;
						return;
					}
					((Class_g_Game) localObject1).var_491a = 0;
				}
			}
		} else {
			if (this.var_48e2 == 0) {
				sub_bf69();
				return;
			}
			sub_155a2();
			if (this.var_49a2 != -1) {
				if (Class_c_MainCanvas.settings[2] != false) {
					Class_e_FightAnimation lo1;
					(lo1 = showUnitDialog(
							Class_f_StringManager.getLangString(196 + this.var_49a2, true),
							(byte) -1, (byte) 2)).var_11aa = 7831691;
					((Class_e_FightAnimation) lo1).var_11a2 = 7831691;
					((Class_e_FightAnimation) lo1).var_fea = 16250855;
				}
				this.var_49a2 = -1;
			}
			if (Class_f_StringManager.mainCanvas.var_17b7 == this) {
				int i;
				if (this.var_478a == 0) {
					for (i = 0; i < this.var_4a6a.length; i++) {
						m = sub_11bae(this.var_49fa[i][0], this.var_49fa[i][1]);
						if ((this.var_4a6a[i] != null) && (m != -1) && (m != 0)
								&& (!this.var_4a6a[i].var_c78)
								&& (Class_c_MainCanvas.random.nextInt() % 8 == 0)) {
							this.var_4a6a[i].var_c78 = true;
							this.var_4a6a[i].setCurrentFrameIndex(0);
							this.var_4a6a[i].var_c48 = 1;
							this.var_4a6a[i].setPixelPosition((this.var_49fa[i][0] + 1)
									* 24 - this.bSmokeSprite.spriteFrameWidth,
									this.var_49fa[i][1] * 24 - 2);
							this.spritesVector.addElement(this.var_4a6a[i]);
						}
					}
				}
				if (this.var_479a - this.var_4952 >= 300L) {
					this.var_494a = (!this.var_494a);
					this.var_4952 = this.var_479a;
				}
				if ((this.var_4e82)
						&& (this.var_479a - this.var_4e92 >= this.var_4e8a)) {
					this.var_4e82 = false;
				}
				if (this.var_4912) {
					this.var_491a += 1;
					if (this.var_491a > 16) {
						if (this.var_478a == 10) {
							this.var_4e52 = 1;
						} else if (this.var_478a == 11) {
							if (this.var_45fa == 0) {
								this.var_4ada = true;
								this.var_4ad2 = true;
								this.var_4ac2 = 0;
							}
							this.var_49f2 = 0;
							this.var_481a = this.var_479a;
						} else {
							sub_18762(this.var_493a, this.var_4942);
							this.var_4d3a = null;
							sub_bc72();
						}
						this.var_4912 = false;
					}
				} else {
					if (this.var_4ada) {
						if (this.var_4aca) {
							if (this.var_4ac2 < 16) {
								this.var_4ac2 += 1;
							}
						} else if (this.var_4ad2) {
							this.var_4ac2 += 1;
							if (this.var_4ac2 > 16) {
								this.var_4ad2 = false;
							}
						}
					}
					if (this.var_4802 != null) {
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
						if (this.var_4c8a > 0) {
							this.var_4c8a -= 4;
							if (this.var_4c8a < 0) {
								this.var_4c8a = 0;
							}
						}
					}
					if ((this.var_47f2)
							&& (this.var_479a - this.var_4672 >= 200L)) {
						this.cursorSprite.nextFrame();
						this.var_4672 = this.var_479a;
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
					if ((!this.var_4a5a) && (this.var_4a52 > 0)) {
						if (this.var_4a52 < 2) {
							this.var_4a52 = 0;
						} else {
							this.var_4a52 /= 2;
						}
						this.var_4c42 = true;
						this.var_4c4a = true;
					} else {
						Class_a_Unit localClass_a_0260;
						if (this.var_478a == 8) {
							if (this.var_4812 == 0) {
								if (this.var_4a52 >= var_4592) {
									this.var_4812 = 1;
									sub_116cf();
									Object localObject2;
									if (this.var_487a[this.someUnitTeamId] == 1) {
										localObject2 = "" + this.var_4d12;
									} else {
										localObject2 = "?";
									}
									localObject2 = sub_14359(
											Class_f_StringManager.getLangString(75),
											Class_f_StringManager.getStrByIdAndReplaceUWith(76,
													(String) localObject2),
											this.someCanHeight, 1500);
									Class_f_StringManager.mainCanvas
											.sub_220e((Class_f_StringManager) localObject2);
									((Class_e_FightAnimation) localObject2).var_11a2 = var_468a[this.var_4832[this.someUnitTeamId]];
									Class_c_MainCanvas
											.sub_2bf1(
													var_4692[this.var_4832[this.someUnitTeamId]],
													0);
									return;
								}
								if (this.var_4a52 == 0) {
									this.var_4a5a = true;
									this.var_4a52 = 1;
								} else {
									this.var_4a52 <<= 1;
								}
								this.var_4c42 = true;
								this.var_4c4a = true;
							} else {
								for (i = this.mapUnitsMaybe.size() - 1; i >= 0; i--) {
									if (((localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
											.elementAt(i)).var_e83 != 3)
											&& (this.someUnitTeamId == localClass_a_0260.teamId)
											&& ((getMapTileType(
													localClass_a_0260.posX,
													localClass_a_0260.posY) == 7) || (sub_11c55(
													localClass_a_0260.posX,
													localClass_a_0260.posY,
													this.var_483a[localClass_a_0260.teamId])))
											&& (localClass_a_0260.health < 100)) {
										int n;
										if ((n = 100 - localClass_a_0260.health) > 20) {
											n = 20;
										}
										localClass_a_0260.health += n;
										Class_g_Sprite localClass_g_25171;
										(localClass_g_25171 = Class_g_Sprite
												.createSomeSprite("+" + n, 0, -4,
														(byte) 1)).setPixelPosition(
												localClass_a_0260.pixelX
														+ localClass_a_0260.spriteFrameWidth
														/ 2,
												localClass_a_0260.pixelY
														+ localClass_a_0260.spriteFrameHeight); // m
																				// n
										this.var_488a
												.addElement(localClass_g_25171);
									}
								}
								this.var_4812 = 0;
								this.var_4a5a = false;
								this.var_478a = 0;
							}
						} else if (this.var_478a == 9) {
							this.var_478a = 0;
						} else if (this.var_478a == 11) {
							if ((!this.var_4912)
									&& (this.var_49f2 == 0)
									&& ((this.var_45fa == 1)
											|| (this.var_479a - this.var_481a >= 3000L) || (Class_f_StringManager.mainCanvas
												.sub_2677()))) {
								this.someCanHeight = this.canvasHeight;
								this.someCanHeightShift = this.canvasHeightShift;
								sub_6d11(this.var_464a, this.canvasHeightShift,
										this.canvasHeight, null);
								this.var_49f2 = 1;
								this.var_4ad2 = false;
							}
						} else if ((this.var_478a != 10)
								&& (this.var_478a != 14)) {
							if (this.var_478a == 13) {
								if (this.var_492a == 0) {
									Class_c_MainCanvas.sub_2af6(200);
									int i1 = this.var_493a
											.getDamageWhenAttack(this.var_4942);
									this.var_4942.sub_108f(400);
									Class_c_MainCanvas.playMusicLooped(14, 1);
									showSpriteOnMap(this.redsparkSprite, this.var_4942.pixelX,
											this.var_4942.pixelY, 0, 0, 2, 50);
									Class_g_Sprite localClass_g_25172 = Class_g_Sprite
											.createSomeSprite("-" + i1, 0, -4, (byte) 1);
									if ((i = this.var_4942.pixelX + this.var_4942.spriteFrameWidth
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
											this.var_4942.pixelY + this.var_4942.spriteFrameHeight);
									this.var_488a
											.addElement(localClass_g_25172);
									this.var_4932 = this.var_479a;
									this.var_492a += 1;
								} else if (this.var_492a == 1) {
									if (this.var_479a - this.var_4932 >= 800L) {
										moveCursorToPos(this.var_493a.posX,
												this.var_493a.posY);
										if (this.var_4942.canAttackPosition(
												this.var_493a.posX,
												this.var_493a.posY)) {
											Class_c_MainCanvas.sub_2af6(200);
											int i2 = this.var_4942
													.getDamageWhenAttack(this.var_493a);
											this.var_493a.sub_108f(400);
											Class_c_MainCanvas.playMusicLooped(14, 1);
											showSpriteOnMap(this.redsparkSprite,
													this.var_493a.pixelX,
													this.var_493a.pixelY, 0, 0, 2,
													50);
											Class_g_Sprite localClass_g_25173 = Class_g_Sprite
													.createSomeSprite("-" + i2, 0, -4,
															(byte) 1);
											if ((i = this.var_493a.pixelX
													+ this.var_493a.spriteFrameWidth / 2)
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
													this.var_493a.pixelY
															+ this.var_493a.spriteFrameHeight);
											this.var_488a
													.addElement(localClass_g_25173);
											this.var_4932 = this.var_479a;
											this.var_492a += 1;
										} else {
											sub_6a9a();
										}
									}
								} else if (this.var_479a - this.var_4932 >= 800L) {
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
											Class_e_FightAnimation localClass_e_01342;
											(localClass_e_01342 = sub_14359(
															null,
															Class_f_StringManager
																	.getLangString(280),
															this.someCanHeight, 2000))
													.sub_1930(this.someCanWidthShift, 2,
															17);
											Class_f_StringManager.mainCanvas
													.sub_220e(localClass_e_01342);
											this.var_4b3a = 1;
										}
									} else if (this.var_4b3a == 1) {
										for (i = 0; i < 3; i++) {
											showSpriteOnMap(
													this.bSmokeSprite,
													this.var_4b2a.pixelX
															+ Class_c_MainCanvas
																	.getRandomMax(this.var_4b2a.spriteFrameWidth
																			- this.bSmokeSprite.spriteFrameWidth),
													this.var_4b2a.pixelY, 0,
													Class_c_MainCanvas
															.getRandomWithin(-3, 0),
													1, 50 * Class_c_MainCanvas
															.getRandomMax(4));
										}
										if (this.var_4b2a.pixelY >= this.var_4b32.pixelY) {
											this.var_4b2a.var_c78 = false;
											Class_c_MainCanvas.sub_2af6(200);
											sub_188ce(500);
											if (this.var_4b42) {
												int i3;
												if ((i3 = 25 + Class_c_MainCanvas
														.getRandomMax(25)) > this.var_4b32.health) {
													i3 = this.var_4b32.health;
												}
												this.var_4b32.health -= i3;
												Class_g_Sprite localObject31 = Class_g_Sprite
														.createSomeSprite("-" + i3, 0,
																-4, (byte) 1);
												localObject31 
														.setPixelPosition(
																this.var_4b32.pixelX
																		+ this.var_4b32.spriteFrameWidth
																		/ 2,
																this.var_4b32.pixelY
																		+ this.var_4b32.spriteFrameHeight);
												this.var_488a
														.addElement(localObject31 );
											}
											sub_ecee(this.var_4b32);
											this.var_4b3a = 2;
										}
									} else if (++this.var_4b3a >= 20) {
										if (this.var_4b32.health <= 0) {
											this.var_489a = this.var_4b32;
											showSpriteOnMap(this.sparkSprite,
													this.var_489a.pixelX,
													this.var_489a.pixelY, 0, 0, 1,
													50);
											Class_c_MainCanvas.playMusicLooped(12, 1);
											this.var_48aa = this.var_479a;
										}
										this.var_4b32 = null;
									}
								} else if (this.var_48a2 != null) {
									if (--this.var_48ca <= 0) {
										Class_c_MainCanvas.sub_2af6(100);
										sub_ecee(this.var_48a2);
										sub_11aac((byte) 27,
												this.var_48a2.posX,
												this.var_48a2.posY);
										this.var_48a2 = null;
									}
								} else if (this.var_489a != null) {
									if ((this.var_479a - this.var_48aa >= 300L)
											&& (sub_ee85(this.var_489a.posX,
													this.var_489a.posY))) {
										if ((this.var_45fa == 0)
												&& (this.var_47a2 == 7)
												&& (this.var_489a == this.maybeTeamKings[1])) {
											this.var_4b4a = true;
										} else {
											showSpriteOnMap(this.smokeSprite,
													this.var_489a.pixelX,
													this.var_489a.pixelY, 0, -3, 1,
													100);
											this.var_489a.var_e83 = 3;
											this.var_489a.var_ecb = 3;
											if ((this.var_489a.unitType != 10)
													&& (this.var_489a.unitType != 11)) {
												if (this.var_489a.unitType == 9) {
													this.var_489a.sub_1686(-10,
															-10);
													this.var_489a.var_e8b = 0;
													this.var_489a.sub_160c();
												}
											} else {
												this.var_489a.killUnitMaybe();
											}
											if ((this.var_489a.unitType == 9)
													&& (this.var_489a.cost < 1000)) {
												this.var_489a.cost += 200;
											}
										}
										this.var_489a = null;
									}
								} else {
									int i10;
									if (this.var_4ae2.size() > 0) {
										localClass_a_0260 = (Class_a_Unit) this.var_4ae2
												.elementAt(0);
										if (this.var_4af2 == 0) {
											moveCursorToPos(localClass_a_0260.posX,
													localClass_a_0260.posY);
											this.var_4af2 = 1;
										} else if (sub_ee85(
												localClass_a_0260.posX,
												localClass_a_0260.posY)) {
											showSpriteOnMap(
													this.smallSparkSprite,
													localClass_a_0260.pixelX
															+ Class_c_MainCanvas
																	.getRandomMax(localClass_a_0260.spriteFrameWidth),
													localClass_a_0260.pixelY
															+ Class_c_MainCanvas
																	.getRandomMax(localClass_a_0260.spriteFrameHeight),
													0, 0, 1, 50);
											if (this.var_4af2 == 1) {
												Class_c_MainCanvas.playMusicLooped(13, 1);
											}
											if (this.var_4af2 <= 5) {
												i10 = 200;
												if (this.var_4af2 == 5) {
													i10 = 1000;
												}
												i = localClass_a_0260.pixelX
														+ (localClass_a_0260.spriteFrameWidth - this.levelUpSprite.spriteFrameWidth)
														/ 2;
												int i11 = localClass_a_0260.pixelY
														- (this.var_4af2 << 2);
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
											this.var_4af2 += 1;
											if (this.var_4af2 >= 20) {
												this.var_4ae2
														.removeElement(localClass_a_0260);
												this.var_4af2 = 0;
												if ((localClass_a_0260.unitType != 9)
														&& (localClass_a_0260.level <= 6)
														&& (localClass_a_0260.level % 2 == 0)) {
													Class_f_StringManager.mainCanvas
															.sub_220e(sub_14359(
																			null,
																			Class_f_StringManager
																					.getLangString(80)
																					+ "\n"
																					+ localClass_a_0260.unitName,
																			this.someCanWidth,
																			2000));
												}
											}
										}
									} else if (this.var_48b2 != null) {
										if (this.var_479a - this.var_48c2 >= 400L) {
											this.var_48b2.killUnitMaybe();
											Class_a_Unit.createUnit((byte) 10,
													this.var_48ba,
													this.var_48b2.posX,
													this.var_48b2.posY)
													.sub_26fe();
											this.var_48b2 = null;
										}
									} else if (!this.var_4e3a) {
										if (this.var_478a == 2) {
											if ((this.someActiveUnit.var_e83 != 1)
													&& (this.var_4c82)) {
												sub_bd39(this.someActiveUnit);
											}
										} else if ((this.var_4f92 == 0)
												&& (this.var_487a[this.someUnitTeamId] == 0)) {
											sub_1240c();
										} else if (sub_5d81()) {
											if ((this.var_48da)
													&& (Class_f_StringManager.mainCanvas
															.sub_272b(var_4602))) {
												Class_f_StringManager.mainCanvas
														.runGameAction(16);
												Class_f_StringManager.mainCanvas
														.releaseGameAction(var_4602);
											}
											if ((this.var_478a != 6)
													&& (this.var_478a != 7)) {
												if ((this.var_479a
														- this.var_467a >= 150L)
														&& (this.cursorSprite.pixelX % 24 == 0)
														&& (this.cursorSprite.pixelY % 24 == 0)) {
													if ((!Class_f_StringManager.mainCanvas
															.sub_26d7(4))
															&& (!Class_f_StringManager.mainCanvas
																	.isGameActionRunning(4))) {
														if ((Class_f_StringManager.mainCanvas
																.sub_26d7(8))
																|| (Class_f_StringManager.mainCanvas
																		.isGameActionRunning(8))) {
															if (this.cursorPosX < this.mapWidthMaybe - 1) {
																this.cursorPosX += 1;
															}
															this.var_495a = true;
															this.var_467a = this.var_479a;
														}
													} else {
														if (this.cursorPosX > 0) {
															this.cursorPosX -= 1;
														}
														this.var_495a = true;
														this.var_467a = this.var_479a;
													}
													if ((!Class_f_StringManager.mainCanvas
															.sub_26d7(1))
															&& (!Class_f_StringManager.mainCanvas
																	.isGameActionRunning(1))) {
														if ((Class_f_StringManager.mainCanvas
																.sub_26d7(2))
																|| (Class_f_StringManager.mainCanvas
																		.isGameActionRunning(2))) {
															if (this.cursorPosY < this.mapHeightMaybe - 1) {
																this.cursorPosY += 1;
															}
															this.var_495a = true;
															this.var_467a = this.var_479a;
														}
													} else {
														if (this.cursorPosY > 0) {
															this.cursorPosY -= 1;
														}
														this.var_495a = true;
														this.var_467a = this.var_479a;
													}
													if (this.var_495a) {
														if (this.var_478a == 1) {
															if (this.var_47da[this.cursorPosX][this.cursorPosY] > 0) {
																this.var_4802 = this.someActiveUnit
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
												if (((this.var_478a == 1) || (this.var_478a == 0))
														&& (this.var_4f92 == 0)
														&& (Class_f_StringManager.mainCanvas
																.sub_26d7(256))) {
													if ((localClass_a_0260 = getUnitAtPos(
															this.cursorPosX,
															this.cursorPosY,
															(byte) 0)) != null) {
														Class_e_FightAnimation localObject31  = new Class_e_FightAnimation(
																(byte) 15, 15);
														localObject31.var_11e2 = this.someCanHeight;
														Class_e_FightAnimation localClass_e_01343 = new Class_e_FightAnimation(
																(byte) 5, 2);
														Class_e_FightAnimation localClass_e_01341;
														(localClass_e_01341 = new Class_e_FightAnimation(
																(byte) 10, 1)).var_1152 = true;
														String str = Class_f_StringManager
																.getLangString(184 + localClass_a_0260.unitType);
														if (localClass_a_0260.var_e8b != 0) {
															StringBuffer localStringBuffer = new StringBuffer(
																	Class_f_StringManager
																			.getLangString(98));
															if ((localClass_a_0260.var_e8b & 0x2) != 0) {
																localStringBuffer
																		.append('\n');
																localStringBuffer
																		.append(Class_f_StringManager
																				.getLangString(100));
															}
															if ((localClass_a_0260.var_e8b & 0x1) != 0) {
																localStringBuffer
																		.append('\n');
																localStringBuffer
																		.append(Class_f_StringManager
																				.getLangString(99));
															}
															localStringBuffer
																	.append("\n-----------\n");
															str = localStringBuffer
																	.toString()
																	+ str;
														}
														localClass_e_01341
																.sub_1ca8(
																		null,
																		str,
																		this.someCanWidth,
																		this.someCanHeight
																				- localClass_e_01343.var_1042);
														((Class_e_FightAnimation) localObject31)
																.sub_1698(
																		localClass_e_01343,
																		0, 0, 0);
														((Class_e_FightAnimation) localObject31)
																.sub_1698(
																		localClass_e_01341,
																		0,
																		localClass_e_01343.var_1042,
																		0);
														((Class_e_FightAnimation) localObject31).var_115a = true;
														((Class_e_FightAnimation) localObject31)
																.sub_1350(this);
														Class_f_StringManager.mainCanvas
																.sub_220e((Class_f_StringManager) localObject31);
													}
													Class_f_StringManager.mainCanvas
															.releaseGameAction(256);
												}
												if (this.var_478a == 1) {
													if ((Class_f_StringManager.mainCanvas
															.sub_26d7(16))
															&& (this.someActiveUnit != null)) {
														localClass_a_0260 = getUnitAtPos(
																this.cursorPosX,
																this.cursorPosY,
																(byte) 0);
														if ((this.var_47da[this.cursorPosX][this.cursorPosY] > 0)
																&& ((localClass_a_0260 == null) || (localClass_a_0260 == this.someActiveUnit))) {
															this.var_47ca = this.someActiveUnit.posX;
															this.var_47d2 = this.someActiveUnit.posY;
															this.someActiveUnit
																	.sub_1c9f(
																			this.cursorPosX,
																			this.cursorPosY,
																			true);
															this.var_4c6a = this.someActiveUnit;
															this.var_47f2 = false;
															this.var_47e2 = false;
															this.var_4802 = null;
															this.var_4882 = null;
															this.var_48d2 = false;
															this.var_48da = false;
															this.var_478a = 2;
															Class_c_MainCanvas
																	.playMusicLooped(
																			10,
																			1);
														}
														Class_f_StringManager.mainCanvas
																.releaseGameAction(16);
													}
												} else if (this.var_478a == 0) {
													int i4;
													if (this.var_4f92 == 1) {
														if (Class_f_StringManager.mainCanvas
																.sub_26d7(128)) {
															if ((this.cursorTileId = (byte) (this.cursorTileId + 1)) >= this.tiles0Frames.length) {
																this.cursorTileId = 0;
															}
															this.var_4c42 = true;
															this.var_4c4a = true;
														} else if (Class_f_StringManager.mainCanvas
																.sub_26d7(64)) {
															if ((this.cursorTileId = (byte) (this.cursorTileId - 1)) < 0) {
																this.cursorTileId = ((byte) (this.tiles0Frames.length - 1));
															}
															this.var_4c42 = true;
															this.var_4c4a = true;
														} else {
															int i12;
															if (Class_f_StringManager.mainCanvas
																	.sub_26d7(16)) {
																if (this.var_47e2) {
																	if (this.var_47da[this.cursorPosX][this.cursorPosY] == 0) {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 1;
																	} else {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 0;
																	}
																	this.var_47e2 = false;
																	for (i10 = 0; i10 < this.mapWidthMaybe; i10++) {
																		for (i12 = 0; i12 < this.mapHeightMaybe; i12++) {
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
																	this.var_4782[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																}
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(512)) {
																if (this.cursorTileId == this.var_4782[this.cursorPosX][this.cursorPosY]) {
																	if ((this.cursorTileId = (byte) (this.cursorTileId + 1)) >= this.tiles0Frames.length) {
																		this.cursorTileId = 0;
																	}
																	this.var_4782[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																} else {
																	this.cursorTileId = this.var_4782[this.cursorPosX][this.cursorPosY];
																}
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(256)) {
																if (this.cursorTileId == this.var_4782[this.cursorPosX][this.cursorPosY]) {
																	if ((this.cursorTileId = (byte) (this.cursorTileId - 1)) < 0) {
																		this.cursorTileId = ((byte) (this.tiles0Frames.length - 1));
																	}
																	this.var_4782[this.cursorPosX][this.cursorPosY] = this.cursorTileId;
																	sub_b87b();
																} else {
																	this.cursorTileId = this.var_4782[this.cursorPosX][this.cursorPosY];
																}
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(32)) {
																if (this.var_47e2) {
																	sub_b5bf(this.var_4fba);
																} else {
																	this.cursorTileId = this.var_4782[this.cursorPosX][this.cursorPosY];
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
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(16384)) {
																if (this.var_47e2) {
																	if (this.var_47da[this.cursorPosX][this.cursorPosY] == 0) {
																		this.var_47da[this.cursorPosX][this.cursorPosY] = 1;
																	} else {
																		i10 = this.mapWidthMaybe;
																		i12 = this.mapHeightMaybe;
																		int j = -1;
																		int i13 = -1;
																		for (int i14 = 0; i14 < this.mapWidthMaybe; i14++) {
																			for (i4 = 0; i4 < this.mapHeightMaybe; i4++) {
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
																					&& (j == this.mapWidthMaybe - 1)
																					&& (i13 == this.mapHeightMaybe - 1)) {
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
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(8192)) {
																if (this.teamsCountMaybe > 0) {
																	sub_bcb2(
																			this.var_47da,
																			0);
																	this.var_47e2 = false;
																	this.var_4f92 = 2;
																	this.someUnitTeamId = 0;
																	this.var_4f8a = null;
																	this.var_4c42 = true;
																	this.var_4c4a = true;
																}
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(var_4602)) {
																this.var_4882 = new Class_e_FightAnimation(
																		(byte) 11,
																		0);
																this.var_4882
																		.sub_20ad(
																				var_4582,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																Class_f_StringManager.mainCanvas
																		.sub_220e(this.var_4882);
															}
														}
													} else {
														Object localObject5;
														if (this.var_4f92 == 2) {
															if (Class_f_StringManager.mainCanvas
																	.sub_26d7(128)) {
																if ((this.someUnitTypeId = (byte) (this.someUnitTypeId + 1)) >= 12) {
																	this.someUnitTypeId = 0;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(64)) {
																if ((this.someUnitTypeId = (byte) (this.someUnitTypeId - 1)) < 0) {
																	this.someUnitTypeId = 11;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(16)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) == null) {
																	Class_a_Unit
																			.sub_11aa(
																					this.someUnitTypeId,
																					this.someUnitTeamId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																} else {
																	((Class_a_Unit) localObject5)
																			.killUnitMaybe();
																}
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(512)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) != null) {
																	if (this.someUnitTypeId != ((Class_a_Unit) localObject5).unitType) {
																		this.someUnitTypeId = ((Class_a_Unit) localObject5).unitType;
																	} else {
																		if ((this.someUnitTypeId = (byte) (this.someUnitTypeId + 1)) >= 12) {
																			this.someUnitTypeId = 0;
																		}
																		((Class_a_Unit) localObject5)
																				.killUnitMaybe();
																		Class_a_Unit
																				.sub_11aa(
																						this.someUnitTypeId,
																						this.someUnitTeamId,
																						this.cursorPosX,
																						this.cursorPosY,
																						true);
																	}
																} else {
																	Class_a_Unit
																			.sub_11aa(
																					this.someUnitTypeId,
																					this.someUnitTeamId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(256)) {
																if ((localObject5 = getUnitAtPos(
																		this.cursorPosX,
																		this.cursorPosY,
																		(byte) 0)) != null) {
																	if (this.someUnitTypeId != ((Class_a_Unit) localObject5).unitType) {
																		this.someUnitTypeId = ((Class_a_Unit) localObject5).unitType;
																	} else {
																		if ((this.someUnitTypeId = (byte) (this.someUnitTypeId - 1)) < 0) {
																			this.someUnitTypeId = 11;
																		}
																		((Class_a_Unit) localObject5)
																				.killUnitMaybe();
																		Class_a_Unit
																				.sub_11aa(
																						this.someUnitTypeId,
																						this.someUnitTeamId,
																						this.cursorPosX,
																						this.cursorPosY,
																						true);
																	}
																} else {
																	Class_a_Unit
																			.sub_11aa(
																					this.someUnitTypeId,
																					this.someUnitTeamId,
																					this.cursorPosX,
																					this.cursorPosY,
																					true);
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(8192)) {
																if ((this.someUnitTeamId = (byte) (this.someUnitTeamId + 1)) >= this.teamsCountMaybe) {
																	this.someUnitTeamId = 0;
																	this.var_4f92 = 1;
																}
																this.var_4f8a = null;
																this.var_4c42 = true;
																this.var_4c4a = true;
															} else if (Class_f_StringManager.mainCanvas
																	.sub_26d7(var_4602)) {
																this.var_4882 = new Class_e_FightAnimation(
																		(byte) 11,
																		0);
																this.var_4882
																		.sub_20ad(
																				var_4582,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																Class_f_StringManager.mainCanvas
																		.sub_220e(this.var_4882);
															}
														} else if (Class_f_StringManager.mainCanvas
																.sub_26d7(512)) {
															i4 = 0;
															localObject5 = this.maybeTeamKings[this.someUnitTeamId];
															if ((this.unitAtCursorPos != null)
																	&& (this.unitAtCursorPos.unitType == 9)) {
															}
															Class_a_Unit localObject51 = this.teamsUnits[this.someUnitTeamId][((this.unitAtCursorPos.unitId + 1) % this.teamsUnitsCount[this.someUnitTeamId])];
															for (;;) {
																i4++;
																if ((i4 >= this.teamsUnitsCount[this.someUnitTeamId])
																		|| (((Class_a_Unit) localObject51).var_e83 != 3)) {
																	if ((localObject51 == null)
																			|| (((Class_a_Unit) localObject51).var_e83 == 3)) {
																		break;
																	}
																	moveCursorToPos(
																			((Class_a_Unit) localObject51).posX,
																			((Class_a_Unit) localObject51).posY);
																	sub_efb8(
																			((Class_a_Unit) localObject51).pixelX + 12,
																			((Class_a_Unit) localObject51).pixelY + 12);
																	break;
																}
																localObject51 = this.teamsUnits[this.someUnitTeamId][((localObject51.unitId + 1) % this.teamsUnitsCount[this.someUnitTeamId])];
															}
														} else if (Class_f_StringManager.mainCanvas
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
																	this.var_4c8a = 12;
																}
															}
															Class_f_StringManager.mainCanvas
																	.releaseGameAction(32);
														} else if ((Class_f_StringManager.mainCanvas
																.sub_26d7(16))
																|| (Class_f_StringManager.mainCanvas
																		.sub_26d7(var_4602))) {
															this.someActiveUnit = getUnitAtPos(
																	this.cursorPosX,
																	this.cursorPosY,
																	(byte) 0);
															if ((this.someActiveUnit != null)
																	&& (this.someActiveUnit.var_e83 == 0)
																	&& (this.someActiveUnit.teamId == this.someUnitTeamId)) {
																byte[] lo5;
																if ((lo5 = sub_bddb(
																				this.someActiveUnit,
																				(byte) 1)).length > 1) {
																	sub_6e49((byte[]) lo5);
																	Class_c_MainCanvas
																			.playMusicLooped(
																					11,
																					1);
																} else {
																	this.var_49ea = false;
																	sub_6c83(this.someActiveUnit);
																}
															} else if ((getMapTileType(
																	this.cursorPosX,
																	this.cursorPosY) == 9)
																	&& (sub_11cae(
																			this.cursorPosX,
																			this.cursorPosY,
																			this.someUnitTeamId))) {
																byte[] lo5;
																lo5 = new byte[] { 0 };
																sub_6e49((byte[]) lo5);
																Class_c_MainCanvas
																		.playMusicLooped(
																				11,
																				1);
															} else {
																this.someActiveUnit = null;
																this.var_4882 = new Class_e_FightAnimation(
																		(byte) 11,
																		0);
																this.var_4882
																		.sub_20ad(
																				this.var_4612,
																				2,
																				2,
																				-1,
																				this.someCanHeight,
																				20,
																				0);
																this.var_4882
																		.sub_1350(this);
																Class_f_StringManager.mainCanvas
																		.sub_220e(this.var_4882);
																Class_c_MainCanvas
																		.playMusicLooped(
																				11,
																				1);
															}
															Class_f_StringManager.mainCanvas
																	.sub_26ad();
														}
													}
												}
											} else {
												if ((!Class_f_StringManager.mainCanvas
														.sub_26d7(4))
														&& (!Class_f_StringManager.mainCanvas
																.sub_26d7(1))) {
													if ((Class_f_StringManager.mainCanvas
															.sub_26d7(8))
															|| (Class_f_StringManager.mainCanvas
																	.sub_26d7(2))) {
														this.var_47b2 += 1;
														if (this.var_47b2 >= this.var_47ba.length) {
															this.var_47b2 = 0;
														}
														Class_f_StringManager.mainCanvas
																.releaseGameAction(8);
														Class_f_StringManager.mainCanvas
																.releaseGameAction(2);
														this.var_495a = true;
													}
												} else {
													this.var_47b2 -= 1;
													if (this.var_47b2 < 0) {
														this.var_47b2 = (this.var_47ba.length - 1);
													}
													Class_f_StringManager.mainCanvas
															.releaseGameAction(4);
													Class_f_StringManager.mainCanvas
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
												if (Class_f_StringManager.mainCanvas
														.sub_26d7(16)) {
													if (this.var_478a == 6) {
														sub_6994(
																this.someActiveUnit,
																this.var_47ba[this.var_47b2]);
													} else if (this.var_478a == 7) {
														sub_ed9f(
																this.var_47ba[this.var_47b2],
																this.someUnitTeamId);
														this.someActiveUnit
																.sub_26fe();
														this.var_478a = 0;
													}
													this.var_4882 = null;
													this.var_47e2 = false;
													this.var_47ea = false;
													this.var_48d2 = false;
													this.var_48da = false;
												}
												this.var_495a = false;
											}
										}
									}
								}
							}
						} else if ((this.var_4e52 != 1)
								&& ((this.var_478a != 14) || (this.var_4e52 == 2))) {
							if (this.var_4e52 == 0) {
								this.var_4912 = true;
								this.var_491a = 0;
							} else if (this.var_4e52 == 2) {
								if (this.var_478a == 14) {
									this.someCanHeight = this.canvasHeight;
									this.someCanHeightShift = this.canvasHeightShift;
									sub_6d11(this.var_464a, this.canvasHeightShift,
											this.canvasHeight, null);
									return;
								}
								if (this.var_47a2 <= 7) {
									sub_aca4(this.var_47a2);
									sub_143ce();
									this.var_478a = 0;
								}
							}
						} else {
							this.var_47a2 += 1;
							if (this.var_47a2 > this.someSetting) {
								Object localObject4;
								if (var_45ca[this.someSetting] >= 0) {
									localObject4 = someOneOf12LangStrings[var_45ca[this.someSetting]];
									localObject4 = sub_14359(null,
											Class_f_StringManager.getStrByIdAndReplaceUWith(82,
													(String) localObject4),
											this.canvasHeight, 3000);
									Class_f_StringManager.mainCanvas
											.sub_220e((Class_f_StringManager) localObject4);
								}
								this.someSetting = this.var_47a2;
								try {
									localObject4 = new byte[] { (byte) this.someSetting };
									Class_c_MainCanvas.addSomeRecords("settings", 1,
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
						((Class_a_Unit) this.mapUnitsMaybe.elementAt(j)).sub_238a();
						j++;
					}
					if (this.var_479a - this.var_4962 >= 300L) {
						this.var_496a = ((this.var_496a + 1) % this.var_497a.length);
						this.tiles0Frames[this.var_4972] = this.var_497a[this.var_496a];
						this.var_4962 = this.var_479a;
					}
					Class_g_Game localClass_g_1956 = this;
					if (this.var_4c6a == null) {
						localClass_g_1956.sub_f012(
								localClass_g_1956.cursorSprite.pixelX + 12,
								localClass_g_1956.cursorSprite.pixelY + 12);
					} else {
						localClass_g_1956.sub_f012(
								localClass_g_1956.var_4c6a.pixelX + 12,
								localClass_g_1956.var_4c6a.pixelY + 12);
					}
					if ((this.var_48d2)
							&& (Class_f_StringManager.mainCanvas.sub_272b(var_460a))) {
						if (this.var_478a == 1) {
							this.var_478a = 0;
							sub_bcb2(this.var_47da, 0);
							this.var_4802 = null;
							this.cursorSprite.setFrameSequence(var_4662[0]);
							moveCursorToPos(this.someActiveUnit.posX,
									this.someActiveUnit.posY);
							this.someActiveUnit = null;
						} else if ((this.var_478a == 6) || (this.var_478a == 7)) {
							this.var_478a = this.var_4792;
							sub_bcb2(this.var_47da, 0);
							this.cursorSprite.setFrameSequence(var_4662[0]);
							moveCursorToPos(this.someActiveUnit.posX,
									this.someActiveUnit.posY);
							Class_f_StringManager.mainCanvas.sub_220e(this.var_4882);
						}
						this.var_47e2 = false;
						this.var_47ea = false;
						Class_f_StringManager.mainCanvas.releaseGameAction(var_460a);
						this.var_48d2 = false;
						this.var_48da = false;
					}
					for (int k = this.var_488a.size() - 1; k >= 0; k--) {
						Class_g_Sprite localClass_g_25174;
						(localClass_g_25174 = (Class_g_Sprite) this.var_488a
								.elementAt(k)).sub_21f3();
						if (!localClass_g_25174.var_c78) {
							this.var_488a.removeElement(localClass_g_25174);
						}
					}
					int k = 0;
					int i6 = this.spritesVector.size();
					while (k < i6) {
						this.var_488a.addElement(this.spritesVector.elementAt(k));
						k++;
					}
					this.spritesVector.removeAllElements();
				}
			}
		}
	}

	private void sub_ecee(Class_a_Unit paramClass_a_0260) {
		int i = paramClass_a_0260.pixelY + 24; // n
		showSpriteOnMap(this.smokeSprite, paramClass_a_0260.pixelX, i - this.smokeSprite.spriteFrameHeight,
				0, -2, 1, 100);
		for (int j = 0; j < 5; j++) {
			showSpriteOnMap(this.bSmokeSprite, paramClass_a_0260.pixelX, i
					- this.bSmokeSprite.spriteFrameHeight, j + -2,
					Class_c_MainCanvas.getRandomWithin(-4, -1), 1,
					50 + 50 * Class_c_MainCanvas.getRandomMax(4));
		}
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX, paramClass_a_0260.pixelX, 0, 0,
				1, 100);
	}

	private void sub_ed9f(Class_a_Unit paramClass_a_0260, byte paramByte) {
		this.var_48b2 = paramClass_a_0260;
		this.var_48ba = paramByte;
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX - 8,
				paramClass_a_0260.pixelY - 8, 1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX + 8,
				paramClass_a_0260.pixelY - 8, -1, 1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX - 8,
				paramClass_a_0260.pixelY + 8, 1, -1, 3, 50);
		showSpriteOnMap(this.sparkSprite, paramClass_a_0260.pixelX + 8,
				paramClass_a_0260.pixelY + 8, -1, -1, 3, 50);
		this.var_48c2 = this.var_479a;
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
			if ((paramInt = this.someCanWidthShift - paramInt) > 0) {
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
			if ((paramInt = this.someCanHeightShift - paramInt) > 0) {
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
				} else if (i < -this.var_4c72) {
					i = -this.var_4c72;
				}
			} else if (i < this.var_4c7a) {
				i = this.var_4c7a;
			} else if (i > this.var_4c72) {
				i = this.var_4c72;
			}
			this.mapLeftX += i;
			this.var_4c82 = false;
		}
		if (paramInt2 != 0) {
			i = paramInt2 / 2;
			if (paramInt2 < 0) {
				if (i > -this.var_4c7a) {
					i = -this.var_4c7a;
				} else if (i < -this.var_4c72) {
					i = -this.var_4c72;
				}
			} else if (i < this.var_4c7a) {
				i = this.var_4c7a;
			} else if (i > this.var_4c72) {
				i = this.var_4c72;
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

	private void sub_f1cc(Graphics graphics) {
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
		if (k >= this.mapWidthMaybe) {
			k = this.mapWidthMaybe - 1;
		}
		if (m >= this.mapHeightMaybe) {
			m = this.mapHeightMaybe - 1;
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
				int i5 = this.var_4782[it2][it1];
				if ((!this.var_47e2) || (this.var_47da[it2][it1] == 0)
						|| (this.var_4c8a > 0)) {
					this.tiles0Frames[i5].drawOnGraphics(graphics, i3, i1);
				}
				if ((this.var_47e2) && (this.var_47da[it2][it1] > 0)) {
					if (this.var_4c8a != 0) {
						graphics.clipRect(i3 + this.var_4c8a, i1
								+ this.var_4c8a, 24 - (this.var_4c8a << 1),
								24 - (this.var_4c8a << 1));
					}
					graphics.drawImage(this.var_4c5a[i2][i5], i3, i1, 0);
					if (this.var_4c8a != 0) {
						graphics.setClip(0, 0, this.someCanWidth,
								this.someCanHeight);
					}
				}
				if (((i5 = it1 + 1) < this.mapHeightMaybe)
						&& (this.tilesDefs[this.var_4782[it2][i5]] == 9)) {
					this.tiles0Frames[28].drawOnGraphics(graphics, i3, i1);
				}
				i3 += 24;
			}
			i1 += 24;
		}
	}

	private void showSomeMessageOnBlackScreen(Graphics graphics) {
		graphics.setFont(Class_c_MainCanvas.theFont);
		graphics.setColor(0);
		graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
		graphics.setColor(16777215); // white
		String message = Class_f_StringManager.getLangString(58);
		Class_c_MainCanvas.showString(graphics, message,
				this.canvasWidth / 2,
				(this.canvasHeight - Class_c_MainCanvas.theFont.getHeight()) / 2, 17);
	}

	public static final int sub_f52a(int paramInt1, int paramInt2,
			int paramInt3, int paramInt4) {
		if (paramInt3 == 0) {
			return paramInt1;
		}
		if (paramInt3 == paramInt4) {
			return paramInt2;
		}
		int i = paramInt1 & 0xFF0000;
		int j = paramInt1 & 0xFF00;
		paramInt1 &= 0xFF;
		i = (((paramInt2 & 0xFF0000) - i) * paramInt3 / paramInt4 & 0xFF0000)
				+ i;
		j = (((paramInt2 & 0xFF00) - j) * paramInt3 / paramInt4 & 0xFF00) + j;
		paramInt1 = ((paramInt2 & 0xFF) - paramInt1) * paramInt3 / paramInt4
				+ paramInt1;
		return i | j | paramInt1;
	}

	private void initIntro(int introImageId, int paramInt2, int paramInt3) {
		this.var_4cd2 = paramInt2;
		this.var_4cda = paramInt3;
		this.var_4cca = this.var_48e2;
		try {
			this.introImage = new Class_d_ImageWrap("intro" + introImageId,
					this.someCanWidth, -1);
		} catch (Exception localException) {
			//
		}
		this.var_4c92 = Class_c_MainCanvas.someFontHeight;
		if (this.introImage != null) {
			this.introImageHeight = this.introImage.imageHeight;
			this.var_491a = 0;
			this.var_4ca2 = ((this.canvasHeight - this.introImage.imageHeight) / this.var_4c92);
		} else {
			this.introImageHeight = 0;
			this.var_491a = 16;
			this.var_4ca2 = (this.canvasHeight / this.var_4c92);
		}
		this.introTextWrapped = Class_f_StringManager.wrapStringText(
				Class_f_StringManager.getLangString(introImageId + 215), this.canvasWidth,
				Class_c_MainCanvas.someFont);
		this.var_4c9a = (this.canvasHeight - this.var_4c92);
		this.var_4caa = 0;
		this.var_4cc2 = false;
		Class_f_StringManager.mainCanvas.sub_26ad();
		this.var_48e2 = 3;
	}

	private void sub_f6d8(String text) {
		this.var_4cca = this.var_48e2;
		this.introTextWrapped = Class_f_StringManager.wrapStringText(text, this.canvasWidth,
				Class_c_MainCanvas.someFont);
		this.var_491a = 16;
		this.var_4cc2 = false;
		this.var_4cd2 = 3;
		this.var_4cda = 3;
		this.introImageHeight = 0;
		this.var_4c92 = Class_c_MainCanvas.someFontHeight;
		this.var_4ca2 = (this.canvasHeight / this.var_4c92);
		this.var_4c9a = (this.canvasHeight - this.var_4c92);
		this.var_4caa = 0;
		Class_f_StringManager.mainCanvas.sub_26ad();
		this.var_48e2 = 3;
	}

	private void sub_f755(Graphics graphics) {
		graphics.setFont(Class_c_MainCanvas.someFont);
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
					Class_c_MainCanvas.sub_1edc(graphics, i << 24, 0, 0,
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
				m = sub_f52a(0, m, i, 16);
			}
			graphics.setColor(m);
			Class_c_MainCanvas.showString(graphics, this.introTextWrapped[k],
					this.canvasWidthShift, j + 3, 17);
			j += this.var_4c92;
		}
		if (!this.var_4cc2) {
			drawButtonIcon(graphics, var_4602, 2, this.canvasHeight);
		}
	}

	private void sub_fb32(Graphics graphics) {
		/* intro images waving? */
		
		if (this.var_490a == 0) {
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.msLogoImage,
					(this.canvasWidth - this.msLogoImage.imageWidth) / 2,
					(this.canvasHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.var_490a == 1) {
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.msLogoImage,
					(this.canvasWidth - this.msLogoImage.imageWidth) / 2,
					(this.canvasHeight - this.msLogoImage.imageHeight) / 2, 4);
			return;
		}
		if (this.var_490a == 3) {
			graphics.setColor(0);
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			sub_11f87(graphics, this.var_491a, 40, 0, this.var_48fa, 0, 0,
					1);
			graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			return;
		}
		if (this.var_490a == 4) {
			if (this.var_491a >= 16) {
				if (this.var_48f2 != null) {
					this.var_48fa.drawOnGraphics(graphics, 0, 0);
					if (this.var_4a42 != -1) {
						int i = (this.var_48fa.imageHeight + this.var_4902.imageHeight - 1)
								/ this.var_4902.imageHeight;
						for (int j = 0; j < i; j++) {
							this.var_4902.drawOnGraphics(graphics, 4
									+ this.var_4a42 - j * 38, 6
									+ this.var_4902.imageHeight * j);
						}
					}
					this.var_48f2.drawOnGraphics(graphics, 0, 0);
				} else {
					graphics.setColor(0);
					graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
					this.var_48fa.drawOnGraphics(graphics, 0, 0);
				}
				if ((this.var_498a) && (this.var_48f2 != null)) {
					graphics.setColor(16777215);
					graphics.setFont(Class_c_MainCanvas.theFont);
					sub_fdce(graphics, Class_f_StringManager.getLangString(59),
							this.canvasWidthShift, this.canvasHeight - this.buttonsSprite.spriteFrameHeight
									- 1, 33, 16777215, 0);
				}
			} else {
				if (this.var_48f2 != null) {
					this.var_48f2.drawOnGraphics(graphics, 0, 0);
				} else {
					graphics.setColor(0);
					graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
				}
				Class_c_MainCanvas.sub_1edc(graphics,
						255 * (16 - this.var_491a) / 16 << 24, 0, 0,
						this.canvasWidth, this.canvasHeight);
				this.var_48fa.drawOnGraphics(graphics, 0, 0);
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

	@Override
	public final void startLoading(Graphics graphics) {
		if (this.var_48e2 == 4) { //loading screen
			graphics.setColor(16777215); // white
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
			graphics.setFont(Class_c_MainCanvas.theFont);
			graphics.setColor(0);
			// "LOADING..."
			graphics.drawString(Class_f_StringManager.getLangString(58),
					this.canvasWidth / 2, this.canvasHeight / 2 - 1, 33);
			int i = this.canvasHeight / 18;
			if (i < 12) {
				i = 12;
			}
			int k1 = this.canvasHeight / 2 + 1;
			graphics.setColor(13553358); //#CECECE gray
			Class_e_FightAnimation.drawRoundedRect(graphics, 1, k1, this.canvasWidth - 2, i);
			graphics.setColor(2370117); //#242A45 darkblue
			Class_e_FightAnimation.drawRoundedRect(graphics, 2, k1 + 2, this.loadingProgress
					* (this.canvasWidth - 6) / 100, i - 4);
			return;
		}
		int k;
		int i3;
		if (this.var_48e2 == 2) {
			Graphics localGraphics = graphics;
			Class_g_Game paramGraphics = this;
			k = 0;
			int n = 0;
			if (paramGraphics.var_4e82) {
				k = Class_c_MainCanvas.getRandomNumber() % 10;
				n = Class_c_MainCanvas.getRandomNumber() % 3;
			}
			localGraphics.translate(0, paramGraphics.var_4cfa);
			localGraphics.setClip(0, 0, paramGraphics.someCanWidth,
					paramGraphics.var_4eba);
			paramGraphics.var_4e5a.sub_35c1(localGraphics, k, n);
			paramGraphics.var_4e62.sub_35c1(localGraphics, k
					+ paramGraphics.someCanWidthShift, n);
			localGraphics.setColor(0);
			localGraphics.fillRect(paramGraphics.someCanWidthShift - 1 + k, 0, 2,
					paramGraphics.var_4eba);
			paramGraphics.var_4e5a.sub_374d(localGraphics);
			paramGraphics.var_4e62.sub_374d(localGraphics);
			Vector localVector = new Vector(paramGraphics.spritesList.size());
			Class_g_Sprite localClass_g_25171;
			for (n = 0; n < paramGraphics.spritesList.size(); n++) {
				localClass_g_25171 = (Class_g_Sprite) paramGraphics.spritesList
						.elementAt(n);
				i3 = 0;
				if (localClass_g_25171.var_c88) {
					localVector.addElement(localClass_g_25171);
				} else {
					for (i3 = 0; i3 < localVector.size(); i3++) {
						Class_g_Sprite localClass_g_25172;
						if (((localClass_g_25172 = (Class_g_Sprite) localVector
								.elementAt(i3)).var_c88)
								|| (localClass_g_25171.pixelY
										+ localClass_g_25171.spriteFrameHeight < localClass_g_25172.pixelY
										+ localClass_g_25172.spriteFrameHeight)) {
							localVector.insertElementAt(localClass_g_25171, i3);
							break;
						}
					}
				}
				if (i3 == localVector.size()) {
					localVector.addElement(localClass_g_25171);
				}
			}
			paramGraphics.spritesList = localVector;
			for (n = 0; n < paramGraphics.spritesList.size(); n++) {
				if ((localClass_g_25171 = (Class_g_Sprite) paramGraphics.spritesList
						.elementAt(n)).var_c98 == 0) {
					localGraphics.setClip(0, 0, paramGraphics.someCanWidthShift,
							paramGraphics.var_4eba);
				} else if (localClass_g_25171.var_c98 == 1) {
					localGraphics.setClip(paramGraphics.someCanWidthShift, 0,
							paramGraphics.someCanWidthShift, paramGraphics.var_4eba);
				} else {
					localGraphics.setClip(0, 0, paramGraphics.someCanWidth,
							paramGraphics.var_4eba);
				}
				localClass_g_25171.sub_1d20(localGraphics, 0,
						localClass_g_25171.var_c38);
			}
			localGraphics.translate(0, -paramGraphics.var_4cfa);
			localGraphics.setClip(0, 0, paramGraphics.canvasWidth,
					paramGraphics.canvasHeight);
			if (paramGraphics.var_4eb2) {
				paramGraphics.var_4eb2 = false;
				n = paramGraphics.canvasHeight - var_4592;
				localGraphics.setColor(14672074);
				localGraphics.fillRect(0, n, paramGraphics.canvasWidth, var_4592);
				Class_e_FightAnimation.sub_5066(localGraphics, 0, n,
						paramGraphics.canvasWidth, var_4592, 0);
				localGraphics.setClip(0, 0, paramGraphics.canvasWidth,
						paramGraphics.canvasHeight);
				paramGraphics.var_4e5a.sub_36f9(localGraphics);
				localGraphics.translate(paramGraphics.someCanWidthShift, 0);
				paramGraphics.var_4e62.sub_36f9(localGraphics);
				localGraphics.translate(-paramGraphics.someCanWidthShift, 0);
			}
			if (paramGraphics.var_4eaa) {
				paramGraphics.var_4eaa = false;
				paramGraphics.drawUnitAttackBar(localGraphics,
						paramGraphics.var_4e5a.var_b47,
						paramGraphics.var_4e62.var_b47, 0);
			}
			if (paramGraphics.var_4ea2) {
				sub_12052(localGraphics, 0, paramGraphics.var_491a, 16, 1, 0,
						0, paramGraphics.canvasWidth, paramGraphics.canvasHeight);
			}
			return;
		}
		if (this.var_48e2 == 3) {
			sub_f755(graphics);
			return;
		}
		if (this.var_4982) {
			showSomeMessageOnBlackScreen(graphics);
			return;
		}
		if (this.var_4912) {
			if (this.var_491a >= 16) {
				if ((this.var_478a != 11) && (this.var_478a != 10)) {
					showSomeMessageOnBlackScreen(graphics);
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
		if (this.var_48e2 == 0) {
			sub_fb32(graphics);
		} else if (this.var_478a == 14) {
			graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
			graphics.setColor(0);
			graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
		} else if ((this.var_478a == 10) && (this.var_4e52 > 0)) {
			showSomeMessageOnBlackScreen(graphics);
		} else {
			Object localObject1;
			if ((this.var_478a == 11) && (!this.var_4912)) {
				localObject1 = Class_f_StringManager.getLangString(57);
				graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				graphics.setFont(Class_c_MainCanvas.theFont);
				graphics.setColor(0);
				graphics.fillRect(0, 0, this.canvasWidth, this.canvasHeight);
				if (this.var_45fa == 0) {
					graphics.setColor(16777215);
					if (this.gameOverImage != null) {
						this.gameOverImage.drawOnGraphics(graphics, this.canvasWidthShift,
								this.canvasHeightShift, 3);
						Class_c_MainCanvas.showString(graphics,
								(String) localObject1, this.canvasWidthShift,
								this.canvasHeight - 2, 33);
					} else {
						m = this.canvasHeightShift - Class_c_MainCanvas.theFont.getHeight()
								/ 2;
						Class_c_MainCanvas.showString(graphics,
								(String) localObject1, this.canvasWidthShift, m, 17);
					}
				}
			} else {
				graphics.setClip(0, 0, this.someCanWidth, this.someCanHeight);
				if ((this.var_46d2 < this.someCanWidth)
						|| (this.var_46da < this.someCanHeight)) {
					graphics.setColor(0);
					graphics.fillRect(0, 0, this.someCanWidth, this.someCanHeight);
				}
				if (this.var_4e82) {
					y = Class_c_MainCanvas.getRandomNumber() % 10;
					m = Class_c_MainCanvas.getRandomNumber() % 4;
					graphics.translate(y, m);
					sub_f1cc(graphics);
					graphics.translate(-y, -m);
				} else {
					sub_f1cc(graphics);
				}
				y = 0;
				m = this.mapUnitsMaybe.size();
				while (y < m) {
					Class_a_Unit unit = (Class_a_Unit) this.mapUnitsMaybe
							.elementAt(y);
					if (unit.var_e83 == 3) {
						this.tombStoneImage.drawOnGraphics(
										graphics,
										this.mapLeftX + unit.pixelX, //x
										this.mapTopY + unit.pixelY  //y
										);
					} else if (unit != this.someActiveUnit) {
						unit.sub_28d7(graphics,
								this.mapLeftX, this.mapTopY);
					}
					y++;
				}
				y = 0;
				m = this.mapUnitsMaybe.size();
				while (y < m) {
					((Class_a_Unit) this.mapUnitsMaybe.elementAt(y)).drawHealthString(
							graphics, this.mapLeftX, this.mapTopY);
					y++;
				}
				int i2;
				Object localObject2;
				if (this.var_4802 != null) {
					graphics.setColor(14745682); //#E10052 red
					m = 12 + this.var_4d02 / 4;
					int i4 = 24 - m;
					int index = 0;
					int count = this.var_4802.size();
					while (index < count) {
						short[] lObj2 = (short[]) this.var_4802
								.elementAt(index);
						int left = lObj2[0] * 24 + this.mapLeftX;
						int top = lObj2[1] * 24 + this.mapTopY;
						int leftShift = left + 12;
						int topShift = top + 12;
						short[] arrayOfShort;
						if (index != 0) {
							if ((arrayOfShort = (short[]) this.var_4802
									.elementAt(index - 1))[0] == lObj2[0] + 1) {
								graphics.fillRect(left + i4, topShift
										- this.var_4d0a, m, this.var_4d02);
							} else if (arrayOfShort[0] == lObj2[0] - 1) {
								graphics.fillRect(left, topShift - this.var_4d0a,
										m, this.var_4d02);
							} else if (arrayOfShort[1] == lObj2[1] + 1) {
								graphics.fillRect(leftShift - this.var_4d0a, top
										+ i4, this.var_4d02, m);
							} else if (arrayOfShort[1] == lObj2[1] - 1) {
								graphics.fillRect(leftShift - this.var_4d0a, top,
										this.var_4d02, m);
							}
						}
						if (index == count - 1) {
							graphics.setClip(0, 0, this.someCanWidth,
									this.someCanHeight);
							this.currentCursorSpriteMaybe.drawCurrentFrame(graphics, leftShift, topShift, 3);
						} else if ((arrayOfShort = (short[]) this.var_4802
								.elementAt(index + 1))[0] == lObj2[0] + 1) {
							graphics.fillRect(left + i4, topShift - this.var_4d0a,
									m, this.var_4d02);
						} else if (arrayOfShort[0] == lObj2[0] - 1) {
							graphics.fillRect(left, topShift - this.var_4d0a, m,
									this.var_4d02);
						} else if (arrayOfShort[1] == lObj2[1] + 1) {
							graphics.fillRect(leftShift - this.var_4d0a, top + i4,
									this.var_4d02, m);
						} else if (arrayOfShort[1] == lObj2[1] - 1) {
							graphics.fillRect(leftShift - this.var_4d0a, top,
									this.var_4d02, m);
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
				if (this.var_47f2) {
					this.cursorSprite.drawCurrentFrame(graphics, this.mapLeftX + 12,
							this.mapTopY + 12, 3);
				}
				y = 0;
				m = this.var_488a.size();
				while (y < m) {
					Class_g_Sprite lob;
					(lob = (Class_g_Sprite) this.var_488a.elementAt(y))
							.sub_1d20(
									graphics,
									this.mapLeftX,
									this.mapTopY
											+ ((Class_g_Sprite) lob).var_c38);
					y++;
				}
				graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				y = this.canvasHeight - var_4592;
				if (this.var_4a52 > 0) {
					Class_e_FightAnimation.sub_5066(graphics, 0, y, this.someCanWidth,
							var_4592, 14);
					graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				}
				m = var_4592 - 24 >> 1;
				int i4 = 24 + (m << 1);
				int x = this.canvasWidth - i4;
				y += this.var_4a52;
				if (this.var_4c42) {
					this.var_4c42 = false;
					i2 = this.canvasHeight - var_4592 / 2 + this.var_4a52;
					int i5 = 10;
					if (this.someCanWidth <= 120) {
						i5 = 4;
					}
					if (this.var_4f92 == 1) {
						Class_e_FightAnimation.sub_5092(graphics, 0, y, x + 1,
								var_4592, 0, 2370117, var_468a[0],
								this.var_4a52, var_4592);
						Class_c_MainCanvas.sub_2007(graphics, this.cursorTileId + 1
								+ "/" + this.tiles0Frames.length, i5 + 1, i2, 1, 6);
					} else if (this.var_4f92 == 2) {
						Class_e_FightAnimation.sub_5092(graphics, 0, y, x + 1,
								var_4592, 0, 2370117,
								var_468a[this.var_4832[this.someUnitTeamId]],
								this.var_4a52, var_4592);
						Class_c_MainCanvas.sub_2007(graphics, this.someUnitTypeId + 1
								+ "/" + 12, i5 + 1, i2, 1, 6);
					} else {
						Class_e_FightAnimation.sub_5092(graphics, 0, y, x + 1,
								var_4592, 0, 2370117,
								var_468a[this.var_4832[this.someUnitTeamId]],
								this.var_4a52, var_4592);
						if (this.var_45fa == 1) {
							i3 = x / 2;
							this.hudIcons2Sprite.drawFrame(graphics, 0, i3, i2, 6);
							Class_c_MainCanvas.sub_2007(graphics,
									countSomeTeamUnitsOfType(-1, -1, this.someUnitTeamId)
											- countSomeTeamUnitsOfType(10, -1, this.someUnitTeamId)
											+ "/" + this.var_45f2, i3
											+ this.hudIcons2Sprite.spriteFrameWidth + 1, i2, 1,
									6);
						}
						this.hudIcons2Sprite.drawFrame(graphics, 1, i5, i2, 6);
						i3 = i5 + this.hudIcons2Sprite.spriteFrameWidth + 1;
						if ((!Class_c_MainCanvas.propDeveloperModeOn)
								&& (this.var_487a[this.someUnitTeamId] != 1)) {
							Class_c_MainCanvas.sub_2007(graphics, "- - -", i3,
									i2, 1, 6);
						} else {
							Class_c_MainCanvas.sub_2007(graphics, ""
									+ this.var_486a[this.someUnitTeamId], i3, i2, 1,
									6);
						}
					}
					graphics.setClip(0, 0, this.canvasWidth, this.canvasHeight);
				}
				if (this.var_4c4a) {
					this.var_4c4a = false;
					if (m > 0) {
						drawRectBar(graphics, x, y, i4, var_4592);
					}
					int px = x + m;
					int py = y + m;
					if ((this.var_4f92 == 0) || (this.var_4f92 == 2)) {
						this.cursorTileId = this.var_4782[this.cursorPosX][this.cursorPosY];
					}
					this.tiles0Frames[this.cursorTileId]
							.drawOnGraphics(graphics, px, py);
					if (this.var_4f92 == 2) {
						if (this.var_4f8a == null) {
							this.var_4f8a = Class_a_Unit.sub_11aa(
									this.someUnitTypeId, this.someUnitTeamId, 0, 0, false);
						}
						this.var_4f8a.sub_28d7(graphics, px, py);
					}
					if (this.var_4f92 == 0) {
						String str = "."
								+ tilesExtraDefence[this.tilesDefs[this.cursorTileId]];
						Class_c_MainCanvas.sub_2007(graphics, str, px + 24,
								py + 24, 0, 40);
					}
					if (m == 0) {
						graphics.setColor(0);
						graphics.drawRect(px, py, 24, 24);
					}
				}
				if ((this.var_478a == 6)
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
			if (this.var_48d2) {
				drawButtonIcon(graphics, var_460a, 1, this.someCanHeight); // return/cancel
			}
			if (this.var_48da) {
				drawButtonIcon(graphics, var_4602, 0, this.someCanHeight); // ok/apply
			}
			if ((this.var_48e2 == 1)
					&& ((this.var_487a[this.someUnitTeamId] == 0) || (this.var_478a == 0))
					&& (this.var_478a != 11)) {
				drawButtonIcon(graphics, var_4602, 3, this.someCanHeight); //openmenu
			}
		}
		if ((this.var_4aca) || (this.var_4ad2)) {
			y = this.var_4ac2;
			if (this.var_4ad2) {
				y = 16 - this.var_4ac2;
			}
			m = y * 255 / 16;
			Class_c_MainCanvas.sub_1edc(graphics, m << 24, 0, 0, this.canvasWidth,
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
			Class_a_Unit unit1, Class_a_Unit unit2,
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
				Class_a_Unit localClass_a_0260;
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
								.getSomeAttackValueMaybe1((Class_a_Unit) localObject);
						localObject = localClass_a_0260.attackMin + bonusAttack + "-"
								+ (localClass_a_0260.attackMax + bonusAttack);
					}
				} else if (m == 1) {
					int unitResist = localClass_a_0260.getSomeUnitResistance((Class_a_Unit) localObject);
					localObject = "" + (localClass_a_0260.defence + unitResist);
				} else {
					localObject = "" + localClass_a_0260.level;
				}
				Class_c_MainCanvas.drawAString(gr, (String) localObject, i5,
						n + 1, 0);
				if (i6 > 0) {
					this.arrowIconsSprite.drawFrame(
							gr,
							1,
							i5
									+ 1
									+ Class_c_MainCanvas.sub_1e71((byte) 0,
											(String) localObject), n + i4 / 2,
							6);
				} else if (i6 < 0) {
					this.arrowIconsSprite.drawFrame(
							gr,
							2,
							i5
									+ 1
									+ Class_c_MainCanvas.sub_1e71((byte) 0,
											(String) localObject), n + i4 / 2,
							6);
				}
				int i3 = j + i1 - 2;
				if ((m == 0) && ((localClass_a_0260.var_e8b & 0x2) != 0)) {
					this.statusSprite
							.drawFrame(gr, 1, i3, n + i4 / 2, 10);
					i3 -= this.statusSprite.spriteFrameWidth;
				}
				if (((m == 0) || (m == 1))
						&& ((localClass_a_0260.var_e8b & 0x1) != 0)) {
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

	public final Class_a_Unit getUnitAtPos(int inX, int inY,
			byte paramByte) {
		int i = 0;
		int mapUnitsCount = this.mapUnitsMaybe.size();
		while (i < mapUnitsCount) {
			Class_a_Unit unit = (Class_a_Unit) this.mapUnitsMaybe.elementAt(i);
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
		return this.tilesDefs[this.var_4782[paramInt1][paramInt2]];
	}

	private void sub_11699() {
		Class_c_MainCanvas.stopCurrentMusicPlayer();
		this.var_4812 = 0;
		this.var_4a52 = 0;
		this.var_478a = 8;
		this.var_481a = this.var_479a;
	}

	private void sub_116cf() {
		for (;;) {
			if (this.var_4f92 != 0) {
				return;
			}
			this.var_4872[this.someUnitTeamId][0] = ((byte) this.cursorPosX);
			this.var_4872[this.someUnitTeamId][1] = ((byte) this.cursorPosY);
			this.var_484a = ((short) (this.var_484a + 1));
			this.someUnitTeamId = ((byte) ((this.someUnitTeamId + 1) % this.teamsCountMaybe));
			if (this.var_487a[this.someUnitTeamId] == 2) {
				sub_116cf();
				return;
			}
			for (int i = this.mapUnitsMaybe.size() - 1; i >= 0; i--) {
				Class_a_Unit localClass_a_0260;
				if ((localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
						.elementAt(i)).var_e83 == 3) {
					if ((localClass_a_0260.unitType != 9)
							&& ((localClass_a_0260.var_ecb = (byte) (localClass_a_0260.var_ecb - 1)) <= 0)) {
						localClass_a_0260.killUnitMaybe();
					}
				} else {
					localClass_a_0260.var_e83 = 0;
					if (((localClass_a_0260.var_e8b & 0x1) != 0)
							&& (localClass_a_0260.var_ed3 == this.someUnitTeamId)) {
						localClass_a_0260.sub_15e0((byte) 1);
					}
					if (localClass_a_0260.teamId == this.someUnitTeamId) {
						localClass_a_0260.sub_15e0((byte) 2);
					}
					localClass_a_0260.var_f03 = 0;
				}
			}
			this.var_4d12 = 0;
			for (int i = 0; i < this.var_4782.length; i++) {
				for (int j = 0; j < this.var_4782[i].length; j++) {
					if (sub_11cae(i, j, this.someUnitTeamId)) {
						if (getMapTileType(i, j) == 8) {
							this.var_4d12 += 30;
						} else if (getMapTileType(i, j) == 9) {
							this.var_4d12 += 50;
						}
					}
				}
			}
			this.var_486a[this.someUnitTeamId] += this.var_4d12;
			for (int i = 0; i < this.var_49fa.length; i++) {
				this.var_4d82[i] = 0;
			}
			if (this.var_487a[this.someUnitTeamId] == 1) {
				moveCursorToPos(this.var_4872[this.someUnitTeamId][0],
						this.var_4872[this.someUnitTeamId][1]);
			}
			this.var_495a = true;
			this.var_4c42 = true;
			if (this.var_487a[this.someUnitTeamId] == 0) {
				sub_122cc();
			} else {
				Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
			}
			if ((countSomeTeamUnitsOfType(-1, 0, this.someUnitTeamId) > 0)
					|| (sub_11cef(this.someUnitTeamId) != 0)) {
				break;
			}
		}
	}

	private boolean canOccupyVillageMaybe(Class_a_Unit unit) {
		return (unit.hasProperty((short) 8)) //occupy village
				&& (getMapTileType(unit.posX,
						unit.posY) == 8) // village
				&& (!sub_11b75(this.var_4782[unit.posX][unit.posY]));
	}

	private boolean canOccupyVillageOrTownMaybe(Class_a_Unit unit) {
		if ((unit.hasProperty((short) 8)) //occupy village
				&& (getMapTileType(unit.posX,
						unit.posY) == 8) // village
				&& (sub_11b75(this.var_4782[unit.posX][unit.posY]))
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

	private void sub_11aac(byte paramByte, int inX, int inY) {
		this.var_4782[inX][inY] = paramByte;
	}

	private void sub_11ad0(int inX, int inY, int paramInt3) {
		if (sub_11b75(this.var_4782[inX][inY])) {
			sub_11aac(
					(byte) (37 + (paramInt3 << 1) + (this.var_4782[inX][inY] - 37) % 2),
					inX, inY);
		}
	}

	private static boolean sub_11b28(byte paramByte) {
		return ((paramByte >= 37) && (paramByte < 47)) || (paramByte == 27);
	}

	public static boolean sub_11b75(byte inByte) {
		return (inByte >= 37) && (inByte < 47);
	}

	private int sub_11bae(int paramInt1, int paramInt2) {
		return sub_11bd2(paramInt1, paramInt2, this.var_4782);
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
			Class_a_Unit unit = (Class_a_Unit) this.mapUnitsMaybe
					.elementAt(index);
			if (((inUnitType == -1) || (unit.unitType == inUnitType))
					&& (((paramInt2 == -1) && (unit.var_e83 != 3)) || ((paramInt2 == unit.var_e83) && ((inTeamId == -1) || (unit.teamId == inTeamId))))) {
				count++;
			}
			index++;
		}
		return count;
	}

	private Class_a_Unit[] getSomeUnitsOfTypeOfTeam(int inUnitType, int paramInt2,
			byte inTeamId) {
		Vector list = new Vector();
		int i = 0;
		int unitsCount = this.mapUnitsMaybe.size();
		while (i < unitsCount) {
			Class_a_Unit unit = (Class_a_Unit) this.mapUnitsMaybe
					.elementAt(i);
			if (((inUnitType == -1) || (unit.unitType == inUnitType))
					&& (((paramInt2 == -1) && (unit.var_e83 != 3)) || ((paramInt2 == unit.var_e83) && ((inTeamId == -1) || (unit.teamId == inTeamId))))) {
				list.addElement(unit);
			}
			i++;
		}
		Class_a_Unit[] units = new Class_a_Unit[list
				.size()];
		list.copyInto(units);
		return units;
	}

	private static void sub_11f87(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, Class_d_ImageWrap image,
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
			int m = paramInt2 * Class_f_StringManager.sub_f0f(paramInt1) >> 10;
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
			Class_c_MainCanvas.setGraphicsColor(paramGraphics, i << 24 | paramInt1);
			for (i = 0; i <= 0; i++) {
				paramGraphics.fillRect(paramInt7 + 0, 0, paramInt6, paramInt8);
			}
		}
	}

	private boolean sub_12199(byte paramByte, int paramInt1, int paramInt2) {
		if ((this.var_45f2 > countSomeTeamUnitsOfType(-1, -1, this.someUnitTeamId)
				- countSomeTeamUnitsOfType(10, -1, this.someUnitTeamId))
				&& (paramByte <= this.var_49ca)
				&& (Class_a_Unit.unitsCost[paramByte] <= this.var_486a[this.someUnitTeamId])
				&& (Class_a_Unit.unitsCost[paramByte] > 0)) {
			sub_bcb2(this.var_47da, 0);
			return Class_a_Unit.sub_212e(this.var_47da, paramInt1, paramInt2,
					Class_a_Unit.unitsMoveRange[paramByte], -1, paramByte,
					this.someUnitTeamId, true);
		}
		return false;
	}

	private boolean sub_12226(Class_a_Unit paramClass_a_0260, int paramInt1,
			int paramInt2) {
		if ((this.var_45f2 > countSomeTeamUnitsOfType(-1, -1, this.someUnitTeamId)
				- countSomeTeamUnitsOfType(10, -1, this.someUnitTeamId))
				&& ((paramClass_a_0260.unitType <= this.var_49ca) || (paramClass_a_0260.unitType == 9))
				&& (paramClass_a_0260.cost <= this.var_486a[this.someUnitTeamId])) {
			sub_bcb2(this.var_47da, 0);
			return Class_a_Unit.sub_212e(this.var_47da, paramInt1, paramInt2,
					Class_a_Unit.unitsMoveRange[paramClass_a_0260.unitType], -1,
					paramClass_a_0260.unitType, this.someUnitTeamId, true);
		}
		return false;
	}

	private void sub_122cc() {
		Class_a_Unit[] units = getSomeUnitsOfTypeOfTeam(-1, 0, this.someUnitTeamId);
		this.var_4dc2 = new Vector(units.length);
		for (int i = 0; i < units.length; i++) {
			int j = 0;
			while (j < i) {
				Class_a_Unit unit = (Class_a_Unit) this.var_4dc2
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
		this.var_4d6a = new Class_a_Unit[this.var_49fa.length];
		this.var_4d72 = new byte[this.var_49fa.length];
		Class_a_Unit.var_de3 = Class_a_Unit.var_dd3;
		this.var_4d52 = 0;
		this.var_4d22 = 0;
	}

	private void sub_1240c() {
		if (Class_f_StringManager.mainCanvas.sub_26d7(var_4602)) {
			sub_6d11(this.var_4652, this.someCanHeightShift, this.someCanHeight, this);
			Class_f_StringManager.mainCanvas.sub_26ad();
			return;
		}
		if (this.var_4d22 == 4) {
			if ((this.var_4d3a == null) && (this.var_4d42 == null)) {
				int i;
				if (canOccupyVillageOrTownMaybe(this.someActiveUnit)) {
					i = sub_14272(this.someActiveUnit.posX, this.someActiveUnit.posY);
					if ((this.var_4dba != -1) && (this.var_4dba != i)) {
						this.var_4d6a[this.var_4dba] = this.var_4d6a[i];
						this.var_4d6a[i] = this.someActiveUnit;
					}
					sub_11ad0(this.someActiveUnit.posX, this.someActiveUnit.posY,
							this.var_4832[this.someActiveUnit.teamId]);
					Class_f_StringManager.mainCanvas.sub_220e(sub_14359(null,
							Class_f_StringManager.getLangString(73), this.someCanHeight, 1000));
					Class_c_MainCanvas.playMusicLooped(9, 1); // game complete?
					this.var_478a = 9;
					this.var_481a = this.var_479a;
				} else if (canOccupyVillageMaybe(this.someActiveUnit)) {
					i = sub_14272(this.someActiveUnit.posX, this.someActiveUnit.posY);
					if ((this.var_4dba != -1) && (this.var_4dba != i)) {
						this.var_4d6a[this.var_4dba] = this.var_4d6a[i];
						this.var_4d6a[i] = this.someActiveUnit;
					}
					sub_11aac((byte) 37, this.someActiveUnit.posX,
							this.someActiveUnit.posY);
					Class_f_StringManager.mainCanvas.sub_220e(sub_14359(null,
							Class_f_StringManager.getLangString(74), this.someCanHeight, 1000));
					Class_c_MainCanvas.playMusicLooped(9, 1);
					this.var_478a = 0;
					this.var_481a = this.var_479a;
				} else {
					this.var_478a = 0;
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
				this.var_4d5a = this.var_479a;
				if (this.var_4d3a != null) {
					this.cursorSprite.setFrameSequence(var_4662[1]);
					moveCursorToPos(this.var_4d3a.posX, this.var_4d3a.posY);
				} else if (this.var_4d42 != null) {
					moveCursorToPos(this.var_4d42.posX, this.var_4d42.posY);
				}
			}
			this.var_47f2 = true;
			return;
		}
		if (this.var_4d22 == 5) {
			if (this.var_479a - this.var_4d5a >= 500L) {
				if (this.var_4d3a != null) {
					sub_6994(this.someActiveUnit, this.var_4d3a);
				} else if (this.var_4d42 != null) {
					sub_ed9f(this.var_4d42, this.someUnitTeamId);
					this.var_4d42 = null;
					this.var_4d22 = 7;
					this.someActiveUnit.sub_26fe();
				}
				this.var_47e2 = false;
				this.var_47ea = false;
			}
		} else if (this.var_4d22 == 7) {
			if (this.var_48b2 == null) {
				this.var_4d22 = 0;
				this.var_478a = 0;
			}
		} else if (this.var_4d22 == 6) {
			if (this.var_479a - this.var_4d5a >= 1000L) {
				this.var_4d3a = null;
				this.var_4d22 = 0;
				this.var_478a = 0;
			}
		} else {
			if (this.var_4d22 == 2) {
				return;
			}
			if (this.var_4d22 == 3) {
				if (this.var_4d52 == 0) {
					if (sub_ee3c(this.someActiveUnit.pixelX + 12, this.someActiveUnit.pixelY + 12)) // m
					{
						if ((this.var_45fa == 0) && (this.var_47a2 == 7)
								&& (this.someActiveUnit == this.maybeTeamKings[1])) {
							this.var_4c6a = null;
							Class_a_Unit[] loo = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);
							if (loo.length > 0) {
								sub_6963(loo[Class_c_MainCanvas
										.getRandomMax(loo.length)]);
							}
							this.var_4d22 = 4;
							return;
						}
						this.var_4d52 = 1;
						this.var_4d5a = this.var_479a;
					}
				} else if (this.var_4d52 == 1) {
					if (this.var_479a - this.var_4d5a >= 100L) {
						this.var_47e2 = true;
						this.var_47ea = false;
						this.var_4d52 = 2;
						this.var_478a = 1;
						this.var_4d5a = this.var_479a;
					}
				} else if (this.var_4d52 == 2) {
					if (this.var_479a - this.var_4d5a >= 200L) {
						this.cursorPosX = this.var_4d2a;
						this.cursorPosY = this.var_4d32;
						this.cursorSprite.setPixelPosition(this.var_4d2a * 24,
								this.var_4d32 * 24);
						this.var_4802 = this.someActiveUnit.sub_1ef5(
								this.someActiveUnit.posX, this.someActiveUnit.posY,
								this.cursorPosX, this.cursorPosY);
						this.var_4d52 = 3;
						this.var_4d5a = this.var_479a;
					}
				} else if ((this.var_4d52 == 3)
						&& (this.var_479a - this.var_4d5a >= 200L)) {
					this.var_4802 = null;
					this.someActiveUnit.sub_1c9f(this.var_4d2a, this.var_4d32, true);
					this.var_4d22 = 2;
					this.var_4d52 = 0;
					this.var_478a = 2;
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
				for (int i1 = 0; i1 < this.var_49fa.length; i1++) {
					i4 = this.var_49fa[i1][0];
					i2 = this.var_49fa[i1][1];
					if ((getMapTileType(i4, i2) == 9)
							&& (sub_11cae(i4, i2, this.someUnitTeamId))) {
						if (j == 0) {
							m = i4;
							n = i2;
						}
						j++;
						i5 = 0;
						int i8;
						for (int i6 = this.mapUnitsMaybe.size() - 1; i6 >= 0; i6--) {
							Class_a_Unit localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
									.elementAt(i6);
							if ((this.var_483a[localClass_a_0260.teamId] != this.var_483a[this.someUnitTeamId])
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
							for (int i6 = 0; i6 < this.var_49fa.length; i6++) {
								i7 = this.var_49fa[i6][0];
								i8 = this.var_49fa[i6][1];
								if ((getMapTileType(i7, i8) == 9)
										&& (!sub_11cae(i7, i8, this.someUnitTeamId))
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
					for (i1 = 0; i1 < this.teamsUnitsCount[this.someUnitTeamId]; i1++) {
						if ((this.teamsUnits[this.someUnitTeamId][i1] != null)
								&& (this.teamsUnits[this.someUnitTeamId][i1].var_e83 == 3)
								&& (sub_12226(
										this.teamsUnits[this.someUnitTeamId][i1], m, n))) {
							localObject = sub_abab(
									this.teamsUnits[this.someUnitTeamId][i1], m, n);
						}
					}
					if (localObject == null) {
						if ((countSomeTeamUnitsOfType(0, -1, this.someUnitTeamId) < 2)
								&& (sub_12199((byte) 0, m, n))) {
							localObject = sub_ac11((byte) 0, m, n);
						} else if ((countSomeTeamUnitsOfType(1, -1, this.someUnitTeamId) < 2)
								&& (sub_12199((byte) 1, m, n))) {
							localObject = sub_ac11((byte) 1, m, n);
						} else {
							i1 = 0;
							i4 = 0;
							int i3;
							for ( byte i21 = 0; i21 < this.teamsCountMaybe; i3 = (byte) (i21 + 1)) {
								if (this.var_483a[i21] == this.var_483a[this.someUnitTeamId]) {
									i1 += countSomeTeamUnitsOfType(-1, -1, i21);
								} else {
									i4 += countSomeTeamUnitsOfType(-1, -1, i21);
								}
							}
							if ((this.var_486a[this.someUnitTeamId] >= 1000)
									|| (countSomeTeamUnitsOfType(-1, -1, this.someUnitTeamId) < 8)
									|| (i1 < i4)) {
								i5 = 0;
								byte[] arrayOfByte = new byte[12];
								byte b;
								for (byte i71 = 1; i71 < 12; b = (byte) (i71 + 1)) {
									if (((countSomeTeamUnitsOfType(i71, -1, this.someUnitTeamId) <= 0) || (Class_a_Unit.unitsCost[i71] >= 600))
											&& (sub_12199(i71, m, n))) {
										arrayOfByte[i5] = i71;
										i5++;
									}
								}
								if (i5 > 0) {
									b = arrayOfByte[(Math.abs(Class_c_MainCanvas
											.getRandomNumber()) % i5)];
									localObject = sub_ac11(b, m, n);
								}
							}
						}
					}
				}
				if (localObject != null) {
					sub_12e7e((Class_a_Unit) localObject);
					return;
				}
				this.var_4d62 = null;
				this.var_4dc2 = null;
				sub_11699();
				return;
			}
			if ((this.var_45fa == 0) && (this.var_47a2 == 7)
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
				localObject = (Class_a_Unit) this.var_4dc2.elementAt(0);
			}
			sub_12e7e((Class_a_Unit) localObject);
			if (this.var_4d4a == null) {
				this.var_4dc2.removeElement(localObject);
			}
		}
	}

	private void sub_12e7e(Class_a_Unit paramClass_a_0260) {
		this.someActiveUnit = paramClass_a_0260;
		this.var_47f2 = true;
		sub_bcb2(this.var_47da, 0);
		this.someActiveUnit.sub_20f8(this.var_47da);
		this.var_47e2 = false;
		this.var_4d62 = getSomeUnitsOfTypeOfTeam(0, -1, this.someUnitTeamId);
		int i = 0;
		int j = this.maybeTeamKings.length + this.var_4d62.length
				+ this.var_49fa.length;
		this.var_4d7a = new int[j][5];
		this.var_4d8a = 0;
		j = 10000;
		this.var_4da2 = -1;
		this.var_4daa = -1;
		this.var_4db2 = -1;
		this.var_4dba = -1;
		for (int k = 0; k < this.var_4d62.length + this.maybeTeamKings.length; k++) {
			Class_a_Unit localClass_a_02601 = null;
			if (k >= this.var_4d62.length) {
				if ((localClass_a_02601 = this.maybeTeamKings[(k - this.var_4d62.length)]) != null) {
					if (localClass_a_02601.var_e83 == 3) {
						localClass_a_02601 = null;
					} else if ((this.var_483a[localClass_a_02601.teamId] != this.var_483a[this.someUnitTeamId])
							&& (this.maybeTeamKings[this.someUnitTeamId] == null)) {
						this.var_4d7a[i][2] += (localClass_a_02601.sub_1713(
								localClass_a_02601.posX,
								localClass_a_02601.posY, null) << 1);
					} else if ((this.var_484a >= 15)
							&& (this.var_483a[localClass_a_02601.teamId] != this.var_483a[this.someUnitTeamId])
							&& (countSomeTeamUnitsOfType(-1, -1, localClass_a_02601.teamId) < 4)
							&& (countSomeTeamUnitsOfType(-1, -1, this.someUnitTeamId) >= 8)) {
						this.var_4d7a[i][2] += (localClass_a_02601.sub_1713(
								localClass_a_02601.posX,
								localClass_a_02601.posY, null) << 1);
					} else if (localClass_a_02601.teamId != this.someUnitTeamId) {
						localClass_a_02601 = null;
					}
				}
			} else if (this.maybeTeamKings[this.someUnitTeamId] != null) {
				localClass_a_02601 = this.var_4d62[k];
			}
			if (localClass_a_02601 != null) {
				this.var_4d7a[i][0] = localClass_a_02601.posX;
				this.var_4d7a[i][1] = localClass_a_02601.posY;
				if (localClass_a_02601.teamId == this.someUnitTeamId) {
					Class_a_Unit[] arrayOfClass_a_02601 = localClass_a_02601
							.getUnitsInAttackRange(localClass_a_02601.posX,
									localClass_a_02601.posY, 1, 5, (byte) 0);
					for (int m = 0; m < arrayOfClass_a_02601.length; m++) {
						if (arrayOfClass_a_02601[m].var_e83 != 4) {
							this.var_4d7a[i][2] += arrayOfClass_a_02601[m]
									.sub_1713(arrayOfClass_a_02601[m].posX,
											arrayOfClass_a_02601[m].posY,
											localClass_a_02601);
						}
					}
				}
				if (this.var_4d7a[i][2] > 0) {
					this.var_4d7a[i][4] += localClass_a_02601.sub_1713(
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
		for (int i2 = 0; i2 < this.var_49fa.length; i2++) {
			int i6 = this.var_49fa[i2][0];
			int i7 = this.var_49fa[i2][1];
			i8 = getMapTileType(i6, i7);
			boolean bool = sub_11cae(i6, i7, paramClass_a_0260.teamId);
			this.var_4d7a[i][2] = -6666;
			if ((bool) || (this.var_4d6a[i2] != null)) {
				Class_a_Unit[] arrayOfClass_a_02602 = paramClass_a_0260
						.getUnitsInAttackRange(i6, i7, 1, 5, (byte) 0);
				this.var_4d7a[i][0] = i6;
				this.var_4d7a[i][1] = i7;
				this.var_4d7a[i][2] = 0;
				for (int i3 = 0; i3 < arrayOfClass_a_02602.length; i3++) {
					if ((arrayOfClass_a_02602[i3].var_e83 != 4)
							&& (((this.var_4d6a[i2] != null) && (!bool))
									|| ((i8 == 8) && (arrayOfClass_a_02602[i3]
											.hasProperty((short) 8))) || ((i8 == 9) && (arrayOfClass_a_02602[i3]
									.hasProperty((short) 16))))) {
						this.var_4d7a[i][2] += arrayOfClass_a_02602[i3]
								.sub_1713(arrayOfClass_a_02602[i3].posX,
										arrayOfClass_a_02602[i3].posY, null);
					}
				}
				if (this.var_4d7a[i][2] == 0) {
					if ((this.var_4d6a[i2] != null) && (!bool)) {
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
				Class_a_Unit localClass_a_02602;
				int i4;
				if ((((localClass_a_02602 = getUnitAtPos(i6, i7, (byte) 0)) == null) || (localClass_a_02602.teamId == paramClass_a_0260.teamId))
						&& ((i4 = Math.abs(i6 - paramClass_a_0260.posX)
								+ Math.abs(i7 - paramClass_a_0260.posY)) < n)) {
					m = i2;
					n = i4;
				}
			} else if (((this.var_4d6a[i2] == null) || (this.var_4d6a[i2] == paramClass_a_0260))
					&& (((i8 == 8) && (paramClass_a_0260.hasProperty((short) 8))) || ((i8 == 9) && (paramClass_a_0260
							.hasProperty((short) 16))))) {
				int i10;
				if ((i10 = Math.abs(i6 - paramClass_a_0260.posX)
						+ Math.abs(i7 - paramClass_a_0260.posY)) < k) {
					i1 = i2;
					k = i10;
				}
				Class_a_Unit localClass_a_02605 = getUnitAtPos(i6, i7, (byte) 0);
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
			this.var_4d6a[m] = paramClass_a_0260;
			this.var_4da2 = this.var_49fa[m][0];
			this.var_4daa = this.var_49fa[m][1];
			sub_bcb2(this.var_4d92, 0);
			Class_a_Unit.sub_212e(this.var_4d92, this.var_4da2, this.var_4daa,
					10, -1, paramClass_a_0260.unitType, this.someUnitTeamId, false);
		} else if ((this.maybeTeamKings[this.someUnitTeamId] != null)
				&& (i1 != -1)
				&& ((paramClass_a_0260.hasProperty((short) 8)) || (paramClass_a_0260
						.hasProperty((short) 16)))) {
			this.var_4dba = i1;
			this.var_4d6a[i1] = paramClass_a_0260;
			this.var_4da2 = this.var_49fa[i1][0];
			this.var_4daa = this.var_49fa[i1][1];
			sub_bcb2(this.var_4d92, 0);
			Class_a_Unit.sub_212e(this.var_4d92, this.var_4da2, this.var_4daa,
					10, -1, paramClass_a_0260.unitType, this.someUnitTeamId, false);
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
				int i7 = paramClass_a_0260.sub_1713(paramClass_a_0260.posX,
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
				Class_a_Unit.sub_212e(this.var_4d92, this.var_4da2,
						this.var_4daa, 10, -1, paramClass_a_0260.unitType,
						this.someUnitTeamId, false);
			}
		}
		int i2 = -10000;
		int i6 = 0;
		int i7 = this.var_47da.length;
		while (i6 < i7) {
			i8 = 0;
			int i9 = this.var_47da[i6].length;
			while (i8 < i9) {
				Class_a_Unit localClass_a_02603;
				if ((this.var_47da[i6][i8] > 0)
						&& (((localClass_a_02603 = getUnitAtPos(i6, i8, (byte) 0)) == null)
								|| (localClass_a_02603 == paramClass_a_0260) || ((this.var_4d4a == null)
								&& (localClass_a_02603.teamId == paramClass_a_0260.teamId) && (localClass_a_02603.var_e83 == 0)))) {
					int i5;
					if ((!paramClass_a_0260.hasProperty((short) 512))
							|| (localClass_a_02603 == paramClass_a_0260)) {
						Class_a_Unit[] arrayOfClass_a_02603 = paramClass_a_0260
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
		Class_a_Unit localClass_a_02604;
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

	private int sub_13d9e(Class_a_Unit paramClass_a_02601, int paramInt1,
			int paramInt2, Class_a_Unit paramClass_a_02602,
			Class_a_Unit paramClass_a_02603) {
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
						&& ((getMapTileType(paramInt1, paramInt2) == 8) || (this.var_4782[paramInt1][paramInt2] == 27))) {
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
			Class_a_Unit[] arrayOfClass_a_0260 = paramClass_a_02601.getUnitsInAttackRange(
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
				if ((j != 0) && (k != -1) && (this.var_4d6a[k] == null)) {
					i += paramClass_a_02601.sub_1713(paramInt1, paramInt2,
							paramClass_a_02602) / 2;
				}
			} else {
				if (!paramClass_a_02602.canAttackPosition(paramInt1, paramInt2)) {
					i += (paramClass_a_02601.sub_1713(paramInt1, paramInt2,
							paramClass_a_02602) << 1);
				} else {
					i += paramClass_a_02601.sub_1713(paramInt1, paramInt2,
							paramClass_a_02602)
							* 3
							/ 2
							- paramClass_a_02602.sub_1713(paramInt1, paramInt2,
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
		if ((j != -1) && ((paramClass_a_02602 = this.var_4d6a[j]) != null)
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
		for (int i = 0; i < this.var_49fa.length; i++) {
			if ((this.var_49fa[i][0] == paramInt1)
					&& (this.var_49fa[i][1] == paramInt2)) {
				return i;
			}
		}
		return -1;
	}

	private void sub_142e5(int paramInt) {
		this.var_4dd2 = paramInt;
		this.var_4e32 = true;
	}

	private Class_e_FightAnimation showUnitDialog(String message, byte paramByte1,
			byte paramByte2) {
		Class_e_FightAnimation cll = new Class_e_FightAnimation((byte) 7, 12);
		int i = Class_c_MainCanvas.var_1767 * 3;
		cll.sub_19f5(message, this.canvasWidth, i, paramByte1);
		cll.sub_1930(0, this.canvasHeight - i, 0);
		Class_f_StringManager.mainCanvas.sub_220e(cll);
		return cll;
	}

	private Class_e_FightAnimation sub_14359(String paramString1, String paramString2,
			int paramInt1, int paramInt2) {
		return sub_1437e(paramString1, paramString2, paramInt1, -1, paramInt2);
	}

	private Class_e_FightAnimation sub_1437e(String paramString1, String paramString2,
			int paramInt1, int paramInt2, int paramInt3) {
		Class_e_FightAnimation strMan = new Class_e_FightAnimation((byte) 10, 12);
		strMan.sub_1ca8(paramString1, paramString2, this.canvasWidth, paramInt2);
		strMan.sub_1930(this.canvasWidthShift, paramInt1 / 2, 3);
		strMan.stringManager = this;
		strMan.var_10f2 = paramInt3;
		return strMan;
	}

	private void sub_143ce() {
		this.var_4e02 = null;
		if (this.var_45fa == 0) {
			this.var_4a52 = var_4592;
			this.var_4a5a = true;
			this.var_4a4a = false;
			this.var_4dda = sub_14359(null, this.var_4b52, this.canvasHeight, 2000);
			this.var_4dda.sub_1930(this.canvasWidthShift, this.canvasHeightShift, 3);
			this.var_4ada = true;
			this.var_4ad2 = true;
			this.var_4ac2 = 0;
		}
		if (this.var_47a2 == 0) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			Class_a_Unit.var_de3 = 4;
			this.var_4c72 = 2;
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			initIntro(2, 3, 3);
			Class_c_MainCanvas.sub_2bf1(1, 1);
			this.var_4ada = false;
			this.var_47f2 = false;
			this.var_4e12 = 0;
			return;
		}
		if (this.var_47a2 == 1) {
			this.var_49ca = 1;
			this.var_486a[0] = 300;
			this.var_486a[1] = 50;
			Class_a_Unit.var_de3 = 4;
			this.var_4c72 = 2;
			this.maybeTeamKings[0].setKingName(2);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			getUnitAtPos(7, 12, (byte) 0).sub_1c9f(7, 10, false);
			getUnitAtPos(8, 11, (byte) 0).sub_1c9f(8, 9, false);
			getUnitAtPos(9, 12, (byte) 0).sub_1c9f(9, 10, false);
			sub_186a6(7, 3);
			Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			return;
		}
		if (this.var_47a2 == 2) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			Class_a_Unit.var_de3 = 4;
			this.var_486a[0] = 0;
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			this.var_4de2 = getUnitAtPos(8, 17, (byte) 0);
			this.var_4dea = getUnitAtPos(8, 18, (byte) 0);
			this.var_4df2 = getUnitAtPos(8, 19, (byte) 0);
			this.var_4de2.sub_1c9f(8, 15, false);
			this.var_4dea.sub_1c9f(8, 15, false);
			this.var_4df2.sub_1c9f(8, 15, false);
			this.maybeTeamKings[0].sub_1c9f(8, 14, false);
			this.var_47f2 = false;
			Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			this.var_4e12 = 0;
			return;
		}
		if (this.var_47a2 == 3) {
			this.var_49ca = 7;
			Class_a_Unit.var_de3 = 4;
			this.var_486a[0] = 400;
			this.var_486a[1] = 400;
			this.var_4de2 = Class_a_Unit.createUnit((byte) 0, (byte) 0, -1, 5);
			this.var_4dea = Class_a_Unit.createUnit((byte) 2, (byte) 0, -2, 5);
			this.var_4df2 = Class_a_Unit.createUnit((byte) 3, (byte) 0, -3, 5);
			this.var_4de2.sub_1c9f(3, 4, false);
			this.var_4dea.sub_1c9f(4, 4, false);
			this.var_4df2.sub_1c9f(2, 4, false);
			this.maybeTeamKings[0].sub_1c9f(3, 3, false);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(3, 3);
			this.var_4c6a = this.maybeTeamKings[0];
			initIntro(3, 3, 3);
			Class_c_MainCanvas.sub_2bf1(1, 1);
			this.var_4ada = false;
			this.var_47f2 = false;
			this.var_4e12 = 0;
			return;
		}
		Class_a_Unit localClass_a_02601;
		if (this.var_47a2 == 4) {
			this.var_49ca = 0;
			this.var_486a[0] = 0;
			this.var_486a[1] = 0;
			sub_efb8(this.maybeTeamKings[0].pixelX + 12, this.maybeTeamKings[0].pixelY + 12); // m n pos
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			Class_a_Unit.var_de3 = 4;
			(localClass_a_02601 = getUnitAtPos(11, 2, (byte) 0)).sub_1686(11, -3);
			localClass_a_02601.sub_1c9f(11, 2, false);
			(localClass_a_02601 = getUnitAtPos(10, 1, (byte) 0)).sub_1686(10, -5);
			localClass_a_02601.sub_1c9f(10, 1, false);
			(localClass_a_02601 = getUnitAtPos(11, 1, (byte) 0)).sub_1686(11, -5);
			localClass_a_02601.sub_1c9f(11, 1, false);
			(localClass_a_02601 = getUnitAtPos(12, 1, (byte) 0)).sub_1686(12, -5);
			localClass_a_02601.sub_1c9f(12, 1, false);
			(localClass_a_02601 = getUnitAtPos(11, 0, (byte) 0)).sub_1686(11, -7);
			localClass_a_02601.sub_1c9f(11, 0, false);
			(localClass_a_02601 = getUnitAtPos(12, 0, (byte) 0)).sub_1686(12, -7);
			localClass_a_02601.sub_1c9f(12, 0, false);
			Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			this.var_47f2 = false;
			this.var_4e12 = 0;
			return;
		}
		if (this.var_47a2 == 5) {
			this.var_49ca = 7;
			this.var_486a[0] = 600;
			this.var_486a[1] = 600;
			this.maybeTeamKings[0].setKingName(2);
			sub_efe5(5, 0);
			moveCursorToPos(5, 0);
			this.var_4c72 = 4;
			sub_186a6(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			this.var_47f2 = false;
			this.var_4e12 = 0;
			return;
		}
		Class_a_Unit localClass_a_02602;
		if (this.var_47a2 == 6) {
			this.var_49ca = 8;
			Class_a_Unit.var_de3 = 4;
			this.var_486a[0] = 400;
			this.var_486a[1] = 600;
			localClass_a_02601 = Class_a_Unit.createUnit((byte) 0, (byte) 0, 13,
					-1);
			localClass_a_02602 = Class_a_Unit.createUnit((byte) 1, (byte) 0, 13,
					-1);
			Class_a_Unit localClass_a_02603 = Class_a_Unit.createUnit((byte) 3,
					(byte) 0, 13, -1);
			Class_a_Unit localClass_a_02604 = Class_a_Unit.createUnit((byte) 11,
					(byte) 0, 13, -1);
			this.maybeTeamKings[0].var_ee3 = localClass_a_02601;
			localClass_a_02601.var_ee3 = localClass_a_02602;
			localClass_a_02602.var_ee3 = localClass_a_02603;
			localClass_a_02603.var_ee3 = localClass_a_02604;
			this.maybeTeamKings[0].sub_20f8(this.var_47da);
			this.maybeTeamKings[0].sub_1c9f(14, 3, true);
			sub_efe5(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			moveCursorToPos(this.maybeTeamKings[0].posX, this.maybeTeamKings[0].posY);
			this.var_4c6a = this.maybeTeamKings[0];
			Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			this.var_47f2 = false;
			this.var_4e12 = 0;
			return;
		}
		if (this.var_47a2 == 7) {
			this.var_49ca = 8;
			Class_a_Unit.var_de3 = 4;
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
			Class_c_MainCanvas.sub_2bf1(1, 1);
			this.var_4ada = false;
			this.var_47f2 = false;
			this.var_4e12 = 0;
		}
	}

	private void someReadScriptMethod(int scriptId) {
		//@todo WTF
		InputStream scriptStream = Class_c_MainCanvas.getResourceStream("m" + scriptId + ".script");
		if (scriptStream  == null) {
			this.someScriptStrings = null;
			return;
		}
		Vector vecOfVecs = new Vector();
		Vector localVector2 = null;
		String scriptStr = Class_c_MainCanvas.streamToString(scriptStream);
		while (scriptStr != null) {
			int eolnIndex =  scriptStr.indexOf(';');
			if (eolnIndex >= 0) {
				scriptStr = scriptStr.substring(0, eolnIndex);
			}
			String str = scriptStr.trim();
			if (str.length() != 0) {
				String[] lineParams = Class_c_MainCanvas.splitStringByChar((String) str, ' ');
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
					localVector2.addElement(i);  //@todo unused localVector2
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
		String[][] scriptArr2 = this.someScriptStrings[this.var_4e12];
		int i = 0;
		int j = -1;
		Class_a_Unit unit = null;
		while ((i >= 0) && (i < scriptArr2.length)) {
			String[] localObject1;
			if ((localObject1 = scriptArr2[(i++)])[0]
					.equalsIgnoreCase("Jump")) {
				i += Integer.parseInt(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("Alt")) {
				if ((j = Integer.parseInt(localObject1[1])) == 0) {
					j = -1;
				} else {
					j += i;
				}
			} else if (localObject1[0].equalsIgnoreCase("Test")) {
				int k = 0;
				int m = 0;
				String localObject3 = null;
				if (localObject1[1].equalsIgnoreCase("CurrentPlayer")) {
					k = this.someUnitTeamId;
				} else if (localObject1[1].equalsIgnoreCase("CurrentTurn")) {
					k = this.var_484a;
				} else if (localObject1[1].equalsIgnoreCase("GameState")) {
					k = this.var_478a;
				} else if (localObject1[1].equalsIgnoreCase("AlphaWindow")) {
					k = this.var_4c8a;
				} else if (localObject1[1].equalsIgnoreCase("StatusBarOffset")) {
					k = this.var_4a52;
				} else if (localObject1[1].equalsIgnoreCase("UnitFinishedMove")) {
					k = this.var_4e0a != null ? 1 : 0;
				} else if (localObject1[1].equalsIgnoreCase("CountUnits")) {
					k = countSomeTeamUnitsOfType(Integer.parseInt(localObject1[2]),
							Integer.parseInt(localObject1[3]),
							(byte) Integer.parseInt(localObject1[4]));
					m = Integer.parseInt(localObject1[6]);
					localObject3 = localObject1[5];
				}
				if (localObject3 == null) {
					m = Integer.parseInt(localObject1[3]);
					localObject3 = localObject1[2];
				}
				/* WTF */
				boolean boolExpr = false;
				switch(localObject3){
					case("<="): boolExpr = k <= m; break;
					case("<"): boolExpr = k < m; break;
					case(">="): boolExpr = k >= m; break;
					case(">"): boolExpr = k > m; break;
					case("!="): boolExpr = k != m; break;
					case("=="): boolExpr = k == m; break;
				}
				if(boolExpr == false)
				{
					i = j;
				}
				j = -1;
			} else if (localObject1[0].equalsIgnoreCase("Wait")) {
				sub_142e5(Integer.parseInt(localObject1[1]));
			} else if (localObject1[0].equalsIgnoreCase("NextState")) {
				this.var_4e12 += 1;
			} else if (localObject1[0].equalsIgnoreCase("ShowMapName")) {
				Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
			} else if (localObject1[0].equalsIgnoreCase("StartPlay")) {
				sub_1864a();
			} else if (localObject1[0].equalsIgnoreCase("CompleteMission")) {
				sub_186db();
			} else if (localObject1[0].equalsIgnoreCase("SetFadeEnabled")) {
				this.var_4ada = "true".equalsIgnoreCase(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("SetCursorVisible")) {
				this.var_47f2 = "true".equalsIgnoreCase(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("SetGameActive")) {
				this.var_4a4a = "true".equalsIgnoreCase(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("SetFadeValue")) {
				this.var_4ac2 = Integer.parseInt(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("SetMapStepMax")) {
				this.var_4c72 = Integer.parseInt(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("SetUnitSpeed")) {
				if (localObject1[1].equalsIgnoreCase("slow")) {
					Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
				} else if (localObject1[1].equalsIgnoreCase("fast")) {
					Class_a_Unit.var_de3 = Class_a_Unit.var_dd3;
				} else {
					Class_a_Unit.var_de3 = (byte) Integer
							.parseInt(localObject1[1]);
				}
			} else if (localObject1[0].equalsIgnoreCase("ShowDialog")) {
				showUnitDialog(
						Class_f_StringManager.getLangString(Integer.parseInt(localObject1[1])),
						(byte) Integer.parseInt(localObject1[2]),
						(byte) Integer.parseInt(localObject1[3]));
			} else if (localObject1[0].equalsIgnoreCase("ShowHelp")) {
				this.var_49a2 = Integer.parseInt(localObject1[1]);
			} else if (localObject1[0].equalsIgnoreCase("Vibrate")) {
				Class_c_MainCanvas.sub_2af6(Integer.parseInt(localObject1[1]));
			} else {
				Object localObject2;
				if (localObject1[0].equalsIgnoreCase("MoveMapAndCursor")) {
					if (localObject1[1].equalsIgnoreCase("king")) {
						localObject2 = this.maybeTeamKings[Integer
								.parseInt(localObject1[2])];
						sub_186a6(((Class_a_Unit) localObject2).posX,
								((Class_a_Unit) localObject2).posY);
					} else {
						sub_186a6(Integer.parseInt(localObject1[1]),
								Integer.parseInt(localObject1[2]));
					}
				} else if (localObject1[0].equalsIgnoreCase("GetUnitPlotRoute")) {
					getUnitAtPos(Integer.parseInt(localObject1[1]),
							Integer.parseInt(localObject1[2]),
							(byte) Integer.parseInt(localObject1[3])).sub_1c9f(
							Integer.parseInt(localObject1[4]),
							Integer.parseInt(localObject1[5]),
							"true".equalsIgnoreCase(localObject1[6]));
				} else if (localObject1[0]
						.equalsIgnoreCase("CreateUnitPlotRoute")) {
					Class_a_Unit.createUnit(
							(byte) Integer.parseInt(localObject1[1]),
							(byte) Integer.parseInt(localObject1[2]),
							Integer.parseInt(localObject1[3]),
							Integer.parseInt(localObject1[4])).sub_1cc2(
							Integer.parseInt(localObject1[5]),
							Integer.parseInt(localObject1[6]),
							"true".equalsIgnoreCase(localObject1[7]),
							"true".equalsIgnoreCase(localObject1[8]));
				} else if (localObject1[0].equalsIgnoreCase("GetUnit")) {
					unit = getUnitAtPos(
							Integer.parseInt(localObject1[1]),
							Integer.parseInt(localObject1[2]),
							(byte) Integer.parseInt(localObject1[3]));
				} else if (localObject1[0].equalsIgnoreCase("RemoveUnit")) {
					unit.killUnitMaybe();
				} else if (localObject1[0]
						.equalsIgnoreCase("ScheduleUnitAnimationStop")) {
					unit.sub_108f(Integer
							.parseInt(localObject1[1]));
				} else if (localObject1[0]
						.equalsIgnoreCase("CreateSpriteAtUnit")) {
					localObject2 = null;
					if (localObject1[1].equalsIgnoreCase("Smoke")) {
						localObject2 = this.smokeSprite;
					} else if (localObject1[1].equalsIgnoreCase("Spark")) {
						localObject2 = this.sparkSprite;
					} else if (localObject1[1].equalsIgnoreCase("RedSpark")) {
						localObject2 = this.redsparkSprite;
					}
					showSpriteOnMap((Class_g_Sprite) localObject2, unit.pixelX, unit.pixelY, // m, n pos
							Integer.parseInt(localObject1[2]),
							Integer.parseInt(localObject1[3]),
							Integer.parseInt(localObject1[4]),
							Integer.parseInt(localObject1[5]));
				}
			}
		}
	}

	/** AI maybe **/
	private void sub_155a2() {
		if (this.var_4f92 != 0) {
			return;
		}
		if ((this.var_4dd2 <= 0) || (--this.var_4dd2 <= 0)) {
			if (this.var_4e3a) {
				if (this.var_4e12 == 0) {
					this.var_4912 = true;
					this.var_491a = 0;
					this.var_478a = 11;
					this.var_4e12 = 1;
				}
			} else {
				int i;
				Object localObject3;
				Object localObject2;
				if (this.var_45fa == 1) {
					if (this.var_4e12 == 100) {
						Class_c_MainCanvas.sub_2bf1(
								var_4692[this.var_4832[this.someUnitTeamId]], 0);
						this.var_49c2.sub_132e((byte) 0, true);
						this.var_49c2.sub_1350(null);
						Class_f_StringManager.mainCanvas.sub_220e(this.var_49c2);
						this.var_4e12 += 1;
						return;
					}
					if (this.var_4e12 == 101) {
						int j = -1;
						i = -1;
						int n = 1;
						for (int i2 = 0; i2 < this.teamsCountMaybe; i2++) {
							if ((this.var_487a[i2] != 2)
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
							this.var_4a4a = false;
							this.var_47f2 = false;
							localObject3 = Class_f_StringManager.getStrByIdAndReplaceUWith(38, ""
									+ (this.var_483a[i] + 1));
							String str = Class_f_StringManager.getStrByIdAndReplaceUWith(81,
									(String) localObject3) + "\n(";
							for (n = 0; n < this.teamsCountMaybe; n++) {
								if ((this.var_487a[n] != 2)
										&& (this.var_483a[n] == this.var_483a[i])) {
									str = str
											+ " "
											+ Class_f_StringManager
													.getLangString(88 + this.var_4832[n])
											+ " ";
								}
							}
							str = str + ")";
							Class_e_FightAnimation lo2 = sub_1437e(null, str, this.someCanHeight,
									this.someCanHeightShift, -1);
							lo2.sub_1350(this);
							Class_f_StringManager.mainCanvas.sub_220e((Class_f_StringManager) lo2);
							if (this.var_487a[i] == 1) {
								Class_c_MainCanvas.sub_2bf1(6, 1);
							} else {
								Class_c_MainCanvas.sub_2bf1(7, 1);
							}
							sub_142e5(15);
							this.var_4e12 += 1;
							return;
						}
						return;
					}
					if (this.var_4e12 == 102) {
						this.var_4912 = true;
						this.var_491a = 0;
						this.var_478a = 11;
						this.var_4e12 += 1;
					}
				} else if ((this.var_48e2 == 1) && (this.var_45fa == 0)
						&& (this.var_4e12 != -1)) {
					if (this.var_4e42 != -1) {
						if (!sub_ee85(this.var_4e42, this.var_4e4a)) {
							return;
						}
						this.var_4e42 = -1;
						this.var_4e4a = -1;
					}
					if (this.var_478a != 11) {
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
						if (this.var_47a2 == 0) {
							switch (this.var_4e12) {
							case 0:
								this.var_4e12 += 1;
								break;
							case 1:
								Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 2:
								this.var_4ada = true;
								getUnitAtPos(0, 8, (byte) 0).sub_1c9f(3, 8, false);
								getUnitAtPos(1, 9, (byte) 0).sub_1c9f(4, 9, false);
								getUnitAtPos(0, 10, (byte) 0).sub_1c9f(3, 10,
										false);
								sub_186a6(5, 9);
								break;
							case 3:
								sub_186a6(9, 3);
								this.var_47f2 = true;
								break;
							case 4:
								sub_142e5(10);
								this.var_4c72 = 12;
								Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
								this.var_4e12 += 1;
								break;
							case 5:
								showUnitDialog(Class_f_StringManager.getLangString(221),
										(byte) 2, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 6:
								localObject2 = getUnitAtPos(9, 3, (byte) 0);
								Class_c_MainCanvas.sub_2af6(100);
								((Class_a_Unit) localObject2).sub_108f(400);
								showSpriteOnMap(this.redsparkSprite,
										((Class_a_Unit) localObject2).pixelX,
										((Class_a_Unit) localObject2).pixelY, 0, 0,
										2, 50);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 7:
								showUnitDialog(Class_f_StringManager.getLangString(222),
										(byte) 2, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 8:
								localObject1 = getUnitAtPos(9, 3, (byte) 0);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject1).pixelX,
										((Class_a_Unit) localObject1).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.smokeSprite,
										((Class_a_Unit) localObject1).pixelX,
										((Class_a_Unit) localObject1).pixelY, 0, -3,
										1, 100);
								((Class_a_Unit) localObject1).killUnitMaybe();
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 9:
								this.var_47f2 = false;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 11:
								showUnitDialog(Class_f_StringManager.getLangString(223),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 12:
								showUnitDialog(Class_f_StringManager.getLangString(224),
										(byte) 5, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 13:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 14:
								if (this.var_4a52 == 0) {
									this.var_49a2 = 0;
									this.var_4e12 += 1;
								}
								break;
							case 15:
								if ((this.someUnitTeamId == 0)
										&& (this.var_478a == 1)
										&& (this.var_4c8a == 0)) {
									this.var_49a2 = 1;
									this.var_4e12 += 1;
								}
								break;
							case 16:
								if ((this.someUnitTeamId == 0)
										&& (this.var_4e0a != null)) {
									this.var_49a2 = 2;
									this.var_4e12 += 1;
								}
								break;
							case 17:
								if ((this.someUnitTeamId == 0)
										&& (this.var_4e0a != null)) {
									this.var_49a2 = 3;
									this.var_4e12 += 1;
								}
								break;
							case 18:
								if (countSomeTeamUnitsOfType(-1, 2, (byte) 0) >= 3) {
									this.var_49a2 = 4;
									this.var_4e12 += 1;
								} else if (this.var_484a > 0) {
									this.var_4e12 += 1;
								}
								break;
							case 19:
								if (this.var_484a >= 2) {
									this.var_49a2 = 5;
									this.var_4e12 += 1;
								}
								break;
							case 20:
								this.var_49a2 = 6;
								this.var_4e12 += 1;
								break;
							case 21:
								if ((this.var_478a == 1)
										&& (this.someUnitTeamId == 0)) {
									this.var_49a2 = 7;
									this.var_4e12 += 1;
								}
								break;
							case 22:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.var_4a4a = false;
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 23:
								sub_186a6(1, 1);
								break;
							case 24:
								Class_a_Unit.createUnit((byte) 1, (byte) 1, 1, 1)
										.sub_1cc2(1, 2, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 25:
								sub_186a6(10, 10);
								break;
							case 26:
								Class_a_Unit.createUnit((byte) 0, (byte) 1, 10,
										10).sub_1cc2(10, 9, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 27:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 28:
								showUnitDialog(Class_f_StringManager.getLangString(225),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 29:
								showUnitDialog(Class_f_StringManager.getLangString(226),
										(byte) 0, (byte) 4);
								this.var_4a4a = true;
								this.var_4e12 += 1;
								break;
							case 30:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (this.var_478a == 0)) {
									this.var_4a4a = false;
									this.var_47f2 = false;
									sub_142e5(30);
									this.var_4e12 += 1;
								}
								break;
							case 31:
								this.var_4aca = true;
								this.var_4ac2 = 0;
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 32:
								showUnitDialog(Class_f_StringManager.getLangString(227),
										(byte) 2, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 33:
								showUnitDialog(Class_f_StringManager.getLangString(228),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 34:
								showUnitDialog(Class_f_StringManager.getLangString(229),
										(byte) 2, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 35:
								showUnitDialog(Class_f_StringManager.getLangString(230),
										(byte) 0, (byte) 4);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 36:
								sub_186db();
							}
						} else if (this.var_47a2 == 1) {
							switch (this.var_4e12) {
							case 1:
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 2:
								this.var_4c72 = 4;
								sub_186a6(12, 3);
								break;
							case 3:
								showUnitDialog(Class_f_StringManager.getLangString(231),
										(byte) 1, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 4:
								showUnitDialog(Class_f_StringManager.getLangString(232),
										(byte) 3, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 5:
								showUnitDialog(Class_f_StringManager.getLangString(233),
										(byte) 5, (byte) 4);
								sub_186a6(7, 3);
								break;
							case 6:
								Class_a_Unit.var_de3 = 2;
								this.var_4de2 = Class_a_Unit.createUnit((byte) 0,
										(byte) 1, 7, 3);
								this.var_4dea = Class_a_Unit.createUnit(
										(byte) 11, (byte) 1, 7, 3);
								this.var_4df2 = Class_a_Unit.createUnit((byte) 0,
										(byte) 1, 7, 3);
								this.var_4de2.var_ee3 = this.var_4dea;
								this.var_4dea.var_ee3 = this.var_4df2;
								this.var_4de2.sub_1c9f(6, -2, false);
								sub_142e5(30);
								this.var_4e12 += 1;
								break;
							case 7:
								if ((this.var_4df2.posX == 6)
										&& (this.var_4df2.posY == 1)) {
									Class_a_Unit.var_de3 = 4;
									this.var_4dfa = Class_a_Unit.createUnit(
											(byte) 0, (byte) 0, 7, 3);
									this.var_4dfa.sub_1c9f(6, 2, false);
									this.var_4dea.var_ee3 = null;
									showUnitDialog(Class_f_StringManager.getLangString(234),
											(byte) 2, (byte) 4);
									this.var_4e12 += 1;
								}
								break;
							case 8:
								if (this.var_4dfa.var_e83 != 1) {
									Class_c_MainCanvas.sub_2af6(100);
									this.var_4dfa.sub_108f(400);
									showSpriteOnMap(this.redsparkSprite, this.var_4dfa.pixelX,
											this.var_4dfa.pixelY, 0, 0, 2, 50);
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 9:
								showUnitDialog(Class_f_StringManager.getLangString(235),
										(byte) 2, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 10:
								showSpriteOnMap(this.smokeSprite, this.var_4dfa.pixelX,
										this.var_4dfa.pixelY, 0, -3, 1, 100);
								showSpriteOnMap(this.sparkSprite, this.var_4dfa.pixelX,
										this.var_4dfa.pixelY, 0, 0, 1, 50);
								this.var_4dfa.killUnitMaybe();
								this.var_4dfa = null;
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 11:
								Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
								this.var_4de2.killUnitMaybe();
								this.var_4dea.killUnitMaybe();
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								this.var_4c72 = 12;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 12:
								showUnitDialog(Class_f_StringManager.getLangString(236),
										(byte) 5, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 13:
								showUnitDialog(Class_f_StringManager.getLangString(237),
										(byte) 1, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 14:
								sub_186a6(3, 5);
								break;
							case 15:
								showUnitDialog(Class_f_StringManager.getLangString(238),
										(byte) 5, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 16:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 17:
								this.var_49a2 = 8;
								this.var_4e12 += 1;
								break;
							case 18:
								this.var_49a2 = 9;
								this.var_4e12 += 1;
								break;
							case 19:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 20:
								if ((this.var_478a == 9)
										&& (this.someUnitTeamId == 0)) {
									this.var_49a2 = 10;
									this.var_4e12 += 1;
								}
								break;
							case 21:
								this.var_49a2 = 11;
								this.var_4e12 += 1;
								break;
							case 22:
								if ((this.maybeTeamKings[0].var_e83 == 3)
										|| (this.maybeTeamKings[1].var_e83 == 3)) {
									this.var_49a2 = 12;
									this.var_4e12 += 1;
								}
								break;
							case 23:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.var_4a4a = false;
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 24:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 25:
								showUnitDialog(Class_f_StringManager.getLangString(239),
										(byte) 1, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 26:
								showUnitDialog(Class_f_StringManager.getLangString(240),
										(byte) 5, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 27:
								sub_186db();
							}
						} else if (this.var_47a2 == 2) {
							switch (this.var_4e12) {
							case 0:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2.sub_1c9f(7, 14, false);
									this.var_4e12 += 1;
								}
								break;
							case 1:
								if (this.var_4dea.var_e83 != 1) {
									this.var_4dea.sub_1c9f(7, 15, false);
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 2:
								Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								showUnitDialog(Class_f_StringManager.getLangString(241),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 3:
								showUnitDialog(Class_f_StringManager.getLangString(242),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 4:
								showUnitDialog(Class_f_StringManager.getLangString(243),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 5:
								this.var_49a2 = 14;
								this.var_4e12 += 1;
								break;
							case 6:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 7:
							case 8:
								if ((this.var_4e12 == 7)
										&& (this.someUnitTeamId == 0)
										&& (this.var_4a52 == 0)
										&& (countSomeTeamUnitsOfType(-1, 3, (byte) -1) > 0)) {
									this.var_49a2 = 15;
									this.var_4e12 += 1;
								}
								Class_a_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, 2, (byte) 0);//super. it returns array
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].posX <= 4)
											|| (localObject11[i].posY <= 10)) {
										sub_142e5(10);
										this.var_4a4a = false;
										this.var_47f2 = false;
										this.var_4e12 = 9;
										break;
									}
								}
							case 9:
								sub_186a6(0, 8);
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, -1, 8)
										.sub_1c9f(0, 8, false);
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, -2, 7)
										.sub_1c9f(1, 7, false);
								sub_142e5(20);
								break;
							case 10:
								sub_186a6(8, 6);
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 12, 6)
										.sub_1c9f(8, 6, false);
								sub_142e5(20);
								break;
							case 11:
								sub_186a6(2, 1);
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 1, -2)
										.sub_1c9f(1, 2, false);
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 3, -2)
										.sub_1c9f(3, 2, false);
								Class_a_Unit
										.createUnit((byte) 4, (byte) 1, 2, -1)
										.sub_1c9f(2, 1, false);
								sub_142e5(20);
								break;
							case 12:
								showUnitDialog(Class_f_StringManager.getLangString(244),
										(byte) 5, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 13:
								sub_186a6(4, 8);
								sub_142e5(15);
								break;
							case 14:
								Class_a_Unit localObject111 = Class_a_Unit.createUnit((byte) 2,
										(byte) 1, 3, 8);
								localObject2 = Class_a_Unit.createUnit((byte) 2,
										(byte) 1, 4, 7);
								localObject3 = Class_a_Unit.createUnit((byte) 2,
										(byte) 1, 5, 8);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject111).pixelX,
										((Class_a_Unit) localObject111).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject2).pixelX,
										((Class_a_Unit) localObject2).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject3).pixelX,
										((Class_a_Unit) localObject3).pixelY, 0, 0,
										1, 50);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 15:
								showUnitDialog(Class_f_StringManager.getLangString(245),
										(byte) 5, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 16:
								showUnitDialog(Class_f_StringManager.getLangString(246),
										(byte) -1, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 17:
								showUnitDialog(Class_f_StringManager.getLangString(247),
										(byte) 0, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 18:
								Class_f_StringManager.mainCanvas.sub_220e(sub_14359(
										null, Class_f_StringManager.getLangString(248),
										this.someCanHeight, 1500));
								this.var_4e12 += 1;
								break;
							case 19:
								getUnitAtPos(3, 8, (byte) 0).killUnitMaybe();
								getUnitAtPos(4, 7, (byte) 0).killUnitMaybe();
								getUnitAtPos(5, 8, (byte) 0).killUnitMaybe();
								Class_a_Unit localObject1111 = Class_a_Unit.createUnit((byte) 2,
										(byte) 0, 3, 8);
								localObject2 = Class_a_Unit.createUnit((byte) 2,
										(byte) 0, 4, 7);
								localObject3 = Class_a_Unit.createUnit((byte) 2,
										(byte) 0, 5, 8);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject1111).pixelX,
										((Class_a_Unit) localObject1111).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject2).pixelX,
										((Class_a_Unit) localObject2).pixelY, 0, 0,
										1, 50);
								showSpriteOnMap(this.sparkSprite,
										((Class_a_Unit) localObject3).pixelX,
										((Class_a_Unit) localObject3).pixelY, 0, 0,
										1, 50);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 20:
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_49a2 = 13;
								this.var_4e12 += 1;
								break;
							case 21:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.var_4a4a = false;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 22:
								sub_186db();
							}
						} else if (this.var_47a2 == 3) {
							switch (this.var_4e12) {
							case 0:
								Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
								this.var_4ada = true;
								this.var_4e12 += 1;
								break;
							case 1:
								if (this.maybeTeamKings[0].var_e83 != 1) {
									this.var_4c6a = null;
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 2:
								this.var_4aca = true;
								this.var_4ada = true;
								this.var_4ac2 = 0;
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 3:
								showUnitDialog(Class_f_StringManager.getLangString(249),
										(byte) 2, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 4:
								showUnitDialog(Class_f_StringManager.getLangString(250),
										(byte) 0, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 5:
								showUnitDialog(Class_f_StringManager.getLangString(251),
										(byte) 5, (byte) 4);
								moveCursorToPos(13, 3);
								sub_efb8(312, 72);
								this.maybeTeamKings[0].sub_1686(7, 1);
								this.var_4de2.sub_1686(5, 4);
								this.var_4dea.sub_1686(7, 5);
								this.var_4df2.sub_1686(3, 3);
								this.var_4de2 = null;
								this.var_4dea = null;
								this.var_4df2 = null;
								this.var_4c72 = 2;
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 6:
								this.var_4aca = false;
								this.var_4ad2 = true;
								this.var_4ac2 = 0;
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 7:
								sub_186a6(13, 10);
								break;
							case 8:
								Class_a_Unit.var_de3 = 2;
								this.var_4c72 = 4;
								this.var_4de2 = getUnitAtPos(10, 10, (byte) 0);
								this.var_4de2.sub_1c9f(6, 10, false);
								moveCursorToPos(6, 10);
								sub_186a6(6, 10);
								break;
							case 9:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2 = null;
									this.var_47f2 = true;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 10:
								moveCursorToPos(4, 9);
								sub_186a6(4, 9);
								showSpriteOnMap(this.redsparkSprite, 96, 216, 0, 0, 1, 50);
								sub_142e5(15);
								break;
							case 11:
								this.var_48a2 = Class_a_Unit.createUnitWithBool((byte) 0,
										(byte) 0, 4, 9, false);
								this.var_48a2.unitType = -1;
								this.var_48a2.var_e83 = 4;
								this.var_48ca = 6;
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 12:
								showUnitDialog(Class_f_StringManager.getLangString(252),
										(byte) 5, (byte) 4);
								sub_186a6(7, 1);
								break;
							case 13:
								showUnitDialog(Class_f_StringManager.getLangString(253),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 14:
								this.var_49a2 = 17;
								this.var_4e12 += 1;
								break;
							case 15:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 16:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									sub_142e5(15);
									this.var_4a4a = false;
									this.var_4e12 += 1;
								}
								break;
							case 17:
								showUnitDialog(Class_f_StringManager.getLangString(254),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 18:
								showUnitDialog(Class_f_StringManager.getLangString(255),
										(byte) 0, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 19:
								sub_186db();
							}
						} else if (this.var_47a2 == 4) {
							if (this.var_4e02 == null) {
								this.var_4e02 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super. array
							}
							if ((this.var_4e12 == 25)
									&& (this.var_4e02.posX >= 15)
									&& (this.var_4e02.posY >= 11)
									&& (this.var_4e02.var_e83 == 2)) {
								sub_142e5(10);
								this.var_4a4a = false;
								this.var_47f2 = false;
								this.var_4e12 = 26;
								return;
							}
							if (this.var_4e02.var_e83 == 3) {
								this.var_4e02 = null;
								sub_1872e();
								return;
							}
							switch (this.var_4e12) {
							case 0:
								sub_142e5(50);
								this.var_4e12 += 1;
								break;
							case 1:
								showUnitDialog(Class_f_StringManager.getLangString(256),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 2:
								showUnitDialog(Class_f_StringManager.getLangString(257),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 3:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 4:
								Class_a_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);//super. array
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX <= 8)) {
										this.var_4a4a = false;
										sub_142e5(5);
										this.var_4e12 += 1;
										break;
									}
								}
							case 5:
								this.var_47f2 = false;
								sub_186a6(4, 4);
								break;
							case 6:
								Class_a_Unit
										.createUnit((byte) 10, (byte) 1, 4, 4)
										.sub_1cc2(4, 1, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 7:
								Class_a_Unit.createUnit((byte) 1, (byte) 1, 4, 4)
										.sub_1cc2(5, 2, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 8:
								Class_a_Unit
										.createUnit((byte) 10, (byte) 1, 4, 4)
										.sub_1cc2(4, 3, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 9:
								showUnitDialog(Class_f_StringManager.getLangString(258),
										(byte) 5, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_4e12 += 1;
								break;
							case 11:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0);//super.
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posY >= 7)) {
										this.var_4a4a = false;
										this.var_47f2 = false;
										sub_186a6(6, 10);
										break;
									}
								}
							case 12:
								Class_a_Unit
										.createUnit((byte) 1, (byte) 1, 6, 10)
										.sub_1cc2(5, 10, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 13:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 6, 10)
										.sub_1cc2(7, 8, false, true);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 14:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 6, 10)
										.sub_1cc2(7, 9, false, true);
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_4e12 += 1;
								break;
							case 15:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super. return unit[]
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX >= 8)
											&& (localObject11[i].posY >= 6)) {
										this.var_4a4a = false;
										this.var_47f2 = false;
										sub_186a6(12, 5);
										break;
									}
								}
							case 16:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 12, 5)
										.sub_1cc2(12, 7, false, true);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 17:
								Class_a_Unit
										.createUnit((byte) 6, (byte) 1, 12, 5)
										.sub_1cc2(12, 6, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 18:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 12, 5)
										.sub_1cc2(12, 5, false, true);
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_4e12 += 1;
								break;
							case 19:
								localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super.
								for (i = 0; i < localObject11.length; i++) {
									if ((localObject11[i].var_e83 == 2)
											&& (localObject11[i].posX >= 15)
											&& (localObject11[i].posY >= 8)) {
										this.var_4a4a = false;
										this.var_47f2 = false;
										sub_186a6(18, 8);
										break;
									}
								}
							case 20:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 18, 8)
										.sub_1cc2(16, 10, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 21:
								Class_a_Unit
										.createUnit((byte) 6, (byte) 1, 18, 8)
										.sub_1cc2(17, 10, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 22:
								Class_a_Unit
										.createUnit((byte) 5, (byte) 1, 18, 8)
										.sub_1cc2(18, 10, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 23:
								Class_a_Unit
										.createUnit((byte) 1, (byte) 1, 18, 8)
										.sub_1cc2(18, 9, false, true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 24:
								showUnitDialog(Class_f_StringManager.getLangString(259),
										(byte) 0, (byte) 4);
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_4e12 += 1;
								break;
							case 25:
								if (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0) {
									this.var_4a4a = false;
									this.var_47f2 = false;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 26:
								sub_186db();
								this.var_4e12 += 1;
							}
						} else if (this.var_47a2 == 5) {
							switch (this.var_4e12) {
							case 0:
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 1:
								showUnitDialog(Class_f_StringManager.getLangString(260),
										(byte) 1, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 2:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 3:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.var_4a4a = false;
									this.var_47f2 = false;
									sub_142e5(15);
									this.var_4e12 += 1;
								}
								break;
							case 4:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 5:
								showUnitDialog(Class_f_StringManager.getLangString(261),
										(byte) 0, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 6:
								sub_186db();
							}
						} else if (this.var_47a2 == 6) {
							if (this.var_4e12 <= 10) {
								if (this.var_4e02 == null) {
									this.var_4e02 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super.
								}
								if (this.var_4e02.var_e83 == 3) {
									this.var_4e02 = null;
									sub_1872e();
									return;
								}
							}
							switch (this.var_4e12) {
							case 0:
								if (this.maybeTeamKings[0].var_e83 != 1) {
									this.var_4c6a = null;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 1:
								showUnitDialog(Class_f_StringManager.getLangString(262),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 2:
								showUnitDialog(Class_f_StringManager.getLangString(263),
										(byte) 0, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 3:
								Class_a_Unit[] localObject11 = getSomeUnitsOfTypeOfTeam(-1, -1, (byte) 0); //super.
								for (i = 0; i < localObject11.length; i++) {
									localObject11[i].var_ee3 = null;
								}
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 4:
								if (this.var_484a >= 2) {
									sub_142e5(15);
									this.var_4a4a = false;
									this.var_47f2 = false;
									sub_186a6(11, 7);
								}
								break;
							case 5:
								Class_a_Unit localObject111 = Class_a_Unit.createUnit((byte) 5,
										(byte) 1, 11, 8);
								localObject111.sub_20f8(this.var_47da);
								localObject111.sub_1c9f(14, 7,
										true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 6:
								Class_a_Unit localObject21= Class_a_Unit.createUnit((byte) 0,
										(byte) 1, 11, 8);
								localObject21.sub_20f8(this.var_47da);
								localObject21.sub_1c9f(13, 7,
										true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 7:
								Class_a_Unit localObject31 = Class_a_Unit.createUnit((byte) 3,
										(byte) 1, 11, 8);
								localObject31.sub_20f8(this.var_47da);
								((Class_a_Unit) localObject31).sub_1c9f(12, 7,
										true);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 8:
								Class_a_Unit
										.createUnit((byte) 1, (byte) 1, 11, 8)
										.sub_1c9f(13, 8, false);
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 9:
								showUnitDialog(Class_f_StringManager.getLangString(264),
										(byte) 5, (byte) 4);
								this.var_4a4a = true;
								this.var_47f2 = true;
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 10:
								int i1 = 0;
								Class_a_Unit[] arrayOfClass_a_0260 = getSomeUnitsOfTypeOfTeam(-1, 2, (byte) 0); //super.
								for (int m = 0; m < arrayOfClass_a_0260.length; m++) {
									if ((arrayOfClass_a_0260[m].posX <= 9)
											|| (arrayOfClass_a_0260[m].posY >= 10)) {
										i1 = 1;
										break;
									}
								}
								if ((i1 != 0)
										|| (countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)) {
									this.var_47f2 = false;
									this.var_4a4a = false;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 11:
								this.var_4de2 = getSomeUnitsOfTypeOfTeam(11, -1, (byte)0)[0]; //super.
								this.var_4dea = Class_a_Unit.createUnit((byte) 8,
										(byte) 1, this.mapWidthMaybe,
										this.var_4de2.posY);
								sub_186a6(this.mapWidthMaybe - 1,
										this.var_4de2.posY);
								this.var_47f2 = false;
								break;
							case 12:
								this.var_4dea.sub_1c9f(this.var_4de2.posX,
										this.var_4de2.posY, false);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 13:
								showUnitDialog(Class_f_StringManager.getLangString(265),
										(byte) 5, (byte) 4);
								this.var_4c6a = this.var_4dea;
								this.var_4e12 += 1;
								break;
							case 14:
								if (this.var_4dea.var_e83 != 1) {
									showUnitDialog(Class_f_StringManager.getLangString(266),
											(byte) 0, (byte) 4);
									this.var_4dea.sub_1c9f(-1,
											this.var_4dea.posY, false);
									sub_142e5(3);
									this.var_4e12 += 1;
								}
								break;
							case 15:
								this.var_4de2.sub_1c9f(-1,
										this.var_4dea.posY, false);
								this.var_4e12 += 1;
								break;
							case 16:
								if (this.var_4dea.var_e83 != 1) {
									sub_142e5(10);
									this.var_4de2.killUnitMaybe();
									this.var_4dea.killUnitMaybe();
									moveCursorToPos(0, this.var_4dea.posY);
									this.var_4de2 = null;
									this.var_4dea = null;
									this.var_4c6a = null;
									this.var_4e12 += 1;
								}
								break;
							case 17:
								sub_186a6(1, 9);
								break;
							case 18:
								this.maybeTeamKings[1] = Class_a_Unit.createUnit((byte)9, (byte)1,
										-2, 8);
								this.maybeTeamKings[1].sub_1c9f(0, 8, false);
								Class_a_Unit
										.createUnit((byte) 0, (byte) 1, -1, 8)
										.sub_1c9f(3, 8, false);
								Class_a_Unit.createUnit((byte) 0, (byte) 1, -1,
										10).sub_1c9f(1, 10, false);
								Class_a_Unit
										.createUnit((byte) 8, (byte) 1, -3, 7)
										.sub_1c9f(4, 8, false);
								Class_a_Unit.createUnit((byte) 8, (byte) 1, -3,
										11).sub_1c9f(2, 10, false);
								Class_a_Unit
										.createUnit((byte) 4, (byte) 1, -2, 9)
										.sub_1c9f(2, 9, false);
								Class_a_Unit
										.createUnit((byte) 6, (byte) 1, -4, 9)
										.sub_1c9f(4, 9, false);
								Class_a_Unit
										.createUnit((byte) 6, (byte) 1, -6, 9)
										.sub_1c9f(5, 10, false);
								sub_142e5(50);
								this.var_4e12 += 1;
								break;
							case 19:
								showUnitDialog(Class_f_StringManager.getLangString(267),
										(byte) 3, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 20:
								sub_186a6(13, 14);
								break;
							case 21:
								Class_a_Unit.createUnit((byte) 0, (byte) 1, 13,
										14).sub_1c9f(12, 14, false);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 22:
								Class_a_Unit.createUnit((byte) 6, (byte) 1, 13,
										14).sub_1c9f(14, 14, false);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 23:
								Class_a_Unit.createUnit((byte) 2, (byte) 1, 13,
										14).sub_1c9f(13, 12, false);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 24:
								Class_a_Unit.createUnit((byte) 3, (byte) 1, 13,
										14).sub_1c9f(13, 15, false);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 25:
								showUnitDialog(Class_f_StringManager.getLangString(268),
										(byte) 5, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 26:
								showUnitDialog(Class_f_StringManager.getLangString(269),
										(byte) 0, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 27:
								sub_186a6(13, 17);
								break;
							case 28:
								Class_a_Unit localClass_a_0260;
								(localClass_a_0260 = Class_a_Unit.createUnit(
										(byte) 9, (byte) 0, 13, 18))
										.setKingName(2);
								localClass_a_0260.sub_1c9f(13, 16, false);
								Class_a_Unit.createUnit((byte) 6, (byte) 0, 12,
										18).sub_1c9f(12, 16, false);
								Class_a_Unit.createUnit((byte) 8, (byte) 0, 14,
										19).sub_1c9f(14, 16, false);
								Class_a_Unit.createUnit((byte) 4, (byte) 0, 13,
										19).sub_1c9f(13, 17, false);
								Class_a_Unit.createUnit((byte) 1, (byte) 0, 12,
										19).sub_1c9f(12, 17, false);
								sub_142e5(20);
								this.var_4e12 += 1;
								break;
							case 29:
								showUnitDialog(Class_f_StringManager.getLangString(270),
										(byte) 1, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 30:
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 31:
								this.var_49a2 = 18;
								this.var_4e12 += 1;
								break;
							case 32:
								this.var_4a4a = true;
								this.var_47f2 = true;
								this.var_49c2 = sub_14359(Class_f_StringManager
										.getLangString(121 + this.var_47a2),
										Class_f_StringManager.getLangString(138),
										this.someCanHeight, -1);
								this.var_49c2.sub_132e((byte) 0, true);
								this.var_49c2.sub_1350(null);
								Class_f_StringManager.mainCanvas.sub_220e(this.var_49c2);
								this.var_4e12 += 1;
								break;
							case 33:
								if ((countSomeTeamUnitsOfType(-1, -1, (byte) 1) == 0)
										&& (sub_11cef(1) == 0)) {
									this.var_4a4a = false;
									this.var_47f2 = false;
									sub_142e5(10);
									this.var_4e12 += 1;
								}
								break;
							case 34:
								sub_186db();
							}
						} else if (this.var_47a2 == 7) {
							switch (this.var_4e12) {
							case 0:
								Class_f_StringManager.mainCanvas.sub_220e(this.var_4dda);
								this.var_4ada = true;
								this.var_4e12 += 1;
								break;
							case 1:
								if (!this.var_4ad2) {
									showUnitDialog(Class_f_StringManager.getLangString(271),
											(byte) 0, (byte) 4);
									this.var_4e12 += 1;
								}
								break;
							case 2:
								sub_186a6(this.maybeTeamKings[1].posX,
										this.maybeTeamKings[1].posY);
								break;
							case 3:
								showUnitDialog(Class_f_StringManager.getLangString(272),
										(byte) 4, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 4:
								showUnitDialog(Class_f_StringManager.getLangString(273),
										(byte) 1, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 5:
								showUnitDialog(Class_f_StringManager.getLangString(274),
										(byte) 4, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 6:
								this.var_4de2 = getUnitAtPos(5, 2, (byte) 0);
								this.var_4de2.sub_1c9f(7, 2, false);
								this.var_4e12 += 1;
								break;
							case 7:
								if (this.var_4de2.var_e83 != 1) {
									this.var_4de2.killUnitMaybe();
									this.var_4de2 = null;
									this.var_4dea = getUnitAtPos(7, 3, (byte) 0);
									this.var_4dea.sub_1c9f(7, 2, false);
									this.var_4e12 += 1;
								}
								break;
							case 8:
								if (this.var_4dea.var_e83 != 1) {
									this.var_4dea.killUnitMaybe();
									this.var_4dea = null;
									this.var_4df2 = getUnitAtPos(9, 2, (byte) 0);
									this.var_4df2.sub_1c9f(7, 2, false);
									this.var_4e12 += 1;
								}
								break;
							case 9:
								if (this.var_4df2.var_e83 != 1) {
									this.var_4df2.killUnitMaybe();
									this.var_4df2 = null;
									this.maybeTeamKings[1].sub_1c9f(7, 2, false);
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 10:
								sub_186a6(9, 15);
								this.var_47f2 = true;
								break;
							case 11:
								Class_e_FightAnimation localClass_e_0134;
								(localClass_e_0134 = sub_14359(null,
										Class_f_StringManager.getLangString(279),
										this.someCanHeight, 2000)).sub_1930(
										this.someCanWidthShift, 2, 17);
								Class_f_StringManager.mainCanvas
										.sub_220e(localClass_e_0134);
								this.var_4e12 += 1;
								break;
							case 12:
								this.var_4b42 = false;
								sub_6963(getUnitAtPos(9, 15, (byte) 0));
								this.var_4e12 += 1;
								break;
							case 13:
								if (this.var_4b3a >= 2) {
									showUnitDialog(Class_f_StringManager.getLangString(275),
											(byte) 0, (byte) 4);
									getUnitAtPos(9, 15, (byte) 0).killUnitMaybe();
									this.var_4b42 = true;
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 14:
								this.var_47f2 = false;
								showUnitDialog(Class_f_StringManager.getLangString(276),
										(byte) 4, (byte) 4);
								this.var_4e12 += 1;
								break;
							case 15:
								showUnitDialog(Class_f_StringManager.getLangString(277),
										(byte) 1, (byte) 4);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 16:
								this.var_47f2 = true;
								this.var_4c72 = 4;
								sub_186a6(3, 9);
								break;
							case 17:
								sub_186a6(13, 4);
								break;
							case 18:
								this.var_4c72 = 12;
								showUnitDialog(Class_f_StringManager.getLangString(278),
										(byte) 5, (byte) 4);
								sub_186a6(this.maybeTeamKings[0].posX,
										this.maybeTeamKings[0].posY);
								break;
							case 19:
								sub_1864a();
								this.var_4e12 += 1;
								break;
							case 20:
								if (this.var_4b4a) {
									this.var_47f2 = false;
									this.var_4a4a = false;
									sub_142e5(20);
									this.var_4e12 += 1;
								}
								break;
							case 21:
								this.var_4aca = true;
								this.var_4ac2 = 0;
								this.var_4ada = true;
								this.var_4e12 += 1;
								break;
							case 22:
								if (this.var_4ac2 >= 16) {
									sub_efe5(7, 2);
									moveCursorToPos(7, 2);
									sub_ac6f();
									this.maybeTeamKings[1] = Class_a_Unit.createUnit((byte)9,
											(byte)1, 7, 2);
									this.maybeTeamKings[1].setKingName(3);
									Class_a_Unit.createUnit((byte) 9, (byte) 0,
											6, 3);
									Class_a_Unit.createUnit((byte) 9, (byte) 0,
											8, 3).setKingName(2);
									Class_a_Unit.createUnit((byte) 0, (byte) 0,
											6, 1);
									Class_a_Unit.createUnit((byte) 0, (byte) 0,
											8, 1);
									sub_142e5(10);
									this.var_4e12 += 1;
									Class_c_MainCanvas.sub_2bf1(8, 0);
								}
								break;
							case 23:
								this.var_4aca = false;
								this.var_4ad2 = true;
								this.var_4ac2 = 0;
								this.var_4e12 += 1;
								break;
							case 24:
								if (this.var_4ac2 >= 16) {
									showUnitDialog(Class_f_StringManager.getLangString(281),
											(byte) 4, (byte) 4);
									sub_142e5(15);
									this.var_4e12 += 1;
								}
								break;
							case 25:
								showUnitDialog(Class_f_StringManager.getLangString(282),
										(byte) 0, (byte) 4);
								sub_142e5(8);
								this.var_4e12 += 1;
								break;
							case 26:
								showUnitDialog(Class_f_StringManager.getLangString(283),
										(byte) 4, (byte) 4);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 27:
								showSpriteOnMap(this.sparkSprite, 168, 48, 0, 0, 1, 50);
								this.mapUnitsMaybe.removeElement(this.maybeTeamKings[1]);
								sub_142e5(15);
								this.var_4e12 += 1;
								break;
							case 28:
								Class_c_MainCanvas.sub_2af6(400);
								sub_188ce(5000);
								sub_142e5(10);
								this.var_4e12 += 1;
								break;
							case 29:
								showUnitDialog(Class_f_StringManager.getLangString(284),
										(byte) 5, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 30:
								showUnitDialog(Class_f_StringManager.getLangString(285),
										(byte) 2, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 31:
								showUnitDialog(Class_f_StringManager.getLangString(286),
										(byte) 1, (byte) 4);
								sub_142e5(5);
								this.var_4e12 += 1;
								break;
							case 32:
								showUnitDialog(Class_f_StringManager.getLangString(287),
										(byte) 0, (byte) 4);
								this.var_4aca = true;
								this.var_4ac2 = 0;
								this.var_4e12 += 1;
								break;
							case 33:
								if (this.var_4ac2 >= 16) {
									sub_142e5(10);
									this.var_4e82 = false;
									this.var_4e12 += 1;
								}
								break;
							case 34:
								initIntro(5, 2, 2);
								this.var_4e12 += 1;
								break;
							case 35:
								Class_c_MainCanvas.sub_2bf1(0, 0);
								sub_f6d8(Class_f_StringManager.getLangString(288));
								this.var_4e12 += 1;
								break;
							case 36:
								this.var_4e52 = 0;
								this.var_478a = 14;
								this.var_4e12 += 1;
							}
						}
					}
					this.var_4e0a = null;
				}
			}
		}
	}

	private void sub_1864a() {
		this.var_4dda = null;
		this.var_4c72 = 12;
		Class_a_Unit.var_de3 = Class_a_Unit.var_ddb;
		this.var_49c2.sub_132e((byte) 0, true);
		this.var_49c2.sub_132e((byte) 1, false);
		Class_f_StringManager.mainCanvas.sub_220e(this.var_49c2);
		this.var_47f2 = true;
		this.var_4a4a = true;
		this.var_4a5a = false;
		Class_c_MainCanvas.sub_2bf1(2, 0);
	}

	private void sub_186a6(int paramInt1, int paramInt2) {
		this.var_4e42 = paramInt1;
		this.var_4e4a = paramInt2;
		moveCursorToPos(paramInt1, paramInt2);
		this.var_4e12 += 1;
	}

	private void sub_186db() {
		Class_c_MainCanvas.stopCurrentMusicPlayer();
		Class_c_MainCanvas.playMusicLooped(6, 1);
		Class_f_StringManager.mainCanvas.sub_220e(sub_14359(null, Class_f_StringManager.getLangString(72),
				this.someCanHeight, 3000));
		this.var_481a = this.var_479a;
		this.var_4e12 = -1;
		this.var_4e52 = 0;
		this.var_478a = 10;
	}

	private void sub_1872e() {
		this.var_4e3a = true;
		this.var_4e12 = 0;
		sub_142e5(20);
		Class_c_MainCanvas.stopCurrentMusicPlayer();
		Class_c_MainCanvas.playMusicLooped(7, 1);
	}

	private void sub_18762(Class_a_Unit unit1,
			Class_a_Unit unit2) {
		System.gc();
		this.var_4eba = (this.someCanHeight - this.var_4cfa);
		this.var_4ea2 = true;
		this.var_491a = 0;
		this.var_4e72 = false;
		this.var_493a = unit1;
		this.var_4942 = unit2;
		Class_c_MainCanvas.initResPak();
		this.var_4e5a = new Class_h_0417(this, unit1, null);
		this.var_4e62 = new Class_h_0417(this, unit2,
				this.var_4e5a);
		this.var_4e5a.var_c0f = this.var_4e62;
		unit1.getDamageWhenAttack(unit2);
		if (unit2.canAttackPosition(unit1.posX,
				unit1.posY)) {
			unit2.getDamageWhenAttack(unit1);
			this.var_4e9a = true;
		} else {
			this.var_4e9a = false;
		}
		this.var_4e5a.var_b77 = ((byte) unit1.health);
		this.var_4e5a.var_b87 = ((byte) unit1.sub_16bf());
		this.var_4e62.var_b77 = ((byte) unit2.health);
		this.var_4e62.var_b87 = ((byte) unit2.sub_16bf());
		Class_c_MainCanvas.playMusicLooped(var_469a[this.var_4832[this.someUnitTeamId]], 0);
		this.var_48e2 = 2;
		return;
	}

	public final void addSomeSprite(Class_g_Sprite sprite) {
		this.spritesList.addElement(sprite);
	}

	public final void removeSomeSprite(Class_g_Sprite sprite) {
		this.spritesList.removeElement(sprite);
	}

	public final void sub_188ce(int paramInt) {
		this.var_4e82 = true;
		this.var_4e8a = paramInt;
		this.var_4e92 = this.var_479a;
	}

	private Class_e_FightAnimation sub_188fc(Class_f_StringManager strMan) {
		Class_e_FightAnimation localClass_e_01341;
		if (this.var_4ed2.length > 0) {
			Class_e_FightAnimation localClass_e_01342;
			(localClass_e_01342 = (localClass_e_01341 = new Class_e_FightAnimation(
					(byte) 11, 0)).sub_165b(Class_f_StringManager.getLangString(46))).var_11b2 = this.menuIconsFrames[6];
			localClass_e_01341.sub_20ad(this.var_4ed2, this.someCanWidth / 2,
					(this.someCanHeight + localClass_e_01342.var_1042) / 2,
					this.someCanWidth, this.someCanHeight - localClass_e_01342.var_1042,
					3, 4);
		} else {
			(localClass_e_01341 = new Class_e_FightAnimation((byte) 10, 0))
					.sub_165b(Class_f_StringManager.getLangString(46)).var_11b2 = this.menuIconsFrames[6];
			localClass_e_01341.sub_1ca8(null, Class_f_StringManager.getLangString(52),
					this.someCanWidth, -1);
		}
		localClass_e_01341.sub_1350(strMan);
		Class_f_StringManager.mainCanvas.sub_220e(localClass_e_01341);
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
					Class_e_FightAnimation localClass_e_0134;
					(localClass_e_0134 = sub_1437e(
							this.var_4ed2[this.var_4ec2],
							this.var_4ee2[this.var_4ec2], this.someCanHeight,
							this.someCanHeight / 2, -1)).sub_1350(this.var_4f3a);
					Class_f_StringManager.mainCanvas.sub_220e(localClass_e_0134);
				} else if (this.var_4f42 == 2) {
					i = paramArrayOfByte.readInt() / 3;
					this.var_4eea = new String[i];
					this.var_4ef2 = new String[i];
					this.var_4efa = new int[i];
					for (int j = 0; j < i; j++) {
						this.var_4eea[j] = paramArrayOfByte.readUTF();
						this.var_4ef2[j] = paramArrayOfByte.readUTF();
						this.var_4efa[j] = Integer.parseInt(paramArrayOfByte
								.readUTF());
					}
					sub_70c0(this.var_4f3a);
					Class_f_StringManager.mainCanvas.sub_220e(this.var_4c0a);
				} else if (this.var_4f42 == 3) {
					String str = this.var_4eea[this.var_4eca];
					byte[] arrayOfByte = new byte[i];
					paramArrayOfByte.readFully(arrayOfByte);
					sub_19157(str, arrayOfByte);
					sub_70c0(this.var_4c0a.stringManager);
					Class_e_FightAnimation cll;
					(cll = sub_14359(null, Class_f_StringManager.getStrByIdAndReplaceUWith(45, str),
							this.someCanHeight, 2000)).sub_1350(this.var_4c0a);
					Class_f_StringManager.mainCanvas.sub_220e(cll);
				}
				this.var_4f3a = null;
				return;
			}
			paramArrayOfByte.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Class_e_FightAnimation bbc;
		(bbc = sub_14359(null, Class_f_StringManager.getLangString(44), this.someCanHeight, -1))
				.sub_1350(this.var_4f3a);
		this.var_4f3a = null;
		Class_f_StringManager.mainCanvas.sub_220e(bbc);
	}

	private void sub_18c91(int paramInt, String paramString1,
			String paramString2, Class_f_StringManager paramClass_f_0145) {
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
			Class_e_FightAnimation cl = sub_14359(null, Class_f_StringManager.getLangString(43), this.someCanHeight, -1);
			cl.sub_1350(paramClass_f_0145);
			Class_f_StringManager.mainCanvas.sub_220e(cl);

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
		System.arraycopy(this.settingsStrListMaybe, 0, arrayOfString, 0, paramInt);
		System.arraycopy(this.settingsStrListMaybe, paramInt + 1, arrayOfString, paramInt,
				this.settingsCountMaybe - paramInt);
		System.arraycopy(this.settingsIntListMaybe, 0, arrayOfInt, 0, paramInt);
		System.arraycopy(this.settingsIntListMaybe, paramInt + 1, arrayOfInt, paramInt,
				this.settingsCountMaybe - paramInt);
		this.settingsStrListMaybe = arrayOfString;
		this.settingsIntListMaybe = arrayOfInt;
		Class_c_MainCanvas.deleteRecord("download", i);
		this.downloadAvailableSize = Class_c_MainCanvas.getAvailableRecordSize("download");
		sub_191de();
		for (paramInt = 0; paramInt < 3; paramInt++) {
			if (this.saveSlotsMapIds[paramInt] == i + someOneOf12LangStrings.length) {
				this.saveSlotBytes[paramInt] = -1;
				this.saveSlotsMapIds[paramInt] = -1;
				this.saveSlotsDescriptions[paramInt] = ("\n" + Class_f_StringManager.getLangString(79) + "\n ");
				Class_c_MainCanvas.addSomeRecords("save", paramInt, new byte[0]);
			}
		}
	}

	private void sub_19157(String paramString, byte[] paramArrayOfByte) {
		String[] arrayOfString = new String[this.settingsCountMaybe + 1];
		int[] arrayOfInt = new int[this.settingsCountMaybe + 1];
		System.arraycopy(this.settingsStrListMaybe, 0, arrayOfString, 0, this.settingsCountMaybe);
		System.arraycopy(this.settingsIntListMaybe, 0, arrayOfInt, 0, this.settingsCountMaybe);
		this.settingsStrListMaybe = arrayOfString;
		this.settingsIntListMaybe = arrayOfInt;
		this.settingsIntListMaybe[this.settingsCountMaybe] = Class_c_MainCanvas.saveRecord("download",
				paramArrayOfByte);
		this.settingsStrListMaybe[this.settingsCountMaybe] = paramString;
		this.settingsCountMaybe += 1;
		this.downloadAvailableSize = Class_c_MainCanvas.getAvailableRecordSize("download");
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
				localDataOutputStream.writeUTF(this.settingsStrListMaybe[i]);
			}
			Class_c_MainCanvas.addSomeRecords("settings", 2,
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
					Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
					Class_f_StringManager.mainCanvas.sub_220e(this);
					this.var_45fa = 1;
					this.var_4f92 = 1;
					this.var_4982 = true;
					Class_f_StringManager.mainCanvas.repaintAll();
					sub_5dc1();
					int[] arrayOfInt = this.var_4fba;
					int i1 = intSomoeDiss;
					int j = intSomoe;
					String paramDisplayable = this.var_5002.getString();
					Class_g_Game paramCommand = this;
					try {
						Class_c_MainCanvas.stopCurrentMusicPlayer();
						paramCommand.var_488a = new Vector();
						paramCommand.var_4aca = false;
						paramCommand.var_47f2 = true;
						paramCommand.var_4912 = false;
						paramCommand.var_4b4a = false;
						paramCommand.var_4802 = null;
						paramCommand.var_489a = null;
						paramCommand.var_4b32 = null;
						paramCommand.var_48a2 = null;
						paramCommand.var_48b2 = null;
						paramCommand.var_4ae2.removeAllElements();
						paramCommand.var_484a = 0;
						paramCommand.someUnitTeamId = 0;
						paramCommand.someUnitTeamId = 0;
						paramCommand.var_4e12 = 0;
						paramCommand.sub_ac6f();
						paramCommand.maybeTeamKings = null;
						paramCommand.var_4782 = null;
						paramCommand.var_47da = null;
						paramCommand.teamsCountMaybe = 0;
						for (int i3 = 0; i3 < 5; i3++) {
							paramCommand.var_482a[i3] = -1;
						}
						paramCommand.var_495a = true;
						Class_c_MainCanvas.initResPak();
						paramCommand.var_4b52 = paramDisplayable;
						paramCommand.mapWidthMaybe = j;
						paramCommand.mapHeightMaybe = i1;
						paramCommand.var_4782 = new byte[paramCommand.mapWidthMaybe][paramCommand.mapHeightMaybe];
						paramCommand.var_47da = new byte[paramCommand.mapWidthMaybe][paramCommand.mapHeightMaybe];
						paramCommand.var_4d92 = new byte[paramCommand.mapWidthMaybe][paramCommand.mapHeightMaybe];
						paramCommand.var_4d9a = 0;
						int i3 = 0;

						Vector vecParamDisplayable = new Vector();
						Vector localVector = new Vector();
						Class_c_MainCanvas.sub_1abc(arrayOfInt, true);
						for (int i4 = 0; i4 < paramCommand.mapWidthMaybe; i4 = (short) (i4 + 1)) {
							for (int i5 = 0; i5 < paramCommand.mapHeightMaybe; i5 = (short) (i5 + 1)) {
								paramCommand.var_4782[i4][i5] = ((byte) Class_c_MainCanvas
										.getRandomArrayItemOrWhat(arrayOfInt));
								paramCommand.var_47da[i4][i5] = 0;
								if (sub_11b28(paramCommand.var_4782[i4][i5])) {
									int i2 = paramCommand.sub_11bae(i4, i5);
									byte[] arrayOfByte;
									(arrayOfByte = new byte[3])[0] = ((byte) i4);
									arrayOfByte[1] = ((byte) i5);
									arrayOfByte[2] = ((byte) i2);
									vecParamDisplayable.addElement(arrayOfByte);
									i3++;
									if (paramCommand.getMapTileType(i4, i5) == 9) {
										if ((paramCommand.var_45fa == 1)
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
						Class_c_MainCanvas.sub_1abc(arrayOfInt, false);
						paramCommand.var_4d82 = new int[i3];
						paramCommand.var_49fa = new byte[i3][];
						vecParamDisplayable.copyInto(paramCommand.var_49fa);
						paramCommand.var_4a02 = new byte[paramCommand.var_4d9a][];
						localVector.copyInto(paramCommand.var_4a02);
						paramCommand.var_46d2 = (paramCommand.mapWidthMaybe * 24);
						paramCommand.var_46da = (paramCommand.mapHeightMaybe * 24);
						paramCommand.var_4e3a = false;
						paramCommand.var_4e02 = null;
						paramCommand.var_4de2 = null;
						paramCommand.var_4dea = null;
						paramCommand.var_4df2 = null;
						paramCommand.var_4dfa = null;
						paramCommand.var_4e0a = null;
						if (paramCommand.var_45fa == 1) {
							paramCommand.var_4e12 = 100;
							paramCommand.var_4a4a = true;
						}
						paramCommand.var_4d6a = new Class_a_Unit[paramCommand.var_49fa.length];
						paramCommand.var_4d72 = new byte[paramCommand.var_49fa.length];
						paramCommand.var_4a6a = new Class_g_Sprite[paramCommand.var_49fa.length];
						for (short i4 = 0; i4 < paramCommand.var_49fa.length; i4 = (short) (i4 + 1)) {
							if (paramCommand.getMapTileType(
									paramCommand.var_49fa[i4][0],
									paramCommand.var_49fa[i4][1]) == 8) {
								paramCommand.var_4a6a[i4] = Class_g_Sprite
										.sub_2054(paramCommand.bSmokeSprite, 0, -1,
												0, 1, 250, (byte) 0);
								paramCommand.var_4a6a[i4].var_c78 = false;
							}
						}
						Class_c_MainCanvas.sub_2bf1(var_4692[1], 0);
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
					this.var_4982 = false;
					this.var_478a = 0;
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
					Class_c_MainCanvas.setDisplayableAsCurrent(this.var_4ff2);
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
				Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
				Class_f_StringManager.mainCanvas.sub_220e(this);
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
					Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
					Class_f_StringManager.mainCanvas.sub_220e(this);
					return;
				}
				if (inparamCommand == this.var_508a) {
					System.arraycopy(this.var_4fba, 0, this.var_4fc2, 0,
							this.var_4fba.length);
					itemStateChanged(this.var_502a);
					Class_c_MainCanvas.setDisplayableAsCurrent(this.var_4ff2);
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
				Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
				Class_f_StringManager.mainCanvas.sub_220e(this);
				return;
			}
			if (inparamDisplayable == this.var_4fe2) {
				if (inparamCommand == this.var_506a) {
					if (this.var_5002.size() == 0) {
						return;
					}
					Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
					Class_f_StringManager.mainCanvas.sub_220e(this);
					this.var_4b52 = this.var_5002.getString();
					return;
				}
				if (inparamCommand == this.var_5092) {
					this.var_5002.setString(Long.toString(
							System.currentTimeMillis(), 36).toUpperCase());
					return;
				}
				Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
				Class_f_StringManager.mainCanvas.sub_220e(this);
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
				Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
				Class_f_StringManager.mainCanvas.sub_220e(this);
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
					Class_c_MainCanvas.setDisplayableAsCurrent(this.var_4fda);
					return;
				}
				if (this.var_4fd2 != null) {
					Class_c_MainCanvas.setDisplayableAsCurrent(this.var_4fd2);
				}
			} else {
				int k;
				if (inparamDisplayable == this.var_4ffa) {
					if (inparamCommand == this.var_506a) {
						int[] intArrparamCommand = new int[] {
								100 - this.var_5062.getValue(), 100 };
						for (int itparamDisplayable = 0; itparamDisplayable < this.mapWidthMaybe; itparamDisplayable++) {
							for (k = 0; k < this.mapHeightMaybe; k++) {
								if (this.var_47da[itparamDisplayable][k] > 0) {
									this.var_47da[itparamDisplayable][k] = ((byte) Class_c_MainCanvas
											.getRandomArrayItemOrWhat(intArrparamCommand));
								}
							}
						}
					}
					Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
					Class_f_StringManager.mainCanvas.sub_220e(this);
					return;
				}
				if (inparamDisplayable == this.var_505a) {
					if (inparamCommand == this.var_506a) {
						String[] thepcc = null;
						try {

							String[] theppc = Class_c_MainCanvas.splitStringByChar(this.var_505a
									.getString().toLowerCase(), ' ');
							if (thepcc[0].equals("win")) {
								if (this.var_47a2 == 7) {
									this.var_4b4a = true;
								} else {
									sub_186db();
								}
							} else if (theppc[0].equals("fps")) {
								Class_f_StringManager.mainCanvas.setFPSOverride(Integer
										.parseInt(theppc[1]));
							} else if (theppc[0].equals("money")) {
								if (theppc[1].equals("add")) {
									if (theppc[2].equals("player")) {
										this.var_486a[this.someUnitTeamId] += Integer
												.parseInt(theppc[3]);
										//break label3051; @label
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											if (this.var_487a[paramDisplayable] == 0) {
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
										this.var_486a[this.someUnitTeamId] -= Integer
												.parseInt(theppc[3]);
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < 4; paramDisplayable++) {
											if (this.var_487a[paramDisplayable] == 0) {
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
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidthMaybe; paramDisplayable++) {
											for (k = 0; k < this.mapHeightMaybe; k++) {
												if ((getMapTileType(
														paramDisplayable, k) == 8)
														&& (sub_11bae(
																paramDisplayable,
																k) == 0)) {
													sub_11ad0(
															paramDisplayable,
															k,
															this.var_4832[this.someUnitTeamId]);
												}
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidthMaybe; paramDisplayable++) {
											for (k = 0; k < this.mapHeightMaybe; k++) {
												if (getMapTileType(paramDisplayable,
														k) == 8) {
													sub_11ad0(
															paramDisplayable,
															k,
															this.var_4832[this.someUnitTeamId]);
												}
											}
										}
										//break label3051;
									}
								} else if (theppc[1].equals("castle")) {
									if (theppc[2].equals("civilian")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidthMaybe; paramDisplayable++) {
											for (k = 0; k < this.mapHeightMaybe; k++) {
												if ((getMapTileType(
														paramDisplayable, k) == 9)
														&& (sub_11bae(
																paramDisplayable,
																k) == 0)) {
													sub_11ad0(
															paramDisplayable,
															k,
															this.var_4832[this.someUnitTeamId]);
												}
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapWidthMaybe; paramDisplayable++) {
											for (k = 0; k < this.mapHeightMaybe; k++) {
												if (getMapTileType(paramDisplayable,
														k) == 9) {
													sub_11ad0(
															paramDisplayable,
															k,
															this.var_4832[this.someUnitTeamId]);
												}
											}
										}
										//break label3051;
									}
								}
							} else if (theppc[0].equals("unit")) {
								if (theppc[1].equals("reset")) {
									if (theppc[2].equals("current")) {
										Class_a_Unit paramDisplayable;
										if ((paramDisplayable = getUnitAtPos(
												this.cursorPosX, this.cursorPosY,
												(byte) 0)) != null) {
											paramDisplayable.var_e83 = 0;
										}
										//break label3051;
									}
									Class_a_Unit localClass_a_0260;
									if (theppc[2].equals("player")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											if ((localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).teamId == this.someUnitTeamId) {
												localClass_a_0260.var_e83 = 0;
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											if ((localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).teamId != this.someUnitTeamId) {
												localClass_a_0260.var_e83 = 0;
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("all")) {
										for (int paramDisplayable = 0; paramDisplayable < this.mapUnitsMaybe
												.size(); paramDisplayable++) {
											(localClass_a_0260 = (Class_a_Unit) this.mapUnitsMaybe
													.elementAt(paramDisplayable)).var_e83 = 0;
										}
										//break label3051;
									}
								} else if (theppc[1].equals("promote")) {
									if (theppc[2].equals("current")) {
										Class_a_Unit paramDisplayable;
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
											Class_a_Unit loo;
											if ((loo = (Class_a_Unit) this.mapUnitsMaybe
													.elementAt(m)).teamId == this.someUnitTeamId) {
												((Class_a_Unit) loo)
														.setUnitLevel(paramDisplayable);
											}
										}
										//break label3051;
									}
									if (theppc[2].equals("enemy")) {
										byte paramDisplayable = (byte) Integer
												.parseInt(theppc[3]);
										for (m = 0; m < this.mapUnitsMaybe.size(); m++) {
											Class_a_Unit loo;
											if ((loo = (Class_a_Unit) this.mapUnitsMaybe
													.elementAt(m)).teamId != this.someUnitTeamId) {
												((Class_a_Unit) loo)
														.setUnitLevel(paramDisplayable);
											}
										}
									//	break label3051;
									}
									if (theppc[2].equals("all")) {
										byte paramDisplayable = (byte) Integer
												.parseInt(theppc[3]);
										for (m = 0; m < this.mapUnitsMaybe.size(); m++) {
											Class_a_Unit loo;
											(loo = (Class_a_Unit) this.mapUnitsMaybe
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
					label3051: Class_c_MainCanvas.setDisplayableAsCurrent(Class_f_StringManager.mainCanvas);
					Class_f_StringManager.mainCanvas.sub_220e(this);
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
			this.var_502a.setLabel(Class_f_StringManager.getStrByIdAndReplaceUWith(308,
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
			this.var_5062.setLabel(Class_f_StringManager.getStrByIdAndReplaceUWith(315,
					Integer.toString(this.var_5062.getValue()) + "%"));
		}
	}

	private void sub_1a88b() {
		if (this.var_4fe2 != null) {
			return;
		}
		this.var_4fe2 = new Form(Class_f_StringManager.getLangString(304));
		this.var_5002 = new TextField(Class_f_StringManager.getLangString(294), this.var_4b52,
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
		this.var_4fea = new Form(Class_f_StringManager.getLangString(306));
		this.var_503a = new TextField(Class_f_StringManager.getLangString(310), "0", 20, 2);
		this.var_5042 = new TextField(Class_f_StringManager.getLangString(311), "0", 20, 2);
		this.var_504a = new TextField(Class_f_StringManager.getLangString(312), "0", 20, 2);
		this.var_5052 = new TextField(Class_f_StringManager.getLangString(313), "0", 20, 2);
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
		this.var_4ffa = new Form(Class_f_StringManager.getLangString(307));
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
		this.var_4fda = new Form(Class_f_StringManager.getLangString(303));
		this.var_501a = new ChoiceGroup(Class_f_StringManager.getLangString(297), 2);
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
					" " + Class_f_StringManager.getStrByIdAndReplaceUWith(308, Integer.toString(i + 1))
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
		this.var_4fd2 = new Form(Class_f_StringManager.getLangString(292));
		this.var_5002 = new TextField(Class_f_StringManager.getLangString(294), Long.toString(
				System.currentTimeMillis(), 36).toUpperCase(), 100, 0);
		int i = (this.canvasWidth + 23) / 24;
		int j = (this.canvasHeight - var_4592 + 23) / 24;
		this.var_500a = new TextField(Class_f_StringManager.getLangString(295),
				Integer.toString(i), 3, 2);
		this.var_5012 = new TextField(Class_f_StringManager.getLangString(296),
				Integer.toString(j), 3, 2);
		this.var_501a = new ChoiceGroup(Class_f_StringManager.getLangString(297), 2);
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
					" " + Class_f_StringManager.getStrByIdAndReplaceUWith(308, Integer.toString(i + 1))
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
		this.var_4ff2 = new Form(Class_f_StringManager.getLangString(304));
		this.var_5032 = new ImageItem(null, null, 1, null);
		this.var_5032.setLayout(2049);
		this.var_502a = new Gauge("", true, this.tiles0Frames.length - 1, 0);
		this.var_502a.setLayout(2049);
		this.var_5022 = new TextField(Class_f_StringManager.getLangString(309), "", 20, 2);
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
		Class_g_Game localClass_g_1956 = this;
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
		String consoleStr = Class_f_StringManager.getLangString(314);
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