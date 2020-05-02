package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class AgentActivity extends AppCompatActivity {
    ListView lvAgents;
    ArrayAdapter<com.wade.day12exercise.Agent> agentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);
        lvAgents = findViewById(R.id.lvAgents);
        loadData();
    }
    private void loadData() {

        //agentsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,agentDataSource.loadAgents());

        String URL ="http://10.10.63.176:8080/Workshop7-1/rs/agent/getallagents";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("Rest Response: ", response.toString() );

                        //Need to parse JSON data nto listview

                        //lvAgents.setAdapter((ListAdapter) response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response: ", error.toString() );
                    }
                });

                requestQueue.add(objectRequest);


    }
}
