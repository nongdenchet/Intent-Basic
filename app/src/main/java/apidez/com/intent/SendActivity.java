package apidez.com.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by nongdenchet on 10/11/16.
 */

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent intent = getIntent();
        String email = intent.getStringExtra(Intent.EXTRA_EMAIL);
        String subject = intent.getStringExtra(Intent.EXTRA_SUBJECT);
        String body = intent.getStringExtra(Intent.EXTRA_TEXT);
        Toast.makeText(this, email + " " + subject + " " + body, Toast.LENGTH_LONG)
                .show();
    }
}
