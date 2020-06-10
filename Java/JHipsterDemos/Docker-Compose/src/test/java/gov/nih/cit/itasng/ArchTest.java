package gov.nih.cit.itasng;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("gov.nih.cit.itasng");

        noClasses()
            .that()
                .resideInAnyPackage("gov.nih.cit.itasng.service..")
            .or()
                .resideInAnyPackage("gov.nih.cit.itasng.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..gov.nih.cit.itasng.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
