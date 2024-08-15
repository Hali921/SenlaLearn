package ru.repositories;

import ru.models.Part;

import java.util.List;

public interface PartRepository {

    List<Part> findAllParts();
    void save(Part part);
    Part findById(Integer partId);
    void deleteById(Integer partId);

}
