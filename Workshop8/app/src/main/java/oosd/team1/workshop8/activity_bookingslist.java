package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class activity_bookingslist extends AppCompatActivity {
    private ListView lstBookings;
    private Button btnAddBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookingslist);

        btnAddBooking= (Button)findViewById(R.id.btnAddBookings);
        lstBookings=(ListView)findViewById(R.id.lstBookings);



        btnAddBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openAddBookingActivity();
                openEditBookingActivity();

            }

        });




        lstBookings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

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
