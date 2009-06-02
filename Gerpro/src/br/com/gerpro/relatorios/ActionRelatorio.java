/*
 * ActionReport.java
 *
 * Created on December 7, 2007, 8:20 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.gerpro.relatorios;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.StateManager;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.gerpro.util.HibernateUtil;

/**
 *
 * @author vista
 */
public class ActionRelatorio{
    
    //Usados para a conex�o com o banco de dados
    //private static Connection con = null;
    //private static String driver = "com.mysql.jdbc.Driver";
    //private static String endereco = "jdbc:mysql://localhost/gerprodb";
    ///private static String user = "root";
    //private static String pass = "123";
	private static	Session session = null;
	private static Transaction tx = null;
	
    
	
	
     String tmp = this.getClass().getResource("/br/com/gerpro/relatorios").getPath();
    
    
    /**
     * <p>Prefixo do nome do recurso para relat�rios compilados.</p>
     */
    //private static final String PREFIX = "../../../WEB-INF/classes/org/maternidade/relatorios/";
    private String SUB = tmp;
    	
    /**
     * <p>Sufixo do nome do recurso para relat�rios compilados.</p>
     */
    private static final String SUFFIX = ".jasper";
    
    
    /** Creates a new instance of ActionReport */
    public ActionRelatorio() {
        
       // formatador = Formatador.getInstance();
        //this.pacDAO = new ParturienteDAO();
        //this.setNomeConsulta(null);
        //this.setListaParturiente(null);
        
    }
    
    
    /*public String gerarHistorico(){
        
      //  if(formatador.getFuncionario().getAdm().equalsIgnoreCase("S")){
            
          //  if(listaParturiente != null){
               // Parturiente part = (Parturiente)getListaParturiente().getRowData();
                
                //Map<String,Object> params = new HashMap<String,Object>();
                //params.put("idParturiente",part.getIdPac());
    	HashMap map = new HashMap();
                try{
                    
                    conexao();
                    jasperReport("historicoParturiente",map);
                    
                }catch(Exception e){
                    
                    System.out.println(e.getMessage());
                }
        //    }
            //return null;
            
        //}else
          //  return "erroAcesso";
        
        
        
        
    }
    */
    public String gerarRelatorioProposta(){
        
            
            Map<String,Object> params = new HashMap<String,Object>();
            /*params.put("data_inicio",getDt_inicial());
            params.put("data_fim",getDt_final());
            */
            //Valor retornado na compara��o entre as datas.
          //  comparadorData = dt_inicial.compareTo(getDt_final());
                
                
                try{
                    
        //            conexao();
                    jasperReport("proposta",params);
                    
                }catch(Exception e){
                    
                    System.err.println(e.getMessage());
                    
                }
                       
        return null;
        
    }
    
    public void jasperReport(String nome, Map params){
        
    	session = HibernateUtil.getSession();
    	tx = session.beginTransaction();
    	
    	try {
            
            byte[] pdf = JasperRunManager.runReportToPdf(SUB+nome+SUFFIX, params, session.connection());
            
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse)faces.getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(pdf.length);
            response.setHeader("Content-disposition", "inline");
            
            response.setHeader("Cache-Control", "cache, must-revalidate");
            response.setHeader("Pragma", "public");
            ServletOutputStream out = response.getOutputStream();
            
            out.write(pdf);
            StateManager stateManager = (StateManager)faces.getApplication().getStateManager();
            stateManager.saveSerializedView(faces);
            
            faces.responseComplete();
            
        } catch (RuntimeException e) {
            
            throw e;
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
            throw new FacesException(e);
            
        }finally{
        	 session.close();
        }
        
        
           
        
    }
    
    //Cria a conexao
/*    public void conexao(){
        
        try{
            if (con == null || con.isClosed()){
                Class.forName(driver);
                con = DriverManager.getConnection(endereco,user,pass);
            }
            
        }catch(Exception e){
            System.err.println("N�o foi poss�vel conectar ao banco ->");
            System.err.println(e.getMessage());
        }
    }
    
*/    
    //Fun��o para realizar busca de Parturiente
    /*public String pesquisarParturiente(){
        
        if(this.getNomeConsulta() == null || this.getNomeConsulta().length() == 0){
            
            return null;
            
        }else {
            
            //Lista de Parturiente.
            List<Parturiente> lista = pacDAO.buscarParturiente(getNomeConsulta());
            
            //Verifica se n�o foi encontrado parturiente.
            if(lista.size() == 0){
                
                System.out.println("Parturiente n�o encontrada. Verificar como mostrar um resposta na tela");
                return null;
            }
            
            //Seta a lista de parturiente encontrado.
            setListaParturiente(new ListDataModel(lista));
            
        }
        
        return null;
    }
    */
      //Fun��o com responsabilidade de limpar os dados da sess�o e retorna a string fechar
    public String fechar(){
        
       // limparAtributos();
        return "fechar";
        
    }
    
    }
