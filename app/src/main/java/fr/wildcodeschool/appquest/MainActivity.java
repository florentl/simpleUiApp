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
        final EditText firstNameINput = findViewById(R.id.firstName);
        final EditText lastNameInput = findViewById(R.id.lastName);
        final CheckBox myCb = findViewById(R.id.checkBox);
        final TextView congratTextView = findViewById(R.id.welcomeMsg);
        final Button button = findViewById(R.id.submit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Context context = getApplicationContext();
                String firstName   = firstNameINput.getText().toString();
                String lastName   = lastNameInput.getText().toString();
                boolean inputFilled = "".equals(firstName.trim()) || "".equals(lastName.trim());
                if(inputFilled) {
                    String msg = context.getString(R.string.fillFirstLastName);
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, msg, duration);
                    toast.show();
                } else {
                    congratTextView.setText(context.getString(R.string.congrats));
                    congratTextView.append(" " + firstName + " " + lastName);
                    firstNameINput.setText("");
                    lastNameInput.setText("");
                    myCb.setChecked(false);
                    firstNameINput.setEnabled(false);
                    lastNameInput.setEnabled(false);
                    button.setEnabled(false);
                }
            }
        });


        myCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  findViewById(R.id.firstName).setEnabled(isChecked);
                  findViewById(R.id.lastName).setEnabled(isChecked);
                  button.setEnabled(isChecked);

                  if(!isChecked) {
                      firstNameINput.setText("");
                      lastNameInput.setText("");
                  }else {
                      congratTextView.setText("");
                  }
            }
        });

    }
}
