package una.ac.cr.wcc;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class OtrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pendientes);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_add:
                        Toast.makeText(OtrosActivity.this, "Action Add Clicked" , Toast.LENGTH_SHORT).show();
                    case R.id.action_edit:
                        Toast.makeText(OtrosActivity.this, "Action Edit Clicked" , Toast.LENGTH_SHORT).show();
                    case R.id.action_remove:
                        Toast.makeText(OtrosActivity.this, "Action Remove Clicked" , Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
