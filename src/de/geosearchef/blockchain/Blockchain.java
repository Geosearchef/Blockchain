package de.geosearchef.blockchain;


import java.util.LinkedList;

public class Blockchain {

    public long currentIndex = 0;

    private LinkedList<Block> chain = new LinkedList<Block>();
    private byte[] lastHash = new byte[64];
    private long startIndex;

    public synchronized Block insertData(byte[] data) throws InvalidBlockException {
        Block block = new Block(currentIndex++, System.currentTimeMillis(), lastHash, data);

        insertBlock(block);
        return block;
    }

    public synchronized Block insertBlock(Block block) throws InvalidBlockException {
        Block previousBlock = chain.isEmpty() ? null : chain.get(chain.size() - 1);
        synchronized (chain) {
            if(previousBlock != null && (previousBlock.getIndex() + 1 != block.getIndex() || previousBlock.getTimestamp() >= block.getTimestamp() || block.getPreviousHash() != previousBlock.getHash()))
                throw new InvalidBlockException();

            lastHash = block.getHash();
            chain.add(block);
        }
        return block;
    }
}
