package com.xavir.androidjetpackarch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.xavir.androidjetpackarch.R;
import com.xavir.androidjetpackarch.adapter.TaskAdapter;
import com.xavir.androidjetpackarch.entities.Task;
import com.xavir.androidjetpackarch.viewmodel.TaskViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView taskRecyclerView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskRecyclerView = findViewById(R.id.task_recyclerview);

        setupTaskRecyclerView();
        setupTaskViewModel();
    }

    private void setupTaskRecyclerView() {
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskRecyclerView.setHasFixedSize(true);

        taskAdapter = new TaskAdapter();
        taskRecyclerView.setAdapter(taskAdapter);
    }

    private void setupTaskViewModel() {
        TaskViewModel taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
        taskViewModel.init(this.getApplication());
        taskViewModel.getAllTasks().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                taskAdapter.setTaskList(tasks);
            }
        });
    }
}
