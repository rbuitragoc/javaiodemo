package com.teaminternational.serialization;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@JsonRootName(value = "contact")
public class BasicSerializableClass implements Serializable {

    @JsonIgnore
     public String name;
    @JsonProperty(value = "edad")
     public int age;
    public Date birthDate;
    transient public Map<String, String> documents;

    public BasicSerializableClass(String name, int age, Date birthDate, Map<String, String> documents) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "nombre: " + name + ", edad: " + age + ", fecha nacimiento: " + birthDate + ", Documentos: " + documents;
    }

}
