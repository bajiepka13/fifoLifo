package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.*;

public class StackImplementationTest {
    private static ManagingClassTest common = new ManagingClassTest();
    private static ManagingClass stack = new StackImplementation();
    private final String[] INIT_DATA = common.fiveStringsArray;


    @Before
    public void setUp() throws Exception {
        stack.addValues(INIT_DATA);
    }

    @After
    public void tearDown() throws Exception {
        stack.clear();
    }

    @Test
    public void getFirst() throws Exception {
        final int LAST = INIT_DATA.length - 1;
        String firstStringInQueue;
        String firstStringInArray;

        firstStringInQueue = stack.getFirst().toString();
        firstStringInArray = INIT_DATA[LAST];

        assertEquals(firstStringInQueue, firstStringInArray);
    }

    @Test
    public void removeFirst() throws Exception {
        final int EXCLUDE_LAST = 1;
        boolean isDataEqualBeforeRemoveFirst = false;
        boolean isDataEqualAfterRemoveFirst = false;

        for (int i = 0; i < INIT_DATA.length - 1; i++) {
            if (stack.vault[i].equals(INIT_DATA[i])) {
                isDataEqualBeforeRemoveFirst = true;
            } else {
                isDataEqualBeforeRemoveFirst = false;
                break;
            }
        }

        stack.removeFirst();

        for (int i = 0; i < INIT_DATA.length - EXCLUDE_LAST; i++) {
            if (stack.vault[i].equals(INIT_DATA[i])) {
                isDataEqualAfterRemoveFirst = true;
            } else {
                isDataEqualAfterRemoveFirst = false;
                break;
            }
        }

        assertTrue(isDataEqualBeforeRemoveFirst & isDataEqualAfterRemoveFirst);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        common = null;
        stack = null;
    }

}
