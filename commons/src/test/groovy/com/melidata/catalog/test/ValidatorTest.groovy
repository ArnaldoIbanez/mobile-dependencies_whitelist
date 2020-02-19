package com.melidata.catalog.test

import com.ml.melidata.catalog.TrackDefinitionProperty
import com.ml.melidata.catalog.PropertyType
import com.ml.melidata.catalog.MapProperty
import com.ml.melidata.catalog.ArrayListProperty
import com.ml.melidata.catalog.ValidatorFactory
import com.ml.melidata.catalog.tree.TrackValidationResponse
import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue

/**
 * Created by apetalas on 13/11/14.
 */
class ValidatorTest {



    @Test void shouldFailValuesValidatorWithInvalidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateValuesValidator(["mobile", "web"])

        validator.validate(response,"" ,"webs")

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)
        //println result.messages
    }

    @Test void shouldNotFailValuesValidatorWithValidValue() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateValuesValidator(["mobile", "web"])

        validator.validate(response, "","web")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithRegexValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateRegexValidator(/mob[iI]le/)

        validator.validate(response,"", "mobIle")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithTypeValidatorNumeric() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(PropertyType.Numeric)

        validator.validate(response,"" ,1)

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldValidateTrackWithTypeValidatorString() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(PropertyType.String)

        validator.validate(response, "", "1")

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
        //println result.messages
    }

    @Test void shouldFailValidateTrackWithTypeValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(PropertyType.Numeric)


        validator.validate(response, "propertyname", "a")

        // Assert
        assertEquals(response.status, false)
        //println result.messages
    }

    @Test void shouldValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateCategoryValidator()

        validator.validate(response, "propertyname", "MLA1334")

        // Assert
        //println response.messages
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)

    }

    @Test void shouldFailValidateTrackWithCategoryValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateCategoryValidator()

        validator.validate(response,"propertyname", "MLAA1334")

        // Assert
        //println response.messages
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)

    }

    @Test void shouldValidateTrackWithNestedValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator( new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.String),
                propertyname2: new TrackDefinitionProperty(required: true, type: PropertyType.Numeric),
                propertyname3: new TrackDefinitionProperty(required: true, type: PropertyType.ArrayList(PropertyType.Numeric))
        ]))

        validator.validate(response,"propertyname", [
                propertyname: "value",
                propertyname2: 289,
                propertyname3: [1, 2, 3]
        ])

        // Assert
        //println response.messages
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)

    }

    @Test void shouldFailValidationTrackWithNestedValidatorRequiredPropertyMissing() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.String),
                propertyname2: new TrackDefinitionProperty(required: true, type: PropertyType.Numeric)
        ]))

        validator.validate(response,"propertyname", [
                propertyname: "value"
        ])

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)
    }

    @Test void shouldValidateTrackWithNestedValidatorNonRequiredPropertyMissing() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.String),
                propertyname2: new TrackDefinitionProperty(required: false, type: PropertyType.Numeric)
        ]))

        validator.validate(response,"propertyname", [
                propertyname: "value"
        ])

        // Assert
        assertEquals(response.status, true)
    }

    @Test void shouldFailValidationTrackWithNestedValidatorAgainstSomethingThatsNotAMap() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.String),
        ]))

        validator.validate(response,"propertyname", 89321)

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)
    }

    @Test void shouldFailValidationTrackWithNestedValidatorWithNonDeclaredField() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.String),
        ]))

        validator.validate(response,"propertyname", [
                propertyname: "value",
                propertyname2: "value"
        ])

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)
    }

    @Test void shouldFailValidationTrackWithNestedValidatorWithIteratedMapError() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new MapProperty([
                propertyname: new TrackDefinitionProperty(required: true, type: PropertyType.Map([
                        propertyname1: new TrackDefinitionProperty(required: true, type: PropertyType.String),
                        propertyname2: new TrackDefinitionProperty(required: false, type: PropertyType.String)
                ])),
        ]))

        validator.validate(response,"propertyname", [
                propertyname: [
                        propertyname1: 3
                ]
        ])

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)

        def message = response.messages.get(0)
        assertTrue(message.contains("propertyname") && message.contains("propertyname1") && !message.contains("propertyname2") && message.contains("Integer"))
    }

    @Test void shouldValidateTrackWithArrayListValidator() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new ArrayListProperty(PropertyType.String))

        validator.validate(response,"propertyname", ["Hello"])

        // Assert
        assertEquals(response.status, true)
        assertEquals(response.messages.size(), 0)
    }

    @Test void shouldFailValidationTrackWithArrayListValidatorArraySizeTimes() {

        // Arrange
        def testArray = [0,2,3,4,5]
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new ArrayListProperty(PropertyType.String))

        validator.validate(response,"propertyname", testArray)

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), testArray.size())
    }


    @Test void shouldFailValidationTrackWithArrayListValidatorWithAnyPositionWrongType() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new ArrayListProperty(PropertyType.String))

        validator.validate(response,"propertyname", ["hola", "chau", "todo", 0, "bien"])

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)

        assertTrue(response.messages.get(0).contains("Integer"))
    }

    @Test void shouldFailOnNestedMapOnArray() {

        // Arrange
        def response = new TrackValidationResponse()
        def validator = ValidatorFactory.CreateTypeValidator(new ArrayListProperty(new MapProperty([
                items: new TrackDefinitionProperty(required: true, type: PropertyType.Map([
                        credits: new TrackDefinitionProperty(required: true, type: PropertyType.ArrayList(PropertyType.String)),
                        propertyname2: new TrackDefinitionProperty(required: false, type: PropertyType.String)
                ])),
        ])))

        validator.validate(response,"propertyname", [
                [
                        items: [
                                credits: ["1", 2, "3"],
                                propertyname2: "hola"
                        ]
                ],
                [
                        items: [
                                credits: ["1", "2", "3"],
                                propertyname2: "hola"
                        ]
                ]
        ])

        // Assert
        assertEquals(response.status, false)
        assertEquals(response.messages.size(), 1)

        def message = response.messages.get(0)
        assertTrue(message.contains("items") && message.contains("credits") && !message.contains("list") && message.contains("Integer"))
    }
}
