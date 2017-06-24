package una.ac.cr.wcc;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
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

public class RegistrarFacturasActivity extends AppCompatActivity {
    EditText numeroFactura,codigoCliente,montoFactura,fechaFactura;
    TextView textView;
    Button btnOk;
    SwipeDismissDialog swipeDismissDialog;
    BD_Controlador controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_facturas);

        numeroFactura = (EditText)findViewById(R.id.numeroFactura_input);
        codigoCliente = (EditText)findViewById(R.id.codigoCliente_input);
        montoFactura = (EditText)findViewById(R.id.montoFactura_input);
        fechaFactura = (EditText)findViewById(R.id.fechaFactura_input);

        textView = (TextView)findViewById(R.id.textView);

        controller = new BD_Controlador(this,"",null,1);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(RegistrarFacturasActivity.this, "Se registro correctamente" , Toast.LENGTH_SHORT).show();
                        try {

                        }catch (SQLiteException e){
                            Toast.makeText(RegistrarFacturasActivity.this, "Ya existe esta factura", Toast.LENGTH_SHORT).show();
                        }
                        controller.insertar_factura(numeroFactura.getText().toString(),codigoCliente.getText().toString(),montoFactura.getText().toString()
                                ,fechaFactura.getText().toString());
                        View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                        swipeDismissDialog = new SwipeDismissDialog.Builder(RegistrarFacturasActivity.this)
                                .setView(dialog)
                                .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                                    @Override
                                    public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                        Toast.makeText(RegistrarFacturasActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .build()
                                .show();

                        btnOk = (Button)dialog.findViewById(R.id.btnOk);
                        btnOk.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                Toast.makeText(RegistrarFacturasActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                                swipeDismissDialog.dismiss();
                            }
                        });
                        break;
                    case R.id.action_edit:
                        Toast.makeText(RegistrarFacturasActivity.this, "Loquis" , Toast.LENGTH_SHORT).show();
                       controller.listar_facturas2(textView);
                        break;
                    case R.id.action_remove:
                        Toast.makeText(RegistrarFacturasActivity.this, "Se Elimino corrrectamente" , Toast.LENGTH_SHORT).show();
                        controller.eliminar_factura(numeroFactura.getText().toString());
                        break;
                }
                return true;
            }
        });
    }
    public void btn_click(View view){
        switch (view.getId()){
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(RegistrarFacturasActivity.this);
                dialog.setTitle("DIGITE NUEVO NÚMERO DE FACTURA ");

                final EditText new_numero = new EditText(this);
                dialog.setView(new_numero);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_factura(numeroFactura.getText().toString(),new_numero.getText().toString());

                    }
                });
                dialog.show();
                break;
        }

    }
    /*
    public void btn_click(View view){
        switch (view.getId()){
            case R.id.btn_add:
                try {

                }catch (SQLiteException e){
                    Toast.makeText(RegistrarFacturasActivity.this, "ALREDY EXISTS", Toast.LENGTH_SHORT).show();
                }
                controller.insertar_factura(numeroFactura.getText().toString(),codigoCliente.getText().toString(),montoFactura.getText().toString()
                        ,fechaFactura.getText().toString());
                break;
            case R.id.btn_delete:
                controller.eliminar_factura(numeroFactura.getText().toString());
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(RegistrarFacturasActivity.this);
                dialog.setTitle("DIGITE NUEVO NÚMERO DE FACTURA ");

                final EditText new_numero = new EditText(this);
                dialog.setView(new_numero);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.actualizar_factura(numeroFactura.getText().toString(),new_numero.getText().toString());

                    }
                });
                dialog.show();
                break;
            case R.id.listar_facturas:
                controller.listar_facturas(textView);
                break;
        }

    }*/
}
