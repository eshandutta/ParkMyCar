//https://www.androidhive.info/2016/06/android-getting-started-firebase-simple-login-registration-auth/
package com.example.parkmycar3;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    EditText euser;
    EditText epassword;
    Button login;
    Button register;
    Button forgotPassword;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        euser = findViewById(R.id.username);
        epassword = findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        forgotPassword=(Button)findViewById(R.id.forgotPassword);
        databaseReference =db.getReference("Data");
        mAuth=FirebaseAuth.getInstance();


        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent intent=new Intent(MainActivity.this,ShowBookings.class);
                    startActivity(intent);
                }
            }
        };


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  sendData();
                startSignIn();

               // Intent intent = new Intent(MainActivity.this, Places.class);
                //startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    public void startSignIn()
    {
        final String dataFieldName = euser.getText().toString();
        final String dataFieldPassword = epassword.getText().toString();



              if(TextUtils.isEmpty(dataFieldName)||TextUtils.isEmpty(dataFieldPassword))
              {
                  Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  mAuth.signInWithEmailAndPassword(dataFieldName,dataFieldPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                  {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task)
                      {
                          if(!task.isSuccessful())
                          {
                              Toast.makeText(MainActivity.this,"sign in failed",Toast.LENGTH_SHORT).show();
                          }
                      }
                  });
              }
    }

}





    /*public void sendData()
    {
        String dataFieldName = euser.getText().toString();
        String dataFieldPassword = epassword.getText().toString();
        String id = databaseReference.push().getKey();
        if (!TextUtils.isEmpty(dataFieldName))
        {
            Data data = new Data(dataFieldName, dataFieldPassword, id);
            databaseReference.child(id).setValue(data);
            Toast.makeText(this, "data saved", Toast.LENGTH_SHORT).show();
        }
        else
            {
                 Toast.makeText(this, "Please enter th sdd", Toast.LENGTH_SHORT).show();
            }

    }*/


