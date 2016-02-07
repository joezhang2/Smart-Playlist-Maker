package shuttlePlaylistModel;
/*
 * Creates a playlist for Shuttle using playlist information from a iTunes playlist
 */
public class MakeShuttlePlaylist{
	private String itunesFileName;
	private String shuttleFileName;
	private ReadItunePlaylist itunesFileStorage;
	private FileOutput shuttleFileMaker;
	
	/*====================================
	Constructors
	====================================*/
	public MakeShuttlePlaylist(){
		itunesFileStorage = new ReadItunePlaylist();
		shuttleFileMaker = new FileOutput();
	}
	public MakeShuttlePlaylist(String itunesFileName){
		//Sets file
		setItunesFileName(itunesFileName);
		itunesFileStorage = new ReadItunePlaylist(getItunesFileName());

		//make the file for Shuttle, using the same fileName as iTunes but with a different extension
		createFile(itunesFileName);
	}
	
	/*====================================
	Getters and Setters
	====================================*/
	//itunesFileName: name of the file to copy
	public void setItunesFileName(String itunesFileName){
		this.itunesFileName = itunesFileName; 	
	}
	public String getItunesFileName(){
		return itunesFileName;
	}
	//shuttleFileName: name of the Shuttle playlist file
	public void setShuttleFileName(String shuttleFileName){
		this.shuttleFileName = shuttleFileName;
	}
	public String getShuttleFileName(){
		return shuttleFileName;
	}
	
	/*====================================
	Creates playlist for Shuttle
		parameters: name of file with iTunes playlist
		Creates a file with the same name, but different extension (.txt -> .m3u)
	====================================*/
	public void createFile(String itunesFileName){
		String[] temp = getItunesFileName().split(".txt");
		setShuttleFileName(temp[0]+".m3u");
		shuttleFileMaker = new FileOutput(getShuttleFileName());
	}

	/*====================================
	Saves re-formated playlist info into a file
		Copies relevant information from the ReadItunesPlaylist object (itunesFileStorage)
		Formats the data and stores into the FileOutput object (shuttleFileMaker) and saves the file 
	====================================*/
	//
	public void convert(){
		//Load up iTunes info into GenericList
		//Each line in the playlist is separated into an array
		itunesFileStorage.fileDataToList();
		
		String templine = "";

		itunesFileStorage.getFormattedInputData().resetIterator();
		//Skip first line in itunesPlayList file, it contains the header row that is not needed
		itunesFileStorage.getFormattedInputData().getNext();
		
		//Needed to start each Shuttle playlist
		shuttleFileMaker.getTempList().add("#EXTM3U");

		//Array of values needed to format the playlist values for Shuttle
		String[] formatter = {"#EXTINF:" , "," , " - ","\n/storage/emulated/0/Music/"};
		
		while(itunesFileStorage.getFormattedInputData().hasNext()){
			//Get the formatted data from itunesFileStorage, combine it with the values in the formatter String array 
			templine = formatSongInShuttlePlaylist(gatherDataFromItunesPlaylist(itunesFileStorage.getFormattedInputData().getNext()),formatter);
			shuttleFileMaker.getTempList().add(templine);
		}
		//Write the contents of the generic list to the file 
		shuttleFileMaker.createPlaylist();
	}
	
	/*====================================
	Returns an array of the values needed to make a Shuttle playlist
		parameters: array containing a song's info in a iTunes playlist 
	====================================*/
	private String[] gatherDataFromItunesPlaylist(String[] input){
		//positions needed from an array
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
	
	/*====================================
	Merges itunesData with formatForData together
		parameters: itunesData: data from iTunes playlist for a song
					formatForData: formatting strings needed to format song info for Shuttle
		Assumes that both array have the same length 
	====================================*/
	private String formatSongInShuttlePlaylist(String[] itunesData, String[] formatForData){
		String line = "";		//contains contents of both arrays
		//format and store itunesData into a string to return 
		for(int i = 0; i < itunesData.length; i++){
			line += formatForData[i]+itunesData[i];
		}
		return line;
	}
}