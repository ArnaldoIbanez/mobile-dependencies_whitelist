package com.melidata.definitions.uploaders

import com.amazonaws.ClientConfiguration
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.ml.melidata.manager.storage.S3Service

class WhitelistService extends S3Service {


    static final String ONE_PART_ONE = 'AKIAJ4K4Z'
    static final String ONE_PART_TWO = 'OXUNJLTL4NQ'
    static final String AWS_ACCESS_KEY = ONE_PART_ONE + ONE_PART_TWO

    static final String TWO_PART_ONE = 'F6Ymfs+n3ttTUqxd89UQ+'
    static final String TWO_PART_TWO = 'AmQmfUI1wdTnLTW/Wzw'
    static final String AWS_SECRET_KEY = TWO_PART_ONE + TWO_PART_TWO

    WhitelistService() {
        super('melidata-api-whitelist')
        this.client = new AmazonS3Client(new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_KEY),
                new ClientConfiguration().withMaxConnections(300))
    }
}
