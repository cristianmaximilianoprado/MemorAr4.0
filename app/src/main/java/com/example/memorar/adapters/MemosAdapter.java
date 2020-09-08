package com.example.memorar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memorar.R;
import com.example.memorar.callbacks.MemoEventListener;
import com.example.memorar.model.Memo;
import com.example.memorar.utils.MemoUtils;

import java.util.ArrayList;

public class MemosAdapter extends RecyclerView.Adapter<MemosAdapter.MemoHolder> {
    private Context context;

    private ArrayList<Memo> memos;
    private MemoEventListener listener;

    public MemosAdapter(Context context, ArrayList<Memo> memos) {
        this.context = context;
        this.memos = memos;
    }


    @Override
    public MemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.memo_layout, parent, false);
        return new MemoHolder(v);
    }

    @Override
    public void onBindViewHolder(MemoHolder holder, int position) {
        final Memo memo = getMemo(position);
        if (memo != null) {
            holder.memoText.setText(memo.getMemoText());
            holder.memoDate.setText(MemoUtils.dateFromLong(memo.getMemoDate()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onMemoClick(memo);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    listener.onMemoLongClick(memo);
                    return false;
                }
            });
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
            memoDate = itemView.findViewById(R.id.memo_date);
            memoText = itemView.findViewById(R.id.memo_text);
        }
    }

    public void setListener(MemoEventListener listener) {
        this.listener = listener;
    }
}
