package software.ulpgc.kata3.clean.control;

import software.ulpgc.kata3.clean.view.BarchartDisplay;
import software.ulpgc.kata3.clean.model.Barchart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ToggleChartCommand implements Command{
    private final BarchartDisplay barchartDisplay;
    private final List<Barchart> barcharts;

    public ToggleChartCommand(BarchartDisplay barchartDisplay) {
        this.barchartDisplay = barchartDisplay;
        this.barcharts = new ArrayList<>();
    }

    @Override
    public void execute() {
        barchartDisplay.display(selectBarchart());
    }

    private int index = 0;
    private Barchart selectBarchart() {
        index += 1;
        if (index >= barcharts.size()) {index = 0;}
        return barcharts.get(index);
    }

    public void addBarchartData(String title, Map<String, Integer> histogram) {
        Barchart barchart = new Barchart(title);
        for (String category: histogram.keySet()){
            barchart.add(category, histogram.get(category));
        }
        barcharts.add(barchart);
    }
}
