package com.example.memorar.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memorar.R;
import com.example.memorar.model.Memo;
import com.example.memorar.utils.MemoUtils;

import java.util.ArrayList;

public class MemosAdapter extends RecyclerView.Adapter<MemosAdapter.MemoHolder> {

    private ArrayList<Memo> memos;

    @NonNull
    @Override
    public MemoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.memo_layout, parent, false);
        return new MemoHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoHolder holder, int position) {
        Memo memo = getMemo(position);
        if (memo != null) {
            holder.memoText.setText(memo.getMemoText());
            holder.memoDate.setText(MemoUtils.dateFromLong(memo.getMemodate()));
        }
    }

    @Override
    public int getItemCount() {
        return memos.size();
    }

    private Memo getMemo(int position) {
        return memos.get(position);
    }

    class MemoHolder extends RecyclerView.ViewHolder {
        TextView memoText, memoDate;

        public MemoHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
