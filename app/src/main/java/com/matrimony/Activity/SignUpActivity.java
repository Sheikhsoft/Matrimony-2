package com.matrimony.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.matrimony.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText emailEditText;
    private EditText passEditText;
    private EditText mobileEditText;
    private EditText dobEditText;
    private Spinner spReligion;
    private Spinner spCountry;
    private  DatePickerDialog datePickerDialog;
    private RadioGroup radioGenderGroup;
    private RadioButton radioGenderButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Address the email and password field
        emailEditText = (EditText) findViewById(R.id.etEmail);
        mobileEditText = (EditText) findViewById(R.id.etMobile);
        passEditText = (EditText) findViewById(R.id.etPassword);
        spCountry=  (Spinner) findViewById(R.id.ddCountry);
        spReligion=  (Spinner) findViewById(R.id.ddReligion);
        dobEditText=(EditText) findViewById(R.id.etdob);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.religion, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReligion.setAdapter(adapter);
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(countryAdapter);

         datePickerDialog = new DatePickerDialog(
                this,  this, 2016, 21, 3);

                radioGenderGroup = (RadioGroup) findViewById(R.id.radioGender);


    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnSignUp:
                int selectedId = radioGenderGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioGenderButton = (RadioButton) findViewById(selectedId);
                if(radioGenderButton!=null)
                Toast.makeText(this,
                        radioGenderButton.getText(), Toast.LENGTH_SHORT).show();
                final String email = emailEditText.getText().toString();
                if (!isValidEmail(email)) {
                    //Set error message for email field
                    emailEditText.setError("Invalid Email");
                }

                final String mobile = mobileEditText.getText().toString();
                if (!isValidMobile(mobile)) {
                    //Set error message for email field
                    mobileEditText.setError("Invalid Mobile");
                }

                final String pass = passEditText.getText().toString();
                if (!isValidPassword(pass)) {
                    //Set error message for password field
                    passEditText.setError("Password cannot be empty");
                }

                if(isValidEmail(email) && isValidPassword(pass) && isValidMobile(mobile) )
                {
                    Toast.makeText(this,"Sign Up Clicked",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.tvLoginLink:
                Intent mIntent=new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(mIntent);

                break;
            case R.id.etdob:
                datePickerDialog.show();

                break;


        }



    }

    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidMobile(String mobile) {
       if(mobile.length()==10) {
           String MOBILE_PATTERN = "[a-zA-Z]+";
           Pattern pattern = Pattern.compile(MOBILE_PATTERN);
           Matcher matcher = pattern.matcher(mobile);
           return !matcher.matches();
       }
        return false;
    }
    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
    dobEditText.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
    }
}
