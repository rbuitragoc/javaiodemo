package com.teaminternational.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import javax.swing.*;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBContextFactory;
import javax.xml.bind.JAXBException;
import java.beans.XMLEncoder;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class SerializationTest {

    public void testBasicSerialization() {
        BasicSerializableClass basic = new BasicSerializableClass(
                "Un Nombre de Verdad",
                100,
                new Date(),
                new HashMap<>() {{
                    put("cedula", "12463142435");
                }});
        System.out.println(basic);
    }




    //DateFormat.getDateInstance(DateFormat.SHORT).parse("02/03/1979")
    public void testObjectStreamSerialization() throws Exception {
        BasicSerializableClass basic = new BasicSerializableClass(
                "First test ever",
                100,
                new Date(),//DateFormat.getDateInstance(DateFormat.SHORT).parse("02/03/1979"),
                new HashMap<>());
        try (ObjectOutputStream objectStream = new ObjectOutputStream(System.out)) {
            objectStream.writeObject(basic);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testObjectStreamSerializationWithRead() throws Exception {
        BasicSerializableClass basic = new BasicSerializableClass(
                "First test ever",
                100,
                new Date(),
                null);
        try (ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream("serializedObject.txt"))) {
            objectStream.writeObject(basic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("serializedObject.txt"))) {
            BasicSerializableClass deserializedClass = (BasicSerializableClass) objectStream.readObject();
            System.out.println(deserializedClass.toString());
        }

    }

    public void testXMLSerializationWithXStream() {
        XMLSerializableClass xclass = new XMLSerializableClass(
                "Mr David",
                "Copperfield",
                250,
                new XMLSerializableClass.Phone(324, 51325213)
        );
        XStream xstream = new XStream(new StaxDriver());
        xstream.alias("contact", XMLSerializableClass.class);
        String xmlContent = xstream.toXML(xclass);
        System.out.println(xmlContent);
    }

    public void testXMLSerializationWithXMLEncoder() {
        XMLSerializableClass xclass = new XMLSerializableClass(
                "Mr David",
                "Copperfield",
                250,
                new XMLSerializableClass.Phone(324, 51325213)
        );
        try (XMLEncoder encoder = new XMLEncoder(System.out)) {
            encoder.writeObject(xclass);
        }
    }

    public void testXMLSerializationWithJAXB() throws JAXBException {
        JAXBSerializableClass xclass = new JAXBSerializableClass(
                "Mr David",
                "Copperfield",
                null,
                new JAXBSerializableClass.Phone(324, 51325213)
        );

        JAXBContext
                .newInstance(JAXBSerializableClass.class)
                .createMarshaller()
                .marshal(xclass, System.out);
    }

    public void testJsonSerializationWithJackson() throws ParseException, JsonProcessingException {
        BasicSerializableClass basic = new BasicSerializableClass(
                "First test ever",
                100,
                new Date(),
                new HashMap<>(){{put("cedula", "1235234614");}});

        JAXBSerializableClass xclass = new JAXBSerializableClass(
                "Mr David",
                "Copperfield",
                250,
                new JAXBSerializableClass.Phone(324, 51325213)
        );

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String jsonString = mapper.writeValueAsString(basic);
        System.out.println(String.format("Printing JSON a bit ugly: %s", jsonString));
    }


    public static void main(String[] args) throws Exception {
        SerializationTest test = new SerializationTest();
//        test.testBasicSerialization();
//        test.testObjectStreamSerialization();
//        test.testObjectStreamSerializationWithRead();
//        test.testXMLSerializationWithXStream();
//        test.testXMLSerializationWithXMLEncoder(); // FIXME
//        test.testXMLSerializationWithJAXB();
        test.testJsonSerializationWithJackson();
    }

}
