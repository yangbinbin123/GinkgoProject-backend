package com.partneration.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 学校实体类
 * @author John
 *
 */
@Entity
@Table(name = "school")
public class School implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int schoolId;
	
	@Column(nullable = false, name = "school_name")
	private String schoolName;
	
	@Column(name = "school_description")
	private String SchoolDescription;
	
	@OneToMany(targetEntity = College.class, mappedBy = "school", fetch = FetchType.LAZY)
	private Set<College> colleges = new HashSet<>();

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolDescription() {
		return SchoolDescription;
	}

	public void setSchoolDescription(String schoolDescription) {
		SchoolDescription = schoolDescription;
	}

	public Set<College> getColleges() {
		return colleges;
	}

	public void setColleges(Set<College> colleges) {
		this.colleges = colleges;
	}
	
	
}
