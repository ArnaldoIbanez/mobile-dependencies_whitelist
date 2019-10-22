import com.melidata.definitions.validators.BIIntegrationValidator

static void main(String[] args) {
    def status = BIIntegrationValidator.validateQueries()

    if(!status)
        System.exit(1)
}