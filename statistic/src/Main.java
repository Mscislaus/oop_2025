public class Main {
    public static void main(String[] args) {
        DeathCauseStatisticList lista = new DeathCauseStatisticList();
        lista.repopulate();
        //System.out.println(lista);

        System.out.println(lista.mostDeadlyDiseases(3, 5));
        ICDCodeTabular desc = new ICDCodeTabularOptimizedForMemory("ICD-10.txt");
        System.out.println(desc.getDescription("P07.2"));
    }
}