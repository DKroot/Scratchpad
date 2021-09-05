//file:noinspection GrUnresolvedAccess // designed to work inside Gradle only
import groovy.transform.CompileStatic

// Using implicitly imported `CompilerCustomizationBuilder.withConfig()`
withConfig(configuration) {
  ast(CompileStatic)
//  ast(TypeChecked)
}