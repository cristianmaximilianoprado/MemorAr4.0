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
    private Memo temp;
    public static final String MEMO_EXTRA_key = "memo_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_memo);
        inputMemo = findViewById(R.id.input_memo);
        dao = MemosDB.getInstance(this).memosDao();
        if (getIntent().getExtras() != null) {
            int id = getIntent().getExtras().getInt(MEMO_EXTRA_key, 0);
            temp = dao.getMemoById(id);
            inputMemo.setText(temp.getMemoText());

        } else temp = new Memo();
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


            temp.setMemoDate(date);
            temp.setMemoText(text);

            if (temp.getId() == -1)
                dao.insertMemo(temp); // Inserta y guarda nuevo memo en base de datos
            else dao.updateMemo(temp);

            finish(); //retorna a mainactivity
        }
    }
}