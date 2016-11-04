package androidapp.gabrielrunescape.com.br.view;

import android.view.*;
import android.widget.*;
import android.os.Bundle;
import android.support.v7.app.*;
import androidapp.gabrielrunescape.com.br.R;
import androidapp.gabrielrunescape.com.br.adapter.ImageAdapter;
import androidapp.gabrielrunescape.com.br.controller.MainController;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        GridView gridview = (GridView) findViewById(R.id.mainGridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new MainController(this, gridview));
    }
}
