package com.stackroute.SalonOwnerService.controller;

import com.stackroute.SalonOwnerService.exception.SalonIdDoesNotExistException;
import com.stackroute.SalonOwnerService.exception.CategoryAlreadyExistException;
import com.stackroute.SalonOwnerService.exception.CategoryDoesNotExistException;
import com.stackroute.SalonOwnerService.model.Category;
import com.stackroute.SalonOwnerService.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryServiceImpl service;

    @PostMapping("/addcategory")
    public ResponseEntity<?> addCategory(@RequestBody  Category category) throws CategoryAlreadyExistException, IOException {
        Category category1 = service.addCategory(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);

    }
    @GetMapping("viewallcategory")
    public ResponseEntity<?> viewAllCategorys(){
        Iterable<Category> categoryList = service.viewAllCategorys();
        return  new ResponseEntity<Iterable>(categoryList,HttpStatus.OK);
    }
    @DeleteMapping("/deletecategory/{cNo}")
    public ResponseEntity<?> deleteCategory(@PathVariable("cNo") String cno){
        try {
            boolean result = service.deleteCategorybyCategory(cno);
            return new ResponseEntity<String>("Category Record Deleted",HttpStatus.OK);
        } catch (CategoryDoesNotExistException e) {
            return new ResponseEntity<String>("Id not Found in DB",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updatecategory")
    public ResponseEntity<?> updateBlog(@RequestBody Category category){
        try {
            Category category1 = service.updateCategory(category);
            return new ResponseEntity<Category>(category1,HttpStatus.OK);
        } catch (CategoryDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("viewbycategory/{categoryNo}")
    public Optional<Category> viewByCategory(@PathVariable String categoryNo){
        return service.getSalonCategoryByCategory(categoryNo);
    }

    @GetMapping("viewbyprice/{maxprice}")
    public ResponseEntity<?> viewByPrice(@PathVariable int maxprice) {
        List<Category> categoryList = service.getCategoryBasedOnCost(maxprice);
        return new ResponseEntity<List>(categoryList, HttpStatus.OK);
    }
}
