package apidez.com.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private final int EDIT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }

    public void openVideo(View view) {
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivity(intent);
    }

    public void openPhone(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:0947811003"));
        startActivity(intent);
    }

    public void callPhone(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:0947811003"));
        startActivity(intent);
    }

    public void openDetail(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void openEdit(View view) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, EDIT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, data.getStringExtra("string"), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public void openDatePicker(View view) {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        Toast.makeText(MainActivity.this, dayOfMonth
                                        + "/" + (monthOfYear + 1)
                                        + "/" + year,
                                Toast.LENGTH_SHORT).show();
                    }
                },
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setAccentColor(ContextCompat.getColor(this, R.color.colorPrimary));
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    public void openTimePicker(View view) {
        Calendar now = Calendar.getInstance();
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialPickerLayout view, int hourOfDay,
                                          int minute, int second) {
                        Toast.makeText(MainActivity.this, hourOfDay
                                        + ":" + minute
                                        + ":" + second,
                                Toast.LENGTH_SHORT).show();
                    }
                },
                now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND),
                false);
        timePickerDialog.setAccentColor(ContextCompat.getColor(this, R.color.colorPrimary));
        timePickerDialog.show(getFragmentManager(), "Timepickerdialog");
    }
}
