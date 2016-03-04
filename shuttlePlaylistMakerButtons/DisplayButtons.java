package shuttlePlaylistMakerButtons;

import javax.swing.JFrame;
	
public class DisplayButtons {

	private FileSelectionButtons buttons;
	
	public DisplayButtons() {
		buttons = new FileSelectionButtons();
	}
	
	public static void main(String[] args) {
		DisplayButtons test = new DisplayButtons();
		JFrame testFrame = new JFrame();
		testFrame.add(test.buttons);
		testFrame.pack();
		testFrame.setVisible(true);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
