package thegreatest.shahar.com.a19_11_2015_multipleactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by hackeru on 19/11/2017.
 */

public class SecondActivity extends AppCompatActivity {

    private Button btnMain;
    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnMain = (Button) findViewById(R.id.btnMain);
        etData = (EditText) findViewById(R.id.etData);

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = etData.getText().toString().trim();
                if (!content.isEmpty()){
                    //go to main activity
                    //Intent mainIntent = new Intent(SecondActivity.this, MainActivity.class);
                    //startActivity(mainIntent);
                    Intent mainIntent = new Intent();
                    mainIntent.putExtra("name", content);
                    setResult(RESULT_OK, mainIntent);
                    finish();
                }else{
                    //If we want the context inside anon functions we must use
                    //the name of the object.this - name_of_the_current_activity.this
                    Toast.makeText(SecondActivity.this, "Can't Go Back, Text Is Empty", Toast.LENGTH_LONG).show();
                    etData.setError("Data Cannot Be Empty.... IDIOT!");
                }
            }
        });


        //Toast.makeText(this, "Can't Go Back, Text Is Empty", Toast.LENGTH_LONG).show();
    }

//    public void Do(View view){
//        //this is redundent - no need to call for the activity
//        Toast.makeText(SecondActivity.this, "Can't Go Back, Text Is Empty", Toast.LENGTH_LONG).show();
//
//        //The right way of doing it:
//        Toast.makeText(this, "Can't Go Back, Text Is Empty", Toast.LENGTH_LONG).show();
//    }
}
