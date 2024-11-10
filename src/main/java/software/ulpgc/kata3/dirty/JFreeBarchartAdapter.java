package software.ulpgc.kata3.dirty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.clean.model.Barchart;

public class JFreeBarchartAdapter {

    public static JFreeChart adapt(Barchart barchart){
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                barchart.getTitle(),
                "count",
                datasetOf(barchart)
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return chart;
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String category: barchart.getCategory()) {
            dataset.addValue(barchart.getValue(category),"", category);
        }
        return dataset;
    }
}
