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
	connectBt: function(btMacAddr, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'connectBt',
			[{
				"btMacAddr": btMacAddr
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
	printJsonArray: function(jsonArrayToBePrinted, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'printJsonArray',
			jsonArrayToBePrinted
		);
	},
	saveSpool: function(jsonArrayToBePrinted, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'saveSpool',
			jsonArrayToBePrinted
		);
	},
	printSpool: function(printBool, successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'printSpool',
			[{
				"printBool": printBool
			}]
		);
	},
	clearSpool: function(successCallback, errorCallback){
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'clearSpool',
			[]
		);
	},
	printImage: function(fileLocation, successCallback, errorCallback){
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'printImage',
			[{
				"fileLocation": fileLocation
			}]
		);
	}
}

module.exports = woosimPrinter;