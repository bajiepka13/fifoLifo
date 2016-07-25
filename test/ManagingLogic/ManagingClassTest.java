package ManagingLogic;

import org.junit.*;

import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    private int vaultInitLength;
    private static ManagingClass common;
    private String[] oneStringArray = new String[]{
            "The Additional String"
    };
    private String[] fiveStringsArray = new String[]{
            "The First String",
            "The Second String",
            "The Third String",
            "The Fourth String",
            "The Fifth String"
    };

    private final int INIT_DATA_LENGTH = fiveStringsArray.length;
    private final int ADD_DATA_LENGTH = oneStringArray.length;


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
    }

    @Before
    public void setUp() throws Exception {
        vaultInitLength = common.vault.length;
        common.addValues(fiveStringsArray);
    }

    @After
    public void tearDown() throws Exception {
        common.clear();
    }

    @Test
    public void vaultSizeChangesAfterAddValues() throws Exception {
        boolean isVaultSizeNotChanged;
        boolean isVaultSizeChanged;
        boolean isSizeEqualsInputQuantity;
        int vaultLength;
        int collectionSize;

        collectionSize = common.size();
        vaultLength = common.vault.length;
        isVaultSizeNotChanged = (vaultInitLength == vaultLength) & (vaultLength == INIT_DATA_LENGTH);
        isSizeEqualsInputQuantity = (collectionSize == INIT_DATA_LENGTH);

        common.addValues(oneStringArray);

        collectionSize = common.size();
        vaultLength = common.vault.length;
        isVaultSizeChanged = (vaultLength == ADD_DATA_LENGTH + vaultInitLength);
        isSizeEqualsInputQuantity = isSizeEqualsInputQuantity & (collectionSize == INIT_DATA_LENGTH + ADD_DATA_LENGTH);

        assertTrue(isVaultSizeChanged & isVaultSizeNotChanged & isSizeEqualsInputQuantity);
    }

    @Test
    public void contentVerificationAfterAddValues() {
        boolean areStringsEqual = false;
        for (int i = 0; i < INIT_DATA_LENGTH - 1; i++) {
            if (common.vault[i].equals(fiveStringsArray[i])) {
                areStringsEqual = true;
            } else {
                areStringsEqual = false;
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