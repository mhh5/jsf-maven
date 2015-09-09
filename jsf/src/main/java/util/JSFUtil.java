package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtil {

	private static void adicionarMensagem(FacesMessage mensagem) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);
	}
	
	public static void adicionarMensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		//adicionarMensagem(msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		//adicionarMensagem(msg);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, msg);
	}
	
}
