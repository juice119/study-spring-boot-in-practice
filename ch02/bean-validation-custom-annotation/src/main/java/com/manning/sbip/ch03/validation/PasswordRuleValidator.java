package com.manning.sbip.ch03.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RepeatCharacterRegexRule;
import org.passay.Rule;
import org.passay.RuleResult;

public class PasswordRuleValidator implements ConstraintValidator<Password, String> {

    private static final int MIN_LENGTH_RULES = 8;
    private static final int MAX_LENGTH_RULES = 30;
    private static final int MIN_COMPLEX_RULES = 2;
    private static final int MAX_REPETITIVE_CHARS = 3;
    private static final int MIN_SPECIAL_CASE_CHARS = 1;
    private static final int MIN_UPPER_CASE_CHARS = 1;
    private static final int MIN_LOWER_CASE_CHARS = 1;
    private static final int MIN_DIGIT_CASE_CHARS = 1;

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        List<Rule> passwordRules = new ArrayList<>();
        passwordRules.add(new LengthRule(MIN_LENGTH_RULES, MAX_LENGTH_RULES));
        passwordRules.add(this.characteristicsRule());
        passwordRules.add(new RepeatCharacterRegexRule(MAX_REPETITIVE_CHARS));

        PasswordValidator passwordValidator = new PasswordValidator(passwordRules);
        RuleResult validateResult = passwordValidator.validate(new PasswordData(password));

        return validateResult.isValid();
    }


    private Rule characteristicsRule() {
        return new CharacterCharacteristicsRule(MIN_COMPLEX_RULES,
            new CharacterRule(EnglishCharacterData.Special, MIN_SPECIAL_CASE_CHARS),
            new CharacterRule(EnglishCharacterData.UpperCase, MIN_UPPER_CASE_CHARS),
            new CharacterRule(EnglishCharacterData.LowerCase, MIN_LOWER_CASE_CHARS),
            new CharacterRule(EnglishCharacterData.Digit, MIN_DIGIT_CASE_CHARS));
    }
}
