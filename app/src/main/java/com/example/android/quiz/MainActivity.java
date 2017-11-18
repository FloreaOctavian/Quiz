package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private int question1Answer() {
        CheckBox a = (CheckBox) findViewById(R.id.check_box_1);
        CheckBox b = (CheckBox) findViewById(R.id.check_box_2);
        CheckBox c = (CheckBox) findViewById(R.id.check_box_3);
        if (a.isChecked() && b.isChecked() && !c.isChecked()) return 1;
        else return 0;
    }

    private int question2Answer() {
        RadioButton a = (RadioButton) findViewById(R.id.rb_1);
        if (a.isChecked()) return 1;
        else return 0;
    }

    private int question3Answer() {
        CheckBox a = (CheckBox) findViewById(R.id.check_box_4);
        CheckBox b = (CheckBox) findViewById(R.id.check_box_5);
        CheckBox c = (CheckBox) findViewById(R.id.check_box_6);
        if (!a.isChecked() && b.isChecked() && c.isChecked()) return 1;
        else return 0;
    }

    private int question4Answer() {
        RadioButton c = (RadioButton) findViewById(R.id.rb_6);
        if (c.isChecked()) return 1;
        else return 0;
    }

    private void showResults() {
        EditText nameEditText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameEditText.getText().toString();
        String text = getString(R.string.yourPoints) + name + " answered corect at " + score + " of 4 questions";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    //Submit function

    public void submitClick(View view) {
        score = question1Answer() + question2Answer() + question3Answer() + question4Answer();
        showResults();
    }
}
