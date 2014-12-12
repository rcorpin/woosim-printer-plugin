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
	public static final String ACTION_CHECK_CONNECTION = "checkConnection";
	public static final String ACTION_CONNECT_BT = "connectBt";
	public static final String ACTION_PRINT_TEST = "printTest";

	private String isConnected;
	private WoosimPrinter woosim;

	private final static String EUC_KR = "EUC-KR";

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
	    woosim = new WoosimPrinter();
	    isConnected = "false";
	}
	
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		try {
			if (ACTION_CHECK_CONNECTION.equals(action)) {
				callbackContext.success(isConnected);
				return true;
			} else if (ACTION_CONNECT_BT.equals(action)) {
				JSONObject arg_object = args.getJSONObject(0);
				String bt_mac_addr = arg_object.getString("bt_mac_addr");
				int ret = woosim.BTConnection(bt_mac_addr, false);
				if (ret == 1) {
					isConnected = "true";
				}
				callbackContext.success(ret);
				return true;
			} else if (ACTION_PRINT_TEST.equals(action)) {
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
