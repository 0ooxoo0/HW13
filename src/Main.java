import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Создаем товары
        Product product1 = new Product(1, "Ноутбук", 75000, "Электроника");
        Product product2 = new Product(2, "Смартфон", 50000, "Электроника");
        Product product3 = new Product(1, "Планшет", 30000, "Электроника");
        Product product4 = new Product(1, "Ноутбук", 75000, "Электроника"); // совпадает с product1
        Product product5 = new Product(3, "Книга", 1500, "Литература");

        // Выводим товары
        System.out.println("=== Товары ===");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);
        System.out.println(product5);

        // Сравниваем товары
        System.out.println("\n=== Сравнение товаров ===");
        System.out.println("product1.equals(product2): " + product1.equals(product2));
        System.out.println("product1.equals(product3): " + product1.equals(product3));
        System.out.println("product1.equals(product4): " + product1.equals(product4));
        System.out.println("product1.equals(product5): " + product1.equals(product5));

        // Создаем заказы
        Order order1 = new Order("Иванов Иван", new Product[]{product1, product2});
        Order order2 = new Order("Петров Петр", new Product[]{product1, product3});
        Order order3 = new Order("Иванов Иван", new Product[]{product1, product2}); // совпадает с order1
        Order order4 = new Order("Иванов Иван", new Product[]{product2, product1}); // порядок товаров другой

        // Выводим заказы
        System.out.println("\n=== Заказы ===");
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(order4);

        // Сравниваем заказы
        System.out.println("\n=== Сравнение заказов ===");
        System.out.println("order1.equals(order2): " + order1.equals(order2));
        System.out.println("order1.equals(order3): " + order1.equals(order3));
        System.out.println("order1.equals(order4): " + order1.equals(order4));
    }
}

class Product {
    private final int id;
    private final String name;
    private final int price;
    private final String category;

    public Product(int id, String name, int price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Товар[артикул=" + id + ", название=" + name + ", цена=" + price + ", категория=" + category + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id && Objects.equals(category, product.category);
    }

    // Геттеры могут понадобиться, но не требуются в задании
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}

class Order {
    private final String customer;
    private final Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Order{customer='" + customer + "', basket=" + Arrays.toString(basket) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Order order = (Order) obj;
        if (!Objects.equals(customer, order.customer)) return false;
        if (!Arrays.equals(basket, order.basket)) return false;
        return true;
    }
}