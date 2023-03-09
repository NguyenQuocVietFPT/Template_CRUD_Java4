package com.iamviet.template_crud_java4.repositories;

import com.iamviet.template_crud_java4.entities.DongVat;

import java.util.List;

public interface IDongVatrRepository {

    /*Get all dongvats from database*/
    List<DongVat> getAll();


    /*Add new dongvat into database*/
    DongVat addNew(DongVat dv);


    /*Get one dongvat by id from database*/
    DongVat getById(Integer id);


    /*Update dongvat by id */
    void updateById(DongVat dv);


    /*Delete dongvat by id */
    void deleteById(DongVat dv);

}
