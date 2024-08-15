package ru.repositories;

import org.springframework.stereotype.Component;
import ru.models.Client;
import ru.models.Manufacture;
import ru.models.Part;
import ru.models.PartType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PartRepositoryImpl implements PartRepository{

    Integer createId = 3;

    List<Part> partList = new ArrayList<>(Arrays.asList(
            new Part(1, new PartType(1,"bumper"),
                    new Manufacture(1, "GM"), 3.0, 100, 100),
            new Part(2, new PartType(2, "door"),
                    new Manufacture(2, "Bosh"), 3.2, 100, 120),
            new Part(3, new PartType(3, "glass"),
                    new Manufacture(3,"Fag"), 2.4, 100, 50)
    ));

    public List<Part> findAllParts(){
        return partList;
    }

    public void save(Part part){
        partList.add(part);
        part.setId(++createId);
    }

    public Part findById(Integer partId){
        Part foundPart = null;
        for (Part part : partList){
            if(part.getId().equals(partId))
                foundPart = part;
        }
        return foundPart;
    }

    public void deleteById(Integer partId) {
        for (Part part : partList){
            if (part.getId().equals(partId))
                partList.remove(part);
        }
    }






}
