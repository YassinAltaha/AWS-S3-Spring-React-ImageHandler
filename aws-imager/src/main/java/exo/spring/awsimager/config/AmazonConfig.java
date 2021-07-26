package exo.spring.awsimager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {
	
	
	//TODO: Replace Credentials with Hidden Variables
	@Bean
	public AmazonS3 s3() {
		AWSCredentials awsCredentials = 
				new BasicAWSCredentials(
						"AWS Access Key",
						"AWS Security Key");
	return AmazonS3ClientBuilder
			.standard()	
			.withRegion("us-east-2")
			.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
			.build();
	} 
}
