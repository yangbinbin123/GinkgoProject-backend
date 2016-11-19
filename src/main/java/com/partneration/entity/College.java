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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 学院实体类
 * @author John
 *
 */
@Entity
@Table(name = "college")
public class College implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	
	@Column(nullable = false)
	private String collegeName;
	
	private String collegeDescription;
	
	//对应学校
	@ManyToOne(targetEntity = School.class)
	@JoinColumn(name = "school_id", referencedColumnName = "school_id")
	private School school;

	//对应专业
	@OneToMany(targetEntity = Specialty.class, mappedBy = "college", fetch = FetchType.LAZY)
	private Set<Specialty> specialties = new HashSet<>();

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeDescription() {
		return collegeDescription;
	}

	public void setCollegeDescription(String collegeDescription) {
		this.collegeDescription = collegeDescription;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Specialty> getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	
}
