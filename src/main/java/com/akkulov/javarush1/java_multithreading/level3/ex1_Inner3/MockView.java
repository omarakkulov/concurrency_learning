package com.akkulov.javarush1.java_multithreading.level3.ex1_Inner3;

import java.util.HashMap;
import java.util.Map;

public class MockView {
    private static final Map FAKE_TASK_CRITERIA = new HashMap();
    private static final Map FAKE_NAME_CRITERIA = new HashMap();

    public static Map getFakeTaskCriteria() {
        return FAKE_TASK_CRITERIA;
    }

    public static Map getFakeNameCriteria() {
        return FAKE_NAME_CRITERIA;
    }
}
