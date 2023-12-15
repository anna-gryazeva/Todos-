package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void simpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskWithoutMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Связаться");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Молоко");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void epicWithoutMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Арбуз");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void meetingTopicMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicWithoutMatches() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("обновление");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectMatches() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение НетоБанка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectWithoutMatches() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Сайт");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }
}
