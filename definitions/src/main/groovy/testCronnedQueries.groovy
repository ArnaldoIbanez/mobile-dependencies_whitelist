import com.melidata.definitions.JsonUploaderValidator

static void main(String[] args) {
    def status = JsonUploaderValidator.validateQueries()

    if(!status)
        System.exit(1)
}