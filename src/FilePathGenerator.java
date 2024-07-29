import java.io.File;

public class FilePathGenerator {

    public static String[] getFilePaths(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        assert files != null;
        String[] filePaths = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            filePaths[i] = files[i].getAbsolutePath();
        }
        return filePaths;
    }
}
