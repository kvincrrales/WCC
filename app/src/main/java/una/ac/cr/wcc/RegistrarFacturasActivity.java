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

public class RegistrarFacturasActivity extends AppCompatActivity {
    EditText numeroFactura,codigoCliente,montoFactura,fechaFactura;
    TextView textView;
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
    }

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
    }
}
