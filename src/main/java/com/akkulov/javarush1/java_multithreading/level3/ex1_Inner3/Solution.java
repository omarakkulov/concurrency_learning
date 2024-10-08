package com.akkulov.javarush1.java_multithreading.level3.ex1_Inner3;

import java.util.List;
import java.util.Map;

public class Solution {

    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {

    }

    private class TaskDataProvider implements DbDataProvider<MockDB> {
        @Override
        public void refreshAllData(Map criteria) {
            //get tasks from server by criteria
            tasks = MockDB.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider<String> {
        @Override
        public void refreshAllData(Map criteria) {
            //get names from server by criteria
            names = MockDB.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {
        new Solution().refresh();
    }
}
