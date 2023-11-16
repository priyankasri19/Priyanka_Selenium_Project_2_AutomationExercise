package setup;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AutomationExerciseUtility {
	
	public static String getAbsolutePath() {
		Path currRelativePath = Paths.get("");
        String currAbsolutePathString = currRelativePath.toAbsolutePath().toString();
		return currAbsolutePathString;
	}

}
