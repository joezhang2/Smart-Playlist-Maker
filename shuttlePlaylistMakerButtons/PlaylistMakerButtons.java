package shuttlePlaylistMakerButtons;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
public class PlaylistMakerButtons {
	private JFileChooser fileSelection;
	private FileSelection buttons;
	
	public PlaylistMakerButtons() {
		buttons = new FileSelection();
	}
	
	public static void main(String[] args) {
		PlaylistMakerButtons test = new PlaylistMakerButtons();
		JFrame testFrame = new JFrame();
		testFrame.add(test.buttons);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
