package com.melidata.catalog.test

import com.ml.melidata.catalog.CategoryValidator
import com.ml.melidata.catalog.RegexValidator
import com.ml.melidata.catalog.TrackValidationResponse
import com.ml.melidata.catalog.TypeValidator
import com.ml.melidata.catalog.ValuesValidator
import org.junit.Test
import static org.junit.Assert.assertEquals

/**
 * Created by apetalas on 13/11/14.
 */
class ValidatorTest {



    @Test void shouldFailValuesValidatorWithInvalidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new ValuesValidator(["mobile", "web"])

        validator.validate(response, "webs")

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.menssages.size(), 1)
        //println result.menssages
    }

    @Test void shouldNotFailValuesValidatorWithValidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new ValuesValidator(["mobile", "web"])

        validator.validate(response, "web")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.menssages.size(), 0)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithRegexValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new RegexValidator(/mob[iI]le/)

        validator.validate(response, "mobIle")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.menssages.size(), 0)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithTypeValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new TypeValidator(Integer)

        validator.validate(response, 1)

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.menssages.size(), 0)
        //println result.menssages
    }

    @Test void shouldValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new CategoryValidator()

        validator.validate(response, "MLA1334")

        // Assert
        //println response.menssages
        assertEquals(response.status, true)
        assertEquals(response.menssages.size(), 0)

    }

    @Test void shouldFailValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = new CategoryValidator()

        validator.validate(response, "MLAA1334")

        // Assert
        //println response.menssages
        assertEquals(response.status, false)
        assertEquals(response.menssages.size(), 1)

    }


}
