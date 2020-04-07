package com.latihan.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnMoveActivity, btnMoveWithData, btnDialNumber, btnMoveWithResult;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveWithData = findViewById(R.id.btn_move_with_data);
        btnMoveWithData.setOnClickListener(this);

        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        btnMoveWithResult = findViewById(R.id.btn_move_with_result);
        btnMoveWithResult.setOnClickListener(this);

        tvResult = findViewById(R.id.tv_result);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                int result = bundle.getInt("result");
                String res = String.valueOf(result);
                tvResult.setText(res);
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(moveActivity);
                break;

            case R.id.btn_move_with_data:
                Intent moveWithData = new Intent(getApplicationContext(), MoveWithDataActivity.class);
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "Daru");
                moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 19);
                startActivity(moveWithData);
                break;

            case R.id.btn_dial_number:
                String number = "082136564484";
                Intent dialNumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));

                /* BISA JUGA GINI
                Intent dialNumber = new Intent(Intent.ACTION_DIAL);
                dialNumber.setData(Uri.parse("tel:" + number));
                */

                startActivity(dialNumber);
                break;

            case R.id.btn_move_with_result:
                Intent moveResult = new Intent(MainActivity.this, MoveWithResultActivity.class);
                startActivity(moveResult);
                break;
        }
    }
}
