/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.copa.runnable;

import br.copa.dao.EstadioDAO;
import br.copa.model.Estadio;
import br.copa.util.Execute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.json.JSONObject;
import org.apache.catalina.util.Base64;

/**
 *
 * @author George
 */
public class TesteBanco {
      
    
    public static void main(String[] args) {
     Estadio estadio = new Estadio();
     Estadio estadio2 = new Estadio();
     Estadio estadio3 = new Estadio();
     Estadio estadio4 = new Estadio();
     EstadioDAO estadioDao = new EstadioDAO();
     TesteBanco teste = new TesteBanco();
     List<Estadio>estadioList = new ArrayList<Estadio>();
     Iterator it;
    
//     
//     teste.criarEsquemaDeBanco();
//     
     //verificação do json
//       estadio = estadioDao.getEstadio(4);
//       JSONObject jsonObj = new JSONObject();
//          jsonObj.put("message",estadio.getNome());
//       //String imagemCod = Base64.encode(estadio.getFoto());
//       System.out.println(jsonObj);
               
     //recupera a imagem do banco e a escreve em um arquivo
   
     /*
     estadio = estadioDao.getEstadio(1);
     
     try{
            //FileOutputStream fos = new FileOutputStream("images\\output.jpg");  //windows
            FileOutputStream fos = new FileOutputStream("D:/Arquivos/CopaAdvisor/output.jpg");
            fos.write(estadio.getFoto());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
     */
     
     //gravando uma imagem no banco
     File file = new File("D:/Arquivos/CopaAdvisor/img/maracana4.jpg");
    
     // Converte o arquivo em um array de bytes
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
           System.out.println("Erro: "+e.getMessage());
        }
        
        estadio = estadioDao.getEstadio(2);
        estadio.setFoto(bFile);
        estadioDao.update(estadio);
     
      //busca de todos os estadios cadastrados
     /*estadioList = estadioDao.getEstadios();
     it = estadioList.iterator();
     while(it.hasNext()){
       estadio = (Estadio) it.next();
       System.out.println(estadio);
     }*/
     
     
     
     //busca dos estadio atraves do id
     /*estadio = estadioDao.getEstadio(4);
     System.out.println(estadio);*/
     
     
     
     //update dos estadios
     /*estadio = estadioDao.getEstadio(4);
     estadio.setNome("Mané Garrincha");
     estadioDao.update(estadio);*/
     
  //   teste.criarEsquemaDeBanco(); acho q não preciso usar pois funciona sem ele
     
     //criaçao e cadastro dos objetos estadios
     /*
      estadio.setNome("Maracanã");
      estadio.setDescricao("Estádio Jornalista Mário Filho, mais conhecido como Maracanã,"
              + "o popular Maraca (semelhante a um chocalho em tupi-guarani, "
              + "devido ao som de pássaros que viviam por ali), é um estádio de futebol localizado no Rio de Janeiro "
              + "e inaugurado em 1950, tendo sido utilizado na Copa do Mundo de Futebol daquele ano. "
              + "Desde então, o Maracanã foi palco de grandes momentos do futebol brasileiro e mundial, "
              + "como o milésimo gol de Pelé, finais do Campeonato Brasileiro, Carioca de Futebol, "
              + "Taça Libertadores da América e do primeiro Campeonato Mundial de Clubes da FIFA, "
              + "além de competições internacionais e partidas da Seleção Brasileira. "
              + "Foi um dos locais de competição dos Jogos Pan-Americanos de 2007, recebendo o futebol, "
              + "as cerimônias de abertura e de encerramento. Sediará o futebol e as cerimônias de abertura e "
              + "encerramento dos Jogos Olímpicos de 2016, que serão realizados na cidade do Rio de Janeiro. "
              + "É também o provável palco da partida final da Copa do Mundo FIFA de 2014");
      
      estadio2.setNome("Mineirão");
      estadio2.setDescricao("O Estádio Governador Magalhães Pinto, mais conhecido como Mineirão, "
              + "é o segundo maior estádio de futebol do Brasil e o 29ª maior do mundo, "
              + "de acordo com as estimativas do World Stadium. No Brasil é superado apenas pelo Maracanã.");
      
      estadio3.setNome(null);
      estadio3.setDescricao("O Estádio Mané Garrincha foi um estádio de futebol inaugurado em 1974 e demolido em 2010, "
              + "para dar lugar ao novo Estádio Nacional de Brasília.O estádio abrigava um complexo esportivo com vestiários, "
              + "sala de fisioterapia, alojamento, restaurante e academias. Além de contar com uma escolinha de futebol, "
              + "o estádio possuía ambiente, ainda, para a prática de outras modalidades, como judô, ginástica, capoeira e dança. "
              + "O Mané Garrincha tornou-se sede das federações de esportes da cidade de Brasília e pertencía ao Departamento de Esportes,"
              + " Educação Física e Recreação do Distrito Federal."
              + ""
              + "O jogador Mané Garrincha foi homenageado pelos brasilienses ainda vivo. "
              + "Porém, na época tinha 40 anos e, não estando em forma física ideal, não pôde atuar no estádio que leva o seu nome.");
      
      estadioDao.salvar(estadio);
      estadioDao.salvar(estadio2);
      estadioDao.salvar(estadio3);*/
        
    }
    
     public void criarEsquemaDeBanco(){
            Execute schemaGenerator= new Execute();
            schemaGenerator.generateSchema();
    }
    
}
