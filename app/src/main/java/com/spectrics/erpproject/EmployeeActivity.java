package com.spectrics.erpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.spectrics.erpproject.model.EmployeeModel;
import com.spectrics.erpproject.model.SignUpModel;

public class EmployeeActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;

    Button addClient,manageClient;
    EditText EmpName,EmpId,EmpPhone,EmpAddress,EmpEmail,EmpProjects,EmpSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_add);

        EmpName = findViewById(R.id.emp_name);
        EmpId = findViewById(R.id.emp_id);
        EmpPhone = findViewById(R.id.emp_phone);
        EmpAddress = findViewById(R.id.emp_address);
        EmpEmail = findViewById(R.id.emp_email);
        EmpProjects = findViewById(R.id.emp_projects);
        EmpSalary = findViewById(R.id.emp_salary);

        addClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add_client();
            }
        });



    }

    private  void  add_client(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("employee");
        String name = EmpName.getText().toString();
        String id = EmpId.getText().toString();
        String phone = EmpPhone.getText().toString();
        String address = EmpAddress.getText().toString();
        String email = EmpEmail.getText().toString();
        String projects = EmpProjects.getText().toString();
        String salary = EmpSalary.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Enter Employee Name!", Toast.LENGTH_SHORT).show();
            return;
        }


        if (TextUtils.isEmpty(id)) {
            Toast.makeText(getApplicationContext(), "Enter Employee Id!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(getApplicationContext(), "Enter Employee Address!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (phone.length() != 10) {
            Toast.makeText(getApplicationContext(), "Incorrect Mobile Number length, enter only 10 characters!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(salary)) {
            Toast.makeText(getApplicationContext(), "Enter Employee Salary!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(projects)) {
            Toast.makeText(getApplicationContext(), "Enter number of Projects assigned to the Employee!", Toast.LENGTH_SHORT).show();
            return;
        }

        EmployeeModel helperClass = new EmployeeModel(name,id,phone,address,email,projects,salary);
        reference.child(id).setValue(helperClass);

    }



}