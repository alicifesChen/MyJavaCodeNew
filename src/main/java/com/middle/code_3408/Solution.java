package com.middle.code_3408;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author chenyuxiang
 * @Date 2025-09-18
 * @Description
 */
public class Solution {
    private class Task {
        int userId;
        int taskId;
        int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    private TreeSet<Task> taskSet;
    private Map<Integer, Task> taskMap;

    public void TaskManager(List<List<Integer>> tasks) {
        taskSet = new TreeSet<>((a, b) -> {
            if (a.priority != b.priority) {
                return b.priority - a.priority; // Higher priority first
            }
            return b.taskId - a.taskId; // Lower taskId first
        });
        taskMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            Task newTask = new Task(userId, taskId, priority);
            taskSet.add(newTask);
            taskMap.put(taskId, newTask);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        taskSet.add(newTask);
        taskMap.put(taskId, newTask);
    }

    public void edit(int taskId, int newPriority) {
        Task toEdit = taskMap.get(taskId);
        if (toEdit != null) {
            taskSet.remove(toEdit);
            taskMap.remove(taskId);
            Task newTask = new Task(toEdit.userId, toEdit.taskId, newPriority);
            taskSet.add(newTask);
            taskMap.put(taskId, newTask);
        }
    }

    public void rmv(int taskId) {
        Task toRemove = taskMap.get(taskId);
        if (toRemove != null) {
            taskSet.remove(toRemove);
            taskMap.remove(taskId);
        }
    }

    public int execTop() {
        if (taskSet.isEmpty()) {
            return -1;
        }
        Task topTask = taskSet.pollFirst();
        taskMap.remove(topTask.taskId);
        return topTask.userId;
    }
}
