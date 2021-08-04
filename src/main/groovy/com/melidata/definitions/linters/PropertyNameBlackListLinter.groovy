package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class PropertyNameBlackListLinter extends AbstractLinter {

    List<String> vagueNames
    List<String> reservedNames
    List<String> alreadyTrackeds

    PropertyNameBlackListLinter(List<String> vageNames, List<String> reservedNames, List<String> alreadyTrackeds) {
        this.vagueNames = vageNames
        this.reservedNames = reservedNames
        this.alreadyTrackeds = alreadyTrackeds

        this.errorMessage = "Property names shouldnt be included at \n" +
                "${this.vagueNames} => Too vague names \n" +
                "${this.reservedNames} => Reserved property names \n" +
                "${this.alreadyTrackeds} => Already tracked information"
    }

    @Override
    boolean validateTrack(TrackDefinition definition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> definition) {
        return definition.every {
            !(it.name in this.vagueNames) && !(it.name in this.reservedNames)  && !(it.name in this.alreadyTrackeds)
        }
    }
}
