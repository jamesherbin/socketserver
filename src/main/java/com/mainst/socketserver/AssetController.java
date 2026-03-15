package com.mainst.socketserver;

import static java.nio.charset.StandardCharsets.UTF_8;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;

@RestController
public class AssetController {

	public AssetController()
	{	
	}
	
	public void getAsset(){}
	
	@PostMapping("uploadAsset")
	public void uploadAsset(){
		Storage storage = StorageOptions.getDefaultInstance().getService();
		String bucketName = "msc_asset_bucket";
		//Bucket bucket = storage.create(BucketInfo.of(bucketName));

		BlobId blobId = BlobId.of(bucketName, "test_blob");
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
		Blob blob = storage.create(blobInfo, "a simple blob".getBytes(UTF_8));
	}
	public void deleteAsset(){}

}

