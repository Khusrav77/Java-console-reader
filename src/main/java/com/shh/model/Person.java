package com.shh.model;

public final class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public Integer getId() {return id;}

    public String getName() {return name;}

    public Integer getAge() {return age;}

    public void setName(String name) {this.name = name;}

    public void setAge(Integer age) {this.age = age;}

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
