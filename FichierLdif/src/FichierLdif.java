/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author T410
 */
import java.io.FileReader ;
import java.io.FileWriter ;
import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.PrintWriter;

public class FichierLdif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
    String path = "users.ldif";
    String text;
    String text1;
    BufferedReader br = new BufferedReader(new FileReader("users.csv"));
    String ligne = null;
    PrintWriter ecri = null ;
    ecri = new PrintWriter(new FileWriter(path));
    
      text1=
        "dn: dc=heigvd,dc=ch \n"+
        "dc: heigvd \n"+
        "objectClass: domain\n" +
        "objectClass: top\n\n" +
      
        "dn: ou=People,dc=heigvd,dc=ch \n"+
        "ou: People \n"+
        "objectClass: organizationalunit\n" +
        "objectClass: top\n\n" ;
                    
         ecri.print(text1);  
         
        while ((ligne = br.readLine()) != null)
     {
      // Retourner la ligne dans un tableau
      String[] data = ligne.split(",");
       
      // Afficher le contenu du tableau
     
          text=
        "dn: uid="+data[0]+",ou=People,dc=heigvd,dc=ch \n"+
        "objectClass: person\n" +
        "objectClass: inetorgperson\n" +
        "objectClass: organizationalperson\n" +
        "objectClass: top\n" +
        "uid: "+data[0]+"\n"+
        "givenName: "+data[1]+"\n" +
        "cn: "+data[1]+""+data[2]+"\n" +
        "sn: "+data[2]+"\n" +
        "description: "+data[5]+"\n"+
        "telephoneNumber: "+data[3]+"\n" +
        "departmentNumber: "+data[6]+"\n" +  
        "employeeType: "+data[7]+"\n" + 
        
        "mail: "+data[4]+"\n\n";
                
	ecri.print(text);
	//ecri.flush();
        
         }
    ecri.close();
			
    br.close();
       
    
  }
}

