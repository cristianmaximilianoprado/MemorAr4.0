package com.example.memorar.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "memos")
public class Memo {
    @PrimaryKey(autoGenerate = true)
    private int id = -1; //valor por defecto
    @ColumnInfo(name = "text")
    private String memoText;
    @ColumnInfo(name = "date")
    private long memoDate;

    public Memo() {
    }

    public Memo(String memoText, long memoDate) {
        this.memoText = memoText;
        this.memoDate = memoDate;
    }

    public String getMemoText() {
        return memoText;
    }

    public void setMemoText(String memoText) {
        this.memoText = memoText;
    }

    public long getMemoDate() {
        return memoDate;
    }

    public void setMemoDate(long memoDate) {
        this.memoDate = memoDate;
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
                ", memoDate=" + memoDate +
                '}';
    }
}
