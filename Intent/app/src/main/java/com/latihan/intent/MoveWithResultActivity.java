package com.latihan.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MoveWithResultActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rbGroup;
    Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_result);

        rbGroup = findViewById(R.id.rb_group);

        btnChoose = findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int selectedId = rbGroup.getCheckedRadioButtonId();

        Intent intent = new Intent();

        switch (selectedId){
            case R.id.rb_50 :
                quickActivity(intent, 50);
                break;

            case R.id.rb_100 :
                quickActivity(intent, 100);
                break;

            case R.id.rb_150 :
                quickActivity(intent, 150);
                break;

            case R.id.rb_200 :
                quickActivity(intent, 200);
                break;

                default:
                    Toast.makeText(this, "pilih salah satu", Toast.LENGTH_SHORT).show();
        }
    }

    public void quickActivity (Intent i, int j){
        i = new Intent(MoveWithResultActivity.this, MainActivity.class);
        i.putExtra("result", j);
        startActivity(i);
    }
}
