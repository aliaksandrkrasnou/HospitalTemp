package com.company.reader;

import com.company.collections.Archive;
import com.company.collections.Doctors;
import com.company.collections.Patients;
import com.company.converter.Converter;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Reader {
    public static void readPatients(String filename, Patients patientsList) {
        File file = new File(filename);
        System.out.println("Открываем файл по пути " + file.getAbsolutePath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            System.out.println("Чтение данных о пациентах");
            while ((string = br.readLine()) != null) {
                patientsList.add(string);
            }
            System.out.println("Чтение успешно завершено");
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл \"" + filename + "\" не найден");
        } catch (IOException e) {
            System.err.println("IOException при чтении \"" + filename + "\"");
        }
    }

    public static void readDoctors(String filename, Doctors doctorsList) {
        File file = new File(filename);
        System.out.println("Открываем файл по пути " + file.getAbsolutePath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            System.out.println("Чтение данных о докторах");
            while ((string = br.readLine()) != null) {
                doctorsList.add(string);
            }
            System.out.println("Чтение успешно завершено");
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("Файл \"" + filename + "\" не найден");
        } catch (IOException e) {
            System.err.println("IOException при чтении \"" + filename + "\"");
        }
    }

    public static void readArchieve(String filename, Archive archive) {
        File file = new File(filename);
        System.out.println("Открываем файл по пути " + file.getAbsolutePath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String string;
            System.out.println("Чтение архива");
            while ((string = br.readLine()) != null) {
                archive.add(string);
            }
            System.out.println("Чтение архива завершено");
            br.close();
        } catch (FileNotFoundException e) {
            System.err.println("File \"" + filename + "\" not found");
        } catch (IOException e) {
            System.err.println("IOException while reading \"" + filename + "\"");
        }
    }
}
