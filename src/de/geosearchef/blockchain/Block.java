package de.geosearchef.blockchain;


import java.nio.ByteBuffer;

public class Block {

    private final long index;
    private final long timestamp;
    private final byte[] previousHash;
    private final byte[] data;
    private final byte[] hash;

    public Block(long index, long timestamp, byte[] previousHash, byte[] data) {
        this.index = index;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        this.data = data;

        this.hash = calcHash();
    }

    public byte[] calcHash() {
        ByteBuffer blockData = ByteBuffer.wrap(new byte[8 + 8 + previousHash.length + data.length]);
        blockData.putLong(index);
        blockData.putLong(timestamp);
        blockData.put(previousHash);
        blockData.put(data);
        return SHA256.hash(blockData.array());
    }

    public long getIndex() {
        return index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public byte[] getPreviousHash() {
        return previousHash;
    }

    public byte[] getData() {
        return data;
    }

    public byte[] getHash() {
        return hash;
    }

    public String getHashString() {
        return String.format("%064x", new java.math.BigInteger(1, hash));
    }
}
