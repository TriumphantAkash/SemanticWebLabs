import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadWriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Semantic Web");
		File file = new File("semantic_web_sample_file.txt");
		
		try {
		// if file doesnt exists, then create it
//					if (!file.exists()) {
//						file.createNewFile();
//					}
					
					
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("Hello Semantic Web");
		
		fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
