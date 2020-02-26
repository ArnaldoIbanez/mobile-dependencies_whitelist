import com.melidata.definitions.uploaders.CatalogUploader
import com.melidata.definitions.uploaders.MetricsUploader
import com.melidata.definitions.uploaders.QueriesUploader
import com.melidata.definitions.uploaders.WhitelistPathUploader

static void main(String[] args) {

    println("Starting upload of all catalogs")
    CatalogUploader.main(args)
    println("Starting upload json for batch queries")
    QueriesUploader.main(args)
    println("Starting upload metrics")
    MetricsUploader.main(args)
    println("Starting upload json for whitelisted paths")
    WhitelistPathUploader.main(args)
}