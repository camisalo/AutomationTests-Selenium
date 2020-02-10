

import com.beampro.test.StaticTest;
import org.junit.jupiter.api.Test;


public class BeamProStaticTests {

    @Test
    public void checkalCulationTest() throws InterruptedException {
        StaticTest test = new StaticTest();
        test.changeLenghtTest();
        test.close();
    }

    @Test
    public void addConstantLoadTest() throws InterruptedException {
        StaticTest test = new StaticTest();
        test.addLoadConstTest();
        test.close();
    }

    @Test
    public void removeConstantLoadTest() throws InterruptedException {
        StaticTest test = new StaticTest();
        test.removeLoadConstTest();
        test.close();
    }

    @Test
    public void addVariableLoadTest() throws InterruptedException {
        StaticTest test = new StaticTest();
        test.addLoadVarTest();
        test.close();
    }

    @Test
    public void removeVariableLoadTest() throws InterruptedException {
        StaticTest test = new StaticTest();
        test.removeLoadVarTest();
        test.close();
    }
}
