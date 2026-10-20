
interface Pizza {
    double getPrice();
    String getDescription();
}


class PlainPizza implements Pizza {
    public double getPrice() {
        return 5.0;
    }

    public String getDescription() {
        return "Plain Dough & Sauce";
    }
}

abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    public double getPrice() {
        return pizza.getPrice() + 2.0;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
}


class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    public double getPrice() {
        return pizza.getPrice() + 1.0;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
}


class Pineapple extends ToppingDecorator {
    public Pineapple(Pizza pizza) {
        super(pizza);
    }

    public double getPrice() {
        return pizza.getPrice() + 1.5;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pineapple";
    }
}
public class Main {
    public static void main(String[] args) {
        Pizza myPizza = new PlainPizza();

        myPizza = new Cheese(myPizza);
        myPizza = new Olives(myPizza);
        myPizza = new Pineapple(myPizza);

        System.out.println("Description: " + myPizza.getDescription());
        System.out.printf("Total Cost: $%.2f%n", myPizza.getPrice());
    }
}
