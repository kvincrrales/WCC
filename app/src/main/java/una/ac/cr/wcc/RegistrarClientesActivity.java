package una.ac.cr.wcc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarClientesActivity extends AppCompatActivity {
    EditText cuentaCliente,nombreCliente;
    TextView textView;
    BD_Controlador controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_clientes);

        cuentaCliente = (EditText)findViewById(R.id.cuentaCliente_input);
        nombreCliente = (EditText)findViewById(R.id.nombreCliente_input);

        textView = (TextView)findViewById(R.id.textView);
        //Revisar ese valor 2
        controller = new BD_Controlador(this,"",null,1);
    }

    public void btn_click(View view){
        switch (view.getId()){
            case R.id.btn_add:
                try {

                }catch (SQLiteException e){
                    Toast.makeText(RegistrarClientesActivity.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
                }
                controller.insertar_cliente(cuentaCliente.getText().toString(),nombreCliente.getText().toString());
                break;
            case R.id.btn_delete:
                controller.eliminar_cliente(cuentaCliente.getText().toString());
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(RegistrarClientesActivity.this);
                dialog.setTitle("DIGITE LA NUEVA CUENTA CLIENTE ");

                final EditText new_cuenta = new EditText(this);
                dialog.setView(new_cuenta);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_cliente(cuentaCliente.getText().toString(),new_cuenta.getText().toString());

                    }
                });
                dialog.show();
                break;
            case R.id.listar_clientes:
                controller.listar_clientes(textView);
                break;
        }
    }
}
