package shuttlePlaylistModel;

public class SelectedDirectories {
	
	private String[] selectedFiles;
	private String directory;
	
	public SelectedDirectories() {
		// TODO Auto-generated constructor stub
	}
	
	public SelectedDirectories(String[] selectedFiles, String directory) {
		setSelectedFiles(selectedFiles);
		setDirectory(directory);
	}

	public String[] getSelectedFiles() {
		return selectedFiles;
	}

	public String getDirectory() {
		return directory;
	}

	public void setSelectedFiles(String[] selectedFiles) {
		this.selectedFiles = selectedFiles;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}
	

}
