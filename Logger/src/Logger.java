import java.util.ArrayList;


public class Logger {
	
static ArrayList<Cibles> ciblesList;
String level="debug";
	public Logger(){
		ciblesList=new ArrayList<Cibles>();
		
		
	}
	
public static String addCible(Cibles cible){
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
	
	
public static void debug(String message){
	
	write(message);
	
	
}
public void info(String message){
	if(level=="info" ||level=="error"){
		
		write(message);
		
	}
	
	
}
	
public void error(String message){
	
	if(level=="error"){
	write(message);
	}
	
}

private static void write(String message){
	int i;
	for(i=0;i<ciblesList.size();i++){
		ciblesList.get(i).write(message);
		
	}
	
}

}
