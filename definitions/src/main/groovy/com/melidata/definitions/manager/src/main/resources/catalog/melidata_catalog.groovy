
            import com.ml.melidata.catalog.PropertyType
            import static com.ml.melidata.catalog.parsers.dsl.CatalogDsl.catalog
            import com.ml.melidata.TrackType

            catalog {
                business = [ "prueba_business"]

                defaultBusiness = "prueba_business"

                platforms = ["/prueba"]

                tracks {
                    "/path1"(platform: "/prueba") {
                        field1(required: false)
                    }
                }

            }
        
