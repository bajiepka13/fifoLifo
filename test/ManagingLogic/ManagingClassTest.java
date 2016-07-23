package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    static ManagingClass managing;
    int vaultInitSize;
    static String[] dataForTest = new String[]{
            "The First String",
            "The Second String",
            "The Third String",
            "The Fourth String",
            "The Fifth String",
            "The Sixth String"
    };

    @BeforeClass
    public static void setUpClass() throws Exception {
        managing = new ManagingClass() {
            @Override
            public Object getLast() {
                return null;
            }

            @Override
            public void removeLast() {
            }
        };
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        dataForTest = null;

    }

    @Before
    public void setUp() throws Exception {
        vaultInitSize = managing.vault.length;
        managing.addValues(dataForTest);
    }


    @Test
    public void vaultSizeChangedAfterAddValues() throws Exception {
        assertTrue(managing.vault.length == dataForTest.length + vaultInitSize);
    }

    @Test
    public void compareAfterAddValues() {
        boolean areStringsEqual = false;
        for (int i = 0; i < managing.vault.length - vaultInitSize; i++) {
            if (managing.vault[i].equals(dataForTest[i])) {
                areStringsEqual = true;
            } else {
                areStringsEqual = false;
                break;
            }
        }
        assertTrue(areStringsEqual);
    }

    @Ignore
    @Test
    public void add() throws Exception {

    }

    @Ignore
    @Test
    public void get() throws Exception {

    }

    @Ignore
    @Test
    public void remove() throws Exception {

    }

    @Ignore
    @Test
    public void size() throws Exception {

    }

    @Ignore
    @Test
    public void capacity() throws Exception {

    }

    @Ignore
    @Test
    public void clear() throws Exception {

    }

    @Ignore
    @Test
    public void getLast() throws Exception {

    }

    @Ignore
    @Test
    public void removeLast() throws Exception {

    }

    @Ignore
    @Test
    public void iterator() throws Exception {

    }

//    @Test
//    public void toString() throws Exception {
//
//    }

}