package com.example.coffeeshop_e_prep.service;

import com.example.coffeeshop_e_prep.model.entity.Category;
import com.example.coffeeshop_e_prep.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
