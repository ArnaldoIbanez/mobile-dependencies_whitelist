package com.melidata.definitions.validation

import com.amazonaws.services.s3.model.S3Object
import com.melidata.definitions.uploader.S3Controller
import com.ml.melidata.catalog.Catalog
import org.apache.commons.io.IOUtils


class CatalogFileHandler {

    private static final String AWS_KEY = 'AKIAI2AFLMRLNMSP3IJA'
    private static final String AWS_SECRET = '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'
    private static final String DEFAULT_BUCKET = 'melidata-catalog-versions'
    private static final String LAST_DSL_NAME = 'last.dsl'
    private static final String CATALOG_NAME = 'catalog.groovy'

    protected String dslName
    protected S3Controller s3Controller

    protected String _lastDSL
    protected String _embeddedDSL
    protected Catalog _catalog

    CatalogFileHandler() {
        s3Controller = new S3Controller(DEFAULT_BUCKET, AWS_KEY, AWS_SECRET)
        dslName = LAST_DSL_NAME
        loadFiles()
    }

    CatalogFileHandler(String bucket, String dslName) {
        s3Controller = new S3Controller(bucket, AWS_KEY, AWS_SECRET)
        this.dslName = dslName
        loadFiles()
    }

    String getLastDSL() {
        try {
            S3Object o = s3Controller.getObject(dslName)
            return IOUtils.toString(o.objectContent)
        } catch (Exception e) {
            return null
        }
    }

    String getEmbeddedDSL() {
        try {
            InputStream s = Thread.currentThread().contextClassLoader.getResourceAsStream(CATALOG_NAME)
            return IOUtils.toString(s)
        } catch (Exception e) {
            return null
        }
    }

    protected void loadFiles() {
        _lastDSL = lastDSL
        _embeddedDSL = embeddedDSL
    }

    boolean isRecentDSL() {
        _embeddedDSL.equals(_lastDSL)
    }

    boolean hasLastDSL() {
        _lastDSL != null
    }

    Catalog getCatalog() {
        if (_catalog) return _catalog
        try {
            GroovyShell shell = new GroovyShell()
            Script script = shell.parse(_lastDSL ?: _embeddedDSL)
            _catalog = script.run()
            return _catalog
        } catch (Exception e) {
            return null
        }
    }

}
