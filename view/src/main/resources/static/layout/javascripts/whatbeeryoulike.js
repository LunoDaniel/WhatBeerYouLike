$(function(){	
	$("td > button").click(function(e){
		var beerId = this.getAttribute('item-id');
		var action = $("#form-delete").attr("action");
		action += beerId;
		$("#form-delete").attr("action", action);
	});
});