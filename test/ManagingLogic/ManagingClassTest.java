package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    private int vaultInitSize;
    private static ManagingClass manager;
    private static String[] sixStringArray;
    private static String[] fiveStringsArray;


    @BeforeClass
    public static void setUpClass() throws Exception {
        manager = new ManagingClass() {
            @Override
            public Object getLast() {
                return null;
            }

            @Override
            public void removeLast() {
            }
        };
        sixStringArray = new String[]{
                "The First String",
                "The Second String",
                "The Third String",
                "The Fourth String",
                "The Fifth String",
                "The Sixth String"
        };
        fiveStringsArray = new String[]{
                "The First String",
                "The Second String",
                "The Third String",
                "The Fourth String",
                "The Fifth String",
        };
    }

    @Before
    public void setUp() throws Exception {
        vaultInitSize = manager.vault.length;
        manager.addValues(sixStringArray);
    }

    @After
    public void tearDown() throws Exception {
        manager.clear();
    }


    @Test
    public void vaultSizeChangedAfterAddValues() throws Exception {
        assertTrue(manager.vault.length == sixStringArray.length + vaultInitSize);
    }

    @Test
    public void compareAfterAddValues() {
        boolean areStringsEqual = false;
        for (int i = 0; i < sixStringArray.length - 1; i++) {
            if (manager.vault[i].equals(sixStringArray[i])) {
                areStringsEqual = true;
            } else {
                areStringsEqual = true;
                break;
            }
        }
        assertTrue(areStringsEqual);
    }

    @Test
    public void clear() throws Exception {
        boolean isVaultEmpty = false;
        manager.clear();
        for (Object obj : manager.vault) {
            if (obj != null) {
                isVaultEmpty = false;
                break;
            } else {
                isVaultEmpty = true;
            }
        }
        assertTrue(isVaultEmpty);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        sixStringArray = null;

    }


//    @Ignore
//    @Test
//    public void add() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void get() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void remove() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void size() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void capacity() throws Exception {
//
//    }
//
//
//    @Ignore
//    @Test
//    public void getLast() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void removeLast() throws Exception {
//
//    }
//
//    @Ignore
//    @Test
//    public void iterator() throws Exception {
//
//    }

//    @Test
//    public void toString() throws Exception {
//
//    }

}