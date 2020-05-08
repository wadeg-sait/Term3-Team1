package oosd.team1.workshop8;
//zoha ahmed code
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
// zoha Ahmed code
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
         Intent intent= getIntent();
         final int bk= intent.getIntExtra(activity_bookingslist.EXTRA_NUMBER,0);
         bookingId.setText(String.valueOf(bk));
         System.out.println(bk+"zoha");



         cancelAddBooking.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 cancelbookingAdd();

             }
         });

         addBookingSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (packageId.getText().toString().matches("" )|| bookingNo.getText().toString().matches("" )|| tripTypeId.getText().toString().matches("" )
                         ||travelerCount.getText().toString().matches("" )||customerId.getText().toString().matches("" )){
                     Toast.makeText(getApplicationContext(), "All fields are required as an input", Toast.LENGTH_LONG).show();
                     return;
                 }

                 if (Integer.parseInt(customerId.getText().toString()) <=0 || Integer.parseInt(packageId.getText().toString())<=0){
                     Toast.makeText(getApplicationContext(), "Customer ID and Package ID must be greater than 0", Toast.LENGTH_LONG).show();
                     return;
                 }

                 if (tripTypeId.getText().length()>1){
                     Toast.makeText(getApplicationContext(), "Trip Type Id  must be a single character", Toast.LENGTH_LONG).show();
                     return;
                 }

                 JSONObject json = new JSONObject();
                 try {

                     json.put("bookingId",bk);
                     json.put( "bookingNo", bookingNo.getText());
                     json.put("travelerCount", Double.parseDouble(travelerCount.getText().toString()));
                     json.put("customerId",Integer.parseInt(customerId.getText().toString()));
                     json.put("tripTypeId",tripTypeId.getText());
                     json.put("packageId", Integer.parseInt(packageId.getText().toString()));
                     System.out.println(json);
                     addAgent(json);
                     Toast.makeText(getApplicationContext(), "BooKing added.", Toast.LENGTH_SHORT).show();
                     onBackPressed();
                     cancelbookingAdd();
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }



             }
         });



    }
// adding agent
    private void addAgent(JSONObject data) {
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/bookings/postBooking";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        // Enter the correct url for your api service site
        System.out.println(data);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //resultTextView.setText("String Response : "+ response.toString());
                        //Toast.makeText(getApplicationContext(),"Agent added",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    public void cancelbookingAdd(){
        Intent intent=new Intent(this,activity_bookingslist.class);
        startActivity(intent);


    }
}
