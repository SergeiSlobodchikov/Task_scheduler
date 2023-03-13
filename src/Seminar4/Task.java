package Seminar4;

import java.time.LocalDateTime;


class Task {
    private static int nextId = 1;
    private int id;
    private LocalDateTime addedDateTime;
    private LocalDateTime deadlineDateTime;
    private Priority priority;
    private String authorName;
    private String description;
    private int idnum;

    public Task(LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        this.id = nextId++;
        this.addedDateTime = addedDateTime;
        this.deadlineDateTime = deadlineDateTime;
        this.priority = priority;
        this.authorName = authorName;
        this.description = description;
    }
    public Task(int idnum, LocalDateTime addedDateTime, LocalDateTime deadlineDateTime, Priority priority, String authorName, String description) {
        this.idnum = idnum;
        this.addedDateTime = addedDateTime;
        this.deadlineDateTime = deadlineDateTime;
        this.priority = priority;
        this.authorName = authorName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getAddedDateTime() {
        return addedDateTime;
    }

    public LocalDateTime getDeadlineDateTime() {
        return deadlineDateTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", начало срока=" + addedDateTime +
                ", крайний срок=" + deadlineDateTime +
                ", приоритет=" + priority +
                ", имя автора='" + authorName + '\'' +
                ", описание='" + description + '\'' +
                '}';
    }
}