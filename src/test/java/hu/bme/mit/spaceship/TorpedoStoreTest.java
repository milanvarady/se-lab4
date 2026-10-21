package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(1, 1.0);

        boolean result = store.fire(1);

        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_DecreasesCount() {
        TorpedoStore store = new TorpedoStore(1);

        store.fire(1);

        assertEquals(0, store.getTorpedoCount());
        assertTrue(store.isEmpty());
    }

    @Test
    void fire_InvalidArgument() {
        TorpedoStore store = new TorpedoStore(1);

        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }
}
