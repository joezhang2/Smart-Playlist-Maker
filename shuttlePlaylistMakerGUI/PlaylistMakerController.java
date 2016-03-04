package shuttlePlaylistMakerGUI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import shuttlePlaylistMakerButtons.*;
	
public class PlaylistMakerController {
	private JFileChooser fileSelection;
	private FileSelectionButtons buttons;
	private JFrame testFrame;
	
	public PlaylistMakerController() {
		buttons = new FileSelectionButtons();
		testFrame = new JFrame();
	}

	public void init(){
		testFrame.add(buttons);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
