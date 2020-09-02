package com.example.memorar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.memorar.db.MemosDB;
import com.example.memorar.db.MemosDao;
import com.example.memorar.model.Memo;

import java.util.Date;

public class EditeMemoActivity extends AppCompatActivity {
    private EditText inputMemo;
    private MemosDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_memo);
        inputMemo = findViewById(R.id.input_memo);
        dao = MemosDB.getInstance(this).memosDao();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edite_memo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save_memo)
            onSaveMemo();
        return super.onOptionsItemSelected(item);
    }

    private void onSaveMemo() {
        //Todo 02/09/2020 Guardar Memos
        String text = inputMemo.getText().toString();
        if (!text.isEmpty()) {
            long date = new Date().getTime();
            Memo memo = new Memo(text, date); //Crea nuevo memo
            dao.insertMemo(memo); // Inserta y guarda nuevo memo en base de datos

            finish(); //retorna a mainactivity
        }
    }
}