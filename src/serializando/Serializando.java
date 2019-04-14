package serializando;

import java.util.Date;
import java.util.GregorianCalendar;

public class Serializando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Empleado {
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