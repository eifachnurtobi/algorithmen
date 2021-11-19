public class Runner {
    private String startNr;
    private String einlaufzeit;
    private String kategorie;
    private String name;

    public String getStartNr() {
        return startNr;
    }

    public void setStartNr(String startNr) {
        this.startNr = startNr;
    }

    public String getEinlaufzeit() {
        return einlaufzeit;
    }

    public void setEinlaufzeit(String einlaufzeit) {
        this.einlaufzeit = einlaufzeit;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return startNr+'\t'+name+'\t'+kategorie+'\t'+einlaufzeit;
    }
}
