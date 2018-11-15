package fr.wildcodeschool.appquest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = findViewById(R.id.submit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                String firstName   = ((EditText)findViewById(R.id.firstName)).getText().toString();
                String lastName   = ((EditText)findViewById(R.id.lastName)).getText().toString();
                boolean inputFilled = firstName == null || "".equals(firstName.trim())
                        || lastName == null || "".equals(lastName.trim());
                if(inputFilled) {
                    String msg = context.getString(R.string.fillFirstLastName);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, msg, duration);
                    toast.show();
                } else {
                    TextView congratTextView = (TextView)findViewById(R.id.welcomeMsg);
                    congratTextView.setText(context.getString(R.string.congrats));
                    congratTextView.append(" " + firstName + " " + lastName);
                }
            }
        });


        final CheckBox myCb = findViewById(R.id.checkBox);
        myCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  findViewById(R.id.firstName).setEnabled(isChecked);
                  findViewById(R.id.lastName).setEnabled(isChecked);
            }
        });

    }
}
