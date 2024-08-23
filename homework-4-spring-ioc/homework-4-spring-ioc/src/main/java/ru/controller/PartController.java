package ru.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dto.PartDTO;
import ru.models.Part;
import ru.services.PartService;

import java.util.List;

@Component
public class PartController {

    @Autowired
    private PartService partService;

    @SneakyThrows
    public String getAllParts() {
        List<Part> parts = partService.getAllParts();

        return new ObjectMapper().writeValueAsString(parts);
    }

    public void addPart(PartDTO partDTO){
        partService.addPart(partDTO);
    }

    @SneakyThrows
    public String getPart(Integer partId){
        Part part = partService.getPart(partId);
        return new ObjectMapper().writeValueAsString(part);
    }

    public void updatePart(Integer partId, PartDTO partDTO){
        partService.updatePart(partId, partDTO);
    }

    public void deletePart(Integer partId){
        partService.deletePart(partId);
    }
}
