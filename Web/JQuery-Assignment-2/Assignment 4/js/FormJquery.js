//To display data in empty div
	$( document ).ready(function() {
		$("#name").keyup(function(){
			var storeText = $('#name').val();
			$('#content').text('Name :'+ storeText);
		});
	});
		
//To display data in empty div
	$( document ).ready(function() {
		$("#age").keyup(function(){
			var storeText = $('#age').val();
			$('#content').text('Age :'+storeText);
		});
	});
		
//To display data in empty div
	$( document ).ready(function() {
		$("#address").keyup(function(){
			var storeText = $('#address').val();
			$('#content').text('Address :'+storeText);
		});
	});
		
// function to highlight and change background for a few milliseconds
	$( document ).ready(function() {
		$("#name").click(function () {
			var $el = $("#name");
			$el.css("background", "yellow");
			setTimeout(function () {
				$el.css("background", "white");
					}, 2000);
			});
			
	$("#age").click(function () {
		var $el = $("#age");
		$el.css("background", "yellow");
		setTimeout(function () {
			$el.css("background", "white");
					}, 2000);
			});
			
	$("#address").click(function () {
		var $el = $("#address");
		$el.css("background", "yellow");
		setTimeout(function () {
			$el.css("background", "white");
				}, 2000);
		});
	});