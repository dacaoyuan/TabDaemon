package com.example.tabdaemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4,R.id.button5,R.id.button6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, Main2Activity.class));

                break;
            case R.id.button2:
                startActivity(new Intent(this, Main3Activity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, Main4Activity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, Main5Activity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, Main6Activity.class));

                break;
            case R.id.button6:
                startActivity(new Intent(this, Main7Activity.class));

                break;
        }
    }
}
