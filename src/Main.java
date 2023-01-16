public class Main {
    public static void main(String [] args){
        Circulo C=new Circulo(8.2);
        Cilindro A=new Cilindro(5.4,7.3);
        Cilindro B=new Cilindro(2.5,4.6);
        System.out.println(C.getRadio()+"\n"+C.getArea());
        System.out.println(B.getRadio()+"\n"+B.getArea()+"\n"+B.getAltura()+"\n"+B.getVolumen());
        System.out.println(A.getRadio()+"\n"+A.getArea()+"\n"+ A.getAltura()+"\n"+A.getVolumen());
    }
}
