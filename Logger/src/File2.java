import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.RandomAccessFile;

public class File2 extends Cibles{

	public File2(){
			
	}
		
	public void write(String chaine){
		String fichier2 ="toto.log";
		boolean continueWriting = true;
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
		rotateFile(fichier2);
	}
	
	private void rotateFile(String fichier2){
		File file = new File(fichier2);
		if(file.exists() && !file.isDirectory() && file.length() > 512){
			//le fichier existe bien, n'est pas un répertoire et dépasse les X bits : on réecrira donc à la fin du fichier en enlevant les lignes les plus anciennes.
			System.out.println("Trop long! : "+file.length() + ", rotation");
			try {
				RandomAccessFile tools = new RandomAccessFile(file, "rw");
				tools.readLine(); // On va a la seconde ligne
				long length = tools.length() - tools.getFilePointer(); // moins la première, sinon ça marchera moins bien
				byte[] nexts = new byte[(int) length];
				tools.readFully(nexts); // Lecture de toutes les autres lignes.
				tools.seek(0); // On retourne ensuite au début du fichier
				tools.write(nexts); // On insert juste une ligne avant
				tools.setLength(nexts.length); // On tronque la dernière ligne dupliquée.
				tools.close();
	 
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}

}
