public class FileIOTester{
	final String INPUT_FILE = "testFile.txt";
	final String FILE_OUTPUT = "testFileOuput.txt";
	
	FileInput inputTest;
	FileOutput outputTest;
	
	public FileIOTester(){
		inputTest = new FileInput(INPUT_FILE);
		outputTest = new FileOutput(FILE_OUTPUT);
	}

	public FileIOTester(String inputFile, String outputFile){
		inputTest = new FileInput(inputFile);
		outputTest = new FileOutput(outputFile);
	}
	public FileOutput getOutputTest(){
		return outputTest;
	}
	public FileInput getInputTest(){
		return inputTest;
	}
	
	public void copyInputToOutput(){
		inputTest.readFile();
		outputTest.setTempList(inputTest.getTempList());
		outputTest.createList();
	}

	public static void main(String[] args){
		FileIOTester tester = new FileIOTester();
		tester.copyInputToOutput();
		//tester.getInputTest().readFile();
		System.out.println("Contents of copied generic list");
		tester.getInputTest().getTempList().printContent();
	}
}