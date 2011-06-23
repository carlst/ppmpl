/* 
 * PayPal Mobile Payment Library - JavaScript-Java bridge
 *
 * Copyright (C) 2011, Appception, Inc.. All Rights Reserved.
 */
package com.ppmpl;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.paypal.android.MEP.PayPal;

// N.B. activity directly intercepts (PayPal) button click
public class ppmpl extends Activity {
    WebView webview;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	// Set WebView layout
	webview = new WebView(this);
	webview.getSettings().setJavaScriptEnabled(true);
	setContentView(webview);

	webview.loadUrl("file:///android_asset/www/index.html");

	// Add JSMPL library
	webview.addJavascriptInterface(new mpl(this, PayPal.ENV_NONE, ""), "mpl");
    }
}
