package com.spectrics.erpproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
//        profileName = findViewById(R.id.profileName);
//        profileEmail = findViewById(R.id.profileEmail);
//        profileUsername = findViewById(R.id.profileUsername);
//        profilePassword = findViewById(R.id.profilePassword);
//        titleName = findViewById(R.id.titleName);
//        titleUsername = findViewById(R.id.titleUsername);
//        editProfile = findViewById(R.id.editButton);

//        showAllUserData();

//        editProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                passUserData();
//            }
//        });
//
//    }

//    public void showAllUserData(){
//        Intent intent = getIntent();
//        String nameUser = intent.getStringExtra("name");
//        String emailUser = intent.getStringExtra("email");
//        String usernameUser = intent.getStringExtra("username");
//        String passwordUser = intent.getStringExtra("password");
//
//        titleName.setText(nameUser);
//        titleUsername.setText(usernameUser);
//        profileName.setText(nameUser);
//        profileEmail.setText(emailUser);
//        profileUsername.setText(usernameUser);
//        profilePassword.setText(passwordUser);
//    }
//
//    public void passUserData(){
//        String userUsername = profileUsername.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if (snapshot.exists()){
//
//                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
//                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//
//                    Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
//
//                    intent.putExtra("name", nameFromDB);
//                    intent.putExtra("email", emailFromDB);
//                    intent.putExtra("username", usernameFromDB);
//                    intent.putExtra("password", passwordFromDB);
//
//                    startActivity(intent);
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }
//}