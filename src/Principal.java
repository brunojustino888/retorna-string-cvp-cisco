
public class Principal {

	public static void main(String[] args){
		
		VerbalizaTempo2 um = new VerbalizaTempo2(); 
		um.RetornaString("10:");
		
		
		while(!um.strLista.isEmpty()){  
		    System.out.println(um.strLista.remove(0));  
		}  
		

		
	}
	
}
