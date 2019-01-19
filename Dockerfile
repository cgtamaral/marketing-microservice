FROM openjdk:8
ADD target/MarketingMicroService.jar MarketingMicroService.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar", "MarketingMicroService.jar"]
