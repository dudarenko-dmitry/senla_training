package pl.senla.lecture3.task3.part;

public class PartEngine implements IProductPart{

    private String name;

    public PartEngine() {
    }

    public PartEngine(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "name='" + name + '\'';
    }

}
