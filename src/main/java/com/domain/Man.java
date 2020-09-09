package com.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mans")
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    public Man() {
    }

    public Man(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return id == man.id &&
                age == man.age &&
                Objects.equals(name, man.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
