package aeii;

import javax.microedition.midlet.MIDlet;

public class Main extends MIDlet {
	
	public static Main mainMIDlet;
	private static Class_c_MainCanvas mainCanvas;

	public final void startApp() {
		if (mainMIDlet == null) {
			mainMIDlet = this;
			mainCanvas = new Class_c_MainCanvas(this);
		}
	}

	public final void destroyApp(boolean paramBoolean) {
		if (mainCanvas != null) {
			mainCanvas.stopThread();
		}
		mainCanvas = null;
		mainMIDlet = null;
	}

	public final void pauseApp() {
		//
	}
}

/*
 * Location: C:\Users\DevInCube\Desktop\deob\
 * 
 * Qualified Name: aeii.Main
 * 
 * JD-Core Version: 0.7.0.1
 */