package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Product product1 = new Book(123, "Красная таблетка", 450, "Курпатов");
    private Product product2 = new Book(134, "Магия утра", 360, "Чупина");
    private Product product3 = new Smartphone(735, "Honor 50", 24900, "Huawei");
    private Product product4 = new Smartphone(425, "Samsung Galaxy A73", 51000, "Samsung");
    private Product product5 = new Smartphone(256, "Honor 30", 21900, "Huawei");


    @Test
    void searchByWhenSeveralResults() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] actual = manager.searchBy("Honor");
        Product[] expected = {product3, product5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWhenOneResult() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] actual = manager.searchBy("Магия утра");
        Product[] expected = {product2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWhenZeroResult() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);

        Product[] actual = manager.searchBy("Психология");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}