package com.example.remindergranny;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class AddRem extends AppCompatActivity {
    TimePicker alarmTime;
    TextClock currentTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reminder);
        alarmTime = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        final Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {

                if (currentTime.getText().toString().equals(AlarmTime())){
                    r.play();
                }else{
                    r.stop();
                }
            }
        }, 0, 1000);
    }
    public String AlarmTime(){

        Integer alarmHours = alarmTime.getCurrentHour();
        Integer alarmMinutes = alarmTime.getCurrentMinute();
        String stringAlarmMinutes;
        if (alarmMinutes<10){
            stringAlarmMinutes = "0";
            stringAlarmMinutes = stringAlarmMinutes.concat(alarmMinutes.toString());
        }else{
            stringAlarmMinutes = alarmMinutes.toString();
        }
        String stringAlarmTime;
        if(alarmHours>12){
            alarmHours = alarmHours -12;
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat("pm");
        }else{
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinutes).concat("am");
        }
        return stringAlarmTime;
    }
}



