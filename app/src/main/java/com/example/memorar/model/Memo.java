package com.example.memorar.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "memos")
public class Memo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "text")
    private String memoText;
    @ColumnInfo(name = "date")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Memo{" +
                "id=" + id +
                ", memodate=" + memodate +
                '}';
    }
}
