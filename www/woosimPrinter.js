var woosimPrinter = {
	checkConnection: function(successCallback, errorCallback){
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinterPlugin',
			'checkConnection',
			[]
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