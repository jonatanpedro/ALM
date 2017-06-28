package arquiteto.helper;

public class Data {
	private int dia, mes,ano;
	
	public Data(int dia, int mes, int ano) {
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
	}

	public boolean anoBissexto() {
		return (ano%4==0 && ano%100!=0) || (ano%400==0);
	}
}
