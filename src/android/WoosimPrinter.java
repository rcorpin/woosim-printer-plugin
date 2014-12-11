package com.rcorpin.woosimprinter;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import com.woosim.bt.WoosimPrinter;

public class WoosimPrinter extends CordovaPlugin {
	public static final String ACTION_PRINT_TEST = "printTest";
	public WoosimPrinter woosim;
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_PRINT_TEST.equals(action)) {
				woosim.saveSpool(EUC_KR, "Cordova Plugin Test", 0, false);
				woosim.printSpool(true);
				callbackContext.success();
	            return true;
			}
			callbackContext.error("Invalid action");
	    	return false;
		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage());
		    return false;
		}
	}
}
