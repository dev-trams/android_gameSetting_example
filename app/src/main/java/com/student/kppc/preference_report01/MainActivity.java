package com.student.kppc.preference_report01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String level;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                showDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout layout = new LinearLayout(this);
        TextView strSound = new TextView(this);
        SeekBar seekSound = new SeekBar(this);
        strSound.setText("Sound: 0/100");
        strSound.setGravity(View.TEXT_ALIGNMENT_CENTER);
        seekSound.setMax(100);

        seekSound.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int intSound = seekBar.getProgress();
                strSound.setText(String.format("Sound: %d/100", intSound));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextView strBrightness = new TextView(this);
        strBrightness.setText("Brightness : 0/100");
        strBrightness.setGravity(View.TEXT_ALIGNMENT_CENTER);
        SeekBar seekBrightness = new SeekBar(this);
        seekBrightness.setMax(100);
        seekBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int intBrightness = seekBrightness.getProgress();
                strBrightness.setText(String.format("Brightness : %d/100", intBrightness));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextView strDifficultyLevel = new TextView(this);
        strDifficultyLevel.setText("Difficulty Level :");
        RadioGroup radioLevel = new RadioGroup(this);
        radioLevel.setOrientation(LinearLayout.HORIZONTAL);
        RadioButton radioEasy = new RadioButton(this);
        radioEasy.setText("Easy");
        RadioButton radioMedium = new RadioButton(this);
        radioMedium.setText("Medium");
        RadioButton radioHard = new RadioButton(this);
        radioHard.setText("Hard");
        radioLevel.addView(radioEasy);
        radioLevel.addView(radioMedium);
        radioLevel.addView(radioHard);
        level = "";
        radioEasy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                level = "Easy";
            }
        });
        radioMedium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                level = "Medium";
            }
        });
        radioHard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                level = "Hard";
            }
        });


        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10, 10, 10, 10);
        layout.addView(strSound);
        layout.addView(seekSound);
        layout.addView(strBrightness);
        layout.addView(seekBrightness);
        layout.addView(strDifficultyLevel);
        layout.addView(radioLevel);


        builder.setTitle("환경 설정").setIcon(R.drawable.unnamed).setView(layout);
        builder.show();
    }
}