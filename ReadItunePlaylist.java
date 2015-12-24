public class ReadItunePlaylist{
	private FileInput fileData;
	private String playListFile;
	private GenericList<String[]> formattedInputData;
	final private String defaultFile = "testFile.txt";
	
	//Constructors
	public ReadItunePlaylist(){
			setPlayListFile(defaultFile);
			fileData = new FileInput(getPlayListFile());
			formattedInputData = new GenericList<String[]>(getFileData().getDefaultSize(), getFileData().getDefaultGrowthRate());
	}
	public ReadItunePlaylist(String playListFile){
		setPlayListFile(playListFile);
		fileData = new FileInput(getPlayListFile());
		formattedInputData = new GenericList<String[]>(getFileData().getDefaultSize(), getFileData().getDefaultGrowthRate());
	}

	//Getters and setters
	public void setPlayListFile(String playListFile){
		this.playListFile = playListFile;
	}
	public String getPlayListFile(){
		return playListFile;
	}
	
	public void setFileData(FileInput fileData){
		this.fileData = fileData;
	}
	public FileInput getFileData(){
		return fileData;
	}

	public void fileDataToList(){
		//transfer contents of itunes playlist file to the generic list
		fileData.readFile();
		
		fileData.getTempList().resetIterator();
		String columnNames;
		String[] temp;
		while(fileData.getTempList().hasNext()){
			//Get a line from the tempList and split the string around tabs
			columnNames = (String)fileData.getTempList().getNext();
			temp = columnNames.split("\t");	

			formattedInputData.add(temp);
		}
	}
	public void printFormattedData(){
		formattedInputData.resetIterator();

		while(formattedInputData.hasNext()){
			String temp = "";
			String[] tempArray = formattedInputData.getNext();
			for(int i = 0; i < tempArray.length; i++){
				temp += tempArray[i] + " | ";
			}
			System.out.println(temp);
		}
	}

}