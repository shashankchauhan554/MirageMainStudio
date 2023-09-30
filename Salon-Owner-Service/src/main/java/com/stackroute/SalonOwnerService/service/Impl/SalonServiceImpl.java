package com.stackroute.SalonOwnerService.service.Impl;

import com.stackroute.SalonOwnerService.exception.*;
import com.stackroute.SalonOwnerService.model.Salon;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.repository.SalonRepository;
import com.stackroute.SalonOwnerService.repository.CategoryRepository;
import com.stackroute.SalonOwnerService.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    @Autowired
    SalonRepository repository;
    @Autowired
    CategoryRepository categoryRepository ;
    @Override

    public Salon addSalon(Salon salon) throws SalonIdAlreadyExistException {
        Salon salon1;
        Optional<Salon> optionalSalon = repository.findById(salon.getSalonId());
        if(optionalSalon.isPresent()){
            throw new SalonIdAlreadyExistException("Duplicate Salon Id");
        }
        else{
            Optional<List<Category>> optionalCategoryList = Optional.ofNullable(salon.getCategoryList());
            optionalCategoryList.ifPresent(categoryList ->
                    categoryList.forEach(category -> categoryRepository.save(category)));
            salon1= repository.save(salon);
        }
        return salon1;
    }
    @Override
    public Iterable<Salon> viewAllSalons() {
        return repository.findAll();
    }

    @Override
    public boolean deleteSalonbySalonId(String salonId) throws SalonIdDoesNotExistException {

        Optional<Salon> optionalSalon = repository.findById(salonId);
        if(optionalSalon.isPresent()){
            repository.deleteById(salonId);
            return true;
        }else
            throw new SalonIdDoesNotExistException("Salon Id is not available in DB");
    }

    @Override
    public Salon updateSalon(Salon salon) throws SalonIdDoesNotExistException {
        Optional<Salon> optionalCategory = repository.findById(salon.getSalonId());
        if(optionalCategory.isPresent()){
            return repository.save(salon);
        }else
            throw new SalonIdDoesNotExistException("Salon Id is not Available in DB");
    }

    @Override
    public Optional<Salon> getSalonBySalonId(String salonId) {
        return repository.findById(salonId);
    }

    @Override
    public Salon addCategory(String salonId,Category category) throws SalonIdDoesNotExistException {
        Optional<Salon> optionalSalon = repository.findById(salonId);

        if (optionalSalon.isEmpty()) {
            throw new SalonIdDoesNotExistException("notFound");
        } else {
            Salon salon = optionalSalon.get();
            List<Category> existCategoryList = salon.getCategoryList();

            if (existCategoryList == null) {
                existCategoryList = new ArrayList<>(); // Create a new list if it's null
            }

            existCategoryList.add(category);
            salon.setCategoryList(existCategoryList);
            Optional<List<Category>> optionalCategoryList = Optional.ofNullable(salon.getCategoryList());
            optionalCategoryList.ifPresent(categoryaList ->
                    categoryaList.forEach(categorys -> categoryRepository.save(category)));
            return repository.save(salon);
        }
    }

    @Override
    public List<Salon> getSalonByLocation(String location) {
        return repository.findByLocation(location);
    }
    @Override
    public Salon getSalonByName(String name) {return repository.findBySalonName(name);
    }

    @Override
    public boolean deleteCategory(String salonId, String Category) throws SalonIdDoesNotExistException, CategoryDoesNotExistException {
        Optional<Salon> medicalShop = repository.findById(salonId);
        if(medicalShop.isEmpty()){
            throw new SalonIdDoesNotExistException("Not Found");
        }
        else {
            Salon salon1 = medicalShop.get();
            List<Category> existSalon = salon1.getCategoryList();
            existSalon.removeIf((med) ->med.getCategoryId().equals(Category));
            salon1.setCategoryList(existSalon);
            repository.save(salon1);
            return true;
        }
    }
    @Override
    public List<Salon> getSalonBasedOnCost(int price) {
        return repository.findByPriceGreaterThan(price);
    }

}