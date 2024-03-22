package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Task {
	private Long id;
	private String nome;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date dataTask;
	
	public Task(Long id, String nome, Date dataTask) {
		this.id = id;
		this.nome = nome;
		this.dataTask = dataTask;
	}
	
	public Task() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataTask() {
		return dataTask;
	}
	public void setDataTask(Date data) {
		this.dataTask = data;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", nome=" + nome + ", dataTask=" + dataTask + "]";
	}
	
	
	

}
