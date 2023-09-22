package com.stackroute.SalonOwnerService.service;

import com.stackroute.SalonOwnerService.exception.CategoryAlreadyExistException;
import com.stackroute.SalonOwnerService.exception.CategoryDoesNotExistException;
import com.stackroute.SalonOwnerService.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    public Category addCategory(Category category) throws CategoryAlreadyExistException;
    public Iterable<Category> viewAllCategorys();
    //delete
    boolean deleteCategorybyCategory(String category) throws CategoryDoesNotExistException;
    public Category updateCategory(Category category) throws CategoryDoesNotExistException;
    //update
    public Optional<Category> getSalonCategoryByCategory(String category);
    List<Category> getCategoryBasedOnCost(int price);

}
