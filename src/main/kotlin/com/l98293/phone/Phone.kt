package com.l98293.phone

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

/**
 * This annotation allows you to select a region based on the **ISO 3166-1** international standard
 * and validates the phone number format for each specific region.
 *
 * It returns **true** if the phone number is `null` or empty.
 * To prevent null or empty values, it should be used in conjunction with other annotations such as `@NotEmpty` or `@NotBlank`.
 *
 * @since 2.1.2
 * @author L98293
 * @see <a href="https://www.apache.org/licenses/LICENSE-2.0">Apache 2.0</a>
 */
@MustBeDocumented
@Constraint(validatedBy = [PhoneValidator::class])
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Phone(
    val message: String = "Invalid number format..",
    val region: Region,
    val format: Format,
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)