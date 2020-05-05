console.log("test");

let data = [];

const reversebtn = document.querySelector('#btn');
const search = document.querySelector('#search');
const addBtn = document.querySelector('#addButton');
const form = document.querySelector('#booking');
const submit = document.querySelector('#submit');
const cancel = document.querySelector('#cancel');
const table = document.querySelector('#bookingData');
const hideShow = document.querySelector('#hideshow');
const formTitle = document.querySelector('#formTitle');
const inpBookingId = document.querySelector('#bkid');
const inpBookingNum = document.querySelector('#bknm');
const inpTravelerCount = document.querySelector('#trcnt');
const inpcustomerId = document.querySelector('#csid');
const inptripTypeId = document.querySelector('#trid');
const inppackageId = document.querySelector('#pkid');
const error = document.querySelector('#error');

window.addEventListener('load', function() {
	getData();
});

function getData() {
	const getReq = new XMLHttpRequest();

	getReq.addEventListener('load', function() {
		console.log('IT WORKED!!!');
		clearTableRow();
		data = JSON.parse(this.responseText);
		tableData(data);
	});

	getReq.addEventListener('error', () => {
		console.log('ERROR!!!!!!');
	});

	getReq.open('GET', 'http://localhost:8080/Workshop7-1/rs/bookings/getbookings');
	getReq.send();
}

function tableData(result) {
	const table = document.querySelector('#bookingData');

	for (let row of result) {
		const dataRow = document.createElement('tr');
		const bookingIDCell = document.createElement('td');
		bookingIDCell.innerText = row.bookingId;
		/*const bookingDateCell = document.createElement('td');
		bookingDateCell.innerText = row.bookingDate;*/
		const bookigNumCell = document.createElement('td');
		bookigNumCell.innerText = row.bookingNo;
		const travlerCountCell = document.createElement('td');
		travlerCountCell.innerText = row.travelerCount;
		const customerIdCell = document.createElement('td');
		customerIdCell.innerText = row.customerId;
		const tripTypeIdCell = document.createElement('td');
		tripTypeIdCell.innerText = row.tripTypeId;
		const packageIdCell = document.createElement('td');
		if (row.packageId == 0) {
			packageIdCell.innerText = 'No Package Selected';
		} else {
			packageIdCell.innerText = row.packageId;
		}

		const edit = document.createElement('button');
		edit.classList.add('btn');
		edit.classList.add('btn-outline-dark');
		edit.classList.add('font-weight-bold');
		edit.classList.add('btn-block');
		edit.innerText = 'EDIT';
		const editCell = document.createElement('td');
		editCell.appendChild(edit);

		edit.addEventListener('click', function() {
			error.innerText = '';
			form.classList.remove('collapse');
			hideShow.classList.add('collapse');
			inpBookingId.value = row.bookingId;
			inpBookingNum.value = row.bookingNo;
			inpTravelerCount.value = row.travelerCount;
			inpcustomerId.value = row.customerId;
			inptripTypeId.value = row.tripTypeId;
			inppackageId.value = row.packageId;
			formTitle.innerText = `EDITING BOOKINGS FOR BOOKING ID ${row.bookingId}`;

			
		});

		const del = document.createElement('button');
		del.innerText = 'DELETE';
		del.classList.add('btn');
		del.classList.add('btn-outline-danger');
		del.classList.add('font-weight-bold');
		del.classList.add('btn-block');
		const delCell = document.createElement('td');
		delCell.appendChild(del);
		del.addEventListener('click', function() {
			deleteBookings(row.bookingId);
			search.value = '';
		});

		dataRow.append(
			bookingIDCell,
			bookigNumCell,
			travlerCountCell,
			customerIdCell,
			tripTypeIdCell,
			packageIdCell,
			editCell,
			delCell
		);

		table.append(dataRow);
	}
}
console.log("Zoha");
function formCollpase() {
	form.classList.add('collapse');
}

addBtn.addEventListener('click', function() {
	form.classList.remove('collapse');
	hideShow.classList.add('collapse');
	inpBookingId.value = Math.max(data[data.length - 1].bookingId + 1, data[0].bookingId + 1);
	formTitle.innerText = 'ADD NEW BOOKING';
});

submit.addEventListener('click', () => {
	
	if (
			inpBookingId.value == '' ||
			inpBookingNum.value == '' ||
			inpTravelerCount.value == '' ||
			inpcustomerId.value == '' ||
			inptripTypeId.value == '' ||
			inppackageId.value == ''
		) {
			error.innerText = 'All fields required as an input';
			return;
		}

		if (inptripTypeId.value.length > 1) {
			error.innerText = 'Trip Type ID must be single charcter';
			return;
		}

		if (inpcustomerId.value < 1 || inppackageId.value < 1) {
			error.innerText = 'Customer ID and Package ID must be positive Integer';
			return;
		}
		
		console.log("zoha");
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
	formdata.bookingId = parseInt(inpBookingId.value);
	formdata.bookingNo = inpBookingNum.value;
	formdata.travelerCount = parseFloat(inpTravelerCount.value);
	formdata.customerId = parseInt(inpcustomerId.value);
	formdata.tripTypeId = inptripTypeId.value;
	formdata.packageId = parseInt(inppackageId.value);
	console.log(formdata);
	if (formTitle.innerText == 'ADD NEW BOOKING') {
		addBookings(formdata);
	} else {
		updateBookings(formdata);
	}
}

function addBookings(addData) {
	const xhr = new XMLHttpRequest();
	const params = addData;
	console.log(' i ma here for test');
	console.log(params);
	xhr.open('POST', 'http://localhost:8080/Workshop7-1/rs/bookings/postBooking');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(params));
	xhr.onload = () => {
		getData();
		clearTableRow();
		tableData(data.reverse());
		console.log(xhr.responseText);
	};
}

function updateBookings(updateData) {
	const xhr = new XMLHttpRequest();
	const params = updateData;
	console.log(' i ma here for update');
	console.log(params);
	xhr.open('PUT', 'http://localhost:8080/Workshop7-1/rs/bookings/updateBooking');
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(params));
	xhr.onload = () => {
		getData();
		clearTableRow();
		tableData(data.reverse());
		console.log(xhr.responseText);
	};
}


function formClear() {
	inpBookingId.value = '';
	inpBookingNum.value = '';
	inpTravelerCount.value = '';
	inpcustomerId.value = '';
	inpcustomerId.value = '';
	inptripTypeId.value = '';
	inppackageId.value = '';
}


function postPut(btn) {
	if (btn.innerText == 'Add Booking') {
		console.log('Exceute  POST');
	} else {
		console.log('Execute Update');
	}
}

function deleteBookings(num) {
	const delReq = new XMLHttpRequest();
	delReq.addEventListener('load', function() {
		if (delReq.responseText == 'Booking deleted') {
			getData();
		}
	});

	delReq.addEventListener('error', () => {
		console.log('ERROR!!!!!!');
	});
	delReq.open('DELETE', 'http://localhost:8080/Workshop7-1/rs/bookings/deleteBooking/' + num);
	delReq.send();
}

reversebtn.addEventListener('click', function() {
	clearTableRow();
	tableData(data.reverse());
});

function clearTableRow() {
	var table = document.getElementById('bookingData');

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
				item.customerId == search.value ||
				item.bookingId == search.value ||
				item.packageId == search.value ||
				item.bookingNo == search.value
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
