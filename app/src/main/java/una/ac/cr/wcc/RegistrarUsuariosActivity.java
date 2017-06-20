package una.ac.cr.wcc;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarUsuariosActivity extends AppCompatActivity {
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

        controller = new BD_Controlador(this,"",null,2);
    }

    public void btn_click(View view){
        switch (view.getId()){
            case R.id.btn_add:
                try {

                }catch (SQLiteException e){
                    Toast.makeText(RegistrarUsuariosActivity.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
                }
                controller.insertar_usuario(emailUsuario.getText().toString(),nombreUsuario.getText().toString(),passUsuario.getText().toString());
                break;
            case R.id.btn_delete:
                controller.eliminar_usuario(emailUsuario.getText().toString());
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(RegistrarUsuariosActivity.this);
                dialog.setTitle("DIGITE EL NUEVO EMAIL DEL USUARIO ");

                final EditText new_email = new EditText(this);
                dialog.setView(new_email);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_usuario(emailUsuario.getText().toString(),new_email.getText().toString());

                    }
                });
                dialog.show();
                break;
            case R.id.listar_usuarios:
                controller.listar_usuarios(textView);
                break;
        }
    }
}
