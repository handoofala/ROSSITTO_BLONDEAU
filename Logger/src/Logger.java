import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Logger {
	
ArrayList<Cibles> ciblesList;
String level="debug";
	public Logger() {
		ciblesList=new ArrayList<Cibles>();
		FileReader fr;
		BufferedReader bf;
		try{
			fr=new FileReader("src/Logger.properties");
			bf = new BufferedReader(fr);
			if(findterm(bf)){
				Terminal t=new Terminal();
				ciblesList.add(t);
			}
		
		
		
			bf.close();
		}catch (IOException e){
			System.out.println("file not found");
			
		}
		
		try {
			fr=new FileReader("src/Logger.properties");
			bf = new BufferedReader(fr);
			if(findfile(bf)){
				File file=new File();
				ciblesList.add(file);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
	
		
		
	}
	
	public boolean findfile(BufferedReader bf){
		String s;
		try {
			while( (s=bf.readLine())!=null){
				if(s.contains("TextFile :")){
					//System.out.println("lignetrouvée:::");
					if(s.contains("true")){
						return true;
					}
					else {
						return false;
					}
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	public boolean findterm(BufferedReader bf) throws IOException{
		String s;
		
		while( (s=bf.readLine())!=null){
			if(s.contains("terminal")){
				//System.out.println("lignetrouvée:::");
				if(s.contains("true")){
					return true;
				}
				else {
					return false;
				}
			}
			
		}
		
		
	return false;	
	}
	
	
public String addCible(Cibles cible){
	ciblesList.add(cible);
	return "cible ajoutée";
}	
	
public String setLevel(String s){
	if(s=="debug" || s=="info" || s=="error"){
	level=s;
	return "ok";
	
	}
	else return "invalid statement";
}
	
	
public void debug(String message){
	if(level=="debug")
	write(message);
	
	
}
public void info(String message){
	if(level=="info" ||level=="debug"){
		
		write(message);
		
	}
	
	
}
	
public void error(String message){
	
	
	write(message);
	
	
}

private void write(String message){
	int i;
	for(i=0;i<ciblesList.size();i++){
		ciblesList.get(i).write(message);
		
	}
	
}

}
