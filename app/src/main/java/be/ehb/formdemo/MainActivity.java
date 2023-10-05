package be.ehb.formdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = etUser.getText().toString();
            String pinAsString = etPin.getText().toString();
            int pin = -1;

            if(pinAsString.matches("[0-9]{4,8}")){
                pin = Integer.parseInt(pinAsString);
            }
            else{
                Toast.makeText(getApplication(), R.string.txt_invalid_pin, Toast.LENGTH_LONG).show();
            }

            Log.d("FORMDEMO","Logged in as " + username + " with pin " + pin);
        }
    };
    private EditText etUser;
    private EditText etPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.et_login_use);
        etPin = findViewById(R.id.et_login_pin);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(loginListener);

        Log.d("VALUE", "it works");
    }
}