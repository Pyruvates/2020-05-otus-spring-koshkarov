package ru.koshkarovvitaliy.model;

public class Questions implements Quiz {
    private final String classPath;

    public Questions(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String getClassPath() {
        return this.classPath;
    }
}
