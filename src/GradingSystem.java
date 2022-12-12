import javax.swing.*;

public class GradingSystem {
    private static float[][] gradingSystemData;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | RuntimeException | ClassNotFoundException | UnsupportedLookAndFeelException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }

        initializeGradingSystemData();
        SwingUtilities.invokeLater(GradingSystemUI::new);
    }

    private static void initializeGradingSystemData() {
        gradingSystemData = new float[][] {
                {100.00F, 100.00F, 100},
                {98.40F, 99.99F, 99},
                {96.80F, 98.39F, 98},
                {95.20F, 96.79F, 97},
                {93.60F, 95.19F, 96},
                {92.00F, 93.59F, 95},
                {90.40F, 91.99F, 94},
                {88.80F, 90.39F, 93},
                {87.20F, 88.79F, 92},
                {85.60F, 87.19F, 91},
                {84.00F, 85.59F, 90},
                {82.40F, 83.99F, 89},
                {80.80F, 82.39F, 88},
                {79.20F, 80.79F, 87},
                {77.60F, 79.19F, 86},
                {76.00F, 77.59F, 85},
                {74.40F, 75.99F, 84},
                {72.80F, 74.39F, 83},
                {71.20F, 72.79F, 82},
                {69.90F, 71.19F, 81},
                {68.00F, 69.59F, 80},
                {66.40F, 67.99F, 79},
                {64.80F, 66.39F, 78},
                {63.20F, 64.79F, 77},
                {61.60F, 63.19F, 76},
                {60.00F, 61.59F, 75},
                {56.00F, 59.99F, 74},
                {52.00F, 55.59F, 73},
                {48.00F, 51.99F, 72},
                {44.00F, 47.99F, 71},
                {40.00F, 43.99F, 70},
                {36.00F, 39.99F, 69},
                {32.00F, 35.99F, 68},
                {28.00F, 31.99F, 67},
                {24.00F, 27.99F, 66},
                {20.00F, 23.99F, 65},
                {16.00F, 19.99F, 64},
                {12.00F, 15.99F, 63},
                {8.00F, 11.99F, 62},
                {4.00F, 7.99F, 61},
                {0F, 3.99F, 60}
        };
    }

    public static int getEquivalentGrades(float totalRawGrade) {
        for (float[] gradingSystemDatum : gradingSystemData) {
            if (totalRawGrade >= gradingSystemDatum[0] && totalRawGrade <= gradingSystemDatum[1]) {
                return (int) gradingSystemDatum[2];
            }
        }
        return 0;
    }
}