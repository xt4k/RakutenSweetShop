#  Sweet Shop web site auto-testing

##### Done for task `QA UI Automation Test`

![image](https://sweetshop.netlify.app/favicon.png)

## TABLE OF CONTENT

## Technology stack

| GitHub                                                                                                                                   |                                                                   IDEA                                                                   |                                                                   Java                                                                   |                                                                  Junit5                                                                  |                                                                  Gradle                                                                  |                                                                 Selenide                                                                 |                                                                  Allure                                                                  |                                                                                                      
|:-----------------------------------------------------------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://cdn-icons-png.flaticon.com/512/25/25231.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562458-1c1abd00-c40f-11eb-8ce8-2eb023f3e24f.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40"> |
## How to run tests
**./gradlew runWebTests**

## How to generate allure report
**allure serve build/allure-results**
<img width="683" alt="image" src="https://github.com/user-attachments/assets/3dc5ea49-22ca-4f7e-a4d9-0c0cc120e2d5">



## Allure report
### Common report info 
### Testsuites

![image](https://github.com/user-attachments/assets/89551d0b-6e1a-4632-9069-080a6adb3950)

## :arrow_forward: Failed test information
### In purpose failed test (unsuccessfull login try)
![image](https://github.com/user-attachments/assets/fc56e307-db23-48c5-8feb-f0098845ab22)

### Positive tests (with last screen screenshot)
### 1. All the selected items are present in basket.
<img width="1883" alt="image" src="https://github.com/user-attachments/assets/80d09586-308e-4b2e-8ac2-62a41706dad7">

### 2. Test the total price in GBP is correct i.e., matches the price of individual items based on quantity.
![image](https://github.com/user-attachments/assets/1bc13509-164c-41d2-9a25-e4d1df627ff2)

### 3. Change the delivery type to Standard Shipping and verify the total price.
![image](https://github.com/user-attachments/assets/87171963-64eb-4fde-8606-b014245e6803)

### 4. Fill the details and click on checkout.
![image](https://github.com/user-attachments/assets/2776be5a-6655-4058-87b1-d69cdf3e83fb)
![image](https://github.com/user-attachments/assets/a7ba7f0c-e9d8-4e27-a8ef-0af1502234de)
![image](https://github.com/user-attachments/assets/780ba6ee-9342-4747-928f-c7714ce942a3)

### 5. Login to account
![image](https://github.com/user-attachments/assets/73c48c18-7a1a-45b5-b90e-6da89f917a99)

