/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.copa.dao.EstadioDAO;
import br.copa.model.Estadio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.catalina.util.Base64;

/**
 *
 * @author George
 */
public class principal extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            
        } finally {            
            out.close();
        }
    }
    
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
       



    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
        
        
             String resposta = request.getParameter("mensagem");
             resposta += "Estou ouvindo do post de novo"; 
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
//             HashMap<String,String> hm = new HashMap<String,String>();
//
//           hm.put("message","My first JSON application");
//
//           //Cada chave do HashMap vira uma Chave do JSON
           
            Estadio estadio = new Estadio();
            EstadioDAO est = new EstadioDAO();
            estadio = est.getEstadio(2);
            
            
             String  teste = estadio.getNome();
           JSONObject jsonObj = new JSONObject();
          jsonObj.put("message",teste);
          jsonObj.put("foto",Base64.encode(estadio.getFoto()));
          
//           // JSONObject json = JSONObject.fromObject(hm);
//            System.out.println(jsonObj);
// 
//
            //response.setContentType("application/json");
//            PrintWriter out = response.getWriter();

  // Pega a Stream de Saída do servidor que sera utilizada para enviar a resposta JSON

             //out.print(json);//Escreve a resposta no formato JSON na Stream de saída que será recebida pela aplicação cliente
             
            //out.println(resposta);
            //out.println("{ 'messagem' : 'Json criado' ");
            out.println(jsonObj);
             out.flush();
             out.close();
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
}
