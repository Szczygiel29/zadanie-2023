package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall() {
        this.blocks = new ArrayList<>();
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for (Block block : blocks) {
            if (block.color().equals(color)) {
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> matchingBlocks = new ArrayList<>();
        for (Block block : blocks) {
            if (block.material().equals(material)) {
                matchingBlocks.add(block);
            }
        }
        return matchingBlocks;
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    public void  addBlock(Block block){
        blocks.add(block);
    }

    public void removeBlock(Block block){
        blocks.remove(block);
    }

}
