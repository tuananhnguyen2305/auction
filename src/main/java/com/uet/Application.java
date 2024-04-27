package com.uet;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) throws IOException {
//    	ClassLoader classLoader = Application.class.getClassLoader();
//    	
//    	File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
//    	FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
//    	
//    	FirebaseOptions options = new FirebaseOptions.Builder()
//    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//    			  .build();
//
//    			FirebaseApp.initializeApp(options);
    	
        SpringApplication.run(Application.class, args);
        
    }

}