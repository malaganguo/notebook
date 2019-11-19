package com.mlgg.thinkinjava;

/**
 * @author zhang.yifei4
 * @version 1.0
 * @ClassName handle
 * <p>
 * @Date
 * @since v9.0
 */
public class handle {

    static void f(Letter l) {
        l.c = 'l';//句柄传递
    }
    public static void main(String[] args) {
        Letter letter = new Letter();
        letter.c = 'c';
        System.out.println(letter.c);
        f(letter);
        System.out.println(letter.c);

        System.out.println("--------------------");

        Student student = new Student();
        student = new Student(new Letter('q'));
        System.out.println(student.toString());
        sf(student);
        System.out.println(student);

    }
    static void sf(Student s) {
        s = new Student(new Letter('s'));
    }
}
class Letter {
    public Letter() {
    }
    public Letter(char c) {
        this.c = c;
    }

    char c;

    @Override
    public String toString() {
        return "Letter{" +
                "c=" + c +
                '}';
    }
}
class Student {
    public Student() {
    }
    public Student(Letter let) {
        this.let = let;
    }

    Letter let;

    @Override
    public String toString() {
        return "Student{" +
                "let=" + let +
                '}';
    }
}
