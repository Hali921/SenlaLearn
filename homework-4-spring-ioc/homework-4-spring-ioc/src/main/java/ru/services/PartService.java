package ru.services;

import ru.dto.ClientDTO;
import ru.dto.PartDTO;
import ru.models.Client;
import ru.models.Part;

import java.util.List;

public interface PartService {

    List<Part> getAllParts();
    void addPart(PartDTO partDTO);
    Part getPart(Integer partId);
    void updatePart(Integer partId, PartDTO partDTO);
    void deletePart(Integer partId);

}
