package com.shh.model;

public final class Person {
   static boolean b;
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

//        Person person = new Person();
//
//        Person person1 = new Person();
//
//        System.out.println(person.count);
//        System.out.println(Person.count++);
//        System.out.println(++Person.count);
//        System.out.println(Person.count);

        int x = 1;
        System.out.println(x++); // 2
        System.out.println(++x); // 2
        System.out.println(x); // 3


        char s;

        byte by;
        long l; // 0
        float f; //0.0
        double d;
        System.out.println(b); // tru ,
        System.out.println();
        System.out.println(b);
        System.out.println(b);
        System.out.println(b);
        System.out.println(b);
        System.out.println(b);

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
