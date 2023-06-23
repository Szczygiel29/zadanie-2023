package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Block block1 = new Block("Red", "Brick");
        Block block2 = new Block("Blue", "Concrete");
        Block block3 = new Block("Green", "Brick");

        Wall wall = new Wall();

        wall.addBlock(block1);
        wall.addBlock(block2);
        wall.addBlock(block3);

        Optional<Block> foundBlock = wall.findBlockByColor("Blue");
        handleBlock(foundBlock);

        List<Block> bricks = wall.findBlocksByMaterial("Brick");
        BlockPrinter.printBlockList(bricks);

        int blockCount = wall.count();
        BlockPrinter.printBlockCount(blockCount);

        BlockPrinter.printBlockList(wall.getBlocks());
        wall.removeBlock(block3);
        BlockPrinter.printBlockList(wall.getBlocks());
    }

    private static void handleBlock(Optional<Block> foundBlock) {
        if (foundBlock.isPresent()) {
            BlockPrinter.printFoundBlock(foundBlock.get());
        } else {
            BlockPrinter.printBlockNotFound(foundBlock.get());
        }
    }
}