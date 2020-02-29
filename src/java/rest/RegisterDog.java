package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.ws.rs.Consumes;
import java.sql.Date;
import java.util.ArrayList;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import models.Dog;
import models.Veterinarian;


/**
 *
 * @author 703174
 */
@Path("registerDog")
public class RegisterDog {

    public RegisterDog() {

    }

    @Context
    private UriInfo context;

    /**
     * PUT method for updating or creating an instance of
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putJson(String content) {
        JsonParser parser = Json.createParser(new StringReader(content));
        Dog dog = new Dog();

        parser.next();       // START_OBJECT

        // {dogname, breed, dob, gender, weight, neuteredspayed, medication, allergies, physlimit, veterinarian, stranger, larger, small, puppy, da2pp, rabies, bordetella}
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setName(parser.getString());

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setBreed(parser.getString());

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        Date dob = Date.valueOf(parser.getString());
        dog.setDateOfBirth(dob);

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setGender(parser.getString());

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        dog.setWeight(Double.parseDouble(parser.getString()));

        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        if (parser.getString().equals("yes")) {
            dog.setSpayedNeutered(true);
        } else {
            dog.setSpayedNeutered(false);
        }
        //medications parsing
        parser.next();       // KEY_NAME
        parser.next();       // VALUE_STRING
        String medInfo = parser.getString();
        Gson gson = new Gson();
        ArrayList<String> medList;
        try (JsonParser parserMeds = Json.createParser(new StringReader(medInfo))) {
            medList = gson.fromJson(medInfo, ArrayList.class);
//        boolean flag = true;
//        parserMeds.next();
//        while (flag) {
//            try {
//                parserMeds.next();
//                parserMeds.next();
//
//                medList.add(parser.getString());
//            } catch (Exception e) {
//                flag = false;
//            }
//        }
for(int x = 0; x < medList.size(); x++){
    System.out.println(medList.get(x));
}
        }
//        boolean flag = true;
//        parserMeds.next();
//        while (flag) {
//            try {
//                parserMeds.next();
//                parserMeds.next();
//
//                medList.add(parser.getString());
//            } catch (Exception e) {
//                flag = false;
//            }
//        }
        dog.setMedications(medList);
        
//        allergies parsing
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING
//        String allerInfo = parser.getString();
//        JsonParser parserAller = Json.createParser(new StringReader(allerInfo));
//        ArrayList<String> allerList = new ArrayList<>();
//        flag = true;
//        parserAller.next();
//        while (flag) {
//            try {
//                parserAller.next();
//                parserAller.next();
//
//                allerList.add(parser.getString());
//            } catch (Exception e) {
//                flag = false;
//            }
//        }
//        parserAller.close();
//        dog.setAllergies(allerList);
        
        //vet parsing
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING
//        String vetInfo = parser.getString();
//        
//        gson = new Gson();
//        Veterinarian vet = gson.fromJson(vetInfo, Veterinarian.class);
//        dog.setVeterinarian(vet);
        return null;
    }
}
