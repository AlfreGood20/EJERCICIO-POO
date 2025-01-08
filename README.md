## 😬ENUNCIADO

Crea una clase Fecha con atributos para el día, el mes y el año de la fecha.
Incluye, al menos, los siguientes métodos:

 Constructor predeterminado con el 1-1-1900 como fecha por defecto.

 Constructor parametrizado con día, mes y año.

 leer(): pedirá al usuario el día (1 a 31), el mes (1 a 12) y el año (1900 a 2050).

 bisiesto(): indicará si el año de la fecha es bisiesto o no.

 diasMes(int): devolverá el número de días del mes que se le indique
(para el año de la fecha).

 valida(): comprobará si la fecha es correcta (entre el 1-1-1900 y el 31-12-2050);
si el día no es correcto, lo pondrá a 1; si el mes no es correcto, lo pondrá a 1;
y si el año no es correcto, lo pondrá a 1900. Será un método auxiliar (privado).
Este método se llamará en el constructor parametrizado y en leer().

 Accedentes y mutadores.

 corta(): mostrará la fecha en formato corto (02-09-2003).

 diasTranscurridos(): devolverá el número de días transcurridos
desde el 1-1-1900 hasta la fecha.

 diaSemana(): devolverá el día de la semana de la fecha (0 para domingo, ..., 6 para sábado). El 1-1-1900 fue domingo.

 larga(): mostrará la fecha en formato largo, empezando por el día de la semana (martes 2 de septiembre de 2003).

 fechaTras(long): hará que la fecha sea la correspondiente a haber transcurrido los días que se indiquen desde el 1-1-1900.

 diasEntre(Fecha): devolverá el número de días entre la fecha y la proporcionada.

 siguiente(): pasará al día siguiente.

 anterior(): pasará al día anterior.

 copia(): devolverá un clon de la fecha.

 igualQue(Fecha): indica si la fecha es la misma que la proporcionada.

 menorQue(Fecha): indica si la fecha es anterior a la proporcionada.

 mayorQue(Fecha): indica si la fecha es posterior a la proporcionada. 
