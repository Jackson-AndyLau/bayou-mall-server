package com.huazai.bayou.common.annotation.valid;

import com.huazai.bayou.common.annotation.impl.DataStatusConstraintValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * ClassName: DataStatusValid
 * Package: com.huazai.bayou.common.annotation.valid
 * Description:
 *
 * @Author HuaZai
 * @Create 2025-01-16 11:01
 * @Version 1.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
/*指定校验器*/
@Constraint(validatedBy = {DataStatusConstraintValidator.class})
public @interface DataStatusValid {

    String message() default "{com.huazai.bayou.common.annotation.valid.DataStatusValid.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int[] values() default {};

}
