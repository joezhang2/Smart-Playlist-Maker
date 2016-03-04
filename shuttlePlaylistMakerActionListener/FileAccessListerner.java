package shuttlePlaylistMakerActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import java.io.File;


public class FileAccessListerner implements ActionListener {
	private JList<String> listToModify;
	private JLabel labelToModify;
	private JFileChooser fileChooser;

	public FileAccessListerner(JList<String> componentToModify) {
		// TODO Auto-generated constructor stub
		setListToModify(componentToModify);
		setLabelToModify(null);
		fileChooser = new JFileChooser();
		
	}
	public FileAccessListerner(JLabel componentToModify) {
		setLabelToModify(componentToModify);
		setListToModify(null);
		fileChooser = new JFileChooser();
	}
	
	public JList<String> getListToModify() {
		return listToModify;
	}

	public JLabel getLabelToModify() {
		return labelToModify;
	}

	public void setListToModify(JList<String> listToModify) {
		this.listToModify = listToModify;
	}

	public void setLabelToModify(JLabel labelToModify) {
		this.labelToModify = labelToModify;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//selecting a list of files
		if(isList()){
			getFileChooser().setMultiSelectionEnabled(true);

			//get result of fileChooserDialog
			int result = getFileChooser().showOpenDialog(null);

			//valid file was selected
			if(result == getFileChooser().APPROVE_OPTION){
				File[] files = getFileChooser().getSelectedFiles();
				String[] tempName = new String[files.length];
				
				for(int i = 0; i < files.length; i++){
					tempName[i] = files[i].getName();
				}
				
				//set displayed list of file paths 
				getListToModify().setListData(tempName);
				
				//update stored data
				
				//refresh parent panel
				getListToModify().getParent().revalidate();
				getListToModify().getParent().repaint();
			}	
		}
		//selecting a single file
		else {
			//get result of fileChooserDialog
			int result = getFileChooser().showOpenDialog(null);
			
			//valid file was selected
			if(result == getFileChooser().APPROVE_OPTION){
				
				//change displayed file path
				getLabelToModify().setText(getLabelToModify().getText() + fileChooser.getSelectedFile().getName());

				//update stored data
				
				//refresh parent panel
				getListToModify().getParent().revalidate();
				getListToModify().getParent().repaint();
			}
					
			
		}
	}
	
	private boolean isList(){
		if(getLabelToModify() == null)
			return true;
		else {
			return false;
		}
	}

}
