package controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import model.Fabricante;
import model.dao.FabricanteDAO;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private ListDataModel<Fabricante> fabricantes;
	private Fabricante fabricante;

	public ListDataModel<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ListDataModel<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@PostConstruct
	public void carregarDados() {
		atualizarLista();
		fabricante = new Fabricante();
	}

	private void atualizarLista() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			List<Fabricante> lista = dao.listar();
			fabricantes = new ListDataModel<>(lista);
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararAdicionar() {
		fabricante = new Fabricante();
	}
	
	public void adicionar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			atualizarLista();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararExcluir() {
		fabricante = fabricantes.getRowData();
	}
	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);
			atualizarLista();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante excluido com sucusso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	public void prepararEditar() {
		fabricante = fabricantes.getRowData();
	}
	
	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);
			atualizarLista();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante editado com sucesso.");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

}
