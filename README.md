# Sweet Shop web site auto-testing

##### Done for task `QA UI Automation Test`

![image](https://sweetshop.netlify.app/favicon.png)

## TABLE OF CONTENT

## Technology stack

| GitHub / Github Action | IDEA | Java | Junit5 | Gradle | Selenide | Allure | LambdaTest |                                                                                                      
|:----------------------:|:----:|:----:|:------:|:------:|:--------:|:-------:|:---------:|
|<div align="center"> <img src="https://cdn-icons-png.flaticon.com/512/25/25231.png" width="40" height="40"></div> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562458-1c1abd00-c40f-11eb-8ce8-2eb023f3e24f.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40"> | <img src="https://bitrise-steplib-collection.s3.amazonaws.com/steps/lambdatest-upload/assets/icon.svg" width="40" height="40"> |

## How to:
### 1. Run tests locally

**./gradlew runWebTests**
<p align="left"> <img src="https://github.com/user-attachments/assets/3f435505-c3d0-4111-9367-363898184ed2" width="200" height="100"></p>
###
### 2. Пenerate local allure report
**allure serve build/allure-results**
###
<p align="left"> <img src="https://github.com/user-attachments/assets/3dc5ea49-22ca-4f7e-a4d9-0c0cc120e2d5" width="200" height="100"></p>
###

### 2. Github Actions pipeline:
#### CI-CD pipeline placed in .github/workflows folder as gradle-ci-cd.yml file. 
##### It contain steps that should be done after pushes for every of tracked branches (qa, preprod, prod) on defined Env.
##### Defined different testsuite content, job sequence, and environments.
##### After test run completion testrun result is archived and published. Also generated testrun Allure report
###### (Known GA limitation that only last Allure report is accessible).  
##### Allure report and test run artifact archive may be found in `pages-build-deployment` Actions
#### Pipeline screenshots:
### QA pipeline
<p align="left">
    <img src="https://github.com/user-attachments/assets/35a39253-7070-400d-b6e0-515d940fa0c9" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/7fa5d8fc-e69a-4f73-94a0-9bb5b8e724a3" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/3712c8a1-b93a-4eae-abe3-8bd07bfacd26" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/1a179892-5a40-4e8d-941c-1f2bd122e571" width="200" height="100">
</p>
<p align="left">
    <img src="https://github.com/user-attachments/assets/7a5d236b-1aab-4509-948c-f1d722e18640" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/49d53fd7-3e3b-45b3-9ba1-9c6a2f86e86f" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/3e7cd927-a822-4002-83ac-6b38feabc2e4" width="200" height="100">
    <img src="https://github.com/user-attachments/assets/18ee2aa2-d07c-423e-a2c8-98f0c54a7a2c" width="200" height="100">    
</p>

### Preprod pipeline 
<p align="left">
    <img src="https://github.com/user-attachments/assets/bc42ffa0-1e88-48d4-9f00-9966ee6ff573" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/15750577-7b05-4465-bf8e-0bcd7d1479ea" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/5ec0d7bd-6780-4ed6-8a50-fd919e4e9b20" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/12bad319-b8ae-4d1e-85d7-f44ed271931a" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/d46a0826-2d52-4100-9ed2-d089d0763b51" width="160" height="90">
</p>

### Prod pipeline 
<p align="left">
    <img src="https://github.com/user-attachments/assets/b7ce09de-0e43-47e0-891e-59f23876c3c3" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/cace5811-9cbb-4dff-818d-75e192c48078" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/f5d297c9-4d99-4d0a-97d1-eb53c064d87d" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/fd7a1db3-5616-4a79-bd1a-2f755dcee260" width="160" height="90">
    <img src="https://github.com/user-attachments/assets/3e1488b6-34c3-46da-a456-85047e5d3f5f" width="160" height="90">  
</p>
###


## Allure report

### Common report info


### Testsuites

![image](https://github.com/user-attachments/assets/89551d0b-6e1a-4632-9069-080a6adb3950)

###
|  Failed test information |  Positive tests | Java | Junit5 | Gradle | Selenide | Allure | LambdaTest |                                                                                                      
|:----------------------:|:----:|:----:|:------:|:------:|:--------:|:-------:|:---------:|
|<div align="center"> <img src="https://cdn-icons-png.flaticon.com/512/25/25231.png" width="40" height="40"></div> | <img src="https://user-images.githubusercontent.com/38681283/120561799-e88b6300-c40d-11eb-91ba-d4103ef6d4b5.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120561837-f7721580-c40d-11eb-8590-7b3b0b5eb50d.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562013-43bd5580-c40e-11eb-926f-1b8d3dc9e965.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562398-fbeafe00-c40e-11eb-9fe7-3a641bf7115c.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562458-1c1abd00-c40f-11eb-8ce8-2eb023f3e24f.png" width="40" height="40"> | <img src="https://user-images.githubusercontent.com/38681283/120562749-b5e26a00-c40f-11eb-91d9-641e254428c9.png" width="40" height="40"> | <img src="https://bitrise-steplib-collection.s3.amazonaws.com/steps/lambdatest-upload/assets/icon.svg" width="40" height="40"> |


## :arrow_forward: Failed test information

### In purpose failed test (unsuccessfull login try)

![image](https://github.com/user-attachments/assets/fc56e307-db23-48c5-8feb-f0098845ab22)

### Positive tests (with last screen screenshot)
|  1. All the selected items are present in basket |  2. Test the total price in GBP is correct the price of individual items based on quantity match | 3. Change the delivery type to Standard Shipping and verify the total price |  
|:----------------------:|:---------:|:------------:|
|<div align="center"> <img src="https://github.com/user-attachments/assets/80d09586-308e-4b2e-8ac2-62a41706dad7" width="200" height="100"></div> | <img src="https://github.com/user-attachments/assets/1bc13509-164c-41d2-9a25-e4d1df627ff2" width="200" height="100"> | <img src="https://github.com/user-attachments/assets/87171963-64eb-4fde-8606-b014245e6803" width="200" height="100"> |


|  4. Fill the details and click on checkout. |  5. Login to account |  
|:----------------------:|:---------:|
| <img src="https://github.com/user-attachments/assets/2776be5a-6655-4058-87b1-d69cdf3e83fb" width="200" height="100"></div>  <img src="https://github.com/user-attachments/assets/a7ba7f0c-e9d8-4e27-a8ef-0af1502234de" width="200" height="100"> <img src="https://github.com/user-attachments/assets/780ba6ee-9342-4747-928f-c7714ce942a3" width="200" height="100">  | <img src="https://github.com/user-attachments/assets/73c48c18-7a1a-45b5-b90e-6da89f917a99" width="200" height="100"> |

### 4. Fill the details and click on checkout.

![image](https://github.com/user-attachments/assets/2776be5a-6655-4058-87b1-d69cdf3e83fb)
![image](https://github.com/user-attachments/assets/a7ba7f0c-e9d8-4e27-a8ef-0af1502234de)
![image](https://github.com/user-attachments/assets/780ba6ee-9342-4747-928f-c7714ce942a3)

###

### 5. Login to account

![image](https://github.com/user-attachments/assets/73c48c18-7a1a-45b5-b90e-6da89f917a99)

###
