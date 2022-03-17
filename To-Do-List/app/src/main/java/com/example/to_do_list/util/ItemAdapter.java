package com.example.to_do_list.util;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.to_do_list.R;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {
    private int layout;

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.layout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater)
            getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout,parent,false);
        }
        TextView txtNomeNote =(TextView)convertView.findViewById(R.id.txtNomeNote);

        Item item = this.getItem(position);

        txtNomeNote.setText((item.getNome()));
        txtNomeNote.setTextColor(Color.WHITE);

       switch(item.getPrioridade()){
           case 1:
               convertView.setBackgroundColor(Color.BLUE);
               break;
           case 2:
               txtNomeNote.setTextColor(Color.BLACK);
               convertView.setBackgroundColor(Color.YELLOW);
               break;
           case 3:
               convertView.setBackgroundColor(Color.RED);
               break;
       }

        return convertView;
    }
}
