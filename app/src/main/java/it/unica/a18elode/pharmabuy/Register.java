package it.unica.a18elode.pharmabuy;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        register();
    }
    //validazione mail INIZIO
    private boolean mailSyntaxCheck(String email)
    {
        // Create the Pattern using the regex
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        // Match the given string with the pattern
        Matcher m = p.matcher(email);
        // check whether match is found
        boolean matchFound = m.matches();
        StringTokenizer st = new StringTokenizer(email, ".");
        String lastToken = null;
        while (st.hasMoreTokens()) {
            lastToken = st.nextToken();
        }
        // validate the country code
        if (matchFound && lastToken.length() >= 2
                && email.length() - 1 != lastToken.length()) {
            return true;
        } else {
            return false;
        }


    }
    //validazione mail FINE


    public void register() {
        buttonRegister= (Button) findViewById(R.id.confirm);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.Username);
                EditText password = (EditText) findViewById(R.id.Password);
                EditText email = (EditText) findViewById(R.id.Email);
                EditText confPsw=(EditText) findViewById(R.id.ConfPassword);
                if (!(username.getText().toString().equals(""))&&
                        !(password.getText().toString().equals(""))&&
                        !(email.getText().toString().equals(""))&&
                        !(confPsw.getText().toString().equals(""))&&
                        password.getText().toString().equals(confPsw.getText().toString())){
                    PersonFactory.getInstance().getListaPersone().add(new Person(
                            username.getText().toString().toLowerCase(),
                            password.getText().toString(),
                            email.getText().toString().toLowerCase())
                    );
                    Intent goToHome = new Intent(Register.this, MainActivity.class);
                    startActivity(goToHome);
                    Toast reg = Toast.makeText(Register.this, "Registrazione avvenuta con successo", Toast.LENGTH_SHORT);
                    reg.show();
                }
                else {
                    if(!(password.getText().toString().equals(confPsw.getText().toString()))) {
                        Toast alert = Toast.makeText(Register.this, "Le password non corrispondono", Toast.LENGTH_SHORT);
                        alert.show();
                        ((EditText) findViewById(R.id.Password)).setTextColor(Color.RED);
                        ((EditText) findViewById(R.id.ConfPassword)).setTextColor(Color.RED);

                    }
                    else{

                        Toast empty = Toast.makeText(Register.this, "Riempi tutti i campi", Toast.LENGTH_SHORT);
                        empty.show();
                        if(username.getText().toString().equals("")){
                            ((EditText) findViewById(R.id.Username)).setHintTextColor(Color.RED);
                        }
                        else
                            ((EditText) findViewById(R.id.Username)).setHintTextColor(Color.BLACK);
                        if(password.getText().toString().equals("")){
                            ((EditText) findViewById(R.id.Password)).setHintTextColor(Color.RED);
                        }else
                            ((EditText) findViewById(R.id.Password)).setHintTextColor(Color.BLACK);
                        if(confPsw.getText().toString().equals("")){
                            ((EditText) findViewById(R.id.ConfPassword)).setHintTextColor(Color.RED);
                        }else
                            ((EditText) findViewById(R.id.ConfPassword)).setHintTextColor(Color.BLACK);
                        if(email.getText().toString().equals("")&& mailSyntaxCheck(email.getText().toString())==false ){
                            ((EditText) findViewById(R.id.Email)).setHintTextColor(Color.RED);
                        }else
                            ((EditText) findViewById(R.id.Email)).setHintTextColor(Color.BLACK);


                    }
                    if((password.getText().toString().equals(confPsw.getText().toString()))){
                        ((EditText) findViewById(R.id.Password)).setTextColor(Color.BLACK);
                        ((EditText) findViewById(R.id.ConfPassword)).setTextColor(Color.BLACK);
                    }
                }
            }
        });

    }

}
