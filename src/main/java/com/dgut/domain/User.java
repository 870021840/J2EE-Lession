package com.dgut.domain;

public class User {
    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {

        //第一种方式
//        User user = new User("123",123);
//        System.out.println(user);

         //第二种方式 set方法
//        User u = new User();
//        u.setUsername("xieman");
//        u.setAge(19);
//        System.out.println(u);
//        user.setUsername("123");
//        user.setAge(12);

    }
}
