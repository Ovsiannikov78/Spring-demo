package de.ovsiannikov.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {
        try {

        // create object mapper
            ObjectMapper mapper = new ObjectMapper();

        // read JSON file and map/convert to Java POJO: data/sample-lite.json

            Student theStudent = mapper.readValue(new File("data/sample-full.json"),Student.class);

        // print first name and last name
            System.out.println("First name = " + theStudent.getFirstName());
            System.out.println("Last name = " + theStudent.getLastName());

        // print out address
            Address tempAddress = theStudent.getAddress();
            System.out.println("\n=======>>> Address <<<=========\n");

            System.out.println("Street = " + tempAddress.getStreet());
            System.out.println("City = " + tempAddress.getCity());
            System.out.println("State = " + tempAddress.getState());
            System.out.println("Zip = " + tempAddress.getZip());
            System.out.println("Country = " + tempAddress.getCountry());

        // print out languages
            System.out.println("\n=======>>> Languages <<<=========\n");
            for (String language : theStudent.getLanguages()) {
                System.out.println(language);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
