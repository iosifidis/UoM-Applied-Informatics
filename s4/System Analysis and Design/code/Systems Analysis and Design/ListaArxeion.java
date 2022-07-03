import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class ListaArxeion {

	private ArrayList<String> fileList;
	
	/**
	 * 
	 * @param file
	 */
	
	public ListaArxeion() {
		fileList = new ArrayList<String>();
		
	}
	

	public ArrayList<String> getFileList() {
		return fileList;
	}


	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}


	public void prostheseArxeio(String filename) {
		this.fileList.add(filename);
	}

	/**
	 * 
	 * @param file
	 */
	public void diagrapseArxeio(String filename) {
		this.fileList.remove(filename);
	}
	
	
	@Override
	public String toString() {
		return fileList.toString();
	}
	
	
	public void printData() {
		for(String filename:fileList) {
			System.out.println(filename);
		}
	}

}