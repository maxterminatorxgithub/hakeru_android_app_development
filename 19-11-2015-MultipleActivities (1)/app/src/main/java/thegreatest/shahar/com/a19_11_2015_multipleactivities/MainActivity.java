package thegreatest.shahar.com.a19_11_2015_multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSecond, btnThird, btnFourth, btnFive;
    private TextView tvData;
    private static final int SECOND_ACTIVITY_RESULT = 2;
    private static final int THIRD_ACTIVITY_RESULT = 7;
    private static final int FOURTH_ACTIVITY_RESULT = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecond = (Button) findViewById(R.id.btnSecond);
        btnThird = (Button) findViewById(R.id.btnThird);
        btnFourth = (Button) findViewById(R.id.btnFourth);
        btnFive = (Button) findViewById(R.id.btnFive);
        tvData = (TextView) findViewById(R.id.tvData);

        btnSecond.setOnClickListener(this);
        btnThird.setOnClickListener(this);
        btnFourth.setOnClickListener(this);
        btnFive.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSecond:
                Intent intentSecond = new Intent(this, SecondActivity.class);
                //startActivity(intentSecond);
                startActivityForResult(intentSecond, SECOND_ACTIVITY_RESULT);
                break;
            case R.id.btnThird:
                Intent intentThird = new Intent(this, ThirdActivity.class);
                //startActivity(intentThird);
                startActivityForResult(intentThird, THIRD_ACTIVITY_RESULT);
                break;
            case R.id.btnFourth:
                Intent intentFourth = new Intent(this, FourthActivity.class);
                startActivityForResult(intentFourth, FOURTH_ACTIVITY_RESULT);
                break;
            case R.id.btnFive:
                int age = 8;
                Intent intentFive = new Intent(this, FIfthActivity.class);
                intentFive.putExtra("num", age);
                startActivity(intentFive);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECOND_ACTIVITY_RESULT) {
            if (resultCode == RESULT_OK){
                tvData.setText((data.getStringExtra("name")));
            }
            Toast.makeText(this, "Back From Two", Toast.LENGTH_SHORT).show();
        }
        if (requestCode == THIRD_ACTIVITY_RESULT) {
            Toast.makeText(this, "Back From Three", Toast.LENGTH_SHORT).show();
        }
        if(requestCode == FOURTH_ACTIVITY_RESULT){
            if (resultCode == RESULT_OK){
                Toast.makeText
                        (this, data.getStringExtra("data"), Toast.LENGTH_SHORT).show();
            }else if (resultCode == RESULT_CANCELED){
                Toast.makeText
                        (this, "Operation Was Canceled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
