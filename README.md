
# Melidata Catalog

This repository contains all the definitions for the information tracked in *melidata* platform. The catalog serves as a central repository to governate our data, know what are we tracking and how.

[![Build Status](http://216.33.196.24/drone/api/badge/github.com/mercadolibre/melidata-catalog/status.svg?branch=master)](http://drone.melicloud.com/github.com/mercadolibre/melidata-catalog)

## Catalog Definitions

[Documentation](https://github.com/mercadolibre/melidata-catalog/wiki#catalog-definitions)

Please check [tracks definitions guidelines](https://github.com/mercadolibre/melidata-catalog/wiki/Tracking-Style-Guide) before making PR. Try to follow other definition examples and make sure your data is not already tracked.

And always remember to define how your tracking "should be" not "as it is". We want this catalog to represent "the tracking we want" and not "the one we have". The catalog helps us to keep governance on our data and making it more predictable and easy to exploit

## Metrics Definitions

[Documentation](https://github.com/mercadolibre/melidata-catalog/wiki#metrics-definitions)

## Cronned Queries Definitions

[Documentation](https://github.com/mercadolibre/melidata-all/wiki/Hive-BI-Integration)

## Testing the catalog

If you want to run the tests, you should execute **```make test```**

If you want to run the tests for a specific catalog, you should execute **```make test CATALOG=${catalogName}```** with the catalogName capitalized

If you want to run all available tests **```make test CATALOG=${All}```**
