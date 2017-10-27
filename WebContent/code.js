function callAjax(param, executer) {
	$.ajax({
		url : "AjaxServlet",
		data : param,
		success : function(data) {
			executer(data);
		},
		fail : function(data) {

		}
	});
}
$("body").on("click", ".deletebutton", function() {
	var id = $(this).attr("cityid");
	var target = $(this).parent().parent();
	callAjax({
		method : "deleteCity",
		cityId : id
	}, function(data) {
		if (data == "1") {
			target.remove();
		} else {

		}
	});
});
$("body").on(
		"click",
		".editbutton",
		function() {
			/*
			 * $(this).parent().siblings("td:nth-child(2)").children(
			 * ".citynamebox").show();
			 * $(this).parent().siblings("td:nth-child(2)").children(".cityname")
			 * .hide(); $(this).siblings(".updatebutton").show();
			 * $(this).siblings(".cancelbutton").show(); $(this).hide();
			 */
			$(".updatebutton").hide();
			$(".cancelbutton").hide();
			$(".editbutton").show();
			$(".citynamebox").hide();
			$(".cityname").show();
			$(this).parent().siblings("td:nth-child(2)").children(
					".citynamebox").show();
			$(this).parent().siblings(".containsName").children(".cityname")
					.hide();
			$(this).siblings(".updatebutton").show();
			$(this).siblings(".cancelbutton").show();
			$(this).hide();
		});
$("body").on(
		"click",
		".cancelbutton",
		function() {
			$(this).parent().siblings("td:nth-child(2)").children(
					".citynamebox").hide();
			$(this).parent().siblings("td:nth-child(2)").children(".cityname")
					.show();
			$(this).siblings(".updatebutton").hide();
			$(this).siblings(".editbutton").show();
			$(this).hide();
			var ctname = $(this).parent().siblings("td:nth-child(2)").children(
					".cityname").text();
			$(this).parent().siblings("td:nth-child(2)").children(
					".citynamebox").val(ctname);
		});
$("body").on(
		"click",
		".updatebutton",
		function() {
			var id = $(this).attr("cityid");
			var ctname = $(this).parent().siblings("td:nth-child(2)").children(
					".citynamebox").val();
			var target = $(this).parent().siblings("td:nth-child(2)").children(
					".cityname");
			var me = $(this);
			callAjax({
				method : "updateCity",
				cityId : id,
				cityName : ctname
			}, function(data) {
				if (data == "1") {
					target.text(ctname);
					target.show();
					me.hide();
					me.siblings(".cancelbutton").hide();
					me.siblings(".editbutton").show();
					target.siblings(".citynamebox").hide();
				} else {

				}
			});
		});