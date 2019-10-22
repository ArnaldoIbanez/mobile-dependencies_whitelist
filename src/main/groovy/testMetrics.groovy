import com.melidata.definitions.validators.BIIntegrationValidator

static void main(String[] args) {
    def status = BIIntegrationValidator.validateMetrics()

    if(!status)
        System.exit(1)
}