package shuttlePlaylistModel;
/*
 * Tests ReadItunePlaylist and sees if a file containing iTunes playlist info can be read and
 * then have the contents copied over to a file for Shuttle 
 */
public class ReadItunePlaylistTester{
	private String testFile = "testFile.txt";
	private ReadItunePlaylist playList;
	/*====================================
	Constructors
	====================================*/
	public ReadItunePlaylistTester(){
		playList = new ReadItunePlaylist(testFile);
	}
	public ReadItunePlaylistTester(String fileName){
		playList = new ReadItunePlaylist(fileName);
	}
	/*====================================
	Getters and setters
	====================================*/
	public ReadItunePlaylist getPlaylist(){
		return playList;
	}
	public void setPlaylist(ReadItunePlaylist playList){
		this.playList = playList;
	}
	
	/*====================================
	Test
		Tests the ability to copy data from a file into a created generic list
	====================================*/
	public static void main(String[] args){
		ReadItunePlaylistTester test = new ReadItunePlaylistTester();
		System.out.println("Formatting data");
		test.getPlaylist().fileDataToList();
		System.out.println("Displaying data");
		test.getPlaylist().printFormattedData();
	}

}