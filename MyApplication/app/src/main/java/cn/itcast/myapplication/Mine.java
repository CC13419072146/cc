package cn.itcast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Mine extends AppCompatActivity implements View.OnClickListener{
    TextView textView13,textView14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine);
        textView13 = findViewById(R.id.textView13);
        textView14 = findViewById(R.id.textView14);
        textView13.setOnClickListener(this);
        textView14.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView13:
                Intent intent = new Intent(this,Recommend.class);
                startActivity(intent);
                break;
            case R.id.textView14:
                Intent intent1 = new Intent(this,First.class);
                startActivity(intent1);
                break;
        }
    }
}