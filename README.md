# AMRIT - Identity Service 
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)  ![branch parameter](https://github.com/PSMRI/Identity-API/actions/workflows/sast-and-package.yml/badge.svg)

Identity API is a microservice which is used for the creation and management of beneficaries.

### Primary Features
* Beneficiary Creation
* Beneficiary Search
* Beneficiary Management


## Building From Source
This microservice is built on Java, Spring boot framework and MySQL DB.

### Prerequisites 
* JDK 1.8
* Maven 

$ ./mvn clean install

## Installation
This service has been tested on Wildfly as the application server.

### Prerequisites 
* Wildfly (or any compatible app server)
* Redis
* MySQL Database

## Environment and setup

1. Install dependencies `mvn clean install`
2. You can copy `common_example.properties` to `common_local.properties` and edit the file accordingly. The file is under `src/main/environment` folder.
3. Run the spring server with local configuration `mvn spring-boot:run -DENV_VAR=local`

## Integrations
* RMNCH (Reproductive, Maternal, Newborn, and Child Health)

## Usage
All features have been exposed as REST endpoints. Refer to the SWAGGER API specification for details.

