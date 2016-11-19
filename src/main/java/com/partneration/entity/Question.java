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
 * 问题表
 * @author John
 *
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "question_name")
	private String questionName;
	
	@Column(name = "must_answer")
	private int mustAnswer;
	
	//表格中的题号
	@Column(name = "title_id")
	private int titleId;
	
	//该问题对应的表
	@ManyToOne(targetEntity = TableWork.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "table_id", referencedColumnName = "table_id")
	private TableWork tableWork;
	
	//问题的答案
	@OneToMany(targetEntity = Answer.class, mappedBy = "question", fetch = FetchType.LAZY)
	private Set<Answer> answers = new HashSet<>();

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public int getMustAnswer() {
		return mustAnswer;
	}

	public void setMustAnswer(int mustAnswer) {
		this.mustAnswer = mustAnswer;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public TableWork getTableWork() {
		return tableWork;
	}

	public void setTableWork(TableWork tableWork) {
		this.tableWork = tableWork;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
}
