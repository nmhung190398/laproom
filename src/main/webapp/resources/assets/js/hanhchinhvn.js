$(document).ready(function() {
	var tinh_tp;
	$.getJSON("../dist/tinh_tp.json", function(json) {
    	tinh_tp = json;
    	console.log(json);
	});
});