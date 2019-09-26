//: com.yuli.security.signature.SignatureApplication.java


package com.yuli.security.signature;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SignatureApplication implements CommandLineRunner {

	public SignatureApplication() {}

	public static void main(String[] args) {
		SpringApplication.run(SignatureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/* Generate a DSA signature */
		if (args.length != 1) {
			log.warn("------- Usage: SignatureApplication name_of_file_to_sign");
		} else try {
			// Create a Key Pair Generator
			KeyPairGenerator kenGen = KeyPairGenerator.getInstance("DSA",
					"SUN");

			// Initialize the Key Pair Generator
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG",
					"SUN");

			// SecureRandom.getInstanceStrong()

			kenGen.initialize(1024, random);

			// Generate Public and Private Keys
			KeyPair keyPair = kenGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();

			/*
			 * Get a Signature Object:
			 *
			 * When specifying the signature algorithm name, you should also
			 * include the name of the message digest algorithm used by the
			 * signature algorithm.
			 *
			 * "SHA1withDSA" is a way of specifying the DSA signature algorithm,
			 * using the SHA-1 message digest algorithm.
			 */
			Signature signature = Signature.getInstance("SHA1withDSA",
					"SUN");

			// Initialize the Signature Object


		} catch (Exception e) {
			log.error("------- Caught exception {}", e.toString());
		}
	}

}///:~