import labs.LabManagement;

public class Test {
    public static void main(String[] args) {

        // Создаем объект для управления лабораторными
        LabManagement management = new LabManagement();

        // Добавляем группы
        management.addGroup("Группа 1");
        management.addGroup("Группа 2");

        // Добавляем студентов в группы
        management.addStudentToGroup("Группа 1", "Иван");
        management.addStudentToGroup("Группа 1", "Мария");
        management.addStudentToGroup("Группа 2", "Сергей");

        // Добавляем лабораторные работы
        management.addLab("lab 1");
        management.addLab("lab 2");

        // Добавляем нового студента в группу (например, после выхода из академа)
        management.addStudentToGroup("Группа 2", "Саша");

        // Отмечаем выполнение лабораторных работ студентами
        management.markLabAsCompleted("Группа 1", "Иван", "lab 1");
        management.markLabAsCompleted("Группа 2", "Сергей", "lab 1");

        // Показываем статус выполнения лабораторных работ для всех студентов
        management.showStatus();
    }
}
