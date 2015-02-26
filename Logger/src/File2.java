import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class File2 extends Cibles{

	public File2(){
			
	}
		
	public void write(String chaine){
		String fichier2 ="toto.log";
		//création ou ajout dans le fichier texte
		try {
			FileWriter fw = new FileWriter (fichier2, true);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
			fichierSortie.println (chaine); 
			fichierSortie.close();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

}
