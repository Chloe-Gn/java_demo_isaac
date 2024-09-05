package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.bo.Category;

import java.util.List;

public interface ICategoryManager {

    List<Category> getCategories();
    Category getCategory(Long id);

}
