package com.melidata.definitions.uploader

import com.amazonaws.ClientConfiguration
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.CanonicalGrantee
import org.apache.commons.io.IOUtils
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.AccessControlList
import com.amazonaws.services.s3.model.GroupGrantee
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.util.StringInputStream
import com.amazonaws.services.s3.model.Permission
import org.apache.commons.io.IOUtils

/**
 * Created by geisbruch on 12/16/14.
 */
class S3Controller {
    def static LAST_VERSION_OBJECT="lastVersion"

    AmazonS3 s3;
    def bucket
    def BasicAWSCredentials credentials

    def S3Controller(String bucket, String accessKey, String secretKey) {
        credentials = new BasicAWSCredentials(accessKey, secretKey)
        ClientConfiguration config = new ClientConfiguration();
        if(System.getenv().containsKey("proxyHost")){
            config.setProxyHost(System.getenv().get("proxyHost"))
        }
        if(System.getenv().containsKey("proxyPort")){
            config.setProxyPort(Integer.parseInt(System.getenv().get("proxyPort")))
        }

        s3 = new AmazonS3Client(credentials, config)

        this.bucket = bucket;
    }

    Integer getLastVersion() {
        S3Object obj = s3.getObject(bucket, LAST_VERSION_OBJECT);
        def content = IOUtils.toString(obj.objectContent);
        return Integer.parseInt(content.trim());
    }


    void setLastServersion(Integer version) {
        saveFile(LAST_VERSION_OBJECT,version.toString())
    }


    void saveCatalogVersion(String catalogFile, String contentType, String name, Integer version) {
        def ext = contentType.split("/")[-1]
        saveFile(name+"."+ext,catalogFile,contentType, ["Catalog-Version":version.toString()])
    }

    void saveFile(String fileName, String file, String contentType = "text/plain",  headers=[:]) {
        def metadata = new ObjectMetadata();
        def stream = new StringInputStream(file)
        metadata.setUserMetadata(headers)
        //metadata.setContentLength(stream.bytes.size());
        metadata.setContentType(contentType)
        s3.putObject(new PutObjectRequest(bucket, fileName,stream,metadata)
                        .withCannedAcl(CannedAccessControlList.AuthenticatedRead))


    }

}
