/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import controller.Algorithm;
import java.io.*;
/**
 *
 * @author Tran HaF
 */
public class FileIO {
    public void normalizeData(String inputFilePath, String outputFilePath) {
            FileIO io = new FileIO();
        Algorithm algorithm = new Algorithm();
        BufferedReader br = null;
        PrintWriter pw = null;

        try {

            br = new BufferedReader(new FileReader(new File(inputFilePath)));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath, true)));
            String line;

            while ((line = br.readLine()) != null) {
                if (io.isLineEmpty(line)) {
                    continue;
                }

                line = processLine(line, algorithm);

                pw.print(line);
            }
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    private String processLine(String line, Algorithm algorithm) {
        line = algorithm.formatOneSpace(line);
        line = algorithm.formatSpecialCharacters(line);
        line = algorithm.afterDotUpperCase(line);
        line = algorithm.noSpaceQuotes(line);
        line = algorithm.firstUpercase(line);
        line = algorithm.lastAddDot(line);
        return line;
    }
}
