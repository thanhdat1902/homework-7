import flyweight.FlyweightTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import proxy.ProxyTest;

@Suite
@SelectClasses({FlyweightTest.class, ProxyTest.class})
public class CompleteUnitTest {
}
