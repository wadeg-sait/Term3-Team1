/*
 * Created by Muhammad Khalil
 *
 * */

package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;

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

public class CustomerActivity extends AppCompatActivity {
    // setup controls, objects
    Button btnAdd;
    ListView lvCustomers;
    ArrayAdapter<Customer> customersAdapter;
    ArrayList<Customer> customers = new ArrayList<>();
    boolean emptyAdaptor = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        lvCustomers = findViewById(R.id.lvCustomers);
        btnAdd = findViewById(R.id.btnAdd);

        lvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CustomerDetail.class);
                intent.putExtra("customer", (Customer) lvCustomers.getAdapter().getItem(position));
                intent.putExtra("mode", "update");
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerDetail.class);

                intent.putExtra("mode", "Add");
                startActivity(intent);
            }
        });


        loadCustomerData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!emptyAdaptor) {
            customers.clear();
            loadCustomerData();

        }


    }


    private void loadCustomerData() {

        String url = "http://10.0.0.131:8080/Workshop7-1/rs/customers/getCustomers";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject json = response.getJSONObject(i);
                                Log.e("Shoda","check");
                                Customer customer = new Customer(
                                        json.getInt("customerId"),
                                        json.getString("custFirstName"),
                                        json.getString("custLastName"),
                                        json.getString("custAddress"),
                                        json.getString("custCity"),
                                        json.getString("custHomePhone"),
                                        //json.optString("agtMiddleInitial", ""),
                                        json.getString("custEmail"));
                                customers.add(customer);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        ArrayAdapter customersAdapter = new ArrayAdapter<>(CustomerActivity.this, android.R.layout.simple_list_item_1, customers);
                        lvCustomers.setAdapter(customersAdapter);
                        emptyAdaptor = false;
                    }
                },
                new Response.ErrorListener() { // if the request returns any errors dump them to the log
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response: ", error.toString());
                    }
                });

        requestQueue.add(objectRequest);

    }


}









