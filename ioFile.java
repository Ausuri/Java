import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ioFile {
	
	File file = new File("gimp.txt");
	public boolean fileExists = file.exists();
	boolean hasFound = false;
	
	public boolean readName(String name) throws Exception{
		
		if(!fileExists)
			file.createNewFile();
		
		Scanner txtscan = new Scanner(file);
		while(txtscan.hasNextLine()){
		    String str = txtscan.nextLine();
		    System.out.println(str);
		    if(str.contains(name))
		    	hasFound = true;		    
		    else
		    	hasFound = false;
		}
		txtscan.close();
		return hasFound;
	} 
	
	public void writeName(String name) throws Exception{
		
			
			if (!file.exists()) 
				file.createNewFile();
			
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			if (!readName(name))
			{
				bw.append(name);
				bw.newLine();
				bw.close();
			}

	}
	public void deleteName(String name) throws Exception{
		
		if(!fileExists)
			file.createNewFile();
		File inputFile = new File("gimp.txt");
		File tempFile = new File("replace.txt");
		String replace = tempFile.getAbsolutePath();
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while((currentLine = reader.readLine()) != null) {
			if(null!=currentLine && !currentLine.equalsIgnoreCase(name)){
				writer.write(currentLine + System.getProperty("line.separator"));
		    }
		}
		writer.close(); 
		reader.close(); 
		inputFile.delete();
		File file = new File(replace);
		file.createNewFile();
		}

	
	}

