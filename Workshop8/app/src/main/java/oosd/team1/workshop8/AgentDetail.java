package oosd.team1.workshop8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import oosd.team1.workshop8.Agent;

public class AgentDetail extends AppCompatActivity {

    EditText etAgentId,etAgtFirstName, etAgtMiddleInitial, etAgtLastName, etAgtEmail, etAgtBusPhone, etAgtPosition, etAgencyID;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_detail);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        etAgentId = findViewById(R.id.etAgentId);
        etAgtFirstName = findViewById(R.id.etAgtFirstName);
        etAgtMiddleInitial = findViewById(R.id.etAgtMiddleInitial);
        etAgtLastName = findViewById(R.id.etAgtLastName);
        etAgtBusPhone = findViewById(R.id.etAgtBusPhone);
        etAgtEmail = findViewById(R.id.etAgtEmail);
        etAgtPosition = findViewById(R.id.etAgtPosition);
        etAgencyID = findViewById(R.id.etAgencyId);


        Intent intent = getIntent();
        String mode = intent.getStringExtra("mode");
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
        }else{
            btnSave.setEnabled(false);
        }

       // final AgentDataSource agentDataSource = new AgentDataSource(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                long rowsAffected = agentDataSource.updateAgent(new Agent(
//                        Integer.parseInt(etAgentId.getText().toString()),
//                        etAgtFirstName.getText().toString(),
//                        etAgtMiddleInitial.getText().toString(),
//                        etAgtLastName.getText().toString(),
//                        etAgtBusPhone.getText().toString(),
//                        etAgtEmail.getText().toString(),
//                        etAgtPosition.getText().toString(),
//                        Integer.parseInt(etAgencyID.getText().toString())));
                Toast.makeText(getApplicationContext(),"Record edited.",Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Action(s) canceled, no data added/updated.",Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });
    }
    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }
}
