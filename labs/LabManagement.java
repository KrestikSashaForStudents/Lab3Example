package labs;

import java.util.*;

public class LabManagement{
    private final Map<String, Group> groups = new HashMap<>();
    private final List<String> labsList = new ArrayList<>();

    // Добавить новую группу
    public void addGroup(String groupName) {
        groups.putIfAbsent(groupName, new Group(groupName));
    }

    // Добавить студента в группу
    public void addStudentToGroup(String groupName, String studentName) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).addStudent(studentName, labsList);
        } else {
            System.out.println("Группа " + groupName + " не существует.");
        }
    }

    // Добавить лабораторную работу для всей параллели
    public void addLab(String labName) {
        labsList.add(labName);
        for (Group group : groups.values()) {
            group.addLab(labName);
        }
        System.out.println("Лабораторная работа \"" + labName + "\" добавлена для всех групп.");
    }

    // Отметить выполнение лабораторной студентом
    public void markLabAsCompleted(String groupName, String studentName, String labName) {
        if (groups.containsKey(groupName)) {
            groups.get(groupName).markLabAsCompleted(studentName, labName);
        } else {
            System.out.println("Группа " + groupName + " не найдена.");
        }
    }

    // Показать статус выполнения лабораторных
    public void showStatus() {
        for (Group group : groups.values()) {
            group.showStatus();
        }
    }
}
