# Assessment
This assessment project is just a coding exercise to do a Spring Boot REST API call to JSONPlaceholder API (https://jsonplaceholder.typicode.com). This project uses JDK 21 and Spring Boot 3.4.0. Only a few features will be implemented as this is only an exercise. I use the RestClient for calling the JSONPlaceholder API. Unit testing is also done in the project.

## Getting Started
To use this code, just clone the repository and import it to your IDE. Just make sure you have JDK 21 installed on your computer.


## Features
### Getting all posts ("/posts")
<img width="500" alt="Screenshot 2024-12-04 at 19 48 54" src="https://github.com/user-attachments/assets/0aa9a7d0-476f-4118-bec9-b35e1e2b60f1">
<img width="500" alt="Screenshot 2024-12-04 at 20 13 12" src="https://github.com/user-attachments/assets/dc8aeae5-3767-4f0f-9781-e494f906c2a0">

This feature returns all 100 posts from JSONPlaceholder API.


### Getting the post with the longest title ("/longest")
<img width="500" alt="Screenshot 2024-12-04 at 20 13 55" src="https://github.com/user-attachments/assets/269c4edf-8fa5-4847-9721-2454e6ad9e30">

This feature returns a single post with the longest title.


### Getting all posts with modified response ("/modified")
<img width="500" alt="Screenshot 2024-12-04 at 20 14 14" src="https://github.com/user-attachments/assets/abef8898-b36b-42f8-9e41-c4dddf564176">

This feature returns all posts with added field of titleLength which counts each post's title's length.


### Getting the post with the longest title using standard comparator ("/comparator/standard")
<img width="500" alt="Screenshot 2024-12-04 at 20 14 31" src="https://github.com/user-attachments/assets/aafa8e3e-e185-41a1-85bd-bce3c41788c2">

This feature returns a single post with the longest title using the standard comparator class.


### Getting the post with the longest title using ignore case comparator ("/comparator/ignorecase")
<img width="500" alt="Screenshot 2024-12-04 at 20 14 51" src="https://github.com/user-attachments/assets/e43ac368-7879-4f21-bf51-5d3a14d4ab0e">

This feature returns a single post with the longest title using the ignore case comparator class.


## Unit Testing
<img width="357" alt="Screenshot 2024-12-04 at 20 22 50" src="https://github.com/user-attachments/assets/742e427b-df9e-42fd-a49d-492820053626">

Unit testing is done to make sure that the features are working properly.
