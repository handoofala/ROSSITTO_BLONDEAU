import java.io.*;

public class File extends Cibles{

	public File(){
			
	}
		
	public void write(String chaine){
		String fichier ="toto.log";
		//création ou ajout dans le fichier texte
		try {
			FileWriter fw = new FileWriter (fichier, true);
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
