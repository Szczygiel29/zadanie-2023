package org.example;

import java.util.List;

public class BlockPrinter {
    public static void printFoundBlock(Block block) {
        System.out.println("Found block with color " + block.color() + ": " + block);
    }

    public static void printBlockList(List<Block> blocks) {
        System.out.println("Blocks: " + blocks);
    }

    public static void printBlockCount(int count) {
        System.out.println("Total block count: " + count);
    }

    public static void printBlockNotFound(Block block) {
        System.out.println("Block with color" + block.color() + "not found.");
    }
}
