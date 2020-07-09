package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = ViewMock.getFakeTasksCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = ViewMock.getFakeNamesCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider<Task>{
        @Override
        public void refreshAllData(Map criteria) {
            tasks = DbMock.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider<String>{
        @Override
        public void refreshAllData(Map criteria) {
            names = DbMock.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }
}


    class DbMock {
        private static final List<Solution.Task> FAKE_TASKS = new ArrayList<>();
        private static final List<String> FAKE_NAMES = new ArrayList<>();

        public static List<Solution.Task> getFakeTasks(Map criteria) {
            return ViewMock.getFakeTasksCriteria().equals(criteria) ? FAKE_TASKS : null;
        }

        public static List<String> getFakeNames(Map criteria) {
            return ViewMock.getFakeNamesCriteria().equals(criteria) ? FAKE_NAMES : null;
        }
    }
    class ViewMock {
        private static final Map FAKE_TASKS_CRITERIA = new HashMap();
        private static final Map FAKE_NAMES_CRITERIA = new HashMap();

        public static Map getFakeTasksCriteria() {
            return FAKE_TASKS_CRITERIA;
        }

        public static Map getFakeNamesCriteria() {
            return FAKE_NAMES_CRITERIA;
        }
    }


