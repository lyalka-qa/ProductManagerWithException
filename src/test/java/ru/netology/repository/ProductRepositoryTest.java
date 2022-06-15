package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repo = new ProductRepository();

    private Product product1 = new Book(123, "Красная таблетка", 450, "Курпатов");
    private Product product2 = new Book(134, "Магия утра", 360, "Чупина");
    private Product product3 = new Smartphone(735, "Honor 50", 24900, "Huawei");
    private Product product4 = new Smartphone(425, "Samsung Galaxy A73", 51000, "Samsung");
    private Product product5 = new Smartphone(256, "Honor 30", 21900, "Huawei");

    @BeforeEach
    void save() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
    }

    @Test
    void shouldTestFindAll() {
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4, product5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTestRemoveById() {
        repo.removeById(735);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4, product5};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldTestFindById() {
        assertEquals(product1, repo.findById(123));
    }

    @Test
    void shouldTestNotFindById() {
        assertNull(repo.findById(367));
    }

    @Test
    void shouldTestRemoveByIdIfNotExist() {

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(978);
        });
    }

}