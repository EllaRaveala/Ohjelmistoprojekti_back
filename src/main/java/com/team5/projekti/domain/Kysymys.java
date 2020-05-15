package com.team5.projekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Kysymys {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long kysymysId;
	private String question;
	private String type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> answers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	public List<Vaihtoehto> vaihtoehdot;

	public Kysymys() {
		this.question = null;
	}

	public Kysymys(String question, String type) {
		this.question = question;
		this.type = type;

	}


	public Long getId() {
		return kysymysId;
	}

	public void setId(Long id) {
		this.kysymysId = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Vastaus> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Vastaus> answers) {
		this.answers = answers;
	}

	public List<Vaihtoehto> getVaihtoehdot() {
		return vaihtoehdot;
	}

	public void setVaihtoehdot(List<Vaihtoehto> vaihtoehdot) {
		this.vaihtoehdot = vaihtoehdot;
	}

	@Override
	public String toString() {
		return "Kysymys [id=" + kysymysId + ", question=" + question + ", type=" + type + "]";
	}

}
