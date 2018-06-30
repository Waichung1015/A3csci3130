package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateContactActivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField,addressField,provinceField,business_Type,business_Num;
    private MyApplicationData appState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());
        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        business_Num = (EditText) findViewById(R.id.businessNum);//business num
        business_Type = (EditText) findViewById(R.id.businessType);//primmary business
        addressField = (EditText) findViewById(R.id.address);//address
        provinceField = (EditText) findViewById(R.id.province);//province
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String num = business_Num.getText().toString();
        String type = business_Type.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        if(checkName(name)&&checkAddress(address)&&checkNum(num)&&checkProvince(province)&&checkType(type)){
            Contact person = new Contact(personID, name, email,num,type,address,province);
            appState.firebaseReference.child(personID).setValue(person);
            Toast.makeText(this,"Upload.",Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this,"retry again, not valid information.",Toast.LENGTH_SHORT).show();
        }
        finish();

    }

    public boolean checkNum(String businessNum){
        if(businessNum.length()!=9)
            return false;

        return true;
    }
    public boolean checkName(String name){
        if(name.length()<2||name.length()>49)
            return false;

        return true ;
    }
    public boolean checkType(String Type){
        ArrayList<String> type = new ArrayList<String>(Arrays.asList("Fisher", "Distributor", "Processor", "Fish Monger"));
        if(!type.contains(Type))
           return false ;
        return true;
    }
    public boolean checkAddress(String address){
        if(address.length()>51)
            return false;
        return true;
    }
    public boolean checkProvince(String province){
        ArrayList<String> p = new ArrayList<String>(Arrays.asList("AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK"));
        if(!p.contains(province))
            return false;
        return true;
    }
}
