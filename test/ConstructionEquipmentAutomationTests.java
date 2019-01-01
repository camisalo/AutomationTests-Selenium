import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class ConstructionEquipmentAutomationTests {

    @Test
    public void checkUserRegistration(){
        CheckUserRegistration test = new CheckUserRegistration();
        Boolean result = false;
        try {
            result = test.startTest();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void checkAddUserData(){
        CheckAddUserData test = new CheckAddUserData();
        String result = "";
        try {
            result = test.startTest();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals("123-456-32-18",result);
    }

    @Test
    public void checkAddJSONFile(){
        CheckAddJSONFile test = new CheckAddJSONFile();
        String result = "";
        try {
            result = test.startTest();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals("Sukces",result);
    }

    @Test
    public void checkSearchEngineWithAddedJSON(){
        CheckSearchEngineWithAddedJSON test = new CheckSearchEngineWithAddedJSON();
        String result = "";
        try {
            result = test.startTest();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals("Sukces",result);
    }

    @Test
    public void checkSearchEngine1(){
        CheckSearchEngine test = new CheckSearchEngine();
        String result = "";
        try {
             result = test.startTest1();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals("Minikoparka 980/1138 kg",result);
    }

    @Test
    public void checkSearchEngine2(){
        CheckSearchEngine test = new CheckSearchEngine();
        String result = "";
        try {
            result = test.startTest2();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        assertEquals("Niwelator optyczny TOPCON AT-B4",result);
    }
}
