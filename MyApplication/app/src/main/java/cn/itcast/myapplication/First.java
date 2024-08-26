package cn.itcast.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class First extends AppCompatActivity implements View.OnClickListener{
    ListView listView;
    TextView textView,textView5;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist);
        listView = findViewById(R.id.listView);
        ListAdpater adpater = new ListAdpater(this);
        listView.setAdapter(adpater);
        textView = findViewById(R.id.textView);
        textView5 = findViewById(R.id.textView5);
        textView.setOnClickListener(this);
        textView5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView:
                Intent intent = new Intent(this,Recommend.class);
                startActivity(intent);
                break;
            case R.id.textView5:
                Intent intent1 = new Intent(this,Mine.class);
                startActivity(intent1);
                break;
        }
    }
}