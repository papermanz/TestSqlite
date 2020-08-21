package com.minhhieu.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.minhhieu.testsqlite.adapter.CustomAdapter;
import com.minhhieu.testsqlite.data.DBManager;
import com.minhhieu.testsqlite.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText edtName, edtAddress, edtEmail, edtPhonenumber;
    private Button btnSave;
    private ListView lvStudent;
    private DBManager dbManager;
    private CustomAdapter customAdapter;
    private List<Student> students;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBManager dbManager = new DBManager(this);
        initWidget();

        students = dbManager.getAllStudent();
        setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = createStudent();
                if(student != null){
                    dbManager.addStudent(student);
                }
                students.clear();
                students.addAll(dbManager.getAllStudent());
                setAdapter();
            }
        });

    }
    private Student createStudent(){
        // ba kiểu ép sang kiểu string thông dụng
        String name = edtName.getText().toString();
        String address = String.valueOf(edtAddress.getText());
        String phoneNumber = edtPhonenumber.getText()+"";
        String email = edtEmail.getText().toString();

        Student student = new Student(name, address, phoneNumber,email);
        return student;
    }
    private  void initWidget(){
        edtName = (EditText)findViewById(R.id.edt_name);
        edtAddress = (EditText)findViewById(R.id.edt_address);
        edtEmail = (EditText)findViewById(R.id.edt_email);
        edtPhonenumber = (EditText)findViewById(R.id.edt_number);
        lvStudent = (ListView)findViewById(R.id.lv_student);
        btnSave = (Button)findViewById(R.id.btn_save);
    }
    // đổ dữ liệu database lên listview

    private void setAdapter(){
        if(customAdapter ==null){
            customAdapter = new CustomAdapter(this, R.layout.item_listview_student,students);
            lvStudent.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            lvStudent.setSelection(customAdapter.getCount()-1);
        }

    }


}