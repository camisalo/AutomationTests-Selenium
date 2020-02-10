import com.beampro.test.CalculationTest;
import org.junit.jupiter.api.Test;

public class BeamProCalculationTest {


    @Test
    public void checkSteelChangeTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.changeSteel();
        test.close();
    }

    @Test
    public void checkConcreteChangeTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.changeConcrete();
        test.close();
    }

    @Test
    public void takeMaxMomentTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.takeMaxMoment();
        test.close();
    }

    @Test
    public void bendingCalculationTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.checkBendingCalculations();
        test.close();
    }

    @Test
    public void checkDecreasingBarNumberTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.checkDecreasingBarNumber();
        test.close();
    }

    @Test
    public void checkMaxVerticalForceTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.takeMaxVerticalForce();
        test.close();
    }

    @Test
    public void checkVerticalCalcTest() throws InterruptedException {
        CalculationTest test = new CalculationTest();
        test.checkVertivalCalc();
        test.close();
    }
}
