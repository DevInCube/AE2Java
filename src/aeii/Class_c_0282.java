package aeii;

import a.a.a.Class_g_2517;
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

public final class Class_c_0282 extends Canvas implements Runnable,
		CommandListener {
	public static boolean var_173f;
	public static boolean var_1747;
	public static final Font var_174f = Font.getFont(0, 1, 8);
	public static Font var_1757;
	public static int var_175f;
	public static final int var_1767 = (Class_c_0282.var_175f = (Class_c_0282.var_1757 = Font
			.getFont(0, 1, 8)).getBaselinePosition()) + 6;
	public static final int var_176f;
	private static short[] var_1777;
	private static short[] var_177f;
	private static byte[][] var_1787;
	private static Display var_178f;
	private boolean var_1797 = false;
	private boolean var_179f = true;
	private int var_17a7;
	private String var_17af = "";
	public Class_f_0145 var_17b7;
	public static int var_17bf;
	public static int var_17c7;
	private int var_17cf = 0;
	private int var_17d7;
	private int var_17df = 0;
	private long var_17e7;
	public static Class_g_2517[] var_17ef;
	public static Random var_17f7 = new Random();
	public static boolean[] var_17ff = { true, true, true, true };
	public static String[] var_1807;
	private static int[] var_180f;
	private boolean var_1817 = false;
	private static int var_181f = -1;
	private static int var_1827;
	private static boolean var_182f = false;
	public static final String[] var_1837 = { "main_theme", "bg_story",
			"bg_good", "bg_bad", "battle_good", "battle_bad", "victory",
			"gameover", "game_complete" };
	private static byte[] var_183f = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	private static Player[] var_1847;
	private static Player var_184f;
	private static boolean[] var_1857;
	private static int var_185f;
	private static int var_1867;
	private static byte[][] var_186f;
	private static String[] var_1877;

	public Class_c_0282(MIDlet paramMIDlet) {
		try {
			var_173f = "true".equalsIgnoreCase(Main.var_11b
					.getAppProperty("Developer-Mode"));
		} catch (Exception localException1) {
			var_173f = false;
		}
		try {
			var_1747 = "true".equalsIgnoreCase(Main.var_11b
					.getAppProperty("Disable-Intro"));
		} catch (Exception localException2) {
			var_1747 = false;
		}
		try {
			sub_28f5(Integer.parseInt(Main.var_11b
					.getAppProperty("Override-FPS")));
		} catch (Exception localException3) {
			sub_28f5(15);
		}
		try {
			setFullScreenMode(true);
			Class_f_0145.var_743 = this;
			Class_f_0145.sub_b8d("/lang.dat");
			var_17bf = getWidth();
			var_17c7 = getHeight();
			(Class_c_0282.var_178f = Display.getDisplay(paramMIDlet))
					.setCurrent(this);
			new Thread(this).start();
			return;
		} catch (Exception localException4) {
			Exception ex;
			(ex = localException4).printStackTrace();
			sub_2850(ex.toString());
		}
	}

	public static final int sub_19e8(int paramInt) {
		return sub_1a08(0, paramInt);
	}

	public static final int sub_1a08(int paramInt1, int paramInt2) {
		return paramInt1 + Math.abs(var_17f7.nextInt())
				% (paramInt2 - paramInt1);
	}

	public static final int sub_1a32() {
		return var_17f7.nextInt();
	}

	public static final int sub_1a53(int[] paramArrayOfInt) {
		int i = paramArrayOfInt[(paramArrayOfInt.length - 1)];
		i = sub_1a08(0, i);
		for (int j = 0; j < paramArrayOfInt.length; j++) {
			if (i < paramArrayOfInt[j]) {
				return j;
			}
		}
		return -1;
	}

	public static final void sub_1abc(int[] paramArrayOfInt,
			boolean paramBoolean) {
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

	public static String sub_1b49(InputStream paramInputStream) {
		StringBuffer localStringBuffer = new StringBuffer();
		for (;;) {
			char c;
			try {
				if ((c = (char) paramInputStream.read()) == 65535) {
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

	public static String[] sub_1bda(String paramString, char paramChar1) {
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

	public static final byte[] sub_1c7e(String paramString, int paramInt) {

		try {
			RecordStore store = null;
			byte[] bytes = (store = RecordStore.openRecordStore(paramString,
					false)).getRecord(paramInt + 1);
			store.closeRecordStore();
			return bytes;
		} catch (Exception localException) {
		}
		return null;
	}

	public static final void sub_1ccb(String paramString, int paramInt,
			byte[] paramArrayOfByte) {
		try {
			int i;
			RecordStore store = null;
			if ((i = (store = RecordStore.openRecordStore(paramString, true))
					.getNumRecords()) <= paramInt) {
				while (i < paramInt) {
					store.addRecord(null, 0, 0);
					i++;
				}
				store.addRecord(paramArrayOfByte, 0, paramArrayOfByte.length);
			} else {
				store.setRecord(paramInt + 1, paramArrayOfByte, 0,
						paramArrayOfByte.length);
			}
			store.closeRecordStore();
			return;
		} catch (Exception localException) {
		}
	}

	public static final int sub_1d7e(String paramString, byte[] paramArrayOfByte) {
		try {
			RecordStore store = null;
			int res = (store = RecordStore.openRecordStore(paramString, true))
					.addRecord(paramArrayOfByte, 0, paramArrayOfByte.length);
			store.closeRecordStore();
			return res - 1;
		} catch (Exception localException) {
		}
		return -1;
	}

	public static final void sub_1dce(String paramString, int paramInt) {
		try {
			RecordStore store = null;
			(store = RecordStore.openRecordStore(paramString, true))
					.deleteRecord(paramInt + 1);
			store.closeRecordStore();
			return;
		} catch (Exception localException) {
		}
	}

	public static final int sub_1e19(String paramString) {
		int i = 0;
		try {
			RecordStore store = null;
			i = (store = RecordStore.openRecordStore(paramString, true))
					.getSizeAvailable();
			store.closeRecordStore();
		} catch (Exception localException) {
		}
		return i;
	}

	public static final int sub_1e71(byte paramByte, String paramString) {
		return var_17ef[paramByte].var_c20 * paramString.length();
	}

	public static final int sub_1e99(byte paramByte) {
		return var_17ef[paramByte].var_c28;
	}

	public static final void sub_1ebc(Graphics paramGraphics, int paramInt) {
		paramGraphics.setColor(paramInt);
	}

	public static final void sub_1edc(Graphics paramGraphics, int paramInt1,
			int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
		for (paramInt2 = paramInt4 * paramInt5 - 1; paramInt2 >= 0; paramInt2--) {
			var_180f[paramInt2] = paramInt1;
		}
		paramGraphics.drawRGB(var_180f, 0, paramInt4, 0, 0, paramInt4,
				paramInt5, true);
	}

	public final void showNotify() {
		setFullScreenMode(true);
		this.var_1817 = false;
		var_182f = false;
		sub_26ad();
		if (this.var_17b7 != null) {
			this.var_17b7.sub_7f2();
		}
	}

	public final void hideNotify() {
		sub_26ad();
		if (this.var_17b7 != null) {
			var_182f = true;
			if ((var_184f != null) && (var_184f.getState() == 400)
					&& (var_183f[var_185f] == 1)) {
				var_181f = var_185f;
				var_1827 = var_1867;
			}
			sub_2c11();
			this.var_1817 = false;
		}
	}

	public static final void sub_2007(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3,
			int paramInt4) {
		if ((paramInt4 & 0x8) != 0) {
			paramInt1 -= sub_1e71((byte) paramInt3, paramString);
		} else if ((paramInt4 & 0x1) != 0) {
			paramInt1 -= sub_1e71((byte) paramInt3, paramString) / 2;
		}
		if ((paramInt4 & 0x20) != 0) {
			paramInt2 -= sub_1e99((byte) paramInt3);
		} else if ((paramInt4 & 0x2) != 0) {
			paramInt2 -= sub_1e99((byte) paramInt3) / 2;
		}
		sub_20c1(paramGraphics, paramString, paramInt1, paramInt2, paramInt3);
	}

	public static final void sub_20c1(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3) {
		int i = 0;
		int j = paramString.length();
		while (i < j) {
			int k;
			if (((k = paramString.charAt(i)) >= var_1777[paramInt3])
					&& (k <= var_177f[paramInt3])) {
				int m;
				if ((m = var_1787[paramInt3][(k - var_1777[paramInt3])]) != -1) {
					var_17ef[paramInt3].sub_1afa(m);
					var_17ef[paramInt3].sub_1d20(paramGraphics, paramInt1,
							paramInt2);
					paramInt1 += var_17ef[paramInt3].var_c20;
				} else {
					byte[] localObject = { (byte) k };
					String localString = new String((byte[]) localObject);
					paramGraphics.drawString((String) localString, paramInt1,
							paramInt2, 20);
					paramInt1 += paramGraphics.getFont().stringWidth(
							(String) localString);
				}
			}
			i++;
		}
	}

	public static final void sub_21c6(Graphics paramGraphics,
			String paramString, int paramInt1, int paramInt2, int paramInt3) {
		paramGraphics.drawString(paramString, paramInt1, paramInt2 - 2,
				paramInt3);
	}

	public static void sub_21ec(Displayable paramDisplayable) {
		var_178f.setCurrent(paramDisplayable);
	}

	public final void sub_220e(Class_f_0145 paramClass_f_0145) {
		sub_26ad();
		paramClass_f_0145.sub_7f2();
		this.var_17b7 = paramClass_f_0145;
	}

	public final void sub_2236() {
		repaint();
		serviceRepaints();
	}

	public final void paint(Graphics paramGraphics) {
		if (this.var_179f) {
			paramGraphics.setColor(16777215);
			paramGraphics.fillRect(0, 0, var_17bf, var_17c7);
			paramGraphics.setFont(var_1757);
			paramGraphics.setColor(0);
			paramGraphics.drawString(Class_f_0145.sub_c07(58), var_17bf / 2,
					var_17c7 / 2 - 1, 33);
		} else {
			this.var_17b7.sub_828(paramGraphics);
		}
		if (var_173f) {
			paramGraphics.setFont(var_1757);
			Class_g_1956
					.sub_fdce(paramGraphics, this.var_17af, 2, 2, 20, -1, 0);
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
		}
		return 4096;
	}

	public final String sub_251b(int paramInt) {
		int i = 0;
		switch (paramInt) {
		case 1:
			i = 50;
			break;
		case 2:
			i = 56;
			break;
		case 4:
			i = 52;
			break;
		case 8:
			i = 54;
			break;
		case 16:
			i = 53;
			break;
		case 32:
			i = 48;
			break;
		case 64:
			i = 49;
			break;
		case 128:
			i = 51;
			break;
		case 256:
			i = 55;
			break;
		case 512:
			i = 57;
		}
		return super.getKeyName(i);
	}

	public final void keyPressed(int paramInt) {
		paramInt = getGameAction(paramInt);
		sub_27cf(paramInt);
	}

	public final boolean sub_2677() {
		return this.var_17cf != 0;
	}

	public final void sub_26ad() {
		this.var_17df = 0;
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

	public final void keyReleased(int paramInt) {
		sub_280a(getGameAction(paramInt));
	}

	public final boolean sub_2788(int paramInt) {
		return (this.var_17df == paramInt)
				&& (System.currentTimeMillis() - this.var_17e7 >= 400L);
	}

	public final void sub_27cf(int paramInt) {
		this.var_17df = paramInt;
		this.var_17e7 = System.currentTimeMillis();
		this.var_17cf |= paramInt;
		this.var_17d7 |= paramInt;
	}

	public final void sub_280a(int paramInt) {
		if (paramInt == this.var_17df) {
			this.var_17df = 0;
		}
		this.var_17cf &= (paramInt ^ 0xFFFFFFFF);
	}

	private void sub_2850(String paramString) {
		this.var_1797 = false;
		Form localForm;
		(localForm = new Form("Fatal error!")).append(paramString);
		Command command = new Command("Exit", 7, 1);
		localForm.addCommand(command);
		localForm.setCommandListener(this);
		var_178f.setCurrent(localForm);
	}

	public final void sub_289e() {
		this.var_1797 = false;
	}

	public static final void sub_28be() {
		var_17ef[0] = new Class_g_2517("chars");
		var_17ef[1] = new Class_g_2517("lchars");
	}

	public final void sub_28f5(int paramInt) {
		if (paramInt <= 0) {
			this.var_17a7 = 0;
			return;
		}
		this.var_17a7 = (1000 / paramInt);
	}

	public final void run() {
		try {
			sub_2236();
			var_1807 = new String[] { Class_f_0145.sub_c07(26),
					Class_f_0145.sub_c07(28), Class_f_0145.sub_c07(25),
					Class_f_0145.sub_c07(24) };
			Class_g_1956 localClass_g_1956 = new Class_g_1956();
			sub_2236();
			this.var_17b7 = localClass_g_1956;
			this.var_179f = false;
			this.var_1797 = true;
			localClass_g_1956.sub_5531();
			var_180f = new int[var_17bf * var_17c7];
			long l1 = System.currentTimeMillis();
			int j = 0;
			while (this.var_1797) {
				long l2 = System.currentTimeMillis();
				if ((isShown()) && (!var_182f)) {
					if (var_181f >= 0) {
						sub_2c63(var_181f, var_1827);
						if ((var_184f != null) && (var_184f.getState() == 400)) {
							var_181f = -1;
						}
					}
					this.var_17b7.sub_80d();
					sub_2236();
				}
				if (var_173f) {
					int i = (int) (System.currentTimeMillis() - l1);
					j++;
					if (i >= 1000) {
						this.var_17af = Integer.toString(j * 1000 / i);
						l1 = System.currentTimeMillis();
						j = 0;
					}
				}
				int i = (int) (System.currentTimeMillis() - l2);
				if ((i = this.var_17a7 - i) > 0) {
					try {
						Thread.sleep(i);
					} catch (Exception localException2) {
					}
				}
			}
			if (Main.var_11b != null) {
				Main.var_11b.notifyDestroyed();
				Main.var_11b.destroyApp(true);
			}
			return;
		} catch (Exception localException3) {
			Exception localException1;
			(localException1 = localException3).printStackTrace();
			sub_2850(localException1.toString());
		}
	}

	public static final void sub_2af6(int paramInt) {
		try {
			if (var_17ff[1] != false) {
				var_178f.vibrate(paramInt << 2);
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2b46() {
		var_1847 = new Player[var_1837.length];
		var_1857 = new boolean[var_1837.length];
	}

	public static final void sub_2b74(int paramInt) {
		try {
			var_1857[paramInt] = false;
			InputStream localInputStream = sub_2fb7(var_1837[paramInt] + ".mid");
			var_1847[paramInt] = Manager.createPlayer(localInputStream,
					"audio/midi");
			var_1847[paramInt].realize();
			var_1847[paramInt].prefetch();
			var_1857[paramInt] = true;
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2bf1(int paramInt1, int paramInt2) {
		sub_2c63(paramInt1, paramInt2);
	}

	public static final void sub_2c11() {
		try {
			if (var_184f != null) {
				var_184f.stop();
				var_184f = null;
				var_185f = -1;
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2c63(int paramInt1, int paramInt2) {
		try {
			if (var_1857[paramInt1] == false) {
				return;
			}
			if (var_184f != null) {
				var_184f.stop();
			}
			if ((var_183f[paramInt1] == 1) && (var_17ff[0] != false)) {
				if (paramInt2 == 0) {
					paramInt2 = -1;
				}
				if (var_182f) {
					var_181f = paramInt1;
					var_1827 = paramInt2;
				} else {
					(Class_c_0282.var_184f = var_1847[paramInt1])
							.setLoopCount(paramInt2);
					var_184f.start();
					var_185f = paramInt1;
					var_1867 = paramInt2;
				}
			} else {
			}
		} catch (Exception localException) {
		}
	}

	public static final void sub_2d32(int paramInt) {
		try {
			if (var_1857[10] == false) {
				return;
			}
			if (var_184f == var_1847[10]) {
				var_184f.stop();
				var_184f = null;
				var_185f = -1;
			}
			return;
		} catch (Exception localException) {
		}
	}

	public static final void sub_2da5() {
		if (var_1877 == null) {
			try {
				DataInputStream localDataInputStream;
				int i = (localDataInputStream = new DataInputStream(
						Main.var_11b.getClass().getResourceAsStream("/res.pak")))
						.readShort();
				int j;
				var_1877 = new String[j = localDataInputStream.readShort()];
				int[] arrayOfInt1 = new int[j];
				int[] arrayOfInt2 = new int[j];
				for (int k = 0; k < j; k++) {
					var_1877[k] = localDataInputStream.readUTF();
					arrayOfInt1[k] = (localDataInputStream.readInt() + i);
					arrayOfInt2[k] = localDataInputStream.readShort();
				}
				var_186f = new byte[var_1877.length][];
				for (int k = 0; k < var_1877.length; k++) {
					var_186f[k] = new byte[arrayOfInt2[k]];
					localDataInputStream.readFully(var_186f[k]);
				}
				localDataInputStream.close();
				return;
			} catch (Exception localException) {
			}
		}
	}

	public static final byte[] sub_2ebf(String paramString) {
		if (var_1877 != null) {
			for (int i = 0; i < var_1877.length; i++) {
				if (paramString.equals(var_1877[i])) {
					return var_186f[i];
				}
			}
		}
		try {
			Object localObject;
			if ((localObject = Main.var_11b.getClass().getResourceAsStream(
					"/res/" + paramString)) != null) {
				ByteArrayOutputStream baos = (ByteArrayOutputStream) new ByteArrayOutputStream();
				int j;
				while ((j = ((InputStream) localObject).read()) >= 0) {
					baos.write(j);
				}
				((InputStream) localObject).close();
				byte[] bytes = baos.toByteArray();
				baos.close();
				return bytes;
			}
		} catch (IOException localIOException) {
		}
		return null;
	}

	public static final InputStream sub_2fb7(String paramString) {
		if (var_1877 != null) {
			for (int i = 0; i < var_1877.length; i++) {
				if (paramString.equals(var_1877[i])) {
					return new ByteArrayInputStream(var_186f[i]);
				}
			}
		}
		return Main.var_11b.getClass().getResourceAsStream(
				"/res/" + paramString);
	}

	public final void commandAction(Command paramCommand,
			Displayable paramDisplayable) {
		Main.var_11b.notifyDestroyed();
	}

	static {
		var_174f.getBaselinePosition();
		var_176f = var_174f.getHeight();
		var_1777 = new short[] { 45, 43 };
		var_177f = new short[] { 57, 57 };
		var_1787 = new byte[][] { { 10, 11, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 12, -1, 11, -1, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
		var_17ef = new Class_g_2517[2];
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Class_c_0282
 * 
 * JD-Core Version: 0.7.0.1
 */