import com.melidata.definitions.manager.CatalogManager
import org.junit.Test

class CatalogManagerTest {

    @Test
    void instantiateCatalogManagerShouldHaveAllCatalogs() {

        CatalogManager cm = new CatalogManager()
        cm.init()

        assert cm.getCatalog("melidata") != null

    }
}
