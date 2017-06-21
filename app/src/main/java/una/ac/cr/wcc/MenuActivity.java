package una.ac.cr.wcc;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MenuActivity extends AppCompatActivity {
    String arrayName[] ={
            "Facturas",
            "Clientes",
            "Usuarios",
            "Otros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        CircleMenu circleMenu = (CircleMenu)findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.pokeball, R.drawable.pokeball)
                .addSubMenu(Color.parseColor("#AED6F1"),R.drawable.squirtle)
                .addSubMenu(Color.parseColor("#ABEBC6"),R.drawable.bullbasaur)
                .addSubMenu(Color.parseColor("#FADBD8"),R.drawable.charmander)
                .addSubMenu(Color.parseColor("#FAD7A0"),R.drawable.pikachu)
                .setOnMenuSelectedListener(new OnMenuSelectedListener(){

                    @Override
                    public void onMenuSelected(int index){
                        switch (index) {
                            case 0:

                                Intent intent = new Intent(MenuActivity.this, RegistrarFacturasActivity.class);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(MenuActivity.this, RegistrarUsuariosActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(MenuActivity.this, RegistrarClientesActivity.class);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(MenuActivity.this, RegistrarFacturaActivity.class);
                                startActivity(intent);
                                break;
                        }

                        Toast.makeText(MenuActivity.this, "Selecciono el menú " +arrayName[index], Toast.LENGTH_SHORT).show();}
    });}
}
