package com.partneration.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.partneration.dao.SchoolDao;
import com.partneration.entity.School;

@Repository("schoolDao")
public class SchoolDaoImpl extends BaseDaoImpl<School>implements SchoolDao {

	@Override
	public List<School> findSchools(int schoolId) {
		String hql = "from School as s where s.schoolId = ?";
		return find(hql, schoolId);
	}

	
}
