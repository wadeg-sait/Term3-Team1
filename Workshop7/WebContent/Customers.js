let data = [];
console.log("Loading JS FIle")
const reversebtn = document.querySelector('#btn');
const search = document.querySelector('#search');
const addBtn = document.querySelector('#addButton');
const form = document.querySelector('#customers');
const submit = document.querySelector('#submit');
const cancel = document.querySelector('#cancel');
const table = document.querySelector('#customerData');
const hideShow = document.querySelector('#hideshow');
const formTitle = document.querySelector('#formTitle');
const inpCustomerId = document.querySelector('#csid');
const inpCustFirstName = document.querySelector('#cfn');
const inpCustLastName = document.querySelector('#cln');
const inpCustAddress = document.querySelector('#cad');
const inpCustCity = document.querySelector('#cct');
const inpCustHomePhone = document.querySelector('#chp');
const inpCustEmail = document.querySelector('#cem');
const error = document.querySelector('#error');

window.addEventListener('load', function() {
	getData();
});

function getData() {
	const getReq = new XMLHttpRequest();

	getReq.addEventListener('load', function() {
		console.log('IT WORKED!!!');
		data = JSON.parse(this.responseText);
		tableData(data);
	});

	getReq.addEventListener('error', () => {
		console.log('ERROR!!!!!!');
	});

	getReq.open('GET', 'http://localhost:8080/Workshop7-1/rs/customers/getCustomers');
	getReq.send();
}

function tableData(result) {
	const table = document.querySelector('#customerData');

	for (let row of result) {
		const dataRow = document.createElement('tr');
		const customerIdCell = document.createElement('td');
		customerIdCell.innerText = row.customerId;
		const custFirstNameCell = document.createElement('td');
		custFirstNameCell.innerText = row.custFirstName;
		const custLastNameCell = document.createElement('td');
		custLastNameCell.innerText = row.custLastName;
		const custAddressCell = document.createElement('td');
		custAddressCell.innerText = row.custAddress;
		const custCityCell = document.createElement('td');
		custCityCell.innerText = row.custCity;
		const custHomePhoneCell = document.createElement('td');
		custHomePhoneCell.innerText = row.custHomePhone;
		const custEmailCell = document.createElement('td');
		custEmailCell.innerText = row.custEmail;

		const edit = document.createElement('button');
		edit.classList.add('btn');
		edit.classList.add('btn-primary');
		edit.classList.add('btn-block');
		edit.innerText = 'EDIT';
		const editCell = document.createElement('td');
		editCell.appendChild(edit);

		edit.addEventListener('click', function() {
			error.innerText = '';
			//form.classList.remove('collapse');
			hideShow.classList.add('collapse');
			inpCustomerId.value = row.customerId;
			inpCustFirstName.value = row.custFirstName;
			inpCustLastName.value = row.custLastName;
			inpCustAddress.value = row.custAddress;
			inpCustCity.value = row.custCity;
			inpCustHomePhone.value = row.custHomePhone;
			inpCustEmail.value = row.custEmai;;
			formTitle.innerText = `EDITING CUSTOMERS FOR CUSTOMER ID ${row.customerId}`;
			
		});

		const del = document.createElement('button');
		del.innerText = 'DELETE';
		del.classList.add('btn');
		del.classList.add('btn-danger');
		del.classList.add('btn-block');
		const delCell = document.createElement('td');
		delCell.appendChild(del);
		del.addEventListener('click', function() {
			deleteCustomers(row.customerId);
			search.value = '';
		});

		dataRow.append(
			customerIdCell,
			custFirstNameCell,
			custLastNameCell,
			custAddressCell,
			custCityCell,
			custHomePhoneCell,
			custEmailCell,
			editCell,
			delCell
		);

		table.append(dataRow);
	}
}

addBtn.addEventListener('click', function() {
	postPut(this);
});

function postPut(btn) {
	if (btn.innerText == 'Danger') {
		console.log('Exceute  POST');
	} else {
		console.log('Execute Update');
	}
}

function formCollpase() {
	form.classList.add('collapse');
}

addBtn.addEventListener('click', function() {
	form.classList.remove('collapse');
	hideShow.classList.add('collapse');
	inpCustomerId.value = Math.max(data[data.length - 1].customerId + 1, data[0].customerId + 1);
	formTitle.innerText = 'ADD NEW CUSTOMER';
});

submit.addEventListener('click', () => {
	
	if (
			inpCustomerId.value == '' ||
			inpCustFirstName.value == '' ||
			inpCustLastName.value == '' ||
			inpCustAddress.value == '' ||
			inpCustCity.value == '' ||
			inpCustHomePhone.value == '' ||
			inpCustEmail.value == ''
		) {
			error.innerText = 'All fields required as an input';
			return;
		}

		
		
		console.log("muhammad");
	formDataCapture();
	formClear();
	hideShow.classList.remove('collapse');
	formCollpase();
	clearTableRow();
	getData();
	error.innerText = '';
});

cancel.addEventListener('click', function() {
	formClear();
	formCollpase();
	hideShow.classList.remove('collapse');
});


function formDataCapture() {
	const formdata = {};
	formdata.customerId = parseInt(inpCustomerId.value);
	formdata.custFirstName = inpCustFirstName.value;
	formdata.custLastName = inpCustLastName.value;
	formdata.custAddress = inpCustAddress.value;
	formdata.custCity = inpCustCity.value;
	formdata.custHomePhone = inpCustHomePhone.value;
	formdata.custEmail = inpCustEmail.value;
	console.log(formdata);
	if (formTitle.innerText == 'ADD NEW CUSTOMER') {
		addCustomers(formdata);
	} else {
		updateCustomers(formdata);
	}
}

function addCustomers(addData) {
	const xhr = new XMLHttpRequest();
	const params = addData;
	console.log(' i ma here for test');
	console.log(params);
	xhr.open('POST', 'http://localhost:8080/Workshop7-1/rs/customers/postCustomers');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(params));
	xhr.onload = () => {
		getData();
		clearTableRow();
		tableData(data.reverse());
		console.log(xhr.responseText);
	};
}


function updateCustomers(updateData) {
	const xhr = new XMLHttpRequest();
	const params = updateData;
	console.log(' i ma here for update');
	console.log(params);
	xhr.open('PUT', 'http://localhost:8080/Workshop7-1/rs/customers/updateCustomers');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(params));
	xhr.onload = () => {
		getData();
		clearTableRow();
		tableData(data.reverse());
		console.log(xhr.responseText);
	};
}

function deleteCustomers(num) {
	const delReq = new XMLHttpRequest();
	delReq.addEventListener('load', function() {
		getData();
	});

	delReq.addEventListener('error', () => {
		console.log('ERROR!!!!!!');
	});
	delReq.open('DELETE', 'http://localhost:8080/Workshop7-1/customers/deleteCustomer/' + num);
	delReq.send();
}

reversebtn.addEventListener('click', function() {
	clearTableRow();
	tableData(data.reverse());
});

function clearTableRow() {
	var table = document.getElementById('customerData');

	while (table.rows.length > 1) {
		table.deleteRow(1);
	}
}

search.addEventListener('input', function() {
	liveSearch();
});

function liveSearch() {
	if (search.value.length != 0) {
		const dataCopy = data.slice();
		clearTableRow();
		const result = dataCopy.filter(function(item) {
			if (
				item.customerId == search.value
			) {
				return item;
			}
		});

		if (result.length != 0) {
			tableData(result);
		} else {
			console.log('no Recrd found');
		}
	} else {
		tableData(data);
	}
}

function formClear() {
	inpCustomerId.value = '';
	inpCustFirstName.value = '';
	inpCustLastName.value = '';
	inpCustAddress.value = '';
	inpCustCity.value = '';
	inpCustHomePhone.value = '';
	inpCustEmail.value = '';
}