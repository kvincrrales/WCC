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

public class ClientesActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    Button btnShowDialog,btnShowDialog2,btnShowDialog3,btnOk;
    SwipeDismissDialog swipeDismissDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_add:

                        Toast.makeText(ClientesActivity.this, "Action Add Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                    case R.id.action_edit:
                        Toast.makeText(ClientesActivity.this, "Action Edit Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                    case R.id.action_remove:
                        Toast.makeText(ClientesActivity.this, "Action Remove Clicked" , Toast.LENGTH_SHORT).show();
                        //FIXME
                        viewFlipper.showNext();
                }
                return true;
            }
        });

        btnShowDialog = (Button)findViewById(R.id.btnShowDialog);
        btnShowDialog2 = (Button)findViewById(R.id.btnShowDialog2);
        btnShowDialog3 = (Button)findViewById(R.id.btnShowDialog3);

        btnShowDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(ClientesActivity.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(ClientesActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(ClientesActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });
            }
        });
        btnShowDialog2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(ClientesActivity.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(ClientesActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(ClientesActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });
            }
        });
        btnShowDialog3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                View dialog = LayoutInflater.from(getBaseContext()).inflate(R.layout.dialog_success,null);

                swipeDismissDialog = new SwipeDismissDialog.Builder(ClientesActivity.this)
                        .setView(dialog)
                        .setOnSwipeDismissListener(new OnSwipeDismissListener() {
                            @Override
                            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
                                Toast.makeText(ClientesActivity.this, "Dismiss on left "+direction, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();

                btnOk = (Button)dialog.findViewById(R.id.btnOk);
                btnOk.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Toast.makeText(ClientesActivity.this, "Click OK !!!", Toast.LENGTH_SHORT).show();
                        swipeDismissDialog.dismiss();
                    }
                });
            }
        });
    }
}
