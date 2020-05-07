/*
 * Created by Muhammad Khalil
 *
 * */

package oosd.team1.workshop8;

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

import java.util.ArrayList;


// class to get individual details of the agent that was clicked
public class CustomerDetail extends AppCompatActivity {
    // setup buttons and text fields
    EditText etCustomerId, etCustFirstName, etCustLastName, etCustAddress, etCustCity, etCustHomePhone, etCustEmail;
    Button btnSave, btnCancel, btnDelete;
    ArrayList<EditText> etControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);
//set references to said buttons and text fields
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        etCustomerId = findViewById(R.id.etCustomerId);
        etCustFirstName = findViewById(R.id.etCustFirstName);
        etCustLastName = findViewById(R.id.etCustLastName);
        etCustAddress = findViewById(R.id.etCustAddress);
        etCustHomePhone = findViewById(R.id.etCustHomePhone);
        etCustCity = findViewById(R.id.etCustCity);
        etCustEmail = findViewById(R.id.etCustEmail);

        etControls =  new ArrayList<EditText>(){{add(etCustFirstName);add(etCustAddress);add(etCustCity);add(etCustHomePhone);add(etCustEmail);}};
//state your intentions... Display the data
        Intent intent = getIntent();
        final String mode = intent.getStringExtra("mode");
        if (mode.equals("update")) {
            Customer a = (Customer) intent.getSerializableExtra("customer");
            etCustomerId.setText(String.valueOf(a.getCustomerId()));
            etCustFirstName.setText(a.getCustFirstName());
            etCustLastName.setText(a.getCustLastName());
            etCustAddress.setText(a.getCustAddress());
            etCustHomePhone.setText(a.getCustHomePhone());
            etCustCity.setText(a.getCustCity());
            etCustEmail.setText(a.getCustEmail());
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //

            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    JSONObject json = new JSONObject();
                    try {
                        if (mode.equals("update")) {
                            json.put("CustomerId", Integer.parseInt(etCustomerId.getText().toString()));
                        }
                        json.put("CustFirstName", etCustFirstName.getText().toString());
                        json.put("CustLastName", etCustLastName.getText().toString());
                        json.put("CustAddress", etCustAddress.getText().toString());
                        json.put("CustHomePhone", etCustHomePhone.getText().toString());
                        json.put("CustCity", etCustCity.getText().toString());
                        json.put("CustEmail", etCustEmail.getText().toString());
                        //String data = json.toJson(obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (mode.equals("update")) {
                        updateCustomer(json);
                        Toast.makeText(getApplicationContext(), "Record edited.", Toast.LENGTH_LONG).show();
                        onBackPressed();
                    } else {
                        addCustomer(json);
                        Toast.makeText(getApplicationContext(), "Customer added.", Toast.LENGTH_LONG).show();
                        onBackPressed();
                    }
                }
            }
        });

        // forget it, Im outta here
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Action(s) canceled, no data added/updated.", Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int customerId = Integer.parseInt(etCustomerId.getText().toString());
                if (customerId > 9) {
                    deleteCustomer(customerId);
                    Toast.makeText(getApplicationContext(), "Record deleted.", Toast.LENGTH_LONG).show();
                    onBackPressed();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to delete record in prototype.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean validateFields() {
        int badInput=0;
        for (EditText et : etControls) {
            if (et.getText().toString().trim().length() == 0){
                et.setError("Field cannot be empty");
                badInput++;
            }
        }
        if(badInput==0){
            return true;
        }else{
            return false;
        }
    }

    // is there anything in the field?
//    private boolean isEmpty(EditText editText) {
//        for (EditText et : etControls) {
//
//        }
//        //return editText.getText().toString().trim().length() == 0;
//    }

    private void addCustomer(JSONObject data) {
        String url = "http://192.168.0.23:8080/Workshop7-1/rs/customers/postCustomer";
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        // Enter the correct url for your api service site
        System.out.println(data);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, data,
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


    private void updateCustomer(JSONObject data) {
        String url = "http://192.168.0.23:8080/Workshop7-1/rs/customers/updateCustomer";
        //setup the request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        // Enter the correct url for your api service site
        System.out.println(data);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //resultTextView.setText("String Response : "+ response.toString());
                        //Toast.makeText(getApplicationContext(),"Agent updated",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);

    }

    private void deleteCustomer(int customerId) {
        String url = "http://192.168.0.23:8080/Workshop7-1/rs/customers/deleteCustomer/" + customerId;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        // Enter the correct url for your api service site
        //System.out.println(data);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //resultTextView.setText("String Response : "+ response.toString());
                        //Toast.makeText(getApplicationContext(),"Agent deleted",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


}
