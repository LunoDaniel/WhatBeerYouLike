$(function(){	
	$("td > button").click(function(e){
		var beerId = this.getAttribute('beer-id');
		var action = $("#form-delete").attr("action");
		action += beerId;
		$("#form-delete").attr("action", action);
	});
});