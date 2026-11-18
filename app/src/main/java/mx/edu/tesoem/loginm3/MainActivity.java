package mx.edu.tesoem.loginm3;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilEmail, tilPassword;
    private TextInputEditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v -> validar(v));
        findViewById(R.id.btnForgot).setOnClickListener(v ->
                Snackbar.make(v, "Función no implementada (prototipo)", Snackbar.LENGTH_SHORT).show());
        findViewById(R.id.btnRegister).setOnClickListener(v ->
                Snackbar.make(v, "Función no implementada (prototipo)", Snackbar.LENGTH_SHORT).show());
    }

    private void validar(View vista) {
        String correo = etEmail.getText() == null ? "" : etEmail.getText().toString().trim();
        String clave = etPassword.getText() == null ? "" : etPassword.getText().toString();

        boolean correoOk = Patterns.EMAIL_ADDRESS.matcher(correo).matches();
        boolean claveOk = clave.length() >= 6;

        tilEmail.setError(correoOk ? null : getString(R.string.error_email));
        tilPassword.setError(claveOk ? null : getString(R.string.error_password));

        if (correoOk && claveOk) {
            Snackbar.make(vista, R.string.login_ok, Snackbar.LENGTH_LONG).show();
        }
    }
}