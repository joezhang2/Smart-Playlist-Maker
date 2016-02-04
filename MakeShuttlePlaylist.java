public class MakeShuttlePlaylist{
	private String itunesFileName;
	private String shuttleFileName;
	private ReadItunePlaylist itunesFileStorage;
	private FileOutput shuttleFileMaker;

	public MakeShuttlePlaylist(){
		itunesFileStorage = new ReadItunePlaylist();
		shuttleFileMaker = new FileOutput();
	}
	public MakeShuttlePlaylist(String itunesFileName){
		//Sets file
		setItunesFileName(itunesFileName);
		itunesFileStorage = new ReadItunePlaylist(getItunesFileName());
		
		createFile(itunesFileName);
	}

	public void setItunesFileName(String itunesFileName){
		this.itunesFileName = itunesFileName; 	
	}
	public String getItunesFileName(){
		return itunesFileName;
	}
	public void setShuttleFileName(String shuttleFileName){
		this.shuttleFileName = shuttleFileName;
	}
	public String getShuttleFileName(){
		return shuttleFileName;
	}

	public void createFile(String itunesFileName){
		String[] temp = getItunesFileName().split(".txt");
		setShuttleFileName(temp[0]+".m3u");
		shuttleFileMaker = new FileOutput(getShuttleFileName());
	}

	//Saves reformated playlist info into shuttleFileMaker and saves the list into a file
	public void convert(){
		//Load up itunes info into GenericList
		//Each line in the playlist is separated into an array
		itunesFileStorage.fileDataToList();
		
		String templine = "";

		itunesFileStorage.getFormattedInputData().resetIterator();
		//Skip first line in itunesPlayList file that explains what each column is
		itunesFileStorage.getFormattedInputData().getNext();
		
		//Needed in each Shuttle playlist
		shuttleFileMaker.getTempList().add("#EXTM3U");

		String[] formatter = {"#EXTINF:" , "," , " - ","\n/storage/emulated/0/Music/"};
		
		while(itunesFileStorage.getFormattedInputData().hasNext()){
			templine = formatSongInShuttlePlaylist(gatherDataFromItunesPlaylist(itunesFileStorage.getFormattedInputData().getNext()),formatter);
			shuttleFileMaker.getTempList().add(templine);
		}
		shuttleFileMaker.createList();
	}
	private String[] gatherDataFromItunesPlaylist(String[] input){
		int[] positions = {7,0,1,26};
		String[] tempLocation;
		
		String[] returnData = new String[positions.length];

		//Store first 3 values into array
		for(int i = 0; i < positions.length; i++){
			returnData[i] = input[positions[i]];
		}
		//change the filepath, using / instead of : to denote a lower level
		tempLocation = input[positions[positions.length-1]].split(":");
		returnData[returnData.length-1] = tempLocation[tempLocation.length-3] + "/"
										+ tempLocation[tempLocation.length-2] + "/"
										+ tempLocation[tempLocation.length-1];

		return returnData;
	}

	private String formatSongInShuttlePlaylist(String[] itunesData, String[] formatForData){
		String line = "";
		
		//Format and store itunesData into a string to return 
		for(int i = 0; i < itunesData.length; i++){
			line += formatForData[i]+itunesData[i];
		}
		
		return line;
	}
}