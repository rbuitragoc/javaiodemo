package com.teaminternational.serialization;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@XmlRootElement(name = "contact")
public class JAXBSerializableClass {

    @XmlElement
    private String name;
    @XmlElement
    private String lastName;
    @XmlElement(name = "edad")
    private Integer age;
    @XmlElement
    private Phone phone;

    public JAXBSerializableClass() {}

    public JAXBSerializableClass(String name, String lastName, Integer age, Phone phone) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    static class Phone implements Serializable {
        @XmlElement
        private int prefix;
        @XmlElement
        private int number;
        public Phone(int prefix, int number) {
            this.prefix = prefix;
            this.number = number;
        }
    }
}
