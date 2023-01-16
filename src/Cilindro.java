public class Cilindro extends Circulo{
    private double altura;
    public Cilindro(double radio, double altura){
        super(radio);
        this.altura=Math.max(altura,0);
    }
    public double getAltura(){
        return this.altura;
    }
    public double getVolumen(){
        return getAltura()*getArea();
    }
}
