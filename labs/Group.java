package labs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Group {
    private final String name; // Название группы
    private final Map<String, Student> students = new HashMap<>(); // Студенты группы

    // Конструктор группы
    public Group(String name) {
        this.name = name;
    }

    // Добавить студента в группу с лабораторными
    public void addStudent(String studentName, List<String> labs) {
        Student s = students.putIfAbsent(studentName, new Student(studentName));
        if (s == null) { // Если студент добавлен впервые
            s = students.get(studentName);
            for (String lab : labs) {
                s.addLab(lab);
            }
        }
    }

    // Добавить лабораторную работу всем студентам
    public void addLab(String labName) {
        for (Student student : students.values()) {
            student.addLab(labName);
        }
    }

    // Отметить выполнение лабораторной студентом
    public void markLabAsCompleted(String studentName, String labName) {
        if (students.containsKey(studentName)) {
            students.get(studentName).markLabAsCompleted(labName);
        } else {
            System.out.println("Студент " + studentName + " не найден в группе " + name + ".");
        }
    }

    // Показать статус выполнения лабораторных работ
    public void showStatus() {
        System.out.println("Статус группы: " + name);
        for (Student student : students.values()) {
            student.showStatus();
        }
    }
}
