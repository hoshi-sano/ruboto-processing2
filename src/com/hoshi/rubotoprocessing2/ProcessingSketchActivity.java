package com.hoshi.rubotoprocessing2;

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.io.IOException;
import org.ruboto.Script;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

public class ProcessingSketchActivity extends PApplet implements org.ruboto.RubotoComponent {

  static final public boolean DEBUG = true;
  protected boolean availableSetup = false;
  protected boolean availableDraw = false;
  protected boolean availableKeyPressed = false;
  protected boolean availableKeyReleased = false;
  protected boolean availableMousePressed = false;
  protected boolean availableMouseReleased = false;
  protected boolean availableMouseClicked = false;
  protected boolean availableMouseDragged = false;
  protected boolean availableMouseMoved = false;
  protected boolean availableMouseEntered = false;
  protected boolean availableMouseExited = false;

  private final org.ruboto.ScriptInfo scriptInfo = new org.ruboto.ScriptInfo();
  public org.ruboto.ScriptInfo getScriptInfo() {
      return scriptInfo;
  }

  public void onCreate(android.os.Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (org.ruboto.JRubyAdapter.isInitialized()); {
      getScriptInfo().setFromIntent(getIntent());
      org.ruboto.ScriptLoader.loadScript(this);

      String rubyClassName = scriptInfo.getRubyClassName();
      String scriptBase = ".private_instance_methods(false).any?{|m| m.to_sym == ";

      availableSetup = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_setup}");
      availableDraw = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_draw}");
      availableKeyPressed = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_key_pressed}");
      availableKeyReleased = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_key_released}");
      availableMousePressed = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_pressed}");
      availableMouseReleased = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_released}");
      availableMouseClicked = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_clicked}");
      availableMouseDragged = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_dragged}");
      availableMouseMoved = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_moved}");
      availableMouseEntered = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_entered}");
      availableMouseExited = (Boolean)org.ruboto.JRubyAdapter.runScriptlet(rubyClassName + scriptBase + ":_mouse_exited}");
    };
    return;
  }

  public void setup() {
    if (availableSetup) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_setup");
    }
  }

  public void draw() {
    if (availableDraw) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_draw");
    }
  }

  public void keyPressed() {
    if (availableKeyPressed) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_key_pressed");
    }
  }

  public void keyReleased() {
    if (availableKeyReleased) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_key_released");
    }
  }

  public void mousePressed() {
    if (availableMousePressed) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_pressed");
    }
  }

  public void mouseReleased() {
    if (availableMouseReleased) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_released");
    }
  }

  public void mouseClicked() {
    if (availableMouseClicked) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_clicked");
    }
  }

  public void mouseDragged() {
    if (availableMouseDragged) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_dragged");
    }
  }

  public void mouseMoved() {
    if (availableMouseMoved) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_moved");
    }
  }

  public void mouseEntered() {
    if (availableMouseEntered) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_entered");
    }
  }

  public void mouseExited() {
    if (availableMouseExited) {
      org.ruboto.JRubyAdapter.runRubyMethod(scriptInfo.getRubyInstance(), "send", "_mouse_exited");
    }
  }
}
