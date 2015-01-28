



public class Main {
	
	public static void main (String[] args){
		System.out.println("hello world!");
		Logger test = new Logger();
		
		
		test.setLevel("info");
		
		test.debug("toto");
		
		File fileTest = new File();
		
		test.addCible(fileTest);
		test.debug("yolo");
		test.info("yolo!!!");
		test.error("houlalal");
	}
}
