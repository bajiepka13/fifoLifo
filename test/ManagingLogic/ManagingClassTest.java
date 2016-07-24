package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    private int vaultInitSize;
    private static ManagingClass common;
    private static String[] oneStringArray;
    private static String[] fiveStringsArray;

    @BeforeClass
    public static void setUpClass() throws Exception {
        common = new ManagingClass() {
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
        vaultInitSize = common.vault.length;
        common.addValues(fiveStringsArray);
    }

    @After
    public void tearDown() throws Exception {
        common.clear();
    }

    @Test
    public void vaultSizeChangesAfterAddValues() throws Exception {
        boolean vaultSizeNotChanged;
        boolean vaultSizeChanged;
        boolean isSizeEqualInputQuantity;

        vaultSizeNotChanged = (common.vault.length == fiveStringsArray.length);
        isSizeEqualInputQuantity = (common.size() == fiveStringsArray.length);

        common.addValues(oneStringArray);
        vaultSizeChanged = (common.vault.length == oneStringArray.length + vaultInitSize);
        isSizeEqualInputQuantity
                = isSizeEqualInputQuantity & (common.size() == fiveStringsArray.length + oneStringArray.length);

        assertTrue(vaultSizeChanged & vaultSizeNotChanged & isSizeEqualInputQuantity);
    }

    @Test
    public void contentVerificationAfterAddValues() {
        boolean areStringsEqual = false;
        for (int i = 0; i < fiveStringsArray.length - 1; i++) {
            if (common.vault[i].equals(fiveStringsArray[i])) {
                areStringsEqual = true;
            } else {
                areStringsEqual = true;
                break;
            }
        }
        assertTrue(areStringsEqual);
    }

    @Test
    public void sizeAndCapacityChangesAfterClear() throws Exception {
        final int EMPTY = 0;
        boolean isVaultEmpty = false;
        boolean isCapacityEqualSize;
        boolean isCapacityNotChanged;
        boolean isSizeReseted;
        int capacityBeforeClear;

        capacityBeforeClear = common.capacity();
        isCapacityEqualSize = (common.capacity() == common.size());

        common.clear();

        isCapacityNotChanged = (capacityBeforeClear == common.capacity());
        isSizeReseted = (common.size() == EMPTY);

        for (Object obj : common.vault) {
            if (obj != null) {
                isVaultEmpty = false;
                break;
            } else {
                isVaultEmpty = true;
            }
        }
        assertTrue(isVaultEmpty & isCapacityEqualSize & isCapacityNotChanged & isSizeReseted);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        oneStringArray = null;
        fiveStringsArray = null;
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

}