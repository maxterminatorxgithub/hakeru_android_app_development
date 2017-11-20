package thegreatest.shahar.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtName = (EditText) findViewById(R.id.txtName);
        final EditText txtPass = (EditText) findViewById(R.id.txtPass);
        Button btnPushMe = (Button) findViewById(R.id.btnPushMe);
        Button btnBravo = (Button) findViewById(R.id.btnBravo);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        final Button btnCheck = (Button) findViewById(R.id.btnCheck);
        txtInfo = (TextView) findViewById(R.id.txtInfo);

        btnPushMe.setOnClickListener(this);
        btnBravo.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnCheck.setOnClickListener(this);

        txtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (txtName.length() > 0 && txtPass.length() > 0) {
                    btnCheck.setEnabled(true);
                } else {
                    btnCheck.setEnabled(false);
                }
            }
        });

        txtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (txtName.length() > 0 && txtPass.length() > 0) {
                    btnCheck.setEnabled(true);
                } else {
                    btnCheck.setEnabled(false);
                }
            }
        });
//        btnPushMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtInfo.setText("Push Me");
//            }
//        });
//        btnBravo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtInfo.setText("Bravo");
//            }
//        });
//        btnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                txtInfo.setText("");
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnPushMe:
                txtInfo.setText("Push Me");
                break;
            case R.id.btnBravo:
                txtInfo.setText("Bravo");
                break;
            case R.id.btnClear:
                txtInfo.setText("");
                break;
            case R.id.btnCheck:
                txtInfo.setText("Success");
                break;
        }
    }
}
