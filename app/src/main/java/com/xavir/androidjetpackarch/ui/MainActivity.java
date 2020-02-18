package com.xavir.androidjetpackarch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.xavir.androidjetpackarch.R;
import com.xavir.androidjetpackarch.entities.Task;
import com.xavir.androidjetpackarch.viewmodel.TaskViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupTaskViewModel();
    }

    private void setupTaskViewModel() {
        TaskViewModel taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.init(this.getApplication());
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                Log.i(TAG, "onChanged: " + tasks.get(0).getTitle());
            }
        });
    }
}
