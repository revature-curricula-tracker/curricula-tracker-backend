package com.revature.modelTests;



import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.model.Curriculum;

@SpringBootTest(classes=Curriculum.class)
class CurriculumTests {
	// One big test
    @Test
    void testBean() {
        assertThat(Curriculum.class, allOf(
                hasValidBeanConstructor(),
                hasValidGettersAndSetters(),
                hasValidBeanHashCode(),
                hasValidBeanEquals(),
                hasValidBeanToString()
        ));
    }

    // Individual, well named tests

    @Test
    void shouldHaveANoArgsConstructor() {
        assertThat(Curriculum.class, hasValidBeanConstructor());
    }

    @Test
    void gettersAndSettersShouldWorkForEachProperty() {
        assertThat(Curriculum.class, hasValidGettersAndSetters());
    }

    @Test
    void allPropertiesShouldInfluenceHashCode() {
        assertThat(Curriculum.class, hasValidBeanHashCode());
    }

    @Test
    void allPropertiesShouldBeComparedDuringEquals() {
        assertThat(Curriculum.class, hasValidBeanEquals());
    }

    @Test
    void allPropertiesShouldBeRepresentedInToStringOutput() {
        assertThat(Curriculum.class, hasValidBeanToString());
    }
}
