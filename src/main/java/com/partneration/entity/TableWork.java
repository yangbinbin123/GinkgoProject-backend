package com.partneration.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 表格
 * @author John
 *
 */
@Entity
@Table(name = "table_work")
public class TableWork implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id")
	private int tableId;
	
	@Column(name = "table_name", nullable = false)
	private String tableName;
	
	@Column(name = "table_description")
	private String tableDescription;
	
	@Column(name = "table_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tableCreatedTime;
	
	//该表格有哪些问题
	@OneToMany(targetEntity = Question.class, mappedBy = "tableWork", fetch = FetchType.LAZY)
	private Set<Question> questions = new HashSet<>();

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}

	public Date getTableCreatedTime() {
		return tableCreatedTime;
	}

	public void setTableCreatedTime(Date tableCreatedTime) {
		this.tableCreatedTime = tableCreatedTime;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
}
