package PRACTICA_11;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Fecha {
	private final int [] diasMeses= {31,(bisiesto()?29:28),31,30,31,30,31,31,30,31,30,31};
	private final String [] DIA_SEMANA= {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"};
	private final String [] MESES_NOMBRE= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	private final Scanner lector=new Scanner(System.in);
	private int dia;
	private int mes;
	private int año;
	
	//AQUI VA EL PRIMER CONSTRUCTRO POR DETERMINADO
	public Fecha() {
		this.dia=01;
		this.mes=01;
		this.año=1900;
	}
	
	//EL SEGUNDO CONSTRUCTOR CON CONSTRUCTOR CON PARAMETRO
	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}
	
	//PRIMER METODO LEER
	public void leer() {
		System.out.println("Ingrese el dia (1 a 31): ");
		this.dia=lector.nextInt();
		System.out.println("Ingrese el mes (1 al 12: " );
		this.mes=lector.nextInt();
		System.out.println("Ingrese el año: (1900 a 2050)");
		this.año=lector.nextInt();
		
		if(!valida()) {
			System.out.println("Año incorrecto no se encuentra entre los rangos");
			this.dia=1;
			this.mes=1;
			this.año=1900;
		}
	}
	
	//METODO DE SI ES EL AÑO BICIESTO O NO
	public boolean bisiesto() {
		//METODO QUE JAVA IMPLEMETO EN JAVA 8 QUE DECIDE SI EL AÑO ES O NO ES BICIESTO
		return (Year.isLeap(this.año));
	}
	
	public int diasMes(int mes) {
		return 	(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==9 || mes==12)?31:
				(mes==4 || mes==6 || mes==9 || mes==11)?30
				:(mes==2 && bisiesto())?29:28;
	}
	
	private boolean valida() {
		return (this.dia<=31 && this.mes<=12 && this.año<=2050 && this.dia>=1 && this.mes>=1 && this.año>=1900);
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public void setAño(int año) {
		this.año = año;
	}
	
	public void corta() {
		System.out.printf("%02d-%02d-%04d%n",this.dia,this.mes,this.año);
	}
	
	public int diasTranscurridos() { 
		int contarBisiestos=0;
		int contarAñosNormales=0;
	
		for(int año=1900;año<this.año;año++) {
			contarBisiestos += (Year.isLeap(año)) ? 1 : 0;
		    contarAñosNormales += (!Year.isLeap(año)) ? 1 : 0;
		}
		return (contarBisiestos*366)+(contarAñosNormales*365);
	}
	
	public String diaSemana() {
		//DIAS DE LA SEMANA SON 7 DIAS
		int dia = this.dia % 7;
		//SI EL DIA CON MOD DA 0 ENTONCES REINICIAMOS EL DIA
		if(dia==0) {
			dia=6;
		}
		return DIA_SEMANA[dia];
	}
	
	public void largo() {
		System.out.printf("%s %02d De %s de %04d%n",diaSemana(),this.dia,MESES_NOMBRE[this.mes-1],this.año);
	}
	
	public void fechaTras(long dias) {
		this.dia=1;
		this.mes=1;
		this.año=1900;
		
		while(dias>=(bisiesto()?366:365)) {
			dias-=(bisiesto()?366:365);
			this.año++;
		}
		
		while(dias>=diasMeses[this.mes-1]) {
			this.mes++;
			dias-=diasMeses[this.mes-1];
			if(mes>12) {
				this.mes=1;
				this.año++;
			}
		}
		this.dia+=dias;
		corta();
	}
	
	public long diasEntre(Fecha otraFecha) {
		LocalDate inicio;
		LocalDate fin;
		
		boolean añoMayor=this.año>otraFecha.año;
		
		if(añoMayor) {
			inicio=LocalDate.of(this.año,this.mes,this.dia);
			fin=LocalDate.of(otraFecha.año,otraFecha.mes,otraFecha.dia);
		}
		else{
			inicio=LocalDate.of(otraFecha.año,otraFecha.mes,otraFecha.dia);
			fin=LocalDate.of(this.año,this.mes,this.dia);
		}
		
		long dias=ChronoUnit.DAYS.between(inicio,fin);
		return dias;
	}
	
	public void siguente() {
		//CONDICIONAMOS SI EL DIA ES MENOR AL MES CON EL FINAL DEL DIA
		//EJEMPLO: SI(28 DE FEBRRO < 29 FEBRERO) ENTONCES DIA +1
		if(this.dia<diasMeses[this.mes-1]) {
			this.dia++;
		}
		//CONDICIONAMOS CON EL FALSO EMPEZAMOS PONIENDO AL DIA 1 POR QUE EL MES COMIENZA ASI
		//Y CONDICIONAMOS SI EL MES ES MENOR A 12 DE DICIEMBRE AL MES +1 Y SI NO PUES EL MES COMIENZA EN 1 Y COMIENZA CON OTRO AÑO
		else {
			this.dia=1;
			if(this.mes<12) {
				this.mes++;
			}
			else {
				this.mes=1;
				this.año++;
			}
		}
		//MOSTRAMOS LA FECHA CON LA FUNCION YA HECHA
		corta();
	}
	
	public void anterior() {
		//CONDICIONAMOS SI EL DIA ES MAYOR A 1 EJEMPLO: 01 DE ENERO, NO ES MAYOR A UNO LO QUE SE PASA
		//AL SIGUENTE BLOQUE TIENEN QUE SER MAYOR A 1 SIN CONTAR A EL 2,3,4,5,6,7,8,9
		if(this.dia>1) {
			this.dia--;
		}
		else {
			//SI EL MES ES MAYOR 1 MES -1 Y EL MES LE PONERMOS AL FIN DEL MES CORREPONDIENTE
			if(this.mes>1) {
				this.mes--;
				//EL FIN DEL DIA DEL MES CORRESPONDIENTE
				this.dia=diasMeses[this.mes-1];
			}
			else {
				//Y SI LA FECHA ERA 1 DE ENERO PUES SOLO LE OTROGAMOS ESTOS DATOS
				this.dia=31;
				this.mes=12;
				this.año--;
			}
		}
		corta();
	}
	
	public void copia() {
		int dia=this.dia;
		int mes=this.mes;
		int año=this.año;
		System.out.println("SE ACABA DE COPIAR\n");
		System.out.printf("%02d-%02d-%04d%n",dia,mes,año);
	}
	
	public boolean igualQue(Fecha otraFecha) {
		//MOSTRAMOS TRUE SI SE CUMPLE ESTO
		return this.año==otraFecha.año && this.mes==otraFecha.mes && this.dia==otraFecha.dia;
	}
	
	public boolean menorQue(Fecha otraFecha) {
				//SI AÑO ES MENOR AÑO COMPARAR==SI ES MENOR(TRUE)
											//SI EL AÑO ES IGUAL AL AÑOCOM Y EL MES ES MENOR AL MESCOM==SI ES MENOR(TRUE)
		return this.año<otraFecha.año || (this.año==otraFecha.año && this.mes<otraFecha.mes)||
				//SI EL AÑO ES IGUAL AÑOCOM Y EL MES ES IGUAL AL MESCOM Y EL DIA ES MENOR AL DIACOM==SI ES MENOR(TRUE)
				(this.año==otraFecha.año && this.mes==otraFecha.mes && this.dia<otraFecha.dia);
	}
	public boolean mayorQue(Fecha otraFecha) {
		return this.año>otraFecha.año || (this.año==otraFecha.año && this.mes>otraFecha.mes) || (this.año==otraFecha.año && this.mes==otraFecha.mes && this.dia>otraFecha.dia);
	}
}
