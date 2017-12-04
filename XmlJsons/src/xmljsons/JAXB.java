/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmljsons;

import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXB implements XmlJsons {

    @Override
    public void serialize(Object object, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, file);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object deserialize(Class c, File file) {
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        } finally {
            return object;
        }
    }
}