package shuttlePlaylistMakerActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

public class RemoveListListener implements ActionListener {
	private JList<String> listToModify;
	
	public RemoveListListener(JList<String> componentToModify) {
		// TODO Auto-generated constructor stub
		setListToModify(componentToModify);
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
			int firstSelectedIndex = getListToModify().getSelectedIndex();
			int lastSelectedIndex = firstSelectedIndex + numSelectedElements;
			
			//get everything up to the first selected index
			//skip the selected things in the middle, based on the way things are selected in a jlist
			//they have to be sequential
			for(int i = 0; i < firstSelectedIndex; i++){
				tempdata[i] = getListToModify().getModel().getElementAt(i);
			}
			
			//get everything after the last selected value
			for(int i = lastSelectedIndex; i < getListToModify().getModel().getSize(); i++){
				tempdata[i - numSelectedElements] = getListToModify().getModel().getElementAt(i);
			}
				
			getListToModify().setListData(tempdata);
			
			//refresh gui to show update info
			getListToModify().getParent().revalidate();
			getListToModify().getParent().repaint();
		}
	}
	
	public JList<String> getListToModify() {
		return listToModify;
	}

	public void setListToModify(JList<String> listToModify) {
		this.listToModify = listToModify;
	}
}
