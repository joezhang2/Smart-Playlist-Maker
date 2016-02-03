import java.io.*;

public class FileInput{
	final private int DEFAULT_SIZE = 100;			//initial size of list
	final private int DEFAULT_GROWTH_RATE = 20;		//number of elements to add when list is full

	private String fileName;						//name of file to copy into list
	private GenericList<String> tempList;			//list that stores elements in an array

	public FileInput(){
		tempList = new GenericList<String>(100,20);	
	}
	public FileInput(String fileName){
		setFileName(fileName);
		tempList = new GenericList<String>(100,20);	
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
	Saves each line of text in a file as a string in a list
	====================================*/
	public void readFile(){
		FileReader fReader = null;
		try{
			//open a file
			fReader = new FileReader(getFileName());
			BufferedReader bReader = new BufferedReader(fReader);
			try{
				//read text from the file
				String tempLine = bReader.readLine();
				while(tempLine != null){
					//add line to the list
					tempList.add(tempLine);
					tempLine = bReader.readLine();
				}	
				bReader.close();
			}catch(IOException e){
				System.err.println("I/O problem with buffered reader");
				System.err.println(e.getMessage());
			}
			fReader.close();
		}catch(FileNotFoundException e){			
			System.err.println("File not found");
			System.err.println(e.getMessage());
		}catch(IOException e){
			System.err.println("I/O problem with file");
			System.err.println(e.getMessage());
		}		
	}
}