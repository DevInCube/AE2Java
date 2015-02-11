package aeii;

import a.a.a.G_Sprite;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;

public final class C_MainCanvas extends Canvas implements Runnable,
		CommandListener {

	public static boolean propDeveloperModeOn;
	public static boolean propDisableIntroOn;
	public static final Font someFont = Font.getFont(0, 1, 8);
	public static Font theFont = Font.getFont(0, 1, 8);
	public static int fontBaselinePos = C_MainCanvas.theFont.getBaselinePosition();
	public static final int var_1767 = C_MainCanvas.fontBaselinePos + 6;
	public static final int someFontHeight;
	private static short[] var_1777;
	private static short[] var_177f;
	private static byte[][] var_1787;
	private static Display midletDisplay;
	private boolean isRunning = false;
	private boolean var_179f = true;
	private int frameDelay;
	private String fpsValue = "";
	public F_StringManager var_17b7;
	public static int canvasWidth;
	public static int canvasHeight;
	private int var_17cf = 0;
	private int var_17d7;
	private int gameActionCodeRunning = 0;
	private long gameActionStartTime;
	public static G_Sprite[] sprites;
	public static Random random = new Random();
	public static boolean[] settings = { true, true, true, true };
	public static String[] var_1807;
	private static int[] var_180f;
	private boolean var_1817 = false;
	private static int var_181f = -1;
	private static int var_1827;
	private static boolean var_182f = false;
	public static final String[] musicThemesStrings = { "main_theme", "bg_story", "bg_good", "bg_bad", "battle_good", "battle_bad", "victory", "gameover", "game_complete" };
	private static byte[] var_183f = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private static Player[] musicPlayers;
	private static Player currentMusicPlayer;
	private static boolean[] musicPlayersInitFlags;
	private static int currentMusicPlayerIndex;
	private static int var_1867;
	private static byte[][] var_186f;
	private static String[] resPakStrings;

	public C_MainCanvas(MIDlet paramMIDlet) {
		try {
			propDeveloperModeOn = "true".equalsIgnoreCase(Main.mainMIDlet
					.getAppProperty("Developer-Mode"));
		} catch (Exception localException1) {
			propDeveloperModeOn = false;
		}
		try {
			propDisableIntroOn = "true".equalsIgnoreCase(Main.mainMIDlet
					.getAppProperty("Disable-Intro"));
		} catch (Exception ex) {
			propDisableIntroOn = false;
		}
		try {
			setFPSOverride(Integer.parseInt(Main.mainMIDlet
					.getAppProperty("Override-FPS")));
		} catch (Exception localException3) {
			setFPSOverride(15);
		}
		try {
			setFullScreenMode(true);
			F_StringManager.mainCanvas = this;
			F_StringManager.loadLangDataFromFile("/lang.dat");
			canvasWidth = getWidth();
			canvasHeight = getHeight();
			C_MainCanvas.midletDisplay = Display.getDisplay(paramMIDlet);
			midletDisplay.setCurrent(this);
			new Thread(this).start();
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			showFatalError(ex.toString());
		}
	}

	public static final int getRandomMax(int max) {
		return getRandomWithin(0, max);
	}

	public static final int getRandomWithin(int min, int max) {
		return min + Math.abs(random.nextInt()) % (max - min);
	}

	public static final int getRandomNumber() {
		return random.nextInt();
	}

	public static final int getRandomArrayItemOrWhat(int[] paramArrayOfInt) {
		int number = paramArrayOfInt[(paramArrayOfInt.length - 1)];
		int randomNumber = getRandomWithin(0, number);
		for (int j = 0; j < paramArrayOfInt.length; j++) {
			if (randomNumber < paramArrayOfInt[j]) {
				return j;
			}
		}
		return -1;
	}

	public static final void sub_1abc(int[] paramArrayOfInt, boolean paramBoolean) {
		if (paramBoolean) {
			for (int i = 1; i < paramArrayOfInt.length; i++) {
				paramArrayOfInt[i] += paramArrayOfInt[(i - 1)];
			}
			return;
		}
		for (int i = paramArrayOfInt.length - 1; i > 0; i--) {
			paramArrayOfInt[i] -= paramArrayOfInt[(i - 1)];
		}
	}

	public static String streamToString(InputStream paramInputStream) {
		StringBuffer localStringBuffer = new StringBuffer();
		for (;;) {
			char c;
			try {
				c = (char) paramInputStream.read();
				if (c == 65535) {
					if (localStringBuffer.length() > 0) {
						return localStringBuffer.toString();
					}
					return null;
				}
				if (c == '\n') {
					return localStringBuffer.toString();
				}
				if (c != '\r') {
					localStringBuffer.append(c);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static String[] splitStringByChar(String paramString, char paramChar1) {
		Vector paramChar = new Vector();
		while (paramString.length() > 0) {
			int i;
			if ((i = paramString.indexOf(' ')) >= 0) {
				paramChar.addElement(paramString.substring(0, i));
				paramString = paramString.substring(i + 1);
			} else if (i == 0) {
				paramString = paramString.substring(1);
			} else {
				paramChar.addElement(paramString);
			}
		}
		String[] resParamString = new String[paramChar.size()];
		paramChar.copyInto(resParamString);
		return resParamString;
	}

	public static final byte[] getRecordData(String paramString, int paramInt) {

		try {
			RecordStore store = RecordStore
					.openRecordStore(paramString, false);
			byte[] bytes = store.getRecord(paramInt + 1);
			store.closeRecordStore();
			return bytes;
		} catch (Exception localException) {
			//
		}
		return null;
	}

	public static final void addSomeRecords(String paramString, int paramInt, byte[] paramArrayOfByte) {
		try {
			
			RecordStore store = RecordStore.openRecordStore(paramString, true);
			int i = store.getNumRecords();
			if (i <= paramInt) {
				while (i < paramInt) {
					store.addRecord(null, 0, 0);
					i++;
				}
				store.addRecord(paramArrayOfByte, 0, paramArrayOfByte.length);
			} else {
				store.setRecord(paramInt + 1, paramArrayOfByte, 0, paramArrayOfByte.length);
			}
			store.closeRecordStore();
			return;
		} catch (Exception localException) {
			//
		}
	}

	public static final int saveRecord(String paramString, byte[] paramArrayOfByte) {
		try {
			RecordStore store = RecordStore.openRecordStore(paramString, true);
			int res = store.addRecord(paramArrayOfByte, 0, paramArrayOfByte.length);
			store.closeRecordStore();
			return res - 1;
		} catch (Exception localException) {
			//
		}
		return -1;
	}

	public static final void deleteRecord(String paramString, int paramInt) {
		try {
			RecordStore store = RecordStore.openRecordStore(paramString, true);
			store.deleteRecord(paramInt + 1);
			store.closeRecordStore();
			return;
		} catch (Exception localException) {
			//
		}
	}

	public static final int getAvailableRecordSize(String paramString) {
		int size = 0;
		try {
			RecordStore store = RecordStore.openRecordStore(paramString, true);
			size = store.getSizeAvailable();
			store.closeRecordStore();
		} catch (Exception localException) {
			//
		}
		return size;
	}

	public static final int spriteTextWidth(byte spriteIndex, String paramString) {
		return sprites[spriteIndex].spriteFrameWidth * paramString.length();
	}

	public static final int spriteTextHeight(byte spriteIndex) {
		return sprites[spriteIndex].spriteFrameHeight;
	}

	public static final void setGraphicsColor(Graphics paramGraphics, int colorInt) {
		paramGraphics.setColor(colorInt);
	}

	public static final void sub_1edc(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
		for (int index = paramInt4 * paramInt5 - 1; index >= 0; index--) {
			var_180f[index] = paramInt1;
		}
		paramGraphics
				.drawRGB(var_180f, 0, paramInt4, 0, 0, paramInt4, paramInt5, true);
	}

	public final void showNotify() {
		setFullScreenMode(true);
		this.var_1817 = false;
		var_182f = false;
		sub_26ad();
		if (this.var_17b7 != null) {
			this.var_17b7.someUnknownMethod();
		}
	}

	public final void hideNotify() {
		sub_26ad();
		if (this.var_17b7 != null) {
			var_182f = true;
			if ((currentMusicPlayer != null) && (currentMusicPlayer.getState() == 400) && (var_183f[currentMusicPlayerIndex] == 1)) {
				var_181f = currentMusicPlayerIndex;
				var_1827 = var_1867;
			}
			stopCurrentMusicPlayer();
			this.var_1817 = false;
		}
	}

	public static final void sub_2007(Graphics gr, String msg, int inX, int inY, int spriteIndex, int paramInt4) {		
		if ((paramInt4 & 0x8) != 0) {
			inX -= spriteTextWidth((byte) spriteIndex, msg);
		} else if ((paramInt4 & 0x1) != 0) {
			inX -= spriteTextWidth((byte) spriteIndex, msg) / 2;
		}
		if ((paramInt4 & 0x20) != 0) {
			inY -= spriteTextHeight((byte) spriteIndex);
		} else if ((paramInt4 & 0x2) != 0) {
			inY -= spriteTextHeight((byte) spriteIndex) / 2;
		}
		drawAString(gr, msg, inX, inY, spriteIndex);
	}

	public static final void drawAString(Graphics gr, String str, int inX, int inY, int textSpriteIndex) {
		int charPos = 0;
		int strLength = str.length();
		while (charPos < strLength) {
			int aChar = str.charAt(charPos);
			if ((aChar >= var_1777[textSpriteIndex]) && (aChar <= var_177f[textSpriteIndex])) {
				int m = var_1787[textSpriteIndex][(aChar - var_1777[textSpriteIndex])];
				if (m  != -1) {
					sprites[textSpriteIndex].setCurrentFrameIndex(m);
					sprites[textSpriteIndex]
							.sub_1d20(gr, inX, inY);
					inX += sprites[textSpriteIndex].spriteFrameWidth;
				} else {
					byte[] localObject = { (byte) aChar };
					String localString = new String(localObject);
					gr
							.drawString((String) localString, inX, inY, 20);
					inX += gr.getFont()
							.stringWidth((String) localString);
				}
			}
			charPos++;
		}
	}

	public static final void showString(Graphics paramGraphics, String str, int paramInt1, int paramInt2, int paramInt3) {
		paramGraphics
				.drawString(str, paramInt1, paramInt2 - 2, paramInt3);
	}

	public static void setDisplayableAsCurrent(Displayable paramDisplayable) {
		midletDisplay.setCurrent(paramDisplayable);
	}

	public final void sub_220e(F_StringManager paramClass_f_0145) {
		sub_26ad();
		paramClass_f_0145.someUnknownMethod();
		this.var_17b7 = paramClass_f_0145;
	}

	public final void repaintAll() {
		repaint();
		serviceRepaints();
	}

	public final void paint(Graphics paramGraphics) {
		if (this.var_179f) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, canvasWidth, canvasHeight);
			paramGraphics.setFont(theFont);
			paramGraphics.setColor(0);
			paramGraphics
					.drawString(F_StringManager.getLangString(58), canvasWidth / 2, canvasHeight / 2 - 1, 33);
		} else {
			this.var_17b7.startLoading(paramGraphics);
		}
		if (propDeveloperModeOn) {
			paramGraphics.setFont(theFont);
			G_Game
					.sub_fdce(paramGraphics, this.fpsValue, 2, 2, 20, -1, 0);
		}
	}

	public final int getGameAction(int paramInt) {
		switch (paramInt) {
		case -11:
			return 0;
		case -7:
			return 2048;
		case -6:
			return 1024;
		case 35:
			return 8192;
		case 42:
			return 16384;
		case 48:
			return 32;
		case 49:
			return 64;
		case 50:
			return 1;
		case 51:
			return 128;
		case 52:
			return 4;
		case 53:
			return 16;
		case 54:
			return 8;
		case 55:
			return 256;
		case 56:
			return 2;
		case 57:
			return 512;
		}
		try {
			switch (super.getGameAction(paramInt)) {
			case 1:
				return 1;
			case 2:
				return 4;
			case 3:
			case 4:
			case 7:
			default:
				break;
			case 5:
				return 8;
			case 6:
				return 2;
			case 8:
				return 16;
			}
		} catch (Exception localException) {
			//
		}
		return 4096;
	}

	public final String getCodeKeyName(int paramInt) {
		int keyCode = 0;
		switch (paramInt) {
		case 1:
			keyCode = 50;
			break;
		case 2:
			keyCode = 56;
			break;
		case 4:
			keyCode = 52;
			break;
		case 8:
			keyCode = 54;
			break;
		case 16:
			keyCode = 53;
			break;
		case 32:
			keyCode = 48;
			break;
		case 64:
			keyCode = 49;
			break;
		case 128:
			keyCode = 51;
			break;
		case 256:
			keyCode = 55;
			break;
		case 512:
			keyCode = 57;
		}
		return super.getKeyName(keyCode);
	}

	public final boolean sub_2677() {
		return this.var_17cf != 0;
	}

	public final void sub_26ad() {
		this.gameActionCodeRunning = 0;
		this.var_17cf = 0;
		this.var_17d7 = 0;
	}

	public final boolean sub_26d7(int paramInt) {
		boolean bool = (this.var_17d7 & paramInt) != 0;
		this.var_17d7 &= (paramInt ^ 0xFFFFFFFF);
		return bool;
	}

	public final boolean sub_272b(int paramInt) {
		return (this.var_17cf & paramInt) != 0;
	}

	public final void keyPressed(int code) {
		runGameAction(getGameAction(code));
	}

	public final void keyReleased(int paramInt) {
		releaseGameAction(getGameAction(paramInt));
	}

	public final boolean isGameActionRunning(int code) {
		return (this.gameActionCodeRunning == code) && (System
				.currentTimeMillis() - this.gameActionStartTime >= 400L);
	}

	public final void runGameAction(int code) {
		this.gameActionCodeRunning = code;
		this.gameActionStartTime = System.currentTimeMillis();
		this.var_17cf |= code;
		this.var_17d7 |= code;
	}

	public final void releaseGameAction(int code) {
		if (code == this.gameActionCodeRunning) {
			this.gameActionCodeRunning = 0;
		}
		this.var_17cf &= (code ^ 0xFFFFFFFF);
	}

	private void showFatalError(String errorMsg) {
		this.isRunning = false;
		Form localForm = new Form("Fatal error!");
		localForm.append(errorMsg);
		Command command = new Command("Exit", 7, 1);
		localForm.addCommand(command);
		localForm.setCommandListener(this);
		midletDisplay.setCurrent(localForm);
	}

	public final void stopThread() {
		this.isRunning = false;
	}

	public static final void sub_28be() {
		sprites[0] = new G_Sprite("chars");
		sprites[1] = new G_Sprite("lchars");
	}

	public final void setFPSOverride(int fps) {
		if (fps <= 0)
			this.frameDelay = 0;
		else
			this.frameDelay = (1000 / fps);
	}

	public final void run() {
		try {
			repaintAll();
			var_1807 = new String[] { F_StringManager.getLangString(26), F_StringManager
					.getLangString(28), F_StringManager.getLangString(25), F_StringManager
					.getLangString(24) };
			G_Game localClass_g_1956 = new G_Game();
			repaintAll();
			this.var_17b7 = localClass_g_1956;
			this.var_179f = false;
			this.isRunning = true;
			localClass_g_1956.loadingProcess();
			var_180f = new int[canvasWidth * canvasHeight];
			long ticks = System.currentTimeMillis();
			int j = 0;
			while (this.isRunning) {
				long ticks2 = System.currentTimeMillis();
				if (isShown() && (!var_182f)) {
					if (var_181f >= 0) {
						playMusicLooped(var_181f, var_1827);
						if ((currentMusicPlayer != null) && (currentMusicPlayer
								.getState() == 400)) {
							var_181f = -1;
						}
					}
					this.var_17b7.paintScene();
					repaintAll();
				}
				if (propDeveloperModeOn) {
					int i = (int) (System.currentTimeMillis() - ticks);
					j++;
					if (i >= 1000) {
						this.fpsValue = Integer.toString(j * 1000 / i);
						ticks = System.currentTimeMillis();
						j = 0;
					}
				}
				int elapsed = (int) (System.currentTimeMillis() - ticks2);
				int extraDelay = this.frameDelay - elapsed;
				if (extraDelay > 0) {
					try {
						Thread.sleep(extraDelay);
					} catch (Exception ex) {
						//
					}
				}
			}
			if (Main.mainMIDlet != null) {
				Main.mainMIDlet.notifyDestroyed();
				Main.mainMIDlet.destroyApp(true);
			}
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
			showFatalError(ex.toString());
		}
	}

	public static final void sub_2af6(int paramInt) {
		try {
			if (settings[1] != false) {
				midletDisplay.vibrate(paramInt << 2);
			}
			return;
		} catch (Exception localException) {
			//
		}
	}

	public static final void createMusicPlayers() {
		musicPlayers = new Player[musicThemesStrings.length];
		musicPlayersInitFlags = new boolean[musicThemesStrings.length];
	}

	public static final void initMusicPlayer(int index) {
		try {
			musicPlayersInitFlags[index] = false;
			InputStream stream = getResourceStream(musicThemesStrings[index] + ".mid");
			musicPlayers[index] = Manager.createPlayer(stream, "audio/midi");
			musicPlayers[index].realize();
			musicPlayers[index].prefetch();
			musicPlayersInitFlags[index] = true;
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void sub_2bf1(int paramInt1, int paramInt2) {
		playMusicLooped(paramInt1, paramInt2);
	}

	public static final void stopCurrentMusicPlayer() {
		try {
			if (currentMusicPlayer != null) {
				currentMusicPlayer.stop();
				currentMusicPlayer = null;
				currentMusicPlayerIndex = -1;
			}
			return;
		} catch (Exception ex) {
			//
		}
	}

	public static final void playMusicLooped(int playerIndex, int playLoopCount) {
		try {
			if (musicPlayersInitFlags[playerIndex] == false) {
				return;
			}
			if (currentMusicPlayer != null) {
				currentMusicPlayer.stop();
			}
			if ((var_183f[playerIndex] == 1) && (settings[0] != false)) {
				if (playLoopCount == 0) {
					playLoopCount = -1;
				}
				if (var_182f) {
					var_181f = playerIndex;
					var_1827 = playLoopCount;
				} else {
					C_MainCanvas.currentMusicPlayer = musicPlayers[playerIndex];
					currentMusicPlayer.setLoopCount(playLoopCount);
					currentMusicPlayer.start();
					currentMusicPlayerIndex = playerIndex;
					var_1867 = playLoopCount;
				}
			} else {
				// ??
			}
		} catch (Exception ex) {
			//
		}
	}

	public static final void sub_2d32(int paramInt) {
		try {
			if (musicPlayersInitFlags[10] == false) {
				return;
			}
			if (currentMusicPlayer == musicPlayers[10]) {
				currentMusicPlayer.stop();
				currentMusicPlayer = null;
				currentMusicPlayerIndex = -1;
			}
			return;
		} catch (Exception localException) {
			//
		}
	}

	public static final void initResPak() {
		if (resPakStrings == null) {
			try {
				DataInputStream stream = new DataInputStream(Main.mainMIDlet
						.getClass().getResourceAsStream("/res.pak"));
				short i = stream.readShort();
				short streamLength = stream.readShort();
				resPakStrings = new String[streamLength];
				int[] arrayOfInt1 = new int[streamLength];
				int[] arrayOfInt2 = new int[streamLength];
				for (int k = 0; k < streamLength; k++) {
					resPakStrings[k] = stream.readUTF();
					arrayOfInt1[k] = (stream.readInt() + i);
					arrayOfInt2[k] = stream.readShort();
				}
				var_186f = new byte[resPakStrings.length][];
				for (int k = 0; k < resPakStrings.length; k++) {
					var_186f[k] = new byte[arrayOfInt2[k]];
					stream.readFully(var_186f[k]);
				}
				stream.close();
				return;
			} catch (Exception localException) {
				//
			}
		}
	}

	public static final byte[] getResourceString(String resId) {
		if (resPakStrings != null) {
			for (int i = 0; i < resPakStrings.length; i++) {
				if (resId.equals(resPakStrings[i])) {
					return var_186f[i];
				}
			}
		}
		try {
			InputStream stream = Main.mainMIDlet.getClass()
					.getResourceAsStream("/res/" + resId);
			if (stream != null) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int j;
				while ((j = stream.read()) >= 0) {
					baos.write(j);
				}
				stream.close();
				byte[] bytes = baos.toByteArray();
				baos.close();
				return bytes;
			}
		} catch (IOException localIOException) {
			//
		}
		return null;
	}

	public static final InputStream getResourceStream(String resId) {
		if (resPakStrings != null) {
			for (int i = 0; i < resPakStrings.length; i++) {
				if (resId.equals(resPakStrings[i])) {
					return new ByteArrayInputStream(var_186f[i]);
				}
			}
		}
		return Main.mainMIDlet.getClass().getResourceAsStream("/res/" + resId);
	}

	public final void commandAction(Command paramCommand, Displayable paramDisplayable) {
		Main.mainMIDlet.notifyDestroyed();
	}

	static {
		someFontHeight = someFont.getHeight();
		/*//@todo
		someFont.getBaselinePosition();
		someFontHeight = someFont.getHeight();
		var_1777 = new short[] { 45, 43 };
		var_177f = new short[] { 57, 57 };
		var_1787 = new byte[][] { { 10, 11, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 12, -1, 11, -1, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
		sprites = new G_Sprite[2];
		*/
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_c_0282
 * 
 * JD-Core Version: 0.7.0.1
 */