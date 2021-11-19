import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Reader reader = new Reader();
        Filter filter = new Filter();
        Map<String, Runner> runners = new HashMap<>();

        reader.parseFile("./Listen/startliste.txt", new ArrayList<>(){{
            add("startnr");
            add("kategorie");
            add("name");
        }}).map( entry -> {
            Runner r = new Runner();
            r.setStartNr(entry.get("startnr"));
            r.setKategorie(entry.get("kategorie"));
            r.setName(entry.get("name"));
            return r;
        }).forEach(runner -> {
            runners.put(runner.getStartNr(), runner);
        });

        reader.parseFile("Listen/messresultate.txt", new ArrayList<>(){{
            add("startnr");
            add("einlaufzeit");
        }}).forEach(entry -> {
            Runner runner = runners.get(entry.get("startnr"));
            runner.setEinlaufzeit(entry.get("einlaufzeit"));
        });

        filter.filter(runners.values());
    }


}
