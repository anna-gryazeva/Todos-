package ru.netology.domain;

public class Todos {
    private Task[] tasks = new Task[0];

    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    public void add(Task task) {
        tasks = addToArray(tasks, task);
    }

    public void add(SimpleTask simpleTask) {
        tasks = addToArray(tasks, simpleTask);
    }

    public void add(Epic epic) {
        tasks = addToArray(tasks, epic);
    }

    public void add(Meeting meeting) {
        tasks = addToArray(tasks, meeting);
    }

    public Task[] findAll() {
        return tasks;
    }

    public Task[] search(String query) {
        Task[] result = new Task[0]; // массив для ответа
        for (Task task : tasks) { // перебираем все задачи
            if (task.matches(query)) { // если задача подходит под запрос
                result = addToArray(result, task); // добавляем её в массив ответа
            }
        }
        return result;
    }

}
