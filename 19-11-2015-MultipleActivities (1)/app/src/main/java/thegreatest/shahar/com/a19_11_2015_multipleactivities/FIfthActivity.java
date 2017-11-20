package thegreatest.shahar.com.a19_11_2015_multipleactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FIfthActivity extends AppCompatActivity {

    private TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        tvData = (TextView)findViewById(R.id.tvData);
        int myNumber = getIntent().getIntExtra("numOne", -1);
        tvData.setText(String.valueOf(myNumber));
    }
}
