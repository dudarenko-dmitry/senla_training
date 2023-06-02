package pl.senla.lecture3.task3.part;

public class PartChassis implements IProductPart{

    private final String name;

    public PartChassis(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PartChassis{" +
                "name='" + name + '\'' +
                '}';
    }
}
