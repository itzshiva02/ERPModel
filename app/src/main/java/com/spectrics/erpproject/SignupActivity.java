package com.spectrics.erpproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.spectrics.erpproject.model.SignUpModel;

public class SignupActivity extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword, signupPhone;
    TextView loginRedirectText;
    Button signupButton;
    final String emailpattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    FirebaseDatabase database;
    DatabaseReference reference;
    private EditText edtPhone, edtOTP;

    // buttons for generating OTP and verifying OTP
    private Button verifyOTPBtn, generateOTPBtn;
    private FirebaseAuth mAuth;

    // string for storing our verification ID
    private String verificationId;
//    edtPhone = findViewById(R.id.idEdtPhoneNumber);
//    edtOTP = findViewById(R.id.idEdtOtp);
//    verifyOTPBtn = findViewById(R.id.idBtnVerify);
//    generateOTPBtn = findViewById(R.id.idBtnGetOtp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        edtOTP = findViewById(R.id.idEdtOtp);
//        verifyOTPBtn = findViewById(R.id.idBtnVerify);
        signupName = findViewById(R.id.signup_name);
        signupPhone = findViewById(R.id.signup_phone);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        mAuth = FirebaseAuth.getInstance();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String phone = signupPhone.getText().toString();
                String status = "true";
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Name!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter Username!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                SignUpModel helperClass = new SignUpModel(name,email,phone, username, password, status);
//                reference.child(username).setValue(helperClass);


                // redirect to otp verification screen
                String phonex = signupPhone.getText().toString();
                Intent intent = new Intent(SignupActivity.this, OtpActivity.class);
                intent.putExtra("phone",phonex);
                startActivity(intent);

            }
        });
    }
}