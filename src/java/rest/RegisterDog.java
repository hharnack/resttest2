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
        //JsonParser parser = Json.createParser(new StringReader(content));
        Gson gson = new Gson();
        Dog dog = gson.fromJson(content, Dog.class);
        System.out.println(dog.getDateOfBirth());

//        System.out.println(dog.getVeterinarian().getName());
//       parser.next();       // START_OBJECT
//
//        // {dogname, breed, dob, gender, weight, neuteredspayed, medication, allergies, physlimit, veterinarian, stranger, larger, small, puppy, da2pp, rabies, bordetella}
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 1
//        dog.setName(parser.getString());
//
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 2
//        dog.setBreed(parser.getString());
//
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 3
//        Date dob = Date.valueOf(parser.getString());
//        dog.setDateOfBirth(dob);
//
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 4
//        dog.setGender(parser.getString());
//
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 5
//        dog.setWeight(Double.parseDouble(parser.getString()));
//
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 6
//        if (parser.getString().equals("yes")) {
//            dog.setSpayedNeutered(true);
//        } else {
//            dog.setSpayedNeutered(false);
//        }
//        //medications parsing
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING 7
//        String meds = parser.getString();
//        System.out.println(meds);
//        String[] arr = {meds};
//        ArrayList<String> medList = new ArrayList<>();
//        for(int x = 0; x < arr.length-1; x++){
//            medList.add(arr[x]);
//        }
//        for(int x = 0; x < medList.size(); x++){
//        System.out.println(medList.get(x));
//        }
//         dog.setMedications(medList);
//     
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
//        for(int x = 0; x < medList.size(); x++){
//            System.out.println(allerList.get(x));
//        }
        //vet parsing
//        parser.next();       // KEY_NAME
//        parser.next();       // VALUE_STRING
//        String vetInfo = parser.getString();
//        
//        Gson gson = new Gson();
//        Veterinarian vet = gson.fromJson(vetInfo, Veterinarian.class);
//        dog.setVeterinarian(vet);
        return null;
    }
}
