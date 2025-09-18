import java.util.Scanner;
public class Sample {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Student Grades Analysis System\n");

        System.out.print("Enter number of students: ");
        int stdNo = input.nextInt();
        System.out.print("Enter number of subjects: ");
        int subNo = input.nextInt();

        int[] stdID = new int[stdNo];
        String[] stdName = new String[stdNo];
        int[][] subGrade = new int[stdNo][subNo];
        double[] stdAverage = new double[stdNo];
        double[] subAverage = new double[subNo];
        int marksSum = 0;

        for(int i = 0; i < stdNo; i++){
            marksSum = 0;
            System.out.println("\nEnter details for Student "+(i+1)+" :");

            System.out.print("ID : ");
            stdID[i] = input.nextInt();

            System.out.print("Name : ");
            stdName[i] = input.next();

            System.out.println("Enter subject Marks below : ");
            for(int j = 0; j<subNo; j++){
                System.out.print("Subject # "+(j+1)+" Marks : ");
                subGrade[i][j] = input.nextInt();
                marksSum = marksSum + subGrade[i][j];
            }
            stdAverage[i] = (double)marksSum/subNo;
        }
        System.out.println("--- Results ---");
        for(int i = 0; i < stdNo; i++){
            System.out.println(stdName[i]+ " -> Average : "+ stdAverage[i]);
        }

        System.out.println("Class Average (per subject):");
        for(int i = 0; i < subNo; i++){
            marksSum = 0;
            for(int j = 0; j < stdNo; j++){
                marksSum = marksSum + subGrade[j][i];
            }
            subAverage[i] = (double)marksSum/stdNo;
            System.out.println("Subject " + (i+1) + " : " + subAverage[i]);
        }
        for(int i=0; i<stdNo; i++){
            double max= stdAverage[0];
            if(max<=stdAverage[i]){
                max= stdAverage[i];
                System.out.println("Top Student: "+stdName[i]+" with Average: "+max);
            }
            double min= stdAverage[0];
            if(min>stdAverage[i]){
                min= stdAverage[i];
                System.out.println("Lowest Student: "+stdName[i]+" with Average: "+min);
            }
        }
    }
}

