package managinglogic;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ManagingClassTest {
    final String[] INIT_DATA = new String[]{
            "The First String",
            "The Second String",
            "The Third String",
            "The Fourth String",
            "The Fifth String"
    };

    final String[] ADD_DATA = new String[]{
            "The Additional String"
    };

    final int INIT_DATA_LENGTH = INIT_DATA.length;
    final int ADD_DATA_LENGTH = ADD_DATA.length;

    private static ManagingClass common;
    private int vaultInitSize;

    @BeforeClass
    public static void setUpClass() throws Exception {
        common = new ManagingClass() {
            @Override
            public Object getFirst() {
                return null;
            }

            @Override
            public void removeFirst() {
            }
        };
    }

    @Before
    public void setUp() throws Exception {
        vaultInitSize = common.vault.length;
        common.addValues(INIT_DATA);
    }

    @After
    public void tearDown() throws Exception {
        common.clear();
    }

    @Test(timeout = 1000)
    public void vaultSizeChangesAfterAddValues() throws Exception {
        boolean isVaultSizeNotChanged;
        boolean isVaultSizeChanged;
        boolean isSizeEqualsInputQuantity;
        int vaultSize;
        int collectionSize;

        collectionSize = common.size();
        vaultSize = common.vault.length;
        isVaultSizeNotChanged = (vaultInitSize == vaultSize) & (vaultSize == INIT_DATA_LENGTH);
        isSizeEqualsInputQuantity = (collectionSize == INIT_DATA_LENGTH);

        common.addValues(ADD_DATA);

        collectionSize = common.size();
        vaultSize = common.vault.length;
        isVaultSizeChanged = (vaultSize == ADD_DATA_LENGTH + vaultInitSize);
        isSizeEqualsInputQuantity = isSizeEqualsInputQuantity & (collectionSize == INIT_DATA_LENGTH + ADD_DATA_LENGTH);

        assertTrue(isVaultSizeChanged & isVaultSizeNotChanged & isSizeEqualsInputQuantity);
    }

    @Test(timeout = 1000)
    public void contentVerificationAfterAddValues() {
        boolean areStringsEqual = false;
        for (int i = 0; i < INIT_DATA_LENGTH - 1; i++) {
            if (common.vault[i].equals(INIT_DATA[i])) {
                areStringsEqual = true;
            } else {
                areStringsEqual = false;
                break;
            }
        }
        assertTrue(areStringsEqual);
    }

    @Test(timeout = 1000)
    public void sizeAndCapacityChangesAfterClear() throws Exception {
        final int EMPTY = 0;
        boolean isVaultEmpty = false;
        boolean isCapacityEqualsToSize;
        boolean isCapacityNotChanged;
        boolean isSizeReseted;
        int capacityBeforeClear;

        capacityBeforeClear = common.capacity();
        isCapacityEqualsToSize = (common.capacity() == common.size());

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
        assertTrue(isVaultEmpty & isCapacityEqualsToSize & isCapacityNotChanged & isSizeReseted);
    }

    @Test(timeout = 1000)
    public void toStringIfEmpty() throws Exception {
        final String EXPECTED_IF_EMPTY = "Collection is empty";
        common.clear();
        String actualAfterClear = common.toString();
        assertEquals(actualAfterClear, EXPECTED_IF_EMPTY);
    }

    @Test(timeout = 1000)
    public void addWithoutCapacityChange() throws Exception {
        common.clear();
        common.addWithoutCapacityChange(ADD_DATA);
        assertTrue(common.vault[ADD_DATA_LENGTH - 1].equals(ADD_DATA));
    }

    @Test(expected = Exception.class, timeout = 1000)
    public void addWithoutCapacityChangeNoSpace() throws Exception {
        common.addWithoutCapacityChange(ADD_DATA);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        common = null;
    }
}