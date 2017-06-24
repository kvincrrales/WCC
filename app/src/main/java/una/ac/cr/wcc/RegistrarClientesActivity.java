package una.ac.cr.wcc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;

public class RegistrarClientesActivity extends AppCompatActivity {
    EditText cuentaCliente,nombreCliente;
    TextView textView;
    BD_Controlador controller;
    Button btnOk;
    SwipeDismissDialog swipeDismissDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_clientes);

        cuentaCliente = (EditText)findViewById(R.id.cuentaCliente_input);
        nombreCliente = (EditText)findViewById(R.id.nombreCliente_input);

        textView = (TextView)findViewById(R.id.textView);
        //Revisar ese valor 2
        controller = new BD_Controlador(this,"",null,1);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(RegistrarClientesActivity.this, "Se registro correctamente" , Toast.LENGTH_SHORT).show();
                        try {

                        }catch (SQLiteException e){
                            Toast.makeText(RegistrarClientesActivity.this, "Ya existe esta factura", Toast.LENGTH_SHORT).show();
                        }
                        controller.insertar_cliente(cuentaCliente.getText().toString(),nombreCliente.getText().toString());
                        View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                        swipeDismissDialog = new SwipeDismissDialog.Builder(RegistrarClientesActivity.this)
                                .setView(dialog)
                                .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                                    @Override
                                    public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                        Toast.makeText(RegistrarClientesActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .build()
                                .show();

                        btnOk = (Button)dialog.findViewById(R.id.btnOk);
                        btnOk.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                Toast.makeText(RegistrarClientesActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                                swipeDismissDialog.dismiss();
                            }
                        });
                        break;
                    case R.id.action_edit:
                        Toast.makeText(RegistrarClientesActivity.this, "Listar Facturas" , Toast.LENGTH_SHORT).show();
                        controller.listar_clientes(textView);
                        break;
                    case R.id.action_remove:
                        Toast.makeText(RegistrarClientesActivity.this, "Se Elimino corrrectamente" , Toast.LENGTH_SHORT).show();
                        controller.eliminar_cliente(cuentaCliente.getText().toString());
                        break;
                }
                return true;
            }
        });
    }

    public void btn_click(View view){
        switch (view.getId()){
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

        }
    }



}
