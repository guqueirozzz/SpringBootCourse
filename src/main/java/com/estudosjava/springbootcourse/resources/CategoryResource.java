package com.estudosjava.springbootcourse.resources;

import com.estudosjava.springbootcourse.entities.Category;
import com.estudosjava.springbootcourse.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listAll(){
        List<Category> categories = categoryService.listAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> listById(@PathVariable Long id){
        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

}
