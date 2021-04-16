package com.example.consumingrest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class ConsumingRestApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        System.out.println("Enter offer_id");
        Scanner sc = new Scanner(System.in);
        String offer_id = sc.nextLine();

        System.out.println("Enter candidate_id");
        Scanner scanner = new Scanner(System.in);
        int candidate_id = scanner.nextInt();

        URI targetUrl = UriComponentsBuilder.fromUriString("https://api.recruitee.com")  // Build the base link
                .path("/c/123/candidates")                            // Add path
                .queryParam("offer_id", offer_id)                                // Add one or more query params
                .build()                                                 // Build the URL
                .encode()                                                // Encode any URI items that need to be encoded
                .toUri();
        return args -> {
            ResponseEntity<OfferCandidate[]> responseEntity = restTemplate.getForEntity(targetUrl, OfferCandidate[].class);
            OfferCandidate[] candidates = responseEntity.getBody();
            for (int i = 0; i < candidates.length; i++) {
                log.info(candidates[i].toString());
            }

            URI targetUrl1 = UriComponentsBuilder.fromUriString("https://api.recruitee.com")
                    .path("/c/123/candidates")
                    .queryParam("id", candidate_id)
                    .build()
                    .encode()
                    .toUri();
            Candidate candidate = restTemplate.getForObject(targetUrl1, Candidate.class);
            log.info(candidate.getCv());

            log.info(candidate.getPlacements().toString());
        };
    }
}