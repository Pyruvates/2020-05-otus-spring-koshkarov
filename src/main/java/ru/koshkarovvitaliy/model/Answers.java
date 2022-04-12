package ru.koshkarovvitaliy.model;

public class Answers implements Quiz {
    private final String classPath;

    public Answers(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String getClassPath() {
        return this.classPath;
    }
}
