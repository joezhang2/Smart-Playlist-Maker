package shuttlePlaylistMakerActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import shuttlePlaylistModel.SelectedDirectories;

public class RemoveListListener implements ActionListener {
	private JList<String> listToModify;
	private SelectedDirectories directories;
	
	public RemoveListListener(JList<String> componentToModify, SelectedDirectories directories) {
		// TODO Auto-generated constructor stub
		setListToModify(componentToModify);
		setDirectories(directories);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int numSelectedElements = getListToModify().getSelectedIndices().length;
		
		if(numSelectedElements == 0){
			return;
		}
		else{
			int newTotal =  getListToModify().getModel().getSize() - numSelectedElements;
			String[] tempdata = new String[newTotal];
			String[] tempDirectories = new String[newTotal];
			int firstSelectedIndex = getListToModify().getSelectedIndex();
			int lastSelectedIndex = firstSelectedIndex + numSelectedElements;
			
			//get everything up to the first selected index
			//skip the selected things in the middle, based on the way things are selected in a jlist
			//they have to be sequential
			for(int i = 0; i < firstSelectedIndex; i++){
				tempdata[i] = getListToModify().getModel().getElementAt(i);
				tempDirectories[i] = getDirectories().getSelectedFiles()[i];
			}
			
			//get everything after the last selected value
			for(int i = lastSelectedIndex; i < getListToModify().getModel().getSize(); i++){
				tempdata[i - numSelectedElements] = getListToModify().getModel().getElementAt(i);
				tempDirectories[i - numSelectedElements] = getDirectories().getSelectedFiles()[i];
			}
				
			getListToModify().setListData(tempdata);
			getDirectories().setSelectedFiles(tempdata);
			
			//refresh gui to show update info
			getListToModify().getParent().revalidate();
			getListToModify().getParent().repaint();
		}
	}

	public JList<String> getListToModify() {
		return listToModify;
	}

	public SelectedDirectories getDirectories(){
		return directories;
	}
	
	public void setListToModify(JList<String> listToModify) {
		this.listToModify = listToModify;
	}
	
	public void setDirectories(SelectedDirectories directories){
		this.directories = directories;
	}
}
