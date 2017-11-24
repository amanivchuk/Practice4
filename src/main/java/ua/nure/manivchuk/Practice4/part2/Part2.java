package ua.nure.manivchuk.Practice4.part2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lenovo on 11/22/2017.
 */
public class Part2 {

    private String fileNameIn;
    private String fileNameOut;

    public Part2(String fileNameIn, String fileNameOut) {
        this.fileNameIn = fileNameIn;
        this.fileNameOut = fileNameOut;
    }

    public String getFileNameIn() {
        return fileNameIn;
    }

    public void setFileNameIn(String fileNameIn) {
        this.fileNameIn = fileNameIn;
    }

    public String getFileNameOut() {
        return fileNameOut;
    }

    public void setFileNameOut(String fileNameOut) {
        this.fileNameOut = fileNameOut;
    }

    public void readWriteData(){
        /*String fileNameIn = "src/main/resources/part2In.txt";
        String fileNameOut = "src/main/resources/part2Out.txt";*/
        int[] array = null;

        boolean resWriteData = writeData(fileNameIn);

        if (resWriteData){
            array = sortData(fileNameIn);
        }

        writeSortData(array, fileNameOut);

        showDataFromFile(fileNameIn);
        showDataFromFile(fileNameOut);
    }

    private boolean writeData(String fileNameIn) {
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameIn), "utf-8"))){

            for(int i = 0; i < 50; i++){
                String data = random.nextInt(50) + " ";
                writer.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return true;
        }
    }

    private int[] sortData(String fileNameIn) {
        ArrayList<String> buffer = new ArrayList<>();
        StringBuffer stringBuffer = getDataFromFile(fileNameIn);

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(stringBuffer.toString());
        while (matcher.find()){
            buffer.add(matcher.group(1));
        }

        int[] array = new int[buffer.size()];
       for(int i = 0; i < buffer.size(); i++){
           array[i] = Integer.parseInt(buffer.get(i));
       }


        for(int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i-1;
            while (j >= 0 && array[j] > key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }

    private StringBuffer getDataFromFile(String fileNameIn) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameIn)))){
            String res;
            while ((res = reader.readLine()) != null){
                stringBuffer.append(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    private void writeSortData(int[] array, String fileNameOut) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameOut), "utf-8"))){

            for (int i = 0; i < array.length; i++){
                writer.write(array[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDataFromFile(String fileName) {
        StringBuffer stringBuffer = getDataFromFile(fileName);;
        System.out.println(stringBuffer.toString());
    }


    public static void main(String[] args) {
        String file1 = "src/main/resources/part2In.txt";
        String file2 = "src/main/resources/part2Out.txt";
        Part2 part2 = new Part2(file1, file2);
        part2.readWriteData();

    }
}
