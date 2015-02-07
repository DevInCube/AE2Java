package aeii;

import javax.microedition.midlet.MIDlet;

public class Main
  extends MIDlet
{
  public static Main var_11b;
  private static Class_c_0282 var_123;
  
  public final void startApp()
  {
    if (var_11b == null)
    {
      var_11b = this;
      var_123 = new Class_c_0282(this);
    }
  }
  
  public final void destroyApp(boolean paramBoolean)
  {
    if (var_123 != null) {
      var_123.sub_289e();
    }
    var_123 = null;
    var_11b = null;
  }
  
  public final void pauseApp() {}
}


/* Location:           C:\Users\DevInCube\Desktop\deob\
 * Qualified Name:     aeii.Main
 * JD-Core Version:    0.7.0.1
 */