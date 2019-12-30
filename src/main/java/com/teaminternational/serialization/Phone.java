package com.teaminternational.serialization;

import java.beans.BeanProperty;
import java.beans.ConstructorProperties;
import java.beans.JavaBean;
import java.io.Serializable;

@JavaBean(
        defaultProperty = "number",
        description = "An implementation of Phone Class"
)
public class Phone implements Serializable {
    private int prefix;
    private int number;

    @ConstructorProperties({"prefix", "number"})
    public Phone(int prefix, int number) {
        this.setPrefix(prefix);
        this.setNumber(number);
    }

    @BeanProperty(
            bound = false,
            expert = true,
            description = "A number that specifies the prefix of the phone class."
    )
    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    @BeanProperty(
            bound = false,
            expert = true,
            description = "A number that specifies the number of the phone class."
    )
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
