package exo.spring.awsimager.filestore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;

@Service
public class FileStore {
	
	
	private final AmazonS3 s3;
	
	@Autowired
	public FileStore(AmazonS3 s3) {
		this.s3 = s3;
	}
	
	public void save(
			String path, 
			String fileName,
			Optional<Map<String ,String >> optionalMetaData,
			InputStream inputStream
			) {
		
		ObjectMetadata metadata = new ObjectMetadata();
		optionalMetaData.ifPresent(map ->{
			//Checking if map is empty
			if(!map.isEmpty()) {
				
				//Loop through map
				map.forEach((key,value) ->
				//Assign User's Metadata to object metadata
				metadata.addUserMetadata(key, value)
				);
			}
		});
		
		
		try {
			s3.putObject(path, fileName, inputStream, metadata);
			
		}catch(AmazonServiceException e) {
			throw new IllegalStateException("Failed to store file to S3, " + e);
		}
		
	}

	public byte[] download(String format, String key) {
		
		try {
			S3Object object = s3.getObject(format, key);
			return IOUtils.toByteArray(object.getObjectContent());
		}catch(AmazonServiceException | IOException e) {
			throw new IllegalStateException("Failed to download Image from S3" ,e);
		}
		
	}

}
