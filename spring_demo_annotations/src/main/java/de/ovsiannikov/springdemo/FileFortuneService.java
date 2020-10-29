package de.ovsiannikov.springdemo;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class FileFortuneService implements FortuneService {

    File file = new File("src/main/resources/fortune-data.txt");
    List<String> fortunes = new ArrayList<>();

    private Random myRandom = new Random();

    public FileFortuneService() {
        System.out.println(">> FileFortuneService: inside default constructor");
    }

    @PostConstruct
    private void loadTheFortunesFileToTheArrayList() throws FileNotFoundException {

        System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");
        System.out.println("Reading fortunes from file: " + file);
        System.out.println("File exists: " + file.exists());

        BufferedReader br = new BufferedReader(new FileReader(file));
        fortunes = br.lines().collect(Collectors.toList());
    }

    public String getFortune() {
        // pick a random string from the array
        int index = myRandom.nextInt(fortunes.size());
        return fortunes.get(index);
    }
}
