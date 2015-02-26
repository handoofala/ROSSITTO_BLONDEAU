



public class Main {
	
	public static void main (String[] args){
		System.out.println("hello world!");
		Logger test = new Logger();
		
		
		test.setLevel("debug");
		
		test.debug("toto");
		
		test.remoteDate();
		File2 file2 = new File2();
		test.addErrorCible(file2);
		
		
		test.info("yolo!!!");
		test.remoteerrorlevel();
		test.error("houlalal");
		test.activeerrorlevel();
		test.activeDate();
		
		test.error("houlalal");
	
		test.debug("yolo");
	}
}
