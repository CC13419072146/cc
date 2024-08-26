package cn.itcast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText user,password;
    Button login,register;
    DBHelper helper = new DBHelper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.editTextNumber);
        password = findViewById(R.id.editTextTextPassword2);
        login = findViewById(R.id.button);
        register = findViewById(R.id.button2);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String username = user.getText().toString().trim();
                String userPassword = password.getText().toString().trim();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(userPassword)) {
                    Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else {
                    SQLiteDatabase db = helper.getReadableDatabase();
                    Cursor cursor = db.rawQuery("select name,password from list where name = ? and password = ?",new String[]{username,userPassword});
                    if(cursor.moveToNext()) {
                        cursor.close();
                        db.close();
                        finish();
                        Intent intent = new Intent(this,First.class);
                        startActivity(intent);
                        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                    }
                    cursor.close();
                    db.close();
                    Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                break;
        }
    }
}