package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

public class ComponentSelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ExpandableListView expandableListView;
    List<String> listGroup;
    HashMap<String, List<String>> listItem;
    MainAdapter adapter;
    ArrayList<String> outthere = new ArrayList<>();
    TextView display;
    boolean a = false;


    private FirebaseAuth mAuth;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component_selection);

        display = findViewById(R.id.avail_compo);
        expandableListView = findViewById(R.id.expandable_listview);
        listGroup = new ArrayList<>();
        listItem = new HashMap<>();
        adapter = new MainAdapter(this,listGroup,listItem);
        expandableListView.setAdapter(adapter);

        FloatingActionButton floatb = findViewById(R.id.next);

        floatb.setEnabled(false);
        floatb.setVisibility(View.INVISIBLE);

        display.append(Html.fromHtml("<br><br>"));
        initListData();

        floatb.setOnClickListener(v -> {
            Intent i = new Intent(ComponentSelection.this,ArPage.class);
            startActivity(i);
        });


        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {

        String current;
        current =  listItem.get(listGroup.get(groupPosition)).get(childPosition);

        for(String s : outthere)
        {
            if(s.equals(current))
            {
                a = true;
                break;
            }
            else
            {
                a = false;
            }

        }

        if(a == true)
        {
            System.out.println("Already Exist");
            Toast.makeText(ComponentSelection.this,"Already Existing", Toast.LENGTH_LONG).show();
        }
        else
        {
            outthere.add(current);
            display.append(current + Html.fromHtml("<br><br>"));
            if(outthere.size() == 9){
                floatb.setEnabled(true);
                floatb.setVisibility(View.VISIBLE);}

        }
        return true;
        });

        mAuth = FirebaseAuth.getInstance();

    }

    private void initListData() {

        listGroup.add(getString(R.string.processors));
        listGroup.add(getString(R.string.motherboard));
        listGroup.add(getString(R.string.video_card));
        listGroup.add(getString(R.string.SSD));
        listGroup.add(getString(R.string.HDD));
        listGroup.add(getString(R.string.ram));
        listGroup.add(getString(R.string.smps));
        listGroup.add(getString(R.string.Case));
        listGroup.add(getString(R.string.cooling_fan));

        String[] array;

        List<String> processors= new ArrayList<>();
        array = getResources().getStringArray(R.array.processors);
        for (String item : array) {
            processors.add(item);
        }
        List<String> motherboard = new ArrayList<>();
        array = getResources().getStringArray(R.array.motherboard);
        for (String item : array) {
            motherboard.add(item);
        }
        List<String> video_card = new ArrayList<>();
        array = getResources().getStringArray(R.array.video_card);
        for (String item : array) {
            video_card.add(item);
        }
        List<String> SSD = new ArrayList<>();
        array = getResources().getStringArray(R.array.SSD);
        for (String item : array) {
            SSD.add(item);
        }
        List<String> HDD = new ArrayList<>();
        array = getResources().getStringArray(R.array.HDD);
        for (String item : array) {
            HDD.add(item);
        }
        List<String> ram = new ArrayList<>();
        array = getResources().getStringArray(R.array.ram);
        for (String item : array) {
            ram.add(item);
        }
        List<String> smps = new ArrayList<>();
        array = getResources().getStringArray(R.array.smps);
        for (String item : array) {
            smps.add(item);
        }
        List<String> Case = new ArrayList<>();
        array = getResources().getStringArray(R.array.Case);
        for (String item : array) {
            Case.add(item);
        }
        List<String> cooling_fan = new ArrayList<>();
        array = getResources().getStringArray(R.array.cooling_fan);
        for (String item : array) {
            cooling_fan.add(item);
        }

        listItem.put(listGroup.get(0),processors);
        listItem.put(listGroup.get(1),motherboard);
        listItem.put(listGroup.get(2),video_card);
        listItem.put(listGroup.get(3),SSD);
        listItem.put(listGroup.get(4),HDD);
        listItem.put(listGroup.get(5),ram);
        listItem.put(listGroup.get(6),smps);
        listItem.put(listGroup.get(7),Case);
        listItem.put(listGroup.get(8),cooling_fan);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}