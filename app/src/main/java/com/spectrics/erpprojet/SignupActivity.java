package com.spectrics.erpprojet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.spectrics.erpproject.R;

import java.util.concurrent.TimeUnit;

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
        verifyOTPBtn = findViewById(R.id.idBtnVerify);
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
                HelperClass helperClass = new HelperClass(name, email, username, password);
//                reference.child(username).setValue(helperClass);
                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                setContentView(R.layout.otp_screen);
                edtOTP = findViewById(R.id.idEdtOtp);
                verifyOTPBtn = findViewById(R.id.idBtnVerify);
                String phonex = "+91" + signupPhone.getText().toString();
                sendVerificationCode(phonex);
                verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // validating if the OTP text field is empty or not.
                        if (TextUtils.isEmpty(edtOTP.getText().toString())) {
                            // if the OTP text field is empty display
                            // a message to user to enter OTP
                            Toast.makeText(SignupActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                        } else {
                            // if OTP field is not empty calling
                            // method to verify the OTP.
                            verifyCode(edtOTP.getText().toString());
                        }
                    }
                });


//                loginRedirectText.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                    }
//
//
//
//
//                    // callback method is called on Phone auth provider.
//
//
//                    // below method is use to verify code from Firebase.
//
//
//
//                });
            }


            private void verifyCode(String code) {
                // below line is used for getting
                // credentials from our verification id and code.
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);

                // after getting credential we are
                // calling sign in method.
                signInWithCredential(credential);
            }
            private PhoneAuthProvider.OnVerificationStateChangedCallbacks

                    // initializing our callbacks for on
                    // verification callback method.
                    mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                // below method is used when
                // OTP is sent from Firebase
                @Override
                public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    // when we receive the OTP it
                    // contains a unique id which
                    // we are storing in our string
                    // which we have already created.
                    verificationId = s;
                }

                // this method is called when user
                // receive OTP from Firebase.
                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    // below line is used for getting OTP code
                    // which is sent in phone auth credentials.
                    final String code = phoneAuthCredential.getSmsCode();

                    // checking if the code
                    // is null or not.
                    if (code != null) {
                        // if the code is not null then
                        // we are setting that code to
                        // our OTP edittext field.
                        edtOTP.setText(code);

                        // after setting this code
                        // to OTP edittext field we
                        // are calling our verifycode method.
                        verifyCode(code);
                    }
                }

                // this method is called when firebase doesn't
                // sends our OTP code due to any error or issue.
                @Override
                public void onVerificationFailed(FirebaseException e) {
                    // displaying error message with firebase exception.
                    Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            };

            private void signInWithCredential(PhoneAuthCredential credential) {
                // inside this method we are checking if
                // the code entered is correct or not.
                mAuth.signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // if the code is correct and the task is successful
                                    // we are sending our user to new activity.
                                    Intent i = new Intent(SignupActivity.this, Dashboard.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    // if the code is not correct then we are
                                    // displaying an error message to the user.
                                    Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
            public void sendVerificationCode(String number) {
                // this method is used for getting
                // OTP on user phone number.
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(mAuth)
                                .setPhoneNumber(number)            // Phone number to verify
                                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(SignupActivity.this)                 // Activity (for callback binding)
                                .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                                .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
            }
        });
    }


}