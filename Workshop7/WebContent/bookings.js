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
const inpBookingId = document.querySelector('#bkid');
const formTitle = document.querySelector('#formTitle');

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

	getReq.open('GET', 'http://localhost:8080/Workshop7-1/rs/bookings');
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
		edit.classList.add('btn-primary');
		edit.classList.add('btn-block');
		edit.innerText = 'EDIT';
		const editCell = document.createElement('td');
		editCell.appendChild(edit);

		edit.addEventListener('click', function() {
			form.classList.remove('collapse');
			hideShow.classList.add('collapse');

			submit.addEventListener('click', () => {
				console.log(' have to put put method // update table');
				hideShow.classList.remove('collapse');
				formCollpase();
			});

			cancel.addEventListener('click', function() {
				hideShow.classList.remove('collapse');
				formCollpase();
			});
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
	inpBookingId.value = data[data.length - 1].bookingId + 1;
	formTitle.innerText = 'ADD NEW BOOKING';


	submit.addEventListener('click', () => {
		console.log(' have to put post method // update table');
		hideShow.classList.remove('collapse');
		formCollpase();
	});

	cancel.addEventListener('click', function() {
		formCollpase();
		hideShow.classList.remove('collapse');
	});
});

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
