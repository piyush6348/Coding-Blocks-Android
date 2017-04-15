package todo.codepath.piyush6348.com.myapplication.db;

/**
 * Created by dell on 4/15/2017.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import static todo.codepath.piyush6348.com.myapplication.db.DbConsts.*;
public class ToDoTable {

    interface Columns{
        String TASK="task";
        String ID="id";
        String DONE="done";
    }

    public static final String CREATE_TABLE=
            CREATE_TABLE_INE+ TABLE_NAME +
                    LCB+
                    Columns.ID+TYPE_INT +TYPE_PK+ TYPE_AUTOINCR+COMMA+
                    Columns.TASK+TYPE_TEXT+COMMA+
                    Columns.DONE+TYPE_BOOL+
                    RCB+SEMICOL;

    public static final String INSERT_VALUES=
            INSERT_INTO+LCB;

    public static final String UPDATE_TABLE=ALTER_TABLE +ADD +
            Columns.DONE;


    public static void addTask(SQLiteDatabase db,ToDo newToDo){
        //db.execSQL(INSERT_VALUES + taskName+RCB);

        if(db.isReadOnly()){
            return;}

        ContentValues cv=new ContentValues();
        cv.put(Columns.TASK,newToDo.getTask());
        cv.put(Columns.DONE,false);
        db.insert(TABLE_NAME,null,cv);
    }

    public static ArrayList<ToDo> fetchToDos(SQLiteDatabase db){
        Cursor c=db.query(TABLE_NAME,new String[]{Columns.TASK,Columns.DONE,Columns.ID},null,null,null,null,null);
        ArrayList<ToDo> arrList=new ArrayList<>();

        int taskIndex=(c.getColumnIndex(Columns.TASK));
        int doneIndex=(c.getColumnIndex(Columns.DONE));
        int idIndex=(c.getColumnIndex(Columns.ID));

        if(c.getCount()>0)
        Log.e("fetchToDos: ",taskIndex +" "+doneIndex+" "+idIndex );
        if(c.moveToFirst()){
            do {
                boolean value;
                if(c.getInt(doneIndex)==1)
                    value=true;
                else
                    value=false;
                ToDo obj=new ToDo(c.getString(taskIndex),value,c.getInt(idIndex));
                arrList.add(obj);
            }while (c.moveToNext());
        }
        c.close();
        return arrList;
    }
    public static void setDone(SQLiteDatabase db,ToDo updateThisTodo)
    {
        ContentValues cv=new ContentValues();
        cv.put(Columns.DONE,false);

        db.update(TABLE_NAME,cv,Columns.ID +" =? ",new String[]{String.valueOf(updateThisTodo.getId())});
    }

}
