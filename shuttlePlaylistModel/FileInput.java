package shuttlePlaylistModel;
/*
 *	Reads the lines from a file and saves them to a generic list
 */
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
	//fileName: name of file to read from
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	public String getFileName(){
		return fileName;
	}
	//tempList: list that stores lines of data from the file (fileName)
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
				String tempLine = "";
				//the bufferedReader handles new line and EOF characters, but not whitespace characters
				//the trim() method removes the whitespace character/s at the end of the file
				
				while((tempLine=bReader.readLine()) != null && tempLine.trim().length() != 0){
					//add line to the list
					tempList.add(tempLine);
				}	
				bReader.close();
			}catch(IOException e){	//exceptions from reading contents of the file
				System.err.println("I/O problem with buffered reader");
				System.err.println(e.getMessage());
			}
			fReader.close();
		}catch(FileNotFoundException e){	//exceptions from opening the file
			System.err.println("File not found");
			System.err.println(e.getMessage());
		}catch(IOException e){
			System.err.println("I/O problem with file");
			System.err.println(e.getMessage());
		}		
	}
}