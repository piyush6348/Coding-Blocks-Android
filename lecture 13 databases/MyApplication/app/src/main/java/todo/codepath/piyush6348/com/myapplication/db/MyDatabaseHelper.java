package todo.codepath.piyush6348.com.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dell on 4/15/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final int VER=1;
    public static final String name="piyush.db";
    public MyDatabaseHelper(Context context) {
        super(context, name, null,VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ToDoTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
