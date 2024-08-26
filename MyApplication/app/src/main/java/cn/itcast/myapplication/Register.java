package cn.itcast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Button button;
    String name,emil,pwd,sex,hobbys;
    EditText edit_name,edit_emil,edit_pwd;
    RadioGroup rg_sex;
    CheckBox cb_sing,cb_dance,cb_read;
    DBHelper helper = new DBHelper(Register.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    public void init() {
        edit_emil = findViewById(R.id.edit_emil);
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_password);
        cb_sing = findViewById(R.id.sing);
        cb_dance = findViewById(R.id.dance);
        cb_read = findViewById(R.id.read);
        rg_sex = findViewById(R.id.sex);
        button = findViewById(R.id.register);
        button.setOnClickListener(this);
        cb_sing.setOnCheckedChangeListener(this);
        cb_dance.setOnCheckedChangeListener(this);
        cb_read.setOnCheckedChangeListener(this);
        hobbys = new String();
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.Man :
                        sex = "男";break;
                    case R.id.Woman :
                        sex = "女";break;
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        name = edit_name.getText().toString();
        emil = edit_emil.getText().toString();
        pwd = edit_pwd.getText().toString();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"请输入姓名",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(emil)) {
            Toast.makeText(this,"请输入邮箱",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(sex)) {
            Toast.makeText(this,"请选择性别",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(hobbys)) {
            Toast.makeText(this,"请选择爱好",Toast.LENGTH_SHORT).show();
        }else {
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into list(name,password,email,sex,aihao) values(?,?,?,?,?)",new String[]{name,pwd,emil,sex,hobbys});
            db.close();
            finish();
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            Log.i("MyinActivitu","注册用户的信息:"+"名字"+name+"邮箱"+emil+"密码"+pwd+"性别"+sex+"爱好"+hobbys);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String motion = compoundButton.getText().toString();
        if(b) {
            if(!hobbys.contains(motion)) {
                hobbys = hobbys + motion;
            }
        }else {
            if(hobbys.contains(motion)){
                hobbys = hobbys.replace(motion,"");
            }
        }
    }
}