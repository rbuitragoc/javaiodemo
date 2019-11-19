package com.teaminternational.serialization;

import java.io.Serializable;

public class XMLSerializableClass implements Serializable {

    private String name;
    private String lastName;
    private int age;
    private Phone phone;

    public XMLSerializableClass(String name, String lastName, int age, Phone phone) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    static class Phone implements Serializable {
        private int prefix;
        private int number;
        public Phone(int prefix, int number) {
            this.prefix = prefix;
            this.number = number;
        }
    }
}
