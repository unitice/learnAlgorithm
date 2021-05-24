package com.it.Entity;

/**
 * @author LY
 * @PackageName:com.it.Entity
 * @ClassName:User
 * @date 2021/5/24 11:25
 * 类说明: <br>
 */
public class User implements Comparable<User> {

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

    @Override
    public int compareTo(User o) {
        if (this.age > o.age){
            return 1;
        } else {
            if (this.age == o.age){
                if (this.name.compareTo(o.name) >= 0){
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
