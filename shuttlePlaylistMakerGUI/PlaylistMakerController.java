package shuttlePlaylistMakerGUI;

import javax.swing.JFrame;

import shuttlePlaylistMakerButtons.*;
//import shuttlePlaylistUtilities.GenericList;
import shuttlePlaylistModel.SelectedDirectories;
import shuttlePlaylistMakerActionListener.*;
//import shuttlePlaylistModel.MakeShuttlePlaylist;

public class PlaylistMakerController {
	private FileSelectionButtons buttons;
	private JFrame testFrame;
	private SelectedDirectories directories;
	
	public PlaylistMakerController() {
		setButtons(new FileSelectionButtons());
		setTestFrame(new JFrame());
		setDirectories(new SelectedDirectories());
	}

	public static void main(String[] args){
		PlaylistMakerController test = new PlaylistMakerController();
		test.addListeners();
		test.init();
	}
	
	public void init(){
		testFrame.add(buttons);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addListeners(){
		getButtons().getPlaylistLocationButton().addActionListener(new FileAccessListerner(buttons.getSelectedFilesList( ), getDirectories()));
		getButtons().getStorageLocationButton().addActionListener(new FileAccessListerner(buttons.getLocationLabel(), getDirectories()));
		getButtons().getRemoveButton().addActionListener(new RemoveListListener(buttons.getSelectedFilesList(), getDirectories()));
		getButtons().getConvertButton().addActionListener(new ConvertPlaylistListener(buttons.getConvertButton(), getDirectories()));
	}

	public FileSelectionButtons getButtons() {
		return buttons;
	}

	public JFrame getTestFrame() {
		return testFrame;
	}

	public SelectedDirectories getDirectories() {
		return directories;
	}

	public void setButtons(FileSelectionButtons buttons) {
		this.buttons = buttons;
	}

	public void setTestFrame(JFrame testFrame) {
		this.testFrame = testFrame;
	}

	public void setDirectories(SelectedDirectories directories) {
		this.directories = directories;
	}
}
