package una.ac.cr.wcc;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;

public class FacturasActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Button btnShowDialog,btnShowDialog2,btnShowDialog3,btnOk;
    SwipeDismissDialog swipeDismissDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturas_old);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipperFacturas);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_add:

                        Toast.makeText(FacturasActivity.this, "Action Add Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                    case R.id.action_edit:
                        Toast.makeText(FacturasActivity.this, "Action Edit Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                    case R.id.action_remove:
                        Toast.makeText(FacturasActivity.this, "Action Remove Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                }
                return true;
            }
        });

        btnShowDialog = (Button)findViewById(R.id.btnShowDialogInsertar);
        btnShowDialog2 = (Button)findViewById(R.id.btnShowDialogEditar);
        btnShowDialog3 = (Button)findViewById(R.id.btnShowDialogEliminar);
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
        btnShowDialog2.setOnClickListener(new View.OnClickListener(){
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
        btnShowDialog3.setOnClickListener(new View.OnClickListener(){
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
