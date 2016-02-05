/*
 * Writes an the contents of a list to a file
 */
import java.io.*;

public class FileOutput{
	private String fileName;
	private GenericList<String> tempList;
	
	/*====================================
	Constructors
	====================================*/
	public FileOutput(){
		//list starts out with a size of 100 and adds 20 new elements when maxed
		tempList = new GenericList<String>(100,20);	
	}
	public FileOutput(String fileName){
		//list starts out with a size of 100 and adds 20 new elements when maxed
		tempList = new GenericList<String>(100,20);	
		setFileName(fileName);
	}

	/*====================================
	Getters and setters
	====================================*/
	//fileName: name of the file to print to
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public String getFileName(){
		return fileName;
	}
	//tempList: list of data to write to the output file (fileName)
	public void setTempList(GenericList tempList){
			this.tempList = tempList;
	}
	public GenericList getTempList(){
		return tempList;
	}

	/*====================================
	Creates and writes contents of list to a file
	====================================*/
	public void createPlaylist(){
		//Make the file
		File file = new File (getFileName());
		try{
			PrintWriter outputLine = new PrintWriter(file);
			//reset the iterator in temp list
			tempList.resetIterator();
			String tempLine = null;
			//Each element of list is written to a new line in the file
			while(tempList.hasNext()){
				tempLine = tempList.getNext();
				outputLine.println(tempLine);
			}	
			outputLine.close();
		}catch (FileNotFoundException e){
			//Error message in the file is not found
			System.err.println("File not found");
			System.err.println(e.getMessage());
    	}
	}
}