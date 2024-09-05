package eni.demo.demo.module4.ihm.converter;

import eni.demo.demo.module4.bll.ICategoryManager;
import eni.demo.demo.module4.bo.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//on l'appelle nulle part. c'est fait en caché par Spring

@Component
public class StringToCategoryConverter implements Converter<String, Category> {

    private ICategoryManager categoryManager;

    public StringToCategoryConverter(ICategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }



    @Override
    public Category convert(String idCategory) {

        System.out.println("Conversion de idCategory = " + idCategory);

        //il faut redescendre dans les couches et dans la BDD

        // Ci dessous, on convertit le String en Long avec "Long.parseLong")
        return categoryManager.getCategory(Long.parseLong(idCategory));
    }
}
