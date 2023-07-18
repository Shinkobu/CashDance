public class CbCategory {
    String name;


    public CbCategory(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "CbCategory{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
