package com.rcorpin.woosimPrinter;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class WoosimPrinter extends CordovaPlugin {
	public static final String ACTION_PRINT_TEST = "printTest";

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
	}
	
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_PRINT_TEST.equals(action)) {
				callbackContext.success();
	            return true;
			}
			callbackContext.error("Invalid action");
	    	return false;
		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage() + ": " + action);
		    return false;
		}
	}
}
