package ru.YLab.hwThree.fileSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sorter {
    private static final int CHUNK_SIZE = 100000; //размер блока
    private static final String outputFilePath = "YLabHomework/src/main/resources/sortedData.txt";

    public static File sortFile(File inputFile) {
        File outputFile = new File(outputFilePath);
        try {

            //разбиваем файл на блоки
            List<File> chunks = chunkFile(inputFile);

            //сортируем каждый блок
            for (File chunk : chunks) {
                sortChunk(chunk);
            }

            //сливаем блоки в отсортированный файл
            mergeChunks(chunks, outputFile);

            //удаляем временные файлы
            for (File chunk : chunks) {
                chunk.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputFile;
    }

    //разбиваем файл на блоки
    private static List<File> chunkFile(File inputFile) throws IOException {
        List<File> chunks = new ArrayList<>();
        FileInputStream fis = new FileInputStream(inputFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        List<Integer> chunkData = new ArrayList<>();
        int linesCount = 0;
        while ((line = br.readLine()) != null) {
            chunkData.add(Integer.parseInt(line));
            linesCount++;
            if (linesCount == CHUNK_SIZE) { //достигли максимального размера блока
                chunks.add(createChunk(chunkData));
                chunkData.clear();
                linesCount = 0;
            }
        }
        if (!chunkData.isEmpty()) { //если остался неполный блок
            chunks.add(createChunk(chunkData));
        }
        return chunks;
    }

    private static File createChunk(List<Integer> chunkData) throws IOException {
        File chunkFile = File.createTempFile("chunk", null);
        chunkFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(chunkFile);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        chunkData.stream().sorted().forEach(number -> {
            try {
                bw.write(number.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fos.close();
        return chunkFile;
    }

    //сортируем блок
    private static void sortChunk(File chunk) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        FileInputStream fis = new FileInputStream(chunk);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        while ((line = br.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
        }
        fis.close();
        br.close();
        numbers.sort(Integer::compareTo);
        FileOutputStream fos = new FileOutputStream(chunk);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        numbers.forEach(number -> {
            try {
                bw.write(number.toString());
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.close();
        fos.close();
    }

    //сливаем блоки в отсортированный файл
    private static void mergeChunks(List<File> chunks, File outputFile) throws IOException {
        List<BufferedReader> readers = new ArrayList<>();
        for (File chunk : chunks) {
            FileInputStream fis = new FileInputStream(chunk);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            readers.add(br);
        }
        FileOutputStream fos = new FileOutputStream(outputFile);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        List<Integer> numbers = new ArrayList<>();
        for (BufferedReader reader : readers) {
            String line = reader.readLine();
            if (line != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        while (!numbers.isEmpty()) {
            int minNumber = numbers.stream().min(Integer::compareTo).orElseThrow();
            bw.write(minNumber);
            bw.newLine();
            for (BufferedReader reader : readers) {
                String line = reader.readLine();
                if (line != null) {
                    int number = Integer.parseInt(line);
                    if (number == minNumber) {
                        numbers.add(number);
                    }
                }
            }
            numbers.remove((Integer) minNumber);
        }
        bw.close();
        fos.close();
        for (BufferedReader reader : readers) {
            reader.close();
        }
    }
}

