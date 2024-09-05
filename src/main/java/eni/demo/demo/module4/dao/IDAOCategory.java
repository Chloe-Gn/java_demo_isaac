package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Category;

import java.util.List;

public interface IDAOCategory {

    List<Category> findAll();

    Category findById(Long id);
}
