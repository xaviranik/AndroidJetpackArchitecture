package com.xavir.androidjetpackarch.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.xavir.androidjetpackarch.data.TaskDao;
import com.xavir.androidjetpackarch.entities.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class TaskDatabase extends RoomDatabase {
    public static TaskDatabase instance;
    public abstract TaskDao taskDao();

    public static synchronized TaskDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, TaskDatabase.class, "task_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
