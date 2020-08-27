package com.example.memorar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class EditeMemoActivity extends AppCompatActivity {
    private EditText inputMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_memo);
        inputMemo = findViewById(R.id.input_memo);

    }
}