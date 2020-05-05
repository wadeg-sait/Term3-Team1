let data = [];
console.log("Loading JS FIle")
const reversebtn = document.querySelector('#btn');
const search = document.querySelector('#search');
const addBtn = document.querySelector('#addButton');
const form = document.querySelector('#customers');
const submit = document.querySelector('#submit');
const cancel = document.querySelector('#cancel');

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
			postPut(this);
		});

		const del = document.createElement('button');
		del.innerText = 'DELETE';
		del.classList.add('btn');
		del.classList.add('btn-danger');
		del.classList.add('btn-block');
		const delCell = document.createElement('td');
		delCell.appendChild(del);
		del.addEventListener('click', function() {
			deleteBookings(row.bookingId);
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

cancel.addEventListener('click', function() {
	console.log('add code to clear form and colapse form');
});

function deleteCustomers(num) {
	const delReq = new XMLHttpRequest();
	delReq.addEventListener('load', function() {
		getData();
	});

	delReq.addEventListener('error', () => {
		console.log('ERROR!!!!!!');
	});
	delReq.open('DELETE', 'http://localhost:8080/TravelExpert/webapi/customers/deleteCustomer/' + num);
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
