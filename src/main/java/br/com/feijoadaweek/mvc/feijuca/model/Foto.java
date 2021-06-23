package br.com.feijoadaweek.mvc.feijuca.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="restaurante_id", nullable=true)
	private Prato restaurante;
	
	@ManyToOne
	@JoinColumn(name="prato_id", nullable=true)
	private Prato prato;
	
	@ManyToOne
	@JoinColumn(name="marca_id", nullable=true)
	private Prato marca;
	
	@ManyToOne
	@JoinColumn(name="cerveja_id", nullable=true)
	private Prato cerveja;

	private String nome;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	private String url;
	
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Prato getPrato() {
//		return prato;
//	}
//
//	public void setPrato(Prato prato) {
//		this.prato = prato;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Prato getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Prato restaurante) {
		this.restaurante = restaurante;
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	public Prato getMarca() {
		return marca;
	}

	public void setMarca(Prato marca) {
		this.marca = marca;
	}

	public Prato getCerveja() {
		return cerveja;
	}

	public void setCerveja(Prato cerveja) {
		this.cerveja = cerveja;
	}

	
	
}
