package PRACTICA_11;

public class Principal {

	public static void main(String[] args) {
		//SIMULAR FECHAS
		Fecha fecha1=new Fecha();
		Fecha fecha2=new Fecha(30,12,2024);
		Fecha fecha3=new Fecha(01,1,2006);
		Fecha fecha4=new Fecha(14,8,2024);
		
		fecha1.anterior();
		fecha2.anterior();
		fecha3.anterior();
		fecha4.anterior();
		System.out.println("-------------------------------");
		System.out.println(fecha1.bisiesto());
		System.out.println(fecha2.bisiesto());
		System.out.println(fecha3.bisiesto());
		System.out.println(fecha4.bisiesto());
		System.out.println("--------------------------------");
		fecha1.largo();
		fecha2.largo();
		fecha3.largo();
		fecha4.largo();
		System.out.println("--------------------------------");
		fecha1.corta();
		fecha2.corta();
		fecha3.corta();
		fecha4.corta();
		System.out.println("----------------------------------");
		fecha1.fechaTras(5000);
		fecha2.fechaTras(10);
		fecha3.fechaTras(365);
		fecha3.fechaTras(600);
		System.out.println("----------------------------------");
		System.out.println(fecha1.diasTranscurridos());
		System.out.println(fecha2.diasTranscurridos());
		System.out.println(fecha3.diasTranscurridos());
		System.out.println(fecha4.diasTranscurridos());
		System.out.println("----------------------------------");
		System.out.println(fecha1.mayorQue(fecha2));
		System.out.println(fecha2.menorQue(fecha3));
	}
}
