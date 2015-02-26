import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


public class File2 extends Cibles{

	public File2(){
			
	}
		
	public void write(String chaine){
		String fichier2 ="toto.log";
		boolean continueWriting = true;
		File file = new File(fichier2);
		if(file.exists() && !file.isDirectory()){
			//le fichier existe déjà. On vérifie donc sa taille. Si la taille est trop grande, on réecrira au début du fichier.
			if(file.length() > 500){
				System.out.println("Trop long! : "+file.length());
				continueWriting = false;
			}
			else{
				System.out.println("file exist! : "+file.length());
			}
		}
		//création ou ajout dans le fichier texte
		try {
			FileWriter fw = new FileWriter (fichier2, continueWriting);
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
