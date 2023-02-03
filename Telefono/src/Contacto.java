import java.util.ArrayList;
import java.util.Scanner;

public class Contacto {
    private String name;
    private String phoneNumber;
    public Contacto (String name, String phoneNumber){
        this.name= name;
        this.phoneNumber= phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public static Contacto createContact(String name, String phoneNumber){
        return new Contacto(name, phoneNumber);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
class TelefonoMovil {
    private String myNumber;
    public static ArrayList<Contacto> myContacts= new ArrayList<Contacto>();
    public TelefonoMovil (String myNumber){
        this.myNumber= myNumber;
    }
    private static int findContact (Contacto obj){
        return myContacts.indexOf(obj);
    }
    private static int findContact (String nombre){
        int resultado=0;
        for(int i=0; i<myContacts.size(); i++){
            if(myContacts.get(i).getName().equalsIgnoreCase(nombre)){
                resultado= i;
            }else{
                resultado= -1;
            }
        }
        return resultado;
    }
    public static boolean addNewContact(Contacto obj){
        if(findContact(obj)==-1){
            myContacts.add(obj);
            return true;
        }else {
            return false;
        }
    }
    public static boolean updateContact (Contacto nuevo, Contacto ant){
        boolean respuesta;
        if (findContact(ant)>=0){
            myContacts.set(findContact(ant),nuevo);
            respuesta=true;
        }else {
            respuesta=false;
        }
        return respuesta;
    }
    public static boolean removeContact (Contacto obj){
        boolean respuesta;
        if(findContact(obj)>=0){
            myContacts.remove(obj);
            respuesta=true;
        }else {
            respuesta= false;
        }
        return respuesta;
    }
    public static Contacto queryContact (String name){
        if(findContact(name)!=-1){
            return myContacts.get(findContact(name));
        }else{
            return null;
        }
    }
    public static void printContacts(){
        for(int i=0; i<myContacts.size(); i++){
            System.out.println(myContacts.get(i).getName()+ " "+ myContacts.get(i).getPhoneNumber());
            //System.out.println(myContacts.get(i).toString());
        }
    }
}
class Main{
    public static void main (String[] args) {
        boolean continuar=true;
        do {
            System.out.println("""
                    Menú:
                    0-Salir
                    1-Imprime tus contactos
                    2-Añadir nuevo contacto
                    3-Actualizar contacto existente
                    4-Eliminar contacto
                    5-Buscar contacto
                    6-Volver a imprimir menú
                    """);
            Scanner scan = new Scanner(System.in);
            int menu = scan.nextInt();
            switch (menu) {
                case 0: {
                    continuar=false;
                    System.out.println("Ha salido");
                    break;
                }
                case 1: {
                    System.out.println("Lista de contactos:"+"\n");
                    TelefonoMovil.printContacts();
                    break;
                }
                case 2: {
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Introduce el nombre del nuevo contacto:");
                    String nombre = scan1.next();
                    boolean error;
                    do {
                        error=false;
                        try {
                            System.out.println("Introduce el número de móvil");
                            String numero = scan1.next();

                            if (!numero.matches("[0-9]{9}")){
                                error=true;
                                throw new Exception("Solo se pueden introducir números en el campo del móvil");
                            }
                            TelefonoMovil.addNewContact(Contacto.createContact(nombre, numero));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }while (error==true);
                    break;
                }
                case 3: {
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Introduce el nombre del contacto a actualizar");
                    String nomAnt = scan2.next();
                    if (TelefonoMovil.queryContact(nomAnt) == null) {
                        System.out.println("El contacto no existe");
                    } else if (TelefonoMovil.queryContact(nomAnt)!=null){
                        System.out.println(TelefonoMovil.queryContact(nomAnt));
                        System.out.println("Introduce el nuevo nombre del contacto:");
                        String nombre = scan2.next();
                        boolean error;
                        do {
                            error=false;
                            try {
                            System.out.println("Introduce el nuevo número de móvil");
                            String numero = scan2.next();
                            TelefonoMovil.updateContact(Contacto.createContact(nombre,numero), TelefonoMovil.queryContact(nomAnt));
                            System.out.println("Contacto actualizado con éxito");
                            if (!numero.matches("[0-9]{9}")){
                                error=true;
                                throw new Exception("Solo se pueden introducir números en el campo del móvil");
                            }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }while (error==true);
                    }
                    break;
                }
                case 4: {
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Introduce el nombre del contacto a eliminar:");
                    String nombre = scan3.next();
                    if (TelefonoMovil.queryContact(nombre) != null) {
                        TelefonoMovil.removeContact(TelefonoMovil.queryContact(nombre));
                        System.out.println("Contacto eliminado con éxito");
                    }else {
                        System.out.println("El contacto no existe, no puede ser eliminado");
                    }
                    break;
                }
                case 5: {
                    Scanner scan4 = new Scanner(System.in);
                    System.out.println("Introduce el nombre del contacto a buscar:");
                    String nombre = scan4.next();
                    if (TelefonoMovil.queryContact(nombre) != null) {
                    System.out.println(TelefonoMovil.queryContact(nombre).getName()+" "+TelefonoMovil.queryContact(nombre).getPhoneNumber());
                    }else {
                        System.out.println("El contacto no existe, no puede ser eliminado");
                    }
                    break;
                }
                case 6: {
                    Main.main(null);
                    break;
                }
            }
        }while (continuar);
    }
}
