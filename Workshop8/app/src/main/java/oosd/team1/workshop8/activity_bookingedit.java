package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_bookingedit extends AppCompatActivity {
    EditText editBookingId, editBookingNo,editTravelerCount, editCustomerId, editTripTypeId,editPackageId;
    Button editBooking,saveEditBooking,cancelEditBooking, deleteBooking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingedit);

        editBookingId=(EditText)findViewById(R.id.txtEditBookingID);
        editBookingNo=(EditText)findViewById(R.id.txtEditBookingNo);
        editTravelerCount=(EditText)findViewById((R.id.txtEditTravellerCount));
        editCustomerId=(EditText)findViewById(R.id.txtEditCustomerId);
        editTripTypeId=(EditText)findViewById(R.id.txtEditTripTypeId);
        editPackageId=(EditText)findViewById((R.id.txtEditPackageId));
        editBooking=(Button)findViewById(R.id.btnEditBooking);
        saveEditBooking=(Button)findViewById(R.id.btnSaveEditBooking);
        cancelEditBooking=(Button)findViewById(R.id.btnCancelEditBooking);
        deleteBooking=(Button)findViewById(R.id.btnDeleteBooking);

        saveEditBooking.setVisibility(View.INVISIBLE);
        cancelEditBooking.setVisibility(View.INVISIBLE);

        editBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editBookingId.setFocusable(true);
                editBookingNo.setFocusable(true);
                editTravelerCount.setFocusable(true);
                editCustomerId.setFocusable(true);
                editTripTypeId.setFocusable(true);
                editPackageId.setFocusable(true);
                editBookingId.setClickable(true);
                editBookingNo.setClickable(true);
                editTravelerCount.setClickable(true);
                editCustomerId.setClickable(true);
                editTripTypeId.setClickable(true);
                editPackageId.setClickable(true);
                editBooking.setVisibility(View.INVISIBLE);
                deleteBooking.setVisibility(View.INVISIBLE);
                saveEditBooking.setVisibility(View.VISIBLE);
                cancelEditBooking.setVisibility(View.VISIBLE);



            }
        });

        saveEditBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        cancelEditBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelbookingEdit();

            }
        });

        deleteBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelbookingEdit();
            }
        });

    }

    public void cancelbookingEdit(){
        Intent intent=new Intent(this,activity_bookingslist.class);
        startActivity(intent);


    }
}
