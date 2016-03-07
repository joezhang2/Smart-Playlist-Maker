package shuttlePlaylistMakerActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;

import shuttlePlaylistModel.SelectedDirectories;

import java.io.File;

public class FileAccessListerner implements ActionListener {
	private JList<String> listToModify;
	private JLabel labelToModify;
	private JFileChooser fileChooser;
	private SelectedDirectories directory;

	public FileAccessListerner(JList<String> componentToModify, SelectedDirectories directory) {
		// TODO Auto-generated constructor stub
		setListToModify(componentToModify);
		setSelectedDirectories(directory);
		labelToModify = null;
		
		setFileChooser(new JFileChooser());
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	}
	public FileAccessListerner(JLabel componentToModify, SelectedDirectories directory) {
		setLabelToModify(componentToModify);
		setSelectedDirectories(directory);
		listToModify = null;
		
		setFileChooser(new JFileChooser());
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
				String[] tempPath = new String[files.length];
				
				//store selected file names
				for(int i = 0; i < files.length; i++){
					tempName[i] = files[i].getName();
					tempPath[i] = files[i].getAbsolutePath();
				}
				
				//update stored info 
				getListToModify().setListData(tempName);			
				getSelectedDirectories().setSelectedFiles(tempPath);
				
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
				
				//update stored info
				getLabelToModify().setText(getLabelToModify().getText() + fileChooser.getSelectedFile().getName());
				getSelectedDirectories().setDirectory(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
				
				//refresh parent panel
				getLabelToModify().getParent().revalidate();
				getLabelToModify().getParent().repaint();
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

	public SelectedDirectories getSelectedDirectories() {
		return directory;
	}
	public void setSelectedDirectories(SelectedDirectories directory) {
		this.directory = directory;
	}
}
