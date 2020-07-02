# MELIDATA CATALOG

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

### REFERENCES

1. [**Tracking Definitions**](https://github.com/mercadolibre/melidata-catalog/wiki/Tracking-Style-Guide)

2. [Metrics Definitions](https://github.com/mercadolibre/melidata-catalog/wiki/New-Metric)

3. [Cronned Queries Definitions](https://sites.google.com/mercadolibre.com/melidata/custom-data/bi-integration)

4. [Tracking health check](https://github.com/mercadolibre/melidata-catalog/wiki/Catalog-health-check)

5. [FAQ](https://github.com/mercadolibre/melidata-catalog/wiki/FAQ) 

### CONTACT
<melidata_dev@mercadolibre.com>

We internally rotate in the Melidata team to periodically take PRs at this catalog. In case of a hurry ( just in that case ) you can reach catalog owner of the week by checking [this rotation](https://nasdaq-meli.app.opsgenie.com/settings/schedule/detail/e9e18d88-3536-4572-9351-6ab680d4b1ed)
