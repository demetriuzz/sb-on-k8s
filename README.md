# Spring Boot Container On Kubernetes.

Prepare Spring Boot application for Kubernetes Environment.

Target platform - Linux Debian (_on this variant used version 11.1_)

## Component version

* Java 11 + JDK
* Maven 3.6
* Spring Boot 2.4
* Docker Engine 20.10
* Local Kubernetes 1.22 (as variant minikube + kubectl).

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
* Run command `docker build -t springio/gs-spring-boot-docker .` for build image with current `Dockerfile`.
* Check the creation of the image by command `docker image ls`.

### Prepare Deployment

Use this command for prepare Deployment template, step by step:

```
$ kubectl create deployment t1 --image springio/gs-spring-boot-docker --dry-run=client -o yaml > deployment.yaml
$ echo --- >> deployment.yaml
$ kubectl create service loadbalancer t1 --tcp 8200:8100 --dry-run=client -o yaml >> deployment.yaml
```

After preparation `Deployment` and `Service` you can run command
```
$ kubectl apply -f deployment.yaml
```

## Important

When the Spring Boot application is running, it listens to the port.

But at what IP address? LocalHost on `127.0.0.1`?

For application in container is __wrong__: the connection will not be possible!

In `application.properties` need set correct `server.port` and `server.address`.

`server.address` mast be as `0.0.0.0` for bind all IP on container.


## Links

Docker build <https://docs.docker.com/engine/reference/commandline/build>

Dockerfile, reference <https://docs.docker.com/engine/reference/builder>

Dockerfile, best practices <https://docs.docker.com/develop/develop-images/dockerfile_best-practices>

About Docker <https://www.ibm.com/ru-ru/cloud/learn/docker>
