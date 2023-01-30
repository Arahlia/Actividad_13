import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int edad;
    private double altura;

    public Estudiante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public int compareTo(Estudiante obj) {
        int resultado = 0;
        if (this.altura > obj.altura) {
            resultado = -1;
        } else if (this.altura < obj.altura) {
            resultado = 1;
        } else if (this.edad > obj.edad) {
            resultado = -1;
        } else if (this.edad < obj.edad) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Patri", 12, 170));
        estudiantes.add(new Estudiante("Manuel", 43, 173));
        estudiantes.add(new Estudiante("Javier", 72, 189));
        estudiantes.add(new Estudiante("Alicia", 52, 168));
        estudiantes.add(new Estudiante("Alberto", 35, 189));
        for (Estudiante n : estudiantes) {
            System.out.println(n.toString());
        }

        Collections.sort(estudiantes);
        System.out.println("\n Lista ordenada: ");
        for (Estudiante n : estudiantes) {
            System.out.println(n.toString());
        }
    }
}
