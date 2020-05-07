package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class activity_bookingslist extends AppCompatActivity {

    public static final String EXTRA_NUMBER="oosd.team1.workshop8.EXTRA_NUMBER";
    private ListView lstBookings;
    private Button btnAddBooking;
    ArrayAdapter<Bookings> bookingsAdapter;
    ArrayList<Bookings> bookings = new ArrayList<>();
    boolean emptyAdaptor = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingslist);

        btnAddBooking= (Button)findViewById(R.id.btnAddBookings);
        lstBookings=(ListView)findViewById(R.id.lstBookings);

        loadBookingsData();
        System.out.println("Zoha");
        


        btnAddBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer bkid=bookings.get(0).getBookingId()+1;
                Intent intent= new Intent(getApplicationContext(), activity_addBooking.class);
                intent.putExtra(EXTRA_NUMBER,bkid);
                startActivity(intent);
                System.out.println(bkid);
                //openAddBookingActivity();


            }

        });
        

        lstBookings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), activity_bookingedit.class);
                intent.putExtra("booking", (Bookings) lstBookings.getAdapter().getItem(position));
                startActivity(intent);


            }
        });

        
    }




    private void loadBookingsData() {
        String url = "http://192.168.0.23:8080/Workshop7-1/rs/bookings/getbookings";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i =response.length()-1; i >=0; i--) {
                    try {

                        JSONObject json = response.getJSONObject(i);
                         Bookings booking =  new Bookings();
                         booking.setBookingId(json.getInt("bookingId"));
                        booking.setBookingNo(json.getString("bookingNo"));
                        booking.setTravelerCount((json.getDouble("travelerCount")));
                        booking.setCustomerId(json .getInt("customerId"));
                        booking.setTripTypeId(json.getString("tripTypeId"));
                        booking.setPackageId(json.getInt("packageId"));
                         bookings.add(booking);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                ArrayAdapter bookingAdapter = new ArrayAdapter<>(activity_bookingslist.this, android.R.layout.simple_list_item_1, bookings);
                lstBookings.setAdapter(bookingAdapter);
                emptyAdaptor = false;

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response: ", error.toString());
                    }
                });
        requestQueue.add(objectRequest);

    }

    public void  openAddBookingActivity(){
        Intent intent= new Intent(this, activity_addBooking.class);
        startActivity(intent);
    }

    public void  openEditBookingActivity(){
        Intent intent= new Intent(this, activity_bookingedit.class);
        startActivity(intent);
    }
}
