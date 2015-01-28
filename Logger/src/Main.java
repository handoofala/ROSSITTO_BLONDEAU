public class Main {
	
	public static void main (String[] args){
		System.out.println("hello world!");
		Logger test = new Logger();
		Terminal terminalTest = new Terminal();
		
		test.addCible(terminalTest);
		test.debug("toto");
		
		File fileTest = new File();
		
		test.addCible(fileTest);
		test.debug("toto");
	}
}
