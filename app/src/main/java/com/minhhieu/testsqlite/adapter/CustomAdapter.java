package com.minhhieu.testsqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minhhieu.testsqlite.R;
import com.minhhieu.testsqlite.model.Student;

import java.util.List;

public class CustomAdapter extends ArrayAdapter <Student> {

    private Context context;
    private int resource;
    private List<Student> listStudent;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listStudent = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listview_student,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvId = (TextView)convertView.findViewById(R.id.tv_id);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.tv_name);
            viewHolder.tvAddress = (TextView)convertView.findViewById(R.id.tv_address);
            viewHolder.tvPhoneNumber = (TextView)convertView.findViewById(R.id.tv_phone_number);
            viewHolder.tvEmail = (TextView)convertView.findViewById(R.id.tv_email);

            convertView.setTag(viewHolder);
        }else{
                viewHolder = (ViewHolder) convertView.getTag();
        }
        Student student = listStudent.get(position);
        viewHolder.tvId.setText(String.valueOf(student.getmID()));
        viewHolder.tvName.setText(student.getmName());
        viewHolder.tvAddress.setText(student.getmAddress());
        viewHolder.tvPhoneNumber.setText(student.getmPhone());
        viewHolder.tvEmail.setText(student.getmEmail());

        return convertView;
    }
    public class ViewHolder{
        private TextView tvId;
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvPhoneNumber;
        private TextView tvEmail;

    }
}
