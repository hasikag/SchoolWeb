package com.school.service;

import com.school.dao.SchoolDAO;
import com.school.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:59 AM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService{

    @Autowired
	private SchoolDAO schoolDAO;


    @Override
    public void saveOrUpdate(School school) {
        schoolDAO.saveOrUpdate(school);
    }

    @Override
    public void delete(int contactId) {
        schoolDAO.delete(contactId);
    }

    @Override
    public School get(int contactId) {
//        return new School("Straw Nest Primary School","003","10 Showground Road","@straw-nest.com.au");
        return schoolDAO.get(contactId);
    }

    @Override
    public List<School> list() {
        return schoolDAO.list();
    }
}
