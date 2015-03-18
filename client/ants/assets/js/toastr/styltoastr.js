/**
 * 
 */
var stylToast = {
	success : function success(msg) {
		Notify(msg, 'bottom-right', '5000', 'success', 'fa-edit', true);
	},
	fail : function fail(msg) {
		Notify(msg, 'bottom-right', '5000', 'danger', 'fa-edit', true);
	},
	warring : function warring(msg) {
		Notify(msg, 'bottom-right', '5000', 'warring', 'fa-edit', true);
	}
}
