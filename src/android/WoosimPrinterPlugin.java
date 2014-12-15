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
	public static final String ACTION_PRINT_JSON_ARRAY = "printJsonArray";

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
			} else if  (ACTION_PRINT_JSON_ARRAY.equals(action)) {
				for (int index=0; index<args.length(); index++){
					JSONObject arg_object = args.getJSONObject(index);
					Log.d("Saving to spool -- charset: ", arg_object.getString("charset"), " data: ",arg_object.getString("data"), " fontValue: ", arg_object.getInt("fontValue"), " emphasis: ", arg_object.getBoolean("emphasis"));
					woosim.saveSpool(arg_object.getString("charset"), arg_object.getString("data"), arg_object.getInt("fontValue"), arg_object.getBoolean("emphasis"));
				}

				int ret = woosim.printSpool(true);
				callbackContext.success(ret);
	            return true;
			} else if (ACTION_PRINT_TEST.equals(action)) {
				woosim.saveSpool(EUC_KR, " Dr. Green Invoice\r\n\r\n\r\n", 0x11, true);
				woosim.saveSpool(EUC_KR, "MERCHANT NAME     woosim coffee\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "MASTER            Gil-dong Hong\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "ADDRESS   #501, Daerung Techno\r\n          town3rd 448,Gasan-dong\r\n          Gumcheon-gu, Seoul\r\n          Korea\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "HELP DESK      (+82-2)2107-3721\r\n", 0, false);

				woosim.saveSpool(EUC_KR, "--------------------------------\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "Product       Sale       Price\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "--------------------------------\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "Cafe mocha      2         7.5$\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "Cafe latte      1         7.0$\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "Cappuccino      1         7.5$\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "--------------------------------\r\n", 0, false);
				woosim.saveSpool(EUC_KR, "Total                    29.5$\r\n", 0, false);

				woosim.saveSpool(EUC_KR, "--------------------------------\r\n", 0, false);
				byte[] lf = {0x0a};
				woosim.controlCommand(lf, lf.length);
				woosim.controlCommand(lf, lf.length);
				woosim.controlCommand(lf, lf.length);
				byte[] ff ={0x0c};
				woosim.controlCommand(ff, 1);
				
				int ret = woosim.printSpool(true);
				callbackContext.success(ret);
	            return true;
			} else {}
			callbackContext.error("Invalid action");
	    	return false;
		} catch(Exception e) {
		    System.err.println("Exception: " + e.getMessage());
		    callbackContext.error(e.getMessage() + ": " + action);
		    return false;
		}
	}
}
