package shuttlePlaylistModel;
/*
 * Tests the FileInput and FileOutput classes 
 * 
 * This class verifies that a file can be read and copied into a FileInput object 
 * The data is then copied to a new file using an FileOuput object
 */
public class FileIOTester{
	final String INPUT_FILE = "testFile.txt";
	final String FILE_OUTPUT = "testFileOuput.txt";
	
	FileInput inputTest;
	FileOutput outputTest;
	
	/*=============================
	Constructors
	=============================*/
	public FileIOTester(){
		inputTest = new FileInput(INPUT_FILE);
		outputTest = new FileOutput(FILE_OUTPUT);
	}
	public FileIOTester(String inputFile, String outputFile){
		inputTest = new FileInput(inputFile);
		outputTest = new FileOutput(outputFile);
	}
	/*=============================
	Getters and setters
	=============================*/
	public FileOutput getOutputTest(){
		return outputTest;
	}
	public void setOutputTest(FileOutput outputTest){
		this.outputTest = outputTest;
	}
	public FileInput getInputTest(){
		return inputTest;
	}
	public void setInputTest(FileInput inputTest){
		this.inputTest = inputTest;
	}
	
	/*=============================
	Looks for a file
	=============================*/
	public void copyInputToOutput(){
		inputTest.readFile();
		outputTest.setTempList(inputTest.getTempList());
		outputTest.createPlaylist();
	}

	/*=============================
	Getters and setters
	=============================*/
	public static void main(String[] args){
		FileIOTester tester = new FileIOTester();
		tester.copyInputToOutput();
		//tester.getInputTest().readFile();
		System.out.println("Contents of copied generic list");
		tester.getInputTest().getTempList().printContent();
	}
}