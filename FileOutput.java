/*
	Writes an the contents of a list to a file. 
*/
import java.io.*;

public class FileOutput{
	private String fileName;
	private GenericList<String> tempList;

	public FileOutput(){
		tempList = new GenericList<String>(100,20);	
	}
	public FileOutput(String fileName){
		tempList = new GenericList<String>(100,20);	
		setFileName(fileName);
	}

	/*====================================
	Getters and setters
	====================================*/
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public String getFileName(){
		return fileName;
	}
	public void setTempList(GenericList tempList){
			this.tempList = tempList;
	}
	public GenericList getTempList(){
		return tempList;
	}
	

	/*====================================
	Creates and writes conents of list to a file
	====================================*/
	public void createList(){
		//Make the file
		File file = new File (getFileName());
        //file.getParentFile().mkdirs();
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