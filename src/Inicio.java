import java.util.ArrayList;
import java.util.*;

public class Inicio {
    static ArrayList<Nacional> listaNacionales = new ArrayList<>();
    static ArrayList<Importado> listaImportados = new ArrayList<>();
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {

        listaImportados.add(new Importado("tetero", 123, "TE123"));
        listaNacionales.add(new Nacional("pañales", 321,"PA321"));

        while (true){
            System.out.print("Selecciona la accion que deseas realizar"+
                    "\n[1] Registrar producto Nacional"+
                    "\n[2] Registrar producto Importado"+
                    "\n[3] Revisar lista de productos Nacionales"+
                    "\n[4] Revisar lista de productos Importados"+
                    "\n[5] Buscar producto Nacional"+
                    "\n[6] Buscar producto Importado"+
                    "\nAcción --> ");

            int eleccion = scn.nextInt();

            if (eleccion == 1){
                rPrtoNacional();
            }
            else if (eleccion == 2){
                rPrtoImportados();
            }
            else if(eleccion == 3){
                lPrtoNacioanles();
            }
            else if (eleccion == 4){
                lPrtoImportados();
            } else if (eleccion == 5 ) {
                bPrtNacional();
            } else if (eleccion ==6) {
                bPrtImportado();
            }
            else {
                scn.close();
                break;
            }
        }


    }

    static public void rPrtoNacional() {

        System.out.print("\nIngrese el nombre del producto:");
        String nombre = scn.next();
        System.out.print("\nIngrese el codigo del producto: ");
        int codigo = scn.nextInt();
        System.out.print("\nIngrese el registro DIAN: ");
        String rDIAN = scn.next();

        listaNacionales.add(new Nacional(nombre, codigo, rDIAN));

    }
    static public void  rPrtoImportados(){

        System.out.print("\nIngrese el nombre del producto:");
        String nombre = scn.next();
        System.out.print("\nIngrese el codigo del producto: ");
        int codigo = scn.nextInt();
        System.out.print("\nIngrese la licencia de importacion: ");
        String lImport = scn.next();

        listaImportados.add(new Importado(nombre, codigo, lImport));
    }


    public static void lPrtoNacioanles() {

        System.out.println("Lista productos Nacionales: ");

        for (Nacional producto : listaNacionales) {
            System.out.println("Nombre: " + producto.getNombre() + ", Codigo: " + producto.getCodigo() + ", R. DIAN: " + producto.registroDIAN);
            System.out.println();
        }

    }

    public static void lPrtoImportados(){
        System.out.println("Lista productos Importados: ");

        for (Importado producto: listaImportados){
            System.out.println("Nombre: " + producto.getNombre() + ", Codigo: "+producto.getCodigo() + ", L. Import: "+ producto.licenciaImportacion);
            System.out.println();
        }
        System.out.println();
    }

    public static void bPrtNacional() {
        System.out.print("Ingrese el nombre del producto nacional que desea buscar: ");
        String nombreBuscado = scn.next();
        boolean encontrado = false;

        for (Nacional producto : listaNacionales) {
            if (producto.getNombre().equals(nombreBuscado)) {
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + producto.getNombre() + ", Codigo: " + producto.getCodigo() + ", R. DIAN: " + producto.registroDIAN);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }

        System.out.println();
    }

    public static void bPrtImportado() {
        System.out.print("Ingrese el nombre del producto importado que desea buscar: ");
        String nombreBuscado = scn.next();
        boolean encontrado = false;

        for (Importado producto : listaImportados) {
            if (producto.getNombre().equals(nombreBuscado)) { // o el metodo iqualsIgnoreCase
                System.out.println("Producto encontrado:");
                System.out.println("Nombre: " + producto.getNombre() + ", Codigo: " + producto.getCodigo() + ", L. Import: " + producto.licenciaImportacion);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
        System.out.println();
    }
}
