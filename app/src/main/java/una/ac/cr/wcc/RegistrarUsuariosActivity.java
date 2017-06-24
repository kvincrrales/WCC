package una.ac.cr.wcc;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
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

public class RegistrarUsuariosActivity extends AppCompatActivity {
    private EditText et_nombreUsuario_input, et_emailUsuario_input, et_passUsuario_input;
    private String nombreUsuario_input, emailUsuario_input, passUsuario_input;
    Button btn_update;
    Button btnOk;
    SwipeDismissDialog swipeDismissDialog;
    EditText nombreUsuario,emailUsuario,passUsuario;
    TextView textView;
    BD_Controlador controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuarios);

        nombreUsuario = (EditText)findViewById(R.id.nombreUsuario_input);
        emailUsuario = (EditText)findViewById(R.id.emailUsuario_input);
        passUsuario = (EditText)findViewById(R.id.passUsuario_input);

        textView = (TextView)findViewById(R.id.textView);

        controller = new BD_Controlador(this,"",null,1);

        et_nombreUsuario_input = (EditText) findViewById(R.id.nombreUsuario_input);
        et_emailUsuario_input = (EditText) findViewById(R.id.emailUsuario_input);
        et_passUsuario_input = (EditText) findViewById(R.id.passUsuario_input);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registroUsuario();
            }
        });
    }

    public void registroUsuario() {
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
        if(nombreUsuario_input.isEmpty()||nombreUsuario_input.length()>15){
            et_nombreUsuario_input.setError("Ingrese un nombre de usuario");
            valid = false;
        }
        if(emailUsuario_input.isEmpty()|| Patterns.EMAIL_ADDRESS.matcher(emailUsuario_input).matches()){
            et_emailUsuario_input.setError("Ingrese un email");
            valid = false;
        }
        if(passUsuario_input.isEmpty()){
            et_passUsuario_input.setError("Ingrese un password");
            valid = false;
        }
        return valid;
    }
    public void intiliaze(){
        nombreUsuario_input = et_nombreUsuario_input.getText().toString().trim();
        emailUsuario_input = et_emailUsuario_input.getText().toString().trim();
        passUsuario_input = et_passUsuario_input.getText().toString().trim();
    }

    public void btn_click(View view){
        switch (view.getId()){
            //COMENTADOS PORQUE NO NOS SIRVEN POR USABILIDAD SIN EMBARGO AQUI ESTA LA FUNCIONALIDAD
            case R.id.btn_add:
                try {

                }catch (SQLiteException e){
                    Toast.makeText(RegistrarUsuariosActivity.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
                }
                controller.insertar_usuario(emailUsuario.getText().toString(),nombreUsuario.getText().toString(),passUsuario.getText().toString());
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(RegistrarUsuariosActivity.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(RegistrarUsuariosActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(RegistrarUsuariosActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });

                break;
            case R.id.btn_delete:
                controller.eliminar_usuario(emailUsuario.getText().toString());
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog2 = new AlertDialog.Builder(RegistrarUsuariosActivity.this);
                dialog2.setTitle("DIGITE LA NUEVA CONTRASEÑA");

                final EditText new_PASS = new EditText(this);
                dialog2.setView(new_PASS);
                dialog2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_pass(passUsuario.getText().toString(),new_PASS.getText().toString());
                    }
                });
                dialog2.show();

                AlertDialog.Builder dialog4 = new AlertDialog.Builder(RegistrarUsuariosActivity.this);
                dialog4.setTitle("DIGITE EL NUEVO EMAIL DEL USUARIO ");

                final EditText new_email = new EditText(this);
                dialog4.setView(new_email);


                dialog4.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_usuario(emailUsuario.getText().toString(),new_email.getText().toString());

                    }
                });
                dialog4.show();

            case R.id.listar_usuarios:
                controller.listar_usuarios(textView);
                break;
        }
    }
}
