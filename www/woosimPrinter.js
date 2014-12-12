var woosimPrinter = {
	checkConnection: function(successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'checkConnection',
			[]
		);
	},
	connectBt: function(bt_mac_addr, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'connectBt',
			[{
				"bt_mac_addr": bt_mac_addr
			}]
		);
	},
	printTest: function(successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'printTest',
			[]
		);
	},
	printArray: function(jsonArrayToBePrinted, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'printJsonArray',
			jsonArrayToBePrinted
		);
	}
}

module.exports = woosimPrinter;