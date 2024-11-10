package software.ulpgc.kata3.dirty;

import software.ulpgc.kata2.Title;
import software.ulpgc.kata2.TsvFileTitleReader;
import software.ulpgc.kata3.clean.control.ToggleChartCommand;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\crazy\\Downloads\\title.basics.tsv");
        List<Title> titles = new TsvFileTitleReader(file).read();
        HashMap<String, Integer> typeHistogram = new HashMap<>();
        HashMap<String, Integer> genreHistogram = new HashMap<>();
        for (Title title : titles) {
            typeHistogram.put(title.getTitleType().name(), typeHistogram.getOrDefault(title.getTitleType().name(),0) + 1);
            for (Title.Genre genre: title.getGenreType()){
                genreHistogram.put(genre.name(), genreHistogram.getOrDefault(genre.name(),0) +1);
            }
        }
        MainFrame mainFrame = new MainFrame();
        ToggleChartCommand command = new ToggleChartCommand(mainFrame.getBarchartDisplay());
        command.addBarchartData("Movie Type", typeHistogram);
        command.addBarchartData("Movie Genre", genreHistogram);
        mainFrame.put("toggle", command);
        mainFrame.setVisible(true);
    }
}
