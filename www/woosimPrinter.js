var woosimPrinter = {
	printTest: function(successCallback, errorCallback) {
		cordova.exec(
			successCallback,
			errorCallback,
			'WoosimPrinter',
			'printTest',
			[]
		);
	}
}

module.export = woosimPrinter;