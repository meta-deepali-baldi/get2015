$(document).ready(function() {
	$("button#start").click(function() {
		$("div#box").animate({
			left : '+=400'
		}, 'slow', 'swing');
	});

	$("button#back").click(function() {
		$("div#box").animate({
			left : '-=400'
		}, 'slow', 'linear');
	});

	$("button#stop").click(function() {
		$("div#box").animate().stop();
	});

	$("button#top").click(function() {
		$("div#box").animate({
			top : '-=50'
		}, 'slow', 'swing');
	});

	$("button#left").click(function() {
		$("div#box").animate({
			left : '-=50'
		}, 'slow', 'swing');
	});

	$("button#right").click(function() {
		$("div#box").animate({
			left : '+=50'
		}, 'slow', 'swing');
	});

	$("button#bottom").click(function() {
		$("div#box").animate({
			top : '+=50'
		}, 'slow', 'swing');
	});
});