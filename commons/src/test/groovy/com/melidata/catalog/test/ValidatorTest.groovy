package com.melidata.catalog.test

import com.ml.melidata.catalog.CategoryValidator
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.RegexValidator
import com.ml.melidata.catalog.TypeValidator
import com.ml.melidata.catalog.Validator
import com.ml.melidata.catalog.ValuesValidator
import com.ml.melidata.catalog.tree.TrackValidationResponse
import org.junit.Test

import java.security.Timestamp

import static org.junit.Assert.assertEquals

/**
 * Created by apetalas on 13/11/14.
 */
class ValidatorTest {



    @Test void shouldFailValuesValidatorWithInvalidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateValuesValidator(["mobile", "web"])

        validator.validate(response,"" ,"webs")

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)
        //println result.messages
    }

    @Test void shouldNotFailValuesValidatorWithValidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateValuesValidator(["mobile", "web"])

        validator.validate(response, "","web")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithRegexValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateRegexValidator(/mob[iI]le/)

        validator.validate(response,"", "mobIle")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithTypeValidatorNumeric() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateTypeValidator(PropertyType.Numeric)

        validator.validate(response,"" ,1)

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithTypeValidatorString() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateTypeValidator(PropertyType.String)

        validator.validate(response, "", "1")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithTypeValidatorTimeStamp() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateTypeValidator(PropertyType.Timestamp)


        validator.validate(response, "", new java.sql.Timestamp(123123123))

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldFailValidateTrackWithTypeValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateTypeValidator(PropertyType.Numeric)


        validator.validate(response, "propertyname", "a")

        // Assert
        assertEquals(response.status, false)
        //println result.messages
    }

    @Test void shouldValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateCategoryValidator()

        validator.validate(response, "propertyname", "MLA1334")

        // Assert
        //println response.messages
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)

    }

    @Test void shouldFailValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = Validator.CreateCategoryValidator()

        validator.validate(response,"propertyname", "MLAA1334")

        // Assert
        //println response.messages
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)

    }


}
