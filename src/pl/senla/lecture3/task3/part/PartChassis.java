package pl.senla.lecture3.task3.part;

public class PartChassis implements IProductPart{

    private String name;

    public PartChassis() {
    }

    public PartChassis(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'';
    }
}
