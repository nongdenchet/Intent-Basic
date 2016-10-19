package apidez.com.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
    }

    public void ok(View view) {
        Intent intent = new Intent();
        intent.putExtra("string", "Hello World");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void cancel(View view) {
        finish();
    }
}
