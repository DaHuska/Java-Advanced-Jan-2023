package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < getCapacity()) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(e -> e.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(r -> r.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }

        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = new ArrayList<>();

        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)) {
                soldRabbits.add(rabbit);
            }
        }

        this.data.removeAll(soldRabbits);

        return soldRabbits;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String rabbitsString = this.data
                .stream()
                .filter(rabbit -> rabbit.isAvailable())
                .map(r -> r.toString())
                .collect(Collectors.joining("\n"));

        return String.format("Rabbits available at %s:\n%s", this.name, rabbitsString);
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}
