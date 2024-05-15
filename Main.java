import java.util.ArrayList;
import java.util.List;

class Apple {
    Color color;
    int weight;

    public Apple(Color color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return color.toString() + " " + weight;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        // for (Apple apple : inventory) {
        // if (p.test(apple)) {
        // result.add(apple);
        // }
        // }
        inventory.forEach(apple -> {
            if (p.test(apple)) {
                result.add(apple);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(Color.GREEN, 12));
        apples.add(new Apple(Color.RED, 15));
        apples.add(new Apple(Color.GREEN, 11));
        apples.add(new Apple(Color.GREEN, 7));
        apples.add(new Apple(Color.RED, 12));
        // System.out.println("Apples we have :" + apples);

        List<Apple> greenApples = filterApples(apples, (Apple apple) -> Color.GREEN.equals(apple.getColor()));
        List<Apple> weightApples = filterApples(greenApples, (Apple apple) -> apple.getWeight() > 11);

        System.out.println(weightApples);
    }
}