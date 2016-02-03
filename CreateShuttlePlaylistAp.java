import java.io.*;

public class CreateShuttlePlaylistAp{
	private MakeShuttlePlaylist maker = new MakeShuttlePlaylist();

	public CreateShuttlePlaylistAp(){
		maker = new MakeShuttlePlaylist();
	}
	public CreateShuttlePlaylistAp(String itunesFileName){
		maker = new MakeShuttlePlaylist(itunesFileName);
	}
	public MakeShuttlePlaylist getMaker(){
		return maker;
	}
	public static void main(String[] args){
		//System.out.println("Enter name of playlist");
		System.out.println("test");
		CreateShuttlePlaylistAp test = new CreateShuttlePlaylistAp("aaron.txt");
		test.getMaker().convert();
	}
}