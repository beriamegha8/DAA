import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(int capacity, Item[] items) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                double r1 = (double) a.value / a.weight;
                double r2 = (double) b.value / b.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity > 0 && item.weight <= capacity) {
                // Take the whole item
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // Take a fraction of the item
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };

        System.out.println("Maximum value in Knapsack = " + fractionalKnapsack(capacity, items));
    }
}
