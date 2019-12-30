package com.teaminternational.serialization;

import java.beans.BeanProperty;
import java.beans.ConstructorProperties;
import java.beans.JavaBean;
import java.io.Serializable;

@JavaBean(
        defaultProperty = "name",
        description = "An implementation of XMLSerializable Class"
)
public class XMLSerializableClass implements Serializable {

    private String name;
    private String lastName;
    private int age;
    private Phone phone;

    @ConstructorProperties({"name", "lastName", "age", "phone"})
    public XMLSerializableClass(String name, String lastName, int age, Phone phone) {
        this.setName(name);
        this.setLastName(lastName);
        this.setAge(age);
        this.setPhone(phone);
    }
    @BeanProperty(
            bound = false,
            expert = true,
            description = "A string that specifies the name of the serializable class."
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @BeanProperty(
            bound = false,
            expert = true,
            description = "A string that specifies the last name of the serializable class."
    )
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @BeanProperty(
            bound = false,
            expert = true,
            description = "A string that specifies the age of the serializable class."
    )
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @BeanProperty(
            bound = false,
            expert = true,
            description = "An object that specifies the phone of the serializable class."
    )
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
