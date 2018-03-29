package us.mattgreen.listexample;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends ListActivity {

    static final String[] CARSARRAY = new String[] {"Ford Mustang", "Saab 77", "Plymoth Horizon",
            "Dodge Carivan", "Toyota Tercel", "Toyota Rav4", "Chrsysler Sebring", "Eagle Talon",
            "Dodge Diplomat"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        final List<String> cars;
        final ListView listView = getListView();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String name = getBundleString(bundle, "name", "");
            if(bundle.getStringArrayList("list") == null){
                cars = new ArrayList<String>(Arrays.asList(CARSARRAY));
            }else{
                cars = bundle.getStringArrayList("list");
            }
            if(bundle.containsKey("pos")){

                cars.set(bundle.getInt("pos"),name);
            }else{
            cars.add(name);}

            listView.invalidateViews();
        }else {
            cars = new ArrayList<String>(Arrays.asList(CARSARRAY));
        }
        setListAdapter(new ArrayAdapter<String>(this, R.layout.custom_list_car, cars));


        listView.setTextFilterEnabled(true);



        CarAdapter adapter = new CarAdapter((ArrayList<String>) cars, this);

        //handle listview and assign adapter

        listView.setAdapter(adapter);







    }
    public String getBundleString(Bundle b, String key, String def)
    {
        String value = b.getString(key);
        if (value == null)
            value = def;
        return value;
    }

}
