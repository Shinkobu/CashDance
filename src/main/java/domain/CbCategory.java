package domain;

public class CbCategory {
    String name;


    public CbCategory(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "CashDance.domain.CbCategory{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
