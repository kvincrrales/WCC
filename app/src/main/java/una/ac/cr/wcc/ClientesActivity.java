package una.ac.cr.wcc;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class ClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(ClientesActivity.this, "Action Add Clicked" , Toast.LENGTH_SHORT).show();
                    case R.id.action_edit:
                        Toast.makeText(ClientesActivity.this, "Action Edit Clicked" , Toast.LENGTH_SHORT).show();
                    case R.id.action_remove:
                        Toast.makeText(ClientesActivity.this, "Action Remove Clicked" , Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
