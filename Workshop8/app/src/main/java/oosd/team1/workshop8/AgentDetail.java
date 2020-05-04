package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import oosd.team1.workshop8.Agent;
// class to get individual details of the agent that was clicked
public class AgentDetail extends AppCompatActivity {
// setup buttons and text fields
    EditText etAgentId,etAgtFirstName, etAgtMiddleInitial, etAgtLastName, etAgtEmail, etAgtBusPhone, etAgtPosition, etAgencyID;
    Button btnSave, btnCancel, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_detail);
//set references to said buttons and text fields
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        etAgentId = findViewById(R.id.etAgentId);
        etAgtFirstName = findViewById(R.id.etAgtFirstName);
        etAgtMiddleInitial = findViewById(R.id.etAgtMiddleInitial);
        etAgtLastName = findViewById(R.id.etAgtLastName);
        etAgtBusPhone = findViewById(R.id.etAgtBusPhone);
        etAgtEmail = findViewById(R.id.etAgtEmail);
        etAgtPosition = findViewById(R.id.etAgtPosition);
        etAgencyID = findViewById(R.id.etAgencyId);

//state your intentions... Display the data
        Intent intent = getIntent();
        final String mode = intent.getStringExtra("mode");
        if(mode.equals("update")){
            Agent a = (Agent) intent.getSerializableExtra("agent");
            etAgentId.setText(String.valueOf(a.getAgentId()));
            etAgtFirstName.setText(a.getAgtFirstName());
            etAgtMiddleInitial.setText(a.getAgtMiddleInitial());
            etAgtLastName.setText(a.getAgtLastName());
            etAgtBusPhone.setText(a.getAgtBusPhone());
            etAgtEmail.setText(a.getAgtEmail());
            etAgtPosition.setText(a.getAgtPosition());
            etAgencyID.setText(String.valueOf(a.getAgencyId()));
        }else if(mode.equals("Add")){
           //btnSave.setEnabled(false);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject json = new JSONObject();
                //Gson json = new Gson();
                Agent obj = new Agent();
                try {
                if(mode.equals("update")){
                        json.put("agentId",Integer.parseInt(etAgentId.getText().toString()));
                }
                    json.put("agtFirstName",etAgtFirstName.getText().toString());
                    json.put("agtMiddleInitial", etAgtMiddleInitial.getText().toString());
                    json.put("agtLastName",etAgtLastName.getText().toString());
                    json.put("agtBusPhone",etAgtBusPhone.getText().toString());
                    json.put("agtEmail", etAgtEmail.getText().toString());
                    json.put("agtPosition",etAgtPosition.getText().toString());
                    json.put("agencyId",Integer.parseInt(etAgencyID.getText().toString()));
                //String data = json.toJson(obj);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(mode.equals("update")){
                    updateAgent(json);
                    Toast.makeText(getApplicationContext(),"Record edited.",Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else{
                    addAgent(json);
                    Toast.makeText(getApplicationContext(),"Agent added.",Toast.LENGTH_LONG).show();
                    onBackPressed();
                }
            }
        });

        // forget it, Im outta here
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Action(s) canceled, no data added/updated.",Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int agentId = Integer.parseInt(etAgentId.getText().toString());
                if(agentId>9) {
                    deleteAgent(agentId);
                    Toast.makeText(getApplicationContext(),"Record deleted.",Toast.LENGTH_LONG).show();
                    onBackPressed();
                }else {
                    Toast.makeText(getApplicationContext(),"Unable to delete record in prototype.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    // is there anything in the field?
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

    private void addAgent(JSONObject data){
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/agent/putagent";
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


    private void updateAgent(JSONObject data){
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/agent/postagent";
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

    private void deleteAgent(int agentId){
        String url = "http://10.10.63.176:8080/Workshop7-1/rs/agent/deleteagent/"+agentId;
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
