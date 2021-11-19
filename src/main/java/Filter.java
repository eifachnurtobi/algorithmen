import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {
    public void filter(Collection<Runner> runners) throws FileNotFoundException {
        List<Runner> onlyCompletedRuns = runners.stream().filter(runner -> {
            if(runner.getEinlaufzeit() == null){
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        output("junioren.rl.txt",
                onlyCompletedRuns.stream()
                    .filter(r -> r.getKategorie().equals("1"))
                    .collect(Collectors.toList())
        );
        output("senioren.rl.txt",
                onlyCompletedRuns.stream()
                        .filter(r -> r.getKategorie().equals("2"))
                        .collect(Collectors.toList())
        );
        output("elite.rl.txt",
                onlyCompletedRuns.stream()
                        .filter(r -> r.getKategorie().equals("3"))
                        .collect(Collectors.toList())
        );

        PrintWriter out = new PrintWriter("namen.ref");
        onlyCompletedRuns.forEach(runner -> {
            out.println(runner.toString());
        });
        out.flush();
    }

    private void output(String filename, List<Runner> runners) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        int rang = 1;
        for(Runner runner : runners){
            out.print(rang+"\t");
            out.print(runner.getStartNr()+"\t");
            out.print(runner.getEinlaufzeit()+"\t");
            out.print(runner.getName()+"\n");
            rang++;
        }
        out.flush();
    }
}
