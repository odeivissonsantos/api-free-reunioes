package com.odeivissonsantos.freereunioes.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Convidado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nomeCompleto;
	
	@Column
	private String telefone;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private SalaModel sala;
	
	public Convidado() {

	}

	public Convidado(Integer id, String nomeCompleto, String telefone, SalaModel sala) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.telefone = telefone;
		this.sala = sala;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public SalaModel getSala() {
		return sala;
	}

	public void setSala(SalaModel sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Convidado [id=" + id + ", nomeCompleto=" + nomeCompleto + ", telefone=" + telefone + ", sala=" + sala
				+ "]";
	}
	
	
	
	
	
	
}
