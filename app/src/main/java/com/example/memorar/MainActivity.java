package com.example.memorar;

import android.os.Bundle;

import com.example.memorar.adapters.MemosAdapter;
import com.example.memorar.model.Memo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Memo> memos;
    private MemosAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.memos_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadMemos();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: 13/08/2020 add new memo
                onAddNewMemo();
            }
        });
    }

    private void loadMemos() {
        this.memos = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            memos.add(new Memo("esto es un memo", new Date().getTime()));
            
        }
    }

    private void onAddNewMemo() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
