package una.ac.cr.wcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;

public class FacturasActivity extends AppCompatActivity {

    Button btnShowDialog,btnOk;
    SwipeDismissDialog swipeDismissDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturas);

        btnShowDialog = (Button)findViewById(R.id.btnShowDialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(FacturasActivity.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(FacturasActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(FacturasActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });
            }
        });
    }
}
