public class Forma {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public double area() {
        return 0;
    }

    public Forma(String nombre) {
        this.nombre = nombre;
    }
}

    class esfera extends Forma{
        private double radio;
        public esfera(double radio){
            super("esfera");
            this.radio=radio;
        }

        @Override
        public String toString() {
            return "esfera{" +
                    "nombre='" + getNombre() + '\'' +
                    ", radio=" + radio +
                    '}';
        }

        @Override
        public double area() {
            return super.area()+Math.pow(this.radio, 2)*Math.PI*4;
        }
    }
    class rectangulo extends Forma{
        private double longuitud;
        private double ancho;
        public rectangulo(double longuitud, double ancho){
            super("rectángulo");
            this.longuitud= longuitud;
            this.ancho= ancho;
        }

        @Override
        public String toString() {
            return "rectangulo{" +
                    "nombre='" + getNombre() + '\'' +
                    ", longuitud=" + longuitud +
                    ", ancho=" + ancho +
                    '}';
        }

        @Override
        public double area() {
            return super.area()+this.ancho*this.longuitud;
        }
    }
    class cilindro extends Forma{
        private double radio;
        private double altura;
        public cilindro(double radio, double altura){
            super("cilindro");
            this.radio=radio;
            this.altura=altura;
        }

        @Override
        public String toString() {
            return "cilindro{" +
                    "nombre='" + getNombre() + '\'' +
                    ", radio=" + radio +
                    ", altura=" + altura +
                    '}';
        }

        @Override
        public double area() {
            return super.area()+Math.PI*Math.pow(this.radio, 2)*this.altura;
        }
    }
    class pintura{
        private double cobertura;
        public pintura(double cobertura){
            this.cobertura=cobertura;
        }
        public double cantidadPintura(Forma obj){
            return obj.area()/this.cobertura;
        }
    }

    class Main{
    public static void main (String [] args){
        pintura color= new pintura(250);
        rectangulo rectanguloObj= new rectangulo(20, 35);
        esfera esferaObj= new esfera(15);
        cilindro cilindroObj= new cilindro(10, 30);
        System.out.println(color.cantidadPintura(rectanguloObj));
        System.out.println(color.cantidadPintura(esferaObj));
        System.out.println(color.cantidadPintura(cilindroObj));
    }
}

