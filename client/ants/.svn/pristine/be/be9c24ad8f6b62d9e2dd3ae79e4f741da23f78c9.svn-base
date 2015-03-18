var inDeverlopment = true
var mode = "ColectionTransactionController"

function Logger(header) {
	return {
		info : logInfo,
		showObject: showObject
	}

	function logInfo(value) {
		if (couldLog(header)) {
			console.log("Info from " + header + ": \n\t" + value)
		}
	}
	
	function showObject(object) {
		if (couldLog(header)) {
			console.log(object)
		}
	}

	function couldLog(header) {
		if (inDeverlopment == false) {
			return false
		}

		if (mode === "all" || mode === header) {
			return true
		} else {
			return false
		}
	}
}
