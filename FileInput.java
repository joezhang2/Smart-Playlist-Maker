import java.io.*;

public class FileInput{
	private String fileName;
	//private String[] fileLines
	private GenericList<String> tempList;

	public FileInput(){
		tempList = new GenericList<String>(100,20);	
	}
	public FileInput(String fileName){
		setFileName(fileName);
		tempList = new GenericList<String>(100,20);	
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

	public void readFile(){
		FileReader fReader = null;
		try{
			 fReader = new FileReader(getFileName());

			BufferedReader bReader = new BufferedReader(fReader);
			try{
				String tempLine = bReader.readLine();
			
				//.equals() checks contents of string
				while(tempLine != null){
					tempList.add(tempLine);
					tempLine = bReader.readLine();
				}	
				bReader.close();
			}catch (IOException e){
				System.err.println("I/O problem with buffered reader");
				System.err.println(e.getMessage());
			}
			fReader.close();

		}catch (FileNotFoundException e){			
			System.err.println("File not found");
			System.err.println(e.getMessage());
		}catch (IOException e){
			System.err.println("I/O problem with file");
			System.err.println(e.getMessage());
		}		
	}
}