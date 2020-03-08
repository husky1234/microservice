package com.husky.microservicegatewayzuul.test;

import java.io.*;

public class FileCompare {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File("D:\\compare.txt")));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        File file = new File("D:\\test");
        String[] array = file.list();
        String filename;
        File outFile = new File("D:\\output.txt");
        FileWriter fileWriter = new FileWriter(outFile);
        while ((filename = bufferedReader.readLine()) != null) {
            int count = 0;
            for (String s : array) {
                if (s.contains(filename)) {
                    count += 1;
                }
            }
            if (count > 0) {
                fileWriter.append(filename + "\t" + 1 + "\n");
            } else {
                fileWriter.append(filename + "\t" + 0 + "\n");
            }
        }
        fileWriter.close();
    }
}
