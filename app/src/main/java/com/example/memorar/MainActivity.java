package com.example.memorar;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.example.memorar.adapters.MemosAdapter;
import com.example.memorar.callbacks.MemoEventListener;
import com.example.memorar.db.MemosDB;
import com.example.memorar.db.MemosDao;
import com.example.memorar.model.Memo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MemoEventListener {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ArrayList<Memo> memos;
    private MemosAdapter adapter;
    private MemosDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.memos_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: 13/08/2020 add new memo
                onAddNewMemo();
            }
        });

        dao = MemosDB.getInstance(this).memosDao();
    }

    private void loadMemos() {
        this.memos = new ArrayList<>();
        List<Memo> list = dao.getMemos();
        this.memos.addAll(list);
        this.adapter = new MemosAdapter(this, this.memos);
        this.adapter.setListener(this);
        this.recyclerView.setAdapter(adapter);

    }

    private void onAddNewMemo() {
        //Todo 02/09/2020 inicia EditeMemoActivity
        startActivity(new Intent(this, EditeMemoActivity.class));
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

    @Override
    protected void onResume() {
        super.onResume();
        loadMemos();
    }

    @Override
    public void onMemoClick(Memo memo) {


    }

    @Override
    public void onMemoLongClick(Memo memo) {

        Log.d(TAG, "onMemoLongClick:" + memo.getId());
    }
}
