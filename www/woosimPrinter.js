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
	}
}

module.exports = woosimPrinter;