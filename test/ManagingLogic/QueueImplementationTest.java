package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.*;

public class QueueImplementationTest {
    private static ManagingClassTest common = new ManagingClassTest();
    private static ManagingClass queue = new QueueImplementation();
    private final String[] INIT_DATA = common.INIT_DATA;


    @Before
    public void setUp() throws Exception {
        queue.addValues(INIT_DATA);
    }

    @After
    public void tearDown() throws Exception {
        queue.clear();
    }

    @Test(timeout = 1000)
    public void getFirst() throws Exception {
        final int FIRST = 0;
        String firstStringInQueue;
        String firstStringInArray;

        firstStringInQueue = queue.getFirst().toString();
        firstStringInArray = INIT_DATA[FIRST];

        assertEquals(firstStringInQueue, firstStringInArray);
    }

    @Test(timeout = 1000)
    public void removeFirst() throws Exception {
        final int EXCLUDE_FIRST = 1;
        boolean isDataEqualBeforeRemoveFirst = false;
        boolean isDataEqualAfterRemoveFirst = false;

        for (int i = 0; i < INIT_DATA.length - 1; i++) {
            if (queue.vault[i].equals(INIT_DATA[i])) {
                isDataEqualBeforeRemoveFirst = true;
            } else {
                isDataEqualBeforeRemoveFirst = false;
                break;
            }
        }

        queue.removeFirst();

        for (int i = 0; i < INIT_DATA.length - 1; i++) {
            if (queue.vault[i].equals(INIT_DATA[i + EXCLUDE_FIRST])) {
                isDataEqualAfterRemoveFirst = true;
            } else {
                isDataEqualAfterRemoveFirst = false;
                break;
            }
        }

        assertTrue(isDataEqualBeforeRemoveFirst & isDataEqualAfterRemoveFirst);

    }

    @Test(expected = Exception.class, timeout = 1000)
    public void removeFirstOnEmptyCollection() throws Exception {
        queue.clear();
        queue.removeFirst();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        common = null;
        queue = null;
    }

}

