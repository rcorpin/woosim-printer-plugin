woosim-printer-plugin
=====================

Cordova plugin for Woosim BT printer


How To:

Add to cordova project:
	- cordova plugins remove com.rcorpin.woosimPrinter 

Remove from cordova project:
	- cordova plugins add https://github.com/rcorpin/woosim-printer-plugin.git

In Javascript:
	- just call the plugin commands

Commands:
	woosimPrinter.connectBt(bt_mac_addr, successCallback, errorCallback);
		bt_mac_addr: MAC address of the Woosim BT Printer
	woosimPrinter.print(successCallback, errorCallback);