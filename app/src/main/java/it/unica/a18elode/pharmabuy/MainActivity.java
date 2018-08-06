package it.unica.a18elode.pharmabuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button buttonRegister;
    public Button buttonLogin;

    public void init() {
        buttonRegister = (Button) findViewById(R.id.signup_button);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(MainActivity.this, Register.class);

                startActivity(goToRegister);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        login();
    }

 /* Login try*/

    public void login() {
        buttonLogin= (Button) findViewById(R.id.login_button);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.username);
                EditText password = (EditText) findViewById(R.id.password);
                if (PersonFactory.getInstance().getIdByUserAndPassword(username.getText().toString(),password.getText().toString()) != -1 ||
                    PersonFactory.getInstance().getIdByEmailAndPassword(username.getText().toString(),password.getText().toString()) != -1 ){
                    Intent goToHome = new Intent(MainActivity.this, Menu.class);

                    startActivity(goToHome);
                }
                else {
                    Toast alert = Toast.makeText(MainActivity.this, "Username o Password ERRATI", Toast.LENGTH_SHORT);
                    alert.show();
                }
            }
        });

    }
}
