# Spring Boot Container On Kubernetes.

## Component version

* Java 11 + JDK
* Maven 3.6
* Spring Boot 2.4
* Docker Engine 20.10
* Local Kubernetes (as variant Minikube 1.23).

## Purpose

* Create Test RESTFul Controller.
* Prepare Dockerfile.
* Prepare Deployment YAML.
* Creating Docker Image and deploy it on Kubernetes environment.

## Result

* Deployed Spring Boot application as container on Kubernetes environment.
* Correct start container.
* Correct stop container.
* Working endpoint in Spring Boot application provided by the component Actuator.

## Comment

### Prepare Docker Image

For Prepare Docker Image need:

* Go to project root catalogue.
* Build project `mvn clean package`.
* Run command `docker build -t springio/sb-service .` for build image with tag `springio/sb-service` by current `Dockerfile`.
* Check the creation of the image by command `docker container ls`.

This works with the `Linux` operating system.

For other system may use IDE Docker plugin.
