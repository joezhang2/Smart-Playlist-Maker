package shuttlePlaylistMakerGUI;

import java.security.PublicKey;

import javax.swing.JFrame;

import shuttlePlaylistMakerButtons.*;
import shuttlePlaylistUtilities.GenericList;
import shuttlePlaylistMakerActionListener.*;

public class PlaylistMakerController {
	private FileSelectionButtons buttons;
	private JFrame testFrame;
	//private FileAccessListerner selectListener;
	
	public PlaylistMakerController() {
		buttons = new FileSelectionButtons();
		testFrame = new JFrame();
		
		buttons.getPlaylistLocationButton().addActionListener(new FileAccessListerner(buttons.getSelectedFilesList( )));
		buttons.getStorageLocationButton().addActionListener(new FileAccessListerner(buttons.getLocationLabel()));
		buttons.getRemoveButton().addActionListener(new RemoveListListener(buttons.getSelectedFilesList()));
	}

	public void init(){
		testFrame.add(buttons);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		PlaylistMakerController test = new PlaylistMakerController();
		test.init();
	}
	
	
	
}
