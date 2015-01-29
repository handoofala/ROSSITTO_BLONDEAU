import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Date;

public class Logger {
	
	
	ArrayList<Cibles> errorList;
	
	ArrayList<Cibles> debugList;
	ArrayList<Cibles> infoList;
ArrayList<Cibles> ciblesList;
String level="debug";
Date date;
private boolean putDate;
private boolean puterrorlevel;
	public Logger() {
		ciblesList=new ArrayList<Cibles>();
		errorList=new ArrayList<Cibles>();
		debugList=new ArrayList<Cibles>();
		infoList=new ArrayList<Cibles>();
		FileReader fr;
		BufferedReader bf;
		putDate=true;
		puterrorlevel=true;
		
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
	
	public void activeDate(){
		putDate=true;
		
	}
	public void remoteDate(){
		putDate=false;
	}
	public void activeerrorlevel(){
		puterrorlevel=true;
	}
	public void remoteerrorlevel(){
		puterrorlevel=false;
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
	
	
public String addDefaultCible(Cibles cible){
	ciblesList.add(cible);
	return "cible ajoutée";
}	
	
public String addErrorCible(Cibles cible){
	errorList.add(cible);
	return "cible ajoutée";
}	
public String addDebugCible(Cibles cible){
	debugList.add(cible);
	return "cible ajoutée";
}	
public String addInfoCible(Cibles cible){
	infoList.add(cible);
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
	write(addDate()+adderrorlevel("debug")+message);
	writedebug(addDate()+adderrorlevel("debug")+message);
	
}
public void info(String message){
	if(level=="info" ||level=="debug")
		
		write(addDate()+adderrorlevel("info")+message);
		
		writeinfo(addDate()+adderrorlevel("info")+message);
	
}
private String adderrorlevel(String a){
	if(puterrorlevel)return a+"//";
	return "";
}


public void error(String message){
	
	
	write(addDate()+adderrorlevel("error")+message);
	writeerror(addDate()+adderrorlevel("debug")+message);
	
}

private void writeerror(String message){
	int i;
	for(i=0;i<errorList.size();i++){
		errorList.get(i).write(message);
		
	}
	
}

private String addDate(){
	if(putDate==true){
	date=new Date();
	return date.toString()+"//";
	}
	return ("");
}


private void writeinfo(String message){
	int i;
	for(i=0;i<infoList.size();i++){
		infoList.get(i).write(message);
		
	}
	
}

private void writedebug(String message){
	int i;
	for(i=0;i<debugList.size();i++){
		debugList.get(i).write(message);
		
	}
	
}

private void write(String message){
	int i;
	for(i=0;i<ciblesList.size();i++){
		ciblesList.get(i).write(message);
		
	}
	
}

}
