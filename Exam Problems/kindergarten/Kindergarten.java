package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (this.registry.size() < this.capacity) {
            this.registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        return this.registry.removeIf(name -> name.getFirstName().equals(firstName));
    }

    public Child getChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                return child;
            }
        }

        return null;
    }

    public String registryReport() {
        Comparator<Child> compareByAge = Comparator
                .comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName);

        String childsString = this.registry
                .stream()
                .sorted(compareByAge)
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));

        return String.format("Registered children in %s:\n%s", this.name, childsString);
    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Child> getRegistry() {
        return registry;
    }
}
