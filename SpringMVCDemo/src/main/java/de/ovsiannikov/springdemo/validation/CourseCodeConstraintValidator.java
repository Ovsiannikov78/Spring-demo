package de.ovsiannikov.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefix;

    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result = false;
        if (theCode != null) {
            for (String tempPrefix : coursePrefix) {

                // loop thru course prefixes
                // check to see if code matches any of the course

                result = theCode.startsWith(tempPrefix);

                // if we found a match then break out of the loop
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}
