package christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data = new ArrayList<>();

    Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
    }

    public int count() {
        return this.data.size();
    }

    public Present heaviestPresent() {
        int heaviestIndex = -1;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getWeight() > heaviestIndex) {
                heaviestIndex = i;
            }
        }

        return this.data.get(heaviestIndex);
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public void add(Present present) {
        this.data.add(present);
    }

    /*public Present getPresent(String name) {
        Present p;

        for (Present pres : this.data) {
            if (pres.getName().equals(name)) {
                p = pres;
                return pres;
            }
        }
    }*/

    public String report() {
        StringBuilder result = new StringBuilder();

        result.append(String.format("%s bag contains:%n", getColor()));

        for (int i = 0; i < this.data.size(); i++) {
            if (i < this.data.size() - 1) {
                result.append(String.format("%s%n", this.data.get(i).toString()));
            } else if (i == this.data.size() - 1) {
                result.append(String.format("%s", this.data.get(i).toString()));
            }
        }

        return result.toString();
    }

    public String getColor() {
        return this.color;
    }
    public int getCapacity() {
        return this.capacity;
    }
}
