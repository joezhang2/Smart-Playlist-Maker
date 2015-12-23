import java.io.*;

public class FileOutput{
	private String fileName;
	//private String[] fileLines
	private GenericList<String> tempList;

	public FileOutput(){
		tempList = new GenericList<String>(100,20);	
	}
	public FileOutput(String fileName){
		tempList = new GenericList<String>(100,20);	
		setFileName(fileName);
	}

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
	
	public void createList(){
	
		File file = new File (getFileName());
        //file.getParentFile().mkdirs();
		try{
			PrintWriter outputLine = new PrintWriter(file);
			//reset the iterator in temp list
			tempList.resetIterator();
			String tempLine = null;
			while(tempList.hasNext()){
				tempLine = tempList.getNext();
				outputLine.println(tempLine);
			}	
			outputLine.close();
		}catch (FileNotFoundException e){
			System.err.println("File not found");
			System.err.println(e.getMessage());
    	}
	}
}