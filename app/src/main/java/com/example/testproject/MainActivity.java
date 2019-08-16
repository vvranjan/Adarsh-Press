package com.example.testproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText itemName;
    private EditText unit;
    private Spinner sUnit;
    private EditText costPrice;
    private Spinner gst;
    private EditText totalCp;
    private EditText wholesalePrice;
    private EditText retailPrice;
    private EditText pUid;
    private Button addData;
    private Button dashboard;
    private Firebase mRootRef;
    public static String s1 = null;
    public static String s2 = null;

    FirebaseDatabase database;
    DatabaseReference ref;
    Items item;
    String parentuid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemName = (EditText) findViewById(R.id.item);
        unit = (EditText) findViewById(R.id.typeUnit);
        sUnit= (Spinner) findViewById(R.id.unit);
        costPrice = (EditText) findViewById(R.id.costPrice);
        gst = (Spinner) findViewById(R.id.gst);
        totalCp = (EditText) findViewById(R.id.totalCp);
        wholesalePrice = (EditText) findViewById(R.id.wholesalePrice);
        retailPrice = (EditText) findViewById(R.id.retailPrice);
        pUid = (EditText) findViewById(R.id.pUid);
        addData = (Button) findViewById(R.id.addData);
        dashboard = (Button) findViewById(R.id.dashboard);
        database = FirebaseDatabase.getInstance();



        item= new Items();

        ref= FirebaseDatabase.getInstance().getReference().child("Items");
        parentuid= ref.push().getKey();
        pUid.setText(parentuid);


        final Spinner spinner = findViewById(R.id.unit);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Spinner spinner1 = findViewById(R.id.gst);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.gst, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1= (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s2= spinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getValues();
                ref.child(parentuid).setValue(item);
                Toast.makeText(MainActivity.this,"data inserted..",Toast.LENGTH_LONG).show();
                btnInsert();


            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dashboard();


            }
        });

    }

    public void btnInsert()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void dashboard()
    {
        Intent intent = new Intent(this,AdminDashboard.class);
        startActivity(intent);
    }



    private void getValues()
    {
        item.setItemName(itemName.getText().toString());
        item.setUnit(unit.getText().toString());
        item.setSUnit(s1);
        item.setCostPrice(costPrice.getText().toString());
        item.setGST(s2);
        item.setTotalCP(totalCp.getText().toString());
        item.setWholesalePrice(wholesalePrice.getText().toString());
        item.setRetailPrice(retailPrice.getText().toString());
        item.setpUid(pUid.getText().toString());
    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

