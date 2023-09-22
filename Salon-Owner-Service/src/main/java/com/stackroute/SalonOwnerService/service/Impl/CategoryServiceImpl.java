package com.stackroute.SalonOwnerService.service.Impl;

import com.stackroute.SalonOwnerService.exception.CategoryAlreadyExistException;
import com.stackroute.SalonOwnerService.exception.CategoryDoesNotExistException;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.repository.CategoryRepository;
import com.stackroute.SalonOwnerService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository repository;
    @Override
    public Category addCategory(Category category) throws CategoryAlreadyExistException {
        Category category1;
        Optional<Category> optionalCategory = repository.findById(category.getCategoryId());
        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Duplicate Category No");
        }
        else
            category1 = repository.save(category);
        return category1;
    }
    @Override
    public Iterable<Category> viewAllCategorys() {
        return repository.findAll();
    }

    @Override
    public boolean deleteCategorybyCategory(String category) throws CategoryDoesNotExistException {

        Optional<Category> optionalCategory = repository.findById(category);
        if(optionalCategory.isPresent()){
            repository.deleteById(category);
            return true;
        }else
            throw new CategoryDoesNotExistException("Category is not available in DB");
    }
    @Override
    public Category updateCategory(Category category) throws CategoryDoesNotExistException {
        Optional<Category> optionalCategory = repository.findById(category.getCategoryId());
        if(optionalCategory.isPresent()){
            return repository.save(category);
        }else
            throw new CategoryDoesNotExistException("Category is not Available in DB");
    }
    @Override
    public Optional<Category> getSalonCategoryByCategory(String category) {
        return repository.findById(category);
    }

    @Override
    public List<Category> getCategoryBasedOnCost(int price) {
        return repository.findByPriceGreaterThan(price);
    }

}
