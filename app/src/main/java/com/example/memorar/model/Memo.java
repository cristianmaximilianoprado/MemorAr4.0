package com.example.memorar.model;

public class Memo {
    private String memoText;
    private long memodate;

    public Memo(String memoText, long memodate) {
        this.memoText = memoText;
        this.memodate = memodate;
    }

    public String getMemoText() {
        return memoText;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }

    public long getMemodate() {
        return memodate;
    }

    public void setMemodate(long memodate) {
        this.memodate = memodate;
    }
}
