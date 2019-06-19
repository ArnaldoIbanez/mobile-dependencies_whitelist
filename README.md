# MELIDATA CATALOG

[![Build Status](http://216.33.196.24/drone/api/badge/github.com/mercadolibre/melidata-catalog/status.svg?branch=master)](http://drone.melicloud.com/github.com/mercadolibre/melidata-catalog)

### CONTENT

[1 - Description](#description)

[2 - Disclaimer](#disclaimer)

[3 - Requirement](#requirement)

[4 - Testing](#testing)

[5 - References](#references)

[6 - Contact](#contact)


### DESCRIPTION

This repository contains all the definitions for the information tracked in *melidata* platform. The catalog serves as a central repository to governate our data, know what are we tracking and how.

### DISCLAIMER

- Always remember to define how your tracking "should be" not "as it is". We want this catalog to represent "the tracking we want" and not "the one we have". The catalog helps us to keep governance on our data and making it more predictable and easy to exploit

- Before making PR. Try to follow other definition examples and make sure your data is not already tracked.

### REQUIREMENT

Download JDK 8 (u212) and set JAVA_HOME variable. In your terminal, run:

```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_212.jdk/Contents/Home
```

If your JAVA_HOME is set to JDK 9+, it might trigger incompatibility problems.

### TESTING

If you want to run the tests, you should execute **```make test```**

If you want to run the tests for a specific catalog, you should execute **```make test CATALOG=${catalogName}```** with the catalogName capitalized

If you want to run all available tests **```make test CATALOG=${All}```** 

### REFERENCES

1. [Melidata Architecture](https://docs.google.com/document/d/1hDP_2iB3lNnKcsbsuQAdvCEentABMEF6sbbV-C6MUTM/edit?usp=sharing)

2. [Catalog Definitions](https://github.com/mercadolibre/melidata-catalog/wiki#catalog-definitions)

3. [Metrics Definitions](https://github.com/mercadolibre/melidata-catalog/wiki#metrics-definitions)

4. [Cronned Queries Definitions](https://github.com/mercadolibre/melidata-all/wiki/Hive-BI-Integration)

5. [Tracking Definitions](https://github.com/mercadolibre/melidata-catalog/wiki/Tracking-Style-Guide)

6. [FAQ](https://github.com/mercadolibre/melidata-catalog/wiki/FAQ) 

### CONTACT

<melidata_dev@mercadolibre.com>
