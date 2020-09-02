package com.example.memorar.callbacks;

import com.example.memorar.model.Memo;

public interface MemoEventListener {

    void onMemoClick(Memo memo);
    void onMemoLongClick(Memo memo);
}
