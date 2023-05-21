package Proposals;

public class CbCategory {
    String name;
    String russianName;

    @Override
    public String toString() {
        return russianName;
    }

    public CbCategory(String name, String russianName) {
        this.name = name;
        this.russianName = russianName;
    }
}
