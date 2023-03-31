import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        Plant aa = new Plant();
        aa.setTitle("Rožė");
        aa.setTitleLatin("Rosa");
        aa.setAnnualPerennial(false);
        aa.setPlantContinent("Kinija");
        aa.setHeightAdultPlantInMeters(7);
        aa.setEdibleInedible(true);

        Plant aa2 = new Plant();
        aa2.setTitle("Triskiautė žibuoklė");
        aa2.setTitleLatin("Hepatica nobilis. ");
        aa2.setAnnualPerennial(true);
        aa2.setPlantContinent("Europa. ");
        aa2.setHeightAdultPlantInMeters(0.25);
        aa2.setEdibleInedible(false);

        Plant aa3 = new Plant("Saulėgrąža", "Helianthus", true, "Europa",
                3, true);

        Plant.plants.add(aa);
        Plant.plants.add(aa2);
        Plant.plants.add(aa3);

        while (true) {
            Plant.Info();

            int input = sc.nextInt();

             input = Validated.integer(sc);



            sc.nextLine();
            switch (input) {
                case 1:
                    Plant.printPlants();
                    break;
                case 2:
                    Plant.filter();
                    break;
                case 3:
                    Plant.addPlants(sc);
                    break;
                case 4:
                    Plant.editPlant();
                    break;
                case 5:
                    Plant.deletePlant();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pasirinkite validižią opciją");
                    break;
            }
        }
    }
}