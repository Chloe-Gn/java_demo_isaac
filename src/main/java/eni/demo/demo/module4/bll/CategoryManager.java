package eni.demo.demo.module4.bll;

import eni.demo.demo.module4.bo.Category;
import eni.demo.demo.module4.dao.IDAOCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryManager{

// On peut aussi utiliser un Autowired à la place

   private IDAOCategory categoryDao;


    public CategoryManager (IDAOCategory categoryDAO){
        this.categoryDao = categoryDAO;
    }

    @Override
    public List<Category> getCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryDao.findById(id);
    }


}
