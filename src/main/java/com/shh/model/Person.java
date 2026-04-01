package com.shh.model;

public final class Person {

    static int count;
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        count ++;
        System.out.println("k1");
    }

    public Person() {
        this(14);
        System.out.println("k2");

    }

    public Person(Integer age) {
        this("Bob", age);
        System.out.println("k3");
    }

    public static void main(String[] args) {

        Person person = new Person();

        Person person1 = new Person();

        System.out.println(person.count);
        System.out.println(Person.count++);
        System.out.println(++Person.count);
        System.out.println(Person.count);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
