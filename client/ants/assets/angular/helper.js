var passParameter = function(paramenter, value, defaultUrl) {
	var url = defaultUrl,
	injectPoint = '{' + paramenter + '}'

	return url.replace(injectPoint, value)
}


var currentDate = new Date(),
timeZoneOffSet = currentDate.getTimezoneOffset(),
changeUTCToCurrentTimeZone = function(timeInDigitValue) {
	return moment(timeInDigitValue).zone(timeZoneOffSet).format('YYYY-MM-DD HH:mm')
},
changeCurrentTimeZoneToUTC = function(timeInString) {
	return moment(timeInString).zone(timeZoneOffSet).toDate().getTime()
},
buildURL = function(gold) {
	return host + gold
}