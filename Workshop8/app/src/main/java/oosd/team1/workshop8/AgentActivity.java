/*
 * Workshop 8 base skeleton created by Wade Grimm
 *
 * */

package oosd.team1.workshop8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AgentActivity extends AppCompatActivity {
    // setup controls, objects
    ListView lvAgents;
    ArrayAdapter<Agent> agentsAdapter;
    ArrayList<Agent> agents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);
        // grab ref to ListView
        lvAgents = findViewById(R.id.lvAgents);
        // on click listener for listview items
        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AgentDetail.class);
                intent.putExtra("agent", (Agent) lvAgents.getAdapter().getItem(position));
                intent.putExtra("mode","update");
                startActivity(intent);
            }
        });
//get the agent data from rest service on web server
        loadAgentData();
        }

        // we use Volley to request, receive the JSON data from the server
    private void loadAgentData() {
       String URL = "http://10.10.63.176:8080/Workshop7-1/rs/agent/getallagents";
       //setup the request queue
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       //setup the request - it requires the method (Get, Post), URL, any parameters that need to be sent, a listener object and listener error object
       JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                    // we receive the data back as a JSON Array, so we need to break it down to JSON Objects and then again into the Agent Objects
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                // pull out each JSON Object
                                JSONObject json = response.getJSONObject(i);
                                //create a new Agent object with the data, notice the json.optString
                                // this will return the value is set otherwise it will return the 'fallback' string
                                // since not every record has a midddle initial I was getting parse errors before i found that
                                Agent agent = new Agent(
                                        json.getInt("agentId"),
                                        json.getInt("agencyId"),
                                        json.getString("agtBusPhone"),
                                        json.getString("agtEmail"),
                                        json.getString("agtFirstName"),
                                        json.getString("agtLastName"),
                                        json.optString("agtMiddleInitial", ""),
                                        json.getString("agtPosition"));
                                agents.add(agent); //add each agent to a list of agents
                                //Log.e("Agent: ",agent.toString() );
                            } catch (JSONException e) { // if there is an error dump it to the log
                                e.printStackTrace();
                            }
                        }
                        // ListView needs an ArrayAdaptor to format the display items, we create it from the list of agents and set the list view to use it
                        ArrayAdapter agentsAdapter = new ArrayAdapter<>(AgentActivity.this, android.R.layout.simple_list_item_1, agents);
                        lvAgents.setAdapter(agentsAdapter);
                    }
                },
                new Response.ErrorListener() { // if the request returns any errors dump them to the log
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error Response: ", error.toString());
                    }
                });
       // send the request
        requestQueue.add(objectRequest);
    }
}









