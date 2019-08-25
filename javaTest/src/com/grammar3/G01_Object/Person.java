package com.grammar3.G01_Object;

import java.util.Objects;


public class Person {
    private String name;
    private Integer age;

    public Person(String name) {
        this.name = name;
    }

    /**
     *  Object类的equals方法，默认比较的是两个对象的地址值，没有意义；
     *  所以我们要重写equals方法，比较两个对象的属性（name,age）;
     *  问题：
     *      隐藏着一个多态
     *          多态的弊端：无法使用子类特有的内容（属性和方法）
     *          解决方法：可以使用向下转型（强转）把obj类型转换我Person;
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass()  这个就是利用反射的机制 等效于 if(o instanceof Person)
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
