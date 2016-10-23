package androidapp.gabrielrunescape.com.br.view;

import android.widget.*;
import android.os.Bundle;
import androidapp.gabrielrunescape.com.br.R;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private TextView tvLogin;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btnLogout = (Button) findViewById(R.id.btnLogout);
        tvLogin = (TextView) findViewById(R.id.lbl_login);
        tvEmail = (TextView) findViewById(R.id.lbl_email);
    }
}
