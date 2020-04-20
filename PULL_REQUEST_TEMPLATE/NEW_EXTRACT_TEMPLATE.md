[//]: # (BI Integration PR template, otherwise delete it!)

## Need for this
[//]: # (Explain why do you need to do this Tableau's extract) 

## Expiration date (YYYY/MM/DD)
[//]: # (If this Tableau's extract is a temporary need, set the expiration date. The extract will be updated until the established date)  	
	

## Self-validation  	
[//]: # (Does your track check the following?)  	

- [ ] JSON File: I set the partition key column	
- [ ] JSON File: The orden columns is right (Columns are mapped by order rather than column name) 	
- [ ] SQL File: The partition column is the last column
- [ ] SQL File: The query does not include WITH statements
- [ ] SQL File: The query does not include -- ( comments )
- [ ] SQL File: I optimized the performance of query (See [Tracks Optimized](https://sites.google.com/mercadolibre.com/melidata/querying/tables#h.p_xDv8FixIvsT3))

## For more info 	
Further information can be found in:
- [BI Integration Guide](https://sites.google.com/mercadolibre.com/melidata/custom-data/bi-integration?authuser=0) 
- [Tracks Optimized](https://sites.google.com/mercadolibre.com/melidata/querying/tables#h.p_xDv8FixIvsT3) 	
- [Golden Rules](https://sites.google.com/mercadolibre.com/melidata/querying#h.p_AOcqlkENCbKD)
