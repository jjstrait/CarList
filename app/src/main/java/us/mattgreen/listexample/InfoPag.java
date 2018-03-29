package us.mattgreen.listexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class InfoPag extends AppCompatActivity {

    private Button btn;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pag);

        btn = (Button)findViewById(R.id.btn);
        name = (EditText)findViewById(R.id.name);

    }

    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity.class);

        //Create the bundle
        Bundle bundle = getIntent().getExtras();

//Add your data to bundle
        if(bundle.containsKey("pos")){
            bundle.putInt("pos",bundle.getInt("pos"));
        }
        bundle.putString("name", name.getText().toString());

        ArrayList<String> list = bundle.getStringArrayList("list");
        bundle.putStringArrayList("list", list);
//Add the bundle to the intent
        intent.putExtras(bundle);

//Fire that second activity
        startActivity(intent);
    }
}
