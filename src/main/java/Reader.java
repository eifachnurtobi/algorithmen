import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reader {
    public Stream<Map<String, String>> parseFile(String filename, List<String> values){
        Stream<String> lines = openFile(filename);
        return lines
                .map(l -> l.trim().split("\t"))
                .map(rawTokens -> {
                    Map<String, String> tokens = new HashMap<>();
                    for (int i = 0; i < rawTokens.length; i++) {
                        tokens.put(values.get(i), rawTokens[i]);
                    }
                    return tokens;
                });
    }

    private Stream<String> openFile(String filename) {
        try {
            return Files.lines(Paths.get(filename));
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
