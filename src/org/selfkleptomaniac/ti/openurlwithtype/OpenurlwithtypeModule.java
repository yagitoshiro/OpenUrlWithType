/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package org.selfkleptomaniac.ti.openurlwithtype;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;

import android.net.Uri;
import android.content.Intent;
import android.content.ActivityNotFoundException;

@Kroll.module(name="Openurlwithtype", id="org.selfkleptomaniac.ti.openurlwithtype")
public class OpenurlwithtypeModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "OpenurlwithtypeModule";
	private static final boolean DBG = TiConfig.LOGD;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public OpenurlwithtypeModule(TiContext tiContext) {
		super(tiContext);
	}

	// Methods
	@Kroll.method
	public String example() {
		Log.d(LCAT, "example called");
		return "hello world";
	}
	
	// Properties
	@Kroll.getProperty
	public String getExampleProp() {
		Log.d(LCAT, "get example property");
		return "hello world";
	}
	
	
	@Kroll.setProperty
	public void setExampleProp(String value) {
		Log.d(LCAT, "set example property: " + value);
	}

  @Kroll.method
  public boolean openUrlWithType(String url, String type) {
    Uri uri = Uri.parse(url);
    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
      intent.setDataAndType(uri, type);
      intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
      try {
        getTiContext().getActivity().startActivity(intent);
        return true;
      } catch (ActivityNotFoundException e) {
        Log.e(LCAT,"Activity not found: " + url, e);
        return false;
      }
   }
}
