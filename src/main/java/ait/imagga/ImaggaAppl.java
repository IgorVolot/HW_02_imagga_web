package ait.imagga;

import ait.imagga.dto.ResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ImaggaAppl {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjXzJiZGM5MTc3NGYyZjc1NDpmNDk0MGE4M2RhMzIxZWM1MmY5NmU3MjhhNDBjMWY0OA==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url","https://upload.wikimedia.org/wikipedia/commons/7/73/Blick_auf_Todtmoos.jpg");

        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ResponseDto> response = restTemplate.exchange(request, ResponseDto.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders().get("Content-type\t"));
        response.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);
    }
}
