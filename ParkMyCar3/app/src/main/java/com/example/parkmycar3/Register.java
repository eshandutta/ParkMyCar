package com.example.parkmycar3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
          EditText euser;
          EditText epassword;
          EditText econfirmpassword;
          EditText emobile;
          EditText eemail;
          Button register;
          FirebaseDatabase db= FirebaseDatabase.getInstance();
          DatabaseReference databaseReference;
          FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        euser=findViewById(R.id.username);
        epassword=findViewById(R.id.password);
        econfirmpassword=findViewById(R.id.confirmpassword);
        emobile=findViewById(R.id.mobile);
        eemail=findViewById(R.id.email);
        register=findViewById(R.id.register);

        databaseReference=db.getReference("RegisterDb");

        //GET Firebase auth instance
        auth=FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=eemail.getText().toString().trim();
                String password=epassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
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

                //create user
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Register.this,"User Created."+task.isSuccessful(),Toast.LENGTH_SHORT).show();
                    }
                });

                /*if (!task.isSuccessful())
                {
                    Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                            Toast.LENGTH_SHORT).show();
                }*/

                sendData();
            }
        });



    }

    public void sendData() {
        String dataFieldName = euser.getText().toString();
        String dataFieldPassword = epassword.getText().toString();
        String dataFieldConfirmpassword = econfirmpassword.getText().toString();
        String dataFieldMobile = emobile.getText().toString();
        String dataFieldEmail = eemail.getText().toString();
        String id = databaseReference.push().getKey();
        if (!TextUtils.isEmpty(dataFieldName))
        {
            RegisterDb data=new RegisterDb(dataFieldName,dataFieldPassword,dataFieldConfirmpassword,dataFieldMobile,dataFieldEmail,id);
            databaseReference.child(id).setValue(data);
          //  Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Caution!! All details are not entered",Toast.LENGTH_SHORT).show();
        }
    }
}
