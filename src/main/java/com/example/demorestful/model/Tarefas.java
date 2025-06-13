package com.example.demorestful.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefas {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nameTarefa;
	private String dataEntrega;
	private String responsavelTarefa;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameTarefa() {
		return nameTarefa;
	}
	public void setNameTarefa(String nameTarefa) {
		this.nameTarefa = nameTarefa;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getResponsavelTarefa() {
		return responsavelTarefa;
	}
	public void setResponsavelTarefa(String responsavelTarefa) {
		this.responsavelTarefa = responsavelTarefa;
	}
	@Override
	public String toString() {
		return "Tarefas [id=" + id + ", nameTarefa=" + nameTarefa + ", dataEntrega=" + dataEntrega + ", responsavelTarefa=" + responsavelTarefa + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nameTarefa, dataEntrega, responsavelTarefa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefas other = (Tarefas) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameTarefa, other.nameTarefa) && Objects.equals(dataEntrega, other.dataEntrega)
				&& Objects.equals(responsavelTarefa, other.responsavelTarefa);
	}
}
