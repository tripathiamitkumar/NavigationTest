package com.example.navigationtest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.navigationtest.util.LoginPreference;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    public static final String LOGIN_URL="https://ordinancebadmal.000webhostapp.com/UserRegistration/login.php";
    //public static final String KEY_EMAIL="email";
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    public static final String LOGIN_SUCCESS="success";

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button BtnLogin;
    private boolean loggedIn=false;
    LoginPreference loginPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextUsername=(EditText)findViewById(R.id.editText_username);
        editTextPassword=(EditText)findViewById(R.id.editText_password);
        BtnLogin=(Button)findViewById(R.id.btn_login);
        loginPreference = new LoginPreference(this);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //login();
                if(isValid()){
                    testLogin();
                }
            }
        });
    }


    private boolean isValid(){
        if(editTextUsername.getText().length()<1){
             editTextUsername.requestFocus();
             editTextUsername.setError("Username Required!");
             return false;
        }else if(editTextPassword.getText().length()<1){
            editTextPassword.requestFocus();
            editTextPassword.setError("Password Required!");
            return false;
        }
        return true;
    }

    private void testLogin(){
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        if (username.equals("admin") && password.equals("admin123")) {
            loginPreference.putLoginPref(username);
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void login() {
        final String username = editTextUsername.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equalsIgnoreCase(LOGIN_SUCCESS)){
                            loginPreference.putLoginPref(username);
                            Intent intent = new Intent(Login.this, MainActivity.class);
                           // Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> prams = new HashMap<>();
                prams.put(KEY_USERNAME, username);
                prams.put(KEY_PASSWORD, password);

                return prams;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(loginPreference==null){
            loginPreference =new LoginPreference(this);
        }
        loggedIn= loginPreference.isLogin();
        if(loggedIn){
            Intent intent = new Intent(Login.this, MainActivity.class);
            //Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
