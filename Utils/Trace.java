/*
Copyright 2018 Phil May
This file is part of N2KLib
N2KLib is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
N2KLib is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with N2KLib.  If not, see <https://www.gnu.org/licenses/>.
*/
package com.santacruzinstruments.scicalibrator.nmea2000.N2KLib.Utils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

import timber.log.Timber;

public final class Trace
{
  static String[] classes = new String[]{}; //"ActisenseTransport"};
  static public int level = 4;
  static public String[] fileList = {};
  static public boolean reclist = false;
  static BufferedOutputStream trcFile = null;
  static BufferedOutputStream logFile = null;

  static private void prtln(String txt)
  {
    Timber.d("%014d %s", System.currentTimeMillis(), txt);
  }

  static private void prtln(String txt, String txt2)
  {
    Timber.d("%014d %s: %s\n", System.currentTimeMillis(), txt, txt2);
  }

  static public void debug(String txt)
  {
    if ((level < 1) && testClass())
    {
      prtln(txt);
    }
  }

  static public void normal(String txt)
  {
    if ((level < 2) && testClass())
    {
      prtln(txt);
    }
  }

  static public void alert(String txt)
  {
    if (level < 3)
    {
      prtln(txt);
    }
  }

  static public void msg(String txt)
  {
    if (level < 4)
    {
      prtln(txt);
    }
  }

  static public void error(String txt)
  {
    if (level < 5)
    {
      prtln(txt);
    }
    log(txt);
  }

  static private String hexdata(String txt, byte[] bytes, int off, int length)
  {
    byte[] rcvdata = Arrays.copyOfRange(bytes, off, off + length);
    StringBuffer sb = new StringBuffer();
    for( int i = 0; i< length; i++){
      sb.append(String.format("%02X ", bytes[i]));
    }
    prtln(txt, sb.toString());
    return(sb.toString());
  }

  static public void hexdbg(String txt, byte[] bytes, int off, int length)
  {
    if ((level < 1) && testClass())
    {
      hexdata(txt, bytes, off, length);
    }
  }
  static public void hex(String txt, byte[] bytes, int off, int length)
  {
    if ((level < 2) && testClass())
    {
      hexdata(txt, bytes, off, length);
    }
  }
  static public void hexalt(String txt, byte[] bytes, int off, int length)
  {
    if (level < 3)
    {
      hexdata(txt, bytes, off, length);
    }
  }
  static public void hexerr(String txt, byte[] bytes, int off, int length)
  {
    String hextxt = hexdata(txt, bytes, off, length);
    log(txt + ": " + hextxt);
  }

  public static boolean testClass()
  {
    boolean ok = true;
    if (classes.length > 0)
    {
      StackTraceElement[] el = Thread.currentThread().getStackTrace();
      //Trace.alert("Elements 3: " + el[3].getClassName());
      ok = false;
      for (String cl : classes)
      {
        if (el[3].getClassName().contains(cl))
        {
          ok = true;
        }
      }
    }
    return(ok);
  }

  public static void stack(Exception ex, String context)
  {
    StackTraceElement[] el = ex.getStackTrace();
    Trace.error(context);
    log(context);
    Trace.error(ex.toString());
    log(ex.toString());
    for (StackTraceElement e : el)
    {
      Trace.error(e.toString());
      log(e.toString());
    }
    ex.printStackTrace();
  }

  public static void log(String logtext)
  {
    try
    {
      if (logFile == null)
      {
        logFile = new BufferedOutputStream(new FileOutputStream(Utils.getHomePath() +"errors.txt"));
      }
      logFile.write(logtext.getBytes());
    }
    catch (Exception ex)
    {
      Trace.error("Failed to write to log file " + ex.getStackTrace());
    }
  }
}
