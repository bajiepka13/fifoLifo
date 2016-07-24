package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    private int vaultInitSize;
    private static ManagingClass manager;
    private static String[] oneStringArray;
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

        fiveStringsArray = new String[]{
                "The First String",
                "The Second String",
                "The Third String",
                "The Fourth String",
                "The Fifth String",
        };
        oneStringArray = new String[]{
                "The Additional String",
        };
    }

    @Before
    public void setUp() throws Exception {
        vaultInitSize = manager.vault.length;
        manager.addValues(fiveStringsArray);
    }

    @After
    public void tearDown() throws Exception {
        manager.clear();
    }

    @Test
    public void vaultSizeChangesAfterAddValues() throws Exception {
        boolean vaultSizeNotChanged = (manager.vault.length == fiveStringsArray.length);
        manager.addValues(oneStringArray);
        boolean vaultSizeChanged = (manager.vault.length == oneStringArray.length + vaultInitSize);
        assertTrue(vaultSizeChanged & vaultSizeNotChanged);
    }
    
    @Test
    public void compareAfterAddValues() {

        boolean areStringsEqual = false;
        for (int i = 0; i < fiveStringsArray.length - 1; i++) {
            if (manager.vault[i].equals(fiveStringsArray[i])) {
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
        oneStringArray = null;
        fiveStringsArray = null;

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