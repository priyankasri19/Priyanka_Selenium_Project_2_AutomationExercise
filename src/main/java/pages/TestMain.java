package pages;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestMain {

	public static void main(String[] args) {
		
		Path currRelativePath = Paths.get("");
        String currAbsolutePathString = currRelativePath.toAbsolutePath().toString();
        
		String fileName = "\\test-data\\sample-attachment.txt";
		System.out.println("Current absolute path is - " + currAbsolutePathString+fileName);

	}

}
