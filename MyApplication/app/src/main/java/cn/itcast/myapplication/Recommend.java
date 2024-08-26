package cn.itcast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Recommend extends AppCompatActivity implements View.OnClickListener {
    TextView textView2,textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend);
        textView2 = findViewById(R.id.textView2);
        textView5 = findViewById(R.id.textView5);
        textView2.setOnClickListener(this);
        textView5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView2:
                Intent intent = new Intent(this,First.class);
                startActivity(intent);
                break;
            case R.id.textView5:
                Intent intent1 = new Intent(this,Mine.class);
                startActivity(intent1);
                break;
        }
    }
}