import java.util.ArrayList;

/**
 * @author: Bruno Justino
 * @date: 01-10-2013
 * Essa classe recebe como parâmetro uma String "HH:MM" e retorna um ArrayList de String.
 * O array list será carregado de acordo com o exemplo: "10.wav horas. e.wav 23.wav minutos.wav".
 * A seguinte classe trata também algumas variações na String (Ex: 00:00 - 01: - :01 - 0:0)  
 */

public class RetornaString{
	
	ArrayList<String> strLista = new ArrayList<String>();
	String[] strArray; //Array de String's utilizado para armazenar o resultado da String após a aplicação do método Split
 	String strRetorno; //String que retornará no final o valor referente aos .wav. 	
	
	public RetornaString(String strMomento) {
		
		//Atribui à uma variável global o valor da String passada como parâmetro
		strRetorno = strMomento;  
		
		if(strMomento.contains(":")){
			
			//Verifica o método que será chamado de acordo com a posição dos ":"
			if(strMomento.startsWith(":")){
				ApenasMinutos();
			}else if(strMomento.endsWith(":")){
				ApenasHoras();
			}else {
				Padrao();
			}
			
		}else{
			ApenasMinutos();
		}		
	}
	
	
	public ArrayList Padrao(){
				   
		//Pega-se a String passada como parâmetro e guarda em um array global de String.
		strArray = strRetorno.split(":");  
			
		//Verifica a primeira parte do Array
		if(strArray[0].length()== 0){
		strArray[0] = "00"+strArray[0];
		}
		
		//Acrescenta um 0 na primeira parte do Array
		if(strArray[0].length()== 1){
		strArray[0] = "00"+strArray[0];
		}
		
		//Acrescenta um 0 na primeira parte do Array
		if(strArray[0].length()== 2){
		strArray[0] = "0"+strArray[0];
		}
		
		//Acrescenta um 0 na segunda parte do Array
		if(strArray[1].length()==1){
		strArray[1] = "00"+strArray[1];
		}
		
		//Acrescenta um 0 na segunda parte do Array
		if(strArray[1].length()==2){
		strArray[1] = "0"+strArray[1];
		}
		
		//Verifa se o 0 está na primeira parte do array. 
		if((strArray[0].equals("00"))||(strArray[0].equals("000"))||(strArray[0].equals("0"))){
			ZeroNoInicio();
		}else if( strArray[1].equals("0")||(strArray[1].equals("00")||strArray[1].equals("000") )) {
			HoraExata();
		}else{
			Normal();
		}
				
		return strLista;
		
	}
	
	public ArrayList HoraExata(){
		
		
		
		strRetorno = strArray[0]+".wav - "+HoraHoras()+".wav - ";
		
		strLista.add(strArray[0]+".wav");
		strLista.add(HoraHoras()+".wav");
		
		return strLista;
			
	}
	
	public ArrayList Normal(){
		
		strRetorno = strArray[0]+".wav - "+HoraHoras()+".wav - " + "e.wav - " + strArray[1]+".wav - " +MinutoMinutos()+".wav";
		
		if (strArray[0].equals("00")||strArray[0].equals("0")||strArray[0].equals("000") ){
			strLista.add(strArray[0]+".wav");
			strLista.add(HoraHoras()+".wav");
		}else{		
		strLista.add(strArray[0]+".wav");
		strLista.add(HoraHoras()+".wav");
		strLista.add("e.wav");
		strLista.add(strArray[1]+".wav");
		strLista.add(MinutoMinutos()+".wav");
		}
		
		return strLista;
			
	}
	
	public ArrayList ZeroNoInicio(){
		
		if (strArray[1].equals("00")||strArray[1].equals("0")||strArray[1].equals("000") ){
		strLista.add("vazio.wav");
		}else{
		strLista.add(strArray[1]+".wav");
		strLista.add(MinutoMinutos()+".wav");
		}
		return strLista;
	}
	
	public ArrayList ApenasMinutos(){
		
		//Retira os : da String caso tenha :
		if(strRetorno.contains(":")){
			strRetorno = strRetorno.replace(":","");
		}
		
		if((strRetorno.equals("0")||strRetorno.equals("00")||strRetorno.equals("000"))){
			strLista.add("vazio.wav");
			
		}else{
		
		//Verifica o tamanho da String
		switch(strRetorno.length()){
		case 1 : strRetorno = "0"+strRetorno;
		case 2 : strRetorno = "0"+strRetorno;
		}
		
		strLista.add(strRetorno+".wav");
		strLista.add(MinutMinuts()+".wav");
		}
		return strLista;
	}
	
	public ArrayList ApenasHoras(){
		
		//Retira os : da String caso tenha :
		if(strRetorno.contains(":")){
		strRetorno = strRetorno.replace(":","");
		}
		
		if((strRetorno.equals("0")||strRetorno.equals("00")||strRetorno.equals("000"))){
		strLista.add("vazio.wav");
		}else{
		
		//Verifica o tamanho da String
		switch(strRetorno.length()){
		case 1 : strRetorno = "0"+strRetorno;
		case 2 : strRetorno = "0"+strRetorno;
		}
		
		strLista.add(strRetorno+".wav");
		strLista.add(HourHours()+".wav");
		}
		
		return strLista;
		
	}
	
	
	//Método para verificar o retorno da palavra hora ou horas.wav
	public String HoraHoras(){
		if(   (strArray[0].equals("001"))||(strArray[0].equals("1")) ){
			return "Hora";
		}else{
			return "Horas";
		}
	}
	
	//Método para verificar o retorno da palavra minuto ou minutos.wav
	public String MinutoMinutos(){
		if(   (strArray[1].equals("001"))||(strArray[1].equals("1"))||(strArray[1].equals("01")) ){
			return "Minuto";
		}else{
			return "Minutos";
		}
	}
	
	//Método para verificar o retorno da palavra minuto ou minutos.wav
	public String MinutMinuts(){
		if( (strRetorno.equals("1") || strRetorno.equals("01") || strRetorno.equals("001"))){
			return "Minuto";
		}else{
			return "Minutos";
		}
	}
	
	//Método para verificar o retorno da palavra minuto ou minutos.wav
	public String HourHours(){
		if( (strRetorno.equals("1") || strRetorno.equals("01") || strRetorno.equals("001"))){
			return "Hora";
		}else{
			return "Horas";
		}
	}
	
}
