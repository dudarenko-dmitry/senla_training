package pl.senla.lecture3.task3.part;

public class PartBody implements IProductPart{

    private final String name;

    public PartBody(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PartBody{" +
                "name='" + name + '\'' +
                '}';
    }
}
