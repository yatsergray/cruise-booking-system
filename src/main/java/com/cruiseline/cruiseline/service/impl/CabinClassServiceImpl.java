package com.cruiseline.cruiseline.service.impl;

import com.cruiseline.cruiseline.dao.CabinClassDAO;
import com.cruiseline.cruiseline.entity.CabinClass;
import com.cruiseline.cruiseline.exception.NoSuchCabinClassExistsException;
import com.cruiseline.cruiseline.service.CabinClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CabinClassServiceImpl implements CabinClassService {

    @Autowired
    private CabinClassDAO cabinClassDAO;

    @Override
    public CabinClass addCabinClass(CabinClass cabinClass) {
        return cabinClassDAO.save(cabinClass);
    }

    @Override
    public CabinClass copyAndUpdateCabinClassById(Long cabinClassId, CabinClass cabinClass) throws NoSuchCabinClassExistsException {
        CabinClass updatedCabinClass = getCabinClassById(cabinClassId);
        updatedCabinClass.setName(cabinClass.getName());
        return addCabinClass(updatedCabinClass);
    }

    @Override
    public void removeCabinClassById(Long id) {
        cabinClassDAO.deleteById(id);
    }

    @Override
    public void removeCabinClass(CabinClass cabinClass) {
        cabinClassDAO.delete(cabinClass);
    }

    @Override
    public CabinClass getCabinClassById(Long id) throws NoSuchCabinClassExistsException {
        return Optional.of(cabinClassDAO.getById(id)).orElseThrow(() -> new NoSuchCabinClassExistsException("Cabin class with id " + id + " doesn't exist."));
    }

    @Override
    public List<CabinClass> getAllCabinClasses() {
        return cabinClassDAO.findAll();
    }

    public boolean isBooked(Long cabinClassId) throws NoSuchCabinClassExistsException {
        return !getCabinClassById(cabinClassId).getCabins().isEmpty();
    }
}
