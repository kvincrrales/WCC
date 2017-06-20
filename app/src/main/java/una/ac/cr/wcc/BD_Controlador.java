package una.ac.cr.wcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by Kevin on 19/06/2017.
 */

public class BD_Controlador extends SQLiteOpenHelper {
    public BD_Controlador(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "CAJAS.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE FACTURAS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NUMERO TEXT UNIQUE, CLIENTE TEXT, MONTO TEXT, FECHA TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE USUARIOS(ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT UNIQUE, NOMBRE TEXT, CONTRA TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS FACTURAS;");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USUARIOS;");
        onCreate(sqLiteDatabase);

    }

    public void insertar_factura(String numeroFactura, String codigoCliente, String montoFactura,String fechaFactura){
        ContentValues contentValues = new ContentValues();
        contentValues.put("NUMERO", numeroFactura);
        contentValues.put("CLIENTE", codigoCliente);
        contentValues.put("MONTO", montoFactura);
        contentValues.put("FECHA", fechaFactura);
        this.getWritableDatabase().insertOrThrow("FACTURAS","",contentValues);
    }

    public void eliminar_factura(String numeroFactura){
        this.getWritableDatabase().delete("FACTURAS","NUMERO='"+numeroFactura+"'",null);
    }

    public void actualizar_factura(String old_numero, String new_numero){
        this.getWritableDatabase().execSQL("UPDATE FACTURAS SET NUMERO='"+new_numero+"' WHERE NUMERO='"+old_numero+"'");
    }
    public void listar_facturas(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM FACTURAS", null);
        textView.setText("");
        while (cursor.moveToNext()) {
            textView.append(cursor.getString(0)+ " " +cursor.getString(1)+ " " +cursor.getString(2)+ "\n");
        }
    }

    public void insertar_usuario(String emailUsuario, String nombreUsuario,  String passUsuario){
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL", emailUsuario);
        contentValues.put("NOMBRE", nombreUsuario);
        contentValues.put("CONTRA", passUsuario);
        this.getWritableDatabase().insertOrThrow("USUARIOS","",contentValues);
    }

    public void eliminar_usuario(String emailUsuario){
        this.getWritableDatabase().delete("USUARIOS","EMAIL='"+emailUsuario+"'",null);
    }

    public void actualizar_usuario(String old_email, String new_email){
        this.getWritableDatabase().execSQL("UPDATE USUARIOS SET EMAIL='"+new_email+"' WHERE EMAIL='"+old_email+"'");
    }
    public void listar_usuarios(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM USUARIOS", null);
        textView.setText("");
        while (cursor.moveToNext()) {
            textView.append(cursor.getString(0)+ " " +cursor.getString(1)+ " " +cursor.getString(2)+ "\n");
        }
    }
}
