package una.ac.cr.wcc;

import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;

public class Registro extends AppCompatActivity {
    private EditText et_username, et_email_entry, et_pass_entry;
    private String username, email_entry, pass_entry;
    Button boton_registrar;
    Button btnOk;
    SwipeDismissDialog swipeDismissDialog;
    EditText nombreUsuario,emailUsuario,passUsuario;
    BD_Controlador controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        et_username = (EditText) findViewById(R.id.username);
        et_email_entry = (EditText) findViewById(R.id.email_entry);
        et_pass_entry = (EditText) findViewById(R.id.pass_entry);
        boton_registrar = (Button) findViewById(R.id.boton_registrar);
        controller = new BD_Controlador(this,"",null,1);
        boton_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                }catch (SQLiteException e){
                    Toast.makeText(Registro.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
                }
                controller.insertar_usuario( et_email_entry.getText().toString(), et_username.getText().toString(),et_pass_entry.getText().toString());
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(Registro.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(Registro.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(Registro.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });
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
        try {

        }catch (SQLiteException e){
            Toast.makeText(Registro.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
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
