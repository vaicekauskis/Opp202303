import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Filter;

public class Plant {
    public static ArrayList<Plant> plants = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    private static int idCount = 0;  //Statinis laukas

    private final int id;
    private String title;
    private String titleLatin;
    private boolean annualPerennial;
    private String plantContinent;
    private double heightAdultPlantInMeters;
    private boolean edibleInedible;

    public Plant() {
        this.id = ++idCount;
    }

    public Plant(int id) {
        this.id = id;
    }


    public Plant(String title, String titleLatin, boolean annualPerennial, String plantcontinent,
                 int heightAdultPlantInMeters, boolean edibleInedible) {
        this.id = ++idCount;
        this.title = title;
        this.titleLatin = titleLatin;
        this.annualPerennial = annualPerennial;
        this.plantContinent = plantcontinent;
        this.heightAdultPlantInMeters = heightAdultPlantInMeters;
        this.edibleInedible = edibleInedible;

    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public String getTitleLatin() {
        return titleLatin;
    }

    public void setTitleLatin(String titleLatin) {
        this.titleLatin = titleLatin;

    }

    public boolean getAnnualPerennial() {
        return annualPerennial;
    }

    public void setAnnualPerennial(boolean annualPerennial) {
        this.annualPerennial = annualPerennial;

    }

    public String getPlantContinent() {
        return plantContinent;
    }

    public void setPlantContinent(String plantContinent) {
        this.plantContinent = plantContinent;

    }

    public double getHeightAdultPlantInMeters() {
        return heightAdultPlantInMeters;
    }

    public void setHeightAdultPlantInMeters(double heightAdultPlantInMeters) {
        this.heightAdultPlantInMeters = heightAdultPlantInMeters;

    }

    public boolean getedibleInedible() {
        return edibleInedible;
    }

    public void setEdibleInedible(boolean edibleInedible) {
        this.edibleInedible = edibleInedible;

    }

    @Override
    public String toString() {
        return id + ". Augalo pavadinimas: " + title + ". Pavadinimas Lotyniškai : " + titleLatin + ". Vienmetis :" +
                (annualPerennial ? " Taip " : " Ne ") + " Labiausiai paplitęs :" + plantContinent + " Suaugusio augalo aukštis " +
                (heightAdultPlantInMeters == (int) heightAdultPlantInMeters ? ((int) heightAdultPlantInMeters + "") :
                        heightAdultPlantInMeters) + " Metrais " + " Ar valgomas :" + (edibleInedible ? " Taip " : " Ne ");
    }


    public static void printPlants() {
        for (int i = 0; i < plants.size(); i++) {
            System.out.println(plants.get(i));
        }
    }

    public static void Info() {
        System.out.println("1. Pamatyti augalų sąrašą");
        System.out.println("2. Filtruoti  augalų sąrašą");
        System.out.println("3. Pridėti augalą");
        System.out.println("4. Redaguoti augalą");
        System.out.println("5. Ištrinti augalą");
        System.out.println("6. Išeiti iš programos");
    }


    public static void addPlants(Scanner sc) {
        Plant plants = new Plant();
        System.out.println("iveskite Augalo pavadinimą");
        plants.setTitle(sc.nextLine());
        System.out.println("iveskite Augalo pavadinimą Lotyniškai");
        plants.setTitleLatin(sc.nextLine());
        System.out.println("iveskite ar augalas vienmetis ");
        plants.setAnnualPerennial(Validated.boole(sc));
        sc.nextLine();
        System.out.println("iveskite Augalo kontinentą");
        plants.setPlantContinent(sc.nextLine());
        System.out.println("iveskite suaugusio augalo aukštį");
        plants.setHeightAdultPlantInMeters(Validated.height(sc));
        sc.nextLine();                                                 // nextLine() kad neprasoktu ir eitu užpildytį stulpelį
        System.out.println("iveskite ar augalas valgomas ");
        plants.setEdibleInedible(Validated.boole(sc));
        Plant.plants.add(plants);
    }

    public static void editPlant() {
        System.out.println("iveskite augalą Id kurį norite redaguoti");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).id == id) {
                Plant aa4 = new Plant(id);
                System.out.println("iveskite Augalo pavadinimą");
                aa4.setTitle(sc.nextLine());
                System.out.println("iveskite Augalo pavadinimą Lotyniškai");
                aa4.setTitleLatin(sc.nextLine());
                System.out.println("iveskite ar augalas vienmetis ");
                aa4.setAnnualPerennial(Validated.boole(sc));
                sc.nextLine();
                System.out.println("iveskite Augalo kontinentą");
                aa4.setPlantContinent(sc.nextLine());
                System.out.println("iveskite suaugusio augalo aukštį");
                aa4.setHeightAdultPlantInMeters(Validated.height(sc));
                sc.nextLine();
                System.out.println("iveskite ar augalas valgomas ");
                aa4.setEdibleInedible(Validated.boole(sc));
                plants.set(i, aa4);
                break;
            }
        }
        System.out.println("tokio id neradome.");
    }

    public static void deletePlant() {
        System.out.println("iveskite augalą  Is kurį norite redaguoti");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).id == id) {
                plants.remove(i);
                break;

            }
        }
        System.out.println("tokio id neradome.");
    }

    public static void filter() {
        System.out.println("Pasirinkite pagal kuri lauką norite redaguoti");
        System.out.println("1 Pagal Pavadinimą");
        System.out.println("2. Pagal Lotynišką pavadinimą");
        System.out.println("3. Pagal augalo kontinenta ");
        System.out.println("4. Pagal tai at augalas valgomas (taip) arba nevalgomas (ne)");
        System.out.println("5. Atgal į meniu ");
        int input = Validated.integer(sc);
        sc.nextLine();
        switch (input) {
            case 1:
                filterByName();
                break;
            case 2:
                FilterByLatinName();
                break;
            case 3:
               FilterByContinent();
                break;
            case 4:
                FilterByEdibleInedible();
                break;
            case  5:
                break;
            default:
                System.out.println("Tokio pairinkimo nėra");
                break;

        }
    }

    public static void filterByName(){
        System.out.println("įveskite augalo pavadinimą arba pavadinimo fragmenta");
        String input = sc.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i <plants.size(); i++) {
            if (plants.get(i).title.toLowerCase().contains(input)){
                System.out.println(plants.get(i));
                count++;
            }
        }
        if (count == 0){
            System.out.println("Tokiu pavadinimu augalo neradome");
        }
    }


    public static void FilterByLatinName() {
        System.out.println("įveskite augalo pavadinimą Lotyniškai arba pavadinimo fragmenta");
        String input = sc.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).titleLatin.toLowerCase().contains(input)) {
                System.out.println(plants.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Tokiu pavadinimu augalo neradome");
        }
    }

    public static void FilterByContinent() {
        System.out.println("įveskite augalo continentą  ");
        String input = sc.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).plantContinent.toLowerCase().contains(input)) {
                System.out.println(plants.get(i));
                count++;

            }
        }
        if (count == 0) {
            System.out.println("v");
        }
    }
    public static void FilterByEdibleInedible() {
        System.out.println("įveskite ar augalas valgomas - True arba nevalgomas - false:" );
        boolean input = Validated.boole(sc);
        sc.nextLine();
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).edibleInedible == input) {
                System.out.println(plants.get(i));

            }
        }
    }

}


















