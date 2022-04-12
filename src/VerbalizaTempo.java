//These classes are used by custom configurable elements.
import java.util.ArrayList;

import com.audium.server.AudiumException;
import com.audium.server.voiceElement.ActionElementBase;
import com.audium.server.voiceElement.ElementInterface;
import com.audium.server.voiceElement.Setting;
import com.audium.server.voiceElement.ElementData;
import com.audium.server.voiceElement.ElementException;
import com.audium.server.xml.ActionElementConfig;

// This class is used by action elements.
import com.audium.server.session.ActionElementData;

/**
 * This is the skeleton of a configurable action element. This is different 
 * from a standard action in that it is pre-built and the developer 
 * configures it in Studio. The methods implemented here 
 * apply primarily to define the display in Studio.
 */
public class VerbalizaTempo extends ActionElementBase implements ElementInterface 
{
	ArrayList<String> strLista = new ArrayList<String>();
	String[] strArray; //Array de String's utilizado para armazenar o resultado da String após a aplicação do método Split
 	String strRetorno; //String que retornará no final o valor referente aos .wav. 	
 	String aux;
	
public void RetornaString(String strMomento) {
		
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

 	
	// This method returns the name of the action element that appears in Studio's Element view
    public String getElementName()
    {
        return "WittelSayTime";
    }
	// This method returns the name of a folder that will contain the action element 
	// in Studio's Element view. Use return null if you don't want it in a folder.
    public String getDisplayFolderName()
    {
        return "Wittel";
    }
	// This method returns a description of the element that will display in Studio
	// when the cursor hovers over the element in the Element view
    public String getDescription() 
    {
        return "Componente responsável por retornar um ArrayList de Strings para verbalizar o tempo\n";
    }
    
    //This method returns the settings to display in the element's configuration view
	public Setting[] getSettings() throws ElementException 
	 {	
	 	 //You must define the number of settings here
		 Setting[] settingArray = new Setting[1];
		 
       	//each setting must specify: real name, display name, description,
       	//is it required?, can it only appear once?, does it allow substitution?,
       	//and the type of entry allowed
       	
       	//Note that the settingArray starts indexing at 0
		 settingArray[0] = new Setting("Hora", "Hora", 
				   "Representa a hora que será passada no formato HH:MM",
				   true,   // It is required
				   true,   // It appears only once
				   true,   // It does not allow substitution
				   Setting.STRING);
		 		 
		return settingArray;
	 }
   

	/**
	 * This method returns an array of ElementData created by the element.
	 * It is not used in CVP 3.1, but is used in CVP4. This method should return null 
	 * if the action element does not create any Element Data.
	 */
    public ElementData[] getElementData() throws ElementException 
    {
    	
    	
    	// As duas linhas abaixo estavam comentadas.
    	ElementData[] elementDataArray = new ElementData[6];
       
    	elementDataArray[0] = new ElementData("retorno0", "O Valor da Hora");
    	elementDataArray[1] = new ElementData("retorno1", "A string Hora ou horas.wav");
    	elementDataArray[2] = new ElementData("retorno2", "O e.wav");
    	elementDataArray[3] = new ElementData("retorno3", "O valor dos minutos");
    	elementDataArray[4] = new ElementData("retorno4", "A palavra minuto ou minutos");
    	elementDataArray[5] = new ElementData("isretornavazio", "The result of the decision");
    	
    	
        return elementDataArray;
    	
    }
    
	/**
	 * This is the run time code, executed by CVP VXML Server when it reaches the element 
	 * in the call flow. 
	 */
	public void	doAction(String name, ActionElementData actionData) throws AudiumException
	{    	
		try {
			
			// Get the configuration
			ActionElementConfig config = actionData.getActionElementConfig();
						
			//now retrieve each setting value using its 'real' name as defined in the getSettings method above
			//each setting is returned as a String type, but can be converted.
			String s = config.getSettingValue("Hora",actionData);
			RetornaString(s);
			
			for(int i = 0; i<strLista.size(); i++ ){	
				actionData.setElementData("retorno"+i, strLista.get(i) );
			}
			
			

		} catch (Exception e) {
			//If anything goes wrong, create Element data 'status' with the value 'failure'
			//and return an empty string into the variable requested by the caller
		}
	}

}
