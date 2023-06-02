package pl.senla.lecture3.task3.part;

public class PartEngine implements IProductPart{

    private final String name;

    public PartEngine(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "PartEngine{" +
                "name='" + name + '\'' +
                '}';
    }

}
