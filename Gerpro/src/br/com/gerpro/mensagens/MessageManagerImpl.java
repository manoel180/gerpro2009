/**
 * 
 */
package br.com.gerpro.mensagens;

import javax.faces.application.FacesMessage;

/**
 * @author Clã dos Souza
 *
 */
public class MessageManagerImpl {
	private static MessageManager messageManager =  new MessageManager();
	
	public static void setMensagem(FacesMessage.Severity severidade, String mensagem, String detalhes){
		messageManager.setMensagem(severidade, mensagem, detalhes);
	}

}
