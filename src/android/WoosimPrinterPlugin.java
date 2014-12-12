package com.rcorpin.woosimPrinter;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.woosim.bt.WoosimPrinter;
public class WoosimPrinterPlugin extends CordovaPlugin {
	public static final String ACTION_PRINT_TEST = "printTest";
	private WoosimPrinter woosim;

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
	    woosim = new WoosimPrinter();
	}
	
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_PRINT_TEST.equals(action)) {
				woosim.saveSpool(EUC_KR, "Woosim Printer Cordova Plugin", 0, false);
				woosim.printSpool(true);
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
