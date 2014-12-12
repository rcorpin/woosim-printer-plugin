var woosimPrinter = {
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