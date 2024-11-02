import java.time.LocalDate;
import java.time.Month;

public class Concesionario
{
    private static String fichaCoche(MasNulos.Coche coche) {
        String ficha = "";
        if (coche != null) {
            MasNulos.Titular prop = coche.getPropieraria();
            if (prop != null) {
                LocalDate nac = prop.getFechaNac();
                if (nac != null) {
                    ficha += "Nacida en " + nac.getYear() + ", ";
                }
                ficha += prop.getNombre() != null ? prop.getNombre() : "Nadie";
            } else {
                ficha += "El concesionario";
            }
            ficha += " es titular del coche ";
            ficha += coche.getMatricula() != null ? coche.getMatricula() :
                    " sin matricular";
        }
        return ficha + ".";
    }

    public static void main(String[] args) {
        Titular laura = new Titular("Laura",
                LocalDate.of(1994, Month.JUNE, 30));
        Coche bueno = new Coche("1234 BCD", laura);
        System.out.println(fichaCoche(bueno));

        Coche nulo = null;
        System.out.println(fichaCoche(nulo));

        Coche nuevo = new Coche(null, null);
        System.out.println(fichaCoche(nuevo));

        Coche vendido = new Coche(null, new Titular(null, null));
        System.out.println(fichaCoche(vendido));

        Coche yaSi = new Coche(null, new Titular(null, LocalDate.now()));
        System.out.println(fichaCoche(yaSi));
    }
}

class Titular {
    private String nombre;
    private LocalDate fechaNac;

    public Titular(String nombre, LocalDate fechaNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
}

class Coche {
    private String matricula;
    private Persona propietaria;

    public Coche(String matr, Persona prop) {
        matricula = matr;
        propietaria = prop;
    }

    public String getMatricula() {
        return matricula;
    }
    public Persona getPropietaria() {
        return propietaria;
    }
}