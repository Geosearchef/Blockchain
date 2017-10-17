package de.geosearchef.blockchain;

import java.util.Scanner;

/**
 * Created by Geosearchef on 17.10.2017.
 */
public class BlockchainTest {

    public static void main(String args[]) throws InvalidBlockException {
        Blockchain blockchain = new Blockchain();


        Scanner scan = new Scanner(System.in);
        String in;

        while(! (in = scan.nextLine()).equals("stop")) {
            Block block = blockchain.insertData(in.getBytes());

            System.out.println("Inserted block #" + block.getIndex() + " into the blockchain");
            System.out.println("Hash: " + block.getHashString() + "\n");
        }
    }
}
