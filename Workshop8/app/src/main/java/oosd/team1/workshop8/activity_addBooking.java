package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.BufferUnderflowException;

public class activity_addBooking extends AppCompatActivity {
    EditText bookingId,bookingNo,travelerCount,customerId,tripTypeId,packageId;
    Button addBookingSave,cancelAddBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_booking);

         bookingId = (EditText)findViewById(R.id.txtBookingID);
         bookingNo= (EditText)findViewById(R.id.txtBookingNo);
         travelerCount=(EditText)findViewById(R.id.txtTravellerCount);
         customerId=(EditText)findViewById(R.id.txtCustomerId);
         tripTypeId=(EditText)findViewById(R.id.txtTripTypeId);
         packageId=(EditText)findViewById(R.id.txtPackageId);

         addBookingSave=(Button)findViewById(R.id.btnSaveAddBooking);
         cancelAddBooking=(Button)findViewById(R.id.btnCancelBooking);


         cancelAddBooking.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cancelbookingAdd();

             }
         });

         addBookingSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });



    }

    public void cancelbookingAdd(){
        Intent intent=new Intent(this,activity_bookingslist.class);
        startActivity(intent);


    }
}
