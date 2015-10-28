function show() {
				var showValue=document.getElementById('input');
				showValue.innerHTML="My name is Deepali";
			}
			function hide() {
				var showValue=document.getElementById('input');
				showValue.innerHTML="";
			}
			function showOrHide() {
				var showValue=document.getElementById('input');
				if (showValue.innerHTML.length == 0)
					showValue.innerHTML="My name is Deepali";
				else
					showValue.innerHTML="";
			}