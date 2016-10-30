package androidapp.gabrielrunescape.com.br.view;

import android.view.*;
import android.widget.*;
import android.os.Bundle;
import androidapp.gabrielrunescape.com.br.R;
import androidapp.gabrielrunescape.com.br.controller.MainController;

import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvEmail;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        tvName = (TextView) findViewById(R.id.lbl_name);
        tvEmail = (TextView) findViewById(R.id.lbl_email);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        String name = this.getIntent().getExtras().getString("lbl_name");
        String mail = this.getIntent().getExtras().getString("lbl_mail");

        tvName.setText(name);
        tvEmail.setText(mail);

        btnLogout.setOnClickListener(new MainController(this, btnLogout, tvName, tvEmail));
    }
}
