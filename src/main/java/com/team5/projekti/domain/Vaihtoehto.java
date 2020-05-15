package com.team5.projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vaihtoehto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vaihtoehtoid;
	private String teksti;

	@ManyToOne
	@JoinColumn(name = "kysymysId")
	private Kysymys kysymys;

	public Vaihtoehto() {
		this.teksti = null;
	}

	public Vaihtoehto(String teksti, Kysymys kysymys) {
		this.teksti = teksti;
		this.kysymys = kysymys;
	}

	public Long getVaihtoehtoid() {
		return vaihtoehtoid;
	}

	public void setVaihtoehtoid(Long vaihtoehtoid) {
		this.vaihtoehtoid = vaihtoehtoid;
	}

	public String getTeksti() {
		return teksti;
	}

	public void setTeksti(String teksti) {
		this.teksti = teksti;
	}

	public Kysymys getKysymys() {
		return kysymys;
	}

	public void setKysymys(Kysymys kysymys) {
		this.kysymys = kysymys;
	}

	@Override
	public String toString() {
		return teksti;
	}

}
