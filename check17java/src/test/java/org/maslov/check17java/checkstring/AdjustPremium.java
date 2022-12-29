package org.maslov.check17java.checkstring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class AdjustPremium {
  public static void main(String[] args) throws IOException {
    Set<String> set = new HashSet<>();
    File file = new File("ALL PREMIUM_2.csv");
    File outFile = new File("outALL PREMIUM_2.csv");

    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    int cnt = 0;
    while ((st = br.readLine()) != null) {
      String[] parts = st.split(",");
      String name = parts[0].trim().toLowerCase();
      BigInteger price = new BigInteger(parts[1]).multiply(new BigInteger("1000000000000000000"));
      if (set.contains(name)) {
        System.out.println("DUPLICATE: " + name + " line :" +  cnt);
      } else {
        set.add(name);
        bw.write(name + "," + price + "\n");
      }
      //System.out.println(st);
      ++cnt;
    }
    bw.flush();
    bw.close();
    br.close();
    System.out.println("CNT: " + cnt);
  }
}
