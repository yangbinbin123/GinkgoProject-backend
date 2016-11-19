package com.partneration.dao;


import java.util.List;

import com.partneration.entity.School;

public interface SchoolDao extends BaseDao<School> {

	public List<School> findSchools(int schoolId);
}
