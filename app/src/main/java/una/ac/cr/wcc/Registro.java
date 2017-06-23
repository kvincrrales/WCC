package una.ac.cr.wcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    private EditText et_username, et_email_entry, et_pass_entry;
    private String username, email_entry, pass_entry;
    Button boton_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et_username = (EditText) findViewById(R.id.username);
        et_email_entry = (EditText) findViewById(R.id.email_entry);
        et_pass_entry = (EditText) findViewById(R.id.pass_entry);
        boton_registrar = (Button) findViewById(R.id.boton_registrar);
        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

    }
    public void registro() {
        intiliaze();
        if (!validate()) {
            Toast.makeText(this, "Fallo el registro", Toast.LENGTH_SHORT).show();
        } else {
            onSignupSuccess();
        }
    }
    public void onSignupSuccess(){

    }
    public boolean validate(){
        boolean valid = true;
        if(username.isEmpty()||username.length()>15){
            et_username.setError("Ingrese un nombre de usuario");
            valid = false;
        }
        if(email_entry.isEmpty()|| Patterns.EMAIL_ADDRESS.matcher(email_entry).matches()){
            et_email_entry.setError("Ingrese un email");
            valid = false;
        }
        if(pass_entry.isEmpty()){
            et_pass_entry.setError("Ingrese un password");
            valid = false;
        }
        return valid;
    }
    public void intiliaze(){
        username = et_username.getText().toString().trim();
        email_entry = et_email_entry.getText().toString().trim();
        pass_entry = et_pass_entry.getText().toString().trim();
    }

}
