package vk.com.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time_picker);
        textView = findViewById(R.id.time_result);

    
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                  String format = "";
                  int hour=i;
                if (hour == 0) {
                    hour += 12;
                    format = "AM";
                } else if (hour == 12) {
                    format = "PM";
                } else if (hour > 12) {
                    hour -= 12;
                    format = "PM";
                } else {
                    format = "AM";
                }

                StringBuilder hourTime = new StringBuilder("");
                if(String.valueOf(hour).length()==1)
                {
                    hourTime.append(0).append(hour);
                }
                else
                    {
                        hourTime.append(hour);
                    }

                StringBuilder minuteTime = new StringBuilder("");
                if(String.valueOf(i1).length()==1)
                {
                    minuteTime.append(0).append(i1);
                }
                else {
                    minuteTime.append(i1);
                }

                  StringBuilder time = new StringBuilder("");
                 time.append(hourTime).append(":").append(minuteTime).append(" ").append(format);
                 textView.setText(time.toString());

            }
        });


    }
}
