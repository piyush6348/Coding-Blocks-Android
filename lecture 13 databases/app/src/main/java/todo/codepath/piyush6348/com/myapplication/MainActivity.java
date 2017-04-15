package todo.codepath.piyush6348.com.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import todo.codepath.piyush6348.com.myapplication.db.MyDatabaseHelper;
import todo.codepath.piyush6348.com.myapplication.db.ToDo;
import todo.codepath.piyush6348.com.myapplication.db.ToDoTable;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button btn;
    private ListAdapter toDoAdapter;
    private SQLiteDatabase db;
    ArrayList<ToDo> toDoS=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDatabaseHelper databaseHelper=new MyDatabaseHelper(this);
        db=databaseHelper.getWritableDatabase();

        listView=(ListView) findViewById(R.id.list_view);
        editText= (EditText) findViewById(R.id.edit_text);
        btn= (Button) findViewById(R.id.button_add);

        toDoAdapter=new ListAdapter(toDoS,this);
        listView.setAdapter(toDoAdapter);
        refreshToDos();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDo obj=new ToDo(editText.getText().toString(),false);
                ToDoTable.addTask(db,obj);
                refreshToDos();
            }
        });
    }
    void refreshToDos(){
        toDoAdapter.updateToDoS(ToDoTable.fetchToDos(db));
    }
}
