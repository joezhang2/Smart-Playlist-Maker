public class ReadItunePlaylistTester{
	private String testFile = "testFile.txt";
	private ReadItunePlaylist playList;
	
	public ReadItunePlaylistTester(){
		playList = new ReadItunePlaylist(testFile);
	}
	
	public ReadItunePlaylist getPlaylist(){
		return playList;
	}
	public void setPlaylist(ReadItunePlaylist playList){
		this.playList = playList;
	}
	public static void main(String[] args){
		ReadItunePlaylistTester test = new ReadItunePlaylistTester();
		System.out.println("Formatting data");
		test.getPlaylist().fileDataToList();
		System.out.println("Displaying data");
		test.getPlaylist().printFormattedData();
	}

}