public class Circulo {
    private double radio;
    public Circulo(double radio){
        this.radio=Math.max(radio,0);
    }
    public double getRadio(){
        return this.radio;
    }
    public double getArea(){
        return this.radio*this.radio*Math.PI;
    }
}
