public class ReadItunePlaylist {
	private FileInput fileData;
	private String playListFile;
	private GenericList<String[]> formattedInputData;
	final private String defaultFile = "testFile.txt";
	
	/*====================================
	Constructors
	====================================*/
	public ReadItunePlaylist(){
		setPlayListFile(defaultFile);
		fileData = new FileInput(getPlayListFile());
		formattedInputData = new GenericList<String[]>(getFileData().getTempList().getLength(), getFileData().getTempList().getGrowthAmt());
	}
	public ReadItunePlaylist(String playListFile){
		setPlayListFile(playListFile);
		fileData = new FileInput(getPlayListFile());
		formattedInputData = new GenericList<String[]>(getFileData().getTempList().getLength(), getFileData().getTempList().getGrowthAmt());
	}
	
	/*====================================
	Getters and setters
	====================================*/
	//playListFile: the name of the file to be converted
	public void setPlayListFile(String playListFile){
		this.playListFile = playListFile;
	}
	public String getPlayListFile(){
		return playListFile;
	}
	
	//fileData: copies the file into a self made arrayList object
	public void setFileData(FileInput fileData){
		this.fileData = fileData;
	}
	public FileInput getFileData(){
		return fileData;
	}
	
	//formattedInputData: formatted data from the fileInput object is copied into this arrayList
	public void setFormattedInputData(GenericList<String[]> formattedInputData){
		this.formattedInputData = formattedInputData;
	}
	public GenericList<String[]> getFormattedInputData(){
		return formattedInputData;
	}
	
	/*====================================
	Copies formatted data
		Reads data from the text file and separates the line into array elements
	====================================*/
	public void fileDataToList(){
		//transfer contents of iTunes playlist file to the generic list
		fileData.readFile();
		//reset the iterator to allow for everything to be copied over
		fileData.getTempList().resetIterator();
		
		String columnNames;			//contains a line from the file
		while(fileData.getTempList().hasNext()){
			//Get a line from the tempList and casts into a string
			columnNames = (String)fileData.getTempList().getNext();
			//separate the string and save into the arrayList
			formattedInputData.add(columnNames.split("\t"));
		}
	}
	
	/*====================================
	Prints contents of split up data
		Used for testing
	====================================*/
	public void printFormattedData(){
		formattedInputData.resetIterator();

		while(formattedInputData.hasNext()){
			String temp = "";				//used to hold a line in the playlist file to print to console
			String[] tempArray = null;		//the data from an element in the arrayList
			//Get an element from the arrayList
			tempArray = formattedInputData.getNext();
			
			//positions of of the arrayList used in the Shuttle playlist
			int[] positions = {7,0,1,26};

			//get components from the read playlist
			for(int i = 0; i < positions.length; i++){
				temp += " | " + "(" + i + ") " + tempArray[positions[i]];
			}
			System.out.println(temp);
		}
	}
}
