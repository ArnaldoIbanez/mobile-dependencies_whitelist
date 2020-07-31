package com.melidata.definitions.manager

import com.amazonaws.ClientConfiguration
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.ObjectListing
import com.ml.melidata.catalog.Catalog
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.util.StringInputStream
import com.amazonaws.services.s3.model.GetObjectRequest
import org.apache.commons.io.IOUtils

import java.security.MessageDigest

/**
 * Created by geisbruch on 12/16/14.
 */
class S3Controller {

    AmazonS3 s3;
    def String bucket
    def BasicAWSCredentials credentials

    def S3Controller(String bucket, String accessKey, String secretKey) {
        this.bucket = bucket
        this.credentials = new BasicAWSCredentials(accessKey, secretKey)
        ClientConfiguration config = new ClientConfiguration();
        if(System.getenv().containsKey("proxyHost")){
            config.setProxyHost(System.getenv().get("proxyHost"))
        }
        if(System.getenv().containsKey("proxyPort")){
            config.setProxyPort(Integer.parseInt(System.getenv().get("proxyPort")))
        }
        s3 = new AmazonS3Client(credentials, config)
    }

    Integer getLastVersion(String lastVersionObject) {
        try {
            println "getLastVersion ${bucket} - ${lastVersionObject}"
            S3Object obj = s3.getObject(bucket, lastVersionObject)
            def content = IOUtils.toString(obj.objectContent)
            return Integer.parseInt(content.trim())
        } catch(Exception e) {
            return 0
        }
    }


    void setLastServersion(String lastVersionObject, Integer version) {
        saveFile(lastVersionObject ,version.toString())
    }

    void saveCatalogVersion(Catalog catalog, String name, Integer version) {
        def ext = "dsl"
        catalog.getFiles().each { file ->
            def content = IOUtils.toString(new FileInputStream(file))
            saveFile(name + "." + ext +  "/" + file.name, content, "application/" + ext, ["Catalog-Version":version.toString()])
        }
    }

    void saveCatalogVersion(String json, String name, Integer version) {
        def ext = "json"
        saveFile(name+"."+ext,json,"application/" + ext, ["Catalog-Version":version.toString()])
    }

    void saveFile(String fileName, String content, String contentType = "text/plain",  headers=[:]) {
        def metadata = new ObjectMetadata();
        def stream = new StringInputStream(content)
        metadata.setUserMetadata(headers)
        //metadata.setContentLength(stream.bytes.size());
        metadata.setContentType(contentType)
        s3.putObject(new PutObjectRequest(bucket, fileName,stream,metadata)
                        .withCannedAcl(CannedAccessControlList.AuthenticatedRead))

    }

    S3Object getObject(String name) { s3.getObject(bucket,name) }

    S3Object getObject(GetObjectRequest request) {
        s3.getObject(request)
    }

    ObjectListing listObjects(ListObjectsRequest listObjectsRequest) {
        return s3.listObjects(listObjectsRequest)

    }
}
