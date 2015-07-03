package com.school.service;

import com.school.model.School;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hga
 * Date: 7/2/15
 * Time: 1:58 AM
 * To change this template use File | Settings | File Templates.
 */
public interface SchoolService {

    public void saveOrUpdate(School school);

	public void delete(int contactId);

	public School get(int contactId);

	public List<School> list();
}
