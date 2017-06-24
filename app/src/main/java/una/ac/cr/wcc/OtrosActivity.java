package una.ac.cr.wcc;

import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class OtrosActivity extends AppCompatActivity {

    TextView textViewNombre,textViewMonto,textViewFactura,textViewFecha;

    BD_Controlador controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pendientes);
        textViewNombre = (TextView)findViewById(R.id.textViewNOMBRE);
        textViewMonto = (TextView)findViewById(R.id.textViewMONTO);
        textViewFactura = (TextView)findViewById(R.id.textViewFACTURA);
        textViewFecha = (TextView)findViewById(R.id.textViewFECHA);

        controller = new BD_Controlador(this,"",null,1);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(OtrosActivity.this, "Mostrar Todas" , Toast.LENGTH_SHORT).show();
                        controller.listar_facturas(textViewFactura,textViewNombre,textViewMonto,textViewFecha);
                        break;
                    case R.id.action_edit:
                        Toast.makeText(OtrosActivity.this, "Mostrar por cliente" , Toast.LENGTH_SHORT).show();

                        break;

                }
                return true;
            }
        });
    }
}
