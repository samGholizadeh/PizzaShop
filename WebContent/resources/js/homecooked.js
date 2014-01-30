$(document).ready(function(e) {
	
	$(".remove").click(function(){
		var orderId = $(this).closest("tr").attr("id");
		$("#"+orderId).remove();
		$.ajax({
			type: "POST",
			url: "",
			data: {
				"action" : "removeOrder",
				"orderId" : orderId
			},
			success: function(){
				alert("Callback function");
				$("#"+orderId).remove();
			}
		});
	});
	
	$(".delivered").click(function(){
		var orderId = $(this).closest("tr").attr("id");
		$(this).remove();
		$.ajax({
			type: "POST",
			url: "",
			data: {
				"action" : "changeOrderStatus",
				"orderId" : orderId
			},
			success: function(){
				$("#"+orderId).attr("class", "success");
			}
		});
	});
});