package com.odeivissonsantos.freereunioes.models;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sala")
public class SalaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private String horaInicio;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "HH:mm")
	private String horaTermino;
	
	

	public SalaModel() {
		super();
	}

	public SalaModel(Integer id, String nome, LocalDate data, String horaInicio, String horaTermino) {
		super();
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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

	@Override
	public String toString() {
		return "SalaModel [id=" + id + ", data=" + data + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino
				+ "]";
	}
	
	
	

}
