/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.copa.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author George
 */
public class Execute {

    /**
     * @param args the command line arguments
     */
    
     public void generateSchema(){
         //Cria objeto que receberá as configurações
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        
        //Informe o arquivo XML que contém a configurações
        cfg.configure();

        SchemaExport export = new SchemaExport(cfg);
        System.out.println("**************************************************");
        System.out.println("***** GENERATING SCRIPT: CREATE_SCRIPT.SQL *******");
        System.out.println("**************************************************");
        System.out.println("");
       // export.setOutputFile("create_script.sql");
       // export.create(true, true);
        System.out.println("**************************************************");
        System.out.println("**************** SCRIPT GENERATED ****************");
        System.out.println("**************************************************");
    }
    public static void main(String[] args) {
         Execute schemaGenerator= new Execute();
        schemaGenerator.generateSchema();
    }
}
