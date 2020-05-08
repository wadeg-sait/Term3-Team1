package oosd.team1.workshop8;
//  zoha ahmed code
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

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
        Intent intent = getIntent();
        Bookings  b = (Bookings) intent.getSerializableExtra("booking");
        editBookingId.setText(String.valueOf(b.getBookingId()));
        editBookingNo.setText(b.getBookingNo());
        editTravelerCount.setText((String.valueOf(b.getTravelerCount())));
        editCustomerId.setText(String.valueOf(b.getCustomerId()));
        editTripTypeId.setText(b.getTripTypeId());
        editPackageId.setText(String.valueOf(b.getPackageId()));


        editBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editBookingNo.setFocusable(true);
                editTravelerCount.setFocusable(true);
                editCustomerId.setFocusable(true);
                editTripTypeId.setFocusable(true);
                editPackageId.setFocusable(true);
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
// editing booking
        saveEditBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editPackageId.getText().toString().matches("" )|| editBookingNo.getText().toString().matches("" )|| editTripTypeId.getText().toString().matches("" )
                ||editTravelerCount.getText().toString().matches("" )||editCustomerId.getText().toString().matches("" )){
                    Toast.makeText(getApplicationContext(), "All fields are required as an input", Toast.LENGTH_LONG).show();
                    return;
                }

                if (Integer.parseInt(editCustomerId.getText().toString()) <=0 || Integer.parseInt(editPackageId.getText().toString())<=0){
                    Toast.makeText(getApplicationContext(), "Customer ID and Package ID must be greater than 0", Toast.LENGTH_LONG).show();
                    return;
                }

                if (editTripTypeId.getText().length()>1){
                    Toast.makeText(getApplicationContext(), "Trip Type Id  must be a single character", Toast.LENGTH_LONG).show();
                    return;
                }

                JSONObject json = new JSONObject();
                try {

                    json.put("bookingId", Integer.parseInt(editBookingId.getText().toString()));
                    json.put( "bookingNo", editBookingNo.getText());
                    json.put("travelerCount", Double.parseDouble(editTravelerCount.getText().toString()));
                    json.put("customerId",Integer.parseInt(editCustomerId.getText().toString()));
                    json.put("tripTypeId",editTripTypeId.getText());
                    json.put("packageId", Integer.parseInt(editPackageId.getText().toString()));
                    System.out.println(json);
                    editBookingSave(json);
                    Toast.makeText(getApplicationContext(), "BooKing Updated", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    cancelbookingEdit();

                } catch (JSONException e) {
                    e.printStackTrace();
                }


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
                BookingDelete(Integer.parseInt(String.valueOf(editBookingId.getText())));
                Toast.makeText(getApplicationContext(),"Booking deleted", Toast.LENGTH_LONG).show();
                cancelbookingEdit();
            }
        });

    }
// deleteing booking
    private void  BookingDelete(int bookingId) {
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/bookings/deleteBooking/" + bookingId;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void editBookingSave(JSONObject data) {
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/bookings/updateBooking";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void cancelbookingEdit(){
        Intent intent=new Intent(this,activity_bookingslist.class);
        startActivity(intent);


    }
}
