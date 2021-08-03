package com.melidata.definitions.linters

import com.ml.melidata.catalog.TrackDefinition
import com.ml.melidata.catalog.TrackDefinitionProperty

class PropertyNameBlackListLinter extends AbstractLinter {

    List<String> vagueNames
    List<String> reservedNames
    List<String> alreadyTrackeds

    PropertyNameBlackListLinter() {
        this.vagueNames = ["data", "extra_info", "extra_data", "extra", "event_data"]
        this.reservedNames = ["platform", "user", "device", "name", "required", "description"]
        this.alreadyTrackeds = ["user_id", "site_id", "colaborator_id"]

        this.errorMessage = "Property names shouldnt be included at \n" +
                "${vagueNames} => Too vague names \n" +
                "${reservedNames} => Reserved property names \n" +
                "${alreadyTrackeds} => Already tracked information \n"
    }

    PropertyNameBlackListLinter(List<String> vageNames, List<String> reservedNames, List<String> alreadyTrackeds) {
        this.vagueNames = vageNames
        this.reservedNames = reservedNames
        this.alreadyTrackeds = alreadyTrackeds

        this.errorMessage = "Property names shouldnt be included at \n" +
                "${vagueNames} => Too vague names \n" +
                "${reservedNames} => Reserved property names \n" +
                "${alreadyTrackeds} => Already tracked information \n"
    }

    @Override
    boolean validateTrack(TrackDefinition definition) {
        return true
    }

    @Override
    boolean validatePropertySet(List<TrackDefinitionProperty> definition) {
        return definition.every {
            !(it.name in vagueNames) && !(it.name in alreadyTrackeds)  && !(it.name in reservedNames)
        }
    }
}
