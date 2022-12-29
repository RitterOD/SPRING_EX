package org.maslov.check17java.checkstring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

  public static void main(String[] args) throws IOException {
    Set<String> set = new HashSet<>();
    File file = new File("new_and_old.csv");
    File outFile = new File("new_and_old2.csv");

    BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
    BufferedReader br = new BufferedReader(new FileReader(file));
    String st;
    int cnt = 0;
    while ((st = br.readLine()) != null) {
      st = st.trim();
      if (set.contains(st)) {
        System.out.println("DUPLICATE: " + st + " line :" +  cnt);
      } else {
        set.add(st);
        bw.write(st + "\n");
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
