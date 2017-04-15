package todo.codepath.piyush6348.com.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import todo.codepath.piyush6348.com.myapplication.db.ToDo;


public class ListAdapter extends BaseAdapter {

    private List<ToDo> toDoList;
    private MainActivity inst;

    public ListAdapter(List<ToDo> toDoList, MainActivity inst) {
        this.toDoList = toDoList;
        this.inst = inst;
    }
    @Override
    public int getCount() {
        return toDoList.size();
    }

    @Override
    public Object getItem(int i) {
        return toDoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
    void updateToDoS(List<ToDo> arrayList)
    {
        toDoList=arrayList;
        notifyDataSetChanged();
    }
}
