import com.amazonaws.AmazonClientException
import com.amazonaws.AmazonServiceException
import com.amazonaws.AmazonWebServiceRequest
import com.amazonaws.HttpMethod
import com.amazonaws.SdkClientException
import com.amazonaws.regions.Region
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.Headers
import com.amazonaws.services.s3.S3ClientOptions
import com.amazonaws.services.s3.S3ResponseMetadata
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest
import com.amazonaws.services.s3.model.AccessControlList
import com.amazonaws.services.s3.model.Bucket
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration
import com.amazonaws.services.s3.model.BucketLoggingConfiguration
import com.amazonaws.services.s3.model.BucketNotificationConfiguration
import com.amazonaws.services.s3.model.BucketPolicy
import com.amazonaws.services.s3.model.BucketReplicationConfiguration
import com.amazonaws.services.s3.model.BucketTaggingConfiguration
import com.amazonaws.services.s3.model.BucketVersioningConfiguration
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult
import com.amazonaws.services.s3.model.CopyObjectRequest
import com.amazonaws.services.s3.model.CopyObjectResult
import com.amazonaws.services.s3.model.CopyPartRequest
import com.amazonaws.services.s3.model.CopyPartResult
import com.amazonaws.services.s3.model.CreateBucketRequest
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketAnalyticsConfigurationResult
import com.amazonaws.services.s3.model.DeleteBucketCrossOriginConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketInventoryConfigurationResult
import com.amazonaws.services.s3.model.DeleteBucketLifecycleConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketMetricsConfigurationResult
import com.amazonaws.services.s3.model.DeleteBucketPolicyRequest
import com.amazonaws.services.s3.model.DeleteBucketReplicationConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketRequest
import com.amazonaws.services.s3.model.DeleteBucketTaggingConfigurationRequest
import com.amazonaws.services.s3.model.DeleteBucketWebsiteConfigurationRequest
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.DeleteObjectTaggingRequest
import com.amazonaws.services.s3.model.DeleteObjectTaggingResult
import com.amazonaws.services.s3.model.DeleteObjectsRequest
import com.amazonaws.services.s3.model.DeleteObjectsResult
import com.amazonaws.services.s3.model.DeleteVersionRequest
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.amazonaws.services.s3.model.GetBucketAccelerateConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketAclRequest
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketAnalyticsConfigurationResult
import com.amazonaws.services.s3.model.GetBucketCrossOriginConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketInventoryConfigurationResult
import com.amazonaws.services.s3.model.GetBucketLifecycleConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketLocationRequest
import com.amazonaws.services.s3.model.GetBucketLoggingConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketMetricsConfigurationResult
import com.amazonaws.services.s3.model.GetBucketNotificationConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketPolicyRequest
import com.amazonaws.services.s3.model.GetBucketReplicationConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketTaggingConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketVersioningConfigurationRequest
import com.amazonaws.services.s3.model.GetBucketWebsiteConfigurationRequest
import com.amazonaws.services.s3.model.GetObjectAclRequest
import com.amazonaws.services.s3.model.GetObjectMetadataRequest
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.GetObjectTaggingRequest
import com.amazonaws.services.s3.model.GetObjectTaggingResult
import com.amazonaws.services.s3.model.GetS3AccountOwnerRequest
import com.amazonaws.services.s3.model.HeadBucketRequest
import com.amazonaws.services.s3.model.HeadBucketResult
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsRequest
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsRequest
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsRequest
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult
import com.amazonaws.services.s3.model.ListBucketsRequest
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest
import com.amazonaws.services.s3.model.ListNextBatchOfObjectsRequest
import com.amazonaws.services.s3.model.ListNextBatchOfVersionsRequest
import com.amazonaws.services.s3.model.ListObjectsRequest
import com.amazonaws.services.s3.model.ListObjectsV2Request
import com.amazonaws.services.s3.model.ListObjectsV2Result
import com.amazonaws.services.s3.model.ListPartsRequest
import com.amazonaws.services.s3.model.ListVersionsRequest
import com.amazonaws.services.s3.model.MultipartUploadListing
import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.Owner
import com.amazonaws.services.s3.model.PartListing
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.PutObjectResult
import com.amazonaws.services.s3.model.RestoreObjectRequest
import com.amazonaws.services.s3.model.S3Object
import com.amazonaws.services.s3.model.S3ObjectSummary
import com.amazonaws.services.s3.model.SetBucketAccelerateConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketAclRequest
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketAnalyticsConfigurationResult
import com.amazonaws.services.s3.model.SetBucketCrossOriginConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketInventoryConfigurationResult
import com.amazonaws.services.s3.model.SetBucketLifecycleConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketLoggingConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketMetricsConfigurationResult
import com.amazonaws.services.s3.model.SetBucketNotificationConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketPolicyRequest
import com.amazonaws.services.s3.model.SetBucketReplicationConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketTaggingConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketVersioningConfigurationRequest
import com.amazonaws.services.s3.model.SetBucketWebsiteConfigurationRequest
import com.amazonaws.services.s3.model.SetObjectAclRequest
import com.amazonaws.services.s3.model.SetObjectTaggingRequest
import com.amazonaws.services.s3.model.SetObjectTaggingResult
import com.amazonaws.services.s3.model.StorageClass
import com.amazonaws.services.s3.model.UploadPartRequest
import com.amazonaws.services.s3.model.UploadPartResult
import com.amazonaws.services.s3.model.VersionListing
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration
import com.amazonaws.services.s3.waiters.AmazonS3Waiters

/**
 * Created by mtencer on 22/03/16.
 */
class CatalogHandlerTest {

    //TODO testMultiFileCatalog and CatalogManager
/*
    @Test void testSingleFileCatalog(){

        CatalogHandler handler = new CatalogHandler("melidata")

        //mock cli
        def catalogObj = new S3ObjectSummary();
        catalogObj.setKey(CatalogHandler.S3_CATALOG_FILE)
        catalogObj.setETag("XXX")
        def list = new ObjectListing()
        list.objectSummaries = [catalogObj]

        S3Object obj = new S3Object()
        obj.setObjectContent(new StringBufferInputStream("""
            import com.ml.melidata.catalog.PropertyType
            import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
            import com.ml.melidata.TrackType

            catalog {
                business = [ "prueba_business"]

                defaultBusiness = "prueba_business"

                platforms = ["/prueba"]

                tracks {
                    "/path1"(platform: "/prueba") {
                        field1(required: false)
                    }
                }

            }
        """))

        def metadata = new ObjectMetadata()
        metadata.setUserMetadata(Collections.singletonMap("catalog-version", "5"))
        metadata.setHeader(Headers.ETAG, "XXX")
        obj.setObjectMetadata(metadata)

        handler.cli.s3 = new S3ClientMock(list, obj);

        boolean reload = handler.reload()

        assertEquals(true, reload)
        assertEquals(5, handler.getVersion())
        assertNotNull(handler.getCatalog())

        assertEquals("prueba_business", handler.getCatalog().getDefaultBusiness())
        assertEquals(1, handler.getCatalog().platforms.size())
        assertEquals("/prueba", handler.getCatalog().platforms.get(0))

        //assert validation
        TrackValidationResponse response = handler.getCatalog().validate(new com.ml.melidata.Track("/path1", com.ml.melidata.TrackType.View, "/prueba", "prueba_business"))
        assertTrue(response.status)
    }

    public class S3ClientMock implements AmazonS3 {

        def ObjectListing list
        def S3Object obj

        S3ClientMock(ObjectListing list, S3Object obj) {
            this.list = list
            this.obj = obj
        }


        @Override
        public ObjectListing listObjects(ListObjectsRequest listObjectsRequest) {
            list
        }

        @Override
        ListObjectsV2Result listObjectsV2(String bucketName) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        ListObjectsV2Result listObjectsV2(String bucketName, String prefix) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        public S3Object getObject(String bucketName, String key) throws AmazonClientException {
            obj
        }

        @Override
        void setEndpoint(String endpoint) {

        }

        @Override
        void setRegion(Region region) throws IllegalArgumentException {

        }

        @Override
        void setS3ClientOptions(S3ClientOptions clientOptions) {

        }

        @Override
        void changeObjectStorageClass(String bucketName, String key, StorageClass newStorageClass) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setObjectRedirectLocation(String bucketName, String key, String newRedirectLocation) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        ObjectListing listObjects(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        ObjectListing listObjects(String bucketName, String prefix) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        ObjectListing listNextBatchOfObjects(ObjectListing previousObjectListing) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        VersionListing listVersions(String bucketName, String prefix) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        VersionListing listNextBatchOfVersions(VersionListing previousVersionListing) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        VersionListing listVersions(String bucketName, String prefix, String keyMarker, String versionIdMarker, String delimiter, Integer maxResults) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        boolean doesBucketExist(String bucketName) throws AmazonClientException, AmazonServiceException {
            return false
        }

        @Override
        HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        String getBucketLocation(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Bucket createBucket(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Bucket createBucket(String bucketName, com.amazonaws.services.s3.model.Region region) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        Bucket createBucket(String bucketName, String region) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        AccessControlList getObjectAcl(String bucketName, String key) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        AccessControlList getObjectAcl(String bucketName, String key, String versionId) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        AccessControlList getObjectAcl(GetObjectAclRequest getObjectAclRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        void setObjectAcl(String bucketName, String key, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setObjectAcl(String bucketName, String key, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setObjectAcl(String bucketName, String key, String versionId, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setObjectAcl(String bucketName, String key, String versionId, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setObjectAcl(SetObjectAclRequest setObjectAclRequest) throws SdkClientException, AmazonServiceException {

        }

        @Override
        AccessControlList getBucketAcl(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketAcl(String bucketName, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setBucketAcl(String bucketName, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        ObjectMetadata getObjectMetadata(String bucketName, String key) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        ObjectMetadata getObject(GetObjectRequest getObjectRequest, File destinationFile) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        String getObjectAsString(String bucketName, String key) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest) {
            return null
        }

        @Override
        SetObjectTaggingResult setObjectTagging(SetObjectTaggingRequest setObjectTaggingRequest) {
            return null
        }

        @Override
        DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest) {
            return null
        }

        @Override
        void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteBucket(String bucketName) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        PutObjectResult putObject(PutObjectRequest putObjectRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        PutObjectResult putObject(String bucketName, String key, File file) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        PutObjectResult putObject(String bucketName, String key, InputStream input, ObjectMetadata metadata) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        PutObjectResult putObject(String bucketName, String key, String content) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        CopyPartResult copyPart(CopyPartRequest copyPartRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void deleteObject(String bucketName, String key) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void deleteVersion(String bucketName, String key, String versionId) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        BucketLoggingConfiguration getBucketLoggingConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        BucketVersioningConfiguration getBucketVersioningConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        BucketLifecycleConfiguration getBucketLifecycleConfiguration(String bucketName) {
            return null
        }

        @Override
        BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest) {
            return null
        }

        @Override
        void setBucketLifecycleConfiguration(String bucketName, BucketLifecycleConfiguration bucketLifecycleConfiguration) {

        }

        @Override
        void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest) {

        }

        @Override
        void deleteBucketLifecycleConfiguration(String bucketName) {

        }

        @Override
        void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest) {

        }

        @Override
        BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String bucketName) {
            return null
        }

        @Override
        BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest) {
            return null
        }

        @Override
        void setBucketCrossOriginConfiguration(String bucketName, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {

        }

        @Override
        void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest) {

        }

        @Override
        void deleteBucketCrossOriginConfiguration(String bucketName) {

        }

        @Override
        void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest) {

        }

        @Override
        BucketTaggingConfiguration getBucketTaggingConfiguration(String bucketName) {
            return null
        }

        @Override
        BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest) {
            return null
        }

        @Override
        void setBucketTaggingConfiguration(String bucketName, BucketTaggingConfiguration bucketTaggingConfiguration) {

        }

        @Override
        void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest) {

        }

        @Override
        void deleteBucketTaggingConfiguration(String bucketName) {

        }

        @Override
        void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest) {

        }

        @Override
        BucketNotificationConfiguration getBucketNotificationConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest) throws SdkClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setBucketNotificationConfiguration(String bucketName, BucketNotificationConfiguration bucketNotificationConfiguration) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        BucketWebsiteConfiguration getBucketWebsiteConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketWebsiteConfiguration(String bucketName, BucketWebsiteConfiguration configuration) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteBucketWebsiteConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        BucketPolicy getBucketPolicy(String bucketName) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void setBucketPolicy(String bucketName, String policyText) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteBucketPolicy(String bucketName) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        URL generatePresignedUrl(String bucketName, String key, Date expiration) throws AmazonClientException {
            return null
        }

        @Override
        URL generatePresignedUrl(String bucketName, String key, Date expiration, HttpMethod method) throws AmazonClientException {
            return null
        }

        @Override
        URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
            return null
        }

        @Override
        InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest request) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        UploadPartResult uploadPart(UploadPartRequest request) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        PartListing listParts(ListPartsRequest request) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        void abortMultipartUpload(AbortMultipartUploadRequest request) throws AmazonClientException, AmazonServiceException {

        }

        @Override
        CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest request) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest request) throws AmazonClientException, AmazonServiceException {
            return null
        }

        @Override
        S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
            return null
        }

        @Override
        void restoreObject(RestoreObjectRequest request) throws AmazonServiceException {

        }

        @Override
        void restoreObject(String bucketName, String key, int expirationInDays) throws AmazonServiceException {

        }

        @Override
        void enableRequesterPays(String bucketName) throws AmazonServiceException, AmazonClientException {

        }

        @Override
        void disableRequesterPays(String bucketName) throws AmazonServiceException, AmazonClientException {

        }

        @Override
        boolean isRequesterPaysEnabled(String bucketName) throws AmazonServiceException, AmazonClientException {
            return false
        }

        @Override
        void setBucketReplicationConfiguration(String bucketName, BucketReplicationConfiguration configuration) throws AmazonServiceException, SdkClientException {

        }

        @Override
        void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest) throws AmazonServiceException, SdkClientException {

        }

        @Override
        BucketReplicationConfiguration getBucketReplicationConfiguration(String bucketName) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        void deleteBucketReplicationConfiguration(String bucketName) throws AmazonServiceException, SdkClientException {

        }

        @Override
        void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest request) throws AmazonServiceException, SdkClientException {

        }

        @Override
        boolean doesObjectExist(String bucketName, String objectName) throws AmazonServiceException, SdkClientException {
            return false
        }

        @Override
        BucketAccelerateConfiguration getBucketAccelerateConfiguration(String bucketName) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        void setBucketAccelerateConfiguration(String bucketName, BucketAccelerateConfiguration accelerateConfiguration) throws AmazonServiceException, SdkClientException {

        }

        @Override
        void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest) throws AmazonServiceException, SdkClientException {

        }

        @Override
        DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        DeleteBucketMetricsConfigurationResult deleteBucketMetricsConfiguration(DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketMetricsConfigurationResult getBucketMetricsConfiguration(GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(String bucketName, MetricsConfiguration metricsConfiguration) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketMetricsConfigurationResult setBucketMetricsConfiguration(SetBucketMetricsConfigurationRequest setBucketMetricsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        ListBucketMetricsConfigurationsResult listBucketMetricsConfigurations(ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        DeleteBucketAnalyticsConfigurationResult deleteBucketAnalyticsConfiguration(DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketAnalyticsConfigurationResult getBucketAnalyticsConfiguration(GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(String bucketName, AnalyticsConfiguration analyticsConfiguration) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketAnalyticsConfigurationResult setBucketAnalyticsConfiguration(SetBucketAnalyticsConfigurationRequest setBucketAnalyticsConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        ListBucketAnalyticsConfigurationsResult listBucketAnalyticsConfigurations(ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        DeleteBucketInventoryConfigurationResult deleteBucketInventoryConfiguration(DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(String bucketName, String id) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        GetBucketInventoryConfigurationResult getBucketInventoryConfiguration(GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(String bucketName, InventoryConfiguration inventoryConfiguration) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        SetBucketInventoryConfigurationResult setBucketInventoryConfiguration(SetBucketInventoryConfigurationRequest setBucketInventoryConfigurationRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        ListBucketInventoryConfigurationsResult listBucketInventoryConfigurations(ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest) throws AmazonServiceException, SdkClientException {
            return null
        }

        @Override
        com.amazonaws.services.s3.model.Region getRegion() {
            return null
        }

        @Override
        String getRegionName() {
            return null
        }

        @Override
        URL getUrl(String bucketName, String key) {
            return null
        }

        @Override
        AmazonS3Waiters waiters() {
            return null
        }
    }
*/
}
