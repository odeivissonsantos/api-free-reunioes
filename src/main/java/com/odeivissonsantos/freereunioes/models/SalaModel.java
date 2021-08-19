package com.odeivissonsantos.freereunioes.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class SalaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String data;
	
	@Column(nullable = false)
	private String horaInicio;
	
	@Column(nullable = false)
	private String horaTermino;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sala")
	private List<Convidado> convidado = new ArrayList<>();
	
	public SalaModel() {

	}


	public SalaModel(Integer id, String nome, String data, String horaInicio, String horaTermino,
			List<Convidado> convidado) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.convidado = convidado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public List<Convidado> getConvidado() {
		return convidado;
	}


	public void setConvidado(List<Convidado> convidado) {
		this.convidado = convidado;
	}


	@Override
	public String toString() {
		return "SalaModel [id=" + id + ", nome=" + nome + ", data=" + data + ", horaInicio=" + horaInicio
				+ ", horaTermino=" + horaTermino + ", convidado=" + convidado + "]";
	}
	
	
	

}
