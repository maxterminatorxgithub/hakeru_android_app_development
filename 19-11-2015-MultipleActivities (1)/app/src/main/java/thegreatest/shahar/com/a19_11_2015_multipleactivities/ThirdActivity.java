package thegreatest.shahar.com.a19_11_2015_multipleactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private Button btnMain;
    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btnMain = (Button) findViewById(R.id.btnMain);
        etData = (EditText) findViewById(R.id.etData);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = etData.getText().toString().trim();
                if (!content.isEmpty()){
                    //go to main activity
                    //Intent mainIntent = new Intent(ThirdActivity.this, MainActivity.class);
                    //startActivity(mainIntent);
                    finish();
                }else{
                    //If we want the context inside anon functions we must use
                    //the name of the object.this - name_of_the_current_activity.this
                    Toast.makeText(ThirdActivity.this, "Can't Go Back, Text Is Empty", Toast.LENGTH_LONG).show();
                    etData.setError("Data Cannot Be Empty.... IDIOT!");
                }
            }
        });
    }
}
