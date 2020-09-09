package com.service;

import com.dao.CrudDao;
import com.domain.Man;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ManServiceImpl implements CrudService<Man> {

    private CrudDao<Man> crudDao;

    @Autowired
    public ManServiceImpl(@Qualifier("manDao") CrudDao<Man> crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void save(Man man) {
        crudDao.save(man);
    }

    @Override
    public Man findById(int id) {
        return crudDao.findById(id);
    }

    @Override
    public void update(Man man) {
        crudDao.update(man);
    }

    @Override
    public void deleteById(int id) {
        crudDao.deleteById(id);
    }
}
