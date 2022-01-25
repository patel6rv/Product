import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    Product p1;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Pipeweed", "Long Bottom Leaf", 600);
    }

    @Test
    void getName() {
        assertEquals("Pipeweed", p1.getName());
    }

    @Test
    void setName() {
        p1.setName("Wipepeed");
        assertEquals("Wipepeed", p1.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Long Bottom Leaf", p1.getDescription());
    }

    @Test
    void setDescription() {
        p1.setDescription("Leaf Bottom Long");
        assertEquals("Leaf Bottom Long", p1.getDescription());
    }

    @Test
    void getID() {
        assertEquals("000001", p1.getID());
    }

    //will never change but to test
    @Test
    void setID() {
        p1.setID("000002");
        assertEquals("000002", p1.getID());
    }

    @Test
    void getCost() {
        assertEquals(600, p1.getCost());
    }

    @Test
    void setCost() {
        p1.setCost(111.11);
        assertEquals(111.11, p1.getCost());
    }

    @Test
    void testToString() {
        String expected = "Product{ID='" + p1.getID() + "', name='" + p1.getName() + "', description='" + p1.getDescription() + "', cost=" + p1.getCost()+ "}";
        assertEquals(expected, p1.toString());
    }
}
