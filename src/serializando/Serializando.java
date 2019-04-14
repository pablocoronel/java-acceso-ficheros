package serializando;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Administrador jefe = new Administrador("pablo", 25000, 2012, 05, 01);
		jefe.setIncentivo(5000);

		// en este ejemplo el array personal va a ser serializado
		Empleado[] personal = new Empleado[3];
		personal[0] = jefe;
		personal[1] = new Empleado("ana", 15000, 2015, 07, 12);
		personal[2] = new Empleado("marcelo", 20000, 2015, 05, 01);

		// serializacion:
		String ruta_almacenamiento = "C:\\Users\\Usuario\\eclipse-workspace\\Acceso_Ficheros\\src\\serializando\\empleado.dat";

		FileOutputStream salida;
		try {
			salida = new FileOutputStream(ruta_almacenamiento);

			// flujo de datos de salida (Stream)
			ObjectOutputStream fichero = new ObjectOutputStream(salida);

			// escritura del objeto ya serializado
			fichero.writeObject(personal);

			fichero.close();

			// recuprando el objeto serializado:
			FileInputStream entrada = new FileInputStream(ruta_almacenamiento);
			ObjectInputStream leyendo = new ObjectInputStream(entrada);

			// aca se obtiene lo guardado
			Empleado[] personal_recuperado = (Empleado[]) leyendo.readObject();

			leyendo.close();

			for (Empleado un_empleado : personal_recuperado) {
				System.out.println(un_empleado.toString());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

// implementa la interface Serializable
class Empleado implements Serializable {
	private String nombre;
	private double sueldo;
	private Date fechaContrato;

	public Empleado(String nombre, double sueldo, int anio, int mes, int dia) {
		this.nombre = nombre;
		this.sueldo = sueldo;

		GregorianCalendar calendario = new GregorianCalendar(anio, mes - 1, dia);
		this.fechaContrato = calendario.getTime();

	}

	public String getNombre() {
		return nombre;
	}

	public double getSueldo() {
		return sueldo;
	}

	public Date getFechaContrato() {
		return fechaContrato;
	}

	public void subirSueldo(double porcentaje) {
		double aumento = this.sueldo * (porcentaje / 100);

		this.sueldo += aumento;
	}

	// sobreescritura del metodo toString() de Object
	// este metodo sirve para dar una descripción de la clase
	public String toString() {
		return "Nombre= " + this.nombre + " Sueldo= " + this.sueldo + " Fecha de contrato= " + this.fechaContrato;
	}
}

class Administrador extends Empleado {
	private double incentivo;

	public Administrador(String nombre, double sueldo, int anio, int mes, int dia) {
		super(nombre, sueldo, anio, mes, dia);
		this.incentivo = 0;
	}

	@Override
	public double getSueldo() {
		// TODO Auto-generated method stub
		double sueldoBase = super.getSueldo();

		return sueldoBase + this.incentivo;
	}

	public void setIncentivo(double b) {
		this.incentivo = b;
	}

	@Override
	public String toString() {
		return super.toString() + "Administrador [incentivo=" + incentivo + "]";
	}

}