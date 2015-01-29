



public class Main {
	
	public static void main (String[] args){
		System.out.println("hello world!");
		Logger test = new Logger();
		
		
		test.setLevel("debug");
		
		test.debug("toto");
		
		test.remoteDate();
		
		
		
		test.info("yolo!!!");
		test.error("houlalal");
		test.remoteerrorlevel();
		test.debug("yolo");
	}
}
