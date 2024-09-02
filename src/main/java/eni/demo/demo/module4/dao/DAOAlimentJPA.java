package eni.demo.demo.module4.dao;

import eni.demo.demo.module4.bo.Aliment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Profile("jpa")
public class DAOAlimentJPA implements IDAOAliment{

    @Autowired
    AlimentRepository alimentRepository;


    @Override
    public List<Aliment> selectAliments() {
      return (List<Aliment>) alimentRepository.findAll();
    }

    @Override
    public Aliment getAlimentById(long id) {
        return alimentRepository.findById(id).get();
    }

    @Override
    public void saveAliment(Aliment aliment) {

        alimentRepository.save(aliment);

    }
}
