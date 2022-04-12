//These classes are used by custom configurable elements.
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
public class JaninesSleep extends ActionElementBase implements ElementInterface 
{
	// This method returns the name of the action element that appears in Studio's Element view
    public String getElementName()
    {
        return "Sleep";
    }
	// This method returns the name of a folder that will contain the action element 
	// in Studio's Element view. Use return null if you don't want it in a folder.
    public String getDisplayFolderName()
    {
        return "Janines Elements";
    }
	// This method returns a description of the element that will display in Studio
	// when the cursor hovers over the element in the Element view
    public String getDescription() 
    {
        return "Sleep (delay) for a number of seconds\n";
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
		 settingArray[0] = new Setting("sleep", "Sleep seconds", 
						   "The number of seconds to delay (integer value)",
						   true,   // It is required
						   true,   // It appears only once
						   false,   // It does not allow substitution
						   Setting.INT);
		 settingArray[0].setDefaultValue("10");
		return settingArray;
	 }

	/**
	 * This method returns an array of ElementData created by the element.
	 * It is not used in CVP 3.1, but is used in CVP4. This method should return null 
	 * if the action element does not create any Element Data.
	 */
    public ElementData[] getElementData() throws ElementException 
    {
        return null;
    }
    
	/**
	 * This is the run time code, executed by CVP VXML Server when it reaches the element 
	 * in the call flow. 
	 */
	public void	doAction(String name, ActionElementData actionData) throws AudiumException
	{    	
		try {
			
			
			

		} catch (Exception e) {
			//If anything goes wrong, create Element data 'status' with the value 'failure'
			//and return an empty string into the variable requested by the caller
		}
	}

}
