package fr.gaspezia.loginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import fr.gaspezia.loginpage.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton loginInfoButton = findViewById(R.id.imageButton_login_info);
        ImageButton passwordInfoButton = findViewById(R.id.imageButton_password_info);
        Button okButton = findViewById(R.id.button_ok);

        loginInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "forme du login : prenom.nom", Toast.LENGTH_LONG).show();
            }
        });

        passwordInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "votre mdp doit contenir 1 majuscule et 1 chiffre", Toast.LENGTH_LONG).show();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText loginEditText = findViewById(R.id.editText_login);
                EditText passwordEditText = findViewById(R.id.editText_password);

                String login = loginEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isLoginAndPasswordValid(login, password)) {
                    Toast.makeText(MainActivity.this, "login et mot de passe conforme", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "login ou mot de passe non conforme", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean isLoginAndPasswordValid(String login, String password) {
        return login.matches("^[a-z]+\\.[a-z]+$") && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}
