console.log("woosim-printer-plugin initialized");

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

module.exports = woosimPrinter;