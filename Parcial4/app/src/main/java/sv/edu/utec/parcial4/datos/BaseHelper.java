package sv.edu.utec.parcial4.datos;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS=1;
    private static final String NOMBRE_BASE="Parcial04.db";
    public static final String NOMBRE_TABLAC="MD_Clientes";
    private static final String NOMBRE_TABLAV="MD_Vehiculos";
    private static final String NOMBRE_TABLACV="MD_ClienteVehiculo";

    public BaseHelper(@Nullable Context context) {

        super(context, NOMBRE_BASE, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+NOMBRE_TABLAC+" ("+
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sNombreCliente TEXT NOT NULL ,"+
                "sApellidoCliente TEXT NOT NULL ,"+
                "sDireccionCliente TEXT NOT NULL"
                +")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLAV+" ("+
                "ID_Vehiculo INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                "sMarca TEXT NOT NULL ,"+
                "sModelo TEXT NOT NULL "
                +")");

        db.execSQL("CREATE TABLE "+NOMBRE_TABLACV+" ("+
                "idCliente INTEGER ,"+
                "idVehiculo INTEGER NOT NULL ,"+
                "iKilometro REAL NOT NULL ,"+
                "sDireccionCliente TEXT NOT NULL"
                +")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+NOMBRE_TABLAPR);

                onCreate(db);

    }
}