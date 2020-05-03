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
    ListView lvAgents;
   ArrayAdapter<Agent> agentsAdapter;
    ArrayList<Agent> agents = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);
        lvAgents = findViewById(R.id.lvAgents);
        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AgentDetail.class);
                intent.putExtra("agent", (Agent) lvAgents.getAdapter().getItem(position));
                intent.putExtra("mode","update");
                startActivity(intent);
            }
        });

        loadAgentData();
        }
    private void loadAgentData() {
       String URL = "http://10.10.63.176:8080/Workshop7-1/rs/agent/getallagents";
       RequestQueue requestQueue = Volley.newRequestQueue(this);
       JsonArrayRequest objectRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Log.e("Rest Response: ", response.toString() );
                        //Need to parse JSON data nto listview
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject json = response.getJSONObject(i);
                                Agent agent = new Agent(
                                        json.getInt("agentId"),
                                        json.getInt("agencyId"),
                                        json.getString("agtBusPhone"),
                                        json.getString("agtEmail"),
                                        json.getString("agtFirstName"),
                                        json.getString("agtLastName"),
                                        json.optString("agtMiddleInitial", ""),
                                        json.getString("agtPosition"));
                                agents.add(agent);
                                //Log.e("Agent: ",agent.toString() );
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ArrayAdapter agentsAdapter = new ArrayAdapter<>(AgentActivity.this, android.R.layout.simple_list_item_1, agents);
                        lvAgents.setAdapter(agentsAdapter);
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
}









