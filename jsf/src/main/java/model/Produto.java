package model;

public class Produto {

	private Integer id;
	private String descricao;
	private Integer quantidade;
	private Double preco;
	private Fabricante fabricante = new Fabricante();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	@Override
	public String toString() {
		return id+" - "+descricao+" - "+quantidade+" - "+preco+" - "+fabricante.getDescricao();
	}
	
}
