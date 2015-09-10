package controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Fabricante;
import model.Produto;
import model.dao.FabricanteDAO;
import model.dao.ProdutoDAO;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private List<Fabricante> fabricantes;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void carregarDados() {
		atualizarLista();
		produto = new Produto();
	}

	public void atualizarLista() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararSalvar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();

			produto = new Produto();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void salvar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
			
			atualizarLista();

			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			
			atualizarLista();
			
			JSFUtil.adicionarMensagemSucesso("Produto excluido com sucesso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararEditar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			
			atualizarLista();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	
}
