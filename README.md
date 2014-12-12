woosim-printer-plugin
=====================

Cordova plugin for Woosim BT printer

Still in progress; as of now, printTest can be called to print a sample receipt


## How To:

### Add to cordova project:
	cordova plugins add https://github.com/rcorpin/woosim-printer-plugin.git

### Remove from cordova project:
	cordova plugins remove com.rcorpin.woosimPrinter 

### Using the plugin in Javascript:
	No need to instantiate anything, just call the Commands.

### Commands:
	* woosimPrinter.connectBt(bt_mac_addr, successCallback, errorCallback);
	  - bt_mac_addr: MAC address of the Woosim BT Printer

	* woosimPrinter.printTest(successCallback, errorCallback);