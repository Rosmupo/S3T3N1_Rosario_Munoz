import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    //Variables globales

    static Scanner sc = new Scanner(System.in);
    public static final String DIRECTORY = "/Users/Rosario/Pruebas/Catalogo";
    static Florist florist = null;

    public static void main(String[] args) throws IOException {

        int option, numFlower, numTree, numDecoration, index;
        boolean out = false;


        System.out.println("        ¡¡¡BIENVENIDOS A LA APLICACIÓN !!!");
        System.out.println("Como se llama tu floristería");
        florist = createFlorist();

        while (!out) {
            System.out.println("""
                    Tiene disponible las siguientes opciones:\s
                     1. Agregar árbol.
                     2. Agregar flor.
                     3. Agregar decoración.
                     4. Borrar árbol.
                     5. Borrar flor.
                     6. Borrar decoración.
                     7. Guardar en txt e imprimir todos los árboles, flores y decoración.
                     8. Imprimir stock de los árboles, flores y decoración.
                     9. Valor total de todos los productos de la floristeria.
                     10. Crear ticket.
                     11. Mostrar lista de todas las compras.
                     12. Mostrar total de todas las compras.
                     13. Salir del programa. """);



        option = askInfoInt("Seleccione la opción que desea realizar:");

        switch (option) {
            case 1:
                System.out.println("Ha seleccionado la opción 1,  agregar árbol");
                Tree tree = createTree();
                addTreeToFloristList(tree, florist);
                break;
            case 2:
                System.out.println("Ha seleccionado la opción 2,  agregar flor");
                Flower flower = createFlower();
                addFlowerToFloristList(flower, florist);
                break;
            case 3:
                System.out.println("Ha seleccionado la opción 3,  agregar decoración");
                Decoration decoration = createDecoration();
                addDecorationToFloristList(decoration, florist);
                break;
            case 4:
                System.out.println("Ha seleccionado la opción 4, borrar árbol.");
                numTree= askInfoInt("Indique el código del árbol");
                index = findTheTree(numTree, florist);
                deleteTree(index, florist);
                break;
            case 5:
                System.out.println("Ha seleccionado la opción 5, borrar flor.");
                numFlower = askInfoInt("Indique el código de la flor");
                index = findTheFlower(numFlower, florist);
                deleteFlower(index, florist);
                break;
            case 6:
                System.out.println("Ha seleccionado la opción 6, borrar decoración.");
                numDecoration = askInfoInt("Indique el código de la decoración");
                index = findTheDecoration(numDecoration, florist);
                deleteDecoration(index, florist);
                break;
            case 7:
                System.out.println("Ha seleccionado la opción 7, guardar en txt e imprimir por consola todos los árboles, flores y decoración.");
                String data = florist.getFlowerList().toString() + florist.getTreeList().toString()+florist.getDecorationList().toString();
                writeFile(data);
                florist.printFlowers();
                florist.printDecoration();
                florist.printTree();
                break;
            case 8:
                System.out.println("Ha seleccionado la opción 8, imprimir la cantidad de todos los árboles, flores y decoración.");
                System.out.println("Cantidad de árboles: " + florist.getTreeList().size() +" cantidad flores: " + florist.getFlowerList().size() + ". Cantidad decoración: " + florist.getDecorationList().size());
                break;
            case 9:
                System.out.println("Ha seleccionado la opción 9, el valor total es: " + florist.getTotalValue());
                break;
            case 10:
                int choose = askInfoInt("Que desea comprar, opción 1: flores, opción 2 árboles, opción 3: decoración");
                Ticket ticket = new Ticket();
                ticket.addProductsToTicket(choose, florist);
                florist.getTicketsList().add(ticket);
                break;
            case 11:
                florist.printTicket();
                break;
            case 12:
                florist.totalAllSales();
                break;
            case 13:
                System.out.println("Ha seleccionado la opción 13, salir de la aplicación. Gracias por su visita, hasta la próxima!!");
                out = true;
                break;
        }
    }
}

    private static int findTheTree(int numTree, Florist florist) {
        int index = 0;
        boolean foundIt = false;
        int indexTree = -1;
        while ((index < florist.getTreeList().size()) && (!foundIt)) {
            if (florist.getTreeList().get(index).getCode() == numTree) {
                foundIt = true;
                indexTree = index;
            }
            index++;
        }
        return indexTree;
    }

    private static int findTheFlower(int numFlower, Florist florist) {
        int index = 0;
        boolean foundIt = false;
        int indexFlower = -1;
        while ((index < florist.getFlowerList().size()) && (!foundIt)) {
            if (florist.getFlowerList().get(index).getCode() == numFlower) {
                foundIt = true;
                indexFlower = index;
            }
            index++;
        }
        return indexFlower;
    }

    private static int findTheDecoration(int numDecoration, Florist florist) {
        int index = 0;
        boolean foundIt = false;
        int indexDecoration = -1;
        while ((index < florist.getDecorationList().size()) && (!foundIt)) {
            if (florist.getDecorationList().get(index).getCode() == numDecoration) {
                foundIt = true;
                indexDecoration = index;
            }
            index++;
        }
        return indexDecoration;
    }

    private static void deleteTree(int index, Florist florist) {
        if (!(index == -1)) {
            florist.getTreeList().remove(index);
            System.out.println("El árbol se ha borrado correctamente");
        } else {
            System.out.println("El árbol no está en la lista.");
        }
    }
    private static void deleteFlower(int index, Florist florist) {
        if (!(index == -1)) {
            florist.getFlowerList().remove(index);
            System.out.println("La flor se ha borrado correctamente");
        } else {
            System.out.println("La flor no está en la lista.");
        }
    }
    private static void deleteDecoration (int index, Florist florist) {
        if (!(index == -1)) {
            florist.getDecorationList().remove(index);
            System.out.println("La decoración se ha borrado correctamente");
        } else {
            System.out.println("La decoración no está en la lista.");
        }
    }







//////////////////FUNCIONALIDADES


/////////////////MÉTODOS  DE CREACIÓN Y ELIMINACIÓN DE INSTANCIAS DE CLASE


    private static Florist createFlorist (){
        String name =askInfoString("Indique el nombre de su floristeria ");
        return  new Florist(name);
    }


    private static Tree createTree(){
        String name = askInfoString("Indique el nombre del árbol");
        double price = askInfoDouble("Indique el precio");
        int height = askInfoInt("Indique la altura");
        int code= askInfoInt("Indique el código");

        return new Tree(name, price, height, code);

    }
    private static Flower createFlower(){
        String name = askInfoString("Indique el nombre de la flor");
        double price = askInfoDouble("Indique el precio");
        String color = askInfoString("Indique el color de la flor");
        int code= askInfoInt("Indique el código");

        return new Flower(name, price, color, code);

    }
    private static Decoration createDecoration(){
        String name = askInfoString("Indique el nombre de la decoración");
        double price = askInfoDouble("Indique el precio");
        String material = askInfoString("Indique si el material es plástico o madera");
        int code= askInfoInt("Indique el código");

        return new Decoration(name, price, material, code);

    }


    private static Flower addFlowerToFloristList(Flower flower, Florist florist ){
       florist.addFlowerToList(flower);
       return flower;
    }
    private static Tree addTreeToFloristList(Tree tree, Florist florist ){
        florist.addTreeToList(tree);
        return tree;
    }
    private static Decoration addDecorationToFloristList(Decoration decoration, Florist florist ){
        florist.addDecorationToList(decoration);
        return decoration;
    }



    //Método que transforma los datos de un objeto en String para guardarlo en la base de datos txt

    private static String dataConvert (){
        String info;
        Flower fl= florist.getFlowerList().get(0);
        info = fl.getCode() + fl.getName() + fl.getPrice() + fl.getColor();
        return info;
    }



    //Método para escribir ficheros de texto

    private static void writeFile(String info) throws IOException {

        try {
            File file = new File(DIRECTORY);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(DIRECTORY);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(info);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



/////////MÉTODOS ENTRADA DE DATOS

    private static int askInfoInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextInt();
    }

    private static String askInfoString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    private static double askInfoDouble(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextDouble();
    }

}


