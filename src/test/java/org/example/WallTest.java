package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class WallTest {
    private Wall wall;
    private Block block1;
    private Block block2;
    private Block block3;

    @BeforeEach
    public void setUp() {
        wall = new Wall();
        block1 = new Block("Red", "Brick");
        block2 = new Block("Blue", "Concrete");
        block3 = new Block("Green", "Brick");
    }

    @Test
    public void testFindBlockByColor_ExistingColor() {
        wall.addBlock(block1);
        wall.addBlock(block2);
        wall.addBlock(block3);

        Optional<Block> foundBlock = wall.findBlockByColor("Blue");

        Assertions.assertTrue(foundBlock.isPresent());
        Assertions.assertEquals(block2, foundBlock.get());
    }

    @Test
    public void testFindBlockByColor_NonExistingColor() {
        wall.addBlock(block1);
        wall.addBlock(block2);

        Optional<Block> foundBlock = wall.findBlockByColor("Green");

        Assertions.assertFalse(foundBlock.isPresent());
    }

    @Test
    public void testFindBlocksByMaterial_ExistingMaterial() {
        wall.addBlock(block1);
        wall.addBlock(block2);
        wall.addBlock(block3);

        List<Block> foundBlocks = wall.findBlocksByMaterial("Brick");

        Assertions.assertEquals(2, foundBlocks.size());
        Assertions.assertTrue(foundBlocks.contains(block1));
        Assertions.assertTrue(foundBlocks.contains(block3));
    }

    @Test
    public void testFindBlocksByMaterial_NonExistingMaterial() {
        wall.addBlock(block1);
        wall.addBlock(block2);

        List<Block> foundBlocks = wall.findBlocksByMaterial("Concrete");

        Assertions.assertFalse(foundBlocks.isEmpty());
    }

    @Test
    public void testCount() {
        wall.addBlock(block1);
        wall.addBlock(block2);
        wall.addBlock(block3);

        int blockCount = wall.count();

        Assertions.assertEquals(3, blockCount);
    }
}
