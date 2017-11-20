package thegreatest.shahar.com.mydonation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnDonate;
    private RadioGroup rgMethod;
    private ProgressBar progressBar;
    private NumberPicker npAmount;
    private RelativeLayout relLayoutInfo, relLayoutImage;
    private int totalAmount = 0;
    private static final double BITCOIN_RATE = 3000;
    private static final double DOLLAR_RATE = 3.5;
    private static final double AMOUNT_SUCCESS = 10000 * DOLLAR_RATE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        btnDonate = (Button) findViewById(R.id.btnDonate);
        rgMethod = (RadioGroup) findViewById(R.id.rgMethod);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        npAmount = (NumberPicker) findViewById(R.id.npAmount);
        relLayoutInfo = (RelativeLayout) findViewById(R.id.relLayoutInfo);
        relLayoutImage = (RelativeLayout) findViewById(R.id.relLayoutImage);


        npAmount.setMinValue(1);
        npAmount.setMaxValue(1000);
        progressBar.setMax((int)AMOUNT_SUCCESS);

        btnDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = npAmount.getValue();
                int radioId = rgMethod.getCheckedRadioButtonId();

                String method;

                if (radioId == R.id.rbPaypal) {
                    method = "PayPal";
                    totalAmount += amount;
                } else {
                    method = "BitCoin";
                    totalAmount += amount * BITCOIN_RATE;
                }
                Toast.makeText(getApplicationContext(),
                        "You Donated: " + amount + "NIS Via " +
                                method, Toast.LENGTH_LONG).show();
                totalAmount += amount;
                progressBar.setProgress(totalAmount);
                if (totalAmount >= AMOUNT_SUCCESS){
                    relLayoutInfo.setVisibility(View.INVISIBLE);
                    relLayoutImage.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}