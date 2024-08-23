package ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dto.PartDTO;
import ru.models.Part;
import ru.repositories.PartRepository;

import java.util.List;

@Component
public class PartServiceImpl implements PartService{

    @Autowired
    private PartRepository partRepository;


    @Override
    public List<Part> getAllParts() {
        return partRepository.findAllParts();
    }

    @Override
    public void addPart(PartDTO partDTO) {
        Part part = Part.builder()
                .partType(partDTO.getPartType())
                .manufacture(partDTO.getManufacture())
                .rating(partDTO.getRating())
                .quantity(partDTO.getQuantity())
                .price(partDTO.getPrice())
                .build();
        partRepository.save(part);

    }

    @Override
    public Part getPart(Integer partId) {
        return partRepository.findById(partId);
    }

    @Override
    public void updatePart(Integer partId, PartDTO partDTO) {
        Part part = partRepository.findById(partId);
        part.setRating(partDTO.getRating());
        part.setQuantity(partDTO.getQuantity());
        part.setPrice(partDTO.getPrice());
        partRepository.deleteById(partId);
        partRepository.save(part);
    }

    @Override
    public void deletePart(Integer partId) {
        partRepository.deleteById(partId);
    }
}
