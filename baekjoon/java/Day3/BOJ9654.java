package Day3;

public class BOJ9654 {
    public static final String SHIP_INFO = "SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\nN2 Bomber      Heavy Fighter  Limited    21        \nJ-Type 327     Light Combat   Unlimited  1         \nNX Cruiser     Medium Fighter Limited    18        \nN1 Starfighter Medium Fighter Unlimited  25        \nRoyal Cruiser  Light Combat   Limited    4         ";

    public static void main(String[] args) {
        System.out.println(SHIP_INFO);
    }
}

//import java.util.ArrayList;
//import java.util.List;

//public class BOJ9654 {
//    public static void main(String[] args) {
//        List<Ship> shipInfoOfNaboo = new ArrayList<>();
//        shipInfoOfNaboo.add(new Ship("N2 Bomber", "Heavy Fighter", "Limited", 21));
//        shipInfoOfNaboo.add(new Ship("J-Type 327", "Light Combat", "Unlimited", 1));
//        shipInfoOfNaboo.add(new Ship("NX Cruiser", "Medium Fighter", "Limited", 18));
//        shipInfoOfNaboo.add(new Ship("N1 Starfighter", "Medium Fighter", "Unlimited", 25));
//        shipInfoOfNaboo.add(new Ship("Royal Cruiser", "Light Combat", "Limited", 4));
//
//        System.out.printf("%s\t\t%s\t\t\t%s\t%s\n", "SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE");
//        for (Ship shipInfo : shipInfoOfNaboo) {
//            if (shipInfo.getName().length() > 10)
//                System.out.printf("%s\t", shipInfo.getName());
//            else
//                System.out.printf("%s\t\t", shipInfo.getName());
//            if (shipInfo.getShipClass().length() > 10)
//                System.out.printf("%s\t", shipInfo.getShipClass());
//            else
//                System.out.printf("%s\t\t", shipInfo.getShipClass());
//            if (shipInfo.getDeployment().length() > 8)
//                System.out.printf("%s\t", shipInfo.getDeployment());
//            else
//                System.out.printf("%s\t\t", shipInfo.getDeployment());
//            System.out.printf("%d\t\t\n", shipInfo.getInService());
//
//        }
//    }
//}
//
//class Ship {
//    private String name;
//    private String shipClass;
//    private String deployment;
//    private int inService;
//
//    public Ship (String name, String shipClass, String deployment, int inService) {
//        this.name = name;
//        this.shipClass = shipClass;
//        this.deployment = deployment;
//        this.inService = inService;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getShipClass() {
//        return shipClass;
//    }
//
//    public String getDeployment() {
//        return deployment;
//    }
//
//    public int getInService() {
//        return inService;
//    }
//}