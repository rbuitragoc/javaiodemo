package com.teaminternational.serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class BasicSerializableClass implements Serializable {

     public String name;
     public int age;
    public Date birthDate;
    public Map<String, String> documents;

    public BasicSerializableClass(String name, int age, Date birthDate, Map<String, String> documents) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "nombre: " + name + " edad: " + age + " fecha nacimiento: " + birthDate + " Documentos: " + documents;
    }

}
