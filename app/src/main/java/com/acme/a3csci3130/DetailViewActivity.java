package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, addressField, provinceField, business_Type, business_Num;
    Contact receivedPersonInfo;
    MyApplicationData app;
    CreateContactActivity cA = new CreateContactActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact) getIntent().getSerializableExtra("Contact");
        app = ((MyApplicationData) this.getApplicationContext());
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        business_Num = (EditText) findViewById(R.id.businessNum);//business num
        business_Type = (EditText) findViewById(R.id.businessType);//primmary business
        addressField = (EditText) findViewById(R.id.address);//address
        provinceField = (EditText) findViewById(R.id.province);//province


        if (receivedPersonInfo != null) {
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            business_Num.setText(receivedPersonInfo.businessNum);
            business_Type.setText(receivedPersonInfo.businessType);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    public void updateContact(View v) {// write in data
        //TODO: Update contact funcionality

        //CreateContactActivity cA = new CreateContactActivity();
        String personID = receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String num = business_Num.getText().toString();
        String type = business_Type.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();



        if (cA.checkName(name)&& cA.checkNum(num)&& cA.checkType(type)&& cA.checkAddress(address)&&cA.checkProvince(province)) {
            Contact person = new Contact(personID, name, email,num,type,address,province);
            Map<String, Object> update = person.toMap();
            Map<String, Object> childUpdate = new HashMap<>();
            childUpdate.put(personID, update);
            app.firebaseReference.updateChildren(childUpdate);
            Toast.makeText(this,"Update Succeed",Toast.LENGTH_SHORT).show();
            finish();
        } else {
           Toast.makeText(this, "retry again, not valid information.", Toast.LENGTH_SHORT).show();
       }
    }

    public void eraseContact(View v) {//remove data
        //TODO: Erase contact functionality
        app.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }

}

