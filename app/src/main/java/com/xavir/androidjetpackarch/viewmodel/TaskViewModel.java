package com.xavir.androidjetpackarch.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.xavir.androidjetpackarch.entities.Task;
import com.xavir.androidjetpackarch.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends ViewModel {
    private TaskRepository taskRepository;
    private LiveData<List<Task>> allTasks;

    public void init(Application application) {
        if(allTasks != null) {
            return;
        }
        taskRepository = new TaskRepository(application);
        allTasks = taskRepository.getAllTasks();
    }

    public void insert(Task task) {
        taskRepository.insert(task);
    }

    public void update(Task task) {
        taskRepository.update(task);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }

    public void deleteAllTasks() {
        taskRepository.deleteAllTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }
}
