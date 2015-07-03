package com.school.dao;

import com.school.model.School;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:43 AM
 * Defines DAO operations for the school model.
 */
public interface SchoolDAO {
    public void saveOrUpdate(School school);

	public void delete(int contactId);

	public School get(int contactId);

	public List<School> list();
}

