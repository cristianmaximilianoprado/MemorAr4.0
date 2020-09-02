package com.example.memorar.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.memorar.model.Memo;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MemosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMemo(Memo memo);

    @Delete
    void deleteMemo(Memo memo);

    @Update
    void updateMemo(Memo memo);

    @Query("SELECT * FROM memos")
    List<Memo> getMemos();

    @Query("SELECT * FROM memos WHERE id = :memoId")
    Memo getMemoById(int memoId);

    @Query("DELETE FROM memos WHERE id = :memoId")
    void deleteMemoById(int memoId);
}
