/*
 * Created by Wade Grimm
 *
 * */


package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static java.lang.Class.forName;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // declare the button objects
    Button btnAgents, btnBookings, btnCustomers, btnSuppliers, btnExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// set said button object references
        Button btnAgents = findViewById(R.id.btnAgents);
        Button btnBookings = findViewById(R.id.btnBookings);
        Button btnCustomers = findViewById(R.id.btnCustomers);
        Button btnSuppliers = findViewById(R.id.btnSuppliers);
        Button btnExtra = findViewById(R.id.btnExtra);
//handle the button clicks
        btnAgents.setOnClickListener(this);
        btnBookings.setOnClickListener(this);
        btnCustomers.setOnClickListener(this);
        btnSuppliers.setOnClickListener(this);
        btnExtra.setOnClickListener(this);


    }

    // capture the button press, perform a function based on what button was pressed
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAgents:
                // do something
                openActivity(AgentActivity.class);
                //Toast.makeText(this, "Load Agents", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBookings:
                 openActivity(activity_bookingslist.class);
                Toast.makeText(this, "Load Bookings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCustomers:
                // do something
                openActivity(CustomerActivity.class);
                //Toast.makeText(this, "Load Customers", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSuppliers:
                // do something
                Toast.makeText(this, "Load Suppliers", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnExtra:
                // do something
                Toast.makeText(this, "Load Extras", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // open other 'pages' of content
    public void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
