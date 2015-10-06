function namevalidate(e) {
	if (e.which) {
		keynum = e.which;
	}
	keychar = String.fromCharCode(keynum);
	numcheck = /\d/;
	return !numcheck.test(keychar);
}

function selectCountry() {
	var str = "<select name='city' id='city'><option>-Select City-</option><option";
	if (document.getElementById("state").value == "Rajasthan") {
		document.getElementById("city").innerHTML = str
				+ "Jaipur</option><option>Jodhpur</option><option>Udaipur</option><option>Kota</option></select>";
	} else if (document.getElementById("state").value == "Madhya Pradesh") {
		document.getElementById("city").innerHTML = str
				+ "Bhopal</option><option>Gwalior</option><option>Indore</option><option>Ratlam</option></select>";
	} else if (document.getElementById("state").value == "Maharashtra") {
		document.getElementById("city").innerHTML = str
				+ "Mumbai</option><option>Pune</option><option>Nagpur</option><option>Thane</option></select>";
	} else {
		document.getElementById("city").innerHTML = str
				+ "Ahmedabad</option><option>Rajkot</option><option>Baroda</option><option>Surat</option></select>";
	}
}

function checkCondition() {
	if (document.getElementById("condition").checked == true) {
		document.getElementById("create").disabled = false;
	} else {
		document.getElementById("create").disabled = true;
	}
}

function validateComplete() {
	var age_value = document.getElementById('age').value;
	var filter = /^[0-9]+(.[0-9]{1,2})?$/;

	if (document.getElementById('firstName').value == "") {
		alert("Enter First Name");
		document.form.first_Name.focus();
		return false;
	} else if (document.getElementById('lastName').value == "") {
		alert("Enter Last Name");
		document.form.last_Name.focus();
		return false;
	} else if (document.getElementById('pwd').value == "") {
		alert("Enter password");
		document.form.password.focus();
		return false;
	} else if (document.getElementById('pwd').value.length <= 7) {
		alert("Password length should be greater than 8");
		document.form.password.focus();
		return false;
	} else if (document.getElementById('confirm_pwd').value == "") {
		alert("Enter password to confirm");
		document.form.confirmPassword.focus();
		return false;
	} else if (document.getElementById('pwd').value != document
			.getElementById('confirm_pwd').value) {
		alert("Re-entered Password is not matching ,please enter correct password");
		document.form.confirmPassword.focus();
		return false;
	} else if (document.getElementById('age').value == "") {
		alert("Enter age");
		document.form.age.focus();
		return false;
	} else if (!filter.test(age_value)) {
		alert('Please provide a valid age');
		return false;
	} else if (document.getElementById("create").disabled == true) {
		alert("Accept all the condition");
		document.getElementById('create').focus();
		return false;
	} else {
		alert("User Created Successfully");
		return true;
	}

}
