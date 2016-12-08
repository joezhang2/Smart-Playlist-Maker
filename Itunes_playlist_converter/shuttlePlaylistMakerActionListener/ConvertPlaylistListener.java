package shuttlePlaylistMakerActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import shuttlePlaylistModel.MakeShuttlePlaylist;
import shuttlePlaylistModel.SelectedDirectories;
import shuttlePlaylistUtilities.GenericList;

import org.apache.commons.io.FilenameUtils;

public class ConvertPlaylistListener implements ActionListener {
	private SelectedDirectories directories;
	private GenericList<MakeShuttlePlaylist> playlistsToConvert;
	private JButton convertSuccessful;
		
	public ConvertPlaylistListener(JButton convertSuccessful, SelectedDirectories directories) {
		// TODO Auto-generated constructor stub
		setConvertSuccessful(convertSuccessful);
		setDirectories(directories);
		setPlaylistsToConvert(new GenericList<MakeShuttlePlaylist>());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String newPath;
		
		//create playlist objects
		for(int i = 0; i < getDirectories().getSelectedFiles().length; i++){
			newPath = createNewPath(getDirectories().getSelectedFiles()[i], getDirectories().getDirectory());
			getPlaylistsToConvert().add(
				new MakeShuttlePlaylist(getDirectories().getSelectedFiles()[i], newPath)); 
		}
		
		//convert playlists
		while(getPlaylistsToConvert().hasNext()){
			getPlaylistsToConvert().getNext().convert();
		}
		
		getConvertSuccessful().setText("Conversion completed");
		
		getConvertSuccessful().getParent().revalidate();
		getConvertSuccessful().getParent().repaint();
	}

	private String createNewPath(String oldPath, String newDirectory){
		String path = "";
		//get the path to the new file
		path += newDirectory;
		//copy name of the playlist
		path += "/" + FilenameUtils.getBaseName(oldPath);
		//add in the new extension
		path += ".m3u";
		
		return path;
	}
	
	public SelectedDirectories getDirectories() {
		return directories;
	}

	public GenericList<MakeShuttlePlaylist> getPlaylistsToConvert() {
		return playlistsToConvert;
	}

	public JButton getConvertSuccessful(){
		return convertSuccessful;
	}
	
	public void setDirectories(SelectedDirectories directories) {
		this.directories = directories;
	}
	
	public void setPlaylistsToConvert(
			GenericList<MakeShuttlePlaylist> playlistsToConvert) {
		this.playlistsToConvert = playlistsToConvert;
	}	
	
	public void setConvertSuccessful(JButton convertSuccessful){
		this.convertSuccessful = convertSuccessful;
	}
}
